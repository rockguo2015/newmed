package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.RepairEvaluatePropertyView;
import com.fudanmed.platform.core.web.client.project.ShowRepairEvaluatePresenterView;
import com.fudanmed.platform.core.web.shared.project.UIRepairEvaluate;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

public class ShowRepairEvaluateView extends GWTAbstractView implements ShowRepairEvaluatePresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(repairEvaluatePropertyView),
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
  private RepairEvaluatePropertyView repairEvaluatePropertyView;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _asWidget = ShowRepairEvaluateView.this.repairEvaluatePropertyView.asWidget();
          return _asWidget;
        }
      };
    Widget _lazy = ClientUi.<Widget>lazy(this.con, _function);
    this.con = _lazy;
  }
  
  public void setValue(final UIRepairEvaluate evaluate) {
    
    this.repairEvaluatePropertyView.setValue(evaluate);
  }
}
