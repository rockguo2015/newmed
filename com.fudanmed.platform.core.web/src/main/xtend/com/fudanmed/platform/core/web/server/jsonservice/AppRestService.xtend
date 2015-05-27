package com.fudanmed.platform.core.web.server.jsonservice

import com.fudanmed.platform.core.common.RCSystemParameterService
import com.fudanmed.platform.core.domain.RCSecurityService
import com.fudanmed.platform.core.domain.RCWorkItemTask
import com.fudanmed.platform.core.domain.RCWorkItemTaskStatus
import com.fudanmed.platform.core.domain.rest.RCFinishedWorkItemTaskCriteria
import com.fudanmed.platform.core.domain.rest.RCProcessingWorkItemTaskCriteria
import com.fudanmed.platform.core.domain.rest.RCWorkItemTaskCriteria4Status
import com.fudanmed.platform.core.measure.RCMeasureDevice
import com.fudanmed.platform.core.measure.RCMeasureDeviceCriteria
import com.fudanmed.platform.core.measure.RCMeasureDeviceTypeDAO
import com.fudanmed.platform.core.web.server.service.project.WorkItemTaskMapper
import edu.fudan.langlab.domain.security.AppFunctionService
import edu.fudan.langlab.domain.security.SecurityService
import edu.fudan.mylang.pf.BaseService
import edu.fudan.mylang.pf.IObjectFactory
import edu.fudan.mylang.utils.DateUtil
import java.util.Collection
import org.json.JSONObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import static extension com.fudanmed.platform.core.web.server.jsonservice.JSONUtil.*
import java.io.File
import com.fudanmed.platform.core.domain.RCTaskDirtyManager

@Service
@Transactional
class AppRestService extends BaseService implements IAppRestService{
	
	@Autowired RCSecurityService securityService;
	@Autowired SecurityService roleService;
	@Autowired AppFunctionService appFunctionService;
	@Autowired IObjectFactory entities;
	@Autowired RCSystemParameterService systemParameterService;

	File tempDir  = new File(System::getProperty("java.io.tmpdir"))
	
	override login(String userid, String passwd){
		val user = securityService.employeeUserLogin(userid,passwd)
		if(user==null){ 
			fail("无效用户名或密码")
		}else{
			val roles = roleService.getAllRoles4User(userid)
				.^map[appFunctionService.loadAllFunctions4Role(it.roleId)].flatten
				.toSet.filter[it.parent!=null && "com.fudanmed.platform.core.app".equals(it.parent.functionId)]
				.^map[name].toList
			success[
				 put("sessionid",userid)
				.put("userName",user.employee.name)
				.put("hospitalName",systemParameterService.systemParameter.orgName)
				.put("departmentName",user.employee.organization.name)
				.put("roles",roles)
			]
		}
	}

	override modifyPasswd(String userid, String oldPasswd, String newPasswd) {
		val user = securityService.employeeUserLogin(userid,oldPasswd)
		if(user!=null){
			user.passwd = newPasswd
			success[]
		}else{
			fail("无效用户名或密码")
		}
	}
	
	def toWorkItemTaskStatus(String status){
		RCWorkItemTaskStatus::valueOf(status)
	}
	

	override getFinishedCount(String userid, String startDate, String endDate) {
		success[
			put("count",(entities.createQueryCriteria(typeof(RCFinishedWorkItemTaskCriteria))=>[
				it.owner = securityService.asEmployeeUser(userid).employee
				it.startDate = startDate.toDate
				it.endDate = endDate.toDate
			]).^count)
		]
	}
	
	@Autowired WorkItemTaskMapper workitemTaskMapper
	@Autowired RCTaskDirtyManager taskDirtyManager
	override getFinishedWorkItems(String userid, String startDate, String endDate,String startNumber, String endNumber){
		val datas = (entities.createQueryCriteria(typeof(RCFinishedWorkItemTaskCriteria))=>[
			it.owner = securityService.asEmployeeUser(userid).employee
			it.startDate = startDate.toDate
			it.endDate = endDate.toDate
			it.^start = startNumber.toInteger
			it.^limit = endNumber.toInteger - ^start + 1
		]).list.^map[item|
			val workitem = workitemTaskMapper.transform(item)
			new JSONObject()=>[
				put("id",workitem.id)
				put("sid",workitem.sid)
				put("department",item.groupTask.repairTask.reportOrg.entityName)
				put("comment",item.groupTask.repairTask.comment)
				put("status",workitem.status.toString)
				put("time",workitem.time.toDateTimeString)
				put("reportTime",item.groupTask.repairTask.reportTime.toDateTimeString)
				put("finishTime",item.finishTime.toDateTimeString)
			]
		]	
		success(datas.toList)
	}

