package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlanStatus;
import com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignment;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;
import edu.fudan.langlab.gxt.client.component.propertyview.GXTPropertyView;
import edu.fudan.langlab.gxt.client.component.propertyview.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.propertyview.factory.DateValueProviderFactory.DatePropertyItem;
import edu.fudan.langlab.gxt.client.component.propertyview.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class WorkItemPlanAssignmentPropertyView extends GXTPropertyView<UIWorkItemPlanAssignment> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public IValueViewer<String> sid;
  
  public IValueViewer<String> name;
  
  public IValueViewer<String> specification;
  
  public IValueViewer<RCOnsitePositionProxy> location;
  
  public IValueViewer<RCDeviceTypeProxy> deviceType;
  
  public IValueViewer<RCDevicePMTypeProxy> pmType;
  
  public IValueViewer<Integer> intervalInDays;
  
  public DatePropertyItem planDate;
  
  public IValueViewer<UIDevicePMPlanStatus> smstatus;
  
  public IValueViewer<String> pmComment;
  
  public IValueViewer<String> comment;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private UIWorkItemPlanAssignment value = new UIWorkItemPlanAssignment();
  
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
    location = defaultObjectSelectorFactory.createAsPropertyItem("location","安装地点");
    widgetsRegistory.put("location",location);
    deviceType = defaultObjectSelectorFactory.createAsPropertyItem("deviceType","设备类型");
    widgetsRegistory.put("deviceType",deviceType);
    pmType = defaultObjectSelectorFactory.createAsPropertyItem("pmType","维保类别");
    widgetsRegistory.put("pmType",pmType);
    intervalInDays = defaultObjectSelectorFactory.createAsPropertyItem("intervalInDays","维保周期(天)");
    widgetsRegistory.put("intervalInDays",intervalInDays);
    planDate = dateValueProviderFactory.createAsDateItem("planDate","PM计划日期");
    widgetsRegistory.put("planDate",planDate);
    smstatus = defaultObjectSelectorFactory.createAsPropertyItem("smstatus","状态");
    widgetsRegistory.put("smstatus",smstatus);
    pmComment = defaultObjectSelectorFactory.createAsPropertyItem("pmComment","维保内容");
    widgetsRegistory.put("pmComment",pmComment);
    comment = defaultObjectSelectorFactory.createAsPropertyItem("comment","维保记录");
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
  
  public UIWorkItemPlanAssignment getValueAsNew() {
    UIWorkItemPlanAssignment value = new UIWorkItemPlanAssignment();
    return value;
  }
  
  public UIWorkItemPlanAssignment doGetValue() {
    
    return value;
  }
  
  public UIWorkItemPlanAssignment getValue(final UIWorkItemPlanAssignment copyValue) {
    
    return copyValue;
  }
  
  protected WorkItemPlanAssignmentPropertyView doSetValue(final UIWorkItemPlanAssignment value) {
    this.value = value;
    sid.setValue(value.getSid());
    name.setValue(value.getName());
    specification.setValue(value.getSpecification());
    location.setValue(value.getLocation());
    deviceType.setValue(value.getDeviceType());
    pmType.setValue(value.getPmType());
    intervalInDays.setValue(value.getIntervalInDays());
    planDate.setValue(value.getPlanDate());
    smstatus.setValue(value.getSmstatus());
    pmComment.setValue(value.getPmComment());
    comment.setValue(value.getComment());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)sid,(ICanAsWidget)name,(ICanAsWidget)specification,(ICanAsWidget)location,(ICanAsWidget)deviceType,(ICanAsWidget)pmType,(ICanAsWidget)intervalInDays,(ICanAsWidget)planDate,(ICanAsWidget)smstatus,(ICanAsWidget)pmComment,(ICanAsWidget)comment
    					);
  }
}
