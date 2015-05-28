package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.WorkItemStorage4SettlementListGrid;
import com.fudanmed.platform.core.web.client.project.WorkItemStorage4SettlementListPresenterView;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStorage4Settlement;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.widget.ContentPanel;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class WorkItemStorage4SettlementListView extends GWTAbstractView implements WorkItemStorage4SettlementListPresenterView {
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
  private WorkItemStorage4SettlementListGrid listGrid;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    ContentPanel _ContentPanel = this.widgets.ContentPanel();
    final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
        public void apply(final ContentPanel it) {
          SGroupingGrid<UIWorkItemStorage4Settlement> _asWidget = WorkItemStorage4SettlementListView.this.listGrid.asWidget();
          it.setWidget(_asWidget);
          final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
              public void apply(final SelectEvent it) {materialExportRequestRequestHandler.execute();
                
              }
            };
          TextButton _TextButton = WorkItemStorage4SettlementListView.this.widgets.TextButton("\u5BFC\u51FA", _function);
          it.addButton(_TextButton);
        }
      };
    ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
    this.con = _doubleArrow;
  }
  
  public void setResults(final Collection<UIWorkItemStorage4Settlement> results) {
    
    this.listGrid.setObjects(results);
  }
  
  private RequestHandler materialExportRequestRequestHandler;
  
  public void materialExportRequest(final RequestHandler requestHandler) {
    this.materialExportRequestRequestHandler = requestHandler;
  }
}
