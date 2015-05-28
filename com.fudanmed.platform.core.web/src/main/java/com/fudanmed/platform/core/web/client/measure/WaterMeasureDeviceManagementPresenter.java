package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.WaterMeasureDeviceListPresenter;
import com.fudanmed.platform.core.web.client.measure.WaterMeasureDeviceManagementPresenterView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class WaterMeasureDeviceManagementPresenter extends WorkbenchAbstractPresenter<WaterMeasureDeviceManagementPresenterView> {
  @Inject
  public WaterMeasureDeviceManagementPresenter(final WaterMeasureDeviceManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public WaterMeasureDeviceListPresenter initPart(final WaterMeasureDeviceListPresenter part) {
    this.registerPart(part);
    this.getView().setQueryListPresenter(part);
    return part;
    
  }
  
  @Inject
  private WaterMeasureDeviceListPresenter queryListPresenter;
  
  public void setup(final RCWaterMeasureDeviceTypeProxy context, final IPresenterInitiazerNotifier<WaterMeasureDeviceManagementPresenter> _notifier) {
    
    WaterMeasureDeviceListPresenter _initPart = this.initPart(this.queryListPresenter);
    final Procedure1<WaterMeasureDeviceListPresenter> _function = new Procedure1<WaterMeasureDeviceListPresenter>() {
        public void apply(final WaterMeasureDeviceListPresenter it) {
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {
                WaterMeasureDeviceManagementPresenterView _view = WaterMeasureDeviceManagementPresenter.this.getView();
                _view.setContext(context);_notifier.done(WaterMeasureDeviceManagementPresenter.this);
              }
            };
          WaterMeasureDeviceManagementPresenter.this.activate(new IPostInitializeAction() {
              public void initializeFinished(Void v) {
                _function.apply(v);
              }
          });
        }
      };
    _initPart.setup(context, new IPresenterInitiazerNotifier<WaterMeasureDeviceListPresenter>() {
        public void done(WaterMeasureDeviceListPresenter presenter) {
          _function.apply(presenter);
        }
    });
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
