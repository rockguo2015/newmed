package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.client.organization.OnsiteLocationOutlinePresenter;
import com.fudanmed.platform.core.web.client.organization.OnsiteLocationOutlinePresenterView;
import com.fudanmed.platform.core.web.client.organization.OnsitePositionManagementPresenterView;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
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
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.extensions.ObjectSelectionProviders;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.action.SingleObjectActions;
import edu.fudan.langlab.gxt.client.widget.FramedPanel;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import edu.fudan.langlab.security.shared.IFunctionIdentifier;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class OnsitePositionManagementView extends GWTAbstractView implements OnsitePositionManagementPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    initialize();
    postInitialize.initializeFinished(null);
    
  }
  
  @Inject
  private Securities securities;
  
  @Inject
  private EventBus eventBus;
  
  private OnsiteLocationOutlinePresenter onsiteLocationOutlinePresenter;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u533A\u57DF\u4F4D\u7F6E\u7EF4\u62A4");
    final Procedure1<FramedPanel> _function = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          OnsiteLocationOutlinePresenterView _view = OnsitePositionManagementView.this.onsiteLocationOutlinePresenter.getView();
          Widget _asWidget = _view.asWidget();
          it.setWidget(_asWidget);
          OnsiteLocationOutlinePresenterView _view_1 = OnsitePositionManagementView.this.onsiteLocationOutlinePresenter.getView();
          final ActionContext<UIOnsitePosition> ac = _view_1.getActionContext();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void v) {
                TextButton _TextButton = OnsitePositionManagementView.this.widgets.TextButton("\u65B0\u5EFA");
                final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                    public void apply(final TextButton it) {
                      final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                          public void apply(final SelectEvent it) {
                            final UIOnsitePosition possibleParent = ObjectSelectionProviders.<UIOnsitePosition>getOnlySelected(ac);
                            RCOnsitePositionProxy _proxy = possibleParent==null?(RCOnsitePositionProxy)null:possibleParent.toProxy();
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
          OnsitePositionManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.organization.OnsitePositionManagementPresenter.createRequest" );
            }
          }.apply(), _function);
          final Procedure1<Void> _function_1 = new Procedure1<Void>() {
              public void apply(final Void v) {
                TextButton _TextButton = OnsitePositionManagementView.this.widgets.TextButton("\u5BFC\u5165");
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
                TextButton _doubleArrow = ObjectExtensions.<TextButton>operator_doubleArrow(_TextButton, _function);
                it.addButton(_doubleArrow);
              }
            };
          OnsitePositionManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.organization.OnsitePositionManagementPresenter.importRequest" );
            }
          }.apply(), _function_1);
          final Procedure1<Void> _function_2 = new Procedure1<Void>() {
              public void apply(final Void v) {
                final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                    public void apply(final SingleObjectActions it) {
                      final Procedure1<UIOnsitePosition> _function = new Procedure1<UIOnsitePosition>() {
                          public void apply(final UIOnsitePosition selectedValue) {
                            RCOnsitePositionProxy _proxy = selectedValue.toProxy();
                            modifyRequestRequestHandler.execute(_proxy);
                            
                          }
                        };
                      it.onExecute(_function);
                    }
                  };
                SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIOnsitePosition>onSingleObjectAction(ac, _function);
                TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u4FEE\u6539");
                it.addButton(_asButtonRequester);
              }
            };
          OnsitePositionManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.organization.OnsitePositionManagementPresenter.modifyRequest" );
            }
          }.apply(), _function_2);
          final Procedure1<Void> _function_3 = new Procedure1<Void>() {
              public void apply(final Void v) {
                final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                    public void apply(final SingleObjectActions it) {
                      final Procedure1<UIOnsitePosition> _function = new Procedure1<UIOnsitePosition>() {
                          public void apply(final UIOnsitePosition selectedValue) {
                            final Procedure1<Void> _function = new Procedure1<Void>() {
                                public void apply(final Void it) {
                                  RCOnsitePositionProxy _proxy = selectedValue.toProxy();
                                  deleteRequestRequestHandler.execute(_proxy);
                                  
                                }
                              };
                            ConfirmMessageBox _ConfirmMessageBox = OnsitePositionManagementView.this.widgets.ConfirmMessageBox("\u786E\u8BA4", "\u786E\u8BA4\u5220\u9664", _function);
                            _ConfirmMessageBox.show();
                          }
                        };
                      it.onExecute(_function);
                    }
                  };
                SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIOnsitePosition>onSingleObjectAction(ac, _function);
                TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u5220\u9664");
                it.addButton(_asButtonRequester);
              }
            };
          OnsitePositionManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.organization.OnsitePositionManagementPresenter.deleteRequest" );
            }
          }.apply(), _function_3);
        }
      };
    FramedPanel _doubleArrow = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function);
    this.con = _doubleArrow;
  }
  
  public void setOnsiteLocationOutlinePresenter(final OnsiteLocationOutlinePresenter onsiteLocationOutlinePresenter) {
    this.onsiteLocationOutlinePresenter = onsiteLocationOutlinePresenter;
  }
  
  private RequestHandler1<RCOnsitePositionProxy> createRequestRequestHandler;
  
  public void createRequest(final RequestHandler1<RCOnsitePositionProxy> requestHandler) {
    this.createRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler importRequestRequestHandler;
  
  public void importRequest(final RequestHandler requestHandler) {
    this.importRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCOnsitePositionProxy> deleteRequestRequestHandler;
  
  public void deleteRequest(final RequestHandler1<RCOnsitePositionProxy> requestHandler) {
    this.deleteRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCOnsitePositionProxy> modifyRequestRequestHandler;
  
  public void modifyRequest(final RequestHandler1<RCOnsitePositionProxy> requestHandler) {
    this.modifyRequestRequestHandler = requestHandler;
  }
}
