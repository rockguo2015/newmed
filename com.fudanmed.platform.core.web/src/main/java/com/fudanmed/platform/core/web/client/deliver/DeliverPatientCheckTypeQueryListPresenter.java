package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy;
import com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckTypeQueryListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckTypeQueryListPresenterView;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckType;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckTypeCriteria;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DeliverPatientCheckTypeQueryListPresenter extends WorkbenchAbstractPresenter<DeliverPatientCheckTypeQueryListPresenterView> {
  @Inject
  protected DeliverPatientCheckTypeQueryListPresenterServiceAsync _service;
  
  @Inject
  public DeliverPatientCheckTypeQueryListPresenter(final DeliverPatientCheckTypeQueryListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final ActionContext<DLDeliverPatientCheckCategoryProxy> categoryAC, final IPresenterInitiazerNotifier<DeliverPatientCheckTypeQueryListPresenter> _notifier) {
    
    DeliverPatientCheckTypeQueryListPresenterView _view = this.getView();
    _view.setCategoryAC(categoryAC);
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {getView().refresh();
          _notifier.done(DeliverPatientCheckTypeQueryListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void view_filterRequestExecution(final UIDeliverPatientCheckTypeCriteria c) {
    
    final Procedure1<IPagedResult<UIDeliverPatientCheckType>> _function = new Procedure1<IPagedResult<UIDeliverPatientCheckType>>() {
        public void apply(final IPagedResult<UIDeliverPatientCheckType> it) {
          getView().showResults(it);
          
        }
      };
    AsyncCallback<IPagedResult<UIDeliverPatientCheckType>> _onSuccess = this.<IPagedResult<UIDeliverPatientCheckType>>onSuccess(_function);
    _service.filter(c, _onSuccess);
  }
  
  public void _eventbus_DeliverPatientCheckTypesChanged() {
    getView().refresh();
    
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().filterRequest(new RequestHandler1<UIDeliverPatientCheckTypeCriteria>(){
    			
    			public void execute(UIDeliverPatientCheckTypeCriteria c){
    				view_filterRequestExecution(c);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckTypesChangedEvent.__type__, new com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckTypesChangedHandler(){
    public void DeliverPatientCheckTypesChanged(){
    	_eventbus_DeliverPatientCheckTypesChanged();
    }
    }));
    
  }
}
