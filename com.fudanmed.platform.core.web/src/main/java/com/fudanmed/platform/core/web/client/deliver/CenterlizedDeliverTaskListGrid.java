package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverSubjectProxy;
import com.fudanmed.platform.core.deliver.proxy.DLResourceProxy;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTaskStatus;
import com.fudanmed.platform.core.web.shared.deliver.UITaskSourceType;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory.DateColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory.TimeColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectsSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectsSelectorFactory.CollectionListColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class CenterlizedDeliverTaskListGrid extends GXTGridComponent<UICenterlizedDeliverTask> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UICenterlizedDeliverTask> sid;
  
  public DateColumn<UICenterlizedDeliverTask> createTime;
  
  public DateColumn<UICenterlizedDeliverTask> planDate;
  
  public TimeColumn<UICenterlizedDeliverTask> planTime;
  
  public StringValueColumn<UICenterlizedDeliverTask,DLDeliverSubjectProxy> subject;
  
  public CollectionListColumn<UICenterlizedDeliverTask,RCEmployeeProxy> performers;
  
  public CollectionListColumn<UICenterlizedDeliverTask,DLResourceProxy> resources;
  
  public StringValueColumn<UICenterlizedDeliverTask,UITaskSourceType> taskSourceType;
  
  public StringValueColumn<UICenterlizedDeliverTask,RCEmployeeProxy> operator;
  
  public StringValueColumn<UICenterlizedDeliverTask,UICenterlizedDeliverTaskStatus> status;
  
  @Inject
  private DefaultObjectsSelectorFactory defaultObjectsSelectorFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UICenterlizedDeliverTask value = new UICenterlizedDeliverTask();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sid = stringValueProviderFactory.createAsStringColumn("sid","任务编号",UICenterlizedDeliverTask.SidAccessor);
    widgetsRegistory.put("sid",sid);
    createTime = dateValueProviderFactory.createAsStringColumn("createTime","生成时间",UICenterlizedDeliverTask.CreateTimeAccessor);
    widgetsRegistory.put("createTime",createTime);
    planDate = dateValueProviderFactory.createAsStringColumn("planDate","计划日期",UICenterlizedDeliverTask.PlanDateAccessor);
    widgetsRegistory.put("planDate",planDate);
    planTime = dateValueProviderFactory.createAsTimeColumn("planTime","计划时间",UICenterlizedDeliverTask.PlanTimeAccessor);
    widgetsRegistory.put("planTime",planTime);
    subject = defaultObjectSelectorFactory.createAsDefaultColumn("subject","运送项目",UICenterlizedDeliverTask.SubjectAccessor);
    widgetsRegistory.put("subject",subject);
    performers = defaultObjectsSelectorFactory.createAsStringColumn("performers","运送人",UICenterlizedDeliverTask.PerformersAccessor);
    widgetsRegistory.put("performers",performers);
    resources = defaultObjectsSelectorFactory.createAsStringColumn("resources","资源",UICenterlizedDeliverTask.ResourcesAccessor);
    widgetsRegistory.put("resources",resources);
    taskSourceType = defaultObjectSelectorFactory.createAsDefaultColumn("taskSourceType","任务来源",UICenterlizedDeliverTask.TaskSourceTypeAccessor);
    widgetsRegistory.put("taskSourceType",taskSourceType);
    operator = defaultObjectSelectorFactory.createAsDefaultColumn("operator","操作员",UICenterlizedDeliverTask.OperatorAccessor);
    widgetsRegistory.put("operator",operator);
    status = defaultObjectSelectorFactory.createAsDefaultColumn("status","状态",UICenterlizedDeliverTask.StatusAccessor);
    widgetsRegistory.put("status",status);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UICenterlizedDeliverTask getValueAsNew() {
    UICenterlizedDeliverTask value = new UICenterlizedDeliverTask();
    value.setSid(sid.getValue());
    value.setCreateTime(createTime.getValue());
    value.setPlanDate(planDate.getValue());
    value.setPlanTime(planTime.getValue());
    value.setSubject(subject.getValue());
    value.setPerformers(performers.getValue());
    value.setResources(resources.getValue());
    value.setTaskSourceType(taskSourceType.getValue());
    value.setOperator(operator.getValue());
    value.setStatus(status.getValue());
    return value;
  }
  
  public UICenterlizedDeliverTask doGetValue() {
    
    value.setSid(sid.getValue());
    value.setCreateTime(createTime.getValue());
    value.setPlanDate(planDate.getValue());
    value.setPlanTime(planTime.getValue());
    value.setSubject(subject.getValue());
    value.setPerformers(performers.getValue());
    value.setResources(resources.getValue());
    value.setTaskSourceType(taskSourceType.getValue());
    value.setOperator(operator.getValue());
    value.setStatus(status.getValue());
    return value;
  }
  
  public UICenterlizedDeliverTask getValue(final UICenterlizedDeliverTask copyValue) {
    
    copyValue.setSid(sid.getValue());
    copyValue.setCreateTime(createTime.getValue());
    copyValue.setPlanDate(planDate.getValue());
    copyValue.setPlanTime(planTime.getValue());
    copyValue.setSubject(subject.getValue());
    copyValue.setPerformers(performers.getValue());
    copyValue.setResources(resources.getValue());
    copyValue.setTaskSourceType(taskSourceType.getValue());
    copyValue.setOperator(operator.getValue());
    copyValue.setStatus(status.getValue());
    return copyValue;
  }
  
  protected CenterlizedDeliverTaskListGrid doSetValue(final UICenterlizedDeliverTask value) {
    this.value = value;
    sid.setValue(value.getSid());
    createTime.setValue(value.getCreateTime());
    planDate.setValue(value.getPlanDate());
    planTime.setValue(value.getPlanTime());
    subject.setValue(value.getSubject());
    performers.setValue(value.getPerformers());
    resources.setValue(value.getResources());
    taskSourceType.setValue(value.getTaskSourceType());
    operator.setValue(value.getOperator());
    status.setValue(value.getStatus());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)sid,(ICanAsWidget)createTime,(ICanAsWidget)planDate,(ICanAsWidget)planTime,(ICanAsWidget)subject,(ICanAsWidget)performers,(ICanAsWidget)resources,(ICanAsWidget)taskSourceType,(ICanAsWidget)operator,(ICanAsWidget)status
    					);
  }
}
