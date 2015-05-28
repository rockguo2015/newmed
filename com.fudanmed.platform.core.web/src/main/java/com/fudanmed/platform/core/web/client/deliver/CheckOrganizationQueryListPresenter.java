package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.CheckOrganizationQueryListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.deliver.CheckOrganizationQueryListPresenterView;
import com.fudanmed.platform.core.web.shared.deliver.UICheckOrganization;
import com.fudanmed.platform.core.web.shared.deliver.UICheckOrganizationCriteria;
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

public class CheckOrganizationQueryListPresenter extends WorkbenchAbstractPresenter<CheckOrganizationQueryListPresenterView> {
  @Inject
  protected CheckOrganizationQueryListPresenterServiceAsync _service;
  
  @Inject
  public CheckOrganizationQueryListPresenter(final CheckOrganizationQueryListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final IPresenterInitiazerNotifier<CheckOrganizationQueryListPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {getView().refresh();
          _notifier.done(CheckOrganizationQueryListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void view_filterRequestExecution(final UICheckOrganizationCriteria c) {
    
    final Procedure1<IPagedResult<UICheckOrganization>> _function = new Procedure1<IPagedResult<UICheckOrganization>>() {
        public void apply(final IPagedResult<UICheckOrganization> it) {
          getView().showResults(it);
          
        }
      };
    AsyncCallback<IPagedResult<UICheckOrganization>> _onSuccess = this.<IPagedResult<UICheckOrganization>>onSuccess(_function);
    _service.filter(c, _onSuccess);
  }
  
  public void _eventbus_CheckOrganizationsChanged() {
    getView().refresh();
    
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().filterRequest(new RequestHandler1<UICheckOrganizationCriteria>(){
    			
    			public void execute(UICheckOrganizationCriteria c){
    				view_filterRequestExecution(c);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.deliver.CheckOrganizationsChangedEvent.__type__, new com.fudanmed.platform.core.web.client.deliver.CheckOrganizationsChangedHandler(){
    public void CheckOrganizationsChanged(){
    	_eventbus_CheckOrganizationsChanged();
    }
    }));
    
  }
}
