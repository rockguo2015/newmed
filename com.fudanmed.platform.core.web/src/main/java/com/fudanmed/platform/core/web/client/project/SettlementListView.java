package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCSettlementProxy;
import com.fudanmed.platform.core.web.client.project.RepairTask4SettlementListGrid;
import com.fudanmed.platform.core.web.client.project.SettlementCriteriaForm;
import com.fudanmed.platform.core.web.client.project.SettlementListGrid;
import com.fudanmed.platform.core.web.client.project.SettlementListPresenterView;
import com.fudanmed.platform.core.web.client.project.WorkItemStorage4SettlementListPresenter;
import com.fudanmed.platform.core.web.client.project.WorkItemStorage4SettlementListPresenterView;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.fudanmed.platform.core.web.shared.project.UISettlement;
import com.fudanmed.platform.core.web.shared.project.UISettlementCriteria;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.info.Info;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.ActionExtensions;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.ObjectListView.SelectEntityListener;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener;
import com.uniquesoft.gwt.client.common.widgets.pager.IPager;
import com.uniquesoft.gwt.client.common.widgets.pager.IPager.GotoPageHandler;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.action.MultiObjectActions;
import edu.fudan.langlab.gxt.client.action.SingleObjectActions;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.pager.Extensions;
import edu.fudan.langlab.gxt.client.widget.ContentPanel;
import edu.fudan.langlab.gxt.client.widget.FramedPanel;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.TabPanel;
import edu.fudan.langlab.security.client.Securities;
import edu.fudan.langlab.security.shared.IFunctionIdentifier;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

