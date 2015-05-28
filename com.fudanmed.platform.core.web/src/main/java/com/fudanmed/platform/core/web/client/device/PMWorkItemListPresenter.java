package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.web.client.device.PMWorkItemListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.PMWorkItemListPresenterView;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItem;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class PMWorkItemListPresenter extends WorkbenchAbstractPresenter<PMWorkItemListPresenterView> {
  @Inject
  protected PMWorkItemListPresenterServiceAsync _service;
  
  @Inject
  public PMWorkItemListPresenter(final PMWorkItemListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final Procedure1<? super PMWorkItemListPresenter> postInit) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          postInit.apply(PMWorkItemListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setDevice(final RCDeviceProxy device) {
    
    final Procedure1<Collection<UIPMWorkItem>> _function = new Procedure1<Collection<UIPMWorkItem>>() {
        public void apply(final Collection<UIPMWorkItem> it) {
          PMWorkItemListPresenterView _view = PMWorkItemListPresenter.this.getView();
          _view.setResults(it);
        }
      };
    AsyncCallback<Collection<UIPMWorkItem>> _onSuccess = this.<Collection<UIPMWorkItem>>onSuccess(_function);
    _service.loadPMWorkItemList(device, _onSuccess);
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    
  }
}
