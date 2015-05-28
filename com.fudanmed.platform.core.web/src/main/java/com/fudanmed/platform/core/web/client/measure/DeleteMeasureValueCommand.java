package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureValueProxy;
import com.fudanmed.platform.core.measure.proxy.RCMeasureValueProxy;
import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureValueProxy;
import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureValueProxy;
import com.fudanmed.platform.core.web.client.measure.DeleteElectricMeasureValueCommand;
import com.fudanmed.platform.core.web.client.measure.DeletePhasedElectricMeasureValueCommand;
import com.fudanmed.platform.core.web.client.measure.DeleteWaterMeasureValueCommand;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.InputOutput;

public class DeleteMeasureValueCommand extends BaseContextAwareSingleObjectCommand<RCMeasureValueProxy> implements IContextConsumer<RCMeasureValueProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "删除";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.DeleteMeasureValueCommand";
  }
  
  public void execute(final RCMeasureValueProxy value) {
    boolean _matched = false;
    if (!_matched) {
      if (value instanceof RCWaterMeasureValueProxy) {
        final RCWaterMeasureValueProxy _rCWaterMeasureValueProxy = (RCWaterMeasureValueProxy)value;
        _matched=true;
        DeleteWaterMeasureValueCommand _get = this.deleteWaterMeasureValueCommand.get();
        _get.execute(_rCWaterMeasureValueProxy);
      }
    }
    if (!_matched) {
      if (value instanceof RCPhasedElectricMeasureValueProxy) {
        final RCPhasedElectricMeasureValueProxy _rCPhasedElectricMeasureValueProxy = (RCPhasedElectricMeasureValueProxy)value;
        _matched=true;
        DeletePhasedElectricMeasureValueCommand _get = this.deletePhasedElectricMeasureValueCommand.get();
        _get.execute(_rCPhasedElectricMeasureValueProxy);
      }
    }
    if (!_matched) {
      if (value instanceof RCElectricMeasureValueProxy) {
        final RCElectricMeasureValueProxy _rCElectricMeasureValueProxy = (RCElectricMeasureValueProxy)value;
        _matched=true;
        DeleteElectricMeasureValueCommand _get = this.deleteElectricMeasureValueCommand.get();
        _get.execute(_rCElectricMeasureValueProxy);
      }
    }
    if (!_matched) {
      InputOutput.<String>println("not implemented");
    }
  }
  
  @Inject
  private Provider<DeleteWaterMeasureValueCommand> deleteWaterMeasureValueCommand;
  
  @Inject
  private Provider<DeletePhasedElectricMeasureValueCommand> deletePhasedElectricMeasureValueCommand;
  
  @Inject
  private Provider<DeleteElectricMeasureValueCommand> deleteElectricMeasureValueCommand;
}
