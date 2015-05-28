package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.StockTakingInputQuantityPresenterView;
import com.fudanmed.platform.core.web.client.warehouse.StockTakingItem4InputListGrid;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingItem;
import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.Size;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.validation.ErrorNotifierViewer;
import edu.fudan.langlab.gxt.client.widget.ContentPanel;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class StockTakingInputQuantityView extends ErrorNotifierViewer implements StockTakingInputQuantityPresenterView, IHasTitle, IHasSize {
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
  private StockTakingItem4InputListGrid listGrid;
  
  public void initialize() {
    
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
        public void apply(final VerticalLayoutContainer it) {
          ContentPanel _ContentPanel = StockTakingInputQuantityView.this.widgets.ContentPanel();
          final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
              public void apply(final ContentPanel it) {
                SGroupingGrid<UIStockTakingItem> _asWidget = StockTakingInputQuantityView.this.listGrid.asWidget();
                it.setWidget(_asWidget);
              }
            };
          ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
          VerticalLayoutData _VLayoutData = StockTakingInputQuantityView.this.widgets.VLayoutData(1, 420, 10);
          it.add(_doubleArrow, _VLayoutData);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    ClientUi.operator_add(this, _doubleArrow);
  }
  
  public Collection<UIStockTakingItem> getItems() {
    Iterable<UIStockTakingItem> _objects = this.listGrid.getObjects();
    Collection<UIStockTakingItem> _unlazy = IterableExtensions2.<UIStockTakingItem>unlazy(_objects);
    return _unlazy;
  }
  
  public HasEditorErrors mapField(final String errorKey) {
    return null;
  }
  
  public void clearErrors() {
  }
  
  public void setItems(final Collection<UIStockTakingItem> items) {
    this.listGrid.setObjects(items);
  }
  
  public Size getSize() {
    Size _size = new Size(810, 500);
    return _size;
  }
  
  public String getTitle() {
    return "\u5B9E\u76D8\u4FE1\u606F\u5F55\u5165";
  }
}
