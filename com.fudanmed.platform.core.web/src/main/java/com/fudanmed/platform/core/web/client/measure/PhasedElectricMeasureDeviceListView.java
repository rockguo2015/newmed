package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.client.measure.PhasedElectricMeasureDeviceListGrid;
import com.fudanmed.platform.core.web.client.measure.PhasedElectricMeasureDeviceListPresenterView;
import com.fudanmed.platform.core.web.shared.measure.UIPhasedElectricMeasureDevice;
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

public class PhasedElectricMeasureDeviceListView extends GWTAbstractView implements PhasedElectricMeasureDeviceListPresenterView {
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
  private PhasedElectricMeasureDeviceListGrid listGrid;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    SGroupingGrid<UIPhasedElectricMeasureDevice> _asWidget = this.listGrid.asWidget();
    this.con = _asWidget;
  }
  
  public void setResults(final Collection<UIPhasedElectricMeasureDevice> results) {
    
    this.listGrid.setObjects(results);
  }
  
  public ActionContext<UIPhasedElectricMeasureDevice> getActionContext() {
    ActionContext<UIPhasedElectricMeasureDevice> _createActionContext = ActionExtensions.<UIPhasedElectricMeasureDevice>createActionContext(this.listGrid);
    return _createActionContext;
  }
}
