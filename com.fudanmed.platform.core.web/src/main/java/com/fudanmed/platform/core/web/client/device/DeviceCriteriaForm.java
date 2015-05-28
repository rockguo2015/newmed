package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.shared.device.UIDeviceCriteria;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.ReadonlyItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.StringReadonlyItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class DeviceCriteriaForm extends GXTFormComponent<UIDeviceCriteria> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public TextItem sid;
  
  public TextItem name;
  
  public ReadonlyItem<RCDeviceTypeProxy> deviceType;
  
  public StringReadonlyItem category;
  
  public ReadonlyItem<RCOnsitePositionProxy> location;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIDeviceCriteria value = new UIDeviceCriteria();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sid = stringValueProviderFactory.createAsEscapedTextItem("sid","设备编号");
    widgetsRegistory.put("sid",sid);
    name = stringValueProviderFactory.createAsEscapedTextItem("name","名称");
    widgetsRegistory.put("name",name);
    deviceType = defaultObjectSelectorFactory.createAsReadonlyItem("deviceType","deviceType");
    widgetsRegistory.put("deviceType",deviceType);
    category = stringValueProviderFactory.createAsReadonlyItem("category","category");
    widgetsRegistory.put("category",category);
    location = defaultObjectSelectorFactory.createAsReadonlyItem("location","location");
    widgetsRegistory.put("location",location);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIDeviceCriteria getValueAsNew() {
    UIDeviceCriteria value = new UIDeviceCriteria();
    value.setSid(sid.getValue());
    value.setName(name.getValue());
    value.setDeviceType(deviceType.getValue());
    value.setCategory(category.getValue());
    value.setLocation(location.getValue());
    return value;
  }
  
  public UIDeviceCriteria doGetValue() {
    
    value.setSid(sid.getValue());
    value.setName(name.getValue());
    value.setDeviceType(deviceType.getValue());
    value.setCategory(category.getValue());
    value.setLocation(location.getValue());
    return value;
  }
  
  public UIDeviceCriteria getValue(final UIDeviceCriteria copyValue) {
    
    copyValue.setSid(sid.getValue());
    copyValue.setName(name.getValue());
    copyValue.setDeviceType(deviceType.getValue());
    copyValue.setCategory(category.getValue());
    copyValue.setLocation(location.getValue());
    return copyValue;
  }
  
  protected DeviceCriteriaForm doSetValue(final UIDeviceCriteria value) {
    this.value = value;
    sid.setValue(value.getSid());
    name.setValue(value.getName());
    deviceType.setValue(value.getDeviceType());
    category.setValue(value.getCategory());
    location.setValue(value.getLocation());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)sid,(ICanAsWidget)name,(ICanAsWidget)deviceType,(ICanAsWidget)category,(ICanAsWidget)location
    					);
  }
}
