package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemWorkerAssignmentProxy;
import com.fudanmed.platform.core.web.client.device.PMEngineerReportCommand;
import com.fudanmed.platform.core.web.client.device.PMTeamWorkItemManagementPresenterView;
import com.fudanmed.platform.core.web.client.device.PMWorkItem4TeamListGrid;
import com.fudanmed.platform.core.web.client.device.PMWorkItemCriteriaForm;
import com.fudanmed.platform.core.web.client.device.PMWorkItemEvaluatePropertyViewPresenter;
import com.fudanmed.platform.core.web.client.device.PMWorkItemEvaluatePropertyViewPresenterView;
import com.fudanmed.platform.core.web.client.device.PMWorkItemPropertyPresenter;
import com.fudanmed.platform.core.web.client.device.PMWorkItemPropertyPresenterView;
import com.fudanmed.platform.core.web.client.device.PMWorkItemWorkerAssignmentListPresenter;
import com.fudanmed.platform.core.web.client.device.PMWorkItemWorkerAssignmentListPresenterView;
import com.fudanmed.platform.core.web.client.device.PrintPMWorkItemAssignmentCommand;
import com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentListPresenter;
import com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentListPresenterView;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItem;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemCriteria;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemStatue;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignment;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignmentStatus;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
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
import edu.fudan.langlab.gxt.client.widget.HTableLayoutContainer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.TabPanel;
import edu.fudan.langlab.security.client.Securities;
import edu.fudan.langlab.security.shared.IFunctionIdentifier;
import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

