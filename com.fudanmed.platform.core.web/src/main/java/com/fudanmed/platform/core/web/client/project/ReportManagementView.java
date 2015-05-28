package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.client.project.RepairTaskTreeInfoPresenter;
import com.fudanmed.platform.core.web.client.project.RepairTaskTreeInfoPresenterView;
import com.fudanmed.platform.core.web.client.project.ReportCriteriaForm;
import com.fudanmed.platform.core.web.client.project.ReportListGrid;
import com.fudanmed.platform.core.web.client.project.ReportManagementPresenterView;
import com.fudanmed.platform.core.web.shared.project.UIEvaluateState;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.fudanmed.platform.core.web.shared.project.UIReportCriteria;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.ActionExtensions;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.ObjectListView.SelectEntityListener;
import com.uniquesoft.gwt.client.common.widgets.pager.Extensions;
import com.uniquesoft.gwt.client.common.widgets.pager.IPager;
import com.uniquesoft.gwt.client.common.widgets.pager.IPager.GotoPageHandler;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.action.SingleObjectActions;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.widget.ContentPanel;
import edu.fudan.langlab.gxt.client.widget.FramedPanel;
import edu.fudan.langlab.gxt.client.widget.HTableLayoutContainer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

public class ReportManagementView extends GWTAbstractView implements ReportManagementPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(listGrid,criteriaForm),
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
  
  private RepairTaskTreeInfoPresenter repairTaskInfoPresenter;
  
  public void setRepairTaskInfoPresenter(final RepairTaskTreeInfoPresenter repairTaskInfoPresenter) {
    this.repairTaskInfoPresenter = repairTaskInfoPresenter;
  }
  
  @Inject
  private ReportListGrid listGrid;
  
  @Inject
  private ReportCriteriaForm criteriaForm;
  
  private IPager pager;
  
  private TextButton refreshButton;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    this.listGrid.asWidget();
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u79D1\u5BA4\u62A5\u4FEE\u5DE5\u4F5C\u53F0");
    final Procedure1<FramedPanel> _function = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          VerticalLayoutContainer _VLayout = ReportManagementView.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                HTableLayoutContainer _HTableLayout = ReportManagementView.this.widgets.HTableLayout();
                final Procedure1<HTableLayoutContainer> _function = new Procedure1<HTableLayoutContainer>() {
                    public void apply(final HTableLayoutContainer it) {
                      FieldLabel _asWidget = ReportManagementView.this.criteriaForm.comment.asWidget();
                      FieldLabel _asWidget_1 = ReportManagementView.this.criteriaForm.includeFinishedTask4Reporter.asWidget();
                      final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                          public void apply(final FieldLabel it) {
                            ReportManagementView.this.criteriaForm.includeFinishedTask4Reporter.setValue(Boolean.valueOf(false));
                          }
                        };
                      FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget_1, _function);
                      TextButton _TextButton = ReportManagementView.this.widgets.TextButton("\u67E5\u8BE2");
                      final Procedure1<TextButton> _function_1 = new Procedure1<TextButton>() {
                          public void apply(final TextButton it) {
                            it.setWidth("80px");
                            final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                public void apply(final SelectEvent it) {
                                  UIReportCriteria _value = ReportManagementView.this.criteriaForm.getValue();
                                  UIReportCriteria _withPagerInfo = Extensions.<UIReportCriteria>withPagerInfo(_value, ReportManagementView.this.pager);
                                  final Procedure1<UIReportCriteria> _function = new Procedure1<UIReportCriteria>() {
                                      public void apply(final UIReportCriteria it) {
                                        it.setPage(Integer.valueOf(1));
                                      }
                                    };
                                  UIReportCriteria _doubleArrow = ObjectExtensions.<UIReportCriteria>operator_doubleArrow(_withPagerInfo, _function);
                                  filterRequestRequestHandler.execute(_doubleArrow);
                                  
                                }
                              };
                            it.addSelectHandler(new SelectHandler() {
                                public void onSelect(SelectEvent event) {
                                  _function.apply(event);
                                }
                            });
                          }
                        };
                      TextButton _doubleArrow_1 = ObjectExtensions.<TextButton>operator_doubleArrow(_TextButton, _function_1);
                      TextButton _refreshButton = ReportManagementView.this.refreshButton = _doubleArrow_1;
                      ArrayList<Widget> _newArrayList = CollectionLiterals.<Widget>newArrayList(_asWidget, _doubleArrow, _refreshButton);
                      it.add(_newArrayList);
                    }
                  };
                HTableLayoutContainer _doubleArrow = ObjectExtensions.<HTableLayoutContainer>operator_doubleArrow(_HTableLayout, _function);
                it.add(_doubleArrow);
                IPager<UIRepairTask> _createPager = edu.fudan.langlab.gxt.client.pager.Extensions.<UIRepairTask>createPager(ReportManagementView.this.listGrid);
                final Procedure1<IPager<UIRepairTask>> _function_1 = new Procedure1<IPager<UIRepairTask>>() {
                    public void apply(final IPager<UIRepairTask> it) {
                      final Procedure2<Integer,Integer> _function = new Procedure2<Integer,Integer>() {
                          public void apply(final Integer pageNum, final Integer recordsPerPage) {
                            UIReportCriteria _value = ReportManagementView.this.criteriaForm.getValue();
                            UIReportCriteria _withPagerInfo = Extensions.<UIReportCriteria>withPagerInfo(_value, ReportManagementView.this.pager);
                            final Procedure1<UIReportCriteria> _function = new Procedure1<UIReportCriteria>() {
                                public void apply(final UIReportCriteria it) {
                                  it.setPage(Integer.valueOf(pageNum));
                                  it.setPageSize(Integer.valueOf(recordsPerPage));
                                }
                              };
                            UIReportCriteria _doubleArrow = ObjectExtensions.<UIReportCriteria>operator_doubleArrow(_withPagerInfo, _function);
                            filterRequestRequestHandler.execute(_doubleArrow);
                            
                          }
                        };
                      it.setPagerHandler(new GotoPageHandler() {
                          public void gotoPage(int pageNum,int recordsPerPage) {
                            _function.apply(pageNum,recordsPerPage);
                          }
                      });
                    }
                  };
                IPager<UIRepairTask> _doubleArrow_1 = ObjectExtensions.<IPager<UIRepairTask>>operator_doubleArrow(_createPager, _function_1);
                ReportManagementView.this.pager = _doubleArrow_1;
                ContentPanel _ContentPanel = ReportManagementView.this.widgets.ContentPanel();
                final Procedure1<ContentPanel> _function_2 = new Procedure1<ContentPanel>() {
                    public void apply(final ContentPanel it) {
                      ReportManagementView.this.listGrid.keepSelection();
                      VerticalLayoutContainer _VLayout = ReportManagementView.this.widgets.VLayout();
                      final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                          public void apply(final VerticalLayoutContainer it) {
                            SGroupingGrid<UIRepairTask> _asWidget = ReportManagementView.this.listGrid.asWidget();
                            VerticalLayoutData _VLayoutData = ReportManagementView.this.widgets.VLayoutData(1, 1);
                            it.add(_asWidget, _VLayoutData);
                            Widget _asWidget_1 = ReportManagementView.this.pager.asWidget();
                            int _minus = (-1);
                            VerticalLayoutData _VLayoutData_1 = ReportManagementView.this.widgets.VLayoutData(1, _minus);
                            it.add(_asWidget_1, _VLayoutData_1);
                          }
                        };
                      VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                      it.setWidget(_doubleArrow);
                      final Procedure1<UIRepairTask> _function_1 = new Procedure1<UIRepairTask>() {
                          public void apply(final UIRepairTask it) {
                            RCRepairTaskProxy _proxy = it.toProxy();
                            showRepairTaskDetailRequestRequestHandler.execute(_proxy);
                            
                          }
                        };
                      ReportManagementView.this.listGrid.addSelectEntityListener(new SelectEntityListener<UIRepairTask>() {
                          public void objectSelected(UIRepairTask selected) {
                            _function_1.apply(selected);
                          }
                      });
                      final ActionContext<UIRepairTask> ac = ActionExtensions.<UIRepairTask>createActionContext(ReportManagementView.this.listGrid);
                      TextButton _textButton = new TextButton("\u6545\u969C\u62A5\u4FEE");
                      final Procedure1<TextButton> _function_2 = new Procedure1<TextButton>() {
                          public void apply(final TextButton it) {
                            final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                public void apply(final SelectEvent it) {createRequestRequestHandler.execute();
                                  
                                }
                              };
                            it.addSelectHandler(new SelectHandler() {
                                public void onSelect(SelectEvent event) {
                                  _function.apply(event);
                                }
                            });
                          }
                        };
                      TextButton _doubleArrow_1 = ObjectExtensions.<TextButton>operator_doubleArrow(_textButton, _function_2);
                      it.addButton(_doubleArrow_1);
                      final Procedure1<SingleObjectActions> _function_3 = new Procedure1<SingleObjectActions>() {
                          public void apply(final SingleObjectActions it) {
                            final Procedure1<UIRepairTask> _function = new Procedure1<UIRepairTask>() {
                                public void apply(final UIRepairTask selectedValue) {
                                  RCRepairTaskProxy _proxy = selectedValue.toProxy();
                                  complaintRequestRequestHandler.execute(_proxy);
                                  
                                }
                              };
                            it.onExecute(_function);
                          }
                        };
                      SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIRepairTask>onSingleObjectAction(ac, _function_3);
                      TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u6295\u8BC9");
                      it.addButton(_asButtonRequester);
                      final Procedure1<SingleObjectActions> _function_4 = new Procedure1<SingleObjectActions>() {
                          public void apply(final SingleObjectActions it) {
                            final Procedure1<UIRepairTask> _function = new Procedure1<UIRepairTask>() {
                                public void apply(final UIRepairTask selectedValue) {
                                  RCRepairTaskProxy _proxy = selectedValue.toProxy();
                                  doEvaluateRequestHandler.execute(_proxy);
                                  
                                }
                              };
                            it.onExecute(_function);
                            final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                                public Boolean apply(final Void it) {
                                  final Function1<UIRepairTask,Boolean> _function = new Function1<UIRepairTask,Boolean>() {
                                      public Boolean apply(final UIRepairTask it) {
                                        UIEvaluateState _evaluateState = it.getEvaluateState();
                                        boolean _equals = Objects.equal(_evaluateState, UIEvaluateState.waiting);
                                        return Boolean.valueOf(_equals);
                                      }
                                    };
                                  Boolean _singleSelectedAnd = ActionExtensions.<UIRepairTask>singleSelectedAnd(ReportManagementView.this.listGrid, _function);
                                  return _singleSelectedAnd;
                                }
                              };
                            it.onCheckEnable(_function_1);
                          }
                        };
                      SingleObjectActions _onSingleObjectAction_1 = SingleObjectActions.<UIRepairTask>onSingleObjectAction(ac, _function_4);
                      TextButton _asButtonRequester_1 = _onSingleObjectAction_1.asButtonRequester("\u7EF4\u4FEE\u8BC4\u4EF7");
                      it.addButton(_asButtonRequester_1);
                    }
                  };
                ContentPanel _doubleArrow_2 = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function_2);
                VerticalLayoutData _VLayoutData = ReportManagementView.this.widgets.VLayoutData(1, 0.6);
                it.add(_doubleArrow_2, _VLayoutData);
                RepairTaskTreeInfoPresenterView _view = ReportManagementView.this.repairTaskInfoPresenter.getView();
                Widget _asWidget = _view.asWidget();
                VerticalLayoutData _VLayoutData_1 = ReportManagementView.this.widgets.VLayoutData(1, 0.4);
                it.add(_asWidget, _VLayoutData_1);
              }
            };
          VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
          it.setWidget(_doubleArrow);
        }
      };
    FramedPanel _doubleArrow = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function);
    this.con = _doubleArrow;
  }
  
  public void showResults(final IPagedResult<UIRepairTask> results) {
    this.pager.pageLoaded(results);
    this.refreshButton.setHTML("\u67E5\u8BE2");
  }
  
  public void refresh() {
    int _activePage = this.pager.getActivePage();
    this.pager.gotoPage(_activePage);
  }
  
  public void markAsDirty() {
    this.refreshButton.setHTML("<font color=\'red\'>\u8BF7\u5237\u65B0</font>");
  }
  
  private RequestHandler createRequestRequestHandler;
  
  public void createRequest(final RequestHandler requestHandler) {
    this.createRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCRepairTaskProxy> complaintRequestRequestHandler;
  
  public void complaintRequest(final RequestHandler1<RCRepairTaskProxy> requestHandler) {
    this.complaintRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCRepairTaskProxy> doEvaluateRequestHandler;
  
  public void doEvaluate(final RequestHandler1<RCRepairTaskProxy> requestHandler) {
    this.doEvaluateRequestHandler = requestHandler;
  }
  
  private RequestHandler1<UIReportCriteria> filterRequestRequestHandler;
  
  public void filterRequest(final RequestHandler1<UIReportCriteria> requestHandler) {
    this.filterRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCRepairTaskProxy> showRepairTaskDetailRequestRequestHandler;
  
  public void showRepairTaskDetailRequest(final RequestHandler1<RCRepairTaskProxy> requestHandler) {
    this.showRepairTaskDetailRequestRequestHandler = requestHandler;
  }
}
