package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.web.client.warehouse.AllWorkItemProductSpecSummaryContentProvider;
import com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationSummaryListView;
import com.fudanmed.platform.core.web.shared.warehouse.AllWorkItemProductSpecSummaryContentProviderCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecificationSummary;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemProductSpecSummary;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.IntegerValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.IntegerValueProviderFactory.IntegerItem;
import edu.fudan.langlab.gxt.client.component.form.factory.IntegerValueProviderFactory.IntegerReadonlyItem;
import edu.fudan.langlab.gxt.client.component.form.factory.SuggestionComboBoxSelector;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class WorkItemProductSpecSummaryForm extends GXTFormComponent<UIWorkItemProductSpecSummary> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public SuggestionComboBoxSelector<UIProductSpecificationSummary> productSpecSummary;
  
  @Inject
  public AllWorkItemProductSpecSummaryContentProvider productSpecSummaryContentProvider;
  
  public IntegerItem quantity;
  
  public IntegerReadonlyItem sourceQuantity;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  private UIWorkItemProductSpecSummary value = new UIWorkItemProductSpecSummary();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();productSpecSummary = defaultObjectSelectorFactory.createAsSuggestionItem("productSpecSummary","已领材料",this.productSpecificationSummaryListView);
    productSpecSummary.setContentProvider(productSpecSummaryContentProvider);
    widgetsRegistory.put("productSpecSummary",productSpecSummary);
    quantity = integerValueProviderFactory.createAsIntegerItem("quantity","退料数量");
    widgetsRegistory.put("quantity",quantity);
    sourceQuantity = integerValueProviderFactory.createAsReadonlyItem("sourceQuantity","已领数量");
    widgetsRegistory.put("sourceQuantity",sourceQuantity);
    if(productSpecificationSummaryListView instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)productSpecificationSummaryListView);
    						}IPostInitializeAction postAction = new IPostInitializeAction() {
    								
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
    value.setProductSpecSummary(productSpecSummary.getValue());
    value.setQuantity(quantity.getValue());
    value.setSourceQuantity(sourceQuantity.getValue());
    return value;
  }
  
  public UIWorkItemProductSpecSummary doGetValue() {
    
    value.setProductSpecSummary(productSpecSummary.getValue());
    value.setQuantity(quantity.getValue());
    value.setSourceQuantity(sourceQuantity.getValue());
    return value;
  }
  
  public UIWorkItemProductSpecSummary getValue(final UIWorkItemProductSpecSummary copyValue) {
    
    copyValue.setProductSpecSummary(productSpecSummary.getValue());
    copyValue.setQuantity(quantity.getValue());
    copyValue.setSourceQuantity(sourceQuantity.getValue());
    return copyValue;
  }
  
  protected WorkItemProductSpecSummaryForm doSetValue(final UIWorkItemProductSpecSummary value) {
    this.value = value;
    productSpecSummary.setValue(value.getProductSpecSummary());
    quantity.setValue(value.getQuantity());
    sourceQuantity.setValue(value.getSourceQuantity());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)productSpecSummary,(ICanAsWidget)quantity,(ICanAsWidget)sourceQuantity
    					);
  }
  
  public void setWorkItem(final RCWorkItemTaskProxy workItem) {
    AllWorkItemProductSpecSummaryContentProviderCriteria _createCriteria = this.productSpecSummaryContentProvider.createCriteria();
    final Procedure1<AllWorkItemProductSpecSummaryContentProviderCriteria> _function = new Procedure1<AllWorkItemProductSpecSummaryContentProviderCriteria>() {
        public void apply(final AllWorkItemProductSpecSummaryContentProviderCriteria it) {
          it.setWorkItem(workItem);
        }
      };
    ObjectExtensions.<AllWorkItemProductSpecSummaryContentProviderCriteria>operator_doubleArrow(_createCriteria, _function);
  }
  
  @Inject
  private ProductSpecificationSummaryListView productSpecificationSummaryListView;
}
