package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.common.proxy.RCFaultEmergencyLevelProxy;
import com.fudanmed.platform.core.common.proxy.RCFaultLevelProxy;
import com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.AllFaultEmergencyLevelContentProvider;
import com.fudanmed.platform.core.web.client.organization.AllFaultLevelContentProvider;
import com.fudanmed.platform.core.web.client.organization.AllMaintenanceTeamContentProvider;
import com.fudanmed.platform.core.web.client.organization.AllOrganizationAsyncContentProvider;
import com.fudanmed.platform.core.web.client.project.AllFaultTypeSContentProvider;
import com.fudanmed.platform.core.web.client.project.FaultReportSourceContentProvider;
import com.fudanmed.platform.core.web.client.project.FaultTypeListView;
import com.fudanmed.platform.core.web.client.project.MaintenamceTypeManagementPresenter;
import com.fudanmed.platform.core.web.shared.project.UIFaultType;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.sencha.gxt.widget.core.client.Dialog;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;
import com.uniquesoft.gwt.shared.DateUtil;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.BooleanValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.BooleanValueProviderFactory.CheckBoxItem;
import edu.fudan.langlab.gxt.client.component.form.factory.ComboBoxSelector;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory.DateItem;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory.TimeItem;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextAreaItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.component.form.factory.SuggestionComboBoxSelector;
import edu.fudan.langlab.gxt.client.selector.ObjectSelector;
import edu.fudan.langlab.gxt.client.widget.HTMLTagsExt;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTD;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTR;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTable;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import java.util.Date;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;

