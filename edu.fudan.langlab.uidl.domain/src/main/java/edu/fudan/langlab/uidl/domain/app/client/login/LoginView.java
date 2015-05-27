package edu.fudan.langlab.uidl.domain.app.client.login;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.CenterLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.RequestHandler2;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.widget.HTMLTagsExt;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTD;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTR;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTable;
import edu.fudan.langlab.security.client.Securities;
import edu.fudan.langlab.uidl.domain.app.client.login.LoginPresenterView;
import edu.fudan.langlab.uidl.domain.app.client.login.UILoginForm;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class LoginView extends GWTAbstractView implements LoginPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(loginForm),
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
  private UILoginForm loginForm;
  
  private Widget con;
  
  private Label message1;
  
  public void initialize() {
    
    PlainHTMLTable _TABLE = HTMLTagsExt.TABLE();
    final Procedure1<PlainHTMLTable> _function = new Procedure1<PlainHTMLTable>() {
        public void apply(final PlainHTMLTable it) {
          it.setWidth("100%");
          PlainHTMLTR _tr = HTMLTagsExt.tr(it);
          final Procedure1<PlainHTMLTR> _function = new Procedure1<PlainHTMLTR>() {
              public void apply(final PlainHTMLTR it) {
                it.setHeight("150");
              }
            };
          ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr, _function);
          PlainHTMLTR _tr_1 = HTMLTagsExt.tr(it);
          final Procedure1<PlainHTMLTR> _function_1 = new Procedure1<PlainHTMLTR>() {
              public void apply(final PlainHTMLTR it) {
                PlainHTMLTD _td = HTMLTagsExt.td(it);
                final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      CenterLayoutContainer _centerLayoutContainer = new CenterLayoutContainer();
                      final Procedure1<CenterLayoutContainer> _function = new Procedure1<CenterLayoutContainer>() {
                          public void apply(final CenterLayoutContainer it) {
                            VerticalLayoutContainer _VLayout = LoginView.this.widgets.VLayout();
                            final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                                public void apply(final VerticalLayoutContainer it) {
                                  FieldLabel _asWidget = LoginView.this.loginForm.userid.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                  FieldLabel _asWidget_1 = LoginView.this.loginForm.passwd.asWidget();
                                  ClientUi.operator_add(it, _asWidget_1);
                                  TextButton _TextButton = LoginView.this.widgets.TextButton("Login");
                                  final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                                      public void apply(final TextButton it) {
                                        final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                            public void apply(final SelectEvent it) {
                                              LoginView.this.message1.setText("");
                                              String _value = LoginView.this.loginForm.userid.getValue();
                                              
                                              String _value_1 = LoginView.this.loginForm.passwd.getValue();
                                              loginRequestHandler.execute(_value,_value_1);
                                              
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
                                  ClientUi.operator_add(it, _doubleArrow);
                                  Label _Label = LoginView.this.widgets.Label("");
                                  Label _message1 = LoginView.this.message1 = _Label;
                                  ClientUi.operator_add(it, _message1);
                                }
                              };
                            VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                            ClientUi.operator_add(it, _doubleArrow);
                          }
                        };
                      CenterLayoutContainer _doubleArrow = ObjectExtensions.<CenterLayoutContainer>operator_doubleArrow(_centerLayoutContainer, _function);
                      ClientUi.operator_add(it, _doubleArrow);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
              }
            };
          ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_1, _function_1);
        }
      };
    PlainHTMLTable _doubleArrow = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE, _function);
    this.con = _doubleArrow;
  }
  
  public void loginFailed() {
    this.message1.setText("\u7528\u6237\u540D\u6216\u5BC6\u7801\u9519\u8BEF");
  }
  
  public Widget asWidget() {
    return this.con;
  }
  
  private RequestHandler2<String,String> loginRequestHandler;
  
  public void login(final RequestHandler2<String,String> requestHandler) {
    this.loginRequestHandler = requestHandler;
  }
}
