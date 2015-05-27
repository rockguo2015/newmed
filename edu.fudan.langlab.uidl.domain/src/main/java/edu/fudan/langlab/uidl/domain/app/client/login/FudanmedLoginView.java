package edu.fudan.langlab.uidl.domain.app.client.login;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.PasswordField;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.info.Info;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.RequestHandler2;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.widget.HTMLTagsExt;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import edu.fudan.langlab.uidl.domain.app.client.login.LoginPresenterView;
import edu.fudan.langlab.uidl.domain.app.client.login.UILoginForm;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class FudanmedLoginView extends GWTAbstractView implements LoginPresenterView {
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
    
    FlowPanel _DIV = HTMLTagsExt.DIV();
    final Procedure1<FlowPanel> _function = new Procedure1<FlowPanel>() {
        public void apply(final FlowPanel it) {
          it.addStyleName("login_con");
          FlowPanel _div = HTMLTagsExt.div(it);
          final Procedure1<FlowPanel> _function = new Procedure1<FlowPanel>() {
              public void apply(final FlowPanel it) {
                it.addStyleName("con_box");
                TextField _TextField = FudanmedLoginView.this.widgets.TextField();
                final Procedure1<TextField> _function = new Procedure1<TextField>() {
                    public void apply(final TextField it) {
                      it.setWidth(142);
                      it.addStyleName("input");
                      it.addStyleName("in_name");
                    }
                  };
                final TextField userName = ObjectExtensions.<TextField>operator_doubleArrow(_TextField, _function);
                ClientUi.operator_add(it, userName);
                PasswordField _PasswordField = FudanmedLoginView.this.widgets.PasswordField();
                final Procedure1<PasswordField> _function_1 = new Procedure1<PasswordField>() {
                    public void apply(final PasswordField it) {
                      it.setWidth(142);
                      it.addStyleName("input");
                      it.addStyleName("in_pass");
                    }
                  };
                final PasswordField passwd = ObjectExtensions.<PasswordField>operator_doubleArrow(_PasswordField, _function_1);
                ClientUi.operator_add(it, passwd);
                final Procedure1<SelectEvent> _function_2 = new Procedure1<SelectEvent>() {
                    public void apply(final SelectEvent it) {
                      String _value = userName.getValue();
                      
                      String _value_1 = passwd.getValue();
                      loginRequestHandler.execute(_value,_value_1);
                      
                    }
                  };
                TextButton _TextButton = FudanmedLoginView.this.widgets.TextButton("\u767B\u5F55", _function_2);
                final Procedure1<TextButton> _function_3 = new Procedure1<TextButton>() {
                    public void apply(final TextButton it) {
                      it.setWidth(80);
                      it.addStyleName("btn");
                      it.addStyleName("tj");
                    }
                  };
                TextButton _doubleArrow = ObjectExtensions.<TextButton>operator_doubleArrow(_TextButton, _function_3);
                ClientUi.operator_add(it, _doubleArrow);
                final Procedure1<SelectEvent> _function_4 = new Procedure1<SelectEvent>() {
                    public void apply(final SelectEvent it) {
                      userName.setValue("");
                      passwd.setValue("");
                    }
                  };
                TextButton _TextButton_1 = FudanmedLoginView.this.widgets.TextButton("\u53D6\u6D88", _function_4);
                final Procedure1<TextButton> _function_5 = new Procedure1<TextButton>() {
                    public void apply(final TextButton it) {
                      it.setWidth(80);
                      it.addStyleName("btn");
                      it.addStyleName("qx");
                    }
                  };
                TextButton _doubleArrow_1 = ObjectExtensions.<TextButton>operator_doubleArrow(_TextButton_1, _function_5);
                ClientUi.operator_add(it, _doubleArrow_1);
              }
            };
          ObjectExtensions.<FlowPanel>operator_doubleArrow(_div, _function);
        }
      };
    FlowPanel _doubleArrow = ObjectExtensions.<FlowPanel>operator_doubleArrow(_DIV, _function);
    this.con = _doubleArrow;
  }
  
  public void loginFailed() {
    Info.display("\u5931\u8D25", "\u7528\u6237\u540D\u6216\u5BC6\u7801\u9519\u8BEF");
  }
  
  public Widget asWidget() {
    return this.con;
  }
  
  private RequestHandler2<String,String> loginRequestHandler;
  
  public void login(final RequestHandler2<String,String> requestHandler) {
    this.loginRequestHandler = requestHandler;
  }
}
