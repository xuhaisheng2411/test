package com.pod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;


@Component

public class TestRejectedExecutionHandler implements RejectedExecutionHandler {
    private static Logger log = LoggerFactory.getLogger(TestRejectedExecutionHandler.class);
    private String poolName;
    
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor executor) {
        log.info("poolName:"+poolName+","+runnable.toString() + " : has been rejected");
    }
    
    
    public TestRejectedExecutionHandler(String poolName){
    	this.poolName = poolName;
    }
    
    public TestRejectedExecutionHandler(){
    }   


}
