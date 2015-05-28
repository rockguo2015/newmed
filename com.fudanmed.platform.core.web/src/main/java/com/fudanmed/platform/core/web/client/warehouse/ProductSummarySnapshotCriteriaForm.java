package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.client.warehouse.AllProductSpecificationContentProvider;
import com.fudanmed.platform.core.web.client.warehouse.AllWarehouseContentProvider;
import com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationListView;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSummarySnapshotCriteria;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.ComboBoxSelector;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory.DateItem;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.SuggestionComboBoxSelector;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class ProductSummarySnapshotCriteriaForm extends GXTFormComponent<UIProductSummarySnapshotCriteria> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public DateItem dateFrom;
  
  public DateItem dateTo;
  
  public ComboBoxSelector<RCWarehouseProxy> store;
  
  @Inject
  public AllWarehouseContentProvider storeContentProvider;
  
  public SuggestionComboBoxSelector<UIProductSpecification> productSpec;
  
  @Inject
  public AllProductSpecificationContentProvider productSpecContentProvider;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private UIProductSummarySnapshotCriteria value = new UIProductSummarySnapshotCriteria();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();dateFrom = dateValueProviderFactory.createAsDateItem("dateFrom","起始日期");
    widgetsRegistory.put("dateFrom",dateFrom);
    dateTo = dateValueProviderFactory.createAsDateItem("dateTo","结束日期");
    widgetsRegistory.put("dateTo",dateTo);
    store = defaultObjectSelectorFactory.createAsComboBoxItem("store","仓库");
    _initializerSupports.add(storeContentProvider);
    store.setContentProvider(storeContentProvider);
    widgetsRegistory.put("store",store);
    productSpec = defaultObjectSelectorFactory.createAsSuggestionItem("productSpec","材料",this.productSpecificationListView);
    productSpec.setContentProvider(productSpecContentProvider);
    widgetsRegistory.put("productSpec",productSpec);
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
  
  public UIProductSummarySnapshotCriteria getValueAsNew() {
    UIProductSummarySnapshotCriteria value = new UIProductSummarySnapshotCriteria();
    value.setDateFrom(dateFrom.getValue());
    value.setDateTo(dateTo.getValue());
    value.setStore(store.getValue());
    value.setProductSpec(productSpec.getValue());
    return value;
  }
  
  public UIProductSummarySnapshotCriteria doGetValue() {
    
    value.setDateFrom(dateFrom.getValue());
    value.setDateTo(dateTo.getValue());
    value.setStore(store.getValue());
    value.setProductSpec(productSpec.getValue());
    return value;
  }
  
  public UIProductSummarySnapshotCriteria getValue(final UIProductSummarySnapshotCriteria copyValue) {
    
    copyValue.setDateFrom(dateFrom.getValue());
    copyValue.setDateTo(dateTo.getValue());
    copyValue.setStore(store.getValue());
    copyValue.setProductSpec(productSpec.getValue());
    return copyValue;
  }
  
  protected ProductSummarySnapshotCriteriaForm doSetValue(final UIProductSummarySnapshotCriteria value) {
    this.value = value;
    dateFrom.setValue(value.getDateFrom());
    dateTo.setValue(value.getDateTo());
    store.setValue(value.getStore());
    productSpec.setValue(value.getProductSpec());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)dateFrom,(ICanAsWidget)dateTo,(ICanAsWidget)store,(ICanAsWidget)productSpec
    					);
  }
  
  @Inject
  private ProductSpecificationListView productSpecificationListView;
}
