package com.uniquesoft.gwt.client.common.extensions;

import com.google.common.base.Objects;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * Set special kinds of validation errors for the callback.
 */
@SuppressWarnings("all")
public class ConfigurableAsyncCallback<T extends Object> extends ServiceCallback<T> {
  public static <T extends Object> ConfigurableAsyncCallback<T> callback(final Procedure1<? super ConfigurableAsyncCallback<T>> init) {
    ConfigurableAsyncCallback<T> _configurableAsyncCallback = new ConfigurableAsyncCallback<T>();
    final ConfigurableAsyncCallback<T> x = _configurableAsyncCallback;
    init.apply(x);
    return x;
  }
  
  private Procedure1<? super Throwable> onFailure = null;
  
  private Procedure1<? super T> onSuccess = null;
  
  private Procedure1<? super Collection<ValidationErrorItem>> onValidationFailure = null;
  
  public void onSuccessDo(final Procedure1<? super T> onSuccess) {
    this.onSuccess = onSuccess;
  }
  
  private Procedure1<? super Void> onSessionTimeout;
  
  public void onSessionTimeoutDo(final Procedure1<? super Void> onSessionTimeout) {
    this.onSessionTimeout = onSessionTimeout;
  }
  
  public void onFailureDo(final Procedure1<? super Throwable> onFailure) {
    this.onFailure = onFailure;
  }
  
  public void onValidationFailureDo(final Procedure1<? super Collection<ValidationErrorItem>> onValidationFailure) {
    this.onValidationFailure = onValidationFailure;
  }
  
  public void onFailure(final Throwable caught) {
    boolean _notEquals = (!Objects.equal(this.onFailure, null));
    if (_notEquals) {
      this.onFailure.apply(caught);
    } else {
      super.onFailure(caught);
    }
  }
  
  public void onSuccess(final T result) {
    this.onSuccess.apply(result);
  }
  
  public void onSessionTimeOutException() {
    this.onSessionTimeout.apply(null);
  }
  
  public void onValidationException(final Collection<ValidationErrorItem> errors) {
    boolean _notEquals = (!Objects.equal(this.onValidationFailure, null));
    if (_notEquals) {
      this.onValidationFailure.apply(errors);
    } else {
      super.onValidationException(errors);
    }
  }
}
