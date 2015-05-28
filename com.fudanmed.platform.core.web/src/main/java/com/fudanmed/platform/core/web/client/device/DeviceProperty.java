package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCAcquireTypeProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceIndicatorProxy;
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
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;
import edu.fudan.langlab.gxt.client.component.propertyview.GXTPropertyView;
import edu.fudan.langlab.gxt.client.component.propertyview.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.propertyview.factory.DateValueProviderFactory.DatePropertyItem;
import edu.fudan.langlab.gxt.client.component.propertyview.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.propertyview.factory.DoubleValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.propertyview.factory.DoubleValueProviderFactory.DoublePropertyItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class DeviceProperty extends GXTPropertyView<UIDevice> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public IValueViewer<String> sid;
  
  public IValueViewer<String> name;
  
  public IValueViewer<String> specification;
  
  public IValueViewer<String> locationName;
  
  public IValueViewer<RCSupplierProxy> productor;
  
  public IValueViewer<RCSupplierProxy> supplier;
  
  public IValueViewer<RCOnsitePositionProxy> location;
  
  public IValueViewer<String> serviceLocationName;
  
  public DatePropertyItem outStockTime;
  
  public IValueViewer<RCDeviceTypeProxy> deviceType;
  
  public IValueViewer<RCDeviceIndicatorProxy> deviceIndicator;
  
  public IValueViewer<RCAcquireTypeProxy> acquireType;
  
  public IValueViewer<RCDeviceUsageTypeProxy> usageType;
  
  public DatePropertyItem buyTime;
  
  public DoublePropertyItem buyPrice;
  
  public DoublePropertyItem netPrice;
  
  public IValueViewer<RCEmployeeProxy> owner;
  
  public IValueViewer<String> ownerDepartmentName;
  
  public IValueViewer<Integer> depreciationYears;
  
  public DoublePropertyItem netLeaveRate;
  
  public IValueViewer<String> comment;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private DoubleValueProviderFactory doubleValueProviderFactory;
  
  private UIDevice value = new UIDevice();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sid = defaultObjectSelectorFactory.createAsPropertyItem("sid","设备编号");
    widgetsRegistory.put("sid",sid);
    name = defaultObjectSelectorFactory.createAsPropertyItem("name","设备名称");
    widgetsRegistory.put("name",name);
    specification = defaultObjectSelectorFactory.createAsPropertyItem("specification","规格型号");
    widgetsRegistory.put("specification",specification);
    locationName = defaultObjectSelectorFactory.createAsPropertyItem("locationName","安装地点");
    widgetsRegistory.put("locationName",locationName);
    productor = defaultObjectSelectorFactory.createAsPropertyItem("productor","生产厂商");
    widgetsRegistory.put("productor",productor);
    supplier = defaultObjectSelectorFactory.createAsPropertyItem("supplier","供应厂商");
    widgetsRegistory.put("supplier",supplier);
    location = defaultObjectSelectorFactory.createAsPropertyItem("location","区域位置");
    widgetsRegistory.put("location",location);
    serviceLocationName = defaultObjectSelectorFactory.createAsPropertyItem("serviceLocationName","服务区域");
    widgetsRegistory.put("serviceLocationName",serviceLocationName);
    outStockTime = dateValueProviderFactory.createAsDateItem("outStockTime","出厂时间");
    widgetsRegistory.put("outStockTime",outStockTime);
    deviceType = defaultObjectSelectorFactory.createAsPropertyItem("deviceType","设备类型");
    widgetsRegistory.put("deviceType",deviceType);
    deviceIndicator = defaultObjectSelectorFactory.createAsPropertyItem("deviceIndicator","设备标识");
    widgetsRegistory.put("deviceIndicator",deviceIndicator);
    acquireType = defaultObjectSelectorFactory.createAsPropertyItem("acquireType","增置方式");
    widgetsRegistory.put("acquireType",acquireType);
    usageType = defaultObjectSelectorFactory.createAsPropertyItem("usageType","使用情况");
    widgetsRegistory.put("usageType",usageType);
    buyTime = dateValueProviderFactory.createAsDateItem("buyTime","购买时间");
    widgetsRegistory.put("buyTime",buyTime);
    buyPrice = doubleValueProviderFactory.createAsDoubleItem("buyPrice","资产原值");
    widgetsRegistory.put("buyPrice",buyPrice);
    netPrice = doubleValueProviderFactory.createAsDoubleItem("netPrice","资产净值");
    widgetsRegistory.put("netPrice",netPrice);
    owner = defaultObjectSelectorFactory.createAsPropertyItem("owner","资产负责人");
    widgetsRegistory.put("owner",owner);
    ownerDepartmentName = defaultObjectSelectorFactory.createAsPropertyItem("ownerDepartmentName","使用部门");
    widgetsRegistory.put("ownerDepartmentName",ownerDepartmentName);
    depreciationYears = defaultObjectSelectorFactory.createAsPropertyItem("depreciationYears","折旧年限");
    widgetsRegistory.put("depreciationYears",depreciationYears);
    netLeaveRate = doubleValueProviderFactory.createAsDoubleItem("netLeaveRate","净残率");
    widgetsRegistory.put("netLeaveRate",netLeaveRate);
    comment = defaultObjectSelectorFactory.createAsPropertyItem("comment","备注",Integer.valueOf(3));
    widgetsRegistory.put("comment",comment);
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
    return value;
  }
  
  public UIDevice doGetValue() {
    
    return value;
  }
  
  public UIDevice getValue(final UIDevice copyValue) {
    
    return copyValue;
  }
  
  protected DeviceProperty doSetValue(final UIDevice value) {
    this.value = value;
    sid.setValue(value.getSid());
    name.setValue(value.getName());
    specification.setValue(value.getSpecification());
    locationName.setValue(value.getLocationName());
    productor.setValue(value.getProductor());
    supplier.setValue(value.getSupplier());
    location.setValue(value.getLocation());
    serviceLocationName.setValue(value.getServiceLocationName());
    outStockTime.setValue(value.getOutStockTime());
    deviceType.setValue(value.getDeviceType());
    deviceIndicator.setValue(value.getDeviceIndicator());
    acquireType.setValue(value.getAcquireType());
    usageType.setValue(value.getUsageType());
    buyTime.setValue(value.getBuyTime());
    buyPrice.setValue(value.getBuyPrice());
    netPrice.setValue(value.getNetPrice());
    owner.setValue(value.getOwner());
    ownerDepartmentName.setValue(value.getOwnerDepartmentName());
    depreciationYears.setValue(value.getDepreciationYears());
    netLeaveRate.setValue(value.getNetLeaveRate());
    comment.setValue(value.getComment());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)sid,(ICanAsWidget)name,(ICanAsWidget)specification,(ICanAsWidget)locationName,(ICanAsWidget)productor,(ICanAsWidget)supplier,(ICanAsWidget)location,(ICanAsWidget)serviceLocationName,(ICanAsWidget)outStockTime,(ICanAsWidget)deviceType,(ICanAsWidget)deviceIndicator,(ICanAsWidget)acquireType,(ICanAsWidget)usageType,(ICanAsWidget)buyTime,(ICanAsWidget)buyPrice,(ICanAsWidget)netPrice,(ICanAsWidget)owner,(ICanAsWidget)ownerDepartmentName,(ICanAsWidget)depreciationYears,(ICanAsWidget)netLeaveRate,(ICanAsWidget)comment
    					);
  }
  
  public Integer getCols() {
    return Integer.valueOf(3);
  }
}
