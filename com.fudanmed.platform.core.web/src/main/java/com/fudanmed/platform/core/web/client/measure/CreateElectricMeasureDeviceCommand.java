package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.CreateOrUpdateElectricMeasureDevicePresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateElectricMeasureDeviceCommand extends BaseContextAwareSingleObjectCommand<RCElectricMeasureDeviceTypeProxy> implements IContextConsumer<RCElectricMeasureDeviceTypeProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "新建";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.CreateElectricMeasureDeviceCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final RCElectricMeasureDeviceTypeProxy value) {
    CreateOrUpdateElectricMeasureDevicePresenter _get = this.createOrUpdateElectricMeasureDevicePresenter.get();
    final Procedure1<CreateOrUpdateElectricMeasureDevicePresenter> _function = new Procedure1<CreateOrUpdateElectricMeasureDevicePresenter>() {
        public void apply(final CreateOrUpdateElectricMeasureDevicePresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Create(value, new IPresenterInitiazerNotifier<CreateOrUpdateElectricMeasureDevicePresenter>() {
        public void done(CreateOrUpdateElectricMeasureDevicePresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<CreateOrUpdateElectricMeasureDevicePresenter> createOrUpdateElectricMeasureDevicePresenter;
}
