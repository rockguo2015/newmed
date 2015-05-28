package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureValueProxy;
import com.fudanmed.platform.core.measure.proxy.RCMeasureValueProxy;
import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureValueProxy;
import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureValueProxy;
import com.fudanmed.platform.core.web.client.measure.UpdateElectricMeasureValueCommand;
import com.fudanmed.platform.core.web.client.measure.UpdatePhasedElectricMeasureValueCommand;
import com.fudanmed.platform.core.web.client.measure.UpdateWaterMeasureValueCommand;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.InputOutput;

public class ModifyMeasureValueCommand extends BaseContextAwareSingleObjectCommand<RCMeasureValueProxy> implements IContextConsumer<RCMeasureValueProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "修改";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.ModifyMeasureValueCommand";
  }
  
  public void execute(final RCMeasureValueProxy value) {
    boolean _matched = false;
    if (!_matched) {
      if (value instanceof RCWaterMeasureValueProxy) {
        final RCWaterMeasureValueProxy _rCWaterMeasureValueProxy = (RCWaterMeasureValueProxy)value;
        _matched=true;
        UpdateWaterMeasureValueCommand _get = this.updateWaterMeasureValueCommand.get();
        _get.execute(_rCWaterMeasureValueProxy);
      }
    }
    if (!_matched) {
      if (value instanceof RCPhasedElectricMeasureValueProxy) {
        final RCPhasedElectricMeasureValueProxy _rCPhasedElectricMeasureValueProxy = (RCPhasedElectricMeasureValueProxy)value;
        _matched=true;
        UpdatePhasedElectricMeasureValueCommand _get = this.updatePhasedElectricMeasureValueCommand.get();
        _get.execute(_rCPhasedElectricMeasureValueProxy);
      }
    }
    if (!_matched) {
      if (value instanceof RCElectricMeasureValueProxy) {
        final RCElectricMeasureValueProxy _rCElectricMeasureValueProxy = (RCElectricMeasureValueProxy)value;
        _matched=true;
        UpdateElectricMeasureValueCommand _get = this.updateElectricMeasureValueCommand.get();
        _get.execute(_rCElectricMeasureValueProxy);
      }
    }
    if (!_matched) {
      InputOutput.<String>println("not implemented");
    }
  }
  
  @Inject
  private Provider<UpdateWaterMeasureValueCommand> updateWaterMeasureValueCommand;
  
  @Inject
  private Provider<UpdatePhasedElectricMeasureValueCommand> updatePhasedElectricMeasureValueCommand;
  
  @Inject
  private Provider<UpdateElectricMeasureValueCommand> updateElectricMeasureValueCommand;
}
