package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.listview.GXTListViewComponent;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class DeviceListView extends GXTListViewComponent<UIDevice> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public SafeHtml render(final UIDevice device) {
    return ((com.fudanmed.platform.core.web.client.device.DeviceListViewRenderTemplate)com.google.gwt.core.client.GWT.create(com.fudanmed.platform.core.web.client.device.DeviceListViewRenderTemplate.class)).render(
    	device
    );
    
  }
  
  private UIDevice value = new UIDevice();
  
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
  
  public UIDevice getValueAsNew() {
    UIDevice value = new UIDevice();
    return value;
  }
  
  public UIDevice doGetValue() {
    
    return value;
  }
  
  public UIDevice getValue(final UIDevice copyValue) {
    
    return copyValue;
  }
  
  protected DeviceListView doSetValue(final UIDevice value) {
    this.value = value;
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					);
  }
}
