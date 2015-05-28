package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.shared.organization.UISupplier;
import com.fudanmed.platform.core.web.shared.organization.UISupplierType;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class SupplierListGrid extends GXTGridComponent<UISupplier> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UISupplier> code;
  
  public StringColumn<UISupplier> name;
  
  public StringColumn<UISupplier> phone;
  
  public StringColumn<UISupplier> email;
  
  public StringValueColumn<UISupplier,UISupplierType> type;
  
  public StringColumn<UISupplier> address;
  
  public StringColumn<UISupplier> enterpriseEnrolNum;
  
  public StringColumn<UISupplier> workNo;
  
  public StringColumn<UISupplier> aptitudeName;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UISupplier value = new UISupplier();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();code = stringValueProviderFactory.createAsStringColumn("code","代码",UISupplier.CodeAccessor);
    widgetsRegistory.put("code",code);
    name = stringValueProviderFactory.createAsStringColumn("name","名称",UISupplier.NameAccessor);
    widgetsRegistory.put("name",name);
    phone = stringValueProviderFactory.createAsStringColumn("phone","联系电话",UISupplier.PhoneAccessor);
    widgetsRegistory.put("phone",phone);
    email = stringValueProviderFactory.createAsStringColumn("email","电子邮件",UISupplier.EmailAccessor);
    widgetsRegistory.put("email",email);
    type = defaultObjectSelectorFactory.createAsDefaultColumn("type","类型",UISupplier.TypeAccessor);
    widgetsRegistory.put("type",type);
    address = stringValueProviderFactory.createAsStringColumn("address","地址 ",UISupplier.AddressAccessor);
    widgetsRegistory.put("address",address);
    enterpriseEnrolNum = stringValueProviderFactory.createAsStringColumn("enterpriseEnrolNum","企业注册号",UISupplier.EnterpriseEnrolNumAccessor);
    widgetsRegistory.put("enterpriseEnrolNum",enterpriseEnrolNum);
    workNo = stringValueProviderFactory.createAsStringColumn("workNo","营业执照号",UISupplier.WorkNoAccessor);
    widgetsRegistory.put("workNo",workNo);
    aptitudeName = stringValueProviderFactory.createAsStringColumn("aptitudeName","已获得资质",UISupplier.AptitudeNameAccessor);
    widgetsRegistory.put("aptitudeName",aptitudeName);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UISupplier getValueAsNew() {
    UISupplier value = new UISupplier();
    value.setCode(code.getValue());
    value.setName(name.getValue());
    value.setPhone(phone.getValue());
    value.setEmail(email.getValue());
    value.setType(type.getValue());
    value.setAddress(address.getValue());
    value.setEnterpriseEnrolNum(enterpriseEnrolNum.getValue());
    value.setWorkNo(workNo.getValue());
    value.setAptitudeName(aptitudeName.getValue());
    return value;
  }
  
  public UISupplier doGetValue() {
    
    value.setCode(code.getValue());
    value.setName(name.getValue());
    value.setPhone(phone.getValue());
    value.setEmail(email.getValue());
    value.setType(type.getValue());
    value.setAddress(address.getValue());
    value.setEnterpriseEnrolNum(enterpriseEnrolNum.getValue());
    value.setWorkNo(workNo.getValue());
    value.setAptitudeName(aptitudeName.getValue());
    return value;
  }
  
  public UISupplier getValue(final UISupplier copyValue) {
    
    copyValue.setCode(code.getValue());
    copyValue.setName(name.getValue());
    copyValue.setPhone(phone.getValue());
    copyValue.setEmail(email.getValue());
    copyValue.setType(type.getValue());
    copyValue.setAddress(address.getValue());
    copyValue.setEnterpriseEnrolNum(enterpriseEnrolNum.getValue());
    copyValue.setWorkNo(workNo.getValue());
    copyValue.setAptitudeName(aptitudeName.getValue());
    return copyValue;
  }
  
  protected SupplierListGrid doSetValue(final UISupplier value) {
    this.value = value;
    code.setValue(value.getCode());
    name.setValue(value.getName());
    phone.setValue(value.getPhone());
    email.setValue(value.getEmail());
    type.setValue(value.getType());
    address.setValue(value.getAddress());
    enterpriseEnrolNum.setValue(value.getEnterpriseEnrolNum());
    workNo.setValue(value.getWorkNo());
    aptitudeName.setValue(value.getAptitudeName());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)code,(ICanAsWidget)name,(ICanAsWidget)phone,(ICanAsWidget)email,(ICanAsWidget)type,(ICanAsWidget)address,(ICanAsWidget)enterpriseEnrolNum,(ICanAsWidget)workNo,(ICanAsWidget)aptitudeName
    					);
  }
}
