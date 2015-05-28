package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemReturnStockRecord;
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

public class WorkItemReturnStockRecordListGrid extends GXTGridComponent<UIWorkItemReturnStockRecord> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIWorkItemReturnStockRecord> sid;
  
  public StringValueColumn<UIWorkItemReturnStockRecord,RCWarehouseProxy> sourceStore;
  
  public StringValueColumn<UIWorkItemReturnStockRecord,RCWorkItemTaskProxy> workItem;
  
  public StringValueColumn<UIWorkItemReturnStockRecord,RCEmployeeProxy> operator;
  
  public DateColumn<UIWorkItemReturnStockRecord> date;
  
  public StringColumn<UIWorkItemReturnStockRecord> comment;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIWorkItemReturnStockRecord value = new UIWorkItemReturnStockRecord();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sid = stringValueProviderFactory.createAsStringColumn("sid","退料单号",UIWorkItemReturnStockRecord.SidAccessor);
    widgetsRegistory.put("sid",sid);
    sourceStore = defaultObjectSelectorFactory.createAsDefaultColumn("sourceStore","入库仓库",UIWorkItemReturnStockRecord.SourceStoreAccessor);
    widgetsRegistory.put("sourceStore",sourceStore);
    workItem = defaultObjectSelectorFactory.createAsDefaultColumn("workItem","工单号",UIWorkItemReturnStockRecord.WorkItemAccessor);
    widgetsRegistory.put("workItem",workItem);
    operator = defaultObjectSelectorFactory.createAsDefaultColumn("operator","操作员",UIWorkItemReturnStockRecord.OperatorAccessor);
    widgetsRegistory.put("operator",operator);
    date = dateValueProviderFactory.createAsStringColumn("date","退料日期",UIWorkItemReturnStockRecord.DateAccessor);
    widgetsRegistory.put("date",date);
    comment = stringValueProviderFactory.createAsStringColumn("comment","备注",UIWorkItemReturnStockRecord.CommentAccessor);
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
  
  public UIWorkItemReturnStockRecord getValueAsNew() {
    UIWorkItemReturnStockRecord value = new UIWorkItemReturnStockRecord();
    value.setSid(sid.getValue());
    value.setSourceStore(sourceStore.getValue());
    value.setWorkItem(workItem.getValue());
    value.setOperator(operator.getValue());
    value.setDate(date.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UIWorkItemReturnStockRecord doGetValue() {
    
    value.setSid(sid.getValue());
    value.setSourceStore(sourceStore.getValue());
    value.setWorkItem(workItem.getValue());
    value.setOperator(operator.getValue());
    value.setDate(date.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UIWorkItemReturnStockRecord getValue(final UIWorkItemReturnStockRecord copyValue) {
    
    copyValue.setSid(sid.getValue());
    copyValue.setSourceStore(sourceStore.getValue());
    copyValue.setWorkItem(workItem.getValue());
    copyValue.setOperator(operator.getValue());
    copyValue.setDate(date.getValue());
    copyValue.setComment(comment.getValue());
    return copyValue;
  }
  
  protected WorkItemReturnStockRecordListGrid doSetValue(final UIWorkItemReturnStockRecord value) {
    this.value = value;
    sid.setValue(value.getSid());
    sourceStore.setValue(value.getSourceStore());
    workItem.setValue(value.getWorkItem());
    operator.setValue(value.getOperator());
    date.setValue(value.getDate());
    comment.setValue(value.getComment());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)sid,(ICanAsWidget)sourceStore,(ICanAsWidget)workItem,(ICanAsWidget)operator,(ICanAsWidget)date,(ICanAsWidget)comment
    					);
  }
}
