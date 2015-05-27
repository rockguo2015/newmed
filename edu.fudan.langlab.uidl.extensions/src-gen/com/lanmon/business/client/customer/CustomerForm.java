package com.lanmon.business.client.customer;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.lanmon.business.client.customer.AllEmployees;
import com.lanmon.business.client.customer.DomainCodeProvider;
import com.lanmon.business.client.customer.GWTCustomerStatusContentProvider;
import com.lanmon.business.client.customer.PropertyCodeProvider;
import com.lanmon.business.client.customer.RegionCodeProvider;
import com.lanmon.business.client.customer.ScaleCodeProvider;
import com.lanmon.business.client.widgets.ILanmonWidgetFactory;
import com.lanmon.business.shared.customer.GWTCustomer;
import com.lanmon.business.shared.customer.GWTCustomerStatus;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateRangeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.FormComponent;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.ComboBoxSingleEntitySelector;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.DateRangeValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.DateRangeValueProviderFactory.DateRangeItemAdaptor;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.DefaultObjectSelectorFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.StringValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.StringValueProviderFactory.TextAreaBasedStringValueProvider;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.form.factory.StringValueProviderFactory.TextItemBasedStringValueProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CustomerForm extends FormComponent<GWTCustomer> implements IInitializerSupport {
  @Inject
  private ILanmonWidgetFactory widgets;
  
  public TextItemBasedStringValueProvider name;
  
  public TextItemBasedStringValueProvider phone;
  
  public TextItemBasedStringValueProvider fax;
  
  public ComboBoxSingleEntitySelector<GWTCustomerStatus> status;
  
  @Inject
  public GWTCustomerStatusContentProvider statusContentProvider;
  
  public TextItemBasedStringValueProvider contractor;
  
  public TextItemBasedStringValueProvider annotation;
  
  public ComboBoxSingleEntitySelector<GWTNamedEntity> phoneSaleOwner;
  
  @Inject
  public AllEmployees phoneSaleOwnerContentProvider;
  
  public ComboBoxSingleEntitySelector<GWTNamedEntity> onsiteSaleOwner;
  
  @Inject
  public AllEmployees onsiteSaleOwnerContentProvider;
  
  public TextItemBasedStringValueProvider postcode;
  
  public TextItemBasedStringValueProvider addressInfo;
  
  public TextItemBasedStringValueProvider email;
  
  public TextItemBasedStringValueProvider homePage;
  
  public DateRangeItemAdaptor contractDate;
  
  public ComboBoxSingleEntitySelector<GWTNamedEntity> domainCode;
  
  @Inject
  public DomainCodeProvider domainCodeContentProvider;
  
  public ComboBoxSingleEntitySelector<GWTNamedEntity> propertyCode;
  
  @Inject
  public PropertyCodeProvider propertyCodeContentProvider;
  
  public ComboBoxSingleEntitySelector<GWTNamedEntity> scaleCode;
  
  @Inject
  public ScaleCodeProvider scaleCodeContentProvider;
  
  public ComboBoxSingleEntitySelector<GWTNamedEntity> regionCode;
  
  @Inject
  public RegionCodeProvider regionCodeContentProvider;
  
  public DateRangeItemAdaptor outsourceDate;
  
  public TextAreaBasedStringValueProvider customerComment;
  
  @Inject
  private DateRangeValueProviderFactory dateRangeValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private GWTCustomer value = new GWTCustomer();
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();name = stringValueProviderFactory.createAsTextItemAdaptor("name","客户名");
    phone = stringValueProviderFactory.createAsTextItemAdaptor("phone","联系电话");
    fax = stringValueProviderFactory.createAsTextItemAdaptor("fax","传真");
    status = defaultObjectSelectorFactory.createAsSelectItemAdaptor("status","客户状态");
    status.setContentProvider(statusContentProvider);
    contractor = stringValueProviderFactory.createAsTextItemAdaptor("contractor","联系人");
    annotation = stringValueProviderFactory.createAsTextItemAdaptor("annotation","客户状态备注");
    phoneSaleOwner = defaultObjectSelectorFactory.createAsSelectItemAdaptor("phoneSaleOwner","电话销售");
    _initializerSupports.add(phoneSaleOwnerContentProvider);
    phoneSaleOwner.setContentProvider(phoneSaleOwnerContentProvider);
    onsiteSaleOwner = defaultObjectSelectorFactory.createAsSelectItemAdaptor("onsiteSaleOwner","上门商务");
    _initializerSupports.add(onsiteSaleOwnerContentProvider);
    onsiteSaleOwner.setContentProvider(onsiteSaleOwnerContentProvider);
    postcode = stringValueProviderFactory.createAsTextItemAdaptor("postcode","邮编");
    addressInfo = stringValueProviderFactory.createAsTextItemAdaptor("addressInfo","地址");
    email = stringValueProviderFactory.createAsTextItemAdaptor("email","e-mail");
    homePage = stringValueProviderFactory.createAsTextItemAdaptor("homePage","主页");
    contractDate = dateRangeValueProviderFactory.createAsDateRangeItem("contractDate","签约期间");
    domainCode = defaultObjectSelectorFactory.createAsSelectItemAdaptor("domainCode","所属行业");
    _initializerSupports.add(domainCodeContentProvider);
    domainCode.setContentProvider(domainCodeContentProvider);
    propertyCode = defaultObjectSelectorFactory.createAsSelectItemAdaptor("propertyCode","性质");
    _initializerSupports.add(propertyCodeContentProvider);
    propertyCode.setContentProvider(propertyCodeContentProvider);
    scaleCode = defaultObjectSelectorFactory.createAsSelectItemAdaptor("scaleCode","规模");
    _initializerSupports.add(scaleCodeContentProvider);
    scaleCode.setContentProvider(scaleCodeContentProvider);
    regionCode = defaultObjectSelectorFactory.createAsSelectItemAdaptor("regionCode","区域");
    _initializerSupports.add(regionCodeContentProvider);
    regionCode.setContentProvider(regionCodeContentProvider);
    outsourceDate = dateRangeValueProviderFactory.createAsDateRangeItem("outsourceDate","外包期间");
    customerComment = stringValueProviderFactory.createAsTextAreaAdaptor("customerComment","customerComment");
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, handler);
  }
  
  public GWTCustomer getValueAsNew() {
    GWTCustomer value = new GWTCustomer();
    value.setName(name.getValue());
    value.setPhone(phone.getValue());
    value.setFax(fax.getValue());
    value.setStatus(status.getValue());
    value.setContractor(contractor.getValue());
    value.setAnnotation(annotation.getValue());
    value.setPhoneSaleOwner(phoneSaleOwner.getValue());
    value.setOnsiteSaleOwner(onsiteSaleOwner.getValue());
    value.setPostcode(postcode.getValue());
    value.setAddressInfo(addressInfo.getValue());
    value.setEmail(email.getValue());
    value.setHomePage(homePage.getValue());
    value.setContractDate(contractDate.getValue());
    value.setDomainCode(domainCode.getValue());
    value.setPropertyCode(propertyCode.getValue());
    value.setScaleCode(scaleCode.getValue());
    value.setRegionCode(regionCode.getValue());
    value.setOutsourceDate(outsourceDate.getValue());
    value.setCustomerComment(customerComment.getValue());
    return value;
  }
  
  public GWTCustomer doGetValue() {
    
    value.setName(name.getValue());
    value.setPhone(phone.getValue());
    value.setFax(fax.getValue());
    value.setStatus(status.getValue());
    value.setContractor(contractor.getValue());
    value.setAnnotation(annotation.getValue());
    value.setPhoneSaleOwner(phoneSaleOwner.getValue());
    value.setOnsiteSaleOwner(onsiteSaleOwner.getValue());
    value.setPostcode(postcode.getValue());
    value.setAddressInfo(addressInfo.getValue());
    value.setEmail(email.getValue());
    value.setHomePage(homePage.getValue());
    value.setContractDate(contractDate.getValue());
    value.setDomainCode(domainCode.getValue());
    value.setPropertyCode(propertyCode.getValue());
    value.setScaleCode(scaleCode.getValue());
    value.setRegionCode(regionCode.getValue());
    value.setOutsourceDate(outsourceDate.getValue());
    value.setCustomerComment(customerComment.getValue());
    return value;
  }
  
  public GWTCustomer getValue(final GWTCustomer copyValue) {
    
    copyValue.setName(name.getValue());
    copyValue.setPhone(phone.getValue());
    copyValue.setFax(fax.getValue());
    copyValue.setStatus(status.getValue());
    copyValue.setContractor(contractor.getValue());
    copyValue.setAnnotation(annotation.getValue());
    copyValue.setPhoneSaleOwner(phoneSaleOwner.getValue());
    copyValue.setOnsiteSaleOwner(onsiteSaleOwner.getValue());
    copyValue.setPostcode(postcode.getValue());
    copyValue.setAddressInfo(addressInfo.getValue());
    copyValue.setEmail(email.getValue());
    copyValue.setHomePage(homePage.getValue());
    copyValue.setContractDate(contractDate.getValue());
    copyValue.setDomainCode(domainCode.getValue());
    copyValue.setPropertyCode(propertyCode.getValue());
    copyValue.setScaleCode(scaleCode.getValue());
    copyValue.setRegionCode(regionCode.getValue());
    copyValue.setOutsourceDate(outsourceDate.getValue());
    copyValue.setCustomerComment(customerComment.getValue());
    return copyValue;
  }
  
  protected CustomerForm doSetValue(final GWTCustomer value) {
    this.value = value;
    name.setValue(value.getName());
    phone.setValue(value.getPhone());
    fax.setValue(value.getFax());
    status.setValue(value.getStatus());
    contractor.setValue(value.getContractor());
    annotation.setValue(value.getAnnotation());
    phoneSaleOwner.setValue(value.getPhoneSaleOwner());
    onsiteSaleOwner.setValue(value.getOnsiteSaleOwner());
    postcode.setValue(value.getPostcode());
    addressInfo.setValue(value.getAddressInfo());
    email.setValue(value.getEmail());
    homePage.setValue(value.getHomePage());
    contractDate.setValue(value.getContractDate());
    domainCode.setValue(value.getDomainCode());
    propertyCode.setValue(value.getPropertyCode());
    scaleCode.setValue(value.getScaleCode());
    regionCode.setValue(value.getRegionCode());
    outsourceDate.setValue(value.getOutsourceDate());
    customerComment.setValue(value.getCustomerComment());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)name,(ICanAsWidget)phone,(ICanAsWidget)fax,(ICanAsWidget)status,(ICanAsWidget)contractor,(ICanAsWidget)annotation,(ICanAsWidget)phoneSaleOwner,(ICanAsWidget)onsiteSaleOwner,(ICanAsWidget)postcode,(ICanAsWidget)addressInfo,(ICanAsWidget)email,(ICanAsWidget)homePage,(ICanAsWidget)contractDate,(ICanAsWidget)domainCode,(ICanAsWidget)propertyCode,(ICanAsWidget)scaleCode,(ICanAsWidget)regionCode,(ICanAsWidget)outsourceDate,(ICanAsWidget)customerComment
    					);
  }
  
  public DynamicForm asWidget() {
    DynamicForm _xblockexpression = null;
    {
      boolean _notEquals = (!Objects.equal(this.form, null));
      if (_notEquals) {
        return this.form;
      }
      DynamicForm _DynamicForm = this.widgets.DynamicForm();
      final Procedure1<DynamicForm> _function = new Procedure1<DynamicForm>() {
          public void apply(final DynamicForm form) {
            form.setNumCols(4);
            TextItem _asWidget = CustomerForm.this.name.asWidget();
            TextItem _asWidget_1 = CustomerForm.this.phone.asWidget();
            TextItem _asWidget_2 = CustomerForm.this.fax.asWidget();
            TextItem _asWidget_3 = CustomerForm.this.contractor.asWidget();
            SelectItem _asWidget_4 = CustomerForm.this.status.asWidget();
            TextItem _asWidget_5 = CustomerForm.this.annotation.asWidget();
            SelectItem _asWidget_6 = CustomerForm.this.phoneSaleOwner.asWidget();
            SelectItem _asWidget_7 = CustomerForm.this.onsiteSaleOwner.asWidget();
            TextItem _asWidget_8 = CustomerForm.this.postcode.asWidget();
            TextItem _asWidget_9 = CustomerForm.this.addressInfo.asWidget();
            TextItem _asWidget_10 = CustomerForm.this.email.asWidget();
            TextItem _asWidget_11 = CustomerForm.this.homePage.asWidget();
            SelectItem _asWidget_12 = CustomerForm.this.regionCode.asWidget();
            DateRangeItem _asWidget_13 = CustomerForm.this.contractDate.asWidget();
            DateRangeItem _asWidget_14 = CustomerForm.this.outsourceDate.asWidget();
            SelectItem _asWidget_15 = CustomerForm.this.domainCode.asWidget();
            SelectItem _asWidget_16 = CustomerForm.this.propertyCode.asWidget();
            SelectItem _asWidget_17 = CustomerForm.this.scaleCode.asWidget();
            form.setFields(_asWidget, _asWidget_1, _asWidget_2, _asWidget_3, _asWidget_4, _asWidget_5, _asWidget_6, _asWidget_7, _asWidget_8, _asWidget_9, _asWidget_10, _asWidget_11, _asWidget_12, _asWidget_13, _asWidget_14, _asWidget_15, _asWidget_16, _asWidget_17);
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
