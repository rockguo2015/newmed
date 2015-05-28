package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy;
import com.fudanmed.platform.core.web.client.deliver.DeliverMaterialTypeQueryListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.deliver.DeliverMaterialTypeQueryListPresenterView;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialType;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialTypeCriteria;
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

public class DeliverMaterialTypeQueryListPresenter extends WorkbenchAbstractPresenter<DeliverMaterialTypeQueryListPresenterView> {
  @Inject
  protected DeliverMaterialTypeQueryListPresenterServiceAsync _service;
  
  @Inject
  public DeliverMaterialTypeQueryListPresenter(final DeliverMaterialTypeQueryListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final ActionContext<DLDeliverMaterialCategoryProxy> categoryAC, final IPresenterInitiazerNotifier<DeliverMaterialTypeQueryListPresenter> _notifier) {
    
    DeliverMaterialTypeQueryListPresenterView _view = this.getView();
    _view.setCategoryAC(categoryAC);
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {getView().refresh();
          _notifier.done(DeliverMaterialTypeQueryListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void view_filterRequestExecution(final UIDeliverMaterialTypeCriteria c) {
    
    final Procedure1<IPagedResult<UIDeliverMaterialType>> _function = new Procedure1<IPagedResult<UIDeliverMaterialType>>() {
        public void apply(final IPagedResult<UIDeliverMaterialType> it) {
          getView().showResults(it);
          
        }
      };
    AsyncCallback<IPagedResult<UIDeliverMaterialType>> _onSuccess = this.<IPagedResult<UIDeliverMaterialType>>onSuccess(_function);
    _service.filter(c, _onSuccess);
  }
  
  public void _eventbus_DeliverMaterialTypesChanged() {
    getView().refresh();
    
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().filterRequest(new RequestHandler1<UIDeliverMaterialTypeCriteria>(){
    			
    			public void execute(UIDeliverMaterialTypeCriteria c){
    				view_filterRequestExecution(c);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.deliver.DeliverMaterialTypesChangedEvent.__type__, new com.fudanmed.platform.core.web.client.deliver.DeliverMaterialTypesChangedHandler(){
    public void DeliverMaterialTypesChanged(){
    	_eventbus_DeliverMaterialTypesChanged();
    }
    }));
    
  }
}
