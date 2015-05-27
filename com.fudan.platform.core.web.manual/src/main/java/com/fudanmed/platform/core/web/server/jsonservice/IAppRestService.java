package com.fudanmed.platform.core.web.server.jsonservice;

import java.util.Collection;

import org.json.JSONObject;

public interface IAppRestService {

	public abstract JSONObject login(String userid, String passwd);
	public abstract JSONObject modifyPasswd(String userid, String oldPasswd, String newPasswd);
	public abstract JSONObject getFinishedCount(String sessionid, String startDate, String endDate);
	public abstract JSONObject getFinishedWorkItems(String userid, String startDate, String endDate,String startNumber, String endNumber);
	public abstract JSONObject getProcessingCount(String sessionid);
	public abstract JSONObject getProcessingWorkItems(String userid,String startNumber, String endNumber);
	public abstract JSONObject getWorkItem4Status(String userid,String fromDate, String toDate, String startNumber, String endNumber, String status);
	public abstract JSONObject getWorkItemDetail(String workitemId);
	
	public abstract JSONObject pendWorkItem(String workitemId, String comment);
	public abstract JSONObject cancelPendWorkItem(String workitemId, String comment, String reportTime, String deviceNumber, String[] photoIds);
	
	public abstract JSONObject outsourceWorkItem(String workitemId, String comment);
	public abstract JSONObject finishOutsourceWorkItem(String workitemId, String comment, String reportTime, String deviceNumber, String[] photoIds);

	public abstract JSONObject misdispatchWorkItem(String workitemId, String comment, String reportTime);
	public abstract JSONObject followupWorkItem(String workitemId, String comment, String reportTime);
	public abstract JSONObject finishWorkItem(String workitemId, String comment, String reportTime, String deviceNumber, String[] photoIds);
	public abstract JSONObject getMeasureDeviceList(String deviceType,String startNumber, String endNumber, String deviceName);
	public abstract JSONObject submitMeasureResult(String userid, String id, Collection<String> values, String date);
	
}