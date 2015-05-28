package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureDeviceProxy;
import com.fudanmed.platform.core.web.client.measure.CreateOrUpdateElectricMeasureDevicePresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class UpdateElectricMeasureDeviceCommand extends BaseContextAwareSingleObjectCommand<RCElectricMeasureDeviceProxy> implements IContextConsumer<RCElectricMeasureDeviceProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "修改";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.UpdateElectricMeasureDeviceCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final RCElectricMeasureDeviceProxy value) {
    CreateOrUpdateElectricMeasureDevicePresenter _get = this.createOrUpdateElectricMeasureDevicePresenter.get();
    final Procedure1<CreateOrUpdateElectricMeasureDevicePresenter> _function = new Procedure1<CreateOrUpdateElectricMeasureDevicePresenter>() {
        public void apply(final CreateOrUpdateElectricMeasureDevicePresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Update(value, new IPresenterInitiazerNotifier<CreateOrUpdateElectricMeasureDevicePresenter>() {
        public void done(CreateOrUpdateElectricMeasureDevicePresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<CreateOrUpdateElectricMeasureDevicePresenter> createOrUpdateElectricMeasureDevicePresenter;
}
