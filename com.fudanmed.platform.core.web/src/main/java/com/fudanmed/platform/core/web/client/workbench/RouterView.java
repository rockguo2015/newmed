package com.fudanmed.platform.core.web.client.workbench;

import com.fudanmed.platform.core.web.client.workbench.RouterPresenterView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.widget.HTMLTagsExt;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class RouterView extends GWTAbstractView implements RouterPresenterView {
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
  
  public Widget asWidget() {
    FlowPanel _DIV = HTMLTagsExt.DIV();
    final Procedure1<FlowPanel> _function = new Procedure1<FlowPanel>() {
        public void apply(final FlowPanel it) {
          it.addStyleName("right_content");
        }
      };
    FlowPanel _doubleArrow = ObjectExtensions.<FlowPanel>operator_doubleArrow(_DIV, _function);
    return _doubleArrow;
  }
  
  public void initialize() {
    
  }
}
