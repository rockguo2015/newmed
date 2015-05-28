package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemStockRecordProxy;
import com.fudanmed.platform.core.web.client.project.WorkItemTaskListGrid;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemOutStockRecordListPresenter;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemOutStockRecordListPresenterView;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemStorageListPresenter;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemStorageListPresenterView;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemTaskCriteriaForm;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemTaskManagementPresenterView;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTask;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemTaskCriteria;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.button.TextButton;
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
import edu.fudan.langlab.gxt.client.widget.HTableLayoutContainer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.TabPanel;
import edu.fudan.langlab.security.client.Securities;
import edu.fudan.langlab.security.shared.IFunctionIdentifier;
import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

public class WorkItemTaskManagementView extends GWTAbstractView implements WorkItemTaskManagementPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(listGrid,criteriaForm),
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
  
  private WorkItemOutStockRecordListPresenter workItemOutStockRecordListPresenter;
  
  public void setWorkItemOutStockRecordListPresenter(final WorkItemOutStockRecordListPresenter workItemOutStockRecordListPresenter) {
    this.workItemOutStockRecordListPresenter = workItemOutStockRecordListPresenter;
  }
  
  private WorkItemStorageListPresenter workItemStorageListPresenter;
  
  public void setWorkItemStorageListPresenter(final WorkItemStorageListPresenter workItemStorageListPresenter) {
    this.workItemStorageListPresenter = workItemStorageListPresenter;
  }
  
  @Inject
  private WorkItemTaskListGrid listGrid;
  
  @Inject
  private WorkItemTaskCriteriaForm criteriaForm;
  
  private IPager pager;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    this.listGrid.asWidget();
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u5DE5\u5355\u9886/\u9000\u6599");
    final Procedure1<FramedPanel> _function = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          VerticalLayoutContainer _VLayout = WorkItemTaskManagementView.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                HTableLayoutContainer _HTableLayout = WorkItemTaskManagementView.this.widgets.HTableLayout();
                final Procedure1<HTableLayoutContainer> _function = new Procedure1<HTableLayoutContainer>() {
                    public void apply(final HTableLayoutContainer it) {
                      FieldLabel _asWidget = WorkItemTaskManagementView.this.criteriaForm.sid.asWidget();
                      FieldLabel _asWidget_1 = WorkItemTaskManagementView.this.criteriaForm.team.asWidget();
                      FieldLabel _asWidget_2 = WorkItemTaskManagementView.this.criteriaForm.showAll.asWidget();
                      TextButton _TextButton = WorkItemTaskManagementView.this.widgets.TextButton("\u67E5\u8BE2");
                      final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                          public void apply(final TextButton it) {
                            it.setWidth("80px");
                            final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                public void apply(final SelectEvent it) {
                                  UIWorkItemTaskCriteria _value = WorkItemTaskManagementView.this.criteriaForm.getValue();
                                  UIWorkItemTaskCriteria _withPagerInfo = Extensions.<UIWorkItemTaskCriteria>withPagerInfo(_value, WorkItemTaskManagementView.this.pager);
                                  final Procedure1<UIWorkItemTaskCriteria> _function = new Procedure1<UIWorkItemTaskCriteria>() {
                                      public void apply(final UIWorkItemTaskCriteria it) {
                                        it.setPage(Integer.valueOf(1));
                                      }
                                    };
                                  UIWorkItemTaskCriteria _doubleArrow = ObjectExtensions.<UIWorkItemTaskCriteria>operator_doubleArrow(_withPagerInfo, _function);
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
                IPager<UIWorkItemTask> _createPager = edu.fudan.langlab.gxt.client.pager.Extensions.<UIWorkItemTask>createPager(WorkItemTaskManagementView.this.listGrid);
                final Procedure1<IPager<UIWorkItemTask>> _function_1 = new Procedure1<IPager<UIWorkItemTask>>() {
                    public void apply(final IPager<UIWorkItemTask> it) {
                      final Procedure2<Integer,Integer> _function = new Procedure2<Integer,Integer>() {
                          public void apply(final Integer pageNum, final Integer recordsPerPage) {
                            UIWorkItemTaskCriteria _value = WorkItemTaskManagementView.this.criteriaForm.getValue();
                            UIWorkItemTaskCriteria _withPagerInfo = Extensions.<UIWorkItemTaskCriteria>withPagerInfo(_value, WorkItemTaskManagementView.this.pager);
                            final Procedure1<UIWorkItemTaskCriteria> _function = new Procedure1<UIWorkItemTaskCriteria>() {
                                public void apply(final UIWorkItemTaskCriteria it) {
                                  it.setPage(Integer.valueOf(pageNum));
                                  it.setPageSize(Integer.valueOf(recordsPerPage));
                                }
                              };
                            UIWorkItemTaskCriteria _doubleArrow = ObjectExtensions.<UIWorkItemTaskCriteria>operator_doubleArrow(_withPagerInfo, _function);
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
                IPager<UIWorkItemTask> _doubleArrow_1 = ObjectExtensions.<IPager<UIWorkItemTask>>operator_doubleArrow(_createPager, _function_1);
                WorkItemTaskManagementView.this.pager = _doubleArrow_1;
                ContentPanel _ContentPanel = WorkItemTaskManagementView.this.widgets.ContentPanel();
                final Procedure1<ContentPanel> _function_2 = new Procedure1<ContentPanel>() {
                    public void apply(final ContentPanel it) {
                      VerticalLayoutContainer _VLayout = WorkItemTaskManagementView.this.widgets.VLayout();
                      final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                          public void apply(final VerticalLayoutContainer it) {
                            SGroupingGrid<UIWorkItemTask> _asWidget = WorkItemTaskManagementView.this.listGrid.asWidget();
                            VerticalLayoutData _VLayoutData = WorkItemTaskManagementView.this.widgets.VLayoutData(1, 1);
                            it.add(_asWidget, _VLayoutData);
                            final Procedure1<UIWorkItemTask> _function = new Procedure1<UIWorkItemTask>() {
                                public void apply(final UIWorkItemTask it) {
                                  RCWorkItemTaskProxy _proxy = it.toProxy();
                                  showWorkItemDetailRequestRequestHandler.execute(_proxy);
                                  
                                }
                              };
                            WorkItemTaskManagementView.this.listGrid.addSelectEntityListener(new SelectEntityListener<UIWorkItemTask>() {
                                public void objectSelected(UIWorkItemTask selected) {
                                  _function.apply(selected);
                                }
                            });
                            Widget _asWidget_1 = WorkItemTaskManagementView.this.pager.asWidget();
                            int _minus = (-1);
                            VerticalLayoutData _VLayoutData_1 = WorkItemTaskManagementView.this.widgets.VLayoutData(1, _minus);
                            it.add(_asWidget_1, _VLayoutData_1);
                          }
                        };
                      VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                      it.setWidget(_doubleArrow);
                      final ActionContext<UIWorkItemTask> ac = ActionExtensions.<UIWorkItemTask>createActionContext(WorkItemTaskManagementView.this.listGrid);
                      final Procedure1<Void> _function_1 = new Procedure1<Void>() {
                          public void apply(final Void v) {
                            final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                public void apply(final SingleObjectActions it) {
                                  final Procedure1<UIWorkItemTask> _function = new Procedure1<UIWorkItemTask>() {
                                      public void apply(final UIWorkItemTask workItemTask) {
                                        RCWorkItemTaskProxy _proxy = workItemTask.toProxy();
                                        createWorkItemOutStoreRequestRequestHandler.execute(_proxy);
                                        
                                      }
                                    };
                                  it.onExecute(_function);
                                }
                              };
                            SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIWorkItemTask>onSingleObjectAction(ac, _function);
                            TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u5DE5\u5355\u9886\u6599");
                            it.addButton(_asButtonRequester);
                          }
                        };
                      WorkItemTaskManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                        public IFunctionIdentifier apply() {
                          return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.warehouse.WorkItemTaskManagementPresenter.createWorkItemOutStoreRequest" );
                        }
                      }.apply(), _function_1);
                      final Procedure1<Void> _function_2 = new Procedure1<Void>() {
                          public void apply(final Void v) {
                            final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                public void apply(final SingleObjectActions it) {
                                  final Procedure1<UIWorkItemTask> _function = new Procedure1<UIWorkItemTask>() {
                                      public void apply(final UIWorkItemTask workItemTask) {
                                        RCWorkItemTaskProxy _proxy = workItemTask.toProxy();
                                        createWorkItemReturnStoreRequestRequestHandler.execute(_proxy);
                                        
                                      }
                                    };
                                  it.onExecute(_function);
                                }
                              };
                            SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIWorkItemTask>onSingleObjectAction(ac, _function);
                            TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u5DE5\u5355\u9000\u6599");
                            it.addButton(_asButtonRequester);
                          }
                        };
                      WorkItemTaskManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                        public IFunctionIdentifier apply() {
                          return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.warehouse.WorkItemTaskManagementPresenter.createWorkItemReturnStoreRequest" );
                        }
                      }.apply(), _function_2);
                    }
                  };
                ContentPanel _doubleArrow_2 = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function_2);
                VerticalLayoutData _VLayoutData = WorkItemTaskManagementView.this.widgets.VLayoutData(1, 0.55);
                it.add(_doubleArrow_2, _VLayoutData);
                TabPanel _TabPanel = WorkItemTaskManagementView.this.widgets.TabPanel();
                final Procedure1<TabPanel> _function_3 = new Procedure1<TabPanel>() {
                    public void apply(final TabPanel it) {
                      ContentPanel _ContentPanel = WorkItemTaskManagementView.this.widgets.ContentPanel();
                      final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
                          public void apply(final ContentPanel it) {
                            WorkItemOutStockRecordListPresenterView _view = WorkItemTaskManagementView.this.workItemOutStockRecordListPresenter.getView();
                            Widget _asWidget = _view.asWidget();
                            it.setWidget(_asWidget);
                            WorkItemOutStockRecordListPresenterView _view_1 = WorkItemTaskManagementView.this.workItemOutStockRecordListPresenter.getView();
                            final ActionContext<UIWorkItemStockRecord> recordListAc = _view_1.getActionContext();
                            final Procedure1<Void> _function = new Procedure1<Void>() {
                                public void apply(final Void v) {
                                  final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                      public void apply(final SingleObjectActions it) {
                                        final Procedure1<UIWorkItemStockRecord> _function = new Procedure1<UIWorkItemStockRecord>() {
                                            public void apply(final UIWorkItemStockRecord context) {
                                              RCWorkItemStockRecordProxy _proxy = context.toProxy();
                                              showWorkItemOutStockRecordDetailRequestHandler.execute(_proxy);
                                              
                                            }
                                          };
                                        it.onExecute(_function);
                                      }
                                    };
                                  SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIWorkItemStockRecord>onSingleObjectAction(recordListAc, _function);
                                  TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u9886/\u9000\u6599\u4FE1\u606F");
                                  it.addButton(_asButtonRequester);
                                }
                              };
                            WorkItemTaskManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                              public IFunctionIdentifier apply() {
                                return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.warehouse.WorkItemTaskManagementPresenter.showWorkItemOutStockRecordDetail" );
                              }
                            }.apply(), _function);
                            final Procedure1<SingleObjectActions> _function_1 = new Procedure1<SingleObjectActions>() {
                                public void apply(final SingleObjectActions it) {
                                  final Procedure1<UIWorkItemStockRecord> _function = new Procedure1<UIWorkItemStockRecord>() {
                                      public void apply(final UIWorkItemStockRecord context) {
                                        RCWorkItemStockRecordProxy _proxy = context.toProxy();
                                        printRequestHandler.execute(_proxy);
                                        
                                      }
                                    };
                                  it.onExecute(_function);
                                }
                              };
                            SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIWorkItemStockRecord>onSingleObjectAction(recordListAc, _function_1);
                            TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u9886\u9000\u6599\u5355\u6253\u5370");
                            it.addButton(_asButtonRequester);
                            final Procedure1<SingleObjectActions> _function_2 = new Procedure1<SingleObjectActions>() {
                                public void apply(final SingleObjectActions it) {
                                  final Procedure1<UIWorkItemStockRecord> _function = new Procedure1<UIWorkItemStockRecord>() {
                                      public void apply(final UIWorkItemStockRecord context) {
                                        RCWorkItemStockRecordProxy _proxy = context.toProxy();
                                        printFitRequestHandler.execute(_proxy);
                                        
                                      }
                                    };
                                  it.onExecute(_function);
                                  final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                                      public Boolean apply(final Void it) {
                                        final Function1<UIWorkItemStockRecord,Boolean> _function = new Function1<UIWorkItemStockRecord,Boolean>() {
                                            public Boolean apply(final UIWorkItemStockRecord it) {
                                              String _typeName = it.getTypeName();
                                              boolean _equals = Objects.equal(_typeName, "\u9886\u6599");
                                              return Boolean.valueOf(_equals);
                                            }
                                          };
                                        Boolean _singleSelectedAnd = ActionExtensions.<UIWorkItemStockRecord>singleSelectedAnd(recordListAc, _function);
                                        return _singleSelectedAnd;
                                      }
                                    };
                                  it.onCheckEnable(_function_1);
                                }
                              };
                            SingleObjectActions _onSingleObjectAction_1 = SingleObjectActions.<UIWorkItemStockRecord>onSingleObjectAction(recordListAc, _function_2);
                            TextButton _asButtonRequester_1 = _onSingleObjectAction_1.asButtonRequester("\u9886\u6599\u5355\u5957\u6253");
                            it.addButton(_asButtonRequester_1);
                          }
                        };
                      ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
                      it.add(_doubleArrow, "\u9886\u6599/\u9000\u6599");
                      WorkItemStorageListPresenterView _view = WorkItemTaskManagementView.this.workItemStorageListPresenter.getView();
                      Widget _asWidget = _view.asWidget();
                      it.add(_asWidget, "\u7528\u6599\u4FE1\u606F");
                    }
                  };
                TabPanel _doubleArrow_3 = ObjectExtensions.<TabPanel>operator_doubleArrow(_TabPanel, _function_3);
                VerticalLayoutData _VLayoutData_1 = WorkItemTaskManagementView.this.widgets.VLayoutData(1, 0.45);
                it.add(_doubleArrow_3, _VLayoutData_1);
              }
            };
          VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
          it.setWidget(_doubleArrow);
        }
      };
    FramedPanel _doubleArrow = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function);
    this.con = _doubleArrow;
  }
  
  public void showResults(final IPagedResult<UIWorkItemTask> results) {
    this.pager.pageLoaded(results);
  }
  
  public void refresh() {
    int _activePage = this.pager.getActivePage();
    this.pager.gotoPage(_activePage);
  }
  
  public void refreshChild() {
    Iterable<UIWorkItemTask> _selectedObjects = this.listGrid.getSelectedObjects();
    int _size = IterableExtensions.size(_selectedObjects);
    boolean _notEquals = (_size != 0);
    if (_notEquals) {
      Iterable<UIWorkItemTask> _selectedObjects_1 = this.listGrid.getSelectedObjects();
      UIWorkItemTask _head = IterableExtensions.<UIWorkItemTask>head(_selectedObjects_1);
      RCWorkItemTaskProxy _proxy = _head.toProxy();
      showWorkItemDetailRequestRequestHandler.execute(_proxy);
      
    }
  }
  
  private RequestHandler1<RCWorkItemStockRecordProxy> showWorkItemOutStockRecordDetailRequestHandler;
  
  public void showWorkItemOutStockRecordDetail(final RequestHandler1<RCWorkItemStockRecordProxy> requestHandler) {
    this.showWorkItemOutStockRecordDetailRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCWorkItemStockRecordProxy> printRequestHandler;
  
  public void print(final RequestHandler1<RCWorkItemStockRecordProxy> requestHandler) {
    this.printRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCWorkItemStockRecordProxy> printFitRequestHandler;
  
  public void printFit(final RequestHandler1<RCWorkItemStockRecordProxy> requestHandler) {
    this.printFitRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCWorkItemTaskProxy> createWorkItemOutStoreRequestRequestHandler;
  
  public void createWorkItemOutStoreRequest(final RequestHandler1<RCWorkItemTaskProxy> requestHandler) {
    this.createWorkItemOutStoreRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCWorkItemTaskProxy> createWorkItemReturnStoreRequestRequestHandler;
  
  public void createWorkItemReturnStoreRequest(final RequestHandler1<RCWorkItemTaskProxy> requestHandler) {
    this.createWorkItemReturnStoreRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<UIWorkItemTaskCriteria> filterRequestRequestHandler;
  
  public void filterRequest(final RequestHandler1<UIWorkItemTaskCriteria> requestHandler) {
    this.filterRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCWorkItemTaskProxy> showWorkItemDetailRequestRequestHandler;
  
  public void showWorkItemDetailRequest(final RequestHandler1<RCWorkItemTaskProxy> requestHandler) {
    this.showWorkItemDetailRequestRequestHandler = requestHandler;
  }
}
