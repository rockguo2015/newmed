package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureDeviceProxy;
import com.fudanmed.platform.core.web.client.measure.CreateElectricMeasureValueCommand;
import com.fudanmed.platform.core.web.client.measure.CreatePhasedElectricMeasureValueCommand;
import com.fudanmed.platform.core.web.client.measure.CreateWaterMeasureValueCommand;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.InputOutput;

public class CreateMeasureValueCommand extends BaseContextAwareSingleObjectCommand<RCMeasureDeviceProxy> implements IContextConsumer<RCMeasureDeviceProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "新建";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.CreateMeasureValueCommand";
  }
  
  public void execute(final RCMeasureDeviceProxy value) {
    boolean _matched = false;
    if (!_matched) {
      if (value instanceof RCWaterMeasureDeviceProxy) {
        final RCWaterMeasureDeviceProxy _rCWaterMeasureDeviceProxy = (RCWaterMeasureDeviceProxy)value;
        _matched=true;
        CreateWaterMeasureValueCommand _get = this.createWaterMeasureValueCommand.get();
        _get.execute(_rCWaterMeasureDeviceProxy);
      }
    }
    if (!_matched) {
      if (value instanceof RCPhasedElectricMeasureDeviceProxy) {
        final RCPhasedElectricMeasureDeviceProxy _rCPhasedElectricMeasureDeviceProxy = (RCPhasedElectricMeasureDeviceProxy)value;
        _matched=true;
        CreatePhasedElectricMeasureValueCommand _get = this.createPhasedElectricMeasureValueCommand.get();
        _get.execute(_rCPhasedElectricMeasureDeviceProxy);
      }
    }
    if (!_matched) {
      if (value instanceof RCElectricMeasureDeviceProxy) {
        final RCElectricMeasureDeviceProxy _rCElectricMeasureDeviceProxy = (RCElectricMeasureDeviceProxy)value;
        _matched=true;
        CreateElectricMeasureValueCommand _get = this.createElectricMeasureValueCommand.get();
        _get.execute(_rCElectricMeasureDeviceProxy);
      }
    }
    if (!_matched) {
      InputOutput.<String>println("not implemented");
    }
  }
  
  @Inject
  private Provider<CreateWaterMeasureValueCommand> createWaterMeasureValueCommand;
  
  @Inject
  private Provider<CreatePhasedElectricMeasureValueCommand> createPhasedElectricMeasureValueCommand;
  
  @Inject
  private Provider<CreateElectricMeasureValueCommand> createElectricMeasureValueCommand;
}
