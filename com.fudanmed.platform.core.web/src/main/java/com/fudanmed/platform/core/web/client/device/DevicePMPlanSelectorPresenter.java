package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMPlanProxy;
import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMWorkItemPresenter;
import com.fudanmed.platform.core.web.client.device.DeviceCategoryAndTypeListPresenter;
import com.fudanmed.platform.core.web.client.device.DevicePMPlanSelectorPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.DevicePMPlanSelectorPresenterView;
import com.fudanmed.platform.core.web.client.organization.OnsiteLocationOutlinePresenter;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlan;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlanCriteria;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DevicePMPlanSelectorPresenter extends WorkbenchAbstractPresenter<DevicePMPlanSelectorPresenterView> implements CommitablePresenter {
  @Inject
  protected DevicePMPlanSelectorPresenterServiceAsync _service;
  
  @Inject
  public DevicePMPlanSelectorPresenter(final DevicePMPlanSelectorPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private Provider<CreateOrUpdatePMWorkItemPresenter> createOrUpdatePMWorkItemPresenter;
  
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
  
  private Procedure1<? super CommitResultNotifier> commiter;
  
  public void setup(final RCPMWorkItemProxy pmworkItem, final IPresenterInitiazerNotifier<DevicePMPlanSelectorPresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          DevicePMPlanSelectorPresenterView _view = DevicePMPlanSelectorPresenter.this.getView();
          Collection<RCDevicePMPlanProxy> _selectedValues = _view.getSelectedValues();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {
                notifier.success();
                InputOutput.<String>println("fire eventbus.DevicePMPlansChanged");eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.DevicePMPlansChangedEvent());
                
              }
            };
          AsyncCallback<Void> _onSuccess = DevicePMPlanSelectorPresenter.this.<Void>onSuccess(_function);
          _service.assignPlansToWorkItem(pmworkItem, _selectedValues, _onSuccess);
        }
      };
    this.commiter = _function;
    OnsiteLocationOutlinePresenter _initPart = this.initPart(this.onsiteLocationOutlinePresenter);
    final Procedure1<OnsiteLocationOutlinePresenter> _function_1 = new Procedure1<OnsiteLocationOutlinePresenter>() {
        public void apply(final OnsiteLocationOutlinePresenter it) {
          DeviceCategoryAndTypeListPresenter _initPart = DevicePMPlanSelectorPresenter.this.initPart(DevicePMPlanSelectorPresenter.this.deviceCategoryAndTypeListPresenter);
          final Procedure1<DeviceCategoryAndTypeListPresenter> _function = new Procedure1<DeviceCategoryAndTypeListPresenter>() {
              public void apply(final DeviceCategoryAndTypeListPresenter it) {
                DevicePMPlanSelectorPresenterView _view = DevicePMPlanSelectorPresenter.this.getView();
                _view.setUsage(Boolean.valueOf(true));
                final Procedure1<Void> _function = new Procedure1<Void>() {
                    public void apply(final Void it) {getView().refresh();
                      _notifier.done(DevicePMPlanSelectorPresenter.this);
                    }
                  };
                DevicePMPlanSelectorPresenter.this.activate(new IPostInitializeAction() {
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
    _initPart.setupAsSimpleTree(_function_1);
  }
  
  public void setup4CreateWorkItem(final IPresenterInitiazerNotifier<DevicePMPlanSelectorPresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreateOrUpdatePMWorkItemPresenter _get = DevicePMPlanSelectorPresenter.this.createOrUpdatePMWorkItemPresenter.get();
          DevicePMPlanSelectorPresenterView _view = DevicePMPlanSelectorPresenter.this.getView();
          Collection<RCDevicePMPlanProxy> _selectedValues = _view.getSelectedValues();
          final Procedure1<CreateOrUpdatePMWorkItemPresenter> _function = new Procedure1<CreateOrUpdatePMWorkItemPresenter>() {
              public void apply(final CreateOrUpdatePMWorkItemPresenter it) {
                notifier.success();
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          _get.setup4Create(_selectedValues, new IPresenterInitiazerNotifier<CreateOrUpdatePMWorkItemPresenter>() {
              public void done(CreateOrUpdatePMWorkItemPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    this.commiter = _function;
    OnsiteLocationOutlinePresenter _initPart = this.initPart(this.onsiteLocationOutlinePresenter);
    final Procedure1<OnsiteLocationOutlinePresenter> _function_1 = new Procedure1<OnsiteLocationOutlinePresenter>() {
        public void apply(final OnsiteLocationOutlinePresenter it) {
          DeviceCategoryAndTypeListPresenter _initPart = DevicePMPlanSelectorPresenter.this.initPart(DevicePMPlanSelectorPresenter.this.deviceCategoryAndTypeListPresenter);
          final Procedure1<DeviceCategoryAndTypeListPresenter> _function = new Procedure1<DeviceCategoryAndTypeListPresenter>() {
              public void apply(final DeviceCategoryAndTypeListPresenter it) {
                DevicePMPlanSelectorPresenterView _view = DevicePMPlanSelectorPresenter.this.getView();
                _view.setUsage(Boolean.valueOf(true));
                final Procedure1<Void> _function = new Procedure1<Void>() {
                    public void apply(final Void it) {getView().refresh();
                      _notifier.done(DevicePMPlanSelectorPresenter.this);
                    }
                  };
                DevicePMPlanSelectorPresenter.this.activate(new IPostInitializeAction() {
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
    _initPart.setupAsSimpleTree(_function_1);
  }
  
  public void setup(final IPresenterInitiazerNotifier<DevicePMPlanSelectorPresenter> _notifier) {
    
    OnsiteLocationOutlinePresenter _initPart = this.initPart(this.onsiteLocationOutlinePresenter);
    final Procedure1<OnsiteLocationOutlinePresenter> _function = new Procedure1<OnsiteLocationOutlinePresenter>() {
        public void apply(final OnsiteLocationOutlinePresenter it) {
          DeviceCategoryAndTypeListPresenter _initPart = DevicePMPlanSelectorPresenter.this.initPart(DevicePMPlanSelectorPresenter.this.deviceCategoryAndTypeListPresenter);
          final Procedure1<DeviceCategoryAndTypeListPresenter> _function = new Procedure1<DeviceCategoryAndTypeListPresenter>() {
              public void apply(final DeviceCategoryAndTypeListPresenter it) {
                DevicePMPlanSelectorPresenterView _view = DevicePMPlanSelectorPresenter.this.getView();
                _view.setUsage(Boolean.valueOf(false));
                final Procedure1<Void> _function = new Procedure1<Void>() {
                    public void apply(final Void it) {getView().refresh();
                      _notifier.done(DevicePMPlanSelectorPresenter.this);
                    }
                  };
                DevicePMPlanSelectorPresenter.this.activate(new IPostInitializeAction() {
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
  
  public void view_filterRequestExecution(final UIDevicePMPlanCriteria c) {
    
    final Procedure1<IPagedResult<UIDevicePMPlan>> _function = new Procedure1<IPagedResult<UIDevicePMPlan>>() {
        public void apply(final IPagedResult<UIDevicePMPlan> it) {
          getView().showResults(it);
          
        }
      };
    AsyncCallback<IPagedResult<UIDevicePMPlan>> _onSuccess = this.<IPagedResult<UIDevicePMPlan>>onSuccess(_function);
    _service.filter(c, _onSuccess);
  }
  
  public void _eventbus_DevicePMPlansChanged() {
    getView().refresh();
    
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    this.commiter.apply(notifier);
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().filterRequest(new RequestHandler1<UIDevicePMPlanCriteria>(){
    			
    			public void execute(UIDevicePMPlanCriteria c){
    				view_filterRequestExecution(c);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.device.DevicePMPlansChangedEvent.__type__, new com.fudanmed.platform.core.web.client.device.DevicePMPlansChangedHandler(){
    public void DevicePMPlansChanged(){
    	_eventbus_DevicePMPlansChanged();
    }
    }));
    
  }
}
