package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.AllMaintenanceTeamContentProvider;
import com.fudanmed.platform.core.web.client.organization.AllOrgEmployeeContentProvider;
import com.fudanmed.platform.core.web.client.organization.AllOrganizationContentProvider;
import com.fudanmed.platform.core.web.client.organization.EmployeeListView;
import com.fudanmed.platform.core.web.client.project.UIRepairTaskStatusContentProvider;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatisticCriteria;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatus;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.ComboBoxSelector;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.component.form.factory.UIDateRangeValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.UIDateRangeValueProviderFactory.DateRangeItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class RepairTaskStatisticCriteriaForm extends GXTFormComponent<UIRepairTaskStatisticCriteria> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public ComboBoxSelector<RCOrganizationProxy> reportOrg;
  
  @Inject
  public AllOrganizationContentProvider reportOrgContentProvider;
  
  public ComboBoxSelector<RCMaintenanceTeamProxy> team;
  
  @Inject
  public AllMaintenanceTeamContentProvider teamContentProvider;
  
  public ComboBoxSelector<RCEmployeeProxy> worker;
  
  @Inject
  public AllOrgEmployeeContentProvider workerContentProvider;
  
  public DateRangeItem reportDateRange;
  
  public TextItem comment;
  
  public ComboBoxSelector<UIRepairTaskStatus> status;
  
  @Inject
  public UIRepairTaskStatusContentProvider statusContentProvider;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private UIDateRangeValueProviderFactory uIDateRangeValueProviderFactory;
  
  private UIRepairTaskStatisticCriteria value = new UIRepairTaskStatisticCriteria();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();reportOrg = defaultObjectSelectorFactory.createAsComboBoxItem("reportOrg","报修部门");
    _initializerSupports.add(reportOrgContentProvider);
    reportOrg.setContentProvider(reportOrgContentProvider);
    widgetsRegistory.put("reportOrg",reportOrg);
    team = defaultObjectSelectorFactory.createAsComboBoxItem("team","维修班组");
    _initializerSupports.add(teamContentProvider);
    team.setContentProvider(teamContentProvider);
    widgetsRegistory.put("team",team);
    worker = defaultObjectSelectorFactory.createAsComboBoxItem("worker","维修人员");
    worker.setContentProvider(workerContentProvider);
    widgetsRegistory.put("worker",worker);
    reportDateRange = uIDateRangeValueProviderFactory.createAsDateRangeItem("reportDateRange","报修日期");
    widgetsRegistory.put("reportDateRange",reportDateRange);
    comment = stringValueProviderFactory.createAsEscapedTextItem("comment","报修信息");
    widgetsRegistory.put("comment",comment);
    status = defaultObjectSelectorFactory.createAsComboBoxItem("status","报修单状态");
    status.setContentProvider(statusContentProvider);
    widgetsRegistory.put("status",status);
    if(employeeListView instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)employeeListView);
    						}IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIRepairTaskStatisticCriteria getValueAsNew() {
    UIRepairTaskStatisticCriteria value = new UIRepairTaskStatisticCriteria();
    value.setReportOrg(reportOrg.getValue());
    value.setTeam(team.getValue());
    value.setWorker(worker.getValue());
    value.setReportDateRange(reportDateRange.getValue());
    value.setComment(comment.getValue());
    value.setStatus(status.getValue());
    return value;
  }
  
  public UIRepairTaskStatisticCriteria doGetValue() {
    
    value.setReportOrg(reportOrg.getValue());
    value.setTeam(team.getValue());
    value.setWorker(worker.getValue());
    value.setReportDateRange(reportDateRange.getValue());
    value.setComment(comment.getValue());
    value.setStatus(status.getValue());
    return value;
  }
  
  public UIRepairTaskStatisticCriteria getValue(final UIRepairTaskStatisticCriteria copyValue) {
    
    copyValue.setReportOrg(reportOrg.getValue());
    copyValue.setTeam(team.getValue());
    copyValue.setWorker(worker.getValue());
    copyValue.setReportDateRange(reportDateRange.getValue());
    copyValue.setComment(comment.getValue());
    copyValue.setStatus(status.getValue());
    return copyValue;
  }
  
  protected RepairTaskStatisticCriteriaForm doSetValue(final UIRepairTaskStatisticCriteria value) {
    this.value = value;
    reportOrg.setValue(value.getReportOrg());
    team.setValue(value.getTeam());
    worker.setValue(value.getWorker());
    reportDateRange.setValue(value.getReportDateRange());
    comment.setValue(value.getComment());
    status.setValue(value.getStatus());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)reportOrg,(ICanAsWidget)team,(ICanAsWidget)worker,(ICanAsWidget)reportDateRange,(ICanAsWidget)comment,(ICanAsWidget)status
    					);
  }
  
  @Inject
  private EmployeeListView employeeListView;
}
