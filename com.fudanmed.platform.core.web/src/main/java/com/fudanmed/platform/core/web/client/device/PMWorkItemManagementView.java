package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.device.pm.proxy.RCWorkItemPlanAssignmentProxy;
import com.fudanmed.platform.core.web.client.device.PMWorkItem4DispatcherListGrid;
import com.fudanmed.platform.core.web.client.device.PMWorkItemCriteriaForm;
import com.fudanmed.platform.core.web.client.device.PMWorkItemEvaluatePropertyViewPresenter;
import com.fudanmed.platform.core.web.client.device.PMWorkItemEvaluatePropertyViewPresenterView;
import com.fudanmed.platform.core.web.client.device.PMWorkItemManagementPresenterView;
import com.fudanmed.platform.core.web.client.device.PMWorkItemPropertyPresenter;
import com.fudanmed.platform.core.web.client.device.PMWorkItemPropertyPresenterView;
import com.fudanmed.platform.core.web.client.device.PMWorkItemWorkerAssignmentListPresenter;
import com.fudanmed.platform.core.web.client.device.PMWorkItemWorkerAssignmentListPresenterView;
import com.fudanmed.platform.core.web.client.device.RemoveWorkItemPlanAssignmentCommand;
import com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentListPresenter;
import com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentListPresenterView;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItem;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemCriteria;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemStatue;
import com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignment;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.ActionExtensions;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.ObjectListView.SelectEntityListener;
import com.uniquesoft.gwt.client.common.widgets.pager.Extensions;
import com.uniquesoft.gwt.client.common.widgets.pager.IPager;
import com.uniquesoft.gwt.client.common.widgets.pager.IPager.GotoPageHandler;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.action.SingleObjectActions;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.widget.ContentPanel;
import edu.fudan.langlab.gxt.client.widget.FramedPanel;
import edu.fudan.langlab.gxt.client.widget.HTMLTagsExt;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTD;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTR;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTable;
import edu.fudan.langlab.gxt.client.widget.TabPanel;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import edu.fudan.langlab.security.client.Securities;
import edu.fudan.langlab.security.shared.IFunctionIdentifier;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

