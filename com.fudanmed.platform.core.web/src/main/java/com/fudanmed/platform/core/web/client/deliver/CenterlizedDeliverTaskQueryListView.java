package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTaskCriteriaForm;
import com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTaskListGrid;
import com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTaskQueryListPresenterView;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTaskCriteria;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.ActionExtensions;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.pager.Extensions;
import com.uniquesoft.gwt.client.common.widgets.pager.IPager;
import com.uniquesoft.gwt.client.common.widgets.pager.IPager.GotoPageHandler;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.widget.HTMLTagsExt;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTD;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTR;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTable;
import edu.fudan.langlab.security.client.Securities;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

public class CenterlizedDeliverTaskQueryListView extends GWTAbstractView implements CenterlizedDeliverTaskQueryListPresenterView {
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
  
  @Inject
  private CenterlizedDeliverTaskListGrid listGrid;
  
  @Inject
  private CenterlizedDeliverTaskCriteriaForm criteriaForm;
  
  private IPager pager;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    this.listGrid.asMultiSelectGrid();
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
        public void apply(final VerticalLayoutContainer it) {
          PlainHTMLTable _TABLE = HTMLTagsExt.TABLE();
          final Procedure1<PlainHTMLTable> _function = new Procedure1<PlainHTMLTable>() {
              public void apply(final PlainHTMLTable it) {
                PlainHTMLTR _tr = HTMLTagsExt.tr(it);
                final Procedure1<PlainHTMLTR> _function = new Procedure1<PlainHTMLTR>() {
                    public void apply(final PlainHTMLTR it) {
                      PlainHTMLTD _td = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = CenterlizedDeliverTaskQueryListView.this.criteriaForm.sid.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                      PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = CenterlizedDeliverTaskQueryListView.this.criteriaForm.createTimeFrom.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                      PlainHTMLTD _td_2 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_2 = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = CenterlizedDeliverTaskQueryListView.this.criteriaForm.createTimeTo.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_2, _function_2);
                    }
                  };
                ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr, _function);
                PlainHTMLTR _tr_1 = HTMLTagsExt.tr(it);
                final Procedure1<PlainHTMLTR> _function_1 = new Procedure1<PlainHTMLTR>() {
                    public void apply(final PlainHTMLTR it) {
                      PlainHTMLTD _td = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = CenterlizedDeliverTaskQueryListView.this.criteriaForm.performer.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                      PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = CenterlizedDeliverTaskQueryListView.this.criteriaForm.taskSourceType.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                      PlainHTMLTD _td_2 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_2 = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            TextButton _TextButton = CenterlizedDeliverTaskQueryListView.this.widgets.TextButton("\u67E5\u627E");
                            final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                                public void apply(final TextButton it) {
                                  it.setWidth("80px");
                                  final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                      public void apply(final SelectEvent it) {
                                        UICenterlizedDeliverTaskCriteria _value = CenterlizedDeliverTaskQueryListView.this.criteriaForm.getValue();
                                        UICenterlizedDeliverTaskCriteria _withPagerInfo = Extensions.<UICenterlizedDeliverTaskCriteria>withPagerInfo(_value, CenterlizedDeliverTaskQueryListView.this.pager);
                                        final Procedure1<UICenterlizedDeliverTaskCriteria> _function = new Procedure1<UICenterlizedDeliverTaskCriteria>() {
                                            public void apply(final UICenterlizedDeliverTaskCriteria it) {
                                              it.setPage(Integer.valueOf(1));
                                            }
                                          };
                                        UICenterlizedDeliverTaskCriteria _doubleArrow = ObjectExtensions.<UICenterlizedDeliverTaskCriteria>operator_doubleArrow(_withPagerInfo, _function);
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
                            TextButton _doubleArrow = ObjectExtensions.<TextButton>operator_doubleArrow(_TextButton, _function);
                            ClientUi.operator_add(it, _doubleArrow);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_2, _function_2);
                    }
                  };
                ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_1, _function_1);
              }
            };
          PlainHTMLTable _doubleArrow = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE, _function);
          it.add(_doubleArrow);
          IPager<UICenterlizedDeliverTask> _createPager = edu.fudan.langlab.gxt.client.pager.Extensions.<UICenterlizedDeliverTask>createPager(CenterlizedDeliverTaskQueryListView.this.listGrid);
          final Procedure1<IPager<UICenterlizedDeliverTask>> _function_1 = new Procedure1<IPager<UICenterlizedDeliverTask>>() {
              public void apply(final IPager<UICenterlizedDeliverTask> it) {
                final Procedure2<Integer,Integer> _function = new Procedure2<Integer,Integer>() {
                    public void apply(final Integer pageNum, final Integer recordsPerPage) {
                      UICenterlizedDeliverTaskCriteria _value = CenterlizedDeliverTaskQueryListView.this.criteriaForm.getValue();
                      UICenterlizedDeliverTaskCriteria _withPagerInfo = Extensions.<UICenterlizedDeliverTaskCriteria>withPagerInfo(_value, CenterlizedDeliverTaskQueryListView.this.pager);
                      final Procedure1<UICenterlizedDeliverTaskCriteria> _function = new Procedure1<UICenterlizedDeliverTaskCriteria>() {
                          public void apply(final UICenterlizedDeliverTaskCriteria it) {
                            it.setPage(Integer.valueOf(pageNum));
                            it.setPageSize(Integer.valueOf(recordsPerPage));
                          }
                        };
                      UICenterlizedDeliverTaskCriteria _doubleArrow = ObjectExtensions.<UICenterlizedDeliverTaskCriteria>operator_doubleArrow(_withPagerInfo, _function);
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
          IPager<UICenterlizedDeliverTask> _doubleArrow_1 = ObjectExtensions.<IPager<UICenterlizedDeliverTask>>operator_doubleArrow(_createPager, _function_1);
          CenterlizedDeliverTaskQueryListView.this.pager = _doubleArrow_1;
          SGroupingGrid<UICenterlizedDeliverTask> _asWidget = CenterlizedDeliverTaskQueryListView.this.listGrid.asWidget();
          VerticalLayoutData _VLayoutData = CenterlizedDeliverTaskQueryListView.this.widgets.VLayoutData(1, 1);
          it.add(_asWidget, _VLayoutData);
          Widget _asWidget_1 = CenterlizedDeliverTaskQueryListView.this.pager.asWidget();
          it.add(_asWidget_1);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    this.con = _doubleArrow;
  }
  
  public void showResults(final IPagedResult<UICenterlizedDeliverTask> results) {
    this.pager.pageLoaded(results);
  }
  
  public void refresh() {
    int _activePage = this.pager.getActivePage();
    this.pager.gotoPage(_activePage);
  }
  
  public ActionContext<UICenterlizedDeliverTask> getActionContext() {
    ActionContext<UICenterlizedDeliverTask> _createActionContext = ActionExtensions.<UICenterlizedDeliverTask>createActionContext(this.listGrid);
    return _createActionContext;
  }
  
  private RequestHandler1<UICenterlizedDeliverTaskCriteria> filterRequestRequestHandler;
  
  public void filterRequest(final RequestHandler1<UICenterlizedDeliverTaskCriteria> requestHandler) {
    this.filterRequestRequestHandler = requestHandler;
  }
}
