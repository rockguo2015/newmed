package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverSubjectProxy;
import com.fudanmed.platform.core.deliver.proxy.DLResourceProxy;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask;
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
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class CenterlizedDeliverTaskSimpleListGrid extends GXTGridComponent<UICenterlizedDeliverTask> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public DateColumn<UICenterlizedDeliverTask> createTime;
  
  public DateColumn<UICenterlizedDeliverTask> planDate;
  
  public TimeColumn<UICenterlizedDeliverTask> planTime;
  
  public StringValueColumn<UICenterlizedDeliverTask,DLDeliverSubjectProxy> subject;
  
  public CollectionListColumn<UICenterlizedDeliverTask,DLResourceProxy> resources;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private DefaultObjectsSelectorFactory defaultObjectsSelectorFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  private UICenterlizedDeliverTask value = new UICenterlizedDeliverTask();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();createTime = dateValueProviderFactory.createAsStringColumn("createTime","生成时间",UICenterlizedDeliverTask.CreateTimeAccessor);
    widgetsRegistory.put("createTime",createTime);
    planDate = dateValueProviderFactory.createAsStringColumn("planDate","计划日期",UICenterlizedDeliverTask.PlanDateAccessor);
    widgetsRegistory.put("planDate",planDate);
    planTime = dateValueProviderFactory.createAsTimeColumn("planTime","计划时间",UICenterlizedDeliverTask.PlanTimeAccessor);
    widgetsRegistory.put("planTime",planTime);
    subject = defaultObjectSelectorFactory.createAsDefaultColumn("subject","运送项目",UICenterlizedDeliverTask.SubjectAccessor);
    widgetsRegistory.put("subject",subject);
    resources = defaultObjectsSelectorFactory.createAsStringColumn("resources","资源",UICenterlizedDeliverTask.ResourcesAccessor);
    widgetsRegistory.put("resources",resources);
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
    value.setCreateTime(createTime.getValue());
    value.setPlanDate(planDate.getValue());
    value.setPlanTime(planTime.getValue());
    value.setSubject(subject.getValue());
    value.setResources(resources.getValue());
    return value;
  }
  
  public UICenterlizedDeliverTask doGetValue() {
    
    value.setCreateTime(createTime.getValue());
    value.setPlanDate(planDate.getValue());
    value.setPlanTime(planTime.getValue());
    value.setSubject(subject.getValue());
    value.setResources(resources.getValue());
    return value;
  }
  
  public UICenterlizedDeliverTask getValue(final UICenterlizedDeliverTask copyValue) {
    
    copyValue.setCreateTime(createTime.getValue());
    copyValue.setPlanDate(planDate.getValue());
    copyValue.setPlanTime(planTime.getValue());
    copyValue.setSubject(subject.getValue());
    copyValue.setResources(resources.getValue());
    return copyValue;
  }
  
  protected CenterlizedDeliverTaskSimpleListGrid doSetValue(final UICenterlizedDeliverTask value) {
    this.value = value;
    createTime.setValue(value.getCreateTime());
    planDate.setValue(value.getPlanDate());
    planTime.setValue(value.getPlanTime());
    subject.setValue(value.getSubject());
    resources.setValue(value.getResources());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)createTime,(ICanAsWidget)planDate,(ICanAsWidget)planTime,(ICanAsWidget)subject,(ICanAsWidget)resources
    					);
  }
}
