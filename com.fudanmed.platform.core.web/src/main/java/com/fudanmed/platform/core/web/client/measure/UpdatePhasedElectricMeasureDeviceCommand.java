package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureDeviceProxy;
import com.fudanmed.platform.core.web.client.measure.CreateOrUpdatePhasedElectricMeasureDevicePresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class UpdatePhasedElectricMeasureDeviceCommand extends BaseContextAwareSingleObjectCommand<RCPhasedElectricMeasureDeviceProxy> implements IContextConsumer<RCPhasedElectricMeasureDeviceProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "修改";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.UpdatePhasedElectricMeasureDeviceCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final RCPhasedElectricMeasureDeviceProxy value) {
    CreateOrUpdatePhasedElectricMeasureDevicePresenter _get = this.createOrUpdatePhasedElectricMeasureDevicePresenter.get();
    final Procedure1<CreateOrUpdatePhasedElectricMeasureDevicePresenter> _function = new Procedure1<CreateOrUpdatePhasedElectricMeasureDevicePresenter>() {
        public void apply(final CreateOrUpdatePhasedElectricMeasureDevicePresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Update(value, new IPresenterInitiazerNotifier<CreateOrUpdatePhasedElectricMeasureDevicePresenter>() {
        public void done(CreateOrUpdatePhasedElectricMeasureDevicePresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<CreateOrUpdatePhasedElectricMeasureDevicePresenter> createOrUpdatePhasedElectricMeasureDevicePresenter;
}
