package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.client.organization.CreateOrUpdateFaultLevelColorAdaptorPresenterView;
import com.fudanmed.platform.core.web.client.organization.FaultLevelColorAdaptorForm;
import com.fudanmed.platform.core.web.shared.organization.UIFaultLevelColorAdaptor;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.Size;
import edu.fudan.langlab.gxt.client.component.form.FormViewerImpl;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;

public class CreateOrUpdateFaultLevelColorAdaptorView extends FormViewerImpl<UIFaultLevelColorAdaptor> implements CreateOrUpdateFaultLevelColorAdaptorPresenterView, IHasSize, IHasTitle {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(form),
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
  private FaultLevelColorAdaptorForm form;
  
  public FaultLevelColorAdaptorForm doGetFormComponent() {
    return form;
  }
  
  public Size getSize() {
    return new com.uniquesoft.gwt.client.common.widgets.Size(300,200);
  }
  
  public String getTitle() {
    return "风险等级颜色设置";
  }
  
  public void initialize() {
    
    Widget _asWidget = this.form.asWidget();
    ClientUi.operator_add(this, _asWidget);
  }
}
