package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.web.client.chart.BarChart;
import com.fudanmed.platform.core.web.client.project.GroupTaskCriteriaForm;
import com.fudanmed.platform.core.web.client.project.GroupTaskStatByTeamPresenterView;
import com.fudanmed.platform.core.web.client.project.WorkItemStockRecordItemStat4ProductEntryListPresenter;
import com.fudanmed.platform.core.web.client.project.WorkItemStockRecordItemStat4ProductEntryListPresenterView;
import com.fudanmed.platform.core.web.client.project.WorkItemTask4WorkersStatListPresenter;
import com.fudanmed.platform.core.web.client.project.WorkItemTask4WorkersStatListPresenterView;
import com.fudanmed.platform.core.web.shared.project.UIGroupTaskCriteria;
import com.fudanmed.platform.core.web.shared.project.UIGroupTaskStatByTeamCriteriaData;
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

public class GroupTaskStatByTeamView extends GWTAbstractView implements GroupTaskStatByTeamPresenterView {
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
  
  private WorkItemTask4WorkersStatListPresenter workItemTask4WorkersStatListPresenter;
  
  public void setWorkItemTask4WorkersStatListPresenter(final WorkItemTask4WorkersStatListPresenter workItemTask4WorkersStatListPresenter) {
    this.workItemTask4WorkersStatListPresenter = workItemTask4WorkersStatListPresenter;
  }
  
  private WorkItemStockRecordItemStat4ProductEntryListPresenter workItemStockRecordItemStat4ProductEntryListPresenter;
  
  public void setWorkItemStockRecordItemStat4ProductEntryListPresenter(final WorkItemStockRecordItemStat4ProductEntryListPresenter workItemStockRecordItemStat4ProductEntryListPresenter) {
    this.workItemStockRecordItemStat4ProductEntryListPresenter = workItemStockRecordItemStat4ProductEntryListPresenter;
  }
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  private BarChart<UIGroupTaskStatByTeamCriteriaData> chart;
  
