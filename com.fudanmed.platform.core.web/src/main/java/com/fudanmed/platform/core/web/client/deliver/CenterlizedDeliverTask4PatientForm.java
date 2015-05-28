package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverEmergencyProxy;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy;
import com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy;
import com.fudanmed.platform.core.deliver.proxy.DLPatientDeliverMethodProxy;
import com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTask4PatientListGrid;
import com.fudanmed.platform.core.web.client.deliver.CheckOrgContentProvider;
import com.fudanmed.platform.core.web.client.deliver.DeliverEmergencyContentProvider;
import com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckTypeContentProvider;
import com.fudanmed.platform.core.web.client.deliver.InHospitalPatientContentProvider;
import com.fudanmed.platform.core.web.client.deliver.InHospitalPatientForm;
import com.fudanmed.platform.core.web.client.deliver.PatientDeliverMethodContentProvider;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask4Patient;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.info.Info;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.ComboBoxSelector;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory.DateItem;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory.TimeItem;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectsSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectsSelectorFactory.ListGridBasedItemsProvider;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

public class CenterlizedDeliverTask4PatientForm extends GXTFormComponent<UICenterlizedDeliverTask4Patient> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public DateItem planDate;
  
  public TimeItem planTime;
  
  public ComboBoxSelector<DLInHospitalPatientProxy> patient;
  
  @Inject
  public InHospitalPatientContentProvider patientContentProvider;
  
  public ComboBoxSelector<DLCheckOrganizationProxy> checkOrganization;
  
  @Inject
  public CheckOrgContentProvider checkOrganizationContentProvider;
  
  public ComboBoxSelector<DLDeliverPatientCheckTypeProxy> checkType;
  
  @Inject
  public DeliverPatientCheckTypeContentProvider checkTypeContentProvider;
  
  public ComboBoxSelector<DLPatientDeliverMethodProxy> deliverMethod;
  
  @Inject
  public PatientDeliverMethodContentProvider deliverMethodContentProvider;
  
  public ComboBoxSelector<DLDeliverEmergencyProxy> emergency;
  
  @Inject
  public DeliverEmergencyContentProvider emergencyContentProvider;
  
  public ListGridBasedItemsProvider<UICenterlizedDeliverTask4Patient> patients;
  
  @Inject
  private DefaultObjectsSelectorFactory defaultObjectsSelectorFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private UICenterlizedDeliverTask4Patient value = new UICenterlizedDeliverTask4Patient();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();planDate = dateValueProviderFactory.createAsDateItem("planDate","计划日期");
    widgetsRegistory.put("planDate",planDate);
    planTime = dateValueProviderFactory.createAsTimeItem("planTime","计划时间");
    widgetsRegistory.put("planTime",planTime);
    patient = defaultObjectSelectorFactory.createAsComboBoxItem("patient","病人");
    _initializerSupports.add(patientContentProvider);
    patient.setContentProvider(patientContentProvider);
    widgetsRegistory.put("patient",patient);
    checkOrganization = defaultObjectSelectorFactory.createAsComboBoxItem("checkOrganization","检查科室");
    checkOrganization.setContentProvider(checkOrganizationContentProvider);
    widgetsRegistory.put("checkOrganization",checkOrganization);
    checkType = defaultObjectSelectorFactory.createAsComboBoxItem("checkType","检查项目");
    _initializerSupports.add(checkTypeContentProvider);
    checkType.setContentProvider(checkTypeContentProvider);
    widgetsRegistory.put("checkType",checkType);
    deliverMethod = defaultObjectSelectorFactory.createAsComboBoxItem("deliverMethod","接送方式");
    _initializerSupports.add(deliverMethodContentProvider);
    deliverMethod.setContentProvider(deliverMethodContentProvider);
    widgetsRegistory.put("deliverMethod",deliverMethod);
    emergency = defaultObjectSelectorFactory.createAsComboBoxItem("emergency","紧急度");
    _initializerSupports.add(emergencyContentProvider);
    emergency.setContentProvider(emergencyContentProvider);
    widgetsRegistory.put("emergency",emergency);
    patients = defaultObjectsSelectorFactory.createAsListGridBasedItem("patients","检查项目列表",this.patientList);
    widgetsRegistory.put("patients",patients);
    if(patientForm instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)patientForm);
    						}if(patientList instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)patientList);
    						}IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UICenterlizedDeliverTask4Patient getValueAsNew() {
    UICenterlizedDeliverTask4Patient value = new UICenterlizedDeliverTask4Patient();
    value.setPlanDate(planDate.getValue());
    value.setPlanTime(planTime.getValue());
    value.setPatient(patient.getValue());
    value.setCheckOrganization(checkOrganization.getValue());
    value.setCheckType(checkType.getValue());
    value.setDeliverMethod(deliverMethod.getValue());
    value.setEmergency(emergency.getValue());
    value.setPatients(patients.getValue());
    return value;
  }
  
  public UICenterlizedDeliverTask4Patient doGetValue() {
    
    value.setPlanDate(planDate.getValue());
    value.setPlanTime(planTime.getValue());
    value.setPatient(patient.getValue());
    value.setCheckOrganization(checkOrganization.getValue());
    value.setCheckType(checkType.getValue());
    value.setDeliverMethod(deliverMethod.getValue());
    value.setEmergency(emergency.getValue());
    value.setPatients(patients.getValue());
    return value;
  }
  
  public UICenterlizedDeliverTask4Patient getValue(final UICenterlizedDeliverTask4Patient copyValue) {
    
    copyValue.setPlanDate(planDate.getValue());
    copyValue.setPlanTime(planTime.getValue());
    copyValue.setPatient(patient.getValue());
    copyValue.setCheckOrganization(checkOrganization.getValue());
    copyValue.setCheckType(checkType.getValue());
    copyValue.setDeliverMethod(deliverMethod.getValue());
    copyValue.setEmergency(emergency.getValue());
    copyValue.setPatients(patients.getValue());
    return copyValue;
  }
  
  protected CenterlizedDeliverTask4PatientForm doSetValue(final UICenterlizedDeliverTask4Patient value) {
    this.value = value;
    planDate.setValue(value.getPlanDate());
    planTime.setValue(value.getPlanTime());
    patient.setValue(value.getPatient());
    checkOrganization.setValue(value.getCheckOrganization());
    checkType.setValue(value.getCheckType());
    deliverMethod.setValue(value.getDeliverMethod());
    emergency.setValue(value.getEmergency());
    patients.setValue(value.getPatients());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)planDate,(ICanAsWidget)planTime,(ICanAsWidget)patient,(ICanAsWidget)checkOrganization,(ICanAsWidget)checkType,(ICanAsWidget)deliverMethod,(ICanAsWidget)emergency,(ICanAsWidget)patients
    					);
  }
  
  public Widget createWidget() {
    Widget _xblockexpression = null;
    {
      final Function1<Void,UICenterlizedDeliverTask4Patient> _function = new Function1<Void,UICenterlizedDeliverTask4Patient>() {
          public UICenterlizedDeliverTask4Patient apply(final Void it) {
            UICenterlizedDeliverTask4Patient _xblockexpression = null;
            {
              UICenterlizedDeliverTask4Patient v = CenterlizedDeliverTask4PatientForm.this.getValueAsNew();
              UICenterlizedDeliverTask4Patient _xifexpression = null;
              boolean _or = false;
              boolean _or_1 = false;
              boolean _or_2 = false;
              boolean _or_3 = false;
              boolean _or_4 = false;
              boolean _or_5 = false;
              DLInHospitalPatientProxy _patient = v.getPatient();
              boolean _equals = Objects.equal(_patient, null);
              if (_equals) {
                _or_5 = true;
              } else {
                DLCheckOrganizationProxy _checkOrganization = v.getCheckOrganization();
                boolean _equals_1 = Objects.equal(_checkOrganization, null);
                _or_5 = (_equals || _equals_1);
              }
              if (_or_5) {
                _or_4 = true;
              } else {
                DLDeliverPatientCheckTypeProxy _checkType = v.getCheckType();
                boolean _equals_2 = Objects.equal(_checkType, null);
                _or_4 = (_or_5 || _equals_2);
              }
              if (_or_4) {
                _or_3 = true;
              } else {
                DLPatientDeliverMethodProxy _deliverMethod = v.getDeliverMethod();
                boolean _equals_3 = Objects.equal(_deliverMethod, null);
                _or_3 = (_or_4 || _equals_3);
              }
              if (_or_3) {
                _or_2 = true;
              } else {
                DLDeliverEmergencyProxy _emergency = v.getEmergency();
                boolean _equals_4 = Objects.equal(_emergency, null);
                _or_2 = (_or_3 || _equals_4);
              }
              if (_or_2) {
                _or_1 = true;
              } else {
                Date _planDate = v.getPlanDate();
                boolean _equals_5 = Objects.equal(_planDate, null);
                _or_1 = (_or_2 || _equals_5);
              }
              if (_or_1) {
                _or = true;
              } else {
                Date _planTime = v.getPlanTime();
                boolean _equals_6 = Objects.equal(_planTime, null);
                _or = (_or_1 || _equals_6);
              }
              if (_or) {
                UICenterlizedDeliverTask4Patient _xblockexpression_1 = null;
                {
                  Info.display("\u63D0\u793A", "\u4E0D\u80FD\u6709\u7A7A\u503C");
                  _xblockexpression_1 = (null);
                }
                _xifexpression = _xblockexpression_1;
              } else {
                _xifexpression = v;
              }
              _xblockexpression = (_xifexpression);
            }
            return _xblockexpression;
          }
        };
      this.patients.setObjectCreater(new Function<Void,UICenterlizedDeliverTask4Patient>() {
          public UICenterlizedDeliverTask4Patient apply(Void input) {
            return _function.apply(input);
          }
      });
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  public Collection<UICenterlizedDeliverTask4Patient> getPatientDeliverList() {
    Iterable<UICenterlizedDeliverTask4Patient> _objects = this.patientList.getObjects();
    Collection<UICenterlizedDeliverTask4Patient> _unlazy = IterableExtensions2.<UICenterlizedDeliverTask4Patient>unlazy(_objects);
    return _unlazy;
  }
  
  public InHospitalPatientForm getPatientForm() {
    return this.patientForm;
  }
  
  @Inject
  private InHospitalPatientForm patientForm;
  
  @Inject
  private CenterlizedDeliverTask4PatientListGrid patientList;
}
