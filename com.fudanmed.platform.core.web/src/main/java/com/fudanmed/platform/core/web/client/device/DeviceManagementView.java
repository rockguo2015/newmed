package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.device.proxy.DeviceFileContainerProxy;
import com.fudanmed.platform.core.device.proxy.DevicePictureContainerProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.client.device.AttributeSlotTreeListPresenter;
import com.fudanmed.platform.core.web.client.device.AttributeSlotTreeListPresenterView;
import com.fudanmed.platform.core.web.client.device.CreateDeviceDocumentStorageCommand;
import com.fudanmed.platform.core.web.client.device.CreateDevicePictureCommand;
import com.fudanmed.platform.core.web.client.device.DeleteDeviceDocumentStorageCommand;
import com.fudanmed.platform.core.web.client.device.DeleteDevicePictureCommand;
import com.fudanmed.platform.core.web.client.device.DeviceCategoryAndTypeListPresenter;
import com.fudanmed.platform.core.web.client.device.DeviceCategoryAndTypeListPresenterView;
import com.fudanmed.platform.core.web.client.device.DeviceCriteriaForm;
import com.fudanmed.platform.core.web.client.device.DeviceListGrid;
import com.fudanmed.platform.core.web.client.device.DeviceManagementPresenterView;
import com.fudanmed.platform.core.web.client.device.DevicePMPlanAssignmentListPresenter;
import com.fudanmed.platform.core.web.client.device.DevicePMPlanAssignmentListPresenterView;
import com.fudanmed.platform.core.web.client.device.DevicePMPlanList4DevicePresenter;
import com.fudanmed.platform.core.web.client.device.DevicePMPlanList4DevicePresenterView;
import com.fudanmed.platform.core.web.client.device.DevicePropertyPresenter;
import com.fudanmed.platform.core.web.client.device.DevicePropertyPresenterView;
import com.fudanmed.platform.core.web.client.device.DocumentStorageListPresenter;
import com.fudanmed.platform.core.web.client.device.DocumentStorageListPresenterView;
import com.fudanmed.platform.core.web.client.device.ExportDeviceCommand;
import com.fudanmed.platform.core.web.client.device.PictureListPresenter;
import com.fudanmed.platform.core.web.client.device.PictureListPresenterView;
import com.fudanmed.platform.core.web.client.device.UpdateDeviceDocumentStorageCommand;
import com.fudanmed.platform.core.web.client.device.UpdateDevicePictureCommand;
import com.fudanmed.platform.core.web.client.device.UploadDeviceCommand;
import com.fudanmed.platform.core.web.client.organization.OnsiteLocationOutlinePresenter;
import com.fudanmed.platform.core.web.client.organization.OnsiteLocationOutlinePresenterView;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.fudanmed.platform.core.web.shared.device.UIDeviceCategoryAndType;
import com.fudanmed.platform.core.web.shared.device.UIDeviceCategoryOrTypeType;
import com.fudanmed.platform.core.web.shared.device.UIDeviceCriteria;
import com.fudanmed.platform.core.web.shared.device.UIDocumentStorage;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FieldSet;
import com.uniquesoft.gwt.client.common.RequestHandler;
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
import edu.fudan.langlab.domain.document.proxy.DocumentStorageProxy;
import edu.fudan.langlab.gxt.client.action.SingleObjectActions;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.widget.ContentPanel;
import edu.fudan.langlab.gxt.client.widget.FramedPanel;
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

