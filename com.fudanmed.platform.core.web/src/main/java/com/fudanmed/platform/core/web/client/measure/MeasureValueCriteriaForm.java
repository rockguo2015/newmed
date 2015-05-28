package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.shared.measure.UIMeasureValueCriteria;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory.DateItem;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.ReadonlyItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class MeasureValueCriteriaForm extends GXTFormComponent<UIMeasureValueCriteria> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public ReadonlyItem<RCMeasureDeviceTypeProxy> deviceType;
  
  public ReadonlyItem<RCMeasureDeviceProxy> device;
  
  public DateItem measureDateFrom;
  
  public DateItem measureDateTo;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private UIMeasureValueCriteria value = new UIMeasureValueCriteria();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();deviceType = defaultObjectSelectorFactory.createAsReadonlyItem("deviceType","deviceType");
    widgetsRegistory.put("deviceType",deviceType);
    device = defaultObjectSelectorFactory.createAsReadonlyItem("device","device");
    widgetsRegistory.put("device",device);
    measureDateFrom = dateValueProviderFactory.createAsDateItem("measureDateFrom","开始日期");
    widgetsRegistory.put("measureDateFrom",measureDateFrom);
    measureDateTo = dateValueProviderFactory.createAsDateItem("measureDateTo","结束日期");
    widgetsRegistory.put("measureDateTo",measureDateTo);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIMeasureValueCriteria getValueAsNew() {
    UIMeasureValueCriteria value = new UIMeasureValueCriteria();
    value.setDeviceType(deviceType.getValue());
    value.setDevice(device.getValue());
    value.setMeasureDateFrom(measureDateFrom.getValue());
    value.setMeasureDateTo(measureDateTo.getValue());
    return value;
  }
  
  public UIMeasureValueCriteria doGetValue() {
    
    value.setDeviceType(deviceType.getValue());
    value.setDevice(device.getValue());
    value.setMeasureDateFrom(measureDateFrom.getValue());
    value.setMeasureDateTo(measureDateTo.getValue());
    return value;
  }
  
  public UIMeasureValueCriteria getValue(final UIMeasureValueCriteria copyValue) {
    
    copyValue.setDeviceType(deviceType.getValue());
    copyValue.setDevice(device.getValue());
    copyValue.setMeasureDateFrom(measureDateFrom.getValue());
    copyValue.setMeasureDateTo(measureDateTo.getValue());
    return copyValue;
  }
  
  protected MeasureValueCriteriaForm doSetValue(final UIMeasureValueCriteria value) {
    this.value = value;
    deviceType.setValue(value.getDeviceType());
    device.setValue(value.getDevice());
    measureDateFrom.setValue(value.getMeasureDateFrom());
    measureDateTo.setValue(value.getMeasureDateTo());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)deviceType,(ICanAsWidget)device,(ICanAsWidget)measureDateFrom,(ICanAsWidget)measureDateTo
    					);
  }
}