  @Inject
  private GroupTaskCriteriaForm criteriaForm;
  
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
                            FieldLabel _asWidget = GroupTaskStatByTeamView.this.criteriaForm.dateFrom.asWidget();
                            final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                public void apply(final FieldLabel it) {
                                  Date _day = DateUtil.today();
                                  int _minus = (-12);
                                  Date _addMonths = DateUtil.addMonths(_day, _minus);
                                  GroupTaskStatByTeamView.this.criteriaForm.dateFrom.setValue(_addMonths);
                                  final Procedure1<Date> _function = new Procedure1<Date>() {
                                      public void apply(final Date it) {
                                        GroupTaskStatByTeamView.this.refresh();
                                      }
                                    };
                                  GroupTaskStatByTeamView.this.criteriaForm.dateFrom.addValueChangedListener(new ValueChangedListener<Date>() {
                                      public void onValueChanged(Date value) {
                                        _function.apply(value);
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
                            FieldLabel _asWidget = GroupTaskStatByTeamView.this.criteriaForm.dateTo.asWidget();
                            final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                public void apply(final FieldLabel it) {
                                  Date _day = DateUtil.today();
                                  GroupTaskStatByTeamView.this.criteriaForm.dateTo.setValue(_day);
                                  final Procedure1<Date> _function = new Procedure1<Date>() {
                                      public void apply(final Date it) {
                                        GroupTaskStatByTeamView.this.refresh();
                                      }
                                    };
                                  GroupTaskStatByTeamView.this.criteriaForm.dateTo.addValueChangedListener(new ValueChangedListener<Date>() {
                                      public void onValueChanged(Date value) {
                                        _function.apply(value);
                                      }
                                  });
                                }
                              };
                            FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function);
                            ClientUi.operator_add(it, _doubleArrow);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                      PlainHTMLTD _td_2 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_2 = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                public void apply(final SelectEvent it) {
                                  GroupTaskStatByTeamView.this.refresh();
                                }
                              };
                            TextButton _TextButton = GroupTaskStatByTeamView.this.widgets.TextButton("\u5237\u65B0", _function);
                            ClientUi.operator_add(it, _TextButton);
                            final Procedure1<SelectEvent> _function_1 = new Procedure1<SelectEvent>() {
                                public void apply(final SelectEvent it) {
                                  GroupTaskStatByTeamView.this.workItemStockRecordItemStat4ProductEntryListPresenter.export();
                                }
                              };
                            TextButton _TextButton_1 = GroupTaskStatByTeamView.this.widgets.TextButton("\u7528\u6599\u5BFC\u51FA", _function_1);
                            ClientUi.operator_add(it, _TextButton_1);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_2, _function_2);
                    }
                  };
                ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr, _function);
              }
            };
          PlainHTMLTable _doubleArrow = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE, _function);
          int _minus = (-1);
          VerticalLayoutData _VLayoutData = GroupTaskStatByTeamView.this.widgets.VLayoutData(1, _minus);
          it.add(_doubleArrow, _VLayoutData);
          BarChart<UIGroupTaskStatByTeamCriteriaData> _barChart = new BarChart<UIGroupTaskStatByTeamCriteriaData>("\u63A5\u4FEE\u6570\u91CF", "\u73ED\u7EC4");
          final Procedure1<BarChart<UIGroupTaskStatByTeamCriteriaData>> _function_1 = new Procedure1<BarChart<UIGroupTaskStatByTeamCriteriaData>>() {
              public void apply(final BarChart<UIGroupTaskStatByTeamCriteriaData> it) {
                final Function1<UIGroupTaskStatByTeamCriteriaData,String> _function = new Function1<UIGroupTaskStatByTeamCriteriaData,String>() {
                    public String apply(final UIGroupTaskStatByTeamCriteriaData it) {
                      RCMaintenanceTeamProxy _team = it.getTeam();
                      String _name = _team.getName();
                      return _name;
                    }
                  };
                it.setCategoryProvider(_function);
                final Function1<UIGroupTaskStatByTeamCriteriaData,Long> _function_1 = new Function1<UIGroupTaskStatByTeamCriteriaData,Long>() {
                    public Long apply(final UIGroupTaskStatByTeamCriteriaData it) {
                      Long _cnt = it.getCnt();
                      return _cnt;
                    }
                  };
                it.setNumberProvider(_function_1);
              }
            };
          BarChart<UIGroupTaskStatByTeamCriteriaData> _doubleArrow_1 = ObjectExtensions.<BarChart<UIGroupTaskStatByTeamCriteriaData>>operator_doubleArrow(_barChart, _function_1);
          GroupTaskStatByTeamView.this.chart = _doubleArrow_1;
          Chart<UIGroupTaskStatByTeamCriteriaData> _asWidget = GroupTaskStatByTeamView.this.chart.asWidget();
          VerticalLayoutData _VLayoutData_1 = GroupTaskStatByTeamView.this.widgets.VLayoutData(1, 0.6);
          it.add(_asWidget, _VLayoutData_1);
          final Procedure1<UIGroupTaskStatByTeamCriteriaData> _function_2 = new Procedure1<UIGroupTaskStatByTeamCriteriaData>() {
              public void apply(final UIGroupTaskStatByTeamCriteriaData it) {
                RCMaintenanceTeamProxy _team = it.getTeam();
                Date _value = GroupTaskStatByTeamView.this.criteriaForm.dateFrom.getValue();
                Date _value_1 = GroupTaskStatByTeamView.this.criteriaForm.dateTo.getValue();
                GroupTaskStatByTeamView.this.workItemTask4WorkersStatListPresenter.setCriteria(_team, _value, _value_1);
                RCMaintenanceTeamProxy _team_1 = it.getTeam();
                Date _value_2 = GroupTaskStatByTeamView.this.criteriaForm.dateFrom.getValue();
                Date _value_3 = GroupTaskStatByTeamView.this.criteriaForm.dateTo.getValue();
                GroupTaskStatByTeamView.this.workItemStockRecordItemStat4ProductEntryListPresenter.setCriteria(_team_1, _value_2, _value_3);
                GroupTaskStatByTeamView.this.chart.highlight(it);
              }
            };
          GroupTaskStatByTeamView.this.chart.addValueSelectedListener(_function_2);
          HorizontalLayoutContainer _HLayout = GroupTaskStatByTeamView.this.widgets.HLayout();
          final Procedure1<HorizontalLayoutContainer> _function_3 = new Procedure1<HorizontalLayoutContainer>() {
              public void apply(final HorizontalLayoutContainer it) {
                FieldSet _FieldSet = GroupTaskStatByTeamView.this.widgets.FieldSet("\u5DE5\u7A0B\u5E08\u7EDF\u8BA1");
                final Procedure1<FieldSet> _function = new Procedure1<FieldSet>() {
                    public void apply(final FieldSet it) {
                      WorkItemTask4WorkersStatListPresenterView _view = GroupTaskStatByTeamView.this.workItemTask4WorkersStatListPresenter.getView();
                      Widget _asWidget = _view.asWidget();
                      it.setWidget(_asWidget);
                    }
                  };
                FieldSet _doubleArrow = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet, _function);
                HorizontalLayoutData _HLayoutData = GroupTaskStatByTeamView.this.widgets.HLayoutData(0.5, 1);
                it.add(_doubleArrow, _HLayoutData);
                FieldSet _FieldSet_1 = GroupTaskStatByTeamView.this.widgets.FieldSet("\u7528\u6599\u7EDF\u8BA1");
                final Procedure1<FieldSet> _function_1 = new Procedure1<FieldSet>() {
                    public void apply(final FieldSet it) {
                      WorkItemStockRecordItemStat4ProductEntryListPresenterView _view = GroupTaskStatByTeamView.this.workItemStockRecordItemStat4ProductEntryListPresenter.getView();
                      Widget _asWidget = _view.asWidget();
                      it.setWidget(_asWidget);
                    }
                  };
                FieldSet _doubleArrow_1 = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet_1, _function_1);
                HorizontalLayoutData _HLayoutData_1 = GroupTaskStatByTeamView.this.widgets.HLayoutData(0.5, 1);
                it.add(_doubleArrow_1, _HLayoutData_1);
              }
            };
          HorizontalLayoutContainer _doubleArrow_2 = ObjectExtensions.<HorizontalLayoutContainer>operator_doubleArrow(_HLayout, _function_3);
          VerticalLayoutData _VLayoutData_2 = GroupTaskStatByTeamView.this.widgets.VLayoutData(1, 0.4);
          it.add(_doubleArrow_2, _VLayoutData_2);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    this.con = _doubleArrow;
  }
  
  public void refresh() {
    Date _value = this.criteriaForm.dateFrom.getValue();
    Date _value_1 = this.criteriaForm.dateTo.getValue();
    this.workItemTask4WorkersStatListPresenter.setCriteria(null, _value, _value_1);
    Date _value_2 = this.criteriaForm.dateFrom.getValue();
    Date _value_3 = this.criteriaForm.dateTo.getValue();
    this.workItemStockRecordItemStat4ProductEntryListPresenter.setCriteria(null, _value_2, _value_3);
    UIGroupTaskCriteria _value_4 = this.criteriaForm.getValue();
    filterRequestRequestHandler.execute(_value_4);
    
  }
  
  public void showResult(final Collection<UIGroupTaskStatByTeamCriteriaData> results) {
    this.chart.setObjects(results);
  }
  
  private RequestHandler1<UIGroupTaskCriteria> filterRequestRequestHandler;
  
  public void filterRequest(final RequestHandler1<UIGroupTaskCriteria> requestHandler) {
    this.filterRequestRequestHandler = requestHandler;
  }
}
