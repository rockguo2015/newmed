package com.fudanmed.platform.core.web.server.jsonservice

import org.json.JSONObject
import java.util.Collection
import java.text.SimpleDateFormat
import java.util.Date
import static extension com.uniquesoft.uidl.validation.Validates.*

class JSONUtil {
	def static success((JSONObject)=>void initReturn){
		new JSONObject()
			.put("message",1)
			.put("description","success")
			.put("data",new JSONObject()=>[initReturn.apply(it)])
	}
	def static success(Collection<JSONObject> datas){
		new JSONObject()
			.put("message",1)
			.put("description","success")
			.put("data",datas)
		
	}
	def static fail(String message){
		new JSONObject()
				.put("message",-3)
				.put("description",message)
	}
	def static fatal(String message){
		new JSONObject()
				.put("message",-1)
				.put("description",message)
	}
	
	def static toInteger(String intStr){
		if(intStr.nullOrEmpty) return null
		try{
			Integer::parseInt(intStr)
		}catch(Exception e){
			throw new JSONServiceException("整数格式错误:"+intStr)
		}
	}
	
	def static toLong(String intStr){
		if(intStr.nullOrEmpty) return null
		try{
			Long::parseLong(intStr)
		}catch(Exception e){
			throw new JSONServiceException("整数格式错误:"+intStr)
		}
	}
	
	def static toDouble(String doubleValue){
		if(doubleValue.nullOrEmpty) return null
		try{
			Double::parseDouble(doubleValue)
		}catch(Exception e){
			throw new JSONServiceException("数值格式错误:"+doubleValue)
		}
	}
	
	//YYYY-MM-DD
	def static toDate(String date){
		if(date.nullOrEmpty) return null
		try{
			new SimpleDateFormat("yyyy-MM-dd").parse(date)
		
		}catch(Exception e){
			throw new JSONServiceException("日期格式错误(YYYY-MM-DD):"+date)
		}
	}
	
	//YYYY-MM-DDTHH:MM:SS
	def static toTime(String time){
		if(time.nullOrEmpty) return null
		try{
			val segs = time.split('T')
			val datePart = new SimpleDateFormat("yyyy-MM-dd").parse(segs.get(0))
			val timePart = new SimpleDateFormat("HH-mm-ss").parse(segs.get(1))
			datePart.setHours(timePart.getHours());
			datePart.setMinutes(timePart.getSeconds());
			datePart.setSeconds(timePart.getSeconds());	
			datePart
		}catch(Exception e){
			throw new JSONServiceException("时间格式错误(YYYY-MM-DDTHH-MM-SS):"+time)
			
		}	
	}
	
	def static toDateString(Date date){
		if(date==null) return ""
		new SimpleDateFormat("yyyy-MM-dd").format(date)
	}
	
	def static toDateTimeString(Date date){
		if(date==null) return ""
		val datePart = new SimpleDateFormat("yyyy-MM-dd").format(date)
		val timePart = new SimpleDateFormat("HH-mm-ss").format(date)
		datePart + "T" + timePart
		
	}
	
}