package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.DeliverOrganizationQueryListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.deliver.DeliverOrganizationQueryListPresenterView;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverOrganization;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverOrganizationCriteria;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DeliverOrganizationQueryListPresenter extends WorkbenchAbstractPresenter<DeliverOrganizationQueryListPresenterView> {
  @Inject
  protected DeliverOrganizationQueryListPresenterServiceAsync _service;
  
  @Inject
  public DeliverOrganizationQueryListPresenter(final DeliverOrganizationQueryListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final IPresenterInitiazerNotifier<DeliverOrganizationQueryListPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {getView().refresh();
          _notifier.done(DeliverOrganizationQueryListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void view_filterRequestExecution(final UIDeliverOrganizationCriteria c) {
    
    final Procedure1<IPagedResult<UIDeliverOrganization>> _function = new Procedure1<IPagedResult<UIDeliverOrganization>>() {
        public void apply(final IPagedResult<UIDeliverOrganization> it) {
          getView().showResults(it);
          
        }
      };
    AsyncCallback<IPagedResult<UIDeliverOrganization>> _onSuccess = this.<IPagedResult<UIDeliverOrganization>>onSuccess(_function);
    _service.filter(c, _onSuccess);
  }
  
  public void _eventbus_DeliverOrganizationsChanged() {
    getView().refresh();
    
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().filterRequest(new RequestHandler1<UIDeliverOrganizationCriteria>(){
    			
    			public void execute(UIDeliverOrganizationCriteria c){
    				view_filterRequestExecution(c);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.deliver.DeliverOrganizationsChangedEvent.__type__, new com.fudanmed.platform.core.web.client.deliver.DeliverOrganizationsChangedHandler(){
    public void DeliverOrganizationsChanged(){
    	_eventbus_DeliverOrganizationsChanged();
    }
    }));
    
  }
}
