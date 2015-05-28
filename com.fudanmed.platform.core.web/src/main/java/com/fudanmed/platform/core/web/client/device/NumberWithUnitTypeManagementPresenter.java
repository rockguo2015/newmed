package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.entityextension.proxy.RCCustomizableTypeProxy;
import com.fudanmed.platform.core.entityextension.proxy.RCNumberWithUnitTypeProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdateNumberWithUnitTypePresenter;
import com.fudanmed.platform.core.web.client.device.NumberWithUnitTypeManagementPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.NumberWithUnitTypeManagementPresenterView;
import com.fudanmed.platform.core.web.shared.device.UICustomizableType;
import com.fudanmed.platform.core.web.shared.device.UICustomizableTypeCriteria;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.sencha.gxt.widget.core.client.info.Info;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class NumberWithUnitTypeManagementPresenter extends WorkbenchAbstractPresenter<NumberWithUnitTypeManagementPresenterView> {
  @Inject
  protected NumberWithUnitTypeManagementPresenterServiceAsync _service;
  
  @Inject
  public NumberWithUnitTypeManagementPresenter(final NumberWithUnitTypeManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private Provider<CreateOrUpdateNumberWithUnitTypePresenter> createOrUpdatePresenter;
  
  public void setup(final IPresenterInitiazerNotifier<NumberWithUnitTypeManagementPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {getView().refresh();
          _notifier.done(NumberWithUnitTypeManagementPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void view_createRequestExecution() {
    
    CreateOrUpdateNumberWithUnitTypePresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateNumberWithUnitTypePresenter> _function = new Procedure1<CreateOrUpdateNumberWithUnitTypePresenter>() {
        public void apply(final CreateOrUpdateNumberWithUnitTypePresenter it) {
          final Procedure1<CreateOrUpdateNumberWithUnitTypePresenter> _function = new Procedure1<CreateOrUpdateNumberWithUnitTypePresenter>() {
              public void apply(final CreateOrUpdateNumberWithUnitTypePresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Create(_function);
        }
      };
    ObjectExtensions.<CreateOrUpdateNumberWithUnitTypePresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_modifyRequestExecution(final RCNumberWithUnitTypeProxy value) {
    
    CreateOrUpdateNumberWithUnitTypePresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateNumberWithUnitTypePresenter> _function = new Procedure1<CreateOrUpdateNumberWithUnitTypePresenter>() {
        public void apply(final CreateOrUpdateNumberWithUnitTypePresenter it) {
          final Procedure1<CreateOrUpdateNumberWithUnitTypePresenter> _function = new Procedure1<CreateOrUpdateNumberWithUnitTypePresenter>() {
              public void apply(final CreateOrUpdateNumberWithUnitTypePresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Update(value, _function);
        }
      };
    ObjectExtensions.<CreateOrUpdateNumberWithUnitTypePresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_deleteRequestExecution(final RCCustomizableTypeProxy value) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.NumberWithUnitTypesChangedEvent());
          
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.delete(value, _onSuccess);
  }
  
  public void view_filterRequestExecution(final UICustomizableTypeCriteria c) {
    
    final Procedure1<IPagedResult<UICustomizableType>> _function = new Procedure1<IPagedResult<UICustomizableType>>() {
        public void apply(final IPagedResult<UICustomizableType> it) {
          getView().showResults(it);
          
        }
      };
    AsyncCallback<IPagedResult<UICustomizableType>> _onSuccess = this.<IPagedResult<UICustomizableType>>onSuccess(_function);
    _service.filter(c, _onSuccess);
  }
  
  public void view_createRangeTypeRequestExecution(final RCNumberWithUnitTypeProxy value) {
    
    final Procedure1<Boolean> _function = new Procedure1<Boolean>() {
        public void apply(final Boolean created) {
          boolean _not = (!created);
          if (_not) {
            final Procedure1<Void> _function = new Procedure1<Void>() {
                public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.NumberWithUnitTypesChangedEvent());
                  
                }
              };
            AsyncCallback<Void> _onSuccess = NumberWithUnitTypeManagementPresenter.this.<Void>onSuccess(_function);
            _service.createRangeType(value, _onSuccess);
          } else {
            Info.display("\u9519\u8BEF", "\u8BE5\u7C7B\u578B\u7684\u8303\u56F4\u7C7B\u578B\u5DF2\u5B9A\u4E49");
          }
        }
      };
    AsyncCallback<Boolean> _onSuccess = this.<Boolean>onSuccess(_function);
    _service.rangeTypeCreated(value, _onSuccess);
  }
  
  public void _eventbus_NumberWithUnitTypesChanged() {
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
    getView().modifyRequest(new RequestHandler1<RCNumberWithUnitTypeProxy>(){
    			
    			public void execute(RCNumberWithUnitTypeProxy value){
    				view_modifyRequestExecution(value);
    			}
    			
    		});
    getView().deleteRequest(new RequestHandler1<RCCustomizableTypeProxy>(){
    			
    			public void execute(RCCustomizableTypeProxy value){
    				view_deleteRequestExecution(value);
    			}
    			
    		});
    getView().filterRequest(new RequestHandler1<UICustomizableTypeCriteria>(){
    			
    			public void execute(UICustomizableTypeCriteria c){
    				view_filterRequestExecution(c);
    			}
    			
    		});
    getView().createRangeTypeRequest(new RequestHandler1<RCNumberWithUnitTypeProxy>(){
    			
    			public void execute(RCNumberWithUnitTypeProxy value){
    				view_createRangeTypeRequestExecution(value);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.device.NumberWithUnitTypesChangedEvent.__type__, new com.fudanmed.platform.core.web.client.device.NumberWithUnitTypesChangedHandler(){
    public void NumberWithUnitTypesChanged(){
    	_eventbus_NumberWithUnitTypesChanged();
    }
    }));
    
  }
}
