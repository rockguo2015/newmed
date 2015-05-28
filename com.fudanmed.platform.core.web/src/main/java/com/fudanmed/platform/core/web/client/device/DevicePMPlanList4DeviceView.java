package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.DevicePMPlan4DeviceInfoListGrid;
import com.fudanmed.platform.core.web.client.device.DevicePMPlanList4DevicePresenterView;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlan;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DevicePMPlanList4DeviceView extends GWTAbstractView implements DevicePMPlanList4DevicePresenterView {
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
  private DevicePMPlan4DeviceInfoListGrid listGrid;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    SGroupingGrid<UIDevicePMPlan> _asWidget = this.listGrid.asWidget();
    final Procedure1<SGroupingGrid<UIDevicePMPlan>> _function = new Procedure1<SGroupingGrid<UIDevicePMPlan>>() {
        public void apply(final SGroupingGrid<UIDevicePMPlan> it) {
          it.groupBy(DevicePMPlanList4DeviceView.this.listGrid.pmType, false);
        }
      };
    SGroupingGrid<UIDevicePMPlan> _doubleArrow = ObjectExtensions.<SGroupingGrid<UIDevicePMPlan>>operator_doubleArrow(_asWidget, _function);
    this.con = _doubleArrow;
  }
  
  public void setResults(final Collection<UIDevicePMPlan> results) {
    
    this.listGrid.setObjects(results);
  }
}
