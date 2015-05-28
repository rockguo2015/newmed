package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.PMWorkItemWorkerAssignmentListGrid;
import com.fudanmed.platform.core.web.client.device.PMWorkItemWorkerAssignmentListPresenterView;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignment;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.ActionExtensions;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import java.util.Collection;

public class PMWorkItemWorkerAssignmentListView extends GWTAbstractView implements PMWorkItemWorkerAssignmentListPresenterView {
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
  private PMWorkItemWorkerAssignmentListGrid listGrid;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    SGroupingGrid<UIPMWorkItemWorkerAssignment> _asWidget = this.listGrid.asWidget();
    this.con = _asWidget;
  }
  
  public ActionContext<UIPMWorkItemWorkerAssignment> getActionContext() {
    ActionContext<UIPMWorkItemWorkerAssignment> _createActionContext = ActionExtensions.<UIPMWorkItemWorkerAssignment>createActionContext(this.listGrid);
    return _createActionContext;
  }
  
  public void setResults(final Collection<UIPMWorkItemWorkerAssignment> results) {
    
    this.listGrid.setObjects(results);
  }
}
