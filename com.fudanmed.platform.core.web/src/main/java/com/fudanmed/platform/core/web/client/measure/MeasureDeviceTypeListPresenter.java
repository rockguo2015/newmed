package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.client.measure.MeasureDeviceTypeListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.measure.MeasureDeviceTypeListPresenterView;
import com.fudanmed.platform.core.web.shared.measure.UIMeasureDeviceType;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class MeasureDeviceTypeListPresenter extends WorkbenchAbstractPresenter<MeasureDeviceTypeListPresenterView> {
  @Inject
  protected MeasureDeviceTypeListPresenterServiceAsync _service;
  
  @Inject
  public MeasureDeviceTypeListPresenter(final MeasureDeviceTypeListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final IPresenterInitiazerNotifier<MeasureDeviceTypeListPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          MeasureDeviceTypeListPresenter.this.refresh();_notifier.done(MeasureDeviceTypeListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void refresh() {
    
    final Procedure1<Collection<UIMeasureDeviceType>> _function = new Procedure1<Collection<UIMeasureDeviceType>>() {
        public void apply(final Collection<UIMeasureDeviceType> items) {
          getView().setResults(items);
          
        }
      };
    AsyncCallback<Collection<UIMeasureDeviceType>> _onSuccess = this.<Collection<UIMeasureDeviceType>>onSuccess(_function);
    _service.loadMeasureDeviceTypeList(_onSuccess);
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
