package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeAction;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.EmployeeCriteriaForm;
import com.fudanmed.platform.core.web.client.organization.EmployeeListGrid;
import com.fudanmed.platform.core.web.client.organization.EmployeeManagementPresenterView;
import com.fudanmed.platform.core.web.client.organization.OrganizationOutlineTreeGrid;
import com.fudanmed.platform.core.web.client.tree.OrganizationTreeContentProvider;
import com.fudanmed.platform.core.web.shared.organization.UIEmployee;
import com.fudanmed.platform.core.web.shared.organization.UIEmployeeCriteria;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
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
import com.sencha.gxt.widget.core.client.form.StoreFilterField;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.RequestHandler2;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.ActionExtensions;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.ObjectListView.SelectEntityListener;
import com.uniquesoft.gwt.client.common.widgets.pager.Extensions;
import com.uniquesoft.gwt.client.common.widgets.pager.IPager;
import com.uniquesoft.gwt.client.common.widgets.pager.IPager.GotoPageHandler;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.action.SingleObjectActions;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.component.treegrid.SGrid;
import edu.fudan.langlab.gxt.client.widget.ComponentExtensions;
import edu.fudan.langlab.gxt.client.widget.ContentPanel;
import edu.fudan.langlab.gxt.client.widget.FramedPanel;
import edu.fudan.langlab.gxt.client.widget.HTableLayoutContainer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import edu.fudan.langlab.security.shared.IFunctionIdentifier;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

