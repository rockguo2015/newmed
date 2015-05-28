package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.common.proxy.RCFaultEmergencyLevelProxy;
import com.fudanmed.platform.core.common.proxy.RCFaultLevelProxy;
import com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.shared.project.UIEvaluateState;
import com.fudanmed.platform.core.web.shared.project.UIFaultType;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;
import edu.fudan.langlab.gxt.client.component.propertyview.GXTPropertyView;
import edu.fudan.langlab.gxt.client.component.propertyview.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.propertyview.factory.DateValueProviderFactory.DatePropertyItem;
import edu.fudan.langlab.gxt.client.component.propertyview.factory.DateValueProviderFactory.TimePropertyItem;
import edu.fudan.langlab.gxt.client.component.propertyview.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class RepairTaskPropertyView extends GXTPropertyView<UIRepairTask> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public IValueViewer<String> reportSid;
  
  public IValueViewer<Boolean> needAudit;
  
  public IValueViewer<RCFaultReportSourceProxy> faultReportSource;
  
  public DatePropertyItem reportDate;
  
  public TimePropertyItem reportTime;
  
  public IValueViewer<String> reporterName;
  
  public IValueViewer<String> reporterPhone;
  
  public DatePropertyItem reserveDate;
  
  public TimePropertyItem reserveTime;
  
  public DatePropertyItem planFinishDate;
  
  public TimePropertyItem planFinishTime;
  
  public DatePropertyItem finishDate;
  
  public TimePropertyItem finishTime;
  
  public IValueViewer<String> location;
  
  public IValueViewer<String> comment;
  
  public IValueViewer<RCEmployeeProxy> operator;
  
  public IValueViewer<RCOrganizationProxy> reportOrg;
  
  public IValueViewer<RCMaintenanceTeamProxy> activeTeam;
  
  public IValueViewer<RCFaultLevelProxy> faultLevel;
  
  public IValueViewer<UIFaultType> faultType;
  
  public IValueViewer<RCFaultEmergencyLevelProxy> faultEmergencyLevel;
  
  public IValueViewer<UIEvaluateState> evaluateState;
  
  public IValueViewer<Boolean> settlementState;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private UIRepairTask value = new UIRepairTask();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();reportSid = defaultObjectSelectorFactory.createAsPropertyItem("reportSid","报修单号",Integer.valueOf(2));
    widgetsRegistory.put("reportSid",reportSid);
    needAudit = defaultObjectSelectorFactory.createAsPropertyItem("needAudit","需要审批");
    widgetsRegistory.put("needAudit",needAudit);
    faultReportSource = defaultObjectSelectorFactory.createAsPropertyItem("faultReportSource","报修来源");
    widgetsRegistory.put("faultReportSource",faultReportSource);
    reportDate = dateValueProviderFactory.createAsDateItem("reportDate","接报日期");
    widgetsRegistory.put("reportDate",reportDate);
    reportTime = dateValueProviderFactory.createAsTimeItem("reportTime","接报时间");
    widgetsRegistory.put("reportTime",reportTime);
    reporterName = defaultObjectSelectorFactory.createAsPropertyItem("reporterName","报修人");
    widgetsRegistory.put("reporterName",reporterName);
    reporterPhone = defaultObjectSelectorFactory.createAsPropertyItem("reporterPhone","报修人电话");
    widgetsRegistory.put("reporterPhone",reporterPhone);
    reserveDate = dateValueProviderFactory.createAsDateItem("reserveDate","预约日期");
    widgetsRegistory.put("reserveDate",reserveDate);
    reserveTime = dateValueProviderFactory.createAsTimeItem("reserveTime","预约时间");
    widgetsRegistory.put("reserveTime",reserveTime);
    planFinishDate = dateValueProviderFactory.createAsDateItem("planFinishDate","计划完成日期");
    widgetsRegistory.put("planFinishDate",planFinishDate);
    planFinishTime = dateValueProviderFactory.createAsTimeItem("planFinishTime","计划完成时间");
    widgetsRegistory.put("planFinishTime",planFinishTime);
    finishDate = dateValueProviderFactory.createAsDateItem("finishDate","完成日期");
    widgetsRegistory.put("finishDate",finishDate);
    finishTime = dateValueProviderFactory.createAsTimeItem("finishTime","完成时间");
    widgetsRegistory.put("finishTime",finishTime);
    location = defaultObjectSelectorFactory.createAsPropertyItem("location","报修地点",Integer.valueOf(2));
    widgetsRegistory.put("location",location);
    comment = defaultObjectSelectorFactory.createAsPropertyItem("comment","报修内容",Integer.valueOf(2));
    widgetsRegistory.put("comment",comment);
    operator = defaultObjectSelectorFactory.createAsPropertyItem("operator","接报人");
    widgetsRegistory.put("operator",operator);
    reportOrg = defaultObjectSelectorFactory.createAsPropertyItem("reportOrg","报修部门");
    widgetsRegistory.put("reportOrg",reportOrg);
    activeTeam = defaultObjectSelectorFactory.createAsPropertyItem("activeTeam","维修班组");
    widgetsRegistory.put("activeTeam",activeTeam);
    faultLevel = defaultObjectSelectorFactory.createAsPropertyItem("faultLevel","风险等级");
    widgetsRegistory.put("faultLevel",faultLevel);
    faultType = defaultObjectSelectorFactory.createAsPropertyItem("faultType","维修类别");
    widgetsRegistory.put("faultType",faultType);
    faultEmergencyLevel = defaultObjectSelectorFactory.createAsPropertyItem("faultEmergencyLevel","紧急度");
    widgetsRegistory.put("faultEmergencyLevel",faultEmergencyLevel);
    evaluateState = defaultObjectSelectorFactory.createAsPropertyItem("evaluateState","用户评价状态");
    widgetsRegistory.put("evaluateState",evaluateState);
    settlementState = defaultObjectSelectorFactory.createAsPropertyItem("settlementState","结算状态");
    widgetsRegistory.put("settlementState",settlementState);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIRepairTask getValueAsNew() {
    UIRepairTask value = new UIRepairTask();
    return value;
  }
  
  public UIRepairTask doGetValue() {
    
    return value;
  }
  
  public UIRepairTask getValue(final UIRepairTask copyValue) {
    
    return copyValue;
  }
  
  protected RepairTaskPropertyView doSetValue(final UIRepairTask value) {
    this.value = value;
    reportSid.setValue(value.getReportSid());
    needAudit.setValue(value.getNeedAudit());
    faultReportSource.setValue(value.getFaultReportSource());
    reportDate.setValue(value.getReportDate());
    reportTime.setValue(value.getReportTime());
    reporterName.setValue(value.getReporterName());
    reporterPhone.setValue(value.getReporterPhone());
    reserveDate.setValue(value.getReserveDate());
    reserveTime.setValue(value.getReserveTime());
    planFinishDate.setValue(value.getPlanFinishDate());
    planFinishTime.setValue(value.getPlanFinishTime());
    finishDate.setValue(value.getFinishDate());
    finishTime.setValue(value.getFinishTime());
    location.setValue(value.getLocation());
    comment.setValue(value.getComment());
    operator.setValue(value.getOperator());
    reportOrg.setValue(value.getReportOrg());
    activeTeam.setValue(value.getActiveTeam());
    faultLevel.setValue(value.getFaultLevel());
    faultType.setValue(value.getFaultType());
    faultEmergencyLevel.setValue(value.getFaultEmergencyLevel());
    evaluateState.setValue(value.getEvaluateState());
    settlementState.setValue(value.getSettlementState());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)reportSid,(ICanAsWidget)needAudit,(ICanAsWidget)faultReportSource,(ICanAsWidget)reportDate,(ICanAsWidget)reportTime,(ICanAsWidget)reporterName,(ICanAsWidget)reporterPhone,(ICanAsWidget)reserveDate,(ICanAsWidget)reserveTime,(ICanAsWidget)planFinishDate,(ICanAsWidget)planFinishTime,(ICanAsWidget)finishDate,(ICanAsWidget)finishTime,(ICanAsWidget)location,(ICanAsWidget)comment,(ICanAsWidget)operator,(ICanAsWidget)reportOrg,(ICanAsWidget)activeTeam,(ICanAsWidget)faultLevel,(ICanAsWidget)faultType,(ICanAsWidget)faultEmergencyLevel,(ICanAsWidget)evaluateState,(ICanAsWidget)settlementState
    					);
  }
  
  public Integer getCols() {
    return Integer.valueOf(2);
  }
}
