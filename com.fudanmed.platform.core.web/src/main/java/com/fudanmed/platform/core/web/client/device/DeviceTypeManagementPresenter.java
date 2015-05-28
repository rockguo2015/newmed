package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.DeviceTypeFileContainerProxy;
import com.fudanmed.platform.core.device.proxy.DeviceTypePictureContainerProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy;
import com.fudanmed.platform.core.entityextension.proxy.RCExtensiableEntityProxy;
import com.fudanmed.platform.core.web.client.device.AttributeSlotEditPresenter;
import com.fudanmed.platform.core.web.client.device.AttributeSlotTreeListPresenter;
import com.fudanmed.platform.core.web.client.device.CreateCompositeTypePresenter;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdateDeviceTypePresenter;
import com.fudanmed.platform.core.web.client.device.CreatePrimaryTypePresenter;
import com.fudanmed.platform.core.web.client.device.DeviceTypeManagementPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.DeviceTypeManagementPresenterView;
import com.fudanmed.platform.core.web.client.device.DocumentStorageListPresenter;
import com.fudanmed.platform.core.web.client.device.PMDefaultIntervalAssociationListPresenter;
import com.fudanmed.platform.core.web.client.device.PartTypeListPresenter;
import com.fudanmed.platform.core.web.client.device.PictureListPresenter;
import com.fudanmed.platform.core.web.shared.device.UIDeviceType;
import com.fudanmed.platform.core.web.shared.device.UIDeviceTypeCategory;
import com.fudanmed.platform.core.web.shared.device.UIDeviceTypeCriteria;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.sencha.gxt.widget.core.client.info.Info;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DeviceTypeManagementPresenter extends WorkbenchAbstractPresenter<DeviceTypeManagementPresenterView> {
  @Inject
  protected DeviceTypeManagementPresenterServiceAsync _service;
  
  @Inject
  public DeviceTypeManagementPresenter(final DeviceTypeManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private Provider<CreateOrUpdateDeviceTypePresenter> createOrUpdatePresenter;
  
  @Inject
  private Provider<CreatePrimaryTypePresenter> createPrimaryTypePresenter;
  
  @Inject
  private Provider<CreateCompositeTypePresenter> createCompositeTypePresenter;
  
  @Inject
  private Provider<CreateOrUpdateDeviceTypePresenter> createOrUpdateDeviceTypePresenter;
  
  @Inject
  private Provider<AttributeSlotEditPresenter> attributeSlotEditPresenter;
  
  public PartTypeListPresenter initPart(final PartTypeListPresenter part) {
    this.registerPart(part);
    this.getView().setPartTypeListPresenter(part);
    return part;
    
  }
  
  @Inject
  private PartTypeListPresenter partTypeListPresenter;
  
  public AttributeSlotTreeListPresenter initPart(final AttributeSlotTreeListPresenter part) {
    this.registerPart(part);
    this.getView().setAttributeSlotTreeListPresenter(part);
    return part;
    
  }
  
  @Inject
  private AttributeSlotTreeListPresenter attributeSlotTreeListPresenter;
  
  public PMDefaultIntervalAssociationListPresenter initPart(final PMDefaultIntervalAssociationListPresenter part) {
    this.registerPart(part);
    this.getView().setDefaultIntervalAssociationListPresenter(part);
    return part;
    
  }
  
  @Inject
  private PMDefaultIntervalAssociationListPresenter defaultIntervalAssociationListPresenter;
  
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
  
  private RCDeviceTypeCategoryProxy category;
  
  public void setup(final IPresenterInitiazerNotifier<DeviceTypeManagementPresenter> _notifier) {
    
    AttributeSlotTreeListPresenter _initPart = this.initPart(this.attributeSlotTreeListPresenter);
    final Procedure1<AttributeSlotTreeListPresenter> _function = new Procedure1<AttributeSlotTreeListPresenter>() {
        public void apply(final AttributeSlotTreeListPresenter it) {
          PMDefaultIntervalAssociationListPresenter _initPart = DeviceTypeManagementPresenter.this.initPart(DeviceTypeManagementPresenter.this.defaultIntervalAssociationListPresenter);
          final Procedure1<PMDefaultIntervalAssociationListPresenter> _function = new Procedure1<PMDefaultIntervalAssociationListPresenter>() {
              public void apply(final PMDefaultIntervalAssociationListPresenter it) {
                PartTypeListPresenter _initPart = DeviceTypeManagementPresenter.this.initPart(DeviceTypeManagementPresenter.this.partTypeListPresenter);
                final Procedure1<PartTypeListPresenter> _function = new Procedure1<PartTypeListPresenter>() {
                    public void apply(final PartTypeListPresenter it) {
                      DocumentStorageListPresenter _initPart = DeviceTypeManagementPresenter.this.initPart(DeviceTypeManagementPresenter.this.deviceDocumentStorageListPresenter);
                      final Procedure1<DocumentStorageListPresenter> _function = new Procedure1<DocumentStorageListPresenter>() {
                          public void apply(final DocumentStorageListPresenter it) {
                            PictureListPresenter _initPart = DeviceTypeManagementPresenter.this.initPart(DeviceTypeManagementPresenter.this.devicepictureListPresenter);
                            final Procedure1<PictureListPresenter> _function = new Procedure1<PictureListPresenter>() {
                                public void apply(final PictureListPresenter it) {
                                  final Procedure1<Void> _function = new Procedure1<Void>() {
                                      public void apply(final Void it) {
                                        DeviceTypeManagementPresenterView _view = DeviceTypeManagementPresenter.this.getView();
                                        ActionContext<UIDeviceType> _actionContext = _view.getActionContext();
                                        final Function1<UIDeviceType,RCDeviceTypeProxy> _function = new Function1<UIDeviceType,RCDeviceTypeProxy>() {
                                            public RCDeviceTypeProxy apply(final UIDeviceType it) {
                                              RCDeviceTypeProxy _proxy = it.toProxy();
                                              return _proxy;
                                            }
                                          };
                                        ActionContext<RCDeviceTypeProxy> _adapt = _actionContext.<RCDeviceTypeProxy>adapt(new Function<UIDeviceType,RCDeviceTypeProxy>() {
                                            public RCDeviceTypeProxy apply(UIDeviceType input) {
                                              return _function.apply(input);
                                            }
                                        });
                                        DeviceTypeManagementPresenter.this.defaultIntervalAssociationListPresenter.setActionContext(_adapt);getView().refresh();
                                        _notifier.done(DeviceTypeManagementPresenter.this);
                                      }
                                    };
                                  DeviceTypeManagementPresenter.this.activate(new IPostInitializeAction() {
                                      public void initializeFinished(Void v) {
                                        _function.apply(v);
                                      }
                                  });
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
                _initPart.setup(new IPresenterInitiazerNotifier<PartTypeListPresenter>() {
                    public void done(PartTypeListPresenter presenter) {
                      _function.apply(presenter);
                    }
                });
              }
            };
          _initPart.setup(new IPresenterInitiazerNotifier<PMDefaultIntervalAssociationListPresenter>() {
              public void done(PMDefaultIntervalAssociationListPresenter presenter) {
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
  
  public void setTypeCategoryActionContext(final ActionContext<UIDeviceTypeCategory> ac) {
    
    DeviceTypeManagementPresenterView _view = this.getView();
    _view.setTypeCategoryActionContext(ac);
  }
  
  public void selectCategory(final RCDeviceTypeCategoryProxy category) {
    
    this.category = category;
    getView().filterByCategory(category);
    
  }
  
  public void view_filterRequestExecution(final UIDeviceTypeCriteria c) {
    
    final Procedure1<IPagedResult<UIDeviceType>> _function = new Procedure1<IPagedResult<UIDeviceType>>() {
        public void apply(final IPagedResult<UIDeviceType> it) {
          getView().showResults(it);
          
        }
      };
    AsyncCallback<IPagedResult<UIDeviceType>> _onSuccess = this.<IPagedResult<UIDeviceType>>onSuccess(_function);
    _service.filter(c, _onSuccess);
  }
  
  public void view_deviceTypeSelectedExecution(final RCDeviceTypeProxy value) {
    
    final Procedure1<RCExtensiableEntityProxy> _function = new Procedure1<RCExtensiableEntityProxy>() {
        public void apply(final RCExtensiableEntityProxy it) {
          DeviceTypeManagementPresenter.this.attributeSlotTreeListPresenter.setExtensiableEntity(it);
        }
      };
    AsyncCallback<RCExtensiableEntityProxy> _onSuccess = this.<RCExtensiableEntityProxy>onSuccess(_function);
    _service.loadEntityExtension(value, _onSuccess);
    this.defaultIntervalAssociationListPresenter.setDeviceType(value);
    this.partTypeListPresenter.setDeviceType(value);
    DeviceTypeFileContainerProxy _deviceTypeFileContainerProxy = new DeviceTypeFileContainerProxy(value);
    this.deviceDocumentStorageListPresenter.setDevice(_deviceTypeFileContainerProxy);
    DeviceTypePictureContainerProxy _deviceTypePictureContainerProxy = new DeviceTypePictureContainerProxy(value);
    this.devicepictureListPresenter.setDevice(_deviceTypePictureContainerProxy);
  }
  
  public void view_showAttributeSlotEditorRequestExecution(final RCDeviceTypeProxy value) {
    
    final Procedure1<RCExtensiableEntityProxy> _function = new Procedure1<RCExtensiableEntityProxy>() {
        public void apply(final RCExtensiableEntityProxy it) {
          AttributeSlotEditPresenter _get = DeviceTypeManagementPresenter.this.attributeSlotEditPresenter.get();
          final Procedure1<AttributeSlotEditPresenter> _function = new Procedure1<AttributeSlotEditPresenter>() {
              public void apply(final AttributeSlotEditPresenter it) {
                it.popup(it);
              }
            };
          _get.setup(it, new IPresenterInitiazerNotifier<AttributeSlotEditPresenter>() {
              public void done(AttributeSlotEditPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    AsyncCallback<RCExtensiableEntityProxy> _onSuccess = this.<RCExtensiableEntityProxy>onSuccess(_function);
    _service.loadEntityExtension(value, _onSuccess);
  }
  
  public void view_deleteAttributeRequestExecution(final RCAttributeSlotProxy slot) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.AttributeSlotDeletedEvent(slot));
          
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.deleteSlotAttribute(slot, _onSuccess);
  }
  
  public void view_newParameterRequestExecution(final RCAttributeSlotProxy slot) {
    
    boolean _equals = Objects.equal(slot, null);
    if (_equals) {
      DeviceTypeManagementPresenterView _view = this.getView();
      RCDeviceTypeProxy _selectedDeviceType = _view.getSelectedDeviceType();
      final Procedure1<RCExtensiableEntityProxy> _function = new Procedure1<RCExtensiableEntityProxy>() {
          public void apply(final RCExtensiableEntityProxy ee) {
            CreatePrimaryTypePresenter _get = DeviceTypeManagementPresenter.this.createPrimaryTypePresenter.get();
            final Procedure1<CreatePrimaryTypePresenter> _function = new Procedure1<CreatePrimaryTypePresenter>() {
                public void apply(final CreatePrimaryTypePresenter it) {
                  eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                  
                }
              };
            _get.setup4ExtensiableEntity(ee, _function);
          }
        };
      AsyncCallback<RCExtensiableEntityProxy> _onSuccess = this.<RCExtensiableEntityProxy>onSuccess(_function);
      _service.loadEntityExtension(_selectedDeviceType, _onSuccess);
    } else {
      CreatePrimaryTypePresenter _get = this.createPrimaryTypePresenter.get();
      final Procedure1<CreatePrimaryTypePresenter> _function_1 = new Procedure1<CreatePrimaryTypePresenter>() {
          public void apply(final CreatePrimaryTypePresenter it) {
            eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
            
          }
        };
      _get.setup4CompositeSlot(slot, _function_1);
    }
  }
  
  public void view_newCategoryRequestExecution(final RCAttributeSlotProxy slot) {
    
    boolean _equals = Objects.equal(slot, null);
    if (_equals) {
      DeviceTypeManagementPresenterView _view = this.getView();
      RCDeviceTypeProxy _selectedDeviceType = _view.getSelectedDeviceType();
      final Procedure1<RCExtensiableEntityProxy> _function = new Procedure1<RCExtensiableEntityProxy>() {
          public void apply(final RCExtensiableEntityProxy ee) {
            CreateCompositeTypePresenter _get = DeviceTypeManagementPresenter.this.createCompositeTypePresenter.get();
            final Procedure1<CreateCompositeTypePresenter> _function = new Procedure1<CreateCompositeTypePresenter>() {
                public void apply(final CreateCompositeTypePresenter it) {
                  eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                  
                }
              };
            _get.setup4ExtensiableEntity(ee, _function);
          }
        };
      AsyncCallback<RCExtensiableEntityProxy> _onSuccess = this.<RCExtensiableEntityProxy>onSuccess(_function);
      _service.loadEntityExtension(_selectedDeviceType, _onSuccess);
    } else {
      CreateCompositeTypePresenter _get = this.createCompositeTypePresenter.get();
      final Procedure1<CreateCompositeTypePresenter> _function_1 = new Procedure1<CreateCompositeTypePresenter>() {
          public void apply(final CreateCompositeTypePresenter it) {
            eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
            
          }
        };
      _get.setup4CompositeSlot(slot, _function_1);
    }
  }
  
  public void view_createChildRequestExecution(final RCDeviceTypeCategoryProxy category) {
    
    boolean _equals = Objects.equal(category, null);
    if (_equals) {
      Info.display("\u9519\u8BEF", "\u8BF7\u9009\u62E9\u8BBE\u5907\u5927\u7C7B");
    } else {
      CreateOrUpdateDeviceTypePresenter _get = this.createOrUpdateDeviceTypePresenter.get();
      final Procedure1<CreateOrUpdateDeviceTypePresenter> _function = new Procedure1<CreateOrUpdateDeviceTypePresenter>() {
          public void apply(final CreateOrUpdateDeviceTypePresenter it) {
            final Procedure1<CreateOrUpdateDeviceTypePresenter> _function = new Procedure1<CreateOrUpdateDeviceTypePresenter>() {
                public void apply(final CreateOrUpdateDeviceTypePresenter it) {
                  eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                  
                }
              };
            it.setup4Create(category, new IPresenterInitiazerNotifier<CreateOrUpdateDeviceTypePresenter>() {
                public void done(CreateOrUpdateDeviceTypePresenter presenter) {
                  _function.apply(presenter);
                }
            });
          }
        };
      ObjectExtensions.<CreateOrUpdateDeviceTypePresenter>operator_doubleArrow(_get, _function);
    }
  }
  
  public void view_cloneChildRequestExecution(final RCDeviceTypeProxy child) {
    
    CreateOrUpdateDeviceTypePresenter _get = this.createOrUpdateDeviceTypePresenter.get();
    final Procedure1<CreateOrUpdateDeviceTypePresenter> _function = new Procedure1<CreateOrUpdateDeviceTypePresenter>() {
        public void apply(final CreateOrUpdateDeviceTypePresenter it) {
          final Procedure1<CreateOrUpdateDeviceTypePresenter> _function = new Procedure1<CreateOrUpdateDeviceTypePresenter>() {
              public void apply(final CreateOrUpdateDeviceTypePresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Clone(child, new IPresenterInitiazerNotifier<CreateOrUpdateDeviceTypePresenter>() {
              public void done(CreateOrUpdateDeviceTypePresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    ObjectExtensions.<CreateOrUpdateDeviceTypePresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_modifyChildRequestExecution(final RCDeviceTypeProxy child) {
    
    CreateOrUpdateDeviceTypePresenter _get = this.createOrUpdateDeviceTypePresenter.get();
    final Procedure1<CreateOrUpdateDeviceTypePresenter> _function = new Procedure1<CreateOrUpdateDeviceTypePresenter>() {
        public void apply(final CreateOrUpdateDeviceTypePresenter it) {
          final Procedure1<CreateOrUpdateDeviceTypePresenter> _function = new Procedure1<CreateOrUpdateDeviceTypePresenter>() {
              public void apply(final CreateOrUpdateDeviceTypePresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Update(child, new IPresenterInitiazerNotifier<CreateOrUpdateDeviceTypePresenter>() {
              public void done(CreateOrUpdateDeviceTypePresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    ObjectExtensions.<CreateOrUpdateDeviceTypePresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_deleteChildRequestExecution(final RCDeviceTypeProxy child) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.DeviceTypesChangedEvent());
          
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.deleteChild(child, _onSuccess);
  }
  
  public void _eventbus_DeviceTypesChanged() {
    getView().refresh();
    
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().filterRequest(new RequestHandler1<UIDeviceTypeCriteria>(){
    			
    			public void execute(UIDeviceTypeCriteria c){
    				view_filterRequestExecution(c);
    			}
    			
    		});
    getView().deviceTypeSelected(new RequestHandler1<RCDeviceTypeProxy>(){
    			
    			public void execute(RCDeviceTypeProxy value){
    				view_deviceTypeSelectedExecution(value);
    			}
    			
    		});
    getView().showAttributeSlotEditorRequest(new RequestHandler1<RCDeviceTypeProxy>(){
    			
    			public void execute(RCDeviceTypeProxy value){
    				view_showAttributeSlotEditorRequestExecution(value);
    			}
    			
    		});
    getView().deleteAttributeRequest(new RequestHandler1<RCAttributeSlotProxy>(){
    			
    			public void execute(RCAttributeSlotProxy slot){
    				view_deleteAttributeRequestExecution(slot);
    			}
    			
    		});
    getView().newParameterRequest(new RequestHandler1<RCAttributeSlotProxy>(){
    			
    			public void execute(RCAttributeSlotProxy slot){
    				view_newParameterRequestExecution(slot);
    			}
    			
    		});
    getView().newCategoryRequest(new RequestHandler1<RCAttributeSlotProxy>(){
    			
    			public void execute(RCAttributeSlotProxy slot){
    				view_newCategoryRequestExecution(slot);
    			}
    			
    		});
    getView().createChildRequest(new RequestHandler1<RCDeviceTypeCategoryProxy>(){
    			
    			public void execute(RCDeviceTypeCategoryProxy category){
    				view_createChildRequestExecution(category);
    			}
    			
    		});
    getView().cloneChildRequest(new RequestHandler1<RCDeviceTypeProxy>(){
    			
    			public void execute(RCDeviceTypeProxy child){
    				view_cloneChildRequestExecution(child);
    			}
    			
    		});
    getView().modifyChildRequest(new RequestHandler1<RCDeviceTypeProxy>(){
    			
    			public void execute(RCDeviceTypeProxy child){
    				view_modifyChildRequestExecution(child);
    			}
    			
    		});
    getView().deleteChildRequest(new RequestHandler1<RCDeviceTypeProxy>(){
    			
    			public void execute(RCDeviceTypeProxy child){
    				view_deleteChildRequestExecution(child);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.device.DeviceTypesChangedEvent.__type__, new com.fudanmed.platform.core.web.client.device.DeviceTypesChangedHandler(){
    public void DeviceTypesChanged(){
    	_eventbus_DeviceTypesChanged();
    }
    }));
    
  }
}
