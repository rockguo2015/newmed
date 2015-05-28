package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.client.project.ComplaintListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.ComplaintListPresenterView;
import com.fudanmed.platform.core.web.shared.project.UIComplaint;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ComplaintListPresenter extends WorkbenchAbstractPresenter<ComplaintListPresenterView> {
  @Inject
  protected ComplaintListPresenterServiceAsync _service;
  
  @Inject
  public ComplaintListPresenter(final ComplaintListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private RCRepairTaskProxy context;
  
  public void setup(final Procedure1<? super ComplaintListPresenter> postInit) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          postInit.apply(ComplaintListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup(final RCRepairTaskProxy context, final Procedure1<? super ComplaintListPresenter> postInit) {
    
    this.context = context;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          ComplaintListPresenter.this.refresh();
          postInit.apply(ComplaintListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setRepairTask(final RCRepairTaskProxy context) {
    
    this.context = context;
    this.refresh();
  }
  
  public void refresh() {
    
    boolean _notEquals = (!Objects.equal(this.context, null));
    if (_notEquals) {
      final Procedure1<Collection<UIComplaint>> _function = new Procedure1<Collection<UIComplaint>>() {
          public void apply(final Collection<UIComplaint> items) {
            getView().setResults(items);
            
          }
        };
      AsyncCallback<Collection<UIComplaint>> _onSuccess = this.<Collection<UIComplaint>>onSuccess(_function);
      _service.loadComplaintList(this.context, _onSuccess);
    }
  }
  
  public void _eventbus_ComplaintsChanged() {
    
    this.refresh();
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.project.ComplaintsChangedEvent.__type__, new com.fudanmed.platform.core.web.client.project.ComplaintsChangedHandler(){
    public void ComplaintsChanged(){
    	_eventbus_ComplaintsChanged();
    }
    }));
    
  }
}
