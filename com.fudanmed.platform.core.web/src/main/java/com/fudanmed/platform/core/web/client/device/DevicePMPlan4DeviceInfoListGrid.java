package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy;
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

public class DevicePMPlan4DeviceInfoListGrid extends GXTGridComponent<UIDevicePMPlan> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringValueColumn<UIDevicePMPlan,RCDevicePMTypeProxy> pmType;
  
  public DateColumn<UIDevicePMPlan> planDate;
  
  public StringValueColumn<UIDevicePMPlan,UIDevicePMPlanStatus> status;
  
  public StringColumn<UIDevicePMPlan> description;
  
  public StringColumn<UIDevicePMPlan> comment;
  
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
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();pmType = defaultObjectSelectorFactory.createAsDefaultColumn("pmType","维保类型",UIDevicePMPlan.PmTypeAccessor);
    widgetsRegistory.put("pmType",pmType);
    planDate = dateValueProviderFactory.createAsStringColumn("planDate","PM计划日期",UIDevicePMPlan.PlanDateAccessor);
    widgetsRegistory.put("planDate",planDate);
    status = defaultObjectSelectorFactory.createAsDefaultColumn("status","状态",UIDevicePMPlan.StatusAccessor);
    widgetsRegistory.put("status",status);
    description = stringValueProviderFactory.createAsStringColumn("description","维保内容",UIDevicePMPlan.DescriptionAccessor);
    widgetsRegistory.put("description",description);
    comment = stringValueProviderFactory.createAsStringColumn("comment","维保记录",UIDevicePMPlan.CommentAccessor);
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
  
  public UIDevicePMPlan getValueAsNew() {
    UIDevicePMPlan value = new UIDevicePMPlan();
    value.setPmType(pmType.getValue());
    value.setPlanDate(planDate.getValue());
    value.setStatus(status.getValue());
    value.setDescription(description.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UIDevicePMPlan doGetValue() {
    
    value.setPmType(pmType.getValue());
    value.setPlanDate(planDate.getValue());
    value.setStatus(status.getValue());
    value.setDescription(description.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UIDevicePMPlan getValue(final UIDevicePMPlan copyValue) {
    
    copyValue.setPmType(pmType.getValue());
    copyValue.setPlanDate(planDate.getValue());
    copyValue.setStatus(status.getValue());
    copyValue.setDescription(description.getValue());
    copyValue.setComment(comment.getValue());
    return copyValue;
  }
  
  protected DevicePMPlan4DeviceInfoListGrid doSetValue(final UIDevicePMPlan value) {
    this.value = value;
    pmType.setValue(value.getPmType());
    planDate.setValue(value.getPlanDate());
    status.setValue(value.getStatus());
    description.setValue(value.getDescription());
    comment.setValue(value.getComment());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)pmType,(ICanAsWidget)planDate,(ICanAsWidget)status,(ICanAsWidget)description,(ICanAsWidget)comment
    					);
  }
}
