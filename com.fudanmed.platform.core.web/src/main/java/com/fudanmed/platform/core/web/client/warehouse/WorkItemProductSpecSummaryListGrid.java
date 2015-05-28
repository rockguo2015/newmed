package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemProductSpecSummary;
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

public class WorkItemProductSpecSummaryListGrid extends GXTGridComponent<UIWorkItemProductSpecSummary> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIWorkItemProductSpecSummary> productSid;
  
  public StringColumn<UIWorkItemProductSpecSummary> productName;
  
  public StringColumn<UIWorkItemProductSpecSummary> typeDesc;
  
  public IntegerColumn<UIWorkItemProductSpecSummary> sourceQuantity;
  
  public IntegerColumn<UIWorkItemProductSpecSummary> quantity;
  
  public StringValueColumn<UIWorkItemProductSpecSummary,RCProduceSpecificationUnitProxy> unit;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  private UIWorkItemProductSpecSummary value = new UIWorkItemProductSpecSummary();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();productSid = stringValueProviderFactory.createAsStringColumn("productSid","条码",UIWorkItemProductSpecSummary.ProductSidAccessor);
    widgetsRegistory.put("productSid",productSid);
    productName = stringValueProviderFactory.createAsStringColumn("productName","物品",UIWorkItemProductSpecSummary.ProductNameAccessor);
    widgetsRegistory.put("productName",productName);
    typeDesc = stringValueProviderFactory.createAsStringColumn("typeDesc","规格型号",UIWorkItemProductSpecSummary.TypeDescAccessor);
    widgetsRegistory.put("typeDesc",typeDesc);
    sourceQuantity = integerValueProviderFactory.createAsIntegerColumn("sourceQuantity","已领数量",UIWorkItemProductSpecSummary.SourceQuantityAccessor);
    widgetsRegistory.put("sourceQuantity",sourceQuantity);
    quantity = integerValueProviderFactory.createAsEditableIntegerColumn("quantity","退料数量",UIWorkItemProductSpecSummary.QuantityAccessor);
    widgetsRegistory.put("quantity",quantity);
    unit = defaultObjectSelectorFactory.createAsDefaultColumn("unit","计量单位",UIWorkItemProductSpecSummary.UnitAccessor);
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
  
  public UIWorkItemProductSpecSummary getValueAsNew() {
    UIWorkItemProductSpecSummary value = new UIWorkItemProductSpecSummary();
    value.setProductSid(productSid.getValue());
    value.setProductName(productName.getValue());
    value.setTypeDesc(typeDesc.getValue());
    value.setSourceQuantity(sourceQuantity.getValue());
    value.setQuantity(quantity.getValue());
    value.setUnit(unit.getValue());
    return value;
  }
  
  public UIWorkItemProductSpecSummary doGetValue() {
    
    value.setProductSid(productSid.getValue());
    value.setProductName(productName.getValue());
    value.setTypeDesc(typeDesc.getValue());
    value.setSourceQuantity(sourceQuantity.getValue());
    value.setQuantity(quantity.getValue());
    value.setUnit(unit.getValue());
    return value;
  }
  
  public UIWorkItemProductSpecSummary getValue(final UIWorkItemProductSpecSummary copyValue) {
    
    copyValue.setProductSid(productSid.getValue());
    copyValue.setProductName(productName.getValue());
    copyValue.setTypeDesc(typeDesc.getValue());
    copyValue.setSourceQuantity(sourceQuantity.getValue());
    copyValue.setQuantity(quantity.getValue());
    copyValue.setUnit(unit.getValue());
    return copyValue;
  }
  
  protected WorkItemProductSpecSummaryListGrid doSetValue(final UIWorkItemProductSpecSummary value) {
    this.value = value;
    productSid.setValue(value.getProductSid());
    productName.setValue(value.getProductName());
    typeDesc.setValue(value.getTypeDesc());
    sourceQuantity.setValue(value.getSourceQuantity());
    quantity.setValue(value.getQuantity());
    unit.setValue(value.getUnit());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)productSid,(ICanAsWidget)productName,(ICanAsWidget)typeDesc,(ICanAsWidget)sourceQuantity,(ICanAsWidget)quantity,(ICanAsWidget)unit
    					);
  }
}
