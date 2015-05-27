package com.lanmon.business.client.customer;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.lanmon.business.client.customer.AllEmployees;
import com.lanmon.business.client.customer.GWTCustomerStatusContentProvider;
import com.lanmon.business.client.widgets.ILanmonWidgetFactory;
import com.lanmon.business.shared.customer.GWTCustomerStatus;
import com.lanmon.business.shared.customer.GWTNormalCustomerCriteria4Admin;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.FormComponent;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.BooleanValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.BooleanValueProviderFactory.CheckBoxBooleanValueSelector;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.ComboBoxSingleEntitySelector;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.DefaultObjectSelectorFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.StringValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.StringValueProviderFactory.EscapedTextItemBasedStringValueProvider;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.StringValueProviderFactory.TextItemBasedStringValueProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class NormalCustomerCriteriaForm4Admin extends FormComponent<GWTNormalCustomerCriteria4Admin> implements IInitializerSupport {
  @Inject
  private ILanmonWidgetFactory widgets;
  
  public EscapedTextItemBasedStringValueProvider name;
  
  public TextItemBasedStringValueProvider phone;
  
  public ComboBoxSingleEntitySelector<GWTCustomerStatus> status;
  
  @Inject
  public GWTCustomerStatusContentProvider statusContentProvider;
  
  public EscapedTextItemBasedStringValueProvider info;
  
  public ComboBoxSingleEntitySelector<GWTNamedEntity> phoneSales;
  
  @Inject
  public AllEmployees phoneSalesContentProvider;
  
  public ComboBoxSingleEntitySelector<GWTNamedEntity> onsiteSales;
  
  @Inject
  public AllEmployees onsiteSalesContentProvider;
  
  public CheckBoxBooleanValueSelector noPhoneSales;
  
  @Inject
  private BooleanValueProviderFactory booleanValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private GWTNormalCustomerCriteria4Admin value = new GWTNormalCustomerCriteria4Admin();
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();name = stringValueProviderFactory.createAsEscapedTextItemAdaptor("name","客户名");
    phone = stringValueProviderFactory.createAsTextItemAdaptor("phone","联系电话");
    status = defaultObjectSelectorFactory.createAsSelectItemAdaptor("status","客户状态");
    status.setContentProvider(statusContentProvider);
    info = stringValueProviderFactory.createAsEscapedTextItemAdaptor("info","联络信息");
    phoneSales = defaultObjectSelectorFactory.createAsSelectItemAdaptor("phoneSales","电话销售");
    _initializerSupports.add(phoneSalesContentProvider);
    phoneSales.setContentProvider(phoneSalesContentProvider);
    onsiteSales = defaultObjectSelectorFactory.createAsSelectItemAdaptor("onsiteSales","上门商务");
    _initializerSupports.add(onsiteSalesContentProvider);
    onsiteSales.setContentProvider(onsiteSalesContentProvider);
    noPhoneSales = booleanValueProviderFactory.createAsCheckBoxItem("noPhoneSales","无电话销售");
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, handler);
  }
  
  public GWTNormalCustomerCriteria4Admin getValueAsNew() {
    GWTNormalCustomerCriteria4Admin value = new GWTNormalCustomerCriteria4Admin();
    value.setName(name.getValue());
    value.setPhone(phone.getValue());
    value.setStatus(status.getValue());
    value.setInfo(info.getValue());
    value.setPhoneSales(phoneSales.getValue());
    value.setOnsiteSales(onsiteSales.getValue());
    value.setNoPhoneSales(noPhoneSales.getValue());
    return value;
  }
  
  public GWTNormalCustomerCriteria4Admin doGetValue() {
    
    value.setName(name.getValue());
    value.setPhone(phone.getValue());
    value.setStatus(status.getValue());
    value.setInfo(info.getValue());
    value.setPhoneSales(phoneSales.getValue());
    value.setOnsiteSales(onsiteSales.getValue());
    value.setNoPhoneSales(noPhoneSales.getValue());
    return value;
  }
  
  public GWTNormalCustomerCriteria4Admin getValue(final GWTNormalCustomerCriteria4Admin copyValue) {
    
    copyValue.setName(name.getValue());
    copyValue.setPhone(phone.getValue());
    copyValue.setStatus(status.getValue());
    copyValue.setInfo(info.getValue());
    copyValue.setPhoneSales(phoneSales.getValue());
    copyValue.setOnsiteSales(onsiteSales.getValue());
    copyValue.setNoPhoneSales(noPhoneSales.getValue());
    return copyValue;
  }
  
  protected NormalCustomerCriteriaForm4Admin doSetValue(final GWTNormalCustomerCriteria4Admin value) {
    this.value = value;
    name.setValue(value.getName());
    phone.setValue(value.getPhone());
    status.setValue(value.getStatus());
    info.setValue(value.getInfo());
    phoneSales.setValue(value.getPhoneSales());
    onsiteSales.setValue(value.getOnsiteSales());
    noPhoneSales.setValue(value.getNoPhoneSales());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)name,(ICanAsWidget)phone,(ICanAsWidget)status,(ICanAsWidget)info,(ICanAsWidget)phoneSales,(ICanAsWidget)onsiteSales,(ICanAsWidget)noPhoneSales
    					);
  }
  
  public DynamicForm asWidget() {
    DynamicForm _xblockexpression = null;
    {
      boolean _notEquals = (!Objects.equal(this.form, null));
      if (_notEquals) {
        /*this.form;*/
      }
      DynamicForm _DynamicForm = this.widgets.DynamicForm();
      final Procedure1<DynamicForm> _function = new Procedure1<DynamicForm>() {
          public void apply(final DynamicForm form) {
            form.setNumCols(6);
            TextItem _asWidget = NormalCustomerCriteriaForm4Admin.this.name.asWidget();
            TextItem _asWidget_1 = NormalCustomerCriteriaForm4Admin.this.phone.asWidget();
            TextItem _asWidget_2 = NormalCustomerCriteriaForm4Admin.this.info.asWidget();
            SelectItem _asWidget_3 = NormalCustomerCriteriaForm4Admin.this.status.asWidget();
            CheckboxItem _asWidget_4 = NormalCustomerCriteriaForm4Admin.this.noPhoneSales.asWidget();
            SelectItem _asWidget_5 = NormalCustomerCriteriaForm4Admin.this.phoneSales.asWidget();
            SelectItem _asWidget_6 = NormalCustomerCriteriaForm4Admin.this.onsiteSales.asWidget();
            form.setFields(_asWidget, _asWidget_1, _asWidget_2, _asWidget_3, _asWidget_4, _asWidget_5, _asWidget_6);
          }
        };
      DynamicForm _doubleArrow = ObjectExtensions.<DynamicForm>operator_doubleArrow(_DynamicForm, _function);
      DynamicForm _form = this.form = _doubleArrow;
      _xblockexpression = (_form);
    }
    return _xblockexpression;
  }
  
  private DynamicForm form;
}
