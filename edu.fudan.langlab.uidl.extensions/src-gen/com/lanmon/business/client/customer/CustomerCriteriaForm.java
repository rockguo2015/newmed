package com.lanmon.business.client.customer;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.lanmon.business.client.customer.DomainCodeProvider;
import com.lanmon.business.client.customer.GWTCustomerStatusContentProvider;
import com.lanmon.business.client.customer.PropertyCodeProvider;
import com.lanmon.business.client.customer.ScaleCodeProvider;
import com.lanmon.business.client.widgets.ILanmonWidgetFactory;
import com.lanmon.business.shared.customer.GWTCustomerCriteria4Sales;
import com.lanmon.business.shared.customer.GWTCustomerStatus;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.FormComponent;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.ComboBoxSingleEntitySelector;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.DefaultObjectSelectorFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.StringValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.StringValueProviderFactory.EscapedTextItemBasedStringValueProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CustomerCriteriaForm extends FormComponent<GWTCustomerCriteria4Sales> implements IInitializerSupport {
  @Inject
  private ILanmonWidgetFactory widgets;
  
  public EscapedTextItemBasedStringValueProvider name;
  
  public EscapedTextItemBasedStringValueProvider address;
  
  public ComboBoxSingleEntitySelector<GWTCustomerStatus> status;
  
  @Inject
  public GWTCustomerStatusContentProvider statusContentProvider;
  
  public ComboBoxSingleEntitySelector<GWTNamedEntity> domainCode;
  
  @Inject
  public DomainCodeProvider domainCodeContentProvider;
  
  public ComboBoxSingleEntitySelector<GWTNamedEntity> propertyCode;
  
  @Inject
  public PropertyCodeProvider propertyCodeContentProvider;
  
  public ComboBoxSingleEntitySelector<GWTNamedEntity> scaleCode;
  
  @Inject
  public ScaleCodeProvider scaleCodeContentProvider;
  
  public EscapedTextItemBasedStringValueProvider annotation;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private GWTCustomerCriteria4Sales value = new GWTCustomerCriteria4Sales();
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();name = stringValueProviderFactory.createAsEscapedTextItemAdaptor("name","客户名");
    address = stringValueProviderFactory.createAsEscapedTextItemAdaptor("address","联系信息");
    status = defaultObjectSelectorFactory.createAsSelectItemAdaptor("status","客户状态");
    status.setContentProvider(statusContentProvider);
    domainCode = defaultObjectSelectorFactory.createAsSelectItemAdaptor("domainCode","所属行业");
    _initializerSupports.add(domainCodeContentProvider);
    domainCode.setContentProvider(domainCodeContentProvider);
    propertyCode = defaultObjectSelectorFactory.createAsSelectItemAdaptor("propertyCode","性质");
    _initializerSupports.add(propertyCodeContentProvider);
    propertyCode.setContentProvider(propertyCodeContentProvider);
    scaleCode = defaultObjectSelectorFactory.createAsSelectItemAdaptor("scaleCode","规模");
    _initializerSupports.add(scaleCodeContentProvider);
    scaleCode.setContentProvider(scaleCodeContentProvider);
    annotation = stringValueProviderFactory.createAsEscapedTextItemAdaptor("annotation","客户状态备注");
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, handler);
  }
  
  public GWTCustomerCriteria4Sales getValueAsNew() {
    GWTCustomerCriteria4Sales value = new GWTCustomerCriteria4Sales();
    value.setName(name.getValue());
    value.setAddress(address.getValue());
    value.setStatus(status.getValue());
    value.setDomainCode(domainCode.getValue());
    value.setPropertyCode(propertyCode.getValue());
    value.setScaleCode(scaleCode.getValue());
    value.setAnnotation(annotation.getValue());
    return value;
  }
  
  public GWTCustomerCriteria4Sales doGetValue() {
    
    value.setName(name.getValue());
    value.setAddress(address.getValue());
    value.setStatus(status.getValue());
    value.setDomainCode(domainCode.getValue());
    value.setPropertyCode(propertyCode.getValue());
    value.setScaleCode(scaleCode.getValue());
    value.setAnnotation(annotation.getValue());
    return value;
  }
  
  public GWTCustomerCriteria4Sales getValue(final GWTCustomerCriteria4Sales copyValue) {
    
    copyValue.setName(name.getValue());
    copyValue.setAddress(address.getValue());
    copyValue.setStatus(status.getValue());
    copyValue.setDomainCode(domainCode.getValue());
    copyValue.setPropertyCode(propertyCode.getValue());
    copyValue.setScaleCode(scaleCode.getValue());
    copyValue.setAnnotation(annotation.getValue());
    return copyValue;
  }
  
  protected CustomerCriteriaForm doSetValue(final GWTCustomerCriteria4Sales value) {
    this.value = value;
    name.setValue(value.getName());
    address.setValue(value.getAddress());
    status.setValue(value.getStatus());
    domainCode.setValue(value.getDomainCode());
    propertyCode.setValue(value.getPropertyCode());
    scaleCode.setValue(value.getScaleCode());
    annotation.setValue(value.getAnnotation());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)name,(ICanAsWidget)address,(ICanAsWidget)status,(ICanAsWidget)domainCode,(ICanAsWidget)propertyCode,(ICanAsWidget)scaleCode,(ICanAsWidget)annotation
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
            TextItem _asWidget = CustomerCriteriaForm.this.name.asWidget();
            TextItem _asWidget_1 = CustomerCriteriaForm.this.address.asWidget();
            SelectItem _asWidget_2 = CustomerCriteriaForm.this.status.asWidget();
            SelectItem _asWidget_3 = CustomerCriteriaForm.this.domainCode.asWidget();
            SelectItem _asWidget_4 = CustomerCriteriaForm.this.propertyCode.asWidget();
            SelectItem _asWidget_5 = CustomerCriteriaForm.this.scaleCode.asWidget();
            TextItem _asWidget_6 = CustomerCriteriaForm.this.annotation.asWidget();
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
