package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.DeliverTaskDispatchPresenter;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTaskStatus;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareMultiObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DeliverTaskDispatchCommand extends BaseContextAwareMultiObjectCommand<UICenterlizedDeliverTask> implements IContextConsumer<UICenterlizedDeliverTask> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "派发";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.DeliverTaskDispatchCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final Iterable<UICenterlizedDeliverTask> value) {
    DeliverTaskDispatchPresenter _get = this.deliverTaskDispatchPresenter.get();
    final Procedure1<DeliverTaskDispatchPresenter> _function = new Procedure1<DeliverTaskDispatchPresenter>() {
        public void apply(final DeliverTaskDispatchPresenter it) {
          it.popup(it);
        }
      };
    _get.setup4create(value, new IPresenterInitiazerNotifier<DeliverTaskDispatchPresenter>() {
        public void done(DeliverTaskDispatchPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  public boolean checkEnable(final Iterable<UICenterlizedDeliverTask> value) {
    final Function1<UICenterlizedDeliverTask,Boolean> _function = new Function1<UICenterlizedDeliverTask,Boolean>() {
        public Boolean apply(final UICenterlizedDeliverTask it) {
          UICenterlizedDeliverTaskStatus _status = it.getStatus();
          boolean _equals = Objects.equal(_status, UICenterlizedDeliverTaskStatus.scheduled);
          return Boolean.valueOf(_equals);
        }
      };
    boolean _forall = IterableExtensions.<UICenterlizedDeliverTask>forall(value, _function);
    return _forall;
  }
  
  @Inject
  private Provider<DeliverTaskDispatchPresenter> deliverTaskDispatchPresenter;
}
