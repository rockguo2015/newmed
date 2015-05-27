package com.lanmon.business.client.message;

import com.google.inject.Inject;
import com.lanmon.business.client.widgets.ILanmonWidgetFactory;
import com.lanmon.business.shared.message.GWTMessage;
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
import com.uniquesoft.gwt.shared.GWTNamedEntity;

public class MessageList extends ListViewComponent<GWTMessage> implements IInitializerSupport {
  @Inject
  private ILanmonWidgetFactory widgets;
  
  public StringListViewItem title;
  
  public DateListViewItem triggerDate;
  
  public ListViewItem<GWTNamedEntity> customer;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  private GWTMessage value = new GWTMessage();
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();title = stringValueProviderFactory.createAsListGridField("title","消息内容");
    triggerDate = dateValueProviderFactory.createAsListGridField("triggerDate","消息生成日期");
    customer = defaultObjectSelectorFactory.createAsListGridItem("customer","相关客户");
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, handler);
  }
  
  public GWTMessage getValueAsNew() {
    GWTMessage value = new GWTMessage();
    value.setTitle(title.getValue());
    value.setTriggerDate(triggerDate.getValue());
    value.setCustomer(customer.getValue());
    return value;
  }
  
  public GWTMessage doGetValue() {
    
    value.setTitle(title.getValue());
    value.setTriggerDate(triggerDate.getValue());
    value.setCustomer(customer.getValue());
    return value;
  }
  
  public GWTMessage getValue(final GWTMessage copyValue) {
    
    copyValue.setTitle(title.getValue());
    copyValue.setTriggerDate(triggerDate.getValue());
    copyValue.setCustomer(customer.getValue());
    return copyValue;
  }
  
  protected MessageList doSetValue(final GWTMessage value) {
    this.value = value;
    title.setValue(value.getTitle());
    triggerDate.setValue(value.getTriggerDate());
    customer.setValue(value.getCustomer());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)title,(ICanAsWidget)triggerDate,(ICanAsWidget)customer
    					);
  }
}
