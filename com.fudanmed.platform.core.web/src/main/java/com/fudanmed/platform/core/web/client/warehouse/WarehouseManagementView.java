package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.client.warehouse.WarehouseListGrid;
import com.fudanmed.platform.core.web.client.warehouse.WarehouseManagementPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIWarehouse;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.ActionExtensions;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.action.SingleObjectActions;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.widget.ContentPanel;
import edu.fudan.langlab.gxt.client.widget.FramedPanel;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import edu.fudan.langlab.security.shared.IFunctionIdentifier;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class WarehouseManagementView extends GWTAbstractView implements WarehouseManagementPresenterView {
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
  private WarehouseListGrid listGrid;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    SGroupingGrid<UIWarehouse> _asWidget = this.listGrid.asWidget();
    this.con = _asWidget;
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u4ED3\u5E93\u4FE1\u606F\u7EF4\u62A4");
    final Procedure1<FramedPanel> _function = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          ContentPanel _ContentPanel = WarehouseManagementView.this.widgets.ContentPanel();
          final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
              public void apply(final ContentPanel it) {
                SGroupingGrid<UIWarehouse> _asWidget = WarehouseManagementView.this.listGrid.asWidget();
                it.setWidget(_asWidget);
              }
            };
          ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
          it.setWidget(_doubleArrow);
          final ActionContext<UIWarehouse> ac = ActionExtensions.<UIWarehouse>createActionContext(WarehouseManagementView.this.listGrid);
          final Procedure1<Void> _function_1 = new Procedure1<Void>() {
              public void apply(final Void v) {
                TextButton _TextButton = WarehouseManagementView.this.widgets.TextButton("\u65B0\u5EFA");
                final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                    public void apply(final TextButton it) {
                      final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                          public void apply(final SelectEvent it) {createWarehouseRequestRequestHandler.execute();
                            
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
          WarehouseManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.warehouse.WarehouseManagementPresenter.createWarehouseRequest" );
            }
          }.apply(), _function_1);
          final Procedure1<Void> _function_2 = new Procedure1<Void>() {
              public void apply(final Void v) {
                final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                    public void apply(final SingleObjectActions it) {
                      final Procedure1<UIWarehouse> _function = new Procedure1<UIWarehouse>() {
                          public void apply(final UIWarehouse wh) {
                            RCWarehouseProxy _proxy = wh.toProxy();
                            updateWarehouseRequestRequestHandler.execute(_proxy);
                            
                          }
                        };
                      it.onExecute(_function);
                    }
                  };
                SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIWarehouse>onSingleObjectAction(ac, _function);
                TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u4FEE\u6539");
                it.addButton(_asButtonRequester);
              }
            };
          WarehouseManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.warehouse.WarehouseManagementPresenter.updateWarehouseRequest" );
            }
          }.apply(), _function_2);
          final Procedure1<Void> _function_3 = new Procedure1<Void>() {
              public void apply(final Void v) {
                final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                    public void apply(final SingleObjectActions it) {
                      final Procedure1<UIWarehouse> _function = new Procedure1<UIWarehouse>() {
                          public void apply(final UIWarehouse wh) {
                            final Procedure1<Void> _function = new Procedure1<Void>() {
                                public void apply(final Void it) {
                                  RCWarehouseProxy _proxy = wh.toProxy();
                                  deleteWarehouseRequestRequestHandler.execute(_proxy);
                                  
                                }
                              };
                            ConfirmMessageBox _ConfirmMessageBox = WarehouseManagementView.this.widgets.ConfirmMessageBox("\u786E\u8BA4", "\u786E\u8BA4\u5220\u9664", _function);
                            _ConfirmMessageBox.show();
                          }
                        };
                      it.onExecute(_function);
                    }
                  };
                SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIWarehouse>onSingleObjectAction(ac, _function);
                TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u5220\u9664");
                it.addButton(_asButtonRequester);
              }
            };
          WarehouseManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.warehouse.WarehouseManagementPresenter.deleteWarehouseRequest" );
            }
          }.apply(), _function_3);
        }
      };
    FramedPanel _doubleArrow = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function);
    this.con = _doubleArrow;
  }
  
  public void setResults(final Collection<UIWarehouse> results) {
    
    this.listGrid.setObjects(results);
  }
  
  private RequestHandler createWarehouseRequestRequestHandler;
  
  public void createWarehouseRequest(final RequestHandler requestHandler) {
    this.createWarehouseRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCWarehouseProxy> updateWarehouseRequestRequestHandler;
  
  public void updateWarehouseRequest(final RequestHandler1<RCWarehouseProxy> requestHandler) {
    this.updateWarehouseRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCWarehouseProxy> deleteWarehouseRequestRequestHandler;
  
  public void deleteWarehouseRequest(final RequestHandler1<RCWarehouseProxy> requestHandler) {
    this.deleteWarehouseRequestRequestHandler = requestHandler;
  }
}
