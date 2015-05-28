package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCInStockRecordProxy;
import com.fudanmed.platform.core.web.client.warehouse.InStockRecordCriteriaForm;
import com.fudanmed.platform.core.web.client.warehouse.InStockRecordDetail;
import com.fudanmed.platform.core.web.client.warehouse.InStockRecordItemReadonlyListGrid;
import com.fudanmed.platform.core.web.client.warehouse.InStockRecordListGrid;
import com.fudanmed.platform.core.web.client.warehouse.InStockRecordListPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecordCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecordItem;
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

public class InStockRecordListView extends GWTAbstractView implements InStockRecordListPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(listGrid,criteriaForm,detailsListGrid,inStockRecordDetail),
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
  private InStockRecordListGrid listGrid;
  
  @Inject
  private InStockRecordCriteriaForm criteriaForm;
  
  @Inject
  private InStockRecordItemReadonlyListGrid detailsListGrid;
  
  @Inject
  private InStockRecordDetail inStockRecordDetail;
  
  private IPager pager;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    this.listGrid.asWidget();
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u5165\u5E93\u7BA1\u7406");
    final Procedure1<FramedPanel> _function = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          VerticalLayoutContainer _VLayout = InStockRecordListView.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                HTableLayoutContainer _HTableLayout = InStockRecordListView.this.widgets.HTableLayout();
                final Procedure1<HTableLayoutContainer> _function = new Procedure1<HTableLayoutContainer>() {
                    public void apply(final HTableLayoutContainer it) {
                      FieldLabel _asWidget = InStockRecordListView.this.criteriaForm.sid.asWidget();
                      FieldLabel _asWidget_1 = InStockRecordListView.this.criteriaForm.dateFrom.asWidget();
                      FieldLabel _asWidget_2 = InStockRecordListView.this.criteriaForm.dateTo.asWidget();
                      TextButton _TextButton = InStockRecordListView.this.widgets.TextButton("\u67E5\u8BE2");
                      final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                          public void apply(final TextButton it) {
                            it.setWidth("80px");
                            final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                public void apply(final SelectEvent it) {
                                  UIInStockRecordCriteria _value = InStockRecordListView.this.criteriaForm.getValue();
                                  UIInStockRecordCriteria _withPagerInfo = Extensions.<UIInStockRecordCriteria>withPagerInfo(_value, InStockRecordListView.this.pager);
                                  final Procedure1<UIInStockRecordCriteria> _function = new Procedure1<UIInStockRecordCriteria>() {
                                      public void apply(final UIInStockRecordCriteria it) {
                                        it.setPage(Integer.valueOf(1));
                                      }
                                    };
                                  UIInStockRecordCriteria _doubleArrow = ObjectExtensions.<UIInStockRecordCriteria>operator_doubleArrow(_withPagerInfo, _function);
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
                IPager<UIInStockRecord> _createPager = edu.fudan.langlab.gxt.client.pager.Extensions.<UIInStockRecord>createPager(InStockRecordListView.this.listGrid);
                final Procedure1<IPager<UIInStockRecord>> _function_1 = new Procedure1<IPager<UIInStockRecord>>() {
                    public void apply(final IPager<UIInStockRecord> it) {
                      final Procedure2<Integer,Integer> _function = new Procedure2<Integer,Integer>() {
                          public void apply(final Integer pageNum, final Integer recordsPerPage) {
                            UIInStockRecordCriteria _value = InStockRecordListView.this.criteriaForm.getValue();
                            UIInStockRecordCriteria _withPagerInfo = Extensions.<UIInStockRecordCriteria>withPagerInfo(_value, InStockRecordListView.this.pager);
                            final Procedure1<UIInStockRecordCriteria> _function = new Procedure1<UIInStockRecordCriteria>() {
                                public void apply(final UIInStockRecordCriteria it) {
                                  it.setPage(Integer.valueOf(pageNum));
                                  it.setPageSize(Integer.valueOf(recordsPerPage));
                                }
                              };
                            UIInStockRecordCriteria _doubleArrow = ObjectExtensions.<UIInStockRecordCriteria>operator_doubleArrow(_withPagerInfo, _function);
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
                IPager<UIInStockRecord> _doubleArrow_1 = ObjectExtensions.<IPager<UIInStockRecord>>operator_doubleArrow(_createPager, _function_1);
                InStockRecordListView.this.pager = _doubleArrow_1;
                ContentPanel _ContentPanel = InStockRecordListView.this.widgets.ContentPanel();
                final Procedure1<ContentPanel> _function_2 = new Procedure1<ContentPanel>() {
                    public void apply(final ContentPanel it) {
                      VerticalLayoutContainer _VLayout = InStockRecordListView.this.widgets.VLayout();
                      final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                          public void apply(final VerticalLayoutContainer it) {
                            SGroupingGrid<UIInStockRecord> _asWidget = InStockRecordListView.this.listGrid.asWidget();
                            VerticalLayoutData _VLayoutData = InStockRecordListView.this.widgets.VLayoutData(1, 1);
                            it.add(_asWidget, _VLayoutData);
                            Widget _asWidget_1 = InStockRecordListView.this.pager.asWidget();
                            int _minus = (-1);
                            VerticalLayoutData _VLayoutData_1 = InStockRecordListView.this.widgets.VLayoutData(1, _minus);
                            it.add(_asWidget_1, _VLayoutData_1);
                          }
                        };
                      VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                      it.setWidget(_doubleArrow);
                      final ActionContext<UIInStockRecord> ac = ActionExtensions.<UIInStockRecord>createActionContext(InStockRecordListView.this.listGrid);
                      final Procedure1<Void> _function_1 = new Procedure1<Void>() {
                          public void apply(final Void v) {
                            TextButton _TextButton = InStockRecordListView.this.widgets.TextButton("\u7269\u54C1\u5165\u5E93");
                            final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                                public void apply(final TextButton it) {
                                  final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                      public void apply(final SelectEvent it) {inStockRequestRequestHandler.execute();
                                        
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
                      InStockRecordListView.this.securities.check(new Function0<IFunctionIdentifier>() {
                        public IFunctionIdentifier apply() {
                          return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.warehouse.InStockRecordListPresenter.inStockRequest" );
                        }
                      }.apply(), _function_1);
                      final Procedure1<Void> _function_2 = new Procedure1<Void>() {
                          public void apply(final Void v) {
                            ActionContext<UIInStockRecord> _createActionContext = ActionExtensions.<UIInStockRecord>createActionContext(ac);
                            final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                public void apply(final SingleObjectActions it) {
                                  final Procedure1<UIInStockRecord> _function = new Procedure1<UIInStockRecord>() {
                                      public void apply(final UIInStockRecord inStockRecord) {
                                        RCInStockRecordProxy _proxy = inStockRecord.toProxy();
                                        modifyInStockRequestRequestHandler.execute(_proxy);
                                        
                                      }
                                    };
                                  it.onExecute(_function);
                                  final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                                      public Boolean apply(final Void it) {
                                        final Function1<UIInStockRecord,Boolean> _function = new Function1<UIInStockRecord,Boolean>() {
                                            public Boolean apply(final UIInStockRecord it) {
                                              Boolean _committed = it.getCommitted();
                                              boolean _isLogicTrue = BooleanExtensions.isLogicTrue(_committed);
                                              boolean _not = (!_isLogicTrue);
                                              return Boolean.valueOf(_not);
                                            }
                                          };
                                        Boolean _isOnlySelectedAnd = ObjectSelectionProviders.<UIInStockRecord>isOnlySelectedAnd(InStockRecordListView.this.listGrid, _function);
                                        return _isOnlySelectedAnd;
                                      }
                                    };
                                  it.onCheckEnable(_function_1);
                                }
                              };
                            SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIInStockRecord>onSingleObjectAction(_createActionContext, _function);
                            TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u4FEE\u6539\u5165\u5E93\u5355");
                            it.addButton(_asButtonRequester);
                          }
                        };
                      InStockRecordListView.this.securities.check(new Function0<IFunctionIdentifier>() {
                        public IFunctionIdentifier apply() {
                          return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.warehouse.InStockRecordListPresenter.modifyInStockRequest" );
                        }
                      }.apply(), _function_2);
                      ActionContext<UIInStockRecord> _createActionContext = ActionExtensions.<UIInStockRecord>createActionContext(ac);
                      final Procedure1<SingleObjectActions> _function_3 = new Procedure1<SingleObjectActions>() {
                          public void apply(final SingleObjectActions it) {
                            final Procedure1<UIInStockRecord> _function = new Procedure1<UIInStockRecord>() {
                                public void apply(final UIInStockRecord inStockRecord) {
                                  RCInStockRecordProxy _proxy = inStockRecord.toProxy();
                                  printRequestHandler.execute(_proxy);
                                  
                                }
                              };
                            it.onExecute(_function);
                          }
                        };
                      SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIInStockRecord>onSingleObjectAction(_createActionContext, _function_3);
                      TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u6253\u5370\u5165\u5E93\u5355");
                      it.addButton(_asButtonRequester);
                    }
                  };
                ContentPanel _doubleArrow_2 = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function_2);
                VerticalLayoutData _VLayoutData = InStockRecordListView.this.widgets.VLayoutData(1, 0.55);
                it.add(_doubleArrow_2, _VLayoutData);
                TabPanel _TabPanel = InStockRecordListView.this.widgets.TabPanel();
                final Procedure1<TabPanel> _function_3 = new Procedure1<TabPanel>() {
                    public void apply(final TabPanel it) {
                      SGroupingGrid<UIInStockRecordItem> _asWidget = InStockRecordListView.this.detailsListGrid.asWidget();
                      it.add(_asWidget, "\u5165\u5E93\u660E\u7EC6");
                      VerticalLayoutContainer _asWidget_1 = InStockRecordListView.this.inStockRecordDetail.asWidget();
                      it.add(_asWidget_1, "\u5165\u5E93\u8BE6\u60C5");
                    }
                  };
                TabPanel _doubleArrow_3 = ObjectExtensions.<TabPanel>operator_doubleArrow(_TabPanel, _function_3);
                VerticalLayoutData _VLayoutData_1 = InStockRecordListView.this.widgets.VLayoutData(1, 0.45);
                it.add(_doubleArrow_3, _VLayoutData_1);
                final Procedure1<UIInStockRecord> _function_4 = new Procedure1<UIInStockRecord>() {
                    public void apply(final UIInStockRecord it) {
                      RCInStockRecordProxy _proxy = it.toProxy();
                      showDetailRequestRequestHandler.execute(_proxy);
                      
                    }
                  };
                InStockRecordListView.this.listGrid.addSelectEntityListener(new SelectEntityListener<UIInStockRecord>() {
                    public void objectSelected(UIInStockRecord selected) {
                      _function_4.apply(selected);
                    }
                });
                final Procedure1<Iterable<UIInStockRecord>> _function_5 = new Procedure1<Iterable<UIInStockRecord>>() {
                    public void apply(final Iterable<UIInStockRecord> it) {
                      boolean _isNullOrEmpty = IterableExtensions.isNullOrEmpty(it);
                      if (_isNullOrEmpty) {
                        ArrayList<UIInStockRecordItem> _newArrayList = CollectionLiterals.<UIInStockRecordItem>newArrayList();
                        InStockRecordListView.this.detailsListGrid.setObjects(_newArrayList);
                      }
                    }
                  };
                InStockRecordListView.this.listGrid.addSelectionChangedListener(new SelectionChangedListener<UIInStockRecord>() {
                    public void selectionChanged(Iterable<UIInStockRecord> selections) {
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
  
  public void showResults(final IPagedResult<UIInStockRecord> results) {
    this.pager.pageLoaded(results);
  }
  
  public void showDetails(final UIInStockRecord detail, final Collection<UIInStockRecordItem> details) {
    this.inStockRecordDetail.setValue(detail);
    this.detailsListGrid.setObjects(details);
  }
  
  public void refresh() {
    int _activePage = this.pager.getActivePage();
    this.pager.gotoPage(_activePage);
  }
  
  private RequestHandler inStockRequestRequestHandler;
  
  public void inStockRequest(final RequestHandler requestHandler) {
    this.inStockRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCInStockRecordProxy> modifyInStockRequestRequestHandler;
  
  public void modifyInStockRequest(final RequestHandler1<RCInStockRecordProxy> requestHandler) {
    this.modifyInStockRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<UIInStockRecordCriteria> filterRequestRequestHandler;
  
  public void filterRequest(final RequestHandler1<UIInStockRecordCriteria> requestHandler) {
    this.filterRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCInStockRecordProxy> showDetailRequestRequestHandler;
  
  public void showDetailRequest(final RequestHandler1<RCInStockRecordProxy> requestHandler) {
    this.showDetailRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCInStockRecordProxy> printRequestHandler;
  
  public void print(final RequestHandler1<RCInStockRecordProxy> requestHandler) {
    this.printRequestHandler = requestHandler;
  }
}
