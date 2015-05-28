package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskAction;
import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskManager;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverTaskFinishDataPresenter;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTaskStatus;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareMultiObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DeliverTaskFinishCommand extends BaseContextAwareMultiObjectCommand<UICenterlizedDeliverTask> implements IContextConsumer<UICenterlizedDeliverTask> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "完成运送";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.DeliverTaskFinishCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final Iterable<UICenterlizedDeliverTask> value) {
    CreateOrUpdateDeliverTaskFinishDataPresenter _get = this.createOrUpdateDeliverTaskFinishDataPresenter.get();
    final Procedure1<CreateOrUpdateDeliverTaskFinishDataPresenter> _function = new Procedure1<CreateOrUpdateDeliverTaskFinishDataPresenter>() {
        public void apply(final CreateOrUpdateDeliverTaskFinishDataPresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Create(value, new IPresenterInitiazerNotifier<CreateOrUpdateDeliverTaskFinishDataPresenter>() {
        public void done(CreateOrUpdateDeliverTaskFinishDataPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  public boolean checkEnable(final Iterable<UICenterlizedDeliverTask> value) {
    final Function1<UICenterlizedDeliverTask,Boolean> _function = new Function1<UICenterlizedDeliverTask,Boolean>() {
        public Boolean apply(final UICenterlizedDeliverTask it) {
          UICenterlizedDeliverTaskStatus _status = it.getStatus();
          Boolean _isActionValid = DLCenterlizedDeliverTaskManager.isActionValid(DLCenterlizedDeliverTaskAction.finish, _status);
          return _isActionValid;
        }
      };
    boolean _forall = IterableExtensions.<UICenterlizedDeliverTask>forall(value, _function);
    return _forall;
  }
  
  @Inject
  private Provider<CreateOrUpdateDeliverTaskFinishDataPresenter> createOrUpdateDeliverTaskFinishDataPresenter;
}
