package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateFaultTypePresenter;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateMaintenamceTypePresenter;
import com.fudanmed.platform.core.web.client.project.MaintenamceTypeManagementPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.MaintenamceTypeManagementPresenterView;
import com.fudanmed.platform.core.web.shared.project.UIFaultType;
import com.fudanmed.platform.core.web.shared.project.UIMaintenamceType;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.selector.IHasObjectSelectionProvider;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class MaintenamceTypeManagementPresenter extends WorkbenchAbstractPresenter<MaintenamceTypeManagementPresenterView> implements IHasObjectSelectionProvider<UIFaultType> {
  @Inject
  protected MaintenamceTypeManagementPresenterServiceAsync _service;
  
  @Inject
  public MaintenamceTypeManagementPresenter(final MaintenamceTypeManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private Provider<CreateOrUpdateMaintenamceTypePresenter> createOrUpdatePresenter;
  
  @Inject
  private Provider<CreateOrUpdateFaultTypePresenter> createOrUpdateFaultTypePresenter;
  
  private RCMaintenamceTypeProxy parent;
  
  public void setup(final Procedure1<? super MaintenamceTypeManagementPresenter> postInit) {
    
    getView().setAsReadonly(false);
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<Collection<UIMaintenamceType>> _function = new Procedure1<Collection<UIMaintenamceType>>() {
              public void apply(final Collection<UIMaintenamceType> it) {
                getView().showResults(it);
                
                postInit.apply(MaintenamceTypeManagementPresenter.this);
              }
            };
          AsyncCallback<Collection<UIMaintenamceType>> _onSuccess = MaintenamceTypeManagementPresenter.this.<Collection<UIMaintenamceType>>onSuccess(_function);
          _service.loadAllMaintenamceType(_onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup4Readonly(final Procedure1<? super MaintenamceTypeManagementPresenter> postInit) {
    
    getView().setAsReadonly(true);
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<Collection<UIMaintenamceType>> _function = new Procedure1<Collection<UIMaintenamceType>>() {
              public void apply(final Collection<UIMaintenamceType> it) {
                getView().showResults(it);
                
                postInit.apply(MaintenamceTypeManagementPresenter.this);
              }
            };
          AsyncCallback<Collection<UIMaintenamceType>> _onSuccess = MaintenamceTypeManagementPresenter.this.<Collection<UIMaintenamceType>>onSuccess(_function);
          _service.loadAllMaintenamceType(_onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup4Selector(final IPresenterInitiazerNotifier<MaintenamceTypeManagementPresenter> _notifier) {
    getView().setAsSelector();
    
    getView().setAsReadonly(true);
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<Collection<UIMaintenamceType>> _function = new Procedure1<Collection<UIMaintenamceType>>() {
              public void apply(final Collection<UIMaintenamceType> it) {
                getView().showResults(it);
                _notifier.done(MaintenamceTypeManagementPresenter.this);
              }
            };
          AsyncCallback<Collection<UIMaintenamceType>> _onSuccess = MaintenamceTypeManagementPresenter.this.<Collection<UIMaintenamceType>>onSuccess(_function);
          _service.loadAllMaintenamceType(_onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void view_createRequestExecution(final RCMaintenamceTypeProxy parent) {
    
    CreateOrUpdateMaintenamceTypePresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateMaintenamceTypePresenter> _function = new Procedure1<CreateOrUpdateMaintenamceTypePresenter>() {
        public void apply(final CreateOrUpdateMaintenamceTypePresenter it) {
          final Procedure1<CreateOrUpdateMaintenamceTypePresenter> _function = new Procedure1<CreateOrUpdateMaintenamceTypePresenter>() {
              public void apply(final CreateOrUpdateMaintenamceTypePresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Create(parent, _function);
        }
      };
    ObjectExtensions.<CreateOrUpdateMaintenamceTypePresenter>operator_doubleArrow(_get, _function);
  }
  
  public void _eventbus_InputNextMaintenamceType(final RCMaintenamceTypeProxy parent) {
    
    CreateOrUpdateMaintenamceTypePresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateMaintenamceTypePresenter> _function = new Procedure1<CreateOrUpdateMaintenamceTypePresenter>() {
        public void apply(final CreateOrUpdateMaintenamceTypePresenter it) {
          final Procedure1<CreateOrUpdateMaintenamceTypePresenter> _function = new Procedure1<CreateOrUpdateMaintenamceTypePresenter>() {
              public void apply(final CreateOrUpdateMaintenamceTypePresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Create(parent, _function);
        }
      };
    ObjectExtensions.<CreateOrUpdateMaintenamceTypePresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_modifyRequestExecution(final RCMaintenamceTypeProxy value) {
    
    CreateOrUpdateMaintenamceTypePresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateMaintenamceTypePresenter> _function = new Procedure1<CreateOrUpdateMaintenamceTypePresenter>() {
        public void apply(final CreateOrUpdateMaintenamceTypePresenter it) {
          final Procedure1<CreateOrUpdateMaintenamceTypePresenter> _function = new Procedure1<CreateOrUpdateMaintenamceTypePresenter>() {
              public void apply(final CreateOrUpdateMaintenamceTypePresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Update(value, _function);
        }
      };
    ObjectExtensions.<CreateOrUpdateMaintenamceTypePresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_deleteRequestExecution(final RCMaintenamceTypeProxy value) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          eventBus.fireEvent(new com.fudanmed.platform.core.web.client.project.MaintenamceTypeDeletedEvent(value));
          
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.delete(value, _onSuccess);
  }
  
  public void _eventbus_MaintenamceTypeChanged(final RCMaintenamceTypeProxy org) {
    
    final Procedure1<UIMaintenamceType> _function = new Procedure1<UIMaintenamceType>() {
        public void apply(final UIMaintenamceType it) {
          getView().updateMaintenamceType(it);
          
        }
      };
    AsyncCallback<UIMaintenamceType> _onSuccess = this.<UIMaintenamceType>onSuccess(_function);
    _service.getValue(org, _onSuccess);
  }
  
  public void _eventbus_MaintenamceTypeDeleted(final RCMaintenamceTypeProxy org) {
    
    getView().deleteMaintenamceType(org);
    
  }
  
  public void _eventbus_MaintenamceTypeAdded(final RCMaintenamceTypeProxy org) {
    
    final Procedure1<UIMaintenamceType> _function = new Procedure1<UIMaintenamceType>() {
        public void apply(final UIMaintenamceType it) {
          getView().addMaintenamceType(it);
          
        }
      };
    AsyncCallback<UIMaintenamceType> _onSuccess = this.<UIMaintenamceType>onSuccess(_function);
    _service.getValue(org, _onSuccess);
  }
  
  public void view_typeSelectedExecution(final RCMaintenamceTypeProxy value) {
    
    this.parent = value;
    final Procedure1<Collection<UIFaultType>> _function = new Procedure1<Collection<UIFaultType>>() {
        public void apply(final Collection<UIFaultType> it) {
          getView().showItems(it);
          
        }
      };
    AsyncCallback<Collection<UIFaultType>> _onSuccess = this.<Collection<UIFaultType>>onSuccess(_function);
    _service.loadItems(value, _onSuccess);
  }
  
  public void view_createChildRequestExecution(final RCMaintenamceTypeProxy parent) {
    
    CreateOrUpdateFaultTypePresenter _get = this.createOrUpdateFaultTypePresenter.get();
    final Procedure1<CreateOrUpdateFaultTypePresenter> _function = new Procedure1<CreateOrUpdateFaultTypePresenter>() {
        public void apply(final CreateOrUpdateFaultTypePresenter it) {
          final Procedure1<CreateOrUpdateFaultTypePresenter> _function = new Procedure1<CreateOrUpdateFaultTypePresenter>() {
              public void apply(final CreateOrUpdateFaultTypePresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Create(parent, _function);
        }
      };
    ObjectExtensions.<CreateOrUpdateFaultTypePresenter>operator_doubleArrow(_get, _function);
  }
  
  public void _eventbus_InputNextFaultType(final RCMaintenamceTypeProxy parent) {
    
    CreateOrUpdateFaultTypePresenter _get = this.createOrUpdateFaultTypePresenter.get();
    final Procedure1<CreateOrUpdateFaultTypePresenter> _function = new Procedure1<CreateOrUpdateFaultTypePresenter>() {
        public void apply(final CreateOrUpdateFaultTypePresenter it) {
          final Procedure1<CreateOrUpdateFaultTypePresenter> _function = new Procedure1<CreateOrUpdateFaultTypePresenter>() {
              public void apply(final CreateOrUpdateFaultTypePresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Create(parent, _function);
        }
      };
    ObjectExtensions.<CreateOrUpdateFaultTypePresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_modifyChildRequestExecution(final RCFaultTypeProxy child) {
    
    CreateOrUpdateFaultTypePresenter _get = this.createOrUpdateFaultTypePresenter.get();
    final Procedure1<CreateOrUpdateFaultTypePresenter> _function = new Procedure1<CreateOrUpdateFaultTypePresenter>() {
        public void apply(final CreateOrUpdateFaultTypePresenter it) {
          final Procedure1<CreateOrUpdateFaultTypePresenter> _function = new Procedure1<CreateOrUpdateFaultTypePresenter>() {
              public void apply(final CreateOrUpdateFaultTypePresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Update(child, _function);
        }
      };
    ObjectExtensions.<CreateOrUpdateFaultTypePresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_deleteChildRequestExecution(final RCFaultTypeProxy child) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.project.FaultTypesChangedEvent());
          
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.deleteChild(child, _onSuccess);
  }
  
  public void _eventbus_FaultTypesChanged() {
    
    final Procedure1<Collection<UIFaultType>> _function = new Procedure1<Collection<UIFaultType>>() {
        public void apply(final Collection<UIFaultType> it) {
          getView().showItems(it);
          
        }
      };
    AsyncCallback<Collection<UIFaultType>> _onSuccess = this.<Collection<UIFaultType>>onSuccess(_function);
    _service.loadItems(this.parent, _onSuccess);
  }
  
  public ObjectSelectionProvider<UIFaultType> getSelectionProvider() {
    
    MaintenamceTypeManagementPresenterView _view = this.getView();
    ActionContext<UIFaultType> _actionContext = _view.getActionContext();
    return _actionContext;
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().createRequest(new RequestHandler1<RCMaintenamceTypeProxy>(){
    			
    			public void execute(RCMaintenamceTypeProxy parent){
    				view_createRequestExecution(parent);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.project.InputNextMaintenamceTypeEvent.__type__, new com.fudanmed.platform.core.web.client.project.InputNextMaintenamceTypeHandler(){
    public void InputNextMaintenamceType(com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy parent){
    	_eventbus_InputNextMaintenamceType(parent);
    }
    }));
    getView().modifyRequest(new RequestHandler1<RCMaintenamceTypeProxy>(){
    			
    			public void execute(RCMaintenamceTypeProxy value){
    				view_modifyRequestExecution(value);
    			}
    			
    		});
    getView().deleteRequest(new RequestHandler1<RCMaintenamceTypeProxy>(){
    			
    			public void execute(RCMaintenamceTypeProxy value){
    				view_deleteRequestExecution(value);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.project.MaintenamceTypeChangedEvent.__type__, new com.fudanmed.platform.core.web.client.project.MaintenamceTypeChangedHandler(){
    public void MaintenamceTypeChanged(com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy org){
    	_eventbus_MaintenamceTypeChanged(org);
    }
    }));
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.project.MaintenamceTypeDeletedEvent.__type__, new com.fudanmed.platform.core.web.client.project.MaintenamceTypeDeletedHandler(){
    public void MaintenamceTypeDeleted(com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy org){
    	_eventbus_MaintenamceTypeDeleted(org);
    }
    }));
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.project.MaintenamceTypeAddedEvent.__type__, new com.fudanmed.platform.core.web.client.project.MaintenamceTypeAddedHandler(){
    public void MaintenamceTypeAdded(com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy org){
    	_eventbus_MaintenamceTypeAdded(org);
    }
    }));
    getView().typeSelected(new RequestHandler1<RCMaintenamceTypeProxy>(){
    			
    			public void execute(RCMaintenamceTypeProxy value){
    				view_typeSelectedExecution(value);
    			}
    			
    		});
    getView().createChildRequest(new RequestHandler1<RCMaintenamceTypeProxy>(){
    			
    			public void execute(RCMaintenamceTypeProxy parent){
    				view_createChildRequestExecution(parent);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.project.InputNextFaultTypeEvent.__type__, new com.fudanmed.platform.core.web.client.project.InputNextFaultTypeHandler(){
    public void InputNextFaultType(com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy parent){
    	_eventbus_InputNextFaultType(parent);
    }
    }));
    getView().modifyChildRequest(new RequestHandler1<RCFaultTypeProxy>(){
    			
    			public void execute(RCFaultTypeProxy child){
    				view_modifyChildRequestExecution(child);
    			}
    			
    		});
    getView().deleteChildRequest(new RequestHandler1<RCFaultTypeProxy>(){
    			
    			public void execute(RCFaultTypeProxy child){
    				view_deleteChildRequestExecution(child);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.project.FaultTypesChangedEvent.__type__, new com.fudanmed.platform.core.web.client.project.FaultTypesChangedHandler(){
    public void FaultTypesChanged(){
    	_eventbus_FaultTypesChanged();
    }
    }));
    
  }
}
