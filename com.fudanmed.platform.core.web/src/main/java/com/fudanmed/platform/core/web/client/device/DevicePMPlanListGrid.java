package com.fudanmed.platform.core.web.client.device;

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
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class DevicePMPlanListGrid extends GXTGridComponent<UIDevicePMPlan> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public DateColumn<UIDevicePMPlan> planDate;
  
  public StringValueColumn<UIDevicePMPlan,UIDevicePMPlanStatus> status;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
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
    status = defaultObjectSelectorFactory.createAsDefaultColumn("status","状态",UIDevicePMPlan.StatusAccessor);
    widgetsRegistory.put("status",status);
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
    return value;
  }
  
  public UIDevicePMPlan doGetValue() {
    
    value.setPlanDate(planDate.getValue());
    value.setStatus(status.getValue());
    return value;
  }
  
  public UIDevicePMPlan getValue(final UIDevicePMPlan copyValue) {
    
    copyValue.setPlanDate(planDate.getValue());
    copyValue.setStatus(status.getValue());
    return copyValue;
  }
  
  protected DevicePMPlanListGrid doSetValue(final UIDevicePMPlan value) {
    this.value = value;
    planDate.setValue(value.getPlanDate());
    status.setValue(value.getStatus());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)planDate,(ICanAsWidget)status
    					);
  }
}
