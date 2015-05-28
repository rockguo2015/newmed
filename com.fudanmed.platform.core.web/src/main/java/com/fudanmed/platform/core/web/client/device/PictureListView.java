package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.app.resource.MedImages;
import com.fudanmed.platform.core.web.client.device.DocumentStorageListGrid;
import com.fudanmed.platform.core.web.client.device.PictureListPresenterView;
import com.fudanmed.platform.core.web.shared.device.UIDocumentStorage;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.ActionExtensions;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.domain.document.proxy.DocumentStorageProxy;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.component.grid.factory.ActionColumnValueProviderFactory.TextButtonActionColumn.GridItemSelectHandler;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class PictureListView extends GWTAbstractView implements PictureListPresenterView {
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
  private DocumentStorageListGrid listGrid;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    SGroupingGrid<UIDocumentStorage> _asWidget = this.listGrid.asWidget();
    this.con = _asWidget;
    final Procedure1<UIDocumentStorage> _function = new Procedure1<UIDocumentStorage>() {
        public void apply(final UIDocumentStorage g) {
          DocumentStorageProxy _proxy = g.toProxy();
          viewDocumentRequestHandler.execute(_proxy);
          
        }
      };
    this.listGrid.download.setSelectHandler(this.listGrid, new GridItemSelectHandler<UIDocumentStorage>() {
        public void objectSelected(UIDocumentStorage d) {
          _function.apply(d);
        }
    });
    ImageResource _viewimage = MedImages.INSTANCE.viewimage();
    this.listGrid.download.setImage(_viewimage);
  }
  
  public void setResults(final Collection<UIDocumentStorage> results) {
    
    this.listGrid.setObjects(results);
  }
  
  public ActionContext<UIDocumentStorage> getActionContext() {
    ActionContext<UIDocumentStorage> _createActionContext = ActionExtensions.<UIDocumentStorage>createActionContext(this.listGrid);
    return _createActionContext;
  }
  
  public void clear() {
    ArrayList<UIDocumentStorage> _newArrayList = CollectionLiterals.<UIDocumentStorage>newArrayList();
    this.listGrid.setObjects(_newArrayList);
  }
  
  private RequestHandler1<DocumentStorageProxy> viewDocumentRequestHandler;
  
  public void viewDocument(final RequestHandler1<DocumentStorageProxy> requestHandler) {
    this.viewDocumentRequestHandler = requestHandler;
  }
}
