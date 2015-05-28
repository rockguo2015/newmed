package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecord;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory.DateColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class WorkItemStockRecordListGrid extends GXTGridComponent<UIWorkItemStockRecord> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIWorkItemStockRecord> typeName;
  
  public StringColumn<UIWorkItemStockRecord> sid;
  
  public StringColumn<UIWorkItemStockRecord> reportSid;
  
  public StringValueColumn<UIWorkItemStockRecord,RCWorkItemTaskProxy> workItem;
  
  public StringValueColumn<UIWorkItemStockRecord,RCWarehouseProxy> sourceStore;
  
  public StringValueColumn<UIWorkItemStockRecord,RCEmployeeProxy> operator;
  
  public DateColumn<UIWorkItemStockRecord> date;
  
  public StringColumn<UIWorkItemStockRecord> comment;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIWorkItemStockRecord value = new UIWorkItemStockRecord();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();typeName = stringValueProviderFactory.createAsStringColumn("typeName","操作类型",UIWorkItemStockRecord.TypeNameAccessor);
    widgetsRegistory.put("typeName",typeName);
    sid = stringValueProviderFactory.createAsStringColumn("sid","领/退料单号",UIWorkItemStockRecord.SidAccessor);
    widgetsRegistory.put("sid",sid);
    reportSid = stringValueProviderFactory.createAsStringColumn("reportSid","报修单号",UIWorkItemStockRecord.ReportSidAccessor);
    widgetsRegistory.put("reportSid",reportSid);
    workItem = defaultObjectSelectorFactory.createAsDefaultColumn("workItem","工单",UIWorkItemStockRecord.WorkItemAccessor);
    widgetsRegistory.put("workItem",workItem);
    sourceStore = defaultObjectSelectorFactory.createAsDefaultColumn("sourceStore","仓库",UIWorkItemStockRecord.SourceStoreAccessor);
    widgetsRegistory.put("sourceStore",sourceStore);
    operator = defaultObjectSelectorFactory.createAsDefaultColumn("operator","操作员",UIWorkItemStockRecord.OperatorAccessor);
    widgetsRegistory.put("operator",operator);
    date = dateValueProviderFactory.createAsStringColumn("date","领/退料日期",UIWorkItemStockRecord.DateAccessor);
    widgetsRegistory.put("date",date);
    comment = stringValueProviderFactory.createAsStringColumn("comment","备注",UIWorkItemStockRecord.CommentAccessor);
    widgetsRegistory.put("comment",comment);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIWorkItemStockRecord getValueAsNew() {
    UIWorkItemStockRecord value = new UIWorkItemStockRecord();
    value.setTypeName(typeName.getValue());
    value.setSid(sid.getValue());
    value.setReportSid(reportSid.getValue());
    value.setWorkItem(workItem.getValue());
    value.setSourceStore(sourceStore.getValue());
    value.setOperator(operator.getValue());
    value.setDate(date.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UIWorkItemStockRecord doGetValue() {
    
    value.setTypeName(typeName.getValue());
    value.setSid(sid.getValue());
    value.setReportSid(reportSid.getValue());
    value.setWorkItem(workItem.getValue());
    value.setSourceStore(sourceStore.getValue());
    value.setOperator(operator.getValue());
    value.setDate(date.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UIWorkItemStockRecord getValue(final UIWorkItemStockRecord copyValue) {
    
    copyValue.setTypeName(typeName.getValue());
    copyValue.setSid(sid.getValue());
    copyValue.setReportSid(reportSid.getValue());
    copyValue.setWorkItem(workItem.getValue());
    copyValue.setSourceStore(sourceStore.getValue());
    copyValue.setOperator(operator.getValue());
    copyValue.setDate(date.getValue());
    copyValue.setComment(comment.getValue());
    return copyValue;
  }
  
  protected WorkItemStockRecordListGrid doSetValue(final UIWorkItemStockRecord value) {
    this.value = value;
    typeName.setValue(value.getTypeName());
    sid.setValue(value.getSid());
    reportSid.setValue(value.getReportSid());
    workItem.setValue(value.getWorkItem());
    sourceStore.setValue(value.getSourceStore());
    operator.setValue(value.getOperator());
    date.setValue(value.getDate());
    comment.setValue(value.getComment());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)typeName,(ICanAsWidget)sid,(ICanAsWidget)reportSid,(ICanAsWidget)workItem,(ICanAsWidget)sourceStore,(ICanAsWidget)operator,(ICanAsWidget)date,(ICanAsWidget)comment
    					);
  }
}
