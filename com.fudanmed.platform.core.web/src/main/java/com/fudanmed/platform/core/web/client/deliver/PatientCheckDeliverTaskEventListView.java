package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.PatientCheckDeliverTaskEventListGrid;
import com.fudanmed.platform.core.web.client.deliver.PatientCheckDeliverTaskEventListPresenterView;
import com.fudanmed.platform.core.web.shared.deliver.UIPatientCheckDeliverTaskEvent;
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

public class PatientCheckDeliverTaskEventListView extends GWTAbstractView implements PatientCheckDeliverTaskEventListPresenterView {
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
  private PatientCheckDeliverTaskEventListGrid listGrid;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    SGroupingGrid<UIPatientCheckDeliverTaskEvent> _asWidget = this.listGrid.asWidget();
    this.con = _asWidget;
  }
  
  public void setResults(final Collection<UIPatientCheckDeliverTaskEvent> results) {
    
    this.listGrid.setObjects(results);
  }
  
  public ActionContext<UIPatientCheckDeliverTaskEvent> getActionContext() {
    ActionContext<UIPatientCheckDeliverTaskEvent> _createActionContext = ActionExtensions.<UIPatientCheckDeliverTaskEvent>createActionContext(this.listGrid);
    return _createActionContext;
  }
  
  public void clear() {
    ArrayList<UIPatientCheckDeliverTaskEvent> _newArrayList = CollectionLiterals.<UIPatientCheckDeliverTaskEvent>newArrayList();
    this.listGrid.setObjects(_newArrayList);
  }
}
