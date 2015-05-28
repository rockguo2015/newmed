package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UITransferRecord;
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

public class TransferRecordListGrid extends GXTGridComponent<UITransferRecord> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UITransferRecord> sid;
  
  public StringValueColumn<UITransferRecord,RCWarehouseProxy> sourceStore;
  
  public StringValueColumn<UITransferRecord,RCWarehouseProxy> targetStore;
  
  public StringValueColumn<UITransferRecord,RCEmployeeProxy> operator;
  
  public DateColumn<UITransferRecord> date;
  
  public StringColumn<UITransferRecord> comment;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UITransferRecord value = new UITransferRecord();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sid = stringValueProviderFactory.createAsStringColumn("sid","调拨单号",UITransferRecord.SidAccessor);
    widgetsRegistory.put("sid",sid);
    sourceStore = defaultObjectSelectorFactory.createAsDefaultColumn("sourceStore","调出仓库",UITransferRecord.SourceStoreAccessor);
    widgetsRegistory.put("sourceStore",sourceStore);
    targetStore = defaultObjectSelectorFactory.createAsDefaultColumn("targetStore","调入仓库",UITransferRecord.TargetStoreAccessor);
    widgetsRegistory.put("targetStore",targetStore);
    operator = defaultObjectSelectorFactory.createAsDefaultColumn("operator","操作员",UITransferRecord.OperatorAccessor);
    widgetsRegistory.put("operator",operator);
    date = dateValueProviderFactory.createAsStringColumn("date","调拨日期",UITransferRecord.DateAccessor);
    widgetsRegistory.put("date",date);
    comment = stringValueProviderFactory.createAsStringColumn("comment","备注",UITransferRecord.CommentAccessor);
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
  
  public UITransferRecord getValueAsNew() {
    UITransferRecord value = new UITransferRecord();
    value.setSid(sid.getValue());
    value.setSourceStore(sourceStore.getValue());
    value.setTargetStore(targetStore.getValue());
    value.setOperator(operator.getValue());
    value.setDate(date.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UITransferRecord doGetValue() {
    
    value.setSid(sid.getValue());
    value.setSourceStore(sourceStore.getValue());
    value.setTargetStore(targetStore.getValue());
    value.setOperator(operator.getValue());
    value.setDate(date.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UITransferRecord getValue(final UITransferRecord copyValue) {
    
    copyValue.setSid(sid.getValue());
    copyValue.setSourceStore(sourceStore.getValue());
    copyValue.setTargetStore(targetStore.getValue());
    copyValue.setOperator(operator.getValue());
    copyValue.setDate(date.getValue());
    copyValue.setComment(comment.getValue());
    return copyValue;
  }
  
  protected TransferRecordListGrid doSetValue(final UITransferRecord value) {
    this.value = value;
    sid.setValue(value.getSid());
    sourceStore.setValue(value.getSourceStore());
    targetStore.setValue(value.getTargetStore());
    operator.setValue(value.getOperator());
    date.setValue(value.getDate());
    comment.setValue(value.getComment());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)sid,(ICanAsWidget)sourceStore,(ICanAsWidget)targetStore,(ICanAsWidget)operator,(ICanAsWidget)date,(ICanAsWidget)comment
    					);
  }
}
