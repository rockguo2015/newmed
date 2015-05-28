package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy;
import com.fudanmed.platform.core.device.pm.proxy.RCWorkItemPlanAssignmentProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.client.device.ShowWorkItemPlanAssignmentPropertyPresenterPropertyCommand;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlanStatus;
import com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignment;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.ActionColumnValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.ActionColumnValueProviderFactory.LinkCellColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.ActionColumnValueProviderFactory.LinkCellColumn.GridItemSelectHandler;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory.DateColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectsSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectsSelectorFactory.CollectionListColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.IntegerValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.IntegerValueProviderFactory.IntegerColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class WorkItemPlanAssignmentListGrid extends GXTGridComponent<UIWorkItemPlanAssignment> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIWorkItemPlanAssignment> sid;
  
  public StringColumn<UIWorkItemPlanAssignment> name;
  
  public StringColumn<UIWorkItemPlanAssignment> specification;
  
  public StringValueColumn<UIWorkItemPlanAssignment,RCOnsitePositionProxy> location;
  
  public StringValueColumn<UIWorkItemPlanAssignment,RCDeviceTypeProxy> deviceType;
  
  public StringValueColumn<UIWorkItemPlanAssignment,RCDevicePMTypeProxy> pmType;
  
  public DateColumn<UIWorkItemPlanAssignment> planDate;
  
  public DateColumn<UIWorkItemPlanAssignment> finishDate;
  
  public CollectionListColumn<UIWorkItemPlanAssignment,RCEmployeeProxy> workers;
  
  public IntegerColumn<UIWorkItemPlanAssignment> intervalInDays;
  
  public StringValueColumn<UIWorkItemPlanAssignment,UIDevicePMPlanStatus> smstatus;
  
  public LinkCellColumn<UIWorkItemPlanAssignment> showDetails;
  
  @Inject
  private DefaultObjectsSelectorFactory defaultObjectsSelectorFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private ActionColumnValueProviderFactory actionColumnValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIWorkItemPlanAssignment value = new UIWorkItemPlanAssignment();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sid = stringValueProviderFactory.createAsStringColumn("sid","设备编号",UIWorkItemPlanAssignment.SidAccessor);
    widgetsRegistory.put("sid",sid);
    name = stringValueProviderFactory.createAsStringColumn("name","设备名称",UIWorkItemPlanAssignment.NameAccessor);
    widgetsRegistory.put("name",name);
    specification = stringValueProviderFactory.createAsStringColumn("specification","规格型号",UIWorkItemPlanAssignment.SpecificationAccessor);
    widgetsRegistory.put("specification",specification);
    location = defaultObjectSelectorFactory.createAsDefaultColumn("location","安装地点",UIWorkItemPlanAssignment.LocationAccessor);
    widgetsRegistory.put("location",location);
    deviceType = defaultObjectSelectorFactory.createAsDefaultColumn("deviceType","设备类型",UIWorkItemPlanAssignment.DeviceTypeAccessor);
    widgetsRegistory.put("deviceType",deviceType);
    pmType = defaultObjectSelectorFactory.createAsDefaultColumn("pmType","维保类别",UIWorkItemPlanAssignment.PmTypeAccessor);
    widgetsRegistory.put("pmType",pmType);
    planDate = dateValueProviderFactory.createAsStringColumn("planDate","PM计划日期",UIWorkItemPlanAssignment.PlanDateAccessor);
    widgetsRegistory.put("planDate",planDate);
    finishDate = dateValueProviderFactory.createAsStringColumn("finishDate","完成日期",UIWorkItemPlanAssignment.FinishDateAccessor);
    widgetsRegistory.put("finishDate",finishDate);
    workers = defaultObjectsSelectorFactory.createAsStringColumn("workers","检修人",UIWorkItemPlanAssignment.WorkersAccessor);
    widgetsRegistory.put("workers",workers);
    intervalInDays = integerValueProviderFactory.createAsIntegerColumn("intervalInDays","维保周期(天)",UIWorkItemPlanAssignment.IntervalInDaysAccessor);
    widgetsRegistory.put("intervalInDays",intervalInDays);
    smstatus = defaultObjectSelectorFactory.createAsDefaultColumn("smstatus","状态",UIWorkItemPlanAssignment.SmstatusAccessor);
    widgetsRegistory.put("smstatus",smstatus);
    showDetails = actionColumnValueProviderFactory.createAsLinkColumn("showDetails","查看",UIWorkItemPlanAssignment.ShowDetailsAccessor);
    widgetsRegistory.put("showDetails",showDetails);
    if(showWorkItemPlanAssignmentPropertyPresenterPropertyCommand instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)showWorkItemPlanAssignmentPropertyPresenterPropertyCommand);
    						}IPostInitializeAction postAction = new IPostInitializeAction() {
    								
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
    value.setSid(sid.getValue());
    value.setName(name.getValue());
    value.setSpecification(specification.getValue());
    value.setLocation(location.getValue());
    value.setDeviceType(deviceType.getValue());
    value.setPmType(pmType.getValue());
    value.setPlanDate(planDate.getValue());
    value.setFinishDate(finishDate.getValue());
    value.setWorkers(workers.getValue());
    value.setIntervalInDays(intervalInDays.getValue());
    value.setSmstatus(smstatus.getValue());
    value.setShowDetails(showDetails.getValue());
    return value;
  }
  
  public UIWorkItemPlanAssignment doGetValue() {
    
    value.setSid(sid.getValue());
    value.setName(name.getValue());
    value.setSpecification(specification.getValue());
    value.setLocation(location.getValue());
    value.setDeviceType(deviceType.getValue());
    value.setPmType(pmType.getValue());
    value.setPlanDate(planDate.getValue());
    value.setFinishDate(finishDate.getValue());
    value.setWorkers(workers.getValue());
    value.setIntervalInDays(intervalInDays.getValue());
    value.setSmstatus(smstatus.getValue());
    value.setShowDetails(showDetails.getValue());
    return value;
  }
  
  public UIWorkItemPlanAssignment getValue(final UIWorkItemPlanAssignment copyValue) {
    
    copyValue.setSid(sid.getValue());
    copyValue.setName(name.getValue());
    copyValue.setSpecification(specification.getValue());
    copyValue.setLocation(location.getValue());
    copyValue.setDeviceType(deviceType.getValue());
    copyValue.setPmType(pmType.getValue());
    copyValue.setPlanDate(planDate.getValue());
    copyValue.setFinishDate(finishDate.getValue());
    copyValue.setWorkers(workers.getValue());
    copyValue.setIntervalInDays(intervalInDays.getValue());
    copyValue.setSmstatus(smstatus.getValue());
    copyValue.setShowDetails(showDetails.getValue());
    return copyValue;
  }
  
  protected WorkItemPlanAssignmentListGrid doSetValue(final UIWorkItemPlanAssignment value) {
    this.value = value;
    sid.setValue(value.getSid());
    name.setValue(value.getName());
    specification.setValue(value.getSpecification());
    location.setValue(value.getLocation());
    deviceType.setValue(value.getDeviceType());
    pmType.setValue(value.getPmType());
    planDate.setValue(value.getPlanDate());
    finishDate.setValue(value.getFinishDate());
    workers.setValue(value.getWorkers());
    intervalInDays.setValue(value.getIntervalInDays());
    smstatus.setValue(value.getSmstatus());
    showDetails.setValue(value.getShowDetails());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)sid,(ICanAsWidget)name,(ICanAsWidget)specification,(ICanAsWidget)location,(ICanAsWidget)deviceType,(ICanAsWidget)pmType,(ICanAsWidget)planDate,(ICanAsWidget)finishDate,(ICanAsWidget)workers,(ICanAsWidget)intervalInDays,(ICanAsWidget)smstatus,(ICanAsWidget)showDetails
    					);
  }
  
  public void initializeComponent() {
    final Procedure1<UIWorkItemPlanAssignment> _function = new Procedure1<UIWorkItemPlanAssignment>() {
        public void apply(final UIWorkItemPlanAssignment it) {
          RCWorkItemPlanAssignmentProxy _proxy = it.toProxy();
          WorkItemPlanAssignmentListGrid.this.showWorkItemPlanAssignmentPropertyPresenterPropertyCommand.execute(_proxy);
        }
      };
    this.showDetails.setSelectHandler(this, new GridItemSelectHandler<UIWorkItemPlanAssignment>() {
        public void objectSelected(UIWorkItemPlanAssignment d) {
          _function.apply(d);
        }
    });
  }
  
  @Inject
  private ShowWorkItemPlanAssignmentPropertyPresenterPropertyCommand showWorkItemPlanAssignmentPropertyPresenterPropertyCommand;
}
