package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.UICustomizableTypeCriteria;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class CustomizableTypeCriteriaForm extends GXTFormComponent<UICustomizableTypeCriteria> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  private UICustomizableTypeCriteria value = new UICustomizableTypeCriteria();
  
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
  
  public UICustomizableTypeCriteria getValueAsNew() {
    UICustomizableTypeCriteria value = new UICustomizableTypeCriteria();
    return value;
  }
  
  public UICustomizableTypeCriteria doGetValue() {
    
    return value;
  }
  
  public UICustomizableTypeCriteria getValue(final UICustomizableTypeCriteria copyValue) {
    
    return copyValue;
  }
  
  protected CustomizableTypeCriteriaForm doSetValue(final UICustomizableTypeCriteria value) {
    this.value = value;
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					);
  }
}
