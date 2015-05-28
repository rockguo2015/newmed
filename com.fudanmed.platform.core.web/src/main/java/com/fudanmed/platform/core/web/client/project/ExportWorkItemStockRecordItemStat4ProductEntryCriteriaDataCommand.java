package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.ExportWorkItemStockRecordItemStat4ProductEntryCriteriaDataCommandServiceAsync;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockRecordItemStatCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.csv.client.CSVClientExtensions;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ExportWorkItemStockRecordItemStat4ProductEntryCriteriaDataCommand extends BaseContextAwareSingleObjectCommand<UIWorkItemStockRecordItemStatCriteria> implements IContextConsumer<UIWorkItemStockRecordItemStatCriteria> {
  @Inject
  protected ExportWorkItemStockRecordItemStat4ProductEntryCriteriaDataCommandServiceAsync _service;
  
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "材料清单导出";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.ExportWorkItemStockRecordItemStat4ProductEntryCriteriaDataCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final UIWorkItemStockRecordItemStatCriteria value) {
    final Procedure1<String> _function = new Procedure1<String>() {
        public void apply(final String it) {
          CSVClientExtensions.doDownload(it);
        }
      };
    AsyncCallback<String> _onSuccess = this.<String>onSuccess(_function);
    _service.prepareExport(value, _onSuccess);
  }
}
