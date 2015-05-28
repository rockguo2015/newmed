package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.PMWorkItemEvaluatePropertyView;
import com.fudanmed.platform.core.web.client.device.PMWorkItemEvaluatePropertyViewPresenterView;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemEvaluate;
import com.google.common.base.Objects;
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

public class PMWorkItemEvaluatePropertyViewView extends GWTAbstractView implements PMWorkItemEvaluatePropertyViewPresenterView, IHasSize, IHasTitle {
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
  
  private Widget con;
  
  @Inject
  private PMWorkItemEvaluatePropertyView propertyView;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _asWidget = PMWorkItemEvaluatePropertyViewView.this.propertyView.asWidget();
          return _asWidget;
        }
      };
    Widget _lazy = ClientUi.<Widget>lazy(this.con, _function);
    this.con = _lazy;
  }
  
  public Size getSize() {
    Size _size = new Size(750, 250);
    return _size;
  }
  
  public String getTitle() {
    return "\u670D\u52A1\u8BC4\u4EF7";
  }
  
  public void setValue(final UIPMWorkItemEvaluate value) {
    
    boolean _equals = Objects.equal(value, null);
    if (_equals) {
      UIPMWorkItemEvaluate _uIPMWorkItemEvaluate = new UIPMWorkItemEvaluate();
      this.propertyView.setValue(_uIPMWorkItemEvaluate);
    } else {
      this.propertyView.setValue(value);
    }
  }
}
