package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCInStoreTypeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecord;
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

public class InStockRecordListGrid extends GXTGridComponent<UIInStockRecord> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIInStockRecord> sid;
  
  public StringValueColumn<UIInStockRecord,RCWarehouseProxy> store;
  
  public StringValueColumn<UIInStockRecord,RCInStoreTypeProxy> inStoreType;
  
  public DateColumn<UIInStockRecord> date;
  
  public StringValueColumn<UIInStockRecord,RCEmployeeProxy> operator;
  
  public StringValueColumn<UIInStockRecord,RCSupplierProxy> supplier;
  
  public BooleanColumn<UIInStockRecord> committed;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private BooleanValueProviderFactory booleanValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIInStockRecord value = new UIInStockRecord();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sid = stringValueProviderFactory.createAsStringColumn("sid","入库单号",UIInStockRecord.SidAccessor);
    widgetsRegistory.put("sid",sid);
    store = defaultObjectSelectorFactory.createAsDefaultColumn("store","入库仓库",UIInStockRecord.StoreAccessor);
    widgetsRegistory.put("store",store);
    inStoreType = defaultObjectSelectorFactory.createAsDefaultColumn("inStoreType","入库类型",UIInStockRecord.InStoreTypeAccessor);
    widgetsRegistory.put("inStoreType",inStoreType);
    date = dateValueProviderFactory.createAsStringColumn("date","入库日期",UIInStockRecord.DateAccessor);
    widgetsRegistory.put("date",date);
    operator = defaultObjectSelectorFactory.createAsDefaultColumn("operator","操作员",UIInStockRecord.OperatorAccessor);
    widgetsRegistory.put("operator",operator);
    supplier = defaultObjectSelectorFactory.createAsDefaultColumn("supplier","供应商",UIInStockRecord.SupplierAccessor);
    widgetsRegistory.put("supplier",supplier);
    committed = booleanValueProviderFactory.createAsBooleanColumn("committed","已入库",UIInStockRecord.CommittedAccessor);
    widgetsRegistory.put("committed",committed);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIInStockRecord getValueAsNew() {
    UIInStockRecord value = new UIInStockRecord();
    value.setSid(sid.getValue());
    value.setStore(store.getValue());
    value.setInStoreType(inStoreType.getValue());
    value.setDate(date.getValue());
    value.setOperator(operator.getValue());
    value.setSupplier(supplier.getValue());
    value.setCommitted(committed.getValue());
    return value;
  }
  
  public UIInStockRecord doGetValue() {
    
    value.setSid(sid.getValue());
    value.setStore(store.getValue());
    value.setInStoreType(inStoreType.getValue());
    value.setDate(date.getValue());
    value.setOperator(operator.getValue());
    value.setSupplier(supplier.getValue());
    value.setCommitted(committed.getValue());
    return value;
  }
  
  public UIInStockRecord getValue(final UIInStockRecord copyValue) {
    
    copyValue.setSid(sid.getValue());
    copyValue.setStore(store.getValue());
    copyValue.setInStoreType(inStoreType.getValue());
    copyValue.setDate(date.getValue());
    copyValue.setOperator(operator.getValue());
    copyValue.setSupplier(supplier.getValue());
    copyValue.setCommitted(committed.getValue());
    return copyValue;
  }
  
  protected InStockRecordListGrid doSetValue(final UIInStockRecord value) {
    this.value = value;
    sid.setValue(value.getSid());
    store.setValue(value.getStore());
    inStoreType.setValue(value.getInStoreType());
    date.setValue(value.getDate());
    operator.setValue(value.getOperator());
    supplier.setValue(value.getSupplier());
    committed.setValue(value.getCommitted());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)sid,(ICanAsWidget)store,(ICanAsWidget)inStoreType,(ICanAsWidget)date,(ICanAsWidget)operator,(ICanAsWidget)supplier,(ICanAsWidget)committed
    					);
  }
}
