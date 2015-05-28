package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCTransferRecordProxy;
import com.fudanmed.platform.core.web.client.warehouse.TransferRecordCriteriaForm;
import com.fudanmed.platform.core.web.client.warehouse.TransferRecordItemListGrid;
import com.fudanmed.platform.core.web.client.warehouse.TransferRecordListGrid;
import com.fudanmed.platform.core.web.client.warehouse.TransferRecordListPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UITransferRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UITransferRecordCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UITransferRecordItem;
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
import com.uniquesoft.gwt.client.common.widgets.ObjectListView.SelectEntityListener;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener;
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
import edu.fudan.langlab.security.client.Securities;
import edu.fudan.langlab.security.shared.IFunctionIdentifier;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

public class TransferRecordListView extends GWTAbstractView implements TransferRecordListPresenterView {
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
  private TransferRecordListGrid listGrid;
  
  @Inject
  private TransferRecordCriteriaForm criteriaForm;
  
  @Inject
  private TransferRecordItemListGrid detailsListGrid;
  
  private IPager pager;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    this.listGrid.asWidget();
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u8C03\u62E8\u7BA1\u7406");
    final Procedure1<FramedPanel> _function = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          VerticalLayoutContainer _VLayout = TransferRecordListView.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                HTableLayoutContainer _HTableLayout = TransferRecordListView.this.widgets.HTableLayout();
                final Procedure1<HTableLayoutContainer> _function = new Procedure1<HTableLayoutContainer>() {
                    public void apply(final HTableLayoutContainer it) {
                      FieldLabel _asWidget = TransferRecordListView.this.criteriaForm.targetStore.asWidget();
                      FieldLabel _asWidget_1 = TransferRecordListView.this.criteriaForm.dateFrom.asWidget();
                      FieldLabel _asWidget_2 = TransferRecordListView.this.criteriaForm.dateTo.asWidget();
                      TextButton _TextButton = TransferRecordListView.this.widgets.TextButton("\u67E5\u8BE2");
                      final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                          public void apply(final TextButton it) {
                            it.setWidth("80px");
                            final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                public void apply(final SelectEvent it) {
                                  UITransferRecordCriteria _value = TransferRecordListView.this.criteriaForm.getValue();
                                  UITransferRecordCriteria _withPagerInfo = Extensions.<UITransferRecordCriteria>withPagerInfo(_value, TransferRecordListView.this.pager);
                                  final Procedure1<UITransferRecordCriteria> _function = new Procedure1<UITransferRecordCriteria>() {
                                      public void apply(final UITransferRecordCriteria it) {
                                        it.setPage(Integer.valueOf(1));
                                      }
                                    };
                                  UITransferRecordCriteria _doubleArrow = ObjectExtensions.<UITransferRecordCriteria>operator_doubleArrow(_withPagerInfo, _function);
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
                IPager<UITransferRecord> _createPager = edu.fudan.langlab.gxt.client.pager.Extensions.<UITransferRecord>createPager(TransferRecordListView.this.listGrid);
                final Procedure1<IPager<UITransferRecord>> _function_1 = new Procedure1<IPager<UITransferRecord>>() {
                    public void apply(final IPager<UITransferRecord> it) {
                      final Procedure2<Integer,Integer> _function = new Procedure2<Integer,Integer>() {
                          public void apply(final Integer pageNum, final Integer recordsPerPage) {
                            UITransferRecordCriteria _value = TransferRecordListView.this.criteriaForm.getValue();
                            UITransferRecordCriteria _withPagerInfo = Extensions.<UITransferRecordCriteria>withPagerInfo(_value, TransferRecordListView.this.pager);
                            final Procedure1<UITransferRecordCriteria> _function = new Procedure1<UITransferRecordCriteria>() {
                                public void apply(final UITransferRecordCriteria it) {
                                  it.setPage(Integer.valueOf(pageNum));
                                  it.setPageSize(Integer.valueOf(recordsPerPage));
                                }
                              };
                            UITransferRecordCriteria _doubleArrow = ObjectExtensions.<UITransferRecordCriteria>operator_doubleArrow(_withPagerInfo, _function);
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
                IPager<UITransferRecord> _doubleArrow_1 = ObjectExtensions.<IPager<UITransferRecord>>operator_doubleArrow(_createPager, _function_1);
                TransferRecordListView.this.pager = _doubleArrow_1;
                ContentPanel _ContentPanel = TransferRecordListView.this.widgets.ContentPanel();
                final Procedure1<ContentPanel> _function_2 = new Procedure1<ContentPanel>() {
                    public void apply(final ContentPanel it) {
                      VerticalLayoutContainer _VLayout = TransferRecordListView.this.widgets.VLayout();
                      final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                          public void apply(final VerticalLayoutContainer it) {
                            SGroupingGrid<UITransferRecord> _asWidget = TransferRecordListView.this.listGrid.asWidget();
                            VerticalLayoutData _VLayoutData = TransferRecordListView.this.widgets.VLayoutData(1, 1);
                            it.add(_asWidget, _VLayoutData);
                            Widget _asWidget_1 = TransferRecordListView.this.pager.asWidget();
                            int _minus = (-1);
                            VerticalLayoutData _VLayoutData_1 = TransferRecordListView.this.widgets.VLayoutData(1, _minus);
                            it.add(_asWidget_1, _VLayoutData_1);
                          }
                        };
                      VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                      it.setWidget(_doubleArrow);
                      final Procedure1<Void> _function_1 = new Procedure1<Void>() {
                          public void apply(final Void v) {
                            TextButton _TextButton = TransferRecordListView.this.widgets.TextButton("\u8C03\u62E8");
                            final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                                public void apply(final TextButton it) {
                                  final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                      public void apply(final SelectEvent it) {transferRequestRequestHandler.execute();
                                        
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
                      TransferRecordListView.this.securities.check(new Function0<IFunctionIdentifier>() {
                        public IFunctionIdentifier apply() {
                          return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.warehouse.TransferRecordListPresenter.transferRequest" );
                        }
                      }.apply(), _function_1);
                      ActionContext<UITransferRecord> _createActionContext = ActionExtensions.<UITransferRecord>createActionContext(TransferRecordListView.this.listGrid);
                      final Procedure1<SingleObjectActions> _function_2 = new Procedure1<SingleObjectActions>() {
                          public void apply(final SingleObjectActions it) {
                            final Procedure1<UITransferRecord> _function = new Procedure1<UITransferRecord>() {
                                public void apply(final UITransferRecord record) {
                                  RCTransferRecordProxy _proxy = record.toProxy();
                                  printRequestHandler.execute(_proxy);
                                  
                                }
                              };
                            it.onExecute(_function);
                          }
                        };
                      SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UITransferRecord>onSingleObjectAction(_createActionContext, _function_2);
                      TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u6253\u5370\u8C03\u62E8\u5355");
                      it.addButton(_asButtonRequester);
                    }
                  };
                ContentPanel _doubleArrow_2 = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function_2);
                VerticalLayoutData _VLayoutData = TransferRecordListView.this.widgets.VLayoutData(1, 0.45);
                it.add(_doubleArrow_2, _VLayoutData);
                ContentPanel _ContentPanel_1 = TransferRecordListView.this.widgets.ContentPanel("\u8C03\u62E8\u660E\u7EC6");
                final Procedure1<ContentPanel> _function_3 = new Procedure1<ContentPanel>() {
                    public void apply(final ContentPanel it) {
                      SGroupingGrid<UITransferRecordItem> _asWidget = TransferRecordListView.this.detailsListGrid.asWidget();
                      it.setWidget(_asWidget);
                    }
                  };
                ContentPanel _doubleArrow_3 = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel_1, _function_3);
                VerticalLayoutData _VLayoutData_1 = TransferRecordListView.this.widgets.VLayoutData(1, 0.55);
                it.add(_doubleArrow_3, _VLayoutData_1);
                final Procedure1<UITransferRecord> _function_4 = new Procedure1<UITransferRecord>() {
                    public void apply(final UITransferRecord it) {
                      RCTransferRecordProxy _proxy = it.toProxy();
                      showDetailRequestRequestHandler.execute(_proxy);
                      
                    }
                  };
                TransferRecordListView.this.listGrid.addSelectEntityListener(new SelectEntityListener<UITransferRecord>() {
                    public void objectSelected(UITransferRecord selected) {
                      _function_4.apply(selected);
                    }
                });
                final Procedure1<Iterable<UITransferRecord>> _function_5 = new Procedure1<Iterable<UITransferRecord>>() {
                    public void apply(final Iterable<UITransferRecord> it) {
                      boolean _isNullOrEmpty = IterableExtensions.isNullOrEmpty(it);
                      if (_isNullOrEmpty) {
                        ArrayList<UITransferRecordItem> _newArrayList = CollectionLiterals.<UITransferRecordItem>newArrayList();
                        TransferRecordListView.this.detailsListGrid.setObjects(_newArrayList);
                      }
                    }
                  };
                TransferRecordListView.this.listGrid.addSelectionChangedListener(new SelectionChangedListener<UITransferRecord>() {
                    public void selectionChanged(Iterable<UITransferRecord> selections) {
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
  
  public void showResults(final IPagedResult<UITransferRecord> results) {
    this.pager.pageLoaded(results);
  }
  
  public void showDetails(final Collection<UITransferRecordItem> details) {
    this.detailsListGrid.setObjects(details);
  }
  
  public void refresh() {
    int _activePage = this.pager.getActivePage();
    this.pager.gotoPage(_activePage);
  }
  
  private RequestHandler transferRequestRequestHandler;
  
  public void transferRequest(final RequestHandler requestHandler) {
    this.transferRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<UITransferRecordCriteria> filterRequestRequestHandler;
  
  public void filterRequest(final RequestHandler1<UITransferRecordCriteria> requestHandler) {
    this.filterRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCTransferRecordProxy> showDetailRequestRequestHandler;
  
  public void showDetailRequest(final RequestHandler1<RCTransferRecordProxy> requestHandler) {
    this.showDetailRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCTransferRecordProxy> printRequestHandler;
  
  public void print(final RequestHandler1<RCTransferRecordProxy> requestHandler) {
    this.printRequestHandler = requestHandler;
  }
}
