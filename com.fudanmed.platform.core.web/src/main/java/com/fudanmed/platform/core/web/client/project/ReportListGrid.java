package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.shared.project.UIEvaluateState;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatus;
import com.google.common.base.Objects;
import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.ICellRender;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory.DateTimeColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;

public class ReportListGrid extends GXTGridComponent<UIRepairTask> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIRepairTask> reportSid;
  
  public StringValueColumn<UIRepairTask,UIRepairTaskStatus> status;
  
  public DateTimeColumn<UIRepairTask> reportDateTime;
  
  public DateTimeColumn<UIRepairTask> planFinishDateTime;
  
  public StringColumn<UIRepairTask> location;
  
  public StringColumn<UIRepairTask> comment;
  
  public StringColumn<UIRepairTask> reporterName;
  
  public StringValueColumn<UIRepairTask,RCOrganizationProxy> reportOrg;
  
  public StringValueColumn<UIRepairTask,UIEvaluateState> evaluateState;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIRepairTask value = new UIRepairTask();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();reportSid = stringValueProviderFactory.createAsStringColumn("reportSid","报修单号",UIRepairTask.ReportSidAccessor,Integer.valueOf(150));
    widgetsRegistory.put("reportSid",reportSid);
    status = defaultObjectSelectorFactory.createAsDefaultColumn("status","状态",UIRepairTask.StatusAccessor,Integer.valueOf(80));
    widgetsRegistory.put("status",status);
    reportDateTime = dateValueProviderFactory.createAsDateTimeColumn("reportDateTime","接报时间",UIRepairTask.ReportDateTimeAccessor);
    widgetsRegistory.put("reportDateTime",reportDateTime);
    planFinishDateTime = dateValueProviderFactory.createAsDateTimeColumn("planFinishDateTime","计划完成时间",UIRepairTask.PlanFinishDateTimeAccessor);
    widgetsRegistory.put("planFinishDateTime",planFinishDateTime);
    location = stringValueProviderFactory.createAsStringColumn("location","报修地点",UIRepairTask.LocationAccessor,Integer.valueOf(150));
    widgetsRegistory.put("location",location);
    comment = stringValueProviderFactory.createAsStringColumn("comment","报修内容",UIRepairTask.CommentAccessor,Integer.valueOf(174));
    widgetsRegistory.put("comment",comment);
    reporterName = stringValueProviderFactory.createAsStringColumn("reporterName","报修人",UIRepairTask.ReporterNameAccessor);
    widgetsRegistory.put("reporterName",reporterName);
    reportOrg = defaultObjectSelectorFactory.createAsDefaultColumn("reportOrg","报修部门",UIRepairTask.ReportOrgAccessor);
    widgetsRegistory.put("reportOrg",reportOrg);
    evaluateState = defaultObjectSelectorFactory.createAsDefaultColumn("evaluateState","用户评价状态",UIRepairTask.EvaluateStateAccessor);
    widgetsRegistory.put("evaluateState",evaluateState);
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
    value.setReportSid(reportSid.getValue());
    value.setStatus(status.getValue());
    value.setReportDateTime(reportDateTime.getValue());
    value.setPlanFinishDateTime(planFinishDateTime.getValue());
    value.setLocation(location.getValue());
    value.setComment(comment.getValue());
    value.setReporterName(reporterName.getValue());
    value.setReportOrg(reportOrg.getValue());
    value.setEvaluateState(evaluateState.getValue());
    return value;
  }
  
  public UIRepairTask doGetValue() {
    
    value.setReportSid(reportSid.getValue());
    value.setStatus(status.getValue());
    value.setReportDateTime(reportDateTime.getValue());
    value.setPlanFinishDateTime(planFinishDateTime.getValue());
    value.setLocation(location.getValue());
    value.setComment(comment.getValue());
    value.setReporterName(reporterName.getValue());
    value.setReportOrg(reportOrg.getValue());
    value.setEvaluateState(evaluateState.getValue());
    return value;
  }
  
  public UIRepairTask getValue(final UIRepairTask copyValue) {
    
    copyValue.setReportSid(reportSid.getValue());
    copyValue.setStatus(status.getValue());
    copyValue.setReportDateTime(reportDateTime.getValue());
    copyValue.setPlanFinishDateTime(planFinishDateTime.getValue());
    copyValue.setLocation(location.getValue());
    copyValue.setComment(comment.getValue());
    copyValue.setReporterName(reporterName.getValue());
    copyValue.setReportOrg(reportOrg.getValue());
    copyValue.setEvaluateState(evaluateState.getValue());
    return copyValue;
  }
  
  protected ReportListGrid doSetValue(final UIRepairTask value) {
    this.value = value;
    reportSid.setValue(value.getReportSid());
    status.setValue(value.getStatus());
    reportDateTime.setValue(value.getReportDateTime());
    planFinishDateTime.setValue(value.getPlanFinishDateTime());
    location.setValue(value.getLocation());
    comment.setValue(value.getComment());
    reporterName.setValue(value.getReporterName());
    reportOrg.setValue(value.getReportOrg());
    evaluateState.setValue(value.getEvaluateState());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)reportSid,(ICanAsWidget)status,(ICanAsWidget)reportDateTime,(ICanAsWidget)planFinishDateTime,(ICanAsWidget)location,(ICanAsWidget)comment,(ICanAsWidget)reporterName,(ICanAsWidget)reportOrg,(ICanAsWidget)evaluateState
    					);
  }
  
  public void initializeComponent() {
    this.asWidget();
    this.unForceFit();
    final Procedure3<Context,UIEvaluateState,SafeHtmlBuilder> _function = new Procedure3<Context,UIEvaluateState,SafeHtmlBuilder>() {
        public void apply(final Context context, final UIEvaluateState value, final SafeHtmlBuilder sb) {
          boolean _notEquals = (!Objects.equal(value, null));
          if (_notEquals) {
            boolean _equals = Objects.equal(value, UIEvaluateState.waiting);
            if (_equals) {
              String _string = value.toString();
              String _plus = ("<SPAN style=\'color:red;\'>" + _string);
              String _plus_1 = (_plus + "</SPAN>");
              sb.appendHtmlConstant(_plus_1);
            } else {
              String _string_1 = value.toString();
              sb.appendHtmlConstant(_string_1);
            }
          }
        }
      };
    this.evaluateState.setRender(new ICellRender<UIEvaluateState>() {
        public void render(Context context,UIEvaluateState value,SafeHtmlBuilder sb) {
          _function.apply(context,value,sb);
        }
    });
  }
}
