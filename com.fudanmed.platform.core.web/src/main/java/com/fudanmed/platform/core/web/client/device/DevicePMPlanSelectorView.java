package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMPlanProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.client.device.DeviceCategoryAndTypeListPresenter;
import com.fudanmed.platform.core.web.client.device.DeviceCategoryAndTypeListPresenterView;
import com.fudanmed.platform.core.web.client.device.DevicePMPlan4SelectListGrid;
import com.fudanmed.platform.core.web.client.device.DevicePMPlanCriteriaForm;
import com.fudanmed.platform.core.web.client.device.DevicePMPlanSelectorPresenterView;
import com.fudanmed.platform.core.web.client.organization.OnsiteLocationOutlinePresenter;
import com.fudanmed.platform.core.web.client.organization.OnsiteLocationOutlinePresenterView;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlan;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlanCriteria;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FieldSet;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener;
import com.uniquesoft.gwt.client.common.widgets.Size;
import com.uniquesoft.gwt.client.common.widgets.pager.Extensions;
import com.uniquesoft.gwt.client.common.widgets.pager.IPager;
import com.uniquesoft.gwt.client.common.widgets.pager.IPager.GotoPageHandler;
import com.uniquesoft.gwt.shared.DateUtil;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.gwt.shared.extensions.StringExtensions;
import edu.fudan.langlab.gxt.client.component.grid.ICellRender;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
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
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;

public class DevicePMPlanSelectorView extends ErrorNotifierViewer implements DevicePMPlanSelectorPresenterView, IHasSize, IHasTitle {
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
  
  private OnsiteLocationOutlinePresenter onsiteLocationOutlinePresenter;
  
  public void setOnsiteLocationOutlinePresenter(final OnsiteLocationOutlinePresenter onsiteLocationOutlinePresenter) {
    this.onsiteLocationOutlinePresenter = onsiteLocationOutlinePresenter;
  }
  
  private DeviceCategoryAndTypeListPresenter deviceCategoryAndTypeListPresenter;
  
  public void setDeviceCategoryAndTypeListPresenter(final DeviceCategoryAndTypeListPresenter deviceCategoryAndTypeListPresenter) {
    this.deviceCategoryAndTypeListPresenter = deviceCategoryAndTypeListPresenter;
  }
  
  @Inject
  private DevicePMPlan4SelectListGrid listGrid;
  
  @Inject
  private DevicePMPlanCriteriaForm criteriaForm;
  
  private IPager pager;
  
  private RCOnsitePositionProxy location;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  private Function1<? super DevicePMPlan4SelectListGrid,? extends DevicePMPlan4SelectListGrid> listGridInitializer;
  
  public void fireFilterRequester() {
    UIDevicePMPlanCriteria _value = this.criteriaForm.getValue();
    final Procedure1<UIDevicePMPlanCriteria> _function = new Procedure1<UIDevicePMPlanCriteria>() {
        public void apply(final UIDevicePMPlanCriteria it) {
          it.setLocation(DevicePMPlanSelectorView.this.location);
        }
      };
    UIDevicePMPlanCriteria _doubleArrow = ObjectExtensions.<UIDevicePMPlanCriteria>operator_doubleArrow(_value, _function);
    UIDevicePMPlanCriteria _withPagerInfo = Extensions.<UIDevicePMPlanCriteria>withPagerInfo(_doubleArrow, this.pager);
    final Procedure1<UIDevicePMPlanCriteria> _function_1 = new Procedure1<UIDevicePMPlanCriteria>() {
        public void apply(final UIDevicePMPlanCriteria it) {
          it.setPage(Integer.valueOf(1));
          it.setPageSize(Integer.valueOf(1000));
        }
      };
    UIDevicePMPlanCriteria _doubleArrow_1 = ObjectExtensions.<UIDevicePMPlanCriteria>operator_doubleArrow(_withPagerInfo, _function_1);
    filterRequestRequestHandler.execute(_doubleArrow_1);
    
  }
  
