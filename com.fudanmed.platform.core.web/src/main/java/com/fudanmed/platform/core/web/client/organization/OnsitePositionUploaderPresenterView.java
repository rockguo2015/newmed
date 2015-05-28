package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.client.organization.OnsitePositionUploaderView;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;
import com.uniquesoft.gwt.shared.datatype.File;

@ImplementedBy(value = OnsitePositionUploaderView.class)
public interface OnsitePositionUploaderPresenterView extends ViewerWithValidation {
  public abstract File getFile();
}
