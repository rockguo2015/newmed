package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductStoreTransaction;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory.DateColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DoubleValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DoubleValueProviderFactory.DoubleColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.IntegerValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.IntegerValueProviderFactory.IntegerColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class ProductStoreTransactionListGrid extends GXTGridComponent<UIProductStoreTransaction> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIProductStoreTransaction> transactionTypeDesc;
  
  public StringColumn<UIProductStoreTransaction> eventRecordSid;
  
  public DateColumn<UIProductStoreTransaction> date;
  
  public IntegerColumn<UIProductStoreTransaction> quantity;
  
  public DoubleColumn<UIProductStoreTransaction> price;
  
  public StringValueColumn<UIProductStoreTransaction,RCEmployeeProxy> operator;
  
  @Inject
  private DoubleValueProviderFactory doubleValueProviderFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIProductStoreTransaction value = new UIProductStoreTransaction();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();transactionTypeDesc = stringValueProviderFactory.createAsStringColumn("transactionTypeDesc","事件名称",UIProductStoreTransaction.TransactionTypeDescAccessor);
    widgetsRegistory.put("transactionTypeDesc",transactionTypeDesc);
    eventRecordSid = stringValueProviderFactory.createAsStringColumn("eventRecordSid","单据编号",UIProductStoreTransaction.EventRecordSidAccessor);
    widgetsRegistory.put("eventRecordSid",eventRecordSid);
    date = dateValueProviderFactory.createAsStringColumn("date","日期",UIProductStoreTransaction.DateAccessor);
    widgetsRegistory.put("date",date);
    quantity = integerValueProviderFactory.createAsIntegerColumn("quantity","数量",UIProductStoreTransaction.QuantityAccessor);
    widgetsRegistory.put("quantity",quantity);
    price = doubleValueProviderFactory.createAsDoubleColumn("price","金额",UIProductStoreTransaction.PriceAccessor);
    widgetsRegistory.put("price",price);
    operator = defaultObjectSelectorFactory.createAsDefaultColumn("operator","操作员",UIProductStoreTransaction.OperatorAccessor);
    widgetsRegistory.put("operator",operator);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIProductStoreTransaction getValueAsNew() {
    UIProductStoreTransaction value = new UIProductStoreTransaction();
    value.setTransactionTypeDesc(transactionTypeDesc.getValue());
    value.setEventRecordSid(eventRecordSid.getValue());
    value.setDate(date.getValue());
    value.setQuantity(quantity.getValue());
    value.setPrice(price.getValue());
    value.setOperator(operator.getValue());
    return value;
  }
  
  public UIProductStoreTransaction doGetValue() {
    
    value.setTransactionTypeDesc(transactionTypeDesc.getValue());
    value.setEventRecordSid(eventRecordSid.getValue());
    value.setDate(date.getValue());
    value.setQuantity(quantity.getValue());
    value.setPrice(price.getValue());
    value.setOperator(operator.getValue());
    return value;
  }
  
  public UIProductStoreTransaction getValue(final UIProductStoreTransaction copyValue) {
    
    copyValue.setTransactionTypeDesc(transactionTypeDesc.getValue());
    copyValue.setEventRecordSid(eventRecordSid.getValue());
    copyValue.setDate(date.getValue());
    copyValue.setQuantity(quantity.getValue());
    copyValue.setPrice(price.getValue());
    copyValue.setOperator(operator.getValue());
    return copyValue;
  }
  
  protected ProductStoreTransactionListGrid doSetValue(final UIProductStoreTransaction value) {
    this.value = value;
    transactionTypeDesc.setValue(value.getTransactionTypeDesc());
    eventRecordSid.setValue(value.getEventRecordSid());
    date.setValue(value.getDate());
    quantity.setValue(value.getQuantity());
    price.setValue(value.getPrice());
    operator.setValue(value.getOperator());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)transactionTypeDesc,(ICanAsWidget)eventRecordSid,(ICanAsWidget)date,(ICanAsWidget)quantity,(ICanAsWidget)price,(ICanAsWidget)operator
    					);
  }
}
