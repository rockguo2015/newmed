package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.client.organization.OrganizationOutlinePresenter;
import com.fudanmed.platform.core.web.client.project.RepairTask4SettlementCriteriaForm;
import com.fudanmed.platform.core.web.client.project.RepairTask4SettlementListGrid;
import com.fudanmed.platform.core.web.client.project.RepairTaskTreeInfoPresenter;
import com.fudanmed.platform.core.web.client.project.RepairTaskTreeInfoPresenterView;
import com.fudanmed.platform.core.web.client.project.SettlementSelectorPresenterView;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask4SettlementCriteria;
import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.Dialog;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.RowClickEvent;
import com.sencha.gxt.widget.core.client.event.RowClickEvent.RowClickHandler;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.Size;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.selector.ObjectSelector;
import edu.fudan.langlab.gxt.client.validation.ErrorNotifierViewer;
import edu.fudan.langlab.gxt.client.widget.ContentPanel;
import edu.fudan.langlab.gxt.client.widget.HTMLTagsExt;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTD;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTR;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTable;
import edu.fudan.langlab.security.client.Securities;
import java.util.Collection;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class SettlementSelectorView extends ErrorNotifierViewer implements SettlementSelectorPresenterView, IHasSize, IHasTitle {
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
  private RepairTask4SettlementListGrid listGrid;
  
  @Inject
  private RepairTask4SettlementCriteriaForm criteriaForm;
  
  @Inject
  private Provider<OrganizationOutlinePresenter> organizationOutlinePresenter;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    this.listGrid.asMultiSelectGrid();
    ContentPanel _ContentPanel = this.widgets.ContentPanel();
    final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
        public void apply(final ContentPanel it) {
          it.setBodyBorder(false);
          it.setBorders(false);
          VerticalLayoutContainer _VLayout = SettlementSelectorView.this.widgets.VLayout();
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
                                  FieldLabel _asWidget = SettlementSelectorView.this.criteriaForm.finishDateFrom.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                            PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = SettlementSelectorView.this.criteriaForm.finishDateTo.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                            PlainHTMLTD _td_2 = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function_2 = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
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
                                  PlainHTMLTable _TABLE = HTMLTagsExt.TABLE();
                                  final Procedure1<PlainHTMLTable> _function = new Procedure1<PlainHTMLTable>() {
                                      public void apply(final PlainHTMLTable it) {
                                        PlainHTMLTR _tr = HTMLTagsExt.tr(it);
                                        final Procedure1<PlainHTMLTR> _function = new Procedure1<PlainHTMLTR>() {
                                            public void apply(final PlainHTMLTR it) {
                                              PlainHTMLTD _td = HTMLTagsExt.td(it);
                                              final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                                  public void apply(final PlainHTMLTD it) {
                                                    FieldLabel _asWidget = SettlementSelectorView.this.criteriaForm.reportOrg.asWidget();
                                                    ClientUi.operator_add(it, _asWidget);
                                                  }
                                                };
                                              ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                                              PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                                              final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                                  public void apply(final PlainHTMLTD it) {
                                                    TextButton _TextButton = SettlementSelectorView.this.widgets.TextButton("\u9009\u62E9");
                                                    final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                                                        public void apply(final TextButton it) {
                                                          final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                                              public void apply(final SelectEvent it) {
                                                                OrganizationOutlinePresenter _get = SettlementSelectorView.this.organizationOutlinePresenter.get();
                                                                final Procedure1<OrganizationOutlinePresenter> _function = new Procedure1<OrganizationOutlinePresenter>() {
                                                                    public void apply(final OrganizationOutlinePresenter it) {
                                                                      final Procedure1<OrganizationOutlinePresenter> _function = new Procedure1<OrganizationOutlinePresenter>() {
                                                                          public void apply(final OrganizationOutlinePresenter it) {
                                                                            final Procedure1<UIOrganization> _function = new Procedure1<UIOrganization>() {
                                                                                public void apply(final UIOrganization it) {
                                                                                  RCOrganizationProxy _proxy = it.toProxy();
                                                                                  SettlementSelectorView.this.criteriaForm.reportOrg.setValue(_proxy);
                                                                                }
                                                                              };
                                                                            Dialog _asSelector = ObjectSelector.<UIOrganization>asSelector(it, "\u9009\u62E9\u7EC4\u7EC7\u673A\u6784", 300, 500, _function);
                                                                            _asSelector.show();
                                                                          }
                                                                        };
                                                                      it.setupAsSimpleTree(_function);
                                                                    }
                                                                  };
                                                                ObjectExtensions.<OrganizationOutlinePresenter>operator_doubleArrow(_get, _function);
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
                                  ClientUi.operator_add(it, _doubleArrow);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                            PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = SettlementSelectorView.this.criteriaForm.team.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                            PlainHTMLTD _td_2 = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function_2 = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  TextButton _TextButton = SettlementSelectorView.this.widgets.TextButton("\u7B5B\u9009");
                                  final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                                      public void apply(final TextButton it) {
                                        it.setWidth("80px");
                                        final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                            public void apply(final SelectEvent it) {
                                              UIRepairTask4SettlementCriteria _value = SettlementSelectorView.this.criteriaForm.getValue();
                                              final Procedure1<UIRepairTask4SettlementCriteria> _function = new Procedure1<UIRepairTask4SettlementCriteria>() {
                                                  public void apply(final UIRepairTask4SettlementCriteria it) {
                                                    it.setPage(Integer.valueOf(1));
                                                  }
                                                };
                                              UIRepairTask4SettlementCriteria _doubleArrow = ObjectExtensions.<UIRepairTask4SettlementCriteria>operator_doubleArrow(_value, _function);
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
                int _minus = (-1);
                VerticalLayoutData _VLayoutData = SettlementSelectorView.this.widgets.VLayoutData(1, _minus, 1);
                it.add(_doubleArrow, _VLayoutData);
                ContentPanel _ContentPanel = SettlementSelectorView.this.widgets.ContentPanel();
                final Procedure1<ContentPanel> _function_1 = new Procedure1<ContentPanel>() {
                    public void apply(final ContentPanel it) {
                      SGroupingGrid<UIRepairTask> _asWidget = SettlementSelectorView.this.listGrid.asWidget();
                      it.setWidget(_asWidget);
                    }
                  };
                ContentPanel _doubleArrow_1 = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function_1);
                VerticalLayoutData _VLayoutData_1 = SettlementSelectorView.this.widgets.VLayoutData(1, 0.6);
                it.add(_doubleArrow_1, _VLayoutData_1);
                RepairTaskTreeInfoPresenterView _view = SettlementSelectorView.this.repairTaskInfoPresenter.getView();
                Widget _asWidget = _view.asWidget();
                VerticalLayoutData _VLayoutData_2 = SettlementSelectorView.this.widgets.VLayoutData(1, 0.4);
                it.add(_asWidget, _VLayoutData_2);
                SGroupingGrid<UIRepairTask> _asWidget_1 = SettlementSelectorView.this.listGrid.asWidget();
                final Procedure1<RowClickEvent> _function_2 = new Procedure1<RowClickEvent>() {
                    public void apply(final RowClickEvent event) {
                      SGroupingGrid<UIRepairTask> _asWidget = SettlementSelectorView.this.listGrid.asWidget();
                      ListStore<UIRepairTask> _store = _asWidget.getStore();
                      int _rowIndex = event.getRowIndex();
                      UIRepairTask _get = _store.get(_rowIndex);
                      RCRepairTaskProxy _proxy = _get.toProxy();
                      showTaskDetailRequestRequestHandler.execute(_proxy);
                      
                    }
                  };
                _asWidget_1.addRowClickHandler(new RowClickHandler() {
                    public void onRowClick(RowClickEvent event) {
                      _function_2.apply(event);
                    }
                });
              }
            };
          VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
          it.setWidget(_doubleArrow);
        }
      };
    ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
    this.con = _doubleArrow;
  }
  
  public Iterable<UIRepairTask> getSelectedRepairTasks() {
    Iterable<UIRepairTask> _selectedObjects = this.listGrid.getSelectedObjects();
    return _selectedObjects;
  }
  
  public void showResults(final Collection<UIRepairTask> results) {
    this.listGrid.setObjects(results);
  }
  
  public void refresh() {
    UIRepairTask4SettlementCriteria _value = this.criteriaForm.getValue();
    final Procedure1<UIRepairTask4SettlementCriteria> _function = new Procedure1<UIRepairTask4SettlementCriteria>() {
        public void apply(final UIRepairTask4SettlementCriteria it) {
          it.setPage(Integer.valueOf(1));
        }
      };
    UIRepairTask4SettlementCriteria _doubleArrow = ObjectExtensions.<UIRepairTask4SettlementCriteria>operator_doubleArrow(_value, _function);
    filterRequestRequestHandler.execute(_doubleArrow);
    
  }
  
  public void setInitialDateRange(final Date fromDate, final Date toDate) {
    this.criteriaForm.finishDateFrom.setValue(fromDate);
    this.criteriaForm.finishDateTo.setValue(toDate);
  }
  
  public HasEditorErrors mapField(final String errorKey) {
    return null;
  }
  
  public void clearErrors() {
  }
  
  public Size getSize() {
    Size _size = new Size(1024, 630);
    return _size;
  }
  
  public String getTitle() {
    return "\u7ED3\u7B97:\u6DFB\u52A0\u62A5\u4FEE\u5355";
  }
  
  private RequestHandler1<UIRepairTask4SettlementCriteria> filterRequestRequestHandler;
  
  public void filterRequest(final RequestHandler1<UIRepairTask4SettlementCriteria> requestHandler) {
    this.filterRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCRepairTaskProxy> showTaskDetailRequestRequestHandler;
  
  public void showTaskDetailRequest(final RequestHandler1<RCRepairTaskProxy> requestHandler) {
    this.showTaskDetailRequestRequestHandler = requestHandler;
  }
}
