package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCGasMeasureDeviceProxy;
import com.fudanmed.platform.core.web.client.measure.CreateOrUpdateGasMeasureDevicePresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class UpdateGasMeasureDeviceCommand extends BaseContextAwareSingleObjectCommand<RCGasMeasureDeviceProxy> implements IContextConsumer<RCGasMeasureDeviceProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "修改";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.UpdateGasMeasureDeviceCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final RCGasMeasureDeviceProxy value) {
    CreateOrUpdateGasMeasureDevicePresenter _get = this.createOrUpdateGasMeasureDevicePresenter.get();
    final Procedure1<CreateOrUpdateGasMeasureDevicePresenter> _function = new Procedure1<CreateOrUpdateGasMeasureDevicePresenter>() {
        public void apply(final CreateOrUpdateGasMeasureDevicePresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Update(value, new IPresenterInitiazerNotifier<CreateOrUpdateGasMeasureDevicePresenter>() {
        public void done(CreateOrUpdateGasMeasureDevicePresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<CreateOrUpdateGasMeasureDevicePresenter> createOrUpdateGasMeasureDevicePresenter;
}
