package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.common.proxy.RCFaultEmergencyLevelProxy;
import com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatisticData;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatus;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.grid.AggregationRowConfig;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.common.shared.Objects;
import edu.fudan.langlab.domain.organization.proxy.PartyProxy;
import edu.fudan.langlab.gxt.client.component.grid.AggregationExtensions;
import edu.fudan.langlab.gxt.client.component.grid.ColumnRenderPair;
import edu.fudan.langlab.gxt.client.component.grid.GXTGrid4LargeDataComponent;
import edu.fudan.langlab.gxt.client.component.grid.IGroupRender;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory.DateColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory.DateTimeColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectsSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectsSelectorFactory.CollectionListColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

public class RepairTaskStatisticDataListGrid extends GXTGrid4LargeDataComponent<UIRepairTaskStatisticData> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringValueColumn<UIRepairTaskStatisticData,RCOrganizationProxy> reportOrg;
  
  public DateTimeColumn<UIRepairTaskStatisticData> reportTime;
  
  public DateTimeColumn<UIRepairTaskStatisticData> dispatchTime;
  
  public DateTimeColumn<UIRepairTaskStatisticData> finishTime;
  
  public StringColumn<UIRepairTaskStatisticData> location;
  
  public StringValueColumn<UIRepairTaskStatisticData,PartyProxy> operator;
  
  public StringColumn<UIRepairTaskStatisticData> reportSid;
  
  public StringValueColumn<UIRepairTaskStatisticData,UIRepairTaskStatus> status;
  
  public StringValueColumn<UIRepairTaskStatisticData,RCFaultEmergencyLevelProxy> faultEmergencyLevel;
  
  public CollectionListColumn<UIRepairTaskStatisticData,RCMaintenanceTeamProxy> teams;
  
  public CollectionListColumn<UIRepairTaskStatisticData,RCEmployeeProxy> workers;
  
  public StringValueColumn<UIRepairTaskStatisticData,RCMaintenamceTypeProxy> mType;
  
  public StringValueColumn<UIRepairTaskStatisticData,RCFaultTypeProxy> faultType;
  
  public StringColumn<UIRepairTaskStatisticData> comment;
  
  public StringColumn<UIRepairTaskStatisticData> reporterName;
  
  public StringValueColumn<UIRepairTaskStatisticData,RCFaultReportSourceProxy> faultReportSource;
  
  public StringColumn<UIRepairTaskStatisticData> hasSettlement;
  
  public StringColumn<UIRepairTaskStatisticData> evaluateComment;
  
  public StringValueColumn<UIRepairTaskStatisticData,RCEmployeeProxy> evaluater;
  
  public DateColumn<UIRepairTaskStatisticData> evaluateTime;
  
  @Inject
  private DefaultObjectsSelectorFactory defaultObjectsSelectorFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIRepairTaskStatisticData value = new UIRepairTaskStatisticData();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();reportOrg = defaultObjectSelectorFactory.createAsDefaultColumn("reportOrg","报修部门",UIRepairTaskStatisticData.ReportOrgAccessor);
    widgetsRegistory.put("reportOrg",reportOrg);
    reportTime = dateValueProviderFactory.createAsDateTimeColumn("reportTime","报修时间",UIRepairTaskStatisticData.ReportTimeAccessor);
    widgetsRegistory.put("reportTime",reportTime);
    dispatchTime = dateValueProviderFactory.createAsDateTimeColumn("dispatchTime","派工时间",UIRepairTaskStatisticData.DispatchTimeAccessor);
    widgetsRegistory.put("dispatchTime",dispatchTime);
    finishTime = dateValueProviderFactory.createAsDateTimeColumn("finishTime","完成时间",UIRepairTaskStatisticData.FinishTimeAccessor);
    widgetsRegistory.put("finishTime",finishTime);
    location = stringValueProviderFactory.createAsStringColumn("location","报修地址",UIRepairTaskStatisticData.LocationAccessor);
    widgetsRegistory.put("location",location);
    operator = defaultObjectSelectorFactory.createAsDefaultColumn("operator","接报人",UIRepairTaskStatisticData.OperatorAccessor);
    widgetsRegistory.put("operator",operator);
    reportSid = stringValueProviderFactory.createAsStringColumn("reportSid","报修单号",UIRepairTaskStatisticData.ReportSidAccessor);
    widgetsRegistory.put("reportSid",reportSid);
    status = defaultObjectSelectorFactory.createAsDefaultColumn("status","维修状态",UIRepairTaskStatisticData.StatusAccessor);
    widgetsRegistory.put("status",status);
    faultEmergencyLevel = defaultObjectSelectorFactory.createAsDefaultColumn("faultEmergencyLevel","紧急度",UIRepairTaskStatisticData.FaultEmergencyLevelAccessor);
    widgetsRegistory.put("faultEmergencyLevel",faultEmergencyLevel);
    teams = defaultObjectsSelectorFactory.createAsStringColumn("teams","维修班组",UIRepairTaskStatisticData.TeamsAccessor,Integer.valueOf(160));
    widgetsRegistory.put("teams",teams);
    workers = defaultObjectsSelectorFactory.createAsStringColumn("workers","维修人员",UIRepairTaskStatisticData.WorkersAccessor);
    widgetsRegistory.put("workers",workers);
    mType = defaultObjectSelectorFactory.createAsDefaultColumn("mType","维修大类",UIRepairTaskStatisticData.MTypeAccessor);
    widgetsRegistory.put("mType",mType);
    faultType = defaultObjectSelectorFactory.createAsDefaultColumn("faultType","维修类别",UIRepairTaskStatisticData.FaultTypeAccessor);
    widgetsRegistory.put("faultType",faultType);
    comment = stringValueProviderFactory.createAsStringColumn("comment","报修内容",UIRepairTaskStatisticData.CommentAccessor);
    widgetsRegistory.put("comment",comment);
    reporterName = stringValueProviderFactory.createAsStringColumn("reporterName","报修人",UIRepairTaskStatisticData.ReporterNameAccessor);
    widgetsRegistory.put("reporterName",reporterName);
    faultReportSource = defaultObjectSelectorFactory.createAsDefaultColumn("faultReportSource","报修来源",UIRepairTaskStatisticData.FaultReportSourceAccessor);
    widgetsRegistory.put("faultReportSource",faultReportSource);
    hasSettlement = stringValueProviderFactory.createAsStringColumn("hasSettlement","材料结算状态",UIRepairTaskStatisticData.HasSettlementAccessor);
    widgetsRegistory.put("hasSettlement",hasSettlement);
    evaluateComment = stringValueProviderFactory.createAsStringColumn("evaluateComment","用户评价",UIRepairTaskStatisticData.EvaluateCommentAccessor);
    widgetsRegistory.put("evaluateComment",evaluateComment);
    evaluater = defaultObjectSelectorFactory.createAsDefaultColumn("evaluater","评价人",UIRepairTaskStatisticData.EvaluaterAccessor);
    widgetsRegistory.put("evaluater",evaluater);
    evaluateTime = dateValueProviderFactory.createAsStringColumn("evaluateTime","评价时间",UIRepairTaskStatisticData.EvaluateTimeAccessor);
    widgetsRegistory.put("evaluateTime",evaluateTime);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIRepairTaskStatisticData getValueAsNew() {
    UIRepairTaskStatisticData value = new UIRepairTaskStatisticData();
    value.setReportOrg(reportOrg.getValue());
    value.setReportTime(reportTime.getValue());
    value.setDispatchTime(dispatchTime.getValue());
    value.setFinishTime(finishTime.getValue());
    value.setLocation(location.getValue());
    value.setOperator(operator.getValue());
    value.setReportSid(reportSid.getValue());
    value.setStatus(status.getValue());
    value.setFaultEmergencyLevel(faultEmergencyLevel.getValue());
    value.setTeams(teams.getValue());
    value.setWorkers(workers.getValue());
    value.setMType(mType.getValue());
    value.setFaultType(faultType.getValue());
    value.setComment(comment.getValue());
    value.setReporterName(reporterName.getValue());
    value.setFaultReportSource(faultReportSource.getValue());
    value.setHasSettlement(hasSettlement.getValue());
    value.setEvaluateComment(evaluateComment.getValue());
    value.setEvaluater(evaluater.getValue());
    value.setEvaluateTime(evaluateTime.getValue());
    return value;
  }
  
  public UIRepairTaskStatisticData doGetValue() {
    
    value.setReportOrg(reportOrg.getValue());
    value.setReportTime(reportTime.getValue());
    value.setDispatchTime(dispatchTime.getValue());
    value.setFinishTime(finishTime.getValue());
    value.setLocation(location.getValue());
    value.setOperator(operator.getValue());
    value.setReportSid(reportSid.getValue());
    value.setStatus(status.getValue());
    value.setFaultEmergencyLevel(faultEmergencyLevel.getValue());
    value.setTeams(teams.getValue());
    value.setWorkers(workers.getValue());
    value.setMType(mType.getValue());
    value.setFaultType(faultType.getValue());
    value.setComment(comment.getValue());
    value.setReporterName(reporterName.getValue());
    value.setFaultReportSource(faultReportSource.getValue());
    value.setHasSettlement(hasSettlement.getValue());
    value.setEvaluateComment(evaluateComment.getValue());
    value.setEvaluater(evaluater.getValue());
    value.setEvaluateTime(evaluateTime.getValue());
    return value;
  }
  
  public UIRepairTaskStatisticData getValue(final UIRepairTaskStatisticData copyValue) {
    
    copyValue.setReportOrg(reportOrg.getValue());
    copyValue.setReportTime(reportTime.getValue());
    copyValue.setDispatchTime(dispatchTime.getValue());
    copyValue.setFinishTime(finishTime.getValue());
    copyValue.setLocation(location.getValue());
    copyValue.setOperator(operator.getValue());
    copyValue.setReportSid(reportSid.getValue());
    copyValue.setStatus(status.getValue());
    copyValue.setFaultEmergencyLevel(faultEmergencyLevel.getValue());
    copyValue.setTeams(teams.getValue());
    copyValue.setWorkers(workers.getValue());
    copyValue.setMType(mType.getValue());
    copyValue.setFaultType(faultType.getValue());
    copyValue.setComment(comment.getValue());
    copyValue.setReporterName(reporterName.getValue());
    copyValue.setFaultReportSource(faultReportSource.getValue());
    copyValue.setHasSettlement(hasSettlement.getValue());
    copyValue.setEvaluateComment(evaluateComment.getValue());
    copyValue.setEvaluater(evaluater.getValue());
    copyValue.setEvaluateTime(evaluateTime.getValue());
    return copyValue;
  }
  
  protected RepairTaskStatisticDataListGrid doSetValue(final UIRepairTaskStatisticData value) {
    this.value = value;
    reportOrg.setValue(value.getReportOrg());
    reportTime.setValue(value.getReportTime());
    dispatchTime.setValue(value.getDispatchTime());
    finishTime.setValue(value.getFinishTime());
    location.setValue(value.getLocation());
    operator.setValue(value.getOperator());
    reportSid.setValue(value.getReportSid());
    status.setValue(value.getStatus());
    faultEmergencyLevel.setValue(value.getFaultEmergencyLevel());
    teams.setValue(value.getTeams());
    workers.setValue(value.getWorkers());
    mType.setValue(value.getMType());
    faultType.setValue(value.getFaultType());
    comment.setValue(value.getComment());
    reporterName.setValue(value.getReporterName());
    faultReportSource.setValue(value.getFaultReportSource());
    hasSettlement.setValue(value.getHasSettlement());
    evaluateComment.setValue(value.getEvaluateComment());
    evaluater.setValue(value.getEvaluater());
    evaluateTime.setValue(value.getEvaluateTime());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)reportOrg,(ICanAsWidget)reportTime,(ICanAsWidget)dispatchTime,(ICanAsWidget)finishTime,(ICanAsWidget)location,(ICanAsWidget)operator,(ICanAsWidget)reportSid,(ICanAsWidget)status,(ICanAsWidget)faultEmergencyLevel,(ICanAsWidget)teams,(ICanAsWidget)workers,(ICanAsWidget)mType,(ICanAsWidget)faultType,(ICanAsWidget)comment,(ICanAsWidget)reporterName,(ICanAsWidget)faultReportSource,(ICanAsWidget)hasSettlement,(ICanAsWidget)evaluateComment,(ICanAsWidget)evaluater,(ICanAsWidget)evaluateTime
    					);
  }
  
  public void initializeComponent() {
    AggregationRowConfig<UIRepairTaskStatisticData> _createSummaryRow = AggregationExtensions.createSummaryRow(this);
    final Procedure1<AggregationRowConfig<UIRepairTaskStatisticData>> _function = new Procedure1<AggregationRowConfig<UIRepairTaskStatisticData>>() {
        public void apply(final AggregationRowConfig<UIRepairTaskStatisticData> it) {
          final Procedure2<SafeHtmlBuilder,Object> _function = new Procedure2<SafeHtmlBuilder,Object>() {
              public void apply(final SafeHtmlBuilder sb, final Object state) {
                Iterable<UIRepairTaskStatisticData> _objects = RepairTaskStatisticDataListGrid.this.getObjects();
                int _size = IterableExtensions.size(_objects);
                String _string = Integer.valueOf(_size).toString();
                String _plus = ("\u5408\u8BA1:" + _string);
                String _plus_1 = (_plus + "\u6761");
                sb.appendHtmlConstant(_plus_1);
              }
            };
          ColumnRenderPair<UIRepairTaskStatisticData> _renderSummaryColumn = AggregationExtensions.<UIRepairTaskStatisticData>renderSummaryColumn(RepairTaskStatisticDataListGrid.this.reportOrg, _function);
          AggregationExtensions.<UIRepairTaskStatisticData>operator_add(it, _renderSummaryColumn);
        }
      };
    ObjectExtensions.<AggregationRowConfig<UIRepairTaskStatisticData>>operator_doubleArrow(_createSummaryRow, _function);
    SGroupingGrid<UIRepairTaskStatisticData> _asWidget = this.asWidget();
    _asWidget.groupBy(this.reportOrg, true);
    this.unForceFit();
    final Procedure2<Number,SafeHtmlBuilder> _function_1 = new Procedure2<Number,SafeHtmlBuilder>() {
        public void apply(final Number value, final SafeHtmlBuilder sb) {
          final Function1<Void,Integer> _function = new Function1<Void,Integer>() {
              public Integer apply(final Void it) {
                return Integer.valueOf(0);
              }
            };
          Number _nullsafe = Objects.<Number>nullsafe(value, _function);
          String _string = _nullsafe.toString();
          String _plus = ("\u5C0F\u8BA1:" + _string);
          String _plus_1 = (_plus + "\u6761");
          sb.appendHtmlConstant(_plus_1);
        }
      };
    this.reportOrg.setGroupRender(new IGroupRender() {
        public void render(Number value,SafeHtmlBuilder sb) {
          _function_1.apply(value,sb);
        }
    });
  }
}
