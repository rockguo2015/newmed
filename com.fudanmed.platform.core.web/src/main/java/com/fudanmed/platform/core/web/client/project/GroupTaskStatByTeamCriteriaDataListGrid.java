package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.web.shared.project.UIGroupTaskStatByTeamCriteriaData;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class GroupTaskStatByTeamCriteriaDataListGrid extends GXTGridComponent<UIGroupTaskStatByTeamCriteriaData> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringValueColumn<UIGroupTaskStatByTeamCriteriaData,RCMaintenanceTeamProxy> team;
  
  public StringValueColumn<UIGroupTaskStatByTeamCriteriaData,Long> cnt;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private UIGroupTaskStatByTeamCriteriaData value = new UIGroupTaskStatByTeamCriteriaData();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();team = defaultObjectSelectorFactory.createAsDefaultColumn("team","班组",UIGroupTaskStatByTeamCriteriaData.TeamAccessor);
    widgetsRegistory.put("team",team);
    cnt = defaultObjectSelectorFactory.createAsDefaultColumn("cnt","数量",UIGroupTaskStatByTeamCriteriaData.CntAccessor);
    widgetsRegistory.put("cnt",cnt);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIGroupTaskStatByTeamCriteriaData getValueAsNew() {
    UIGroupTaskStatByTeamCriteriaData value = new UIGroupTaskStatByTeamCriteriaData();
    value.setTeam(team.getValue());
    value.setCnt(cnt.getValue());
    return value;
  }
  
  public UIGroupTaskStatByTeamCriteriaData doGetValue() {
    
    value.setTeam(team.getValue());
    value.setCnt(cnt.getValue());
    return value;
  }
  
  public UIGroupTaskStatByTeamCriteriaData getValue(final UIGroupTaskStatByTeamCriteriaData copyValue) {
    
    copyValue.setTeam(team.getValue());
    copyValue.setCnt(cnt.getValue());
    return copyValue;
  }
  
  protected GroupTaskStatByTeamCriteriaDataListGrid doSetValue(final UIGroupTaskStatByTeamCriteriaData value) {
    this.value = value;
    team.setValue(value.getTeam());
    cnt.setValue(value.getCnt());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)team,(ICanAsWidget)cnt
    					);
  }
}
