package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorage;
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

public class ProductWarehouseStorage4SummaryListGrid extends GXTGridComponent<UIProductWarehouseStorage> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIProductWarehouseStorage> sid;
  
  public DateColumn<UIProductWarehouseStorage> instockDate;
  
  public StringValueColumn<UIProductWarehouseStorage,RCSupplierProxy> supplier;
  
  public DoubleColumn<UIProductWarehouseStorage> price;
  
  public IntegerColumn<UIProductWarehouseStorage> quantity;
  
  public StringValueColumn<UIProductWarehouseStorage,RCProduceSpecificationUnitProxy> unit;
  
  @Inject
  private DoubleValueProviderFactory doubleValueProviderFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIProductWarehouseStorage value = new UIProductWarehouseStorage();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sid = stringValueProviderFactory.createAsStringColumn("sid","入库批号",UIProductWarehouseStorage.SidAccessor);
    widgetsRegistory.put("sid",sid);
    instockDate = dateValueProviderFactory.createAsStringColumn("instockDate","入库日期",UIProductWarehouseStorage.InstockDateAccessor);
    widgetsRegistory.put("instockDate",instockDate);
    supplier = defaultObjectSelectorFactory.createAsDefaultColumn("supplier","供应商",UIProductWarehouseStorage.SupplierAccessor);
    widgetsRegistory.put("supplier",supplier);
    price = doubleValueProviderFactory.createAsDoubleColumn("price","单价",UIProductWarehouseStorage.PriceAccessor);
    widgetsRegistory.put("price",price);
    quantity = integerValueProviderFactory.createAsIntegerColumn("quantity","库存数量",UIProductWarehouseStorage.QuantityAccessor);
    widgetsRegistory.put("quantity",quantity);
    unit = defaultObjectSelectorFactory.createAsDefaultColumn("unit","计量单位",UIProductWarehouseStorage.UnitAccessor);
    widgetsRegistory.put("unit",unit);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIProductWarehouseStorage getValueAsNew() {
    UIProductWarehouseStorage value = new UIProductWarehouseStorage();
    value.setSid(sid.getValue());
    value.setInstockDate(instockDate.getValue());
    value.setSupplier(supplier.getValue());
    value.setPrice(price.getValue());
    value.setQuantity(quantity.getValue());
    value.setUnit(unit.getValue());
    return value;
  }
  
  public UIProductWarehouseStorage doGetValue() {
    
    value.setSid(sid.getValue());
    value.setInstockDate(instockDate.getValue());
    value.setSupplier(supplier.getValue());
    value.setPrice(price.getValue());
    value.setQuantity(quantity.getValue());
    value.setUnit(unit.getValue());
    return value;
  }
  
  public UIProductWarehouseStorage getValue(final UIProductWarehouseStorage copyValue) {
    
    copyValue.setSid(sid.getValue());
    copyValue.setInstockDate(instockDate.getValue());
    copyValue.setSupplier(supplier.getValue());
    copyValue.setPrice(price.getValue());
    copyValue.setQuantity(quantity.getValue());
    copyValue.setUnit(unit.getValue());
    return copyValue;
  }
  
  protected ProductWarehouseStorage4SummaryListGrid doSetValue(final UIProductWarehouseStorage value) {
    this.value = value;
    sid.setValue(value.getSid());
    instockDate.setValue(value.getInstockDate());
    supplier.setValue(value.getSupplier());
    price.setValue(value.getPrice());
    quantity.setValue(value.getQuantity());
    unit.setValue(value.getUnit());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)sid,(ICanAsWidget)instockDate,(ICanAsWidget)supplier,(ICanAsWidget)price,(ICanAsWidget)quantity,(ICanAsWidget)unit
    					);
  }
}
