package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.shared.organization.UIEmployee;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.domain.security.proxy.RoleProxy;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.BooleanValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.BooleanValueProviderFactory.BooleanColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectsSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectsSelectorFactory.CollectionListColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class EmployeeListGrid extends GXTGridComponent<UIEmployee> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIEmployee> eid;
  
  public StringColumn<UIEmployee> name;
  
  public StringValueColumn<UIEmployee,RCOrganizationProxy> organization;
  
  public CollectionListColumn<UIEmployee,RoleProxy> roles;
  
  public StringColumn<UIEmployee> cardNumber;
  
  public StringColumn<UIEmployee> mobil;
  
  public StringColumn<UIEmployee> tel;
  
  public StringColumn<UIEmployee> workTel;
  
  public StringColumn<UIEmployee> email;
  
  public StringColumn<UIEmployee> address;
  
  public BooleanColumn<UIEmployee> isLeaveJob;
  
  @Inject
  private DefaultObjectsSelectorFactory defaultObjectsSelectorFactory;
  
  @Inject
  private BooleanValueProviderFactory booleanValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIEmployee value = new UIEmployee();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();eid = stringValueProviderFactory.createAsStringColumn("eid","工号",UIEmployee.EidAccessor,Integer.valueOf(90));
    widgetsRegistory.put("eid",eid);
    name = stringValueProviderFactory.createAsStringColumn("name","姓名",UIEmployee.NameAccessor);
    widgetsRegistory.put("name",name);
    organization = defaultObjectSelectorFactory.createAsDefaultColumn("organization","所属机构",UIEmployee.OrganizationAccessor);
    widgetsRegistory.put("organization",organization);
    roles = defaultObjectsSelectorFactory.createAsStringColumn("roles","系统角色",UIEmployee.RolesAccessor,Integer.valueOf(120));
    widgetsRegistory.put("roles",roles);
    cardNumber = stringValueProviderFactory.createAsStringColumn("cardNumber","工牌号",UIEmployee.CardNumberAccessor);
    widgetsRegistory.put("cardNumber",cardNumber);
    mobil = stringValueProviderFactory.createAsStringColumn("mobil","手机",UIEmployee.MobilAccessor,Integer.valueOf(130));
    widgetsRegistory.put("mobil",mobil);
    tel = stringValueProviderFactory.createAsStringColumn("tel","宅电",UIEmployee.TelAccessor,Integer.valueOf(120));
    widgetsRegistory.put("tel",tel);
    workTel = stringValueProviderFactory.createAsStringColumn("workTel","工作电话",UIEmployee.WorkTelAccessor,Integer.valueOf(120));
    widgetsRegistory.put("workTel",workTel);
    email = stringValueProviderFactory.createAsStringColumn("email","电子邮件",UIEmployee.EmailAccessor,Integer.valueOf(140));
    widgetsRegistory.put("email",email);
    address = stringValueProviderFactory.createAsStringColumn("address","地址",UIEmployee.AddressAccessor,Integer.valueOf(150));
    widgetsRegistory.put("address",address);
    isLeaveJob = booleanValueProviderFactory.createAsBooleanColumn("isLeaveJob","已离职",UIEmployee.IsLeaveJobAccessor);
    widgetsRegistory.put("isLeaveJob",isLeaveJob);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
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
    value.setName(name.getValue());
    value.setOrganization(organization.getValue());
    value.setRoles(roles.getValue());
    value.setCardNumber(cardNumber.getValue());
    value.setMobil(mobil.getValue());
    value.setTel(tel.getValue());
    value.setWorkTel(workTel.getValue());
    value.setEmail(email.getValue());
    value.setAddress(address.getValue());
    value.setIsLeaveJob(isLeaveJob.getValue());
    return value;
  }
  
  public UIEmployee doGetValue() {
    
    value.setEid(eid.getValue());
    value.setName(name.getValue());
    value.setOrganization(organization.getValue());
    value.setRoles(roles.getValue());
    value.setCardNumber(cardNumber.getValue());
    value.setMobil(mobil.getValue());
    value.setTel(tel.getValue());
    value.setWorkTel(workTel.getValue());
    value.setEmail(email.getValue());
    value.setAddress(address.getValue());
    value.setIsLeaveJob(isLeaveJob.getValue());
    return value;
  }
  
  public UIEmployee getValue(final UIEmployee copyValue) {
    
    copyValue.setEid(eid.getValue());
    copyValue.setName(name.getValue());
    copyValue.setOrganization(organization.getValue());
    copyValue.setRoles(roles.getValue());
    copyValue.setCardNumber(cardNumber.getValue());
    copyValue.setMobil(mobil.getValue());
    copyValue.setTel(tel.getValue());
    copyValue.setWorkTel(workTel.getValue());
    copyValue.setEmail(email.getValue());
    copyValue.setAddress(address.getValue());
    copyValue.setIsLeaveJob(isLeaveJob.getValue());
    return copyValue;
  }
  
  protected EmployeeListGrid doSetValue(final UIEmployee value) {
    this.value = value;
    eid.setValue(value.getEid());
    name.setValue(value.getName());
    organization.setValue(value.getOrganization());
    roles.setValue(value.getRoles());
    cardNumber.setValue(value.getCardNumber());
    mobil.setValue(value.getMobil());
    tel.setValue(value.getTel());
    workTel.setValue(value.getWorkTel());
    email.setValue(value.getEmail());
    address.setValue(value.getAddress());
    isLeaveJob.setValue(value.getIsLeaveJob());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)eid,(ICanAsWidget)name,(ICanAsWidget)organization,(ICanAsWidget)roles,(ICanAsWidget)cardNumber,(ICanAsWidget)mobil,(ICanAsWidget)tel,(ICanAsWidget)workTel,(ICanAsWidget)email,(ICanAsWidget)address,(ICanAsWidget)isLeaveJob
    					);
  }
  
  public void initializeComponent() {
    this.asWidget();
    this.unForceFit();
  }
}
