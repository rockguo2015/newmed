package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.MeasureDeviceListPresenter;
import com.fudanmed.platform.core.web.client.measure.MeasureDeviceTypeListPresenter;
import com.fudanmed.platform.core.web.client.measure.MeasureDeviceTypeListPresenterView;
import com.fudanmed.platform.core.web.client.measure.MeasureDeviceValueManagementPresenterView;
import com.fudanmed.platform.core.web.shared.measure.UIMeasureDeviceType;
import com.google.common.base.Function;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class MeasureDeviceValueManagementPresenter extends WorkbenchAbstractPresenter<MeasureDeviceValueManagementPresenterView> {
  @Inject
  public MeasureDeviceValueManagementPresenter(final MeasureDeviceValueManagementPresenterView display, final EventBus eventBus) {
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
  
  public void setup(final IPresenterInitiazerNotifier<MeasureDeviceValueManagementPresenter> _notifier) {
    
    MeasureDeviceTypeListPresenter _initPart = this.initPart(this.measureDeviceTypeListPresenter);
    final Procedure1<MeasureDeviceTypeListPresenter> _function = new Procedure1<MeasureDeviceTypeListPresenter>() {
        public void apply(final MeasureDeviceTypeListPresenter it) {
          MeasureDeviceListPresenter _initPart = MeasureDeviceValueManagementPresenter.this.initPart(MeasureDeviceValueManagementPresenter.this.measureDeviceListPresenter);
          final Procedure1<MeasureDeviceListPresenter> _function = new Procedure1<MeasureDeviceListPresenter>() {
              public void apply(final MeasureDeviceListPresenter it) {
                final Procedure1<Void> _function = new Procedure1<Void>() {
                    public void apply(final Void it) {
                      MeasureDeviceTypeListPresenterView _view = MeasureDeviceValueManagementPresenter.this.measureDeviceTypeListPresenter.getView();
                      ActionContext<UIMeasureDeviceType> _actionContext = _view.getActionContext();
                      final Function1<UIMeasureDeviceType,RCMeasureDeviceTypeProxy> _function = new Function1<UIMeasureDeviceType,RCMeasureDeviceTypeProxy>() {
                          public RCMeasureDeviceTypeProxy apply(final UIMeasureDeviceType it) {
                            RCMeasureDeviceTypeProxy _proxy = it.toProxy();
                            return _proxy;
                          }
                        };
                      ActionContext<RCMeasureDeviceTypeProxy> _adapt = _actionContext.<RCMeasureDeviceTypeProxy>adapt(new Function<UIMeasureDeviceType,RCMeasureDeviceTypeProxy>() {
                          public RCMeasureDeviceTypeProxy apply(UIMeasureDeviceType input) {
                            return _function.apply(input);
                          }
                      });
                      MeasureDeviceValueManagementPresenter.this.measureDeviceListPresenter.setContext(_adapt);_notifier.done(MeasureDeviceValueManagementPresenter.this);
                    }
                  };
                MeasureDeviceValueManagementPresenter.this.activate(new IPostInitializeAction() {
                    public void initializeFinished(Void v) {
                      _function.apply(v);
                    }
                });
              }
            };
          _initPart.setup(new IPresenterInitiazerNotifier<MeasureDeviceListPresenter>() {
              public void done(MeasureDeviceListPresenter presenter) {
                _function.apply(presenter);
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