public class EmployeeManagementView extends GWTAbstractView implements EmployeeManagementPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(listGrid,criteriaForm,outlineTreeList),
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
  private EmployeeListGrid listGrid;
  
  @Inject
  private EmployeeCriteriaForm criteriaForm;
  
  @Inject
  private OrganizationOutlineTreeGrid outlineTreeList;
  
  private IPager pager;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    this.listGrid.asWidget();
    this.outlineTreeList.asWidget();
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u5458\u5DE5\u7EF4\u62A4");
    final Procedure1<FramedPanel> _function = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          VerticalLayoutContainer _VLayout = EmployeeManagementView.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                HTableLayoutContainer _HTableLayout = EmployeeManagementView.this.widgets.HTableLayout();
                final Procedure1<HTableLayoutContainer> _function = new Procedure1<HTableLayoutContainer>() {
                    public void apply(final HTableLayoutContainer it) {
                      FieldLabel _asWidget = EmployeeManagementView.this.criteriaForm.info.asWidget();
                      FieldLabel _asWidget_1 = EmployeeManagementView.this.criteriaForm.includeLeaveEmployees.asWidget();
                      TextButton _TextButton = EmployeeManagementView.this.widgets.TextButton("\u67E5\u8BE2");
                      final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                          public void apply(final TextButton it) {
                            it.setWidth("80px");
                            final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                public void apply(final SelectEvent it) {
                                  UIEmployeeCriteria _value = EmployeeManagementView.this.criteriaForm.getValue();
                                  UIEmployeeCriteria _withPagerInfo = Extensions.<UIEmployeeCriteria>withPagerInfo(_value, EmployeeManagementView.this.pager);
                                  final Procedure1<UIEmployeeCriteria> _function = new Procedure1<UIEmployeeCriteria>() {
                                      public void apply(final UIEmployeeCriteria it) {
                                        EmployeeManagementView.this.outlineTreeList.deselect();
                                        it.setOrganization(null);
                                        it.setPage(Integer.valueOf(1));
                                      }
                                    };
                                  UIEmployeeCriteria _doubleArrow = ObjectExtensions.<UIEmployeeCriteria>operator_doubleArrow(_withPagerInfo, _function);
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
                int _minus = (-1);
                VerticalLayoutData _VLayoutData = EmployeeManagementView.this.widgets.VLayoutData(1, _minus);
                it.add(_doubleArrow, _VLayoutData);
                IPager<UIEmployee> _createPager = edu.fudan.langlab.gxt.client.pager.Extensions.<UIEmployee>createPager(EmployeeManagementView.this.listGrid);
                final Procedure1<IPager<UIEmployee>> _function_1 = new Procedure1<IPager<UIEmployee>>() {
                    public void apply(final IPager<UIEmployee> it) {
                      final Procedure2<Integer,Integer> _function = new Procedure2<Integer,Integer>() {
                          public void apply(final Integer pageNum, final Integer recordsPerPage) {
                            UIEmployeeCriteria _value = EmployeeManagementView.this.criteriaForm.getValue();
                            UIEmployeeCriteria _withPagerInfo = Extensions.<UIEmployeeCriteria>withPagerInfo(_value, EmployeeManagementView.this.pager);
                            final Procedure1<UIEmployeeCriteria> _function = new Procedure1<UIEmployeeCriteria>() {
                                public void apply(final UIEmployeeCriteria it) {
                                  it.setPage(Integer.valueOf(pageNum));
                                  it.setPageSize(Integer.valueOf(recordsPerPage));
                                }
                              };
                            UIEmployeeCriteria _doubleArrow = ObjectExtensions.<UIEmployeeCriteria>operator_doubleArrow(_withPagerInfo, _function);
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
                IPager<UIEmployee> _doubleArrow_1 = ObjectExtensions.<IPager<UIEmployee>>operator_doubleArrow(_createPager, _function_1);
                EmployeeManagementView.this.pager = _doubleArrow_1;
                HorizontalLayoutContainer _HLayout = EmployeeManagementView.this.widgets.HLayout();
                final Procedure1<HorizontalLayoutContainer> _function_2 = new Procedure1<HorizontalLayoutContainer>() {
                    public void apply(final HorizontalLayoutContainer it) {
                      FieldSet _FieldSet = EmployeeManagementView.this.widgets.FieldSet("\u6240\u5C5E\u673A\u6784");
                      final Procedure1<FieldSet> _function = new Procedure1<FieldSet>() {
                          public void apply(final FieldSet it) {
                            VerticalLayoutContainer _VLayout = EmployeeManagementView.this.widgets.VLayout();
                            final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                                public void apply(final VerticalLayoutContainer it) {
                                  final Function2<UIOrganization,String,Boolean> _function = new Function2<UIOrganization,String,Boolean>() {
                                      public Boolean apply(final UIOrganization item, final String filter) {
                                        boolean _or = false;
                                        String _name = item.getName();
                                        boolean _contains = _name.contains(filter);
                                        if (_contains) {
                                          _or = true;
                                        } else {
                                          boolean _and = false;
                                          String _simplePy = item.getSimplePy();
                                          boolean _notEquals = (!Objects.equal(_simplePy, null));
                                          if (!_notEquals) {
                                            _and = false;
                                          } else {
                                            String _simplePy_1 = item.getSimplePy();
                                            boolean _contains_1 = _simplePy_1.contains(filter);
                                            _and = (_notEquals && _contains_1);
                                          }
                                          _or = (_contains || _and);
                                        }
                                        return Boolean.valueOf(_or);
                                      }
                                    };
                                  StoreFilterField<UIOrganization> _createFilter = ComponentExtensions.<UIOrganization>createFilter(EmployeeManagementView.this.outlineTreeList, _function);
                                  int _minus = (-1);
                                  VerticalLayoutData _VLayoutData = EmployeeManagementView.this.widgets.VLayoutData(1, _minus);
                                  it.add(_createFilter, _VLayoutData);
                                  ContentPanel _ContentPanel = EmployeeManagementView.this.widgets.ContentPanel();
                                  final Procedure1<ContentPanel> _function_1 = new Procedure1<ContentPanel>() {
                                      public void apply(final ContentPanel it) {
                                        SGrid<UIOrganization> _asWidget = EmployeeManagementView.this.outlineTreeList.asWidget();
                                        it.setWidget(_asWidget);
                                      }
                                    };
                                  ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function_1);
                                  VerticalLayoutData _VLayoutData_1 = EmployeeManagementView.this.widgets.VLayoutData(1, 1);
                                  it.add(_doubleArrow, _VLayoutData_1);
                                }
                              };
                            VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                            it.setWidget(_doubleArrow);
                          }
                        };
                      FieldSet _doubleArrow = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet, _function);
                      HorizontalLayoutData _HLayoutData = EmployeeManagementView.this.widgets.HLayoutData(300, 1, 1);
                      it.add(_doubleArrow, _HLayoutData);
                      FieldSet _FieldSet_1 = EmployeeManagementView.this.widgets.FieldSet("\u5458\u5DE5\u5217\u8868");
                      final Procedure1<FieldSet> _function_1 = new Procedure1<FieldSet>() {
                          public void apply(final FieldSet it) {
                            ContentPanel _ContentPanel = EmployeeManagementView.this.widgets.ContentPanel();
                            final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
                                public void apply(final ContentPanel it) {
                                  VerticalLayoutContainer _VLayout = EmployeeManagementView.this.widgets.VLayout();
                                  final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                                      public void apply(final VerticalLayoutContainer it) {
                                        SGroupingGrid<UIEmployee> _asWidget = EmployeeManagementView.this.listGrid.asWidget();
                                        VerticalLayoutData _VLayoutData = EmployeeManagementView.this.widgets.VLayoutData(1, 1);
                                        it.add(_asWidget, _VLayoutData);
                                        Widget _asWidget_1 = EmployeeManagementView.this.pager.asWidget();
                                        int _minus = (-1);
                                        VerticalLayoutData _VLayoutData_1 = EmployeeManagementView.this.widgets.VLayoutData(1, _minus);
                                        it.add(_asWidget_1, _VLayoutData_1);
                                      }
                                    };
                                  VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                                  it.setWidget(_doubleArrow);
                                }
                              };
                            ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
                            it.setWidget(_doubleArrow);
                          }
                        };
                      FieldSet _doubleArrow_1 = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet_1, _function_1);
                      HorizontalLayoutData _HLayoutData_1 = EmployeeManagementView.this.widgets.HLayoutData(1, 1, 1);
                      it.add(_doubleArrow_1, _HLayoutData_1);
                    }
                  };
                HorizontalLayoutContainer _doubleArrow_2 = ObjectExtensions.<HorizontalLayoutContainer>operator_doubleArrow(_HLayout, _function_2);
                VerticalLayoutData _VLayoutData_1 = EmployeeManagementView.this.widgets.VLayoutData(1, 1);
                it.add(_doubleArrow_2, _VLayoutData_1);
              }
            };
          VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
          it.setWidget(_doubleArrow);
          final ActionContext<UIEmployee> ac = ActionExtensions.<UIEmployee>createActionContext(EmployeeManagementView.this.listGrid);
          final Procedure1<Void> _function_1 = new Procedure1<Void>() {
              public void apply(final Void v) {
                ActionContext<UIOrganization> _createActionContext = ActionExtensions.<UIOrganization>createActionContext(EmployeeManagementView.this.outlineTreeList);
                final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                    public void apply(final SingleObjectActions it) {
                      final Procedure1<UIOrganization> _function = new Procedure1<UIOrganization>() {
                          public void apply(final UIOrganization parent) {
                            RCOrganizationProxy _proxy = parent.toProxy();
                            createRequestRequestHandler.execute(_proxy);
                            
                          }
                        };
                      it.onExecute(_function);
                    }
                  };
                SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIOrganization>onSingleObjectAction(_createActionContext, _function);
                TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u65B0\u5EFA");
                it.addButton(_asButtonRequester);
              }
            };
          EmployeeManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.organization.EmployeeManagementPresenter.createRequest" );
            }
          }.apply(), _function_1);
          final Procedure1<Void> _function_2 = new Procedure1<Void>() {
              public void apply(final Void v) {
                TextButton _TextButton = EmployeeManagementView.this.widgets.TextButton("\u5BFC\u5165");
                final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                    public void apply(final TextButton it) {
                      final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                          public void apply(final SelectEvent it) {importRequestRequestHandler.execute();
                            
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
          EmployeeManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.organization.EmployeeManagementPresenter.importRequest" );
            }
          }.apply(), _function_2);
          final Procedure1<Void> _function_3 = new Procedure1<Void>() {
              public void apply(final Void v) {
                final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                    public void apply(final SingleObjectActions it) {
                      final Procedure1<UIEmployee> _function = new Procedure1<UIEmployee>() {
                          public void apply(final UIEmployee selectedValue) {
                            RCEmployeeProxy _proxy = selectedValue.toProxy();
                            modifyRequestRequestHandler.execute(_proxy);
                            
                          }
                        };
                      it.onExecute(_function);
                    }
                  };
                SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIEmployee>onSingleObjectAction(ac, _function);
                TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u4FEE\u6539");
                it.addButton(_asButtonRequester);
              }
            };
          EmployeeManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.organization.EmployeeManagementPresenter.modifyRequest" );
            }
          }.apply(), _function_3);
          final Procedure1<Void> _function_4 = new Procedure1<Void>() {
              public void apply(final Void v) {
                final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                    public void apply(final SingleObjectActions it) {
                      final Procedure1<UIEmployee> _function = new Procedure1<UIEmployee>() {
                          public void apply(final UIEmployee selectedValue) {
                            RCEmployeeProxy _proxy = selectedValue.toProxy();
                            modifyDepartmentRequestHandler.execute(_proxy);
                            
                          }
                        };
                      it.onExecute(_function);
                    }
                  };
                SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIEmployee>onSingleObjectAction(ac, _function);
                TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u90E8\u95E8\u53D8\u52A8");
                it.addButton(_asButtonRequester);
              }
            };
          EmployeeManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.organization.EmployeeManagementPresenter.modifyDepartment" );
            }
          }.apply(), _function_4);
          final Procedure1<Void> _function_5 = new Procedure1<Void>() {
              public void apply(final Void v) {
                final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                    public void apply(final SingleObjectActions it) {
                      final Procedure1<UIEmployee> _function = new Procedure1<UIEmployee>() {
                          public void apply(final UIEmployee selectedValue) {
                            final Procedure1<Void> _function = new Procedure1<Void>() {
                                public void apply(final Void it) {
                                  RCEmployeeProxy _proxy = selectedValue.toProxy();
                                  leaveJobRequestRequestHandler.execute(_proxy);
                                  
                                }
                              };
                            ConfirmMessageBox _ConfirmMessageBox = EmployeeManagementView.this.widgets.ConfirmMessageBox("\u786E\u8BA4", "\u786E\u8BA4\u5458\u5DE5\u79BB\u804C", _function);
                            _ConfirmMessageBox.show();
                          }
                        };
                      it.onExecute(_function);
                      final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                          public Boolean apply(final Void it) {
                            final Function1<UIEmployee,Boolean> _function = new Function1<UIEmployee,Boolean>() {
                                public Boolean apply(final UIEmployee it) {
                                  Boolean _validFor = it.validFor(RCEmployeeAction.leaveJob);
                                  return _validFor;
                                }
                              };
                            Boolean _singleSelectedAnd = ActionExtensions.<UIEmployee>singleSelectedAnd(ac, _function);
                            return _singleSelectedAnd;
                          }
                        };
                      it.onCheckEnable(_function_1);
                    }
                  };
                SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIEmployee>onSingleObjectAction(ac, _function);
                TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u79BB\u804C");
                it.addButton(_asButtonRequester);
              }
            };
          EmployeeManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.organization.EmployeeManagementPresenter.leaveJobRequest" );
            }
          }.apply(), _function_5);
          final Procedure1<Void> _function_6 = new Procedure1<Void>() {
              public void apply(final Void v) {
                final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                    public void apply(final SingleObjectActions it) {
                      final Procedure1<UIEmployee> _function = new Procedure1<UIEmployee>() {
                          public void apply(final UIEmployee selectedValue) {
                            final Procedure1<Void> _function = new Procedure1<Void>() {
                                public void apply(final Void it) {
                                  RCEmployeeProxy _proxy = selectedValue.toProxy();
                                  resumeJobRequestRequestHandler.execute(_proxy);
                                  
                                }
                              };
                            ConfirmMessageBox _ConfirmMessageBox = EmployeeManagementView.this.widgets.ConfirmMessageBox("\u786E\u8BA4", "\u786E\u8BA4\u5458\u5DE5\u590D\u804C", _function);
                            _ConfirmMessageBox.show();
                          }
                        };
                      it.onExecute(_function);
                      final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                          public Boolean apply(final Void it) {
                            final Function1<UIEmployee,Boolean> _function = new Function1<UIEmployee,Boolean>() {
                                public Boolean apply(final UIEmployee it) {
                                  Boolean _validFor = it.validFor(RCEmployeeAction.returnJob);
                                  return _validFor;
                                }
                              };
                            Boolean _singleSelectedAnd = ActionExtensions.<UIEmployee>singleSelectedAnd(ac, _function);
                            return _singleSelectedAnd;
                          }
                        };
                      it.onCheckEnable(_function_1);
                    }
                  };
                SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIEmployee>onSingleObjectAction(ac, _function);
                TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u590D\u804C");
                it.addButton(_asButtonRequester);
              }
            };
          EmployeeManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.organization.EmployeeManagementPresenter.resumeJobRequest" );
            }
          }.apply(), _function_6);
          final Procedure1<Void> _function_7 = new Procedure1<Void>() {
              public void apply(final Void v) {
                final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                    public void apply(final SingleObjectActions it) {
                      final Procedure1<UIEmployee> _function = new Procedure1<UIEmployee>() {
                          public void apply(final UIEmployee selectedValue) {
                            final Procedure1<Void> _function = new Procedure1<Void>() {
                                public void apply(final Void it) {
                                  RCEmployeeProxy _proxy = selectedValue.toProxy();
                                  deleteRequestRequestHandler.execute(_proxy);
                                  
                                }
                              };
                            ConfirmMessageBox _ConfirmMessageBox = EmployeeManagementView.this.widgets.ConfirmMessageBox("\u786E\u8BA4", "\u786E\u8BA4\u5220\u9664", _function);
                            _ConfirmMessageBox.show();
                          }
                        };
                      it.onExecute(_function);
                    }
                  };
                SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIEmployee>onSingleObjectAction(ac, _function);
                TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u5220\u9664");
                it.addButton(_asButtonRequester);
              }
            };
          EmployeeManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.organization.EmployeeManagementPresenter.deleteRequest" );
            }
          }.apply(), _function_7);
          final Procedure1<Void> _function_8 = new Procedure1<Void>() {
              public void apply(final Void v) {
                final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                    public void apply(final SingleObjectActions it) {
                      final Procedure1<UIEmployee> _function = new Procedure1<UIEmployee>() {
                          public void apply(final UIEmployee selectedValue) {
                            RCEmployeeProxy _proxy = selectedValue.toProxy();
                            assignRolesRequestRequestHandler.execute(_proxy);
                            
                          }
                        };
                      it.onExecute(_function);
                    }
                  };
                SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIEmployee>onSingleObjectAction(ac, _function);
                TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u5206\u914D\u89D2\u8272");
                it.addButton(_asButtonRequester);
              }
            };
          EmployeeManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.organization.EmployeeManagementPresenter.assignRolesRequest" );
            }
          }.apply(), _function_8);
          final Procedure1<Void> _function_9 = new Procedure1<Void>() {
              public void apply(final Void v) {
                final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                    public void apply(final SingleObjectActions it) {
                      final Procedure1<UIEmployee> _function = new Procedure1<UIEmployee>() {
                          public void apply(final UIEmployee selectedValue) {
                            RCEmployeeProxy _proxy = selectedValue.toProxy();
                            resetPasswdRequestRequestHandler.execute(_proxy);
                            
                          }
                        };
                      it.onExecute(_function);
                    }
                  };
                SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIEmployee>onSingleObjectAction(ac, _function);
                TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u91CD\u7F6E\u5BC6\u7801");
                it.addButton(_asButtonRequester);
              }
            };
          EmployeeManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.organization.EmployeeManagementPresenter.resetPasswdRequest" );
            }
          }.apply(), _function_9);
          final Procedure1<UIOrganization> _function_10 = new Procedure1<UIOrganization>() {
              public void apply(final UIOrganization org) {
                RCOrganizationProxy _proxy = org.toProxy();
                
                UIEmployeeCriteria _value = EmployeeManagementView.this.criteriaForm.getValue();
                UIEmployeeCriteria _withPagerInfo = Extensions.<UIEmployeeCriteria>withPagerInfo(_value, EmployeeManagementView.this.pager);
                final Procedure1<UIEmployeeCriteria> _function = new Procedure1<UIEmployeeCriteria>() {
                    public void apply(final UIEmployeeCriteria it) {
                      Long _id = org.getId();
                      String _string = _id.toString();
                      String _plus = ("%[" + _string);
                      String _plus_1 = (_plus + "]%");
                      it.setOrgPath(_plus_1);
                      it.setPage(Integer.valueOf(1));
                    }
                  };
                UIEmployeeCriteria _doubleArrow = ObjectExtensions.<UIEmployeeCriteria>operator_doubleArrow(_withPagerInfo, _function);
                organizationSelectedRequestHandler.execute(_proxy,_doubleArrow);
                
              }
            };
          EmployeeManagementView.this.outlineTreeList.addSelectEntityListener(new SelectEntityListener<UIOrganization>() {
              public void objectSelected(UIOrganization selected) {
                _function_10.apply(selected);
              }
          });
        }
      };
    FramedPanel _doubleArrow = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function);
    this.con = _doubleArrow;
  }
  
  public void showResults(final IPagedResult<UIEmployee> results) {
    this.pager.pageLoaded(results);
  }
  
  public void showOutlineDatas(final Collection<UIOrganization> organizations) {
    OrganizationTreeContentProvider _organizationTreeContentProvider = new OrganizationTreeContentProvider(organizations);
    this.outlineTreeList.setContentProvider(_organizationTreeContentProvider);
  }
  
  public void refresh() {
    int _activePage = this.pager.getActivePage();
    this.pager.gotoPage(_activePage);
  }
  
  private RequestHandler1<RCOrganizationProxy> createRequestRequestHandler;
  
  public void createRequest(final RequestHandler1<RCOrganizationProxy> requestHandler) {
    this.createRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler importRequestRequestHandler;
  
  public void importRequest(final RequestHandler requestHandler) {
    this.importRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler2<RCOrganizationProxy,UIEmployeeCriteria> organizationSelectedRequestHandler;
  
  public void organizationSelected(final RequestHandler2<RCOrganizationProxy,UIEmployeeCriteria> requestHandler) {
    this.organizationSelectedRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCEmployeeProxy> deleteRequestRequestHandler;
  
  public void deleteRequest(final RequestHandler1<RCEmployeeProxy> requestHandler) {
    this.deleteRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCEmployeeProxy> modifyRequestRequestHandler;
  
  public void modifyRequest(final RequestHandler1<RCEmployeeProxy> requestHandler) {
    this.modifyRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCEmployeeProxy> modifyDepartmentRequestHandler;
  
  public void modifyDepartment(final RequestHandler1<RCEmployeeProxy> requestHandler) {
    this.modifyDepartmentRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCEmployeeProxy> assignRolesRequestRequestHandler;
  
  public void assignRolesRequest(final RequestHandler1<RCEmployeeProxy> requestHandler) {
    this.assignRolesRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCEmployeeProxy> resetPasswdRequestRequestHandler;
  
  public void resetPasswdRequest(final RequestHandler1<RCEmployeeProxy> requestHandler) {
    this.resetPasswdRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCEmployeeProxy> leaveJobRequestRequestHandler;
  
  public void leaveJobRequest(final RequestHandler1<RCEmployeeProxy> requestHandler) {
    this.leaveJobRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCEmployeeProxy> resumeJobRequestRequestHandler;
  
  public void resumeJobRequest(final RequestHandler1<RCEmployeeProxy> requestHandler) {
    this.resumeJobRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<UIEmployeeCriteria> filterRequestRequestHandler;
  
  public void filterRequest(final RequestHandler1<UIEmployeeCriteria> requestHandler) {
    this.filterRequestRequestHandler = requestHandler;
  }
}
