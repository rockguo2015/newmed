package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMDefaultIntervalAssociationProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.device.CreatePMDefaultIntervalAssociationCommand;
import com.fudanmed.platform.core.web.client.device.DeletePMDefaultIntervalAssociationCommand;
import com.fudanmed.platform.core.web.client.device.PMDefaultIntervalAssociationListGrid;
import com.fudanmed.platform.core.web.client.device.PMDefaultIntervalAssociationListPresenterView;
import com.fudanmed.platform.core.web.client.device.UpdatePMDefaultIntervalAssociationCommand;
import com.fudanmed.platform.core.web.shared.device.UIPMDefaultIntervalAssociation;
import com.google.common.base.Function;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.ActionExtensions;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.widget.ContentPanel;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class PMDefaultIntervalAssociationListView extends GWTAbstractView implements PMDefaultIntervalAssociationListPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(listGrid,createPMDefaultIntervalAssociationCommand,updatePMDefaultIntervalAssociationCommand,deletePMDefaultIntervalAssociationCommand),
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
  private PMDefaultIntervalAssociationListGrid listGrid;
  
  @Inject
  private CreatePMDefaultIntervalAssociationCommand createPMDefaultIntervalAssociationCommand;
  
  @Inject
  private UpdatePMDefaultIntervalAssociationCommand updatePMDefaultIntervalAssociationCommand;
  
  @Inject
  private DeletePMDefaultIntervalAssociationCommand deletePMDefaultIntervalAssociationCommand;
  
  private ActionContext<RCDeviceTypeProxy> deviceTypeContext;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    ContentPanel _ContentPanel = this.widgets.ContentPanel();
    final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
        public void apply(final ContentPanel it) {
          SGroupingGrid<UIPMDefaultIntervalAssociation> _asWidget = PMDefaultIntervalAssociationListView.this.listGrid.asWidget();
          it.setWidget(_asWidget);
        }
      };
    ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
    this.con = _doubleArrow;
  }
  
  public void setActionContext(final ActionContext<RCDeviceTypeProxy> dac) {
    ActionContext<UIPMDefaultIntervalAssociation> _createActionContext = ActionExtensions.<UIPMDefaultIntervalAssociation>createActionContext(this.listGrid);
    final Function1<UIPMDefaultIntervalAssociation,RCPMDefaultIntervalAssociationProxy> _function = new Function1<UIPMDefaultIntervalAssociation,RCPMDefaultIntervalAssociationProxy>() {
        public RCPMDefaultIntervalAssociationProxy apply(final UIPMDefaultIntervalAssociation it) {
          RCPMDefaultIntervalAssociationProxy _proxy = it.toProxy();
          return _proxy;
        }
      };
    final ActionContext<RCPMDefaultIntervalAssociationProxy> ac = _createActionContext.<RCPMDefaultIntervalAssociationProxy>adapt(new Function<UIPMDefaultIntervalAssociation,RCPMDefaultIntervalAssociationProxy>() {
        public RCPMDefaultIntervalAssociationProxy apply(UIPMDefaultIntervalAssociation input) {
          return _function.apply(input);
        }
    });
    final Procedure1<ContentPanel> _function_1 = new Procedure1<ContentPanel>() {
        public void apply(final ContentPanel it) {
          it.addCommand(dac, PMDefaultIntervalAssociationListView.this.createPMDefaultIntervalAssociationCommand, "\u65B0\u5EFA");
          it.addCommand(ac, PMDefaultIntervalAssociationListView.this.updatePMDefaultIntervalAssociationCommand, "\u4FEE\u6539");
          it.addCommand(ac, PMDefaultIntervalAssociationListView.this.deletePMDefaultIntervalAssociationCommand, "\u5220\u9664");
        }
      };
    ObjectExtensions.<ContentPanel>operator_doubleArrow(((ContentPanel) this.con), _function_1);
  }
  
  public void clear() {
    ArrayList<UIPMDefaultIntervalAssociation> _newArrayList = CollectionLiterals.<UIPMDefaultIntervalAssociation>newArrayList();
    this.listGrid.setObjects(_newArrayList);
  }
  
  public void setResults(final Collection<UIPMDefaultIntervalAssociation> results) {
    
    this.listGrid.setObjects(results);
  }
  
  private RequestHandler setPMSpecRequestRequestHandler;
  
  public void setPMSpecRequest(final RequestHandler requestHandler) {
    this.setPMSpecRequestRequestHandler = requestHandler;
  }
}
