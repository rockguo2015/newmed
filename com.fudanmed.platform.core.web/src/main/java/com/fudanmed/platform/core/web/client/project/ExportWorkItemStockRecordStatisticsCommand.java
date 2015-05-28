package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.ExportWorkItemStockRecordStatisticsCommandServiceAsync;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockStatisticsCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.csv.client.CSVClientExtensions;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ExportWorkItemStockRecordStatisticsCommand extends BaseContextAwareSingleObjectCommand<UIWorkItemStockStatisticsCriteria> implements IContextConsumer<UIWorkItemStockStatisticsCriteria> {
  @Inject
  protected ExportWorkItemStockRecordStatisticsCommandServiceAsync _service;
  
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "用料信息导出";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.ExportWorkItemStockRecordStatisticsCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final UIWorkItemStockStatisticsCriteria value) {
    final Procedure1<String> _function = new Procedure1<String>() {
        public void apply(final String it) {
          CSVClientExtensions.doDownload(it);
        }
      };
    AsyncCallback<String> _onSuccess = this.<String>onSuccess(_function);
    _service.prepareExport(value, _onSuccess);
  }
}
