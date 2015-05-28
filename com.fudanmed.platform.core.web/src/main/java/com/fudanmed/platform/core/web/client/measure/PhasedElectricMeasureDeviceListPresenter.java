package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.PhasedElectricMeasureDeviceListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.measure.PhasedElectricMeasureDeviceListPresenterView;
import com.fudanmed.platform.core.web.shared.measure.UIPhasedElectricMeasureDevice;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class PhasedElectricMeasureDeviceListPresenter extends WorkbenchAbstractPresenter<PhasedElectricMeasureDeviceListPresenterView> {
  @Inject
  protected PhasedElectricMeasureDeviceListPresenterServiceAsync _service;
  
  @Inject
  public PhasedElectricMeasureDeviceListPresenter(final PhasedElectricMeasureDeviceListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private RCPhasedElectricMeasureDeviceTypeProxy context;
  
  public void setup(final RCPhasedElectricMeasureDeviceTypeProxy context, final IPresenterInitiazerNotifier<PhasedElectricMeasureDeviceListPresenter> _notifier) {
    
    this.context = context;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          PhasedElectricMeasureDeviceListPresenter.this.refresh();_notifier.done(PhasedElectricMeasureDeviceListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void refresh() {
    
    boolean _notEquals = (!Objects.equal(this.context, null));
    if (_notEquals) {
      final Procedure1<Collection<UIPhasedElectricMeasureDevice>> _function = new Procedure1<Collection<UIPhasedElectricMeasureDevice>>() {
          public void apply(final Collection<UIPhasedElectricMeasureDevice> items) {
            getView().setResults(items);
            
          }
        };
      AsyncCallback<Collection<UIPhasedElectricMeasureDevice>> _onSuccess = this.<Collection<UIPhasedElectricMeasureDevice>>onSuccess(_function);
      _service.loadPhasedElectricMeasureDeviceList(this.context, _onSuccess);
    }
  }
  
  public void _eventbus_PhasedElectricMeasureDevicesChanged() {
    
    this.refresh();
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.measure.PhasedElectricMeasureDevicesChangedEvent.__type__, new com.fudanmed.platform.core.web.client.measure.PhasedElectricMeasureDevicesChangedHandler(){
    public void PhasedElectricMeasureDevicesChanged(){
    	_eventbus_PhasedElectricMeasureDevicesChanged();
    }
    }));
    
  }
}
