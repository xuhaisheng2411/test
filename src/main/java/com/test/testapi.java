package com.test;

import cn.org.sapphira.commons.lang.SprStringUtils;
import cn.org.sapphira.commons.lang.SprStructuralStringUtils;
import com.apaas.common.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.util.StringUtils;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.TreeSet;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class testapi {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	public  static void main(String[] args) {
		LinkedHashMap<String, String> sortMap = (LinkedHashMap<String, String>)
				SprStructuralStringUtils.toMap("'createDate':'desc','name':'asc'", ",", ":");
 		sortMap.keySet().forEach(key ->{
			System.out.println("key="+key);
			System.out.println("value="+sortMap.get(key));
		});
		System.out.println(sortMap.toString());
		
		StringBuffer  sb=new StringBuffer();

		if(sb!=null && sb.length()>0){
		System.out.println("证明sb不为空!");

		}else {
			System.out.println("证明sb为空!"+sb.length());
		}
		String cronTaskRunKey= "08a7a1cbe2814005956d002615cb152cwVok@20201015171030";

		String cronTaskId = StringUtils.substringBefore(cronTaskRunKey, "@");
		String cronTaskRunTimeStr =  StringUtils.substringAfter(cronTaskRunKey, "@");
		//String newStatus = (String) redisTemplate.hget(Constants.KEYHEAD_CRONTASKRUN +cronTaskRunKey, "status");
		System.out.println("cronTaskRunKey="+cronTaskRunKey+",cronTaskId="+cronTaskId+",cronTaskRunTimeStr="+cronTaskRunTimeStr);

		//TreeSet<Long> exceptionDateLongSet = new TreeSet<Long>();
		//exceptionDateLongSet.add(Long.parseLong(DateUtil.getFileNameByTime(DateUtil.parseDate("20201005", "yyyyMMdd"))));
		//Date d = getNextIntervalHour(true,"30:00",now,1,exceptionDateLongSet);
		//Long l = getCycleMonthScheduleNextLongValue("02:40:00",1,20200926030000L,null, null);
		//System.out.println(getCycleMonthScheduleNextLongValue("05:02:40:00",1,20200926030000L,exceptionDateLongSet, null));
	}
	
	private static Date getDateMonth(Date date,String scheduleValue) {
		int thisYear = Integer.parseInt(DateUtil.getYear(date));
		int thisMonth =Integer.parseInt(DateUtil.getMonth(date));
		String thisDay = SprStringUtils.substring(scheduleValue, ":", 0);
		String timeStr = StringUtils.substring(scheduleValue, 3, 11);
		String dateHourStr = thisYear +"-" + thisMonth +"-" + thisDay +" "+ timeStr;
		return DateUtil.parseDate(dateHourStr, DateUtil.DEFAULT_DATE);
	};	
	private static Long getCycleMonthScheduleNextLongValue(String scheduleValue,int scheduleInterval,Long effectiveDateLong,TreeSet<Long> exceptionDateLongSet, Long lastestTimeLong) {
		Date nextDateTime = null;
		Date now = DateUtil.getCurrentDate();
		Long newDateLong = null;
		Date effectiveDate = null;
		boolean firstTime = lastestTimeLong == null ? true : false;
		System.out.println("firstTime="+firstTime);
		if (firstTime){
			if (null == effectiveDateLong) {
				nextDateTime = getDateMonth(now, scheduleValue);
				effectiveDate = DateUtil.getFirstDayOfYear(nextDateTime);
			}else {
				effectiveDate = DateUtil.parseDate(Long.toString(effectiveDateLong), DateUtil.DEFAULT_FILE_DATE);
				if (DateUtil.earlier(effectiveDate, now ,DateUtil.ACCURACY_MINUTE)) {
					nextDateTime = getDateMonth(now, scheduleValue);
				}else {
					nextDateTime = getDateMonth(effectiveDate, scheduleValue);
				}
			}
			nextDateTime = getNextIntervalMonth(true,scheduleValue,nextDateTime,scheduleInterval,exceptionDateLongSet,effectiveDate);
		}else {
			Date lastestDateTime =  DateUtil.parseDate(Long.toString(lastestTimeLong), DateUtil.DEFAULT_FILE_DATE);
			nextDateTime = getNextIntervalMonth(false,scheduleValue,lastestDateTime,scheduleInterval,exceptionDateLongSet,effectiveDate);			
		}	
		return  Long.parseLong(DateUtil.getFileNameByTime(nextDateTime));
	}	
	
	private static Date getNextIntervalMonth(boolean containCurrentValue,String scheduleValue,Date lastestDateTime,int scheduleInterval,TreeSet<Long> exceptionDateLongSet,Date effectiveDate) {
		boolean rightValue = true;
		Date now = DateUtil.getCurrentDate();
		System.out.println("init lastestDateTime="+lastestDateTime);		
		Date newNextDate = getDateMonth(lastestDateTime,scheduleValue);
		System.out.println("before newNextDate="+newNextDate+",containCurrentValue="+containCurrentValue);
		if (!containCurrentValue) {
			newNextDate = DateUtil.addMonths(newNextDate, scheduleInterval);
		}
		System.out.println("after newNextDate="+newNextDate);
		Long newNextDateLong =Long.parseLong(DateUtil.getFileNameByTime(newNextDate));
		if (null != exceptionDateLongSet && exceptionDateLongSet.iterator().hasNext()) {
			Iterator<Long> eDateLogSet = exceptionDateLongSet.iterator();
			while (eDateLogSet.hasNext()) {
				Long exeptionDateMin = eDateLogSet.next();
				Long exeptionDateMax = exeptionDateMin + 240000L;
				if ( newNextDateLong >= exeptionDateMin && newNextDateLong < exeptionDateMax) {
					rightValue = false;
				}
			}
		}		
		if (!rightValue || DateUtil.earlier(newNextDate, now ,DateUtil.ACCURACY_MINUTE) || DateUtil.earlier(newNextDate, effectiveDate ,DateUtil.ACCURACY_MINUTE)) {
			System.out.println("sub get with newNextDate="+newNextDate);
			return getNextIntervalMonth(false,scheduleValue,newNextDate,scheduleInterval,exceptionDateLongSet,effectiveDate);
		}else {
			return newNextDate;
		}
	}
}

