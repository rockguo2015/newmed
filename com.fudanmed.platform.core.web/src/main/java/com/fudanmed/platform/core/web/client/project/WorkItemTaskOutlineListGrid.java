package com.fudanmed.platform.core.web.client.project;

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
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;

public class WorkItemTaskOutlineListGrid extends GXTGridComponent<UIWorkItemTask> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringValueColumn<UIWorkItemTask,UIWorkItemTaskStatus> status;
  
  public CollectionListColumn<UIWorkItemTask,UIWorker> workers;
  
  public DateTimeColumn<UIWorkItemTask> dateTime;
  
  public DateTimeColumn<UIWorkItemTask> finishDateTime;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private DefaultObjectsSelectorFactory defaultObjectsSelectorFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  private UIWorkItemTask value = new UIWorkItemTask();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();status = defaultObjectSelectorFactory.createAsDefaultColumn("status","工单状态",UIWorkItemTask.StatusAccessor,Integer.valueOf(30));
    widgetsRegistory.put("status",status);
    workers = defaultObjectsSelectorFactory.createAsStringColumn("workers","维修人员",UIWorkItemTask.WorkersAccessor);
    widgetsRegistory.put("workers",workers);
    dateTime = dateValueProviderFactory.createAsDateTimeColumn("dateTime","派工时间",UIWorkItemTask.DateTimeAccessor);
    widgetsRegistory.put("dateTime",dateTime);
    finishDateTime = dateValueProviderFactory.createAsDateTimeColumn("finishDateTime","完工时间",UIWorkItemTask.FinishDateTimeAccessor);
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
  
  public UIWorkItemTask getValueAsNew() {
    UIWorkItemTask value = new UIWorkItemTask();
    value.setStatus(status.getValue());
    value.setWorkers(workers.getValue());
    value.setDateTime(dateTime.getValue());
    value.setFinishDateTime(finishDateTime.getValue());
    return value;
  }
  
  public UIWorkItemTask doGetValue() {
    
    value.setStatus(status.getValue());
    value.setWorkers(workers.getValue());
    value.setDateTime(dateTime.getValue());
    value.setFinishDateTime(finishDateTime.getValue());
    return value;
  }
  
  public UIWorkItemTask getValue(final UIWorkItemTask copyValue) {
    
    copyValue.setStatus(status.getValue());
    copyValue.setWorkers(workers.getValue());
    copyValue.setDateTime(dateTime.getValue());
    copyValue.setFinishDateTime(finishDateTime.getValue());
    return copyValue;
  }
  
  protected WorkItemTaskOutlineListGrid doSetValue(final UIWorkItemTask value) {
    this.value = value;
    status.setValue(value.getStatus());
    workers.setValue(value.getWorkers());
    dateTime.setValue(value.getDateTime());
    finishDateTime.setValue(value.getFinishDateTime());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)status,(ICanAsWidget)workers,(ICanAsWidget)dateTime,(ICanAsWidget)finishDateTime
    					);
  }
  
  public void initializeComponent() {
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
            String _plus = ("<B style=\'color:red;\'>" + _string);
            String _plus_1 = (_plus + "</B>");
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
