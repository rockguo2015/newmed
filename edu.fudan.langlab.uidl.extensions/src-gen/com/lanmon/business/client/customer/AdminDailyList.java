package com.lanmon.business.client.customer;

import com.google.inject.Inject;
import com.lanmon.business.client.widgets.ILanmonWidgetFactory;
import com.lanmon.business.shared.customer.GWTDaily;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.ListViewComponent;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.DateValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.DateValueProviderFactory.DateListViewItem;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.DefaultObjectSelectorFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.IntegerValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.IntegerValueProviderFactory.IntegerListViewItem;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.StringValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.StringValueProviderFactory.StringListViewItem;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.tiem.ListViewItem;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.shared.GWTNamedEntity;

public class AdminDailyList extends ListViewComponent<GWTDaily> implements IInitializerSupport {
  @Inject
  private ILanmonWidgetFactory widgets;
  
  public ListViewItem<GWTNamedEntity> employee;
  
  public DateListViewItem date;
  
  public IntegerListViewItem phoneCount;
  
  public IntegerListViewItem onsiteCount;
  
  public IntegerListViewItem createCustomerCount;
  
  public StringListViewItem note;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  private GWTDaily value = new GWTDaily();
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();employee = defaultObjectSelectorFactory.createAsListGridItem("employee","员工");
    date = dateValueProviderFactory.createAsListGridField("date","日期");
    phoneCount = integerValueProviderFactory.createAsListGridField("phoneCount","电话联络数");
    onsiteCount = integerValueProviderFactory.createAsListGridField("onsiteCount","上门客户数");
    createCustomerCount = integerValueProviderFactory.createAsListGridField("createCustomerCount","登录客户数");
    note = stringValueProviderFactory.createAsListGridField("note","备注");
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, handler);
  }
  
  public GWTDaily getValueAsNew() {
    GWTDaily value = new GWTDaily();
    value.setEmployee(employee.getValue());
    value.setDate(date.getValue());
    value.setPhoneCount(phoneCount.getValue());
    value.setOnsiteCount(onsiteCount.getValue());
    value.setCreateCustomerCount(createCustomerCount.getValue());
    value.setNote(note.getValue());
    return value;
  }
  
  public GWTDaily doGetValue() {
    
    value.setEmployee(employee.getValue());
    value.setDate(date.getValue());
    value.setPhoneCount(phoneCount.getValue());
    value.setOnsiteCount(onsiteCount.getValue());
    value.setCreateCustomerCount(createCustomerCount.getValue());
    value.setNote(note.getValue());
    return value;
  }
  
  public GWTDaily getValue(final GWTDaily copyValue) {
    
    copyValue.setEmployee(employee.getValue());
    copyValue.setDate(date.getValue());
    copyValue.setPhoneCount(phoneCount.getValue());
    copyValue.setOnsiteCount(onsiteCount.getValue());
    copyValue.setCreateCustomerCount(createCustomerCount.getValue());
    copyValue.setNote(note.getValue());
    return copyValue;
  }
  
  protected AdminDailyList doSetValue(final GWTDaily value) {
    this.value = value;
    employee.setValue(value.getEmployee());
    date.setValue(value.getDate());
    phoneCount.setValue(value.getPhoneCount());
    onsiteCount.setValue(value.getOnsiteCount());
    createCustomerCount.setValue(value.getCreateCustomerCount());
    note.setValue(value.getNote());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)employee,(ICanAsWidget)date,(ICanAsWidget)phoneCount,(ICanAsWidget)onsiteCount,(ICanAsWidget)createCustomerCount,(ICanAsWidget)note
    					);
  }
}
