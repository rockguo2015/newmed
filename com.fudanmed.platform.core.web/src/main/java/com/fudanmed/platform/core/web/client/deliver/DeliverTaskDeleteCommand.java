package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskProxy;
import com.fudanmed.platform.core.web.client.deliver.DeliverTaskDeleteCommandServiceAsync;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTaskStatus;
import com.google.common.base.Objects;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareMultiObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DeliverTaskDeleteCommand extends BaseContextAwareMultiObjectCommand<UICenterlizedDeliverTask> implements IContextConsumer<UICenterlizedDeliverTask> {
  @Inject
  protected DeliverTaskDeleteCommandServiceAsync _service;
  
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "删除任务";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.DeliverTaskDeleteCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final Iterable<UICenterlizedDeliverTask> value) {
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Function1<UICenterlizedDeliverTask,DLCenterlizedDeliverTaskProxy> _function = new Function1<UICenterlizedDeliverTask,DLCenterlizedDeliverTaskProxy>() {
              public DLCenterlizedDeliverTaskProxy apply(final UICenterlizedDeliverTask it) {
                DLCenterlizedDeliverTaskProxy _proxy = it.toProxy();
                return _proxy;
              }
            };
          Iterable<DLCenterlizedDeliverTaskProxy> _map = IterableExtensions.<UICenterlizedDeliverTask, DLCenterlizedDeliverTaskProxy>map(value, _function);
          List<DLCenterlizedDeliverTaskProxy> _list = IterableExtensions.<DLCenterlizedDeliverTaskProxy>toList(_map);
          final Procedure1<Void> _function_1 = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTasksChangedEvent());
                
              }
            };
          AsyncCallback<Void> _onSuccess = DeliverTaskDeleteCommand.this.<Void>onSuccess(_function_1);
          _service.deleteAll(_list, _onSuccess);
        }
      };
    ConfirmMessageBox _ConfirmMessageBox = this.widgets.ConfirmMessageBox("\u786E\u8BA4", "\u786E\u8BA4\u5220\u9664", _function);
    _ConfirmMessageBox.show();
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
}
