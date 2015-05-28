package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.common.proxy.RCFaultLevelProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.shared.project.UIGroupTask;
import com.fudanmed.platform.core.web.shared.project.UIGroupTaskStatus;
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

public class GroupTaskListGrid extends GXTGridComponent<UIGroupTask> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public BooleanColumn<UIGroupTask> needAudit;
  
  public StringColumn<UIGroupTask> reportSid;
  
  public StringValueColumn<UIGroupTask,UIGroupTaskStatus> status;
  
  public StringValueColumn<UIGroupTask,RCFaultLevelProxy> faultLevel;
  
  public DateTimeColumn<UIGroupTask> dateTime;
  
  public DateTimeColumn<UIGroupTask> planFinishDateTime;
  
  public StringColumn<UIGroupTask> location;
  
  public StringColumn<UIGroupTask> comment;
  
  public StringValueColumn<UIGroupTask,RCOrganizationProxy> reportOrg;
  
  public StringColumn<UIGroupTask> reporterName;
  
  public DateTimeColumn<UIGroupTask> finishDateTime;
  
  @Inject
  private BooleanValueProviderFactory booleanValueProviderFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIGroupTask value = new UIGroupTask();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();needAudit = booleanValueProviderFactory.createAsBooleanColumn("needAudit","需要审批",UIGroupTask.NeedAuditAccessor);
    widgetsRegistory.put("needAudit",needAudit);
    reportSid = stringValueProviderFactory.createAsStringColumn("reportSid","报修单号",UIGroupTask.ReportSidAccessor,Integer.valueOf(130));
    widgetsRegistory.put("reportSid",reportSid);
    status = defaultObjectSelectorFactory.createAsDefaultColumn("status","状态",UIGroupTask.StatusAccessor,Integer.valueOf(80));
    widgetsRegistory.put("status",status);
    faultLevel = defaultObjectSelectorFactory.createAsDefaultColumn("faultLevel","风险等级",UIGroupTask.FaultLevelAccessor,Integer.valueOf(80));
    widgetsRegistory.put("faultLevel",faultLevel);
    dateTime = dateValueProviderFactory.createAsDateTimeColumn("dateTime","派发时间",UIGroupTask.DateTimeAccessor,Integer.valueOf(120));
    widgetsRegistory.put("dateTime",dateTime);
    planFinishDateTime = dateValueProviderFactory.createAsDateTimeColumn("planFinishDateTime","计划完成时间",UIGroupTask.PlanFinishDateTimeAccessor,Integer.valueOf(120));
    widgetsRegistory.put("planFinishDateTime",planFinishDateTime);
    location = stringValueProviderFactory.createAsStringColumn("location","报修地点",UIGroupTask.LocationAccessor,Integer.valueOf(200));
    widgetsRegistory.put("location",location);
    comment = stringValueProviderFactory.createAsStringColumn("comment","报修内容",UIGroupTask.CommentAccessor,Integer.valueOf(197));
    widgetsRegistory.put("comment",comment);
    reportOrg = defaultObjectSelectorFactory.createAsDefaultColumn("reportOrg","报修部门",UIGroupTask.ReportOrgAccessor);
    widgetsRegistory.put("reportOrg",reportOrg);
    reporterName = stringValueProviderFactory.createAsStringColumn("reporterName","报修人",UIGroupTask.ReporterNameAccessor);
    widgetsRegistory.put("reporterName",reporterName);
    finishDateTime = dateValueProviderFactory.createAsDateTimeColumn("finishDateTime","完工上报时间",UIGroupTask.FinishDateTimeAccessor,Integer.valueOf(110));
    widgetsRegistory.put("finishDateTime",finishDateTime);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIGroupTask getValueAsNew() {
    UIGroupTask value = new UIGroupTask();
    value.setNeedAudit(needAudit.getValue());
    value.setReportSid(reportSid.getValue());
    value.setStatus(status.getValue());
    value.setFaultLevel(faultLevel.getValue());
    value.setDateTime(dateTime.getValue());
    value.setPlanFinishDateTime(planFinishDateTime.getValue());
    value.setLocation(location.getValue());
    value.setComment(comment.getValue());
    value.setReportOrg(reportOrg.getValue());
    value.setReporterName(reporterName.getValue());
    value.setFinishDateTime(finishDateTime.getValue());
    return value;
  }
  
  public UIGroupTask doGetValue() {
    
    value.setNeedAudit(needAudit.getValue());
    value.setReportSid(reportSid.getValue());
    value.setStatus(status.getValue());
    value.setFaultLevel(faultLevel.getValue());
    value.setDateTime(dateTime.getValue());
    value.setPlanFinishDateTime(planFinishDateTime.getValue());
    value.setLocation(location.getValue());
    value.setComment(comment.getValue());
    value.setReportOrg(reportOrg.getValue());
    value.setReporterName(reporterName.getValue());
    value.setFinishDateTime(finishDateTime.getValue());
    return value;
  }
  
  public UIGroupTask getValue(final UIGroupTask copyValue) {
    
    copyValue.setNeedAudit(needAudit.getValue());
    copyValue.setReportSid(reportSid.getValue());
    copyValue.setStatus(status.getValue());
    copyValue.setFaultLevel(faultLevel.getValue());
    copyValue.setDateTime(dateTime.getValue());
    copyValue.setPlanFinishDateTime(planFinishDateTime.getValue());
    copyValue.setLocation(location.getValue());
    copyValue.setComment(comment.getValue());
    copyValue.setReportOrg(reportOrg.getValue());
    copyValue.setReporterName(reporterName.getValue());
    copyValue.setFinishDateTime(finishDateTime.getValue());
    return copyValue;
  }
  
  protected GroupTaskListGrid doSetValue(final UIGroupTask value) {
    this.value = value;
    needAudit.setValue(value.getNeedAudit());
    reportSid.setValue(value.getReportSid());
    status.setValue(value.getStatus());
    faultLevel.setValue(value.getFaultLevel());
    dateTime.setValue(value.getDateTime());
    planFinishDateTime.setValue(value.getPlanFinishDateTime());
    location.setValue(value.getLocation());
    comment.setValue(value.getComment());
    reportOrg.setValue(value.getReportOrg());
    reporterName.setValue(value.getReporterName());
    finishDateTime.setValue(value.getFinishDateTime());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)needAudit,(ICanAsWidget)reportSid,(ICanAsWidget)status,(ICanAsWidget)faultLevel,(ICanAsWidget)dateTime,(ICanAsWidget)planFinishDateTime,(ICanAsWidget)location,(ICanAsWidget)comment,(ICanAsWidget)reportOrg,(ICanAsWidget)reporterName,(ICanAsWidget)finishDateTime
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
          ListStore<UIGroupTask> _store = GroupTaskListGrid.this.grid.getStore();
          int _index = context.getIndex();
          final UIGroupTask m = _store.get(_index);
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
    final Procedure3<Context,UIGroupTaskStatus,SafeHtmlBuilder> _function_2 = new Procedure3<Context,UIGroupTaskStatus,SafeHtmlBuilder>() {
        public void apply(final Context context, final UIGroupTaskStatus value, final SafeHtmlBuilder sb) {
          boolean _equals = Objects.equal(value, null);
          if (_equals) {
            return;
          }
          boolean _or = false;
          boolean _equals_1 = Objects.equal(value, UIGroupTaskStatus.newCreated);
          if (_equals_1) {
            _or = true;
          } else {
            boolean _equals_2 = Objects.equal(value, UIGroupTaskStatus.wait4TeamOwnerProcess);
            _or = (_equals_1 || _equals_2);
          }
          if (_or) {
            String _string = value.toString();
            String _plus = ("<B style=\'color:red;\'>" + _string);
            String _plus_1 = (_plus + "</B>");
            sb.appendHtmlConstant(_plus_1);
          } else {
            String _string_1 = value.toString();
            sb.appendHtmlConstant(_string_1);
          }
        }
      };
    this.status.setRender(new ICellRender<UIGroupTaskStatus>() {
        public void render(Context context,UIGroupTaskStatus value,SafeHtmlBuilder sb) {
          _function_2.apply(context,value,sb);
        }
    });
    final Procedure3<Context,Date,SafeHtmlBuilder> _function_3 = new Procedure3<Context,Date,SafeHtmlBuilder>() {
        public void apply(final Context context, final Date value, final SafeHtmlBuilder sb) {
          boolean _equals = Objects.equal(value, null);
          if (_equals) {
            return;
          }
          ListStore<UIGroupTask> _store = GroupTaskListGrid.this.grid.getStore();
          int _index = context.getIndex();
          final UIGroupTask m = _store.get(_index);
          boolean _and = false;
          boolean _and_1 = false;
          UIGroupTaskStatus _status = m.getStatus();
          boolean _notEquals = (!Objects.equal(_status, UIGroupTaskStatus.finished));
          if (!_notEquals) {
            _and_1 = false;
          } else {
            UIGroupTaskStatus _status_1 = m.getStatus();
            boolean _notEquals_1 = (!Objects.equal(_status_1, UIGroupTaskStatus.misDispatched));
            _and_1 = (_notEquals && _notEquals_1);
          }
          if (!_and_1) {
            _and = false;
          } else {
            Date _now = DateUtil.now();
            boolean _greaterThan = (_now.compareTo(value) > 0);
            _and = (_and_1 && _greaterThan);
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
