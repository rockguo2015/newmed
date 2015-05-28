package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.common.proxy.RCOutStockTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecord;
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

public class OutStockRecordListGrid extends GXTGridComponent<UIOutStockRecord> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIOutStockRecord> sid;
  
  public StringValueColumn<UIOutStockRecord,RCOutStockTypeProxy> type;
  
  public StringValueColumn<UIOutStockRecord,RCWarehouseProxy> sourceStore;
  
  public StringValueColumn<UIOutStockRecord,RCEmployeeProxy> operator;
  
  public DateColumn<UIOutStockRecord> date;
  
  public StringValueColumn<UIOutStockRecord,RCMaintenanceTeamProxy> team;
  
  public StringValueColumn<UIOutStockRecord,RCEmployeeProxy> worker;
  
  public StringColumn<UIOutStockRecord> comment;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIOutStockRecord value = new UIOutStockRecord();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sid = stringValueProviderFactory.createAsStringColumn("sid","出库单号",UIOutStockRecord.SidAccessor);
    widgetsRegistory.put("sid",sid);
    type = defaultObjectSelectorFactory.createAsDefaultColumn("type","出库类型",UIOutStockRecord.TypeAccessor);
    widgetsRegistory.put("type",type);
    sourceStore = defaultObjectSelectorFactory.createAsDefaultColumn("sourceStore","出库仓库",UIOutStockRecord.SourceStoreAccessor);
    widgetsRegistory.put("sourceStore",sourceStore);
    operator = defaultObjectSelectorFactory.createAsDefaultColumn("operator","操作员",UIOutStockRecord.OperatorAccessor);
    widgetsRegistory.put("operator",operator);
    date = dateValueProviderFactory.createAsStringColumn("date","出库日期",UIOutStockRecord.DateAccessor);
    widgetsRegistory.put("date",date);
    team = defaultObjectSelectorFactory.createAsDefaultColumn("team","领料班组",UIOutStockRecord.TeamAccessor);
    widgetsRegistory.put("team",team);
    worker = defaultObjectSelectorFactory.createAsDefaultColumn("worker","领料人",UIOutStockRecord.WorkerAccessor);
    widgetsRegistory.put("worker",worker);
    comment = stringValueProviderFactory.createAsStringColumn("comment","备注",UIOutStockRecord.CommentAccessor);
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
  
  public UIOutStockRecord getValueAsNew() {
    UIOutStockRecord value = new UIOutStockRecord();
    value.setSid(sid.getValue());
    value.setType(type.getValue());
    value.setSourceStore(sourceStore.getValue());
    value.setOperator(operator.getValue());
    value.setDate(date.getValue());
    value.setTeam(team.getValue());
    value.setWorker(worker.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UIOutStockRecord doGetValue() {
    
    value.setSid(sid.getValue());
    value.setType(type.getValue());
    value.setSourceStore(sourceStore.getValue());
    value.setOperator(operator.getValue());
    value.setDate(date.getValue());
    value.setTeam(team.getValue());
    value.setWorker(worker.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UIOutStockRecord getValue(final UIOutStockRecord copyValue) {
    
    copyValue.setSid(sid.getValue());
    copyValue.setType(type.getValue());
    copyValue.setSourceStore(sourceStore.getValue());
    copyValue.setOperator(operator.getValue());
    copyValue.setDate(date.getValue());
    copyValue.setTeam(team.getValue());
    copyValue.setWorker(worker.getValue());
    copyValue.setComment(comment.getValue());
    return copyValue;
  }
  
  protected OutStockRecordListGrid doSetValue(final UIOutStockRecord value) {
    this.value = value;
    sid.setValue(value.getSid());
    type.setValue(value.getType());
    sourceStore.setValue(value.getSourceStore());
    operator.setValue(value.getOperator());
    date.setValue(value.getDate());
    team.setValue(value.getTeam());
    worker.setValue(value.getWorker());
    comment.setValue(value.getComment());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)sid,(ICanAsWidget)type,(ICanAsWidget)sourceStore,(ICanAsWidget)operator,(ICanAsWidget)date,(ICanAsWidget)team,(ICanAsWidget)worker,(ICanAsWidget)comment
    					);
  }
}
