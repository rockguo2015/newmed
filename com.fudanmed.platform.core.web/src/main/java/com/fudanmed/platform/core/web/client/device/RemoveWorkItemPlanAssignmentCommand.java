package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCWorkItemPlanAssignmentProxy;
import com.fudanmed.platform.core.web.client.device.RemoveWorkItemPlanAssignmentCommandServiceAsync;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItem;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemStatue;
import com.google.common.base.Objects;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareMultiObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.List;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class RemoveWorkItemPlanAssignmentCommand extends BaseContextAwareMultiObjectCommand<RCWorkItemPlanAssignmentProxy> implements IContextConsumer<RCWorkItemPlanAssignmentProxy> {
  @Inject
  protected RemoveWorkItemPlanAssignmentCommandServiceAsync _service;
  
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "移除PM计划";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.RemoveWorkItemPlanAssignmentCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final Iterable<RCWorkItemPlanAssignmentProxy> value) {
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          List<RCWorkItemPlanAssignmentProxy> _list = IterableExtensions.<RCWorkItemPlanAssignmentProxy>toList(value);
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.PMWorkItemsChangedEvent());
                
              }
            };
          AsyncCallback<Void> _onSuccess = RemoveWorkItemPlanAssignmentCommand.this.<Void>onSuccess(_function);
          _service.removeAssignment(_list, _onSuccess);
        }
      };
    ConfirmMessageBox _ConfirmMessageBox = this.widgets.ConfirmMessageBox("\u786E\u8BA4", "\u786E\u8BA4\u79FB\u9664", _function);
    _ConfirmMessageBox.show();
  }
  
  public boolean checkEnable(final Iterable<RCWorkItemPlanAssignmentProxy> value) {
    boolean _and = false;
    boolean _and_1 = false;
    Iterable<UIPMWorkItem> _selectedObjects = this.workitemContext.getSelectedObjects();
    UIPMWorkItem _head = IterableExtensions.<UIPMWorkItem>head(_selectedObjects);
    boolean _notEquals = (!Objects.equal(_head, null));
    if (!_notEquals) {
      _and_1 = false;
    } else {
      Iterable<UIPMWorkItem> _selectedObjects_1 = this.workitemContext.getSelectedObjects();
      UIPMWorkItem _head_1 = IterableExtensions.<UIPMWorkItem>head(_selectedObjects_1);
      UIPMWorkItemStatue _status = _head_1.getStatus();
      boolean _equals = Objects.equal(_status, UIPMWorkItemStatue.planed);
      _and_1 = (_notEquals && _equals);
    }
    if (!_and_1) {
      _and = false;
    } else {
      int _size = IterableExtensions.size(value);
      boolean _greaterThan = (_size > 0);
      _and = (_and_1 && _greaterThan);
    }
    return _and;
  }
  
  public ActionContext<UIPMWorkItem> workitemContext;
}
