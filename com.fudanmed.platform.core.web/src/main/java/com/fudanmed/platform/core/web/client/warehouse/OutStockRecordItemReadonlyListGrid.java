package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationListView;
import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecordItem;
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

public class OutStockRecordItemReadonlyListGrid extends GXTGridComponent<UIOutStockRecordItem> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIOutStockRecordItem> sid;
  
  public StringColumn<UIOutStockRecordItem> productSid;
  
  public StringColumn<UIOutStockRecordItem> materialId;
  
  public StringValueColumn<UIOutStockRecordItem,RCProductSpecificationProxy> productSpec;
  
  public StringColumn<UIOutStockRecordItem> typeDesc;
  
  public StringValueColumn<UIOutStockRecordItem,RCMaterialBrandProxy> brand;
  
  public DoubleColumn<UIOutStockRecordItem> price;
  
  public IntegerColumn<UIOutStockRecordItem> quantity;
  
  public StringValueColumn<UIOutStockRecordItem,RCProduceSpecificationUnitProxy> unit;
  
  @Inject
  private DoubleValueProviderFactory doubleValueProviderFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIOutStockRecordItem value = new UIOutStockRecordItem();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sid = stringValueProviderFactory.createAsStringColumn("sid","入库批号",UIOutStockRecordItem.SidAccessor,Integer.valueOf(70));
    widgetsRegistory.put("sid",sid);
    productSid = stringValueProviderFactory.createAsStringColumn("productSid","条码",UIOutStockRecordItem.ProductSidAccessor,Integer.valueOf(70));
    widgetsRegistory.put("productSid",productSid);
    materialId = stringValueProviderFactory.createAsStringColumn("materialId","物品编号",UIOutStockRecordItem.MaterialIdAccessor,Integer.valueOf(70));
    widgetsRegistory.put("materialId",materialId);
    productSpec = defaultObjectSelectorFactory.createAsDefaultColumn("productSpec","物品名称",UIOutStockRecordItem.ProductSpecAccessor,Integer.valueOf(100));
    widgetsRegistory.put("productSpec",productSpec);
    typeDesc = stringValueProviderFactory.createAsStringColumn("typeDesc","规格型号",UIOutStockRecordItem.TypeDescAccessor,Integer.valueOf(60));
    widgetsRegistory.put("typeDesc",typeDesc);
    brand = defaultObjectSelectorFactory.createAsDefaultColumn("brand","品牌",UIOutStockRecordItem.BrandAccessor);
    widgetsRegistory.put("brand",brand);
    price = doubleValueProviderFactory.createAsDoubleColumn("price","单价",UIOutStockRecordItem.PriceAccessor);
    widgetsRegistory.put("price",price);
    quantity = integerValueProviderFactory.createAsIntegerColumn("quantity","数量",UIOutStockRecordItem.QuantityAccessor);
    widgetsRegistory.put("quantity",quantity);
    unit = defaultObjectSelectorFactory.createAsDefaultColumn("unit","计量单位",UIOutStockRecordItem.UnitAccessor,Integer.valueOf(50));
    widgetsRegistory.put("unit",unit);
    if(productSpecificationListView instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)productSpecificationListView);
    						}IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIOutStockRecordItem getValueAsNew() {
    UIOutStockRecordItem value = new UIOutStockRecordItem();
    value.setSid(sid.getValue());
    value.setProductSid(productSid.getValue());
    value.setMaterialId(materialId.getValue());
    value.setProductSpec(productSpec.getValue());
    value.setTypeDesc(typeDesc.getValue());
    value.setBrand(brand.getValue());
    value.setPrice(price.getValue());
    value.setQuantity(quantity.getValue());
    value.setUnit(unit.getValue());
    return value;
  }
  
  public UIOutStockRecordItem doGetValue() {
    
    value.setSid(sid.getValue());
    value.setProductSid(productSid.getValue());
    value.setMaterialId(materialId.getValue());
    value.setProductSpec(productSpec.getValue());
    value.setTypeDesc(typeDesc.getValue());
    value.setBrand(brand.getValue());
    value.setPrice(price.getValue());
    value.setQuantity(quantity.getValue());
    value.setUnit(unit.getValue());
    return value;
  }
  
  public UIOutStockRecordItem getValue(final UIOutStockRecordItem copyValue) {
    
    copyValue.setSid(sid.getValue());
    copyValue.setProductSid(productSid.getValue());
    copyValue.setMaterialId(materialId.getValue());
    copyValue.setProductSpec(productSpec.getValue());
    copyValue.setTypeDesc(typeDesc.getValue());
    copyValue.setBrand(brand.getValue());
    copyValue.setPrice(price.getValue());
    copyValue.setQuantity(quantity.getValue());
    copyValue.setUnit(unit.getValue());
    return copyValue;
  }
  
  protected OutStockRecordItemReadonlyListGrid doSetValue(final UIOutStockRecordItem value) {
    this.value = value;
    sid.setValue(value.getSid());
    productSid.setValue(value.getProductSid());
    materialId.setValue(value.getMaterialId());
    productSpec.setValue(value.getProductSpec());
    typeDesc.setValue(value.getTypeDesc());
    brand.setValue(value.getBrand());
    price.setValue(value.getPrice());
    quantity.setValue(value.getQuantity());
    unit.setValue(value.getUnit());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)sid,(ICanAsWidget)productSid,(ICanAsWidget)materialId,(ICanAsWidget)productSpec,(ICanAsWidget)typeDesc,(ICanAsWidget)brand,(ICanAsWidget)price,(ICanAsWidget)quantity,(ICanAsWidget)unit
    					);
  }
  
  @Inject
  private ProductSpecificationListView productSpecificationListView;
}
