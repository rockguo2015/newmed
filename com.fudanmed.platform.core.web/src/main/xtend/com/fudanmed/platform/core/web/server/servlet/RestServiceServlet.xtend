package com.fudanmed.platform.core.web.server.servlet

import com.fudanmed.platform.core.web.server.jsonservice.IAppRestService
import com.fudanmed.platform.core.web.server.jsonservice.JSONServiceException
import com.fudanmed.platform.core.web.server.jsonservice.JSONUtil
import com.uniquesoft.gwt.server.service.common.HttpRequestThreadLocal
import com.uniquesoft.gwt.shared.validation.ValidationException
import edu.fudan.langlab.domain.statemachine.InvalidStateException
import java.io.File
import java.io.IOException
import java.io.OutputStreamWriter
import java.util.HashMap
import java.util.List
import java.util.UUID
import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.apache.commons.fileupload.FileItem
import org.apache.commons.fileupload.disk.DiskFileItemFactory
import org.apache.commons.fileupload.servlet.ServletFileUpload
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.json.JSONObject
import org.springframework.web.context.support.WebApplicationContextUtils

import static com.fudanmed.platform.core.web.server.jsonservice.JSONUtil.*
import static com.fudanmed.platform.core.web.server.servlet.RestServiceServlet.*

class RestServiceServlet extends HttpServlet{
	HashMap<String, (HttpServletRequest , HttpServletResponse )=>JSONObject> dispatcher = new HashMap<String, (HttpServletRequest , HttpServletResponse )=>JSONObject>()
	private static Log logger = LogFactory::
			getLog(typeof(RestServiceServlet));
	
	def isEncode(String s, String encoding){
		s.equals(new String(s.getBytes(encoding),encoding))
	}
	def getRequiredParameter(HttpServletRequest request, String key){
		val value = request.getParameter(key)
		if(value==null) throw new JSONServiceException("missing parameter:"+key)
		value
	}
	
	def getRequiredParameterValues(HttpServletRequest request, String key){
		val value = request.getParameterValues(key)
		if(value==null || value.size==0) throw new JSONServiceException("missing parameter:"+key)
		value
	}
	
