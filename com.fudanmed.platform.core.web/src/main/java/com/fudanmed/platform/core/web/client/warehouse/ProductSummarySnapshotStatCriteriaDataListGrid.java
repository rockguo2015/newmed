package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSummarySnapshotStatCriteriaData;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DoubleValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DoubleValueProviderFactory.DoubleColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class ProductSummarySnapshotStatCriteriaDataListGrid extends GXTGridComponent<UIProductSummarySnapshotStatCriteriaData> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringValueColumn<UIProductSummarySnapshotStatCriteriaData,RCWarehouseProxy> store;
  
  public StringValueColumn<UIProductSummarySnapshotStatCriteriaData,RCProductSpecificationProxy> productSpec;
  
  public StringValueColumn<UIProductSummarySnapshotStatCriteriaData,Long> startQuantity;
  
  public StringValueColumn<UIProductSummarySnapshotStatCriteriaData,Long> inStockQuantity;
  
  public StringValueColumn<UIProductSummarySnapshotStatCriteriaData,Long> outStockQuantity;
  
  public StringValueColumn<UIProductSummarySnapshotStatCriteriaData,Long> stockTakingStockQuantity;
  
  public StringValueColumn<UIProductSummarySnapshotStatCriteriaData,Long> transferStockQuantity;
  
  public StringValueColumn<UIProductSummarySnapshotStatCriteriaData,Long> workitemStockQuantity;
  
  public StringValueColumn<UIProductSummarySnapshotStatCriteriaData,Long> finishQuantity;
  
  public DoubleColumn<UIProductSummarySnapshotStatCriteriaData> startAmount;
  
  public DoubleColumn<UIProductSummarySnapshotStatCriteriaData> inStockAmount;
  
  public DoubleColumn<UIProductSummarySnapshotStatCriteriaData> outStockAmount;
  
  public DoubleColumn<UIProductSummarySnapshotStatCriteriaData> stockTakingStockAmount;
  
  public DoubleColumn<UIProductSummarySnapshotStatCriteriaData> transferStockAmount;
  
  public DoubleColumn<UIProductSummarySnapshotStatCriteriaData> workitemStockAmount;
  
  public DoubleColumn<UIProductSummarySnapshotStatCriteriaData> finishAmount;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private DoubleValueProviderFactory doubleValueProviderFactory;
  
  private UIProductSummarySnapshotStatCriteriaData value = new UIProductSummarySnapshotStatCriteriaData();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();store = defaultObjectSelectorFactory.createAsDefaultColumn("store","仓库",UIProductSummarySnapshotStatCriteriaData.StoreAccessor);
    widgetsRegistory.put("store",store);
    productSpec = defaultObjectSelectorFactory.createAsDefaultColumn("productSpec","材料",UIProductSummarySnapshotStatCriteriaData.ProductSpecAccessor);
    widgetsRegistory.put("productSpec",productSpec);
    startQuantity = defaultObjectSelectorFactory.createAsDefaultColumn("startQuantity","期初库存",UIProductSummarySnapshotStatCriteriaData.StartQuantityAccessor);
    widgetsRegistory.put("startQuantity",startQuantity);
    inStockQuantity = defaultObjectSelectorFactory.createAsDefaultColumn("inStockQuantity","入库数量",UIProductSummarySnapshotStatCriteriaData.InStockQuantityAccessor);
    widgetsRegistory.put("inStockQuantity",inStockQuantity);
    outStockQuantity = defaultObjectSelectorFactory.createAsDefaultColumn("outStockQuantity","出库数量",UIProductSummarySnapshotStatCriteriaData.OutStockQuantityAccessor);
    widgetsRegistory.put("outStockQuantity",outStockQuantity);
    stockTakingStockQuantity = defaultObjectSelectorFactory.createAsDefaultColumn("stockTakingStockQuantity","盘点数量",UIProductSummarySnapshotStatCriteriaData.StockTakingStockQuantityAccessor);
    widgetsRegistory.put("stockTakingStockQuantity",stockTakingStockQuantity);
    transferStockQuantity = defaultObjectSelectorFactory.createAsDefaultColumn("transferStockQuantity","调拨数量	",UIProductSummarySnapshotStatCriteriaData.TransferStockQuantityAccessor);
    widgetsRegistory.put("transferStockQuantity",transferStockQuantity);
    workitemStockQuantity = defaultObjectSelectorFactory.createAsDefaultColumn("workitemStockQuantity","领料数量	",UIProductSummarySnapshotStatCriteriaData.WorkitemStockQuantityAccessor);
    widgetsRegistory.put("workitemStockQuantity",workitemStockQuantity);
    finishQuantity = defaultObjectSelectorFactory.createAsDefaultColumn("finishQuantity","期末库存",UIProductSummarySnapshotStatCriteriaData.FinishQuantityAccessor);
    widgetsRegistory.put("finishQuantity",finishQuantity);
    startAmount = doubleValueProviderFactory.createAsDoubleColumn("startAmount","期初金额",UIProductSummarySnapshotStatCriteriaData.StartAmountAccessor);
    widgetsRegistory.put("startAmount",startAmount);
    inStockAmount = doubleValueProviderFactory.createAsDoubleColumn("inStockAmount","入库金额",UIProductSummarySnapshotStatCriteriaData.InStockAmountAccessor);
    widgetsRegistory.put("inStockAmount",inStockAmount);
    outStockAmount = doubleValueProviderFactory.createAsDoubleColumn("outStockAmount","出库金额",UIProductSummarySnapshotStatCriteriaData.OutStockAmountAccessor);
    widgetsRegistory.put("outStockAmount",outStockAmount);
    stockTakingStockAmount = doubleValueProviderFactory.createAsDoubleColumn("stockTakingStockAmount","盘点金额",UIProductSummarySnapshotStatCriteriaData.StockTakingStockAmountAccessor);
    widgetsRegistory.put("stockTakingStockAmount",stockTakingStockAmount);
    transferStockAmount = doubleValueProviderFactory.createAsDoubleColumn("transferStockAmount","调拨金额",UIProductSummarySnapshotStatCriteriaData.TransferStockAmountAccessor);
    widgetsRegistory.put("transferStockAmount",transferStockAmount);
    workitemStockAmount = doubleValueProviderFactory.createAsDoubleColumn("workitemStockAmount","领料金额",UIProductSummarySnapshotStatCriteriaData.WorkitemStockAmountAccessor);
    widgetsRegistory.put("workitemStockAmount",workitemStockAmount);
    finishAmount = doubleValueProviderFactory.createAsDoubleColumn("finishAmount","期末金额",UIProductSummarySnapshotStatCriteriaData.FinishAmountAccessor);
    widgetsRegistory.put("finishAmount",finishAmount);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIProductSummarySnapshotStatCriteriaData getValueAsNew() {
    UIProductSummarySnapshotStatCriteriaData value = new UIProductSummarySnapshotStatCriteriaData();
    value.setStore(store.getValue());
    value.setProductSpec(productSpec.getValue());
    value.setStartQuantity(startQuantity.getValue());
    value.setInStockQuantity(inStockQuantity.getValue());
    value.setOutStockQuantity(outStockQuantity.getValue());
    value.setStockTakingStockQuantity(stockTakingStockQuantity.getValue());
    value.setTransferStockQuantity(transferStockQuantity.getValue());
    value.setWorkitemStockQuantity(workitemStockQuantity.getValue());
    value.setFinishQuantity(finishQuantity.getValue());
    value.setStartAmount(startAmount.getValue());
    value.setInStockAmount(inStockAmount.getValue());
    value.setOutStockAmount(outStockAmount.getValue());
    value.setStockTakingStockAmount(stockTakingStockAmount.getValue());
    value.setTransferStockAmount(transferStockAmount.getValue());
    value.setWorkitemStockAmount(workitemStockAmount.getValue());
    value.setFinishAmount(finishAmount.getValue());
    return value;
  }
  
  public UIProductSummarySnapshotStatCriteriaData doGetValue() {
    
    value.setStore(store.getValue());
    value.setProductSpec(productSpec.getValue());
    value.setStartQuantity(startQuantity.getValue());
    value.setInStockQuantity(inStockQuantity.getValue());
    value.setOutStockQuantity(outStockQuantity.getValue());
    value.setStockTakingStockQuantity(stockTakingStockQuantity.getValue());
    value.setTransferStockQuantity(transferStockQuantity.getValue());
    value.setWorkitemStockQuantity(workitemStockQuantity.getValue());
    value.setFinishQuantity(finishQuantity.getValue());
    value.setStartAmount(startAmount.getValue());
    value.setInStockAmount(inStockAmount.getValue());
    value.setOutStockAmount(outStockAmount.getValue());
    value.setStockTakingStockAmount(stockTakingStockAmount.getValue());
    value.setTransferStockAmount(transferStockAmount.getValue());
    value.setWorkitemStockAmount(workitemStockAmount.getValue());
    value.setFinishAmount(finishAmount.getValue());
    return value;
  }
  
  public UIProductSummarySnapshotStatCriteriaData getValue(final UIProductSummarySnapshotStatCriteriaData copyValue) {
    
    copyValue.setStore(store.getValue());
    copyValue.setProductSpec(productSpec.getValue());
    copyValue.setStartQuantity(startQuantity.getValue());
    copyValue.setInStockQuantity(inStockQuantity.getValue());
    copyValue.setOutStockQuantity(outStockQuantity.getValue());
    copyValue.setStockTakingStockQuantity(stockTakingStockQuantity.getValue());
    copyValue.setTransferStockQuantity(transferStockQuantity.getValue());
    copyValue.setWorkitemStockQuantity(workitemStockQuantity.getValue());
    copyValue.setFinishQuantity(finishQuantity.getValue());
    copyValue.setStartAmount(startAmount.getValue());
    copyValue.setInStockAmount(inStockAmount.getValue());
    copyValue.setOutStockAmount(outStockAmount.getValue());
    copyValue.setStockTakingStockAmount(stockTakingStockAmount.getValue());
    copyValue.setTransferStockAmount(transferStockAmount.getValue());
    copyValue.setWorkitemStockAmount(workitemStockAmount.getValue());
    copyValue.setFinishAmount(finishAmount.getValue());
    return copyValue;
  }
  
  protected ProductSummarySnapshotStatCriteriaDataListGrid doSetValue(final UIProductSummarySnapshotStatCriteriaData value) {
    this.value = value;
    store.setValue(value.getStore());
    productSpec.setValue(value.getProductSpec());
    startQuantity.setValue(value.getStartQuantity());
    inStockQuantity.setValue(value.getInStockQuantity());
    outStockQuantity.setValue(value.getOutStockQuantity());
    stockTakingStockQuantity.setValue(value.getStockTakingStockQuantity());
    transferStockQuantity.setValue(value.getTransferStockQuantity());
    workitemStockQuantity.setValue(value.getWorkitemStockQuantity());
    finishQuantity.setValue(value.getFinishQuantity());
    startAmount.setValue(value.getStartAmount());
    inStockAmount.setValue(value.getInStockAmount());
    outStockAmount.setValue(value.getOutStockAmount());
    stockTakingStockAmount.setValue(value.getStockTakingStockAmount());
    transferStockAmount.setValue(value.getTransferStockAmount());
    workitemStockAmount.setValue(value.getWorkitemStockAmount());
    finishAmount.setValue(value.getFinishAmount());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)store,(ICanAsWidget)productSpec,(ICanAsWidget)startQuantity,(ICanAsWidget)inStockQuantity,(ICanAsWidget)outStockQuantity,(ICanAsWidget)stockTakingStockQuantity,(ICanAsWidget)transferStockQuantity,(ICanAsWidget)workitemStockQuantity,(ICanAsWidget)finishQuantity,(ICanAsWidget)startAmount,(ICanAsWidget)inStockAmount,(ICanAsWidget)outStockAmount,(ICanAsWidget)stockTakingStockAmount,(ICanAsWidget)transferStockAmount,(ICanAsWidget)workitemStockAmount,(ICanAsWidget)finishAmount
    					);
  }
}
