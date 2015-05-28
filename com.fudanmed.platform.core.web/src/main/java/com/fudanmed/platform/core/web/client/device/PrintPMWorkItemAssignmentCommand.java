package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemWorkerAssignmentProxy;
import com.fudanmed.platform.core.web.client.device.PrintPMWorkItemAssignmentCommandServiceAsync;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.client.common.print.Print;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class PrintPMWorkItemAssignmentCommand extends BaseContextAwareSingleObjectCommand<RCPMWorkItemWorkerAssignmentProxy> implements IContextConsumer<RCPMWorkItemWorkerAssignmentProxy> {
  @Inject
  protected PrintPMWorkItemAssignmentCommandServiceAsync _service;
  
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "打印PM工单";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.PrintPMWorkItemAssignmentCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final RCPMWorkItemWorkerAssignmentProxy value) {
    final Procedure1<String> _function = new Procedure1<String>() {
        public void apply(final String html) {
          Print.it(html);
        }
      };
    AsyncCallback<String> _onSuccess = this.<String>onSuccess(_function);
    _service.generatePrintContents(value, _onSuccess);
  }
}
