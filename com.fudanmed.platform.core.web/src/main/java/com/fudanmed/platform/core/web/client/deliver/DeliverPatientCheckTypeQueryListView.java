package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy;
import com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckTypeCriteriaForm;
import com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckTypeListGrid;
import com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckTypeQueryListPresenterView;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckType;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckTypeCriteria;
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
import com.uniquesoft.gwt.client.common.extensions.ObjectSelectionProviders;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener;
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

public class DeliverPatientCheckTypeQueryListView extends GWTAbstractView implements DeliverPatientCheckTypeQueryListPresenterView {
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
  private DeliverPatientCheckTypeListGrid listGrid;
  
  @Inject
  private DeliverPatientCheckTypeCriteriaForm criteriaForm;
  
  private ActionContext<DLDeliverPatientCheckCategoryProxy> categoryAC;
  
  private IPager pager;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    this.listGrid.asWidget();
    final Procedure1<Iterable<DLDeliverPatientCheckCategoryProxy>> _function = new Procedure1<Iterable<DLDeliverPatientCheckCategoryProxy>>() {
        public void apply(final Iterable<DLDeliverPatientCheckCategoryProxy> it) {
          DLDeliverPatientCheckCategoryProxy _onlySelected = ObjectSelectionProviders.<DLDeliverPatientCheckCategoryProxy>getOnlySelected(DeliverPatientCheckTypeQueryListView.this.categoryAC);
          DeliverPatientCheckTypeQueryListView.this.criteriaForm.category.setValue(_onlySelected);
          DeliverPatientCheckTypeQueryListView.this.refresh();
        }
      };
    this.categoryAC.addSelectionChangedListener(new SelectionChangedListener<DLDeliverPatientCheckCategoryProxy>() {
        public void selectionChanged(Iterable<DLDeliverPatientCheckCategoryProxy> selections) {
          _function.apply(selections);
        }
    });
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function_1 = new Procedure1<VerticalLayoutContainer>() {
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
                            FieldLabel _asWidget = DeliverPatientCheckTypeQueryListView.this.criteriaForm.info.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                      PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            TextButton _TextButton = DeliverPatientCheckTypeQueryListView.this.widgets.TextButton("\u67E5\u627E");
                            final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                                public void apply(final TextButton it) {
                                  it.setWidth("80px");
                                  final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                      public void apply(final SelectEvent it) {
                                        UIDeliverPatientCheckTypeCriteria _value = DeliverPatientCheckTypeQueryListView.this.criteriaForm.getValue();
                                        UIDeliverPatientCheckTypeCriteria _withPagerInfo = Extensions.<UIDeliverPatientCheckTypeCriteria>withPagerInfo(_value, DeliverPatientCheckTypeQueryListView.this.pager);
                                        final Procedure1<UIDeliverPatientCheckTypeCriteria> _function = new Procedure1<UIDeliverPatientCheckTypeCriteria>() {
                                            public void apply(final UIDeliverPatientCheckTypeCriteria it) {
                                              DLDeliverPatientCheckCategoryProxy _onlySelected = ObjectSelectionProviders.<DLDeliverPatientCheckCategoryProxy>getOnlySelected(DeliverPatientCheckTypeQueryListView.this.categoryAC);
                                              it.setCategory(_onlySelected);
                                              it.setPage(Integer.valueOf(1));
                                            }
                                          };
                                        UIDeliverPatientCheckTypeCriteria _doubleArrow = ObjectExtensions.<UIDeliverPatientCheckTypeCriteria>operator_doubleArrow(_withPagerInfo, _function);
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
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                    }
                  };
                ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr, _function);
              }
            };
          PlainHTMLTable _doubleArrow = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE, _function);
          it.add(_doubleArrow);
          IPager<UIDeliverPatientCheckType> _createPager = edu.fudan.langlab.gxt.client.pager.Extensions.<UIDeliverPatientCheckType>createPager(DeliverPatientCheckTypeQueryListView.this.listGrid);
          final Procedure1<IPager<UIDeliverPatientCheckType>> _function_1 = new Procedure1<IPager<UIDeliverPatientCheckType>>() {
              public void apply(final IPager<UIDeliverPatientCheckType> it) {
                final Procedure2<Integer,Integer> _function = new Procedure2<Integer,Integer>() {
                    public void apply(final Integer pageNum, final Integer recordsPerPage) {
                      UIDeliverPatientCheckTypeCriteria _value = DeliverPatientCheckTypeQueryListView.this.criteriaForm.getValue();
                      UIDeliverPatientCheckTypeCriteria _withPagerInfo = Extensions.<UIDeliverPatientCheckTypeCriteria>withPagerInfo(_value, DeliverPatientCheckTypeQueryListView.this.pager);
                      final Procedure1<UIDeliverPatientCheckTypeCriteria> _function = new Procedure1<UIDeliverPatientCheckTypeCriteria>() {
                          public void apply(final UIDeliverPatientCheckTypeCriteria it) {
                            DLDeliverPatientCheckCategoryProxy _onlySelected = ObjectSelectionProviders.<DLDeliverPatientCheckCategoryProxy>getOnlySelected(DeliverPatientCheckTypeQueryListView.this.categoryAC);
                            it.setCategory(_onlySelected);
                            it.setPage(Integer.valueOf(pageNum));
                            it.setPageSize(Integer.valueOf(recordsPerPage));
                          }
                        };
                      UIDeliverPatientCheckTypeCriteria _doubleArrow = ObjectExtensions.<UIDeliverPatientCheckTypeCriteria>operator_doubleArrow(_withPagerInfo, _function);
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
          IPager<UIDeliverPatientCheckType> _doubleArrow_1 = ObjectExtensions.<IPager<UIDeliverPatientCheckType>>operator_doubleArrow(_createPager, _function_1);
          DeliverPatientCheckTypeQueryListView.this.pager = _doubleArrow_1;
          SGroupingGrid<UIDeliverPatientCheckType> _asWidget = DeliverPatientCheckTypeQueryListView.this.listGrid.asWidget();
          VerticalLayoutData _VLayoutData = DeliverPatientCheckTypeQueryListView.this.widgets.VLayoutData(1, 1);
          it.add(_asWidget, _VLayoutData);
          Widget _asWidget_1 = DeliverPatientCheckTypeQueryListView.this.pager.asWidget();
          it.add(_asWidget_1);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function_1);
    this.con = _doubleArrow;
  }
  
  public void showResults(final IPagedResult<UIDeliverPatientCheckType> results) {
    this.pager.pageLoaded(results);
  }
  
  public void refresh() {
    int _activePage = this.pager.getActivePage();
    this.pager.gotoPage(_activePage);
  }
  
  public ActionContext<UIDeliverPatientCheckType> getActionContext() {
    ActionContext<UIDeliverPatientCheckType> _createActionContext = ActionExtensions.<UIDeliverPatientCheckType>createActionContext(this.listGrid);
    return _createActionContext;
  }
  
  public void setCategoryAC(final ActionContext<DLDeliverPatientCheckCategoryProxy> categoryAC) {
    this.categoryAC = categoryAC;
  }
  
  private RequestHandler1<UIDeliverPatientCheckTypeCriteria> filterRequestRequestHandler;
  
  public void filterRequest(final RequestHandler1<UIDeliverPatientCheckTypeCriteria> requestHandler) {
    this.filterRequestRequestHandler = requestHandler;
  }
}
