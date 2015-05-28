package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.shared.organization.UIEmployeeCriteria;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.BooleanValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.BooleanValueProviderFactory.CheckBoxItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class EmployeeCriteriaForm extends GXTFormComponent<UIEmployeeCriteria> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public TextItem info;
  
  public CheckBoxItem includeLeaveEmployees;
  
  @Inject
  private BooleanValueProviderFactory booleanValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIEmployeeCriteria value = new UIEmployeeCriteria();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();info = stringValueProviderFactory.createAsEscapedTextItem("info","员工信息关键字");
    widgetsRegistory.put("info",info);
    includeLeaveEmployees = booleanValueProviderFactory.createAsCheckBoxItem("includeLeaveEmployees","含离职员工");
    widgetsRegistory.put("includeLeaveEmployees",includeLeaveEmployees);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIEmployeeCriteria getValueAsNew() {
    UIEmployeeCriteria value = new UIEmployeeCriteria();
    value.setInfo(info.getValue());
    value.setIncludeLeaveEmployees(includeLeaveEmployees.getValue());
    return value;
  }
  
  public UIEmployeeCriteria doGetValue() {
    
    value.setInfo(info.getValue());
    value.setIncludeLeaveEmployees(includeLeaveEmployees.getValue());
    return value;
  }
  
  public UIEmployeeCriteria getValue(final UIEmployeeCriteria copyValue) {
    
    copyValue.setInfo(info.getValue());
    copyValue.setIncludeLeaveEmployees(includeLeaveEmployees.getValue());
    return copyValue;
  }
  
  protected EmployeeCriteriaForm doSetValue(final UIEmployeeCriteria value) {
    this.value = value;
    info.setValue(value.getInfo());
    includeLeaveEmployees.setValue(value.getIncludeLeaveEmployees());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)info,(ICanAsWidget)includeLeaveEmployees
    					);
  }
}
