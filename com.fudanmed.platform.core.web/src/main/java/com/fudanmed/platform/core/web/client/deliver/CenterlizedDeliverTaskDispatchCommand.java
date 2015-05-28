package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskAction;
import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskManager;
import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskProxy;
import com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTaskDispatchCommandServiceAsync;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTaskStatus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CenterlizedDeliverTaskDispatchCommand extends BaseContextAwareSingleObjectCommand<UICenterlizedDeliverTask> implements IContextConsumer<UICenterlizedDeliverTask> {
  @Inject
  protected CenterlizedDeliverTaskDispatchCommandServiceAsync _service;
  
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "派发";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.CenterlizedDeliverTaskDispatchCommand";
  }
  
  public void execute(final UICenterlizedDeliverTask value) {
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          DLCenterlizedDeliverTaskProxy _proxy = value.toProxy();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTasksChangedEvent());
                
              }
            };
          AsyncCallback<Void> _onSuccess = CenterlizedDeliverTaskDispatchCommand.this.<Void>onSuccess(_function);
          _service.accept(_proxy, _onSuccess);
        }
      };
    ConfirmMessageBox _ConfirmMessageBox = this.widgets.ConfirmMessageBox("\u786E\u8BA4", "\u786E\u8BA4\u6D3E\u53D1", _function);
    _ConfirmMessageBox.show();
  }
  
  public boolean checkEnable(final UICenterlizedDeliverTask value) {
    UICenterlizedDeliverTaskStatus _status = value.getStatus();
    Boolean _isActionValid = DLCenterlizedDeliverTaskManager.isActionValid(DLCenterlizedDeliverTaskAction.dispatch, _status);
    return (_isActionValid).booleanValue();
  }
}
