package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.web.client.warehouse.CurrentUserStockTeamProvider;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemTaskCriteria;
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
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class WorkItemTaskCriteriaForm extends GXTFormComponent<UIWorkItemTaskCriteria> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public TextItem sid;
  
  public CheckBoxItem showAll;
  
  public ComboBoxSelector<RCMaintenanceTeamProxy> team;
  
  @Inject
  public CurrentUserStockTeamProvider teamContentProvider;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private BooleanValueProviderFactory booleanValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIWorkItemTaskCriteria value = new UIWorkItemTaskCriteria();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sid = stringValueProviderFactory.createAsEscapedTextItem("sid","工单编号");
    widgetsRegistory.put("sid",sid);
    showAll = booleanValueProviderFactory.createAsCheckBoxItem("showAll","含已完工工单");
    widgetsRegistory.put("showAll",showAll);
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
  
  public UIWorkItemTaskCriteria getValueAsNew() {
    UIWorkItemTaskCriteria value = new UIWorkItemTaskCriteria();
    value.setSid(sid.getValue());
    value.setShowAll(showAll.getValue());
    value.setTeam(team.getValue());
    return value;
  }
  
  public UIWorkItemTaskCriteria doGetValue() {
    
    value.setSid(sid.getValue());
    value.setShowAll(showAll.getValue());
    value.setTeam(team.getValue());
    return value;
  }
  
  public UIWorkItemTaskCriteria getValue(final UIWorkItemTaskCriteria copyValue) {
    
    copyValue.setSid(sid.getValue());
    copyValue.setShowAll(showAll.getValue());
    copyValue.setTeam(team.getValue());
    return copyValue;
  }
  
  protected WorkItemTaskCriteriaForm doSetValue(final UIWorkItemTaskCriteria value) {
    this.value = value;
    sid.setValue(value.getSid());
    showAll.setValue(value.getShowAll());
    team.setValue(value.getTeam());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)sid,(ICanAsWidget)showAll,(ICanAsWidget)team
    					);
  }
}
