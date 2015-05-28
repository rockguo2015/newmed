package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.shared.deliver.UIPatientCheckDeliverTaskEvent;
import com.fudanmed.platform.core.web.shared.deliver.UIPatientCheckDeliverTaskEventType;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory.DateTimeColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class PatientCheckDeliverTaskEventListGrid extends GXTGridComponent<UIPatientCheckDeliverTaskEvent> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringValueColumn<UIPatientCheckDeliverTaskEvent,UIPatientCheckDeliverTaskEventType> eventType;
  
  public DateTimeColumn<UIPatientCheckDeliverTaskEvent> createTime;
  
  public StringValueColumn<UIPatientCheckDeliverTaskEvent,RCEmployeeProxy> operator;
  
  public StringColumn<UIPatientCheckDeliverTaskEvent> description;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  private UIPatientCheckDeliverTaskEvent value = new UIPatientCheckDeliverTaskEvent();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();eventType = defaultObjectSelectorFactory.createAsDefaultColumn("eventType","eventType",UIPatientCheckDeliverTaskEvent.EventTypeAccessor);
    widgetsRegistory.put("eventType",eventType);
    createTime = dateValueProviderFactory.createAsDateTimeColumn("createTime","事件时间",UIPatientCheckDeliverTaskEvent.CreateTimeAccessor);
    widgetsRegistory.put("createTime",createTime);
    operator = defaultObjectSelectorFactory.createAsDefaultColumn("operator","操作人",UIPatientCheckDeliverTaskEvent.OperatorAccessor);
    widgetsRegistory.put("operator",operator);
    description = stringValueProviderFactory.createAsStringColumn("description","事件描述",UIPatientCheckDeliverTaskEvent.DescriptionAccessor);
    widgetsRegistory.put("description",description);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIPatientCheckDeliverTaskEvent getValueAsNew() {
    UIPatientCheckDeliverTaskEvent value = new UIPatientCheckDeliverTaskEvent();
    value.setEventType(eventType.getValue());
    value.setCreateTime(createTime.getValue());
    value.setOperator(operator.getValue());
    value.setDescription(description.getValue());
    return value;
  }
  
  public UIPatientCheckDeliverTaskEvent doGetValue() {
    
    value.setEventType(eventType.getValue());
    value.setCreateTime(createTime.getValue());
    value.setOperator(operator.getValue());
    value.setDescription(description.getValue());
    return value;
  }
  
  public UIPatientCheckDeliverTaskEvent getValue(final UIPatientCheckDeliverTaskEvent copyValue) {
    
    copyValue.setEventType(eventType.getValue());
    copyValue.setCreateTime(createTime.getValue());
    copyValue.setOperator(operator.getValue());
    copyValue.setDescription(description.getValue());
    return copyValue;
  }
  
  protected PatientCheckDeliverTaskEventListGrid doSetValue(final UIPatientCheckDeliverTaskEvent value) {
    this.value = value;
    eventType.setValue(value.getEventType());
    createTime.setValue(value.getCreateTime());
    operator.setValue(value.getOperator());
    description.setValue(value.getDescription());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)eventType,(ICanAsWidget)createTime,(ICanAsWidget)operator,(ICanAsWidget)description
    					);
  }
}
