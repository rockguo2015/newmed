package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.ElectricMeasureDeviceListPresenter;
import com.fudanmed.platform.core.web.client.measure.ElectricMeasureDeviceManagementPresenterView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ElectricMeasureDeviceManagementPresenter extends WorkbenchAbstractPresenter<ElectricMeasureDeviceManagementPresenterView> {
  @Inject
  public ElectricMeasureDeviceManagementPresenter(final ElectricMeasureDeviceManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public ElectricMeasureDeviceListPresenter initPart(final ElectricMeasureDeviceListPresenter part) {
    this.registerPart(part);
    this.getView().setQueryListPresenter(part);
    return part;
    
  }
  
  @Inject
  private ElectricMeasureDeviceListPresenter queryListPresenter;
  
  public void setup(final RCElectricMeasureDeviceTypeProxy context, final IPresenterInitiazerNotifier<ElectricMeasureDeviceManagementPresenter> _notifier) {
    
    ElectricMeasureDeviceListPresenter _initPart = this.initPart(this.queryListPresenter);
    final Procedure1<ElectricMeasureDeviceListPresenter> _function = new Procedure1<ElectricMeasureDeviceListPresenter>() {
        public void apply(final ElectricMeasureDeviceListPresenter it) {
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {
                ElectricMeasureDeviceManagementPresenterView _view = ElectricMeasureDeviceManagementPresenter.this.getView();
                _view.setContext(context);_notifier.done(ElectricMeasureDeviceManagementPresenter.this);
              }
            };
          ElectricMeasureDeviceManagementPresenter.this.activate(new IPostInitializeAction() {
              public void initializeFinished(Void v) {
                _function.apply(v);
              }
          });
        }
      };
    _initPart.setup(context, new IPresenterInitiazerNotifier<ElectricMeasureDeviceListPresenter>() {
        public void done(ElectricMeasureDeviceListPresenter presenter) {
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
