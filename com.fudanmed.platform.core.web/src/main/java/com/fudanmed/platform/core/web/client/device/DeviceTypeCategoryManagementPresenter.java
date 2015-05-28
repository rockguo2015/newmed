package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdateDeviceTypeCategoryPresenter;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdateDeviceTypePresenter;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMDeviceTypeEntryPresenter;
import com.fudanmed.platform.core.web.client.device.DeviceTypeCategoryManagementPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.DeviceTypeCategoryManagementPresenterView;
import com.fudanmed.platform.core.web.client.device.DeviceTypeManagementPresenter;
import com.fudanmed.platform.core.web.shared.device.UIDeviceTypeCategory;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DeviceTypeCategoryManagementPresenter extends WorkbenchAbstractPresenter<DeviceTypeCategoryManagementPresenterView> {
  @Inject
  protected DeviceTypeCategoryManagementPresenterServiceAsync _service;
  
  @Inject
  public DeviceTypeCategoryManagementPresenter(final DeviceTypeCategoryManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private Provider<CreateOrUpdateDeviceTypeCategoryPresenter> createOrUpdatePresenter;
  
  @Inject
  private Provider<CreateOrUpdateDeviceTypePresenter> createOrUpdateDeviceTypePresenter;
  
  @Inject
  private Provider<CreateOrUpdatePMDeviceTypeEntryPresenter> createOrUpdatePMDeviceTypeEntryPresenter;
  
  public DeviceTypeManagementPresenter initPart(final DeviceTypeManagementPresenter part) {
    this.registerPart(part);
    this.getView().setDeviceTypeManagementPresenter(part);
    return part;
    
  }
  
  @Inject
  private DeviceTypeManagementPresenter deviceTypeManagementPresenter;
  
  private RCDeviceTypeCategoryProxy parent;
  
  public void setup(final Procedure1<? super DeviceTypeCategoryManagementPresenter> postInit) {
    
    getView().setAsReadonly(false);
    
    DeviceTypeManagementPresenter _initPart = this.initPart(this.deviceTypeManagementPresenter);
    final Procedure1<DeviceTypeManagementPresenter> _function = new Procedure1<DeviceTypeManagementPresenter>() {
        public void apply(final DeviceTypeManagementPresenter it) {
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {
                DeviceTypeCategoryManagementPresenterView _view = DeviceTypeCategoryManagementPresenter.this.getView();
                ActionContext<UIDeviceTypeCategory> _actionContext = _view.getActionContext();
                DeviceTypeCategoryManagementPresenter.this.deviceTypeManagementPresenter.setTypeCategoryActionContext(_actionContext);
                final Procedure1<Collection<UIDeviceTypeCategory>> _function = new Procedure1<Collection<UIDeviceTypeCategory>>() {
                    public void apply(final Collection<UIDeviceTypeCategory> it) {
                      getView().showResults(it);
                      
                      postInit.apply(DeviceTypeCategoryManagementPresenter.this);
                    }
                  };
                AsyncCallback<Collection<UIDeviceTypeCategory>> _onSuccess = DeviceTypeCategoryManagementPresenter.this.<Collection<UIDeviceTypeCategory>>onSuccess(_function);
                _service.loadAllDeviceTypeCategory(_onSuccess);
              }
            };
          DeviceTypeCategoryManagementPresenter.this.activate(new IPostInitializeAction() {
              public void initializeFinished(Void v) {
                _function.apply(v);
              }
          });
        }
      };
    _initPart.setup(new IPresenterInitiazerNotifier<DeviceTypeManagementPresenter>() {
        public void done(DeviceTypeManagementPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  public void setup4Readonly(final Procedure1<? super DeviceTypeCategoryManagementPresenter> postInit) {
    
    getView().setAsReadonly(true);
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<Collection<UIDeviceTypeCategory>> _function = new Procedure1<Collection<UIDeviceTypeCategory>>() {
              public void apply(final Collection<UIDeviceTypeCategory> it) {
                getView().showResults(it);
                
                postInit.apply(DeviceTypeCategoryManagementPresenter.this);
              }
            };
          AsyncCallback<Collection<UIDeviceTypeCategory>> _onSuccess = DeviceTypeCategoryManagementPresenter.this.<Collection<UIDeviceTypeCategory>>onSuccess(_function);
          _service.loadAllDeviceTypeCategory(_onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void view_createRequestExecution(final RCDeviceTypeCategoryProxy parent) {
    
    CreateOrUpdateDeviceTypeCategoryPresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateDeviceTypeCategoryPresenter> _function = new Procedure1<CreateOrUpdateDeviceTypeCategoryPresenter>() {
        public void apply(final CreateOrUpdateDeviceTypeCategoryPresenter it) {
          final Procedure1<CreateOrUpdateDeviceTypeCategoryPresenter> _function = new Procedure1<CreateOrUpdateDeviceTypeCategoryPresenter>() {
              public void apply(final CreateOrUpdateDeviceTypeCategoryPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Create(parent, new IPresenterInitiazerNotifier<CreateOrUpdateDeviceTypeCategoryPresenter>() {
              public void done(CreateOrUpdateDeviceTypeCategoryPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    ObjectExtensions.<CreateOrUpdateDeviceTypeCategoryPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_modifyRequestExecution(final RCDeviceTypeCategoryProxy value) {
    
    CreateOrUpdateDeviceTypeCategoryPresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateDeviceTypeCategoryPresenter> _function = new Procedure1<CreateOrUpdateDeviceTypeCategoryPresenter>() {
        public void apply(final CreateOrUpdateDeviceTypeCategoryPresenter it) {
          final Procedure1<CreateOrUpdateDeviceTypeCategoryPresenter> _function = new Procedure1<CreateOrUpdateDeviceTypeCategoryPresenter>() {
              public void apply(final CreateOrUpdateDeviceTypeCategoryPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Update(value, new IPresenterInitiazerNotifier<CreateOrUpdateDeviceTypeCategoryPresenter>() {
              public void done(CreateOrUpdateDeviceTypeCategoryPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    ObjectExtensions.<CreateOrUpdateDeviceTypeCategoryPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_deleteRequestExecution(final RCDeviceTypeCategoryProxy value) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.DeviceTypeCategoryDeletedEvent(value));
          
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.delete(value, _onSuccess);
  }
  
  public void _eventbus_DeviceTypeCategoryChanged(final RCDeviceTypeCategoryProxy org) {
    
    final Procedure1<UIDeviceTypeCategory> _function = new Procedure1<UIDeviceTypeCategory>() {
        public void apply(final UIDeviceTypeCategory it) {
          getView().updateDeviceTypeCategory(it);
          
        }
      };
    AsyncCallback<UIDeviceTypeCategory> _onSuccess = this.<UIDeviceTypeCategory>onSuccess(_function);
    _service.getValue(org, _onSuccess);
  }
  
  public void _eventbus_DeviceTypeCategoryDeleted(final RCDeviceTypeCategoryProxy org) {
    
    getView().deleteDeviceTypeCategory(org);
    
  }
  
  public void _eventbus_DeviceTypeCategoryAdded(final RCDeviceTypeCategoryProxy org) {
    
    final Procedure1<UIDeviceTypeCategory> _function = new Procedure1<UIDeviceTypeCategory>() {
        public void apply(final UIDeviceTypeCategory it) {
          getView().addDeviceTypeCategory(it);
          
        }
      };
    AsyncCallback<UIDeviceTypeCategory> _onSuccess = this.<UIDeviceTypeCategory>onSuccess(_function);
    _service.getValue(org, _onSuccess);
  }
  
  public void view_typeSelectedExecution(final RCDeviceTypeCategoryProxy value) {
    
    this.parent = value;
    this.deviceTypeManagementPresenter.selectCategory(this.parent);
  }
  
  public void _eventbus_DeviceTypesChanged() {
    
    this.deviceTypeManagementPresenter.selectCategory(this.parent);
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().createRequest(new RequestHandler1<RCDeviceTypeCategoryProxy>(){
    			
    			public void execute(RCDeviceTypeCategoryProxy parent){
    				view_createRequestExecution(parent);
    			}
    			
    		});
    getView().modifyRequest(new RequestHandler1<RCDeviceTypeCategoryProxy>(){
    			
    			public void execute(RCDeviceTypeCategoryProxy value){
    				view_modifyRequestExecution(value);
    			}
    			
    		});
    getView().deleteRequest(new RequestHandler1<RCDeviceTypeCategoryProxy>(){
    			
    			public void execute(RCDeviceTypeCategoryProxy value){
    				view_deleteRequestExecution(value);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.device.DeviceTypeCategoryChangedEvent.__type__, new com.fudanmed.platform.core.web.client.device.DeviceTypeCategoryChangedHandler(){
    public void DeviceTypeCategoryChanged(com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy org){
    	_eventbus_DeviceTypeCategoryChanged(org);
    }
    }));
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.device.DeviceTypeCategoryDeletedEvent.__type__, new com.fudanmed.platform.core.web.client.device.DeviceTypeCategoryDeletedHandler(){
    public void DeviceTypeCategoryDeleted(com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy org){
    	_eventbus_DeviceTypeCategoryDeleted(org);
    }
    }));
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.device.DeviceTypeCategoryAddedEvent.__type__, new com.fudanmed.platform.core.web.client.device.DeviceTypeCategoryAddedHandler(){
    public void DeviceTypeCategoryAdded(com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy org){
    	_eventbus_DeviceTypeCategoryAdded(org);
    }
    }));
    getView().typeSelected(new RequestHandler1<RCDeviceTypeCategoryProxy>(){
    			
    			public void execute(RCDeviceTypeCategoryProxy value){
    				view_typeSelectedExecution(value);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.device.DeviceTypesChangedEvent.__type__, new com.fudanmed.platform.core.web.client.device.DeviceTypesChangedHandler(){
    public void DeviceTypesChanged(){
    	_eventbus_DeviceTypesChanged();
    }
    }));
    
  }
}
