package edu.fudan.langlab.uidl.domain.code.client.web;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
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
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.domain.code.proxy.CodeProxy;
import edu.fudan.langlab.gxt.client.action.SingleObjectActions;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.widget.HTableLayoutContainer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import edu.fudan.langlab.security.shared.IFunctionIdentifier;
import edu.fudan.langlab.uidl.domain.code.client.web.CodeCriteriaForm;
import edu.fudan.langlab.uidl.domain.code.client.web.CodeListGrid;
import edu.fudan.langlab.uidl.domain.code.client.web.CodeManagementPresenterView;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICode;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICodeCriteria;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICodeType;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CodeManagementView extends GWTAbstractView implements CodeManagementPresenterView {
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
  private CodeListGrid listGrid;
  
  @Inject
  private CodeCriteriaForm criteriaForm;
  
  private FramedPanel con;
  
  public FramedPanel asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    this.listGrid.asWidget();
    edu.fudan.langlab.gxt.client.widget.FramedPanel _FramedPanel = this.widgets.FramedPanel("\u57FA\u7840\u4EE3\u7801\u7EF4\u62A4");
    final Procedure1<edu.fudan.langlab.gxt.client.widget.FramedPanel> _function = new Procedure1<edu.fudan.langlab.gxt.client.widget.FramedPanel>() {
        public void apply(final edu.fudan.langlab.gxt.client.widget.FramedPanel it) {
          VerticalLayoutContainer _VLayout = CodeManagementView.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                HTableLayoutContainer _HTableLayout = CodeManagementView.this.widgets.HTableLayout();
                final Procedure1<HTableLayoutContainer> _function = new Procedure1<HTableLayoutContainer>() {
                    public void apply(final HTableLayoutContainer it) {
                      FieldLabel _asWidget = CodeManagementView.this.criteriaForm.codeType.asWidget();
                      final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                          public void apply(final FieldLabel it) {
                            final Procedure1<Iterable<UICodeType>> _function = new Procedure1<Iterable<UICodeType>>() {
                                public void apply(final Iterable<UICodeType> it) {
                                  final Procedure1<UICodeType> _function = new Procedure1<UICodeType>() {
                                      public void apply(final UICodeType codeType) {
                                        UICodeCriteria _value = CodeManagementView.this.criteriaForm.getValue();
                                        final Procedure1<UICodeCriteria> _function = new Procedure1<UICodeCriteria>() {
                                            public void apply(final UICodeCriteria it) {
                                              it.setCodeType(codeType);
                                            }
                                          };
                                        UICodeCriteria _doubleArrow = ObjectExtensions.<UICodeCriteria>operator_doubleArrow(_value, _function);
                                        filterRequestRequestHandler.execute(_doubleArrow);
                                        
                                      }
                                    };
                                  IterableExtensions2.<UICodeType>forOnlySelected(it, _function);
                                }
                              };
                            CodeManagementView.this.criteriaForm.codeType.addSelectionChangedListener(new SelectionChangedListener<UICodeType>() {
                                public void selectionChanged(Iterable<UICodeType> selections) {
                                  _function.apply(selections);
                                }
                            });
                          }
                        };
                      FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function);
                      ArrayList<Widget> _newArrayList = CollectionLiterals.<Widget>newArrayList(_doubleArrow);
                      it.add(_newArrayList);
                    }
                  };
                HTableLayoutContainer _doubleArrow = ObjectExtensions.<HTableLayoutContainer>operator_doubleArrow(_HTableLayout, _function);
                it.add(_doubleArrow);
                SGroupingGrid<UICode> _asWidget = CodeManagementView.this.listGrid.asWidget();
                VerticalLayoutData _VLayoutData = CodeManagementView.this.widgets.VLayoutData(1, 1);
                it.add(_asWidget, _VLayoutData);
              }
            };
          VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
          it.setWidget(_doubleArrow);
          final ActionContext<UICode> ac = ActionExtensions.<UICode>createActionContext(CodeManagementView.this.listGrid);
          TextButton _TextButton = CodeManagementView.this.widgets.TextButton("\u65B0\u5EFA");
          final Procedure1<TextButton> _function_1 = new Procedure1<TextButton>() {
              public void apply(final TextButton it) {
                final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                    public void apply(final SelectEvent it) {
                      UICodeType _value = CodeManagementView.this.criteriaForm.codeType.getValue();
                      createRequestRequestHandler.execute(_value);
                      
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
          it.addButton(_doubleArrow_1);
          final Procedure1<Void> _function_2 = new Procedure1<Void>() {
              public void apply(final Void v) {
                final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                    public void apply(final SingleObjectActions it) {
                      final Procedure1<UICode> _function = new Procedure1<UICode>() {
                          public void apply(final UICode selectedValue) {
                            CodeProxy _proxy = selectedValue.toProxy();
                            modifyRequestRequestHandler.execute(_proxy);
                            
                          }
                        };
                      it.onExecute(_function);
                    }
                  };
                SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UICode>onSingleObjectAction(ac, _function);
                TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u4FEE\u6539");
                it.addButton(_asButtonRequester);
              }
            };
          CodeManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "edu.fudan.langlab.uidl.domain.code.client.web.CodeManagementPresenter.modifyRequest" );
            }
          }.apply(), _function_2);
          final Procedure1<Void> _function_3 = new Procedure1<Void>() {
              public void apply(final Void v) {
                final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                    public void apply(final SingleObjectActions it) {
                      final Procedure1<UICode> _function = new Procedure1<UICode>() {
                          public void apply(final UICode selectedValue) {
                            String _name = selectedValue.getName();
                            String _plus = ("\u786E\u8BA4\u5220\u9664" + _name);
                            final Procedure1<Void> _function = new Procedure1<Void>() {
                                public void apply(final Void it) {
                                  CodeProxy _proxy = selectedValue.toProxy();
                                  deleteRequestRequestHandler.execute(_proxy);
                                  
                                }
                              };
                            ConfirmMessageBox _ConfirmMessageBox = CodeManagementView.this.widgets.ConfirmMessageBox("\u786E\u8BA4", _plus, _function);
                            _ConfirmMessageBox.show();
                          }
                        };
                      it.onExecute(_function);
                    }
                  };
                SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UICode>onSingleObjectAction(ac, _function);
                TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u5220\u9664");
                it.addButton(_asButtonRequester);
              }
            };
          CodeManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "edu.fudan.langlab.uidl.domain.code.client.web.CodeManagementPresenter.deleteRequest" );
            }
          }.apply(), _function_3);
        }
      };
    edu.fudan.langlab.gxt.client.widget.FramedPanel _doubleArrow = ObjectExtensions.<edu.fudan.langlab.gxt.client.widget.FramedPanel>operator_doubleArrow(_FramedPanel, _function);
    this.con = _doubleArrow;
  }
  
  public void showResults(final Collection<UICode> results) {
    this.listGrid.setObjects(results);
  }
  
  public void refresh() {
    UICodeCriteria _value = this.criteriaForm.getValue();
    filterRequestRequestHandler.execute(_value);
    
  }
  
  public void showFirst() {
    this.criteriaForm.codeType.selectFirst();
    UICodeCriteria _value = this.criteriaForm.getValue();
    final Procedure1<UICodeCriteria> _function = new Procedure1<UICodeCriteria>() {
        public void apply(final UICodeCriteria it) {
          UICodeType _value = CodeManagementView.this.criteriaForm.codeType.getValue();
          it.setCodeType(_value);
        }
      };
    UICodeCriteria _doubleArrow = ObjectExtensions.<UICodeCriteria>operator_doubleArrow(_value, _function);
    filterRequestRequestHandler.execute(_doubleArrow);
    
  }
  
  private RequestHandler1<UICodeType> createRequestRequestHandler;
  
  public void createRequest(final RequestHandler1<UICodeType> requestHandler) {
    this.createRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<CodeProxy> deleteRequestRequestHandler;
  
  public void deleteRequest(final RequestHandler1<CodeProxy> requestHandler) {
    this.deleteRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<CodeProxy> modifyRequestRequestHandler;
  
  public void modifyRequest(final RequestHandler1<CodeProxy> requestHandler) {
    this.modifyRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<UICodeCriteria> filterRequestRequestHandler;
  
  public void filterRequest(final RequestHandler1<UICodeCriteria> requestHandler) {
    this.filterRequestRequestHandler = requestHandler;
  }
}
