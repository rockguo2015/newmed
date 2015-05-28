package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingList;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.BooleanValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.BooleanValueProviderFactory.BooleanColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory.DateColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class StockTakingListListGrid extends GXTGridComponent<UIStockTakingList> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringValueColumn<UIStockTakingList,RCWarehouseProxy> warehouse;
  
  public DateColumn<UIStockTakingList> date;
  
  public StringValueColumn<UIStockTakingList,RCEmployeeProxy> operator;
  
  public BooleanColumn<UIStockTakingList> isCommited;
  
  public StringColumn<UIStockTakingList> comment;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private BooleanValueProviderFactory booleanValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIStockTakingList value = new UIStockTakingList();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();warehouse = defaultObjectSelectorFactory.createAsDefaultColumn("warehouse","盘点仓库",UIStockTakingList.WarehouseAccessor);
    widgetsRegistory.put("warehouse",warehouse);
    date = dateValueProviderFactory.createAsStringColumn("date","实盘日期",UIStockTakingList.DateAccessor);
    widgetsRegistory.put("date",date);
    operator = defaultObjectSelectorFactory.createAsDefaultColumn("operator","操作员",UIStockTakingList.OperatorAccessor);
    widgetsRegistory.put("operator",operator);
    isCommited = booleanValueProviderFactory.createAsBooleanColumn("isCommited","已提交",UIStockTakingList.IsCommitedAccessor);
    widgetsRegistory.put("isCommited",isCommited);
    comment = stringValueProviderFactory.createAsStringColumn("comment","备注",UIStockTakingList.CommentAccessor);
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
  
  public UIStockTakingList getValueAsNew() {
    UIStockTakingList value = new UIStockTakingList();
    value.setWarehouse(warehouse.getValue());
    value.setDate(date.getValue());
    value.setOperator(operator.getValue());
    value.setIsCommited(isCommited.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UIStockTakingList doGetValue() {
    
    value.setWarehouse(warehouse.getValue());
    value.setDate(date.getValue());
    value.setOperator(operator.getValue());
    value.setIsCommited(isCommited.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UIStockTakingList getValue(final UIStockTakingList copyValue) {
    
    copyValue.setWarehouse(warehouse.getValue());
    copyValue.setDate(date.getValue());
    copyValue.setOperator(operator.getValue());
    copyValue.setIsCommited(isCommited.getValue());
    copyValue.setComment(comment.getValue());
    return copyValue;
  }
  
  protected StockTakingListListGrid doSetValue(final UIStockTakingList value) {
    this.value = value;
    warehouse.setValue(value.getWarehouse());
    date.setValue(value.getDate());
    operator.setValue(value.getOperator());
    isCommited.setValue(value.getIsCommited());
    comment.setValue(value.getComment());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)warehouse,(ICanAsWidget)date,(ICanAsWidget)operator,(ICanAsWidget)isCommited,(ICanAsWidget)comment
    					);
  }
}
