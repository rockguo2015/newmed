package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.AllOrganizationContentProvider;
import com.fudanmed.platform.core.web.client.project.UIRepairTaskStatusContentProvider;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskCriteria;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatus;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.BooleanValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.BooleanValueProviderFactory.CheckBoxItem;
import edu.fudan.langlab.gxt.client.component.form.factory.ComboBoxSelector;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.component.form.factory.UIDateRangeValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.UIDateRangeValueProviderFactory.DateRangeItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class RepairTaskCriteriaForm extends GXTFormComponent<UIRepairTaskCriteria> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public TextItem comment;
  
  public CheckBoxItem includeFinishedTask;
  
  public ComboBoxSelector<RCOrganizationProxy> reportOrg;
  
  @Inject
  public AllOrganizationContentProvider reportOrgContentProvider;
  
  public ComboBoxSelector<UIRepairTaskStatus> status;
  
  @Inject
  public UIRepairTaskStatusContentProvider statusContentProvider;
  
  public DateRangeItem reportDateRange;
  
  @Inject
  private BooleanValueProviderFactory booleanValueProviderFactory;
  
  @Inject
  private UIDateRangeValueProviderFactory uIDateRangeValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIRepairTaskCriteria value = new UIRepairTaskCriteria();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();comment = stringValueProviderFactory.createAsEscapedTextItem("comment","任务信息关键字");
    widgetsRegistory.put("comment",comment);
    includeFinishedTask = booleanValueProviderFactory.createAsCheckBoxItem("includeFinishedTask","含已完成任务");
    widgetsRegistory.put("includeFinishedTask",includeFinishedTask);
    reportOrg = defaultObjectSelectorFactory.createAsComboBoxItem("reportOrg","报修部门");
    _initializerSupports.add(reportOrgContentProvider);
    reportOrg.setContentProvider(reportOrgContentProvider);
    widgetsRegistory.put("reportOrg",reportOrg);
    status = defaultObjectSelectorFactory.createAsComboBoxItem("status","报修单状态");
    status.setContentProvider(statusContentProvider);
    widgetsRegistory.put("status",status);
    reportDateRange = uIDateRangeValueProviderFactory.createAsDateRangeItem("reportDateRange","报修日期范围");
    widgetsRegistory.put("reportDateRange",reportDateRange);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIRepairTaskCriteria getValueAsNew() {
    UIRepairTaskCriteria value = new UIRepairTaskCriteria();
    value.setComment(comment.getValue());
    value.setIncludeFinishedTask(includeFinishedTask.getValue());
    value.setReportOrg(reportOrg.getValue());
    value.setStatus(status.getValue());
    value.setReportDateRange(reportDateRange.getValue());
    return value;
  }
  
  public UIRepairTaskCriteria doGetValue() {
    
    value.setComment(comment.getValue());
    value.setIncludeFinishedTask(includeFinishedTask.getValue());
    value.setReportOrg(reportOrg.getValue());
    value.setStatus(status.getValue());
    value.setReportDateRange(reportDateRange.getValue());
    return value;
  }
  
  public UIRepairTaskCriteria getValue(final UIRepairTaskCriteria copyValue) {
    
    copyValue.setComment(comment.getValue());
    copyValue.setIncludeFinishedTask(includeFinishedTask.getValue());
    copyValue.setReportOrg(reportOrg.getValue());
    copyValue.setStatus(status.getValue());
    copyValue.setReportDateRange(reportDateRange.getValue());
    return copyValue;
  }
  
  protected RepairTaskCriteriaForm doSetValue(final UIRepairTaskCriteria value) {
    this.value = value;
    comment.setValue(value.getComment());
    includeFinishedTask.setValue(value.getIncludeFinishedTask());
    reportOrg.setValue(value.getReportOrg());
    status.setValue(value.getStatus());
    reportDateRange.setValue(value.getReportDateRange());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)comment,(ICanAsWidget)includeFinishedTask,(ICanAsWidget)reportOrg,(ICanAsWidget)status,(ICanAsWidget)reportDateRange
    					);
  }
}
