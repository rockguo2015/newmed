package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCGasMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.CreateOrUpdateGasMeasureDevicePresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateGasMeasureDeviceCommand extends BaseContextAwareSingleObjectCommand<RCGasMeasureDeviceTypeProxy> implements IContextConsumer<RCGasMeasureDeviceTypeProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "新建";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.CreateGasMeasureDeviceCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final RCGasMeasureDeviceTypeProxy value) {
    CreateOrUpdateGasMeasureDevicePresenter _get = this.createOrUpdateGasMeasureDevicePresenter.get();
    final Procedure1<CreateOrUpdateGasMeasureDevicePresenter> _function = new Procedure1<CreateOrUpdateGasMeasureDevicePresenter>() {
        public void apply(final CreateOrUpdateGasMeasureDevicePresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Create(value, new IPresenterInitiazerNotifier<CreateOrUpdateGasMeasureDevicePresenter>() {
        public void done(CreateOrUpdateGasMeasureDevicePresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<CreateOrUpdateGasMeasureDevicePresenter> createOrUpdateGasMeasureDevicePresenter;
}
