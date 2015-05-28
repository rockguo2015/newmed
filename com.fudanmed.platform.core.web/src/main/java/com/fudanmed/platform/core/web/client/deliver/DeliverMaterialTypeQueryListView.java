package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy;
import com.fudanmed.platform.core.web.client.deliver.DeliverMaterialTypeCriteriaForm;
import com.fudanmed.platform.core.web.client.deliver.DeliverMaterialTypeListGrid;
import com.fudanmed.platform.core.web.client.deliver.DeliverMaterialTypeQueryListPresenterView;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialType;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialTypeCriteria;
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

public class DeliverMaterialTypeQueryListView extends GWTAbstractView implements DeliverMaterialTypeQueryListPresenterView {
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
  private DeliverMaterialTypeListGrid listGrid;
  
  @Inject
  private DeliverMaterialTypeCriteriaForm criteriaForm;
  
  private IPager pager;
  
  private ActionContext<DLDeliverMaterialCategoryProxy> categoryAC;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    this.listGrid.asWidget();
    final Procedure1<Iterable<DLDeliverMaterialCategoryProxy>> _function = new Procedure1<Iterable<DLDeliverMaterialCategoryProxy>>() {
        public void apply(final Iterable<DLDeliverMaterialCategoryProxy> it) {
          DLDeliverMaterialCategoryProxy _onlySelected = ObjectSelectionProviders.<DLDeliverMaterialCategoryProxy>getOnlySelected(DeliverMaterialTypeQueryListView.this.categoryAC);
          DeliverMaterialTypeQueryListView.this.criteriaForm.category.setValue(_onlySelected);
          DeliverMaterialTypeQueryListView.this.refresh();
        }
      };
    this.categoryAC.addSelectionChangedListener(new SelectionChangedListener<DLDeliverMaterialCategoryProxy>() {
        public void selectionChanged(Iterable<DLDeliverMaterialCategoryProxy> selections) {
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
                            FieldLabel _asWidget = DeliverMaterialTypeQueryListView.this.criteriaForm.info.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                      PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            TextButton _TextButton = DeliverMaterialTypeQueryListView.this.widgets.TextButton("\u67E5\u627E");
                            final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                                public void apply(final TextButton it) {
                                  it.setWidth("80px");
                                  final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                      public void apply(final SelectEvent it) {
                                        UIDeliverMaterialTypeCriteria _value = DeliverMaterialTypeQueryListView.this.criteriaForm.getValue();
                                        UIDeliverMaterialTypeCriteria _withPagerInfo = Extensions.<UIDeliverMaterialTypeCriteria>withPagerInfo(_value, DeliverMaterialTypeQueryListView.this.pager);
                                        final Procedure1<UIDeliverMaterialTypeCriteria> _function = new Procedure1<UIDeliverMaterialTypeCriteria>() {
                                            public void apply(final UIDeliverMaterialTypeCriteria it) {
                                              it.setPage(Integer.valueOf(1));
                                            }
                                          };
                                        UIDeliverMaterialTypeCriteria _doubleArrow = ObjectExtensions.<UIDeliverMaterialTypeCriteria>operator_doubleArrow(_withPagerInfo, _function);
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
          IPager<UIDeliverMaterialType> _createPager = edu.fudan.langlab.gxt.client.pager.Extensions.<UIDeliverMaterialType>createPager(DeliverMaterialTypeQueryListView.this.listGrid);
          final Procedure1<IPager<UIDeliverMaterialType>> _function_1 = new Procedure1<IPager<UIDeliverMaterialType>>() {
              public void apply(final IPager<UIDeliverMaterialType> it) {
                final Procedure2<Integer,Integer> _function = new Procedure2<Integer,Integer>() {
                    public void apply(final Integer pageNum, final Integer recordsPerPage) {
                      UIDeliverMaterialTypeCriteria _value = DeliverMaterialTypeQueryListView.this.criteriaForm.getValue();
                      UIDeliverMaterialTypeCriteria _withPagerInfo = Extensions.<UIDeliverMaterialTypeCriteria>withPagerInfo(_value, DeliverMaterialTypeQueryListView.this.pager);
                      final Procedure1<UIDeliverMaterialTypeCriteria> _function = new Procedure1<UIDeliverMaterialTypeCriteria>() {
                          public void apply(final UIDeliverMaterialTypeCriteria it) {
                            it.setPage(Integer.valueOf(pageNum));
                            it.setPageSize(Integer.valueOf(recordsPerPage));
                          }
                        };
                      UIDeliverMaterialTypeCriteria _doubleArrow = ObjectExtensions.<UIDeliverMaterialTypeCriteria>operator_doubleArrow(_withPagerInfo, _function);
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
          IPager<UIDeliverMaterialType> _doubleArrow_1 = ObjectExtensions.<IPager<UIDeliverMaterialType>>operator_doubleArrow(_createPager, _function_1);
          DeliverMaterialTypeQueryListView.this.pager = _doubleArrow_1;
          SGroupingGrid<UIDeliverMaterialType> _asWidget = DeliverMaterialTypeQueryListView.this.listGrid.asWidget();
          VerticalLayoutData _VLayoutData = DeliverMaterialTypeQueryListView.this.widgets.VLayoutData(1, 1);
          it.add(_asWidget, _VLayoutData);
          Widget _asWidget_1 = DeliverMaterialTypeQueryListView.this.pager.asWidget();
          it.add(_asWidget_1);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function_1);
    this.con = _doubleArrow;
  }
  
  public void showResults(final IPagedResult<UIDeliverMaterialType> results) {
    this.pager.pageLoaded(results);
  }
  
  public void refresh() {
    int _activePage = this.pager.getActivePage();
    this.pager.gotoPage(_activePage);
  }
  
  public ActionContext<UIDeliverMaterialType> getActionContext() {
    ActionContext<UIDeliverMaterialType> _createActionContext = ActionExtensions.<UIDeliverMaterialType>createActionContext(this.listGrid);
    return _createActionContext;
  }
  
  public void setCategoryAC(final ActionContext<DLDeliverMaterialCategoryProxy> categoryAC) {
    this.categoryAC = categoryAC;
  }
  
  private RequestHandler1<UIDeliverMaterialTypeCriteria> filterRequestRequestHandler;
  
  public void filterRequest(final RequestHandler1<UIDeliverMaterialTypeCriteria> requestHandler) {
    this.filterRequestRequestHandler = requestHandler;
  }
}
