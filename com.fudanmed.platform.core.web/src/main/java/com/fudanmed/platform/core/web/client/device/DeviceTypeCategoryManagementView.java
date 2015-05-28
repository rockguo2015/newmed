package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.fudanmed.platform.core.web.client.device.DeviceTypeCategoryListGrid;
import com.fudanmed.platform.core.web.client.device.DeviceTypeCategoryManagementPresenterView;
import com.fudanmed.platform.core.web.client.device.DeviceTypeManagementPresenter;
import com.fudanmed.platform.core.web.client.device.DeviceTypeManagementPresenterView;
import com.fudanmed.platform.core.web.client.tree.DeviceTypeCategoryTreeContentProvider;
import com.fudanmed.platform.core.web.shared.device.UIDeviceTypeCategory;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.data.shared.TreeStore;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldSet;
import com.sencha.gxt.widget.core.client.form.StoreFilterField;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.ActionExtensions;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.extensions.ObjectSelectionProviders;
import com.uniquesoft.gwt.client.common.widgets.ObjectListView.SelectEntityListener;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.common.shared.Objects;
import edu.fudan.langlab.gxt.client.action.SingleObjectActions;
import edu.fudan.langlab.gxt.client.component.treegrid.SGrid;
import edu.fudan.langlab.gxt.client.widget.ComponentExtensions;
import edu.fudan.langlab.gxt.client.widget.ContentPanel;
import edu.fudan.langlab.gxt.client.widget.FramedPanel;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import edu.fudan.langlab.security.shared.IFunctionIdentifier;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DeviceTypeCategoryManagementView extends GWTAbstractView implements DeviceTypeCategoryManagementPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(listGrid),
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
  
  private DeviceTypeManagementPresenter deviceTypeManagementPresenter;
  
  public void setDeviceTypeManagementPresenter(final DeviceTypeManagementPresenter deviceTypeManagementPresenter) {
    this.deviceTypeManagementPresenter = deviceTypeManagementPresenter;
  }
  
  @Inject
  private DeviceTypeCategoryListGrid listGrid;
  
  private Widget con;
  
  private Boolean isReadonly;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    this.listGrid.asWidget();
    final ActionContext<UIDeviceTypeCategory> ac = ActionExtensions.<UIDeviceTypeCategory>createActionContext(this.listGrid);
    final Procedure1<UIDeviceTypeCategory> _function = new Procedure1<UIDeviceTypeCategory>() {
        public void apply(final UIDeviceTypeCategory it) {
          RCDeviceTypeCategoryProxy _proxy = it.toProxy();
          typeSelectedRequestHandler.execute(_proxy);
          
        }
      };
    this.listGrid.addSelectEntityListener(new SelectEntityListener<UIDeviceTypeCategory>() {
        public void objectSelected(UIDeviceTypeCategory selected) {
          _function.apply(selected);
        }
    });
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u8BBE\u5907\u7C7B\u578B\u7BA1\u7406");
    final Procedure1<FramedPanel> _function_1 = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          HorizontalLayoutContainer _HLayout = DeviceTypeCategoryManagementView.this.widgets.HLayout();
          final Procedure1<HorizontalLayoutContainer> _function = new Procedure1<HorizontalLayoutContainer>() {
              public void apply(final HorizontalLayoutContainer it) {
                FieldSet _FieldSet = DeviceTypeCategoryManagementView.this.widgets.FieldSet("\u8BBE\u5907\u5927\u7C7B");
                final Procedure1<FieldSet> _function = new Procedure1<FieldSet>() {
                    public void apply(final FieldSet it) {
                      ContentPanel _ContentPanel = DeviceTypeCategoryManagementView.this.widgets.ContentPanel();
                      final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
                          public void apply(final ContentPanel it) {
                            it.setBodyBorder(false);
                            it.setBorders(false);
                            VerticalLayoutContainer _VLayout = DeviceTypeCategoryManagementView.this.widgets.VLayout();
                            final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                                public void apply(final VerticalLayoutContainer it) {
                                  final Function2<UIDeviceTypeCategory,String,Boolean> _function = new Function2<UIDeviceTypeCategory,String,Boolean>() {
                                      public Boolean apply(final UIDeviceTypeCategory item, final String filter) {
                                        boolean _or = false;
                                        String _name = item.getName();
                                        final Function1<String,Boolean> _function = new Function1<String,Boolean>() {
                                            public Boolean apply(final String it) {
                                              boolean _contains = it.contains(filter);
                                              return Boolean.valueOf(_contains);
                                            }
                                          };
                                        Boolean _satisfy = Objects.<String>satisfy(_name, _function);
                                        if ((_satisfy).booleanValue()) {
                                          _or = true;
                                        } else {
                                          String _simplePy = item.getSimplePy();
                                          final Function1<String,Boolean> _function_1 = new Function1<String,Boolean>() {
                                              public Boolean apply(final String it) {
                                                boolean _contains = it.contains(filter);
                                                return Boolean.valueOf(_contains);
                                              }
                                            };
                                          Boolean _satisfy_1 = Objects.<String>satisfy(_simplePy, _function_1);
                                          _or = ((_satisfy).booleanValue() || (_satisfy_1).booleanValue());
                                        }
                                        return Boolean.valueOf(_or);
                                      }
                                    };
                                  StoreFilterField<UIDeviceTypeCategory> _createFilter = ComponentExtensions.<UIDeviceTypeCategory>createFilter(DeviceTypeCategoryManagementView.this.listGrid, _function);
                                  int _minus = (-1);
                                  VerticalLayoutData _VLayoutData = DeviceTypeCategoryManagementView.this.widgets.VLayoutData(1, _minus);
                                  it.add(_createFilter, _VLayoutData);
                                  ContentPanel _ContentPanel = DeviceTypeCategoryManagementView.this.widgets.ContentPanel();
                                  final Procedure1<ContentPanel> _function_1 = new Procedure1<ContentPanel>() {
                                      public void apply(final ContentPanel it) {
                                        SGrid<UIDeviceTypeCategory> _asWidget = DeviceTypeCategoryManagementView.this.listGrid.asWidget();
                                        it.setWidget(_asWidget);
                                      }
                                    };
                                  ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function_1);
                                  VerticalLayoutData _VLayoutData_1 = DeviceTypeCategoryManagementView.this.widgets.VLayoutData(1, 1);
                                  it.add(_doubleArrow, _VLayoutData_1);
                                }
                              };
                            VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                            it.setWidget(_doubleArrow);
                            boolean _not = (!DeviceTypeCategoryManagementView.this.isReadonly);
                            if (_not) {
                              final Procedure1<Void> _function_1 = new Procedure1<Void>() {
                                  public void apply(final Void v) {
                                    TextButton _TextButton = DeviceTypeCategoryManagementView.this.widgets.TextButton("\u65B0\u5EFA");
                                    final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                                        public void apply(final TextButton it) {
                                          final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                              public void apply(final SelectEvent it) {
                                                final UIDeviceTypeCategory s = ObjectSelectionProviders.<UIDeviceTypeCategory>getOnlySelected(DeviceTypeCategoryManagementView.this.listGrid);
                                                RCDeviceTypeCategoryProxy _proxy = s==null?(RCDeviceTypeCategoryProxy)null:s.toProxy();
                                                createRequestRequestHandler.execute(_proxy);
                                                
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
                              DeviceTypeCategoryManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                                public IFunctionIdentifier apply() {
                                  return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.device.DeviceTypeCategoryManagementPresenter.createRequest" );
                                }
                              }.apply(), _function_1);
                              final Procedure1<Void> _function_2 = new Procedure1<Void>() {
                                  public void apply(final Void v) {
                                    final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                        public void apply(final SingleObjectActions it) {
                                          final Procedure1<UIDeviceTypeCategory> _function = new Procedure1<UIDeviceTypeCategory>() {
                                              public void apply(final UIDeviceTypeCategory selectedValue) {
                                                RCDeviceTypeCategoryProxy _proxy = selectedValue.toProxy();
                                                modifyRequestRequestHandler.execute(_proxy);
                                                
                                              }
                                            };
                                          it.onExecute(_function);
                                        }
                                      };
                                    SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIDeviceTypeCategory>onSingleObjectAction(ac, _function);
                                    TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u4FEE\u6539");
                                    it.addButton(_asButtonRequester);
                                  }
                                };
                              DeviceTypeCategoryManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                                public IFunctionIdentifier apply() {
                                  return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.device.DeviceTypeCategoryManagementPresenter.modifyRequest" );
                                }
                              }.apply(), _function_2);
                              final Procedure1<Void> _function_3 = new Procedure1<Void>() {
                                  public void apply(final Void v) {
                                    final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                        public void apply(final SingleObjectActions it) {
                                          final Procedure1<UIDeviceTypeCategory> _function = new Procedure1<UIDeviceTypeCategory>() {
                                              public void apply(final UIDeviceTypeCategory selectedValue) {
                                                final Procedure1<Void> _function = new Procedure1<Void>() {
                                                    public void apply(final Void it) {
                                                      RCDeviceTypeCategoryProxy _proxy = selectedValue.toProxy();
                                                      deleteRequestRequestHandler.execute(_proxy);
                                                      
                                                    }
                                                  };
                                                ConfirmMessageBox _ConfirmMessageBox = DeviceTypeCategoryManagementView.this.widgets.ConfirmMessageBox("\u786E\u8BA4", "\u786E\u8BA4\u5220\u9664\u9009\u5B9A\u8BBE\u5907\u5927\u7C7B", _function);
                                                _ConfirmMessageBox.show();
                                              }
                                            };
                                          it.onExecute(_function);
                                        }
                                      };
                                    SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIDeviceTypeCategory>onSingleObjectAction(ac, _function);
                                    TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u5220\u9664");
                                    it.addButton(_asButtonRequester);
                                  }
                                };
                              DeviceTypeCategoryManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                                public IFunctionIdentifier apply() {
                                  return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.device.DeviceTypeCategoryManagementPresenter.deleteRequest" );
                                }
                              }.apply(), _function_3);
                            }
                          }
                        };
                      ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
                      it.setWidget(_doubleArrow);
                    }
                  };
                FieldSet _doubleArrow = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet, _function);
                HorizontalLayoutData _HLayoutData = DeviceTypeCategoryManagementView.this.widgets.HLayoutData(250, 1, 1);
                it.add(_doubleArrow, _HLayoutData);
                FieldSet _FieldSet_1 = DeviceTypeCategoryManagementView.this.widgets.FieldSet("\u8BBE\u5907\u7C7B\u578B");
                final Procedure1<FieldSet> _function_1 = new Procedure1<FieldSet>() {
                    public void apply(final FieldSet it) {
                      ContentPanel _ContentPanel = DeviceTypeCategoryManagementView.this.widgets.ContentPanel();
                      final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
                          public void apply(final ContentPanel it) {
                            it.setBodyBorder(false);
                            it.setBorders(false);
                            DeviceTypeManagementPresenterView _view = DeviceTypeCategoryManagementView.this.deviceTypeManagementPresenter.getView();
                            Widget _asWidget = _view.asWidget();
                            it.setWidget(_asWidget);
                          }
                        };
                      ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
                      it.setWidget(_doubleArrow);
                    }
                  };
                FieldSet _doubleArrow_1 = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet_1, _function_1);
                HorizontalLayoutData _HLayoutData_1 = DeviceTypeCategoryManagementView.this.widgets.HLayoutData(1, 1, 1);
                it.add(_doubleArrow_1, _HLayoutData_1);
              }
            };
          HorizontalLayoutContainer _doubleArrow = ObjectExtensions.<HorizontalLayoutContainer>operator_doubleArrow(_HLayout, _function);
          it.setWidget(_doubleArrow);
        }
      };
    FramedPanel _doubleArrow = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function_1);
    this.con = _doubleArrow;
  }
  
  public ActionContext<UIDeviceTypeCategory> getActionContext() {
    ActionContext<UIDeviceTypeCategory> _createActionContext = ActionExtensions.<UIDeviceTypeCategory>createActionContext(this.listGrid);
    return _createActionContext;
  }
  
  public void showResults(final Collection<UIDeviceTypeCategory> results) {
    DeviceTypeCategoryTreeContentProvider _deviceTypeCategoryTreeContentProvider = new DeviceTypeCategoryTreeContentProvider(results);
    this.listGrid.setContentProvider(_deviceTypeCategoryTreeContentProvider);
  }
  
  public void updateDeviceTypeCategory(final UIDeviceTypeCategory org) {
    TreeStore<UIDeviceTypeCategory> _store = this.listGrid.getStore();
    _store.update(org);
  }
  
  public void deleteDeviceTypeCategory(final RCDeviceTypeCategoryProxy org) {
    TreeStore<UIDeviceTypeCategory> store = this.listGrid.getStore();
    int _hashCode = org.hashCode();
    String _string = Integer.valueOf(_hashCode).toString();
    UIDeviceTypeCategory _findModelWithKey = store.findModelWithKey(_string);
    store.remove(_findModelWithKey);
  }
  
  public void addDeviceTypeCategory(final UIDeviceTypeCategory org) {
    TreeStore store = this.listGrid.getStore();
    RCDeviceTypeCategoryProxy _parent = org.getParent();
    boolean _notEquals = (!com.google.common.base.Objects.equal(_parent, null));
    if (_notEquals) {
      RCDeviceTypeCategoryProxy _parent_1 = org.getParent();
      int _hashCode = _parent_1.hashCode();
      String _string = Integer.valueOf(_hashCode).toString();
      Object parentInStore = store.findModelWithKey(_string);
      store.add(((UIDeviceTypeCategory) parentInStore), ((UIDeviceTypeCategory) org));
    } else {
      store.add(((UIDeviceTypeCategory) org));
    }
  }
  
  public void setAsReadonly(final Boolean isReadonly) {
    this.isReadonly = isReadonly;
  }
  
  private RequestHandler1<RCDeviceTypeCategoryProxy> typeSelectedRequestHandler;
  
  public void typeSelected(final RequestHandler1<RCDeviceTypeCategoryProxy> requestHandler) {
    this.typeSelectedRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCDeviceTypeCategoryProxy> createRequestRequestHandler;
  
  public void createRequest(final RequestHandler1<RCDeviceTypeCategoryProxy> requestHandler) {
    this.createRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCDeviceTypeCategoryProxy> deleteRequestRequestHandler;
  
  public void deleteRequest(final RequestHandler1<RCDeviceTypeCategoryProxy> requestHandler) {
    this.deleteRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCDeviceTypeCategoryProxy> modifyRequestRequestHandler;
  
  public void modifyRequest(final RequestHandler1<RCDeviceTypeCategoryProxy> requestHandler) {
    this.modifyRequestRequestHandler = requestHandler;
  }
}
