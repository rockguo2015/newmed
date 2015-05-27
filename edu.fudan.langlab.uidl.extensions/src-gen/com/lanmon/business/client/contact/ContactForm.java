package com.lanmon.business.client.contact;

import com.google.inject.Inject;
import com.lanmon.business.client.contact.ContactCodeProvider;
import com.lanmon.business.client.widgets.ILanmonWidgetFactory;
import com.lanmon.business.shared.contact.GWTContact;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.FormComponent;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.ComboBoxSingleEntitySelector;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.DefaultObjectSelectorFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.StringValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.StringValueProviderFactory.TextItemBasedStringValueProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

public class ContactForm extends FormComponent<GWTContact> implements IInitializerSupport {
  @Inject
  private ILanmonWidgetFactory widgets;
  
  public TextItemBasedStringValueProvider name;
  
  public ComboBoxSingleEntitySelector<GWTNamedEntity> type;
  
  @Inject
  public ContactCodeProvider typeContentProvider;
  
  public TextItemBasedStringValueProvider phone;
  
  public TextItemBasedStringValueProvider email;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private GWTContact value = new GWTContact();
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();name = stringValueProviderFactory.createAsTextItemAdaptor("name","姓名");
    type = defaultObjectSelectorFactory.createAsSelectItemAdaptor("type","类型");
    _initializerSupports.add(typeContentProvider);
    type.setContentProvider(typeContentProvider);
    phone = stringValueProviderFactory.createAsTextItemAdaptor("phone","电话");
    email = stringValueProviderFactory.createAsTextItemAdaptor("email","邮件");
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
  
  protected ContactForm doSetValue(final GWTContact value) {
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
  
  public DynamicForm asWidget() {
    final Function1<Void,DynamicForm> _function = new Function1<Void,DynamicForm>() {
        public DynamicForm apply(final Void it) {
          TextItem _asWidget = ContactForm.this.name.asWidget();
          SelectItem _asWidget_1 = ContactForm.this.type.asWidget();
          TextItem _asWidget_2 = ContactForm.this.phone.asWidget();
          TextItem _asWidget_3 = ContactForm.this.email.asWidget();
          DynamicForm _DynamicForm = ContactForm.this.widgets.DynamicForm(_asWidget, _asWidget_1, _asWidget_2, _asWidget_3);
          return _DynamicForm;
        }
      };
    DynamicForm _lazy = ClientUi.<DynamicForm>lazy(this.form, _function);
    DynamicForm _form = this.form = _lazy;
    return _form;
  }
  
  private DynamicForm form;
}
