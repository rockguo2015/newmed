package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.DeliverMaterialCategoryListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.deliver.DeliverMaterialCategoryListPresenterView;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialCategory;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DeliverMaterialCategoryListPresenter extends WorkbenchAbstractPresenter<DeliverMaterialCategoryListPresenterView> {
  @Inject
  protected DeliverMaterialCategoryListPresenterServiceAsync _service;
  
  @Inject
  public DeliverMaterialCategoryListPresenter(final DeliverMaterialCategoryListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final IPresenterInitiazerNotifier<DeliverMaterialCategoryListPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          DeliverMaterialCategoryListPresenter.this.refresh();_notifier.done(DeliverMaterialCategoryListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void refresh() {
    
    final Procedure1<Collection<UIDeliverMaterialCategory>> _function = new Procedure1<Collection<UIDeliverMaterialCategory>>() {
        public void apply(final Collection<UIDeliverMaterialCategory> items) {
          getView().setResults(items);
          
        }
      };
    AsyncCallback<Collection<UIDeliverMaterialCategory>> _onSuccess = this.<Collection<UIDeliverMaterialCategory>>onSuccess(_function);
    _service.loadDeliverMaterialCategoryList(_onSuccess);
  }
  
  public void _eventbus_DeliverMaterialCategorysChanged() {
    
    this.refresh();
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.deliver.DeliverMaterialCategorysChangedEvent.__type__, new com.fudanmed.platform.core.web.client.deliver.DeliverMaterialCategorysChangedHandler(){
    public void DeliverMaterialCategorysChanged(){
    	_eventbus_DeliverMaterialCategorysChanged();
    }
    }));
    
  }
}
