package com.redis;

import com.apaas.common.util.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

public class testRedisConcurrentLPush {
    @Autowired
    private RedisService redisService;
//生产者代码 http://127.0.0.1:8098/democratic/testRedisConcurrentLPush?count=20
    @GetMapping("/testRedisConcurrentLPush")
    public @ResponseBody
    String testRedisConcurrentLPush(HttpServletRequest request, Integer count) {
        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    redisService.lSet("test_msg_list_8a8781fe70f6f5cf0170f6f5cf970000", "key_msg");
                    redisService.incr("test_msg_list_count", 1);
                }
            }).start();
            try {
                Thread.sleep(233);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "成功";
    }

}
