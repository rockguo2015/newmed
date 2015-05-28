package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.shared.measure.UIWaterMeasureDevice;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class WaterMeasureDeviceListGrid extends GXTGridComponent<UIWaterMeasureDevice> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIWaterMeasureDevice> sid;
  
  public StringColumn<UIWaterMeasureDevice> name;
  
  public StringColumn<UIWaterMeasureDevice> location;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIWaterMeasureDevice value = new UIWaterMeasureDevice();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sid = stringValueProviderFactory.createAsStringColumn("sid","编号",UIWaterMeasureDevice.SidAccessor);
    widgetsRegistory.put("sid",sid);
    name = stringValueProviderFactory.createAsStringColumn("name","名称",UIWaterMeasureDevice.NameAccessor);
    widgetsRegistory.put("name",name);
    location = stringValueProviderFactory.createAsStringColumn("location","安装位置",UIWaterMeasureDevice.LocationAccessor);
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
  
  public UIWaterMeasureDevice getValueAsNew() {
    UIWaterMeasureDevice value = new UIWaterMeasureDevice();
    value.setSid(sid.getValue());
    value.setName(name.getValue());
    value.setLocation(location.getValue());
    return value;
  }
  
  public UIWaterMeasureDevice doGetValue() {
    
    value.setSid(sid.getValue());
    value.setName(name.getValue());
    value.setLocation(location.getValue());
    return value;
  }
  
  public UIWaterMeasureDevice getValue(final UIWaterMeasureDevice copyValue) {
    
    copyValue.setSid(sid.getValue());
    copyValue.setName(name.getValue());
    copyValue.setLocation(location.getValue());
    return copyValue;
  }
  
  protected WaterMeasureDeviceListGrid doSetValue(final UIWaterMeasureDevice value) {
    this.value = value;
    sid.setValue(value.getSid());
    name.setValue(value.getName());
    location.setValue(value.getLocation());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)sid,(ICanAsWidget)name,(ICanAsWidget)location
    					);
  }
}
