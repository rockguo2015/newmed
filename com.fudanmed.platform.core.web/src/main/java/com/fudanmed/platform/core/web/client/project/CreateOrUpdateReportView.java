package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.common.ServerSideTimeServiceAsync;
import com.fudanmed.platform.core.web.client.organization.OnsitePositionSimpleListGrid;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateReportPresenterView;
import com.fudanmed.platform.core.web.client.project.HistoryReportContentListGrid;
import com.fudanmed.platform.core.web.client.project.RepairTaskSimpleListGrid;
import com.fudanmed.platform.core.web.client.project.ReportForm;
import com.fudanmed.platform.core.web.shared.organization.UIEmployee;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
import com.fudanmed.platform.core.web.shared.project.HistoryReportContent;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.FieldSet;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.ActionExtensions;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.ObjectListView.SelectEntityListener;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener;
import com.uniquesoft.gwt.client.common.widgets.Size;
import com.uniquesoft.gwt.shared.DateUtil;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import edu.fudan.langlab.gxt.client.component.form.Validations;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.validation.ErrorNotifierViewer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import java.util.Collection;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateReportView extends ErrorNotifierViewer implements CreateOrUpdateReportPresenterView, IHasSize, IHasTitle {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(form,historyTasksListGrid,positionsListGrid,historyReportContentListGrid),
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
  private ReportForm form;
  
  @Inject
  private RepairTaskSimpleListGrid historyTasksListGrid;
  
  @Inject
  private OnsitePositionSimpleListGrid positionsListGrid;
  
  @Inject
  private HistoryReportContentListGrid historyReportContentListGrid;
  
  @Inject
  private ServerSideTimeServiceAsync timeService;
  
  public void initialize() {
    
    this.historyTasksListGrid.asWidget();
    this.positionsListGrid.asWidget();
    final ActionContext<UIOnsitePosition> positionAc = ActionExtensions.<UIOnsitePosition>createActionContext(this.positionsListGrid);
    HorizontalLayoutContainer _HLayout = this.widgets.HLayout();
    final Procedure1<HorizontalLayoutContainer> _function = new Procedure1<HorizontalLayoutContainer>() {
        public void apply(final HorizontalLayoutContainer it) {
          VerticalLayoutContainer _VLayout = CreateOrUpdateReportView.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                FieldSet _FieldSet = CreateOrUpdateReportView.this.widgets.FieldSet("\u5386\u53F2\u62A5\u4FEE\u5185\u5BB9");
                final Procedure1<FieldSet> _function = new Procedure1<FieldSet>() {
                    public void apply(final FieldSet it) {
                      SGroupingGrid<HistoryReportContent> _asWidget = CreateOrUpdateReportView.this.historyReportContentListGrid.asWidget();
                      final Procedure1<SGroupingGrid<HistoryReportContent>> _function = new Procedure1<SGroupingGrid<HistoryReportContent>>() {
                          public void apply(final SGroupingGrid<HistoryReportContent> it) {
                            it.setHideHeaders(true);
                            final Procedure1<HistoryReportContent> _function = new Procedure1<HistoryReportContent>() {
                                public void apply(final HistoryReportContent it) {
                                  String _comment = it.getComment();
                                  CreateOrUpdateReportView.this.form.reportContentSelected(_comment);
                                }
                              };
                            CreateOrUpdateReportView.this.historyReportContentListGrid.addSelectEntityListener(new SelectEntityListener<HistoryReportContent>() {
                                public void objectSelected(HistoryReportContent selected) {
                                  _function.apply(selected);
                                }
                            });
                          }
                        };
                      SGroupingGrid<HistoryReportContent> _doubleArrow = ObjectExtensions.<SGroupingGrid<HistoryReportContent>>operator_doubleArrow(_asWidget, _function);
                      it.setWidget(_doubleArrow);
                    }
                  };
                FieldSet _doubleArrow = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet, _function);
                VerticalLayoutData _VLayoutData = CreateOrUpdateReportView.this.widgets.VLayoutData(1, 0.6);
                it.add(_doubleArrow, _VLayoutData);
                FieldSet _FieldSet_1 = CreateOrUpdateReportView.this.widgets.FieldSet("\u4F4D\u7F6E");
                final Procedure1<FieldSet> _function_1 = new Procedure1<FieldSet>() {
                    public void apply(final FieldSet it) {
                      SGroupingGrid<UIOnsitePosition> _asWidget = CreateOrUpdateReportView.this.positionsListGrid.asWidget();
                      final Procedure1<SGroupingGrid<UIOnsitePosition>> _function = new Procedure1<SGroupingGrid<UIOnsitePosition>>() {
                          public void apply(final SGroupingGrid<UIOnsitePosition> it) {
                            it.setHideHeaders(true);
                          }
                        };
                      SGroupingGrid<UIOnsitePosition> _doubleArrow = ObjectExtensions.<SGroupingGrid<UIOnsitePosition>>operator_doubleArrow(_asWidget, _function);
                      it.setWidget(_doubleArrow);
                    }
                  };
                FieldSet _doubleArrow_1 = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet_1, _function_1);
                VerticalLayoutData _VLayoutData_1 = CreateOrUpdateReportView.this.widgets.VLayoutData(1, 0.4);
                it.add(_doubleArrow_1, _VLayoutData_1);
              }
            };
          VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
          HorizontalLayoutData _HLayoutData = CreateOrUpdateReportView.this.widgets.HLayoutData(300, 500, 2);
          it.add(_doubleArrow, _HLayoutData);
          VerticalLayoutContainer _VLayout_1 = CreateOrUpdateReportView.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function_1 = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                FieldSet _FieldSet = CreateOrUpdateReportView.this.widgets.FieldSet("\u62A5\u4FEE\u4FE1\u606F");
                final Procedure1<FieldSet> _function = new Procedure1<FieldSet>() {
                    public void apply(final FieldSet it) {
                      Widget _asWidget = CreateOrUpdateReportView.this.form.asWidget();
                      final Procedure1<Widget> _function = new Procedure1<Widget>() {
                          public void apply(final Widget it) {
                            final Procedure1<Date> _function = new Procedure1<Date>() {
                                public void apply(final Date it) {
                                  Date _trimDate = DateUtil.trimDate(it);
                                  CreateOrUpdateReportView.this.form.reportDate.setValue(_trimDate);
                                  CreateOrUpdateReportView.this.form.reportTime.setValue(it);
                                  Date _trimDate_1 = DateUtil.trimDate(it);
                                  CreateOrUpdateReportView.this.form.reserveDate.setValue(_trimDate_1);
                                  CreateOrUpdateReportView.this.form.reserveTime.setValue(it);
                                }
                              };
                            AsyncCallback<Date> _onSuccess = CreateOrUpdateReportView.this.<Date>onSuccess(_function);
                            CreateOrUpdateReportView.this.timeService.getTime(_onSuccess);
                          }
                        };
                      Widget _doubleArrow = ObjectExtensions.<Widget>operator_doubleArrow(_asWidget, _function);
                      it.setWidget(_doubleArrow);
                    }
                  };
                FieldSet _doubleArrow = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet, _function);
                VerticalLayoutData _VLayoutData = CreateOrUpdateReportView.this.widgets.VLayoutData(1, 270);
                it.add(_doubleArrow, _VLayoutData);
                FieldSet _FieldSet_1 = CreateOrUpdateReportView.this.widgets.FieldSet("\u5386\u53F2\u62A5\u4FEE\u4FE1\u606F");
                final Procedure1<FieldSet> _function_1 = new Procedure1<FieldSet>() {
                    public void apply(final FieldSet it) {
                      SGroupingGrid<UIRepairTask> _asWidget = CreateOrUpdateReportView.this.historyTasksListGrid.asWidget();
                      it.setWidget(_asWidget);
                    }
                  };
                FieldSet _doubleArrow_1 = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet_1, _function_1);
                VerticalLayoutData _VLayoutData_1 = CreateOrUpdateReportView.this.widgets.VLayoutData(1, 1);
                it.add(_doubleArrow_1, _VLayoutData_1);
              }
            };
          VerticalLayoutContainer _doubleArrow_1 = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout_1, _function_1);
          HorizontalLayoutData _HLayoutData_1 = CreateOrUpdateReportView.this.widgets.HLayoutData(600, 500, 2);
          it.add(_doubleArrow_1, _HLayoutData_1);
          final Procedure1<Iterable<UIOnsitePosition>> _function_2 = new Procedure1<Iterable<UIOnsitePosition>>() {
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
          positionAc.addSelectionChangedListener(new SelectionChangedListener<UIOnsitePosition>() {
              public void selectionChanged(Iterable<UIOnsitePosition> selections) {
                _function_2.apply(selections);
              }
          });
        }
      };
    HorizontalLayoutContainer _doubleArrow = ObjectExtensions.<HorizontalLayoutContainer>operator_doubleArrow(_HLayout, _function);
    ClientUi.operator_add(this, _doubleArrow);
  }
  
  public UIRepairTask getValue() {
    UIRepairTask _value = this.form.getValue();
    return _value;
  }
  
  public HasEditorErrors mapField(final String errorKey) {
    HasEditorErrors _mapToErrorEditor = Validations.mapToErrorEditor(this.form, errorKey);
    return _mapToErrorEditor;
  }
  
  public void clearErrors() {
    Validations.clearErrors(this.form);
  }
  
  public void setValue(final UIRepairTask value) {
    this.form.setValue(value);
  }
  
  public Size getSize() {
    Size _size = new Size(920, 600);
    return _size;
  }
  
  public String getTitle() {
    return "\u6545\u969C\u62A5\u4FEE";
  }
  
  public void setReportOrg(final RCOrganizationProxy reportOrg) {
    
    this.form.reportOrg.setValue(reportOrg);
    this.form.faultEmergencyLevel.selectFirst();
  }
  
  public void setDefaultReporter(final UIEmployee reporter) {
    
    String _name = reporter.getName();
    this.form.reporterName.setValue(_name);
    String _workTel = reporter.getWorkTel();
    this.form.reporterPhone.setValue(_workTel);
  }
  
  public void showOrgRelatedInfo(final Collection<UIOnsitePosition> positions, final Collection<UIEmployee> workers, final Collection<UIRepairTask> historyTasks) {
    
    this.positionsListGrid.setObjects(positions);
    this.historyTasksListGrid.setObjects(historyTasks);
    int _size = positions.size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      UIOnsitePosition _head = IterableExtensions.<UIOnsitePosition>head(positions);
      this.positionsListGrid.select(_head);
    }
  }
  
  public void setLocation(final String loc) {
    
    this.form.location.setValue(loc);
  }
  
  public void showHistoryReportContents(final Collection<String> reportContents) {
    
    final Function1<String,HistoryReportContent> _function = new Function1<String,HistoryReportContent>() {
        public HistoryReportContent apply(final String reportContent) {
          HistoryReportContent _historyReportContent = new HistoryReportContent();
          final Procedure1<HistoryReportContent> _function = new Procedure1<HistoryReportContent>() {
              public void apply(final HistoryReportContent it) {
                it.setComment(reportContent);
              }
            };
          HistoryReportContent _doubleArrow = ObjectExtensions.<HistoryReportContent>operator_doubleArrow(_historyReportContent, _function);
          return _doubleArrow;
        }
      };
    Iterable<HistoryReportContent> _map = IterableExtensions.<String, HistoryReportContent>map(reportContents, _function);
    this.historyReportContentListGrid.setObjects(_map);
  }
  
  private RequestHandler1<RCOnsitePositionProxy> locationSelectedRequestHandler;
  
  public void locationSelected(final RequestHandler1<RCOnsitePositionProxy> requestHandler) {
    this.locationSelectedRequestHandler = requestHandler;
  }
}
