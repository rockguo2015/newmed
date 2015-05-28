package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductTypeProxy;
import com.fudanmed.platform.core.web.client.tree.ProductCategoryTreeContentProvider;
import com.fudanmed.platform.core.web.client.warehouse.ProductCategoryListGrid;
import com.fudanmed.platform.core.web.client.warehouse.ProductCategoryManagementPresenterView;
import com.fudanmed.platform.core.web.client.warehouse.ProductTypeListGrid;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductCategory;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductType;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.data.shared.TreeStore;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldSet;
import com.sencha.gxt.widget.core.client.form.StoreFilterField;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.ActionExtensions;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.extensions.ObjectSelectionProviders;
import com.uniquesoft.gwt.client.common.widgets.ObjectListView.SelectEntityListener;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.common.shared.Objects;
import edu.fudan.langlab.gxt.client.action.SingleObjectActions;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.component.treegrid.SGrid;
import edu.fudan.langlab.gxt.client.widget.ComponentExtensions;
import edu.fudan.langlab.gxt.client.widget.ContentPanel;
import edu.fudan.langlab.gxt.client.widget.FramedPanel;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import edu.fudan.langlab.security.shared.IFunctionIdentifier;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ProductCategoryManagementView extends GWTAbstractView implements ProductCategoryManagementPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(listGrid,itemListGrid),
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
  private ProductCategoryListGrid listGrid;
  
  @Inject
  private ProductTypeListGrid itemListGrid;
  
  private Widget con;
  
  private Boolean isReadonly;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    this.listGrid.asWidget();
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u7269\u54C1\u7C7B\u522B\u4FE1\u606F\u7EF4\u62A4");
    final Procedure1<FramedPanel> _function = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          final ActionContext<UIProductCategory> ac = ActionExtensions.<UIProductCategory>createActionContext(ProductCategoryManagementView.this.listGrid);
          final Procedure1<UIProductCategory> _function = new Procedure1<UIProductCategory>() {
              public void apply(final UIProductCategory it) {
                RCProductCategoryProxy _proxy = it.toProxy();
                typeSelectedRequestHandler.execute(_proxy);
                
              }
            };
          ProductCategoryManagementView.this.listGrid.addSelectEntityListener(new SelectEntityListener<UIProductCategory>() {
              public void objectSelected(UIProductCategory selected) {
                _function.apply(selected);
              }
          });
          HorizontalLayoutContainer _HLayout = ProductCategoryManagementView.this.widgets.HLayout();
          final Procedure1<HorizontalLayoutContainer> _function_1 = new Procedure1<HorizontalLayoutContainer>() {
              public void apply(final HorizontalLayoutContainer it) {
                FieldSet _FieldSet = ProductCategoryManagementView.this.widgets.FieldSet("\u7269\u54C1\u5927\u7C7B");
                final Procedure1<FieldSet> _function = new Procedure1<FieldSet>() {
                    public void apply(final FieldSet it) {
                      ContentPanel _ContentPanel = ProductCategoryManagementView.this.widgets.ContentPanel();
                      final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
                          public void apply(final ContentPanel it) {
                            it.setBorders(false);
                            it.setBodyBorder(false);
                            VerticalLayoutContainer _VLayout = ProductCategoryManagementView.this.widgets.VLayout();
                            final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                                public void apply(final VerticalLayoutContainer it) {
                                  final Function2<UIProductCategory,String,Boolean> _function = new Function2<UIProductCategory,String,Boolean>() {
                                      public Boolean apply(final UIProductCategory item, final String filter) {
                                        boolean _or = false;
                                        String _name = item.getName();
                                        final Function1<String,Boolean> _function = new Function1<String,Boolean>() {
                                            public Boolean apply(final String it) {
                                              boolean _contains = it.contains(filter);
                                              return Boolean.valueOf(_contains);
                                            }
                                          };
                                        Boolean _satisfy = Objects.<String>satisfy(_name, _function);
                                        if ((_satisfy).booleanValue()) {
                                          _or = true;
                                        } else {
                                          String _simplePy = item.getSimplePy();
                                          final Function1<String,Boolean> _function_1 = new Function1<String,Boolean>() {
                                              public Boolean apply(final String it) {
                                                boolean _contains = it.contains(filter);
                                                return Boolean.valueOf(_contains);
                                              }
                                            };
                                          Boolean _satisfy_1 = Objects.<String>satisfy(_simplePy, _function_1);
                                          _or = ((_satisfy).booleanValue() || (_satisfy_1).booleanValue());
                                        }
                                        return Boolean.valueOf(_or);
                                      }
                                    };
                                  StoreFilterField<UIProductCategory> _createFilter = ComponentExtensions.<UIProductCategory>createFilter(ProductCategoryManagementView.this.listGrid, _function);
                                  int _minus = (-1);
                                  VerticalLayoutData _VLayoutData = ProductCategoryManagementView.this.widgets.VLayoutData(1, _minus);
                                  it.add(_createFilter, _VLayoutData);
                                  ContentPanel _ContentPanel = ProductCategoryManagementView.this.widgets.ContentPanel();
                                  final Procedure1<ContentPanel> _function_1 = new Procedure1<ContentPanel>() {
                                      public void apply(final ContentPanel it) {
                                        SGrid<UIProductCategory> _asWidget = ProductCategoryManagementView.this.listGrid.asWidget();
                                        it.setWidget(_asWidget);
                                      }
                                    };
                                  ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function_1);
                                  VerticalLayoutData _VLayoutData_1 = ProductCategoryManagementView.this.widgets.VLayoutData(1, 1);
                                  it.add(_doubleArrow, _VLayoutData_1);
                                }
                              };
                            VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                            it.setWidget(_doubleArrow);
                            boolean _not = (!ProductCategoryManagementView.this.isReadonly);
                            if (_not) {
                              final Procedure1<Void> _function_1 = new Procedure1<Void>() {
                                  public void apply(final Void v) {
                                    TextButton _TextButton = ProductCategoryManagementView.this.widgets.TextButton("\u65B0\u5EFA");
                                    final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                                        public void apply(final TextButton it) {
                                          final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                              public void apply(final SelectEvent it) {
                                                final UIProductCategory s = ObjectSelectionProviders.<UIProductCategory>getOnlySelected(ProductCategoryManagementView.this.listGrid);
                                                RCProductCategoryProxy _proxy = s==null?(RCProductCategoryProxy)null:s.toProxy();
                                                createRequestRequestHandler.execute(_proxy);
                                                
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
                              ProductCategoryManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                                public IFunctionIdentifier apply() {
                                  return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.warehouse.ProductCategoryManagementPresenter.createRequest" );
                                }
                              }.apply(), _function_1);
                              final Procedure1<Void> _function_2 = new Procedure1<Void>() {
                                  public void apply(final Void v) {
                                    final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                        public void apply(final SingleObjectActions it) {
                                          final Procedure1<UIProductCategory> _function = new Procedure1<UIProductCategory>() {
                                              public void apply(final UIProductCategory selectedValue) {
                                                RCProductCategoryProxy _proxy = selectedValue.toProxy();
                                                modifyRequestRequestHandler.execute(_proxy);
                                                
                                              }
                                            };
                                          it.onExecute(_function);
                                        }
                                      };
                                    SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIProductCategory>onSingleObjectAction(ac, _function);
                                    TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u4FEE\u6539");
                                    it.addButton(_asButtonRequester);
                                  }
                                };
                              ProductCategoryManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                                public IFunctionIdentifier apply() {
                                  return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.warehouse.ProductCategoryManagementPresenter.modifyRequest" );
                                }
                              }.apply(), _function_2);
                              final Procedure1<Void> _function_3 = new Procedure1<Void>() {
                                  public void apply(final Void v) {
                                    final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                        public void apply(final SingleObjectActions it) {
                                          final Procedure1<UIProductCategory> _function = new Procedure1<UIProductCategory>() {
                                              public void apply(final UIProductCategory selectedValue) {
                                                final Procedure1<Void> _function = new Procedure1<Void>() {
                                                    public void apply(final Void it) {
                                                      RCProductCategoryProxy _proxy = selectedValue.toProxy();
                                                      deleteRequestRequestHandler.execute(_proxy);
                                                      
                                                    }
                                                  };
                                                ConfirmMessageBox _ConfirmMessageBox = ProductCategoryManagementView.this.widgets.ConfirmMessageBox("\u786E\u8BA4", "\u786E\u8BA4\u5220\u9664\u9009\u5B9A\u7269\u54C1\u5927\u7C7B", _function);
                                                _ConfirmMessageBox.show();
                                              }
                                            };
                                          it.onExecute(_function);
                                        }
                                      };
                                    SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIProductCategory>onSingleObjectAction(ac, _function);
                                    TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u5220\u9664");
                                    it.addButton(_asButtonRequester);
                                  }
                                };
                              ProductCategoryManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                                public IFunctionIdentifier apply() {
                                  return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.warehouse.ProductCategoryManagementPresenter.deleteRequest" );
                                }
                              }.apply(), _function_3);
                            }
                          }
                        };
                      ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
                      it.setWidget(_doubleArrow);
                    }
                  };
                FieldSet _doubleArrow = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet, _function);
                HorizontalLayoutData _HLayoutData = ProductCategoryManagementView.this.widgets.HLayoutData(300, 1, 1);
                it.add(_doubleArrow, _HLayoutData);
                FieldSet _FieldSet_1 = ProductCategoryManagementView.this.widgets.FieldSet("\u7269\u54C1\u7C7B\u522B");
                final Procedure1<FieldSet> _function_1 = new Procedure1<FieldSet>() {
                    public void apply(final FieldSet it) {
                      ContentPanel _ContentPanel = ProductCategoryManagementView.this.widgets.ContentPanel();
                      final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
                          public void apply(final ContentPanel it) {
                            SGroupingGrid<UIProductType> _asWidget = ProductCategoryManagementView.this.itemListGrid.asWidget();
                            it.setWidget(_asWidget);
                            boolean _not = (!ProductCategoryManagementView.this.isReadonly);
                            if (_not) {
                              final ActionContext<UIProductType> itemAc = ActionExtensions.<UIProductType>createActionContext(ProductCategoryManagementView.this.itemListGrid);
                              final Procedure1<Void> _function = new Procedure1<Void>() {
                                  public void apply(final Void v) {
                                    final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                        public void apply(final SingleObjectActions it) {
                                          final Procedure1<UIProductCategory> _function = new Procedure1<UIProductCategory>() {
                                              public void apply(final UIProductCategory item) {
                                                RCProductCategoryProxy _proxy = item.toProxy();
                                                createChildRequestRequestHandler.execute(_proxy);
                                                
                                              }
                                            };
                                          it.onExecute(_function);
                                        }
                                      };
                                    SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIProductCategory>onSingleObjectAction(ac, _function);
                                    TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u65B0\u5EFA");
                                    it.addButton(_asButtonRequester);
                                  }
                                };
                              ProductCategoryManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                                public IFunctionIdentifier apply() {
                                  return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.warehouse.ProductCategoryManagementPresenter.createChildRequest" );
                                }
                              }.apply(), _function);
                              final Procedure1<Void> _function_1 = new Procedure1<Void>() {
                                  public void apply(final Void v) {
                                    final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                        public void apply(final SingleObjectActions it) {
                                          final Procedure1<UIProductType> _function = new Procedure1<UIProductType>() {
                                              public void apply(final UIProductType item) {
                                                RCProductTypeProxy _proxy = item.toProxy();
                                                modifyChildRequestRequestHandler.execute(_proxy);
                                                
                                              }
                                            };
                                          it.onExecute(_function);
                                        }
                                      };
                                    SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIProductType>onSingleObjectAction(itemAc, _function);
                                    TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u4FEE\u6539");
                                    it.addButton(_asButtonRequester);
                                  }
                                };
                              ProductCategoryManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                                public IFunctionIdentifier apply() {
                                  return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.warehouse.ProductCategoryManagementPresenter.modifyChildRequest" );
                                }
                              }.apply(), _function_1);
                              final Procedure1<Void> _function_2 = new Procedure1<Void>() {
                                  public void apply(final Void v) {
                                    final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                        public void apply(final SingleObjectActions it) {
                                          final Procedure1<UIProductType> _function = new Procedure1<UIProductType>() {
                                              public void apply(final UIProductType item) {
                                                final Procedure1<Void> _function = new Procedure1<Void>() {
                                                    public void apply(final Void it) {
                                                      RCProductTypeProxy _proxy = item.toProxy();
                                                      deleteChildRequestRequestHandler.execute(_proxy);
                                                      
                                                    }
                                                  };
                                                ConfirmMessageBox _ConfirmMessageBox = ProductCategoryManagementView.this.widgets.ConfirmMessageBox("\u786E\u8BA4", "\u786E\u8BA4\u5220\u9664\u9009\u5B9A\u7269\u54C1\u7C7B\u522B", _function);
                                                _ConfirmMessageBox.show();
                                              }
                                            };
                                          it.onExecute(_function);
                                        }
                                      };
                                    SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIProductType>onSingleObjectAction(itemAc, _function);
                                    TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u5220\u9664");
                                    it.addButton(_asButtonRequester);
                                  }
                                };
                              ProductCategoryManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                                public IFunctionIdentifier apply() {
                                  return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.warehouse.ProductCategoryManagementPresenter.deleteChildRequest" );
                                }
                              }.apply(), _function_2);
                            }
                          }
                        };
                      ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
                      it.setWidget(_doubleArrow);
                    }
                  };
                FieldSet _doubleArrow_1 = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet_1, _function_1);
                HorizontalLayoutData _HLayoutData_1 = ProductCategoryManagementView.this.widgets.HLayoutData(1, 1, 1);
                it.add(_doubleArrow_1, _HLayoutData_1);
              }
            };
          HorizontalLayoutContainer _doubleArrow = ObjectExtensions.<HorizontalLayoutContainer>operator_doubleArrow(_HLayout, _function_1);
          it.setWidget(_doubleArrow);
        }
      };
    FramedPanel _doubleArrow = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function);
    this.con = _doubleArrow;
  }
  
  public void showItems(final Collection<UIProductType> items) {
    this.itemListGrid.setObjects(items);
  }
  
  public void showResults(final Collection<UIProductCategory> results) {
    ProductCategoryTreeContentProvider _productCategoryTreeContentProvider = new ProductCategoryTreeContentProvider(results);
    this.listGrid.setContentProvider(_productCategoryTreeContentProvider);
  }
  
  public void updateProductCategory(final UIProductCategory org) {
    TreeStore<UIProductCategory> _store = this.listGrid.getStore();
    _store.update(org);
  }
  
  public void deleteProductCategory(final RCProductCategoryProxy org) {
    TreeStore<UIProductCategory> store = this.listGrid.getStore();
    int _hashCode = org.hashCode();
    String _string = Integer.valueOf(_hashCode).toString();
    UIProductCategory _findModelWithKey = store.findModelWithKey(_string);
    store.remove(_findModelWithKey);
  }
  
  public void addProductCategory(final UIProductCategory org) {
    TreeStore store = this.listGrid.getStore();
    RCProductCategoryProxy _parent = org.getParent();
    boolean _notEquals = (!com.google.common.base.Objects.equal(_parent, null));
    if (_notEquals) {
      RCProductCategoryProxy _parent_1 = org.getParent();
      int _hashCode = _parent_1.hashCode();
      String _string = Integer.valueOf(_hashCode).toString();
      Object parentInStore = store.findModelWithKey(_string);
      store.add(((UIProductCategory) parentInStore), ((UIProductCategory) org));
    } else {
      store.add(((UIProductCategory) org));
    }
  }
  
  private ActionContext<UIProductType> ac;
  
  public ActionContext<UIProductType> getActionContext() {
    boolean _equals = com.google.common.base.Objects.equal(this.ac, null);
    if (_equals) {
      ActionContext<UIProductType> _createActionContext = ActionExtensions.<UIProductType>createActionContext(this.itemListGrid);
      this.ac = _createActionContext;
    }
    return this.ac;
  }
  
  public void setAsReadonly(final Boolean isReadonly) {
    this.isReadonly = isReadonly;
  }
  
  private RequestHandler1<RCProductCategoryProxy> typeSelectedRequestHandler;
  
  public void typeSelected(final RequestHandler1<RCProductCategoryProxy> requestHandler) {
    this.typeSelectedRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCProductCategoryProxy> createRequestRequestHandler;
  
  public void createRequest(final RequestHandler1<RCProductCategoryProxy> requestHandler) {
    this.createRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCProductCategoryProxy> deleteRequestRequestHandler;
  
  public void deleteRequest(final RequestHandler1<RCProductCategoryProxy> requestHandler) {
    this.deleteRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCProductCategoryProxy> modifyRequestRequestHandler;
  
  public void modifyRequest(final RequestHandler1<RCProductCategoryProxy> requestHandler) {
    this.modifyRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCProductCategoryProxy> createChildRequestRequestHandler;
  
  public void createChildRequest(final RequestHandler1<RCProductCategoryProxy> requestHandler) {
    this.createChildRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCProductTypeProxy> modifyChildRequestRequestHandler;
  
  public void modifyChildRequest(final RequestHandler1<RCProductTypeProxy> requestHandler) {
    this.modifyChildRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCProductTypeProxy> deleteChildRequestRequestHandler;
  
  public void deleteChildRequest(final RequestHandler1<RCProductTypeProxy> requestHandler) {
    this.deleteChildRequestRequestHandler = requestHandler;
  }
}