	override getProcessingCount(String userid) {
		success[
			put("count",
				(entities.createQueryCriteria(typeof(RCProcessingWorkItemTaskCriteria))=>[
					it.owner = securityService.asEmployeeUser(userid).employee
				]).^count
			)
		]
	}

	override getProcessingWorkItems(String userid, String startNumber, String endNumber) {
		val datas = (entities.createQueryCriteria(typeof(RCProcessingWorkItemTaskCriteria))=>[
			it.owner = securityService.asEmployeeUser(userid).employee
			it.^start = startNumber.toInteger
			it.^limit = endNumber.toInteger - startNumber.toInteger
		]).list.^map[item|
			val workitem = workitemTaskMapper.transform(item)
			new JSONObject()=>[
				put("id",workitem.id)
				put("sid",workitem.sid)
				put("department",item.groupTask.repairTask.reportOrg.entityName)
				put("comment",item.groupTask.repairTask.comment)
				put("status",workitem.status.toString)
				put("time",workitem.time.toDateTimeString)
				put("reportTime",item.groupTask.repairTask.reportTime.toDateTimeString)
				put("finishTime",item.finishTime.toDateTimeString)
				
			]
		]
		success(datas.toList)
	}

	override getWorkItem4Status(String userid, String startNumber, String endNumber,String fromDate, String toDate, String status) {
		val datas = (entities.createQueryCriteria(typeof(RCWorkItemTaskCriteria4Status))=>[
			it.owner = securityService.asEmployeeUser(userid).employee
			it.status = status.toWorkItemTaskStatus
			it.^start = startNumber.toInteger
			it.fromDate = fromDate.toDate
			it.toDate = toDate.toDate
			it.^limit = endNumber.toInteger - startNumber.toInteger
		]).list.^map[item|
		val workitem = workitemTaskMapper.transform(item)
			new JSONObject()=>[
				put("id",workitem.id)
				put("sid",workitem.sid)
				put("department",item.groupTask.repairTask.reportOrg.entityName)
				put("comment",item.groupTask.repairTask.comment)
				put("status",workitem.status.toString)
				put("time",workitem.time.toDateTimeString)
				put("reportTime",item.groupTask.repairTask.reportTime.toDateTimeString)
				put("finishTime",item.finishTime.toDateTimeString)
				
				
			]
		]
		success(datas.toList)
	}
	

	override getWorkItemDetail(String workitemId) {
		val workitem = entities.get(typeof(RCWorkItemTask),workitemId.toLong)
		val tWorkitem = workitemTaskMapper.transform(entities.get(typeof(RCWorkItemTask),workitemId.toLong))
		success[
			put("id",workitem.id)
			.put("sid",workitem.sid)
			.put("reportSid",workitem.groupTask.repairTask.reportSid)
			.put("status",tWorkitem.status.toString)
			.put("reportTime",workitem.groupTask.repairTask.reportTime.toDateTimeString)
			.put("finishTime",workitem.finishTime.toDateTimeString)
			.put("time",workitem.time.toDateTimeString)
			.put("workers",workitem.workers.map[name].join(","))
			.put("comment",workitem.groupTask.repairTask.comment)
			.put("location",workitem.groupTask.repairTask.location)
			.put("organization",workitem.groupTask.repairTask.reportOrg.entityName)
			.put("reporter",workitem.groupTask.repairTask.reporterName)
			.put("reporterPhone",workitem.groupTask.repairTask.reporterPhone)
		]
	}
	

	override pendWorkItem(String workitemId, String comment) {
		val workitem = entities.get(typeof(RCWorkItemTask),workitemId.toLong)
		workitem.comment = comment
		workitem.pend
		success[]
	}
	

	override cancelPendWorkItem(String workitemId, String desciption, String reportTime, String deviceNumber, String[] photoIds) {
		val workitem = entities.get(typeof(RCWorkItemTask),workitemId.toLong)
		workitem.comment = desciption
		workitem.finishTime = reportTime.toTime
		workitem.finishDate = DateUtil::trimDate(workitem.finishTime)
		workitem.cancelPend
		if(workitem.groupTask.allTasksFinishedExcept(workitem))
			taskDirtyManager.notifyTeam(workitem.groupTask.team)
		
		success[]
	}
	
