package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.shared.measure.UIMeasureDevice;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class MeasureDeviceListGrid extends GXTGridComponent<UIMeasureDevice> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIMeasureDevice> sid;
  
  public StringColumn<UIMeasureDevice> name;
  
  public StringColumn<UIMeasureDevice> location;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIMeasureDevice value = new UIMeasureDevice();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sid = stringValueProviderFactory.createAsStringColumn("sid","编号",UIMeasureDevice.SidAccessor);
    widgetsRegistory.put("sid",sid);
    name = stringValueProviderFactory.createAsStringColumn("name","名称",UIMeasureDevice.NameAccessor);
    widgetsRegistory.put("name",name);
    location = stringValueProviderFactory.createAsStringColumn("location","安装位置",UIMeasureDevice.LocationAccessor);
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
  
  public UIMeasureDevice getValueAsNew() {
    UIMeasureDevice value = new UIMeasureDevice();
    value.setSid(sid.getValue());
    value.setName(name.getValue());
    value.setLocation(location.getValue());
    return value;
  }
  
  public UIMeasureDevice doGetValue() {
    
    value.setSid(sid.getValue());
    value.setName(name.getValue());
    value.setLocation(location.getValue());
    return value;
  }
  
  public UIMeasureDevice getValue(final UIMeasureDevice copyValue) {
    
    copyValue.setSid(sid.getValue());
    copyValue.setName(name.getValue());
    copyValue.setLocation(location.getValue());
    return copyValue;
  }
  
  protected MeasureDeviceListGrid doSetValue(final UIMeasureDevice value) {
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
  
  public void initializeComponent() {
    this.asWidget();
    this.keepSelection();
  }
}
