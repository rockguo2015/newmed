package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMSpecification;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.shared.extensions.StringExtensions;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory.DateColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.IntegerValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.IntegerValueProviderFactory.IntegerColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

public class DevicePMSpecificationListGrid extends GXTGridComponent<UIDevicePMSpecification> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIDevicePMSpecification> sid;
  
  public StringColumn<UIDevicePMSpecification> name;
  
  public StringColumn<UIDevicePMSpecification> specification;
  
  public StringValueColumn<UIDevicePMSpecification,RCOnsitePositionProxy> location;
  
  public StringValueColumn<UIDevicePMSpecification,RCSupplierProxy> productor;
  
  public StringValueColumn<UIDevicePMSpecification,RCSupplierProxy> supplier;
  
  public StringValueColumn<UIDevicePMSpecification,RCDeviceTypeProxy> deviceType;
  
  public StringValueColumn<UIDevicePMSpecification,RCDevicePMTypeProxy> pmType;
  
  public IntegerColumn<UIDevicePMSpecification> intervalInDays;
  
  public StringColumn<UIDevicePMSpecification> description;
  
  public DateColumn<UIDevicePMSpecification> lastPMPlanDate;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIDevicePMSpecification value = new UIDevicePMSpecification();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sid = stringValueProviderFactory.createAsStringColumn("sid","设备编号",UIDevicePMSpecification.SidAccessor);
    widgetsRegistory.put("sid",sid);
    name = stringValueProviderFactory.createAsStringColumn("name","设备名称",UIDevicePMSpecification.NameAccessor);
    widgetsRegistory.put("name",name);
    specification = stringValueProviderFactory.createAsStringColumn("specification","规格型号",UIDevicePMSpecification.SpecificationAccessor);
    widgetsRegistory.put("specification",specification);
    location = defaultObjectSelectorFactory.createAsDefaultColumn("location","安装地点",UIDevicePMSpecification.LocationAccessor);
    widgetsRegistory.put("location",location);
    productor = defaultObjectSelectorFactory.createAsDefaultColumn("productor","生产厂商",UIDevicePMSpecification.ProductorAccessor);
    widgetsRegistory.put("productor",productor);
    supplier = defaultObjectSelectorFactory.createAsDefaultColumn("supplier","供应厂商",UIDevicePMSpecification.SupplierAccessor);
    widgetsRegistory.put("supplier",supplier);
    deviceType = defaultObjectSelectorFactory.createAsDefaultColumn("deviceType","设备类型",UIDevicePMSpecification.DeviceTypeAccessor);
    widgetsRegistory.put("deviceType",deviceType);
    pmType = defaultObjectSelectorFactory.createAsDefaultColumn("pmType","维保类别",UIDevicePMSpecification.PmTypeAccessor);
    widgetsRegistory.put("pmType",pmType);
    intervalInDays = integerValueProviderFactory.createAsIntegerColumn("intervalInDays","维保周期(天)",UIDevicePMSpecification.IntervalInDaysAccessor);
    widgetsRegistory.put("intervalInDays",intervalInDays);
    description = stringValueProviderFactory.createAsStringColumn("description","维保内容",UIDevicePMSpecification.DescriptionAccessor,Integer.valueOf(200));
    widgetsRegistory.put("description",description);
    lastPMPlanDate = dateValueProviderFactory.createAsStringColumn("lastPMPlanDate","最后PM计划日期",UIDevicePMSpecification.LastPMPlanDateAccessor);
    widgetsRegistory.put("lastPMPlanDate",lastPMPlanDate);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIDevicePMSpecification getValueAsNew() {
    UIDevicePMSpecification value = new UIDevicePMSpecification();
    value.setSid(sid.getValue());
    value.setName(name.getValue());
    value.setSpecification(specification.getValue());
    value.setLocation(location.getValue());
    value.setProductor(productor.getValue());
    value.setSupplier(supplier.getValue());
    value.setDeviceType(deviceType.getValue());
    value.setPmType(pmType.getValue());
    value.setIntervalInDays(intervalInDays.getValue());
    value.setDescription(description.getValue());
    value.setLastPMPlanDate(lastPMPlanDate.getValue());
    return value;
  }
  
  public UIDevicePMSpecification doGetValue() {
    
    value.setSid(sid.getValue());
    value.setName(name.getValue());
    value.setSpecification(specification.getValue());
    value.setLocation(location.getValue());
    value.setProductor(productor.getValue());
    value.setSupplier(supplier.getValue());
    value.setDeviceType(deviceType.getValue());
    value.setPmType(pmType.getValue());
    value.setIntervalInDays(intervalInDays.getValue());
    value.setDescription(description.getValue());
    value.setLastPMPlanDate(lastPMPlanDate.getValue());
    return value;
  }
  
  public UIDevicePMSpecification getValue(final UIDevicePMSpecification copyValue) {
    
    copyValue.setSid(sid.getValue());
    copyValue.setName(name.getValue());
    copyValue.setSpecification(specification.getValue());
    copyValue.setLocation(location.getValue());
    copyValue.setProductor(productor.getValue());
    copyValue.setSupplier(supplier.getValue());
    copyValue.setDeviceType(deviceType.getValue());
    copyValue.setPmType(pmType.getValue());
    copyValue.setIntervalInDays(intervalInDays.getValue());
    copyValue.setDescription(description.getValue());
    copyValue.setLastPMPlanDate(lastPMPlanDate.getValue());
    return copyValue;
  }
  
  protected DevicePMSpecificationListGrid doSetValue(final UIDevicePMSpecification value) {
    this.value = value;
    sid.setValue(value.getSid());
    name.setValue(value.getName());
    specification.setValue(value.getSpecification());
    location.setValue(value.getLocation());
    productor.setValue(value.getProductor());
    supplier.setValue(value.getSupplier());
    deviceType.setValue(value.getDeviceType());
    pmType.setValue(value.getPmType());
    intervalInDays.setValue(value.getIntervalInDays());
    description.setValue(value.getDescription());
    lastPMPlanDate.setValue(value.getLastPMPlanDate());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)sid,(ICanAsWidget)name,(ICanAsWidget)specification,(ICanAsWidget)location,(ICanAsWidget)productor,(ICanAsWidget)supplier,(ICanAsWidget)deviceType,(ICanAsWidget)pmType,(ICanAsWidget)intervalInDays,(ICanAsWidget)description,(ICanAsWidget)lastPMPlanDate
    					);
  }
  
  public void initializeComponent() {
    final Procedure2<UIDevicePMSpecification,SafeHtmlBuilder> _function = new Procedure2<UIDevicePMSpecification,SafeHtmlBuilder>() {
        public void apply(final UIDevicePMSpecification value, final SafeHtmlBuilder sb) {
          String _description = value.getDescription();
          String _nullsafe = StringExtensions.nullsafe(_description);
          sb.appendEscapedLines(_nullsafe);
        }
      };
    this.withExpander(_function);
  }
}
