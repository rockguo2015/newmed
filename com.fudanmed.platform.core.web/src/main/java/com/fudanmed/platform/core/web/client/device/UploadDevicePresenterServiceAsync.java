package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.datatype.File;
import java.util.Collection;

public interface UploadDevicePresenterServiceAsync {
  public abstract void doUpload(final File file, final AsyncCallback<Collection<UIDevice>> callback);
  
  public abstract void commit(final Collection<UIDevice> results, final AsyncCallback<Void> callback);
}
