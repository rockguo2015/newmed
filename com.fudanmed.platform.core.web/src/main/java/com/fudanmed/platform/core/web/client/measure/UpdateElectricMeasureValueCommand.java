package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureValueProxy;
import com.fudanmed.platform.core.web.client.measure.CreateOrUpdateElectricMeasureValuePresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class UpdateElectricMeasureValueCommand extends BaseContextAwareSingleObjectCommand<RCElectricMeasureValueProxy> implements IContextConsumer<RCElectricMeasureValueProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "修改";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.UpdateElectricMeasureValueCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final RCElectricMeasureValueProxy value) {
    CreateOrUpdateElectricMeasureValuePresenter _get = this.createOrUpdateElectricMeasureValuePresenter.get();
    final Procedure1<CreateOrUpdateElectricMeasureValuePresenter> _function = new Procedure1<CreateOrUpdateElectricMeasureValuePresenter>() {
        public void apply(final CreateOrUpdateElectricMeasureValuePresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Update(value, new IPresenterInitiazerNotifier<CreateOrUpdateElectricMeasureValuePresenter>() {
        public void done(CreateOrUpdateElectricMeasureValuePresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<CreateOrUpdateElectricMeasureValuePresenter> createOrUpdateElectricMeasureValuePresenter;
}
