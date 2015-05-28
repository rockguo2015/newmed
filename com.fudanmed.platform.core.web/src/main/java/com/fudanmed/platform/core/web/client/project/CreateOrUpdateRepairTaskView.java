package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.common.ServerSideTimeServiceAsync;
import com.fudanmed.platform.core.web.client.organization.EmployeeSimpleListGrid;
import com.fudanmed.platform.core.web.client.organization.OnsitePositionSimpleListGrid;
import com.fudanmed.platform.core.web.client.organization.OrganizationOutlinePresenter;
import com.fudanmed.platform.core.web.client.organization.OrganizationOutlinePresenterView;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateRepairTaskPresenterView;
import com.fudanmed.platform.core.web.client.project.RepairTaskForm;
import com.fudanmed.platform.core.web.client.project.RepairTaskSimpleListGrid;
import com.fudanmed.platform.core.web.shared.organization.UIEmployee;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.ActionExtensions;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener;
import com.uniquesoft.gwt.client.common.widgets.Size;
import com.uniquesoft.gwt.shared.DateUtil;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import edu.fudan.langlab.gxt.client.component.form.FormViewerImpl;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import edu.fudan.langlab.security.client.Securities;
import java.util.Collection;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateRepairTaskView extends FormViewerImpl<UIRepairTask> implements CreateOrUpdateRepairTaskPresenterView, IHasSize, IHasTitle {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(historyTasksListGrid,positionsListGrid,workersListGrid,form),
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
  private RepairTaskForm form;
  
  public RepairTaskForm doGetFormComponent() {
    return form;
  }
  
  public Size getSize() {
    return new com.uniquesoft.gwt.client.common.widgets.Size(920,650);
  }
  
  public String getTitle() {
    return "报修单";
  }
  
  private OrganizationOutlinePresenter organizationOutlinePresenter;
  
  public void setOrganizationOutlinePresenter(final OrganizationOutlinePresenter organizationOutlinePresenter) {
    this.organizationOutlinePresenter = organizationOutlinePresenter;
  }
  
  @Inject
  private RepairTaskSimpleListGrid historyTasksListGrid;
  
  @Inject
  private OnsitePositionSimpleListGrid positionsListGrid;
  
  @Inject
  private EmployeeSimpleListGrid workersListGrid;
  
  @Inject
  private ServerSideTimeServiceAsync timeService;
  
  public void initialize() {
    
    this.historyTasksListGrid.asWidget();
    this.positionsListGrid.asWidget();
    this.positionsListGrid.keepSelection();
    this.workersListGrid.asWidget();
    this.workersListGrid.keepSelection();
    OrganizationOutlinePresenterView _view = this.organizationOutlinePresenter.getView();
    ActionContext<UIOrganization> _actionContext = _view.getActionContext();
    final Procedure1<Iterable<UIOrganization>> _function = new Procedure1<Iterable<UIOrganization>>() {
        public void apply(final Iterable<UIOrganization> it) {
          CreateOrUpdateRepairTaskView.this.form.reporterName.setValue(null);
          CreateOrUpdateRepairTaskView.this.form.reporterPhone.setValue(null);
          CreateOrUpdateRepairTaskView.this.form.location.setValue(null);
          final Procedure1<UIOrganization> _function = new Procedure1<UIOrganization>() {
              public void apply(final UIOrganization selected) {
                RCOrganizationProxy _proxy = selected.toProxy();
                CreateOrUpdateRepairTaskView.this.form.reportOrg.setValue(_proxy);
                RCOrganizationProxy _proxy_1 = selected.toProxy();
                organizationSelectedRequestHandler.execute(_proxy_1);
                
              }
            };
          IterableExtensions2.<UIOrganization>forOnlySelected(it, _function);
        }
      };
    _actionContext.addSelectionChangedListener(new SelectionChangedListener<UIOrganization>() {
        public void selectionChanged(Iterable<UIOrganization> selections) {
          _function.apply(selections);
        }
    });
    ActionContext<UIOnsitePosition> _createActionContext = ActionExtensions.<UIOnsitePosition>createActionContext(this.positionsListGrid);
    final Procedure1<Iterable<UIOnsitePosition>> _function_1 = new Procedure1<Iterable<UIOnsitePosition>>() {
        public void apply(final Iterable<UIOnsitePosition> it) {
          final Procedure1<UIOnsitePosition> _function = new Procedure1<UIOnsitePosition>() {
              public void apply(final UIOnsitePosition it) {
                RCOnsitePositionProxy _proxy = it.toProxy();
                locationSelectedRequestHandler.execute(_proxy);
                
              }
            };
          IterableExtensions2.<UIOnsitePosition>forOnlySelected(it, _function);
        }
      };
    _createActionContext.addSelectionChangedListener(new SelectionChangedListener<UIOnsitePosition>() {
        public void selectionChanged(Iterable<UIOnsitePosition> selections) {
          _function_1.apply(selections);
        }
    });
    ActionContext<UIEmployee> _createActionContext_1 = ActionExtensions.<UIEmployee>createActionContext(this.workersListGrid);
    final Procedure1<Iterable<UIEmployee>> _function_2 = new Procedure1<Iterable<UIEmployee>>() {
        public void apply(final Iterable<UIEmployee> it) {
          final Procedure1<UIEmployee> _function = new Procedure1<UIEmployee>() {
              public void apply(final UIEmployee selected) {
                RCEmployeeProxy _proxy = selected.toProxy();
                String _name = _proxy.getName();
                CreateOrUpdateRepairTaskView.this.form.reporterName.setValue(_name);
                String _workTel = selected.getWorkTel();
                CreateOrUpdateRepairTaskView.this.form.reporterPhone.setValue(_workTel);
              }
            };
          IterableExtensions2.<UIEmployee>forOnlySelected(it, _function);
        }
      };
    _createActionContext_1.addSelectionChangedListener(new SelectionChangedListener<UIEmployee>() {
        public void selectionChanged(Iterable<UIEmployee> selections) {
          _function_2.apply(selections);
        }
    });
    HorizontalLayoutContainer _HLayout = this.widgets.HLayout();
    final Procedure1<HorizontalLayoutContainer> _function_3 = new Procedure1<HorizontalLayoutContainer>() {
        public void apply(final HorizontalLayoutContainer it) {
          VerticalLayoutContainer _VLayout = CreateOrUpdateRepairTaskView.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                OrganizationOutlinePresenterView _view = CreateOrUpdateRepairTaskView.this.organizationOutlinePresenter.getView();
                Widget _asWidget = _view.asWidget();
                Widget _withFieldSet = WidgetExtensions.withFieldSet(_asWidget, "\u62A5\u4FEE\u90E8\u95E8");
                VerticalLayoutData _VLayoutData = CreateOrUpdateRepairTaskView.this.widgets.VLayoutData(1, 360);
                it.add(_withFieldSet, _VLayoutData);
                HorizontalLayoutContainer _HLayout = CreateOrUpdateRepairTaskView.this.widgets.HLayout();
                final Procedure1<HorizontalLayoutContainer> _function = new Procedure1<HorizontalLayoutContainer>() {
                    public void apply(final HorizontalLayoutContainer it) {
                      SGroupingGrid<UIOnsitePosition> _asWidget = CreateOrUpdateRepairTaskView.this.positionsListGrid.asWidget();
                      Widget _withBorder = WidgetExtensions.withBorder(_asWidget);
                      Widget _withFieldSet = WidgetExtensions.withFieldSet(_withBorder, "\u4F4D\u7F6E\u4FE1\u606F");
                      HorizontalLayoutData _HLayoutData = CreateOrUpdateRepairTaskView.this.widgets.HLayoutData(0.5, 1);
                      final Procedure1<HorizontalLayoutData> _function = new Procedure1<HorizontalLayoutData>() {
                          public void apply(final HorizontalLayoutData it) {
                            Margins _margins = new Margins(0, 1, 0, 0);
                            it.setMargins(_margins);
                          }
                        };
                      HorizontalLayoutData _doubleArrow = ObjectExtensions.<HorizontalLayoutData>operator_doubleArrow(_HLayoutData, _function);
                      it.add(_withFieldSet, _doubleArrow);
                      SGroupingGrid<UIEmployee> _asWidget_1 = CreateOrUpdateRepairTaskView.this.workersListGrid.asWidget();
                      Widget _withBorder_1 = WidgetExtensions.withBorder(_asWidget_1);
                      Widget _withFieldSet_1 = WidgetExtensions.withFieldSet(_withBorder_1, "\u62A5\u4FEE\u4EBA\u4FE1\u606F");
                      HorizontalLayoutData _HLayoutData_1 = CreateOrUpdateRepairTaskView.this.widgets.HLayoutData(0.5, 1);
                      final Procedure1<HorizontalLayoutData> _function_1 = new Procedure1<HorizontalLayoutData>() {
                          public void apply(final HorizontalLayoutData it) {
                            Margins _margins = new Margins(0, 0, 0, 1);
                            it.setMargins(_margins);
                          }
                        };
                      HorizontalLayoutData _doubleArrow_1 = ObjectExtensions.<HorizontalLayoutData>operator_doubleArrow(_HLayoutData_1, _function_1);
                      it.add(_withFieldSet_1, _doubleArrow_1);
                    }
                  };
                HorizontalLayoutContainer _doubleArrow = ObjectExtensions.<HorizontalLayoutContainer>operator_doubleArrow(_HLayout, _function);
                VerticalLayoutData _VLayoutData_1 = CreateOrUpdateRepairTaskView.this.widgets.VLayoutData(1, 1);
                it.add(_doubleArrow, _VLayoutData_1);
              }
            };
          VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
          HorizontalLayoutData _HLayoutData = CreateOrUpdateRepairTaskView.this.widgets.HLayoutData(300, 560, 2);
          it.add(_doubleArrow, _HLayoutData);
          VerticalLayoutContainer _VLayout_1 = CreateOrUpdateRepairTaskView.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function_1 = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                Widget _asWidget = CreateOrUpdateRepairTaskView.this.form.asWidget();
                final Procedure1<Widget> _function = new Procedure1<Widget>() {
                    public void apply(final Widget it) {
                      it.setWidth("600");
                      final Procedure1<Date> _function = new Procedure1<Date>() {
                          public void apply(final Date it) {
                            Date _trimDate = DateUtil.trimDate(it);
                            CreateOrUpdateRepairTaskView.this.form.reportDate.setValue(_trimDate);
                            CreateOrUpdateRepairTaskView.this.form.reportTime.setValue(it);
                            Date _trimDate_1 = DateUtil.trimDate(it);
                            CreateOrUpdateRepairTaskView.this.form.reserveDate.setValue(_trimDate_1);
                            CreateOrUpdateRepairTaskView.this.form.reserveTime.setValue(it);
                          }
                        };
                      AsyncCallback<Date> _onSuccess = CreateOrUpdateRepairTaskView.this.<Date>onSuccess(_function);
                      CreateOrUpdateRepairTaskView.this.timeService.getTime(_onSuccess);
                    }
                  };
                Widget _doubleArrow = ObjectExtensions.<Widget>operator_doubleArrow(_asWidget, _function);
                Widget _withFieldSet = WidgetExtensions.withFieldSet(_doubleArrow, "\u62A5\u4FEE\u4FE1\u606F");
                VerticalLayoutData _VLayoutData = CreateOrUpdateRepairTaskView.this.widgets.VLayoutData(1, 360);
                it.add(_withFieldSet, _VLayoutData);
                SGroupingGrid<UIRepairTask> _asWidget_1 = CreateOrUpdateRepairTaskView.this.historyTasksListGrid.asWidget();
                Widget _withBorder = WidgetExtensions.withBorder(_asWidget_1);
                Widget _withFieldSet_1 = WidgetExtensions.withFieldSet(_withBorder, "\u5386\u53F2\u62A5\u4FEE\u4FE1\u606F");
                VerticalLayoutData _VLayoutData_1 = CreateOrUpdateRepairTaskView.this.widgets.VLayoutData(1, 1);
                it.add(_withFieldSet_1, _VLayoutData_1);
              }
            };
          VerticalLayoutContainer _doubleArrow_1 = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout_1, _function_1);
          HorizontalLayoutData _HLayoutData_1 = CreateOrUpdateRepairTaskView.this.widgets.HLayoutData(600, 560, 2);
          it.add(_doubleArrow_1, _HLayoutData_1);
        }
      };
    HorizontalLayoutContainer _doubleArrow = ObjectExtensions.<HorizontalLayoutContainer>operator_doubleArrow(_HLayout, _function_3);
    ClientUi.operator_add(this, _doubleArrow);
  }
  
  public void setValue(final UIRepairTask taskReport) {
    super.setValue(taskReport);
    FieldLabel _asWidget = this.form.activeTeam.asWidget();
    _asWidget.enable();
    this.form.saveOnly.setValue(Boolean.valueOf(true));
  }
  
  public void setDefaultValues(final RCEmployeeProxy employee) {
    
    this.form.faultEmergencyLevel.selectFirst();
    this.form.faultLevel.selectFirst();
    this.form.faultReportSource.selectFirst();
  }
  
  public void showOrgRelatedInfo(final Collection<UIOnsitePosition> positions, final Collection<UIEmployee> workers, final Collection<UIRepairTask> historyTasks) {
    
    this.positionsListGrid.setObjects(positions);
    this.workersListGrid.setObjects(workers);
    this.historyTasksListGrid.setObjects(historyTasks);
  }
  
  public void setLocation(final String loc) {
    
    this.form.location.setValue(loc);
  }
  
  private RequestHandler1<RCOrganizationProxy> organizationSelectedRequestHandler;
  
  public void organizationSelected(final RequestHandler1<RCOrganizationProxy> requestHandler) {
    this.organizationSelectedRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCOnsitePositionProxy> locationSelectedRequestHandler;
  
  public void locationSelected(final RequestHandler1<RCOnsitePositionProxy> requestHandler) {
    this.locationSelectedRequestHandler = requestHandler;
  }
}
