package edu.fudan.langlab.uidl.domain.app.client.login;

import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.RequestHandler2;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.security.client.Securities;
import edu.fudan.langlab.security.shared.IFunctionIdentifier;
import edu.fudan.langlab.uidl.domain.app.client.login.LoginPresenterServiceAsync;
import edu.fudan.langlab.uidl.domain.app.client.login.LoginPresenterView;
import edu.fudan.langlab.uidl.domain.app.client.workbench.ApplicationWorkbenchPresenter;
import edu.fudan.langlab.uidl.domain.app.client.workbench.ApplicationWorkbenchPresenterView;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import edu.fudan.langlab.uidl.domain.app.shared.login.UIUser;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class LoginPresenter extends WorkbenchAbstractPresenter<LoginPresenterView> {
  @Inject
  protected LoginPresenterServiceAsync _service;
  
  @Inject
  public LoginPresenter(final LoginPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private ApplicationWorkbenchPresenter app;
  
  @Inject
  private Securities securities;
  
  public static UIUser user;
  
  public void onStartExecution() {
    
  }
  
  public void view_loginExecution(final String userid, final String passwd) {
    
    this.doLogin(userid, passwd);
  }
  
  public void doLogin(final String userid, final String passwd) {
    
    final Procedure1<UIUser> _function = new Procedure1<UIUser>() {
        public void apply(final UIUser u) {
          boolean _notEquals = (!Objects.equal(u, null));
          if (_notEquals) {
            LoginPresenter.user = u;
            final Procedure1<Boolean> _function = new Procedure1<Boolean>() {
                public void apply(final Boolean isSuperUser) {
                  if ((isSuperUser).booleanValue()) {
                    LoginPresenter.this.securities.setAsSuperuser();
                    RootPanel _get = RootPanel.get();
                    _get.remove(0);
                    final Procedure1<Void> _function = new Procedure1<Void>() {
                        public void apply(final Void it) {
                          RootPanel _get = RootPanel.get();
                          ApplicationWorkbenchPresenterView _view = LoginPresenter.this.app.getView();
                          Widget _asWidget = _view.asWidget();
                          _get.add(_asWidget);
                          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.login.ApplicationInitializedEvent(LoginPresenter.this.app));
                          
                        }
                      };
                    LoginPresenter.this.app.activate(new IPostInitializeAction() {
                        public void initializeFinished(Void v) {
                          _function.apply(v);
                        }
                    });
                  } else {
                    final Procedure1<Collection<? extends IFunctionIdentifier>> _function_1 = new Procedure1<Collection<? extends IFunctionIdentifier>>() {
                        public void apply(final Collection<? extends IFunctionIdentifier> functions) {
                          final Procedure1<IFunctionIdentifier> _function = new Procedure1<IFunctionIdentifier>() {
                              public void apply(final IFunctionIdentifier function) {
                                LoginPresenter.this.securities.registValidFunction(function);
                              }
                            };
                          IterableExtensions.forEach(functions, _function);
                          RootPanel _get = RootPanel.get();
                          _get.remove(0);
                          final Procedure1<Void> _function_1 = new Procedure1<Void>() {
                              public void apply(final Void it) {
                                RootPanel _get = RootPanel.get();
                                ApplicationWorkbenchPresenterView _view = LoginPresenter.this.app.getView();
                                Widget _asWidget = _view.asWidget();
                                _get.add(_asWidget);
                                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.login.ApplicationInitializedEvent(LoginPresenter.this.app));
                                
                              }
                            };
                          LoginPresenter.this.app.activate(new IPostInitializeAction() {
                              public void initializeFinished(Void v) {
                                _function_1.apply(v);
                              }
                          });
                        }
                      };
                    AsyncCallback<Collection<? extends IFunctionIdentifier>> _onSuccess = LoginPresenter.this.<Collection<? extends IFunctionIdentifier>>onSuccess(_function_1);
                    _service.loadFunctions4User(u, _onSuccess);
                  }
                }
              };
            AsyncCallback<Boolean> _onSuccess = LoginPresenter.this.<Boolean>onSuccess(_function);
            _service.isSuperUsr(userid, _onSuccess);
          } else {getView().loginFailed();
            
          }
        }
      };
    AsyncCallback<UIUser> _onSuccess = this.<UIUser>onSuccess(_function);
    _service.login(userid, passwd, _onSuccess);
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().login(new RequestHandler2<String,String>(){
    			
    			public void execute(String userid,String passwd){
    				view_loginExecution(userid,passwd);
    			}
    			
    		});
    onStartExecution();
    
  }
}
