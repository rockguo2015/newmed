package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.common.proxy.RCFaultLevelColorAdaptorProxy;
import com.fudanmed.platform.core.web.client.organization.FaultLevelColorAdaptorListGrid;
import com.fudanmed.platform.core.web.client.organization.FaultLevelColorAdaptorListPresenterView;
import com.fudanmed.platform.core.web.shared.organization.UIFaultLevelColorAdaptor;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.ActionExtensions;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.action.SingleObjectActions;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.widget.FramedPanel;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class FaultLevelColorAdaptorListView extends GWTAbstractView implements FaultLevelColorAdaptorListPresenterView {
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
  private FaultLevelColorAdaptorListGrid listGrid;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u98CE\u9669\u7B49\u7EA7\u989C\u8272\u8BBE\u7F6E");
    final Procedure1<FramedPanel> _function = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          SGroupingGrid<UIFaultLevelColorAdaptor> _asWidget = FaultLevelColorAdaptorListView.this.listGrid.asWidget();
          it.setWidget(_asWidget);
          ActionContext<UIFaultLevelColorAdaptor> _createActionContext = ActionExtensions.<UIFaultLevelColorAdaptor>createActionContext(FaultLevelColorAdaptorListView.this.listGrid);
          final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
              public void apply(final SingleObjectActions it) {
                final Procedure1<UIFaultLevelColorAdaptor> _function = new Procedure1<UIFaultLevelColorAdaptor>() {
                    public void apply(final UIFaultLevelColorAdaptor v) {
                      RCFaultLevelColorAdaptorProxy _proxy = v.toProxy();
                      updateRequestRequestHandler.execute(_proxy);
                      
                    }
                  };
                it.onExecute(_function);
              }
            };
          SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIFaultLevelColorAdaptor>onSingleObjectAction(_createActionContext, _function);
          TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u4FEE\u6539");
          it.addButton(_asButtonRequester);
        }
      };
    FramedPanel _doubleArrow = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function);
    this.con = _doubleArrow;
  }
  
  public void setResults(final Collection<UIFaultLevelColorAdaptor> results) {
    
    this.listGrid.setObjects(results);
  }
  
  private RequestHandler1<RCFaultLevelColorAdaptorProxy> updateRequestRequestHandler;
  
  public void updateRequest(final RequestHandler1<RCFaultLevelColorAdaptorProxy> requestHandler) {
    this.updateRequestRequestHandler = requestHandler;
  }
}