	override outsourceWorkItem(String workitemId, String comment) {
		val workitem = entities.get(typeof(RCWorkItemTask),workitemId.toLong)
		workitem.comment = comment
		workitem.outsource
		success[]
	}
	

	override finishOutsourceWorkItem(String workitemId, String desciption, String reportTime, String deviceNumber, String[] photoIds) {
		val workitem = entities.get(typeof(RCWorkItemTask),workitemId.toLong)
		workitem.comment = desciption
		workitem.finishTime = reportTime.toTime
		workitem.finishDate = DateUtil::trimDate(workitem.finishTime)
		workitem.finishOutsource
		if(workitem.groupTask.allTasksFinishedExcept(workitem))
			taskDirtyManager.notifyTeam(workitem.groupTask.team)
		success[]
	}

	override finishWorkItem(String workitemId, String desciption, String reportTime, String deviceNumber, String[] photoIds) {
		val workitem = entities.get(typeof(RCWorkItemTask),workitemId.toLong)
		workitem.comment = desciption
		workitem.finishTime = reportTime.toTime
		workitem.finishDate = DateUtil::trimDate(workitem.finishTime)
		workitem.finish
		if(workitem.groupTask.allTasksFinishedExcept(workitem))
			taskDirtyManager.notifyTeam(workitem.groupTask.team)
		println("submit finish workitem:"+photoIds)
		if(photoIds!=null){
			photoIds.forEach[photoId|
				println("photoId:"+photoId)
				workitem.createAndAddtoDocuments=>[
					it.name = workitem.sid
					it.fileName = photoId
					setFile( new File (tempDir, photoId ))
				]
			]
		}
		success[]
	}
	
	override followupWorkItem(String workitemId, String desciption, String reportTime) {
		val workitem = entities.get(typeof(RCWorkItemTask),workitemId.toLong)
		workitem.comment = desciption
		workitem.followup
		success[]
	}
	
	override misdispatchWorkItem(String workitemId, String desciption, String reportTime) {
		val workitem = entities.get(typeof(RCWorkItemTask),workitemId.toLong)
		workitem.comment = desciption
		workitem.finishTime = reportTime.toTime
		workitem.finishDate = DateUtil::trimDate(workitem.finishTime)
		workitem.misDispatching
		if(workitem.groupTask.allTasksFinishedExcept(workitem))
			taskDirtyManager.notifyTeam(workitem.groupTask.team)
		success[]
	}
	
	@Autowired RCMeasureDeviceTypeDAO deviceTypeDAO
	override getMeasureDeviceList(String deviceType,String startNumber, String endNumber, String deviceSid){
		val datas = (entities.createQueryCriteria(typeof(RCMeasureDeviceCriteria))=>[
			val dt = switch(deviceType){
				case '1':{
					'水表'
				}
				case '2':{
					'电表'
				}
				case '3':{
					'气表'
				}
				case '4':{
					'峰谷电表'
				}
				default:{
					'INVALID'
				}
			}
			it.type = deviceTypeDAO.findByName(dt)
			if(!deviceSid.nullOrEmpty)
				it.sid = deviceSid
			it.^start = startNumber.toInteger
			it.^limit = endNumber.toInteger - startNumber.toInteger
		]).list.^map[item|
			new JSONObject()=>[
				put("id",item.id)
				put("sid",item.sid)
				put("name",item.name)
				val dtype = switch(item.deviceType.name){
					case '水表': 1
					case '电表': 2
					case '气表': 3
					case '峰谷电表': 4
					default : 0
				}
				put("deviceType",dtype)
				
				if(item.lastValue!=null){
					put("lastDate",item.lastValue.measureDate.toDateTimeString)
					put("lastValue",item.lastValue.serializeValues)
				}
			]
		]
		success(datas.toList)
	}
	
	override submitMeasureResult(String userid, String id, Collection<String> values, String date){
		val device = entities.get(typeof(RCMeasureDevice),id.toLong)
		device.createValue(date.toTime, securityService.asEmployeeUser(userid).employee.entityName)=>[
			deserializeValues(values.^map[it.toDouble].toList)
		]
		success[]
	}
	
}