	def stateAwareExecute((Void)=>JSONObject executer){
		try{
			executer.apply(null)
		}catch(InvalidStateException e){
			fail("工单状态错误，请刷新状态")
		}
	}
	File tempDir  = new File(System::getProperty("java.io.tmpdir"))
	new(){
		super()
		dispatcher.put("login")[req,resp|
			getAppRestService(req).login(req.getParameter("userid"), req.getParameter("passwd"))
		]
		
		dispatcher.put("modifypasswd")[req,resp|
			getAppRestService(req).modifyPasswd(
				req.getRequiredParameter("sessionid").toUserid, 
				req.getRequiredParameter("oldPasswd"),
				req.getRequiredParameter("newPasswd")
			)
		]
		dispatcher.put("finishedcount")[req,resp|
			getAppRestService(req).getFinishedCount(
				req.getRequiredParameter("sessionid").toUserid, 
				req.getRequiredParameter("startDate"),
				req.getRequiredParameter("endDate")
			)
		]
		dispatcher.put("finishedworkitems")[req,resp|
			getAppRestService(req).getFinishedWorkItems(
				req.getRequiredParameter("sessionid").toUserid, 
				req.getRequiredParameter("startDate"),
				req.getRequiredParameter("endDate"),
				req.getRequiredParameter("startNumber"),
				req.getRequiredParameter("endNumber")
			)
		]
		dispatcher.put("processingcount")[req,resp|
			getAppRestService(req).getProcessingCount(
				req.getRequiredParameter("sessionid").toUserid
			)
		]
		dispatcher.put("processingworkitems")[req,resp|
			getAppRestService(req).getProcessingWorkItems(
				req.getRequiredParameter("sessionid").toUserid, 
				req.getRequiredParameter("startNumber"),
				req.getRequiredParameter("endNumber")
			)
		]	
		dispatcher.put("workitems4status")[req,resp|
			getAppRestService(req).getWorkItem4Status(
				req.getRequiredParameter("sessionid").toUserid, 
				req.getRequiredParameter("startNumber"),
				req.getRequiredParameter("endNumber"),
				req.getParameter("startDate"),
				req.getParameter("endDate"),
				req.getRequiredParameter("status")
			)
		]
		dispatcher.put("workitemdetail")[req,resp|
			getAppRestService(req).getWorkItemDetail(
				req.getRequiredParameter("id")
			)
		]	
		dispatcher.put("pend")[req,resp|
			stateAwareExecute[
				getAppRestService(req).pendWorkItem(
					req.getRequiredParameter("id"),
					new String(req.getParameter("description").getBytes("iso8859-1"),"utf-8")
				)
			]
		]	
		dispatcher.put("cancelpend")[req,resp|
			stateAwareExecute[
				getAppRestService(req).cancelPendWorkItem(
					req.getRequiredParameter("id"),
					new String(req.getParameter("description").getBytes("iso8859-1"),"utf-8"),
					req.getRequiredParameter("reportTime"),
					req.getParameter("deviceNumber"),
					req.getParameterValues("photoIds")
				)
			]
		]	
		dispatcher.put("outsource")[req,resp|
			stateAwareExecute[
				getAppRestService(req).outsourceWorkItem(
					req.getRequiredParameter("id"),
					new String(req.getParameter("description").getBytes("iso8859-1"),"utf-8")
				)
			]
		]	
		dispatcher.put("finishoutsource")[req,resp|
			stateAwareExecute[
				getAppRestService(req).finishOutsourceWorkItem(
					req.getRequiredParameter("id"),
					new String(req.getParameter("description").getBytes("iso8859-1"),"utf-8"),
					req.getRequiredParameter("reportTime"),
					req.getParameter("deviceNumber"),
					req.getParameterValues("photoIds")
				)
			]
		]	
		dispatcher.put("misdispatching")[req,resp|
			stateAwareExecute[
				getAppRestService(req).misdispatchWorkItem(
					req.getRequiredParameter("id"),
					new String(req.getParameter("description").getBytes("iso8859-1"),"utf-8"),
					req.getRequiredParameter("reportTime")
				)
			]
		]	
		dispatcher.put("followup")[req,resp|
			stateAwareExecute[
				getAppRestService(req).followupWorkItem(
					req.getRequiredParameter("id"),
					new String(req.getParameter("description").getBytes("iso8859-1"),"utf-8"),
					req.getRequiredParameter("reportTime")
				)
			]
		]	
		dispatcher.put("finish")[req,resp|
			stateAwareExecute[
				getAppRestService(req).finishWorkItem(
					req.getRequiredParameter("id"),
					new String(req.getParameter("description").getBytes("iso8859-1"),"utf-8"),
					req.getRequiredParameter("reportTime"),
					req.getParameter("deviceNumber"),
					req.getParameterValues("photoIds")
				)
			]
		]	
		dispatcher.put("measuredevicelist")[req,resp|
			getAppRestService(req).getMeasureDeviceList(
				req.getParameter("deviceType"),
				req.getRequiredParameter("startNumber"),
				req.getRequiredParameter("endNumber"),
				req.getParameter("deviceSid")
			)
		]	
		dispatcher.put("submitmeasureresult")[req,resp|
			getAppRestService(req).submitMeasureResult(
				req.getRequiredParameter("sessionid").toUserid, 
				req.getRequiredParameter("id"),
				req.getRequiredParameterValues("value"),
				req.getRequiredParameter("date")
			)
		]	
	}
	
	def toUserid(String sessionid){
		sessionid
	}
	
	def getAppRestService(HttpServletRequest req){
		val applicationContext = WebApplicationContextUtils::
				getWebApplicationContext(req.getSession().getServletContext());
		applicationContext.getBean(typeof(IAppRestService))
	}

	
	override doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8")
		HttpRequestThreadLocal::set(req);
		val serviceName = req.getRequestURI().substring(req.getRequestURI().lastIndexOf("/")+1);
		logger.info("invoke rest service:"+serviceName)
		
		val writer = new OutputStreamWriter(resp.getOutputStream(),"UTF-8");					
		resp.setContentType("application/json");
		try{
			val result = dispatcher.get(serviceName).apply(req,resp)
			writer.write(result.toString);
		}catch(ValidationException e){
			writer.write(fail(e.message).toString)
		}catch(Exception e){
			logger.error(e)
			writer.write(fatal(e.message).toString)
		}finally{
			writer.flush();
		}
	}	
	
	override doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		val serviceName = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
		val writer = new OutputStreamWriter(response.getOutputStream(),"UTF-8");					
		logger.info("invoke rest service:"+serviceName)
		try{
			if (ServletFileUpload::isMultipartContent(request) && 'upload'.equals(serviceName)){
			 	val List<FileItem> multiparts = new ServletFileUpload (new DiskFileItemFactory ()).
			 		parseRequest ( request )
			 	val item = multiparts.filter[!isFormField].head
				val name = UUID::randomUUID.toString + item.name
				item.write ( new File (tempDir, name ))
				println(tempDir.absolutePath + '/'+name)
				val respStr = JSONUtil::success[
					put('photoId',name)
				].toString
				println(respStr)
				writer.write(respStr)
		 	}
	 	}catch(Exception e){
	 		JSONUtil::fail(e.message)
	 	}finally{
	 		writer.flush();
	 	}
	}
		
}