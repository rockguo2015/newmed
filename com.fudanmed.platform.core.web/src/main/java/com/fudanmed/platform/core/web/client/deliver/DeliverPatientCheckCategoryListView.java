package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckCategoryListGrid;
import com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckCategoryListPresenterView;
import com.fudanmed.platform.core.web.client.tree.DeliverPatientCheckCategoryTreeContentProvider;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckCategory;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.ActionExtensions;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.component.treegrid.SGrid;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

public class DeliverPatientCheckCategoryListView extends GWTAbstractView implements DeliverPatientCheckCategoryListPresenterView {
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
  private DeliverPatientCheckCategoryListGrid listGrid;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    SGrid<UIDeliverPatientCheckCategory> _asWidget = this.listGrid.asWidget();
    this.con = _asWidget;
  }
  
  public void setResults(final Collection<UIDeliverPatientCheckCategory> results) {
    
    DeliverPatientCheckCategoryTreeContentProvider _deliverPatientCheckCategoryTreeContentProvider = new DeliverPatientCheckCategoryTreeContentProvider(results);
    this.listGrid.setContentProvider(_deliverPatientCheckCategoryTreeContentProvider);
  }
  
  public ActionContext<UIDeliverPatientCheckCategory> getActionContext() {
    ActionContext<UIDeliverPatientCheckCategory> _createActionContext = ActionExtensions.<UIDeliverPatientCheckCategory>createActionContext(this.listGrid);
    return _createActionContext;
  }
  
  public void clear() {
    ArrayList<UIDeliverPatientCheckCategory> _newArrayList = CollectionLiterals.<UIDeliverPatientCheckCategory>newArrayList();
    this.listGrid.setObjects(_newArrayList);
  }
}
