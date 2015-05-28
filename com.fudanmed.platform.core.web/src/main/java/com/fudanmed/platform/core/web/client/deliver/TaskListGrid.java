package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.shared.deliver.UITask;
import com.fudanmed.platform.core.web.shared.deliver.UITaskSourceType;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory.DateColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectsSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectsSelectorFactory.CollectionListColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class TaskListGrid extends GXTGridComponent<UITask> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UITask> sid;
  
  public DateColumn<UITask> createTime;
  
  public CollectionListColumn<UITask,RCEmployeeProxy> performers;
  
  public StringValueColumn<UITask,RCEmployeeProxy> operator;
  
  public StringValueColumn<UITask,UITaskSourceType> taskSource;
  
  @Inject
  private DefaultObjectsSelectorFactory defaultObjectsSelectorFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UITask value = new UITask();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sid = stringValueProviderFactory.createAsStringColumn("sid","任务编号",UITask.SidAccessor);
    widgetsRegistory.put("sid",sid);
    createTime = dateValueProviderFactory.createAsStringColumn("createTime","生成时间",UITask.CreateTimeAccessor);
    widgetsRegistory.put("createTime",createTime);
    performers = defaultObjectsSelectorFactory.createAsStringColumn("performers","运送人",UITask.PerformersAccessor);
    widgetsRegistory.put("performers",performers);
    operator = defaultObjectSelectorFactory.createAsDefaultColumn("operator","操作员",UITask.OperatorAccessor);
    widgetsRegistory.put("operator",operator);
    taskSource = defaultObjectSelectorFactory.createAsDefaultColumn("taskSource","任务来源",UITask.TaskSourceAccessor);
    widgetsRegistory.put("taskSource",taskSource);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UITask getValueAsNew() {
    UITask value = new UITask();
    value.setSid(sid.getValue());
    value.setCreateTime(createTime.getValue());
    value.setPerformers(performers.getValue());
    value.setOperator(operator.getValue());
    value.setTaskSource(taskSource.getValue());
    return value;
  }
  
  public UITask doGetValue() {
    
    value.setSid(sid.getValue());
    value.setCreateTime(createTime.getValue());
    value.setPerformers(performers.getValue());
    value.setOperator(operator.getValue());
    value.setTaskSource(taskSource.getValue());
    return value;
  }
  
  public UITask getValue(final UITask copyValue) {
    
    copyValue.setSid(sid.getValue());
    copyValue.setCreateTime(createTime.getValue());
    copyValue.setPerformers(performers.getValue());
    copyValue.setOperator(operator.getValue());
    copyValue.setTaskSource(taskSource.getValue());
    return copyValue;
  }
  
  protected TaskListGrid doSetValue(final UITask value) {
    this.value = value;
    sid.setValue(value.getSid());
    createTime.setValue(value.getCreateTime());
    performers.setValue(value.getPerformers());
    operator.setValue(value.getOperator());
    taskSource.setValue(value.getTaskSource());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)sid,(ICanAsWidget)createTime,(ICanAsWidget)performers,(ICanAsWidget)operator,(ICanAsWidget)taskSource
    					);
  }
}
