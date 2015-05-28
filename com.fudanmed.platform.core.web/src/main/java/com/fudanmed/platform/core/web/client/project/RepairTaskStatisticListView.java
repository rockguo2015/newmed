package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.OrganizationOutlinePresenter;
import com.fudanmed.platform.core.web.client.project.ExportRepairTaskStatisticDataCommand;
import com.fudanmed.platform.core.web.client.project.RepairTaskStatisticCriteriaForm;
import com.fudanmed.platform.core.web.client.project.RepairTaskStatisticDataListGrid;
import com.fudanmed.platform.core.web.client.project.RepairTaskStatisticListPresenterView;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatisticCriteria;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatisticData;
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
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;
import com.uniquesoft.gwt.shared.DateUtil;
import com.uniquesoft.gwt.shared.datatype.UIDateRange;
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

public class RepairTaskStatisticListView extends GWTAbstractView implements RepairTaskStatisticListPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(listGrid,criteriaForm,exportRepairTaskStatisticDataCommand),
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
  private RepairTaskStatisticDataListGrid listGrid;
  
  @Inject
  private RepairTaskStatisticCriteriaForm criteriaForm;
  
  @Inject
  private Provider<OrganizationOutlinePresenter> organizationOutlinePresenter;
  
  @Inject
  private ExportRepairTaskStatisticDataCommand exportRepairTaskStatisticDataCommand;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u62A5\u4FEE\u5355\u7EDF\u8BA1\u8868");
    final Procedure1<FramedPanel> _function = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          VerticalLayoutContainer _VLayout = RepairTaskStatisticListView.this.widgets.VLayout();
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
                                  FieldLabel _asWidget = RepairTaskStatisticListView.this.criteriaForm.comment.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                            PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = RepairTaskStatisticListView.this.criteriaForm.team.asWidget();
                                  final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                      public void apply(final FieldLabel it) {
                                        final Procedure1<RCMaintenanceTeamProxy> _function = new Procedure1<RCMaintenanceTeamProxy>() {
                                            public void apply(final RCMaintenanceTeamProxy it) {
                                              RCMaintenanceTeamProxy _value = RepairTaskStatisticListView.this.criteriaForm.team.getValue();
                                              teamChangedRequestHandler.execute(_value);
                                              
                                            }
                                          };
                                        RepairTaskStatisticListView.this.criteriaForm.team.addValueChangedListener(new ValueChangedListener<RCMaintenanceTeamProxy>() {
                                            public void onValueChanged(RCMaintenanceTeamProxy value) {
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
                                  FieldLabel _asWidget = RepairTaskStatisticListView.this.criteriaForm.worker.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_2, _function_2);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr, _function);
                      PlainHTMLTR _tr_1 = HTMLTagsExt.tr(it);
                      final Procedure1<PlainHTMLTR> _function_1 = new Procedure1<PlainHTMLTR>() {
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
                                                    FieldLabel _asWidget = RepairTaskStatisticListView.this.criteriaForm.reportOrg.asWidget();
                                                    ClientUi.operator_add(it, _asWidget);
                                                  }
                                                };
                                              ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                                              PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                                              final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                                  public void apply(final PlainHTMLTD it) {
                                                    TextButton _TextButton = RepairTaskStatisticListView.this.widgets.TextButton("\u9009\u62E9");
                                                    final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                                                        public void apply(final TextButton it) {
                                                          final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                                              public void apply(final SelectEvent it) {
                                                                OrganizationOutlinePresenter _get = RepairTaskStatisticListView.this.organizationOutlinePresenter.get();
                                                                final Procedure1<OrganizationOutlinePresenter> _function = new Procedure1<OrganizationOutlinePresenter>() {
                                                                    public void apply(final OrganizationOutlinePresenter it) {
                                                                      final Procedure1<OrganizationOutlinePresenter> _function = new Procedure1<OrganizationOutlinePresenter>() {
                                                                          public void apply(final OrganizationOutlinePresenter it) {
                                                                            final Procedure1<UIOrganization> _function = new Procedure1<UIOrganization>() {
                                                                                public void apply(final UIOrganization it) {
                                                                                  RCOrganizationProxy _proxy = it.toProxy();
                                                                                  RepairTaskStatisticListView.this.criteriaForm.reportOrg.setValue(_proxy);
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
                                  FieldLabel _asWidget = RepairTaskStatisticListView.this.criteriaForm.status.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                            PlainHTMLTD _td_2 = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function_2 = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_2, _function_2);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_1, _function_1);
                      PlainHTMLTR _tr_2 = HTMLTagsExt.tr(it);
                      final Procedure1<PlainHTMLTR> _function_2 = new Procedure1<PlainHTMLTR>() {
                          public void apply(final PlainHTMLTR it) {
                            PlainHTMLTD _td = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = RepairTaskStatisticListView.this.criteriaForm.reportDateRange.asWidget();
                                  final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                      public void apply(final FieldLabel it) {
                                        UIDateRange _uIDateRange = new UIDateRange();
                                        final Procedure1<UIDateRange> _function = new Procedure1<UIDateRange>() {
                                            public void apply(final UIDateRange it) {
                                              Date _day = DateUtil.today();
                                              int _minus = (-1);
                                              Date _addMonths = DateUtil.addMonths(_day, _minus);
                                              it.setFrom(_addMonths);
                                              Date _day_1 = DateUtil.today();
                                              it.setTo(_day_1);
                                            }
                                          };
                                        UIDateRange _doubleArrow = ObjectExtensions.<UIDateRange>operator_doubleArrow(_uIDateRange, _function);
                                        RepairTaskStatisticListView.this.criteriaForm.reportDateRange.setValue(_doubleArrow);
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
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                            PlainHTMLTD _td_2 = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function_2 = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                      public void apply(final SelectEvent it) {
                                        UIRepairTaskStatisticCriteria _value = RepairTaskStatisticListView.this.criteriaForm.getValue();
                                        final Procedure1<UIRepairTaskStatisticCriteria> _function = new Procedure1<UIRepairTaskStatisticCriteria>() {
                                            public void apply(final UIRepairTaskStatisticCriteria it) {
                                              it.setPageSize(Integer.valueOf(5000));
                                            }
                                          };
                                        UIRepairTaskStatisticCriteria _doubleArrow = ObjectExtensions.<UIRepairTaskStatisticCriteria>operator_doubleArrow(_value, _function);
                                        queryRequestRequestHandler.execute(_doubleArrow);
                                        
                                      }
                                    };
                                  TextButton _TextButton = RepairTaskStatisticListView.this.widgets.TextButton("\u7B5B\u9009", _function);
                                  ClientUi.operator_add(it, _TextButton);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_2, _function_2);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_2, _function_2);
                    }
                  };
                PlainHTMLTable _doubleArrow = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE, _function);
                WidgetExtensions.<PlainHTMLTable>addFill(it, _doubleArrow);
                final Procedure1<Void> _function_1 = new Procedure1<Void>() {
                    public void apply(final Void it) {
                    }
                  };
                RepairTaskStatisticListView.this.criteriaForm.workerContentProvider.load(null, _function_1);
                SGroupingGrid<UIRepairTaskStatisticData> _asWidget = RepairTaskStatisticListView.this.listGrid.asWidget();
                Widget _withBorder = WidgetExtensions.withBorder(_asWidget);
                VerticalLayoutData _VLayoutData = RepairTaskStatisticListView.this.widgets.VLayoutData(1, 1);
                it.add(_withBorder, _VLayoutData);
              }
            };
          VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
          it.setWidget(_doubleArrow);
          final Function0<UIRepairTaskStatisticCriteria> _function_1 = new Function0<UIRepairTaskStatisticCriteria>() {
              public UIRepairTaskStatisticCriteria apply() {
                UIRepairTaskStatisticCriteria _value = RepairTaskStatisticListView.this.criteriaForm.getValue();
                return _value;
              }
            };
          it.<UIRepairTaskStatisticCriteria>addCommand(_function_1, RepairTaskStatisticListView.this.exportRepairTaskStatisticDataCommand);
        }
      };
    FramedPanel _doubleArrow = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function);
    this.con = _doubleArrow;
  }
  
  public void setSelectedOrganization(final RCOrganizationProxy newOrg) {
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
        }
      };
    this.criteriaForm.workerContentProvider.load(newOrg, _function);
  }
  
  public void setResults(final Collection<UIRepairTaskStatisticData> results) {
    int _size = results.size();
    boolean _greaterThan = (_size > 5000);
    if (_greaterThan) {
      Info.display("\u8B66\u544A", "\u7B5B\u9009\u7ED3\u679C\u591A\u4E8E5000\u6761\uFF0C\u53EF\u80FD\u672A\u663E\u793A\u51FA\u5168\u90E8\u6EE1\u8DB3\u6761\u4EF6\u7684\u6570\u636E");
    }
    this.listGrid.setObjects(results);
  }
  
  public void refresh() {
    UIRepairTaskStatisticCriteria _value = this.criteriaForm.getValue();
    final Procedure1<UIRepairTaskStatisticCriteria> _function = new Procedure1<UIRepairTaskStatisticCriteria>() {
        public void apply(final UIRepairTaskStatisticCriteria it) {
          it.setPageSize(Integer.valueOf(501));
        }
      };
    UIRepairTaskStatisticCriteria _doubleArrow = ObjectExtensions.<UIRepairTaskStatisticCriteria>operator_doubleArrow(_value, _function);
    queryRequestRequestHandler.execute(_doubleArrow);
    
  }
  
  private RequestHandler1<UIRepairTaskStatisticCriteria> queryRequestRequestHandler;
  
  public void queryRequest(final RequestHandler1<UIRepairTaskStatisticCriteria> requestHandler) {
    this.queryRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCMaintenanceTeamProxy> teamChangedRequestHandler;
  
  public void teamChanged(final RequestHandler1<RCMaintenanceTeamProxy> requestHandler) {
    this.teamChangedRequestHandler = requestHandler;
  }
}
