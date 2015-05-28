package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.CreateOrUpdateDocumentStorageView;
import com.fudanmed.platform.core.web.shared.device.UIDocumentStorage;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.FormViewer;

@ImplementedBy(value = CreateOrUpdateDocumentStorageView.class)
public interface CreateOrUpdateDocumentStoragePresenterView extends FormViewer<UIDocumentStorage> {
}
