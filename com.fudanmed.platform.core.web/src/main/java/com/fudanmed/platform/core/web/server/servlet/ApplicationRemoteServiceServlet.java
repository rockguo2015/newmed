package com.fudanmed.platform.core.web.server.servlet;

import com.google.common.base.Objects;
import com.google.gwt.user.server.rpc.RPCRequest;
import com.uniquesoft.gwt.server.service.common.SpringGwtRemoteServiceServlet;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public class ApplicationRemoteServiceServlet extends SpringGwtRemoteServiceServlet {
  private static long serialVersionUID = new Function0<Long>() {
    public Long apply() {
      long _minus = (-4968059048798982610L);
      return _minus;
    }
  }.apply();
  
  public boolean hasLogin() {
    HttpServletRequest _threadLocalRequest = this.getThreadLocalRequest();
    HttpSession _session = _threadLocalRequest.getSession();
    Object _attribute = _session.getAttribute("__userid__");
    return (!Objects.equal(_attribute, null));
  }
  
  public boolean requireSession(final RPCRequest rpcRequest) {
    Method _method = rpcRequest.getMethod();
    String _name = _method.getName();
    boolean _equals = _name.equals("login");
    return (!_equals);
  }
}
