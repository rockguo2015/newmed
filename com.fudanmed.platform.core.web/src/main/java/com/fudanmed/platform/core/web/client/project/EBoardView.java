package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.EBoardPresenterView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class EBoardView extends GWTAbstractView implements EBoardPresenterView {
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
  
  private HTML con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    HTML _hTML = new HTML();
    final Procedure1<HTML> _function = new Procedure1<HTML>() {
        public void apply(final HTML it) {
        }
      };
    HTML _doubleArrow = ObjectExtensions.<HTML>operator_doubleArrow(_hTML, _function);
    this.con = _doubleArrow;
  }
  
  public void showResults(final String html) {
    this.con.setHTML(html);
  }
}
