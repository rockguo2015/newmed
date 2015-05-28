package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy;
import com.fudanmed.platform.core.web.client.measure.CreateOrUpdateWaterMeasureValuePresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateWaterMeasureValueCommand extends BaseContextAwareSingleObjectCommand<RCMeasureDeviceProxy> implements IContextConsumer<RCMeasureDeviceProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "新建";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.CreateWaterMeasureValueCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final RCMeasureDeviceProxy value) {
    CreateOrUpdateWaterMeasureValuePresenter _get = this.createOrUpdateWaterMeasureValuePresenter.get();
    final Procedure1<CreateOrUpdateWaterMeasureValuePresenter> _function = new Procedure1<CreateOrUpdateWaterMeasureValuePresenter>() {
        public void apply(final CreateOrUpdateWaterMeasureValuePresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Create(value, new IPresenterInitiazerNotifier<CreateOrUpdateWaterMeasureValuePresenter>() {
        public void done(CreateOrUpdateWaterMeasureValuePresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<CreateOrUpdateWaterMeasureValuePresenter> createOrUpdateWaterMeasureValuePresenter;
}
