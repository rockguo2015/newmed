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

public class CustomerList extends ListViewComponent<GWTCustomer> implements IInitializerSupport {
  @Inject
  private ILanmonWidgetFactory widgets;
  
  public StringListViewItem name;
  
  public StringListViewItem phone;
  
  public StringListViewItem addressInfo;
  
  public StringListViewItem postcode;
  
  public StringListViewItem contractor;
  
  public ListViewItem<GWTCustomerStatus> status;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private GWTCustomer value = new GWTCustomer();
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();name = stringValueProviderFactory.createAsListGridField("name","客户名");
    phone = stringValueProviderFactory.createAsListGridField("phone","联系电话");
    addressInfo = stringValueProviderFactory.createAsListGridField("addressInfo","地址");
    postcode = stringValueProviderFactory.createAsListGridField("postcode","邮编");
    contractor = stringValueProviderFactory.createAsListGridField("contractor","联系人");
    status = defaultObjectSelectorFactory.createAsListGridItem("status","客户状态");
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, handler);
  }
  
  public GWTCustomer getValueAsNew() {
    GWTCustomer value = new GWTCustomer();
    value.setName(name.getValue());
    value.setPhone(phone.getValue());
    value.setAddressInfo(addressInfo.getValue());
    value.setPostcode(postcode.getValue());
    value.setContractor(contractor.getValue());
    value.setStatus(status.getValue());
    return value;
  }
  
  public GWTCustomer doGetValue() {
    
    value.setName(name.getValue());
    value.setPhone(phone.getValue());
    value.setAddressInfo(addressInfo.getValue());
    value.setPostcode(postcode.getValue());
    value.setContractor(contractor.getValue());
    value.setStatus(status.getValue());
    return value;
  }
  
  public GWTCustomer getValue(final GWTCustomer copyValue) {
    
    copyValue.setName(name.getValue());
    copyValue.setPhone(phone.getValue());
    copyValue.setAddressInfo(addressInfo.getValue());
    copyValue.setPostcode(postcode.getValue());
    copyValue.setContractor(contractor.getValue());
    copyValue.setStatus(status.getValue());
    return copyValue;
  }
  
  protected CustomerList doSetValue(final GWTCustomer value) {
    this.value = value;
    name.setValue(value.getName());
    phone.setValue(value.getPhone());
    addressInfo.setValue(value.getAddressInfo());
    postcode.setValue(value.getPostcode());
    contractor.setValue(value.getContractor());
    status.setValue(value.getStatus());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)name,(ICanAsWidget)phone,(ICanAsWidget)addressInfo,(ICanAsWidget)postcode,(ICanAsWidget)contractor,(ICanAsWidget)status
    					);
  }
}
