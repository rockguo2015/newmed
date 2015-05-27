package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;
import edu.fudan.langlab.uidl.domain.app.client.security.CreateOrUpdateRoleView;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIRole;

@ImplementedBy(value = CreateOrUpdateRoleView.class)
public interface CreateOrUpdateRolePresenterView extends ViewerWithValidation {
  public abstract UIRole getValue();
  
  public abstract void setValue(final UIRole value);
}
