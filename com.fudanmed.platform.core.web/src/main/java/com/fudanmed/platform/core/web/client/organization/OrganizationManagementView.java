package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.OrganizationListGrid;
import com.fudanmed.platform.core.web.client.organization.OrganizationManagementPresenterView;
import com.fudanmed.platform.core.web.client.organization.OrganizationOutlinePresenter;
import com.fudanmed.platform.core.web.client.organization.OrganizationOutlinePresenterView;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
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

public class OrganizationManagementView extends GWTAbstractView implements OrganizationManagementPresenterView {
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
  
  @Inject
  private OrganizationListGrid listGrid;
  
  private OrganizationOutlinePresenter organizationOutlinePresenter;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    this.listGrid.asWidget();
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u7EC4\u7EC7\u673A\u6784\u7EF4\u62A4");
    final Procedure1<FramedPanel> _function = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          OrganizationOutlinePresenterView _view = OrganizationManagementView.this.organizationOutlinePresenter.getView();
          Widget _asWidget = _view.asWidget();
          it.setWidget(_asWidget);
          OrganizationOutlinePresenterView _view_1 = OrganizationManagementView.this.organizationOutlinePresenter.getView();
          final ActionContext<UIOrganization> ac = _view_1.getActionContext();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void v) {
                TextButton _TextButton = OrganizationManagementView.this.widgets.TextButton("\u65B0\u5EFA");
                final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                    public void apply(final TextButton it) {
                      final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                          public void apply(final SelectEvent it) {
                            final UIOrganization possibleParent = ObjectSelectionProviders.<UIOrganization>getOnlySelected(ac);
                            RCOrganizationProxy _proxy = possibleParent==null?(RCOrganizationProxy)null:possibleParent.toProxy();
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
          OrganizationManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.organization.OrganizationManagementPresenter.createRequest" );
            }
          }.apply(), _function);
          final Procedure1<Void> _function_1 = new Procedure1<Void>() {
              public void apply(final Void v) {
                TextButton _TextButton = OrganizationManagementView.this.widgets.TextButton("\u5BFC\u5165");
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
          OrganizationManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.organization.OrganizationManagementPresenter.importRequest" );
            }
          }.apply(), _function_1);
          final Procedure1<Void> _function_2 = new Procedure1<Void>() {
              public void apply(final Void v) {
                final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                    public void apply(final SingleObjectActions it) {
                      final Procedure1<UIOrganization> _function = new Procedure1<UIOrganization>() {
                          public void apply(final UIOrganization selectedValue) {
                            RCOrganizationProxy _proxy = selectedValue.toProxy();
                            modifyRequestRequestHandler.execute(_proxy);
                            
                          }
                        };
                      it.onExecute(_function);
                    }
                  };
                SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIOrganization>onSingleObjectAction(ac, _function);
                TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u4FEE\u6539");
                it.addButton(_asButtonRequester);
              }
            };
          OrganizationManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.organization.OrganizationManagementPresenter.modifyRequest" );
            }
          }.apply(), _function_2);
          final Procedure1<Void> _function_3 = new Procedure1<Void>() {
              public void apply(final Void v) {
                final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                    public void apply(final SingleObjectActions it) {
                      final Procedure1<UIOrganization> _function = new Procedure1<UIOrganization>() {
                          public void apply(final UIOrganization selectedValue) {
                            final Procedure1<Void> _function = new Procedure1<Void>() {
                                public void apply(final Void it) {
                                  RCOrganizationProxy _proxy = selectedValue.toProxy();
                                  deleteRequestRequestHandler.execute(_proxy);
                                  
                                }
                              };
                            ConfirmMessageBox _ConfirmMessageBox = OrganizationManagementView.this.widgets.ConfirmMessageBox("\u786E\u8BA4", "\u786E\u8BA4\u5220\u9664", _function);
                            _ConfirmMessageBox.show();
                          }
                        };
                      it.onExecute(_function);
                    }
                  };
                SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIOrganization>onSingleObjectAction(ac, _function);
                TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u5220\u9664");
                it.addButton(_asButtonRequester);
              }
            };
          OrganizationManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.organization.OrganizationManagementPresenter.deleteRequest" );
            }
          }.apply(), _function_3);
        }
      };
    FramedPanel _doubleArrow = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function);
    this.con = _doubleArrow;
  }
  
  public void setOrganizationOutlinePresenter(final OrganizationOutlinePresenter organizationOutlinePresenter) {
    
    this.organizationOutlinePresenter = organizationOutlinePresenter;
  }
  
  private RequestHandler1<RCOrganizationProxy> createRequestRequestHandler;
  
  public void createRequest(final RequestHandler1<RCOrganizationProxy> requestHandler) {
    this.createRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler importRequestRequestHandler;
  
  public void importRequest(final RequestHandler requestHandler) {
    this.importRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCOrganizationProxy> deleteRequestRequestHandler;
  
  public void deleteRequest(final RequestHandler1<RCOrganizationProxy> requestHandler) {
    this.deleteRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCOrganizationProxy> modifyRequestRequestHandler;
  
  public void modifyRequest(final RequestHandler1<RCOrganizationProxy> requestHandler) {
    this.modifyRequestRequestHandler = requestHandler;
  }
}