public class PMWorkItemManagementView extends GWTAbstractView implements PMWorkItemManagementPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(listGrid,criteriaForm,removeWorkItemPlanAssignmentCommand),
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
  
  private WorkItemPlanAssignmentListPresenter workItemPlanAssignmentListPresenter;
  
  public void setWorkItemPlanAssignmentListPresenter(final WorkItemPlanAssignmentListPresenter workItemPlanAssignmentListPresenter) {
    this.workItemPlanAssignmentListPresenter = workItemPlanAssignmentListPresenter;
  }
  
  private PMWorkItemWorkerAssignmentListPresenter workItemWorkerAssignmentListPresenter;
  
  public void setWorkItemWorkerAssignmentListPresenter(final PMWorkItemWorkerAssignmentListPresenter workItemWorkerAssignmentListPresenter) {
    this.workItemWorkerAssignmentListPresenter = workItemWorkerAssignmentListPresenter;
  }
  
  private PMWorkItemEvaluatePropertyViewPresenter workItemEvaluatePropertyViewPresenter;
  
  public void setWorkItemEvaluatePropertyViewPresenter(final PMWorkItemEvaluatePropertyViewPresenter workItemEvaluatePropertyViewPresenter) {
    this.workItemEvaluatePropertyViewPresenter = workItemEvaluatePropertyViewPresenter;
  }
  
  private PMWorkItemPropertyPresenter workItemPropertyPresenter;
  
  public void setWorkItemPropertyPresenter(final PMWorkItemPropertyPresenter workItemPropertyPresenter) {
    this.workItemPropertyPresenter = workItemPropertyPresenter;
  }
  
  @Inject
  private PMWorkItem4DispatcherListGrid listGrid;
  
  @Inject
  private PMWorkItemCriteriaForm criteriaForm;
  
  @Inject
  private RemoveWorkItemPlanAssignmentCommand removeWorkItemPlanAssignmentCommand;
  
  private IPager pager;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    this.listGrid.asWidget();
    this.listGrid.keepSelection();
    final ActionContext<UIPMWorkItem> ac = ActionExtensions.<UIPMWorkItem>createActionContext(this.listGrid);
    FramedPanel _FramedPanel = this.widgets.FramedPanel("PM\u8C03\u5EA6\u5DE5\u4F5C\u53F0");
    final Procedure1<FramedPanel> _function = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          BorderLayoutContainer _BorderLayout = PMWorkItemManagementView.this.widgets.BorderLayout();
          final Procedure1<BorderLayoutContainer> _function = new Procedure1<BorderLayoutContainer>() {
              public void apply(final BorderLayoutContainer it) {
                final Function1<Void,ContentPanel> _function = new Function1<Void,ContentPanel>() {
                    public ContentPanel apply(final Void it) {
                      ContentPanel _ContentPanel = PMWorkItemManagementView.this.widgets.ContentPanel();
                      final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
                          public void apply(final ContentPanel it) {
                            it.setBodyBorder(false);
                            it.setBorders(false);
                            VerticalLayoutContainer _VLayout = PMWorkItemManagementView.this.widgets.VLayout();
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
                                                    FieldLabel _asWidget = PMWorkItemManagementView.this.criteriaForm.assignDateFrom.asWidget();
                                                    ClientUi.operator_add(it, _asWidget);
                                                  }
                                                };
                                              ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                                              PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                                              final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                                  public void apply(final PlainHTMLTD it) {
                                                    FieldLabel _asWidget = PMWorkItemManagementView.this.criteriaForm.assignDateTo.asWidget();
                                                    ClientUi.operator_add(it, _asWidget);
                                                  }
                                                };
                                              ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                                              PlainHTMLTD _td_2 = HTMLTagsExt.td(it);
                                              final Procedure1<PlainHTMLTD> _function_2 = new Procedure1<PlainHTMLTD>() {
                                                  public void apply(final PlainHTMLTD it) {
                                                    FieldLabel _asWidget = PMWorkItemManagementView.this.criteriaForm.includeFinishedItems.asWidget();
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
                                                    FieldLabel _asWidget = PMWorkItemManagementView.this.criteriaForm.team.asWidget();
                                                    ClientUi.operator_add(it, _asWidget);
                                                  }
                                                };
                                              ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                                              PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                                              final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                                  public void apply(final PlainHTMLTD it) {
                                                    FieldLabel _asWidget = PMWorkItemManagementView.this.criteriaForm.status.asWidget();
                                                    ClientUi.operator_add(it, _asWidget);
                                                  }
                                                };
                                              ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                                              PlainHTMLTD _td_2 = HTMLTagsExt.td(it);
                                              final Procedure1<PlainHTMLTD> _function_2 = new Procedure1<PlainHTMLTD>() {
                                                  public void apply(final PlainHTMLTD it) {
                                                    TextButton _TextButton = PMWorkItemManagementView.this.widgets.TextButton("\u7B5B\u9009");
                                                    final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                                                        public void apply(final TextButton it) {
                                                          it.setWidth("80px");
                                                          final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                                              public void apply(final SelectEvent it) {
                                                                UIPMWorkItemCriteria _value = PMWorkItemManagementView.this.criteriaForm.getValue();
                                                                UIPMWorkItemCriteria _withPagerInfo = Extensions.<UIPMWorkItemCriteria>withPagerInfo(_value, PMWorkItemManagementView.this.pager);
                                                                final Procedure1<UIPMWorkItemCriteria> _function = new Procedure1<UIPMWorkItemCriteria>() {
                                                                    public void apply(final UIPMWorkItemCriteria it) {
                                                                      it.setPage(Integer.valueOf(1));
                                                                    }
                                                                  };
                                                                UIPMWorkItemCriteria _doubleArrow = ObjectExtensions.<UIPMWorkItemCriteria>operator_doubleArrow(_withPagerInfo, _function);
                                                                filterRequestRequestHandler.execute(_doubleArrow);
                                                                
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
                                              ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_2, _function_2);
                                            }
                                          };
                                        ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_1, _function_1);
                                      }
                                    };
                                  PlainHTMLTable _doubleArrow = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE, _function);
                                  WidgetExtensions.<PlainHTMLTable>addFill(it, _doubleArrow);
                                  IPager<UIPMWorkItem> _createPager = edu.fudan.langlab.gxt.client.pager.Extensions.<UIPMWorkItem>createPager(PMWorkItemManagementView.this.listGrid);
                                  final Procedure1<IPager<UIPMWorkItem>> _function_1 = new Procedure1<IPager<UIPMWorkItem>>() {
                                      public void apply(final IPager<UIPMWorkItem> it) {
                                        final Procedure2<Integer,Integer> _function = new Procedure2<Integer,Integer>() {
                                            public void apply(final Integer pageNum, final Integer recordsPerPage) {
                                              UIPMWorkItemCriteria _value = PMWorkItemManagementView.this.criteriaForm.getValue();
                                              UIPMWorkItemCriteria _withPagerInfo = Extensions.<UIPMWorkItemCriteria>withPagerInfo(_value, PMWorkItemManagementView.this.pager);
                                              final Procedure1<UIPMWorkItemCriteria> _function = new Procedure1<UIPMWorkItemCriteria>() {
                                                  public void apply(final UIPMWorkItemCriteria it) {
                                                    it.setPage(Integer.valueOf(pageNum));
                                                    it.setPageSize(Integer.valueOf(recordsPerPage));
                                                  }
                                                };
                                              UIPMWorkItemCriteria _doubleArrow = ObjectExtensions.<UIPMWorkItemCriteria>operator_doubleArrow(_withPagerInfo, _function);
                                              filterRequestRequestHandler.execute(_doubleArrow);
                                              
                                            }
                                          };
                                        it.setPagerHandler(new GotoPageHandler() {
                                            public void gotoPage(int pageNum,int recordsPerPage) {
                                              _function.apply(pageNum,recordsPerPage);
                                            }
                                        });
                                      }
                                    };
                                  IPager<UIPMWorkItem> _doubleArrow_1 = ObjectExtensions.<IPager<UIPMWorkItem>>operator_doubleArrow(_createPager, _function_1);
                                  PMWorkItemManagementView.this.pager = _doubleArrow_1;
                                  final Procedure1<UIPMWorkItem> _function_2 = new Procedure1<UIPMWorkItem>() {
                                      public void apply(final UIPMWorkItem it) {
                                        RCPMWorkItemProxy _proxy = it.toProxy();
                                        pmworkitemSelectedRequestHandler.execute(_proxy);
                                        
                                      }
                                    };
                                  PMWorkItemManagementView.this.listGrid.addSelectEntityListener(new SelectEntityListener<UIPMWorkItem>() {
                                      public void objectSelected(UIPMWorkItem selected) {
                                        _function_2.apply(selected);
                                      }
                                  });
                                  ContentPanel _ContentPanel = PMWorkItemManagementView.this.widgets.ContentPanel();
                                  final Procedure1<ContentPanel> _function_3 = new Procedure1<ContentPanel>() {
                                      public void apply(final ContentPanel it) {
                                        VerticalLayoutContainer _VLayout = PMWorkItemManagementView.this.widgets.VLayout();
                                        final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                                            public void apply(final VerticalLayoutContainer it) {
                                              SGroupingGrid<UIPMWorkItem> _asWidget = PMWorkItemManagementView.this.listGrid.asWidget();
                                              VerticalLayoutData _VLayoutData = PMWorkItemManagementView.this.widgets.VLayoutData(1, 1);
                                              it.add(_asWidget, _VLayoutData);
                                              Widget _asWidget_1 = PMWorkItemManagementView.this.pager.asWidget();
                                              int _minus = (-1);
                                              VerticalLayoutData _VLayoutData_1 = PMWorkItemManagementView.this.widgets.VLayoutData(1, _minus);
                                              it.add(_asWidget_1, _VLayoutData_1);
                                            }
                                          };
                                        VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                                        it.setWidget(_doubleArrow);
                                      }
                                    };
                                  ContentPanel _doubleArrow_2 = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function_3);
                                  VerticalLayoutData _VLayoutData = PMWorkItemManagementView.this.widgets.VLayoutData(1, 1);
                                  it.add(_doubleArrow_2, _VLayoutData);
                                }
                              };
                            VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                            it.setWidget(_doubleArrow);
                            final Procedure1<Void> _function_1 = new Procedure1<Void>() {
                                public void apply(final Void v) {
                                  TextButton _TextButton = PMWorkItemManagementView.this.widgets.TextButton("\u65B0\u5EFA");
                                  final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                                      public void apply(final TextButton it) {
                                        final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                            public void apply(final SelectEvent it) {createRequestRequestHandler.execute();
                                              
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
                                  it.addButton(_doubleArrow);
                                }
                              };
                            PMWorkItemManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                              public IFunctionIdentifier apply() {
                                return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.device.PMWorkItemManagementPresenter.createRequest" );
                              }
                            }.apply(), _function_1);
                            final Procedure1<Void> _function_2 = new Procedure1<Void>() {
                                public void apply(final Void v) {
                                  final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                      public void apply(final SingleObjectActions it) {
                                        final Procedure1<UIPMWorkItem> _function = new Procedure1<UIPMWorkItem>() {
                                            public void apply(final UIPMWorkItem selectedValue) {
                                              RCPMWorkItemProxy _proxy = selectedValue.toProxy();
                                              modifyRequestRequestHandler.execute(_proxy);
                                              
                                            }
                                          };
                                        it.onExecute(_function);
                                        final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                                            public Boolean apply(final Void it) {
                                              final Function1<UIPMWorkItem,Boolean> _function = new Function1<UIPMWorkItem,Boolean>() {
                                                  public Boolean apply(final UIPMWorkItem it) {
                                                    UIPMWorkItemStatue _status = it.getStatus();
                                                    boolean _equals = Objects.equal(_status, UIPMWorkItemStatue.planed);
                                                    return Boolean.valueOf(_equals);
                                                  }
                                                };
                                              Boolean _singleSelectedAnd = ActionExtensions.<UIPMWorkItem>singleSelectedAnd(PMWorkItemManagementView.this.listGrid, _function);
                                              return _singleSelectedAnd;
                                            }
                                          };
                                        it.onCheckEnable(_function_1);
                                      }
                                    };
                                  SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIPMWorkItem>onSingleObjectAction(ac, _function);
                                  TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u4FEE\u6539/\u6D3E\u53D1");
                                  it.addButton(_asButtonRequester);
                                }
                              };
                            PMWorkItemManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                              public IFunctionIdentifier apply() {
                                return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.device.PMWorkItemManagementPresenter.modifyRequest" );
                              }
                            }.apply(), _function_2);
                            final Procedure1<Void> _function_3 = new Procedure1<Void>() {
                                public void apply(final Void v) {
                                  final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                      public void apply(final SingleObjectActions it) {
                                        final Procedure1<UIPMWorkItem> _function = new Procedure1<UIPMWorkItem>() {
                                            public void apply(final UIPMWorkItem selectedValue) {
                                              RCPMWorkItemProxy _proxy = selectedValue.toProxy();
                                              selectedPlansRequestRequestHandler.execute(_proxy);
                                              
                                            }
                                          };
                                        it.onExecute(_function);
                                        final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                                            public Boolean apply(final Void it) {
                                              final Function1<UIPMWorkItem,Boolean> _function = new Function1<UIPMWorkItem,Boolean>() {
                                                  public Boolean apply(final UIPMWorkItem it) {
                                                    UIPMWorkItemStatue _status = it.getStatus();
                                                    boolean _equals = Objects.equal(_status, UIPMWorkItemStatue.planed);
                                                    return Boolean.valueOf(_equals);
                                                  }
                                                };
                                              Boolean _singleSelectedAnd = ActionExtensions.<UIPMWorkItem>singleSelectedAnd(PMWorkItemManagementView.this.listGrid, _function);
                                              return _singleSelectedAnd;
                                            }
                                          };
                                        it.onCheckEnable(_function_1);
                                      }
                                    };
                                  SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIPMWorkItem>onSingleObjectAction(ac, _function);
                                  TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u8FFD\u52A0PM\u8BA1\u5212");
                                  it.addButton(_asButtonRequester);
                                }
                              };
                            PMWorkItemManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                              public IFunctionIdentifier apply() {
                                return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.device.PMWorkItemManagementPresenter.selectedPlansRequest" );
                              }
                            }.apply(), _function_3);
                            final Procedure1<Void> _function_4 = new Procedure1<Void>() {
                                public void apply(final Void v) {
                                  final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                      public void apply(final SingleObjectActions it) {
                                        final Procedure1<UIPMWorkItem> _function = new Procedure1<UIPMWorkItem>() {
                                            public void apply(final UIPMWorkItem selectedValue) {
                                              final Procedure1<Void> _function = new Procedure1<Void>() {
                                                  public void apply(final Void it) {
                                                    RCPMWorkItemProxy _proxy = selectedValue.toProxy();
                                                    finishWorkItemRequestRequestHandler.execute(_proxy);
                                                    
                                                  }
                                                };
                                              ConfirmMessageBox _ConfirmMessageBox = PMWorkItemManagementView.this.widgets.ConfirmMessageBox("\u786E\u8BA4", "\u786E\u8BA4\u7ED3\u5355", _function);
                                              _ConfirmMessageBox.show();
                                            }
                                          };
                                        it.onExecute(_function);
                                        final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                                            public Boolean apply(final Void it) {
                                              final Function1<UIPMWorkItem,Boolean> _function = new Function1<UIPMWorkItem,Boolean>() {
                                                  public Boolean apply(final UIPMWorkItem it) {
                                                    UIPMWorkItemStatue _status = it.getStatus();
                                                    boolean _equals = Objects.equal(_status, UIPMWorkItemStatue.teamFinished);
                                                    return Boolean.valueOf(_equals);
                                                  }
                                                };
                                              Boolean _singleSelectedAnd = ActionExtensions.<UIPMWorkItem>singleSelectedAnd(PMWorkItemManagementView.this.listGrid, _function);
                                              return _singleSelectedAnd;
                                            }
                                          };
                                        it.onCheckEnable(_function_1);
                                      }
                                    };
                                  SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIPMWorkItem>onSingleObjectAction(ac, _function);
                                  TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u7ED3\u5355");
                                  it.addButton(_asButtonRequester);
                                }
                              };
                            PMWorkItemManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                              public IFunctionIdentifier apply() {
                                return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.device.PMWorkItemManagementPresenter.finishWorkItemRequest" );
                              }
                            }.apply(), _function_4);
                            final Procedure1<Void> _function_5 = new Procedure1<Void>() {
                                public void apply(final Void v) {
                                  final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                      public void apply(final SingleObjectActions it) {
                                        final Procedure1<UIPMWorkItem> _function = new Procedure1<UIPMWorkItem>() {
                                            public void apply(final UIPMWorkItem selectedValue) {
                                              final Procedure1<Void> _function = new Procedure1<Void>() {
                                                  public void apply(final Void it) {
                                                    RCPMWorkItemProxy _proxy = selectedValue.toProxy();
                                                    deleteRequestRequestHandler.execute(_proxy);
                                                    
                                                  }
                                                };
                                              ConfirmMessageBox _ConfirmMessageBox = PMWorkItemManagementView.this.widgets.ConfirmMessageBox("\u786E\u8BA4", "\u786E\u8BA4\u5220\u9664", _function);
                                              _ConfirmMessageBox.show();
                                            }
                                          };
                                        it.onExecute(_function);
                                        final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                                            public Boolean apply(final Void it) {
                                              final Function1<UIPMWorkItem,Boolean> _function = new Function1<UIPMWorkItem,Boolean>() {
                                                  public Boolean apply(final UIPMWorkItem it) {
                                                    UIPMWorkItemStatue _status = it.getStatus();
                                                    boolean _equals = Objects.equal(_status, UIPMWorkItemStatue.planed);
                                                    return Boolean.valueOf(_equals);
                                                  }
                                                };
                                              Boolean _singleSelectedAnd = ActionExtensions.<UIPMWorkItem>singleSelectedAnd(PMWorkItemManagementView.this.listGrid, _function);
                                              return _singleSelectedAnd;
                                            }
                                          };
                                        it.onCheckEnable(_function_1);
                                      }
                                    };
                                  SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIPMWorkItem>onSingleObjectAction(ac, _function);
                                  TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u5220\u9664");
                                  it.addButton(_asButtonRequester);
                                }
                              };
                            PMWorkItemManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                              public IFunctionIdentifier apply() {
                                return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.device.PMWorkItemManagementPresenter.deleteRequest" );
                              }
                            }.apply(), _function_5);
                          }
                        };
                      ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
                      return _doubleArrow;
                    }
                  };
                HTMLTagsExt.center(it, _function);
                final Function1<Void,TabPanel> _function_1 = new Function1<Void,TabPanel>() {
                    public TabPanel apply(final Void it) {
                      TabPanel _TabPanel = PMWorkItemManagementView.this.widgets.TabPanel();
                      final Procedure1<TabPanel> _function = new Procedure1<TabPanel>() {
                          public void apply(final TabPanel it) {
                            final Function1<UIPMWorkItem,RCPMWorkItemProxy> _function = new Function1<UIPMWorkItem,RCPMWorkItemProxy>() {
                                public RCPMWorkItemProxy apply(final UIPMWorkItem it) {
                                  RCPMWorkItemProxy _proxy = it.toProxy();
                                  return _proxy;
                                }
                              };
                            ActionContext<RCPMWorkItemProxy> _adapt = ac.<RCPMWorkItemProxy>adapt(new Function<UIPMWorkItem,RCPMWorkItemProxy>() {
                                public RCPMWorkItemProxy apply(UIPMWorkItem input) {
                                  return _function.apply(input);
                                }
                            });
                            PMWorkItemManagementView.this.workItemPropertyPresenter.setContext(_adapt);
                            PMWorkItemPropertyPresenterView _view = PMWorkItemManagementView.this.workItemPropertyPresenter.getView();
                            Widget _asWidget = _view.asWidget();
                            it.add(_asWidget, "\u4EFB\u52A1\u8BE6\u60C5");
                            ContentPanel _ContentPanel = PMWorkItemManagementView.this.widgets.ContentPanel();
                            final Procedure1<ContentPanel> _function_1 = new Procedure1<ContentPanel>() {
                                public void apply(final ContentPanel it) {
                                  WorkItemPlanAssignmentListPresenterView _view = PMWorkItemManagementView.this.workItemPlanAssignmentListPresenter.getView();
                                  Widget _asWidget = _view.asWidget();
                                  it.setWidget(_asWidget);
                                  WorkItemPlanAssignmentListPresenterView _view_1 = PMWorkItemManagementView.this.workItemPlanAssignmentListPresenter.getView();
                                  ActionContext<UIWorkItemPlanAssignment> _actionContext = _view_1.getActionContext();
                                  final Function1<UIWorkItemPlanAssignment,RCWorkItemPlanAssignmentProxy> _function = new Function1<UIWorkItemPlanAssignment,RCWorkItemPlanAssignmentProxy>() {
                                      public RCWorkItemPlanAssignmentProxy apply(final UIWorkItemPlanAssignment it) {
                                        RCWorkItemPlanAssignmentProxy _proxy = it.toProxy();
                                        return _proxy;
                                      }
                                    };
                                  final ActionContext<RCWorkItemPlanAssignmentProxy> wiac = _actionContext.<RCWorkItemPlanAssignmentProxy>adapt(new Function<UIWorkItemPlanAssignment,RCWorkItemPlanAssignmentProxy>() {
                                      public RCWorkItemPlanAssignmentProxy apply(UIWorkItemPlanAssignment input) {
                                        return _function.apply(input);
                                      }
                                  });
                                  final Procedure1<RemoveWorkItemPlanAssignmentCommand> _function_1 = new Procedure1<RemoveWorkItemPlanAssignmentCommand>() {
                                      public void apply(final RemoveWorkItemPlanAssignmentCommand it) {
                                        it.workitemContext = ac;
                                      }
                                    };
                                  RemoveWorkItemPlanAssignmentCommand _doubleArrow = ObjectExtensions.<RemoveWorkItemPlanAssignmentCommand>operator_doubleArrow(PMWorkItemManagementView.this.removeWorkItemPlanAssignmentCommand, _function_1);
                                  it.addCommand(wiac, _doubleArrow);
                                }
                              };
                            ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function_1);
                            it.add(_doubleArrow, "PM\u8BA1\u5212\u6E05\u5355");
                            PMWorkItemWorkerAssignmentListPresenterView _view_1 = PMWorkItemManagementView.this.workItemWorkerAssignmentListPresenter.getView();
                            Widget _asWidget_1 = _view_1.asWidget();
                            it.add(_asWidget_1, "\u6D3E\u5DE5\u4FE1\u606F");
                            PMWorkItemEvaluatePropertyViewPresenterView _view_2 = PMWorkItemManagementView.this.workItemEvaluatePropertyViewPresenter.getView();
                            Widget _asWidget_2 = _view_2.asWidget();
                            it.add(_asWidget_2, "\u670D\u52A1\u8BC4\u4EF7");
                          }
                        };
                      TabPanel _doubleArrow = ObjectExtensions.<TabPanel>operator_doubleArrow(_TabPanel, _function);
                      return _doubleArrow;
                    }
                  };
                HTMLTagsExt.south(it, 0.4, _function_1);
              }
            };
          BorderLayoutContainer _doubleArrow = ObjectExtensions.<BorderLayoutContainer>operator_doubleArrow(_BorderLayout, _function);
          it.setWidget(_doubleArrow);
        }
      };
    FramedPanel _doubleArrow = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function);
    this.con = _doubleArrow;
  }
  
  public void showResults(final IPagedResult<UIPMWorkItem> results) {
    this.pager.pageLoaded(results);
  }
  
  public void refresh() {
    int _activePage = this.pager.getActivePage();
    this.pager.gotoPage(_activePage);
  }
  
  private RequestHandler createRequestRequestHandler;
  
  public void createRequest(final RequestHandler requestHandler) {
    this.createRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCPMWorkItemProxy> deleteRequestRequestHandler;
  
  public void deleteRequest(final RequestHandler1<RCPMWorkItemProxy> requestHandler) {
    this.deleteRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCPMWorkItemProxy> modifyRequestRequestHandler;
  
  public void modifyRequest(final RequestHandler1<RCPMWorkItemProxy> requestHandler) {
    this.modifyRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<UIPMWorkItemCriteria> filterRequestRequestHandler;
  
  public void filterRequest(final RequestHandler1<UIPMWorkItemCriteria> requestHandler) {
    this.filterRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCPMWorkItemProxy> pmworkitemSelectedRequestHandler;
  
  public void pmworkitemSelected(final RequestHandler1<RCPMWorkItemProxy> requestHandler) {
    this.pmworkitemSelectedRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCPMWorkItemProxy> selectedPlansRequestRequestHandler;
  
  public void selectedPlansRequest(final RequestHandler1<RCPMWorkItemProxy> requestHandler) {
    this.selectedPlansRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCPMWorkItemProxy> finishWorkItemRequestRequestHandler;
  
  public void finishWorkItemRequest(final RequestHandler1<RCPMWorkItemProxy> requestHandler) {
    this.finishWorkItemRequestRequestHandler = requestHandler;
  }
}
