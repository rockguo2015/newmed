package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.ElectricMeasureDeviceListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.measure.ElectricMeasureDeviceListPresenterView;
import com.fudanmed.platform.core.web.shared.measure.UIElectricMeasureDevice;
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

public class ElectricMeasureDeviceListPresenter extends WorkbenchAbstractPresenter<ElectricMeasureDeviceListPresenterView> {
  @Inject
  protected ElectricMeasureDeviceListPresenterServiceAsync _service;
  
  @Inject
  public ElectricMeasureDeviceListPresenter(final ElectricMeasureDeviceListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private RCElectricMeasureDeviceTypeProxy context;
  
  public void setup(final RCElectricMeasureDeviceTypeProxy context, final IPresenterInitiazerNotifier<ElectricMeasureDeviceListPresenter> _notifier) {
    
    this.context = context;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          ElectricMeasureDeviceListPresenter.this.refresh();_notifier.done(ElectricMeasureDeviceListPresenter.this);
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
      final Procedure1<Collection<UIElectricMeasureDevice>> _function = new Procedure1<Collection<UIElectricMeasureDevice>>() {
          public void apply(final Collection<UIElectricMeasureDevice> items) {
            getView().setResults(items);
            
          }
        };
      AsyncCallback<Collection<UIElectricMeasureDevice>> _onSuccess = this.<Collection<UIElectricMeasureDevice>>onSuccess(_function);
      _service.loadElectricMeasureDeviceList(this.context, _onSuccess);
    }
  }
  
  public void _eventbus_ElectricMeasureDevicesChanged() {
    
    this.refresh();
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.measure.ElectricMeasureDevicesChangedEvent.__type__, new com.fudanmed.platform.core.web.client.measure.ElectricMeasureDevicesChangedHandler(){
    public void ElectricMeasureDevicesChanged(){
    	_eventbus_ElectricMeasureDevicesChanged();
    }
    }));
    
  }
}
