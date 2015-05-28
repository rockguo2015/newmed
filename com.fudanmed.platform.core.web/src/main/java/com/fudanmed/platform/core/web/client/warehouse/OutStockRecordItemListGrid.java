package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecordItem;
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

public class OutStockRecordItemListGrid extends GXTGridComponent<UIOutStockRecordItem> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringValueColumn<UIOutStockRecordItem,RCWarehouseProxy> sourceStore;
  
  public StringValueColumn<UIOutStockRecordItem,RCProductSpecificationProxy> productSpec;
  
  public StringColumn<UIOutStockRecordItem> sid;
  
  public StringColumn<UIOutStockRecordItem> productSid;
  
  public StringColumn<UIOutStockRecordItem> typeDesc;
  
  public IntegerColumn<UIOutStockRecordItem> quantity;
  
  public StringValueColumn<UIOutStockRecordItem,RCProduceSpecificationUnitProxy> unit;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIOutStockRecordItem value = new UIOutStockRecordItem();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sourceStore = defaultObjectSelectorFactory.createAsDefaultColumn("sourceStore","出库仓库",UIOutStockRecordItem.SourceStoreAccessor);
    widgetsRegistory.put("sourceStore",sourceStore);
    productSpec = defaultObjectSelectorFactory.createAsDefaultColumn("productSpec","物品名称",UIOutStockRecordItem.ProductSpecAccessor);
    widgetsRegistory.put("productSpec",productSpec);
    sid = stringValueProviderFactory.createAsStringColumn("sid","入库批号",UIOutStockRecordItem.SidAccessor);
    widgetsRegistory.put("sid",sid);
    productSid = stringValueProviderFactory.createAsStringColumn("productSid","条码",UIOutStockRecordItem.ProductSidAccessor);
    widgetsRegistory.put("productSid",productSid);
    typeDesc = stringValueProviderFactory.createAsStringColumn("typeDesc","规格型号",UIOutStockRecordItem.TypeDescAccessor);
    widgetsRegistory.put("typeDesc",typeDesc);
    quantity = integerValueProviderFactory.createAsIntegerColumn("quantity","数量",UIOutStockRecordItem.QuantityAccessor);
    widgetsRegistory.put("quantity",quantity);
    unit = defaultObjectSelectorFactory.createAsDefaultColumn("unit","计量单位",UIOutStockRecordItem.UnitAccessor);
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
  
  public UIOutStockRecordItem getValueAsNew() {
    UIOutStockRecordItem value = new UIOutStockRecordItem();
    value.setSourceStore(sourceStore.getValue());
    value.setProductSpec(productSpec.getValue());
    value.setSid(sid.getValue());
    value.setProductSid(productSid.getValue());
    value.setTypeDesc(typeDesc.getValue());
    value.setQuantity(quantity.getValue());
    value.setUnit(unit.getValue());
    return value;
  }
  
  public UIOutStockRecordItem doGetValue() {
    
    value.setSourceStore(sourceStore.getValue());
    value.setProductSpec(productSpec.getValue());
    value.setSid(sid.getValue());
    value.setProductSid(productSid.getValue());
    value.setTypeDesc(typeDesc.getValue());
    value.setQuantity(quantity.getValue());
    value.setUnit(unit.getValue());
    return value;
  }
  
  public UIOutStockRecordItem getValue(final UIOutStockRecordItem copyValue) {
    
    copyValue.setSourceStore(sourceStore.getValue());
    copyValue.setProductSpec(productSpec.getValue());
    copyValue.setSid(sid.getValue());
    copyValue.setProductSid(productSid.getValue());
    copyValue.setTypeDesc(typeDesc.getValue());
    copyValue.setQuantity(quantity.getValue());
    copyValue.setUnit(unit.getValue());
    return copyValue;
  }
  
  protected OutStockRecordItemListGrid doSetValue(final UIOutStockRecordItem value) {
    this.value = value;
    sourceStore.setValue(value.getSourceStore());
    productSpec.setValue(value.getProductSpec());
    sid.setValue(value.getSid());
    productSid.setValue(value.getProductSid());
    typeDesc.setValue(value.getTypeDesc());
    quantity.setValue(value.getQuantity());
    unit.setValue(value.getUnit());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)sourceStore,(ICanAsWidget)productSpec,(ICanAsWidget)sid,(ICanAsWidget)productSid,(ICanAsWidget)typeDesc,(ICanAsWidget)quantity,(ICanAsWidget)unit
    					);
  }
}
