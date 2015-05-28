package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.AllMaintenanceTeamContentProvider;
import com.fudanmed.platform.core.web.client.organization.AllOrganizationContentProvider;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockStatisticsCriteria;
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

public class WorkItemStockStatisticsCriteriaForm extends GXTFormComponent<UIWorkItemStockStatisticsCriteria> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public DateItem reportDateFrom;
  
  public DateItem reportDateTo;
  
  public ComboBoxSelector<RCOrganizationProxy> reportOrg;
  
  @Inject
  public AllOrganizationContentProvider reportOrgContentProvider;
  
  public ComboBoxSelector<RCMaintenanceTeamProxy> team;
  
  @Inject
  public AllMaintenanceTeamContentProvider teamContentProvider;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private UIWorkItemStockStatisticsCriteria value = new UIWorkItemStockStatisticsCriteria();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();reportDateFrom = dateValueProviderFactory.createAsDateItem("reportDateFrom","领料开始");
    widgetsRegistory.put("reportDateFrom",reportDateFrom);
    reportDateTo = dateValueProviderFactory.createAsDateItem("reportDateTo","领料结束");
    widgetsRegistory.put("reportDateTo",reportDateTo);
    reportOrg = defaultObjectSelectorFactory.createAsComboBoxItem("reportOrg","报修科室");
    _initializerSupports.add(reportOrgContentProvider);
    reportOrg.setContentProvider(reportOrgContentProvider);
    widgetsRegistory.put("reportOrg",reportOrg);
    team = defaultObjectSelectorFactory.createAsComboBoxItem("team","维修班组");
    _initializerSupports.add(teamContentProvider);
    team.setContentProvider(teamContentProvider);
    widgetsRegistory.put("team",team);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIWorkItemStockStatisticsCriteria getValueAsNew() {
    UIWorkItemStockStatisticsCriteria value = new UIWorkItemStockStatisticsCriteria();
    value.setReportDateFrom(reportDateFrom.getValue());
    value.setReportDateTo(reportDateTo.getValue());
    value.setReportOrg(reportOrg.getValue());
    value.setTeam(team.getValue());
    return value;
  }
  
  public UIWorkItemStockStatisticsCriteria doGetValue() {
    
    value.setReportDateFrom(reportDateFrom.getValue());
    value.setReportDateTo(reportDateTo.getValue());
    value.setReportOrg(reportOrg.getValue());
    value.setTeam(team.getValue());
    return value;
  }
  
  public UIWorkItemStockStatisticsCriteria getValue(final UIWorkItemStockStatisticsCriteria copyValue) {
    
    copyValue.setReportDateFrom(reportDateFrom.getValue());
    copyValue.setReportDateTo(reportDateTo.getValue());
    copyValue.setReportOrg(reportOrg.getValue());
    copyValue.setTeam(team.getValue());
    return copyValue;
  }
  
  protected WorkItemStockStatisticsCriteriaForm doSetValue(final UIWorkItemStockStatisticsCriteria value) {
    this.value = value;
    reportDateFrom.setValue(value.getReportDateFrom());
    reportDateTo.setValue(value.getReportDateTo());
    reportOrg.setValue(value.getReportOrg());
    team.setValue(value.getTeam());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)reportDateFrom,(ICanAsWidget)reportDateTo,(ICanAsWidget)reportOrg,(ICanAsWidget)team
    					);
  }
}
