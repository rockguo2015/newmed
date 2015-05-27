package edu.fudan.langlab.uidl.domain.code.client.web;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.domain.code.proxy.CodeProxy;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICode;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICodeType;

@RemoteServiceRelativePath("service/edu.fudan.langlab.uidl.domain.code.client.web.CreateOrUpdateCodePresenterService")
public interface CreateOrUpdateCodePresenterService extends RemoteService {
  public abstract UICode loadValue(final CodeProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateValue(final UICode uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void createValue(final UICodeType uiCodeType, final UICode uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
