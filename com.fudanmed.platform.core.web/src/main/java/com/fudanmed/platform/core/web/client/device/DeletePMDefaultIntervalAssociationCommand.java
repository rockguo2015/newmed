package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMDefaultIntervalAssociationProxy;
import com.fudanmed.platform.core.web.client.device.DeletePMDefaultIntervalAssociationCommandServiceAsync;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DeletePMDefaultIntervalAssociationCommand extends BaseContextAwareSingleObjectCommand<RCPMDefaultIntervalAssociationProxy> implements IContextConsumer<RCPMDefaultIntervalAssociationProxy> {
  @Inject
  protected DeletePMDefaultIntervalAssociationCommandServiceAsync _service;
  
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "删除PM计划";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.DeletePMDefaultIntervalAssociationCommand";
  }
  
  public void execute(final RCPMDefaultIntervalAssociationProxy value) {
    String _name = value.getName();
    String _plus = ("\u786E\u8BA4\u5220\u9664:" + _name);
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.PMDefaultIntervalAssociationsChangedEvent());
                
              }
            };
          AsyncCallback<Void> _onSuccess = DeletePMDefaultIntervalAssociationCommand.this.<Void>onSuccess(_function);
          _service.delete(value, _onSuccess);
        }
      };
    ConfirmMessageBox _ConfirmMessageBox = this.widgets.ConfirmMessageBox("\u786E\u8BA4\u5220\u9664", _plus, _function);
    _ConfirmMessageBox.show();
  }
}
