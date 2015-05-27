package com.lanmon.business.client.customer;

import com.google.common.base.Objects;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.lanmon.business.client.widgets.ILanmonWidgetFactory;
import com.lanmon.business.shared.customer.GWTCustomer;
import com.lanmon.business.shared.customer.GWTCustomerStatus;
import com.smartgwt.client.widgets.layout.VLayout;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.SmartGwtClientUi;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.detail.DetailViewComponent;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.detail.factory.DefaultObjectSelectorFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.detail.factory.DefaultObjectSelectorFactory.ObjectDetaiItem;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.detail.factory.StringValueProviderFactory;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.detail.factory.StringValueProviderFactory.MailDetailItem;
import com.uniquesoft.gwt.client.common.widgets.smartgwt.component.detail.factory.StringValueProviderFactory.StringDetaiItem;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CustomerDetail extends DetailViewComponent<GWTCustomer> implements IInitializerSupport {
  @Inject
  private ILanmonWidgetFactory widgets;
  
  public StringDetaiItem name;
  
  public StringDetaiItem phone;
  
  public StringDetaiItem fax;
  
  public ObjectDetaiItem<GWTCustomerStatus> status;
  
  public MailDetailItem email;
  
  public StringDetaiItem addressInfo;
  
  public StringDetaiItem homePage;
  
  public ObjectDetaiItem<GWTNamedEntity> onsiteSaleOwner;
  
  public ObjectDetaiItem<GWTNamedEntity> phoneSaleOwner;
  
  public ObjectDetaiItem<GWTNamedEntity> domainCode;
  
  public ObjectDetaiItem<GWTNamedEntity> propertyCode;
  
  public ObjectDetaiItem<GWTNamedEntity> scaleCode;
  
  public ObjectDetaiItem<GWTNamedEntity> regionCode;
  
  public StringDetaiItem contractor;
  
  public StringDetaiItem annotation;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private GWTCustomer value = new GWTCustomer();
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();name = stringValueProviderFactory.createAsDetailItem("name","客户名");
    phone = stringValueProviderFactory.createAsDetailItem("phone","联系电话");
    fax = stringValueProviderFactory.createAsDetailItem("fax","传真");
    status = defaultObjectSelectorFactory.createAsDetailItem("status","客户状态");
    email = stringValueProviderFactory.createAsMailItem("email","e-mail");
    addressInfo = stringValueProviderFactory.createAsDetailItem("addressInfo","地址");
    homePage = stringValueProviderFactory.createAsDetailItem("homePage","主页");
    onsiteSaleOwner = defaultObjectSelectorFactory.createAsDetailItem("onsiteSaleOwner","上门商务");
    phoneSaleOwner = defaultObjectSelectorFactory.createAsDetailItem("phoneSaleOwner","电话销售");
    domainCode = defaultObjectSelectorFactory.createAsDetailItem("domainCode","所属行业");
    propertyCode = defaultObjectSelectorFactory.createAsDetailItem("propertyCode","性质");
    scaleCode = defaultObjectSelectorFactory.createAsDetailItem("scaleCode","规模");
    regionCode = defaultObjectSelectorFactory.createAsDetailItem("regionCode","区域");
    contractor = stringValueProviderFactory.createAsDetailItem("contractor","联系人");
    annotation = stringValueProviderFactory.createAsDetailItem("annotation","客户状态备注");
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, handler);
  }
  
  public GWTCustomer getValueAsNew() {
    GWTCustomer value = new GWTCustomer();
    return value;
  }
  
  public GWTCustomer doGetValue() {
    
    return value;
  }
  
  public GWTCustomer getValue(final GWTCustomer copyValue) {
    
    return copyValue;
  }
  
  protected CustomerDetail doSetValue(final GWTCustomer value) {
    this.value = value;
    name.setValue(value.getName());
    phone.setValue(value.getPhone());
    fax.setValue(value.getFax());
    status.setValue(value.getStatus());
    email.setValue(value.getEmail());
    addressInfo.setValue(value.getAddressInfo());
    homePage.setValue(value.getHomePage());
    onsiteSaleOwner.setValue(value.getOnsiteSaleOwner());
    phoneSaleOwner.setValue(value.getPhoneSaleOwner());
    domainCode.setValue(value.getDomainCode());
    propertyCode.setValue(value.getPropertyCode());
    scaleCode.setValue(value.getScaleCode());
    regionCode.setValue(value.getRegionCode());
    contractor.setValue(value.getContractor());
    annotation.setValue(value.getAnnotation());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)name,(ICanAsWidget)phone,(ICanAsWidget)fax,(ICanAsWidget)status,(ICanAsWidget)email,(ICanAsWidget)addressInfo,(ICanAsWidget)homePage,(ICanAsWidget)onsiteSaleOwner,(ICanAsWidget)phoneSaleOwner,(ICanAsWidget)domainCode,(ICanAsWidget)propertyCode,(ICanAsWidget)scaleCode,(ICanAsWidget)regionCode,(ICanAsWidget)contractor,(ICanAsWidget)annotation
    					);
  }
  
  public VLayout asWidget() {
    VLayout _xblockexpression = null;
    {
      boolean _notEquals = (!Objects.equal(this.canvas, null));
      if (_notEquals) {
        /*this.canvas;*/
      }
      VLayout _VLayout = this.widgets.VLayout();
      final Procedure1<VLayout> _function = new Procedure1<VLayout>() {
          public void apply(final VLayout it) {
            Widget _asWidget = CustomerDetail.this.name.asWidget();
            SmartGwtClientUi.operator_add(it, _asWidget);
            Widget _asWidget_1 = CustomerDetail.this.status.asWidget();
            SmartGwtClientUi.operator_add(it, _asWidget_1);
            Widget _asWidget_2 = CustomerDetail.this.annotation.asWidget();
            SmartGwtClientUi.operator_add(it, _asWidget_2);
            Widget _asWidget_3 = CustomerDetail.this.phone.asWidget();
            SmartGwtClientUi.operator_add(it, _asWidget_3);
            Widget _asWidget_4 = CustomerDetail.this.fax.asWidget();
            SmartGwtClientUi.operator_add(it, _asWidget_4);
            Widget _asWidget_5 = CustomerDetail.this.email.asWidget();
            SmartGwtClientUi.operator_add(it, _asWidget_5);
            Widget _asWidget_6 = CustomerDetail.this.addressInfo.asWidget();
            SmartGwtClientUi.operator_add(it, _asWidget_6);
            Widget _asWidget_7 = CustomerDetail.this.contractor.asWidget();
            SmartGwtClientUi.operator_add(it, _asWidget_7);
            Widget _asWidget_8 = CustomerDetail.this.homePage.asWidget();
            SmartGwtClientUi.operator_add(it, _asWidget_8);
            Widget _asWidget_9 = CustomerDetail.this.onsiteSaleOwner.asWidget();
            SmartGwtClientUi.operator_add(it, _asWidget_9);
            Widget _asWidget_10 = CustomerDetail.this.phoneSaleOwner.asWidget();
            SmartGwtClientUi.operator_add(it, _asWidget_10);
            Widget _asWidget_11 = CustomerDetail.this.domainCode.asWidget();
            SmartGwtClientUi.operator_add(it, _asWidget_11);
            Widget _asWidget_12 = CustomerDetail.this.propertyCode.asWidget();
            SmartGwtClientUi.operator_add(it, _asWidget_12);
            Widget _asWidget_13 = CustomerDetail.this.scaleCode.asWidget();
            SmartGwtClientUi.operator_add(it, _asWidget_13);
            Widget _asWidget_14 = CustomerDetail.this.regionCode.asWidget();
            SmartGwtClientUi.operator_add(it, _asWidget_14);
          }
        };
      VLayout _doubleArrow = ObjectExtensions.<VLayout>operator_doubleArrow(_VLayout, _function);
      VLayout _canvas = this.canvas = _doubleArrow;
      _xblockexpression = (_canvas);
    }
    return _xblockexpression;
  }
  
  private VLayout canvas;
}
