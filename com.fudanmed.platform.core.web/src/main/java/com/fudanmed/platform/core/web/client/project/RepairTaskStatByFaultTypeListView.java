package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.RepairTaskStatByFaultTypeCriteriaDataListGrid;
import com.fudanmed.platform.core.web.client.project.RepairTaskStatByFaultTypeListPresenterView;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatByFaultTypeCriteriaData;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import java.util.Collection;

public class RepairTaskStatByFaultTypeListView extends GWTAbstractView implements RepairTaskStatByFaultTypeListPresenterView {
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
  
  @Inject
  private RepairTaskStatByFaultTypeCriteriaDataListGrid listGrid;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    SGroupingGrid<UIRepairTaskStatByFaultTypeCriteriaData> _asWidget = this.listGrid.asWidget();
    this.con = _asWidget;
  }
  
  public void showResult(final Collection<UIRepairTaskStatByFaultTypeCriteriaData> results) {
    this.listGrid.setObjects(results);
  }
}
