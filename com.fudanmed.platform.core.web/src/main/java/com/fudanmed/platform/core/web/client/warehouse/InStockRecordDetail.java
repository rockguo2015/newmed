package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCInStoreTypeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecord;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;
import edu.fudan.langlab.gxt.client.component.propertyview.GXTPropertyView;
import edu.fudan.langlab.gxt.client.component.propertyview.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.propertyview.factory.DateValueProviderFactory.DatePropertyItem;
import edu.fudan.langlab.gxt.client.component.propertyview.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class InStockRecordDetail extends GXTPropertyView<UIInStockRecord> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public DatePropertyItem date;
  
  public IValueViewer<RCWarehouseProxy> store;
  
  public IValueViewer<RCInStoreTypeProxy> inStoreType;
  
  public IValueViewer<String> deliverNumber;
  
  public IValueViewer<String> invoiceNumber;
  
  public IValueViewer<RCSupplierProxy> supplier;
  
  public IValueViewer<String> comment;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private UIInStockRecord value = new UIInStockRecord();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();date = dateValueProviderFactory.createAsDateItem("date","入库日期",Integer.valueOf(3));
    widgetsRegistory.put("date",date);
    store = defaultObjectSelectorFactory.createAsPropertyItem("store","入库仓库");
    widgetsRegistory.put("store",store);
    inStoreType = defaultObjectSelectorFactory.createAsPropertyItem("inStoreType","入库类型");
    widgetsRegistory.put("inStoreType",inStoreType);
    deliverNumber = defaultObjectSelectorFactory.createAsPropertyItem("deliverNumber","送货单号");
    widgetsRegistory.put("deliverNumber",deliverNumber);
    invoiceNumber = defaultObjectSelectorFactory.createAsPropertyItem("invoiceNumber","发票号码");
    widgetsRegistory.put("invoiceNumber",invoiceNumber);
    supplier = defaultObjectSelectorFactory.createAsPropertyItem("supplier","供应商");
    widgetsRegistory.put("supplier",supplier);
    comment = defaultObjectSelectorFactory.createAsPropertyItem("comment","备注",Integer.valueOf(3));
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
  
  public UIInStockRecord getValueAsNew() {
    UIInStockRecord value = new UIInStockRecord();
    return value;
  }
  
  public UIInStockRecord doGetValue() {
    
    return value;
  }
  
  public UIInStockRecord getValue(final UIInStockRecord copyValue) {
    
    return copyValue;
  }
  
  protected InStockRecordDetail doSetValue(final UIInStockRecord value) {
    this.value = value;
    date.setValue(value.getDate());
    store.setValue(value.getStore());
    inStoreType.setValue(value.getInStoreType());
    deliverNumber.setValue(value.getDeliverNumber());
    invoiceNumber.setValue(value.getInvoiceNumber());
    supplier.setValue(value.getSupplier());
    comment.setValue(value.getComment());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)date,(ICanAsWidget)store,(ICanAsWidget)inStoreType,(ICanAsWidget)deliverNumber,(ICanAsWidget)invoiceNumber,(ICanAsWidget)supplier,(ICanAsWidget)comment
    					);
  }
  
  public Integer getCols() {
    return Integer.valueOf(3);
  }
}