public class PMTeamWorkItemManagementView extends GWTAbstractView implements PMTeamWorkItemManagementPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(listGrid,criteriaForm,engineerReportCommand,printPMWorkItemAssignmentCommand),
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
  private PMWorkItem4TeamListGrid listGrid;
  
  @Inject
  private PMWorkItemCriteriaForm criteriaForm;
  
  @Inject
  private PMEngineerReportCommand engineerReportCommand;
  
  @Inject
  private PrintPMWorkItemAssignmentCommand printPMWorkItemAssignmentCommand;
  
  private IPager pager;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    this.listGrid.asWidget();
    this.listGrid.keepSelection();
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u73ED\u7EC4PM\u5DE5\u4F5C\u53F0");
    final Procedure1<FramedPanel> _function = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          BorderLayoutContainer _BorderLayout = PMTeamWorkItemManagementView.this.widgets.BorderLayout();
          final Procedure1<BorderLayoutContainer> _function = new Procedure1<BorderLayoutContainer>() {
              public void apply(final BorderLayoutContainer it) {
                final Function1<Void,ContentPanel> _function = new Function1<Void,ContentPanel>() {
                    public ContentPanel apply(final Void it) {
                      ContentPanel _ContentPanel = PMTeamWorkItemManagementView.this.widgets.ContentPanel();
                      final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
                          public void apply(final ContentPanel it) {
                            it.setBodyBorder(false);
                            it.setBorders(false);
                            VerticalLayoutContainer _VLayout = PMTeamWorkItemManagementView.this.widgets.VLayout();
                            final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                                public void apply(final VerticalLayoutContainer it) {
                                  HTableLayoutContainer _HTableLayout = PMTeamWorkItemManagementView.this.widgets.HTableLayout();
                                  final Procedure1<HTableLayoutContainer> _function = new Procedure1<HTableLayoutContainer>() {
                                      public void apply(final HTableLayoutContainer it) {
                                        FieldLabel _asWidget = PMTeamWorkItemManagementView.this.criteriaForm.assignDateFrom.asWidget();
                                        FieldLabel _asWidget_1 = PMTeamWorkItemManagementView.this.criteriaForm.assignDateTo.asWidget();
                                        FieldLabel _asWidget_2 = PMTeamWorkItemManagementView.this.criteriaForm.includeFinishedItems.asWidget();
                                        TextButton _TextButton = PMTeamWorkItemManagementView.this.widgets.TextButton("\u7B5B\u9009");
                                        final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                                            public void apply(final TextButton it) {
                                              it.setWidth("80px");
                                              final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                                  public void apply(final SelectEvent it) {
                                                    UIPMWorkItemCriteria _value = PMTeamWorkItemManagementView.this.criteriaForm.getValue();
                                                    UIPMWorkItemCriteria _withPagerInfo = Extensions.<UIPMWorkItemCriteria>withPagerInfo(_value, PMTeamWorkItemManagementView.this.pager);
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
                                        ArrayList<Widget> _newArrayList = CollectionLiterals.<Widget>newArrayList(_asWidget, _asWidget_1, _asWidget_2, _doubleArrow);
                                        it.add(_newArrayList);
                                      }
                                    };
                                  HTableLayoutContainer _doubleArrow = ObjectExtensions.<HTableLayoutContainer>operator_doubleArrow(_HTableLayout, _function);
                                  it.add(_doubleArrow);
                                  IPager<UIPMWorkItem> _createPager = edu.fudan.langlab.gxt.client.pager.Extensions.<UIPMWorkItem>createPager(PMTeamWorkItemManagementView.this.listGrid);
                                  final Procedure1<IPager<UIPMWorkItem>> _function_1 = new Procedure1<IPager<UIPMWorkItem>>() {
                                      public void apply(final IPager<UIPMWorkItem> it) {
                                        final Procedure2<Integer,Integer> _function = new Procedure2<Integer,Integer>() {
                                            public void apply(final Integer pageNum, final Integer recordsPerPage) {
                                              UIPMWorkItemCriteria _value = PMTeamWorkItemManagementView.this.criteriaForm.getValue();
                                              UIPMWorkItemCriteria _withPagerInfo = Extensions.<UIPMWorkItemCriteria>withPagerInfo(_value, PMTeamWorkItemManagementView.this.pager);
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
                                  PMTeamWorkItemManagementView.this.pager = _doubleArrow_1;
                                  final Procedure1<UIPMWorkItem> _function_2 = new Procedure1<UIPMWorkItem>() {
                                      public void apply(final UIPMWorkItem it) {
                                        RCPMWorkItemProxy _proxy = it.toProxy();
                                        pmworkitemSelectedRequestHandler.execute(_proxy);
                                        
                                      }
                                    };
                                  PMTeamWorkItemManagementView.this.listGrid.addSelectEntityListener(new SelectEntityListener<UIPMWorkItem>() {
                                      public void objectSelected(UIPMWorkItem selected) {
                                        _function_2.apply(selected);
                                      }
                                  });
                                  ContentPanel _ContentPanel = PMTeamWorkItemManagementView.this.widgets.ContentPanel();
                                  final Procedure1<ContentPanel> _function_3 = new Procedure1<ContentPanel>() {
                                      public void apply(final ContentPanel it) {
                                        VerticalLayoutContainer _VLayout = PMTeamWorkItemManagementView.this.widgets.VLayout();
                                        final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                                            public void apply(final VerticalLayoutContainer it) {
                                              SGroupingGrid<UIPMWorkItem> _asWidget = PMTeamWorkItemManagementView.this.listGrid.asWidget();
                                              VerticalLayoutData _VLayoutData = PMTeamWorkItemManagementView.this.widgets.VLayoutData(1, 1);
                                              it.add(_asWidget, _VLayoutData);
                                              Widget _asWidget_1 = PMTeamWorkItemManagementView.this.pager.asWidget();
                                              int _minus = (-1);
                                              VerticalLayoutData _VLayoutData_1 = PMTeamWorkItemManagementView.this.widgets.VLayoutData(1, _minus);
                                              it.add(_asWidget_1, _VLayoutData_1);
                                            }
                                          };
                                        VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                                        it.setWidget(_doubleArrow);
                                      }
                                    };
                                  ContentPanel _doubleArrow_2 = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function_3);
                                  VerticalLayoutData _VLayoutData = PMTeamWorkItemManagementView.this.widgets.VLayoutData(1, 1);
                                  it.add(_doubleArrow_2, _VLayoutData);
                                }
                              };
                            VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                            it.setWidget(_doubleArrow);
                            final ActionContext<UIPMWorkItem> ac = ActionExtensions.<UIPMWorkItem>createActionContext(PMTeamWorkItemManagementView.this.listGrid);
                            final Procedure1<Void> _function_1 = new Procedure1<Void>() {
                                public void apply(final Void v) {
                                  final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                      public void apply(final SingleObjectActions it) {
                                        final Procedure1<UIPMWorkItem> _function = new Procedure1<UIPMWorkItem>() {
                                            public void apply(final UIPMWorkItem selectedValue) {
                                              RCPMWorkItemProxy _proxy = selectedValue.toProxy();
                                              assignWorkerRequestRequestHandler.execute(_proxy);
                                              
                                            }
                                          };
                                        it.onExecute(_function);
                                        final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                                            public Boolean apply(final Void it) {
                                              final Function1<UIPMWorkItem,Boolean> _function = new Function1<UIPMWorkItem,Boolean>() {
                                                  public Boolean apply(final UIPMWorkItem it) {
                                                    boolean _or = false;
                                                    UIPMWorkItemStatue _status = it.getStatus();
                                                    boolean _equals = Objects.equal(_status, UIPMWorkItemStatue.teamAssigned);
                                                    if (_equals) {
                                                      _or = true;
                                                    } else {
                                                      UIPMWorkItemStatue _status_1 = it.getStatus();
                                                      boolean _equals_1 = Objects.equal(_status_1, UIPMWorkItemStatue.partialExecuting);
                                                      _or = (_equals || _equals_1);
                                                    }
                                                    return Boolean.valueOf(_or);
                                                  }
                                                };
                                              Boolean _singleSelectedAnd = ActionExtensions.<UIPMWorkItem>singleSelectedAnd(PMTeamWorkItemManagementView.this.listGrid, _function);
                                              return _singleSelectedAnd;
                                            }
                                          };
                                        it.onCheckEnable(_function_1);
                                      }
                                    };
                                  SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIPMWorkItem>onSingleObjectAction(ac, _function);
                                  TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u6D3E\u5DE5");
                                  it.addButton(_asButtonRequester);
                                }
                              };
                            PMTeamWorkItemManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                              public IFunctionIdentifier apply() {
                                return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.device.PMTeamWorkItemManagementPresenter.assignWorkerRequest" );
                              }
                            }.apply(), _function_1);
                            final Procedure1<Void> _function_2 = new Procedure1<Void>() {
                                public void apply(final Void v) {
                                  final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                      public void apply(final SingleObjectActions it) {
                                        final Procedure1<UIPMWorkItem> _function = new Procedure1<UIPMWorkItem>() {
                                            public void apply(final UIPMWorkItem selectedValue) {
                                              RCPMWorkItemProxy _proxy = selectedValue.toProxy();
                                              reportAllFinishRequestRequestHandler.execute(_proxy);
                                              
                                            }
                                          };
                                        it.onExecute(_function);
                                        final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                                            public Boolean apply(final Void it) {
                                              final Function1<UIPMWorkItem,Boolean> _function = new Function1<UIPMWorkItem,Boolean>() {
                                                  public Boolean apply(final UIPMWorkItem it) {
                                                    UIPMWorkItemStatue _status = it.getStatus();
                                                    boolean _equals = Objects.equal(_status, UIPMWorkItemStatue.ready4TeamFinishReport);
                                                    return Boolean.valueOf(_equals);
                                                  }
                                                };
                                              Boolean _singleSelectedAnd = ActionExtensions.<UIPMWorkItem>singleSelectedAnd(PMTeamWorkItemManagementView.this.listGrid, _function);
                                              return _singleSelectedAnd;
                                            }
                                          };
                                        it.onCheckEnable(_function_1);
                                      }
                                    };
                                  SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIPMWorkItem>onSingleObjectAction(ac, _function);
                                  TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u5B8C\u5DE5\u4E0A\u62A5");
                                  it.addButton(_asButtonRequester);
                                }
                              };
                            PMTeamWorkItemManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                              public IFunctionIdentifier apply() {
                                return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.device.PMTeamWorkItemManagementPresenter.reportAllFinishRequest" );
                              }
                            }.apply(), _function_2);
                          }
                        };
                      ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
                      return _doubleArrow;
                    }
                  };
                HTMLTagsExt.center(it, _function);
                final Function1<Void,ContentPanel> _function_1 = new Function1<Void,ContentPanel>() {
                    public ContentPanel apply(final Void it) {
                      ContentPanel _ContentPanel = PMTeamWorkItemManagementView.this.widgets.ContentPanel();
                      final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
                          public void apply(final ContentPanel it) {
                            TabPanel _TabPanel = PMTeamWorkItemManagementView.this.widgets.TabPanel();
                            final Procedure1<TabPanel> _function = new Procedure1<TabPanel>() {
                                public void apply(final TabPanel it) {
                                  PMWorkItemPropertyPresenterView _view = PMTeamWorkItemManagementView.this.workItemPropertyPresenter.getView();
                                  Widget _asWidget = _view.asWidget();
                                  it.add(_asWidget, "\u4EFB\u52A1\u8BE6\u60C5");
                                  ContentPanel _ContentPanel = PMTeamWorkItemManagementView.this.widgets.ContentPanel();
                                  final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
                                      public void apply(final ContentPanel it) {
                                        PMWorkItemWorkerAssignmentListPresenterView _view = PMTeamWorkItemManagementView.this.workItemWorkerAssignmentListPresenter.getView();
                                        Widget _asWidget = _view.asWidget();
                                        it.setWidget(_asWidget);
                                        PMWorkItemWorkerAssignmentListPresenterView _view_1 = PMTeamWorkItemManagementView.this.workItemWorkerAssignmentListPresenter.getView();
                                        final ActionContext<UIPMWorkItemWorkerAssignment> assignmentAc = _view_1.getActionContext();
                                        final Procedure1<Void> _function = new Procedure1<Void>() {
                                            public void apply(final Void v) {
                                              final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                                  public void apply(final SingleObjectActions it) {
                                                    final Procedure1<UIPMWorkItemWorkerAssignment> _function = new Procedure1<UIPMWorkItemWorkerAssignment>() {
                                                        public void apply(final UIPMWorkItemWorkerAssignment value) {
                                                          RCPMWorkItemWorkerAssignmentProxy _proxy = value.toProxy();
                                                          reportFinishRequestRequestHandler.execute(_proxy);
                                                          
                                                        }
                                                      };
                                                    it.onExecute(_function);
                                                    final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                                                        public Boolean apply(final Void it) {
                                                          final Function1<UIPMWorkItemWorkerAssignment,Boolean> _function = new Function1<UIPMWorkItemWorkerAssignment,Boolean>() {
                                                              public Boolean apply(final UIPMWorkItemWorkerAssignment it) {
                                                                boolean _and = false;
                                                                boolean _or = false;
                                                                UIPMWorkItemWorkerAssignmentStatus _status = it.getStatus();
                                                                boolean _equals = Objects.equal(_status, UIPMWorkItemWorkerAssignmentStatus.pending);
                                                                if (_equals) {
                                                                  _or = true;
                                                                } else {
                                                                  UIPMWorkItemWorkerAssignmentStatus _status_1 = it.getStatus();
                                                                  boolean _equals_1 = Objects.equal(_status_1, UIPMWorkItemWorkerAssignmentStatus.planed);
                                                                  _or = (_equals || _equals_1);
                                                                }
                                                                if (!_or) {
                                                                  _and = false;
                                                                } else {
                                                                  Boolean _allTaskFinished = it.getAllTaskFinished();
                                                                  _and = (_or && (_allTaskFinished).booleanValue());
                                                                }
                                                                return Boolean.valueOf(_and);
                                                              }
                                                            };
                                                          Boolean _singleSelectedAnd = ActionExtensions.<UIPMWorkItemWorkerAssignment>singleSelectedAnd(assignmentAc, _function);
                                                          return _singleSelectedAnd;
                                                        }
                                                      };
                                                    it.onCheckEnable(_function_1);
                                                  }
                                                };
                                              SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIPMWorkItemWorkerAssignment>onSingleObjectAction(assignmentAc, _function);
                                              TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u5DE5\u5355\u5B8C\u5DE5");
                                              it.addButton(_asButtonRequester);
                                            }
                                          };
                                        PMTeamWorkItemManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                                          public IFunctionIdentifier apply() {
                                            return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.device.PMTeamWorkItemManagementPresenter.reportFinishRequest" );
                                          }
                                        }.apply(), _function);
                                        it.addCommand(assignmentAc, PMTeamWorkItemManagementView.this.engineerReportCommand);
                                        final Function1<UIPMWorkItemWorkerAssignment,RCPMWorkItemWorkerAssignmentProxy> _function_1 = new Function1<UIPMWorkItemWorkerAssignment,RCPMWorkItemWorkerAssignmentProxy>() {
                                            public RCPMWorkItemWorkerAssignmentProxy apply(final UIPMWorkItemWorkerAssignment it) {
                                              RCPMWorkItemWorkerAssignmentProxy _proxy = it.toProxy();
                                              return _proxy;
                                            }
                                          };
                                        ActionContext<RCPMWorkItemWorkerAssignmentProxy> _adapt = assignmentAc.<RCPMWorkItemWorkerAssignmentProxy>adapt(new Function<UIPMWorkItemWorkerAssignment,RCPMWorkItemWorkerAssignmentProxy>() {
                                            public RCPMWorkItemWorkerAssignmentProxy apply(UIPMWorkItemWorkerAssignment input) {
                                              return _function_1.apply(input);
                                            }
                                        });
                                        it.addCommand(_adapt, PMTeamWorkItemManagementView.this.printPMWorkItemAssignmentCommand);
                                      }
                                    };
                                  ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
                                  it.add(_doubleArrow, "\u6D3E\u5DE5\u4FE1\u606F");
                                  ContentPanel _ContentPanel_1 = PMTeamWorkItemManagementView.this.widgets.ContentPanel();
                                  final Procedure1<ContentPanel> _function_1 = new Procedure1<ContentPanel>() {
                                      public void apply(final ContentPanel it) {
                                        WorkItemPlanAssignmentListPresenterView _view = PMTeamWorkItemManagementView.this.workItemPlanAssignmentListPresenter.getView();
                                        Widget _asWidget = _view.asWidget();
                                        it.setWidget(_asWidget);
                                      }
                                    };
                                  ContentPanel _doubleArrow_1 = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel_1, _function_1);
                                  it.add(_doubleArrow_1, "PM\u8BA1\u5212\u6E05\u5355");
                                  PMWorkItemEvaluatePropertyViewPresenterView _view_1 = PMTeamWorkItemManagementView.this.workItemEvaluatePropertyViewPresenter.getView();
                                  Widget _asWidget_1 = _view_1.asWidget();
                                  it.add(_asWidget_1, "\u670D\u52A1\u8BC4\u4EF7");
                                }
                              };
                            TabPanel _doubleArrow = ObjectExtensions.<TabPanel>operator_doubleArrow(_TabPanel, _function);
                            it.setWidget(_doubleArrow);
                          }
                        };
                      ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
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
  
  private RequestHandler1<RCPMWorkItemProxy> assignWorkerRequestRequestHandler;
  
  public void assignWorkerRequest(final RequestHandler1<RCPMWorkItemProxy> requestHandler) {
    this.assignWorkerRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<UIPMWorkItemCriteria> filterRequestRequestHandler;
  
  public void filterRequest(final RequestHandler1<UIPMWorkItemCriteria> requestHandler) {
    this.filterRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCPMWorkItemProxy> pmworkitemSelectedRequestHandler;
  
  public void pmworkitemSelected(final RequestHandler1<RCPMWorkItemProxy> requestHandler) {
    this.pmworkitemSelectedRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCPMWorkItemWorkerAssignmentProxy> reportFinishRequestRequestHandler;
  
  public void reportFinishRequest(final RequestHandler1<RCPMWorkItemWorkerAssignmentProxy> requestHandler) {
    this.reportFinishRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCPMWorkItemProxy> reportAllFinishRequestRequestHandler;
  
  public void reportAllFinishRequest(final RequestHandler1<RCPMWorkItemProxy> requestHandler) {
    this.reportAllFinishRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCPMWorkItemWorkerAssignmentProxy> pendRequestRequestHandler;
  
  public void pendRequest(final RequestHandler1<RCPMWorkItemWorkerAssignmentProxy> requestHandler) {
    this.pendRequestRequestHandler = requestHandler;
  }
}
