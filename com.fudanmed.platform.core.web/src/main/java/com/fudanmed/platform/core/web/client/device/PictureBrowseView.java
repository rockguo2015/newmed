package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.DocumentStorageSimpleListGrid;
import com.fudanmed.platform.core.web.client.device.PictureBrowsePresenterView;
import com.fudanmed.platform.core.web.client.device.ShowImagePresenter;
import com.fudanmed.platform.core.web.client.device.ShowImagePresenterView;
import com.fudanmed.platform.core.web.shared.device.UIDocumentStorage;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.ActionExtensions;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.ObjectListView.SelectEntityListener;
import com.uniquesoft.gwt.client.common.widgets.Size;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.domain.document.proxy.DocumentStorageProxy;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.widget.ContentPanel;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class PictureBrowseView extends GWTAbstractView implements PictureBrowsePresenterView, IHasSize, IHasTitle {
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
  
  public Size getSize() {
    return new com.uniquesoft.gwt.client.common.widgets.Size(600,600);
  }
  
  public String getTitle() {
    return "图片浏览";
  }
  
  private ShowImagePresenter showImagePresenter;
  
  public void setShowImagePresenter(final ShowImagePresenter showImagePresenter) {
    this.showImagePresenter = showImagePresenter;
  }
  
  @Inject
  private DocumentStorageSimpleListGrid listGrid;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    SGroupingGrid<UIDocumentStorage> _asWidget = this.listGrid.asWidget();
    final Procedure1<SGroupingGrid<UIDocumentStorage>> _function = new Procedure1<SGroupingGrid<UIDocumentStorage>>() {
        public void apply(final SGroupingGrid<UIDocumentStorage> it) {
          PictureBrowseView.this.listGrid.keepSelection();
        }
      };
    ObjectExtensions.<SGroupingGrid<UIDocumentStorage>>operator_doubleArrow(_asWidget, _function);
    ContentPanel _ContentPanel = this.widgets.ContentPanel();
    final Procedure1<ContentPanel> _function_1 = new Procedure1<ContentPanel>() {
        public void apply(final ContentPanel it) {
          VerticalLayoutContainer _VLayout = PictureBrowseView.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                SGroupingGrid<UIDocumentStorage> _asWidget = PictureBrowseView.this.listGrid.asWidget();
                VerticalLayoutData _VLayoutData = PictureBrowseView.this.widgets.VLayoutData(1, 0.3);
                it.add(_asWidget, _VLayoutData);
                ShowImagePresenterView _view = PictureBrowseView.this.showImagePresenter.getView();
                Widget _asWidget_1 = _view.asWidget();
                VerticalLayoutData _VLayoutData_1 = PictureBrowseView.this.widgets.VLayoutData(1, 0.7);
                it.add(_asWidget_1, _VLayoutData_1);
              }
            };
          VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
          it.setWidget(_doubleArrow);
        }
      };
    ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function_1);
    this.con = _doubleArrow;
    final Procedure1<UIDocumentStorage> _function_2 = new Procedure1<UIDocumentStorage>() {
        public void apply(final UIDocumentStorage g) {
          DocumentStorageProxy _proxy = g.toProxy();
          viewDocumentRequestHandler.execute(_proxy);
          
        }
      };
    this.listGrid.addSelectEntityListener(new SelectEntityListener<UIDocumentStorage>() {
        public void objectSelected(UIDocumentStorage selected) {
          _function_2.apply(selected);
        }
    });
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
