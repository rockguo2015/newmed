package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceUsageTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
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

public class DeviceListGrid extends GXTGridComponent<UIDevice> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIDevice> sid;
  
  public StringColumn<UIDevice> name;
  
  public StringColumn<UIDevice> specification;
  
  public StringColumn<UIDevice> locationName;
  
  public StringValueColumn<UIDevice,RCDeviceUsageTypeProxy> usageType;
  
  public StringValueColumn<UIDevice,RCOnsitePositionProxy> location;
  
  public StringColumn<UIDevice> serviceLocationName;
  
  public DateColumn<UIDevice> outStockTime;
  
  public StringValueColumn<UIDevice,RCEmployeeProxy> operator;
  
  public DateColumn<UIDevice> buyTime;
  
  public StringValueColumn<UIDevice,RCSupplierProxy> productor;
  
  public StringValueColumn<UIDevice,RCSupplierProxy> supplier;
  
  public StringValueColumn<UIDevice,RCDeviceTypeProxy> deviceType;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIDevice value = new UIDevice();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sid = stringValueProviderFactory.createAsStringColumn("sid","设备编号",UIDevice.SidAccessor);
    widgetsRegistory.put("sid",sid);
    name = stringValueProviderFactory.createAsStringColumn("name","设备名称",UIDevice.NameAccessor);
    widgetsRegistory.put("name",name);
    specification = stringValueProviderFactory.createAsStringColumn("specification","规格型号",UIDevice.SpecificationAccessor);
    widgetsRegistory.put("specification",specification);
    locationName = stringValueProviderFactory.createAsStringColumn("locationName","安装地点",UIDevice.LocationNameAccessor);
    widgetsRegistory.put("locationName",locationName);
    usageType = defaultObjectSelectorFactory.createAsDefaultColumn("usageType","使用情况",UIDevice.UsageTypeAccessor);
    widgetsRegistory.put("usageType",usageType);
    location = defaultObjectSelectorFactory.createAsDefaultColumn("location","区域位置",UIDevice.LocationAccessor);
    widgetsRegistory.put("location",location);
    serviceLocationName = stringValueProviderFactory.createAsStringColumn("serviceLocationName","服务区域",UIDevice.ServiceLocationNameAccessor);
    widgetsRegistory.put("serviceLocationName",serviceLocationName);
    outStockTime = dateValueProviderFactory.createAsStringColumn("outStockTime","出厂时间",UIDevice.OutStockTimeAccessor);
    widgetsRegistory.put("outStockTime",outStockTime);
    operator = defaultObjectSelectorFactory.createAsDefaultColumn("operator","操作人员",UIDevice.OperatorAccessor);
    widgetsRegistory.put("operator",operator);
    buyTime = dateValueProviderFactory.createAsStringColumn("buyTime","购买时间",UIDevice.BuyTimeAccessor);
    widgetsRegistory.put("buyTime",buyTime);
    productor = defaultObjectSelectorFactory.createAsDefaultColumn("productor","生产厂商",UIDevice.ProductorAccessor);
    widgetsRegistory.put("productor",productor);
    supplier = defaultObjectSelectorFactory.createAsDefaultColumn("supplier","供应厂商",UIDevice.SupplierAccessor);
    widgetsRegistory.put("supplier",supplier);
    deviceType = defaultObjectSelectorFactory.createAsDefaultColumn("deviceType","设备类型",UIDevice.DeviceTypeAccessor);
    widgetsRegistory.put("deviceType",deviceType);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
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
    value.setSid(sid.getValue());
    value.setName(name.getValue());
    value.setSpecification(specification.getValue());
    value.setLocationName(locationName.getValue());
    value.setUsageType(usageType.getValue());
    value.setLocation(location.getValue());
    value.setServiceLocationName(serviceLocationName.getValue());
    value.setOutStockTime(outStockTime.getValue());
    value.setOperator(operator.getValue());
    value.setBuyTime(buyTime.getValue());
    value.setProductor(productor.getValue());
    value.setSupplier(supplier.getValue());
    value.setDeviceType(deviceType.getValue());
    return value;
  }
  
  public UIDevice doGetValue() {
    
    value.setSid(sid.getValue());
    value.setName(name.getValue());
    value.setSpecification(specification.getValue());
    value.setLocationName(locationName.getValue());
    value.setUsageType(usageType.getValue());
    value.setLocation(location.getValue());
    value.setServiceLocationName(serviceLocationName.getValue());
    value.setOutStockTime(outStockTime.getValue());
    value.setOperator(operator.getValue());
    value.setBuyTime(buyTime.getValue());
    value.setProductor(productor.getValue());
    value.setSupplier(supplier.getValue());
    value.setDeviceType(deviceType.getValue());
    return value;
  }
  
  public UIDevice getValue(final UIDevice copyValue) {
    
    copyValue.setSid(sid.getValue());
    copyValue.setName(name.getValue());
    copyValue.setSpecification(specification.getValue());
    copyValue.setLocationName(locationName.getValue());
    copyValue.setUsageType(usageType.getValue());
    copyValue.setLocation(location.getValue());
    copyValue.setServiceLocationName(serviceLocationName.getValue());
    copyValue.setOutStockTime(outStockTime.getValue());
    copyValue.setOperator(operator.getValue());
    copyValue.setBuyTime(buyTime.getValue());
    copyValue.setProductor(productor.getValue());
    copyValue.setSupplier(supplier.getValue());
    copyValue.setDeviceType(deviceType.getValue());
    return copyValue;
  }
  
  protected DeviceListGrid doSetValue(final UIDevice value) {
    this.value = value;
    sid.setValue(value.getSid());
    name.setValue(value.getName());
    specification.setValue(value.getSpecification());
    locationName.setValue(value.getLocationName());
    usageType.setValue(value.getUsageType());
    location.setValue(value.getLocation());
    serviceLocationName.setValue(value.getServiceLocationName());
    outStockTime.setValue(value.getOutStockTime());
    operator.setValue(value.getOperator());
    buyTime.setValue(value.getBuyTime());
    productor.setValue(value.getProductor());
    supplier.setValue(value.getSupplier());
    deviceType.setValue(value.getDeviceType());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)sid,(ICanAsWidget)name,(ICanAsWidget)specification,(ICanAsWidget)locationName,(ICanAsWidget)usageType,(ICanAsWidget)location,(ICanAsWidget)serviceLocationName,(ICanAsWidget)outStockTime,(ICanAsWidget)operator,(ICanAsWidget)buyTime,(ICanAsWidget)productor,(ICanAsWidget)supplier,(ICanAsWidget)deviceType
    					);
  }
  
  public void initializeComponent() {
    this.asWidget();
    this.unForceFit();
  }
}
