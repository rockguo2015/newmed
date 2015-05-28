package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.shared.project.UIGeneralTask;
import com.fudanmed.platform.core.web.shared.project.UIGeneralTaskType;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory.DateTimeColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.component.treegrid.GXTTreeGridComponent;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class GeneralTaskTreeList extends GXTTreeGridComponent<UIGeneralTask> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringValueColumn<UIGeneralTask,UIGeneralTaskType> taskType;
  
  public StringColumn<UIGeneralTask> taskOwner;
  
  public StringColumn<UIGeneralTask> status;
  
  public DateTimeColumn<UIGeneralTask> dateTime;
  
  public DateTimeColumn<UIGeneralTask> finishDateTime;
  
  public StringValueColumn<UIGeneralTask,RCEmployeeProxy> operator;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIGeneralTask value = new UIGeneralTask();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();taskType = defaultObjectSelectorFactory.createAsDefaultColumn("taskType","任务类型",UIGeneralTask.TaskTypeAccessor);
    widgetsRegistory.put("taskType",taskType);
    taskOwner = stringValueProviderFactory.createAsStringColumn("taskOwner","执行者",UIGeneralTask.TaskOwnerAccessor);
    widgetsRegistory.put("taskOwner",taskOwner);
    status = stringValueProviderFactory.createAsStringColumn("status","任务状态",UIGeneralTask.StatusAccessor);
    widgetsRegistory.put("status",status);
    dateTime = dateValueProviderFactory.createAsDateTimeColumn("dateTime","派发时间",UIGeneralTask.DateTimeAccessor);
    widgetsRegistory.put("dateTime",dateTime);
    finishDateTime = dateValueProviderFactory.createAsDateTimeColumn("finishDateTime","完工时间",UIGeneralTask.FinishDateTimeAccessor);
    widgetsRegistory.put("finishDateTime",finishDateTime);
    operator = defaultObjectSelectorFactory.createAsDefaultColumn("operator","任务派发人",UIGeneralTask.OperatorAccessor);
    widgetsRegistory.put("operator",operator);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIGeneralTask getValueAsNew() {
    UIGeneralTask value = new UIGeneralTask();
    value.setTaskType(taskType.getValue());
    value.setTaskOwner(taskOwner.getValue());
    value.setStatus(status.getValue());
    value.setDateTime(dateTime.getValue());
    value.setFinishDateTime(finishDateTime.getValue());
    value.setOperator(operator.getValue());
    return value;
  }
  
  public UIGeneralTask doGetValue() {
    
    value.setTaskType(taskType.getValue());
    value.setTaskOwner(taskOwner.getValue());
    value.setStatus(status.getValue());
    value.setDateTime(dateTime.getValue());
    value.setFinishDateTime(finishDateTime.getValue());
    value.setOperator(operator.getValue());
    return value;
  }
  
  public UIGeneralTask getValue(final UIGeneralTask copyValue) {
    
    copyValue.setTaskType(taskType.getValue());
    copyValue.setTaskOwner(taskOwner.getValue());
    copyValue.setStatus(status.getValue());
    copyValue.setDateTime(dateTime.getValue());
    copyValue.setFinishDateTime(finishDateTime.getValue());
    copyValue.setOperator(operator.getValue());
    return copyValue;
  }
  
  protected GeneralTaskTreeList doSetValue(final UIGeneralTask value) {
    this.value = value;
    taskType.setValue(value.getTaskType());
    taskOwner.setValue(value.getTaskOwner());
    status.setValue(value.getStatus());
    dateTime.setValue(value.getDateTime());
    finishDateTime.setValue(value.getFinishDateTime());
    operator.setValue(value.getOperator());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)taskType,(ICanAsWidget)taskOwner,(ICanAsWidget)status,(ICanAsWidget)dateTime,(ICanAsWidget)finishDateTime,(ICanAsWidget)operator
    					);
  }
}
