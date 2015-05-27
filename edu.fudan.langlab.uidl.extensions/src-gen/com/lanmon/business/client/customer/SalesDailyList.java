package com.lanmon.business.client.customer;

import com.google.inject.Inject;
import com.lanmon.business.client.widgets.ILanmonWidgetFactory;
import com.lanmon.business.shared.customer.GWTDaily;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.ListViewComponent;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.DateValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.DateValueProviderFactory.DateListViewItem;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.IntegerValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.IntegerValueProviderFactory.IntegerListViewItem;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.StringValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.StringValueProviderFactory.StringListViewItem;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;

public class SalesDailyList extends ListViewComponent<GWTDaily> implements IInitializerSupport {
  @Inject
  private ILanmonWidgetFactory widgets;
  
  public DateListViewItem date;
  
  public IntegerListViewItem phoneCount;
  
  public IntegerListViewItem onsiteCount;
  
  public IntegerListViewItem createCustomerCount;
  
  public StringListViewItem note;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  private GWTDaily value = new GWTDaily();
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();date = dateValueProviderFactory.createAsListGridField("date","日期");
    phoneCount = integerValueProviderFactory.createAsListGridField("phoneCount","电话联络数");
    onsiteCount = integerValueProviderFactory.createAsListGridField("onsiteCount","上门客户数");
    createCustomerCount = integerValueProviderFactory.createAsListGridField("createCustomerCount","登录客户数");
    note = stringValueProviderFactory.createAsListGridField("note","备注");
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, handler);
  }
  
  public GWTDaily getValueAsNew() {
    GWTDaily value = new GWTDaily();
    value.setDate(date.getValue());
    value.setPhoneCount(phoneCount.getValue());
    value.setOnsiteCount(onsiteCount.getValue());
    value.setCreateCustomerCount(createCustomerCount.getValue());
    value.setNote(note.getValue());
    return value;
  }
  
  public GWTDaily doGetValue() {
    
    value.setDate(date.getValue());
    value.setPhoneCount(phoneCount.getValue());
    value.setOnsiteCount(onsiteCount.getValue());
    value.setCreateCustomerCount(createCustomerCount.getValue());
    value.setNote(note.getValue());
    return value;
  }
  
  public GWTDaily getValue(final GWTDaily copyValue) {
    
    copyValue.setDate(date.getValue());
    copyValue.setPhoneCount(phoneCount.getValue());
    copyValue.setOnsiteCount(onsiteCount.getValue());
    copyValue.setCreateCustomerCount(createCustomerCount.getValue());
    copyValue.setNote(note.getValue());
    return copyValue;
  }
  
  protected SalesDailyList doSetValue(final GWTDaily value) {
    this.value = value;
    date.setValue(value.getDate());
    phoneCount.setValue(value.getPhoneCount());
    onsiteCount.setValue(value.getOnsiteCount());
    createCustomerCount.setValue(value.getCreateCustomerCount());
    note.setValue(value.getNote());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)date,(ICanAsWidget)phoneCount,(ICanAsWidget)onsiteCount,(ICanAsWidget)createCustomerCount,(ICanAsWidget)note
    					);
  }
}
