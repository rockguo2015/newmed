package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverEmergencyProxy;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy;
import com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy;
import com.fudanmed.platform.core.deliver.proxy.DLPatientDeliverMethodProxy;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask4Patient;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory.DateColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class CenterlizedDeliverTask4PatientListGrid extends GXTGridComponent<UICenterlizedDeliverTask4Patient> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringValueColumn<UICenterlizedDeliverTask4Patient,DLInHospitalPatientProxy> patient;
  
  public StringValueColumn<UICenterlizedDeliverTask4Patient,DLCheckOrganizationProxy> checkOrganization;
  
  public StringValueColumn<UICenterlizedDeliverTask4Patient,DLDeliverPatientCheckTypeProxy> checkType;
  
  public StringValueColumn<UICenterlizedDeliverTask4Patient,DLPatientDeliverMethodProxy> deliverMethod;
  
  public StringValueColumn<UICenterlizedDeliverTask4Patient,DLDeliverEmergencyProxy> emergency;
  
  public DateColumn<UICenterlizedDeliverTask4Patient> planDate;
  
  public DateColumn<UICenterlizedDeliverTask4Patient> planTime;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  private UICenterlizedDeliverTask4Patient value = new UICenterlizedDeliverTask4Patient();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();patient = defaultObjectSelectorFactory.createAsDefaultColumn("patient","病人",UICenterlizedDeliverTask4Patient.PatientAccessor);
    widgetsRegistory.put("patient",patient);
    checkOrganization = defaultObjectSelectorFactory.createAsDefaultColumn("checkOrganization","检查科室",UICenterlizedDeliverTask4Patient.CheckOrganizationAccessor);
    widgetsRegistory.put("checkOrganization",checkOrganization);
    checkType = defaultObjectSelectorFactory.createAsDefaultColumn("checkType","检查项目",UICenterlizedDeliverTask4Patient.CheckTypeAccessor);
    widgetsRegistory.put("checkType",checkType);
    deliverMethod = defaultObjectSelectorFactory.createAsDefaultColumn("deliverMethod","接送方式",UICenterlizedDeliverTask4Patient.DeliverMethodAccessor);
    widgetsRegistory.put("deliverMethod",deliverMethod);
    emergency = defaultObjectSelectorFactory.createAsDefaultColumn("emergency","紧急度",UICenterlizedDeliverTask4Patient.EmergencyAccessor);
    widgetsRegistory.put("emergency",emergency);
    planDate = dateValueProviderFactory.createAsStringColumn("planDate","计划日期",UICenterlizedDeliverTask4Patient.PlanDateAccessor);
    widgetsRegistory.put("planDate",planDate);
    planTime = dateValueProviderFactory.createAsStringColumn("planTime","计划时间",UICenterlizedDeliverTask4Patient.PlanTimeAccessor);
    widgetsRegistory.put("planTime",planTime);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
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
    value.setPatient(patient.getValue());
    value.setCheckOrganization(checkOrganization.getValue());
    value.setCheckType(checkType.getValue());
    value.setDeliverMethod(deliverMethod.getValue());
    value.setEmergency(emergency.getValue());
    value.setPlanDate(planDate.getValue());
    value.setPlanTime(planTime.getValue());
    return value;
  }
  
  public UICenterlizedDeliverTask4Patient doGetValue() {
    
    value.setPatient(patient.getValue());
    value.setCheckOrganization(checkOrganization.getValue());
    value.setCheckType(checkType.getValue());
    value.setDeliverMethod(deliverMethod.getValue());
    value.setEmergency(emergency.getValue());
    value.setPlanDate(planDate.getValue());
    value.setPlanTime(planTime.getValue());
    return value;
  }
  
  public UICenterlizedDeliverTask4Patient getValue(final UICenterlizedDeliverTask4Patient copyValue) {
    
    copyValue.setPatient(patient.getValue());
    copyValue.setCheckOrganization(checkOrganization.getValue());
    copyValue.setCheckType(checkType.getValue());
    copyValue.setDeliverMethod(deliverMethod.getValue());
    copyValue.setEmergency(emergency.getValue());
    copyValue.setPlanDate(planDate.getValue());
    copyValue.setPlanTime(planTime.getValue());
    return copyValue;
  }
  
  protected CenterlizedDeliverTask4PatientListGrid doSetValue(final UICenterlizedDeliverTask4Patient value) {
    this.value = value;
    patient.setValue(value.getPatient());
    checkOrganization.setValue(value.getCheckOrganization());
    checkType.setValue(value.getCheckType());
    deliverMethod.setValue(value.getDeliverMethod());
    emergency.setValue(value.getEmergency());
    planDate.setValue(value.getPlanDate());
    planTime.setValue(value.getPlanTime());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)patient,(ICanAsWidget)checkOrganization,(ICanAsWidget)checkType,(ICanAsWidget)deliverMethod,(ICanAsWidget)emergency,(ICanAsWidget)planDate,(ICanAsWidget)planTime
    					);
  }
}
