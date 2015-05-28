package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemStockRecordProxy;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemStockRecordCriteriaForm;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemStockRecordItemListGrid;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemStockRecordListGrid;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemStockRecordManagementPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecordCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecordItem;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.ObjectListView.SelectEntityListener;
import com.uniquesoft.gwt.client.common.widgets.pager.Extensions;
import com.uniquesoft.gwt.client.common.widgets.pager.IPager;
import com.uniquesoft.gwt.client.common.widgets.pager.IPager.GotoPageHandler;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.widget.ContentPanel;
import edu.fudan.langlab.gxt.client.widget.FramedPanel;
import edu.fudan.langlab.gxt.client.widget.HTableLayoutContainer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.TabPanel;
import edu.fudan.langlab.security.client.Securities;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

public class WorkItemStockRecordManagementView extends GWTAbstractView implements WorkItemStockRecordManagementPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(listGrid,criteriaForm,detailGrid),
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
  private WorkItemStockRecordListGrid listGrid;
  
  @Inject
  private WorkItemStockRecordCriteriaForm criteriaForm;
  
  @Inject
  private WorkItemStockRecordItemListGrid detailGrid;
  
  private IPager pager;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    this.listGrid.asWidget();
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u5DE5\u5355\u9886/\u9000\u6599\u5355\u67E5\u8BE2");
    final Procedure1<FramedPanel> _function = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          VerticalLayoutContainer _VLayout = WorkItemStockRecordManagementView.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                HTableLayoutContainer _HTableLayout = WorkItemStockRecordManagementView.this.widgets.HTableLayout();
                final Procedure1<HTableLayoutContainer> _function = new Procedure1<HTableLayoutContainer>() {
                    public void apply(final HTableLayoutContainer it) {
                      FieldLabel _asWidget = WorkItemStockRecordManagementView.this.criteriaForm.info.asWidget();
                      TextButton _TextButton = WorkItemStockRecordManagementView.this.widgets.TextButton("\u67E5\u8BE2");
                      final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                          public void apply(final TextButton it) {
                            it.setWidth("80px");
                            final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                public void apply(final SelectEvent it) {
                                  UIWorkItemStockRecordCriteria _value = WorkItemStockRecordManagementView.this.criteriaForm.getValue();
                                  UIWorkItemStockRecordCriteria _withPagerInfo = Extensions.<UIWorkItemStockRecordCriteria>withPagerInfo(_value, WorkItemStockRecordManagementView.this.pager);
                                  final Procedure1<UIWorkItemStockRecordCriteria> _function = new Procedure1<UIWorkItemStockRecordCriteria>() {
                                      public void apply(final UIWorkItemStockRecordCriteria it) {
                                        it.setPage(Integer.valueOf(1));
                                      }
                                    };
                                  UIWorkItemStockRecordCriteria _doubleArrow = ObjectExtensions.<UIWorkItemStockRecordCriteria>operator_doubleArrow(_withPagerInfo, _function);
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
                      ArrayList<Widget> _newArrayList = CollectionLiterals.<Widget>newArrayList(_asWidget, _doubleArrow);
                      it.add(_newArrayList);
                    }
                  };
                HTableLayoutContainer _doubleArrow = ObjectExtensions.<HTableLayoutContainer>operator_doubleArrow(_HTableLayout, _function);
                it.add(_doubleArrow);
                IPager<UIWorkItemStockRecord> _createPager = edu.fudan.langlab.gxt.client.pager.Extensions.<UIWorkItemStockRecord>createPager(WorkItemStockRecordManagementView.this.listGrid);
                final Procedure1<IPager<UIWorkItemStockRecord>> _function_1 = new Procedure1<IPager<UIWorkItemStockRecord>>() {
                    public void apply(final IPager<UIWorkItemStockRecord> it) {
                      final Procedure2<Integer,Integer> _function = new Procedure2<Integer,Integer>() {
                          public void apply(final Integer pageNum, final Integer recordsPerPage) {
                            UIWorkItemStockRecordCriteria _value = WorkItemStockRecordManagementView.this.criteriaForm.getValue();
                            UIWorkItemStockRecordCriteria _withPagerInfo = Extensions.<UIWorkItemStockRecordCriteria>withPagerInfo(_value, WorkItemStockRecordManagementView.this.pager);
                            final Procedure1<UIWorkItemStockRecordCriteria> _function = new Procedure1<UIWorkItemStockRecordCriteria>() {
                                public void apply(final UIWorkItemStockRecordCriteria it) {
                                  it.setPage(Integer.valueOf(pageNum));
                                  it.setPageSize(Integer.valueOf(recordsPerPage));
                                }
                              };
                            UIWorkItemStockRecordCriteria _doubleArrow = ObjectExtensions.<UIWorkItemStockRecordCriteria>operator_doubleArrow(_withPagerInfo, _function);
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
                IPager<UIWorkItemStockRecord> _doubleArrow_1 = ObjectExtensions.<IPager<UIWorkItemStockRecord>>operator_doubleArrow(_createPager, _function_1);
                WorkItemStockRecordManagementView.this.pager = _doubleArrow_1;
                ContentPanel _ContentPanel = WorkItemStockRecordManagementView.this.widgets.ContentPanel();
                final Procedure1<ContentPanel> _function_2 = new Procedure1<ContentPanel>() {
                    public void apply(final ContentPanel it) {
                      VerticalLayoutContainer _VLayout = WorkItemStockRecordManagementView.this.widgets.VLayout();
                      final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                          public void apply(final VerticalLayoutContainer it) {
                            SGroupingGrid<UIWorkItemStockRecord> _asWidget = WorkItemStockRecordManagementView.this.listGrid.asWidget();
                            VerticalLayoutData _VLayoutData = WorkItemStockRecordManagementView.this.widgets.VLayoutData(1, 1);
                            it.add(_asWidget, _VLayoutData);
                            Widget _asWidget_1 = WorkItemStockRecordManagementView.this.pager.asWidget();
                            int _minus = (-1);
                            VerticalLayoutData _VLayoutData_1 = WorkItemStockRecordManagementView.this.widgets.VLayoutData(1, _minus);
                            it.add(_asWidget_1, _VLayoutData_1);
                          }
                        };
                      VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                      it.setWidget(_doubleArrow);
                    }
                  };
                ContentPanel _doubleArrow_2 = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function_2);
                VerticalLayoutData _VLayoutData = WorkItemStockRecordManagementView.this.widgets.VLayoutData(1, 0.45);
                it.add(_doubleArrow_2, _VLayoutData);
                TabPanel _TabPanel = WorkItemStockRecordManagementView.this.widgets.TabPanel();
                final Procedure1<TabPanel> _function_3 = new Procedure1<TabPanel>() {
                    public void apply(final TabPanel it) {
                      SGroupingGrid<UIWorkItemStockRecordItem> _asWidget = WorkItemStockRecordManagementView.this.detailGrid.asWidget();
                      it.add(_asWidget, "\u9886/\u9000\u6599\u660E\u7EC6");
                    }
                  };
                TabPanel _doubleArrow_3 = ObjectExtensions.<TabPanel>operator_doubleArrow(_TabPanel, _function_3);
                VerticalLayoutData _VLayoutData_1 = WorkItemStockRecordManagementView.this.widgets.VLayoutData(1, 0.55);
                it.add(_doubleArrow_3, _VLayoutData_1);
              }
            };
          VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
          it.setWidget(_doubleArrow);
          final Procedure1<UIWorkItemStockRecord> _function_1 = new Procedure1<UIWorkItemStockRecord>() {
              public void apply(final UIWorkItemStockRecord it) {
                RCWorkItemStockRecordProxy _proxy = it.toProxy();
                showDetailRequestRequestHandler.execute(_proxy);
                
              }
            };
          WorkItemStockRecordManagementView.this.listGrid.addSelectEntityListener(new SelectEntityListener<UIWorkItemStockRecord>() {
              public void objectSelected(UIWorkItemStockRecord selected) {
                _function_1.apply(selected);
              }
          });
        }
      };
    FramedPanel _doubleArrow = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function);
    this.con = _doubleArrow;
  }
  
  public void showResults(final IPagedResult<UIWorkItemStockRecord> results) {
    this.pager.pageLoaded(results);
  }
  
  public void showDetail(final Collection<UIWorkItemStockRecordItem> detail) {
    this.detailGrid.setObjects(detail);
  }
  
  public void refresh() {
    int _activePage = this.pager.getActivePage();
    this.pager.gotoPage(_activePage);
  }
  
  private RequestHandler1<RCWorkItemStockRecordProxy> showDetailRequestRequestHandler;
  
  public void showDetailRequest(final RequestHandler1<RCWorkItemStockRecordProxy> requestHandler) {
    this.showDetailRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<UIWorkItemStockRecordCriteria> filterRequestRequestHandler;
  
  public void filterRequest(final RequestHandler1<UIWorkItemStockRecordCriteria> requestHandler) {
    this.filterRequestRequestHandler = requestHandler;
  }
}
