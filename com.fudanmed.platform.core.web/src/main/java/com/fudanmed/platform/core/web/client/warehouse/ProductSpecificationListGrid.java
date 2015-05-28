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

public class ProductSpecificationListGrid extends GXTGridComponent<UIProductSpecification> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIProductSpecification> sid;
  
  public StringColumn<UIProductSpecification> materialId;
  
  public StringColumn<UIProductSpecification> name;
  
  public StringColumn<UIProductSpecification> typeDesc;
  
  public StringValueColumn<UIProductSpecification,RCProduceSpecificationUnitProxy> unit;
  
  public StringValueColumn<UIProductSpecification,RCProductTypeProxy> productType;
  
  public StringValueColumn<UIProductSpecification,RCSupplierProxy> defaultSupplier;
  
  public StringValueColumn<UIProductSpecification,RCMaterialBrandProxy> brandType;
  
  public DoubleColumn<UIProductSpecification> referencePrice;
  
  public IntegerColumn<UIProductSpecification> shelfLife;
  
  public IntegerColumn<UIProductSpecification> lowerStorage;
  
  public IntegerColumn<UIProductSpecification> upperStorage;
  
  @Inject
  private DoubleValueProviderFactory doubleValueProviderFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIProductSpecification value = new UIProductSpecification();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sid = stringValueProviderFactory.createAsStringColumn("sid","条码",UIProductSpecification.SidAccessor,Integer.valueOf(80));
    widgetsRegistory.put("sid",sid);
    materialId = stringValueProviderFactory.createAsStringColumn("materialId","物品编号",UIProductSpecification.MaterialIdAccessor,Integer.valueOf(80));
    widgetsRegistory.put("materialId",materialId);
    name = stringValueProviderFactory.createAsStringColumn("name","物品名称",UIProductSpecification.NameAccessor,Integer.valueOf(100));
    widgetsRegistory.put("name",name);
    typeDesc = stringValueProviderFactory.createAsStringColumn("typeDesc","规格型号",UIProductSpecification.TypeDescAccessor);
    widgetsRegistory.put("typeDesc",typeDesc);
    unit = defaultObjectSelectorFactory.createAsDefaultColumn("unit","单位",UIProductSpecification.UnitAccessor,Integer.valueOf(60));
    widgetsRegistory.put("unit",unit);
    productType = defaultObjectSelectorFactory.createAsDefaultColumn("productType","物品类别",UIProductSpecification.ProductTypeAccessor);
    widgetsRegistory.put("productType",productType);
    defaultSupplier = defaultObjectSelectorFactory.createAsDefaultColumn("defaultSupplier","默认供应商",UIProductSpecification.DefaultSupplierAccessor,Integer.valueOf(150));
    widgetsRegistory.put("defaultSupplier",defaultSupplier);
    brandType = defaultObjectSelectorFactory.createAsDefaultColumn("brandType","品牌",UIProductSpecification.BrandTypeAccessor,Integer.valueOf(108));
    widgetsRegistory.put("brandType",brandType);
    referencePrice = doubleValueProviderFactory.createAsDoubleColumn("referencePrice","参考单价",UIProductSpecification.ReferencePriceAccessor,Integer.valueOf(70));
    widgetsRegistory.put("referencePrice",referencePrice);
    shelfLife = integerValueProviderFactory.createAsIntegerColumn("shelfLife","保质期(天)",UIProductSpecification.ShelfLifeAccessor);
    widgetsRegistory.put("shelfLife",shelfLife);
    lowerStorage = integerValueProviderFactory.createAsIntegerColumn("lowerStorage","最小库存",UIProductSpecification.LowerStorageAccessor);
    widgetsRegistory.put("lowerStorage",lowerStorage);
    upperStorage = integerValueProviderFactory.createAsIntegerColumn("upperStorage","最大库存",UIProductSpecification.UpperStorageAccessor);
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
    value.setSid(sid.getValue());
    value.setMaterialId(materialId.getValue());
    value.setName(name.getValue());
    value.setTypeDesc(typeDesc.getValue());
    value.setUnit(unit.getValue());
    value.setProductType(productType.getValue());
    value.setDefaultSupplier(defaultSupplier.getValue());
    value.setBrandType(brandType.getValue());
    value.setReferencePrice(referencePrice.getValue());
    value.setShelfLife(shelfLife.getValue());
    value.setLowerStorage(lowerStorage.getValue());
    value.setUpperStorage(upperStorage.getValue());
    return value;
  }
  
  public UIProductSpecification doGetValue() {
    
    value.setSid(sid.getValue());
    value.setMaterialId(materialId.getValue());
    value.setName(name.getValue());
    value.setTypeDesc(typeDesc.getValue());
    value.setUnit(unit.getValue());
    value.setProductType(productType.getValue());
    value.setDefaultSupplier(defaultSupplier.getValue());
    value.setBrandType(brandType.getValue());
    value.setReferencePrice(referencePrice.getValue());
    value.setShelfLife(shelfLife.getValue());
    value.setLowerStorage(lowerStorage.getValue());
    value.setUpperStorage(upperStorage.getValue());
    return value;
  }
  
  public UIProductSpecification getValue(final UIProductSpecification copyValue) {
    
    copyValue.setSid(sid.getValue());
    copyValue.setMaterialId(materialId.getValue());
    copyValue.setName(name.getValue());
    copyValue.setTypeDesc(typeDesc.getValue());
    copyValue.setUnit(unit.getValue());
    copyValue.setProductType(productType.getValue());
    copyValue.setDefaultSupplier(defaultSupplier.getValue());
    copyValue.setBrandType(brandType.getValue());
    copyValue.setReferencePrice(referencePrice.getValue());
    copyValue.setShelfLife(shelfLife.getValue());
    copyValue.setLowerStorage(lowerStorage.getValue());
    copyValue.setUpperStorage(upperStorage.getValue());
    return copyValue;
  }
  
  protected ProductSpecificationListGrid doSetValue(final UIProductSpecification value) {
    this.value = value;
    sid.setValue(value.getSid());
    materialId.setValue(value.getMaterialId());
    name.setValue(value.getName());
    typeDesc.setValue(value.getTypeDesc());
    unit.setValue(value.getUnit());
    productType.setValue(value.getProductType());
    defaultSupplier.setValue(value.getDefaultSupplier());
    brandType.setValue(value.getBrandType());
    referencePrice.setValue(value.getReferencePrice());
    shelfLife.setValue(value.getShelfLife());
    lowerStorage.setValue(value.getLowerStorage());
    upperStorage.setValue(value.getUpperStorage());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)sid,(ICanAsWidget)materialId,(ICanAsWidget)name,(ICanAsWidget)typeDesc,(ICanAsWidget)unit,(ICanAsWidget)productType,(ICanAsWidget)defaultSupplier,(ICanAsWidget)brandType,(ICanAsWidget)referencePrice,(ICanAsWidget)shelfLife,(ICanAsWidget)lowerStorage,(ICanAsWidget)upperStorage
    					);
  }
  
  public void initializeComponent() {
    this.asWidget();
    this.unForceFit();
  }
}
