package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.common.proxy.RCFaultLevelProxy;
import com.fudanmed.platform.core.common.proxy.RCWorkTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.web.client.organization.AllFaultLevelContentProvider;
import com.fudanmed.platform.core.web.client.organization.AllMaintenanceTeamContentProvider;
import com.fudanmed.platform.core.web.client.project.AllWorkTypeContentProvider;
import com.fudanmed.platform.core.web.shared.project.UIFaultType;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.BooleanValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.BooleanValueProviderFactory.CheckBoxItem;
import edu.fudan.langlab.gxt.client.component.form.factory.ComboBoxSelector;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DoubleValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DoubleValueProviderFactory.DoubleItem;
import edu.fudan.langlab.gxt.client.component.form.factory.ReadonlyItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class FaultTypeForm extends GXTFormComponent<UIFaultType> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public TextItem name;
  
  public DoubleItem standardCostTime;
  
  public DoubleItem performanceWeight;
  
  public ReadonlyItem<RCMaintenamceTypeProxy> mtype;
  
  public ComboBoxSelector<RCWorkTypeProxy> workType;
  
  @Inject
  public AllWorkTypeContentProvider workTypeContentProvider;
  
  public ComboBoxSelector<RCFaultLevelProxy> faultRiskLevel;
  
  @Inject
  public AllFaultLevelContentProvider faultRiskLevelContentProvider;
  
  public ComboBoxSelector<RCMaintenanceTeamProxy> team;
  
  @Inject
  public AllMaintenanceTeamContentProvider teamContentProvider;
  
  public CheckBoxItem inputNext;
  
  public CheckBoxItem needAudit;
  
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
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();name = stringValueProviderFactory.createAsTextItem("name","名称");
    widgetsRegistory.put("name",name);
    standardCostTime = doubleValueProviderFactory.createAsDoubleItem("standardCostTime","标准工时(小时)");
    widgetsRegistory.put("standardCostTime",standardCostTime);
    performanceWeight = doubleValueProviderFactory.createAsDoubleItem("performanceWeight","绩效系数");
    widgetsRegistory.put("performanceWeight",performanceWeight);
    mtype = defaultObjectSelectorFactory.createAsReadonlyItem("mtype","维修类别");
    widgetsRegistory.put("mtype",mtype);
    workType = defaultObjectSelectorFactory.createAsComboBoxItem("workType","工种");
    _initializerSupports.add(workTypeContentProvider);
    workType.setContentProvider(workTypeContentProvider);
    widgetsRegistory.put("workType",workType);
    faultRiskLevel = defaultObjectSelectorFactory.createAsComboBoxItem("faultRiskLevel","风险等级");
    _initializerSupports.add(faultRiskLevelContentProvider);
    faultRiskLevel.setContentProvider(faultRiskLevelContentProvider);
    widgetsRegistory.put("faultRiskLevel",faultRiskLevel);
    team = defaultObjectSelectorFactory.createAsComboBoxItem("team","维修班组");
    _initializerSupports.add(teamContentProvider);
    team.setContentProvider(teamContentProvider);
    widgetsRegistory.put("team",team);
    inputNext = booleanValueProviderFactory.createAsCheckBoxItem("inputNext","继续输入");
    widgetsRegistory.put("inputNext",inputNext);
    needAudit = booleanValueProviderFactory.createAsCheckBoxItem("needAudit","需审批");
    widgetsRegistory.put("needAudit",needAudit);
    if(con instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)con);
    						}IPostInitializeAction postAction = new IPostInitializeAction() {
    								
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
    value.setStandardCostTime(standardCostTime.getValue());
    value.setPerformanceWeight(performanceWeight.getValue());
    value.setMtype(mtype.getValue());
    value.setWorkType(workType.getValue());
    value.setFaultRiskLevel(faultRiskLevel.getValue());
    value.setTeam(team.getValue());
    value.setInputNext(inputNext.getValue());
    value.setNeedAudit(needAudit.getValue());
    return value;
  }
  
  public UIFaultType doGetValue() {
    
    value.setName(name.getValue());
    value.setStandardCostTime(standardCostTime.getValue());
    value.setPerformanceWeight(performanceWeight.getValue());
    value.setMtype(mtype.getValue());
    value.setWorkType(workType.getValue());
    value.setFaultRiskLevel(faultRiskLevel.getValue());
    value.setTeam(team.getValue());
    value.setInputNext(inputNext.getValue());
    value.setNeedAudit(needAudit.getValue());
    return value;
  }
  
  public UIFaultType getValue(final UIFaultType copyValue) {
    
    copyValue.setName(name.getValue());
    copyValue.setStandardCostTime(standardCostTime.getValue());
    copyValue.setPerformanceWeight(performanceWeight.getValue());
    copyValue.setMtype(mtype.getValue());
    copyValue.setWorkType(workType.getValue());
    copyValue.setFaultRiskLevel(faultRiskLevel.getValue());
    copyValue.setTeam(team.getValue());
    copyValue.setInputNext(inputNext.getValue());
    copyValue.setNeedAudit(needAudit.getValue());
    return copyValue;
  }
  
  protected FaultTypeForm doSetValue(final UIFaultType value) {
    this.value = value;
    name.setValue(value.getName());
    standardCostTime.setValue(value.getStandardCostTime());
    performanceWeight.setValue(value.getPerformanceWeight());
    mtype.setValue(value.getMtype());
    workType.setValue(value.getWorkType());
    faultRiskLevel.setValue(value.getFaultRiskLevel());
    team.setValue(value.getTeam());
    inputNext.setValue(value.getInputNext());
    needAudit.setValue(value.getNeedAudit());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)name,(ICanAsWidget)standardCostTime,(ICanAsWidget)performanceWeight,(ICanAsWidget)mtype,(ICanAsWidget)workType,(ICanAsWidget)faultRiskLevel,(ICanAsWidget)team,(ICanAsWidget)inputNext,(ICanAsWidget)needAudit
    					);
  }
  
  public Widget asWidget() {
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _VLayout = FaultTypeForm.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                FieldLabel _asWidget = FaultTypeForm.this.mtype.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget);
                FieldLabel _asWidget_1 = FaultTypeForm.this.name.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_1);
                FieldLabel _asWidget_2 = FaultTypeForm.this.standardCostTime.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_2);
                FieldLabel _asWidget_3 = FaultTypeForm.this.performanceWeight.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_3);
                FieldLabel _asWidget_4 = FaultTypeForm.this.faultRiskLevel.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_4);
                FieldLabel _asWidget_5 = FaultTypeForm.this.team.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_5);
                FieldLabel _asWidget_6 = FaultTypeForm.this.workType.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_6);
                FieldLabel _asWidget_7 = FaultTypeForm.this.needAudit.asWidget();
                it.add(_asWidget_7);
                FieldLabel _asWidget_8 = FaultTypeForm.this.inputNext.asWidget();
                final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                    public void apply(final FieldLabel it) {
                      FaultTypeForm.this.inputNext.setValue(Boolean.valueOf(true));
                    }
                  };
                FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget_8, _function);
                it.add(_doubleArrow);
              }
            };
          VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
          return _doubleArrow;
        }
      };
    Widget _lazy = ClientUi.<Widget>lazy(this.con, _function);
    Widget _con = this.con = _lazy;
    return _con;
  }
  
  private Widget con;
}
