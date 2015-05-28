package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.listview.GXTListViewComponent;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class ProductSpecificationListView extends GXTListViewComponent<UIProductSpecification> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public SafeHtml render(final UIProductSpecification value) {
    return ((com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationListViewRenderTemplate)com.google.gwt.core.client.GWT.create(com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationListViewRenderTemplate.class)).render(
    	value
    );
    
  }
  
  private UIProductSpecification value = new UIProductSpecification();
  
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
  
  public UIProductSpecification getValueAsNew() {
    UIProductSpecification value = new UIProductSpecification();
    return value;
  }
  
  public UIProductSpecification doGetValue() {
    
    return value;
  }
  
  public UIProductSpecification getValue(final UIProductSpecification copyValue) {
    
    return copyValue;
  }
  
  protected ProductSpecificationListView doSetValue(final UIProductSpecification value) {
    this.value = value;
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					);
  }
}
