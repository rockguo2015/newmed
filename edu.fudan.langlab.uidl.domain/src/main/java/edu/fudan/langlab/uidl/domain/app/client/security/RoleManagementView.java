package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.ActionExtensions;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.domain.security.proxy.RoleProxy;
import edu.fudan.langlab.gxt.client.action.SingleObjectActions;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.widget.FramedPanel;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import edu.fudan.langlab.security.shared.IFunctionIdentifier;
import edu.fudan.langlab.uidl.domain.app.client.security.RoleListGrid;
import edu.fudan.langlab.uidl.domain.app.client.security.RoleManagementPresenterView;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIRole;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class RoleManagementView extends GWTAbstractView implements RoleManagementPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(listGrid),
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
  
  private Widget con;
  
  @Inject
  private RoleListGrid listGrid;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u7CFB\u7EDF\u89D2\u8272\u7BA1\u7406");
    final Procedure1<FramedPanel> _function = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          SGroupingGrid<UIRole> _asWidget = RoleManagementView.this.listGrid.asWidget();
          it.setWidget(_asWidget);
          final ActionContext<UIRole> ac = ActionExtensions.<UIRole>createActionContext(RoleManagementView.this.listGrid);
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void v) {
                final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                    public void apply(final SelectEvent it) {createRoleRequestRequestHandler.execute();
                      
                    }
                  };
                TextButton _TextButton = RoleManagementView.this.widgets.TextButton("\u65B0\u5EFA", _function);
                it.addButton(_TextButton);
              }
            };
          RoleManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "edu.fudan.langlab.uidl.domain.app.client.security.RoleManagementPresenter.createRoleRequest" );
            }
          }.apply(), _function);
          final Procedure1<Void> _function_1 = new Procedure1<Void>() {
              public void apply(final Void v) {
                final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                    public void apply(final SingleObjectActions it) {
                      final Procedure1<UIRole> _function = new Procedure1<UIRole>() {
                          public void apply(final UIRole role) {
                            RoleProxy _proxy = role.toProxy();
                            modifyRoleRequestRequestHandler.execute(_proxy);
                            
                          }
                        };
                      it.onExecute(_function);
                      final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                          public Boolean apply(final Void it) {
                            final Function1<UIRole,Boolean> _function = new Function1<UIRole,Boolean>() {
                                public Boolean apply(final UIRole it) {
                                  Boolean _isBuildin = it.getIsBuildin();
                                  boolean _not = (!_isBuildin);
                                  return Boolean.valueOf(_not);
                                }
                              };
                            Boolean _singleSelectedAnd = ActionExtensions.<UIRole>singleSelectedAnd(RoleManagementView.this.listGrid, _function);
                            return _singleSelectedAnd;
                          }
                        };
                      it.onCheckEnable(_function_1);
                    }
                  };
                SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIRole>onSingleObjectAction(ac, _function);
                TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u4FEE\u6539");
                it.addButton(_asButtonRequester);
              }
            };
          RoleManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "edu.fudan.langlab.uidl.domain.app.client.security.RoleManagementPresenter.modifyRoleRequest" );
            }
          }.apply(), _function_1);
          final Procedure1<Void> _function_2 = new Procedure1<Void>() {
              public void apply(final Void v) {
                final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                    public void apply(final SingleObjectActions it) {
                      final Procedure1<UIRole> _function = new Procedure1<UIRole>() {
                          public void apply(final UIRole role) {
                            String _name = role.getName();
                            String _plus = ("\u786E\u8BA4\u5220\u9664\u89D2\u8272" + _name);
                            final Procedure1<Void> _function = new Procedure1<Void>() {
                                public void apply(final Void it) {
                                  RoleProxy _proxy = role.toProxy();
                                  deleteRoleRequestRequestHandler.execute(_proxy);
                                  
                                }
                              };
                            ConfirmMessageBox _ConfirmMessageBox = RoleManagementView.this.widgets.ConfirmMessageBox("\u786E\u8BA4", _plus, _function);
                            _ConfirmMessageBox.show();
                          }
                        };
                      it.onExecute(_function);
                      final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                          public Boolean apply(final Void it) {
                            final Function1<UIRole,Boolean> _function = new Function1<UIRole,Boolean>() {
                                public Boolean apply(final UIRole it) {
                                  Boolean _isBuildin = it.getIsBuildin();
                                  boolean _not = (!_isBuildin);
                                  return Boolean.valueOf(_not);
                                }
                              };
                            Boolean _singleSelectedAnd = ActionExtensions.<UIRole>singleSelectedAnd(RoleManagementView.this.listGrid, _function);
                            return _singleSelectedAnd;
                          }
                        };
                      it.onCheckEnable(_function_1);
                    }
                  };
                SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIRole>onSingleObjectAction(ac, _function);
                TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u5220\u9664");
                it.addButton(_asButtonRequester);
              }
            };
          RoleManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "edu.fudan.langlab.uidl.domain.app.client.security.RoleManagementPresenter.deleteRoleRequest" );
            }
          }.apply(), _function_2);
        }
      };
    FramedPanel _doubleArrow = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function);
    this.con = _doubleArrow;
  }
  
  public void setResults(final Collection<UIRole> results) {
    
    this.listGrid.setObjects(results);
  }
  
  private RequestHandler createRoleRequestRequestHandler;
  
  public void createRoleRequest(final RequestHandler requestHandler) {
    this.createRoleRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RoleProxy> modifyRoleRequestRequestHandler;
  
  public void modifyRoleRequest(final RequestHandler1<RoleProxy> requestHandler) {
    this.modifyRoleRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RoleProxy> deleteRoleRequestRequestHandler;
  
  public void deleteRoleRequest(final RequestHandler1<RoleProxy> requestHandler) {
    this.deleteRoleRequestRequestHandler = requestHandler;
  }
}
