package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.IntegerValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.IntegerValueProviderFactory.IntegerColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class ProductWarehouseStorageSummaryListGrid extends GXTGridComponent<UIProductWarehouseStorageSummary> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringValueColumn<UIProductWarehouseStorageSummary,RCWarehouseProxy> store;
  
  public StringColumn<UIProductWarehouseStorageSummary> productSpecsSid;
  
  public StringColumn<UIProductWarehouseStorageSummary> materialId;
  
  public StringColumn<UIProductWarehouseStorageSummary> name;
  
  public StringValueColumn<UIProductWarehouseStorageSummary,RCMaterialBrandProxy> brand;
  
  public StringColumn<UIProductWarehouseStorageSummary> typeDesc;
  
  public IntegerColumn<UIProductWarehouseStorageSummary> quantity;
  
  public StringValueColumn<UIProductWarehouseStorageSummary,RCProduceSpecificationUnitProxy> unit;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIProductWarehouseStorageSummary value = new UIProductWarehouseStorageSummary();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();store = defaultObjectSelectorFactory.createAsDefaultColumn("store","仓库",UIProductWarehouseStorageSummary.StoreAccessor);
    widgetsRegistory.put("store",store);
    productSpecsSid = stringValueProviderFactory.createAsStringColumn("productSpecsSid","条码",UIProductWarehouseStorageSummary.ProductSpecsSidAccessor);
    widgetsRegistory.put("productSpecsSid",productSpecsSid);
    materialId = stringValueProviderFactory.createAsStringColumn("materialId","物品编号",UIProductWarehouseStorageSummary.MaterialIdAccessor);
    widgetsRegistory.put("materialId",materialId);
    name = stringValueProviderFactory.createAsStringColumn("name","物品名称",UIProductWarehouseStorageSummary.NameAccessor);
    widgetsRegistory.put("name",name);
    brand = defaultObjectSelectorFactory.createAsDefaultColumn("brand","品牌",UIProductWarehouseStorageSummary.BrandAccessor);
    widgetsRegistory.put("brand",brand);
    typeDesc = stringValueProviderFactory.createAsStringColumn("typeDesc","规格型号",UIProductWarehouseStorageSummary.TypeDescAccessor);
    widgetsRegistory.put("typeDesc",typeDesc);
    quantity = integerValueProviderFactory.createAsIntegerColumn("quantity","库存数量",UIProductWarehouseStorageSummary.QuantityAccessor);
    widgetsRegistory.put("quantity",quantity);
    unit = defaultObjectSelectorFactory.createAsDefaultColumn("unit","计量单位",UIProductWarehouseStorageSummary.UnitAccessor);
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
  
  public UIProductWarehouseStorageSummary getValueAsNew() {
    UIProductWarehouseStorageSummary value = new UIProductWarehouseStorageSummary();
    value.setStore(store.getValue());
    value.setProductSpecsSid(productSpecsSid.getValue());
    value.setMaterialId(materialId.getValue());
    value.setName(name.getValue());
    value.setBrand(brand.getValue());
    value.setTypeDesc(typeDesc.getValue());
    value.setQuantity(quantity.getValue());
    value.setUnit(unit.getValue());
    return value;
  }
  
  public UIProductWarehouseStorageSummary doGetValue() {
    
    value.setStore(store.getValue());
    value.setProductSpecsSid(productSpecsSid.getValue());
    value.setMaterialId(materialId.getValue());
    value.setName(name.getValue());
    value.setBrand(brand.getValue());
    value.setTypeDesc(typeDesc.getValue());
    value.setQuantity(quantity.getValue());
    value.setUnit(unit.getValue());
    return value;
  }
  
  public UIProductWarehouseStorageSummary getValue(final UIProductWarehouseStorageSummary copyValue) {
    
    copyValue.setStore(store.getValue());
    copyValue.setProductSpecsSid(productSpecsSid.getValue());
    copyValue.setMaterialId(materialId.getValue());
    copyValue.setName(name.getValue());
    copyValue.setBrand(brand.getValue());
    copyValue.setTypeDesc(typeDesc.getValue());
    copyValue.setQuantity(quantity.getValue());
    copyValue.setUnit(unit.getValue());
    return copyValue;
  }
  
  protected ProductWarehouseStorageSummaryListGrid doSetValue(final UIProductWarehouseStorageSummary value) {
    this.value = value;
    store.setValue(value.getStore());
    productSpecsSid.setValue(value.getProductSpecsSid());
    materialId.setValue(value.getMaterialId());
    name.setValue(value.getName());
    brand.setValue(value.getBrand());
    typeDesc.setValue(value.getTypeDesc());
    quantity.setValue(value.getQuantity());
    unit.setValue(value.getUnit());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)store,(ICanAsWidget)productSpecsSid,(ICanAsWidget)materialId,(ICanAsWidget)name,(ICanAsWidget)brand,(ICanAsWidget)typeDesc,(ICanAsWidget)quantity,(ICanAsWidget)unit
    					);
  }
}
