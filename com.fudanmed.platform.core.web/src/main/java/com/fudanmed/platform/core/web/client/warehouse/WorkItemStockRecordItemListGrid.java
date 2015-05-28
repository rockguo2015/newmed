package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecordItem;
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

public class WorkItemStockRecordItemListGrid extends GXTGridComponent<UIWorkItemStockRecordItem> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringValueColumn<UIWorkItemStockRecordItem,RCWorkItemTaskProxy> workItem;
  
  public StringValueColumn<UIWorkItemStockRecordItem,RCWarehouseProxy> sourceStore;
  
  public StringColumn<UIWorkItemStockRecordItem> sid;
  
  public StringColumn<UIWorkItemStockRecordItem> productSid;
  
  public StringColumn<UIWorkItemStockRecordItem> materialId;
  
  public StringValueColumn<UIWorkItemStockRecordItem,RCProductSpecificationProxy> productSpec;
  
  public StringColumn<UIWorkItemStockRecordItem> typeDesc;
  
  public StringValueColumn<UIWorkItemStockRecordItem,RCMaterialBrandProxy> brand;
  
  public DoubleColumn<UIWorkItemStockRecordItem> price;
  
  public IntegerColumn<UIWorkItemStockRecordItem> quantity;
  
  public StringValueColumn<UIWorkItemStockRecordItem,RCProduceSpecificationUnitProxy> unit;
  
  @Inject
  private DoubleValueProviderFactory doubleValueProviderFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIWorkItemStockRecordItem value = new UIWorkItemStockRecordItem();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();workItem = defaultObjectSelectorFactory.createAsDefaultColumn("workItem","工单编号",UIWorkItemStockRecordItem.WorkItemAccessor);
    widgetsRegistory.put("workItem",workItem);
    sourceStore = defaultObjectSelectorFactory.createAsDefaultColumn("sourceStore","出库仓库",UIWorkItemStockRecordItem.SourceStoreAccessor);
    widgetsRegistory.put("sourceStore",sourceStore);
    sid = stringValueProviderFactory.createAsStringColumn("sid","入库批号",UIWorkItemStockRecordItem.SidAccessor);
    widgetsRegistory.put("sid",sid);
    productSid = stringValueProviderFactory.createAsStringColumn("productSid","条码",UIWorkItemStockRecordItem.ProductSidAccessor);
    widgetsRegistory.put("productSid",productSid);
    materialId = stringValueProviderFactory.createAsStringColumn("materialId","物品编号",UIWorkItemStockRecordItem.MaterialIdAccessor);
    widgetsRegistory.put("materialId",materialId);
    productSpec = defaultObjectSelectorFactory.createAsDefaultColumn("productSpec","物品名称",UIWorkItemStockRecordItem.ProductSpecAccessor);
    widgetsRegistory.put("productSpec",productSpec);
    typeDesc = stringValueProviderFactory.createAsStringColumn("typeDesc","规格型号",UIWorkItemStockRecordItem.TypeDescAccessor);
    widgetsRegistory.put("typeDesc",typeDesc);
    brand = defaultObjectSelectorFactory.createAsDefaultColumn("brand","品牌",UIWorkItemStockRecordItem.BrandAccessor);
    widgetsRegistory.put("brand",brand);
    price = doubleValueProviderFactory.createAsDoubleColumn("price","单价",UIWorkItemStockRecordItem.PriceAccessor);
    widgetsRegistory.put("price",price);
    quantity = integerValueProviderFactory.createAsIntegerColumn("quantity","数量",UIWorkItemStockRecordItem.QuantityAccessor);
    widgetsRegistory.put("quantity",quantity);
    unit = defaultObjectSelectorFactory.createAsDefaultColumn("unit","计量单位",UIWorkItemStockRecordItem.UnitAccessor);
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
  
  public UIWorkItemStockRecordItem getValueAsNew() {
    UIWorkItemStockRecordItem value = new UIWorkItemStockRecordItem();
    value.setWorkItem(workItem.getValue());
    value.setSourceStore(sourceStore.getValue());
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
  
  public UIWorkItemStockRecordItem doGetValue() {
    
    value.setWorkItem(workItem.getValue());
    value.setSourceStore(sourceStore.getValue());
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
  
  public UIWorkItemStockRecordItem getValue(final UIWorkItemStockRecordItem copyValue) {
    
    copyValue.setWorkItem(workItem.getValue());
    copyValue.setSourceStore(sourceStore.getValue());
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
  
  protected WorkItemStockRecordItemListGrid doSetValue(final UIWorkItemStockRecordItem value) {
    this.value = value;
    workItem.setValue(value.getWorkItem());
    sourceStore.setValue(value.getSourceStore());
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
    					(ICanAsWidget)workItem,(ICanAsWidget)sourceStore,(ICanAsWidget)sid,(ICanAsWidget)productSid,(ICanAsWidget)materialId,(ICanAsWidget)productSpec,(ICanAsWidget)typeDesc,(ICanAsWidget)brand,(ICanAsWidget)price,(ICanAsWidget)quantity,(ICanAsWidget)unit
    					);
  }
}
