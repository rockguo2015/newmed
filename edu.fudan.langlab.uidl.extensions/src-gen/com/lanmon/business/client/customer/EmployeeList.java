package com.lanmon.business.client.customer;

import com.google.inject.Inject;
import com.lanmon.business.client.widgets.ILanmonWidgetFactory;
import com.lanmon.business.shared.customer.GWTEmployee;
import com.lanmon.business.shared.customer.GWTRole;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.ListViewComponent;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.DefaultObjectSelectorFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.DefaultObjectsSelectorFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.IntegerValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.IntegerValueProviderFactory.IntegerListViewItem;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.StringValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.StringValueProviderFactory.StringListViewItem;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.tiem.CollectionListViewItem;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.listgrid.factory.tiem.ListViewItem;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.shared.GWTNamedEntity;

public class EmployeeList extends ListViewComponent<GWTEmployee> implements IInitializerSupport {
  @Inject
  private ILanmonWidgetFactory widgets;
  
  public StringListViewItem name;
  
  public ListViewItem<GWTNamedEntity> directManager;
  
  public StringListViewItem userid;
  
  public IntegerListViewItem phoneCountExpected;
  
  public CollectionListViewItem<GWTRole> roles;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private DefaultObjectsSelectorFactory defaultObjectsSelectorFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  private GWTEmployee value = new GWTEmployee();
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();name = stringValueProviderFactory.createAsListGridField("name","姓名");
    directManager = defaultObjectSelectorFactory.createAsListGridItem("directManager","上级主管");
    userid = stringValueProviderFactory.createAsListGridField("userid","用户名");
    phoneCountExpected = integerValueProviderFactory.createAsListGridField("phoneCountExpected","额定每日电话数");
    roles = defaultObjectsSelectorFactory.createAsListGridField("roles","角色");
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, handler);
  }
  
  public GWTEmployee getValueAsNew() {
    GWTEmployee value = new GWTEmployee();
    value.setName(name.getValue());
    value.setDirectManager(directManager.getValue());
    value.setUserid(userid.getValue());
    value.setPhoneCountExpected(phoneCountExpected.getValue());
    return value;
  }
  
  public GWTEmployee doGetValue() {
    
    value.setName(name.getValue());
    value.setDirectManager(directManager.getValue());
    value.setUserid(userid.getValue());
    value.setPhoneCountExpected(phoneCountExpected.getValue());
    return value;
  }
  
  public GWTEmployee getValue(final GWTEmployee copyValue) {
    
    copyValue.setName(name.getValue());
    copyValue.setDirectManager(directManager.getValue());
    copyValue.setUserid(userid.getValue());
    copyValue.setPhoneCountExpected(phoneCountExpected.getValue());
    return copyValue;
  }
  
  protected EmployeeList doSetValue(final GWTEmployee value) {
    this.value = value;
    name.setValue(value.getName());
    directManager.setValue(value.getDirectManager());
    userid.setValue(value.getUserid());
    phoneCountExpected.setValue(value.getPhoneCountExpected());
    roles.setValue(value.getRoles());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)name,(ICanAsWidget)directManager,(ICanAsWidget)userid,(ICanAsWidget)phoneCountExpected,(ICanAsWidget)roles
    					);
  }
}
