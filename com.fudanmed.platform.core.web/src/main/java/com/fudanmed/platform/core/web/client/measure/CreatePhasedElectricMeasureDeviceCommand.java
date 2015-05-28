package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.CreateOrUpdatePhasedElectricMeasureDevicePresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreatePhasedElectricMeasureDeviceCommand extends BaseContextAwareSingleObjectCommand<RCPhasedElectricMeasureDeviceTypeProxy> implements IContextConsumer<RCPhasedElectricMeasureDeviceTypeProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "新建";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.CreatePhasedElectricMeasureDeviceCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final RCPhasedElectricMeasureDeviceTypeProxy value) {
    CreateOrUpdatePhasedElectricMeasureDevicePresenter _get = this.createOrUpdatePhasedElectricMeasureDevicePresenter.get();
    final Procedure1<CreateOrUpdatePhasedElectricMeasureDevicePresenter> _function = new Procedure1<CreateOrUpdatePhasedElectricMeasureDevicePresenter>() {
        public void apply(final CreateOrUpdatePhasedElectricMeasureDevicePresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Create(value, new IPresenterInitiazerNotifier<CreateOrUpdatePhasedElectricMeasureDevicePresenter>() {
        public void done(CreateOrUpdatePhasedElectricMeasureDevicePresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<CreateOrUpdatePhasedElectricMeasureDevicePresenter> createOrUpdatePhasedElectricMeasureDevicePresenter;
}
