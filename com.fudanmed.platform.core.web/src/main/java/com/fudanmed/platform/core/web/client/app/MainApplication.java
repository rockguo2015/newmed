package com.fudanmed.platform.core.web.client.app;

import com.fudanmed.platform.core.web.client.app.MainGinjector;
import com.uniquesoft.gwt.client.common.Presenter;
import edu.fudan.langlab.uidl.domain.app.client.BaseApplication;
import edu.fudan.langlab.uidl.domain.app.client.ModuleInitializer;
import edu.fudan.langlab.uidl.domain.app.client.login.LoginPresenter;

@SuppressWarnings("all")
public class MainApplication extends BaseApplication {
  protected void doOnModuleLoad() {
    ModuleInitializer _applicationBuilder = MainGinjector.INSTANCE.getApplicationBuilder();
    _applicationBuilder.initializeModule();
  }
  
  public Presenter<? extends Object> createMainPresenter() {
    LoginPresenter _loginPresenter = MainGinjector.INSTANCE.getLoginPresenter();
    return _loginPresenter;
  }
}
