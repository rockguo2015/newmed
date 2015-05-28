package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingRecordProxy;
import com.fudanmed.platform.core.web.client.warehouse.StockTakingRecordCriteriaForm;
import com.fudanmed.platform.core.web.client.warehouse.StockTakingRecordItemReadonlyListGrid;
import com.fudanmed.platform.core.web.client.warehouse.StockTakingRecordListGrid;
import com.fudanmed.platform.core.web.client.warehouse.StockTakingRecordListPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecordCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecordItem;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
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
import com.uniquesoft.gwt.client.common.extensions.ObjectSelectionProviders;
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

public class StockTakingRecordListView extends GWTAbstractView implements StockTakingRecordListPresenterView {
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
  private StockTakingRecordListGrid listGrid;
  
  @Inject
  private StockTakingRecordCriteriaForm criteriaForm;
  
  @Inject
  private StockTakingRecordItemReadonlyListGrid detailsListGrid;
  
  private IPager pager;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    this.listGrid.asWidget();
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u76D8\u70B9\u7BA1\u7406");
    final Procedure1<FramedPanel> _function = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          VerticalLayoutContainer _VLayout = StockTakingRecordListView.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                HTableLayoutContainer _HTableLayout = StockTakingRecordListView.this.widgets.HTableLayout();
                final Procedure1<HTableLayoutContainer> _function = new Procedure1<HTableLayoutContainer>() {
                    public void apply(final HTableLayoutContainer it) {
                      FieldLabel _asWidget = StockTakingRecordListView.this.criteriaForm.sid.asWidget();
                      FieldLabel _asWidget_1 = StockTakingRecordListView.this.criteriaForm.dateFrom.asWidget();
                      FieldLabel _asWidget_2 = StockTakingRecordListView.this.criteriaForm.dateTo.asWidget();
                      TextButton _TextButton = StockTakingRecordListView.this.widgets.TextButton("\u67E5\u8BE2");
                      final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                          public void apply(final TextButton it) {
                            it.setWidth("80px");
                            final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                public void apply(final SelectEvent it) {
                                  UIStockTakingRecordCriteria _value = StockTakingRecordListView.this.criteriaForm.getValue();
                                  UIStockTakingRecordCriteria _withPagerInfo = Extensions.<UIStockTakingRecordCriteria>withPagerInfo(_value, StockTakingRecordListView.this.pager);
                                  final Procedure1<UIStockTakingRecordCriteria> _function = new Procedure1<UIStockTakingRecordCriteria>() {
                                      public void apply(final UIStockTakingRecordCriteria it) {
                                        it.setPage(Integer.valueOf(1));
                                      }
                                    };
                                  UIStockTakingRecordCriteria _doubleArrow = ObjectExtensions.<UIStockTakingRecordCriteria>operator_doubleArrow(_withPagerInfo, _function);
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
                IPager<UIStockTakingRecord> _createPager = edu.fudan.langlab.gxt.client.pager.Extensions.<UIStockTakingRecord>createPager(StockTakingRecordListView.this.listGrid);
                final Procedure1<IPager<UIStockTakingRecord>> _function_1 = new Procedure1<IPager<UIStockTakingRecord>>() {
                    public void apply(final IPager<UIStockTakingRecord> it) {
                      final Procedure2<Integer,Integer> _function = new Procedure2<Integer,Integer>() {
                          public void apply(final Integer pageNum, final Integer recordsPerPage) {
                            UIStockTakingRecordCriteria _value = StockTakingRecordListView.this.criteriaForm.getValue();
                            UIStockTakingRecordCriteria _withPagerInfo = Extensions.<UIStockTakingRecordCriteria>withPagerInfo(_value, StockTakingRecordListView.this.pager);
                            final Procedure1<UIStockTakingRecordCriteria> _function = new Procedure1<UIStockTakingRecordCriteria>() {
                                public void apply(final UIStockTakingRecordCriteria it) {
                                  it.setPage(Integer.valueOf(pageNum));
                                  it.setPageSize(Integer.valueOf(recordsPerPage));
                                }
                              };
                            UIStockTakingRecordCriteria _doubleArrow = ObjectExtensions.<UIStockTakingRecordCriteria>operator_doubleArrow(_withPagerInfo, _function);
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
                IPager<UIStockTakingRecord> _doubleArrow_1 = ObjectExtensions.<IPager<UIStockTakingRecord>>operator_doubleArrow(_createPager, _function_1);
                StockTakingRecordListView.this.pager = _doubleArrow_1;
                SGroupingGrid<UIStockTakingRecord> _asWidget = StockTakingRecordListView.this.listGrid.asWidget();
                VerticalLayoutData _VLayoutData = StockTakingRecordListView.this.widgets.VLayoutData(1, 0.55);
                it.add(_asWidget, _VLayoutData);
                Widget _asWidget_1 = StockTakingRecordListView.this.pager.asWidget();
                it.add(_asWidget_1);
                TabPanel _TabPanel = StockTakingRecordListView.this.widgets.TabPanel();
                final Procedure1<TabPanel> _function_2 = new Procedure1<TabPanel>() {
                    public void apply(final TabPanel it) {
                      SGroupingGrid<UIStockTakingRecordItem> _asWidget = StockTakingRecordListView.this.detailsListGrid.asWidget();
                      it.add(_asWidget, "\u76D8\u70B9\u660E\u7EC6");
                    }
                  };
                TabPanel _doubleArrow_2 = ObjectExtensions.<TabPanel>operator_doubleArrow(_TabPanel, _function_2);
                VerticalLayoutData _VLayoutData_1 = StockTakingRecordListView.this.widgets.VLayoutData(1, 0.45);
                it.add(_doubleArrow_2, _VLayoutData_1);
                final Procedure1<UIStockTakingRecord> _function_3 = new Procedure1<UIStockTakingRecord>() {
                    public void apply(final UIStockTakingRecord it) {
                      RCStockTakingRecordProxy _proxy = it.toProxy();
                      showDetailRequestRequestHandler.execute(_proxy);
                      
                    }
                  };
                StockTakingRecordListView.this.listGrid.addSelectEntityListener(new SelectEntityListener<UIStockTakingRecord>() {
                    public void objectSelected(UIStockTakingRecord selected) {
                      _function_3.apply(selected);
                    }
                });
                final Procedure1<Iterable<UIStockTakingRecord>> _function_4 = new Procedure1<Iterable<UIStockTakingRecord>>() {
                    public void apply(final Iterable<UIStockTakingRecord> it) {
                      boolean _isNullOrEmpty = IterableExtensions.isNullOrEmpty(it);
                      if (_isNullOrEmpty) {
                        ArrayList<UIStockTakingRecordItem> _newArrayList = CollectionLiterals.<UIStockTakingRecordItem>newArrayList();
                        StockTakingRecordListView.this.detailsListGrid.setObjects(_newArrayList);
                      }
                    }
                  };
                StockTakingRecordListView.this.listGrid.addSelectionChangedListener(new SelectionChangedListener<UIStockTakingRecord>() {
                    public void selectionChanged(Iterable<UIStockTakingRecord> selections) {
                      _function_4.apply(selections);
                    }
                });
              }
            };
          VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
          it.setWidget(_doubleArrow);
          final ActionContext<UIStockTakingRecord> ac = ActionExtensions.<UIStockTakingRecord>createActionContext(StockTakingRecordListView.this.listGrid);
          final Procedure1<Void> _function_1 = new Procedure1<Void>() {
              public void apply(final Void v) {
                TextButton _TextButton = StockTakingRecordListView.this.widgets.TextButton("\u7269\u54C1\u76D8\u70B9");
                final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                    public void apply(final TextButton it) {
                      final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                          public void apply(final SelectEvent it) {StockTakingRequestRequestHandler.execute();
                            
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
          StockTakingRecordListView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.warehouse.StockTakingRecordListPresenter.StockTakingRequest" );
            }
          }.apply(), _function_1);
          final Procedure1<Void> _function_2 = new Procedure1<Void>() {
              public void apply(final Void v) {
                ActionContext<UIStockTakingRecord> _createActionContext = ActionExtensions.<UIStockTakingRecord>createActionContext(ac);
                final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                    public void apply(final SingleObjectActions it) {
                      final Procedure1<UIStockTakingRecord> _function = new Procedure1<UIStockTakingRecord>() {
                          public void apply(final UIStockTakingRecord StockTakingRecord) {
                            RCStockTakingRecordProxy _proxy = StockTakingRecord.toProxy();
                            modifyStockTakingRequestRequestHandler.execute(_proxy);
                            
                          }
                        };
                      it.onExecute(_function);
                      final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                          public Boolean apply(final Void it) {
                            final Function1<UIStockTakingRecord,Boolean> _function = new Function1<UIStockTakingRecord,Boolean>() {
                                public Boolean apply(final UIStockTakingRecord it) {
                                  Boolean _committed = it.getCommitted();
                                  boolean _isLogicTrue = BooleanExtensions.isLogicTrue(_committed);
                                  boolean _not = (!_isLogicTrue);
                                  return Boolean.valueOf(_not);
                                }
                              };
                            Boolean _isOnlySelectedAnd = ObjectSelectionProviders.<UIStockTakingRecord>isOnlySelectedAnd(StockTakingRecordListView.this.listGrid, _function);
                            return _isOnlySelectedAnd;
                          }
                        };
                      it.onCheckEnable(_function_1);
                    }
                  };
                SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIStockTakingRecord>onSingleObjectAction(_createActionContext, _function);
                TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u4FEE\u6539\u76D8\u70B9\u5355");
                it.addButton(_asButtonRequester);
              }
            };
          StockTakingRecordListView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.warehouse.StockTakingRecordListPresenter.modifyStockTakingRequest" );
            }
          }.apply(), _function_2);
        }
      };
    FramedPanel _doubleArrow = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function);
    this.con = _doubleArrow;
  }
  
  public void showResults(final IPagedResult<UIStockTakingRecord> results) {
    this.pager.pageLoaded(results);
  }
  
  public void showDetails(final UIStockTakingRecord detail, final Collection<UIStockTakingRecordItem> details) {
    this.detailsListGrid.setObjects(details);
  }
  
  public void refresh() {
    int _activePage = this.pager.getActivePage();
    this.pager.gotoPage(_activePage);
  }
  
  private RequestHandler StockTakingRequestRequestHandler;
  
  public void StockTakingRequest(final RequestHandler requestHandler) {
    this.StockTakingRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCStockTakingRecordProxy> modifyStockTakingRequestRequestHandler;
  
  public void modifyStockTakingRequest(final RequestHandler1<RCStockTakingRecordProxy> requestHandler) {
    this.modifyStockTakingRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<UIStockTakingRecordCriteria> filterRequestRequestHandler;
  
  public void filterRequest(final RequestHandler1<UIStockTakingRecordCriteria> requestHandler) {
    this.filterRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCStockTakingRecordProxy> showDetailRequestRequestHandler;
  
  public void showDetailRequest(final RequestHandler1<RCStockTakingRecordProxy> requestHandler) {
    this.showDetailRequestRequestHandler = requestHandler;
  }
}
