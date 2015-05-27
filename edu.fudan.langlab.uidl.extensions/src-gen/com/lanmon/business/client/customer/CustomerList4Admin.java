package com.lanmon.business.client.customer;

import com.google.inject.Inject;
import com.lanmon.business.client.widgets.ILanmonWidgetFactory;
import com.lanmon.business.shared.customer.GWTCustomer;
import com.lanmon.business.shared.customer.GWTCustomerStatus;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.ListViewComponent;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.DefaultObjectSelectorFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.StringValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.StringValueProviderFactory.StringListViewItem;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.tiem.ListViewItem;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.shared.GWTNamedEntity;

public class CustomerList4Admin extends ListViewComponent<GWTCustomer> implements IInitializerSupport {
  @Inject
  private ILanmonWidgetFactory widgets;
  
  public StringListViewItem name;
  
  public StringListViewItem phone;
  
  public ListViewItem<GWTCustomerStatus> status;
  
  public ListViewItem<GWTNamedEntity> phoneSaleOwner;
  
  public ListViewItem<GWTNamedEntity> onsiteSaleOwner;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private GWTCustomer value = new GWTCustomer();
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();name = stringValueProviderFactory.createAsListGridField("name","客户名");
    phone = stringValueProviderFactory.createAsListGridField("phone","联系电话");
    status = defaultObjectSelectorFactory.createAsListGridItem("status","客户状态");
    phoneSaleOwner = defaultObjectSelectorFactory.createAsListGridItem("phoneSaleOwner","电话销售");
    onsiteSaleOwner = defaultObjectSelectorFactory.createAsListGridItem("onsiteSaleOwner","上门商务");
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, handler);
  }
  
  public GWTCustomer getValueAsNew() {
    GWTCustomer value = new GWTCustomer();
    value.setName(name.getValue());
    value.setPhone(phone.getValue());
    value.setStatus(status.getValue());
    value.setPhoneSaleOwner(phoneSaleOwner.getValue());
    value.setOnsiteSaleOwner(onsiteSaleOwner.getValue());
    return value;
  }
  
  public GWTCustomer doGetValue() {
    
    value.setName(name.getValue());
    value.setPhone(phone.getValue());
    value.setStatus(status.getValue());
    value.setPhoneSaleOwner(phoneSaleOwner.getValue());
    value.setOnsiteSaleOwner(onsiteSaleOwner.getValue());
    return value;
  }
  
  public GWTCustomer getValue(final GWTCustomer copyValue) {
    
    copyValue.setName(name.getValue());
    copyValue.setPhone(phone.getValue());
    copyValue.setStatus(status.getValue());
    copyValue.setPhoneSaleOwner(phoneSaleOwner.getValue());
    copyValue.setOnsiteSaleOwner(onsiteSaleOwner.getValue());
    return copyValue;
  }
  
  protected CustomerList4Admin doSetValue(final GWTCustomer value) {
    this.value = value;
    name.setValue(value.getName());
    phone.setValue(value.getPhone());
    status.setValue(value.getStatus());
    phoneSaleOwner.setValue(value.getPhoneSaleOwner());
    onsiteSaleOwner.setValue(value.getOnsiteSaleOwner());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)name,(ICanAsWidget)phone,(ICanAsWidget)status,(ICanAsWidget)phoneSaleOwner,(ICanAsWidget)onsiteSaleOwner
    					);
  }
}
