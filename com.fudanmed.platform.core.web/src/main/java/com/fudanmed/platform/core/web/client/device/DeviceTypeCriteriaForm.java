package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.UIDeviceTypeCriteria;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.StringReadonlyItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class DeviceTypeCriteriaForm extends GXTFormComponent<UIDeviceTypeCriteria> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public TextItem name;
  
  public StringReadonlyItem category;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIDeviceTypeCriteria value = new UIDeviceTypeCriteria();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();name = stringValueProviderFactory.createAsTextItem("name","名称");
    widgetsRegistory.put("name",name);
    category = stringValueProviderFactory.createAsReadonlyItem("category","category");
    widgetsRegistory.put("category",category);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIDeviceTypeCriteria getValueAsNew() {
    UIDeviceTypeCriteria value = new UIDeviceTypeCriteria();
    value.setName(name.getValue());
    value.setCategory(category.getValue());
    return value;
  }
  
  public UIDeviceTypeCriteria doGetValue() {
    
    value.setName(name.getValue());
    value.setCategory(category.getValue());
    return value;
  }
  
  public UIDeviceTypeCriteria getValue(final UIDeviceTypeCriteria copyValue) {
    
    copyValue.setName(name.getValue());
    copyValue.setCategory(category.getValue());
    return copyValue;
  }
  
  protected DeviceTypeCriteriaForm doSetValue(final UIDeviceTypeCriteria value) {
    this.value = value;
    name.setValue(value.getName());
    category.setValue(value.getCategory());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)name,(ICanAsWidget)category
    					);
  }
}
