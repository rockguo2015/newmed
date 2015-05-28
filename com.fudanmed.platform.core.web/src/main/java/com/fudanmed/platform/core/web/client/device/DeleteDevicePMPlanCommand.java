package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMPlanProxy;
import com.fudanmed.platform.core.web.client.device.DeleteDevicePMPlanCommandServiceAsync;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlan;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlanStatus;
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

public class DeleteDevicePMPlanCommand extends BaseContextAwareMultiObjectCommand<UIDevicePMPlan> implements IContextConsumer<UIDevicePMPlan> {
  @Inject
  protected DeleteDevicePMPlanCommandServiceAsync _service;
  
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "删除PM计划";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.DeleteDevicePMPlanCommand";
  }
  
  public void execute(final Iterable<UIDevicePMPlan> value) {
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Function1<UIDevicePMPlan,RCDevicePMPlanProxy> _function = new Function1<UIDevicePMPlan,RCDevicePMPlanProxy>() {
              public RCDevicePMPlanProxy apply(final UIDevicePMPlan it) {
                RCDevicePMPlanProxy _proxy = it.toProxy();
                return _proxy;
              }
            };
          Iterable<RCDevicePMPlanProxy> _map = IterableExtensions.<UIDevicePMPlan, RCDevicePMPlanProxy>map(value, _function);
          List<RCDevicePMPlanProxy> _list = IterableExtensions.<RCDevicePMPlanProxy>toList(_map);
          final Procedure1<Void> _function_1 = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.DevicePMPlansChangedEvent());
                
              }
            };
          AsyncCallback<Void> _onSuccess = DeleteDevicePMPlanCommand.this.<Void>onSuccess(_function_1);
          _service.doDelete(_list, _onSuccess);
        }
      };
    ConfirmMessageBox _ConfirmMessageBox = this.widgets.ConfirmMessageBox("\u786E\u8BA4", "\u786E\u8BA4\u5220\u9664\u9009\u4E2D\u8BA1\u5212", _function);
    _ConfirmMessageBox.show();
  }
  
  public boolean checkEnable(final Iterable<UIDevicePMPlan> value) {
    final Function1<UIDevicePMPlan,Boolean> _function = new Function1<UIDevicePMPlan,Boolean>() {
        public Boolean apply(final UIDevicePMPlan it) {
          UIDevicePMPlanStatus _status = it.getStatus();
          boolean _equals = Objects.equal(_status, UIDevicePMPlanStatus.planed);
          return Boolean.valueOf(_equals);
        }
      };
    boolean _forall = IterableExtensions.<UIDevicePMPlan>forall(value, _function);
    return _forall;
  }
}
