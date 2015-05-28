package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductWarehouseStorageSummaryProxy;
import com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationDetailPresenter;
import com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationDetailPresenterView;
import com.fudanmed.platform.core.web.client.warehouse.ProductStoreTransactionListPresenter;
import com.fudanmed.platform.core.web.client.warehouse.ProductStoreTransactionListPresenterView;
import com.fudanmed.platform.core.web.client.warehouse.ProductWarehouseStorageListPresenter;
import com.fudanmed.platform.core.web.client.warehouse.ProductWarehouseStorageListPresenterView;
import com.fudanmed.platform.core.web.client.warehouse.ProductWarehouseStorageSummaryCriteriaForm;
import com.fudanmed.platform.core.web.client.warehouse.ProductWarehouseStorageSummaryListGrid;
import com.fudanmed.platform.core.web.client.warehouse.ProductWarehouseStorageSummaryManagementPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummaryCriteria;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.ObjectListView.SelectEntityListener;
import com.uniquesoft.gwt.client.common.widgets.pager.Extensions;
import com.uniquesoft.gwt.client.common.widgets.pager.IPager;
import com.uniquesoft.gwt.client.common.widgets.pager.IPager.GotoPageHandler;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.widget.ContentPanel;
import edu.fudan.langlab.gxt.client.widget.FramedPanel;
import edu.fudan.langlab.gxt.client.widget.HTMLTagsExt;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTD;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTR;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTable;
import edu.fudan.langlab.gxt.client.widget.TabPanel;
import edu.fudan.langlab.security.client.Securities;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

public class ProductWarehouseStorageSummaryManagementView extends GWTAbstractView implements ProductWarehouseStorageSummaryManagementPresenterView {
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
  
  private ProductStoreTransactionListPresenter productStoreTransactionListPresenter;
  
  public void setProductStoreTransactionListPresenter(final ProductStoreTransactionListPresenter productStoreTransactionListPresenter) {
    this.productStoreTransactionListPresenter = productStoreTransactionListPresenter;
  }
  
  private ProductWarehouseStorageListPresenter productWarehouseStorageListPresenter;
  
  public void setProductWarehouseStorageListPresenter(final ProductWarehouseStorageListPresenter productWarehouseStorageListPresenter) {
    this.productWarehouseStorageListPresenter = productWarehouseStorageListPresenter;
  }
  
  private ProductSpecificationDetailPresenter productSpecificationDetailPresenter;
  
  public void setProductSpecificationDetailPresenter(final ProductSpecificationDetailPresenter productSpecificationDetailPresenter) {
    this.productSpecificationDetailPresenter = productSpecificationDetailPresenter;
  }
  
  @Inject
  private ProductWarehouseStorageSummaryListGrid listGrid;
  
  @Inject
  private ProductWarehouseStorageSummaryCriteriaForm criteriaForm;
  
