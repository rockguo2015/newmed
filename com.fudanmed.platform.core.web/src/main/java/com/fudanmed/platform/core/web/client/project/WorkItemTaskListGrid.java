package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTask;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTaskStatus;
import com.fudanmed.platform.core.web.shared.project.UIWorker;
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
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectsSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectsSelectorFactory.CollectionListColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;

public class WorkItemTaskListGrid extends GXTGridComponent<UIWorkItemTask> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIWorkItemTask> reportSid;
  
  public StringColumn<UIWorkItemTask> sid;
  
  public StringValueColumn<UIWorkItemTask,UIWorkItemTaskStatus> status;
  
  public DateTimeColumn<UIWorkItemTask> dateTime;
  
  public DateTimeColumn<UIWorkItemTask> finishDateTime;
  
  public StringValueColumn<UIWorkItemTask,RCEmployeeProxy> operator;
  
  public CollectionListColumn<UIWorkItemTask,UIWorker> workers;
  
  public StringColumn<UIWorkItemTask> stockStatus;
  
  public StringColumn<UIWorkItemTask> comment;
  
  @Inject
  private DefaultObjectsSelectorFactory defaultObjectsSelectorFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIWorkItemTask value = new UIWorkItemTask();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();reportSid = stringValueProviderFactory.createAsStringColumn("reportSid","报修单号",UIWorkItemTask.ReportSidAccessor,Integer.valueOf(130));
    widgetsRegistory.put("reportSid",reportSid);
    sid = stringValueProviderFactory.createAsStringColumn("sid","工单编号",UIWorkItemTask.SidAccessor,Integer.valueOf(130));
    widgetsRegistory.put("sid",sid);
    status = defaultObjectSelectorFactory.createAsDefaultColumn("status","工单状态",UIWorkItemTask.StatusAccessor,Integer.valueOf(80));
    widgetsRegistory.put("status",status);
    dateTime = dateValueProviderFactory.createAsDateTimeColumn("dateTime","派工时间",UIWorkItemTask.DateTimeAccessor,Integer.valueOf(120));
    widgetsRegistory.put("dateTime",dateTime);
    finishDateTime = dateValueProviderFactory.createAsDateTimeColumn("finishDateTime","完工时间",UIWorkItemTask.FinishDateTimeAccessor,Integer.valueOf(120));
    widgetsRegistory.put("finishDateTime",finishDateTime);
    operator = defaultObjectSelectorFactory.createAsDefaultColumn("operator","维修主管",UIWorkItemTask.OperatorAccessor);
    widgetsRegistory.put("operator",operator);
    workers = defaultObjectsSelectorFactory.createAsStringColumn("workers","维修人员",UIWorkItemTask.WorkersAccessor);
    widgetsRegistory.put("workers",workers);
    stockStatus = stringValueProviderFactory.createAsStringColumn("stockStatus","领料状态",UIWorkItemTask.StockStatusAccessor);
    widgetsRegistory.put("stockStatus",stockStatus);
    comment = stringValueProviderFactory.createAsStringColumn("comment","维修说明",UIWorkItemTask.CommentAccessor,Integer.valueOf(405));
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
  
  public UIWorkItemTask getValueAsNew() {
    UIWorkItemTask value = new UIWorkItemTask();
    value.setReportSid(reportSid.getValue());
    value.setSid(sid.getValue());
    value.setStatus(status.getValue());
    value.setDateTime(dateTime.getValue());
    value.setFinishDateTime(finishDateTime.getValue());
    value.setOperator(operator.getValue());
    value.setWorkers(workers.getValue());
    value.setStockStatus(stockStatus.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UIWorkItemTask doGetValue() {
    
    value.setReportSid(reportSid.getValue());
    value.setSid(sid.getValue());
    value.setStatus(status.getValue());
    value.setDateTime(dateTime.getValue());
    value.setFinishDateTime(finishDateTime.getValue());
    value.setOperator(operator.getValue());
    value.setWorkers(workers.getValue());
    value.setStockStatus(stockStatus.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UIWorkItemTask getValue(final UIWorkItemTask copyValue) {
    
    copyValue.setReportSid(reportSid.getValue());
    copyValue.setSid(sid.getValue());
    copyValue.setStatus(status.getValue());
    copyValue.setDateTime(dateTime.getValue());
    copyValue.setFinishDateTime(finishDateTime.getValue());
    copyValue.setOperator(operator.getValue());
    copyValue.setWorkers(workers.getValue());
    copyValue.setStockStatus(stockStatus.getValue());
    copyValue.setComment(comment.getValue());
    return copyValue;
  }
  
  protected WorkItemTaskListGrid doSetValue(final UIWorkItemTask value) {
    this.value = value;
    reportSid.setValue(value.getReportSid());
    sid.setValue(value.getSid());
    status.setValue(value.getStatus());
    dateTime.setValue(value.getDateTime());
    finishDateTime.setValue(value.getFinishDateTime());
    operator.setValue(value.getOperator());
    workers.setValue(value.getWorkers());
    stockStatus.setValue(value.getStockStatus());
    comment.setValue(value.getComment());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)reportSid,(ICanAsWidget)sid,(ICanAsWidget)status,(ICanAsWidget)dateTime,(ICanAsWidget)finishDateTime,(ICanAsWidget)operator,(ICanAsWidget)workers,(ICanAsWidget)stockStatus,(ICanAsWidget)comment
    					);
  }
  
  public void initializeComponent() {
    this.asWidget();
    this.unForceFit();
    final Procedure3<Context,UIWorkItemTaskStatus,SafeHtmlBuilder> _function = new Procedure3<Context,UIWorkItemTaskStatus,SafeHtmlBuilder>() {
        public void apply(final Context context, final UIWorkItemTaskStatus value, final SafeHtmlBuilder sb) {
          boolean _or = false;
          boolean _or_1 = false;
          boolean _or_2 = false;
          boolean _equals = Objects.equal(value, UIWorkItemTaskStatus.processing);
          if (_equals) {
            _or_2 = true;
          } else {
            boolean _equals_1 = Objects.equal(value, UIWorkItemTaskStatus.pending);
            _or_2 = (_equals || _equals_1);
          }
          if (_or_2) {
            _or_1 = true;
          } else {
            boolean _equals_2 = Objects.equal(value, UIWorkItemTaskStatus.outsourcing);
            _or_1 = (_or_2 || _equals_2);
          }
          if (_or_1) {
            _or = true;
          } else {
            boolean _equals_3 = Objects.equal(value, UIWorkItemTaskStatus.followuping);
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
    this.status.setRender(new ICellRender<UIWorkItemTaskStatus>() {
        public void render(Context context,UIWorkItemTaskStatus value,SafeHtmlBuilder sb) {
          _function.apply(context,value,sb);
        }
    });
  }
}
