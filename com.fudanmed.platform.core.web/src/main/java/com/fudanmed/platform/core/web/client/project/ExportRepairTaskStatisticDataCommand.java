package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.ExportRepairTaskStatisticDataCommandServiceAsync;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatisticCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.csv.client.CSVClientExtensions;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ExportRepairTaskStatisticDataCommand extends BaseContextAwareSingleObjectCommand<UIRepairTaskStatisticCriteria> implements IContextConsumer<UIRepairTaskStatisticCriteria> {
  @Inject
  protected ExportRepairTaskStatisticDataCommandServiceAsync _service;
  
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "报修单导出";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.ExportRepairTaskStatisticDataCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final UIRepairTaskStatisticCriteria value) {
    final Procedure1<String> _function = new Procedure1<String>() {
        public void apply(final String it) {
          CSVClientExtensions.doDownload(it);
        }
      };
    AsyncCallback<String> _onSuccess = this.<String>onSuccess(_function);
    _service.prepareExport(value, _onSuccess);
  }
}
