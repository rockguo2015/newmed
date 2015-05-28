package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationCriteriaForm;
import com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationListGrid;
import com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationManagementPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecificationCriteria;
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
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

public class ProductSpecificationManagementView extends GWTAbstractView implements ProductSpecificationManagementPresenterView {
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
  
  @Inject
  private ProductSpecificationListGrid listGrid;
  
  @Inject
  private ProductSpecificationCriteriaForm criteriaForm;
  
  private IPager pager;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    this.listGrid.asWidget();
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u7269\u54C1\u4FE1\u606F\u7EF4\u62A4");
    final Procedure1<FramedPanel> _function = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          VerticalLayoutContainer _VLayout = ProductSpecificationManagementView.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                HTableLayoutContainer _HTableLayout = ProductSpecificationManagementView.this.widgets.HTableLayout();
                final Procedure1<HTableLayoutContainer> _function = new Procedure1<HTableLayoutContainer>() {
                    public void apply(final HTableLayoutContainer it) {
                      FieldLabel _asWidget = ProductSpecificationManagementView.this.criteriaForm.info.asWidget();
                      final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                          public void apply(final FieldLabel it) {
                            it.setToolTip("\u53EF\u7528\u62FC\u97F3\u7801 \u6761\u7801");
                          }
                        };
                      FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function);
                      FieldLabel _asWidget_1 = ProductSpecificationManagementView.this.criteriaForm.category.asWidget();
                      TextButton _TextButton = ProductSpecificationManagementView.this.widgets.TextButton("\u67E5\u8BE2");
                      final Procedure1<TextButton> _function_1 = new Procedure1<TextButton>() {
                          public void apply(final TextButton it) {
                            it.setWidth("80px");
                            final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                public void apply(final SelectEvent it) {
                                  UIProductSpecificationCriteria _value = ProductSpecificationManagementView.this.criteriaForm.getValue();
                                  UIProductSpecificationCriteria _withPagerInfo = Extensions.<UIProductSpecificationCriteria>withPagerInfo(_value, ProductSpecificationManagementView.this.pager);
                                  final Procedure1<UIProductSpecificationCriteria> _function = new Procedure1<UIProductSpecificationCriteria>() {
                                      public void apply(final UIProductSpecificationCriteria it) {
                                        it.setPage(Integer.valueOf(1));
                                      }
                                    };
                                  UIProductSpecificationCriteria _doubleArrow = ObjectExtensions.<UIProductSpecificationCriteria>operator_doubleArrow(_withPagerInfo, _function);
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
                      TextButton _doubleArrow_1 = ObjectExtensions.<TextButton>operator_doubleArrow(_TextButton, _function_1);
                      ArrayList<Widget> _newArrayList = CollectionLiterals.<Widget>newArrayList(_doubleArrow, _asWidget_1, _doubleArrow_1);
                      it.add(_newArrayList);
                    }
                  };
                HTableLayoutContainer _doubleArrow = ObjectExtensions.<HTableLayoutContainer>operator_doubleArrow(_HTableLayout, _function);
                it.add(_doubleArrow);
                IPager<UIProductSpecification> _createPager = edu.fudan.langlab.gxt.client.pager.Extensions.<UIProductSpecification>createPager(ProductSpecificationManagementView.this.listGrid);
                final Procedure1<IPager<UIProductSpecification>> _function_1 = new Procedure1<IPager<UIProductSpecification>>() {
                    public void apply(final IPager<UIProductSpecification> it) {
                      final Procedure2<Integer,Integer> _function = new Procedure2<Integer,Integer>() {
                          public void apply(final Integer pageNum, final Integer recordsPerPage) {
                            UIProductSpecificationCriteria _value = ProductSpecificationManagementView.this.criteriaForm.getValue();
                            UIProductSpecificationCriteria _withPagerInfo = Extensions.<UIProductSpecificationCriteria>withPagerInfo(_value, ProductSpecificationManagementView.this.pager);
                            final Procedure1<UIProductSpecificationCriteria> _function = new Procedure1<UIProductSpecificationCriteria>() {
                                public void apply(final UIProductSpecificationCriteria it) {
                                  it.setPage(Integer.valueOf(pageNum));
                                  it.setPageSize(Integer.valueOf(recordsPerPage));
                                }
                              };
                            UIProductSpecificationCriteria _doubleArrow = ObjectExtensions.<UIProductSpecificationCriteria>operator_doubleArrow(_withPagerInfo, _function);
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
                IPager<UIProductSpecification> _doubleArrow_1 = ObjectExtensions.<IPager<UIProductSpecification>>operator_doubleArrow(_createPager, _function_1);
                ProductSpecificationManagementView.this.pager = _doubleArrow_1;
                ContentPanel _ContentPanel = ProductSpecificationManagementView.this.widgets.ContentPanel();
                final Procedure1<ContentPanel> _function_2 = new Procedure1<ContentPanel>() {
                    public void apply(final ContentPanel it) {
                      VerticalLayoutContainer _VLayout = ProductSpecificationManagementView.this.widgets.VLayout();
                      final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                          public void apply(final VerticalLayoutContainer it) {
                            SGroupingGrid<UIProductSpecification> _asWidget = ProductSpecificationManagementView.this.listGrid.asWidget();
                            VerticalLayoutData _VLayoutData = ProductSpecificationManagementView.this.widgets.VLayoutData(1, 1);
                            it.add(_asWidget, _VLayoutData);
                            Widget _asWidget_1 = ProductSpecificationManagementView.this.pager.asWidget();
                            int _minus = (-1);
                            VerticalLayoutData _VLayoutData_1 = ProductSpecificationManagementView.this.widgets.VLayoutData(1, _minus);
                            it.add(_asWidget_1, _VLayoutData_1);
                          }
                        };
                      VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                      it.setWidget(_doubleArrow);
                    }
                  };
                ContentPanel _doubleArrow_2 = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function_2);
                VerticalLayoutData _VLayoutData = ProductSpecificationManagementView.this.widgets.VLayoutData(1, 1);
                it.add(_doubleArrow_2, _VLayoutData);
              }
            };
          VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
          it.setWidget(_doubleArrow);
          final ActionContext<UIProductSpecification> ac = ActionExtensions.<UIProductSpecification>createActionContext(ProductSpecificationManagementView.this.listGrid);
          final Procedure1<Void> _function_1 = new Procedure1<Void>() {
              public void apply(final Void v) {
                TextButton _textButton = new TextButton("\u65B0\u5EFA");
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
                TextButton _doubleArrow = ObjectExtensions.<TextButton>operator_doubleArrow(_textButton, _function);
                it.addButton(_doubleArrow);
              }
            };
          ProductSpecificationManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationManagementPresenter.createRequest" );
            }
          }.apply(), _function_1);
          final Procedure1<Void> _function_2 = new Procedure1<Void>() {
              public void apply(final Void v) {
                TextButton _textButton = new TextButton("\u5BFC\u5165");
                final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                    public void apply(final TextButton it) {
                      final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                          public void apply(final SelectEvent it) {importRequestRequestHandler.execute();
                            
                          }
                        };
                      it.addSelectHandler(new SelectHandler() {
                          public void onSelect(SelectEvent event) {
                            _function.apply(event);
                          }
                      });
                    }
                  };
                TextButton _doubleArrow = ObjectExtensions.<TextButton>operator_doubleArrow(_textButton, _function);
                it.addButton(_doubleArrow);
              }
            };
          ProductSpecificationManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationManagementPresenter.importRequest" );
            }
          }.apply(), _function_2);
          final Procedure1<Void> _function_3 = new Procedure1<Void>() {
              public void apply(final Void v) {
                final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                    public void apply(final SingleObjectActions it) {
                      final Procedure1<UIProductSpecification> _function = new Procedure1<UIProductSpecification>() {
                          public void apply(final UIProductSpecification selectedValue) {
                            RCProductSpecificationProxy _proxy = selectedValue.toProxy();
                            modifyRequestRequestHandler.execute(_proxy);
                            
                          }
                        };
                      it.onExecute(_function);
                    }
                  };
                SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIProductSpecification>onSingleObjectAction(ac, _function);
                TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u4FEE\u6539");
                it.addButton(_asButtonRequester);
              }
            };
          ProductSpecificationManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationManagementPresenter.modifyRequest" );
            }
          }.apply(), _function_3);
          final Procedure1<Void> _function_4 = new Procedure1<Void>() {
              public void apply(final Void v) {
                final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                    public void apply(final SingleObjectActions it) {
                      final Procedure1<UIProductSpecification> _function = new Procedure1<UIProductSpecification>() {
                          public void apply(final UIProductSpecification selectedValue) {
                            final Procedure1<Void> _function = new Procedure1<Void>() {
                                public void apply(final Void it) {
                                  RCProductSpecificationProxy _proxy = selectedValue.toProxy();
                                  deleteRequestRequestHandler.execute(_proxy);
                                  
                                }
                              };
                            ConfirmMessageBox _ConfirmMessageBox = ProductSpecificationManagementView.this.widgets.ConfirmMessageBox("\u786E\u8BA4", "\u786E\u8BA4\u5220\u9664", _function);
                            _ConfirmMessageBox.show();
                          }
                        };
                      it.onExecute(_function);
                    }
                  };
                SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIProductSpecification>onSingleObjectAction(ac, _function);
                TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u5220\u9664");
                it.addButton(_asButtonRequester);
              }
            };
          ProductSpecificationManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationManagementPresenter.deleteRequest" );
            }
          }.apply(), _function_4);
        }
      };
    FramedPanel _doubleArrow = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function);
    this.con = _doubleArrow;
  }
  
  public void showResults(final IPagedResult<UIProductSpecification> results) {
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
  
  private RequestHandler importRequestRequestHandler;
  
  public void importRequest(final RequestHandler requestHandler) {
    this.importRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCProductSpecificationProxy> deleteRequestRequestHandler;
  
  public void deleteRequest(final RequestHandler1<RCProductSpecificationProxy> requestHandler) {
    this.deleteRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCProductSpecificationProxy> modifyRequestRequestHandler;
  
  public void modifyRequest(final RequestHandler1<RCProductSpecificationProxy> requestHandler) {
    this.modifyRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<UIProductSpecificationCriteria> filterRequestRequestHandler;
  
  public void filterRequest(final RequestHandler1<UIProductSpecificationCriteria> requestHandler) {
    this.filterRequestRequestHandler = requestHandler;
  }
}
