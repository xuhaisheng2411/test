package com.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.apaas.common.util.Constants;
import com.apaas.common.util.ServerUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class testapi2 {

	@Autowired
	private   RedisTemplate<String, Object> redisTemplate;
 
	public  static void main(String[] args) {

		JSONObject jb = new JSONObject();
		jb.put("topic", Constants.APAAS_BUSIMSG_APAAS_API);
		jb.put("sender", ServerUtil.APAAS_ServerId);
		jb.put("busiType", Constants.OC_OPERATION_CREATECRONTASKRUN);
		JSONObject content = new JSONObject();
		content.put("taskId", "111");//主类Id
		content.put("configTarget", "222");//是否自动
		content.put("cronTaskRunkey", "33");
		content.put("timetable", "333");
		jb.put("content", content);

		System.out.println("jb"+jb);

		JSONObject newNode = null;
		JSONObject OCCOM_TNodeExecuteTarget = new JSONObject();
		OCCOM_TNodeExecuteTarget.put("classId", Constants.CLASSID_EXECUTETARGET);
		OCCOM_TNodeExecuteTarget.put("dataContent", JSONArray.parseArray("[]"));
		System.out.println("OCCOM_TNodeExecuteTarget="+OCCOM_TNodeExecuteTarget);
		newNode.put("OCCOM_TNodeExecuteTarget", OCCOM_TNodeExecuteTarget);
		System.out.println("newNode="+newNode);


		}
}

