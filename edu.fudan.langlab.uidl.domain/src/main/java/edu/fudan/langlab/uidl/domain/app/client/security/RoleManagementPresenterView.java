package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import edu.fudan.langlab.domain.security.proxy.RoleProxy;
import edu.fudan.langlab.uidl.domain.app.client.security.RoleManagementView;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIRole;
import java.util.Collection;

@ImplementedBy(value = RoleManagementView.class)
public interface RoleManagementPresenterView extends Viewer {
  public abstract void setResults(final Collection<UIRole> results);
  
  public abstract void createRoleRequest(final RequestHandler requestHandler);
  
  public abstract void modifyRoleRequest(final RequestHandler1<RoleProxy> requestHandler);
  
  public abstract void deleteRoleRequest(final RequestHandler1<RoleProxy> requestHandler);
}
