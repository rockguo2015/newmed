package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy;
import com.fudanmed.platform.core.web.client.project.FaultTypeListGrid;
import com.fudanmed.platform.core.web.client.project.MaintenamceTypeListGrid;
import com.fudanmed.platform.core.web.client.project.MaintenamceTypeManagementPresenterView;
import com.fudanmed.platform.core.web.client.tree.MaintenanceTypeTreeContentProvider;
import com.fudanmed.platform.core.web.shared.project.UIFaultType;
import com.fudanmed.platform.core.web.shared.project.UIMaintenamceType;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.data.shared.TreeStore;
import com.sencha.gxt.widget.core.client.ContentPanel;
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
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.ActionExtensions;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.extensions.ObjectSelectionProviders;
import com.uniquesoft.gwt.client.common.widgets.ObjectListView.SelectEntityListener;
import com.uniquesoft.gwt.shared.extensions.BooleanExtensions;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.action.SingleObjectActions;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.component.treegrid.SGrid;
import edu.fudan.langlab.gxt.client.widget.ComponentExtensions;
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

public class MaintenamceTypeManagementView extends GWTAbstractView implements MaintenamceTypeManagementPresenterView {
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
  private MaintenamceTypeListGrid listGrid;
  
  @Inject
  private FaultTypeListGrid itemListGrid;
  
  private Widget con;
  
  private Boolean isReadonly;
  
  public Widget asWidget() {
    return this.con;
  }
  
  private Boolean isSelector;
  
  public void setAsSelector() {
    this.isSelector = Boolean.valueOf(true);
  }
  
