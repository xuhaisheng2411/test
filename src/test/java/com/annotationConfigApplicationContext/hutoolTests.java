package com.annotationConfigApplicationContext;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.HashMap;

@SpringBootTest
class hutoolTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void huToolPost() {
        System.out.println("--------------------------------post请求-----------------------------------");
        HashMap<String, String> paramMaps = new HashMap<>(4);
        paramMaps.put("pid", "463669875660294144");
        paramMaps.put("mobile", "123456.");
        paramMaps.put("name", "123456.");
        paramMaps.put("message", "");
        HttpResponse response = HttpRequest.post("http://192.168.99.202:8202/thySystem/pg-biz-sae/app/opinion/add")
                .header("Content-Type", "application/json")
                .header("token", "710515329923024896")
                .header("kong-request-id", "710515329923024896")
                .body(JSON.toJSONString(paramMaps))
                .execute();

        int status = response.getStatus();
        System.out.println("请求响应状态码:" + status);
        String body = response.body();
        System.out.println(body);
        JSONObject jsonObject = JSONObject.parseObject(body);
        Object msg = jsonObject.get("msg");
        System.out.println(msg);
        Object code = jsonObject.get("code");
        System.out.println(code);

    }

    /**
     * 文件上传测试
     */
    @Test
    public void huToolUploadFile(){
        File f1 = new File("C:\\Users\\Administrator\\Desktop\\图片\\3.jpg");
        File f2 = new File("C:\\Users\\Administrator\\Desktop\\图片\\1.jpg");
        File[] files = new File[2];
        files[0] = f1;
        files[1] = f2;
        HttpResponse response = HttpRequest.post("url")
                .form("param", "test")
                .form("key", files)
                .execute();
    }

    @Test
    public void huToolGet(){
        System.out.println("--------------------------------get请求-----------------------------------");
        HashMap<String, Object> getParamMaps = new HashMap<>(5);
        getParamMaps.put("sortStr", "recordFlag,baseInfo.createTime");
        getParamMaps.put("sortDirection", "ASC");
        getParamMaps.put("filterStr", "flowAbleInfo.nodeId==craCheck");
        getParamMaps.put("pageSize", 10);
        getParamMaps.put("pageNo", 0);
        HttpResponse getResponse = HttpRequest.get("http://192.168.99.202:8202/thySystem/pg-biz-sae/sae/list")
                .header("Content-Type", "application/json")
                .header("token", "710515329923024896")
                .header("kong-request-id", "710515329923024896").form(getParamMaps).execute();

        int status1 = getResponse.getStatus();
        System.out.println("请求响应状态码:" + status1);
        String body1 = getResponse.body();
        System.out.println(body1);
        JSONObject jsonObject1 = JSONObject.parseObject(body1);
        Object msg1 = jsonObject1.get("msg");
        System.out.println(msg1);
        Object code1 = jsonObject1.get("code");
        System.out.println(code1);
    }

}
