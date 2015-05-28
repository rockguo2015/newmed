package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.device.proxy.DeviceFileContainerProxy;
import com.fudanmed.platform.core.device.proxy.DevicePictureContainerProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.entityextension.proxy.RCExtensiableEntityProxy;
import com.fudanmed.platform.core.web.client.device.AttributeSlotTreeListPresenter;
import com.fudanmed.platform.core.web.client.device.CreateCompositeTypePresenter;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdateDevicePresenter;
import com.fudanmed.platform.core.web.client.device.CreatePrimaryTypePresenter;
import com.fudanmed.platform.core.web.client.device.DeviceCategoryAndTypeListPresenter;
import com.fudanmed.platform.core.web.client.device.DeviceManagementPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.DeviceManagementPresenterView;
import com.fudanmed.platform.core.web.client.device.DevicePMPlanAssignmentListPresenter;
import com.fudanmed.platform.core.web.client.device.DevicePMPlanList4DevicePresenter;
import com.fudanmed.platform.core.web.client.device.DevicePropertyPresenter;
import com.fudanmed.platform.core.web.client.device.DocumentStorageListPresenter;
import com.fudanmed.platform.core.web.client.device.PMWorkItemEvaluatePropertyViewPresenter;
import com.fudanmed.platform.core.web.client.device.PMWorkItemPropertyPresenter;
import com.fudanmed.platform.core.web.client.device.PictureListPresenter;
import com.fudanmed.platform.core.web.client.organization.OnsiteLocationOutlinePresenter;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.fudanmed.platform.core.web.shared.device.UIDeviceCriteria;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DeviceManagementPresenter extends WorkbenchAbstractPresenter<DeviceManagementPresenterView> {
  @Inject
  protected DeviceManagementPresenterServiceAsync _service;
  
  @Inject
  public DeviceManagementPresenter(final DeviceManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private Provider<CreateOrUpdateDevicePresenter> createOrUpdatePresenter;
  
  @Inject
  private Provider<CreatePrimaryTypePresenter> createPrimaryTypePresenter;
  
  @Inject
  private Provider<CreateCompositeTypePresenter> createCompositeTypePresenter;
  
  @Inject
  private Provider<PMWorkItemEvaluatePropertyViewPresenter> workItemEvaluatePropertyViewPresenter;
  
  @Inject
  private Provider<PMWorkItemPropertyPresenter> workItemPropertyPresenter;
  
  public AttributeSlotTreeListPresenter initPart(final AttributeSlotTreeListPresenter part) {
    this.registerPart(part);
    this.getView().setAttributeSlotTreeListPresenter(part);
    return part;
    
  }
  
  @Inject
  private AttributeSlotTreeListPresenter attributeSlotTreeListPresenter;
  
  public DevicePropertyPresenter initPart(final DevicePropertyPresenter part) {
    this.registerPart(part);
    this.getView().setDevicePropertyPresenter(part);
    return part;
    
  }
  
  @Inject
  private DevicePropertyPresenter devicePropertyPresenter;
  
  public DevicePMPlanList4DevicePresenter initPart(final DevicePMPlanList4DevicePresenter part) {
    this.registerPart(part);
    this.getView().setDevicePMPlanList4DevicePresenter(part);
    return part;
    
  }
  
  @Inject
  private DevicePMPlanList4DevicePresenter devicePMPlanList4DevicePresenter;
  
  public DocumentStorageListPresenter initPart(final DocumentStorageListPresenter part) {
    this.registerPart(part);
    this.getView().setDeviceDocumentStorageListPresenter(part);
    return part;
    
  }
  
  @Inject
  private DocumentStorageListPresenter deviceDocumentStorageListPresenter;
  
  public PictureListPresenter initPart(final PictureListPresenter part) {
    this.registerPart(part);
    this.getView().setDevicepictureListPresenter(part);
    return part;
    
  }
  
  @Inject
  private PictureListPresenter devicepictureListPresenter;
  
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
  
  public DevicePMPlanAssignmentListPresenter initPart(final DevicePMPlanAssignmentListPresenter part) {
    this.registerPart(part);
    this.getView().setDevicePMPlanAssignmentListPresenter(part);
    return part;
    
  }
  
  @Inject
  private DevicePMPlanAssignmentListPresenter devicePMPlanAssignmentListPresenter;
  
  public void setup(final IPresenterInitiazerNotifier<DeviceManagementPresenter> _notifier) {
    
    AttributeSlotTreeListPresenter _initPart = this.initPart(this.attributeSlotTreeListPresenter);
    final Procedure1<AttributeSlotTreeListPresenter> _function = new Procedure1<AttributeSlotTreeListPresenter>() {
        public void apply(final AttributeSlotTreeListPresenter it) {
          DevicePropertyPresenter _initPart = DeviceManagementPresenter.this.initPart(DeviceManagementPresenter.this.devicePropertyPresenter);
          final Procedure1<DevicePropertyPresenter> _function = new Procedure1<DevicePropertyPresenter>() {
              public void apply(final DevicePropertyPresenter it) {
                DevicePMPlanList4DevicePresenter _initPart = DeviceManagementPresenter.this.initPart(DeviceManagementPresenter.this.devicePMPlanList4DevicePresenter);
                final Procedure1<DevicePMPlanList4DevicePresenter> _function = new Procedure1<DevicePMPlanList4DevicePresenter>() {
                    public void apply(final DevicePMPlanList4DevicePresenter it) {
                      DocumentStorageListPresenter _initPart = DeviceManagementPresenter.this.initPart(DeviceManagementPresenter.this.deviceDocumentStorageListPresenter);
                      final Procedure1<DocumentStorageListPresenter> _function = new Procedure1<DocumentStorageListPresenter>() {
                          public void apply(final DocumentStorageListPresenter it) {
                            PictureListPresenter _initPart = DeviceManagementPresenter.this.initPart(DeviceManagementPresenter.this.devicepictureListPresenter);
                            final Procedure1<PictureListPresenter> _function = new Procedure1<PictureListPresenter>() {
                                public void apply(final PictureListPresenter it) {
                                  OnsiteLocationOutlinePresenter _initPart = DeviceManagementPresenter.this.initPart(DeviceManagementPresenter.this.onsiteLocationOutlinePresenter);
                                  final Procedure1<OnsiteLocationOutlinePresenter> _function = new Procedure1<OnsiteLocationOutlinePresenter>() {
                                      public void apply(final OnsiteLocationOutlinePresenter it) {
                                        DeviceCategoryAndTypeListPresenter _initPart = DeviceManagementPresenter.this.initPart(DeviceManagementPresenter.this.deviceCategoryAndTypeListPresenter);
                                        final Procedure1<DeviceCategoryAndTypeListPresenter> _function = new Procedure1<DeviceCategoryAndTypeListPresenter>() {
                                            public void apply(final DeviceCategoryAndTypeListPresenter it) {
                                              DevicePMPlanAssignmentListPresenter _initPart = DeviceManagementPresenter.this.initPart(DeviceManagementPresenter.this.devicePMPlanAssignmentListPresenter);
                                              final Procedure1<DevicePMPlanAssignmentListPresenter> _function = new Procedure1<DevicePMPlanAssignmentListPresenter>() {
                                                  public void apply(final DevicePMPlanAssignmentListPresenter it) {
                                                    final Procedure1<Void> _function = new Procedure1<Void>() {
                                                        public void apply(final Void it) {_notifier.done(DeviceManagementPresenter.this);
                                                        }
                                                      };
                                                    DeviceManagementPresenter.this.activate(new IPostInitializeAction() {
                                                        public void initializeFinished(Void v) {
                                                          _function.apply(v);
                                                        }
                                                    });
                                                  }
                                                };
                                              _initPart.setup(new IPresenterInitiazerNotifier<DevicePMPlanAssignmentListPresenter>() {
                                                  public void done(DevicePMPlanAssignmentListPresenter presenter) {
                                                    _function.apply(presenter);
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
                            _initPart.setup(new IPresenterInitiazerNotifier<PictureListPresenter>() {
                                public void done(PictureListPresenter presenter) {
                                  _function.apply(presenter);
                                }
                            });
                          }
                        };
                      _initPart.setup(new IPresenterInitiazerNotifier<DocumentStorageListPresenter>() {
                          public void done(DocumentStorageListPresenter presenter) {
                            _function.apply(presenter);
                          }
                      });
                    }
                  };
                _initPart.setup(new IPresenterInitiazerNotifier<DevicePMPlanList4DevicePresenter>() {
                    public void done(DevicePMPlanList4DevicePresenter presenter) {
                      _function.apply(presenter);
                    }
                });
              }
            };
          _initPart.setup(new IPresenterInitiazerNotifier<DevicePropertyPresenter>() {
              public void done(DevicePropertyPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    _initPart.setup(new IPresenterInitiazerNotifier<AttributeSlotTreeListPresenter>() {
        public void done(AttributeSlotTreeListPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  public void view_createRequestExecution() {
    
    DeviceManagementPresenterView _view = this.getView();
    final RCDeviceTypeProxy deviceType = _view.getSelectedDeviceType();
    DeviceManagementPresenterView _view_1 = this.getView();
    final UIOnsitePosition location = _view_1.getSelectedLocation();
    CreateOrUpdateDevicePresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateDevicePresenter> _function = new Procedure1<CreateOrUpdateDevicePresenter>() {
        public void apply(final CreateOrUpdateDevicePresenter it) {
          final Procedure1<CreateOrUpdateDevicePresenter> _function = new Procedure1<CreateOrUpdateDevicePresenter>() {
              public void apply(final CreateOrUpdateDevicePresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Create(deviceType, location, new IPresenterInitiazerNotifier<CreateOrUpdateDevicePresenter>() {
              public void done(CreateOrUpdateDevicePresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    ObjectExtensions.<CreateOrUpdateDevicePresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_duplicateRequestExecution(final RCDeviceProxy value) {
    
    CreateOrUpdateDevicePresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateDevicePresenter> _function = new Procedure1<CreateOrUpdateDevicePresenter>() {
        public void apply(final CreateOrUpdateDevicePresenter it) {
          final Procedure1<CreateOrUpdateDevicePresenter> _function = new Procedure1<CreateOrUpdateDevicePresenter>() {
              public void apply(final CreateOrUpdateDevicePresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Dupicate(value, new IPresenterInitiazerNotifier<CreateOrUpdateDevicePresenter>() {
              public void done(CreateOrUpdateDevicePresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    ObjectExtensions.<CreateOrUpdateDevicePresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_modifyRequestExecution(final RCDeviceProxy value) {
    
    CreateOrUpdateDevicePresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateDevicePresenter> _function = new Procedure1<CreateOrUpdateDevicePresenter>() {
        public void apply(final CreateOrUpdateDevicePresenter it) {
          final Procedure1<CreateOrUpdateDevicePresenter> _function = new Procedure1<CreateOrUpdateDevicePresenter>() {
              public void apply(final CreateOrUpdateDevicePresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Update(value, new IPresenterInitiazerNotifier<CreateOrUpdateDevicePresenter>() {
              public void done(CreateOrUpdateDevicePresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    ObjectExtensions.<CreateOrUpdateDevicePresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_showPMEvaluateInfoExecution(final RCPMWorkItemProxy value) {
    
    PMWorkItemEvaluatePropertyViewPresenter _get = this.workItemEvaluatePropertyViewPresenter.get();
    final Procedure1<PMWorkItemEvaluatePropertyViewPresenter> _function = new Procedure1<PMWorkItemEvaluatePropertyViewPresenter>() {
        public void apply(final PMWorkItemEvaluatePropertyViewPresenter it) {
          final Procedure1<PMWorkItemEvaluatePropertyViewPresenter> _function = new Procedure1<PMWorkItemEvaluatePropertyViewPresenter>() {
              public void apply(final PMWorkItemEvaluatePropertyViewPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
                it.setPMWorkItem(value);
              }
            };
          it.setup(new IPresenterInitiazerNotifier<PMWorkItemEvaluatePropertyViewPresenter>() {
              public void done(PMWorkItemEvaluatePropertyViewPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    ObjectExtensions.<PMWorkItemEvaluatePropertyViewPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_showPMWorkItemInfoExecution(final RCPMWorkItemProxy value) {
    
    PMWorkItemPropertyPresenter _get = this.workItemPropertyPresenter.get();
    final Procedure1<PMWorkItemPropertyPresenter> _function = new Procedure1<PMWorkItemPropertyPresenter>() {
        public void apply(final PMWorkItemPropertyPresenter it) {
          final Procedure1<PMWorkItemPropertyPresenter> _function = new Procedure1<PMWorkItemPropertyPresenter>() {
              public void apply(final PMWorkItemPropertyPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
                it.setValue(value);
              }
            };
          it.setup(new IPresenterInitiazerNotifier<PMWorkItemPropertyPresenter>() {
              public void done(PMWorkItemPropertyPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    ObjectExtensions.<PMWorkItemPropertyPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_deleteRequestExecution(final RCDeviceProxy value) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.DevicesChangedEvent());
          
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.delete(value, _onSuccess);
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
  
  public void view_deviceSelectedExecution(final RCDeviceProxy value) {
    
    final Procedure1<RCExtensiableEntityProxy> _function = new Procedure1<RCExtensiableEntityProxy>() {
        public void apply(final RCExtensiableEntityProxy it) {
          DeviceManagementPresenter.this.attributeSlotTreeListPresenter.setExtensiableEntity(it);
        }
      };
    AsyncCallback<RCExtensiableEntityProxy> _onSuccess = this.<RCExtensiableEntityProxy>onSuccess(_function);
    _service.loadEntityExtension(value, _onSuccess);
    this.devicePropertyPresenter.setDevice(value);
    this.devicePMPlanList4DevicePresenter.setDevice(value);
    this.devicePMPlanAssignmentListPresenter.setDevice(value);
    DeviceFileContainerProxy _deviceFileContainerProxy = new DeviceFileContainerProxy(value);
    this.deviceDocumentStorageListPresenter.setDevice(_deviceFileContainerProxy);
    DevicePictureContainerProxy _devicePictureContainerProxy = new DevicePictureContainerProxy(value);
    this.devicepictureListPresenter.setDevice(_devicePictureContainerProxy);
  }
  
  public void _eventbus_DevicesChanged() {
    getView().refresh();
    
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().createRequest(new RequestHandler(){
    			
    			public void execute(){
    				view_createRequestExecution();
    			}
    			
    		});
    getView().duplicateRequest(new RequestHandler1<RCDeviceProxy>(){
    			
    			public void execute(RCDeviceProxy value){
    				view_duplicateRequestExecution(value);
    			}
    			
    		});
    getView().modifyRequest(new RequestHandler1<RCDeviceProxy>(){
    			
    			public void execute(RCDeviceProxy value){
    				view_modifyRequestExecution(value);
    			}
    			
    		});
    getView().showPMEvaluateInfo(new RequestHandler1<RCPMWorkItemProxy>(){
    			
    			public void execute(RCPMWorkItemProxy value){
    				view_showPMEvaluateInfoExecution(value);
    			}
    			
    		});
    getView().showPMWorkItemInfo(new RequestHandler1<RCPMWorkItemProxy>(){
    			
    			public void execute(RCPMWorkItemProxy value){
    				view_showPMWorkItemInfoExecution(value);
    			}
    			
    		});
    getView().deleteRequest(new RequestHandler1<RCDeviceProxy>(){
    			
    			public void execute(RCDeviceProxy value){
    				view_deleteRequestExecution(value);
    			}
    			
    		});
    getView().filterRequest(new RequestHandler1<UIDeviceCriteria>(){
    			
    			public void execute(UIDeviceCriteria c){
    				view_filterRequestExecution(c);
    			}
    			
    		});
    getView().deviceSelected(new RequestHandler1<RCDeviceProxy>(){
    			
    			public void execute(RCDeviceProxy value){
    				view_deviceSelectedExecution(value);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.device.DevicesChangedEvent.__type__, new com.fudanmed.platform.core.web.client.device.DevicesChangedHandler(){
    public void DevicesChanged(){
    	_eventbus_DevicesChanged();
    }
    }));
    
  }
}
