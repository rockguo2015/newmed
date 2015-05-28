package com.fudanmed.platform.core.web.client.common;

import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Date;

public interface ServerSideTimeServiceAsync {
  public abstract void getTime(final AsyncCallback<Date> callback);
}
