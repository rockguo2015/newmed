package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.entityextension.proxy.RCCustomizableTypeProxy;
import com.fudanmed.platform.core.entityextension.proxy.RCNumberWithUnitTypeProxy;
import com.fudanmed.platform.core.web.client.device.CustomizableTypeCriteriaForm;
import com.fudanmed.platform.core.web.client.device.CustomizableTypeListGrid;
import com.fudanmed.platform.core.web.client.device.NumberWithUnitTypeManagementPresenterView;
import com.fudanmed.platform.core.web.shared.device.UICustomizableType;
import com.fudanmed.platform.core.web.shared.device.UICustomizableTypeCriteria;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.ActionExtensions;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.pager.IPager;
import com.uniquesoft.gwt.client.common.widgets.pager.IPager.GotoPageHandler;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.action.SingleObjectActions;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.pager.Extensions;
import edu.fudan.langlab.gxt.client.widget.ContentPanel;
import edu.fudan.langlab.gxt.client.widget.FramedPanel;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import edu.fudan.langlab.security.shared.IFunctionIdentifier;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

public class NumberWithUnitTypeManagementView extends GWTAbstractView implements NumberWithUnitTypeManagementPresenterView {
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
  private CustomizableTypeListGrid listGrid;
  
  @Inject
  private CustomizableTypeCriteriaForm criteriaForm;
  
