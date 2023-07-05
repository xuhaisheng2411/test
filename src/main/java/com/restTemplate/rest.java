package com.restTemplate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import java.util.concurrent.ExecutionException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= rest.class)
public class rest {


    @Test
    public void contextLoads() throws InterruptedException, ExecutionException {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://jsonplaceholder.typicode.com/posts/1";
        String str = restTemplate.getForObject(url, String.class);
        System.out.println(str);

        String typeName="";
        String key="";
        Body<Boolean, String> body = restTemplate.getForObject(
                "http://144.131.254.121:9203/manager/insideCache/{typeName}/{key}?method=resetTypeAndKey", Body.class, typeName, key);
        System.out.println(body.getResult());

    }
}
