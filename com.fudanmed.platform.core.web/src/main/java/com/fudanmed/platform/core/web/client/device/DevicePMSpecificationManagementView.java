package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMPlanProxy;
import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMSpecificationProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.client.device.BatchInitializePMPlanPresenterCommand;
import com.fudanmed.platform.core.web.client.device.DeleteDevicePMPlanCommand;
import com.fudanmed.platform.core.web.client.device.DeviceCategoryAndTypeListPresenter;
import com.fudanmed.platform.core.web.client.device.DeviceCategoryAndTypeListPresenterView;
import com.fudanmed.platform.core.web.client.device.DeviceCriteriaForm;
import com.fudanmed.platform.core.web.client.device.DeviceListGrid;
import com.fudanmed.platform.core.web.client.device.DevicePMPlanListPresenter;
import com.fudanmed.platform.core.web.client.device.DevicePMPlanListPresenterView;
import com.fudanmed.platform.core.web.client.device.DevicePMSpecificationListPresenter;
import com.fudanmed.platform.core.web.client.device.DevicePMSpecificationListPresenterView;
import com.fudanmed.platform.core.web.client.device.DevicePMSpecificationManagementPresenterView;
import com.fudanmed.platform.core.web.client.device.UIDeviceCategoryAndTypeList;
import com.fudanmed.platform.core.web.client.device.UpdateDevicePMPlanCommand;
import com.fudanmed.platform.core.web.client.organization.OnsiteLocationOutlinePresenter;
import com.fudanmed.platform.core.web.client.organization.OnsiteLocationOutlinePresenterView;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.fudanmed.platform.core.web.shared.device.UIDeviceCriteria;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlan;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMSpecification;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
import com.google.common.base.Function;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FieldSet;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.ActionExtensions;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.ObjectListView.SelectEntityListener;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener;
import com.uniquesoft.gwt.client.common.widgets.pager.Extensions;
import com.uniquesoft.gwt.client.common.widgets.pager.IPager;
import com.uniquesoft.gwt.client.common.widgets.pager.IPager.GotoPageHandler;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.action.SingleObjectActions;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.widget.ContentPanel;
import edu.fudan.langlab.gxt.client.widget.FramedPanel;
import edu.fudan.langlab.gxt.client.widget.HTMLTagsExt;
import edu.fudan.langlab.gxt.client.widget.HTableLayoutContainer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.TabPanel;
import edu.fudan.langlab.security.client.Securities;
import edu.fudan.langlab.security.shared.IFunctionIdentifier;
import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

