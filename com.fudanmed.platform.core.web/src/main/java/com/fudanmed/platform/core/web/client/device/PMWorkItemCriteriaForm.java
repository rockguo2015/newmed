package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.web.client.device.UIPMWorkItemStatueContentProvider;
import com.fudanmed.platform.core.web.client.organization.AllMaintenanceTeamContentProvider;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemCriteria;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemStatue;
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

public class PMWorkItemCriteriaForm extends GXTFormComponent<UIPMWorkItemCriteria> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public DateItem assignDateFrom;
  
  public DateItem assignDateTo;
  
  public CheckBoxItem includeFinishedItems;
  
  public ComboBoxSelector<UIPMWorkItemStatue> status;
  
  @Inject
  public UIPMWorkItemStatueContentProvider statusContentProvider;
  
  public ComboBoxSelector<RCMaintenanceTeamProxy> team;
  
  @Inject
  public AllMaintenanceTeamContentProvider teamContentProvider;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private BooleanValueProviderFactory booleanValueProviderFactory;
  
  private UIPMWorkItemCriteria value = new UIPMWorkItemCriteria();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();assignDateFrom = dateValueProviderFactory.createAsDateItem("assignDateFrom","安排日期(开始)");
    widgetsRegistory.put("assignDateFrom",assignDateFrom);
    assignDateTo = dateValueProviderFactory.createAsDateItem("assignDateTo","安排日期(结束)");
    widgetsRegistory.put("assignDateTo",assignDateTo);
    includeFinishedItems = booleanValueProviderFactory.createAsCheckBoxItem("includeFinishedItems","含已完成任务");
    widgetsRegistory.put("includeFinishedItems",includeFinishedItems);
    status = defaultObjectSelectorFactory.createAsComboBoxItem("status","状态");
    status.setContentProvider(statusContentProvider);
    widgetsRegistory.put("status",status);
    team = defaultObjectSelectorFactory.createAsComboBoxItem("team","班组");
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
  
  public UIPMWorkItemCriteria getValueAsNew() {
    UIPMWorkItemCriteria value = new UIPMWorkItemCriteria();
    value.setAssignDateFrom(assignDateFrom.getValue());
    value.setAssignDateTo(assignDateTo.getValue());
    value.setIncludeFinishedItems(includeFinishedItems.getValue());
    value.setStatus(status.getValue());
    value.setTeam(team.getValue());
    return value;
  }
  
  public UIPMWorkItemCriteria doGetValue() {
    
    value.setAssignDateFrom(assignDateFrom.getValue());
    value.setAssignDateTo(assignDateTo.getValue());
    value.setIncludeFinishedItems(includeFinishedItems.getValue());
    value.setStatus(status.getValue());
    value.setTeam(team.getValue());
    return value;
  }
  
  public UIPMWorkItemCriteria getValue(final UIPMWorkItemCriteria copyValue) {
    
    copyValue.setAssignDateFrom(assignDateFrom.getValue());
    copyValue.setAssignDateTo(assignDateTo.getValue());
    copyValue.setIncludeFinishedItems(includeFinishedItems.getValue());
    copyValue.setStatus(status.getValue());
    copyValue.setTeam(team.getValue());
    return copyValue;
  }
  
  protected PMWorkItemCriteriaForm doSetValue(final UIPMWorkItemCriteria value) {
    this.value = value;
    assignDateFrom.setValue(value.getAssignDateFrom());
    assignDateTo.setValue(value.getAssignDateTo());
    includeFinishedItems.setValue(value.getIncludeFinishedItems());
    status.setValue(value.getStatus());
    team.setValue(value.getTeam());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)assignDateFrom,(ICanAsWidget)assignDateTo,(ICanAsWidget)includeFinishedItems,(ICanAsWidget)status,(ICanAsWidget)team
    					);
  }
}
