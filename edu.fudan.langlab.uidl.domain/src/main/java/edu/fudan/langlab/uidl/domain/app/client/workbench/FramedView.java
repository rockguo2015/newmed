package edu.fudan.langlab.uidl.domain.app.client.workbench;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.Presenter;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.widget.FramedPanel;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import edu.fudan.langlab.uidl.domain.app.client.workbench.FramedPresenterView;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class FramedView extends GWTAbstractView implements FramedPresenterView {
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
  
  private Presenter contentPresenter;
  
  private String theTitle;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    FramedPanel _FramedPanel = this.widgets.FramedPanel(this.theTitle);
    final Procedure1<FramedPanel> _function = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          Viewer _view = FramedView.this.contentPresenter.getView();
          Widget _asWidget = _view.asWidget();
          it.setWidget(_asWidget);
        }
      };
    FramedPanel _doubleArrow = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function);
    this.con = _doubleArrow;
  }
  
  public void setContentPresenter(final String theTitle, final Presenter p) {
    this.contentPresenter = p;
    this.theTitle = theTitle;
  }
}
