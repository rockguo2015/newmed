package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy;
import com.fudanmed.platform.core.web.client.measure.CreateOrUpdateElectricMeasureValuePresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateElectricMeasureValueCommand extends BaseContextAwareSingleObjectCommand<RCMeasureDeviceProxy> implements IContextConsumer<RCMeasureDeviceProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "新建";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.CreateElectricMeasureValueCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final RCMeasureDeviceProxy value) {
    CreateOrUpdateElectricMeasureValuePresenter _get = this.createOrUpdateElectricMeasureValuePresenter.get();
    final Procedure1<CreateOrUpdateElectricMeasureValuePresenter> _function = new Procedure1<CreateOrUpdateElectricMeasureValuePresenter>() {
        public void apply(final CreateOrUpdateElectricMeasureValuePresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Create(value, new IPresenterInitiazerNotifier<CreateOrUpdateElectricMeasureValuePresenter>() {
        public void done(CreateOrUpdateElectricMeasureValuePresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<CreateOrUpdateElectricMeasureValuePresenter> createOrUpdateElectricMeasureValuePresenter;
}
