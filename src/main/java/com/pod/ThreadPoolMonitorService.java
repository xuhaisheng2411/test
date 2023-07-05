package com.pod;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

//import org.apache.log4j.Logger;


@Component

public class ThreadPoolMonitorService implements IThreadPoolMonitorService {
    private static Logger log = LoggerFactory.getLogger(ThreadPoolMonitorService.class);
	   // private static Logger log = Logger.getLogger(ThreadPoolMonitorService.class);
	  	ThreadPoolTaskExecutor executor;
	    private long monitoringPeriod = 20;//打印间隔
	    private String poolName;
	 


		public void run() {
	        try {
	            while (true){
	                monitorThreadPool();
	                Thread.sleep(monitoringPeriod*1000);
	            }
	        } catch (Exception e) {
	            log.error(e.getMessage());
	        }
	    }
	 
	    public void monitorThreadPool() {
	        StringBuffer strBuff = new StringBuffer();
	        strBuff.append("PoolName : 【").append(this.getPoolName());
	        strBuff.append("】 ");
	        strBuff.append(" - ThreadNamePrefix : ").append(executor.getThreadNamePrefix());
	        strBuff.append(" - CurrentPoolSize : ").append(executor.getPoolSize());
	        strBuff.append(" - CorePoolSize : ").append(executor.getCorePoolSize());
	        strBuff.append(" - MaximumPoolSize : ").append(executor.getMaxPoolSize());
	        strBuff.append(" - ActiveTaskCount : ").append(executor.getActiveCount());
	        strBuff.append(" - CompletedTaskCount : ").append(executor.getThreadPoolExecutor().getCompletedTaskCount());
	        strBuff.append(" - TotalTaskCount : ").append(executor.getThreadPoolExecutor().getTaskCount());
	        //strBuff.append(" - isTerminated : ").append(executor.());
	 
	        log.info(strBuff.toString());
	    }
	 
	    public ThreadPoolTaskExecutor getExecutor() {
	        return executor;
	    }
	 
	    public void setExecutor(ThreadPoolTaskExecutor executor) {
	        this.executor = executor;
	    }  
	 
	    public long getMonitoringPeriod() {
	        return monitoringPeriod;
	    }
	 
	    public void setMonitoringPeriod(long monitoringPeriod) {
	        this.monitoringPeriod = monitoringPeriod;
	    }
	    public String getPoolName() {
			return poolName;
		}

		public void setPoolName(String poolName) {
			this.poolName = poolName;
		}	    
}
