package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.InHospitalLocationCriteriaForm;
import com.fudanmed.platform.core.web.client.deliver.InHospitalLocationListGrid;
import com.fudanmed.platform.core.web.client.deliver.InHospitalLocationQueryListPresenterView;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalLocation;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalLocationCriteria;
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

public class InHospitalLocationQueryListView extends GWTAbstractView implements InHospitalLocationQueryListPresenterView {
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
  private InHospitalLocationListGrid listGrid;
  
  @Inject
  private InHospitalLocationCriteriaForm criteriaForm;
  
  private IPager pager;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    this.listGrid.asWidget();
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
                            FieldLabel _asWidget = InHospitalLocationQueryListView.this.criteriaForm.info.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                      PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            TextButton _TextButton = InHospitalLocationQueryListView.this.widgets.TextButton("\u67E5\u627E");
                            final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                                public void apply(final TextButton it) {
                                  it.setWidth("80px");
                                  final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                      public void apply(final SelectEvent it) {
                                        UIInHospitalLocationCriteria _value = InHospitalLocationQueryListView.this.criteriaForm.getValue();
                                        UIInHospitalLocationCriteria _withPagerInfo = Extensions.<UIInHospitalLocationCriteria>withPagerInfo(_value, InHospitalLocationQueryListView.this.pager);
                                        final Procedure1<UIInHospitalLocationCriteria> _function = new Procedure1<UIInHospitalLocationCriteria>() {
                                            public void apply(final UIInHospitalLocationCriteria it) {
                                              it.setPage(Integer.valueOf(1));
                                            }
                                          };
                                        UIInHospitalLocationCriteria _doubleArrow = ObjectExtensions.<UIInHospitalLocationCriteria>operator_doubleArrow(_withPagerInfo, _function);
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
          IPager<UIInHospitalLocation> _createPager = edu.fudan.langlab.gxt.client.pager.Extensions.<UIInHospitalLocation>createPager(InHospitalLocationQueryListView.this.listGrid);
          final Procedure1<IPager<UIInHospitalLocation>> _function_1 = new Procedure1<IPager<UIInHospitalLocation>>() {
              public void apply(final IPager<UIInHospitalLocation> it) {
                final Procedure2<Integer,Integer> _function = new Procedure2<Integer,Integer>() {
                    public void apply(final Integer pageNum, final Integer recordsPerPage) {
                      UIInHospitalLocationCriteria _value = InHospitalLocationQueryListView.this.criteriaForm.getValue();
                      UIInHospitalLocationCriteria _withPagerInfo = Extensions.<UIInHospitalLocationCriteria>withPagerInfo(_value, InHospitalLocationQueryListView.this.pager);
                      final Procedure1<UIInHospitalLocationCriteria> _function = new Procedure1<UIInHospitalLocationCriteria>() {
                          public void apply(final UIInHospitalLocationCriteria it) {
                            it.setPage(Integer.valueOf(pageNum));
                            it.setPageSize(Integer.valueOf(recordsPerPage));
                          }
                        };
                      UIInHospitalLocationCriteria _doubleArrow = ObjectExtensions.<UIInHospitalLocationCriteria>operator_doubleArrow(_withPagerInfo, _function);
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
          IPager<UIInHospitalLocation> _doubleArrow_1 = ObjectExtensions.<IPager<UIInHospitalLocation>>operator_doubleArrow(_createPager, _function_1);
          InHospitalLocationQueryListView.this.pager = _doubleArrow_1;
          SGroupingGrid<UIInHospitalLocation> _asWidget = InHospitalLocationQueryListView.this.listGrid.asWidget();
          VerticalLayoutData _VLayoutData = InHospitalLocationQueryListView.this.widgets.VLayoutData(1, 1);
          it.add(_asWidget, _VLayoutData);
          Widget _asWidget_1 = InHospitalLocationQueryListView.this.pager.asWidget();
          it.add(_asWidget_1);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    this.con = _doubleArrow;
  }
  
  public void showResults(final IPagedResult<UIInHospitalLocation> results) {
    this.pager.pageLoaded(results);
  }
  
  public void refresh() {
    int _activePage = this.pager.getActivePage();
    this.pager.gotoPage(_activePage);
  }
  
  public ActionContext<UIInHospitalLocation> getActionContext() {
    ActionContext<UIInHospitalLocation> _createActionContext = ActionExtensions.<UIInHospitalLocation>createActionContext(this.listGrid);
    return _createActionContext;
  }
  
  private RequestHandler1<UIInHospitalLocationCriteria> filterRequestRequestHandler;
  
  public void filterRequest(final RequestHandler1<UIInHospitalLocationCriteria> requestHandler) {
    this.filterRequestRequestHandler = requestHandler;
  }
}
