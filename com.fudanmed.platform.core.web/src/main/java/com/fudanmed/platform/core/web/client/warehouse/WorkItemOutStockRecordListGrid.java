package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemOutStockRecord;
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

public class WorkItemOutStockRecordListGrid extends GXTGridComponent<UIWorkItemOutStockRecord> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIWorkItemOutStockRecord> sid;
  
  public StringValueColumn<UIWorkItemOutStockRecord,RCWarehouseProxy> sourceStore;
  
  public StringValueColumn<UIWorkItemOutStockRecord,RCWorkItemTaskProxy> workItem;
  
  public StringValueColumn<UIWorkItemOutStockRecord,RCEmployeeProxy> operator;
  
  public DateColumn<UIWorkItemOutStockRecord> date;
  
  public StringColumn<UIWorkItemOutStockRecord> comment;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIWorkItemOutStockRecord value = new UIWorkItemOutStockRecord();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sid = stringValueProviderFactory.createAsStringColumn("sid","领料单号",UIWorkItemOutStockRecord.SidAccessor);
    widgetsRegistory.put("sid",sid);
    sourceStore = defaultObjectSelectorFactory.createAsDefaultColumn("sourceStore","出库仓库",UIWorkItemOutStockRecord.SourceStoreAccessor);
    widgetsRegistory.put("sourceStore",sourceStore);
    workItem = defaultObjectSelectorFactory.createAsDefaultColumn("workItem","工单号",UIWorkItemOutStockRecord.WorkItemAccessor);
    widgetsRegistory.put("workItem",workItem);
    operator = defaultObjectSelectorFactory.createAsDefaultColumn("operator","操作员",UIWorkItemOutStockRecord.OperatorAccessor);
    widgetsRegistory.put("operator",operator);
    date = dateValueProviderFactory.createAsStringColumn("date","领料日期",UIWorkItemOutStockRecord.DateAccessor);
    widgetsRegistory.put("date",date);
    comment = stringValueProviderFactory.createAsStringColumn("comment","备注",UIWorkItemOutStockRecord.CommentAccessor);
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
  
  public UIWorkItemOutStockRecord getValueAsNew() {
    UIWorkItemOutStockRecord value = new UIWorkItemOutStockRecord();
    value.setSid(sid.getValue());
    value.setSourceStore(sourceStore.getValue());
    value.setWorkItem(workItem.getValue());
    value.setOperator(operator.getValue());
    value.setDate(date.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UIWorkItemOutStockRecord doGetValue() {
    
    value.setSid(sid.getValue());
    value.setSourceStore(sourceStore.getValue());
    value.setWorkItem(workItem.getValue());
    value.setOperator(operator.getValue());
    value.setDate(date.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UIWorkItemOutStockRecord getValue(final UIWorkItemOutStockRecord copyValue) {
    
    copyValue.setSid(sid.getValue());
    copyValue.setSourceStore(sourceStore.getValue());
    copyValue.setWorkItem(workItem.getValue());
    copyValue.setOperator(operator.getValue());
    copyValue.setDate(date.getValue());
    copyValue.setComment(comment.getValue());
    return copyValue;
  }
  
  protected WorkItemOutStockRecordListGrid doSetValue(final UIWorkItemOutStockRecord value) {
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
