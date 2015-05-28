package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMSpecificationProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdateDevicePMSpecificationPresenter;
import com.fudanmed.platform.core.web.client.device.DeviceCategoryAndTypeListPresenter;
import com.fudanmed.platform.core.web.client.device.DevicePMPlanListPresenter;
import com.fudanmed.platform.core.web.client.device.DevicePMSpecificationListPresenter;
import com.fudanmed.platform.core.web.client.device.DevicePMSpecificationManagementPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.DevicePMSpecificationManagementPresenterView;
import com.fudanmed.platform.core.web.client.device.InitializePMPlanPresenter;
import com.fudanmed.platform.core.web.client.organization.OnsiteLocationOutlinePresenter;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.fudanmed.platform.core.web.shared.device.UIDeviceCriteria;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DevicePMSpecificationManagementPresenter extends WorkbenchAbstractPresenter<DevicePMSpecificationManagementPresenterView> {
  @Inject
  protected DevicePMSpecificationManagementPresenterServiceAsync _service;
  
  @Inject
  public DevicePMSpecificationManagementPresenter(final DevicePMSpecificationManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private Provider<CreateOrUpdateDevicePMSpecificationPresenter> createOrUpdatePresenter;
  
  @Inject
  private Provider<InitializePMPlanPresenter> initializePMPlanPresenter;
  
  public OnsiteLocationOutlinePresenter initPart(final OnsiteLocationOutlinePresenter part) {
    this.registerPart(part);
    this.getView().setOnsiteLocationOutlinePresenter(part);
    return part;
    
  }
  
  @Inject
  private OnsiteLocationOutlinePresenter onsiteLocationOutlinePresenter;
  
  public DeviceCategoryAndTypeListPresenter initPart(final DeviceCategoryAndTypeListPresenter part) {
    this.registerPart(part);
    this.getView().setDeviceCategoryAndTypeListPresenter(part);
    return part;
    
  }
  
  @Inject
  private DeviceCategoryAndTypeListPresenter deviceCategoryAndTypeListPresenter;
  
  public DevicePMPlanListPresenter initPart(final DevicePMPlanListPresenter part) {
    this.registerPart(part);
    this.getView().setDevicePMPlanListPresenter(part);
    return part;
    
  }
  
  @Inject
  private DevicePMPlanListPresenter devicePMPlanListPresenter;
  
  public DevicePMSpecificationListPresenter initPart(final DevicePMSpecificationListPresenter part) {
    this.registerPart(part);
    this.getView().setDevicePMSpecificationListPresenter(part);
    return part;
    
  }
  
  @Inject
  private DevicePMSpecificationListPresenter devicePMSpecificationListPresenter;
  
  public void setup(final IPresenterInitiazerNotifier<DevicePMSpecificationManagementPresenter> _notifier) {
    
    DevicePMPlanListPresenter _initPart = this.initPart(this.devicePMPlanListPresenter);
    final Procedure1<DevicePMPlanListPresenter> _function = new Procedure1<DevicePMPlanListPresenter>() {
        public void apply(final DevicePMPlanListPresenter it) {
          DevicePMSpecificationListPresenter _initPart = DevicePMSpecificationManagementPresenter.this.initPart(DevicePMSpecificationManagementPresenter.this.devicePMSpecificationListPresenter);
          final Procedure1<DevicePMSpecificationListPresenter> _function = new Procedure1<DevicePMSpecificationListPresenter>() {
              public void apply(final DevicePMSpecificationListPresenter it) {
                OnsiteLocationOutlinePresenter _initPart = DevicePMSpecificationManagementPresenter.this.initPart(DevicePMSpecificationManagementPresenter.this.onsiteLocationOutlinePresenter);
                final Procedure1<OnsiteLocationOutlinePresenter> _function = new Procedure1<OnsiteLocationOutlinePresenter>() {
                    public void apply(final OnsiteLocationOutlinePresenter it) {
                      DeviceCategoryAndTypeListPresenter _initPart = DevicePMSpecificationManagementPresenter.this.initPart(DevicePMSpecificationManagementPresenter.this.deviceCategoryAndTypeListPresenter);
                      final Procedure1<DeviceCategoryAndTypeListPresenter> _function = new Procedure1<DeviceCategoryAndTypeListPresenter>() {
                          public void apply(final DeviceCategoryAndTypeListPresenter it) {
                            final Procedure1<Void> _function = new Procedure1<Void>() {
                                public void apply(final Void it) {getView().refresh();
                                  _notifier.done(DevicePMSpecificationManagementPresenter.this);
                                }
                              };
                            DevicePMSpecificationManagementPresenter.this.activate(new IPostInitializeAction() {
                                public void initializeFinished(Void v) {
                                  _function.apply(v);
                                }
                            });
                          }
                        };
                      _initPart.setup(new IPresenterInitiazerNotifier<DeviceCategoryAndTypeListPresenter>() {
                          public void done(DeviceCategoryAndTypeListPresenter presenter) {
                            _function.apply(presenter);
                          }
                      });
                    }
                  };
                _initPart.setupAsSimpleTree(_function);
              }
            };
          _initPart.setup(new IPresenterInitiazerNotifier<DevicePMSpecificationListPresenter>() {
              public void done(DevicePMSpecificationListPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    _initPart.setup(new IPresenterInitiazerNotifier<DevicePMPlanListPresenter>() {
        public void done(DevicePMPlanListPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  public void view_createRequestExecution(final RCDeviceProxy device) {
    
    CreateOrUpdateDevicePMSpecificationPresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateDevicePMSpecificationPresenter> _function = new Procedure1<CreateOrUpdateDevicePMSpecificationPresenter>() {
        public void apply(final CreateOrUpdateDevicePMSpecificationPresenter it) {
          final Procedure1<CreateOrUpdateDevicePMSpecificationPresenter> _function = new Procedure1<CreateOrUpdateDevicePMSpecificationPresenter>() {
              public void apply(final CreateOrUpdateDevicePMSpecificationPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Create(device, new IPresenterInitiazerNotifier<CreateOrUpdateDevicePMSpecificationPresenter>() {
              public void done(CreateOrUpdateDevicePMSpecificationPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    ObjectExtensions.<CreateOrUpdateDevicePMSpecificationPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_modifyRequestExecution(final RCDevicePMSpecificationProxy value) {
    
    CreateOrUpdateDevicePMSpecificationPresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateDevicePMSpecificationPresenter> _function = new Procedure1<CreateOrUpdateDevicePMSpecificationPresenter>() {
        public void apply(final CreateOrUpdateDevicePMSpecificationPresenter it) {
          final Procedure1<CreateOrUpdateDevicePMSpecificationPresenter> _function = new Procedure1<CreateOrUpdateDevicePMSpecificationPresenter>() {
              public void apply(final CreateOrUpdateDevicePMSpecificationPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Update(value, new IPresenterInitiazerNotifier<CreateOrUpdateDevicePMSpecificationPresenter>() {
              public void done(CreateOrUpdateDevicePMSpecificationPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    ObjectExtensions.<CreateOrUpdateDevicePMSpecificationPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_deviceSelectedExecution(final RCDeviceProxy value) {
    
    this.devicePMPlanListPresenter.setDevice(value);
    this.devicePMSpecificationListPresenter.setDevice(value);
  }
  
  public void view_deleteRequestExecution(final RCDevicePMSpecificationProxy value) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.DevicePMSpecificationsChangedEvent());
          
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.delete(value, _onSuccess);
  }
  
  public void view_initPM4DeviceRequestExecution(final RCDevicePMSpecificationProxy value) {
    
    InitializePMPlanPresenter _get = this.initializePMPlanPresenter.get();
    final Procedure1<InitializePMPlanPresenter> _function = new Procedure1<InitializePMPlanPresenter>() {
        public void apply(final InitializePMPlanPresenter it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
          
        }
      };
    _get.setup4SingleDevice(value, new IPresenterInitiazerNotifier<InitializePMPlanPresenter>() {
        public void done(InitializePMPlanPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  public void view_filterRequestExecution(final UIDeviceCriteria c) {
    
    final Procedure1<IPagedResult<UIDevice>> _function = new Procedure1<IPagedResult<UIDevice>>() {
        public void apply(final IPagedResult<UIDevice> it) {
          getView().showResults(it);
          
        }
      };
    AsyncCallback<IPagedResult<UIDevice>> _onSuccess = this.<IPagedResult<UIDevice>>onSuccess(_function);
    _service.filter(c, _onSuccess);
  }
  
  public void _eventbus_DevicePMSpecificationsChanged() {
    getView().refresh();
    
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().createRequest(new RequestHandler1<RCDeviceProxy>(){
    			
    			public void execute(RCDeviceProxy device){
    				view_createRequestExecution(device);
    			}
    			
    		});
    getView().modifyRequest(new RequestHandler1<RCDevicePMSpecificationProxy>(){
    			
    			public void execute(RCDevicePMSpecificationProxy value){
    				view_modifyRequestExecution(value);
    			}
    			
    		});
    getView().deviceSelected(new RequestHandler1<RCDeviceProxy>(){
    			
    			public void execute(RCDeviceProxy value){
    				view_deviceSelectedExecution(value);
    			}
    			
    		});
    getView().deleteRequest(new RequestHandler1<RCDevicePMSpecificationProxy>(){
    			
    			public void execute(RCDevicePMSpecificationProxy value){
    				view_deleteRequestExecution(value);
    			}
    			
    		});
    getView().initPM4DeviceRequest(new RequestHandler1<RCDevicePMSpecificationProxy>(){
    			
    			public void execute(RCDevicePMSpecificationProxy value){
    				view_initPM4DeviceRequestExecution(value);
    			}
    			
    		});
    getView().filterRequest(new RequestHandler1<UIDeviceCriteria>(){
    			
    			public void execute(UIDeviceCriteria c){
    				view_filterRequestExecution(c);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.device.DevicePMSpecificationsChangedEvent.__type__, new com.fudanmed.platform.core.web.client.device.DevicePMSpecificationsChangedHandler(){
    public void DevicePMSpecificationsChanged(){
    	_eventbus_DevicePMSpecificationsChanged();
    }
    }));
    
  }
}
