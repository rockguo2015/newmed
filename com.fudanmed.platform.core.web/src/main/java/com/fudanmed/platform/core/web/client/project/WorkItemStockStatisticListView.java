package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.OrganizationOutlinePresenter;
import com.fudanmed.platform.core.web.client.project.ExportWorkItemStockRecordStatisticsCommand;
import com.fudanmed.platform.core.web.client.project.WorkItemStockRecordStatisticsDataListGrid;
import com.fudanmed.platform.core.web.client.project.WorkItemStockStatisticListPresenterView;
import com.fudanmed.platform.core.web.client.project.WorkItemStockStatisticsCriteriaForm;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockRecordStatisticsData;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockStatisticsCriteria;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.sencha.gxt.widget.core.client.Dialog;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.info.Info;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.shared.DateUtil;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.selector.ObjectSelector;
import edu.fudan.langlab.gxt.client.widget.FramedPanel;
import edu.fudan.langlab.gxt.client.widget.HTMLTagsExt;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTD;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTR;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTable;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import edu.fudan.langlab.security.client.Securities;
import java.util.Collection;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class WorkItemStockStatisticListView extends GWTAbstractView implements WorkItemStockStatisticListPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(listGrid,criteriaForm,exportWorkItemStockRecordStatisticsCommand),
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
  
  private Widget con;
  
  @Inject
  private WorkItemStockRecordStatisticsDataListGrid listGrid;
  
  @Inject
  private WorkItemStockStatisticsCriteriaForm criteriaForm;
  
  @Inject
  private Provider<OrganizationOutlinePresenter> organizationOutlinePresenter;
  
  @Inject
  private ExportWorkItemStockRecordStatisticsCommand exportWorkItemStockRecordStatisticsCommand;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u62A5\u4FEE\u5355\u7528\u6599\u7EDF\u8BA1\u8868");
    final Procedure1<FramedPanel> _function = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          VerticalLayoutContainer _VLayout = WorkItemStockStatisticListView.this.widgets.VLayout();
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
                                  PlainHTMLTable _TABLE = HTMLTagsExt.TABLE();
                                  final Procedure1<PlainHTMLTable> _function = new Procedure1<PlainHTMLTable>() {
                                      public void apply(final PlainHTMLTable it) {
                                        PlainHTMLTR _tr = HTMLTagsExt.tr(it);
                                        final Procedure1<PlainHTMLTR> _function = new Procedure1<PlainHTMLTR>() {
                                            public void apply(final PlainHTMLTR it) {
                                              PlainHTMLTD _td = HTMLTagsExt.td(it);
                                              final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                                  public void apply(final PlainHTMLTD it) {
                                                    FieldLabel _asWidget = WorkItemStockStatisticListView.this.criteriaForm.reportOrg.asWidget();
                                                    ClientUi.operator_add(it, _asWidget);
                                                  }
                                                };
                                              ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                                              PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                                              final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                                  public void apply(final PlainHTMLTD it) {
                                                    TextButton _TextButton = WorkItemStockStatisticListView.this.widgets.TextButton("\u9009\u62E9");
                                                    final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                                                        public void apply(final TextButton it) {
                                                          final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                                              public void apply(final SelectEvent it) {
                                                                OrganizationOutlinePresenter _get = WorkItemStockStatisticListView.this.organizationOutlinePresenter.get();
                                                                final Procedure1<OrganizationOutlinePresenter> _function = new Procedure1<OrganizationOutlinePresenter>() {
                                                                    public void apply(final OrganizationOutlinePresenter it) {
                                                                      final Procedure1<OrganizationOutlinePresenter> _function = new Procedure1<OrganizationOutlinePresenter>() {
                                                                          public void apply(final OrganizationOutlinePresenter it) {
                                                                            final Procedure1<UIOrganization> _function = new Procedure1<UIOrganization>() {
                                                                                public void apply(final UIOrganization it) {
                                                                                  RCOrganizationProxy _proxy = it.toProxy();
                                                                                  WorkItemStockStatisticListView.this.criteriaForm.reportOrg.setValue(_proxy);
                                                                                }
                                                                              };
                                                                            Dialog _asSelector = ObjectSelector.<UIOrganization>asSelector(it, "\u9009\u62E9\u7EC4\u7EC7\u673A\u6784", 300, 500, _function);
                                                                            _asSelector.show();
                                                                          }
                                                                        };
                                                                      it.setupAsSimpleTree(_function);
                                                                    }
                                                                  };
                                                                ObjectExtensions.<OrganizationOutlinePresenter>operator_doubleArrow(_get, _function);
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
                                  FieldLabel _asWidget = WorkItemStockStatisticListView.this.criteriaForm.team.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
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
                                  FieldLabel _asWidget = WorkItemStockStatisticListView.this.criteriaForm.reportDateFrom.asWidget();
                                  final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                      public void apply(final FieldLabel it) {
                                        Date _day = DateUtil.today();
                                        int _minus = (-1);
                                        Date _addMonths = DateUtil.addMonths(_day, _minus);
                                        WorkItemStockStatisticListView.this.criteriaForm.reportDateFrom.setValue(_addMonths);
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
                                  FieldLabel _asWidget = WorkItemStockStatisticListView.this.criteriaForm.reportDateTo.asWidget();
                                  final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                      public void apply(final FieldLabel it) {
                                        Date _day = DateUtil.today();
                                        WorkItemStockStatisticListView.this.criteriaForm.reportDateTo.setValue(_day);
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
                                        UIWorkItemStockStatisticsCriteria _value = WorkItemStockStatisticListView.this.criteriaForm.getValue();
                                        final Procedure1<UIWorkItemStockStatisticsCriteria> _function = new Procedure1<UIWorkItemStockStatisticsCriteria>() {
                                            public void apply(final UIWorkItemStockStatisticsCriteria it) {
                                              it.setPageSize(Integer.valueOf(5000));
                                            }
                                          };
                                        UIWorkItemStockStatisticsCriteria _doubleArrow = ObjectExtensions.<UIWorkItemStockStatisticsCriteria>operator_doubleArrow(_value, _function);
                                        queryRequestRequestHandler.execute(_doubleArrow);
                                        
                                      }
                                    };
                                  TextButton _TextButton = WorkItemStockStatisticListView.this.widgets.TextButton("\u7B5B\u9009", _function);
                                  ClientUi.operator_add(it, _TextButton);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_2, _function_2);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_1, _function_1);
                    }
                  };
                PlainHTMLTable _doubleArrow = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE, _function);
                WidgetExtensions.<PlainHTMLTable>addFill(it, _doubleArrow);
                SGroupingGrid<UIWorkItemStockRecordStatisticsData> _asWidget = WorkItemStockStatisticListView.this.listGrid.asWidget();
                Widget _withBorder = WidgetExtensions.withBorder(_asWidget);
                VerticalLayoutData _VLayoutData = WorkItemStockStatisticListView.this.widgets.VLayoutData(1, 1);
                it.add(_withBorder, _VLayoutData);
              }
            };
          VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
          it.setWidget(_doubleArrow);
          final Function0<UIWorkItemStockStatisticsCriteria> _function_1 = new Function0<UIWorkItemStockStatisticsCriteria>() {
              public UIWorkItemStockStatisticsCriteria apply() {
                UIWorkItemStockStatisticsCriteria _value = WorkItemStockStatisticListView.this.criteriaForm.getValue();
                return _value;
              }
            };
          it.<UIWorkItemStockStatisticsCriteria>addCommand(_function_1, WorkItemStockStatisticListView.this.exportWorkItemStockRecordStatisticsCommand);
        }
      };
    FramedPanel _doubleArrow = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function);
    this.con = _doubleArrow;
  }
  
  public void setResults(final Collection<UIWorkItemStockRecordStatisticsData> results) {
    int _size = results.size();
    boolean _greaterThan = (_size > 5000);
    if (_greaterThan) {
      Info.display("\u8B66\u544A", "\u7B5B\u9009\u7ED3\u679C\u591A\u4E8E5000\u6761\uFF0C\u53EF\u80FD\u672A\u663E\u793A\u51FA\u5168\u90E8\u6EE1\u8DB3\u6761\u4EF6\u7684\u8BB0\u5F55");
    }
    this.listGrid.setObjects(results);
  }
  
  public void refresh() {
    UIWorkItemStockStatisticsCriteria _value = this.criteriaForm.getValue();
    final Procedure1<UIWorkItemStockStatisticsCriteria> _function = new Procedure1<UIWorkItemStockStatisticsCriteria>() {
        public void apply(final UIWorkItemStockStatisticsCriteria it) {
          it.setPageSize(Integer.valueOf(501));
        }
      };
    UIWorkItemStockStatisticsCriteria _doubleArrow = ObjectExtensions.<UIWorkItemStockStatisticsCriteria>operator_doubleArrow(_value, _function);
    queryRequestRequestHandler.execute(_doubleArrow);
    
  }
  
  private RequestHandler1<UIWorkItemStockStatisticsCriteria> queryRequestRequestHandler;
  
  public void queryRequest(final RequestHandler1<UIWorkItemStockStatisticsCriteria> requestHandler) {
    this.queryRequestRequestHandler = requestHandler;
  }
}
