package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy;
import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductTypeProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;
import edu.fudan.langlab.gxt.client.component.propertyview.GXTPropertyView;
import edu.fudan.langlab.gxt.client.component.propertyview.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.propertyview.factory.DoubleValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.propertyview.factory.DoubleValueProviderFactory.DoublePropertyItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class ProductSpecificationDetailForm extends GXTPropertyView<UIProductSpecification> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public IValueViewer<String> sid;
  
  public IValueViewer<String> name;
  
  public IValueViewer<String> typeDesc;
  
  public IValueViewer<RCProduceSpecificationUnitProxy> unit;
  
  public IValueViewer<RCProductTypeProxy> productType;
  
  public IValueViewer<RCSupplierProxy> defaultSupplier;
  
  public IValueViewer<RCMaterialBrandProxy> brandType;
  
  public DoublePropertyItem referencePrice;
  
  public IValueViewer<String> materialId;
  
  public IValueViewer<Integer> shelfLife;
  
  public IValueViewer<Integer> lowerStorage;
  
  public IValueViewer<Integer> upperStorage;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private DoubleValueProviderFactory doubleValueProviderFactory;
  
  private UIProductSpecification value = new UIProductSpecification();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sid = defaultObjectSelectorFactory.createAsPropertyItem("sid","条码");
    widgetsRegistory.put("sid",sid);
    name = defaultObjectSelectorFactory.createAsPropertyItem("name","物品名称");
    widgetsRegistory.put("name",name);
    typeDesc = defaultObjectSelectorFactory.createAsPropertyItem("typeDesc","规格型号");
    widgetsRegistory.put("typeDesc",typeDesc);
    unit = defaultObjectSelectorFactory.createAsPropertyItem("unit","单位");
    widgetsRegistory.put("unit",unit);
    productType = defaultObjectSelectorFactory.createAsPropertyItem("productType","物品类别");
    widgetsRegistory.put("productType",productType);
    defaultSupplier = defaultObjectSelectorFactory.createAsPropertyItem("defaultSupplier","默认供应商");
    widgetsRegistory.put("defaultSupplier",defaultSupplier);
    brandType = defaultObjectSelectorFactory.createAsPropertyItem("brandType","品牌");
    widgetsRegistory.put("brandType",brandType);
    referencePrice = doubleValueProviderFactory.createAsDoubleItem("referencePrice","参考单价");
    widgetsRegistory.put("referencePrice",referencePrice);
    materialId = defaultObjectSelectorFactory.createAsPropertyItem("materialId","物品编号");
    widgetsRegistory.put("materialId",materialId);
    shelfLife = defaultObjectSelectorFactory.createAsPropertyItem("shelfLife","保质期(天)");
    widgetsRegistory.put("shelfLife",shelfLife);
    lowerStorage = defaultObjectSelectorFactory.createAsPropertyItem("lowerStorage","最小库存");
    widgetsRegistory.put("lowerStorage",lowerStorage);
    upperStorage = defaultObjectSelectorFactory.createAsPropertyItem("upperStorage","最大库存");
    widgetsRegistory.put("upperStorage",upperStorage);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIProductSpecification getValueAsNew() {
    UIProductSpecification value = new UIProductSpecification();
    return value;
  }
  
  public UIProductSpecification doGetValue() {
    
    return value;
  }
  
  public UIProductSpecification getValue(final UIProductSpecification copyValue) {
    
    return copyValue;
  }
  
  protected ProductSpecificationDetailForm doSetValue(final UIProductSpecification value) {
    this.value = value;
    sid.setValue(value.getSid());
    name.setValue(value.getName());
    typeDesc.setValue(value.getTypeDesc());
    unit.setValue(value.getUnit());
    productType.setValue(value.getProductType());
    defaultSupplier.setValue(value.getDefaultSupplier());
    brandType.setValue(value.getBrandType());
    referencePrice.setValue(value.getReferencePrice());
    materialId.setValue(value.getMaterialId());
    shelfLife.setValue(value.getShelfLife());
    lowerStorage.setValue(value.getLowerStorage());
    upperStorage.setValue(value.getUpperStorage());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)sid,(ICanAsWidget)name,(ICanAsWidget)typeDesc,(ICanAsWidget)unit,(ICanAsWidget)productType,(ICanAsWidget)defaultSupplier,(ICanAsWidget)brandType,(ICanAsWidget)referencePrice,(ICanAsWidget)materialId,(ICanAsWidget)shelfLife,(ICanAsWidget)lowerStorage,(ICanAsWidget)upperStorage
    					);
  }
  
  public Integer getCols() {
    return Integer.valueOf(3);
  }
}
