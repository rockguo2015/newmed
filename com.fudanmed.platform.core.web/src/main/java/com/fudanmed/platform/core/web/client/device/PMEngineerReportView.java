package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCWorkItemPlanAssignmentProxy;
import com.fudanmed.platform.core.web.client.device.FinishWorkItemPlanAssignmentCommand;
import com.fudanmed.platform.core.web.client.device.PMEngineerReportPresenterView;
import com.fudanmed.platform.core.web.client.device.ShowWorkItemPlanAssignmentPropertyPresenterPropertyCommand;
import com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentListPresenter;
import com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentListPresenterView;
import com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignment;
import com.google.common.base.Function;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.Size;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.widget.ContentPanel;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class PMEngineerReportView extends GWTAbstractView implements PMEngineerReportPresenterView, IHasSize, IHasTitle {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(showWorkItemPlanAssignmentPropertyPresenterPropertyCommand,finishWorkItemPlanAssignmentCommand),
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
  
  public Size getSize() {
    return new com.uniquesoft.gwt.client.common.widgets.Size(800,450);
  }
  
  public String getTitle() {
    return "PM计划执行记录";
  }
  
  private WorkItemPlanAssignmentListPresenter workItemPlanAssignmentListPresenter;
  
  public void setWorkItemPlanAssignmentListPresenter(final WorkItemPlanAssignmentListPresenter workItemPlanAssignmentListPresenter) {
    this.workItemPlanAssignmentListPresenter = workItemPlanAssignmentListPresenter;
  }
  
  private Widget con;
  
  @Inject
  private ShowWorkItemPlanAssignmentPropertyPresenterPropertyCommand showWorkItemPlanAssignmentPropertyPresenterPropertyCommand;
  
  @Inject
  private FinishWorkItemPlanAssignmentCommand finishWorkItemPlanAssignmentCommand;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    WorkItemPlanAssignmentListPresenterView _view = this.workItemPlanAssignmentListPresenter.getView();
    ActionContext<UIWorkItemPlanAssignment> _actionContext = _view.getActionContext();
    final Function1<UIWorkItemPlanAssignment,RCWorkItemPlanAssignmentProxy> _function = new Function1<UIWorkItemPlanAssignment,RCWorkItemPlanAssignmentProxy>() {
        public RCWorkItemPlanAssignmentProxy apply(final UIWorkItemPlanAssignment it) {
          RCWorkItemPlanAssignmentProxy _proxy = it.toProxy();
          return _proxy;
        }
      };
    final ActionContext<RCWorkItemPlanAssignmentProxy> wiac = _actionContext.<RCWorkItemPlanAssignmentProxy>adapt(new Function<UIWorkItemPlanAssignment,RCWorkItemPlanAssignmentProxy>() {
        public RCWorkItemPlanAssignmentProxy apply(UIWorkItemPlanAssignment input) {
          return _function.apply(input);
        }
    });
    ContentPanel _ContentPanel = this.widgets.ContentPanel();
    final Procedure1<ContentPanel> _function_1 = new Procedure1<ContentPanel>() {
        public void apply(final ContentPanel it) {
          WorkItemPlanAssignmentListPresenterView _view = PMEngineerReportView.this.workItemPlanAssignmentListPresenter.getView();
          Widget _asWidget = _view.asWidget();
          it.setWidget(_asWidget);
          it.addCommand(wiac, PMEngineerReportView.this.showWorkItemPlanAssignmentPropertyPresenterPropertyCommand);
          it.addCommand(wiac, PMEngineerReportView.this.finishWorkItemPlanAssignmentCommand);
        }
      };
    ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function_1);
    this.con = _doubleArrow;
  }
}
