package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.PMWorkItemProperty;
import com.fudanmed.platform.core.web.client.device.PMWorkItemPropertyPresenterView;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItem;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.Size;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

public class PMWorkItemPropertyView extends GWTAbstractView implements PMWorkItemPropertyPresenterView, IHasTitle, IHasSize {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(propertyView),
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
    return "PM任务单详情";
  }
  
  public Size getSize() {
    return new com.uniquesoft.gwt.client.common.widgets.Size(650,200);
  }
  
  private Widget con;
  
  @Inject
  private PMWorkItemProperty propertyView;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _asWidget = PMWorkItemPropertyView.this.propertyView.asWidget();
          return _asWidget;
        }
      };
    Widget _lazy = ClientUi.<Widget>lazy(this.con, _function);
    this.con = _lazy;
  }
  
  public void setValue(final UIPMWorkItem value) {
    
    this.propertyView.setValue(value);
  }
  
  public void clear() {
    
    UIPMWorkItem _uIPMWorkItem = new UIPMWorkItem();
    this.propertyView.setValue(_uIPMWorkItem);
  }
}
