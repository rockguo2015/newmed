package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.common.proxy.RCFaultLevelColorAdaptorProxy;
import com.fudanmed.platform.core.web.client.organization.CreateOrUpdateFaultLevelColorAdaptorPresenter;
import com.fudanmed.platform.core.web.client.organization.FaultLevelColorAdaptorListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.organization.FaultLevelColorAdaptorListPresenterView;
import com.fudanmed.platform.core.web.shared.organization.UIFaultLevelColorAdaptor;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class FaultLevelColorAdaptorListPresenter extends WorkbenchAbstractPresenter<FaultLevelColorAdaptorListPresenterView> {
  @Inject
  protected FaultLevelColorAdaptorListPresenterServiceAsync _service;
  
  @Inject
  public FaultLevelColorAdaptorListPresenter(final FaultLevelColorAdaptorListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private Provider<CreateOrUpdateFaultLevelColorAdaptorPresenter> createOrUpdateFaultLevelColorAdaptorPresenter;
  
  public void setup(final IPresenterInitiazerNotifier<FaultLevelColorAdaptorListPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          FaultLevelColorAdaptorListPresenter.this.refresh();_notifier.done(FaultLevelColorAdaptorListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void refresh() {
    
    final Procedure1<Collection<UIFaultLevelColorAdaptor>> _function = new Procedure1<Collection<UIFaultLevelColorAdaptor>>() {
        public void apply(final Collection<UIFaultLevelColorAdaptor> items) {
          getView().setResults(items);
          
        }
      };
    AsyncCallback<Collection<UIFaultLevelColorAdaptor>> _onSuccess = this.<Collection<UIFaultLevelColorAdaptor>>onSuccess(_function);
    _service.loadFaultLevelColorAdaptorList(_onSuccess);
  }
  
  public void view_updateRequestExecution(final RCFaultLevelColorAdaptorProxy value) {
    
    CreateOrUpdateFaultLevelColorAdaptorPresenter _get = this.createOrUpdateFaultLevelColorAdaptorPresenter.get();
    final Procedure1<CreateOrUpdateFaultLevelColorAdaptorPresenter> _function = new Procedure1<CreateOrUpdateFaultLevelColorAdaptorPresenter>() {
        public void apply(final CreateOrUpdateFaultLevelColorAdaptorPresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Update(value, new IPresenterInitiazerNotifier<CreateOrUpdateFaultLevelColorAdaptorPresenter>() {
        public void done(CreateOrUpdateFaultLevelColorAdaptorPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  public void _eventbus_FaultLevelColorAdaptorsChanged() {
    
    this.refresh();
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().updateRequest(new RequestHandler1<RCFaultLevelColorAdaptorProxy>(){
    			
    			public void execute(RCFaultLevelColorAdaptorProxy value){
    				view_updateRequestExecution(value);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.organization.FaultLevelColorAdaptorsChangedEvent.__type__, new com.fudanmed.platform.core.web.client.organization.FaultLevelColorAdaptorsChangedHandler(){
    public void FaultLevelColorAdaptorsChanged(){
    	_eventbus_FaultLevelColorAdaptorsChanged();
    }
    }));
    
  }
}
