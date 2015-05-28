package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.client.measure.MeasureDeviceListGrid;
import com.fudanmed.platform.core.web.client.measure.MeasureDeviceListPresenterView;
import com.fudanmed.platform.core.web.shared.measure.UIMeasureDevice;
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
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

public class MeasureDeviceListView extends GWTAbstractView implements MeasureDeviceListPresenterView {
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
  private MeasureDeviceListGrid listGrid;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    SGroupingGrid<UIMeasureDevice> _asWidget = this.listGrid.asWidget();
    this.con = _asWidget;
  }
  
  public void setResults(final Collection<UIMeasureDevice> results) {
    
    this.listGrid.setObjects(results);
  }
  
  public ActionContext<UIMeasureDevice> getActionContext() {
    ActionContext<UIMeasureDevice> _createActionContext = ActionExtensions.<UIMeasureDevice>createActionContext(this.listGrid);
    return _createActionContext;
  }
  
  public void clear() {
    ArrayList<UIMeasureDevice> _newArrayList = CollectionLiterals.<UIMeasureDevice>newArrayList();
    this.listGrid.setObjects(_newArrayList);
  }
}
