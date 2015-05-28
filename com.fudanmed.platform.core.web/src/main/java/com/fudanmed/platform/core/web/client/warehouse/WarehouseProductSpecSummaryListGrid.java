package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIWarehouseProductSpecSummary;
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

public class WarehouseProductSpecSummaryListGrid extends GXTGridComponent<UIWarehouseProductSpecSummary> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIWarehouseProductSpecSummary> productName;
  
  public StringColumn<UIWarehouseProductSpecSummary> typeDesc;
  
  public StringValueColumn<UIWarehouseProductSpecSummary,RCMaterialBrandProxy> brand;
  
  public IntegerColumn<UIWarehouseProductSpecSummary> sourceQuantity;
  
  public IntegerColumn<UIWarehouseProductSpecSummary> quantity;
  
  public StringValueColumn<UIWarehouseProductSpecSummary,RCProduceSpecificationUnitProxy> unit;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIWarehouseProductSpecSummary value = new UIWarehouseProductSpecSummary();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();productName = stringValueProviderFactory.createAsStringColumn("productName","物品名称",UIWarehouseProductSpecSummary.ProductNameAccessor);
    widgetsRegistory.put("productName",productName);
    typeDesc = stringValueProviderFactory.createAsStringColumn("typeDesc","规格型号",UIWarehouseProductSpecSummary.TypeDescAccessor);
    widgetsRegistory.put("typeDesc",typeDesc);
    brand = defaultObjectSelectorFactory.createAsDefaultColumn("brand","品牌",UIWarehouseProductSpecSummary.BrandAccessor);
    widgetsRegistory.put("brand",brand);
    sourceQuantity = integerValueProviderFactory.createAsIntegerColumn("sourceQuantity","库存数量",UIWarehouseProductSpecSummary.SourceQuantityAccessor);
    widgetsRegistory.put("sourceQuantity",sourceQuantity);
    quantity = integerValueProviderFactory.createAsEditableIntegerColumn("quantity","数量",UIWarehouseProductSpecSummary.QuantityAccessor);
    widgetsRegistory.put("quantity",quantity);
    unit = defaultObjectSelectorFactory.createAsDefaultColumn("unit","计量单位",UIWarehouseProductSpecSummary.UnitAccessor);
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
  
  public UIWarehouseProductSpecSummary getValueAsNew() {
    UIWarehouseProductSpecSummary value = new UIWarehouseProductSpecSummary();
    value.setProductName(productName.getValue());
    value.setTypeDesc(typeDesc.getValue());
    value.setBrand(brand.getValue());
    value.setSourceQuantity(sourceQuantity.getValue());
    value.setQuantity(quantity.getValue());
    value.setUnit(unit.getValue());
    return value;
  }
  
  public UIWarehouseProductSpecSummary doGetValue() {
    
    value.setProductName(productName.getValue());
    value.setTypeDesc(typeDesc.getValue());
    value.setBrand(brand.getValue());
    value.setSourceQuantity(sourceQuantity.getValue());
    value.setQuantity(quantity.getValue());
    value.setUnit(unit.getValue());
    return value;
  }
  
  public UIWarehouseProductSpecSummary getValue(final UIWarehouseProductSpecSummary copyValue) {
    
    copyValue.setProductName(productName.getValue());
    copyValue.setTypeDesc(typeDesc.getValue());
    copyValue.setBrand(brand.getValue());
    copyValue.setSourceQuantity(sourceQuantity.getValue());
    copyValue.setQuantity(quantity.getValue());
    copyValue.setUnit(unit.getValue());
    return copyValue;
  }
  
  protected WarehouseProductSpecSummaryListGrid doSetValue(final UIWarehouseProductSpecSummary value) {
    this.value = value;
    productName.setValue(value.getProductName());
    typeDesc.setValue(value.getTypeDesc());
    brand.setValue(value.getBrand());
    sourceQuantity.setValue(value.getSourceQuantity());
    quantity.setValue(value.getQuantity());
    unit.setValue(value.getUnit());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)productName,(ICanAsWidget)typeDesc,(ICanAsWidget)brand,(ICanAsWidget)sourceQuantity,(ICanAsWidget)quantity,(ICanAsWidget)unit
    					);
  }
  
  public void initializeComponent() {
    this.asWidget();
    this.unForceFit();
  }
}
