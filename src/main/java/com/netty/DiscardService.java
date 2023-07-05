package com.netty;


import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @Author: Administrator
 * @Desctription: TODO
 * @Date: Created in 2022/5/17 0017 18:34
 * @Version: 1.0
 */
@Service
public class DiscardService {
    private static final Logger log = LoggerFactory.getLogger(DiscardService.class);
    public void discard (String message) {
        log.info("丢弃消息:{}", message);
    }
}
