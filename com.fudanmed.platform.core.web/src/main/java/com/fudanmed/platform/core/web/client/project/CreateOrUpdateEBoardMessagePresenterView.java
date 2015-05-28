package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.CreateOrUpdateEBoardMessageView;
import com.fudanmed.platform.core.web.shared.project.UIEBoardMessage;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.FormViewer;

@ImplementedBy(value = CreateOrUpdateEBoardMessageView.class)
public interface CreateOrUpdateEBoardMessagePresenterView extends FormViewer<UIEBoardMessage> {
}
