package com.fudanmed.platform.core.web.client.app;

import com.fudanmed.platform.core.web.client.app.MainGinjector;
import com.fudanmed.platform.core.web.client.app.ModuleInitializerImpl;
import com.fudanmed.platform.core.web.client.app.UIWorkbenchPartRegister;
import com.fudanmed.platform.core.web.client.names.ObjectNameService;
import com.google.gwt.inject.client.binder.GinAnnotatedBindingBuilder;
import com.google.gwt.inject.client.binder.GinScopedBindingBuilder;
import com.uniquesoft.gwt.client.common.RuntimeGinjector;
import com.uniquesoft.gwt.client.common.gin.UIDLBaseGinModule;
import com.uniquesoft.gwt.client.common.name.IObjectNameProvider;
import edu.fudan.langlab.uidl.domain.app.client.ModuleInitializer;
import edu.fudan.langlab.uidl.domain.app.client.WorkbenchManager;
import edu.fudan.langlab.uidl.domain.app.client.WorkbenchManagerImpl;
import edu.fudan.langlab.uidl.domain.app.client.login.FudanmedLoginView;
import edu.fudan.langlab.uidl.domain.app.client.login.LoginPresenter;
import edu.fudan.langlab.uidl.domain.app.client.login.LoginPresenterView;

@SuppressWarnings("all")
public class MainModule extends UIDLBaseGinModule {
  protected void configure() {
    GinAnnotatedBindingBuilder<RuntimeGinjector> _bind = this.<RuntimeGinjector>bind(RuntimeGinjector.class);
    _bind.<MainGinjector>to(MainGinjector.class);
    GinAnnotatedBindingBuilder<IObjectNameProvider> _bind_1 = this.<IObjectNameProvider>bind(IObjectNameProvider.class);
    _bind_1.<ObjectNameService>to(ObjectNameService.class);
    this.<LoginPresenterView>bindPresenter(LoginPresenter.class, 
      LoginPresenterView.class, 
      FudanmedLoginView.class);
    GinAnnotatedBindingBuilder<WorkbenchManager> _bind_2 = this.<WorkbenchManager>bind(WorkbenchManager.class);
    GinScopedBindingBuilder _to = _bind_2.<WorkbenchManagerImpl>to(WorkbenchManagerImpl.class);
    _to.asEagerSingleton();
    GinAnnotatedBindingBuilder<ModuleInitializer> _bind_3 = this.<ModuleInitializer>bind(ModuleInitializer.class);
    _bind_3.<ModuleInitializerImpl>to(ModuleInitializerImpl.class);
    this.<UIWorkbenchPartRegister>bind(UIWorkbenchPartRegister.class);
  }
}
