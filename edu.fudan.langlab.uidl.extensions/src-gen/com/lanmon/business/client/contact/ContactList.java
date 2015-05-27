package com.lanmon.business.client.contact;

import com.google.inject.Inject;
import com.lanmon.business.client.widgets.ILanmonWidgetFactory;
import com.lanmon.business.shared.contact.GWTContact;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.ListViewComponent;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.DefaultObjectSelectorFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.StringValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.StringValueProviderFactory.StringListViewItem;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.tiem.ListViewItem;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.shared.GWTNamedEntity;

public class ContactList extends ListViewComponent<GWTContact> implements IInitializerSupport {
  @Inject
  private ILanmonWidgetFactory widgets;
  
  public StringListViewItem name;
  
  public ListViewItem<GWTNamedEntity> type;
  
  public StringListViewItem phone;
  
  public StringListViewItem email;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private GWTContact value = new GWTContact();
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();name = stringValueProviderFactory.createAsListGridField("name","姓名");
    type = defaultObjectSelectorFactory.createAsListGridItem("type","类型");
    phone = stringValueProviderFactory.createAsListGridField("phone","电话");
    email = stringValueProviderFactory.createAsListGridField("email","邮件");
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, handler);
  }
  
  public GWTContact getValueAsNew() {
    GWTContact value = new GWTContact();
    value.setName(name.getValue());
    value.setType(type.getValue());
    value.setPhone(phone.getValue());
    value.setEmail(email.getValue());
    return value;
  }
  
  public GWTContact doGetValue() {
    
    value.setName(name.getValue());
    value.setType(type.getValue());
    value.setPhone(phone.getValue());
    value.setEmail(email.getValue());
    return value;
  }
  
  public GWTContact getValue(final GWTContact copyValue) {
    
    copyValue.setName(name.getValue());
    copyValue.setType(type.getValue());
    copyValue.setPhone(phone.getValue());
    copyValue.setEmail(email.getValue());
    return copyValue;
  }
  
  protected ContactList doSetValue(final GWTContact value) {
    this.value = value;
    name.setValue(value.getName());
    type.setValue(value.getType());
    phone.setValue(value.getPhone());
    email.setValue(value.getEmail());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)name,(ICanAsWidget)type,(ICanAsWidget)phone,(ICanAsWidget)email
    					);
  }
}
