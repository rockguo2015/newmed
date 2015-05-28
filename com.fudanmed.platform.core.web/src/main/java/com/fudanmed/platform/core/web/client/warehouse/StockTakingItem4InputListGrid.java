package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingItem;
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

public class StockTakingItem4InputListGrid extends GXTGridComponent<UIStockTakingItem> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIStockTakingItem> productSpecsSid;
  
  public StringColumn<UIStockTakingItem> materialId;
  
  public StringColumn<UIStockTakingItem> name;
  
  public StringColumn<UIStockTakingItem> typeDesc;
  
  public StringValueColumn<UIStockTakingItem,RCMaterialBrandProxy> brand;
  
  public IntegerColumn<UIStockTakingItem> realQuantity;
  
  public StringValueColumn<UIStockTakingItem,RCProduceSpecificationUnitProxy> unit;
  
  public IntegerColumn<UIStockTakingItem> quantity;
  
  public StringColumn<UIStockTakingItem> comment;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIStockTakingItem value = new UIStockTakingItem();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();productSpecsSid = stringValueProviderFactory.createAsStringColumn("productSpecsSid","条码",UIStockTakingItem.ProductSpecsSidAccessor);
    widgetsRegistory.put("productSpecsSid",productSpecsSid);
    materialId = stringValueProviderFactory.createAsStringColumn("materialId","物品编号",UIStockTakingItem.MaterialIdAccessor);
    widgetsRegistory.put("materialId",materialId);
    name = stringValueProviderFactory.createAsStringColumn("name","物品名称",UIStockTakingItem.NameAccessor);
    widgetsRegistory.put("name",name);
    typeDesc = stringValueProviderFactory.createAsStringColumn("typeDesc","规格型号",UIStockTakingItem.TypeDescAccessor);
    widgetsRegistory.put("typeDesc",typeDesc);
    brand = defaultObjectSelectorFactory.createAsDefaultColumn("brand","品牌",UIStockTakingItem.BrandAccessor);
    widgetsRegistory.put("brand",brand);
    realQuantity = integerValueProviderFactory.createAsIntegerColumn("realQuantity","库存数量",UIStockTakingItem.RealQuantityAccessor);
    widgetsRegistory.put("realQuantity",realQuantity);
    unit = defaultObjectSelectorFactory.createAsDefaultColumn("unit","计量单位",UIStockTakingItem.UnitAccessor);
    widgetsRegistory.put("unit",unit);
    quantity = integerValueProviderFactory.createAsEditableIntegerColumn("quantity","实盘数量",UIStockTakingItem.QuantityAccessor);
    widgetsRegistory.put("quantity",quantity);
    comment = stringValueProviderFactory.createAsEditableStringColumn("comment","异动原因",UIStockTakingItem.CommentAccessor);
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
  
  public UIStockTakingItem getValueAsNew() {
    UIStockTakingItem value = new UIStockTakingItem();
    value.setProductSpecsSid(productSpecsSid.getValue());
    value.setMaterialId(materialId.getValue());
    value.setName(name.getValue());
    value.setTypeDesc(typeDesc.getValue());
    value.setBrand(brand.getValue());
    value.setRealQuantity(realQuantity.getValue());
    value.setUnit(unit.getValue());
    value.setQuantity(quantity.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UIStockTakingItem doGetValue() {
    
    value.setProductSpecsSid(productSpecsSid.getValue());
    value.setMaterialId(materialId.getValue());
    value.setName(name.getValue());
    value.setTypeDesc(typeDesc.getValue());
    value.setBrand(brand.getValue());
    value.setRealQuantity(realQuantity.getValue());
    value.setUnit(unit.getValue());
    value.setQuantity(quantity.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UIStockTakingItem getValue(final UIStockTakingItem copyValue) {
    
    copyValue.setProductSpecsSid(productSpecsSid.getValue());
    copyValue.setMaterialId(materialId.getValue());
    copyValue.setName(name.getValue());
    copyValue.setTypeDesc(typeDesc.getValue());
    copyValue.setBrand(brand.getValue());
    copyValue.setRealQuantity(realQuantity.getValue());
    copyValue.setUnit(unit.getValue());
    copyValue.setQuantity(quantity.getValue());
    copyValue.setComment(comment.getValue());
    return copyValue;
  }
  
  protected StockTakingItem4InputListGrid doSetValue(final UIStockTakingItem value) {
    this.value = value;
    productSpecsSid.setValue(value.getProductSpecsSid());
    materialId.setValue(value.getMaterialId());
    name.setValue(value.getName());
    typeDesc.setValue(value.getTypeDesc());
    brand.setValue(value.getBrand());
    realQuantity.setValue(value.getRealQuantity());
    unit.setValue(value.getUnit());
    quantity.setValue(value.getQuantity());
    comment.setValue(value.getComment());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)productSpecsSid,(ICanAsWidget)materialId,(ICanAsWidget)name,(ICanAsWidget)typeDesc,(ICanAsWidget)brand,(ICanAsWidget)realQuantity,(ICanAsWidget)unit,(ICanAsWidget)quantity,(ICanAsWidget)comment
    					);
  }
}
