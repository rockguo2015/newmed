package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.common.proxy.RCFaultLevelProxy;
import com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatus;
import com.google.common.base.Objects;
import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.inject.Inject;
import com.sencha.gxt.data.shared.ListStore;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.shared.DateUtil;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.ICellRender;
import edu.fudan.langlab.gxt.client.component.grid.factory.BooleanValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.BooleanValueProviderFactory.BooleanColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory.DateTimeColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Date;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;

public class RepairTaskListGrid extends GXTGridComponent<UIRepairTask> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public BooleanColumn<UIRepairTask> needAudit;
  
  public StringColumn<UIRepairTask> reportSid;
  
  public StringValueColumn<UIRepairTask,RCFaultReportSourceProxy> faultReportSource;
  
  public StringValueColumn<UIRepairTask,UIRepairTaskStatus> status;
  
  public StringValueColumn<UIRepairTask,RCFaultLevelProxy> faultLevel;
  
  public DateTimeColumn<UIRepairTask> reportDateTime;
  
  public StringValueColumn<UIRepairTask,RCMaintenanceTeamProxy> activeTeam;
  
  public StringValueColumn<UIRepairTask,RCOrganizationProxy> reportOrg;
  
  public StringColumn<UIRepairTask> comment;
  
  public DateTimeColumn<UIRepairTask> planFinishDateTime;
  
  public StringColumn<UIRepairTask> location;
  
  public StringColumn<UIRepairTask> reporterName;
  
  @Inject
  private BooleanValueProviderFactory booleanValueProviderFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIRepairTask value = new UIRepairTask();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();needAudit = booleanValueProviderFactory.createAsBooleanColumn("needAudit","需要审批",UIRepairTask.NeedAuditAccessor);
    widgetsRegistory.put("needAudit",needAudit);
    reportSid = stringValueProviderFactory.createAsStringColumn("reportSid","报修单号",UIRepairTask.ReportSidAccessor,Integer.valueOf(130));
    widgetsRegistory.put("reportSid",reportSid);
    faultReportSource = defaultObjectSelectorFactory.createAsDefaultColumn("faultReportSource","报修来源",UIRepairTask.FaultReportSourceAccessor,Integer.valueOf(80));
    widgetsRegistory.put("faultReportSource",faultReportSource);
    status = defaultObjectSelectorFactory.createAsDefaultColumn("status","状态",UIRepairTask.StatusAccessor,Integer.valueOf(80));
    widgetsRegistory.put("status",status);
    faultLevel = defaultObjectSelectorFactory.createAsDefaultColumn("faultLevel","风险等级",UIRepairTask.FaultLevelAccessor,Integer.valueOf(80));
    widgetsRegistory.put("faultLevel",faultLevel);
    reportDateTime = dateValueProviderFactory.createAsDateTimeColumn("reportDateTime","接报时间",UIRepairTask.ReportDateTimeAccessor,Integer.valueOf(120));
    widgetsRegistory.put("reportDateTime",reportDateTime);
    activeTeam = defaultObjectSelectorFactory.createAsDefaultColumn("activeTeam","维修班组",UIRepairTask.ActiveTeamAccessor,Integer.valueOf(160));
    widgetsRegistory.put("activeTeam",activeTeam);
    reportOrg = defaultObjectSelectorFactory.createAsDefaultColumn("reportOrg","报修部门",UIRepairTask.ReportOrgAccessor);
    widgetsRegistory.put("reportOrg",reportOrg);
    comment = stringValueProviderFactory.createAsStringColumn("comment","报修内容",UIRepairTask.CommentAccessor,Integer.valueOf(200));
    widgetsRegistory.put("comment",comment);
    planFinishDateTime = dateValueProviderFactory.createAsDateTimeColumn("planFinishDateTime","计划完成时间",UIRepairTask.PlanFinishDateTimeAccessor,Integer.valueOf(120));
    widgetsRegistory.put("planFinishDateTime",planFinishDateTime);
    location = stringValueProviderFactory.createAsStringColumn("location","报修地点",UIRepairTask.LocationAccessor,Integer.valueOf(207));
    widgetsRegistory.put("location",location);
    reporterName = stringValueProviderFactory.createAsStringColumn("reporterName","报修人",UIRepairTask.ReporterNameAccessor);
    widgetsRegistory.put("reporterName",reporterName);
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
    value.setNeedAudit(needAudit.getValue());
    value.setReportSid(reportSid.getValue());
    value.setFaultReportSource(faultReportSource.getValue());
    value.setStatus(status.getValue());
    value.setFaultLevel(faultLevel.getValue());
    value.setReportDateTime(reportDateTime.getValue());
    value.setActiveTeam(activeTeam.getValue());
    value.setReportOrg(reportOrg.getValue());
    value.setComment(comment.getValue());
    value.setPlanFinishDateTime(planFinishDateTime.getValue());
    value.setLocation(location.getValue());
    value.setReporterName(reporterName.getValue());
    return value;
  }
  
  public UIRepairTask doGetValue() {
    
    value.setNeedAudit(needAudit.getValue());
    value.setReportSid(reportSid.getValue());
    value.setFaultReportSource(faultReportSource.getValue());
    value.setStatus(status.getValue());
    value.setFaultLevel(faultLevel.getValue());
    value.setReportDateTime(reportDateTime.getValue());
    value.setActiveTeam(activeTeam.getValue());
    value.setReportOrg(reportOrg.getValue());
    value.setComment(comment.getValue());
    value.setPlanFinishDateTime(planFinishDateTime.getValue());
    value.setLocation(location.getValue());
    value.setReporterName(reporterName.getValue());
    return value;
  }
  
  public UIRepairTask getValue(final UIRepairTask copyValue) {
    
    copyValue.setNeedAudit(needAudit.getValue());
    copyValue.setReportSid(reportSid.getValue());
    copyValue.setFaultReportSource(faultReportSource.getValue());
    copyValue.setStatus(status.getValue());
    copyValue.setFaultLevel(faultLevel.getValue());
    copyValue.setReportDateTime(reportDateTime.getValue());
    copyValue.setActiveTeam(activeTeam.getValue());
    copyValue.setReportOrg(reportOrg.getValue());
    copyValue.setComment(comment.getValue());
    copyValue.setPlanFinishDateTime(planFinishDateTime.getValue());
    copyValue.setLocation(location.getValue());
    copyValue.setReporterName(reporterName.getValue());
    return copyValue;
  }
  
  protected RepairTaskListGrid doSetValue(final UIRepairTask value) {
    this.value = value;
    needAudit.setValue(value.getNeedAudit());
    reportSid.setValue(value.getReportSid());
    faultReportSource.setValue(value.getFaultReportSource());
    status.setValue(value.getStatus());
    faultLevel.setValue(value.getFaultLevel());
    reportDateTime.setValue(value.getReportDateTime());
    activeTeam.setValue(value.getActiveTeam());
    reportOrg.setValue(value.getReportOrg());
    comment.setValue(value.getComment());
    planFinishDateTime.setValue(value.getPlanFinishDateTime());
    location.setValue(value.getLocation());
    reporterName.setValue(value.getReporterName());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)needAudit,(ICanAsWidget)reportSid,(ICanAsWidget)faultReportSource,(ICanAsWidget)status,(ICanAsWidget)faultLevel,(ICanAsWidget)reportDateTime,(ICanAsWidget)activeTeam,(ICanAsWidget)reportOrg,(ICanAsWidget)comment,(ICanAsWidget)planFinishDateTime,(ICanAsWidget)location,(ICanAsWidget)reporterName
    					);
  }
  
  public void initializeComponent() {
    this.asWidget();
    this.unForceFit();
    final Procedure3<Context,Boolean,SafeHtmlBuilder> _function = new Procedure3<Context,Boolean,SafeHtmlBuilder>() {
        public void apply(final Context context, final Boolean value, final SafeHtmlBuilder sb) {
          boolean _equals = Objects.equal(value, null);
          if (_equals) {
            return;
          }
          if ((value).booleanValue()) {
            String _plus = ("<SPAN style=\'color:red;\'>" + "\u662F");
            String _plus_1 = (_plus + "</SPAN>");
            sb.appendHtmlConstant(_plus_1);
          } else {
            String _plus_2 = ("<SPAN>" + "\u5426");
            String _plus_3 = (_plus_2 + "</SPAN>");
            sb.appendHtmlConstant(_plus_3);
          }
        }
      };
    this.needAudit.setRender(new ICellRender<Boolean>() {
        public void render(Context context,Boolean value,SafeHtmlBuilder sb) {
          _function.apply(context,value,sb);
        }
    });
    final Procedure3<Context,RCFaultLevelProxy,SafeHtmlBuilder> _function_1 = new Procedure3<Context,RCFaultLevelProxy,SafeHtmlBuilder>() {
        public void apply(final Context context, final RCFaultLevelProxy value, final SafeHtmlBuilder sb) {
          boolean _equals = Objects.equal(value, null);
          if (_equals) {
            return;
          }
          ListStore<UIRepairTask> _store = RepairTaskListGrid.this.grid.getStore();
          int _index = context.getIndex();
          final UIRepairTask m = _store.get(_index);
          String _faultLevelColor = m.getFaultLevelColor();
          String _plus = ("<SPAN style=\'color:" + _faultLevelColor);
          String _plus_1 = (_plus + ";\'>");
          String _string = value.toString();
          String _plus_2 = (_plus_1 + _string);
          String _plus_3 = (_plus_2 + "</SPAN>");
          sb.appendHtmlConstant(_plus_3);
        }
      };
    this.faultLevel.setRender(new ICellRender<RCFaultLevelProxy>() {
        public void render(Context context,RCFaultLevelProxy value,SafeHtmlBuilder sb) {
          _function_1.apply(context,value,sb);
        }
    });
    final Procedure3<Context,UIRepairTaskStatus,SafeHtmlBuilder> _function_2 = new Procedure3<Context,UIRepairTaskStatus,SafeHtmlBuilder>() {
        public void apply(final Context context, final UIRepairTaskStatus value, final SafeHtmlBuilder sb) {
          boolean _equals = Objects.equal(value, null);
          if (_equals) {
            return;
          }
          boolean _or = false;
          boolean _or_1 = false;
          boolean _equals_1 = Objects.equal(value, UIRepairTaskStatus.newCreated);
          if (_equals_1) {
            _or_1 = true;
          } else {
            boolean _equals_2 = Objects.equal(value, UIRepairTaskStatus.wait4Close);
            _or_1 = (_equals_1 || _equals_2);
          }
          if (_or_1) {
            _or = true;
          } else {
            boolean _equals_3 = Objects.equal(value, UIRepairTaskStatus.wait4SchedulerProcess);
            _or = (_or_1 || _equals_3);
          }
          if (_or) {
            String _string = value.toString();
            String _plus = ("<SPAN style=\'color:red;\'>" + _string);
            String _plus_1 = (_plus + "</SPAN>");
            sb.appendHtmlConstant(_plus_1);
          } else {
            String _string_1 = value.toString();
            sb.appendHtmlConstant(_string_1);
          }
        }
      };
    this.status.setRender(new ICellRender<UIRepairTaskStatus>() {
        public void render(Context context,UIRepairTaskStatus value,SafeHtmlBuilder sb) {
          _function_2.apply(context,value,sb);
        }
    });
    final Procedure3<Context,Date,SafeHtmlBuilder> _function_3 = new Procedure3<Context,Date,SafeHtmlBuilder>() {
        public void apply(final Context context, final Date value, final SafeHtmlBuilder sb) {
          boolean _equals = Objects.equal(value, null);
          if (_equals) {
            return;
          }
          ListStore<UIRepairTask> _store = RepairTaskListGrid.this.grid.getStore();
          int _index = context.getIndex();
          final UIRepairTask m = _store.get(_index);
          boolean _and = false;
          UIRepairTaskStatus _status = m.getStatus();
          boolean _notEquals = (!Objects.equal(_status, UIRepairTaskStatus.closed));
          if (!_notEquals) {
            _and = false;
          } else {
            Date _now = DateUtil.now();
            boolean _greaterThan = (_now.compareTo(value) > 0);
            _and = (_notEquals && _greaterThan);
          }
          if (_and) {
            String _formatDateTime = DateUtil.getFormatDateTime(value);
            String _plus = ("<SPAN style=\'color:red;\'>" + _formatDateTime);
            String _plus_1 = (_plus + "</SPAN>");
            sb.appendHtmlConstant(_plus_1);
          } else {
            String _formatDateTime_1 = DateUtil.getFormatDateTime(value);
            sb.appendHtmlConstant(_formatDateTime_1);
          }
        }
      };
    this.planFinishDateTime.setRender(new ICellRender<Date>() {
        public void render(Context context,Date value,SafeHtmlBuilder sb) {
          _function_3.apply(context,value,sb);
        }
    });
  }
}
