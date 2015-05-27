package com.uniquesoft.gwt.client.common.command;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.SessionTimeoutEvent;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.extensions.ConfigurableAsyncCallback;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public abstract class BaseCommand implements IInitializerSupport {
  @Inject
  protected EventBus eventBus;
  
  public abstract String getTitle();
  
  public abstract String getActionId();
  
  public boolean requireCheck() {
    return true;
  }
  
  public void initialize(final IPostInitializeAction postInitialize) {
    postInitialize.initializeFinished(null);
  }
  
  public <T extends Object> AsyncCallback<T> onSuccess(final Procedure1<? super T> onSuccess) {
    ConfigurableAsyncCallback<T> _xblockexpression = null;
    {
      ConfigurableAsyncCallback<T> _configurableAsyncCallback = new ConfigurableAsyncCallback<T>();
      ConfigurableAsyncCallback<T> callback = _configurableAsyncCallback;
      callback.onSuccessDo(onSuccess);
      final Procedure1<Void> _function = new Procedure1<Void>() {
          public void apply(final Void it) {
            SessionTimeoutEvent _sessionTimeoutEvent = new SessionTimeoutEvent();
            BaseCommand.this.eventBus.fireEvent(_sessionTimeoutEvent);
          }
        };
      callback.onSessionTimeoutDo(_function);
      _xblockexpression = (callback);
    }
    return _xblockexpression;
  }
}
