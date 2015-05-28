package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.RepairTaskStatByOrganizationTypeCriteriaDataListGrid;
import com.fudanmed.platform.core.web.client.project.RepairTaskStatByOrganizationTypeListPresenterView;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatByOrganizationTypeCriteriaData;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import java.util.Collection;

public class RepairTaskStatByOrganizationTypeListView extends GWTAbstractView implements RepairTaskStatByOrganizationTypeListPresenterView {
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
  private RepairTaskStatByOrganizationTypeCriteriaDataListGrid listGrid;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    SGroupingGrid<UIRepairTaskStatByOrganizationTypeCriteriaData> _asWidget = this.listGrid.asWidget();
    this.con = _asWidget;
  }
  
  public void showResult(final Collection<UIRepairTaskStatByOrganizationTypeCriteriaData> results) {
    this.listGrid.setObjects(results);
  }
}
