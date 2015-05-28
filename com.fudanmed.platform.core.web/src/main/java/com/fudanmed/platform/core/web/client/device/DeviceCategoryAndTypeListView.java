package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.DeviceCategoryAndTypeListPresenterView;
import com.fudanmed.platform.core.web.client.device.UIDeviceCategoryAndTypeList;
import com.fudanmed.platform.core.web.client.tree.DeviceCategoryOrTypeTreeContentProvider;
import com.fudanmed.platform.core.web.shared.device.UIDeviceCategoryAndType;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.ActionExtensions;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.component.treegrid.SGrid;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DeviceCategoryAndTypeListView extends GWTAbstractView implements DeviceCategoryAndTypeListPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(categoryListGrid),
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
  private UIDeviceCategoryAndTypeList categoryListGrid;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    SGrid<UIDeviceCategoryAndType> _asWidget = this.categoryListGrid.asWidget();
    this.con = _asWidget;
    ActionContext<UIDeviceCategoryAndType> _createActionContext = ActionExtensions.<UIDeviceCategoryAndType>createActionContext(this.categoryListGrid);
    final Procedure1<Iterable<UIDeviceCategoryAndType>> _function = new Procedure1<Iterable<UIDeviceCategoryAndType>>() {
        public void apply(final Iterable<UIDeviceCategoryAndType> it) {
          UIDeviceCategoryAndType _head = IterableExtensions.<UIDeviceCategoryAndType>head(it);
          deviceCategoryOrTypeSelectedRequestHandler.execute(_head);
          
        }
      };
    _createActionContext.addSelectionChangedListener(new SelectionChangedListener<UIDeviceCategoryAndType>() {
        public void selectionChanged(Iterable<UIDeviceCategoryAndType> selections) {
          _function.apply(selections);
        }
    });
  }
  
  public void showCategories(final Collection<UIDeviceCategoryAndType> results) {
    
    DeviceCategoryOrTypeTreeContentProvider _deviceCategoryOrTypeTreeContentProvider = new DeviceCategoryOrTypeTreeContentProvider(results);
    this.categoryListGrid.setContentProvider(_deviceCategoryOrTypeTreeContentProvider);
  }
  
  public ActionContext<UIDeviceCategoryAndType> getActionContext() {
    ActionContext<UIDeviceCategoryAndType> _createActionContext = ActionExtensions.<UIDeviceCategoryAndType>createActionContext(this.categoryListGrid);
    return _createActionContext;
  }
  
  private RequestHandler1<UIDeviceCategoryAndType> deviceCategoryOrTypeSelectedRequestHandler;
  
  public void deviceCategoryOrTypeSelected(final RequestHandler1<UIDeviceCategoryAndType> requestHandler) {
    this.deviceCategoryOrTypeSelectedRequestHandler = requestHandler;
  }
}
