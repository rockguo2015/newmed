package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureValueProxy;
import com.fudanmed.platform.core.web.client.measure.CreateOrUpdateWaterMeasureValuePresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class UpdateWaterMeasureValueCommand extends BaseContextAwareSingleObjectCommand<RCWaterMeasureValueProxy> implements IContextConsumer<RCWaterMeasureValueProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "修改";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.UpdateWaterMeasureValueCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final RCWaterMeasureValueProxy value) {
    CreateOrUpdateWaterMeasureValuePresenter _get = this.createOrUpdateWaterMeasureValuePresenter.get();
    final Procedure1<CreateOrUpdateWaterMeasureValuePresenter> _function = new Procedure1<CreateOrUpdateWaterMeasureValuePresenter>() {
        public void apply(final CreateOrUpdateWaterMeasureValuePresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Update(value, new IPresenterInitiazerNotifier<CreateOrUpdateWaterMeasureValuePresenter>() {
        public void done(CreateOrUpdateWaterMeasureValuePresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<CreateOrUpdateWaterMeasureValuePresenter> createOrUpdateWaterMeasureValuePresenter;
}
