package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckCategoryListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckCategoryListPresenterView;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckCategory;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DeliverPatientCheckCategoryListPresenter extends WorkbenchAbstractPresenter<DeliverPatientCheckCategoryListPresenterView> {
  @Inject
  protected DeliverPatientCheckCategoryListPresenterServiceAsync _service;
  
  @Inject
  public DeliverPatientCheckCategoryListPresenter(final DeliverPatientCheckCategoryListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final IPresenterInitiazerNotifier<DeliverPatientCheckCategoryListPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          DeliverPatientCheckCategoryListPresenter.this.refresh();_notifier.done(DeliverPatientCheckCategoryListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void refresh() {
    
    final Procedure1<Collection<UIDeliverPatientCheckCategory>> _function = new Procedure1<Collection<UIDeliverPatientCheckCategory>>() {
        public void apply(final Collection<UIDeliverPatientCheckCategory> items) {
          getView().setResults(items);
          
        }
      };
    AsyncCallback<Collection<UIDeliverPatientCheckCategory>> _onSuccess = this.<Collection<UIDeliverPatientCheckCategory>>onSuccess(_function);
    _service.loadDeliverPatientCheckCategoryList(_onSuccess);
  }
  
  public void _eventbus_DeliverPatientCheckCategorysChanged() {
    
    this.refresh();
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckCategorysChangedEvent.__type__, new com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckCategorysChangedHandler(){
    public void DeliverPatientCheckCategorysChanged(){
    	_eventbus_DeliverPatientCheckCategorysChanged();
    }
    }));
    
  }
}
