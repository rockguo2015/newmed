package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.measure.proxy.RCGasMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.ElectricMeasureDeviceManagementPresenter;
import com.fudanmed.platform.core.web.client.measure.GasMeasureDeviceManagementPresenter;
import com.fudanmed.platform.core.web.client.measure.PhasedElectricMeasureDeviceManagementPresenter;
import com.fudanmed.platform.core.web.client.measure.WaterMeasureDeviceManagementPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.client.common.widgets.IPresenterContainer;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DeviceListDispatcher extends BaseContextAwareSingleObjectCommand<RCMeasureDeviceTypeProxy> implements IContextConsumer<RCMeasureDeviceTypeProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.DeviceListDispatcher";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final RCMeasureDeviceTypeProxy value) {
    boolean _matched = false;
    if (!_matched) {
      if (value instanceof RCPhasedElectricMeasureDeviceTypeProxy) {
        final RCPhasedElectricMeasureDeviceTypeProxy _rCPhasedElectricMeasureDeviceTypeProxy = (RCPhasedElectricMeasureDeviceTypeProxy)value;
        _matched=true;
        PhasedElectricMeasureDeviceManagementPresenter _get = this.phasedElectricMeasureDeviceManagementPresenter.get();
        final Procedure1<PhasedElectricMeasureDeviceManagementPresenter> _function = new Procedure1<PhasedElectricMeasureDeviceManagementPresenter>() {
            public void apply(final PhasedElectricMeasureDeviceManagementPresenter it) {
              DeviceListDispatcher.this.container.showActivatedPresenter(it);
            }
          };
        _get.setup(_rCPhasedElectricMeasureDeviceTypeProxy, new IPresenterInitiazerNotifier<PhasedElectricMeasureDeviceManagementPresenter>() {
            public void done(PhasedElectricMeasureDeviceManagementPresenter presenter) {
              _function.apply(presenter);
            }
        });
      }
    }
    if (!_matched) {
      if (value instanceof RCElectricMeasureDeviceTypeProxy) {
        final RCElectricMeasureDeviceTypeProxy _rCElectricMeasureDeviceTypeProxy = (RCElectricMeasureDeviceTypeProxy)value;
        _matched=true;
        ElectricMeasureDeviceManagementPresenter _get = this.electricMeasureDeviceManagementPresenter.get();
        final Procedure1<ElectricMeasureDeviceManagementPresenter> _function = new Procedure1<ElectricMeasureDeviceManagementPresenter>() {
            public void apply(final ElectricMeasureDeviceManagementPresenter it) {
              DeviceListDispatcher.this.container.showActivatedPresenter(it);
            }
          };
        _get.setup(_rCElectricMeasureDeviceTypeProxy, new IPresenterInitiazerNotifier<ElectricMeasureDeviceManagementPresenter>() {
            public void done(ElectricMeasureDeviceManagementPresenter presenter) {
              _function.apply(presenter);
            }
        });
      }
    }
    if (!_matched) {
      if (value instanceof RCWaterMeasureDeviceTypeProxy) {
        final RCWaterMeasureDeviceTypeProxy _rCWaterMeasureDeviceTypeProxy = (RCWaterMeasureDeviceTypeProxy)value;
        _matched=true;
        WaterMeasureDeviceManagementPresenter _get = this.waterMeasureDeviceManagementPresenter.get();
        final Procedure1<WaterMeasureDeviceManagementPresenter> _function = new Procedure1<WaterMeasureDeviceManagementPresenter>() {
            public void apply(final WaterMeasureDeviceManagementPresenter it) {
              DeviceListDispatcher.this.container.showActivatedPresenter(it);
            }
          };
        _get.setup(_rCWaterMeasureDeviceTypeProxy, new IPresenterInitiazerNotifier<WaterMeasureDeviceManagementPresenter>() {
            public void done(WaterMeasureDeviceManagementPresenter presenter) {
              _function.apply(presenter);
            }
        });
      }
    }
    if (!_matched) {
      if (value instanceof RCGasMeasureDeviceTypeProxy) {
        final RCGasMeasureDeviceTypeProxy _rCGasMeasureDeviceTypeProxy = (RCGasMeasureDeviceTypeProxy)value;
        _matched=true;
        GasMeasureDeviceManagementPresenter _get = this.gasMeasureDeviceManagementPresenter.get();
        final Procedure1<GasMeasureDeviceManagementPresenter> _function = new Procedure1<GasMeasureDeviceManagementPresenter>() {
            public void apply(final GasMeasureDeviceManagementPresenter it) {
              DeviceListDispatcher.this.container.showActivatedPresenter(it);
            }
          };
        _get.setup(_rCGasMeasureDeviceTypeProxy, new IPresenterInitiazerNotifier<GasMeasureDeviceManagementPresenter>() {
            public void done(GasMeasureDeviceManagementPresenter presenter) {
              _function.apply(presenter);
            }
        });
      }
    }
  }
  
  @Inject
  private Provider<PhasedElectricMeasureDeviceManagementPresenter> phasedElectricMeasureDeviceManagementPresenter;
  
  @Inject
  private Provider<ElectricMeasureDeviceManagementPresenter> electricMeasureDeviceManagementPresenter;
  
  @Inject
  private Provider<WaterMeasureDeviceManagementPresenter> waterMeasureDeviceManagementPresenter;
  
  @Inject
  private Provider<GasMeasureDeviceManagementPresenter> gasMeasureDeviceManagementPresenter;
  
  public IPresenterContainer container;
}
