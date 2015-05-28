package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.CreateOrUpdateWaterMeasureDevicePresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateWaterMeasureDeviceCommand extends BaseContextAwareSingleObjectCommand<RCWaterMeasureDeviceTypeProxy> implements IContextConsumer<RCWaterMeasureDeviceTypeProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "新建";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.CreateWaterMeasureDeviceCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final RCWaterMeasureDeviceTypeProxy value) {
    CreateOrUpdateWaterMeasureDevicePresenter _get = this.createOrUpdateWaterMeasureDevicePresenter.get();
    final Procedure1<CreateOrUpdateWaterMeasureDevicePresenter> _function = new Procedure1<CreateOrUpdateWaterMeasureDevicePresenter>() {
        public void apply(final CreateOrUpdateWaterMeasureDevicePresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Create(value, new IPresenterInitiazerNotifier<CreateOrUpdateWaterMeasureDevicePresenter>() {
        public void done(CreateOrUpdateWaterMeasureDevicePresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<CreateOrUpdateWaterMeasureDevicePresenter> createOrUpdateWaterMeasureDevicePresenter;
}
