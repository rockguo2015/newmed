package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecificationSummary;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.listview.GXTListViewComponent;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class ProductSpecificationSummaryListView extends GXTListViewComponent<UIProductSpecificationSummary> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public SafeHtml render(final UIProductSpecificationSummary value) {
    return ((com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationSummaryListViewRenderTemplate)com.google.gwt.core.client.GWT.create(com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationSummaryListViewRenderTemplate.class)).render(
    	value
    );
    
  }
  
  private UIProductSpecificationSummary value = new UIProductSpecificationSummary();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIProductSpecificationSummary getValueAsNew() {
    UIProductSpecificationSummary value = new UIProductSpecificationSummary();
    return value;
  }
  
  public UIProductSpecificationSummary doGetValue() {
    
    return value;
  }
  
  public UIProductSpecificationSummary getValue(final UIProductSpecificationSummary copyValue) {
    
    return copyValue;
  }
  
  protected ProductSpecificationSummaryListView doSetValue(final UIProductSpecificationSummary value) {
    this.value = value;
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					);
  }
}
