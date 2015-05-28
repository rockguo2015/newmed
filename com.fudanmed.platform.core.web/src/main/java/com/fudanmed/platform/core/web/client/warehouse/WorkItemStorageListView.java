package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.WorkItemStorageListGrid;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemStorageListPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStorage;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.Size;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import java.util.Collection;

public class WorkItemStorageListView extends GWTAbstractView implements WorkItemStorageListPresenterView, IHasTitle, IHasSize {
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
  private WorkItemStorageListGrid listGrid;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    SGroupingGrid<UIWorkItemStorage> _asWidget = this.listGrid.asWidget();
    this.con = _asWidget;
  }
  
  public String getTitle() {
    return "\u7269\u54C1\u4FE1\u606F";
  }
  
  public Size getSize() {
    Size _size = new Size(600, 450);
    return _size;
  }
  
  public void setResults(final Collection<UIWorkItemStorage> results) {
    
    this.listGrid.setObjects(results);
  }
}
