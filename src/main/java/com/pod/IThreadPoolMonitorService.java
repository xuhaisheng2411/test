package com.pod;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public interface IThreadPoolMonitorService extends Runnable {

	   void monitorThreadPool();

	   ThreadPoolTaskExecutor getExecutor();

	    void setExecutor(ThreadPoolTaskExecutor executor);

	    long getMonitoringPeriod();

	    void setMonitoringPeriod(long monitoringPeriod);
	    
	    String getPoolName();
	    
	    void setPoolName(String poolName);
}
