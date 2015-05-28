package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.AllMaintenanceTeamContentProvider;
import com.fudanmed.platform.core.web.client.organization.AllOrganizationContentProvider;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask4SettlementCriteria;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.ComboBoxSelector;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory.DateItem;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class RepairTask4SettlementCriteriaForm extends GXTFormComponent<UIRepairTask4SettlementCriteria> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public DateItem finishDateFrom;
  
  public DateItem finishDateTo;
  
  public ComboBoxSelector<RCMaintenanceTeamProxy> team;
  
  @Inject
  public AllMaintenanceTeamContentProvider teamContentProvider;
  
  public ComboBoxSelector<RCOrganizationProxy> reportOrg;
  
  @Inject
  public AllOrganizationContentProvider reportOrgContentProvider;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private UIRepairTask4SettlementCriteria value = new UIRepairTask4SettlementCriteria();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();finishDateFrom = dateValueProviderFactory.createAsDateItem("finishDateFrom","完工起始日期");
    widgetsRegistory.put("finishDateFrom",finishDateFrom);
    finishDateTo = dateValueProviderFactory.createAsDateItem("finishDateTo","完工结束日期");
    widgetsRegistory.put("finishDateTo",finishDateTo);
    team = defaultObjectSelectorFactory.createAsComboBoxItem("team","维修班组");
    _initializerSupports.add(teamContentProvider);
    team.setContentProvider(teamContentProvider);
    widgetsRegistory.put("team",team);
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
  
  public UIRepairTask4SettlementCriteria getValueAsNew() {
    UIRepairTask4SettlementCriteria value = new UIRepairTask4SettlementCriteria();
    value.setFinishDateFrom(finishDateFrom.getValue());
    value.setFinishDateTo(finishDateTo.getValue());
    value.setTeam(team.getValue());
    value.setReportOrg(reportOrg.getValue());
    return value;
  }
  
  public UIRepairTask4SettlementCriteria doGetValue() {
    
    value.setFinishDateFrom(finishDateFrom.getValue());
    value.setFinishDateTo(finishDateTo.getValue());
    value.setTeam(team.getValue());
    value.setReportOrg(reportOrg.getValue());
    return value;
  }
  
  public UIRepairTask4SettlementCriteria getValue(final UIRepairTask4SettlementCriteria copyValue) {
    
    copyValue.setFinishDateFrom(finishDateFrom.getValue());
    copyValue.setFinishDateTo(finishDateTo.getValue());
    copyValue.setTeam(team.getValue());
    copyValue.setReportOrg(reportOrg.getValue());
    return copyValue;
  }
  
  protected RepairTask4SettlementCriteriaForm doSetValue(final UIRepairTask4SettlementCriteria value) {
    this.value = value;
    finishDateFrom.setValue(value.getFinishDateFrom());
    finishDateTo.setValue(value.getFinishDateTo());
    team.setValue(value.getTeam());
    reportOrg.setValue(value.getReportOrg());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)finishDateFrom,(ICanAsWidget)finishDateTo,(ICanAsWidget)team,(ICanAsWidget)reportOrg
    					);
  }
}
