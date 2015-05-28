package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.client.measure.CreateOrUpdateWaterMeasureDevicePresenterView;
import com.fudanmed.platform.core.web.client.measure.WaterMeasureDeviceForm;
import com.fudanmed.platform.core.web.shared.measure.UIWaterMeasureDevice;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.Size;
import edu.fudan.langlab.gxt.client.component.form.FormViewerImpl;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;

public class CreateOrUpdateWaterMeasureDeviceView extends FormViewerImpl<UIWaterMeasureDevice> implements CreateOrUpdateWaterMeasureDevicePresenterView, IHasSize, IHasTitle {
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
  private WaterMeasureDeviceForm form;
  
  public WaterMeasureDeviceForm doGetFormComponent() {
    return form;
  }
  
  public Size getSize() {
    return new com.uniquesoft.gwt.client.common.widgets.Size(300,200);
  }
  
  public String getTitle() {
    return "水表信息维护";
  }
  
  public void initialize() {
    
    Widget _asWidget = this.form.asWidget();
    VerticalLayoutContainer _DialogContent = this.widgets.DialogContent(_asWidget);
    ClientUi.operator_add(this, _DialogContent);
  }
}
