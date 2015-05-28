package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.shared.organization.UIEmployee;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.listview.GXTListViewComponent;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class EmployeeListView extends GXTListViewComponent<UIEmployee> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public SafeHtml render(final RCEmployeeProxy value) {
    return ((com.fudanmed.platform.core.web.client.organization.EmployeeListViewRenderTemplate)com.google.gwt.core.client.GWT.create(com.fudanmed.platform.core.web.client.organization.EmployeeListViewRenderTemplate.class)).render(
    	value
    );
    
  }
  
  private UIEmployee value = new UIEmployee();
  
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
  
  public UIEmployee getValueAsNew() {
    UIEmployee value = new UIEmployee();
    return value;
  }
  
  public UIEmployee doGetValue() {
    
    return value;
  }
  
  public UIEmployee getValue(final UIEmployee copyValue) {
    
    return copyValue;
  }
  
  protected EmployeeListView doSetValue(final UIEmployee value) {
    this.value = value;
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					);
  }
}
