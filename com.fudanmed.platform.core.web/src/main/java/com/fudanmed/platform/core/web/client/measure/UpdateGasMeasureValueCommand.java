package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCGasMeasureValueProxy;
import com.fudanmed.platform.core.web.client.measure.CreateOrUpdateGasMeasureValuePresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class UpdateGasMeasureValueCommand extends BaseContextAwareSingleObjectCommand<RCGasMeasureValueProxy> implements IContextConsumer<RCGasMeasureValueProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "修改";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.UpdateGasMeasureValueCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final RCGasMeasureValueProxy value) {
    CreateOrUpdateGasMeasureValuePresenter _get = this.createOrUpdateGasMeasureValuePresenter.get();
    final Procedure1<CreateOrUpdateGasMeasureValuePresenter> _function = new Procedure1<CreateOrUpdateGasMeasureValuePresenter>() {
        public void apply(final CreateOrUpdateGasMeasureValuePresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Update(value, new IPresenterInitiazerNotifier<CreateOrUpdateGasMeasureValuePresenter>() {
        public void done(CreateOrUpdateGasMeasureValuePresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<CreateOrUpdateGasMeasureValuePresenter> createOrUpdateGasMeasureValuePresenter;
}
