package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy;
import com.fudanmed.platform.core.web.client.deliver.DeleteInHospitalPatientCommandServiceAsync;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DeleteInHospitalPatientCommand extends BaseContextAwareSingleObjectCommand<DLInHospitalPatientProxy> implements IContextConsumer<DLInHospitalPatientProxy> {
  @Inject
  protected DeleteInHospitalPatientCommandServiceAsync _service;
  
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "删除";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.DeleteInHospitalPatientCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final DLInHospitalPatientProxy value) {
    String _name = value.getName();
    String _plus = ("\u786E\u8BA4\u5220\u9664:" + _name);
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.deliver.InHospitalPatientsChangedEvent());
                
              }
            };
          AsyncCallback<Void> _onSuccess = DeleteInHospitalPatientCommand.this.<Void>onSuccess(_function);
          _service.delete(value, _onSuccess);
        }
      };
    ConfirmMessageBox _ConfirmMessageBox = this.widgets.ConfirmMessageBox("\u786E\u8BA4\u5220\u9664", _plus, _function);
    _ConfirmMessageBox.show();
  }
}
