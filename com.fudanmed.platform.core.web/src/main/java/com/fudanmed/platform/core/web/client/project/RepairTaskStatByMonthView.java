package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.chart.ColumnChart;
import com.fudanmed.platform.core.web.client.project.GroupTaskStatByTeamListPresenter;
import com.fudanmed.platform.core.web.client.project.GroupTaskStatByTeamListPresenterView;
import com.fudanmed.platform.core.web.client.project.RepairTaskCriteriaForm;
import com.fudanmed.platform.core.web.client.project.RepairTaskStatByFaultTypeListPresenter;
import com.fudanmed.platform.core.web.client.project.RepairTaskStatByFaultTypeListPresenterView;
import com.fudanmed.platform.core.web.client.project.RepairTaskStatByMonthPresenterView;
import com.fudanmed.platform.core.web.client.project.RepairTaskStatByOrganizationTypeListPresenter;
import com.fudanmed.platform.core.web.client.project.RepairTaskStatByOrganizationTypeListPresenterView;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskCriteria;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatByMonthCriteriaData;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.chart.client.chart.Chart;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FieldSet;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;
import com.uniquesoft.gwt.shared.DateUtil;
import com.uniquesoft.gwt.shared.datatype.UIDateRange;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.widget.HTMLTagsExt;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTD;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTR;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTable;
import edu.fudan.langlab.security.client.Securities;
import java.util.Collection;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class RepairTaskStatByMonthView extends GWTAbstractView implements RepairTaskStatByMonthPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(criteriaForm),
    	new com.uniquesoft.gwt.client.common.async.IPostInitializeAction(){
    
    	public void initializeFinished(Void v) {
    		initialize();
    		postInitialize.initializeFinished(null);
    	}
    });
    
  }
  
  @Inject
  private Securities securities;
  
  @Inject
  private EventBus eventBus;
  
  private RepairTaskStatByFaultTypeListPresenter repairTaskStatByFaultTypeListPresenter;
  
  public void setRepairTaskStatByFaultTypeListPresenter(final RepairTaskStatByFaultTypeListPresenter repairTaskStatByFaultTypeListPresenter) {
    this.repairTaskStatByFaultTypeListPresenter = repairTaskStatByFaultTypeListPresenter;
  }
  
  private RepairTaskStatByOrganizationTypeListPresenter repairTaskStatByOrganizationTypeListPresenter;
  
  public void setRepairTaskStatByOrganizationTypeListPresenter(final RepairTaskStatByOrganizationTypeListPresenter repairTaskStatByOrganizationTypeListPresenter) {
    this.repairTaskStatByOrganizationTypeListPresenter = repairTaskStatByOrganizationTypeListPresenter;
  }
  
  private GroupTaskStatByTeamListPresenter groupTaskStatByTeamListPresenter;
  
  public void setGroupTaskStatByTeamListPresenter(final GroupTaskStatByTeamListPresenter groupTaskStatByTeamListPresenter) {
    this.groupTaskStatByTeamListPresenter = groupTaskStatByTeamListPresenter;
  }
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  private ColumnChart<UIRepairTaskStatByMonthCriteriaData> chart;
  
  @Inject
  private RepairTaskCriteriaForm criteriaForm;
  
  public void initialize() {
    
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
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
                            FieldLabel _asWidget = RepairTaskStatByMonthView.this.criteriaForm.reportDateRange.asWidget();
                            final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                public void apply(final FieldLabel it) {
                                  UIDateRange _uIDateRange = new UIDateRange();
                                  final Procedure1<UIDateRange> _function = new Procedure1<UIDateRange>() {
                                      public void apply(final UIDateRange it) {
                                        Date _day = DateUtil.today();
                                        int _minus = (-12);
                                        Date _addMonths = DateUtil.addMonths(_day, _minus);
                                        it.setFrom(_addMonths);
                                        Date _day_1 = DateUtil.today();
                                        it.setTo(_day_1);
                                      }
                                    };
                                  UIDateRange _doubleArrow = ObjectExtensions.<UIDateRange>operator_doubleArrow(_uIDateRange, _function);
                                  RepairTaskStatByMonthView.this.criteriaForm.reportDateRange.setValue(_doubleArrow);
                                  final Procedure1<UIDateRange> _function_1 = new Procedure1<UIDateRange>() {
                                      public void apply(final UIDateRange it) {
                                        RepairTaskStatByMonthView.this.refresh();
                                      }
                                    };
                                  RepairTaskStatByMonthView.this.criteriaForm.reportDateRange.addValueChangedListener(new ValueChangedListener<UIDateRange>() {
                                      public void onValueChanged(UIDateRange value) {
                                        _function_1.apply(value);
                                      }
                                  });
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
                            final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                public void apply(final SelectEvent it) {
                                  RepairTaskStatByMonthView.this.refresh();
                                }
                              };
                            TextButton _TextButton = RepairTaskStatByMonthView.this.widgets.TextButton("\u5237\u65B0", _function);
                            ClientUi.operator_add(it, _TextButton);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                    }
                  };
                ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr, _function);
              }
            };
          PlainHTMLTable _doubleArrow = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE, _function);
          int _minus = (-1);
          VerticalLayoutData _VLayoutData = RepairTaskStatByMonthView.this.widgets.VLayoutData(1, _minus);
          it.add(_doubleArrow, _VLayoutData);
          ColumnChart<UIRepairTaskStatByMonthCriteriaData> _columnChart = new ColumnChart<UIRepairTaskStatByMonthCriteriaData>("\u62A5\u4FEE\u6570\u91CF", "\u6708\u4EFD");
          final Procedure1<ColumnChart<UIRepairTaskStatByMonthCriteriaData>> _function_1 = new Procedure1<ColumnChart<UIRepairTaskStatByMonthCriteriaData>>() {
              public void apply(final ColumnChart<UIRepairTaskStatByMonthCriteriaData> it) {
                final Function1<UIRepairTaskStatByMonthCriteriaData,Long> _function = new Function1<UIRepairTaskStatByMonthCriteriaData,Long>() {
                    public Long apply(final UIRepairTaskStatByMonthCriteriaData it) {
                      Long _cnt = it.getCnt();
                      return _cnt;
                    }
                  };
                it.setNumberProvider(_function);
                final Function1<UIRepairTaskStatByMonthCriteriaData,String> _function_1 = new Function1<UIRepairTaskStatByMonthCriteriaData,String>() {
                    public String apply(final UIRepairTaskStatByMonthCriteriaData it) {
                      String _month = it.getMonth();
                      return _month;
                    }
                  };
                it.setCategoryProvider(_function_1);
              }
            };
          ColumnChart<UIRepairTaskStatByMonthCriteriaData> _doubleArrow_1 = ObjectExtensions.<ColumnChart<UIRepairTaskStatByMonthCriteriaData>>operator_doubleArrow(_columnChart, _function_1);
          RepairTaskStatByMonthView.this.chart = _doubleArrow_1;
          Chart<UIRepairTaskStatByMonthCriteriaData> _asWidget = RepairTaskStatByMonthView.this.chart.asWidget();
          VerticalLayoutData _VLayoutData_1 = RepairTaskStatByMonthView.this.widgets.VLayoutData(1, 0.6);
          it.add(_asWidget, _VLayoutData_1);
          final Procedure1<UIRepairTaskStatByMonthCriteriaData> _function_2 = new Procedure1<UIRepairTaskStatByMonthCriteriaData>() {
              public void apply(final UIRepairTaskStatByMonthCriteriaData it) {
                String _month = it.getMonth();
                RepairTaskStatByMonthView.this.repairTaskStatByFaultTypeListPresenter.setMonth(_month);
                String _month_1 = it.getMonth();
                RepairTaskStatByMonthView.this.repairTaskStatByOrganizationTypeListPresenter.setMonth(_month_1);
                String _month_2 = it.getMonth();
                RepairTaskStatByMonthView.this.groupTaskStatByTeamListPresenter.setMonth(_month_2);
                RepairTaskStatByMonthView.this.chart.highlight(it);
              }
            };
          RepairTaskStatByMonthView.this.chart.addValueSelectedListener(_function_2);
          HorizontalLayoutContainer _HLayout = RepairTaskStatByMonthView.this.widgets.HLayout();
          final Procedure1<HorizontalLayoutContainer> _function_3 = new Procedure1<HorizontalLayoutContainer>() {
              public void apply(final HorizontalLayoutContainer it) {
                FieldSet _FieldSet = RepairTaskStatByMonthView.this.widgets.FieldSet("\u6545\u969C\u7C7B\u578B\u7EDF\u8BA1");
                final Procedure1<FieldSet> _function = new Procedure1<FieldSet>() {
                    public void apply(final FieldSet it) {
                      RepairTaskStatByFaultTypeListPresenterView _view = RepairTaskStatByMonthView.this.repairTaskStatByFaultTypeListPresenter.getView();
                      Widget _asWidget = _view.asWidget();
                      it.setWidget(_asWidget);
                    }
                  };
                FieldSet _doubleArrow = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet, _function);
                HorizontalLayoutData _HLayoutData = RepairTaskStatByMonthView.this.widgets.HLayoutData(0.33, 1);
                it.add(_doubleArrow, _HLayoutData);
                FieldSet _FieldSet_1 = RepairTaskStatByMonthView.this.widgets.FieldSet("\u62A5\u4FEE\u90E8\u95E8\u7EDF\u8BA1");
                final Procedure1<FieldSet> _function_1 = new Procedure1<FieldSet>() {
                    public void apply(final FieldSet it) {
                      RepairTaskStatByOrganizationTypeListPresenterView _view = RepairTaskStatByMonthView.this.repairTaskStatByOrganizationTypeListPresenter.getView();
                      Widget _asWidget = _view.asWidget();
                      it.setWidget(_asWidget);
                    }
                  };
                FieldSet _doubleArrow_1 = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet_1, _function_1);
                HorizontalLayoutData _HLayoutData_1 = RepairTaskStatByMonthView.this.widgets.HLayoutData(0.33, 1);
                it.add(_doubleArrow_1, _HLayoutData_1);
                FieldSet _FieldSet_2 = RepairTaskStatByMonthView.this.widgets.FieldSet("\u7EF4\u4FEE\u73ED\u7EC4\u7EDF\u8BA1");
                final Procedure1<FieldSet> _function_2 = new Procedure1<FieldSet>() {
                    public void apply(final FieldSet it) {
                      GroupTaskStatByTeamListPresenterView _view = RepairTaskStatByMonthView.this.groupTaskStatByTeamListPresenter.getView();
                      Widget _asWidget = _view.asWidget();
                      it.setWidget(_asWidget);
                    }
                  };
                FieldSet _doubleArrow_2 = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet_2, _function_2);
                HorizontalLayoutData _HLayoutData_2 = RepairTaskStatByMonthView.this.widgets.HLayoutData(0.34, 1);
                it.add(_doubleArrow_2, _HLayoutData_2);
              }
            };
          HorizontalLayoutContainer _doubleArrow_2 = ObjectExtensions.<HorizontalLayoutContainer>operator_doubleArrow(_HLayout, _function_3);
          VerticalLayoutData _VLayoutData_2 = RepairTaskStatByMonthView.this.widgets.VLayoutData(1, 0.4);
          it.add(_doubleArrow_2, _VLayoutData_2);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    this.con = _doubleArrow;
  }
  
  public void refresh() {
    UIRepairTaskCriteria _value = this.criteriaForm.getValue();
    UIDateRange _reportDateRange = _value.getReportDateRange();
    this.repairTaskStatByFaultTypeListPresenter.setDateRange(_reportDateRange);
    UIRepairTaskCriteria _value_1 = this.criteriaForm.getValue();
    UIDateRange _reportDateRange_1 = _value_1.getReportDateRange();
    this.repairTaskStatByOrganizationTypeListPresenter.setDateRange(_reportDateRange_1);
    UIRepairTaskCriteria _value_2 = this.criteriaForm.getValue();
    UIDateRange _reportDateRange_2 = _value_2.getReportDateRange();
    this.groupTaskStatByTeamListPresenter.setDateRange(_reportDateRange_2);
    UIRepairTaskCriteria _value_3 = this.criteriaForm.getValue();
    filterRequestRequestHandler.execute(_value_3);
    
  }
  
  public void showResult(final Collection<UIRepairTaskStatByMonthCriteriaData> results) {
    this.chart.setObjects(results);
  }
  
  private RequestHandler1<UIRepairTaskCriteria> filterRequestRequestHandler;
  
  public void filterRequest(final RequestHandler1<UIRepairTaskCriteria> requestHandler) {
    this.filterRequestRequestHandler = requestHandler;
  }
}
