package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.WorkItemOutStockRecordDetailForm;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemOutStockRecordItemDetailPresenterView;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemStockRecordItemListGrid;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemOutStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecordItem;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldSet;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.Size;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.widget.ContentPanel;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class WorkItemOutStockRecordItemDetailView extends GWTAbstractView implements WorkItemOutStockRecordItemDetailPresenterView, IHasTitle, IHasSize {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(listGrid,detail),
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
  private WorkItemStockRecordItemListGrid listGrid;
  
  @Inject
  private WorkItemOutStockRecordDetailForm detail;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    ContentPanel _ContentPanel = this.widgets.ContentPanel();
    final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
        public void apply(final ContentPanel it) {
          it.setBorders(false);
          it.setBodyBorder(false);
          VerticalLayoutContainer _VLayout = WorkItemOutStockRecordItemDetailView.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                Widget _asWidget = WorkItemOutStockRecordItemDetailView.this.detail.asWidget();
                it.add(_asWidget);
                FieldSet _FieldSet = WorkItemOutStockRecordItemDetailView.this.widgets.FieldSet("\u9886\u6599\u660E\u7EC6");
                final Procedure1<FieldSet> _function = new Procedure1<FieldSet>() {
                    public void apply(final FieldSet it) {
                      SGroupingGrid<UIWorkItemStockRecordItem> _asWidget = WorkItemOutStockRecordItemDetailView.this.listGrid.asWidget();
                      it.setWidget(_asWidget);
                    }
                  };
                FieldSet _doubleArrow = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet, _function);
                VerticalLayoutData _VLayoutData = WorkItemOutStockRecordItemDetailView.this.widgets.VLayoutData(1, 1);
                it.add(_doubleArrow, _VLayoutData);
              }
            };
          VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
          it.setWidget(_doubleArrow);
          TextButton _TextButton = WorkItemOutStockRecordItemDetailView.this.widgets.TextButton("\u6253\u5370");
          final Procedure1<TextButton> _function_1 = new Procedure1<TextButton>() {
              public void apply(final TextButton it) {
                final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                    public void apply(final SelectEvent it) {printRequestHandler.execute();
                      
                    }
                  };
                it.addSelectHandler(new SelectHandler() {
                    public void onSelect(SelectEvent event) {
                      _function.apply(event);
                    }
                });
              }
            };
          TextButton _doubleArrow_1 = ObjectExtensions.<TextButton>operator_doubleArrow(_TextButton, _function_1);
          it.addButton(_doubleArrow_1);
        }
      };
    ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
    this.con = _doubleArrow;
  }
  
  public String getTitle() {
    return "\u9886/\u9000\u6599\u4FE1\u606F";
  }
  
  public Size getSize() {
    Size _size = new Size(800, 550);
    return _size;
  }
  
  public void setResults(final UIWorkItemOutStockRecord value, final Collection<UIWorkItemStockRecordItem> results) {
    
    this.detail.setValue(value);
    this.listGrid.setObjects(results);
  }
  
  private RequestHandler printRequestHandler;
  
  public void print(final RequestHandler requestHandler) {
    this.printRequestHandler = requestHandler;
  }
}
