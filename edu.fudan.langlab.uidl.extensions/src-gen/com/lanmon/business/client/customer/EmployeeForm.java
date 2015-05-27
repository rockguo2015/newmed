package com.lanmon.business.client.customer;

import com.google.inject.Inject;
import com.lanmon.business.client.customer.AllEmployeesContentProvider;
import com.lanmon.business.client.customer.GWTRoleContentProvider;
import com.lanmon.business.client.widgets.ILanmonWidgetFactory;
import com.lanmon.business.shared.customer.GWTEmployee;
import com.lanmon.business.shared.customer.GWTRole;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.FormComponent;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.ComboBoxSingleEntitySelector;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.DefaultObjectSelectorFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.DefaultObjectsSelectorFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.DefaultObjectsSelectorFactory.CheckboxMultiEntitySelector;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.IntegerValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.IntegerValueProviderFactory.IntegerItemBasedIntegerValueProvider;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.StringValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.StringValueProviderFactory.PasswordItemBasedStringValueProvider;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.StringValueProviderFactory.TextItemBasedStringValueProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.shared.GWTNamedEntity;

public class EmployeeForm extends FormComponent<GWTEmployee> implements IInitializerSupport {
  @Inject
  private ILanmonWidgetFactory widgets;
  
  public TextItemBasedStringValueProvider name;
  
  public ComboBoxSingleEntitySelector<GWTNamedEntity> directManager;
  
  @Inject
  public AllEmployeesContentProvider directManagerContentProvider;
  
  public TextItemBasedStringValueProvider userid;
  
  public PasswordItemBasedStringValueProvider passwd;
  
  public PasswordItemBasedStringValueProvider passwdConfirm;
  
  public CheckboxMultiEntitySelector<GWTRole> roles;
  
  @Inject
  public GWTRoleContentProvider rolesContentProvider;
  
  public IntegerItemBasedIntegerValueProvider phoneCountExpected;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private DefaultObjectsSelectorFactory defaultObjectsSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  private GWTEmployee value = new GWTEmployee();
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();name = stringValueProviderFactory.createAsTextItemAdaptor("name","姓名");
    directManager = defaultObjectSelectorFactory.createAsSelectItemAdaptor("directManager","上级主管");
    _initializerSupports.add(directManagerContentProvider);
    directManager.setContentProvider(directManagerContentProvider);
    userid = stringValueProviderFactory.createAsTextItemAdaptor("userid","用户名");
    passwd = stringValueProviderFactory.createAsPasswordItemAdaptor("passwd","密码");
    passwdConfirm = stringValueProviderFactory.createAsPasswordItemAdaptor("passwdConfirm","确认密码");
    roles = defaultObjectsSelectorFactory.createDefaultValueProvider("roles","角色");
    roles.setContentProvider(rolesContentProvider);
    phoneCountExpected = integerValueProviderFactory.createAsIntegerItemAdaptor("phoneCountExpected","额定每日电话数");
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, handler);
  }
  
  public GWTEmployee getValueAsNew() {
    GWTEmployee value = new GWTEmployee();
    value.setName(name.getValue());
    value.setDirectManager(directManager.getValue());
    value.setUserid(userid.getValue());
    value.setPasswd(passwd.getValue());
    value.setPasswdConfirm(passwdConfirm.getValue());
    value.setRoles(roles.getValue());
    value.setPhoneCountExpected(phoneCountExpected.getValue());
    return value;
  }
  
  public GWTEmployee doGetValue() {
    
    value.setName(name.getValue());
    value.setDirectManager(directManager.getValue());
    value.setUserid(userid.getValue());
    value.setPasswd(passwd.getValue());
    value.setPasswdConfirm(passwdConfirm.getValue());
    value.setRoles(roles.getValue());
    value.setPhoneCountExpected(phoneCountExpected.getValue());
    return value;
  }
  
  public GWTEmployee getValue(final GWTEmployee copyValue) {
    
    copyValue.setName(name.getValue());
    copyValue.setDirectManager(directManager.getValue());
    copyValue.setUserid(userid.getValue());
    copyValue.setPasswd(passwd.getValue());
    copyValue.setPasswdConfirm(passwdConfirm.getValue());
    copyValue.setRoles(roles.getValue());
    copyValue.setPhoneCountExpected(phoneCountExpected.getValue());
    return copyValue;
  }
  
  protected EmployeeForm doSetValue(final GWTEmployee value) {
    this.value = value;
    name.setValue(value.getName());
    directManager.setValue(value.getDirectManager());
    userid.setValue(value.getUserid());
    passwd.setValue(value.getPasswd());
    passwdConfirm.setValue(value.getPasswdConfirm());
    roles.setValue(value.getRoles());
    phoneCountExpected.setValue(value.getPhoneCountExpected());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)name,(ICanAsWidget)directManager,(ICanAsWidget)userid,(ICanAsWidget)passwd,(ICanAsWidget)passwdConfirm,(ICanAsWidget)roles,(ICanAsWidget)phoneCountExpected
    					);
  }
}
