package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.ActionExtensions;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.action.SingleObjectActions;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.component.treegrid.SGrid;
import edu.fudan.langlab.gxt.client.widget.ContentPanel;
import edu.fudan.langlab.gxt.client.widget.FramedPanel;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import edu.fudan.langlab.security.shared.IFunctionIdentifier;
import edu.fudan.langlab.uidl.domain.app.client.security.AppFunctionListGrid;
import edu.fudan.langlab.uidl.domain.app.client.security.AppRoleListGrid;
import edu.fudan.langlab.uidl.domain.app.client.security.RoleFunctionAssignmentPresenterView;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppFunction;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppRole;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class RoleFunctionAssignmentView extends GWTAbstractView implements RoleFunctionAssignmentPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(roleListGrid,appFunctionListGrid),
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
  private AppRoleListGrid roleListGrid;
  
  @Inject
  private AppFunctionListGrid appFunctionListGrid;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u7CFB\u7EDF\u529F\u80FD\u6743\u9650\u8BBE\u7F6E");
    final Procedure1<FramedPanel> _function = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          HorizontalLayoutContainer _HLayout = RoleFunctionAssignmentView.this.widgets.HLayout();
          final Procedure1<HorizontalLayoutContainer> _function = new Procedure1<HorizontalLayoutContainer>() {
              public void apply(final HorizontalLayoutContainer it) {
                SGroupingGrid<UIAppRole> _asWidget = RoleFunctionAssignmentView.this.roleListGrid.asWidget();
                HorizontalLayoutData _HLayoutData = RoleFunctionAssignmentView.this.widgets.HLayoutData(0.4, 1);
                it.add(_asWidget, _HLayoutData);
                final ActionContext<UIAppRole> ac = ActionExtensions.<UIAppRole>createActionContext(RoleFunctionAssignmentView.this.roleListGrid);
                ContentPanel _ContentPanel = RoleFunctionAssignmentView.this.widgets.ContentPanel();
                final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
                    public void apply(final ContentPanel it) {
                      SGrid<UIAppFunction> _asWidget = RoleFunctionAssignmentView.this.appFunctionListGrid.asWidget();
                      it.setWidget(_asWidget);
                      final Procedure1<Void> _function = new Procedure1<Void>() {
                          public void apply(final Void v) {
                            final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                public void apply(final SingleObjectActions it) {
                                  final Procedure1<UIAppRole> _function = new Procedure1<UIAppRole>() {
                                      public void apply(final UIAppRole role) {
                                        modifyAssignmentRequestRequestHandler.execute(role);
                                        
                                      }
                                    };
                                  it.onExecute(_function);
                                }
                              };
                            SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIAppRole>onSingleObjectAction(ac, _function);
                            TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u4FEE\u6539");
                            it.addButton(_asButtonRequester);
                          }
                        };
                      RoleFunctionAssignmentView.this.securities.check(new Function0<IFunctionIdentifier>() {
                        public IFunctionIdentifier apply() {
                          return new edu.fudan.langlab.security.shared.FunctionIdentifier( "edu.fudan.langlab.uidl.domain.app.client.security.RoleFunctionAssignmentPresenter.modifyAssignmentRequest" );
                        }
                      }.apply(), _function);
                    }
                  };
                ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
                HorizontalLayoutData _HLayoutData_1 = RoleFunctionAssignmentView.this.widgets.HLayoutData(0.6, 1);
                it.add(_doubleArrow, _HLayoutData_1);
                final Procedure1<Iterable<UIAppRole>> _function_1 = new Procedure1<Iterable<UIAppRole>>() {
                    public void apply(final Iterable<UIAppRole> roles) {
                      UIAppRole _head = IterableExtensions.<UIAppRole>head(roles);
                      showRoleFunctionsRequestRequestHandler.execute(_head);
                      
                    }
                  };
                ac.addSelectionChangedListener(new SelectionChangedListener<UIAppRole>() {
                    public void selectionChanged(Iterable<UIAppRole> selections) {
                      _function_1.apply(selections);
                    }
                });
              }
            };
          HorizontalLayoutContainer _doubleArrow = ObjectExtensions.<HorizontalLayoutContainer>operator_doubleArrow(_HLayout, _function);
          it.setWidget(_doubleArrow);
        }
      };
    FramedPanel _doubleArrow = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function);
    this.con = _doubleArrow;
  }
  
  public void showRoles(final Collection<UIAppRole> roles) {
    
    this.roleListGrid.setObjects(roles);
  }
  
  public void showFunctions(final Collection<UIAppFunction> functions) {
    
    this.appFunctionListGrid.setObjects(functions);
  }
  
  private RequestHandler1<UIAppRole> showRoleFunctionsRequestRequestHandler;
  
  public void showRoleFunctionsRequest(final RequestHandler1<UIAppRole> requestHandler) {
    this.showRoleFunctionsRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<UIAppRole> modifyAssignmentRequestRequestHandler;
  
  public void modifyAssignmentRequest(final RequestHandler1<UIAppRole> requestHandler) {
    this.modifyAssignmentRequestRequestHandler = requestHandler;
  }
}
