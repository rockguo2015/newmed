package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductTypeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.client.warehouse.AllProductSpecificationContentProvider;
import com.fudanmed.platform.core.web.client.warehouse.AllProductTypeContentProvider;
import com.fudanmed.platform.core.web.client.warehouse.AllWarehouseByManagerContentProvider;
import com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationListView;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummaryCriteria;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.ComboBoxSelector;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.SuggestionComboBoxSelector;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ProductWarehouseStorageSummaryCriteriaForm extends GXTFormComponent<UIProductWarehouseStorageSummaryCriteria> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public ComboBoxSelector<RCWarehouseProxy> store;
  
  @Inject
  public AllWarehouseByManagerContentProvider storeContentProvider;
  
  public SuggestionComboBoxSelector<RCProductTypeProxy> productType;
  
  @Inject
  public AllProductTypeContentProvider productTypeContentProvider;
  
  public SuggestionComboBoxSelector<UIProductSpecification> productSpec;
  
  @Inject
  public AllProductSpecificationContentProvider productSpecContentProvider;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private UIProductWarehouseStorageSummaryCriteria value = new UIProductWarehouseStorageSummaryCriteria();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();store = defaultObjectSelectorFactory.createAsComboBoxItem("store","仓库");
    store.setContentProvider(storeContentProvider);
    widgetsRegistory.put("store",store);
    productType = defaultObjectSelectorFactory.createAsSuggestionItem("productType","物品类别");
    productType.setContentProvider(productTypeContentProvider);
    widgetsRegistory.put("productType",productType);
    productSpec = defaultObjectSelectorFactory.createAsSuggestionItem("productSpec","物品",this.productSpecificationListView);
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
  
  public UIProductWarehouseStorageSummaryCriteria getValueAsNew() {
    UIProductWarehouseStorageSummaryCriteria value = new UIProductWarehouseStorageSummaryCriteria();
    value.setStore(store.getValue());
    value.setProductType(productType.getValue());
    value.setProductSpec(productSpec.getValue());
    return value;
  }
  
  public UIProductWarehouseStorageSummaryCriteria doGetValue() {
    
    value.setStore(store.getValue());
    value.setProductType(productType.getValue());
    value.setProductSpec(productSpec.getValue());
    return value;
  }
  
  public UIProductWarehouseStorageSummaryCriteria getValue(final UIProductWarehouseStorageSummaryCriteria copyValue) {
    
    copyValue.setStore(store.getValue());
    copyValue.setProductType(productType.getValue());
    copyValue.setProductSpec(productSpec.getValue());
    return copyValue;
  }
  
  protected ProductWarehouseStorageSummaryCriteriaForm doSetValue(final UIProductWarehouseStorageSummaryCriteria value) {
    this.value = value;
    store.setValue(value.getStore());
    productType.setValue(value.getProductType());
    productSpec.setValue(value.getProductSpec());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)store,(ICanAsWidget)productType,(ICanAsWidget)productSpec
    					);
  }
  
  public void setSourceWarehouseContext(final RCEmployeeProxy employee, final Procedure1<? super Void> notifier) {
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          notifier.apply(null);
        }
      };
    this.storeContentProvider.load(employee, _function);
  }
  
  @Inject
  private ProductSpecificationListView productSpecificationListView;
}