  private IPager pager;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    this.listGrid.asWidget();
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u5E93\u5B58\u53F0\u5E10");
    final Procedure1<FramedPanel> _function = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          VerticalLayoutContainer _VLayout = ProductWarehouseStorageSummaryManagementView.this.widgets.VLayout();
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
                                  FieldLabel _asWidget = ProductWarehouseStorageSummaryManagementView.this.criteriaForm.store.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                            PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = ProductWarehouseStorageSummaryManagementView.this.criteriaForm.productType.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                            PlainHTMLTD _td_2 = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function_2 = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = ProductWarehouseStorageSummaryManagementView.this.criteriaForm.productSpec.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_2, _function_2);
                            PlainHTMLTD _td_3 = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function_3 = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  TextButton _TextButton = ProductWarehouseStorageSummaryManagementView.this.widgets.TextButton("\u67E5\u8BE2");
                                  final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                                      public void apply(final TextButton it) {
                                        it.setWidth("80px");
                                        final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                            public void apply(final SelectEvent it) {
                                              UIProductWarehouseStorageSummaryCriteria _value = ProductWarehouseStorageSummaryManagementView.this.criteriaForm.getValue();
                                              UIProductWarehouseStorageSummaryCriteria _withPagerInfo = Extensions.<UIProductWarehouseStorageSummaryCriteria>withPagerInfo(_value, ProductWarehouseStorageSummaryManagementView.this.pager);
                                              final Procedure1<UIProductWarehouseStorageSummaryCriteria> _function = new Procedure1<UIProductWarehouseStorageSummaryCriteria>() {
                                                  public void apply(final UIProductWarehouseStorageSummaryCriteria it) {
                                                    it.setPage(Integer.valueOf(1));
                                                  }
                                                };
                                              UIProductWarehouseStorageSummaryCriteria _doubleArrow = ObjectExtensions.<UIProductWarehouseStorageSummaryCriteria>operator_doubleArrow(_withPagerInfo, _function);
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
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_3, _function_3);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr, _function);
                    }
                  };
                PlainHTMLTable _doubleArrow = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE, _function);
                it.add(_doubleArrow);
                IPager<UIProductWarehouseStorageSummary> _createPager = edu.fudan.langlab.gxt.client.pager.Extensions.<UIProductWarehouseStorageSummary>createPager(ProductWarehouseStorageSummaryManagementView.this.listGrid);
                final Procedure1<IPager<UIProductWarehouseStorageSummary>> _function_1 = new Procedure1<IPager<UIProductWarehouseStorageSummary>>() {
                    public void apply(final IPager<UIProductWarehouseStorageSummary> it) {
                      final Procedure2<Integer,Integer> _function = new Procedure2<Integer,Integer>() {
                          public void apply(final Integer pageNum, final Integer recordsPerPage) {
                            UIProductWarehouseStorageSummaryCriteria _value = ProductWarehouseStorageSummaryManagementView.this.criteriaForm.getValue();
                            UIProductWarehouseStorageSummaryCriteria _withPagerInfo = Extensions.<UIProductWarehouseStorageSummaryCriteria>withPagerInfo(_value, ProductWarehouseStorageSummaryManagementView.this.pager);
                            final Procedure1<UIProductWarehouseStorageSummaryCriteria> _function = new Procedure1<UIProductWarehouseStorageSummaryCriteria>() {
                                public void apply(final UIProductWarehouseStorageSummaryCriteria it) {
                                  it.setPage(Integer.valueOf(pageNum));
                                  it.setPageSize(Integer.valueOf(recordsPerPage));
                                }
                              };
                            UIProductWarehouseStorageSummaryCriteria _doubleArrow = ObjectExtensions.<UIProductWarehouseStorageSummaryCriteria>operator_doubleArrow(_withPagerInfo, _function);
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
                IPager<UIProductWarehouseStorageSummary> _doubleArrow_1 = ObjectExtensions.<IPager<UIProductWarehouseStorageSummary>>operator_doubleArrow(_createPager, _function_1);
                ProductWarehouseStorageSummaryManagementView.this.pager = _doubleArrow_1;
                ContentPanel _ContentPanel = ProductWarehouseStorageSummaryManagementView.this.widgets.ContentPanel();
                final Procedure1<ContentPanel> _function_2 = new Procedure1<ContentPanel>() {
                    public void apply(final ContentPanel it) {
                      VerticalLayoutContainer _VLayout = ProductWarehouseStorageSummaryManagementView.this.widgets.VLayout();
                      final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                          public void apply(final VerticalLayoutContainer it) {
                            SGroupingGrid<UIProductWarehouseStorageSummary> _asWidget = ProductWarehouseStorageSummaryManagementView.this.listGrid.asWidget();
                            VerticalLayoutData _VLayoutData = ProductWarehouseStorageSummaryManagementView.this.widgets.VLayoutData(1, 1);
                            it.add(_asWidget, _VLayoutData);
                            Widget _asWidget_1 = ProductWarehouseStorageSummaryManagementView.this.pager.asWidget();
                            int _minus = (-1);
                            VerticalLayoutData _VLayoutData_1 = ProductWarehouseStorageSummaryManagementView.this.widgets.VLayoutData(1, _minus);
                            it.add(_asWidget_1, _VLayoutData_1);
                          }
                        };
                      VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                      it.setWidget(_doubleArrow);
                    }
                  };
                ContentPanel _doubleArrow_2 = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function_2);
                VerticalLayoutData _VLayoutData = ProductWarehouseStorageSummaryManagementView.this.widgets.VLayoutData(1, 0.45);
                it.add(_doubleArrow_2, _VLayoutData);
                TabPanel _TabPanel = ProductWarehouseStorageSummaryManagementView.this.widgets.TabPanel();
                final Procedure1<TabPanel> _function_3 = new Procedure1<TabPanel>() {
                    public void apply(final TabPanel it) {
                      ProductStoreTransactionListPresenterView _view = ProductWarehouseStorageSummaryManagementView.this.productStoreTransactionListPresenter.getView();
                      Widget _asWidget = _view.asWidget();
                      it.add(_asWidget, "\u5E93\u5B58\u53D8\u52A8\u8BB0\u5F55");
                      ProductWarehouseStorageListPresenterView _view_1 = ProductWarehouseStorageSummaryManagementView.this.productWarehouseStorageListPresenter.getView();
                      Widget _asWidget_1 = _view_1.asWidget();
                      it.add(_asWidget_1, "\u6279\u6B21\u4FE1\u606F");
                      ProductSpecificationDetailPresenterView _view_2 = ProductWarehouseStorageSummaryManagementView.this.productSpecificationDetailPresenter.getView();
                      Widget _asWidget_2 = _view_2.asWidget();
                      it.add(_asWidget_2, "\u7269\u54C1\u4FE1\u606F");
                    }
                  };
                TabPanel _doubleArrow_3 = ObjectExtensions.<TabPanel>operator_doubleArrow(_TabPanel, _function_3);
                VerticalLayoutData _VLayoutData_1 = ProductWarehouseStorageSummaryManagementView.this.widgets.VLayoutData(1, 0.55);
                it.add(_doubleArrow_3, _VLayoutData_1);
                final Procedure1<UIProductWarehouseStorageSummary> _function_4 = new Procedure1<UIProductWarehouseStorageSummary>() {
                    public void apply(final UIProductWarehouseStorageSummary it) {
                      RCProductWarehouseStorageSummaryProxy _proxy = it.toProxy();
                      showStorageDetailRequestRequestHandler.execute(_proxy);
                      
                    }
                  };
                ProductWarehouseStorageSummaryManagementView.this.listGrid.addSelectEntityListener(new SelectEntityListener<UIProductWarehouseStorageSummary>() {
                    public void objectSelected(UIProductWarehouseStorageSummary selected) {
                      _function_4.apply(selected);
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
  
  public void showResults(final IPagedResult<UIProductWarehouseStorageSummary> results) {
    this.pager.pageLoaded(results);
  }
  
  public void refresh() {
    int _activePage = this.pager.getActivePage();
    this.pager.gotoPage(_activePage);
  }
  
  private RequestHandler1<UIProductWarehouseStorageSummaryCriteria> filterRequestRequestHandler;
  
  public void filterRequest(final RequestHandler1<UIProductWarehouseStorageSummaryCriteria> requestHandler) {
    this.filterRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler inStockRequestRequestHandler;
  
  public void inStockRequest(final RequestHandler requestHandler) {
    this.inStockRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler transferRequestRequestHandler;
  
  public void transferRequest(final RequestHandler requestHandler) {
    this.transferRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCProductWarehouseStorageSummaryProxy> showStorageDetailRequestRequestHandler;
  
  public void showStorageDetailRequest(final RequestHandler1<RCProductWarehouseStorageSummaryProxy> requestHandler) {
    this.showStorageDetailRequestRequestHandler = requestHandler;
  }
}
