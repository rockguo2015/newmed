package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.web.client.device.PartTypeListPresenterView;
import com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationListGrid;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.ActionExtensions;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.action.SingleObjectActions;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.widget.ContentPanel;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class PartTypeListView extends GWTAbstractView implements PartTypeListPresenterView {
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
  private ProductSpecificationListGrid listGrid;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    ContentPanel _ContentPanel = this.widgets.ContentPanel();
    final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
        public void apply(final ContentPanel it) {
          SGroupingGrid<UIProductSpecification> _asWidget = PartTypeListView.this.listGrid.asWidget();
          it.setWidget(_asWidget);
          final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
              public void apply(final SelectEvent it) {createRequestRequestHandler.execute();
                
              }
            };
          TextButton _TextButton = PartTypeListView.this.widgets.TextButton("\u6DFB\u52A0\u5907\u4EF6", _function);
          it.addButton(_TextButton);
          final ActionContext<UIProductSpecification> ac = ActionExtensions.<UIProductSpecification>createActionContext(PartTypeListView.this.listGrid);
          final Procedure1<SingleObjectActions> _function_1 = new Procedure1<SingleObjectActions>() {
              public void apply(final SingleObjectActions it) {
                final Procedure1<UIProductSpecification> _function = new Procedure1<UIProductSpecification>() {
                    public void apply(final UIProductSpecification productSpec) {
                      final Procedure1<Void> _function = new Procedure1<Void>() {
                          public void apply(final Void it) {
                            RCProductSpecificationProxy _proxy = productSpec.toProxy();
                            deleteRequestRequestHandler.execute(_proxy);
                            
                          }
                        };
                      ConfirmMessageBox _ConfirmMessageBox = PartTypeListView.this.widgets.ConfirmMessageBox("\u786E\u8BA4", "\u786E\u8BA4\u79FB\u9664\u5907\u4EF6", _function);
                      _ConfirmMessageBox.show();
                    }
                  };
                it.onExecute(_function);
              }
            };
          SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIProductSpecification>onSingleObjectAction(ac, _function_1);
          TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u79FB\u9664\u5907\u4EF6");
          it.addButton(_asButtonRequester);
        }
      };
    ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
    this.con = _doubleArrow;
  }
  
  public void setResults(final Collection<UIProductSpecification> results) {
    
    this.listGrid.setObjects(results);
  }
  
  private RequestHandler createRequestRequestHandler;
  
  public void createRequest(final RequestHandler requestHandler) {
    this.createRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCProductSpecificationProxy> deleteRequestRequestHandler;
  
  public void deleteRequest(final RequestHandler1<RCProductSpecificationProxy> requestHandler) {
    this.deleteRequestRequestHandler = requestHandler;
  }
}
