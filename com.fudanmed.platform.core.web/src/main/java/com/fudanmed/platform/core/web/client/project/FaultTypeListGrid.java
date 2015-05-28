package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.common.proxy.RCFaultLevelProxy;
import com.fudanmed.platform.core.common.proxy.RCWorkTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.web.shared.project.UIFaultType;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.BooleanValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.BooleanValueProviderFactory.BooleanColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DoubleValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DoubleValueProviderFactory.DoubleColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class FaultTypeListGrid extends GXTGridComponent<UIFaultType> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIFaultType> name;
  
  public StringValueColumn<UIFaultType,RCMaintenanceTeamProxy> team;
  
  public StringValueColumn<UIFaultType,RCWorkTypeProxy> workType;
  
  public DoubleColumn<UIFaultType> standardCostTime;
  
  public DoubleColumn<UIFaultType> performanceWeight;
  
  public StringValueColumn<UIFaultType,RCFaultLevelProxy> faultRiskLevel;
  
  public BooleanColumn<UIFaultType> needAudit;
  
  @Inject
  private DoubleValueProviderFactory doubleValueProviderFactory;
  
  @Inject
  private BooleanValueProviderFactory booleanValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIFaultType value = new UIFaultType();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();name = stringValueProviderFactory.createAsStringColumn("name","名称",UIFaultType.NameAccessor,Integer.valueOf(150));
    widgetsRegistory.put("name",name);
    team = defaultObjectSelectorFactory.createAsDefaultColumn("team","维修班组",UIFaultType.TeamAccessor,Integer.valueOf(160));
    widgetsRegistory.put("team",team);
    workType = defaultObjectSelectorFactory.createAsDefaultColumn("workType","工种",UIFaultType.WorkTypeAccessor);
    widgetsRegistory.put("workType",workType);
    standardCostTime = doubleValueProviderFactory.createAsDoubleColumn("standardCostTime","标准工时(小时)",UIFaultType.StandardCostTimeAccessor);
    widgetsRegistory.put("standardCostTime",standardCostTime);
    performanceWeight = doubleValueProviderFactory.createAsDoubleColumn("performanceWeight","绩效系数",UIFaultType.PerformanceWeightAccessor);
    widgetsRegistory.put("performanceWeight",performanceWeight);
    faultRiskLevel = defaultObjectSelectorFactory.createAsDefaultColumn("faultRiskLevel","风险等级",UIFaultType.FaultRiskLevelAccessor);
    widgetsRegistory.put("faultRiskLevel",faultRiskLevel);
    needAudit = booleanValueProviderFactory.createAsBooleanColumn("needAudit","需审批",UIFaultType.NeedAuditAccessor);
    widgetsRegistory.put("needAudit",needAudit);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIFaultType getValueAsNew() {
    UIFaultType value = new UIFaultType();
    value.setName(name.getValue());
    value.setTeam(team.getValue());
    value.setWorkType(workType.getValue());
    value.setStandardCostTime(standardCostTime.getValue());
    value.setPerformanceWeight(performanceWeight.getValue());
    value.setFaultRiskLevel(faultRiskLevel.getValue());
    value.setNeedAudit(needAudit.getValue());
    return value;
  }
  
  public UIFaultType doGetValue() {
    
    value.setName(name.getValue());
    value.setTeam(team.getValue());
    value.setWorkType(workType.getValue());
    value.setStandardCostTime(standardCostTime.getValue());
    value.setPerformanceWeight(performanceWeight.getValue());
    value.setFaultRiskLevel(faultRiskLevel.getValue());
    value.setNeedAudit(needAudit.getValue());
    return value;
  }
  
  public UIFaultType getValue(final UIFaultType copyValue) {
    
    copyValue.setName(name.getValue());
    copyValue.setTeam(team.getValue());
    copyValue.setWorkType(workType.getValue());
    copyValue.setStandardCostTime(standardCostTime.getValue());
    copyValue.setPerformanceWeight(performanceWeight.getValue());
    copyValue.setFaultRiskLevel(faultRiskLevel.getValue());
    copyValue.setNeedAudit(needAudit.getValue());
    return copyValue;
  }
  
  protected FaultTypeListGrid doSetValue(final UIFaultType value) {
    this.value = value;
    name.setValue(value.getName());
    team.setValue(value.getTeam());
    workType.setValue(value.getWorkType());
    standardCostTime.setValue(value.getStandardCostTime());
    performanceWeight.setValue(value.getPerformanceWeight());
    faultRiskLevel.setValue(value.getFaultRiskLevel());
    needAudit.setValue(value.getNeedAudit());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)name,(ICanAsWidget)team,(ICanAsWidget)workType,(ICanAsWidget)standardCostTime,(ICanAsWidget)performanceWeight,(ICanAsWidget)faultRiskLevel,(ICanAsWidget)needAudit
    					);
  }
  
  public void initializeComponent() {
    this.asWidget();
    this.unForceFit();
  }
}
