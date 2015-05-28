package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureValueProxy;
import com.fudanmed.platform.core.web.client.measure.CreateOrUpdatePhasedElectricMeasureValuePresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class UpdatePhasedElectricMeasureValueCommand extends BaseContextAwareSingleObjectCommand<RCPhasedElectricMeasureValueProxy> implements IContextConsumer<RCPhasedElectricMeasureValueProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "修改";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.UpdatePhasedElectricMeasureValueCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final RCPhasedElectricMeasureValueProxy value) {
    CreateOrUpdatePhasedElectricMeasureValuePresenter _get = this.createOrUpdatePhasedElectricMeasureValuePresenter.get();
    final Procedure1<CreateOrUpdatePhasedElectricMeasureValuePresenter> _function = new Procedure1<CreateOrUpdatePhasedElectricMeasureValuePresenter>() {
        public void apply(final CreateOrUpdatePhasedElectricMeasureValuePresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Update(value, new IPresenterInitiazerNotifier<CreateOrUpdatePhasedElectricMeasureValuePresenter>() {
        public void done(CreateOrUpdatePhasedElectricMeasureValuePresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<CreateOrUpdatePhasedElectricMeasureValuePresenter> createOrUpdatePhasedElectricMeasureValuePresenter;
}
