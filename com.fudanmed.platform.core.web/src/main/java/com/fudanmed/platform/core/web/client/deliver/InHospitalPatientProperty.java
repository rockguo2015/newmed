package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLInHospitalLocationProxy;
import com.fudanmed.platform.core.web.shared.deliver.UIGender;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalPatient;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;
import edu.fudan.langlab.gxt.client.component.propertyview.GXTPropertyView;
import edu.fudan.langlab.gxt.client.component.propertyview.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class InHospitalPatientProperty extends GXTPropertyView<UIInHospitalPatient> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public IValueViewer<String> name;
  
  public IValueViewer<String> sid;
  
  public IValueViewer<Integer> age;
  
  public IValueViewer<UIGender> gender;
  
  public IValueViewer<DLInHospitalLocationProxy> location;
  
  public IValueViewer<String> bedNumber;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private UIInHospitalPatient value = new UIInHospitalPatient();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();name = defaultObjectSelectorFactory.createAsPropertyItem("name","姓名");
    widgetsRegistory.put("name",name);
    sid = defaultObjectSelectorFactory.createAsPropertyItem("sid","住院号");
    widgetsRegistory.put("sid",sid);
    age = defaultObjectSelectorFactory.createAsPropertyItem("age","年龄");
    widgetsRegistory.put("age",age);
    gender = defaultObjectSelectorFactory.createAsPropertyItem("gender","性别");
    widgetsRegistory.put("gender",gender);
    location = defaultObjectSelectorFactory.createAsPropertyItem("location","位置");
    widgetsRegistory.put("location",location);
    bedNumber = defaultObjectSelectorFactory.createAsPropertyItem("bedNumber","床号");
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
    return value;
  }
  
  public UIInHospitalPatient doGetValue() {
    
    return value;
  }
  
  public UIInHospitalPatient getValue(final UIInHospitalPatient copyValue) {
    
    return copyValue;
  }
  
  protected InHospitalPatientProperty doSetValue(final UIInHospitalPatient value) {
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
  
  public Integer getCols() {
    return Integer.valueOf(3);
  }
}
