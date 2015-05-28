package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingListProxy;
import com.fudanmed.platform.core.web.client.warehouse.StockTakingItemListGrid;
import com.fudanmed.platform.core.web.client.warehouse.StockTakingListCriteriaForm;
import com.fudanmed.platform.core.web.client.warehouse.StockTakingListListGrid;
import com.fudanmed.platform.core.web.client.warehouse.StockTakingListListPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingItem;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingList;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingListCriteria;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.ActionExtensions;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.ObjectListView.SelectEntityListener;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener;
import com.uniquesoft.gwt.client.common.widgets.pager.Extensions;
import com.uniquesoft.gwt.client.common.widgets.pager.IPager;
import com.uniquesoft.gwt.client.common.widgets.pager.IPager.GotoPageHandler;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.extensions.BooleanExtensions;
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
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

public class StockTakingListListView extends GWTAbstractView implements StockTakingListListPresenterView {
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
  
  @Inject
  private StockTakingListListGrid listGrid;
  
  @Inject
  private StockTakingListCriteriaForm criteriaForm;
  
  @Inject
  private StockTakingItemListGrid detailsListGrid;
  
  private IPager pager;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    this.listGrid.asWidget();
    this.listGrid.keepSelection();
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u76D8\u70B9\u7BA1\u7406");
    final Procedure1<FramedPanel> _function = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          VerticalLayoutContainer _VLayout = StockTakingListListView.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                HTableLayoutContainer _HTableLayout = StockTakingListListView.this.widgets.HTableLayout();
                final Procedure1<HTableLayoutContainer> _function = new Procedure1<HTableLayoutContainer>() {
                    public void apply(final HTableLayoutContainer it) {
                      FieldLabel _asWidget = StockTakingListListView.this.criteriaForm.warehouse.asWidget();
                      FieldLabel _asWidget_1 = StockTakingListListView.this.criteriaForm.dateFrom.asWidget();
                      FieldLabel _asWidget_2 = StockTakingListListView.this.criteriaForm.dateTo.asWidget();
                      TextButton _TextButton = StockTakingListListView.this.widgets.TextButton("\u7B5B\u9009");
                      final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                          public void apply(final TextButton it) {
                            it.setWidth("80px");
                            final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                public void apply(final SelectEvent it) {
                                  UIStockTakingListCriteria _value = StockTakingListListView.this.criteriaForm.getValue();
                                  UIStockTakingListCriteria _withPagerInfo = Extensions.<UIStockTakingListCriteria>withPagerInfo(_value, StockTakingListListView.this.pager);
                                  final Procedure1<UIStockTakingListCriteria> _function = new Procedure1<UIStockTakingListCriteria>() {
                                      public void apply(final UIStockTakingListCriteria it) {
                                        it.setPage(Integer.valueOf(1));
                                      }
                                    };
                                  UIStockTakingListCriteria _doubleArrow = ObjectExtensions.<UIStockTakingListCriteria>operator_doubleArrow(_withPagerInfo, _function);
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
                IPager<UIStockTakingList> _createPager = edu.fudan.langlab.gxt.client.pager.Extensions.<UIStockTakingList>createPager(StockTakingListListView.this.listGrid);
                final Procedure1<IPager<UIStockTakingList>> _function_1 = new Procedure1<IPager<UIStockTakingList>>() {
                    public void apply(final IPager<UIStockTakingList> it) {
                      final Procedure2<Integer,Integer> _function = new Procedure2<Integer,Integer>() {
                          public void apply(final Integer pageNum, final Integer recordsPerPage) {
                            UIStockTakingListCriteria _value = StockTakingListListView.this.criteriaForm.getValue();
                            UIStockTakingListCriteria _withPagerInfo = Extensions.<UIStockTakingListCriteria>withPagerInfo(_value, StockTakingListListView.this.pager);
                            final Procedure1<UIStockTakingListCriteria> _function = new Procedure1<UIStockTakingListCriteria>() {
                                public void apply(final UIStockTakingListCriteria it) {
                                  it.setPage(Integer.valueOf(pageNum));
                                  it.setPageSize(Integer.valueOf(recordsPerPage));
                                }
                              };
                            UIStockTakingListCriteria _doubleArrow = ObjectExtensions.<UIStockTakingListCriteria>operator_doubleArrow(_withPagerInfo, _function);
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
                IPager<UIStockTakingList> _doubleArrow_1 = ObjectExtensions.<IPager<UIStockTakingList>>operator_doubleArrow(_createPager, _function_1);
                StockTakingListListView.this.pager = _doubleArrow_1;
                ContentPanel _ContentPanel = StockTakingListListView.this.widgets.ContentPanel();
                final Procedure1<ContentPanel> _function_2 = new Procedure1<ContentPanel>() {
                    public void apply(final ContentPanel it) {
                      VerticalLayoutContainer _VLayout = StockTakingListListView.this.widgets.VLayout();
                      final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                          public void apply(final VerticalLayoutContainer it) {
                            SGroupingGrid<UIStockTakingList> _asWidget = StockTakingListListView.this.listGrid.asWidget();
                            VerticalLayoutData _VLayoutData = StockTakingListListView.this.widgets.VLayoutData(1, 1);
                            it.add(_asWidget, _VLayoutData);
                            Widget _asWidget_1 = StockTakingListListView.this.pager.asWidget();
                            int _minus = (-1);
                            VerticalLayoutData _VLayoutData_1 = StockTakingListListView.this.widgets.VLayoutData(1, _minus);
                            it.add(_asWidget_1, _VLayoutData_1);
                          }
                        };
                      VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                      it.setWidget(_doubleArrow);
                      final Procedure1<Void> _function_1 = new Procedure1<Void>() {
                          public void apply(final Void v) {
                            final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                public void apply(final SelectEvent it) {createStockTakingListRequestRequestHandler.execute();
                                  
                                }
                              };
                            TextButton _TextButton = StockTakingListListView.this.widgets.TextButton("\u65B0\u5EFA\u76D8\u70B9", _function);
                            it.addButton(_TextButton);
                          }
                        };
                      StockTakingListListView.this.securities.check(new Function0<IFunctionIdentifier>() {
                        public IFunctionIdentifier apply() {
                          return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.warehouse.StockTakingListListPresenter.createStockTakingListRequest" );
                        }
                      }.apply(), _function_1);
                      final ActionContext<UIStockTakingList> ac = ActionExtensions.<UIStockTakingList>createActionContext(StockTakingListListView.this.listGrid);
                      final Procedure1<Void> _function_2 = new Procedure1<Void>() {
                          public void apply(final Void v) {
                            final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                public void apply(final SingleObjectActions it) {
                                  final Procedure1<UIStockTakingList> _function = new Procedure1<UIStockTakingList>() {
                                      public void apply(final UIStockTakingList item) {
                                        RCStockTakingListProxy _proxy = item.toProxy();
                                        inputQuantityRequestHandler.execute(_proxy);
                                        
                                      }
                                    };
                                  it.onExecute(_function);
                                  final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                                      public Boolean apply(final Void it) {
                                        final Function1<UIStockTakingList,Boolean> _function = new Function1<UIStockTakingList,Boolean>() {
                                            public Boolean apply(final UIStockTakingList it) {
                                              Boolean _isCommited = it.getIsCommited();
                                              boolean _isLogicTrue = BooleanExtensions.isLogicTrue(_isCommited);
                                              boolean _not = (!_isLogicTrue);
                                              return Boolean.valueOf(_not);
                                            }
                                          };
                                        Boolean _singleSelectedAnd = ActionExtensions.<UIStockTakingList>singleSelectedAnd(StockTakingListListView.this.listGrid, _function);
                                        return _singleSelectedAnd;
                                      }
                                    };
                                  it.onCheckEnable(_function_1);
                                }
                              };
                            SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIStockTakingList>onSingleObjectAction(ac, _function);
                            TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u5B9E\u76D8\u5F55\u5165");
                            it.addButton(_asButtonRequester);
                          }
                        };
                      StockTakingListListView.this.securities.check(new Function0<IFunctionIdentifier>() {
                        public IFunctionIdentifier apply() {
                          return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.warehouse.StockTakingListListPresenter.inputQuantity" );
                        }
                      }.apply(), _function_2);
                      final Procedure1<Void> _function_3 = new Procedure1<Void>() {
                          public void apply(final Void v) {
                            final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                public void apply(final SingleObjectActions it) {
                                  final Procedure1<UIStockTakingList> _function = new Procedure1<UIStockTakingList>() {
                                      public void apply(final UIStockTakingList item) {
                                        final Procedure1<Void> _function = new Procedure1<Void>() {
                                            public void apply(final Void it) {
                                              RCStockTakingListProxy _proxy = item.toProxy();
                                              commitRequestHandler.execute(_proxy);
                                              
                                            }
                                          };
                                        ConfirmMessageBox _ConfirmMessageBox = StockTakingListListView.this.widgets.ConfirmMessageBox("\u786E\u8BA4", "\u786E\u8BA4\u63D0\u4EA4", _function);
                                        _ConfirmMessageBox.show();
                                      }
                                    };
                                  it.onExecute(_function);
                                  final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                                      public Boolean apply(final Void it) {
                                        final Function1<UIStockTakingList,Boolean> _function = new Function1<UIStockTakingList,Boolean>() {
                                            public Boolean apply(final UIStockTakingList it) {
                                              Boolean _isCommited = it.getIsCommited();
                                              boolean _isLogicTrue = BooleanExtensions.isLogicTrue(_isCommited);
                                              boolean _not = (!_isLogicTrue);
                                              return Boolean.valueOf(_not);
                                            }
                                          };
                                        Boolean _singleSelectedAnd = ActionExtensions.<UIStockTakingList>singleSelectedAnd(StockTakingListListView.this.listGrid, _function);
                                        return _singleSelectedAnd;
                                      }
                                    };
                                  it.onCheckEnable(_function_1);
                                }
                              };
                            SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIStockTakingList>onSingleObjectAction(ac, _function);
                            TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u63D0\u4EA4");
                            it.addButton(_asButtonRequester);
                          }
                        };
                      StockTakingListListView.this.securities.check(new Function0<IFunctionIdentifier>() {
                        public IFunctionIdentifier apply() {
                          return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.warehouse.StockTakingListListPresenter.commit" );
                        }
                      }.apply(), _function_3);
                      final Procedure1<Void> _function_4 = new Procedure1<Void>() {
                          public void apply(final Void v) {
                            final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                public void apply(final SingleObjectActions it) {
                                  final Procedure1<UIStockTakingList> _function = new Procedure1<UIStockTakingList>() {
                                      public void apply(final UIStockTakingList item) {
                                        RCStockTakingListProxy _proxy = item.toProxy();
                                        exportRequestHandler.execute(_proxy);
                                        
                                      }
                                    };
                                  it.onExecute(_function);
                                }
                              };
                            SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIStockTakingList>onSingleObjectAction(ac, _function);
                            TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u5BFC\u51FA");
                            it.addButton(_asButtonRequester);
                          }
                        };
                      StockTakingListListView.this.securities.check(new Function0<IFunctionIdentifier>() {
                        public IFunctionIdentifier apply() {
                          return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.warehouse.StockTakingListListPresenter.export" );
                        }
                      }.apply(), _function_4);
                      final Procedure1<Void> _function_5 = new Procedure1<Void>() {
                          public void apply(final Void v) {
                            final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                public void apply(final SingleObjectActions it) {
                                  final Procedure1<UIStockTakingList> _function = new Procedure1<UIStockTakingList>() {
                                      public void apply(final UIStockTakingList item) {
                                        RCStockTakingListProxy _proxy = item.toProxy();
                                        printListlRequestRequestHandler.execute(_proxy);
                                        
                                      }
                                    };
                                  it.onExecute(_function);
                                }
                              };
                            SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIStockTakingList>onSingleObjectAction(ac, _function);
                            TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u76D8\u70B9\u5355\u6253\u5370");
                            it.addButton(_asButtonRequester);
                          }
                        };
                      StockTakingListListView.this.securities.check(new Function0<IFunctionIdentifier>() {
                        public IFunctionIdentifier apply() {
                          return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.warehouse.StockTakingListListPresenter.printListlRequest" );
                        }
                      }.apply(), _function_5);
                      final Procedure1<Void> _function_6 = new Procedure1<Void>() {
                          public void apply(final Void v) {
                            final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                public void apply(final SingleObjectActions it) {
                                  final Procedure1<UIStockTakingList> _function = new Procedure1<UIStockTakingList>() {
                                      public void apply(final UIStockTakingList item) {
                                        final Procedure1<Void> _function = new Procedure1<Void>() {
                                            public void apply(final Void it) {
                                              RCStockTakingListProxy _proxy = item.toProxy();
                                              cancelStockTakingListRequestRequestHandler.execute(_proxy);
                                              
                                            }
                                          };
                                        ConfirmMessageBox _ConfirmMessageBox = StockTakingListListView.this.widgets.ConfirmMessageBox("\u786E\u8BA4", "\u786E\u8BA4\u53D6\u6D88", _function);
                                        _ConfirmMessageBox.show();
                                      }
                                    };
                                  it.onExecute(_function);
                                  final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                                      public Boolean apply(final Void it) {
                                        final Function1<UIStockTakingList,Boolean> _function = new Function1<UIStockTakingList,Boolean>() {
                                            public Boolean apply(final UIStockTakingList it) {
                                              Boolean _isCommited = it.getIsCommited();
                                              boolean _isLogicTrue = BooleanExtensions.isLogicTrue(_isCommited);
                                              boolean _not = (!_isLogicTrue);
                                              return Boolean.valueOf(_not);
                                            }
                                          };
                                        Boolean _singleSelectedAnd = ActionExtensions.<UIStockTakingList>singleSelectedAnd(StockTakingListListView.this.listGrid, _function);
                                        return _singleSelectedAnd;
                                      }
                                    };
                                  it.onCheckEnable(_function_1);
                                }
                              };
                            SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIStockTakingList>onSingleObjectAction(ac, _function);
                            TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u53D6\u6D88");
                            it.addButton(_asButtonRequester);
                          }
                        };
                      StockTakingListListView.this.securities.check(new Function0<IFunctionIdentifier>() {
                        public IFunctionIdentifier apply() {
                          return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.warehouse.StockTakingListListPresenter.cancelStockTakingListRequest" );
                        }
                      }.apply(), _function_6);
                    }
                  };
                ContentPanel _doubleArrow_2 = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function_2);
                VerticalLayoutData _VLayoutData = StockTakingListListView.this.widgets.VLayoutData(1, 0.45);
                it.add(_doubleArrow_2, _VLayoutData);
                TabPanel _TabPanel = StockTakingListListView.this.widgets.TabPanel();
                final Procedure1<TabPanel> _function_3 = new Procedure1<TabPanel>() {
                    public void apply(final TabPanel it) {
                      SGroupingGrid<UIStockTakingItem> _asWidget = StockTakingListListView.this.detailsListGrid.asWidget();
                      it.add(_asWidget, "\u76D8\u70B9\u5355\u660E\u7EC6");
                    }
                  };
                TabPanel _doubleArrow_3 = ObjectExtensions.<TabPanel>operator_doubleArrow(_TabPanel, _function_3);
                VerticalLayoutData _VLayoutData_1 = StockTakingListListView.this.widgets.VLayoutData(1, 0.55);
                it.add(_doubleArrow_3, _VLayoutData_1);
                final Procedure1<UIStockTakingList> _function_4 = new Procedure1<UIStockTakingList>() {
                    public void apply(final UIStockTakingList it) {
                      RCStockTakingListProxy _proxy = it.toProxy();
                      showDetailRequestRequestHandler.execute(_proxy);
                      
                    }
                  };
                StockTakingListListView.this.listGrid.addSelectEntityListener(new SelectEntityListener<UIStockTakingList>() {
                    public void objectSelected(UIStockTakingList selected) {
                      _function_4.apply(selected);
                    }
                });
                final Procedure1<Iterable<UIStockTakingList>> _function_5 = new Procedure1<Iterable<UIStockTakingList>>() {
                    public void apply(final Iterable<UIStockTakingList> it) {
                      boolean _isNullOrEmpty = IterableExtensions.isNullOrEmpty(it);
                      if (_isNullOrEmpty) {
                        ArrayList<UIStockTakingItem> _newArrayList = CollectionLiterals.<UIStockTakingItem>newArrayList();
                        StockTakingListListView.this.detailsListGrid.setObjects(_newArrayList);
                      }
                    }
                  };
                StockTakingListListView.this.listGrid.addSelectionChangedListener(new SelectionChangedListener<UIStockTakingList>() {
                    public void selectionChanged(Iterable<UIStockTakingList> selections) {
                      _function_5.apply(selections);
                    }
                });
              }
            };
          VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
          it.setWidget(_doubleArrow);
        }
      };
    FramedPanel _doubleArrow = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function);
    this.con = _doubleArrow;
  }
  
  public void setSourceWarehouseContext(final RCEmployeeProxy employee, final Procedure1<? super Void> notifier) {
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          notifier.apply(null);
        }
      };
    this.criteriaForm.setSourceWarehouseContext(employee, _function);
  }
  
  public void showResults(final IPagedResult<UIStockTakingList> results) {
    this.pager.pageLoaded(results);
  }
  
  public void showDetails(final Collection<UIStockTakingItem> details) {
    this.detailsListGrid.setObjects(details);
  }
  
  public void refresh() {
    int _activePage = this.pager.getActivePage();
    this.pager.gotoPage(_activePage);
  }
  
  private RequestHandler1<UIStockTakingListCriteria> filterRequestRequestHandler;
  
  public void filterRequest(final RequestHandler1<UIStockTakingListCriteria> requestHandler) {
    this.filterRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler createStockTakingListRequestRequestHandler;
  
  public void createStockTakingListRequest(final RequestHandler requestHandler) {
    this.createStockTakingListRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCStockTakingListProxy> cancelStockTakingListRequestRequestHandler;
  
  public void cancelStockTakingListRequest(final RequestHandler1<RCStockTakingListProxy> requestHandler) {
    this.cancelStockTakingListRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCStockTakingListProxy> inputQuantityRequestHandler;
  
  public void inputQuantity(final RequestHandler1<RCStockTakingListProxy> requestHandler) {
    this.inputQuantityRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCStockTakingListProxy> commitRequestHandler;
  
  public void commit(final RequestHandler1<RCStockTakingListProxy> requestHandler) {
    this.commitRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCStockTakingListProxy> exportRequestHandler;
  
  public void export(final RequestHandler1<RCStockTakingListProxy> requestHandler) {
    this.exportRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCStockTakingListProxy> showDetailRequestRequestHandler;
  
  public void showDetailRequest(final RequestHandler1<RCStockTakingListProxy> requestHandler) {
    this.showDetailRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCStockTakingListProxy> printListlRequestRequestHandler;
  
  public void printListlRequest(final RequestHandler1<RCStockTakingListProxy> requestHandler) {
    this.printListlRequestRequestHandler = requestHandler;
  }
}
