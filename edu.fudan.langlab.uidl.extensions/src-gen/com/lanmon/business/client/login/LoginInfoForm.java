package com.lanmon.business.client.login;

import com.google.inject.Inject;
import com.lanmon.business.client.widgets.ILanmonWidgetFactory;
import com.lanmon.business.shared.login.LoginInfo;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.FormComponent;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.StringValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.StringValueProviderFactory.PasswordItemBasedStringValueProvider;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.StringValueProviderFactory.TextItemBasedStringValueProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;

public class LoginInfoForm extends FormComponent<LoginInfo> implements IInitializerSupport {
  @Inject
  private ILanmonWidgetFactory widgets;
  
  public TextItemBasedStringValueProvider userid;
  
  public PasswordItemBasedStringValueProvider passwd;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private LoginInfo value = new LoginInfo();
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();userid = stringValueProviderFactory.createAsTextItemAdaptor("userid","userid");
    passwd = stringValueProviderFactory.createAsPasswordItemAdaptor("passwd","passwd");
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, handler);
  }
  
  public LoginInfo getValueAsNew() {
    LoginInfo value = new LoginInfo();
    value.setUserid(userid.getValue());
    value.setPasswd(passwd.getValue());
    return value;
  }
  
  public LoginInfo doGetValue() {
    
    value.setUserid(userid.getValue());
    value.setPasswd(passwd.getValue());
    return value;
  }
  
  public LoginInfo getValue(final LoginInfo copyValue) {
    
    copyValue.setUserid(userid.getValue());
    copyValue.setPasswd(passwd.getValue());
    return copyValue;
  }
  
  protected LoginInfoForm doSetValue(final LoginInfo value) {
    this.value = value;
    userid.setValue(value.getUserid());
    passwd.setValue(value.getPasswd());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)userid,(ICanAsWidget)passwd
    					);
  }
}
