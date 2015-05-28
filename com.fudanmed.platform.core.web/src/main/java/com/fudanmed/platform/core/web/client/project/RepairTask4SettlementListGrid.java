package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DateValueProviderFactory.DateTimeColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectsSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectsSelectorFactory.CollectionListColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DoubleValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DoubleValueProviderFactory.DoubleColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class RepairTask4SettlementListGrid extends GXTGridComponent<UIRepairTask> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIRepairTask> reportSid;
  
  public DateTimeColumn<UIRepairTask> reportTime;
  
  public DateTimeColumn<UIRepairTask> finishTime;
  
  public StringColumn<UIRepairTask> location;
  
  public StringColumn<UIRepairTask> comment;
  
  public StringColumn<UIRepairTask> reporterName;
  
  public StringValueColumn<UIRepairTask,RCOrganizationProxy> reportOrg;
  
  public CollectionListColumn<UIRepairTask,RCMaintenanceTeamProxy> teams;
  
  public DoubleColumn<UIRepairTask> amount;
  
  @Inject
  private DefaultObjectsSelectorFactory defaultObjectsSelectorFactory;
  
  @Inject
  private DoubleValueProviderFactory doubleValueProviderFactory;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIRepairTask value = new UIRepairTask();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();reportSid = stringValueProviderFactory.createAsStringColumn("reportSid","报修单号",UIRepairTask.ReportSidAccessor,Integer.valueOf(150));
    widgetsRegistory.put("reportSid",reportSid);
    reportTime = dateValueProviderFactory.createAsDateTimeColumn("reportTime","接报时间",UIRepairTask.ReportTimeAccessor);
    widgetsRegistory.put("reportTime",reportTime);
    finishTime = dateValueProviderFactory.createAsDateTimeColumn("finishTime","完成时间",UIRepairTask.FinishTimeAccessor);
    widgetsRegistory.put("finishTime",finishTime);
    location = stringValueProviderFactory.createAsStringColumn("location","报修地点",UIRepairTask.LocationAccessor,Integer.valueOf(150));
    widgetsRegistory.put("location",location);
    comment = stringValueProviderFactory.createAsStringColumn("comment","报修内容",UIRepairTask.CommentAccessor,Integer.valueOf(150));
    widgetsRegistory.put("comment",comment);
    reporterName = stringValueProviderFactory.createAsStringColumn("reporterName","报修人",UIRepairTask.ReporterNameAccessor);
    widgetsRegistory.put("reporterName",reporterName);
    reportOrg = defaultObjectSelectorFactory.createAsDefaultColumn("reportOrg","报修部门",UIRepairTask.ReportOrgAccessor);
    widgetsRegistory.put("reportOrg",reportOrg);
    teams = defaultObjectsSelectorFactory.createAsStringColumn("teams","班组",UIRepairTask.TeamsAccessor);
    widgetsRegistory.put("teams",teams);
    amount = doubleValueProviderFactory.createAsDoubleColumn("amount","材料费",UIRepairTask.AmountAccessor);
    widgetsRegistory.put("amount",amount);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIRepairTask getValueAsNew() {
    UIRepairTask value = new UIRepairTask();
    value.setReportSid(reportSid.getValue());
    value.setReportTime(reportTime.getValue());
    value.setFinishTime(finishTime.getValue());
    value.setLocation(location.getValue());
    value.setComment(comment.getValue());
    value.setReporterName(reporterName.getValue());
    value.setReportOrg(reportOrg.getValue());
    value.setTeams(teams.getValue());
    value.setAmount(amount.getValue());
    return value;
  }
  
  public UIRepairTask doGetValue() {
    
    value.setReportSid(reportSid.getValue());
    value.setReportTime(reportTime.getValue());
    value.setFinishTime(finishTime.getValue());
    value.setLocation(location.getValue());
    value.setComment(comment.getValue());
    value.setReporterName(reporterName.getValue());
    value.setReportOrg(reportOrg.getValue());
    value.setTeams(teams.getValue());
    value.setAmount(amount.getValue());
    return value;
  }
  
  public UIRepairTask getValue(final UIRepairTask copyValue) {
    
    copyValue.setReportSid(reportSid.getValue());
    copyValue.setReportTime(reportTime.getValue());
    copyValue.setFinishTime(finishTime.getValue());
    copyValue.setLocation(location.getValue());
    copyValue.setComment(comment.getValue());
    copyValue.setReporterName(reporterName.getValue());
    copyValue.setReportOrg(reportOrg.getValue());
    copyValue.setTeams(teams.getValue());
    copyValue.setAmount(amount.getValue());
    return copyValue;
  }
  
  protected RepairTask4SettlementListGrid doSetValue(final UIRepairTask value) {
    this.value = value;
    reportSid.setValue(value.getReportSid());
    reportTime.setValue(value.getReportTime());
    finishTime.setValue(value.getFinishTime());
    location.setValue(value.getLocation());
    comment.setValue(value.getComment());
    reporterName.setValue(value.getReporterName());
    reportOrg.setValue(value.getReportOrg());
    teams.setValue(value.getTeams());
    amount.setValue(value.getAmount());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)reportSid,(ICanAsWidget)reportTime,(ICanAsWidget)finishTime,(ICanAsWidget)location,(ICanAsWidget)comment,(ICanAsWidget)reporterName,(ICanAsWidget)reportOrg,(ICanAsWidget)teams,(ICanAsWidget)amount
    					);
  }
  
  public void initializeComponent() {
    this.asMultiSelectGrid();
  }
}