  public void initialize() {
    
    this.listGrid.asWidget();
    ContentPanel _xifexpression = null;
    boolean _isLogicTrue = BooleanExtensions.isLogicTrue(this.isSelector);
    if (_isLogicTrue) {
      edu.fudan.langlab.gxt.client.widget.ContentPanel _ContentPanel = this.widgets.ContentPanel();
      _xifexpression = _ContentPanel;
    } else {
      FramedPanel _FramedPanel = this.widgets.FramedPanel("\u7EF4\u4FEE\u7C7B\u522B\u7EF4\u62A4");
      _xifexpression = _FramedPanel;
    }
    ContentPanel cp = _xifexpression;
    final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
        public void apply(final ContentPanel it) {
          final ActionContext<UIMaintenamceType> ac = ActionExtensions.<UIMaintenamceType>createActionContext(MaintenamceTypeManagementView.this.listGrid);
          final Procedure1<UIMaintenamceType> _function = new Procedure1<UIMaintenamceType>() {
              public void apply(final UIMaintenamceType it) {
                RCMaintenamceTypeProxy _proxy = it.toProxy();
                typeSelectedRequestHandler.execute(_proxy);
                
              }
            };
          MaintenamceTypeManagementView.this.listGrid.addSelectEntityListener(new SelectEntityListener<UIMaintenamceType>() {
              public void objectSelected(UIMaintenamceType selected) {
                _function.apply(selected);
              }
          });
          HorizontalLayoutContainer _HLayout = MaintenamceTypeManagementView.this.widgets.HLayout();
          final Procedure1<HorizontalLayoutContainer> _function_1 = new Procedure1<HorizontalLayoutContainer>() {
              public void apply(final HorizontalLayoutContainer it) {
                FieldSet _FieldSet = MaintenamceTypeManagementView.this.widgets.FieldSet("\u7EF4\u4FEE\u7C7B\u522B");
                final Procedure1<FieldSet> _function = new Procedure1<FieldSet>() {
                    public void apply(final FieldSet it) {
                      edu.fudan.langlab.gxt.client.widget.ContentPanel _ContentPanel = MaintenamceTypeManagementView.this.widgets.ContentPanel();
                      final Procedure1<edu.fudan.langlab.gxt.client.widget.ContentPanel> _function = new Procedure1<edu.fudan.langlab.gxt.client.widget.ContentPanel>() {
                          public void apply(final edu.fudan.langlab.gxt.client.widget.ContentPanel it) {
                            it.setBorders(false);
                            it.setBodyBorder(false);
                            VerticalLayoutContainer _VLayout = MaintenamceTypeManagementView.this.widgets.VLayout();
                            final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                                public void apply(final VerticalLayoutContainer it) {
                                  final Function2<UIMaintenamceType,String,Boolean> _function = new Function2<UIMaintenamceType,String,Boolean>() {
                                      public Boolean apply(final UIMaintenamceType item, final String filter) {
                                        boolean _or = false;
                                        String _name = item.getName();
                                        boolean _contains = _name.contains(filter);
                                        if (_contains) {
                                          _or = true;
                                        } else {
                                          String _simplePy = item.getSimplePy();
                                          boolean _contains_1 = _simplePy.contains(filter);
                                          _or = (_contains || _contains_1);
                                        }
                                        return Boolean.valueOf(_or);
                                      }
                                    };
                                  StoreFilterField<UIMaintenamceType> _createFilter = ComponentExtensions.<UIMaintenamceType>createFilter(MaintenamceTypeManagementView.this.listGrid, _function);
                                  int _minus = (-1);
                                  VerticalLayoutData _VLayoutData = MaintenamceTypeManagementView.this.widgets.VLayoutData(1, _minus);
                                  it.add(_createFilter, _VLayoutData);
                                  edu.fudan.langlab.gxt.client.widget.ContentPanel _ContentPanel = MaintenamceTypeManagementView.this.widgets.ContentPanel();
                                  final Procedure1<edu.fudan.langlab.gxt.client.widget.ContentPanel> _function_1 = new Procedure1<edu.fudan.langlab.gxt.client.widget.ContentPanel>() {
                                      public void apply(final edu.fudan.langlab.gxt.client.widget.ContentPanel it) {
                                        SGrid<UIMaintenamceType> _asWidget = MaintenamceTypeManagementView.this.listGrid.asWidget();
                                        it.setWidget(_asWidget);
                                      }
                                    };
                                  edu.fudan.langlab.gxt.client.widget.ContentPanel _doubleArrow = ObjectExtensions.<edu.fudan.langlab.gxt.client.widget.ContentPanel>operator_doubleArrow(_ContentPanel, _function_1);
                                  VerticalLayoutData _VLayoutData_1 = MaintenamceTypeManagementView.this.widgets.VLayoutData(1, 1);
                                  it.add(_doubleArrow, _VLayoutData_1);
                                }
                              };
                            VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                            it.setWidget(_doubleArrow);
                            boolean _not = (!MaintenamceTypeManagementView.this.isReadonly);
                            if (_not) {
                              final Procedure1<Void> _function_1 = new Procedure1<Void>() {
                                  public void apply(final Void v) {
                                    TextButton _TextButton = MaintenamceTypeManagementView.this.widgets.TextButton("\u65B0\u5EFA");
                                    final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                                        public void apply(final TextButton it) {
                                          final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                              public void apply(final SelectEvent it) {
                                                final UIMaintenamceType s = ObjectSelectionProviders.<UIMaintenamceType>getOnlySelected(MaintenamceTypeManagementView.this.listGrid);
                                                RCMaintenamceTypeProxy _proxy = s==null?(RCMaintenamceTypeProxy)null:s.toProxy();
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
                              MaintenamceTypeManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                                public IFunctionIdentifier apply() {
                                  return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.project.MaintenamceTypeManagementPresenter.createRequest" );
                                }
                              }.apply(), _function_1);
                              final Procedure1<Void> _function_2 = new Procedure1<Void>() {
                                  public void apply(final Void v) {
                                    final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                        public void apply(final SingleObjectActions it) {
                                          final Procedure1<UIMaintenamceType> _function = new Procedure1<UIMaintenamceType>() {
                                              public void apply(final UIMaintenamceType selectedValue) {
                                                RCMaintenamceTypeProxy _proxy = selectedValue.toProxy();
                                                modifyRequestRequestHandler.execute(_proxy);
                                                
                                              }
                                            };
                                          it.onExecute(_function);
                                        }
                                      };
                                    SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIMaintenamceType>onSingleObjectAction(ac, _function);
                                    TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u4FEE\u6539");
                                    it.addButton(_asButtonRequester);
                                  }
                                };
                              MaintenamceTypeManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                                public IFunctionIdentifier apply() {
                                  return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.project.MaintenamceTypeManagementPresenter.modifyRequest" );
                                }
                              }.apply(), _function_2);
                              final Procedure1<Void> _function_3 = new Procedure1<Void>() {
                                  public void apply(final Void v) {
                                    final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                        public void apply(final SingleObjectActions it) {
                                          final Procedure1<UIMaintenamceType> _function = new Procedure1<UIMaintenamceType>() {
                                              public void apply(final UIMaintenamceType selectedValue) {
                                                final Procedure1<Void> _function = new Procedure1<Void>() {
                                                    public void apply(final Void it) {
                                                      RCMaintenamceTypeProxy _proxy = selectedValue.toProxy();
                                                      deleteRequestRequestHandler.execute(_proxy);
                                                      
                                                    }
                                                  };
                                                ConfirmMessageBox _ConfirmMessageBox = MaintenamceTypeManagementView.this.widgets.ConfirmMessageBox("\u786E\u8BA4", "\u786E\u8BA4\u5220\u9664", _function);
                                                _ConfirmMessageBox.show();
                                              }
                                            };
                                          it.onExecute(_function);
                                        }
                                      };
                                    SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIMaintenamceType>onSingleObjectAction(ac, _function);
                                    TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u5220\u9664");
                                    it.addButton(_asButtonRequester);
                                  }
                                };
                              MaintenamceTypeManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                                public IFunctionIdentifier apply() {
                                  return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.project.MaintenamceTypeManagementPresenter.deleteRequest" );
                                }
                              }.apply(), _function_3);
                            }
                          }
                        };
                      edu.fudan.langlab.gxt.client.widget.ContentPanel _doubleArrow = ObjectExtensions.<edu.fudan.langlab.gxt.client.widget.ContentPanel>operator_doubleArrow(_ContentPanel, _function);
                      it.setWidget(_doubleArrow);
                    }
                  };
                FieldSet _doubleArrow = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet, _function);
                HorizontalLayoutData _HLayoutData = MaintenamceTypeManagementView.this.widgets.HLayoutData(300, 1, 1);
                it.add(_doubleArrow, _HLayoutData);
                FieldSet _FieldSet_1 = MaintenamceTypeManagementView.this.widgets.FieldSet("\u7EF4\u4FEE\u9879\u76EE");
                final Procedure1<FieldSet> _function_1 = new Procedure1<FieldSet>() {
                    public void apply(final FieldSet it) {
                      edu.fudan.langlab.gxt.client.widget.ContentPanel _ContentPanel = MaintenamceTypeManagementView.this.widgets.ContentPanel();
                      final Procedure1<edu.fudan.langlab.gxt.client.widget.ContentPanel> _function = new Procedure1<edu.fudan.langlab.gxt.client.widget.ContentPanel>() {
                          public void apply(final edu.fudan.langlab.gxt.client.widget.ContentPanel it) {
                            SGroupingGrid<UIFaultType> _asWidget = MaintenamceTypeManagementView.this.itemListGrid.asWidget();
                            it.setWidget(_asWidget);
                            boolean _not = (!MaintenamceTypeManagementView.this.isReadonly);
                            if (_not) {
                              final ActionContext<UIFaultType> itemAc = ActionExtensions.<UIFaultType>createActionContext(MaintenamceTypeManagementView.this.itemListGrid);
                              final Procedure1<Void> _function = new Procedure1<Void>() {
                                  public void apply(final Void v) {
                                    final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                        public void apply(final SingleObjectActions it) {
                                          final Procedure1<UIMaintenamceType> _function = new Procedure1<UIMaintenamceType>() {
                                              public void apply(final UIMaintenamceType item) {
                                                RCMaintenamceTypeProxy _proxy = item.toProxy();
                                                createChildRequestRequestHandler.execute(_proxy);
                                                
                                              }
                                            };
                                          it.onExecute(_function);
                                        }
                                      };
                                    SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIMaintenamceType>onSingleObjectAction(ac, _function);
                                    TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u65B0\u5EFA");
                                    it.addButton(_asButtonRequester);
                                  }
                                };
                              MaintenamceTypeManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                                public IFunctionIdentifier apply() {
                                  return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.project.MaintenamceTypeManagementPresenter.createChildRequest" );
                                }
                              }.apply(), _function);
                              final Procedure1<Void> _function_1 = new Procedure1<Void>() {
                                  public void apply(final Void v) {
                                    final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                        public void apply(final SingleObjectActions it) {
                                          final Procedure1<UIFaultType> _function = new Procedure1<UIFaultType>() {
                                              public void apply(final UIFaultType item) {
                                                RCFaultTypeProxy _proxy = item.toProxy();
                                                modifyChildRequestRequestHandler.execute(_proxy);
                                                
                                              }
                                            };
                                          it.onExecute(_function);
                                        }
                                      };
                                    SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIFaultType>onSingleObjectAction(itemAc, _function);
                                    TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u4FEE\u6539");
                                    it.addButton(_asButtonRequester);
                                  }
                                };
                              MaintenamceTypeManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                                public IFunctionIdentifier apply() {
                                  return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.project.MaintenamceTypeManagementPresenter.modifyChildRequest" );
                                }
                              }.apply(), _function_1);
                              final Procedure1<Void> _function_2 = new Procedure1<Void>() {
                                  public void apply(final Void v) {
                                    final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                        public void apply(final SingleObjectActions it) {
                                          final Procedure1<UIFaultType> _function = new Procedure1<UIFaultType>() {
                                              public void apply(final UIFaultType item) {
                                                final Procedure1<Void> _function = new Procedure1<Void>() {
                                                    public void apply(final Void it) {
                                                      RCFaultTypeProxy _proxy = item.toProxy();
                                                      deleteChildRequestRequestHandler.execute(_proxy);
                                                      
                                                    }
                                                  };
                                                ConfirmMessageBox _ConfirmMessageBox = MaintenamceTypeManagementView.this.widgets.ConfirmMessageBox("\u786E\u8BA4", "\u786E\u8BA4\u5220\u9664\u9009\u5B9A\u7EF4\u4FEE\u9879\u76EE", _function);
                                                _ConfirmMessageBox.show();
                                              }
                                            };
                                          it.onExecute(_function);
                                        }
                                      };
                                    SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIFaultType>onSingleObjectAction(itemAc, _function);
                                    TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u5220\u9664");
                                    it.addButton(_asButtonRequester);
                                  }
                                };
                              MaintenamceTypeManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                                public IFunctionIdentifier apply() {
                                  return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.project.MaintenamceTypeManagementPresenter.deleteChildRequest" );
                                }
                              }.apply(), _function_2);
                            }
                          }
                        };
                      edu.fudan.langlab.gxt.client.widget.ContentPanel _doubleArrow = ObjectExtensions.<edu.fudan.langlab.gxt.client.widget.ContentPanel>operator_doubleArrow(_ContentPanel, _function);
                      it.setWidget(_doubleArrow);
                    }
                  };
                FieldSet _doubleArrow_1 = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet_1, _function_1);
                HorizontalLayoutData _HLayoutData_1 = MaintenamceTypeManagementView.this.widgets.HLayoutData(1, 1, 1);
                it.add(_doubleArrow_1, _HLayoutData_1);
              }
            };
          HorizontalLayoutContainer _doubleArrow = ObjectExtensions.<HorizontalLayoutContainer>operator_doubleArrow(_HLayout, _function_1);
          it.setWidget(_doubleArrow);
        }
      };
    ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(cp, _function);
    this.con = _doubleArrow;
  }
  
  public void showItems(final Collection<UIFaultType> items) {
    this.itemListGrid.setObjects(items);
  }
  
  public void showResults(final Collection<UIMaintenamceType> results) {
    MaintenanceTypeTreeContentProvider _maintenanceTypeTreeContentProvider = new MaintenanceTypeTreeContentProvider(results);
    this.listGrid.setContentProvider(_maintenanceTypeTreeContentProvider);
  }
  
  public void updateMaintenamceType(final UIMaintenamceType org) {
    TreeStore<UIMaintenamceType> _store = this.listGrid.getStore();
    _store.update(org);
  }
  
  public void deleteMaintenamceType(final RCMaintenamceTypeProxy org) {
    TreeStore<UIMaintenamceType> store = this.listGrid.getStore();
    int _hashCode = org.hashCode();
    String _string = Integer.valueOf(_hashCode).toString();
    UIMaintenamceType _findModelWithKey = store.findModelWithKey(_string);
    store.remove(_findModelWithKey);
  }
  
  public void addMaintenamceType(final UIMaintenamceType org) {
    TreeStore store = this.listGrid.getStore();
    RCMaintenamceTypeProxy _parent = org.getParent();
    boolean _notEquals = (!Objects.equal(_parent, null));
    if (_notEquals) {
      RCMaintenamceTypeProxy _parent_1 = org.getParent();
      int _hashCode = _parent_1.hashCode();
      String _string = Integer.valueOf(_hashCode).toString();
      Object parentInStore = store.findModelWithKey(_string);
      store.add(((UIMaintenamceType) parentInStore), ((UIMaintenamceType) org));
    } else {
      store.add(((UIMaintenamceType) org));
    }
  }
  
  private ActionContext<UIFaultType> ac;
  
  public ActionContext<UIFaultType> getActionContext() {
    final Function1<Void,ActionContext<UIFaultType>> _function = new Function1<Void,ActionContext<UIFaultType>>() {
        public ActionContext<UIFaultType> apply(final Void it) {
          ActionContext<UIFaultType> _createActionContext = ActionExtensions.<UIFaultType>createActionContext(MaintenamceTypeManagementView.this.itemListGrid);
          return _createActionContext;
        }
      };
    ActionContext<UIFaultType> _lazy = ClientUi.<ActionContext<UIFaultType>>lazy(this.ac, _function);
    ActionContext<UIFaultType> _ac = this.ac = _lazy;
    return _ac;
  }
  
  public void setAsReadonly(final Boolean isReadonly) {
    this.isReadonly = isReadonly;
  }
  
  private RequestHandler1<RCMaintenamceTypeProxy> typeSelectedRequestHandler;
  
  public void typeSelected(final RequestHandler1<RCMaintenamceTypeProxy> requestHandler) {
    this.typeSelectedRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCMaintenamceTypeProxy> createRequestRequestHandler;
  
  public void createRequest(final RequestHandler1<RCMaintenamceTypeProxy> requestHandler) {
    this.createRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCMaintenamceTypeProxy> deleteRequestRequestHandler;
  
  public void deleteRequest(final RequestHandler1<RCMaintenamceTypeProxy> requestHandler) {
    this.deleteRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCMaintenamceTypeProxy> modifyRequestRequestHandler;
  
  public void modifyRequest(final RequestHandler1<RCMaintenamceTypeProxy> requestHandler) {
    this.modifyRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCMaintenamceTypeProxy> createChildRequestRequestHandler;
  
  public void createChildRequest(final RequestHandler1<RCMaintenamceTypeProxy> requestHandler) {
    this.createChildRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCFaultTypeProxy> modifyChildRequestRequestHandler;
  
  public void modifyChildRequest(final RequestHandler1<RCFaultTypeProxy> requestHandler) {
    this.modifyChildRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCFaultTypeProxy> deleteChildRequestRequestHandler;
  
  public void deleteChildRequest(final RequestHandler1<RCFaultTypeProxy> requestHandler) {
    this.deleteChildRequestRequestHandler = requestHandler;
  }
}