public class SettlementListView extends GWTAbstractView implements SettlementListPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(listGrid,criteriaForm,detailsListGrid),
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
  
  private WorkItemStorage4SettlementListPresenter workItemStorage4SettlementListPresenter;
  
  public void setWorkItemStorage4SettlementListPresenter(final WorkItemStorage4SettlementListPresenter workItemStorage4SettlementListPresenter) {
    this.workItemStorage4SettlementListPresenter = workItemStorage4SettlementListPresenter;
  }
  
  @Inject
  private SettlementListGrid listGrid;
  
  @Inject
  private SettlementCriteriaForm criteriaForm;
  
  @Inject
  private RepairTask4SettlementListGrid detailsListGrid;
  
  private IPager pager;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    this.listGrid.asWidget();
    this.listGrid.keepSelection();
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u7ED3\u7B97\u4FE1\u606F");
    final Procedure1<FramedPanel> _function = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          VerticalLayoutContainer _VLayout = SettlementListView.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                IPager<UISettlement> _createPager = Extensions.<UISettlement>createPager(SettlementListView.this.listGrid);
                final Procedure1<IPager<UISettlement>> _function = new Procedure1<IPager<UISettlement>>() {
                    public void apply(final IPager<UISettlement> it) {
                      final Procedure2<Integer,Integer> _function = new Procedure2<Integer,Integer>() {
                          public void apply(final Integer pageNum, final Integer recordsPerPage) {
                            UISettlementCriteria _value = SettlementListView.this.criteriaForm.getValue();
                            UISettlementCriteria _withPagerInfo = com.uniquesoft.gwt.client.common.widgets.pager.Extensions.<UISettlementCriteria>withPagerInfo(_value, SettlementListView.this.pager);
                            final Procedure1<UISettlementCriteria> _function = new Procedure1<UISettlementCriteria>() {
                                public void apply(final UISettlementCriteria it) {
                                  it.setPage(Integer.valueOf(pageNum));
                                  it.setPageSize(Integer.valueOf(recordsPerPage));
                                }
                              };
                            UISettlementCriteria _doubleArrow = ObjectExtensions.<UISettlementCriteria>operator_doubleArrow(_withPagerInfo, _function);
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
                IPager<UISettlement> _doubleArrow = ObjectExtensions.<IPager<UISettlement>>operator_doubleArrow(_createPager, _function);
                SettlementListView.this.pager = _doubleArrow;
                ContentPanel _ContentPanel = SettlementListView.this.widgets.ContentPanel();
                final Procedure1<ContentPanel> _function_1 = new Procedure1<ContentPanel>() {
                    public void apply(final ContentPanel it) {
                      VerticalLayoutContainer _VLayout = SettlementListView.this.widgets.VLayout();
                      final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                          public void apply(final VerticalLayoutContainer it) {
                            SGroupingGrid<UISettlement> _asWidget = SettlementListView.this.listGrid.asWidget();
                            VerticalLayoutData _VLayoutData = SettlementListView.this.widgets.VLayoutData(1, 1);
                            it.add(_asWidget, _VLayoutData);
                            Widget _asWidget_1 = SettlementListView.this.pager.asWidget();
                            it.add(_asWidget_1);
                          }
                        };
                      VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                      it.setWidget(_doubleArrow);
                      final Procedure1<Void> _function_1 = new Procedure1<Void>() {
                          public void apply(final Void v) {
                            final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                public void apply(final SelectEvent it) {createSettlementRequestRequestHandler.execute();
                                  
                                }
                              };
                            TextButton _TextButton = SettlementListView.this.widgets.TextButton("\u65B0\u5EFA\u7ED3\u7B97", _function);
                            it.addButton(_TextButton);
                          }
                        };
                      SettlementListView.this.securities.check(new Function0<IFunctionIdentifier>() {
                        public IFunctionIdentifier apply() {
                          return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.project.SettlementListPresenter.createSettlementRequest" );
                        }
                      }.apply(), _function_1);
                      final ActionContext<UISettlement> ac = ActionExtensions.<UISettlement>createActionContext(SettlementListView.this.listGrid);
                      final Procedure1<Void> _function_2 = new Procedure1<Void>() {
                          public void apply(final Void v) {
                            final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                public void apply(final SingleObjectActions it) {
                                  final Procedure1<UISettlement> _function = new Procedure1<UISettlement>() {
                                      public void apply(final UISettlement settlement) {
                                        RCSettlementProxy _proxy = settlement.toProxy();
                                        modifySettlementRequestRequestHandler.execute(_proxy);
                                        
                                      }
                                    };
                                  it.onExecute(_function);
                                }
                              };
                            SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UISettlement>onSingleObjectAction(ac, _function);
                            TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u4FEE\u6539\u7ED3\u7B97");
                            it.addButton(_asButtonRequester);
                          }
                        };
                      SettlementListView.this.securities.check(new Function0<IFunctionIdentifier>() {
                        public IFunctionIdentifier apply() {
                          return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.project.SettlementListPresenter.modifySettlementRequest" );
                        }
                      }.apply(), _function_2);
                      final Procedure1<Void> _function_3 = new Procedure1<Void>() {
                          public void apply(final Void v) {
                            final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                public void apply(final SingleObjectActions it) {
                                  final Procedure1<UISettlement> _function = new Procedure1<UISettlement>() {
                                      public void apply(final UISettlement settlement) {
                                        final Procedure1<Void> _function = new Procedure1<Void>() {
                                            public void apply(final Void it) {
                                              RCSettlementProxy _proxy = settlement.toProxy();
                                              cancelSettlementRequestRequestHandler.execute(_proxy);
                                              
                                            }
                                          };
                                        ConfirmMessageBox _ConfirmMessageBox = SettlementListView.this.widgets.ConfirmMessageBox("\u786E\u8BA4", "\u786E\u8BA4\u53D6\u6D88\u7ED3\u7B97", _function);
                                        _ConfirmMessageBox.show();
                                      }
                                    };
                                  it.onExecute(_function);
                                }
                              };
                            SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UISettlement>onSingleObjectAction(ac, _function);
                            TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u53D6\u6D88\u7ED3\u7B97");
                            it.addButton(_asButtonRequester);
                          }
                        };
                      SettlementListView.this.securities.check(new Function0<IFunctionIdentifier>() {
                        public IFunctionIdentifier apply() {
                          return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.project.SettlementListPresenter.cancelSettlementRequest" );
                        }
                      }.apply(), _function_3);
                      final Procedure1<Void> _function_4 = new Procedure1<Void>() {
                          public void apply(final Void v) {
                            final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                public void apply(final SingleObjectActions it) {
                                  final Procedure1<UISettlement> _function = new Procedure1<UISettlement>() {
                                      public void apply(final UISettlement settlement) {
                                        RCSettlementProxy _proxy = settlement.toProxy();
                                        addRepairTaskItemsRequestRequestHandler.execute(_proxy);
                                        
                                      }
                                    };
                                  it.onExecute(_function);
                                }
                              };
                            SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UISettlement>onSingleObjectAction(ac, _function);
                            TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u6DFB\u52A0\u62A5\u4FEE\u5355");
                            it.addButton(_asButtonRequester);
                          }
                        };
                      SettlementListView.this.securities.check(new Function0<IFunctionIdentifier>() {
                        public IFunctionIdentifier apply() {
                          return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.project.SettlementListPresenter.addRepairTaskItemsRequest" );
                        }
                      }.apply(), _function_4);
                      final Procedure1<Void> _function_5 = new Procedure1<Void>() {
                          public void apply(final Void v) {
                            final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                public void apply(final SingleObjectActions it) {
                                  final Procedure1<UISettlement> _function = new Procedure1<UISettlement>() {
                                      public void apply(final UISettlement settlement) {
                                        RCSettlementProxy _proxy = settlement.toProxy();
                                        printSettlementRequestRequestHandler.execute(_proxy);
                                        
                                      }
                                    };
                                  it.onExecute(_function);
                                }
                              };
                            SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UISettlement>onSingleObjectAction(ac, _function);
                            TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u6253\u5370");
                            it.addButton(_asButtonRequester);
                          }
                        };
                      SettlementListView.this.securities.check(new Function0<IFunctionIdentifier>() {
                        public IFunctionIdentifier apply() {
                          return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.project.SettlementListPresenter.printSettlementRequest" );
                        }
                      }.apply(), _function_5);
                    }
                  };
                ContentPanel _doubleArrow_1 = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function_1);
                VerticalLayoutData _VLayoutData = SettlementListView.this.widgets.VLayoutData(1, 0.45);
                it.add(_doubleArrow_1, _VLayoutData);
                final Procedure1<UISettlement> _function_2 = new Procedure1<UISettlement>() {
                    public void apply(final UISettlement it) {
                      boolean _notEquals = (!Objects.equal(it, null));
                      if (_notEquals) {
                        RCSettlementProxy _proxy = it.toProxy();
                        showDetailRequestRequestHandler.execute(_proxy);
                        
                      }
                    }
                  };
                SettlementListView.this.listGrid.addSelectEntityListener(new SelectEntityListener<UISettlement>() {
                    public void objectSelected(UISettlement selected) {
                      _function_2.apply(selected);
                    }
                });
                final Procedure1<Iterable<UISettlement>> _function_3 = new Procedure1<Iterable<UISettlement>>() {
                    public void apply(final Iterable<UISettlement> it) {
                      boolean _isNullOrEmpty = IterableExtensions.isNullOrEmpty(it);
                      if (_isNullOrEmpty) {
                        ArrayList<UIRepairTask> _newArrayList = CollectionLiterals.<UIRepairTask>newArrayList();
                        SettlementListView.this.detailsListGrid.setObjects(_newArrayList);
                      }
                    }
                  };
                SettlementListView.this.listGrid.addSelectionChangedListener(new SelectionChangedListener<UISettlement>() {
                    public void selectionChanged(Iterable<UISettlement> selections) {
                      _function_3.apply(selections);
                    }
                });
                TabPanel _TabPanel = SettlementListView.this.widgets.TabPanel();
                final Procedure1<TabPanel> _function_4 = new Procedure1<TabPanel>() {
                    public void apply(final TabPanel it) {
                      ContentPanel _ContentPanel = SettlementListView.this.widgets.ContentPanel();
                      final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
                          public void apply(final ContentPanel it) {
                            SGroupingGrid<UIRepairTask> _asWidget = SettlementListView.this.detailsListGrid.asWidget();
                            it.setWidget(_asWidget);
                            final ActionContext<UIRepairTask> detailAc = ActionExtensions.<UIRepairTask>createActionContext(SettlementListView.this.detailsListGrid);
                            final Procedure1<Void> _function = new Procedure1<Void>() {
                                public void apply(final Void v) {
                                  final Procedure1<MultiObjectActions> _function = new Procedure1<MultiObjectActions>() {
                                      public void apply(final MultiObjectActions it) {
                                        final Procedure1<Iterable<UIRepairTask>> _function = new Procedure1<Iterable<UIRepairTask>>() {
                                            public void apply(final Iterable<UIRepairTask> repairTasks) {
                                              final Procedure1<Void> _function = new Procedure1<Void>() {
                                                  public void apply(final Void it) {
                                                    int _size = IterableExtensions.size(repairTasks);
                                                    String _string = Integer.valueOf(_size).toString();
                                                    Info.display("", _string);
                                                    final Function1<UIRepairTask,RCRepairTaskProxy> _function = new Function1<UIRepairTask,RCRepairTaskProxy>() {
                                                        public RCRepairTaskProxy apply(final UIRepairTask it) {
                                                          RCRepairTaskProxy _proxy = it.toProxy();
                                                          return _proxy;
                                                        }
                                                      };
                                                    Iterable<RCRepairTaskProxy> _map = IterableExtensions.<UIRepairTask, RCRepairTaskProxy>map(repairTasks, _function);
                                                    Collection<RCRepairTaskProxy> _unlazy = IterableExtensions2.<RCRepairTaskProxy>unlazy(_map);
                                                    cancelSettlementItemRequestRequestHandler.execute(_unlazy);
                                                    
                                                  }
                                                };
                                              ConfirmMessageBox _ConfirmMessageBox = SettlementListView.this.widgets.ConfirmMessageBox("\u786E\u8BA4\u79FB\u9664", "\u786E\u8BA4\u79FB\u9664", _function);
                                              _ConfirmMessageBox.show();
                                            }
                                          };
                                        it.onExecute(_function);
                                      }
                                    };
                                  MultiObjectActions _onMultiObjectAction = MultiObjectActions.<UIRepairTask>onMultiObjectAction(detailAc, _function);
                                  TextButton _asButtonRequester = _onMultiObjectAction.asButtonRequester("\u79FB\u9664");
                                  it.addButton(_asButtonRequester);
                                }
                              };
                            SettlementListView.this.securities.check(new Function0<IFunctionIdentifier>() {
                              public IFunctionIdentifier apply() {
                                return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.project.SettlementListPresenter.cancelSettlementItemRequest" );
                              }
                            }.apply(), _function);
                            final Procedure1<SingleObjectActions> _function_1 = new Procedure1<SingleObjectActions>() {
                                public void apply(final SingleObjectActions it) {
                                  final Procedure1<UIRepairTask> _function = new Procedure1<UIRepairTask>() {
                                      public void apply(final UIRepairTask repairTask) {
                                        RCRepairTaskProxy _proxy = repairTask.toProxy();
                                        showRepairTaskDetailRequestHandler.execute(_proxy);
                                        
                                      }
                                    };
                                  it.onExecute(_function);
                                }
                              };
                            SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIRepairTask>onSingleObjectAction(detailAc, _function_1);
                            TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u62A5\u4FEE\u5355\u8BE6\u60C5");
                            it.addButton(_asButtonRequester);
                          }
                        };
                      ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
                      it.add(_doubleArrow, "\u62A5\u4FEE\u5355");
                      WorkItemStorage4SettlementListPresenterView _view = SettlementListView.this.workItemStorage4SettlementListPresenter.getView();
                      Widget _asWidget = _view.asWidget();
                      it.add(_asWidget, "\u6750\u6599\u6E05\u5355");
                    }
                  };
                TabPanel _doubleArrow_2 = ObjectExtensions.<TabPanel>operator_doubleArrow(_TabPanel, _function_4);
                VerticalLayoutData _VLayoutData_1 = SettlementListView.this.widgets.VLayoutData(1, 0.55);
                it.add(_doubleArrow_2, _VLayoutData_1);
              }
            };
          VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
          it.setWidget(_doubleArrow);
        }
      };
    FramedPanel _doubleArrow = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function);
    this.con = _doubleArrow;
  }
  
  public void showResults(final IPagedResult<UISettlement> results) {
    this.pager.pageLoaded(results);
  }
  
  public void showDetails(final Collection<UIRepairTask> details) {
    this.detailsListGrid.setObjects(details);
  }
  
  public void refresh() {
    int _activePage = this.pager.getActivePage();
    this.pager.gotoPage(_activePage);
  }
  
  private RequestHandler1<UISettlementCriteria> filterRequestRequestHandler;
  
  public void filterRequest(final RequestHandler1<UISettlementCriteria> requestHandler) {
    this.filterRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCSettlementProxy> showDetailRequestRequestHandler;
  
  public void showDetailRequest(final RequestHandler1<RCSettlementProxy> requestHandler) {
    this.showDetailRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler createSettlementRequestRequestHandler;
  
  public void createSettlementRequest(final RequestHandler requestHandler) {
    this.createSettlementRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCSettlementProxy> modifySettlementRequestRequestHandler;
  
  public void modifySettlementRequest(final RequestHandler1<RCSettlementProxy> requestHandler) {
    this.modifySettlementRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCSettlementProxy> cancelSettlementRequestRequestHandler;
  
  public void cancelSettlementRequest(final RequestHandler1<RCSettlementProxy> requestHandler) {
    this.cancelSettlementRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCSettlementProxy> addRepairTaskItemsRequestRequestHandler;
  
  public void addRepairTaskItemsRequest(final RequestHandler1<RCSettlementProxy> requestHandler) {
    this.addRepairTaskItemsRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<Collection<RCRepairTaskProxy>> cancelSettlementItemRequestRequestHandler;
  
  public void cancelSettlementItemRequest(final RequestHandler1<Collection<RCRepairTaskProxy>> requestHandler) {
    this.cancelSettlementItemRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCRepairTaskProxy> showRepairTaskDetailRequestHandler;
  
  public void showRepairTaskDetail(final RequestHandler1<RCRepairTaskProxy> requestHandler) {
    this.showRepairTaskDetailRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCSettlementProxy> printSettlementRequestRequestHandler;
  
  public void printSettlementRequest(final RequestHandler1<RCSettlementProxy> requestHandler) {
    this.printSettlementRequestRequestHandler = requestHandler;
  }
}
