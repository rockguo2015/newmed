package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.device.RCDevicePMTypeContentProvider;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlanCriteria;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.ComboBoxSelector;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory.DateItem;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.ReadonlyItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.StringReadonlyItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class DevicePMPlanCriteriaForm extends GXTFormComponent<UIDevicePMPlanCriteria> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public DateItem planDateFrom;
  
  public DateItem planDateTo;
  
  public ReadonlyItem<RCDeviceTypeProxy> deviceType;
  
  public StringReadonlyItem category;
  
  public ComboBoxSelector<RCDevicePMTypeProxy> pmType;
  
  @Inject
  public RCDevicePMTypeContentProvider pmTypeContentProvider;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIDevicePMPlanCriteria value = new UIDevicePMPlanCriteria();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();planDateFrom = dateValueProviderFactory.createAsDateItem("planDateFrom","计划日(开始)");
    widgetsRegistory.put("planDateFrom",planDateFrom);
    planDateTo = dateValueProviderFactory.createAsDateItem("planDateTo","计划日(结束)");
    widgetsRegistory.put("planDateTo",planDateTo);
    deviceType = defaultObjectSelectorFactory.createAsReadonlyItem("deviceType","设备类型");
    widgetsRegistory.put("deviceType",deviceType);
    category = stringValueProviderFactory.createAsReadonlyItem("category","category");
    widgetsRegistory.put("category",category);
    pmType = defaultObjectSelectorFactory.createAsComboBoxItem("pmType","维保类型");
    _initializerSupports.add(pmTypeContentProvider);
    pmType.setContentProvider(pmTypeContentProvider);
    widgetsRegistory.put("pmType",pmType);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIDevicePMPlanCriteria getValueAsNew() {
    UIDevicePMPlanCriteria value = new UIDevicePMPlanCriteria();
    value.setPlanDateFrom(planDateFrom.getValue());
    value.setPlanDateTo(planDateTo.getValue());
    value.setDeviceType(deviceType.getValue());
    value.setCategory(category.getValue());
    value.setPmType(pmType.getValue());
    return value;
  }
  
  public UIDevicePMPlanCriteria doGetValue() {
    
    value.setPlanDateFrom(planDateFrom.getValue());
    value.setPlanDateTo(planDateTo.getValue());
    value.setDeviceType(deviceType.getValue());
    value.setCategory(category.getValue());
    value.setPmType(pmType.getValue());
    return value;
  }
  
  public UIDevicePMPlanCriteria getValue(final UIDevicePMPlanCriteria copyValue) {
    
    copyValue.setPlanDateFrom(planDateFrom.getValue());
    copyValue.setPlanDateTo(planDateTo.getValue());
    copyValue.setDeviceType(deviceType.getValue());
    copyValue.setCategory(category.getValue());
    copyValue.setPmType(pmType.getValue());
    return copyValue;
  }
  
  protected DevicePMPlanCriteriaForm doSetValue(final UIDevicePMPlanCriteria value) {
    this.value = value;
    planDateFrom.setValue(value.getPlanDateFrom());
    planDateTo.setValue(value.getPlanDateTo());
    deviceType.setValue(value.getDeviceType());
    category.setValue(value.getCategory());
    pmType.setValue(value.getPmType());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)planDateFrom,(ICanAsWidget)planDateTo,(ICanAsWidget)deviceType,(ICanAsWidget)category,(ICanAsWidget)pmType
    					);
  }
}
