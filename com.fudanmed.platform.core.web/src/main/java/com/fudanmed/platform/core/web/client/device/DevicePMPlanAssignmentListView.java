package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.DevicePMPlanAssignmentListPresenterView;
import com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignment4DeviceListGrid;
import com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignment;
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

public class DevicePMPlanAssignmentListView extends GWTAbstractView implements DevicePMPlanAssignmentListPresenterView {
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
  private WorkItemPlanAssignment4DeviceListGrid listGrid;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    SGroupingGrid<UIWorkItemPlanAssignment> _asWidget = this.listGrid.asWidget();
    this.con = _asWidget;
  }
  
  public ActionContext<UIWorkItemPlanAssignment> getActionContext() {
    ActionContext<UIWorkItemPlanAssignment> _createActionContext = ActionExtensions.<UIWorkItemPlanAssignment>createActionContext(this.listGrid);
    return _createActionContext;
  }
  
  public void setResults(final Collection<UIWorkItemPlanAssignment> results) {
    
    this.listGrid.setObjects(results);
  }
}
