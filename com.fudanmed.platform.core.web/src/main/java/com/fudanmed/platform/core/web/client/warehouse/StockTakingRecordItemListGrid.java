package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecordItem;
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

public class StockTakingRecordItemListGrid extends GXTGridComponent<UIStockTakingRecordItem> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringValueColumn<UIStockTakingRecordItem,RCWarehouseProxy> sourceStore;
  
  public StringValueColumn<UIStockTakingRecordItem,RCProductSpecificationProxy> productSpec;
  
  public StringColumn<UIStockTakingRecordItem> sid;
  
  public StringColumn<UIStockTakingRecordItem> productSid;
  
  public StringColumn<UIStockTakingRecordItem> typeDesc;
  
  public IntegerColumn<UIStockTakingRecordItem> quantity;
  
  public StringValueColumn<UIStockTakingRecordItem,RCProduceSpecificationUnitProxy> unit;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIStockTakingRecordItem value = new UIStockTakingRecordItem();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sourceStore = defaultObjectSelectorFactory.createAsDefaultColumn("sourceStore","盘点仓库",UIStockTakingRecordItem.SourceStoreAccessor);
    widgetsRegistory.put("sourceStore",sourceStore);
    productSpec = defaultObjectSelectorFactory.createAsDefaultColumn("productSpec","物品",UIStockTakingRecordItem.ProductSpecAccessor);
    widgetsRegistory.put("productSpec",productSpec);
    sid = stringValueProviderFactory.createAsStringColumn("sid","入库批号",UIStockTakingRecordItem.SidAccessor);
    widgetsRegistory.put("sid",sid);
    productSid = stringValueProviderFactory.createAsStringColumn("productSid","条码",UIStockTakingRecordItem.ProductSidAccessor);
    widgetsRegistory.put("productSid",productSid);
    typeDesc = stringValueProviderFactory.createAsStringColumn("typeDesc","规格型号",UIStockTakingRecordItem.TypeDescAccessor);
    widgetsRegistory.put("typeDesc",typeDesc);
    quantity = integerValueProviderFactory.createAsIntegerColumn("quantity","数量",UIStockTakingRecordItem.QuantityAccessor);
    widgetsRegistory.put("quantity",quantity);
    unit = defaultObjectSelectorFactory.createAsDefaultColumn("unit","计量单位",UIStockTakingRecordItem.UnitAccessor);
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
  
  public UIStockTakingRecordItem getValueAsNew() {
    UIStockTakingRecordItem value = new UIStockTakingRecordItem();
    value.setSourceStore(sourceStore.getValue());
    value.setProductSpec(productSpec.getValue());
    value.setSid(sid.getValue());
    value.setProductSid(productSid.getValue());
    value.setTypeDesc(typeDesc.getValue());
    value.setQuantity(quantity.getValue());
    value.setUnit(unit.getValue());
    return value;
  }
  
  public UIStockTakingRecordItem doGetValue() {
    
    value.setSourceStore(sourceStore.getValue());
    value.setProductSpec(productSpec.getValue());
    value.setSid(sid.getValue());
    value.setProductSid(productSid.getValue());
    value.setTypeDesc(typeDesc.getValue());
    value.setQuantity(quantity.getValue());
    value.setUnit(unit.getValue());
    return value;
  }
  
  public UIStockTakingRecordItem getValue(final UIStockTakingRecordItem copyValue) {
    
    copyValue.setSourceStore(sourceStore.getValue());
    copyValue.setProductSpec(productSpec.getValue());
    copyValue.setSid(sid.getValue());
    copyValue.setProductSid(productSid.getValue());
    copyValue.setTypeDesc(typeDesc.getValue());
    copyValue.setQuantity(quantity.getValue());
    copyValue.setUnit(unit.getValue());
    return copyValue;
  }
  
  protected StockTakingRecordItemListGrid doSetValue(final UIStockTakingRecordItem value) {
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
