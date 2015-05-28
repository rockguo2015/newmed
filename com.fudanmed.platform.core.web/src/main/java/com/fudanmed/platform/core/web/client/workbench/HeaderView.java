package com.fudanmed.platform.core.web.client.workbench;

import com.fudanmed.platform.core.web.client.workbench.HeaderPresenterView;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.widget.HTMLTagsExt;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import edu.fudan.langlab.uidl.domain.app.client.login.LoginPresenter;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class HeaderView extends GWTAbstractView implements HeaderPresenterView {
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
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    FlowPanel _flowPanel = new FlowPanel();
    final Procedure1<FlowPanel> _function = new Procedure1<FlowPanel>() {
        public void apply(final FlowPanel it) {
          it.addStyleName("header");
          HTML _HTML = HTMLTagsExt.HTML(it, "<h1 class=\'logo\'><img src=\'images/logo.png\'/></h1>");
          ClientUi.operator_add(it, _HTML);
          HTML _HTML_1 = HTMLTagsExt.HTML(it, "<div class=\'top_title\'><img src=\'images/top_title.png\' /></div>");
          ClientUi.operator_add(it, _HTML_1);
          FlowPanel _DIV = HTMLTagsExt.DIV();
          final Procedure1<FlowPanel> _function = new Procedure1<FlowPanel>() {
              public void apply(final FlowPanel it) {
                it.addStyleName("top_right");
                Anchor _anchor = new Anchor();
                final Procedure1<Anchor> _function = new Procedure1<Anchor>() {
                    public void apply(final Anchor it) {
                      it.setText("\u9000\u51FA");
                      it.addStyleName("bg3");
                      it.setHref("#");
                      final Procedure1<ClickEvent> _function = new Procedure1<ClickEvent>() {
                          public void apply(final ClickEvent it) {
                            Location.reload();
                          }
                        };
                      it.addClickHandler(new ClickHandler() {
                          public void onClick(ClickEvent event) {
                            _function.apply(event);
                          }
                      });
                    }
                  };
                Anchor _doubleArrow = ObjectExtensions.<Anchor>operator_doubleArrow(_anchor, _function);
                it.add(_doubleArrow);
                String _name = LoginPresenter.user.getName();
                String _plus = ("<span>\u6B22\u8FCE" + _name);
                String _plus_1 = (_plus + "\uFF01</span>");
                HTML _HTML = HTMLTagsExt.HTML(it, _plus_1);
                ClientUi.operator_add(it, _HTML);
              }
            };
          FlowPanel _doubleArrow = ObjectExtensions.<FlowPanel>operator_doubleArrow(_DIV, _function);
          ClientUi.operator_add(it, _doubleArrow);
        }
      };
    FlowPanel _doubleArrow = ObjectExtensions.<FlowPanel>operator_doubleArrow(_flowPanel, _function);
    this.con = _doubleArrow;
  }
  
  private String appTitle;
  
  public void setApplicationTitle(final String appTitle) {
    this.appTitle = appTitle;
  }
}
