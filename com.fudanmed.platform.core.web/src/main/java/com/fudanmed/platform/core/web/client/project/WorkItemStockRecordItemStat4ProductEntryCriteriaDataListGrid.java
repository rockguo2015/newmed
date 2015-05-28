package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockRecordItemStat4ProductEntryCriteriaData;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class WorkItemStockRecordItemStat4ProductEntryCriteriaDataListGrid extends GXTGridComponent<UIWorkItemStockRecordItemStat4ProductEntryCriteriaData> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringValueColumn<UIWorkItemStockRecordItemStat4ProductEntryCriteriaData,RCProductSpecificationProxy> productEntry;
  
  public StringColumn<UIWorkItemStockRecordItemStat4ProductEntryCriteriaData> typeDesc;
  
  public StringValueColumn<UIWorkItemStockRecordItemStat4ProductEntryCriteriaData,Long> cnt;
  
  public StringColumn<UIWorkItemStockRecordItemStat4ProductEntryCriteriaData> unit;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIWorkItemStockRecordItemStat4ProductEntryCriteriaData value = new UIWorkItemStockRecordItemStat4ProductEntryCriteriaData();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();productEntry = defaultObjectSelectorFactory.createAsDefaultColumn("productEntry","物品名称",UIWorkItemStockRecordItemStat4ProductEntryCriteriaData.ProductEntryAccessor);
    widgetsRegistory.put("productEntry",productEntry);
    typeDesc = stringValueProviderFactory.createAsStringColumn("typeDesc","规格型号",UIWorkItemStockRecordItemStat4ProductEntryCriteriaData.TypeDescAccessor);
    widgetsRegistory.put("typeDesc",typeDesc);
    cnt = defaultObjectSelectorFactory.createAsDefaultColumn("cnt","数量",UIWorkItemStockRecordItemStat4ProductEntryCriteriaData.CntAccessor);
    widgetsRegistory.put("cnt",cnt);
    unit = stringValueProviderFactory.createAsStringColumn("unit","单位",UIWorkItemStockRecordItemStat4ProductEntryCriteriaData.UnitAccessor);
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
  
  public UIWorkItemStockRecordItemStat4ProductEntryCriteriaData getValueAsNew() {
    UIWorkItemStockRecordItemStat4ProductEntryCriteriaData value = new UIWorkItemStockRecordItemStat4ProductEntryCriteriaData();
    value.setProductEntry(productEntry.getValue());
    value.setTypeDesc(typeDesc.getValue());
    value.setCnt(cnt.getValue());
    value.setUnit(unit.getValue());
    return value;
  }
  
  public UIWorkItemStockRecordItemStat4ProductEntryCriteriaData doGetValue() {
    
    value.setProductEntry(productEntry.getValue());
    value.setTypeDesc(typeDesc.getValue());
    value.setCnt(cnt.getValue());
    value.setUnit(unit.getValue());
    return value;
  }
  
  public UIWorkItemStockRecordItemStat4ProductEntryCriteriaData getValue(final UIWorkItemStockRecordItemStat4ProductEntryCriteriaData copyValue) {
    
    copyValue.setProductEntry(productEntry.getValue());
    copyValue.setTypeDesc(typeDesc.getValue());
    copyValue.setCnt(cnt.getValue());
    copyValue.setUnit(unit.getValue());
    return copyValue;
  }
  
  protected WorkItemStockRecordItemStat4ProductEntryCriteriaDataListGrid doSetValue(final UIWorkItemStockRecordItemStat4ProductEntryCriteriaData value) {
    this.value = value;
    productEntry.setValue(value.getProductEntry());
    typeDesc.setValue(value.getTypeDesc());
    cnt.setValue(value.getCnt());
    unit.setValue(value.getUnit());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)productEntry,(ICanAsWidget)typeDesc,(ICanAsWidget)cnt,(ICanAsWidget)unit
    					);
  }
}
