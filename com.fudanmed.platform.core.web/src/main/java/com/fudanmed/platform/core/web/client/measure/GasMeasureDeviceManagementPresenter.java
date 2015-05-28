package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCGasMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.GasMeasureDeviceListPresenter;
import com.fudanmed.platform.core.web.client.measure.GasMeasureDeviceManagementPresenterView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class GasMeasureDeviceManagementPresenter extends WorkbenchAbstractPresenter<GasMeasureDeviceManagementPresenterView> {
  @Inject
  public GasMeasureDeviceManagementPresenter(final GasMeasureDeviceManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public GasMeasureDeviceListPresenter initPart(final GasMeasureDeviceListPresenter part) {
    this.registerPart(part);
    this.getView().setQueryListPresenter(part);
    return part;
    
  }
  
  @Inject
  private GasMeasureDeviceListPresenter queryListPresenter;
  
  public void setup(final RCGasMeasureDeviceTypeProxy context, final IPresenterInitiazerNotifier<GasMeasureDeviceManagementPresenter> _notifier) {
    
    GasMeasureDeviceListPresenter _initPart = this.initPart(this.queryListPresenter);
    final Procedure1<GasMeasureDeviceListPresenter> _function = new Procedure1<GasMeasureDeviceListPresenter>() {
        public void apply(final GasMeasureDeviceListPresenter it) {
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {
                GasMeasureDeviceManagementPresenterView _view = GasMeasureDeviceManagementPresenter.this.getView();
                _view.setContext(context);_notifier.done(GasMeasureDeviceManagementPresenter.this);
              }
            };
          GasMeasureDeviceManagementPresenter.this.activate(new IPostInitializeAction() {
              public void initializeFinished(Void v) {
                _function.apply(v);
              }
          });
        }
      };
    _initPart.setup(context, new IPresenterInitiazerNotifier<GasMeasureDeviceListPresenter>() {
        public void done(GasMeasureDeviceListPresenter presenter) {
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
