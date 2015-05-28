package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCGasMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.GasMeasureDeviceListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.measure.GasMeasureDeviceListPresenterView;
import com.fudanmed.platform.core.web.shared.measure.UIGasMeasureDevice;
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

public class GasMeasureDeviceListPresenter extends WorkbenchAbstractPresenter<GasMeasureDeviceListPresenterView> {
  @Inject
  protected GasMeasureDeviceListPresenterServiceAsync _service;
  
  @Inject
  public GasMeasureDeviceListPresenter(final GasMeasureDeviceListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private RCGasMeasureDeviceTypeProxy context;
  
  public void setup(final RCGasMeasureDeviceTypeProxy context, final IPresenterInitiazerNotifier<GasMeasureDeviceListPresenter> _notifier) {
    
    this.context = context;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          GasMeasureDeviceListPresenter.this.refresh();_notifier.done(GasMeasureDeviceListPresenter.this);
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
      final Procedure1<Collection<UIGasMeasureDevice>> _function = new Procedure1<Collection<UIGasMeasureDevice>>() {
          public void apply(final Collection<UIGasMeasureDevice> items) {
            getView().setResults(items);
            
          }
        };
      AsyncCallback<Collection<UIGasMeasureDevice>> _onSuccess = this.<Collection<UIGasMeasureDevice>>onSuccess(_function);
      _service.loadGasMeasureDeviceList(this.context, _onSuccess);
    }
  }
  
  public void _eventbus_GasMeasureDevicesChanged() {
    
    this.refresh();
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.measure.GasMeasureDevicesChangedEvent.__type__, new com.fudanmed.platform.core.web.client.measure.GasMeasureDevicesChangedHandler(){
    public void GasMeasureDevicesChanged(){
    	_eventbus_GasMeasureDevicesChanged();
    }
    }));
    
  }
}
