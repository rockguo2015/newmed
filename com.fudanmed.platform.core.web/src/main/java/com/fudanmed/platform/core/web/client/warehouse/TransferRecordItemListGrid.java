package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductEntryProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UITransferRecordItem;
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

public class TransferRecordItemListGrid extends GXTGridComponent<UITransferRecordItem> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UITransferRecordItem> sid;
  
  public StringColumn<UITransferRecordItem> productSid;
  
  public StringColumn<UITransferRecordItem> materialId;
  
  public StringValueColumn<UITransferRecordItem,RCProductEntryProxy> productEntry;
  
  public StringColumn<UITransferRecordItem> typeDesc;
  
  public StringValueColumn<UITransferRecordItem,RCMaterialBrandProxy> brand;
  
  public DoubleColumn<UITransferRecordItem> price;
  
  public IntegerColumn<UITransferRecordItem> quantity;
  
  public StringValueColumn<UITransferRecordItem,RCProduceSpecificationUnitProxy> unit;
  
  @Inject
  private DoubleValueProviderFactory doubleValueProviderFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UITransferRecordItem value = new UITransferRecordItem();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sid = stringValueProviderFactory.createAsStringColumn("sid","入库批号",UITransferRecordItem.SidAccessor);
    widgetsRegistory.put("sid",sid);
    productSid = stringValueProviderFactory.createAsStringColumn("productSid","条码",UITransferRecordItem.ProductSidAccessor);
    widgetsRegistory.put("productSid",productSid);
    materialId = stringValueProviderFactory.createAsStringColumn("materialId","物品编号",UITransferRecordItem.MaterialIdAccessor);
    widgetsRegistory.put("materialId",materialId);
    productEntry = defaultObjectSelectorFactory.createAsDefaultColumn("productEntry","物品名称",UITransferRecordItem.ProductEntryAccessor);
    widgetsRegistory.put("productEntry",productEntry);
    typeDesc = stringValueProviderFactory.createAsStringColumn("typeDesc","规格型号",UITransferRecordItem.TypeDescAccessor);
    widgetsRegistory.put("typeDesc",typeDesc);
    brand = defaultObjectSelectorFactory.createAsDefaultColumn("brand","品牌",UITransferRecordItem.BrandAccessor);
    widgetsRegistory.put("brand",brand);
    price = doubleValueProviderFactory.createAsDoubleColumn("price","单价",UITransferRecordItem.PriceAccessor);
    widgetsRegistory.put("price",price);
    quantity = integerValueProviderFactory.createAsIntegerColumn("quantity","数量",UITransferRecordItem.QuantityAccessor);
    widgetsRegistory.put("quantity",quantity);
    unit = defaultObjectSelectorFactory.createAsDefaultColumn("unit","计量单位",UITransferRecordItem.UnitAccessor);
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
  
  public UITransferRecordItem getValueAsNew() {
    UITransferRecordItem value = new UITransferRecordItem();
    value.setSid(sid.getValue());
    value.setProductSid(productSid.getValue());
    value.setMaterialId(materialId.getValue());
    value.setProductEntry(productEntry.getValue());
    value.setTypeDesc(typeDesc.getValue());
    value.setBrand(brand.getValue());
    value.setPrice(price.getValue());
    value.setQuantity(quantity.getValue());
    value.setUnit(unit.getValue());
    return value;
  }
  
  public UITransferRecordItem doGetValue() {
    
    value.setSid(sid.getValue());
    value.setProductSid(productSid.getValue());
    value.setMaterialId(materialId.getValue());
    value.setProductEntry(productEntry.getValue());
    value.setTypeDesc(typeDesc.getValue());
    value.setBrand(brand.getValue());
    value.setPrice(price.getValue());
    value.setQuantity(quantity.getValue());
    value.setUnit(unit.getValue());
    return value;
  }
  
  public UITransferRecordItem getValue(final UITransferRecordItem copyValue) {
    
    copyValue.setSid(sid.getValue());
    copyValue.setProductSid(productSid.getValue());
    copyValue.setMaterialId(materialId.getValue());
    copyValue.setProductEntry(productEntry.getValue());
    copyValue.setTypeDesc(typeDesc.getValue());
    copyValue.setBrand(brand.getValue());
    copyValue.setPrice(price.getValue());
    copyValue.setQuantity(quantity.getValue());
    copyValue.setUnit(unit.getValue());
    return copyValue;
  }
  
  protected TransferRecordItemListGrid doSetValue(final UITransferRecordItem value) {
    this.value = value;
    sid.setValue(value.getSid());
    productSid.setValue(value.getProductSid());
    materialId.setValue(value.getMaterialId());
    productEntry.setValue(value.getProductEntry());
    typeDesc.setValue(value.getTypeDesc());
    brand.setValue(value.getBrand());
    price.setValue(value.getPrice());
    quantity.setValue(value.getQuantity());
    unit.setValue(value.getUnit());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)sid,(ICanAsWidget)productSid,(ICanAsWidget)materialId,(ICanAsWidget)productEntry,(ICanAsWidget)typeDesc,(ICanAsWidget)brand,(ICanAsWidget)price,(ICanAsWidget)quantity,(ICanAsWidget)unit
    					);
  }
}
