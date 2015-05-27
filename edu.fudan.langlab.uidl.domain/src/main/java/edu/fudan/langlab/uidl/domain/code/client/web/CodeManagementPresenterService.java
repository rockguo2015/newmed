package edu.fudan.langlab.uidl.domain.code.client.web;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.domain.code.proxy.CodeProxy;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICode;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICodeCriteria;
import java.util.Collection;

@RemoteServiceRelativePath("service/edu.fudan.langlab.uidl.domain.code.client.web.CodeManagementPresenterService")
public interface CodeManagementPresenterService extends RemoteService {
  public abstract Collection<UICode> filter(final UICodeCriteria uicriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void delete(final CodeProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