  private IPager pager;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    this.listGrid.asWidget();
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u6570\u503C\u53C2\u6570\u5355\u4F4D\u7BA1\u7406");
    final Procedure1<FramedPanel> _function = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          VerticalLayoutContainer _VLayout = NumberWithUnitTypeManagementView.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                IPager<UICustomizableType> _createPager = Extensions.<UICustomizableType>createPager(NumberWithUnitTypeManagementView.this.listGrid);
                final Procedure1<IPager<UICustomizableType>> _function = new Procedure1<IPager<UICustomizableType>>() {
                    public void apply(final IPager<UICustomizableType> it) {
                      final Procedure2<Integer,Integer> _function = new Procedure2<Integer,Integer>() {
                          public void apply(final Integer pageNum, final Integer recordsPerPage) {
                            UICustomizableTypeCriteria _value = NumberWithUnitTypeManagementView.this.criteriaForm.getValue();
                            UICustomizableTypeCriteria _withPagerInfo = com.uniquesoft.gwt.client.common.widgets.pager.Extensions.<UICustomizableTypeCriteria>withPagerInfo(_value, NumberWithUnitTypeManagementView.this.pager);
                            final Procedure1<UICustomizableTypeCriteria> _function = new Procedure1<UICustomizableTypeCriteria>() {
                                public void apply(final UICustomizableTypeCriteria it) {
                                  it.setPage(Integer.valueOf(pageNum));
                                  it.setPageSize(Integer.valueOf(recordsPerPage));
                                }
                              };
                            UICustomizableTypeCriteria _doubleArrow = ObjectExtensions.<UICustomizableTypeCriteria>operator_doubleArrow(_withPagerInfo, _function);
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
                IPager<UICustomizableType> _doubleArrow = ObjectExtensions.<IPager<UICustomizableType>>operator_doubleArrow(_createPager, _function);
                NumberWithUnitTypeManagementView.this.pager = _doubleArrow;
                ContentPanel _ContentPanel = NumberWithUnitTypeManagementView.this.widgets.ContentPanel();
                final Procedure1<ContentPanel> _function_1 = new Procedure1<ContentPanel>() {
                    public void apply(final ContentPanel it) {
                      VerticalLayoutContainer _VLayout = NumberWithUnitTypeManagementView.this.widgets.VLayout();
                      final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                          public void apply(final VerticalLayoutContainer it) {
                            SGroupingGrid<UICustomizableType> _asWidget = NumberWithUnitTypeManagementView.this.listGrid.asWidget();
                            VerticalLayoutData _VLayoutData = NumberWithUnitTypeManagementView.this.widgets.VLayoutData(1, 1);
                            it.add(_asWidget, _VLayoutData);
                            Widget _asWidget_1 = NumberWithUnitTypeManagementView.this.pager.asWidget();
                            int _minus = (-1);
                            VerticalLayoutData _VLayoutData_1 = NumberWithUnitTypeManagementView.this.widgets.VLayoutData(1, _minus);
                            it.add(_asWidget_1, _VLayoutData_1);
                          }
                        };
                      VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                      it.setWidget(_doubleArrow);
                    }
                  };
                ContentPanel _doubleArrow_1 = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function_1);
                VerticalLayoutData _VLayoutData = NumberWithUnitTypeManagementView.this.widgets.VLayoutData(1, 1);
                it.add(_doubleArrow_1, _VLayoutData);
              }
            };
          VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
          it.setWidget(_doubleArrow);
          final ActionContext<UICustomizableType> ac = ActionExtensions.<UICustomizableType>createActionContext(NumberWithUnitTypeManagementView.this.listGrid);
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
          NumberWithUnitTypeManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.device.NumberWithUnitTypeManagementPresenter.createRequest" );
            }
          }.apply(), _function_1);
          final Procedure1<Void> _function_2 = new Procedure1<Void>() {
              public void apply(final Void v) {
                final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                    public void apply(final SingleObjectActions it) {
                      final Procedure1<UICustomizableType> _function = new Procedure1<UICustomizableType>() {
                          public void apply(final UICustomizableType selectedValue) {
                            RCCustomizableTypeProxy _proxy = selectedValue.toProxy();
                            modifyRequestRequestHandler.execute(((RCNumberWithUnitTypeProxy) _proxy));
                            
                          }
                        };
                      it.onExecute(_function);
                      final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                          public Boolean apply(final Void it) {
                            final Function1<UICustomizableType,Boolean> _function = new Function1<UICustomizableType,Boolean>() {
                                public Boolean apply(final UICustomizableType it) {
                                  Boolean _isPrimary = it.getIsPrimary();
                                  return _isPrimary;
                                }
                              };
                            Boolean _singleSelectedAnd = ActionExtensions.<UICustomizableType>singleSelectedAnd(NumberWithUnitTypeManagementView.this.listGrid, _function);
                            return _singleSelectedAnd;
                          }
                        };
                      it.onCheckEnable(_function_1);
                    }
                  };
                SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UICustomizableType>onSingleObjectAction(ac, _function);
                TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u4FEE\u6539");
                it.addButton(_asButtonRequester);
              }
            };
          NumberWithUnitTypeManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.device.NumberWithUnitTypeManagementPresenter.modifyRequest" );
            }
          }.apply(), _function_2);
          final Procedure1<Void> _function_3 = new Procedure1<Void>() {
              public void apply(final Void v) {
                final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                    public void apply(final SingleObjectActions it) {
                      final Procedure1<UICustomizableType> _function = new Procedure1<UICustomizableType>() {
                          public void apply(final UICustomizableType selectedValue) {
                            RCCustomizableTypeProxy _proxy = selectedValue.toProxy();
                            createRangeTypeRequestRequestHandler.execute(((RCNumberWithUnitTypeProxy) _proxy));
                            
                          }
                        };
                      it.onExecute(_function);
                      final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                          public Boolean apply(final Void it) {
                            final Function1<UICustomizableType,Boolean> _function = new Function1<UICustomizableType,Boolean>() {
                                public Boolean apply(final UICustomizableType it) {
                                  Boolean _isPrimary = it.getIsPrimary();
                                  return _isPrimary;
                                }
                              };
                            Boolean _singleSelectedAnd = ActionExtensions.<UICustomizableType>singleSelectedAnd(NumberWithUnitTypeManagementView.this.listGrid, _function);
                            return _singleSelectedAnd;
                          }
                        };
                      it.onCheckEnable(_function_1);
                    }
                  };
                SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UICustomizableType>onSingleObjectAction(ac, _function);
                TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u521B\u5EFA\u8303\u56F4\u7C7B\u578B");
                it.addButton(_asButtonRequester);
              }
            };
          NumberWithUnitTypeManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.device.NumberWithUnitTypeManagementPresenter.createRangeTypeRequest" );
            }
          }.apply(), _function_3);
          final Procedure1<Void> _function_4 = new Procedure1<Void>() {
              public void apply(final Void v) {
                final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                    public void apply(final SingleObjectActions it) {
                      final Procedure1<UICustomizableType> _function = new Procedure1<UICustomizableType>() {
                          public void apply(final UICustomizableType selectedValue) {
                            final Procedure1<Void> _function = new Procedure1<Void>() {
                                public void apply(final Void it) {
                                  RCCustomizableTypeProxy _proxy = selectedValue.toProxy();
                                  deleteRequestRequestHandler.execute(_proxy);
                                  
                                }
                              };
                            ConfirmMessageBox _ConfirmMessageBox = NumberWithUnitTypeManagementView.this.widgets.ConfirmMessageBox("\u786E\u8BA4", "\u786E\u8BA4\u5220\u9664", _function);
                            _ConfirmMessageBox.show();
                          }
                        };
                      it.onExecute(_function);
                    }
                  };
                SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UICustomizableType>onSingleObjectAction(ac, _function);
                TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u5220\u9664");
                it.addButton(_asButtonRequester);
              }
            };
          NumberWithUnitTypeManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.device.NumberWithUnitTypeManagementPresenter.deleteRequest" );
            }
          }.apply(), _function_4);
        }
      };
    FramedPanel _doubleArrow = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function);
    this.con = _doubleArrow;
  }
  
  public void showResults(final IPagedResult<UICustomizableType> results) {
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
  
  private RequestHandler1<RCCustomizableTypeProxy> deleteRequestRequestHandler;
  
  public void deleteRequest(final RequestHandler1<RCCustomizableTypeProxy> requestHandler) {
    this.deleteRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCNumberWithUnitTypeProxy> modifyRequestRequestHandler;
  
  public void modifyRequest(final RequestHandler1<RCNumberWithUnitTypeProxy> requestHandler) {
    this.modifyRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCNumberWithUnitTypeProxy> createRangeTypeRequestRequestHandler;
  
  public void createRangeTypeRequest(final RequestHandler1<RCNumberWithUnitTypeProxy> requestHandler) {
    this.createRangeTypeRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<UICustomizableTypeCriteria> filterRequestRequestHandler;
  
  public void filterRequest(final RequestHandler1<UICustomizableTypeCriteria> requestHandler) {
    this.filterRequestRequestHandler = requestHandler;
  }
}
