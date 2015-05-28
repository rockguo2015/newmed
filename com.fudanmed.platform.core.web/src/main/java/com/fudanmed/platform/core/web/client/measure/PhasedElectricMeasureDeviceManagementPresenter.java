package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.PhasedElectricMeasureDeviceListPresenter;
import com.fudanmed.platform.core.web.client.measure.PhasedElectricMeasureDeviceManagementPresenterView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class PhasedElectricMeasureDeviceManagementPresenter extends WorkbenchAbstractPresenter<PhasedElectricMeasureDeviceManagementPresenterView> {
  @Inject
  public PhasedElectricMeasureDeviceManagementPresenter(final PhasedElectricMeasureDeviceManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public PhasedElectricMeasureDeviceListPresenter initPart(final PhasedElectricMeasureDeviceListPresenter part) {
    this.registerPart(part);
    this.getView().setQueryListPresenter(part);
    return part;
    
  }
  
  @Inject
  private PhasedElectricMeasureDeviceListPresenter queryListPresenter;
  
  public void setup(final RCPhasedElectricMeasureDeviceTypeProxy context, final IPresenterInitiazerNotifier<PhasedElectricMeasureDeviceManagementPresenter> _notifier) {
    
    PhasedElectricMeasureDeviceListPresenter _initPart = this.initPart(this.queryListPresenter);
    final Procedure1<PhasedElectricMeasureDeviceListPresenter> _function = new Procedure1<PhasedElectricMeasureDeviceListPresenter>() {
        public void apply(final PhasedElectricMeasureDeviceListPresenter it) {
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {
                PhasedElectricMeasureDeviceManagementPresenterView _view = PhasedElectricMeasureDeviceManagementPresenter.this.getView();
                _view.setContext(context);_notifier.done(PhasedElectricMeasureDeviceManagementPresenter.this);
              }
            };
          PhasedElectricMeasureDeviceManagementPresenter.this.activate(new IPostInitializeAction() {
              public void initializeFinished(Void v) {
                _function.apply(v);
              }
          });
        }
      };
    _initPart.setup(context, new IPresenterInitiazerNotifier<PhasedElectricMeasureDeviceListPresenter>() {
        public void done(PhasedElectricMeasureDeviceListPresenter presenter) {
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
