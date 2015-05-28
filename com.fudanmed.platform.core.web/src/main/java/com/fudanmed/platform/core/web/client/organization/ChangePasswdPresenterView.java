package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.client.organization.ChangePasswdView;
import com.fudanmed.platform.core.web.shared.organization.UIChangePasswdData;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.FormViewer;

@ImplementedBy(value = ChangePasswdView.class)
public interface ChangePasswdPresenterView extends FormViewer<UIChangePasswdData> {
}
