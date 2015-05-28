package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePartTypeSelectDataPresenter;
import com.fudanmed.platform.core.web.client.device.PartTypeListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.PartTypeListPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class PartTypeListPresenter extends WorkbenchAbstractPresenter<PartTypeListPresenterView> {
  @Inject
  protected PartTypeListPresenterServiceAsync _service;
  
  @Inject
  public PartTypeListPresenter(final PartTypeListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private Provider<CreateOrUpdatePartTypeSelectDataPresenter> createOrUpdatePartTypeSelectDataPresenter;
  
  private RCDeviceTypeProxy context;
  
  public void setup(final IPresenterInitiazerNotifier<PartTypeListPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(PartTypeListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup(final RCDeviceTypeProxy context, final IPresenterInitiazerNotifier<PartTypeListPresenter> _notifier) {
    
    this.context = context;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          PartTypeListPresenter.this.refresh();_notifier.done(PartTypeListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setDeviceType(final RCDeviceTypeProxy context) {
    
    this.context = context;
    this.refresh();
  }
  
  public void view_createRequestExecution() {
    
    CreateOrUpdatePartTypeSelectDataPresenter _get = this.createOrUpdatePartTypeSelectDataPresenter.get();
    final Procedure1<CreateOrUpdatePartTypeSelectDataPresenter> _function = new Procedure1<CreateOrUpdatePartTypeSelectDataPresenter>() {
        public void apply(final CreateOrUpdatePartTypeSelectDataPresenter it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
          
        }
      };
    _get.setup4Create(this.context, new IPresenterInitiazerNotifier<CreateOrUpdatePartTypeSelectDataPresenter>() {
        public void done(CreateOrUpdatePartTypeSelectDataPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  public void view_deleteRequestExecution(final RCProductSpecificationProxy value) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.PartTypeSelectChangedEvent());
          
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.delete(this.context, value, _onSuccess);
  }
  
  public void refresh() {
    
    boolean _notEquals = (!Objects.equal(this.context, null));
    if (_notEquals) {
      final Procedure1<Collection<UIProductSpecification>> _function = new Procedure1<Collection<UIProductSpecification>>() {
          public void apply(final Collection<UIProductSpecification> items) {
            getView().setResults(items);
            
          }
        };
      AsyncCallback<Collection<UIProductSpecification>> _onSuccess = this.<Collection<UIProductSpecification>>onSuccess(_function);
      _service.loadProductSpecificationList(this.context, _onSuccess);
    }
  }
  
  public void _eventbus_PartTypeSelectChanged() {
    
    this.refresh();
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
    getView().deleteRequest(new RequestHandler1<RCProductSpecificationProxy>(){
    			
    			public void execute(RCProductSpecificationProxy value){
    				view_deleteRequestExecution(value);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.device.PartTypeSelectChangedEvent.__type__, new com.fudanmed.platform.core.web.client.device.PartTypeSelectChangedHandler(){
    public void PartTypeSelectChanged(){
    	_eventbus_PartTypeSelectChanged();
    }
    }));
    
  }
}
