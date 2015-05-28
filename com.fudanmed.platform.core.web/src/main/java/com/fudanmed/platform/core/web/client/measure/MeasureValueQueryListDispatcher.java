package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCGasMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureDeviceProxy;
import com.fudanmed.platform.core.web.client.measure.ElectricMeasureValueQueryListPresenter;
import com.fudanmed.platform.core.web.client.measure.GasMeasureValueQueryListPresenter;
import com.fudanmed.platform.core.web.client.measure.PhasedElectricMeasureValueQueryListPresenter;
import com.fudanmed.platform.core.web.client.measure.WaterMeasureValueQueryListPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.client.common.widgets.IPresenterContainer;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class MeasureValueQueryListDispatcher extends BaseContextAwareSingleObjectCommand<RCMeasureDeviceProxy> implements IContextConsumer<RCMeasureDeviceProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.MeasureValueQueryListDispatcher";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final RCMeasureDeviceProxy value) {
    boolean _matched = false;
    if (!_matched) {
      if (value instanceof RCElectricMeasureDeviceProxy) {
        final RCElectricMeasureDeviceProxy _rCElectricMeasureDeviceProxy = (RCElectricMeasureDeviceProxy)value;
        _matched=true;
        ElectricMeasureValueQueryListPresenter _get = this.electricMeasureValueQueryListPresenter.get();
        final Procedure1<ElectricMeasureValueQueryListPresenter> _function = new Procedure1<ElectricMeasureValueQueryListPresenter>() {
            public void apply(final ElectricMeasureValueQueryListPresenter it) {
              MeasureValueQueryListDispatcher.this.container.showActivatedPresenter(it);
            }
          };
        _get.setup(_rCElectricMeasureDeviceProxy, new IPresenterInitiazerNotifier<ElectricMeasureValueQueryListPresenter>() {
            public void done(ElectricMeasureValueQueryListPresenter presenter) {
              _function.apply(presenter);
            }
        });
      }
    }
    if (!_matched) {
      if (value instanceof RCPhasedElectricMeasureDeviceProxy) {
        final RCPhasedElectricMeasureDeviceProxy _rCPhasedElectricMeasureDeviceProxy = (RCPhasedElectricMeasureDeviceProxy)value;
        _matched=true;
        PhasedElectricMeasureValueQueryListPresenter _get = this.phasedElectricMeasureValueQueryListPresenter.get();
        final Procedure1<PhasedElectricMeasureValueQueryListPresenter> _function = new Procedure1<PhasedElectricMeasureValueQueryListPresenter>() {
            public void apply(final PhasedElectricMeasureValueQueryListPresenter it) {
              MeasureValueQueryListDispatcher.this.container.showActivatedPresenter(it);
            }
          };
        _get.setup(_rCPhasedElectricMeasureDeviceProxy, new IPresenterInitiazerNotifier<PhasedElectricMeasureValueQueryListPresenter>() {
            public void done(PhasedElectricMeasureValueQueryListPresenter presenter) {
              _function.apply(presenter);
            }
        });
      }
    }
    if (!_matched) {
      if (value instanceof RCWaterMeasureDeviceProxy) {
        final RCWaterMeasureDeviceProxy _rCWaterMeasureDeviceProxy = (RCWaterMeasureDeviceProxy)value;
        _matched=true;
        WaterMeasureValueQueryListPresenter _get = this.waterMeasureValueQueryListPresenter.get();
        final Procedure1<WaterMeasureValueQueryListPresenter> _function = new Procedure1<WaterMeasureValueQueryListPresenter>() {
            public void apply(final WaterMeasureValueQueryListPresenter it) {
              MeasureValueQueryListDispatcher.this.container.showActivatedPresenter(it);
            }
          };
        _get.setup(_rCWaterMeasureDeviceProxy, new IPresenterInitiazerNotifier<WaterMeasureValueQueryListPresenter>() {
            public void done(WaterMeasureValueQueryListPresenter presenter) {
              _function.apply(presenter);
            }
        });
      }
    }
    if (!_matched) {
      if (value instanceof RCGasMeasureDeviceProxy) {
        final RCGasMeasureDeviceProxy _rCGasMeasureDeviceProxy = (RCGasMeasureDeviceProxy)value;
        _matched=true;
        GasMeasureValueQueryListPresenter _get = this.gasMeasureValueQueryListPresenter.get();
        final Procedure1<GasMeasureValueQueryListPresenter> _function = new Procedure1<GasMeasureValueQueryListPresenter>() {
            public void apply(final GasMeasureValueQueryListPresenter it) {
              MeasureValueQueryListDispatcher.this.container.showActivatedPresenter(it);
            }
          };
        _get.setup(_rCGasMeasureDeviceProxy, new IPresenterInitiazerNotifier<GasMeasureValueQueryListPresenter>() {
            public void done(GasMeasureValueQueryListPresenter presenter) {
              _function.apply(presenter);
            }
        });
      }
    }
  }
  
  public IPresenterContainer container;
  
  @Inject
  private Provider<ElectricMeasureValueQueryListPresenter> electricMeasureValueQueryListPresenter;
  
  @Inject
  private Provider<PhasedElectricMeasureValueQueryListPresenter> phasedElectricMeasureValueQueryListPresenter;
  
  @Inject
  private Provider<WaterMeasureValueQueryListPresenter> waterMeasureValueQueryListPresenter;
  
  @Inject
  private Provider<GasMeasureValueQueryListPresenter> gasMeasureValueQueryListPresenter;
}
