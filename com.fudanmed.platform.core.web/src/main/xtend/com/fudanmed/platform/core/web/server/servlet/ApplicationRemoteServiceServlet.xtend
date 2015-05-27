package com.fudanmed.platform.core.web.server.servlet
import com.google.gwt.user.server.rpc.RPCRequest;
import com.uniquesoft.gwt.server.service.common.SpringGwtRemoteServiceServlet;
class ApplicationRemoteServiceServlet  extends SpringGwtRemoteServiceServlet {
	private static  long serialVersionUID = -4968059048798982610L
	
	override boolean hasLogin() {
		return getThreadLocalRequest().getSession().getAttribute("__userid__") != null;
	}
	
	override boolean requireSession(RPCRequest rpcRequest) {
		return !(rpcRequest.getMethod().getName().equals("login"));
	}
}