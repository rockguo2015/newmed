package edu.fudan.langlab.client.csv;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.Size;
import edu.fudan.langlab.client.csv.ErrorItemListGrid;
import edu.fudan.langlab.client.csv.ErrorMessagePresenterView;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import edu.fudan.langlab.shared.csv.UIErrorItem;
import java.util.Collection;

public class ErrorMessageView extends GWTAbstractView implements ErrorMessagePresenterView, IHasTitle, IHasSize {
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
  
  public String getTitle() {
    return "错误信息";
  }
  
  public Size getSize() {
    return new com.uniquesoft.gwt.client.common.widgets.Size(400,300);
  }
  
  @Inject
  private ErrorItemListGrid listGrid;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    SGroupingGrid<UIErrorItem> _asWidget = this.listGrid.asWidget();
    this.con = _asWidget;
  }
  
  public void showErrorItems(final Collection<UIErrorItem> results) {
    this.listGrid.setObjects(results);
  }
}
