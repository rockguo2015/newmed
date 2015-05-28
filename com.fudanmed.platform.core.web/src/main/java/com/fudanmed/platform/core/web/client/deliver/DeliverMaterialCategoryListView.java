package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.DeliverMaterialCategoryListGrid;
import com.fudanmed.platform.core.web.client.deliver.DeliverMaterialCategoryListPresenterView;
import com.fudanmed.platform.core.web.client.tree.DeliverMaterialCategoryTreeContentProvider;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialCategory;
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

public class DeliverMaterialCategoryListView extends GWTAbstractView implements DeliverMaterialCategoryListPresenterView {
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
  private DeliverMaterialCategoryListGrid listGrid;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    SGrid<UIDeliverMaterialCategory> _asWidget = this.listGrid.asWidget();
    this.con = _asWidget;
  }
  
  public void setResults(final Collection<UIDeliverMaterialCategory> results) {
    
    DeliverMaterialCategoryTreeContentProvider _deliverMaterialCategoryTreeContentProvider = new DeliverMaterialCategoryTreeContentProvider(results);
    this.listGrid.setContentProvider(_deliverMaterialCategoryTreeContentProvider);
  }
  
  public ActionContext<UIDeliverMaterialCategory> getActionContext() {
    ActionContext<UIDeliverMaterialCategory> _createActionContext = ActionExtensions.<UIDeliverMaterialCategory>createActionContext(this.listGrid);
    return _createActionContext;
  }
  
  public void clear() {
    ArrayList<UIDeliverMaterialCategory> _newArrayList = CollectionLiterals.<UIDeliverMaterialCategory>newArrayList();
    this.listGrid.setObjects(_newArrayList);
  }
}
