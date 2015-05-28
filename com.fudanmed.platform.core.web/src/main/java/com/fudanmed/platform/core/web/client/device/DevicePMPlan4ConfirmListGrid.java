package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlan;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlanStatus;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory.DateColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class DevicePMPlan4ConfirmListGrid extends GXTGridComponent<UIDevicePMPlan> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public DateColumn<UIDevicePMPlan> planDate;
  
  public StringValueColumn<UIDevicePMPlan,UIDevicePMPlanStatus> status;
  
  public StringColumn<UIDevicePMPlan> sid;
  
  public StringColumn<UIDevicePMPlan> name;
  
  public StringValueColumn<UIDevicePMPlan,RCDeviceTypeProxy> deviceType;
  
  public StringColumn<UIDevicePMPlan> specification;
  
  public StringValueColumn<UIDevicePMPlan,RCDevicePMTypeProxy> pmType;
  
  public StringValueColumn<UIDevicePMPlan,RCOnsitePositionProxy> location;
  
  public StringColumn<UIDevicePMPlan> description;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  private UIDevicePMPlan value = new UIDevicePMPlan();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();planDate = dateValueProviderFactory.createAsStringColumn("planDate","PM计划日期",UIDevicePMPlan.PlanDateAccessor);
    widgetsRegistory.put("planDate",planDate);
    status = defaultObjectSelectorFactory.createAsDefaultColumn("status","状态",UIDevicePMPlan.StatusAccessor,Integer.valueOf(80));
    widgetsRegistory.put("status",status);
    sid = stringValueProviderFactory.createAsStringColumn("sid","设备编号",UIDevicePMPlan.SidAccessor);
    widgetsRegistory.put("sid",sid);
    name = stringValueProviderFactory.createAsStringColumn("name","设备名称",UIDevicePMPlan.NameAccessor);
    widgetsRegistory.put("name",name);
    deviceType = defaultObjectSelectorFactory.createAsDefaultColumn("deviceType","设备类型",UIDevicePMPlan.DeviceTypeAccessor);
    widgetsRegistory.put("deviceType",deviceType);
    specification = stringValueProviderFactory.createAsStringColumn("specification","规格型号",UIDevicePMPlan.SpecificationAccessor);
    widgetsRegistory.put("specification",specification);
    pmType = defaultObjectSelectorFactory.createAsDefaultColumn("pmType","维保类型",UIDevicePMPlan.PmTypeAccessor);
    widgetsRegistory.put("pmType",pmType);
    location = defaultObjectSelectorFactory.createAsDefaultColumn("location","安装地点",UIDevicePMPlan.LocationAccessor,Integer.valueOf(200));
    widgetsRegistory.put("location",location);
    description = stringValueProviderFactory.createAsStringColumn("description","维保内容",UIDevicePMPlan.DescriptionAccessor,Integer.valueOf(200));
    widgetsRegistory.put("description",description);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIDevicePMPlan getValueAsNew() {
    UIDevicePMPlan value = new UIDevicePMPlan();
    value.setPlanDate(planDate.getValue());
    value.setStatus(status.getValue());
    value.setSid(sid.getValue());
    value.setName(name.getValue());
    value.setDeviceType(deviceType.getValue());
    value.setSpecification(specification.getValue());
    value.setPmType(pmType.getValue());
    value.setLocation(location.getValue());
    value.setDescription(description.getValue());
    return value;
  }
  
  public UIDevicePMPlan doGetValue() {
    
    value.setPlanDate(planDate.getValue());
    value.setStatus(status.getValue());
    value.setSid(sid.getValue());
    value.setName(name.getValue());
    value.setDeviceType(deviceType.getValue());
    value.setSpecification(specification.getValue());
    value.setPmType(pmType.getValue());
    value.setLocation(location.getValue());
    value.setDescription(description.getValue());
    return value;
  }
  
  public UIDevicePMPlan getValue(final UIDevicePMPlan copyValue) {
    
    copyValue.setPlanDate(planDate.getValue());
    copyValue.setStatus(status.getValue());
    copyValue.setSid(sid.getValue());
    copyValue.setName(name.getValue());
    copyValue.setDeviceType(deviceType.getValue());
    copyValue.setSpecification(specification.getValue());
    copyValue.setPmType(pmType.getValue());
    copyValue.setLocation(location.getValue());
    copyValue.setDescription(description.getValue());
    return copyValue;
  }
  
  protected DevicePMPlan4ConfirmListGrid doSetValue(final UIDevicePMPlan value) {
    this.value = value;
    planDate.setValue(value.getPlanDate());
    status.setValue(value.getStatus());
    sid.setValue(value.getSid());
    name.setValue(value.getName());
    deviceType.setValue(value.getDeviceType());
    specification.setValue(value.getSpecification());
    pmType.setValue(value.getPmType());
    location.setValue(value.getLocation());
    description.setValue(value.getDescription());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)planDate,(ICanAsWidget)status,(ICanAsWidget)sid,(ICanAsWidget)name,(ICanAsWidget)deviceType,(ICanAsWidget)specification,(ICanAsWidget)pmType,(ICanAsWidget)location,(ICanAsWidget)description
    					);
  }
  
  public void initializeComponent() {
    this.asWidget();
    this.unForceFit();
  }
}
