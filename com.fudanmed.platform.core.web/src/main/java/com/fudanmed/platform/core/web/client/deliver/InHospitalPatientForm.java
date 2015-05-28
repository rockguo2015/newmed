package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLInHospitalLocationProxy;
import com.fudanmed.platform.core.web.client.deliver.PatientLocationContentProvider;
import com.fudanmed.platform.core.web.client.deliver.UIGenderContentProvider;
import com.fudanmed.platform.core.web.shared.deliver.UIGender;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalPatient;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.ComboBoxSelector;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.IntegerValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.IntegerValueProviderFactory.IntegerItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class InHospitalPatientForm extends GXTFormComponent<UIInHospitalPatient> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public TextItem name;
  
  public TextItem sid;
  
  public IntegerItem age;
  
  public ComboBoxSelector<UIGender> gender;
  
  @Inject
  public UIGenderContentProvider genderContentProvider;
  
  public ComboBoxSelector<DLInHospitalLocationProxy> location;
  
  @Inject
  public PatientLocationContentProvider locationContentProvider;
  
  public TextItem bedNumber;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIInHospitalPatient value = new UIInHospitalPatient();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();name = stringValueProviderFactory.createAsTextItem("name","姓名");
    widgetsRegistory.put("name",name);
    sid = stringValueProviderFactory.createAsTextItem("sid","住院号");
    widgetsRegistory.put("sid",sid);
    age = integerValueProviderFactory.createAsIntegerItem("age","年龄");
    widgetsRegistory.put("age",age);
    gender = defaultObjectSelectorFactory.createAsComboBoxItem("gender","性别");
    gender.setContentProvider(genderContentProvider);
    widgetsRegistory.put("gender",gender);
    location = defaultObjectSelectorFactory.createAsComboBoxItem("location","位置");
    _initializerSupports.add(locationContentProvider);
    location.setContentProvider(locationContentProvider);
    widgetsRegistory.put("location",location);
    bedNumber = stringValueProviderFactory.createAsTextItem("bedNumber","床号");
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
  
  protected InHospitalPatientForm doSetValue(final UIInHospitalPatient value) {
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
  
  public Widget createWidget() {
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
        public void apply(final VerticalLayoutContainer it) {
          FieldLabel _asWidget = InHospitalPatientForm.this.name.asWidget();
          WidgetExtensions.<FieldLabel>addFill(it, _asWidget);
          FieldLabel _asWidget_1 = InHospitalPatientForm.this.sid.asWidget();
          WidgetExtensions.<FieldLabel>addFill(it, _asWidget_1);
          FieldLabel _asWidget_2 = InHospitalPatientForm.this.age.asWidget();
          WidgetExtensions.<FieldLabel>addFill(it, _asWidget_2);
          FieldLabel _asWidget_3 = InHospitalPatientForm.this.gender.asWidget();
          WidgetExtensions.<FieldLabel>addFill(it, _asWidget_3);
          FieldLabel _asWidget_4 = InHospitalPatientForm.this.location.asWidget();
          WidgetExtensions.<FieldLabel>addFill(it, _asWidget_4);
          FieldLabel _asWidget_5 = InHospitalPatientForm.this.bedNumber.asWidget();
          WidgetExtensions.<FieldLabel>addFill(it, _asWidget_5);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    return _doubleArrow;
  }
}
