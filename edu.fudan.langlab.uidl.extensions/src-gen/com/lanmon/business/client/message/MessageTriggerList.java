package com.lanmon.business.client.message;

import com.google.inject.Inject;
import com.lanmon.business.client.widgets.ILanmonWidgetFactory;
import com.lanmon.business.shared.message.GWTMessageTrigger;
import com.lanmon.business.shared.message.GWTTriggerState;
import com.lanmon.business.shared.message.TriggerType;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.ListViewComponent;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.DateValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.DateValueProviderFactory.DateListViewItem;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.DefaultObjectSelectorFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.StringValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.StringValueProviderFactory.StringListViewItem;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.tiem.ListViewItem;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;

public class MessageTriggerList extends ListViewComponent<GWTMessageTrigger> implements IInitializerSupport {
  @Inject
  private ILanmonWidgetFactory widgets;
  
  public ListViewItem<TriggerType> triggerType;
  
  public StringListViewItem summary;
  
  public ListViewItem<GWTTriggerState> state;
  
  public DateListViewItem triggerDate;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private GWTMessageTrigger value = new GWTMessageTrigger();
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();triggerType = defaultObjectSelectorFactory.createAsListGridItem("triggerType","提醒类型");
    summary = stringValueProviderFactory.createAsListGridField("summary","提醒内容");
    state = defaultObjectSelectorFactory.createAsListGridItem("state","提醒状态");
    triggerDate = dateValueProviderFactory.createAsListGridField("triggerDate","提醒时间");
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, handler);
  }
  
  public GWTMessageTrigger getValueAsNew() {
    GWTMessageTrigger value = new GWTMessageTrigger();
    value.setTriggerType(triggerType.getValue());
    value.setSummary(summary.getValue());
    value.setState(state.getValue());
    value.setTriggerDate(triggerDate.getValue());
    return value;
  }
  
  public GWTMessageTrigger doGetValue() {
    
    value.setTriggerType(triggerType.getValue());
    value.setSummary(summary.getValue());
    value.setState(state.getValue());
    value.setTriggerDate(triggerDate.getValue());
    return value;
  }
  
  public GWTMessageTrigger getValue(final GWTMessageTrigger copyValue) {
    
    copyValue.setTriggerType(triggerType.getValue());
    copyValue.setSummary(summary.getValue());
    copyValue.setState(state.getValue());
    copyValue.setTriggerDate(triggerDate.getValue());
    return copyValue;
  }
  
  protected MessageTriggerList doSetValue(final GWTMessageTrigger value) {
    this.value = value;
    triggerType.setValue(value.getTriggerType());
    summary.setValue(value.getSummary());
    state.setValue(value.getState());
    triggerDate.setValue(value.getTriggerDate());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)triggerType,(ICanAsWidget)summary,(ICanAsWidget)state,(ICanAsWidget)triggerDate
    					);
  }
}
