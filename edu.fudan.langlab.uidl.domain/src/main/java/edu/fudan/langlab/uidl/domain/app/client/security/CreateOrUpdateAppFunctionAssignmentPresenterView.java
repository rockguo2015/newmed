package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;
import edu.fudan.langlab.uidl.domain.app.client.security.CreateOrUpdateAppFunctionAssignmentView;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppFunctionAssignment;

@ImplementedBy(value = CreateOrUpdateAppFunctionAssignmentView.class)
public interface CreateOrUpdateAppFunctionAssignmentPresenterView extends ViewerWithValidation {
  public abstract UIAppFunctionAssignment getValue();
  
  public abstract void setValue(final UIAppFunctionAssignment value);
}
