package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.client.organization.ResetPasswdView;
import com.fudanmed.platform.core.web.shared.organization.UIResetPasswdData;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.FormViewer;

@ImplementedBy(value = ResetPasswdView.class)
public interface ResetPasswdPresenterView extends FormViewer<UIResetPasswdData> {
  public abstract void setDefaultNewPasswd(final String newPasswd);
}
