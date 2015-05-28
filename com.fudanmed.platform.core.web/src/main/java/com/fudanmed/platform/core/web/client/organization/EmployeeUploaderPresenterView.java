package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.client.organization.EmployeeUploaderView;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;
import com.uniquesoft.gwt.shared.datatype.File;

@ImplementedBy(value = EmployeeUploaderView.class)
public interface EmployeeUploaderPresenterView extends ViewerWithValidation {
  public abstract File getFile();
}
