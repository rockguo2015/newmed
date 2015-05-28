package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.shared.measure.UIPhasedElectricMeasureDevice;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DoubleValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DoubleValueProviderFactory.DoubleColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class PhasedElectricMeasureDeviceListGrid extends GXTGridComponent<UIPhasedElectricMeasureDevice> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIPhasedElectricMeasureDevice> sid;
  
  public StringColumn<UIPhasedElectricMeasureDevice> name;
  
  public StringColumn<UIPhasedElectricMeasureDevice> location;
  
  public DoubleColumn<UIPhasedElectricMeasureDevice> factor;
  
  @Inject
  private DoubleValueProviderFactory doubleValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIPhasedElectricMeasureDevice value = new UIPhasedElectricMeasureDevice();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sid = stringValueProviderFactory.createAsStringColumn("sid","编号",UIPhasedElectricMeasureDevice.SidAccessor);
    widgetsRegistory.put("sid",sid);
    name = stringValueProviderFactory.createAsStringColumn("name","名称",UIPhasedElectricMeasureDevice.NameAccessor);
    widgetsRegistory.put("name",name);
    location = stringValueProviderFactory.createAsStringColumn("location","安装位置",UIPhasedElectricMeasureDevice.LocationAccessor);
    widgetsRegistory.put("location",location);
    factor = doubleValueProviderFactory.createAsDoubleColumn("factor","变比",UIPhasedElectricMeasureDevice.FactorAccessor);
    widgetsRegistory.put("factor",factor);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIPhasedElectricMeasureDevice getValueAsNew() {
    UIPhasedElectricMeasureDevice value = new UIPhasedElectricMeasureDevice();
    value.setSid(sid.getValue());
    value.setName(name.getValue());
    value.setLocation(location.getValue());
    value.setFactor(factor.getValue());
    return value;
  }
  
  public UIPhasedElectricMeasureDevice doGetValue() {
    
    value.setSid(sid.getValue());
    value.setName(name.getValue());
    value.setLocation(location.getValue());
    value.setFactor(factor.getValue());
    return value;
  }
  
  public UIPhasedElectricMeasureDevice getValue(final UIPhasedElectricMeasureDevice copyValue) {
    
    copyValue.setSid(sid.getValue());
    copyValue.setName(name.getValue());
    copyValue.setLocation(location.getValue());
    copyValue.setFactor(factor.getValue());
    return copyValue;
  }
  
  protected PhasedElectricMeasureDeviceListGrid doSetValue(final UIPhasedElectricMeasureDevice value) {
    this.value = value;
    sid.setValue(value.getSid());
    name.setValue(value.getName());
    location.setValue(value.getLocation());
    factor.setValue(value.getFactor());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)sid,(ICanAsWidget)name,(ICanAsWidget)location,(ICanAsWidget)factor
    					);
  }
}
