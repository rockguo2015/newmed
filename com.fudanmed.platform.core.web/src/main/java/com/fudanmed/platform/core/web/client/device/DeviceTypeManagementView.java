package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.DeviceTypeFileContainerProxy;
import com.fudanmed.platform.core.device.proxy.DeviceTypePictureContainerProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy;
import com.fudanmed.platform.core.web.client.device.AttributeSlotTreeListPresenter;
import com.fudanmed.platform.core.web.client.device.AttributeSlotTreeListPresenterView;
import com.fudanmed.platform.core.web.client.device.CreateDeviceTypeDocumentStorageCommand;
import com.fudanmed.platform.core.web.client.device.CreateDeviceTypePictureCommand;
import com.fudanmed.platform.core.web.client.device.DeleteDeviceTypeDocumentStorageCommand;
import com.fudanmed.platform.core.web.client.device.DeleteDeviceTypePictureCommand;
import com.fudanmed.platform.core.web.client.device.DeviceTypeCriteriaForm;
import com.fudanmed.platform.core.web.client.device.DeviceTypeListGrid;
import com.fudanmed.platform.core.web.client.device.DeviceTypeManagementPresenterView;
import com.fudanmed.platform.core.web.client.device.DocumentStorageListPresenter;
import com.fudanmed.platform.core.web.client.device.DocumentStorageListPresenterView;
import com.fudanmed.platform.core.web.client.device.PMDefaultIntervalAssociationListPresenter;
import com.fudanmed.platform.core.web.client.device.PMDefaultIntervalAssociationListPresenterView;
import com.fudanmed.platform.core.web.client.device.PartTypeListPresenter;
import com.fudanmed.platform.core.web.client.device.PartTypeListPresenterView;
import com.fudanmed.platform.core.web.client.device.PictureListPresenter;
import com.fudanmed.platform.core.web.client.device.PictureListPresenterView;
import com.fudanmed.platform.core.web.client.device.PopulatePMPlantoAllDeviceCommand;
import com.fudanmed.platform.core.web.client.device.UpdateDeviceTypeDocumentStorageCommand;
import com.fudanmed.platform.core.web.client.device.UpdateDeviceTypePictureCommand;
import com.fudanmed.platform.core.web.shared.device.UIAttributeSlot;
import com.fudanmed.platform.core.web.shared.device.UIDeviceType;
import com.fudanmed.platform.core.web.shared.device.UIDeviceTypeCategory;
import com.fudanmed.platform.core.web.shared.device.UIDeviceTypeCriteria;
import com.fudanmed.platform.core.web.shared.device.UIDocumentStorage;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.info.Info;
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
import edu.fudan.langlab.domain.document.proxy.DocumentStorageProxy;
import edu.fudan.langlab.gxt.client.action.SingleObjectActions;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.widget.ContentPanel;
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

