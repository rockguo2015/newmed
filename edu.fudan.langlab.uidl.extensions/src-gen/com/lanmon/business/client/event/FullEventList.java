package com.lanmon.business.client.event;

import com.google.inject.Inject;
import com.lanmon.business.client.widgets.ILanmonWidgetFactory;
import com.lanmon.business.shared.event.GWTEvent;
import com.lanmon.business.shared.event.GWTEventType;
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

public class FullEventList extends ListViewComponent<GWTEvent> implements IInitializerSupport {
  @Inject
  private ILanmonWidgetFactory widgets;
  
  public ListViewItem<GWTEventType> type;
  
  public StringListViewItem note;
  
  public DateListViewItem eventDate;
  
  public ListViewItem<GWTNamedEntity> eventAuthor;
  
  public ListViewItem<GWTNamedEntity> customer;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private GWTEvent value = new GWTEvent();
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();type = defaultObjectSelectorFactory.createAsListGridItem("type","类型");
    note = stringValueProviderFactory.createAsListGridField("note","事件信息");
    eventDate = dateValueProviderFactory.createAsListGridField("eventDate","日期");
    eventAuthor = defaultObjectSelectorFactory.createAsListGridItem("eventAuthor","记录人");
    customer = defaultObjectSelectorFactory.createAsListGridItem("customer","客户");
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, handler);
  }
  
  public GWTEvent getValueAsNew() {
    GWTEvent value = new GWTEvent();
    value.setType(type.getValue());
    value.setNote(note.getValue());
    value.setEventDate(eventDate.getValue());
    value.setEventAuthor(eventAuthor.getValue());
    value.setCustomer(customer.getValue());
    return value;
  }
  
  public GWTEvent doGetValue() {
    
    value.setType(type.getValue());
    value.setNote(note.getValue());
    value.setEventDate(eventDate.getValue());
    value.setEventAuthor(eventAuthor.getValue());
    value.setCustomer(customer.getValue());
    return value;
  }
  
  public GWTEvent getValue(final GWTEvent copyValue) {
    
    copyValue.setType(type.getValue());
    copyValue.setNote(note.getValue());
    copyValue.setEventDate(eventDate.getValue());
    copyValue.setEventAuthor(eventAuthor.getValue());
    copyValue.setCustomer(customer.getValue());
    return copyValue;
  }
  
  protected FullEventList doSetValue(final GWTEvent value) {
    this.value = value;
    type.setValue(value.getType());
    note.setValue(value.getNote());
    eventDate.setValue(value.getEventDate());
    eventAuthor.setValue(value.getEventAuthor());
    customer.setValue(value.getCustomer());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)type,(ICanAsWidget)note,(ICanAsWidget)eventDate,(ICanAsWidget)eventAuthor,(ICanAsWidget)customer
    					);
  }
}