public class DevicePMSpecificationManagementView extends GWTAbstractView implements DevicePMSpecificationManagementPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(listGrid,categoryListGrid,criteriaForm,batchInitializePMPlanPresenterCommand,deleteDevicePMPlanCommand,updateDevicePMPlanCommand),
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
  
  private DevicePMPlanListPresenter devicePMPlanListPresenter;
  
  public void setDevicePMPlanListPresenter(final DevicePMPlanListPresenter devicePMPlanListPresenter) {
    this.devicePMPlanListPresenter = devicePMPlanListPresenter;
  }
  
  private DevicePMSpecificationListPresenter devicePMSpecificationListPresenter;
  
  public void setDevicePMSpecificationListPresenter(final DevicePMSpecificationListPresenter devicePMSpecificationListPresenter) {
    this.devicePMSpecificationListPresenter = devicePMSpecificationListPresenter;
  }
  
  @Inject
  private DeviceListGrid listGrid;
  
  @Inject
  private UIDeviceCategoryAndTypeList categoryListGrid;
  
  @Inject
  private DeviceCriteriaForm criteriaForm;
  
  @Inject
  private BatchInitializePMPlanPresenterCommand batchInitializePMPlanPresenterCommand;
  
  @Inject
  private DeleteDevicePMPlanCommand deleteDevicePMPlanCommand;
  
  @Inject
  private UpdateDevicePMPlanCommand updateDevicePMPlanCommand;
  
  private IPager pager;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    this.listGrid.asWidget();
    this.listGrid.keepSelection();
    final ActionContext<UIDevice> deviceAc = ActionExtensions.<UIDevice>createActionContext(this.listGrid);
    OnsiteLocationOutlinePresenterView _view = this.onsiteLocationOutlinePresenter.getView();
    final ActionContext<UIOnsitePosition> locationAc = _view.getActionContext();
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u8BBE\u5907PM\u8BA1\u5212\u7BA1\u7406");
    final Procedure1<FramedPanel> _function = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          HorizontalLayoutContainer _HLayout = DevicePMSpecificationManagementView.this.widgets.HLayout();
          final Procedure1<HorizontalLayoutContainer> _function = new Procedure1<HorizontalLayoutContainer>() {
              public void apply(final HorizontalLayoutContainer it) {
                VerticalLayoutContainer _VLayout = DevicePMSpecificationManagementView.this.widgets.VLayout();
                final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                    public void apply(final VerticalLayoutContainer it) {
                      FieldSet _FieldSet = DevicePMSpecificationManagementView.this.widgets.FieldSet("\u8BBE\u5907\u7C7B\u578B");
                      final Procedure1<FieldSet> _function = new Procedure1<FieldSet>() {
                          public void apply(final FieldSet it) {
                            ContentPanel _ContentPanel = DevicePMSpecificationManagementView.this.widgets.ContentPanel();
                            final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
                                public void apply(final ContentPanel it) {
                                  DeviceCategoryAndTypeListPresenterView _view = DevicePMSpecificationManagementView.this.deviceCategoryAndTypeListPresenter.getView();
                                  Widget _asWidget = _view.asWidget();
                                  it.setWidget(_asWidget);
                                }
                              };
                            ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
                            it.setWidget(_doubleArrow);
                          }
                        };
                      FieldSet _doubleArrow = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet, _function);
                      VerticalLayoutData _VLayoutData = DevicePMSpecificationManagementView.this.widgets.VLayoutData(1, 0.5);
                      it.add(_doubleArrow, _VLayoutData);
                      FieldSet _FieldSet_1 = DevicePMSpecificationManagementView.this.widgets.FieldSet("\u533A\u57DF\u4F4D\u7F6E");
                      final Procedure1<FieldSet> _function_1 = new Procedure1<FieldSet>() {
                          public void apply(final FieldSet it) {
                            ContentPanel _ContentPanel = DevicePMSpecificationManagementView.this.widgets.ContentPanel();
                            final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
                                public void apply(final ContentPanel it) {
                                  OnsiteLocationOutlinePresenterView _view = DevicePMSpecificationManagementView.this.onsiteLocationOutlinePresenter.getView();
                                  Widget _asWidget = _view.asWidget();
                                  it.setWidget(_asWidget);
                                }
                              };
                            ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
                            it.setWidget(_doubleArrow);
                          }
                        };
                      FieldSet _doubleArrow_1 = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet_1, _function_1);
                      VerticalLayoutData _VLayoutData_1 = DevicePMSpecificationManagementView.this.widgets.VLayoutData(1, 0.5);
                      it.add(_doubleArrow_1, _VLayoutData_1);
                    }
                  };
                VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                HorizontalLayoutData _HLayoutData = DevicePMSpecificationManagementView.this.widgets.HLayoutData(200, 1, 0);
                it.add(_doubleArrow, _HLayoutData);
                final Procedure1<Iterable<UIOnsitePosition>> _function_1 = new Procedure1<Iterable<UIOnsitePosition>>() {
                    public void apply(final Iterable<UIOnsitePosition> selected) {
                      Iterable<UIOnsitePosition> _selectedObjects = locationAc.getSelectedObjects();
                      UIOnsitePosition _head = IterableExtensions.<UIOnsitePosition>head(_selectedObjects);
                      RCOnsitePositionProxy _proxy = _head==null?(RCOnsitePositionProxy)null:_head.toProxy();
                      DevicePMSpecificationManagementView.this.criteriaForm.location.setValue(_proxy);
                      UIDeviceCriteria _value = DevicePMSpecificationManagementView.this.criteriaForm.getValue();
                      UIDeviceCriteria _withPagerInfo = Extensions.<UIDeviceCriteria>withPagerInfo(_value, DevicePMSpecificationManagementView.this.pager);
                      final Procedure1<UIDeviceCriteria> _function = new Procedure1<UIDeviceCriteria>() {
                          public void apply(final UIDeviceCriteria it) {
                            it.setPage(Integer.valueOf(1));
                          }
                        };
                      UIDeviceCriteria _doubleArrow = ObjectExtensions.<UIDeviceCriteria>operator_doubleArrow(_withPagerInfo, _function);
                      filterRequestRequestHandler.execute(_doubleArrow);
                      
                    }
                  };
                locationAc.addSelectionChangedListener(new SelectionChangedListener<UIOnsitePosition>() {
                    public void selectionChanged(Iterable<UIOnsitePosition> selections) {
                      _function_1.apply(selections);
                    }
                });
                final Procedure1<Void> _function_2 = new Procedure1<Void>() {
                    public void apply(final Void it) {
                      DevicePMSpecificationManagementView.this.criteriaForm.deviceType.setValue(null);
                      DevicePMSpecificationManagementView.this.criteriaForm.category.setValue(null);
                      UIDeviceCriteria _value = DevicePMSpecificationManagementView.this.criteriaForm.getValue();
                      UIDeviceCriteria _withPagerInfo = Extensions.<UIDeviceCriteria>withPagerInfo(_value, DevicePMSpecificationManagementView.this.pager);
                      final Procedure1<UIDeviceCriteria> _function = new Procedure1<UIDeviceCriteria>() {
                          public void apply(final UIDeviceCriteria it) {
                            it.setPage(Integer.valueOf(1));
                          }
                        };
                      UIDeviceCriteria _doubleArrow = ObjectExtensions.<UIDeviceCriteria>operator_doubleArrow(_withPagerInfo, _function);
                      filterRequestRequestHandler.execute(_doubleArrow);
                      
                    }
                  };
                DevicePMSpecificationManagementView.this.deviceCategoryAndTypeListPresenter.onUnselected(_function_2);
                final Procedure1<RCDeviceTypeProxy> _function_3 = new Procedure1<RCDeviceTypeProxy>() {
                    public void apply(final RCDeviceTypeProxy it) {
                      DevicePMSpecificationManagementView.this.criteriaForm.deviceType.setValue(it);
                      DevicePMSpecificationManagementView.this.criteriaForm.category.setValue(null);
                      UIDeviceCriteria _value = DevicePMSpecificationManagementView.this.criteriaForm.getValue();
                      UIDeviceCriteria _withPagerInfo = Extensions.<UIDeviceCriteria>withPagerInfo(_value, DevicePMSpecificationManagementView.this.pager);
                      final Procedure1<UIDeviceCriteria> _function = new Procedure1<UIDeviceCriteria>() {
                          public void apply(final UIDeviceCriteria it) {
                            it.setPage(Integer.valueOf(1));
                          }
                        };
                      UIDeviceCriteria _doubleArrow = ObjectExtensions.<UIDeviceCriteria>operator_doubleArrow(_withPagerInfo, _function);
                      filterRequestRequestHandler.execute(_doubleArrow);
                      
                    }
                  };
                DevicePMSpecificationManagementView.this.deviceCategoryAndTypeListPresenter.onDeviceTypeSelected(_function_3);
                final Procedure1<RCDeviceTypeCategoryProxy> _function_4 = new Procedure1<RCDeviceTypeCategoryProxy>() {
                    public void apply(final RCDeviceTypeCategoryProxy it) {
                      DevicePMSpecificationManagementView.this.criteriaForm.deviceType.setValue(null);
                      Long _id = it.getId();
                      String _plus = ("%[" + _id);
                      String _plus_1 = (_plus + "]%");
                      DevicePMSpecificationManagementView.this.criteriaForm.category.setValue(_plus_1);
                      UIDeviceCriteria _value = DevicePMSpecificationManagementView.this.criteriaForm.getValue();
                      UIDeviceCriteria _withPagerInfo = Extensions.<UIDeviceCriteria>withPagerInfo(_value, DevicePMSpecificationManagementView.this.pager);
                      final Procedure1<UIDeviceCriteria> _function = new Procedure1<UIDeviceCriteria>() {
                          public void apply(final UIDeviceCriteria it) {
                            it.setPage(Integer.valueOf(1));
                          }
                        };
                      UIDeviceCriteria _doubleArrow = ObjectExtensions.<UIDeviceCriteria>operator_doubleArrow(_withPagerInfo, _function);
                      filterRequestRequestHandler.execute(_doubleArrow);
                      
                    }
                  };
                DevicePMSpecificationManagementView.this.deviceCategoryAndTypeListPresenter.onDeviceTypeCategorySelected(_function_4);
                ContentPanel _ContentPanel = DevicePMSpecificationManagementView.this.widgets.ContentPanel();
                final Procedure1<ContentPanel> _function_5 = new Procedure1<ContentPanel>() {
                    public void apply(final ContentPanel it) {
                      it.setBodyBorder(false);
                      BorderLayoutContainer _BorderLayout = DevicePMSpecificationManagementView.this.widgets.BorderLayout();
                      final Procedure1<BorderLayoutContainer> _function = new Procedure1<BorderLayoutContainer>() {
                          public void apply(final BorderLayoutContainer it) {
                            final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
                                public VerticalLayoutContainer apply(final Void it) {
                                  VerticalLayoutContainer _VLayout = DevicePMSpecificationManagementView.this.widgets.VLayout();
                                  final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                                      public void apply(final VerticalLayoutContainer it) {
                                        HTableLayoutContainer _HTableLayout = DevicePMSpecificationManagementView.this.widgets.HTableLayout();
                                        final Procedure1<HTableLayoutContainer> _function = new Procedure1<HTableLayoutContainer>() {
                                            public void apply(final HTableLayoutContainer it) {
                                              FieldLabel _asWidget = DevicePMSpecificationManagementView.this.criteriaForm.sid.asWidget();
                                              TextButton _TextButton = DevicePMSpecificationManagementView.this.widgets.TextButton("\u7B5B\u9009");
                                              final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                                                  public void apply(final TextButton it) {
                                                    it.setWidth("80px");
                                                    final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                                        public void apply(final SelectEvent it) {
                                                          UIDeviceCriteria _value = DevicePMSpecificationManagementView.this.criteriaForm.getValue();
                                                          UIDeviceCriteria _withPagerInfo = Extensions.<UIDeviceCriteria>withPagerInfo(_value, DevicePMSpecificationManagementView.this.pager);
                                                          final Procedure1<UIDeviceCriteria> _function = new Procedure1<UIDeviceCriteria>() {
                                                              public void apply(final UIDeviceCriteria it) {
                                                                it.setPage(Integer.valueOf(1));
                                                              }
                                                            };
                                                          UIDeviceCriteria _doubleArrow = ObjectExtensions.<UIDeviceCriteria>operator_doubleArrow(_withPagerInfo, _function);
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
                                        IPager<UIDevice> _createPager = edu.fudan.langlab.gxt.client.pager.Extensions.<UIDevice>createPager(DevicePMSpecificationManagementView.this.listGrid);
                                        final Procedure1<IPager<UIDevice>> _function_1 = new Procedure1<IPager<UIDevice>>() {
                                            public void apply(final IPager<UIDevice> it) {
                                              final Procedure2<Integer,Integer> _function = new Procedure2<Integer,Integer>() {
                                                  public void apply(final Integer pageNum, final Integer recordsPerPage) {
                                                    UIDeviceCriteria _value = DevicePMSpecificationManagementView.this.criteriaForm.getValue();
                                                    UIDeviceCriteria _withPagerInfo = Extensions.<UIDeviceCriteria>withPagerInfo(_value, DevicePMSpecificationManagementView.this.pager);
                                                    final Procedure1<UIDeviceCriteria> _function = new Procedure1<UIDeviceCriteria>() {
                                                        public void apply(final UIDeviceCriteria it) {
                                                          it.setPage(Integer.valueOf(pageNum));
                                                          it.setPageSize(Integer.valueOf(recordsPerPage));
                                                        }
                                                      };
                                                    UIDeviceCriteria _doubleArrow = ObjectExtensions.<UIDeviceCriteria>operator_doubleArrow(_withPagerInfo, _function);
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
                                        IPager<UIDevice> _doubleArrow_1 = ObjectExtensions.<IPager<UIDevice>>operator_doubleArrow(_createPager, _function_1);
                                        DevicePMSpecificationManagementView.this.pager = _doubleArrow_1;
                                        ContentPanel _ContentPanel = DevicePMSpecificationManagementView.this.widgets.ContentPanel();
                                        final Procedure1<ContentPanel> _function_2 = new Procedure1<ContentPanel>() {
                                            public void apply(final ContentPanel it) {
                                              VerticalLayoutContainer _VLayout = DevicePMSpecificationManagementView.this.widgets.VLayout();
                                              final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                                                  public void apply(final VerticalLayoutContainer it) {
                                                    SGroupingGrid<UIDevice> _asWidget = DevicePMSpecificationManagementView.this.listGrid.asWidget();
                                                    VerticalLayoutData _VLayoutData = DevicePMSpecificationManagementView.this.widgets.VLayoutData(1, 1);
                                                    it.add(_asWidget, _VLayoutData);
                                                    Widget _asWidget_1 = DevicePMSpecificationManagementView.this.pager.asWidget();
                                                    int _minus = (-1);
                                                    VerticalLayoutData _VLayoutData_1 = DevicePMSpecificationManagementView.this.widgets.VLayoutData(1, _minus);
                                                    it.add(_asWidget_1, _VLayoutData_1);
                                                  }
                                                };
                                              VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                                              it.setWidget(_doubleArrow);
                                              final Function0<UIDeviceCriteria> _function_1 = new Function0<UIDeviceCriteria>() {
                                                  public UIDeviceCriteria apply() {
                                                    UIDeviceCriteria _value = DevicePMSpecificationManagementView.this.criteriaForm.getValue();
                                                    return _value;
                                                  }
                                                };
                                              it.<UIDeviceCriteria>addCommand(_function_1, DevicePMSpecificationManagementView.this.batchInitializePMPlanPresenterCommand);
                                            }
                                          };
                                        ContentPanel _doubleArrow_2 = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function_2);
                                        VerticalLayoutData _VLayoutData = DevicePMSpecificationManagementView.this.widgets.VLayoutData(1, 1);
                                        it.add(_doubleArrow_2, _VLayoutData);
                                      }
                                    };
                                  VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                                  return _doubleArrow;
                                }
                              };
                            HTMLTagsExt.center(it, _function);
                            final Function1<Void,ContentPanel> _function_1 = new Function1<Void,ContentPanel>() {
                                public ContentPanel apply(final Void it) {
                                  ContentPanel _ContentPanel = DevicePMSpecificationManagementView.this.widgets.ContentPanel();
                                  final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
                                      public void apply(final ContentPanel it) {
                                        TabPanel _TabPanel = DevicePMSpecificationManagementView.this.widgets.TabPanel();
                                        final Procedure1<TabPanel> _function = new Procedure1<TabPanel>() {
                                            public void apply(final TabPanel it) {
                                              ContentPanel _ContentPanel = DevicePMSpecificationManagementView.this.widgets.ContentPanel();
                                              final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
                                                  public void apply(final ContentPanel pmspecs) {
                                                    it.setBodyBorder(false);
                                                    DevicePMSpecificationListPresenterView _view = DevicePMSpecificationManagementView.this.devicePMSpecificationListPresenter.getView();
                                                    Widget _asWidget = _view.asWidget();
                                                    pmspecs.add(_asWidget);
                                                    DevicePMSpecificationListPresenterView _view_1 = DevicePMSpecificationManagementView.this.devicePMSpecificationListPresenter.getView();
                                                    final ActionContext<UIDevicePMSpecification> ac = _view_1.getActionContext();
                                                    final Procedure1<Void> _function = new Procedure1<Void>() {
                                                        public void apply(final Void v) {
                                                          final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                                              public void apply(final SingleObjectActions it) {
                                                                final Procedure1<UIDevice> _function = new Procedure1<UIDevice>() {
                                                                    public void apply(final UIDevice device) {
                                                                      RCDeviceProxy _proxy = device.toProxy();
                                                                      final Procedure1<RCDeviceProxy> _function = new Procedure1<RCDeviceProxy>() {
                                                                          public void apply(final RCDeviceProxy it) {
                                                                            String _sid = device.getSid();
                                                                            String _plus = (_sid + ",");
                                                                            String _name = device.getName();
                                                                            String _plus_1 = (_plus + _name);
                                                                            it.setName(_plus_1);
                                                                          }
                                                                        };
                                                                      RCDeviceProxy _doubleArrow = ObjectExtensions.<RCDeviceProxy>operator_doubleArrow(_proxy, _function);
                                                                      createRequestRequestHandler.execute(_doubleArrow);
                                                                      
                                                                    }
                                                                  };
                                                                it.onExecute(_function);
                                                              }
                                                            };
                                                          SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIDevice>onSingleObjectAction(deviceAc, _function);
                                                          TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u65B0\u5EFA");
                                                          pmspecs.addButton(_asButtonRequester);
                                                        }
                                                      };
                                                    DevicePMSpecificationManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                                                      public IFunctionIdentifier apply() {
                                                        return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.device.DevicePMSpecificationManagementPresenter.createRequest" );
                                                      }
                                                    }.apply(), _function);
                                                    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
                                                        public void apply(final Void v) {
                                                          final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                                              public void apply(final SingleObjectActions it) {
                                                                final Procedure1<UIDevicePMSpecification> _function = new Procedure1<UIDevicePMSpecification>() {
                                                                    public void apply(final UIDevicePMSpecification selectedValue) {
                                                                      RCDevicePMSpecificationProxy _proxy = selectedValue.toProxy();
                                                                      modifyRequestRequestHandler.execute(_proxy);
                                                                      
                                                                    }
                                                                  };
                                                                it.onExecute(_function);
                                                              }
                                                            };
                                                          SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIDevicePMSpecification>onSingleObjectAction(ac, _function);
                                                          TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u4FEE\u6539");
                                                          pmspecs.addButton(_asButtonRequester);
                                                        }
                                                      };
                                                    DevicePMSpecificationManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                                                      public IFunctionIdentifier apply() {
                                                        return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.device.DevicePMSpecificationManagementPresenter.modifyRequest" );
                                                      }
                                                    }.apply(), _function_1);
                                                    final Procedure1<Void> _function_2 = new Procedure1<Void>() {
                                                        public void apply(final Void v) {
                                                          final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                                              public void apply(final SingleObjectActions it) {
                                                                final Procedure1<UIDevicePMSpecification> _function = new Procedure1<UIDevicePMSpecification>() {
                                                                    public void apply(final UIDevicePMSpecification selectedValue) {
                                                                      RCDevicePMSpecificationProxy _proxy = selectedValue.toProxy();
                                                                      initPM4DeviceRequestRequestHandler.execute(_proxy);
                                                                      
                                                                    }
                                                                  };
                                                                it.onExecute(_function);
                                                              }
                                                            };
                                                          SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIDevicePMSpecification>onSingleObjectAction(ac, _function);
                                                          TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u751F\u6210PM\u8BA1\u5212");
                                                          pmspecs.addButton(_asButtonRequester);
                                                        }
                                                      };
                                                    DevicePMSpecificationManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                                                      public IFunctionIdentifier apply() {
                                                        return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.device.DevicePMSpecificationManagementPresenter.initPM4DeviceRequest" );
                                                      }
                                                    }.apply(), _function_2);
                                                    final Procedure1<Void> _function_3 = new Procedure1<Void>() {
                                                        public void apply(final Void v) {
                                                          final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                                              public void apply(final SingleObjectActions it) {
                                                                final Procedure1<UIDevicePMSpecification> _function = new Procedure1<UIDevicePMSpecification>() {
                                                                    public void apply(final UIDevicePMSpecification selectedValue) {
                                                                      final Procedure1<Void> _function = new Procedure1<Void>() {
                                                                          public void apply(final Void it) {
                                                                            RCDevicePMSpecificationProxy _proxy = selectedValue.toProxy();
                                                                            deleteRequestRequestHandler.execute(_proxy);
                                                                            
                                                                          }
                                                                        };
                                                                      ConfirmMessageBox _ConfirmMessageBox = DevicePMSpecificationManagementView.this.widgets.ConfirmMessageBox("\u786E\u8BA4", "\u786E\u8BA4\u5220\u9664", _function);
                                                                      _ConfirmMessageBox.show();
                                                                    }
                                                                  };
                                                                it.onExecute(_function);
                                                              }
                                                            };
                                                          SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIDevicePMSpecification>onSingleObjectAction(ac, _function);
                                                          TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u5220\u9664");
                                                          pmspecs.addButton(_asButtonRequester);
                                                        }
                                                      };
                                                    DevicePMSpecificationManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                                                      public IFunctionIdentifier apply() {
                                                        return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.device.DevicePMSpecificationManagementPresenter.deleteRequest" );
                                                      }
                                                    }.apply(), _function_3);
                                                  }
                                                };
                                              ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
                                              it.add(_doubleArrow, "PM\u8BA1\u5212\u7C7B\u578B");
                                              ContentPanel _ContentPanel_1 = DevicePMSpecificationManagementView.this.widgets.ContentPanel();
                                              final Procedure1<ContentPanel> _function_1 = new Procedure1<ContentPanel>() {
                                                  public void apply(final ContentPanel it) {
                                                    DevicePMPlanListPresenterView _view = DevicePMSpecificationManagementView.this.devicePMPlanListPresenter.getView();
                                                    final ActionContext<UIDevicePMPlan> pac = _view.getActionContext();
                                                    final Function1<UIDevicePMPlan,RCDevicePMPlanProxy> _function = new Function1<UIDevicePMPlan,RCDevicePMPlanProxy>() {
                                                        public RCDevicePMPlanProxy apply(final UIDevicePMPlan it) {
                                                          RCDevicePMPlanProxy _proxy = it.toProxy();
                                                          return _proxy;
                                                        }
                                                      };
                                                    final ActionContext<RCDevicePMPlanProxy> pmac = pac.<RCDevicePMPlanProxy>adapt(new Function<UIDevicePMPlan,RCDevicePMPlanProxy>() {
                                                        public RCDevicePMPlanProxy apply(UIDevicePMPlan input) {
                                                          return _function.apply(input);
                                                        }
                                                    });
                                                    DevicePMPlanListPresenterView _view_1 = DevicePMSpecificationManagementView.this.devicePMPlanListPresenter.getView();
                                                    Widget _asWidget = _view_1.asWidget();
                                                    it.setWidget(_asWidget);
                                                    it.addCommand(pmac, DevicePMSpecificationManagementView.this.updateDevicePMPlanCommand);
                                                    it.addCommand(pac, DevicePMSpecificationManagementView.this.deleteDevicePMPlanCommand);
                                                  }
                                                };
                                              ContentPanel _doubleArrow_1 = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel_1, _function_1);
                                              it.add(_doubleArrow_1, "PM\u8BA1\u5212\u6E05\u5355");
                                            }
                                          };
                                        TabPanel _doubleArrow = ObjectExtensions.<TabPanel>operator_doubleArrow(_TabPanel, _function);
                                        it.setWidget(_doubleArrow);
                                      }
                                    };
                                  ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
                                  return _doubleArrow;
                                }
                              };
                            HTMLTagsExt.south(it, 0.4, _function_1);
                          }
                        };
                      BorderLayoutContainer _doubleArrow = ObjectExtensions.<BorderLayoutContainer>operator_doubleArrow(_BorderLayout, _function);
                      it.setWidget(_doubleArrow);
                    }
                  };
                ContentPanel _doubleArrow_1 = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function_5);
                HorizontalLayoutData _HLayoutData_1 = DevicePMSpecificationManagementView.this.widgets.HLayoutData(1, 1, 0);
                it.add(_doubleArrow_1, _HLayoutData_1);
                final Procedure1<UIDevice> _function_6 = new Procedure1<UIDevice>() {
                    public void apply(final UIDevice it) {
                      RCDeviceProxy _proxy = it.toProxy();
                      deviceSelectedRequestHandler.execute(_proxy);
                      
                    }
                  };
                DevicePMSpecificationManagementView.this.listGrid.addSelectEntityListener(new SelectEntityListener<UIDevice>() {
                    public void objectSelected(UIDevice selected) {
                      _function_6.apply(selected);
                    }
                });
              }
            };
          HorizontalLayoutContainer _doubleArrow = ObjectExtensions.<HorizontalLayoutContainer>operator_doubleArrow(_HLayout, _function);
          it.setWidget(_doubleArrow);
        }
      };
    FramedPanel _doubleArrow = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function);
    this.con = _doubleArrow;
  }
  
  public void showResults(final IPagedResult<UIDevice> results) {
    this.pager.pageLoaded(results);
  }
  
  public void refresh() {
    int _activePage = this.pager.getActivePage();
    this.pager.gotoPage(_activePage);
  }
  
  private RequestHandler1<RCDeviceProxy> createRequestRequestHandler;
  
  public void createRequest(final RequestHandler1<RCDeviceProxy> requestHandler) {
    this.createRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCDevicePMSpecificationProxy> deleteRequestRequestHandler;
  
  public void deleteRequest(final RequestHandler1<RCDevicePMSpecificationProxy> requestHandler) {
    this.deleteRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCDevicePMSpecificationProxy> modifyRequestRequestHandler;
  
  public void modifyRequest(final RequestHandler1<RCDevicePMSpecificationProxy> requestHandler) {
    this.modifyRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<UIDeviceCriteria> filterRequestRequestHandler;
  
  public void filterRequest(final RequestHandler1<UIDeviceCriteria> requestHandler) {
    this.filterRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCDevicePMSpecificationProxy> initPM4DeviceRequestRequestHandler;
  
  public void initPM4DeviceRequest(final RequestHandler1<RCDevicePMSpecificationProxy> requestHandler) {
    this.initPM4DeviceRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCDevicePMSpecificationProxy> pmSpecSelectedRequestHandler;
  
  public void pmSpecSelected(final RequestHandler1<RCDevicePMSpecificationProxy> requestHandler) {
    this.pmSpecSelectedRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCDeviceProxy> deviceSelectedRequestHandler;
  
  public void deviceSelected(final RequestHandler1<RCDeviceProxy> requestHandler) {
    this.deviceSelectedRequestHandler = requestHandler;
  }
}