  public void initialize() {
    
    OnsiteLocationOutlinePresenterView _view = this.onsiteLocationOutlinePresenter.getView();
    ActionContext<UIOnsitePosition> _actionContext = _view.getActionContext();
    final Procedure1<Iterable<UIOnsitePosition>> _function = new Procedure1<Iterable<UIOnsitePosition>>() {
        public void apply(final Iterable<UIOnsitePosition> o) {
          UIOnsitePosition _head = IterableExtensions.<UIOnsitePosition>head(o);
          RCOnsitePositionProxy _proxy = _head==null?(RCOnsitePositionProxy)null:_head.toProxy();
          DevicePMPlanSelectorView.this.location = _proxy;
          DevicePMPlanSelectorView.this.fireFilterRequester();
        }
      };
    _actionContext.addSelectionChangedListener(new SelectionChangedListener<UIOnsitePosition>() {
        public void selectionChanged(Iterable<UIOnsitePosition> selections) {
          _function.apply(selections);
        }
    });
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {
          DevicePMPlanSelectorView.this.criteriaForm.deviceType.setValue(null);
          DevicePMPlanSelectorView.this.criteriaForm.category.setValue(null);
          UIDevicePMPlanCriteria _value = DevicePMPlanSelectorView.this.criteriaForm.getValue();
          UIDevicePMPlanCriteria _withPagerInfo = Extensions.<UIDevicePMPlanCriteria>withPagerInfo(_value, DevicePMPlanSelectorView.this.pager);
          final Procedure1<UIDevicePMPlanCriteria> _function = new Procedure1<UIDevicePMPlanCriteria>() {
              public void apply(final UIDevicePMPlanCriteria it) {
                it.setPage(Integer.valueOf(1));
              }
            };
          UIDevicePMPlanCriteria _doubleArrow = ObjectExtensions.<UIDevicePMPlanCriteria>operator_doubleArrow(_withPagerInfo, _function);
          filterRequestRequestHandler.execute(_doubleArrow);
          
        }
      };
    this.deviceCategoryAndTypeListPresenter.onUnselected(_function_1);
    final Procedure1<RCDeviceTypeProxy> _function_2 = new Procedure1<RCDeviceTypeProxy>() {
        public void apply(final RCDeviceTypeProxy it) {
          DevicePMPlanSelectorView.this.criteriaForm.deviceType.setValue(it);
          DevicePMPlanSelectorView.this.criteriaForm.category.setValue(null);
          UIDevicePMPlanCriteria _value = DevicePMPlanSelectorView.this.criteriaForm.getValue();
          UIDevicePMPlanCriteria _withPagerInfo = Extensions.<UIDevicePMPlanCriteria>withPagerInfo(_value, DevicePMPlanSelectorView.this.pager);
          final Procedure1<UIDevicePMPlanCriteria> _function = new Procedure1<UIDevicePMPlanCriteria>() {
              public void apply(final UIDevicePMPlanCriteria it) {
                it.setPage(Integer.valueOf(1));
              }
            };
          UIDevicePMPlanCriteria _doubleArrow = ObjectExtensions.<UIDevicePMPlanCriteria>operator_doubleArrow(_withPagerInfo, _function);
          filterRequestRequestHandler.execute(_doubleArrow);
          
        }
      };
    this.deviceCategoryAndTypeListPresenter.onDeviceTypeSelected(_function_2);
    final Procedure1<RCDeviceTypeCategoryProxy> _function_3 = new Procedure1<RCDeviceTypeCategoryProxy>() {
        public void apply(final RCDeviceTypeCategoryProxy it) {
          DevicePMPlanSelectorView.this.criteriaForm.deviceType.setValue(null);
          Long _id = it.getId();
          String _plus = ("%[" + _id);
          String _plus_1 = (_plus + "]%");
          DevicePMPlanSelectorView.this.criteriaForm.category.setValue(_plus_1);
          UIDevicePMPlanCriteria _value = DevicePMPlanSelectorView.this.criteriaForm.getValue();
          UIDevicePMPlanCriteria _withPagerInfo = Extensions.<UIDevicePMPlanCriteria>withPagerInfo(_value, DevicePMPlanSelectorView.this.pager);
          final Procedure1<UIDevicePMPlanCriteria> _function = new Procedure1<UIDevicePMPlanCriteria>() {
              public void apply(final UIDevicePMPlanCriteria it) {
                it.setPage(Integer.valueOf(1));
              }
            };
          UIDevicePMPlanCriteria _doubleArrow = ObjectExtensions.<UIDevicePMPlanCriteria>operator_doubleArrow(_withPagerInfo, _function);
          filterRequestRequestHandler.execute(_doubleArrow);
          
        }
      };
    this.deviceCategoryAndTypeListPresenter.onDeviceTypeCategorySelected(_function_3);
    this.listGridInitializer.apply(this.listGrid);
    ContentPanel _ContentPanel = this.widgets.ContentPanel();
    final Procedure1<ContentPanel> _function_4 = new Procedure1<ContentPanel>() {
        public void apply(final ContentPanel it) {
          it.setBorders(false);
          it.setBodyBorder(false);
          HorizontalLayoutContainer _HLayout = DevicePMPlanSelectorView.this.widgets.HLayout();
          final Procedure1<HorizontalLayoutContainer> _function = new Procedure1<HorizontalLayoutContainer>() {
              public void apply(final HorizontalLayoutContainer it) {
                VerticalLayoutContainer _VLayout = DevicePMPlanSelectorView.this.widgets.VLayout();
                final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                    public void apply(final VerticalLayoutContainer it) {
                      FieldSet _FieldSet = DevicePMPlanSelectorView.this.widgets.FieldSet("\u8BBE\u5907\u7C7B\u578B");
                      final Procedure1<FieldSet> _function = new Procedure1<FieldSet>() {
                          public void apply(final FieldSet it) {
                            DeviceCategoryAndTypeListPresenterView _view = DevicePMPlanSelectorView.this.deviceCategoryAndTypeListPresenter.getView();
                            Widget _asWidget = _view.asWidget();
                            it.setWidget(_asWidget);
                          }
                        };
                      FieldSet _doubleArrow = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet, _function);
                      VerticalLayoutData _VLayoutData = DevicePMPlanSelectorView.this.widgets.VLayoutData(1, 0.5);
                      it.add(_doubleArrow, _VLayoutData);
                      FieldSet _FieldSet_1 = DevicePMPlanSelectorView.this.widgets.FieldSet("\u533A\u57DF\u4F4D\u7F6E");
                      final Procedure1<FieldSet> _function_1 = new Procedure1<FieldSet>() {
                          public void apply(final FieldSet it) {
                            OnsiteLocationOutlinePresenterView _view = DevicePMPlanSelectorView.this.onsiteLocationOutlinePresenter.getView();
                            Widget _asWidget = _view.asWidget();
                            it.setWidget(_asWidget);
                          }
                        };
                      FieldSet _doubleArrow_1 = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet_1, _function_1);
                      VerticalLayoutData _VLayoutData_1 = DevicePMPlanSelectorView.this.widgets.VLayoutData(1, 0.5);
                      it.add(_doubleArrow_1, _VLayoutData_1);
                    }
                  };
                VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                HorizontalLayoutData _HLayoutData = DevicePMPlanSelectorView.this.widgets.HLayoutData(0.2, 1);
                it.add(_doubleArrow, _HLayoutData);
                VerticalLayoutContainer _VLayout_1 = DevicePMPlanSelectorView.this.widgets.VLayout();
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
                                        FieldLabel _asWidget = DevicePMPlanSelectorView.this.criteriaForm.planDateFrom.asWidget();
                                        ClientUi.operator_add(it, _asWidget);
                                      }
                                    };
                                  ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                                  PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                                  final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                      public void apply(final PlainHTMLTD it) {
                                        FieldLabel _asWidget = DevicePMPlanSelectorView.this.criteriaForm.planDateTo.asWidget();
                                        final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                            public void apply(final FieldLabel it) {
                                              Date _day = DateUtil.today();
                                              Date _addMonths = DateUtil.addMonths(_day, 3);
                                              DevicePMPlanSelectorView.this.criteriaForm.planDateTo.setValue(_addMonths);
                                            }
                                          };
                                        FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function);
                                        ClientUi.operator_add(it, _doubleArrow);
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
                                        FieldLabel _asWidget = DevicePMPlanSelectorView.this.criteriaForm.deviceType.asWidget();
                                        ClientUi.operator_add(it, _asWidget);
                                      }
                                    };
                                  ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                                  PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                                  final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                      public void apply(final PlainHTMLTD it) {
                                        FieldLabel _asWidget = DevicePMPlanSelectorView.this.criteriaForm.pmType.asWidget();
                                        ClientUi.operator_add(it, _asWidget);
                                      }
                                    };
                                  ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                                  PlainHTMLTD _td_2 = HTMLTagsExt.td(it);
                                  final Procedure1<PlainHTMLTD> _function_2 = new Procedure1<PlainHTMLTD>() {
                                      public void apply(final PlainHTMLTD it) {
                                        TextButton _TextButton = DevicePMPlanSelectorView.this.widgets.TextButton("\u7B5B\u9009");
                                        final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                                            public void apply(final TextButton it) {
                                              it.setWidth("80px");
                                              final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                                  public void apply(final SelectEvent it) {
                                                    DevicePMPlanSelectorView.this.fireFilterRequester();
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
                      VerticalLayoutData _VLayoutData = DevicePMPlanSelectorView.this.widgets.VLayoutData(1, _minus, 10);
                      it.add(_doubleArrow, _VLayoutData);
                      IPager<UIDevicePMPlan> _createPager = edu.fudan.langlab.gxt.client.pager.Extensions.<UIDevicePMPlan>createPager(DevicePMPlanSelectorView.this.listGrid);
                      final Procedure1<IPager<UIDevicePMPlan>> _function_1 = new Procedure1<IPager<UIDevicePMPlan>>() {
                          public void apply(final IPager<UIDevicePMPlan> it) {
                            final Procedure2<Integer,Integer> _function = new Procedure2<Integer,Integer>() {
                                public void apply(final Integer pageNum, final Integer recordsPerPage) {
                                  UIDevicePMPlanCriteria _value = DevicePMPlanSelectorView.this.criteriaForm.getValue();
                                  UIDevicePMPlanCriteria _withPagerInfo = Extensions.<UIDevicePMPlanCriteria>withPagerInfo(_value, DevicePMPlanSelectorView.this.pager);
                                  final Procedure1<UIDevicePMPlanCriteria> _function = new Procedure1<UIDevicePMPlanCriteria>() {
                                      public void apply(final UIDevicePMPlanCriteria it) {
                                        it.setPage(Integer.valueOf(pageNum));
                                        it.setPageSize(Integer.valueOf(recordsPerPage));
                                      }
                                    };
                                  UIDevicePMPlanCriteria _doubleArrow = ObjectExtensions.<UIDevicePMPlanCriteria>operator_doubleArrow(_withPagerInfo, _function);
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
                      IPager<UIDevicePMPlan> _doubleArrow_1 = ObjectExtensions.<IPager<UIDevicePMPlan>>operator_doubleArrow(_createPager, _function_1);
                      DevicePMPlanSelectorView.this.pager = _doubleArrow_1;
                      ContentPanel _ContentPanel = DevicePMPlanSelectorView.this.widgets.ContentPanel();
                      final Procedure1<ContentPanel> _function_2 = new Procedure1<ContentPanel>() {
                          public void apply(final ContentPanel it) {
                            VerticalLayoutContainer _VLayout = DevicePMPlanSelectorView.this.widgets.VLayout();
                            final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                                public void apply(final VerticalLayoutContainer it) {
                                  SGroupingGrid<UIDevicePMPlan> _asWidget = DevicePMPlanSelectorView.this.listGrid.asWidget();
                                  VerticalLayoutData _VLayoutData = DevicePMPlanSelectorView.this.widgets.VLayoutData(1, 1);
                                  it.add(_asWidget, _VLayoutData);
                                }
                              };
                            VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                            it.setWidget(_doubleArrow);
                          }
                        };
                      ContentPanel _doubleArrow_2 = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function_2);
                      VerticalLayoutData _VLayoutData_1 = DevicePMPlanSelectorView.this.widgets.VLayoutData(1, 1, 10);
                      it.add(_doubleArrow_2, _VLayoutData_1);
                    }
                  };
                VerticalLayoutContainer _doubleArrow_1 = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout_1, _function_1);
                HorizontalLayoutData _HLayoutData_1 = DevicePMPlanSelectorView.this.widgets.HLayoutData(0.8, 1);
                it.add(_doubleArrow_1, _HLayoutData_1);
              }
            };
          HorizontalLayoutContainer _doubleArrow = ObjectExtensions.<HorizontalLayoutContainer>operator_doubleArrow(_HLayout, _function);
          it.setWidget(_doubleArrow);
        }
      };
    ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function_4);
    this.con = _doubleArrow;
  }
  
  public void showResults(final IPagedResult<UIDevicePMPlan> results) {
    this.pager.pageLoaded(results);
  }
  
  public Collection<RCDevicePMPlanProxy> getSelectedValues() {
    Iterable<UIDevicePMPlan> _selectedObjects = this.listGrid.getSelectedObjects();
    final Function1<UIDevicePMPlan,RCDevicePMPlanProxy> _function = new Function1<UIDevicePMPlan,RCDevicePMPlanProxy>() {
        public RCDevicePMPlanProxy apply(final UIDevicePMPlan it) {
          RCDevicePMPlanProxy _proxy = it.toProxy();
          return _proxy;
        }
      };
    Iterable<RCDevicePMPlanProxy> _map = IterableExtensions.<UIDevicePMPlan, RCDevicePMPlanProxy>map(_selectedObjects, _function);
    Collection<RCDevicePMPlanProxy> _unlazy = IterableExtensions2.<RCDevicePMPlanProxy>unlazy(_map);
    return _unlazy;
  }
  
  public void refresh() {
    int _activePage = this.pager.getActivePage();
    this.pager.gotoPage(_activePage);
  }
  
  public Size getSize() {
    Size _size = new Size(1000, 650);
    return _size;
  }
  
  public String formatDate(final Date value) {
    String _xblockexpression = null;
    {
      DateTimeFormat _format = DateTimeFormat.getFormat("yyyy/MM/dd");
      final String d = _format.format(value);
      String _xifexpression = null;
      long _time = value.getTime();
      Date _day = DateUtil.today();
      long _time_1 = _day.getTime();
      boolean _lessThan = (_time < _time_1);
      if (_lessThan) {
        String _plus = ("<B style=\'color:red;\'>" + d);
        String _plus_1 = (_plus + "</B>");
        _xifexpression = _plus_1;
      } else {
        String _xifexpression_1 = null;
        int _minus = (-2);
        Date _addMonths = DateUtil.addMonths(value, _minus);
        long _time_2 = _addMonths.getTime();
        Date _day_1 = DateUtil.today();
        long _time_3 = _day_1.getTime();
        boolean _lessThan_1 = (_time_2 < _time_3);
        if (_lessThan_1) {
          String _plus_2 = ("<B style=\'color:orange;\'>" + d);
          String _plus_3 = (_plus_2 + "</B>");
          _xifexpression_1 = _plus_3;
        } else {
          _xifexpression_1 = d;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public void setUsage(final Boolean forSelector) {
    if ((forSelector).booleanValue()) {
      final Function1<DevicePMPlan4SelectListGrid,DevicePMPlan4SelectListGrid> _function = new Function1<DevicePMPlan4SelectListGrid,DevicePMPlan4SelectListGrid>() {
          public DevicePMPlan4SelectListGrid apply(final DevicePMPlan4SelectListGrid it) {
            final Procedure1<DevicePMPlan4SelectListGrid> _function = new Procedure1<DevicePMPlan4SelectListGrid>() {
                public void apply(final DevicePMPlan4SelectListGrid it) {
                  it.asMultiSelectGrid();
                  it.unForceFit();
                  final Procedure2<UIDevicePMPlan,SafeHtmlBuilder> _function = new Procedure2<UIDevicePMPlan,SafeHtmlBuilder>() {
                      public void apply(final UIDevicePMPlan value, final SafeHtmlBuilder sb) {
                        String _description = value.getDescription();
                        String _nullsafe = StringExtensions.nullsafe(_description);
                        sb.appendEscapedLines(_nullsafe);
                      }
                    };
                  it.withExpander(_function);
                  final Procedure3<Context,Date,SafeHtmlBuilder> _function_1 = new Procedure3<Context,Date,SafeHtmlBuilder>() {
                      public void apply(final Context context, final Date value, final SafeHtmlBuilder sb) {
                        String _formatDate = DevicePMPlanSelectorView.this.formatDate(value);
                        sb.appendHtmlConstant(_formatDate);
                      }
                    };
                  it.planDate.setRender(new ICellRender<Date>() {
                      public void render(Context context,Date value,SafeHtmlBuilder sb) {
                        _function_1.apply(context,value,sb);
                      }
                  });
                }
              };
            DevicePMPlan4SelectListGrid _doubleArrow = ObjectExtensions.<DevicePMPlan4SelectListGrid>operator_doubleArrow(DevicePMPlanSelectorView.this.listGrid, _function);
            return _doubleArrow;
          }
        };
      this.listGridInitializer = _function;
    } else {
      final Function1<DevicePMPlan4SelectListGrid,DevicePMPlan4SelectListGrid> _function_1 = new Function1<DevicePMPlan4SelectListGrid,DevicePMPlan4SelectListGrid>() {
          public DevicePMPlan4SelectListGrid apply(final DevicePMPlan4SelectListGrid it) {
            final Procedure1<DevicePMPlan4SelectListGrid> _function = new Procedure1<DevicePMPlan4SelectListGrid>() {
                public void apply(final DevicePMPlan4SelectListGrid it) {
                  it.asWidget();
                  it.unForceFit();
                  final Procedure2<UIDevicePMPlan,SafeHtmlBuilder> _function = new Procedure2<UIDevicePMPlan,SafeHtmlBuilder>() {
                      public void apply(final UIDevicePMPlan value, final SafeHtmlBuilder sb) {
                        String _description = value.getDescription();
                        String _nullsafe = StringExtensions.nullsafe(_description);
                        sb.appendEscapedLines(_nullsafe);
                      }
                    };
                  it.withExpander(_function);
                  final Procedure3<Context,Date,SafeHtmlBuilder> _function_1 = new Procedure3<Context,Date,SafeHtmlBuilder>() {
                      public void apply(final Context context, final Date value, final SafeHtmlBuilder sb) {
                        String _formatDate = DevicePMPlanSelectorView.this.formatDate(value);
                        sb.appendHtmlConstant(_formatDate);
                      }
                    };
                  it.planDate.setRender(new ICellRender<Date>() {
                      public void render(Context context,Date value,SafeHtmlBuilder sb) {
                        _function_1.apply(context,value,sb);
                      }
                  });
                }
              };
            DevicePMPlan4SelectListGrid _doubleArrow = ObjectExtensions.<DevicePMPlan4SelectListGrid>operator_doubleArrow(DevicePMPlanSelectorView.this.listGrid, _function);
            return _doubleArrow;
          }
        };
      this.listGridInitializer = _function_1;
    }
  }
  
  public String getTitle() {
    return "PM\u4EFB\u52A1\u5355\u7EF4\u62A4\uFF1A\u9009\u62E9\u5F85\u5B89\u6392\u7684\u8BBE\u5907PM\u8BA1\u5212";
  }
  
  private RequestHandler1<UIDevicePMPlanCriteria> filterRequestRequestHandler;
  
  public void filterRequest(final RequestHandler1<UIDevicePMPlanCriteria> requestHandler) {
    this.filterRequestRequestHandler = requestHandler;
  }
}