public class RepairTaskForm extends GXTFormComponent<UIRepairTask> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public ComboBoxSelector<RCFaultReportSourceProxy> faultReportSource;
  
  @Inject
  public FaultReportSourceContentProvider faultReportSourceContentProvider;
  
  public CheckBoxItem saveOnly;
  
  public DateItem reportDate;
  
  public TimeItem reportTime;
  
  public DateItem reserveDate;
  
  public TimeItem reserveTime;
  
  public DateItem planFinishDate;
  
  public TimeItem planFinishTime;
  
  public TextItem location;
  
  public TextAreaItem comment;
  
  public TextItem reporterName;
  
  public TextItem reporterPhone;
  
  public SuggestionComboBoxSelector<RCOrganizationProxy> reportOrg;
  
  @Inject
  public AllOrganizationAsyncContentProvider reportOrgContentProvider;
  
  public ComboBoxSelector<RCMaintenanceTeamProxy> activeTeam;
  
  @Inject
  public AllMaintenanceTeamContentProvider activeTeamContentProvider;
  
  public ComboBoxSelector<RCFaultLevelProxy> faultLevel;
  
  @Inject
  public AllFaultLevelContentProvider faultLevelContentProvider;
  
  public SuggestionComboBoxSelector<UIFaultType> faultType;
  
  @Inject
  public AllFaultTypeSContentProvider faultTypeContentProvider;
  
  public ComboBoxSelector<RCFaultEmergencyLevelProxy> faultEmergencyLevel;
  
  @Inject
  public AllFaultEmergencyLevelContentProvider faultEmergencyLevelContentProvider;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private BooleanValueProviderFactory booleanValueProviderFactory;
  
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
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();faultReportSource = defaultObjectSelectorFactory.createAsComboBoxItem("faultReportSource","报修来源");
    _initializerSupports.add(faultReportSourceContentProvider);
    faultReportSource.setContentProvider(faultReportSourceContentProvider);
    widgetsRegistory.put("faultReportSource",faultReportSource);
    saveOnly = booleanValueProviderFactory.createAsCheckBoxItem("saveOnly","直接下发班组");
    widgetsRegistory.put("saveOnly",saveOnly);
    reportDate = dateValueProviderFactory.createAsDateItem("reportDate","接报日期");
    widgetsRegistory.put("reportDate",reportDate);
    reportTime = dateValueProviderFactory.createAsTimeItem("reportTime","接报时间");
    widgetsRegistory.put("reportTime",reportTime);
    reserveDate = dateValueProviderFactory.createAsDateItem("reserveDate","预约日期");
    widgetsRegistory.put("reserveDate",reserveDate);
    reserveTime = dateValueProviderFactory.createAsTimeItem("reserveTime","预约时间");
    widgetsRegistory.put("reserveTime",reserveTime);
    planFinishDate = dateValueProviderFactory.createAsDateItem("planFinishDate","计划完成日期");
    widgetsRegistory.put("planFinishDate",planFinishDate);
    planFinishTime = dateValueProviderFactory.createAsTimeItem("planFinishTime","计划完成时间");
    widgetsRegistory.put("planFinishTime",planFinishTime);
    location = stringValueProviderFactory.createAsRequiredTextItem("location","报修地点");
    widgetsRegistory.put("location",location);
    comment = stringValueProviderFactory.createAsTextAreaItem("comment","报修内容");
    widgetsRegistory.put("comment",comment);
    reporterName = stringValueProviderFactory.createAsRequiredTextItem("reporterName","报修人");
    widgetsRegistory.put("reporterName",reporterName);
    reporterPhone = stringValueProviderFactory.createAsTextItem("reporterPhone","报修人电话");
    widgetsRegistory.put("reporterPhone",reporterPhone);
    reportOrg = defaultObjectSelectorFactory.createAsRequiredSuggestionItem("reportOrg","报修部门");
    reportOrg.setContentProvider(reportOrgContentProvider);
    widgetsRegistory.put("reportOrg",reportOrg);
    activeTeam = defaultObjectSelectorFactory.createAsComboBoxItem("activeTeam","维修班组");
    _initializerSupports.add(activeTeamContentProvider);
    activeTeam.setContentProvider(activeTeamContentProvider);
    widgetsRegistory.put("activeTeam",activeTeam);
    faultLevel = defaultObjectSelectorFactory.createAsComboBoxItem("faultLevel","风险等级");
    _initializerSupports.add(faultLevelContentProvider);
    faultLevel.setContentProvider(faultLevelContentProvider);
    widgetsRegistory.put("faultLevel",faultLevel);
    faultType = defaultObjectSelectorFactory.createAsRequiredSuggestionItem("faultType","维修类别",this.faultTypeListView);
    faultType.setContentProvider(faultTypeContentProvider);
    widgetsRegistory.put("faultType",faultType);
    faultEmergencyLevel = defaultObjectSelectorFactory.createAsComboBoxItem("faultEmergencyLevel","紧急度");
    _initializerSupports.add(faultEmergencyLevelContentProvider);
    faultEmergencyLevel.setContentProvider(faultEmergencyLevelContentProvider);
    widgetsRegistory.put("faultEmergencyLevel",faultEmergencyLevel);
    if(maintenamceTypeManagementPresenter instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)maintenamceTypeManagementPresenter);
    						}if(faultTypeListView instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)faultTypeListView);
    						}if(eventBus instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)eventBus);
    						}if(con instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
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
  
  public UIRepairTask getValueAsNew() {
    UIRepairTask value = new UIRepairTask();
    value.setFaultReportSource(faultReportSource.getValue());
    value.setSaveOnly(saveOnly.getValue());
    value.setReportDate(reportDate.getValue());
    value.setReportTime(reportTime.getValue());
    value.setReserveDate(reserveDate.getValue());
    value.setReserveTime(reserveTime.getValue());
    value.setPlanFinishDate(planFinishDate.getValue());
    value.setPlanFinishTime(planFinishTime.getValue());
    value.setLocation(location.getValue());
    value.setComment(comment.getValue());
    value.setReporterName(reporterName.getValue());
    value.setReporterPhone(reporterPhone.getValue());
    value.setReportOrg(reportOrg.getValue());
    value.setActiveTeam(activeTeam.getValue());
    value.setFaultLevel(faultLevel.getValue());
    value.setFaultType(faultType.getValue());
    value.setFaultEmergencyLevel(faultEmergencyLevel.getValue());
    return value;
  }
  
  public UIRepairTask doGetValue() {
    
    value.setFaultReportSource(faultReportSource.getValue());
    value.setSaveOnly(saveOnly.getValue());
    value.setReportDate(reportDate.getValue());
    value.setReportTime(reportTime.getValue());
    value.setReserveDate(reserveDate.getValue());
    value.setReserveTime(reserveTime.getValue());
    value.setPlanFinishDate(planFinishDate.getValue());
    value.setPlanFinishTime(planFinishTime.getValue());
    value.setLocation(location.getValue());
    value.setComment(comment.getValue());
    value.setReporterName(reporterName.getValue());
    value.setReporterPhone(reporterPhone.getValue());
    value.setReportOrg(reportOrg.getValue());
    value.setActiveTeam(activeTeam.getValue());
    value.setFaultLevel(faultLevel.getValue());
    value.setFaultType(faultType.getValue());
    value.setFaultEmergencyLevel(faultEmergencyLevel.getValue());
    return value;
  }
  
  public UIRepairTask getValue(final UIRepairTask copyValue) {
    
    copyValue.setFaultReportSource(faultReportSource.getValue());
    copyValue.setSaveOnly(saveOnly.getValue());
    copyValue.setReportDate(reportDate.getValue());
    copyValue.setReportTime(reportTime.getValue());
    copyValue.setReserveDate(reserveDate.getValue());
    copyValue.setReserveTime(reserveTime.getValue());
    copyValue.setPlanFinishDate(planFinishDate.getValue());
    copyValue.setPlanFinishTime(planFinishTime.getValue());
    copyValue.setLocation(location.getValue());
    copyValue.setComment(comment.getValue());
    copyValue.setReporterName(reporterName.getValue());
    copyValue.setReporterPhone(reporterPhone.getValue());
    copyValue.setReportOrg(reportOrg.getValue());
    copyValue.setActiveTeam(activeTeam.getValue());
    copyValue.setFaultLevel(faultLevel.getValue());
    copyValue.setFaultType(faultType.getValue());
    copyValue.setFaultEmergencyLevel(faultEmergencyLevel.getValue());
    return copyValue;
  }
  
  protected RepairTaskForm doSetValue(final UIRepairTask value) {
    this.value = value;
    faultReportSource.setValue(value.getFaultReportSource());
    saveOnly.setValue(value.getSaveOnly());
    reportDate.setValue(value.getReportDate());
    reportTime.setValue(value.getReportTime());
    reserveDate.setValue(value.getReserveDate());
    reserveTime.setValue(value.getReserveTime());
    planFinishDate.setValue(value.getPlanFinishDate());
    planFinishTime.setValue(value.getPlanFinishTime());
    location.setValue(value.getLocation());
    comment.setValue(value.getComment());
    reporterName.setValue(value.getReporterName());
    reporterPhone.setValue(value.getReporterPhone());
    reportOrg.setValue(value.getReportOrg());
    activeTeam.setValue(value.getActiveTeam());
    faultLevel.setValue(value.getFaultLevel());
    faultType.setValue(value.getFaultType());
    faultEmergencyLevel.setValue(value.getFaultEmergencyLevel());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)faultReportSource,(ICanAsWidget)saveOnly,(ICanAsWidget)reportDate,(ICanAsWidget)reportTime,(ICanAsWidget)reserveDate,(ICanAsWidget)reserveTime,(ICanAsWidget)planFinishDate,(ICanAsWidget)planFinishTime,(ICanAsWidget)location,(ICanAsWidget)comment,(ICanAsWidget)reporterName,(ICanAsWidget)reporterPhone,(ICanAsWidget)reportOrg,(ICanAsWidget)activeTeam,(ICanAsWidget)faultLevel,(ICanAsWidget)faultType,(ICanAsWidget)faultEmergencyLevel
    					);
  }
  
  public Widget asWidget() {
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _VLayout = RepairTaskForm.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                PlainHTMLTable _TABLE = HTMLTagsExt.TABLE();
                final Procedure1<PlainHTMLTable> _function = new Procedure1<PlainHTMLTable>() {
                    public void apply(final PlainHTMLTable it) {
                      PlainHTMLTR _tr = HTMLTagsExt.tr(it);
                      final Procedure1<PlainHTMLTR> _function = new Procedure1<PlainHTMLTR>() {
                          public void apply(final PlainHTMLTR it) {
                            PlainHTMLTD _td = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = RepairTaskForm.this.faultReportSource.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                            PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr, _function);
                      PlainHTMLTR _tr_1 = HTMLTagsExt.tr(it);
                      final Procedure1<PlainHTMLTR> _function_1 = new Procedure1<PlainHTMLTR>() {
                          public void apply(final PlainHTMLTR it) {
                            PlainHTMLTD _td = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  it.setColSpan(2);
                                  FieldLabel _asWidget = RepairTaskForm.this.reportOrg.asWidget();
                                  final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                      public void apply(final FieldLabel it) {
                                        it.setWidth("97%");
                                      }
                                    };
                                  FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function);
                                  ClientUi.operator_add(it, _doubleArrow);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_1, _function_1);
                      PlainHTMLTR _tr_2 = HTMLTagsExt.tr(it);
                      final Procedure1<PlainHTMLTR> _function_2 = new Procedure1<PlainHTMLTR>() {
                          public void apply(final PlainHTMLTR it) {
                            PlainHTMLTD _td = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = RepairTaskForm.this.reportDate.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                            PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = RepairTaskForm.this.reportTime.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_2, _function_2);
                      PlainHTMLTR _tr_3 = HTMLTagsExt.tr(it);
                      final Procedure1<PlainHTMLTR> _function_3 = new Procedure1<PlainHTMLTR>() {
                          public void apply(final PlainHTMLTR it) {
                            PlainHTMLTD _td = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = RepairTaskForm.this.reporterName.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                            PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = RepairTaskForm.this.reporterPhone.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_3, _function_3);
                      PlainHTMLTR _tr_4 = HTMLTagsExt.tr(it);
                      final Procedure1<PlainHTMLTR> _function_4 = new Procedure1<PlainHTMLTR>() {
                          public void apply(final PlainHTMLTR it) {
                            PlainHTMLTD _td = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  it.setColSpan(2);
                                  FieldLabel _asWidget = RepairTaskForm.this.location.asWidget();
                                  final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                      public void apply(final FieldLabel it) {
                                        it.setWidth("97%");
                                      }
                                    };
                                  FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function);
                                  ClientUi.operator_add(it, _doubleArrow);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_4, _function_4);
                      PlainHTMLTR _tr_5 = HTMLTagsExt.tr(it);
                      final Procedure1<PlainHTMLTR> _function_5 = new Procedure1<PlainHTMLTR>() {
                          public void apply(final PlainHTMLTR it) {
                            PlainHTMLTD _td = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  PlainHTMLTable _TABLE = HTMLTagsExt.TABLE();
                                  final Procedure1<PlainHTMLTable> _function = new Procedure1<PlainHTMLTable>() {
                                      public void apply(final PlainHTMLTable it) {
                                        PlainHTMLTR _tr = HTMLTagsExt.tr(it);
                                        final Procedure1<PlainHTMLTR> _function = new Procedure1<PlainHTMLTR>() {
                                            public void apply(final PlainHTMLTR it) {
                                              PlainHTMLTD _td = HTMLTagsExt.td(it);
                                              final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                                  public void apply(final PlainHTMLTD it) {
                                                    FieldLabel _asWidget = RepairTaskForm.this.faultType.asWidget();
                                                    ClientUi.operator_add(it, _asWidget);
                                                    final Procedure1<Iterable<UIFaultType>> _function = new Procedure1<Iterable<UIFaultType>>() {
                                                        public void apply(final Iterable<UIFaultType> it) {
                                                          UIFaultType _onlySelected = IterableExtensions2.<UIFaultType>getOnlySelected(it);
                                                          RepairTaskForm.this.faultTypeSelected(_onlySelected);
                                                        }
                                                      };
                                                    RepairTaskForm.this.faultType.addSelectionChangedListener(new SelectionChangedListener<UIFaultType>() {
                                                        public void selectionChanged(Iterable<UIFaultType> selections) {
                                                          _function.apply(selections);
                                                        }
                                                    });
                                                    final Function1<UIFaultType,String> _function_1 = new Function1<UIFaultType,String>() {
                                                        public String apply(final UIFaultType ft) {
                                                          String _name = ft.getName();
                                                          Double _standardCostTime = ft.getStandardCostTime();
                                                          String _string = _standardCostTime.toString();
                                                          String _plus = (_name + _string);
                                                          return _plus;
                                                        }
                                                      };
                                                    RepairTaskForm.this.faultType.setRenderer(_function_1);
                                                  }
                                                };
                                              ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                                              PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                                              final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                                  public void apply(final PlainHTMLTD it) {
                                                    TextButton _TextButton = RepairTaskForm.this.widgets.TextButton("\u9009\u62E9");
                                                    final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                                                        public void apply(final TextButton it) {
                                                          final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                                              public void apply(final SelectEvent it) {
                                                                MaintenamceTypeManagementPresenter _get = RepairTaskForm.this.maintenamceTypeManagementPresenter.get();
                                                                final Procedure1<MaintenamceTypeManagementPresenter> _function = new Procedure1<MaintenamceTypeManagementPresenter>() {
                                                                    public void apply(final MaintenamceTypeManagementPresenter it) {
                                                                      final Procedure1<MaintenamceTypeManagementPresenter> _function = new Procedure1<MaintenamceTypeManagementPresenter>() {
                                                                          public void apply(final MaintenamceTypeManagementPresenter it) {
                                                                            final Procedure1<UIFaultType> _function = new Procedure1<UIFaultType>() {
                                                                                public void apply(final UIFaultType it) {
                                                                                  RepairTaskForm.this.faultTypeSelected(it);
                                                                                }
                                                                              };
                                                                            Dialog _asSelector = ObjectSelector.<UIFaultType>asSelector(it, "\u9009\u62E9\u7EF4\u4FEE\u7C7B\u522B", 800, 400, _function);
                                                                            _asSelector.show();
                                                                          }
                                                                        };
                                                                      it.setup4Selector(new IPresenterInitiazerNotifier<MaintenamceTypeManagementPresenter>() {
                                                                          public void done(MaintenamceTypeManagementPresenter presenter) {
                                                                            _function.apply(presenter);
                                                                          }
                                                                      });
                                                                    }
                                                                  };
                                                                ObjectExtensions.<MaintenamceTypeManagementPresenter>operator_doubleArrow(_get, _function);
                                                              }
                                                            };
                                                          it.addSelectHandler(new SelectHandler() {
                                                              public void onSelect(SelectEvent event) {
                                                                _function.apply(event);
                                                              }
                                                          });
                                                        }
                                                      };
                                                    TextButton _doubleArrow = ObjectExtensions.<TextButton>operator_doubleArrow(_TextButton, _function);
                                                    ClientUi.operator_add(it, _doubleArrow);
                                                  }
                                                };
                                              ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                                            }
                                          };
                                        ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr, _function);
                                      }
                                    };
                                  PlainHTMLTable _doubleArrow = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE, _function);
                                  ClientUi.operator_add(it, _doubleArrow);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                            PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = RepairTaskForm.this.activeTeam.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_5, _function_5);
                      PlainHTMLTR _tr_6 = HTMLTagsExt.tr(it);
                      final Procedure1<PlainHTMLTR> _function_6 = new Procedure1<PlainHTMLTR>() {
                          public void apply(final PlainHTMLTR it) {
                            PlainHTMLTD _td = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = RepairTaskForm.this.comment.asWidget();
                                  final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                      public void apply(final FieldLabel it) {
                                        it.setHeight(50);
                                      }
                                    };
                                  FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function);
                                  ClientUi.operator_add(it, _doubleArrow);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                            PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = RepairTaskForm.this.saveOnly.asWidget();
                                  final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                      public void apply(final FieldLabel it) {
                                        final Procedure1<Boolean> _function = new Procedure1<Boolean>() {
                                            public void apply(final Boolean dispatch) {
                                              if ((dispatch).booleanValue()) {
                                                FieldLabel _asWidget = RepairTaskForm.this.activeTeam.asWidget();
                                                _asWidget.enable();
                                              } else {
                                                FieldLabel _asWidget_1 = RepairTaskForm.this.activeTeam.asWidget();
                                                _asWidget_1.disable();
                                              }
                                            }
                                          };
                                        RepairTaskForm.this.saveOnly.addValueChangedListener(new ValueChangedListener<Boolean>() {
                                            public void onValueChanged(Boolean value) {
                                              _function.apply(value);
                                            }
                                        });
                                        it.setWidth(120);
                                      }
                                    };
                                  FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function);
                                  ClientUi.operator_add(it, _doubleArrow);
                                  RepairTaskForm.this.saveOnly.setValue(Boolean.valueOf(true));
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_6, _function_6);
                      PlainHTMLTR _tr_7 = HTMLTagsExt.tr(it);
                      final Procedure1<PlainHTMLTR> _function_7 = new Procedure1<PlainHTMLTR>() {
                          public void apply(final PlainHTMLTR it) {
                            PlainHTMLTD _td = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = RepairTaskForm.this.faultLevel.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                            PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = RepairTaskForm.this.faultEmergencyLevel.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_7, _function_7);
                      PlainHTMLTR _tr_8 = HTMLTagsExt.tr(it);
                      final Procedure1<PlainHTMLTR> _function_8 = new Procedure1<PlainHTMLTR>() {
                          public void apply(final PlainHTMLTR it) {
                            PlainHTMLTD _td = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = RepairTaskForm.this.reserveDate.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                            PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = RepairTaskForm.this.reserveTime.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_8, _function_8);
                      PlainHTMLTR _tr_9 = HTMLTagsExt.tr(it);
                      final Procedure1<PlainHTMLTR> _function_9 = new Procedure1<PlainHTMLTR>() {
                          public void apply(final PlainHTMLTR it) {
                            PlainHTMLTD _td = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = RepairTaskForm.this.planFinishDate.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                            PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = RepairTaskForm.this.planFinishTime.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_9, _function_9);
                    }
                  };
                PlainHTMLTable _doubleArrow = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE, _function);
                WidgetExtensions.<PlainHTMLTable>addFill(it, _doubleArrow);
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
  
  public void faultTypeSelected(final UIFaultType selectedValue) {
    boolean _notEquals = (!Objects.equal(selectedValue, null));
    if (_notEquals) {
      this.faultType.setValue(selectedValue);
      RCMaintenanceTeamProxy _team = selectedValue.getTeam();
      this.activeTeam.setValue(_team);
      String _value = this.comment.getValue();
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_value);
      if (_isNullOrEmpty) {
        String _name = selectedValue.getName();
        this.comment.setValue(_name);
      }
      RCFaultLevelProxy _faultRiskLevel = selectedValue.getFaultRiskLevel();
      this.faultLevel.setValue(_faultRiskLevel);
      Date _value_1 = this.reserveDate.getValue();
      this.planFinishDate.setValue(_value_1);
      Date _value_2 = this.reserveTime.getValue();
      Double _standardCostTime = selectedValue.getStandardCostTime();
      Date _addHoursToDate = DateUtil.addHoursToDate(_value_2, _standardCostTime);
      this.planFinishTime.setValue(_addHoursToDate);
    }
  }
  
  @Inject
  private Provider<MaintenamceTypeManagementPresenter> maintenamceTypeManagementPresenter;
  
  @Inject
  private FaultTypeListView faultTypeListView;
  
  @Inject
  private EventBus eventBus;
  
  private Widget con;
}
