package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.AllOrganizationContentProvider;
import com.fudanmed.platform.core.web.client.project.UIGroupTaskStatusContentProvider;
import com.fudanmed.platform.core.web.shared.project.UIGroupTaskCriteria;
import com.fudanmed.platform.core.web.shared.project.UIGroupTaskStatus;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.BooleanValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.BooleanValueProviderFactory.CheckBoxItem;
import edu.fudan.langlab.gxt.client.component.form.factory.ComboBoxSelector;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory.DateItem;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class GroupTaskCriteriaForm extends GXTFormComponent<UIGroupTaskCriteria> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public DateItem dateFrom;
  
  public DateItem dateTo;
  
  public CheckBoxItem includeFinishedTask;
  
  public ComboBoxSelector<UIGroupTaskStatus> status;
  
  @Inject
  public UIGroupTaskStatusContentProvider statusContentProvider;
  
  public ComboBoxSelector<RCOrganizationProxy> reportOrg;
  
  @Inject
  public AllOrganizationContentProvider reportOrgContentProvider;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private BooleanValueProviderFactory booleanValueProviderFactory;
  
  private UIGroupTaskCriteria value = new UIGroupTaskCriteria();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();dateFrom = dateValueProviderFactory.createAsDateItem("dateFrom","开始日期");
    widgetsRegistory.put("dateFrom",dateFrom);
    dateTo = dateValueProviderFactory.createAsDateItem("dateTo","结束日期");
    widgetsRegistory.put("dateTo",dateTo);
    includeFinishedTask = booleanValueProviderFactory.createAsCheckBoxItem("includeFinishedTask","含已完工任务");
    widgetsRegistory.put("includeFinishedTask",includeFinishedTask);
    status = defaultObjectSelectorFactory.createAsComboBoxItem("status","状态");
    status.setContentProvider(statusContentProvider);
    widgetsRegistory.put("status",status);
    reportOrg = defaultObjectSelectorFactory.createAsComboBoxItem("reportOrg","报修部门");
    _initializerSupports.add(reportOrgContentProvider);
    reportOrg.setContentProvider(reportOrgContentProvider);
    widgetsRegistory.put("reportOrg",reportOrg);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIGroupTaskCriteria getValueAsNew() {
    UIGroupTaskCriteria value = new UIGroupTaskCriteria();
    value.setDateFrom(dateFrom.getValue());
    value.setDateTo(dateTo.getValue());
    value.setIncludeFinishedTask(includeFinishedTask.getValue());
    value.setStatus(status.getValue());
    value.setReportOrg(reportOrg.getValue());
    return value;
  }
  
  public UIGroupTaskCriteria doGetValue() {
    
    value.setDateFrom(dateFrom.getValue());
    value.setDateTo(dateTo.getValue());
    value.setIncludeFinishedTask(includeFinishedTask.getValue());
    value.setStatus(status.getValue());
    value.setReportOrg(reportOrg.getValue());
    return value;
  }
  
  public UIGroupTaskCriteria getValue(final UIGroupTaskCriteria copyValue) {
    
    copyValue.setDateFrom(dateFrom.getValue());
    copyValue.setDateTo(dateTo.getValue());
    copyValue.setIncludeFinishedTask(includeFinishedTask.getValue());
    copyValue.setStatus(status.getValue());
    copyValue.setReportOrg(reportOrg.getValue());
    return copyValue;
  }
  
  protected GroupTaskCriteriaForm doSetValue(final UIGroupTaskCriteria value) {
    this.value = value;
    dateFrom.setValue(value.getDateFrom());
    dateTo.setValue(value.getDateTo());
    includeFinishedTask.setValue(value.getIncludeFinishedTask());
    status.setValue(value.getStatus());
    reportOrg.setValue(value.getReportOrg());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)dateFrom,(ICanAsWidget)dateTo,(ICanAsWidget)includeFinishedTask,(ICanAsWidget)status,(ICanAsWidget)reportOrg
    					);
  }
}
