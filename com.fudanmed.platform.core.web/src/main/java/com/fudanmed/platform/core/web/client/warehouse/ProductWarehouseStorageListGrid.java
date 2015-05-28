package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorage;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
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

public class ProductWarehouseStorageListGrid extends GXTGridComponent<UIProductWarehouseStorage> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringValueColumn<UIProductWarehouseStorage,RCWarehouseProxy> store;
  
  public StringColumn<UIProductWarehouseStorage> sid;
  
  public StringColumn<UIProductWarehouseStorage> productSpecsSid;
  
  public StringColumn<UIProductWarehouseStorage> name;
  
  public StringColumn<UIProductWarehouseStorage> typeDesc;
  
  public DoubleColumn<UIProductWarehouseStorage> price;
  
  public IntegerColumn<UIProductWarehouseStorage> quantity;
  
  public StringValueColumn<UIProductWarehouseStorage,RCProduceSpecificationUnitProxy> unit;
  
  @Inject
  private DoubleValueProviderFactory doubleValueProviderFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
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
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();store = defaultObjectSelectorFactory.createAsDefaultColumn("store","仓库",UIProductWarehouseStorage.StoreAccessor);
    widgetsRegistory.put("store",store);
    sid = stringValueProviderFactory.createAsStringColumn("sid","入库批号",UIProductWarehouseStorage.SidAccessor);
    widgetsRegistory.put("sid",sid);
    productSpecsSid = stringValueProviderFactory.createAsStringColumn("productSpecsSid","条码",UIProductWarehouseStorage.ProductSpecsSidAccessor);
    widgetsRegistory.put("productSpecsSid",productSpecsSid);
    name = stringValueProviderFactory.createAsStringColumn("name","物品名称",UIProductWarehouseStorage.NameAccessor);
    widgetsRegistory.put("name",name);
    typeDesc = stringValueProviderFactory.createAsStringColumn("typeDesc","规格型号",UIProductWarehouseStorage.TypeDescAccessor);
    widgetsRegistory.put("typeDesc",typeDesc);
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
    value.setStore(store.getValue());
    value.setSid(sid.getValue());
    value.setProductSpecsSid(productSpecsSid.getValue());
    value.setName(name.getValue());
    value.setTypeDesc(typeDesc.getValue());
    value.setPrice(price.getValue());
    value.setQuantity(quantity.getValue());
    value.setUnit(unit.getValue());
    return value;
  }
  
  public UIProductWarehouseStorage doGetValue() {
    
    value.setStore(store.getValue());
    value.setSid(sid.getValue());
    value.setProductSpecsSid(productSpecsSid.getValue());
    value.setName(name.getValue());
    value.setTypeDesc(typeDesc.getValue());
    value.setPrice(price.getValue());
    value.setQuantity(quantity.getValue());
    value.setUnit(unit.getValue());
    return value;
  }
  
  public UIProductWarehouseStorage getValue(final UIProductWarehouseStorage copyValue) {
    
    copyValue.setStore(store.getValue());
    copyValue.setSid(sid.getValue());
    copyValue.setProductSpecsSid(productSpecsSid.getValue());
    copyValue.setName(name.getValue());
    copyValue.setTypeDesc(typeDesc.getValue());
    copyValue.setPrice(price.getValue());
    copyValue.setQuantity(quantity.getValue());
    copyValue.setUnit(unit.getValue());
    return copyValue;
  }
  
  protected ProductWarehouseStorageListGrid doSetValue(final UIProductWarehouseStorage value) {
    this.value = value;
    store.setValue(value.getStore());
    sid.setValue(value.getSid());
    productSpecsSid.setValue(value.getProductSpecsSid());
    name.setValue(value.getName());
    typeDesc.setValue(value.getTypeDesc());
    price.setValue(value.getPrice());
    quantity.setValue(value.getQuantity());
    unit.setValue(value.getUnit());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)store,(ICanAsWidget)sid,(ICanAsWidget)productSpecsSid,(ICanAsWidget)name,(ICanAsWidget)typeDesc,(ICanAsWidget)price,(ICanAsWidget)quantity,(ICanAsWidget)unit
    					);
  }
}
