package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.BatchInitializePMPlanPresenter;
import com.fudanmed.platform.core.web.shared.device.UIDeviceCriteria;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class BatchInitializePMPlanPresenterCommand extends BaseContextAwareSingleObjectCommand<UIDeviceCriteria> implements IContextConsumer<UIDeviceCriteria> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "批量生成PM计划";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.BatchInitializePMPlanPresenterCommand";
  }
  
  public void execute(final UIDeviceCriteria value) {
    BatchInitializePMPlanPresenter _get = this.batchInitializePMPlanPresenter.get();
    final Procedure1<BatchInitializePMPlanPresenter> _function = new Procedure1<BatchInitializePMPlanPresenter>() {
        public void apply(final BatchInitializePMPlanPresenter it) {
          it.popup(it);
        }
      };
    _get.setup(value, new IPresenterInitiazerNotifier<BatchInitializePMPlanPresenter>() {
        public void done(BatchInitializePMPlanPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<BatchInitializePMPlanPresenter> batchInitializePMPlanPresenter;
}
