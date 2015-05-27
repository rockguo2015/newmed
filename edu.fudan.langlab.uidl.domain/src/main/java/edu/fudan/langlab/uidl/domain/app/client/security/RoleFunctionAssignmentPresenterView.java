package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import edu.fudan.langlab.uidl.domain.app.client.security.RoleFunctionAssignmentView;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppFunction;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppRole;
import java.util.Collection;

@ImplementedBy(value = RoleFunctionAssignmentView.class)
public interface RoleFunctionAssignmentPresenterView extends Viewer {
  public abstract void showRoles(final Collection<UIAppRole> roles);
  
  public abstract void showFunctions(final Collection<UIAppFunction> functions);
  
  public abstract void showRoleFunctionsRequest(final RequestHandler1<UIAppRole> requestHandler);
  
  public abstract void modifyAssignmentRequest(final RequestHandler1<UIAppRole> requestHandler);
}
