package com.pod;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 
 * description:核心Pod管理
 * author:yanghongjing
 * date:20191108
 * 
 */

@Component
@Configuration

public class PodService {
	
    /**
     * 日志
     */
    private static Logger log = LoggerFactory.getLogger(PodService.class);
    
    @Value("${apaasConfig.acs.podProfile}")
    public String podProfile;    
    /**
     * 全局Pod对象
     */ 
    public static JSONArray globalPodArray = null;
    /**
     * 全局Service对象
     */ 
    public static JSONObject globalService = null;
    /**
     * 并发操作锁
     */ 
    private static ReentrantLock reentrantLock = new ReentrantLock();
    /**
     * 全局Pod线程池
     */
    public static ConcurrentHashMap<String, ThreadPoolTaskExecutor> globalPodPoolMap
	= new ConcurrentHashMap<String,ThreadPoolTaskExecutor>();    
    /**
     * 全局Pod现场监视池
     */
    public static ConcurrentHashMap<String, Thread> globalPodPoolMonitorMap
	= new ConcurrentHashMap<String,Thread>();  

    /**
     * 核心Pod初始化
     */  

	public void init(){
		//===【1】===启动核心pod
		//读取配置文件，将来这个应该放在ZK里面
		log.info("acs init thread use podProfile:【"+podProfile+"】");
		ClassUtil cu = new ClassUtil();
		String podContent = cu.getResourceFileContent(podProfile,3096);	
		//String podContent = FileUtil.getResourceFileContent(podName,3096);
		log.info(podContent);
		//将信息转换成JSON对象数组
		if (null!=podContent) {
			globalPodArray = JSONArray.parseArray(podContent);
		}
    	
		if (null != globalPodArray && !globalPodArray.isEmpty()) {
			log.info("获取到的pod数量="+globalPodArray.size()+",下面将进行初始化");
			globalPodArray.forEach(aPod ->{
				if (aPod instanceof JSONObject) {
			    	this.getThreadPool(((JSONObject) aPod).getString("name"),
			    			((JSONObject) aPod).getJSONObject("poolConfig").getIntValue("corePoolSize"),
			    			((JSONObject) aPod).getJSONObject("poolConfig").getIntValue("maxPoolSize"),
			    			((JSONObject) aPod).getJSONObject("poolConfig").getIntValue("keepAliveSeconds"),
			    			((JSONObject) aPod).getJSONObject("poolConfig").getIntValue("queueCapacity"),
			    			((JSONObject) aPod).getJSONObject("poolConfig").getBoolean("allowCoreThreadTimeOut"),
			    			(JSONObject) aPod);
				}
			});
		}
		
		/*
		//===【2】===启动service
		String serviceContent = cu.getResourceFileContent("service.json",3096);	
		
		log.info(serviceContent);
		//将信息转换成JSON对象
		if (null!=serviceContent) {
			globalService = (JSONObject) JSONObject.parse(serviceContent);
		}*/
	}

    public ThreadPoolTaskExecutor getThreadPool(String poolName,
    			int corePoolSize,
    			int maxPoolSize,
    			int keepAliveSeconds,
    			int queueCapacity,
    			boolean allowCoreThreadTimeOut,JSONObject pod) {
    	ThreadPoolTaskExecutor threadPoolTaskExecutor = null;
        try {
        	reentrantLock.lock();
            // 根据名称获取缓存线程池，没有则新建并缓存
        	threadPoolTaskExecutor = globalPodPoolMap.get(poolName);
            if (null == threadPoolTaskExecutor) {
            	System.out.println("poolName："+ poolName +" dose not exists,try to create it...");
                //创建线程池
            	ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat(poolName + "-%d").build();
                threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
                int core = Runtime.getRuntime().availableProcessors();
                threadPoolTaskExecutor.setCorePoolSize(corePoolSize);//设置核心线程数
                threadPoolTaskExecutor.setMaxPoolSize(maxPoolSize);//设置最大线程数
                threadPoolTaskExecutor.setKeepAliveSeconds(keepAliveSeconds);//除核心线程外的线程存活时间                
                threadPoolTaskExecutor.setQueueCapacity(queueCapacity);//如果传入值大于0，底层队列使用的是LinkedBlockingQueue,否则默认使用SynchronousQueue
                threadPoolTaskExecutor.setThreadNamePrefix("poolName:【"+poolName+"】,thread-execute");//线程名称前缀
                threadPoolTaskExecutor.setRejectedExecutionHandler(new TestRejectedExecutionHandler(poolName));//设置拒绝策略              
                threadPoolTaskExecutor.setAllowCoreThreadTimeOut(allowCoreThreadTimeOut);
                globalPodPoolMap.put(poolName, threadPoolTaskExecutor);
                //创建检查池监控
                ThreadPoolMonitorService threadPoolMonitorService = new ThreadPoolMonitorService();
                threadPoolMonitorService.setExecutor(threadPoolTaskExecutor);
                threadPoolMonitorService.setPoolName(poolName);
                Thread monitor = new Thread(threadPoolMonitorService);
                globalPodPoolMonitorMap.put(poolName, monitor);
            	System.out.println("poolName："+ poolName +",create monitor thread");
            	threadPoolTaskExecutor.initialize();
            }else {
            	System.out.println("poolName："+ poolName +" hit ,return");

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
        return threadPoolTaskExecutor;    	
    }
  
    public ThreadPoolTaskExecutor getThreadPool(String poolName) {
    	return globalPodPoolMap.get(poolName);
    }


  
    public Thread getMonitorThread(String poolName) {
    	Thread monitorThread = null;
    	monitorThread = globalPodPoolMonitorMap.get(poolName);
    	return monitorThread;
    }
    
    
}

