package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.client.organization.OrganizationUploaderView;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;
import com.uniquesoft.gwt.shared.datatype.File;

@ImplementedBy(value = OrganizationUploaderView.class)
public interface OrganizationUploaderPresenterView extends ViewerWithValidation {
  public abstract File getFile();
}
