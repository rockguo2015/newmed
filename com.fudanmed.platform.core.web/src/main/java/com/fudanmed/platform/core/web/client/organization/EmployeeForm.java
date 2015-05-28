package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.shared.organization.UIEmployee;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.BooleanValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.BooleanValueProviderFactory.CheckBoxItem;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.ReadonlyItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class EmployeeForm extends GXTFormComponent<UIEmployee> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public TextItem eid;
  
  public TextItem cardNumber;
  
  public TextItem name;
  
  public TextItem mobil;
  
  public TextItem tel;
  
  public TextItem workTel;
  
  public TextItem email;
  
  public TextItem address;
  
  public ReadonlyItem<RCOrganizationProxy> organization;
  
  public CheckBoxItem inputNext;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private BooleanValueProviderFactory booleanValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIEmployee value = new UIEmployee();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();eid = stringValueProviderFactory.createAsTextItem("eid","工号");
    widgetsRegistory.put("eid",eid);
    cardNumber = stringValueProviderFactory.createAsTextItem("cardNumber","工牌号");
    widgetsRegistory.put("cardNumber",cardNumber);
    name = stringValueProviderFactory.createAsTextItem("name","姓名");
    widgetsRegistory.put("name",name);
    mobil = stringValueProviderFactory.createAsTextItem("mobil","手机");
    widgetsRegistory.put("mobil",mobil);
    tel = stringValueProviderFactory.createAsTextItem("tel","宅电");
    widgetsRegistory.put("tel",tel);
    workTel = stringValueProviderFactory.createAsTextItem("workTel","工作电话");
    widgetsRegistory.put("workTel",workTel);
    email = stringValueProviderFactory.createAsTextItem("email","电子邮件");
    widgetsRegistory.put("email",email);
    address = stringValueProviderFactory.createAsTextItem("address","地址");
    widgetsRegistory.put("address",address);
    organization = defaultObjectSelectorFactory.createAsReadonlyItem("organization","所属机构");
    widgetsRegistory.put("organization",organization);
    inputNext = booleanValueProviderFactory.createAsCheckBoxItem("inputNext","继续输入");
    widgetsRegistory.put("inputNext",inputNext);
    if(con instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)con);
    						}IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIEmployee getValueAsNew() {
    UIEmployee value = new UIEmployee();
    value.setEid(eid.getValue());
    value.setCardNumber(cardNumber.getValue());
    value.setName(name.getValue());
    value.setMobil(mobil.getValue());
    value.setTel(tel.getValue());
    value.setWorkTel(workTel.getValue());
    value.setEmail(email.getValue());
    value.setAddress(address.getValue());
    value.setOrganization(organization.getValue());
    value.setInputNext(inputNext.getValue());
    return value;
  }
  
  public UIEmployee doGetValue() {
    
    value.setEid(eid.getValue());
    value.setCardNumber(cardNumber.getValue());
    value.setName(name.getValue());
    value.setMobil(mobil.getValue());
    value.setTel(tel.getValue());
    value.setWorkTel(workTel.getValue());
    value.setEmail(email.getValue());
    value.setAddress(address.getValue());
    value.setOrganization(organization.getValue());
    value.setInputNext(inputNext.getValue());
    return value;
  }
  
  public UIEmployee getValue(final UIEmployee copyValue) {
    
    copyValue.setEid(eid.getValue());
    copyValue.setCardNumber(cardNumber.getValue());
    copyValue.setName(name.getValue());
    copyValue.setMobil(mobil.getValue());
    copyValue.setTel(tel.getValue());
    copyValue.setWorkTel(workTel.getValue());
    copyValue.setEmail(email.getValue());
    copyValue.setAddress(address.getValue());
    copyValue.setOrganization(organization.getValue());
    copyValue.setInputNext(inputNext.getValue());
    return copyValue;
  }
  
  protected EmployeeForm doSetValue(final UIEmployee value) {
    this.value = value;
    eid.setValue(value.getEid());
    cardNumber.setValue(value.getCardNumber());
    name.setValue(value.getName());
    mobil.setValue(value.getMobil());
    tel.setValue(value.getTel());
    workTel.setValue(value.getWorkTel());
    email.setValue(value.getEmail());
    address.setValue(value.getAddress());
    organization.setValue(value.getOrganization());
    inputNext.setValue(value.getInputNext());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)eid,(ICanAsWidget)cardNumber,(ICanAsWidget)name,(ICanAsWidget)mobil,(ICanAsWidget)tel,(ICanAsWidget)workTel,(ICanAsWidget)email,(ICanAsWidget)address,(ICanAsWidget)organization,(ICanAsWidget)inputNext
    					);
  }
  
  public Widget asWidget() {
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _VLayout = EmployeeForm.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                FieldLabel _asWidget = EmployeeForm.this.organization.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget);
                FieldLabel _asWidget_1 = EmployeeForm.this.eid.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_1);
                FieldLabel _asWidget_2 = EmployeeForm.this.cardNumber.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_2);
                FieldLabel _asWidget_3 = EmployeeForm.this.name.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_3);
                FieldLabel _asWidget_4 = EmployeeForm.this.mobil.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_4);
                FieldLabel _asWidget_5 = EmployeeForm.this.tel.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_5);
                FieldLabel _asWidget_6 = EmployeeForm.this.workTel.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_6);
                FieldLabel _asWidget_7 = EmployeeForm.this.email.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_7);
                FieldLabel _asWidget_8 = EmployeeForm.this.address.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_8);
                FieldLabel _asWidget_9 = EmployeeForm.this.inputNext.asWidget();
                final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                    public void apply(final FieldLabel it) {
                      EmployeeForm.this.inputNext.setValue(Boolean.valueOf(true));
                    }
                  };
                FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget_9, _function);
                it.add(_doubleArrow);
              }
            };
          VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
          return _doubleArrow;
        }
      };
    Widget _lazy = ClientUi.<Widget>lazy(this.con, _function);
    Widget _con = this.con = _lazy;
    return _con;
  }
  
  private Widget con;
}
