package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskProxy;
import com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTaskDispatchCommand;
import com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTaskManagementPresenterView;
import com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTaskQueryListPresenter;
import com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTaskQueryListPresenterView;
import com.fudanmed.platform.core.web.client.deliver.CreateCenterlizedDeliverTaskCommand;
import com.fudanmed.platform.core.web.client.deliver.DeliverTaskCancelDispatchCommand;
import com.fudanmed.platform.core.web.client.deliver.DeliverTaskDeleteCommand;
import com.fudanmed.platform.core.web.client.deliver.DeliverTaskDispatchCommand;
import com.fudanmed.platform.core.web.client.deliver.DeliverTaskFinishCommand;
import com.fudanmed.platform.core.web.client.deliver.PatientCheckDeliverTaskEventListPresenter;
import com.fudanmed.platform.core.web.client.deliver.PatientCheckDeliverTaskEventListPresenterView;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask;
import com.google.common.base.Function;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.widget.ContentPanel;
import edu.fudan.langlab.gxt.client.widget.FramedPanel;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.TabPanel;
import edu.fudan.langlab.security.client.Securities;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CenterlizedDeliverTaskManagementView extends GWTAbstractView implements CenterlizedDeliverTaskManagementPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(centerlizedDeliverTaskDispatchCommand,createCenterlizedDeliverTaskCommand,deliverTaskDispatchCommand,deliverTaskDeleteCommand,deliverTaskCancelDispatchCommand,deliverTaskFinishCommand),
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
  
  private CenterlizedDeliverTaskQueryListPresenter queryListPresenter;
  
  public void setQueryListPresenter(final CenterlizedDeliverTaskQueryListPresenter queryListPresenter) {
    this.queryListPresenter = queryListPresenter;
  }
  
  private PatientCheckDeliverTaskEventListPresenter patientCheckDeliverTaskEventListPresenter;
  
  public void setPatientCheckDeliverTaskEventListPresenter(final PatientCheckDeliverTaskEventListPresenter patientCheckDeliverTaskEventListPresenter) {
    this.patientCheckDeliverTaskEventListPresenter = patientCheckDeliverTaskEventListPresenter;
  }
  
  private Widget con;
  
  @Inject
  private CenterlizedDeliverTaskDispatchCommand centerlizedDeliverTaskDispatchCommand;
  
  @Inject
  private CreateCenterlizedDeliverTaskCommand createCenterlizedDeliverTaskCommand;
  
  @Inject
  private DeliverTaskDispatchCommand deliverTaskDispatchCommand;
  
  @Inject
  private DeliverTaskDeleteCommand deliverTaskDeleteCommand;
  
  @Inject
  private DeliverTaskCancelDispatchCommand deliverTaskCancelDispatchCommand;
  
  @Inject
  private DeliverTaskFinishCommand deliverTaskFinishCommand;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    CenterlizedDeliverTaskQueryListPresenterView _view = this.queryListPresenter.getView();
    final ActionContext<UICenterlizedDeliverTask> ac = _view.getActionContext();
    final Function1<UICenterlizedDeliverTask,DLCenterlizedDeliverTaskProxy> _function = new Function1<UICenterlizedDeliverTask,DLCenterlizedDeliverTaskProxy>() {
        public DLCenterlizedDeliverTaskProxy apply(final UICenterlizedDeliverTask it) {
          DLCenterlizedDeliverTaskProxy _proxy = it.toProxy();
          return _proxy;
        }
      };
    final ActionContext<DLCenterlizedDeliverTaskProxy> acProxy = ac.<DLCenterlizedDeliverTaskProxy>adapt(new Function<UICenterlizedDeliverTask,DLCenterlizedDeliverTaskProxy>() {
        public DLCenterlizedDeliverTaskProxy apply(UICenterlizedDeliverTask input) {
          return _function.apply(input);
        }
    });
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u4E2D\u592E\u8FD0\u9001\u7BA1\u7406");
    final Procedure1<FramedPanel> _function_1 = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          VerticalLayoutContainer _VLayout = CenterlizedDeliverTaskManagementView.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                ContentPanel _ContentPanel = CenterlizedDeliverTaskManagementView.this.widgets.ContentPanel();
                final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
                    public void apply(final ContentPanel it) {
                      CenterlizedDeliverTaskQueryListPresenterView _view = CenterlizedDeliverTaskManagementView.this.queryListPresenter.getView();
                      Widget _asWidget = _view.asWidget();
                      it.setWidget(_asWidget);
                      it.addSimpleCommand(CenterlizedDeliverTaskManagementView.this.createCenterlizedDeliverTaskCommand);
                      it.addCommand(ac, CenterlizedDeliverTaskManagementView.this.deliverTaskDeleteCommand);
                      it.addCommand(ac, CenterlizedDeliverTaskManagementView.this.deliverTaskCancelDispatchCommand);
                      it.addCommand(ac, CenterlizedDeliverTaskManagementView.this.deliverTaskDispatchCommand);
                      it.addCommand(ac, CenterlizedDeliverTaskManagementView.this.deliverTaskFinishCommand);
                    }
                  };
                ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
                VerticalLayoutData _VLayoutData = CenterlizedDeliverTaskManagementView.this.widgets.VLayoutData(1, 0.7);
                it.add(_doubleArrow, _VLayoutData);
                TabPanel _TabPanel = CenterlizedDeliverTaskManagementView.this.widgets.TabPanel();
                final Procedure1<TabPanel> _function_1 = new Procedure1<TabPanel>() {
                    public void apply(final TabPanel it) {
                      PatientCheckDeliverTaskEventListPresenterView _view = CenterlizedDeliverTaskManagementView.this.patientCheckDeliverTaskEventListPresenter.getView();
                      Widget _asWidget = _view.asWidget();
                      it.add(_asWidget, "\u5904\u7406\u8BB0\u5F55");
                      CenterlizedDeliverTaskManagementView.this.patientCheckDeliverTaskEventListPresenter.setContext(acProxy);
                    }
                  };
                TabPanel _doubleArrow_1 = ObjectExtensions.<TabPanel>operator_doubleArrow(_TabPanel, _function_1);
                VerticalLayoutData _VLayoutData_1 = CenterlizedDeliverTaskManagementView.this.widgets.VLayoutData(1, 0.3);
                it.add(_doubleArrow_1, _VLayoutData_1);
              }
            };
          VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
          it.setWidget(_doubleArrow);
        }
      };
    FramedPanel _doubleArrow = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function_1);
    this.con = _doubleArrow;
  }
}