public class DeviceManagementView extends GWTAbstractView implements DeviceManagementPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(listGrid,criteriaForm,createDeviceDocmentStorageCommand,updateDeviceDocmentStorageCommand,deleteDeviceDocmentStorageCommand,createDevicePictureCommand,updateDevicePictureCommand,deleteDevicePictureCommand,uploadDeviceCommand,exportDeviceCommand),
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
  
  private AttributeSlotTreeListPresenter attributeSlotTreeListPresenter;
  
  public void setAttributeSlotTreeListPresenter(final AttributeSlotTreeListPresenter attributeSlotTreeListPresenter) {
    this.attributeSlotTreeListPresenter = attributeSlotTreeListPresenter;
  }
  
  private DevicePropertyPresenter devicePropertyPresenter;
  
  public void setDevicePropertyPresenter(final DevicePropertyPresenter devicePropertyPresenter) {
    this.devicePropertyPresenter = devicePropertyPresenter;
  }
  
  private DevicePMPlanList4DevicePresenter devicePMPlanList4DevicePresenter;
  
  public void setDevicePMPlanList4DevicePresenter(final DevicePMPlanList4DevicePresenter devicePMPlanList4DevicePresenter) {
    this.devicePMPlanList4DevicePresenter = devicePMPlanList4DevicePresenter;
  }
  
  private DocumentStorageListPresenter deviceDocumentStorageListPresenter;
  
  public void setDeviceDocumentStorageListPresenter(final DocumentStorageListPresenter deviceDocumentStorageListPresenter) {
    this.deviceDocumentStorageListPresenter = deviceDocumentStorageListPresenter;
  }
  
  private PictureListPresenter devicepictureListPresenter;
  
  public void setDevicepictureListPresenter(final PictureListPresenter devicepictureListPresenter) {
    this.devicepictureListPresenter = devicepictureListPresenter;
  }
  
  private OnsiteLocationOutlinePresenter onsiteLocationOutlinePresenter;
  
  public void setOnsiteLocationOutlinePresenter(final OnsiteLocationOutlinePresenter onsiteLocationOutlinePresenter) {
    this.onsiteLocationOutlinePresenter = onsiteLocationOutlinePresenter;
  }
  
  private DeviceCategoryAndTypeListPresenter deviceCategoryAndTypeListPresenter;
  
  public void setDeviceCategoryAndTypeListPresenter(final DeviceCategoryAndTypeListPresenter deviceCategoryAndTypeListPresenter) {
    this.deviceCategoryAndTypeListPresenter = deviceCategoryAndTypeListPresenter;
  }
  
  private DevicePMPlanAssignmentListPresenter devicePMPlanAssignmentListPresenter;
  
  public void setDevicePMPlanAssignmentListPresenter(final DevicePMPlanAssignmentListPresenter devicePMPlanAssignmentListPresenter) {
    this.devicePMPlanAssignmentListPresenter = devicePMPlanAssignmentListPresenter;
  }
  
  @Inject
  private DeviceListGrid listGrid;
  
  @Inject
  private DeviceCriteriaForm criteriaForm;
  
  @Inject
  private CreateDeviceDocumentStorageCommand createDeviceDocmentStorageCommand;
  
  @Inject
  private UpdateDeviceDocumentStorageCommand updateDeviceDocmentStorageCommand;
  
  @Inject
  private DeleteDeviceDocumentStorageCommand deleteDeviceDocmentStorageCommand;
  
  @Inject
  private CreateDevicePictureCommand createDevicePictureCommand;
  
  @Inject
  private UpdateDevicePictureCommand updateDevicePictureCommand;
  
  @Inject
  private DeleteDevicePictureCommand deleteDevicePictureCommand;
  
  @Inject
  private UploadDeviceCommand uploadDeviceCommand;
  
  @Inject
  private ExportDeviceCommand exportDeviceCommand;
  
  private IPager pager;
  
  private ActionContext<UIOnsitePosition> locationAc;
  
  private ActionContext<UIDeviceCategoryAndType> deviceCategoryAndTypeAC;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    this.listGrid.asWidget();
    final ActionContext<UIDevice> ac = ActionExtensions.<UIDevice>createActionContext(this.listGrid);
    OnsiteLocationOutlinePresenterView _view = this.onsiteLocationOutlinePresenter.getView();
    ActionContext<UIOnsitePosition> _actionContext = _view.getActionContext();
    this.locationAc = _actionContext;
    DeviceCategoryAndTypeListPresenterView _view_1 = this.deviceCategoryAndTypeListPresenter.getView();
    ActionContext<UIDeviceCategoryAndType> _actionContext_1 = _view_1.getActionContext();
    this.deviceCategoryAndTypeAC = _actionContext_1;
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u8BBE\u5907\u7BA1\u7406");
    final Procedure1<FramedPanel> _function = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          HorizontalLayoutContainer _HLayout = DeviceManagementView.this.widgets.HLayout();
          final Procedure1<HorizontalLayoutContainer> _function = new Procedure1<HorizontalLayoutContainer>() {
              public void apply(final HorizontalLayoutContainer it) {
                VerticalLayoutContainer _VLayout = DeviceManagementView.this.widgets.VLayout();
                final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                    public void apply(final VerticalLayoutContainer it) {
                      FieldSet _FieldSet = DeviceManagementView.this.widgets.FieldSet("\u8BBE\u5907\u7C7B\u578B");
                      final Procedure1<FieldSet> _function = new Procedure1<FieldSet>() {
                          public void apply(final FieldSet it) {
                            ContentPanel _ContentPanel = DeviceManagementView.this.widgets.ContentPanel();
                            final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
                                public void apply(final ContentPanel it) {
                                  DeviceCategoryAndTypeListPresenterView _view = DeviceManagementView.this.deviceCategoryAndTypeListPresenter.getView();
                                  Widget _asWidget = _view.asWidget();
                                  it.setWidget(_asWidget);
                                }
                              };
                            ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
                            it.setWidget(_doubleArrow);
                          }
                        };
                      FieldSet _doubleArrow = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet, _function);
                      VerticalLayoutData _VLayoutData = DeviceManagementView.this.widgets.VLayoutData(1, 0.5);
                      it.add(_doubleArrow, _VLayoutData);
                      FieldSet _FieldSet_1 = DeviceManagementView.this.widgets.FieldSet("\u533A\u57DF\u4F4D\u7F6E");
                      final Procedure1<FieldSet> _function_1 = new Procedure1<FieldSet>() {
                          public void apply(final FieldSet it) {
                            ContentPanel _ContentPanel = DeviceManagementView.this.widgets.ContentPanel();
                            final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
                                public void apply(final ContentPanel it) {
                                  OnsiteLocationOutlinePresenterView _view = DeviceManagementView.this.onsiteLocationOutlinePresenter.getView();
                                  Widget _asWidget = _view.asWidget();
                                  it.setWidget(_asWidget);
                                }
                              };
                            ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
                            it.setWidget(_doubleArrow);
                          }
                        };
                      FieldSet _doubleArrow_1 = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet_1, _function_1);
                      VerticalLayoutData _VLayoutData_1 = DeviceManagementView.this.widgets.VLayoutData(1, 0.5);
                      it.add(_doubleArrow_1, _VLayoutData_1);
                    }
                  };
                VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                HorizontalLayoutData _HLayoutData = DeviceManagementView.this.widgets.HLayoutData(200, 1, 1);
                it.add(_doubleArrow, _HLayoutData);
                final Procedure1<Iterable<UIOnsitePosition>> _function_1 = new Procedure1<Iterable<UIOnsitePosition>>() {
                    public void apply(final Iterable<UIOnsitePosition> selected) {
                      Iterable<UIOnsitePosition> _selectedObjects = DeviceManagementView.this.locationAc.getSelectedObjects();
                      UIOnsitePosition _head = IterableExtensions.<UIOnsitePosition>head(_selectedObjects);
                      RCOnsitePositionProxy _proxy = _head==null?(RCOnsitePositionProxy)null:_head.toProxy();
                      DeviceManagementView.this.criteriaForm.location.setValue(_proxy);
                      UIDeviceCriteria _value = DeviceManagementView.this.criteriaForm.getValue();
                      UIDeviceCriteria _withPagerInfo = Extensions.<UIDeviceCriteria>withPagerInfo(_value, DeviceManagementView.this.pager);
                      final Procedure1<UIDeviceCriteria> _function = new Procedure1<UIDeviceCriteria>() {
                          public void apply(final UIDeviceCriteria it) {
                            it.setPage(Integer.valueOf(1));
                          }
                        };
                      UIDeviceCriteria _doubleArrow = ObjectExtensions.<UIDeviceCriteria>operator_doubleArrow(_withPagerInfo, _function);
                      filterRequestRequestHandler.execute(_doubleArrow);
                      
                    }
                  };
                DeviceManagementView.this.locationAc.addSelectionChangedListener(new SelectionChangedListener<UIOnsitePosition>() {
                    public void selectionChanged(Iterable<UIOnsitePosition> selections) {
                      _function_1.apply(selections);
                    }
                });
                final Procedure1<Void> _function_2 = new Procedure1<Void>() {
                    public void apply(final Void it) {
                      DeviceManagementView.this.criteriaForm.deviceType.setValue(null);
                      DeviceManagementView.this.criteriaForm.category.setValue(null);
                      UIDeviceCriteria _value = DeviceManagementView.this.criteriaForm.getValue();
                      UIDeviceCriteria _withPagerInfo = Extensions.<UIDeviceCriteria>withPagerInfo(_value, DeviceManagementView.this.pager);
                      final Procedure1<UIDeviceCriteria> _function = new Procedure1<UIDeviceCriteria>() {
                          public void apply(final UIDeviceCriteria it) {
                            it.setPage(Integer.valueOf(1));
                          }
                        };
                      UIDeviceCriteria _doubleArrow = ObjectExtensions.<UIDeviceCriteria>operator_doubleArrow(_withPagerInfo, _function);
                      filterRequestRequestHandler.execute(_doubleArrow);
                      
                    }
                  };
                DeviceManagementView.this.deviceCategoryAndTypeListPresenter.onUnselected(_function_2);
                final Procedure1<RCDeviceTypeProxy> _function_3 = new Procedure1<RCDeviceTypeProxy>() {
                    public void apply(final RCDeviceTypeProxy it) {
                      DeviceManagementView.this.criteriaForm.deviceType.setValue(it);
                      DeviceManagementView.this.criteriaForm.category.setValue(null);
                      UIDeviceCriteria _value = DeviceManagementView.this.criteriaForm.getValue();
                      UIDeviceCriteria _withPagerInfo = Extensions.<UIDeviceCriteria>withPagerInfo(_value, DeviceManagementView.this.pager);
                      final Procedure1<UIDeviceCriteria> _function = new Procedure1<UIDeviceCriteria>() {
                          public void apply(final UIDeviceCriteria it) {
                            it.setPage(Integer.valueOf(1));
                          }
                        };
                      UIDeviceCriteria _doubleArrow = ObjectExtensions.<UIDeviceCriteria>operator_doubleArrow(_withPagerInfo, _function);
                      filterRequestRequestHandler.execute(_doubleArrow);
                      
                    }
                  };
                DeviceManagementView.this.deviceCategoryAndTypeListPresenter.onDeviceTypeSelected(_function_3);
                final Procedure1<RCDeviceTypeCategoryProxy> _function_4 = new Procedure1<RCDeviceTypeCategoryProxy>() {
                    public void apply(final RCDeviceTypeCategoryProxy it) {
                      DeviceManagementView.this.criteriaForm.deviceType.setValue(null);
                      Long _id = it.getId();
                      String _plus = ("%[" + _id);
                      String _plus_1 = (_plus + "]%");
                      DeviceManagementView.this.criteriaForm.category.setValue(_plus_1);
                      UIDeviceCriteria _value = DeviceManagementView.this.criteriaForm.getValue();
                      UIDeviceCriteria _withPagerInfo = Extensions.<UIDeviceCriteria>withPagerInfo(_value, DeviceManagementView.this.pager);
                      final Procedure1<UIDeviceCriteria> _function = new Procedure1<UIDeviceCriteria>() {
                          public void apply(final UIDeviceCriteria it) {
                            it.setPage(Integer.valueOf(1));
                          }
                        };
                      UIDeviceCriteria _doubleArrow = ObjectExtensions.<UIDeviceCriteria>operator_doubleArrow(_withPagerInfo, _function);
                      filterRequestRequestHandler.execute(_doubleArrow);
                      
                    }
                  };
                DeviceManagementView.this.deviceCategoryAndTypeListPresenter.onDeviceTypeCategorySelected(_function_4);
                FieldSet _FieldSet = DeviceManagementView.this.widgets.FieldSet("\u8BBE\u5907\u5217\u8868");
                final Procedure1<FieldSet> _function_5 = new Procedure1<FieldSet>() {
                    public void apply(final FieldSet it) {
                      VerticalLayoutContainer _VLayout = DeviceManagementView.this.widgets.VLayout();
                      final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                          public void apply(final VerticalLayoutContainer it) {
                            HTableLayoutContainer _HTableLayout = DeviceManagementView.this.widgets.HTableLayout();
                            final Procedure1<HTableLayoutContainer> _function = new Procedure1<HTableLayoutContainer>() {
                                public void apply(final HTableLayoutContainer it) {
                                  FieldLabel _asWidget = DeviceManagementView.this.criteriaForm.sid.asWidget();
                                  FieldLabel _asWidget_1 = DeviceManagementView.this.criteriaForm.name.asWidget();
                                  TextButton _TextButton = DeviceManagementView.this.widgets.TextButton("\u7B5B\u9009");
                                  final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                                      public void apply(final TextButton it) {
                                        it.setWidth("80px");
                                        final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                            public void apply(final SelectEvent it) {
                                              UIDeviceCriteria _value = DeviceManagementView.this.criteriaForm.getValue();
                                              UIDeviceCriteria _withPagerInfo = Extensions.<UIDeviceCriteria>withPagerInfo(_value, DeviceManagementView.this.pager);
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
                                  ArrayList<Widget> _newArrayList = CollectionLiterals.<Widget>newArrayList(_asWidget, _asWidget_1, _doubleArrow);
                                  it.add(_newArrayList);
                                }
                              };
                            HTableLayoutContainer _doubleArrow = ObjectExtensions.<HTableLayoutContainer>operator_doubleArrow(_HTableLayout, _function);
                            it.add(_doubleArrow);
                            IPager<UIDevice> _createPager = edu.fudan.langlab.gxt.client.pager.Extensions.<UIDevice>createPager(DeviceManagementView.this.listGrid);
                            final Procedure1<IPager<UIDevice>> _function_1 = new Procedure1<IPager<UIDevice>>() {
                                public void apply(final IPager<UIDevice> it) {
                                  final Procedure2<Integer,Integer> _function = new Procedure2<Integer,Integer>() {
                                      public void apply(final Integer pageNum, final Integer recordsPerPage) {
                                        UIDeviceCriteria _value = DeviceManagementView.this.criteriaForm.getValue();
                                        UIDeviceCriteria _withPagerInfo = Extensions.<UIDeviceCriteria>withPagerInfo(_value, DeviceManagementView.this.pager);
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
                            DeviceManagementView.this.pager = _doubleArrow_1;
                            ContentPanel _ContentPanel = DeviceManagementView.this.widgets.ContentPanel();
                            final Procedure1<ContentPanel> _function_2 = new Procedure1<ContentPanel>() {
                                public void apply(final ContentPanel it) {
                                  VerticalLayoutContainer _VLayout = DeviceManagementView.this.widgets.VLayout();
                                  final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                                      public void apply(final VerticalLayoutContainer it) {
                                        SGroupingGrid<UIDevice> _asWidget = DeviceManagementView.this.listGrid.asWidget();
                                        VerticalLayoutData _VLayoutData = DeviceManagementView.this.widgets.VLayoutData(1, 1);
                                        it.add(_asWidget, _VLayoutData);
                                        Widget _asWidget_1 = DeviceManagementView.this.pager.asWidget();
                                        it.add(_asWidget_1);
                                      }
                                    };
                                  VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                                  it.setWidget(_doubleArrow);
                                  final Procedure1<Void> _function_1 = new Procedure1<Void>() {
                                      public void apply(final Void v) {
                                        TextButton _TextButton = DeviceManagementView.this.widgets.TextButton("\u65B0\u5EFA");
                                        final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
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
                                        TextButton _doubleArrow = ObjectExtensions.<TextButton>operator_doubleArrow(_TextButton, _function);
                                        it.addButton(_doubleArrow);
                                      }
                                    };
                                  DeviceManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                                    public IFunctionIdentifier apply() {
                                      return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.device.DeviceManagementPresenter.createRequest" );
                                    }
                                  }.apply(), _function_1);
                                  final Procedure1<Void> _function_2 = new Procedure1<Void>() {
                                      public void apply(final Void v) {
                                        final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                            public void apply(final SingleObjectActions it) {
                                              final Procedure1<UIDevice> _function = new Procedure1<UIDevice>() {
                                                  public void apply(final UIDevice selectedValue) {
                                                    RCDeviceProxy _proxy = selectedValue.toProxy();
                                                    duplicateRequestRequestHandler.execute(_proxy);
                                                    
                                                  }
                                                };
                                              it.onExecute(_function);
                                            }
                                          };
                                        SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIDevice>onSingleObjectAction(ac, _function);
                                        TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u590D\u5236");
                                        it.addButton(_asButtonRequester);
                                      }
                                    };
                                  DeviceManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                                    public IFunctionIdentifier apply() {
                                      return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.device.DeviceManagementPresenter.duplicateRequest" );
                                    }
                                  }.apply(), _function_2);
                                  final Procedure1<Void> _function_3 = new Procedure1<Void>() {
                                      public void apply(final Void v) {
                                        final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                            public void apply(final SingleObjectActions it) {
                                              final Procedure1<UIDevice> _function = new Procedure1<UIDevice>() {
                                                  public void apply(final UIDevice selectedValue) {
                                                    RCDeviceProxy _proxy = selectedValue.toProxy();
                                                    modifyRequestRequestHandler.execute(_proxy);
                                                    
                                                  }
                                                };
                                              it.onExecute(_function);
                                            }
                                          };
                                        SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIDevice>onSingleObjectAction(ac, _function);
                                        TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u4FEE\u6539");
                                        it.addButton(_asButtonRequester);
                                      }
                                    };
                                  DeviceManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                                    public IFunctionIdentifier apply() {
                                      return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.device.DeviceManagementPresenter.modifyRequest" );
                                    }
                                  }.apply(), _function_3);
                                  final Procedure1<Void> _function_4 = new Procedure1<Void>() {
                                      public void apply(final Void v) {
                                        final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                            public void apply(final SingleObjectActions it) {
                                              final Procedure1<UIDevice> _function = new Procedure1<UIDevice>() {
                                                  public void apply(final UIDevice selectedValue) {
                                                    final Procedure1<Void> _function = new Procedure1<Void>() {
                                                        public void apply(final Void it) {
                                                          RCDeviceProxy _proxy = selectedValue.toProxy();
                                                          deleteRequestRequestHandler.execute(_proxy);
                                                          
                                                        }
                                                      };
                                                    ConfirmMessageBox _ConfirmMessageBox = DeviceManagementView.this.widgets.ConfirmMessageBox("\u786E\u8BA4", "\u786E\u8BA4\u5220\u9664", _function);
                                                    _ConfirmMessageBox.show();
                                                  }
                                                };
                                              it.onExecute(_function);
                                            }
                                          };
                                        SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIDevice>onSingleObjectAction(ac, _function);
                                        TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u5220\u9664");
                                        it.addButton(_asButtonRequester);
                                      }
                                    };
                                  DeviceManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                                    public IFunctionIdentifier apply() {
                                      return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.device.DeviceManagementPresenter.deleteRequest" );
                                    }
                                  }.apply(), _function_4);
                                  it.addSimpleCommand(DeviceManagementView.this.uploadDeviceCommand);
                                  final Function0<UIDeviceCriteria> _function_5 = new Function0<UIDeviceCriteria>() {
                                      public UIDeviceCriteria apply() {
                                        UIDeviceCriteria _value = DeviceManagementView.this.criteriaForm.getValue();
                                        return _value;
                                      }
                                    };
                                  it.<UIDeviceCriteria>addCommand(_function_5, DeviceManagementView.this.exportDeviceCommand);
                                }
                              };
                            ContentPanel _doubleArrow_2 = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function_2);
                            VerticalLayoutData _VLayoutData = DeviceManagementView.this.widgets.VLayoutData(1, 0.6);
                            it.add(_doubleArrow_2, _VLayoutData);
                            TabPanel _TabPanel = DeviceManagementView.this.widgets.TabPanel();
                            final Procedure1<TabPanel> _function_3 = new Procedure1<TabPanel>() {
                                public void apply(final TabPanel it) {
                                  DevicePropertyPresenterView _view = DeviceManagementView.this.devicePropertyPresenter.getView();
                                  Widget _asWidget = _view.asWidget();
                                  it.add(_asWidget, "\u57FA\u672C\u4FE1\u606F");
                                  AttributeSlotTreeListPresenterView _view_1 = DeviceManagementView.this.attributeSlotTreeListPresenter.getView();
                                  Widget _asWidget_1 = _view_1.asWidget();
                                  it.add(_asWidget_1, "\u6269\u5C55\u6280\u672F\u53C2\u6570");
                                  DevicePMPlanList4DevicePresenterView _view_2 = DeviceManagementView.this.devicePMPlanList4DevicePresenter.getView();
                                  Widget _asWidget_2 = _view_2.asWidget();
                                  it.add(_asWidget_2, "PM\u4EFB\u52A1\u6E05\u5355");
                                  DevicePMPlanAssignmentListPresenterView _view_3 = DeviceManagementView.this.devicePMPlanAssignmentListPresenter.getView();
                                  Widget _asWidget_3 = _view_3.asWidget();
                                  it.add(_asWidget_3, "PM\u8BB0\u5F55");
                                  Label _Label = DeviceManagementView.this.widgets.Label("\u7EF4\u4FEE\u8BB0\u5F55");
                                  it.add(_Label, "\u7EF4\u4FEE\u8BB0\u5F55");
                                  ContentPanel _ContentPanel = DeviceManagementView.this.widgets.ContentPanel();
                                  final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
                                      public void apply(final ContentPanel it) {
                                        DocumentStorageListPresenterView _view = DeviceManagementView.this.deviceDocumentStorageListPresenter.getView();
                                        Widget _asWidget = _view.asWidget();
                                        it.setWidget(_asWidget);
                                        final Function1<UIDevice,DeviceFileContainerProxy> _function = new Function1<UIDevice,DeviceFileContainerProxy>() {
                                            public DeviceFileContainerProxy apply(final UIDevice it) {
                                              RCDeviceProxy _proxy = it.toProxy();
                                              DeviceFileContainerProxy _deviceFileContainerProxy = new DeviceFileContainerProxy(_proxy);
                                              return _deviceFileContainerProxy;
                                            }
                                          };
                                        ActionContext<DeviceFileContainerProxy> _adapt = ac.<DeviceFileContainerProxy>adapt(new Function<UIDevice,DeviceFileContainerProxy>() {
                                            public DeviceFileContainerProxy apply(UIDevice input) {
                                              return _function.apply(input);
                                            }
                                        });
                                        it.addCommand(_adapt, DeviceManagementView.this.createDeviceDocmentStorageCommand, "\u4E0A\u4F20");
                                        DocumentStorageListPresenterView _view_1 = DeviceManagementView.this.deviceDocumentStorageListPresenter.getView();
                                        ActionContext<UIDocumentStorage> _actionContext = _view_1.getActionContext();
                                        final Function1<UIDocumentStorage,DocumentStorageProxy> _function_1 = new Function1<UIDocumentStorage,DocumentStorageProxy>() {
                                            public DocumentStorageProxy apply(final UIDocumentStorage it) {
                                              DocumentStorageProxy _proxy = it.toProxy();
                                              return _proxy;
                                            }
                                          };
                                        final ActionContext<DocumentStorageProxy> deviceDocumentAc = _actionContext.<DocumentStorageProxy>adapt(new Function<UIDocumentStorage,DocumentStorageProxy>() {
                                            public DocumentStorageProxy apply(UIDocumentStorage input) {
                                              return _function_1.apply(input);
                                            }
                                        });
                                        it.addCommand(deviceDocumentAc, DeviceManagementView.this.updateDeviceDocmentStorageCommand, "\u4FEE\u6539");
                                        it.addCommand(deviceDocumentAc, DeviceManagementView.this.deleteDeviceDocmentStorageCommand, "\u5220\u9664");
                                      }
                                    };
                                  ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
                                  it.add(_doubleArrow, "\u5173\u8054\u6587\u6863");
                                  ContentPanel _ContentPanel_1 = DeviceManagementView.this.widgets.ContentPanel();
                                  final Procedure1<ContentPanel> _function_1 = new Procedure1<ContentPanel>() {
                                      public void apply(final ContentPanel it) {
                                        PictureListPresenterView _view = DeviceManagementView.this.devicepictureListPresenter.getView();
                                        Widget _asWidget = _view.asWidget();
                                        it.setWidget(_asWidget);
                                        final Function1<UIDevice,DevicePictureContainerProxy> _function = new Function1<UIDevice,DevicePictureContainerProxy>() {
                                            public DevicePictureContainerProxy apply(final UIDevice it) {
                                              RCDeviceProxy _proxy = it.toProxy();
                                              DevicePictureContainerProxy _devicePictureContainerProxy = new DevicePictureContainerProxy(_proxy);
                                              return _devicePictureContainerProxy;
                                            }
                                          };
                                        ActionContext<DevicePictureContainerProxy> _adapt = ac.<DevicePictureContainerProxy>adapt(new Function<UIDevice,DevicePictureContainerProxy>() {
                                            public DevicePictureContainerProxy apply(UIDevice input) {
                                              return _function.apply(input);
                                            }
                                        });
                                        it.addCommand(_adapt, DeviceManagementView.this.createDevicePictureCommand, "\u4E0A\u4F20");
                                        PictureListPresenterView _view_1 = DeviceManagementView.this.devicepictureListPresenter.getView();
                                        ActionContext<UIDocumentStorage> _actionContext = _view_1.getActionContext();
                                        final Function1<UIDocumentStorage,DocumentStorageProxy> _function_1 = new Function1<UIDocumentStorage,DocumentStorageProxy>() {
                                            public DocumentStorageProxy apply(final UIDocumentStorage it) {
                                              DocumentStorageProxy _proxy = it.toProxy();
                                              return _proxy;
                                            }
                                          };
                                        final ActionContext<DocumentStorageProxy> deviceDocumentAc = _actionContext.<DocumentStorageProxy>adapt(new Function<UIDocumentStorage,DocumentStorageProxy>() {
                                            public DocumentStorageProxy apply(UIDocumentStorage input) {
                                              return _function_1.apply(input);
                                            }
                                        });
                                        it.addCommand(deviceDocumentAc, DeviceManagementView.this.updateDevicePictureCommand, "\u4FEE\u6539");
                                        it.addCommand(deviceDocumentAc, DeviceManagementView.this.deleteDevicePictureCommand, "\u5220\u9664");
                                      }
                                    };
                                  ContentPanel _doubleArrow_1 = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel_1, _function_1);
                                  it.add(_doubleArrow_1, "\u8BBE\u5907\u56FE\u7247");
                                }
                              };
                            TabPanel _doubleArrow_3 = ObjectExtensions.<TabPanel>operator_doubleArrow(_TabPanel, _function_3);
                            VerticalLayoutData _VLayoutData_1 = DeviceManagementView.this.widgets.VLayoutData(1, 0.4);
                            it.add(_doubleArrow_3, _VLayoutData_1);
                          }
                        };
                      VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                      it.setWidget(_doubleArrow);
                      final Procedure1<UIDevice> _function_1 = new Procedure1<UIDevice>() {
                          public void apply(final UIDevice device) {
                            RCDeviceProxy _proxy = device.toProxy();
                            deviceSelectedRequestHandler.execute(_proxy);
                            
                          }
                        };
                      DeviceManagementView.this.listGrid.addSelectEntityListener(new SelectEntityListener<UIDevice>() {
                          public void objectSelected(UIDevice selected) {
                            _function_1.apply(selected);
                          }
                      });
                    }
                  };
                FieldSet _doubleArrow_1 = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet, _function_5);
                HorizontalLayoutData _HLayoutData_1 = DeviceManagementView.this.widgets.HLayoutData(1, 1, 1);
                it.add(_doubleArrow_1, _HLayoutData_1);
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
  
  public RCDeviceTypeProxy getSelectedDeviceType() {
    RCDeviceTypeProxy _xblockexpression = null;
    {
      Iterable<UIDeviceCategoryAndType> _selectedObjects = this.deviceCategoryAndTypeAC.getSelectedObjects();
      final UIDeviceCategoryAndType s = IterableExtensions.<UIDeviceCategoryAndType>head(_selectedObjects);
      RCDeviceTypeProxy _xifexpression = null;
      boolean _and = false;
      boolean _notEquals = (!Objects.equal(s, null));
      if (!_notEquals) {
        _and = false;
      } else {
        UIDeviceCategoryOrTypeType _type = s.getType();
        boolean _equals = Objects.equal(_type, UIDeviceCategoryOrTypeType.type);
        _and = (_notEquals && _equals);
      }
      if (_and) {
        RCDeviceTypeProxy _rCDeviceTypeProxy = new RCDeviceTypeProxy();
        final Procedure1<RCDeviceTypeProxy> _function = new Procedure1<RCDeviceTypeProxy>() {
            public void apply(final RCDeviceTypeProxy it) {
              Long _id = s.getId();
              it.setId(_id);
              String _name = s.getName();
              it.setName(_name);
            }
          };
        RCDeviceTypeProxy _doubleArrow = ObjectExtensions.<RCDeviceTypeProxy>operator_doubleArrow(_rCDeviceTypeProxy, _function);
        _xifexpression = _doubleArrow;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public UIOnsitePosition getSelectedLocation() {
    Iterable<UIOnsitePosition> _selectedObjects = this.locationAc.getSelectedObjects();
    UIOnsitePosition _head = IterableExtensions.<UIOnsitePosition>head(_selectedObjects);
    return _head;
  }
  
  public ActionContext<RCDeviceProxy> getActionContext() {
    ActionContext<UIDevice> _createActionContext = ActionExtensions.<UIDevice>createActionContext(this.listGrid);
    final Function1<UIDevice,RCDeviceProxy> _function = new Function1<UIDevice,RCDeviceProxy>() {
        public RCDeviceProxy apply(final UIDevice it) {
          RCDeviceProxy _proxy = it.toProxy();
          return _proxy;
        }
      };
    ActionContext<RCDeviceProxy> _adapt = _createActionContext.<RCDeviceProxy>adapt(new Function<UIDevice,RCDeviceProxy>() {
        public RCDeviceProxy apply(UIDevice input) {
          return _function.apply(input);
        }
    });
    return _adapt;
  }
  
  private RequestHandler createRequestRequestHandler;
  
  public void createRequest(final RequestHandler requestHandler) {
    this.createRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCDeviceProxy> duplicateRequestRequestHandler;
  
  public void duplicateRequest(final RequestHandler1<RCDeviceProxy> requestHandler) {
    this.duplicateRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCDeviceProxy> deleteRequestRequestHandler;
  
  public void deleteRequest(final RequestHandler1<RCDeviceProxy> requestHandler) {
    this.deleteRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCDeviceProxy> modifyRequestRequestHandler;
  
  public void modifyRequest(final RequestHandler1<RCDeviceProxy> requestHandler) {
    this.modifyRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<UIDeviceCriteria> filterRequestRequestHandler;
  
  public void filterRequest(final RequestHandler1<UIDeviceCriteria> requestHandler) {
    this.filterRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCDeviceProxy> deviceSelectedRequestHandler;
  
  public void deviceSelected(final RequestHandler1<RCDeviceProxy> requestHandler) {
    this.deviceSelectedRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCPMWorkItemProxy> showPMEvaluateInfoRequestHandler;
  
  public void showPMEvaluateInfo(final RequestHandler1<RCPMWorkItemProxy> requestHandler) {
    this.showPMEvaluateInfoRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCPMWorkItemProxy> showPMWorkItemInfoRequestHandler;
  
  public void showPMWorkItemInfo(final RequestHandler1<RCPMWorkItemProxy> requestHandler) {
    this.showPMWorkItemInfoRequestHandler = requestHandler;
  }
}
