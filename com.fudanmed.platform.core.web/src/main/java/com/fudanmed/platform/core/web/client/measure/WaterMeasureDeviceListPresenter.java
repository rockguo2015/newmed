package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.WaterMeasureDeviceListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.measure.WaterMeasureDeviceListPresenterView;
import com.fudanmed.platform.core.web.shared.measure.UIWaterMeasureDevice;
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

public class WaterMeasureDeviceListPresenter extends WorkbenchAbstractPresenter<WaterMeasureDeviceListPresenterView> {
  @Inject
  protected WaterMeasureDeviceListPresenterServiceAsync _service;
  
  @Inject
  public WaterMeasureDeviceListPresenter(final WaterMeasureDeviceListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private RCWaterMeasureDeviceTypeProxy context;
  
  public void setup(final RCWaterMeasureDeviceTypeProxy context, final IPresenterInitiazerNotifier<WaterMeasureDeviceListPresenter> _notifier) {
    
    this.context = context;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          WaterMeasureDeviceListPresenter.this.refresh();_notifier.done(WaterMeasureDeviceListPresenter.this);
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
      final Procedure1<Collection<UIWaterMeasureDevice>> _function = new Procedure1<Collection<UIWaterMeasureDevice>>() {
          public void apply(final Collection<UIWaterMeasureDevice> items) {
            getView().setResults(items);
            
          }
        };
      AsyncCallback<Collection<UIWaterMeasureDevice>> _onSuccess = this.<Collection<UIWaterMeasureDevice>>onSuccess(_function);
      _service.loadWaterMeasureDeviceList(this.context, _onSuccess);
    }
  }
  
  public void _eventbus_WaterMeasureDevicesChanged() {
    
    this.refresh();
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.measure.WaterMeasureDevicesChangedEvent.__type__, new com.fudanmed.platform.core.web.client.measure.WaterMeasureDevicesChangedHandler(){
    public void WaterMeasureDevicesChanged(){
    	_eventbus_WaterMeasureDevicesChanged();
    }
    }));
    
  }
}
