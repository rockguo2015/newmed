package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.client.measure.MeasureDeviceListPresenter;
import com.fudanmed.platform.core.web.client.measure.MeasureDeviceManagementPresenterView;
import com.fudanmed.platform.core.web.client.measure.MeasureDeviceTypeListPresenter;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class MeasureDeviceManagementPresenter extends WorkbenchAbstractPresenter<MeasureDeviceManagementPresenterView> {
  @Inject
  public MeasureDeviceManagementPresenter(final MeasureDeviceManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public MeasureDeviceTypeListPresenter initPart(final MeasureDeviceTypeListPresenter part) {
    this.registerPart(part);
    this.getView().setMeasureDeviceTypeListPresenter(part);
    return part;
    
  }
  
  @Inject
  private MeasureDeviceTypeListPresenter measureDeviceTypeListPresenter;
  
  public MeasureDeviceListPresenter initPart(final MeasureDeviceListPresenter part) {
    this.registerPart(part);
    this.getView().setMeasureDeviceListPresenter(part);
    return part;
    
  }
  
  @Inject
  private MeasureDeviceListPresenter measureDeviceListPresenter;
  
  public void setup(final IPresenterInitiazerNotifier<MeasureDeviceManagementPresenter> _notifier) {
    
    MeasureDeviceTypeListPresenter _initPart = this.initPart(this.measureDeviceTypeListPresenter);
    final Procedure1<MeasureDeviceTypeListPresenter> _function = new Procedure1<MeasureDeviceTypeListPresenter>() {
        public void apply(final MeasureDeviceTypeListPresenter it) {
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {_notifier.done(MeasureDeviceManagementPresenter.this);
              }
            };
          MeasureDeviceManagementPresenter.this.activate(new IPostInitializeAction() {
              public void initializeFinished(Void v) {
                _function.apply(v);
              }
          });
        }
      };
    _initPart.setup(new IPresenterInitiazerNotifier<MeasureDeviceTypeListPresenter>() {
        public void done(MeasureDeviceTypeListPresenter presenter) {
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
