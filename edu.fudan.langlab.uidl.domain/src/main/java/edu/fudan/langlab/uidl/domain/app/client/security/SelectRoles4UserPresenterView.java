package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;
import edu.fudan.langlab.domain.security.proxy.RoleProxy;
import edu.fudan.langlab.uidl.domain.app.client.security.SelectRoles4UserView;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIUserRoles;
import java.util.Collection;

@ImplementedBy(value = SelectRoles4UserView.class)
public interface SelectRoles4UserPresenterView extends ViewerWithValidation {
  public abstract void setRoles(final Collection<RoleProxy> roles);
  
  public abstract UIUserRoles getValue();
}
