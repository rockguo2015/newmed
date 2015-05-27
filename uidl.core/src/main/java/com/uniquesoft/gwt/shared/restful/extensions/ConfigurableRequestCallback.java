package com.uniquesoft.gwt.shared.restful.extensions;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

@SuppressWarnings("all")
public class ConfigurableRequestCallback implements RequestCallback {
  public static ConfigurableRequestCallback callback(final Procedure1<? super ConfigurableRequestCallback> init) {
    ConfigurableRequestCallback _configurableRequestCallback = new ConfigurableRequestCallback();
    final ConfigurableRequestCallback x = _configurableRequestCallback;
    init.apply(x);
    return x;
  }
  
  public void onError(final Request request, final Throwable exception) {
    this.onFailure.apply(request, exception);
  }
  
  public void onResponseReceived(final Request request, final Response response) {
    this.onSuccess.apply(request, response);
  }
  
  private Procedure2<? super Request,? super Throwable> onFailure = null;
  
  private Procedure2<? super Request,? super Response> onSuccess = null;
  
  public void onSuccessDo(final Procedure2<? super Request,? super Response> onSuccess) {
    this.onSuccess = onSuccess;
  }
  
  public void onFailureDo(final Procedure2<? super Request,? super Throwable> onFailure) {
    this.onFailure = onFailure;
  }
}
