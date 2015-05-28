package com.fudanmed.platform.core.web.client.warehouse;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.datatype.File;

public interface ProductSpecificationUploaderPresenterServiceAsync {
  public abstract void doUpload(final File file, final AsyncCallback<Void> callback);
}
