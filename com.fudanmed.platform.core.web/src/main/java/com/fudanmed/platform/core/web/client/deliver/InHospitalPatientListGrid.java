package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLInHospitalLocationProxy;
import com.fudanmed.platform.core.web.shared.deliver.UIGender;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalPatient;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.IntegerValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.IntegerValueProviderFactory.IntegerColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class InHospitalPatientListGrid extends GXTGridComponent<UIInHospitalPatient> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIInHospitalPatient> name;
  
  public StringColumn<UIInHospitalPatient> sid;
  
  public IntegerColumn<UIInHospitalPatient> age;
  
  public StringValueColumn<UIInHospitalPatient,UIGender> gender;
  
  public StringValueColumn<UIInHospitalPatient,DLInHospitalLocationProxy> location;
  
  public StringColumn<UIInHospitalPatient> bedNumber;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  private UIInHospitalPatient value = new UIInHospitalPatient();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();name = stringValueProviderFactory.createAsStringColumn("name","姓名",UIInHospitalPatient.NameAccessor);
    widgetsRegistory.put("name",name);
    sid = stringValueProviderFactory.createAsStringColumn("sid","住院号",UIInHospitalPatient.SidAccessor);
    widgetsRegistory.put("sid",sid);
    age = integerValueProviderFactory.createAsIntegerColumn("age","年龄",UIInHospitalPatient.AgeAccessor);
    widgetsRegistory.put("age",age);
    gender = defaultObjectSelectorFactory.createAsDefaultColumn("gender","性别",UIInHospitalPatient.GenderAccessor);
    widgetsRegistory.put("gender",gender);
    location = defaultObjectSelectorFactory.createAsDefaultColumn("location","位置",UIInHospitalPatient.LocationAccessor);
    widgetsRegistory.put("location",location);
    bedNumber = stringValueProviderFactory.createAsStringColumn("bedNumber","床号",UIInHospitalPatient.BedNumberAccessor);
    widgetsRegistory.put("bedNumber",bedNumber);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIInHospitalPatient getValueAsNew() {
    UIInHospitalPatient value = new UIInHospitalPatient();
    value.setName(name.getValue());
    value.setSid(sid.getValue());
    value.setAge(age.getValue());
    value.setGender(gender.getValue());
    value.setLocation(location.getValue());
    value.setBedNumber(bedNumber.getValue());
    return value;
  }
  
  public UIInHospitalPatient doGetValue() {
    
    value.setName(name.getValue());
    value.setSid(sid.getValue());
    value.setAge(age.getValue());
    value.setGender(gender.getValue());
    value.setLocation(location.getValue());
    value.setBedNumber(bedNumber.getValue());
    return value;
  }
  
  public UIInHospitalPatient getValue(final UIInHospitalPatient copyValue) {
    
    copyValue.setName(name.getValue());
    copyValue.setSid(sid.getValue());
    copyValue.setAge(age.getValue());
    copyValue.setGender(gender.getValue());
    copyValue.setLocation(location.getValue());
    copyValue.setBedNumber(bedNumber.getValue());
    return copyValue;
  }
  
  protected InHospitalPatientListGrid doSetValue(final UIInHospitalPatient value) {
    this.value = value;
    name.setValue(value.getName());
    sid.setValue(value.getSid());
    age.setValue(value.getAge());
    gender.setValue(value.getGender());
    location.setValue(value.getLocation());
    bedNumber.setValue(value.getBedNumber());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)name,(ICanAsWidget)sid,(ICanAsWidget)age,(ICanAsWidget)gender,(ICanAsWidget)location,(ICanAsWidget)bedNumber
    					);
  }
}