public class DeviceTypeManagementView extends GWTAbstractView implements DeviceTypeManagementPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(listGrid,criteriaForm,createDeviceDocmentStorageCommand,updateDeviceDocmentStorageCommand,deleteDeviceDocmentStorageCommand,createDevicePictureCommand,updateDevicePictureCommand,deleteDevicePictureCommand,populatePMPlantoAllDeviceCommand),
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
  
  private PartTypeListPresenter partTypeListPresenter;
  
  public void setPartTypeListPresenter(final PartTypeListPresenter partTypeListPresenter) {
    this.partTypeListPresenter = partTypeListPresenter;
  }
  
  private AttributeSlotTreeListPresenter attributeSlotTreeListPresenter;
  
  public void setAttributeSlotTreeListPresenter(final AttributeSlotTreeListPresenter attributeSlotTreeListPresenter) {
    this.attributeSlotTreeListPresenter = attributeSlotTreeListPresenter;
  }
  
  private PMDefaultIntervalAssociationListPresenter defaultIntervalAssociationListPresenter;
  
  public void setDefaultIntervalAssociationListPresenter(final PMDefaultIntervalAssociationListPresenter defaultIntervalAssociationListPresenter) {
    this.defaultIntervalAssociationListPresenter = defaultIntervalAssociationListPresenter;
  }
  
  private DocumentStorageListPresenter deviceDocumentStorageListPresenter;
  
  public void setDeviceDocumentStorageListPresenter(final DocumentStorageListPresenter deviceDocumentStorageListPresenter) {
    this.deviceDocumentStorageListPresenter = deviceDocumentStorageListPresenter;
  }
  
  private PictureListPresenter devicepictureListPresenter;
  
  public void setDevicepictureListPresenter(final PictureListPresenter devicepictureListPresenter) {
    this.devicepictureListPresenter = devicepictureListPresenter;
  }
  
  @Inject
  private DeviceTypeListGrid listGrid;
  
  @Inject
  private DeviceTypeCriteriaForm criteriaForm;
  
  private ContentPanel contentPanel;
  
  private IPager pager;
  
  @Inject
  private CreateDeviceTypeDocumentStorageCommand createDeviceDocmentStorageCommand;
  
  @Inject
  private UpdateDeviceTypeDocumentStorageCommand updateDeviceDocmentStorageCommand;
  
  @Inject
  private DeleteDeviceTypeDocumentStorageCommand deleteDeviceDocmentStorageCommand;
  
  @Inject
  private CreateDeviceTypePictureCommand createDevicePictureCommand;
  
  @Inject
  private UpdateDeviceTypePictureCommand updateDevicePictureCommand;
  
  @Inject
  private DeleteDeviceTypePictureCommand deleteDevicePictureCommand;
  
  @Inject
  private PopulatePMPlantoAllDeviceCommand populatePMPlantoAllDeviceCommand;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    this.listGrid.asWidget();
    this.listGrid.keepSelection();
    final ActionContext<UIDeviceType> deviceTypeAc = ActionExtensions.<UIDeviceType>createActionContext(this.listGrid);
    ContentPanel _ContentPanel = this.widgets.ContentPanel();
    final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
        public void apply(final ContentPanel it) {
          it.setBodyBorder(false);
          it.setBorders(false);
          VerticalLayoutContainer _VLayout = DeviceTypeManagementView.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                HTableLayoutContainer _HTableLayout = DeviceTypeManagementView.this.widgets.HTableLayout();
                final Procedure1<HTableLayoutContainer> _function = new Procedure1<HTableLayoutContainer>() {
                    public void apply(final HTableLayoutContainer it) {
                      FieldLabel _asWidget = DeviceTypeManagementView.this.criteriaForm.name.asWidget();
                      TextButton _TextButton = DeviceTypeManagementView.this.widgets.TextButton("\u7B5B\u9009");
                      final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                          public void apply(final TextButton it) {
                            it.setWidth("80px");
                            final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                public void apply(final SelectEvent it) {
                                  UIDeviceTypeCriteria _value = DeviceTypeManagementView.this.criteriaForm.getValue();
                                  UIDeviceTypeCriteria _withPagerInfo = Extensions.<UIDeviceTypeCriteria>withPagerInfo(_value, DeviceTypeManagementView.this.pager);
                                  final Procedure1<UIDeviceTypeCriteria> _function = new Procedure1<UIDeviceTypeCriteria>() {
                                      public void apply(final UIDeviceTypeCriteria it) {
                                        it.setPage(Integer.valueOf(1));
                                      }
                                    };
                                  UIDeviceTypeCriteria _doubleArrow = ObjectExtensions.<UIDeviceTypeCriteria>operator_doubleArrow(_withPagerInfo, _function);
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
                IPager<UIDeviceType> _createPager = edu.fudan.langlab.gxt.client.pager.Extensions.<UIDeviceType>createPager(DeviceTypeManagementView.this.listGrid);
                final Procedure1<IPager<UIDeviceType>> _function_1 = new Procedure1<IPager<UIDeviceType>>() {
                    public void apply(final IPager<UIDeviceType> it) {
                      final Procedure2<Integer,Integer> _function = new Procedure2<Integer,Integer>() {
                          public void apply(final Integer pageNum, final Integer recordsPerPage) {
                            UIDeviceTypeCriteria _value = DeviceTypeManagementView.this.criteriaForm.getValue();
                            UIDeviceTypeCriteria _withPagerInfo = Extensions.<UIDeviceTypeCriteria>withPagerInfo(_value, DeviceTypeManagementView.this.pager);
                            final Procedure1<UIDeviceTypeCriteria> _function = new Procedure1<UIDeviceTypeCriteria>() {
                                public void apply(final UIDeviceTypeCriteria it) {
                                  it.setPage(Integer.valueOf(pageNum));
                                  it.setPageSize(Integer.valueOf(recordsPerPage));
                                }
                              };
                            UIDeviceTypeCriteria _doubleArrow = ObjectExtensions.<UIDeviceTypeCriteria>operator_doubleArrow(_withPagerInfo, _function);
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
                IPager<UIDeviceType> _doubleArrow_1 = ObjectExtensions.<IPager<UIDeviceType>>operator_doubleArrow(_createPager, _function_1);
                DeviceTypeManagementView.this.pager = _doubleArrow_1;
                ContentPanel _ContentPanel = DeviceTypeManagementView.this.widgets.ContentPanel();
                final Procedure1<ContentPanel> _function_2 = new Procedure1<ContentPanel>() {
                    public void apply(final ContentPanel it) {
                      VerticalLayoutContainer _VLayout = DeviceTypeManagementView.this.widgets.VLayout();
                      final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                          public void apply(final VerticalLayoutContainer it) {
                            SGroupingGrid<UIDeviceType> _asWidget = DeviceTypeManagementView.this.listGrid.asWidget();
                            VerticalLayoutData _VLayoutData = DeviceTypeManagementView.this.widgets.VLayoutData(1, 1);
                            it.add(_asWidget, _VLayoutData);
                            Widget _asWidget_1 = DeviceTypeManagementView.this.pager.asWidget();
                            it.add(_asWidget_1);
                          }
                        };
                      VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                      it.setWidget(_doubleArrow);
                    }
                  };
                ContentPanel _doubleArrow_2 = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function_2);
                ContentPanel _contentPanel = DeviceTypeManagementView.this.contentPanel = _doubleArrow_2;
                VerticalLayoutData _VLayoutData = DeviceTypeManagementView.this.widgets.VLayoutData(1, 0.6);
                it.add(_contentPanel, _VLayoutData);
                TabPanel _TabPanel = DeviceTypeManagementView.this.widgets.TabPanel();
                final Procedure1<TabPanel> _function_3 = new Procedure1<TabPanel>() {
                    public void apply(final TabPanel it) {
                      ContentPanel _ContentPanel = DeviceTypeManagementView.this.widgets.ContentPanel();
                      final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
                          public void apply(final ContentPanel it) {
                            it.setBodyBorder(false);
                            it.setBorders(false);
                            AttributeSlotTreeListPresenterView _view = DeviceTypeManagementView.this.attributeSlotTreeListPresenter.getView();
                            Widget _asWidget = _view.asWidget();
                            it.setWidget(_asWidget);
                            AttributeSlotTreeListPresenterView _view_1 = DeviceTypeManagementView.this.attributeSlotTreeListPresenter.getView();
                            final ActionContext<UIAttributeSlot> ac = _view_1.getActionContext();
                            final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                public void apply(final SingleObjectActions it) {
                                  final Procedure1<UIDeviceType> _function = new Procedure1<UIDeviceType>() {
                                      public void apply(final UIDeviceType dt) {
                                        Iterable<UIAttributeSlot> _selectedObjects = ac.getSelectedObjects();
                                        final UIAttributeSlot selected = _selectedObjects==null?(UIAttributeSlot)null:IterableExtensions.<UIAttributeSlot>head(_selectedObjects);
                                        boolean _and = false;
                                        boolean _notEquals = (!Objects.equal(selected, null));
                                        if (!_notEquals) {
                                          _and = false;
                                        } else {
                                          Boolean _isPrimary = selected.getIsPrimary();
                                          _and = (_notEquals && (_isPrimary).booleanValue());
                                        }
                                        if (_and) {
                                          Info.display("\u9519\u8BEF", "\u8BE5\u57FA\u672C\u53C2\u6570\u4E0B\u65E0\u6CD5\u5EFA\u7ACB\u57FA\u672C\u53C2\u6570");
                                        } else {
                                          Iterable<UIAttributeSlot> _selectedObjects_1 = ac.getSelectedObjects();
                                          UIAttributeSlot _head = _selectedObjects_1==null?(UIAttributeSlot)null:IterableExtensions.<UIAttributeSlot>head(_selectedObjects_1);
                                          RCAttributeSlotProxy _proxy = _head==null?(RCAttributeSlotProxy)null:_head.toProxy();
                                          newParameterRequestRequestHandler.execute(_proxy);
                                          
                                        }
                                      }
                                    };
                                  it.onExecute(_function);
                                }
                              };
                            SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIDeviceType>onSingleObjectAction(deviceTypeAc, _function);
                            TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u65B0\u5EFA\u57FA\u672C\u53C2\u6570");
                            it.addButton(_asButtonRequester);
                            final Procedure1<SingleObjectActions> _function_1 = new Procedure1<SingleObjectActions>() {
                                public void apply(final SingleObjectActions it) {
                                  final Procedure1<UIDeviceType> _function = new Procedure1<UIDeviceType>() {
                                      public void apply(final UIDeviceType dt) {
                                        Iterable<UIAttributeSlot> _selectedObjects = ac.getSelectedObjects();
                                        final UIAttributeSlot selected = _selectedObjects==null?(UIAttributeSlot)null:IterableExtensions.<UIAttributeSlot>head(_selectedObjects);
                                        boolean _and = false;
                                        boolean _notEquals = (!Objects.equal(selected, null));
                                        if (!_notEquals) {
                                          _and = false;
                                        } else {
                                          Boolean _isPrimary = selected.getIsPrimary();
                                          _and = (_notEquals && (_isPrimary).booleanValue());
                                        }
                                        if (_and) {
                                          Info.display("\u9519\u8BEF", "\u8BE5\u57FA\u672C\u53C2\u6570\u65E0\u6CD5\u5EFA\u7ACB\u590D\u5408\u53C2\u6570");
                                        } else {
                                          Iterable<UIAttributeSlot> _selectedObjects_1 = ac.getSelectedObjects();
                                          UIAttributeSlot _head = _selectedObjects_1==null?(UIAttributeSlot)null:IterableExtensions.<UIAttributeSlot>head(_selectedObjects_1);
                                          RCAttributeSlotProxy _proxy = _head==null?(RCAttributeSlotProxy)null:_head.toProxy();
                                          newCategoryRequestRequestHandler.execute(_proxy);
                                          
                                        }
                                      }
                                    };
                                  it.onExecute(_function);
                                }
                              };
                            SingleObjectActions _onSingleObjectAction_1 = SingleObjectActions.<UIDeviceType>onSingleObjectAction(deviceTypeAc, _function_1);
                            TextButton _asButtonRequester_1 = _onSingleObjectAction_1.asButtonRequester("\u65B0\u5EFA\u590D\u5408\u53C2\u6570");
                            it.addButton(_asButtonRequester_1);
                            final Procedure1<SingleObjectActions> _function_2 = new Procedure1<SingleObjectActions>() {
                                public void apply(final SingleObjectActions it) {
                                  final Procedure1<UIAttributeSlot> _function = new Procedure1<UIAttributeSlot>() {
                                      public void apply(final UIAttributeSlot slot) {
                                        final Procedure1<Void> _function = new Procedure1<Void>() {
                                            public void apply(final Void it) {
                                              RCAttributeSlotProxy _proxy = slot.toProxy();
                                              deleteAttributeRequestRequestHandler.execute(_proxy);
                                              
                                            }
                                          };
                                        ConfirmMessageBox _ConfirmMessageBox = DeviceTypeManagementView.this.widgets.ConfirmMessageBox("\u786E\u8BA4", "\u6240\u6709\u5173\u8054\u8BBE\u5907\u4E2D\u7684\u53C2\u6570\u90FD\u5C06\u88AB\u5220\u9664!", _function);
                                        _ConfirmMessageBox.show();
                                      }
                                    };
                                  it.onExecute(_function);
                                }
                              };
                            SingleObjectActions _onSingleObjectAction_2 = SingleObjectActions.<UIAttributeSlot>onSingleObjectAction(ac, _function_2);
                            TextButton _asButtonRequester_2 = _onSingleObjectAction_2.asButtonRequester("\u5220\u9664\u53C2\u6570");
                            it.addButton(_asButtonRequester_2);
                          }
                        };
                      ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
                      it.add(_doubleArrow, "\u6269\u5C55\u6280\u672F\u53C2\u6570");
                      PMDefaultIntervalAssociationListPresenterView _view = DeviceTypeManagementView.this.defaultIntervalAssociationListPresenter.getView();
                      Widget _asWidget = _view.asWidget();
                      it.add(_asWidget, "\u9ED8\u8BA4PM\u8BA1\u5212");
                      PartTypeListPresenterView _view_1 = DeviceTypeManagementView.this.partTypeListPresenter.getView();
                      Widget _asWidget_1 = _view_1.asWidget();
                      it.add(_asWidget_1, "\u914D\u4EF6\u7C7B\u578B");
                      ContentPanel _ContentPanel_1 = DeviceTypeManagementView.this.widgets.ContentPanel();
                      final Procedure1<ContentPanel> _function_1 = new Procedure1<ContentPanel>() {
                          public void apply(final ContentPanel it) {
                            DocumentStorageListPresenterView _view = DeviceTypeManagementView.this.deviceDocumentStorageListPresenter.getView();
                            Widget _asWidget = _view.asWidget();
                            it.setWidget(_asWidget);
                            final Function1<UIDeviceType,DeviceTypeFileContainerProxy> _function = new Function1<UIDeviceType,DeviceTypeFileContainerProxy>() {
                                public DeviceTypeFileContainerProxy apply(final UIDeviceType it) {
                                  RCDeviceTypeProxy _proxy = it.toProxy();
                                  DeviceTypeFileContainerProxy _deviceTypeFileContainerProxy = new DeviceTypeFileContainerProxy(_proxy);
                                  return _deviceTypeFileContainerProxy;
                                }
                              };
                            ActionContext<DeviceTypeFileContainerProxy> _adapt = deviceTypeAc.<DeviceTypeFileContainerProxy>adapt(new Function<UIDeviceType,DeviceTypeFileContainerProxy>() {
                                public DeviceTypeFileContainerProxy apply(UIDeviceType input) {
                                  return _function.apply(input);
                                }
                            });
                            it.addCommand(_adapt, DeviceTypeManagementView.this.createDeviceDocmentStorageCommand, "\u4E0A\u4F20");
                            DocumentStorageListPresenterView _view_1 = DeviceTypeManagementView.this.deviceDocumentStorageListPresenter.getView();
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
                            it.addCommand(deviceDocumentAc, DeviceTypeManagementView.this.updateDeviceDocmentStorageCommand, "\u4FEE\u6539");
                            it.addCommand(deviceDocumentAc, DeviceTypeManagementView.this.deleteDeviceDocmentStorageCommand, "\u5220\u9664");
                          }
                        };
                      ContentPanel _doubleArrow_1 = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel_1, _function_1);
                      it.add(_doubleArrow_1, "\u5173\u8054\u6587\u6863");
                      ContentPanel _ContentPanel_2 = DeviceTypeManagementView.this.widgets.ContentPanel();
                      final Procedure1<ContentPanel> _function_2 = new Procedure1<ContentPanel>() {
                          public void apply(final ContentPanel it) {
                            PictureListPresenterView _view = DeviceTypeManagementView.this.devicepictureListPresenter.getView();
                            Widget _asWidget = _view.asWidget();
                            it.setWidget(_asWidget);
                            final Function1<UIDeviceType,DeviceTypePictureContainerProxy> _function = new Function1<UIDeviceType,DeviceTypePictureContainerProxy>() {
                                public DeviceTypePictureContainerProxy apply(final UIDeviceType it) {
                                  RCDeviceTypeProxy _proxy = it.toProxy();
                                  DeviceTypePictureContainerProxy _deviceTypePictureContainerProxy = new DeviceTypePictureContainerProxy(_proxy);
                                  return _deviceTypePictureContainerProxy;
                                }
                              };
                            ActionContext<DeviceTypePictureContainerProxy> _adapt = deviceTypeAc.<DeviceTypePictureContainerProxy>adapt(new Function<UIDeviceType,DeviceTypePictureContainerProxy>() {
                                public DeviceTypePictureContainerProxy apply(UIDeviceType input) {
                                  return _function.apply(input);
                                }
                            });
                            it.addCommand(_adapt, DeviceTypeManagementView.this.createDevicePictureCommand, "\u4E0A\u4F20");
                            PictureListPresenterView _view_1 = DeviceTypeManagementView.this.devicepictureListPresenter.getView();
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
                            it.addCommand(deviceDocumentAc, DeviceTypeManagementView.this.updateDevicePictureCommand, "\u4FEE\u6539");
                            it.addCommand(deviceDocumentAc, DeviceTypeManagementView.this.deleteDevicePictureCommand, "\u5220\u9664");
                          }
                        };
                      ContentPanel _doubleArrow_2 = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel_2, _function_2);
                      it.add(_doubleArrow_2, "\u8BBE\u5907\u56FE\u7247");
                    }
                  };
                TabPanel _doubleArrow_3 = ObjectExtensions.<TabPanel>operator_doubleArrow(_TabPanel, _function_3);
                VerticalLayoutData _VLayoutData_1 = DeviceTypeManagementView.this.widgets.VLayoutData(1, 0.4);
                it.add(_doubleArrow_3, _VLayoutData_1);
              }
            };
          VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
          it.setWidget(_doubleArrow);
          final Procedure1<UIDeviceType> _function_1 = new Procedure1<UIDeviceType>() {
              public void apply(final UIDeviceType device) {
                RCDeviceTypeProxy _proxy = device.toProxy();
                deviceTypeSelectedRequestHandler.execute(_proxy);
                
              }
            };
          DeviceTypeManagementView.this.listGrid.addSelectEntityListener(new SelectEntityListener<UIDeviceType>() {
              public void objectSelected(UIDeviceType selected) {
                _function_1.apply(selected);
              }
          });
        }
      };
    ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
    this.con = _doubleArrow;
  }
  
  public void setTypeCategoryActionContext(final ActionContext<UIDeviceTypeCategory> typeCategoryAC) {
    final ActionContext<UIDeviceType> ac = ActionExtensions.<UIDeviceType>createActionContext(this.listGrid);
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void v) {
          final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
              public void apply(final SingleObjectActions it) {
                final Procedure1<UIDeviceTypeCategory> _function = new Procedure1<UIDeviceTypeCategory>() {
                    public void apply(final UIDeviceTypeCategory category) {
                      RCDeviceTypeCategoryProxy _proxy = category.toProxy();
                      createChildRequestRequestHandler.execute(_proxy);
                      
                    }
                  };
                it.onExecute(_function);
              }
            };
          SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIDeviceTypeCategory>onSingleObjectAction(typeCategoryAC, _function);
          TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u65B0\u5EFA");
          DeviceTypeManagementView.this.contentPanel.addButton(_asButtonRequester);
        }
      };
    this.securities.check(new Function0<IFunctionIdentifier>() {
      public IFunctionIdentifier apply() {
        return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.device.DeviceTypeManagementPresenter.createChildRequest" );
      }
    }.apply(), _function);
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void v) {
          final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
              public void apply(final SingleObjectActions it) {
                final Procedure1<UIDeviceType> _function = new Procedure1<UIDeviceType>() {
                    public void apply(final UIDeviceType item) {
                      RCDeviceTypeProxy _proxy = item.toProxy();
                      cloneChildRequestRequestHandler.execute(_proxy);
                      
                    }
                  };
                it.onExecute(_function);
              }
            };
          SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIDeviceType>onSingleObjectAction(ac, _function);
          TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u590D\u5236");
          DeviceTypeManagementView.this.contentPanel.addButton(_asButtonRequester);
        }
      };
    this.securities.check(new Function0<IFunctionIdentifier>() {
      public IFunctionIdentifier apply() {
        return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.device.DeviceTypeManagementPresenter.createChildRequest" );
      }
    }.apply(), _function_1);
    final Procedure1<Void> _function_2 = new Procedure1<Void>() {
        public void apply(final Void v) {
          final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
              public void apply(final SingleObjectActions it) {
                final Procedure1<UIDeviceType> _function = new Procedure1<UIDeviceType>() {
                    public void apply(final UIDeviceType item) {
                      RCDeviceTypeProxy _proxy = item.toProxy();
                      modifyChildRequestRequestHandler.execute(_proxy);
                      
                    }
                  };
                it.onExecute(_function);
              }
            };
          SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIDeviceType>onSingleObjectAction(ac, _function);
          TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u4FEE\u6539");
          DeviceTypeManagementView.this.contentPanel.addButton(_asButtonRequester);
        }
      };
    this.securities.check(new Function0<IFunctionIdentifier>() {
      public IFunctionIdentifier apply() {
        return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.device.DeviceTypeManagementPresenter.modifyChildRequest" );
      }
    }.apply(), _function_2);
    final Procedure1<Void> _function_3 = new Procedure1<Void>() {
        public void apply(final Void v) {
          final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
              public void apply(final SingleObjectActions it) {
                final Procedure1<UIDeviceType> _function = new Procedure1<UIDeviceType>() {
                    public void apply(final UIDeviceType item) {
                      final Procedure1<Void> _function = new Procedure1<Void>() {
                          public void apply(final Void it) {
                            RCDeviceTypeProxy _proxy = item.toProxy();
                            deleteChildRequestRequestHandler.execute(_proxy);
                            
                          }
                        };
                      ConfirmMessageBox _ConfirmMessageBox = DeviceTypeManagementView.this.widgets.ConfirmMessageBox("\u786E\u8BA4", "\u786E\u8BA4\u5220\u9664\u9009\u5B9A\u8BBE\u5907\u7C7B\u522B", _function);
                      _ConfirmMessageBox.show();
                    }
                  };
                it.onExecute(_function);
              }
            };
          SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIDeviceType>onSingleObjectAction(ac, _function);
          TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u5220\u9664");
          DeviceTypeManagementView.this.contentPanel.addButton(_asButtonRequester);
        }
      };
    this.securities.check(new Function0<IFunctionIdentifier>() {
      public IFunctionIdentifier apply() {
        return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.device.DeviceTypeManagementPresenter.deleteChildRequest" );
      }
    }.apply(), _function_3);
    final Procedure1<Void> _function_4 = new Procedure1<Void>() {
        public void apply(final Void v) {
          final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
              public void apply(final SingleObjectActions it) {
                final Procedure1<UIDeviceType> _function = new Procedure1<UIDeviceType>() {
                    public void apply(final UIDeviceType item) {
                      RCDeviceTypeProxy _proxy = item.toProxy();
                      showAttributeSlotEditorRequestRequestHandler.execute(_proxy);
                      
                    }
                  };
                it.onExecute(_function);
              }
            };
          SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIDeviceType>onSingleObjectAction(ac, _function);
          TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u6269\u5C55\u6280\u672F\u53C2\u6570");
          DeviceTypeManagementView.this.contentPanel.addButton(_asButtonRequester);
        }
      };
    this.securities.check(new Function0<IFunctionIdentifier>() {
      public IFunctionIdentifier apply() {
        return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.device.DeviceTypeManagementPresenter.showAttributeSlotEditorRequest" );
      }
    }.apply(), _function_4);
    this.contentPanel.addSimpleCommand(this.populatePMPlantoAllDeviceCommand);
  }
  
  public void showResults(final IPagedResult<UIDeviceType> results) {
    this.pager.pageLoaded(results);
  }
  
  public RCDeviceTypeProxy getSelectedDeviceType() {
    Iterable<UIDeviceType> _selectedObjects = this.listGrid.getSelectedObjects();
    UIDeviceType _head = _selectedObjects==null?(UIDeviceType)null:IterableExtensions.<UIDeviceType>head(_selectedObjects);
    RCDeviceTypeProxy _proxy = _head.toProxy();
    return _proxy;
  }
  
  public void refresh() {
    int _activePage = this.pager.getActivePage();
    this.pager.gotoPage(_activePage);
  }
  
  public void filterByCategory(final RCDeviceTypeCategoryProxy category) {
    
    boolean _notEquals = (!Objects.equal(category, null));
    if (_notEquals) {
      Long _id = category.getId();
      String _plus = ("%[" + _id);
      String _plus_1 = (_plus + "]%");
      this.criteriaForm.category.setValue(_plus_1);
    }
    UIDeviceTypeCriteria _value = this.criteriaForm.getValue();
    UIDeviceTypeCriteria _withPagerInfo = Extensions.<UIDeviceTypeCriteria>withPagerInfo(_value, this.pager);
    final Procedure1<UIDeviceTypeCriteria> _function = new Procedure1<UIDeviceTypeCriteria>() {
        public void apply(final UIDeviceTypeCriteria it) {
          it.setPage(Integer.valueOf(1));
        }
      };
    UIDeviceTypeCriteria _doubleArrow = ObjectExtensions.<UIDeviceTypeCriteria>operator_doubleArrow(_withPagerInfo, _function);
    filterRequestRequestHandler.execute(_doubleArrow);
    
  }
  
  public ActionContext<UIDeviceType> getActionContext() {
    ActionContext<UIDeviceType> _createActionContext = ActionExtensions.<UIDeviceType>createActionContext(this.listGrid);
    return _createActionContext;
  }
  
  private RequestHandler1<RCDeviceTypeCategoryProxy> createChildRequestRequestHandler;
  
  public void createChildRequest(final RequestHandler1<RCDeviceTypeCategoryProxy> requestHandler) {
    this.createChildRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCDeviceTypeProxy> cloneChildRequestRequestHandler;
  
  public void cloneChildRequest(final RequestHandler1<RCDeviceTypeProxy> requestHandler) {
    this.cloneChildRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCDeviceTypeProxy> modifyChildRequestRequestHandler;
  
  public void modifyChildRequest(final RequestHandler1<RCDeviceTypeProxy> requestHandler) {
    this.modifyChildRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCDeviceTypeProxy> deleteChildRequestRequestHandler;
  
  public void deleteChildRequest(final RequestHandler1<RCDeviceTypeProxy> requestHandler) {
    this.deleteChildRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<UIDeviceTypeCriteria> filterRequestRequestHandler;
  
  public void filterRequest(final RequestHandler1<UIDeviceTypeCriteria> requestHandler) {
    this.filterRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCAttributeSlotProxy> newParameterRequestRequestHandler;
  
  public void newParameterRequest(final RequestHandler1<RCAttributeSlotProxy> requestHandler) {
    this.newParameterRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCAttributeSlotProxy> newCategoryRequestRequestHandler;
  
  public void newCategoryRequest(final RequestHandler1<RCAttributeSlotProxy> requestHandler) {
    this.newCategoryRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCAttributeSlotProxy> deleteAttributeRequestRequestHandler;
  
  public void deleteAttributeRequest(final RequestHandler1<RCAttributeSlotProxy> requestHandler) {
    this.deleteAttributeRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCDeviceTypeProxy> showAttributeSlotEditorRequestRequestHandler;
  
  public void showAttributeSlotEditorRequest(final RequestHandler1<RCDeviceTypeProxy> requestHandler) {
    this.showAttributeSlotEditorRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCDeviceTypeProxy> deviceTypeSelectedRequestHandler;
  
  public void deviceTypeSelected(final RequestHandler1<RCDeviceTypeProxy> requestHandler) {
    this.deviceTypeSelectedRequestHandler = requestHandler;
  }
}
