package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.client.organization.OrganizationOutlinePresenter;
import com.fudanmed.platform.core.web.client.project.RepairTaskCriteriaForm;
import com.fudanmed.platform.core.web.client.project.RepairTaskListGrid;
import com.fudanmed.platform.core.web.client.project.RepairTaskManagementPresenterView;
import com.fudanmed.platform.core.web.client.project.RepairTaskTreeInfoPresenter;
import com.fudanmed.platform.core.web.client.project.RepairTaskTreeInfoPresenterView;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
import com.fudanmed.platform.core.web.shared.project.StatusValidator;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskActionType;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskCriteria;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatus;
import com.google.common.base.Objects;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.sencha.gxt.widget.core.client.Dialog;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Timer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.ActionExtensions;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.ObjectListView.SelectEntityListener;
import com.uniquesoft.gwt.client.common.widgets.pager.IPager;
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.action.SingleObjectActions;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.selector.ObjectSelector;
import edu.fudan.langlab.gxt.client.widget.ContentPanel;
import edu.fudan.langlab.gxt.client.widget.FramedPanel;
import edu.fudan.langlab.gxt.client.widget.HTMLTagsExt;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.PagedList;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTD;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTR;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTable;
import edu.fudan.langlab.gxt.client.widget.SoundWidget;
import edu.fudan.langlab.security.client.Securities;
import edu.fudan.langlab.security.shared.IFunctionIdentifier;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class RepairTaskManagementView extends GWTAbstractView implements RepairTaskManagementPresenterView {
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
  private RepairTaskListGrid listGrid;
  
  @Inject
  private RepairTaskCriteriaForm criteriaForm;
  
  @Inject
  private Provider<OrganizationOutlinePresenter> organizationOutlinePresenter;
  
  private PagedList<UIRepairTask,UIRepairTaskCriteria> pagedList;
  
  private HTML dirtyInfoPanel;
  
  private SoundWidget soundPlayer;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    SoundWidget _soundWidget = new SoundWidget("sound/demo1.mp3");
    this.soundPlayer = _soundWidget;
    HTML _hTML = new HTML();
    final Procedure1<HTML> _function = new Procedure1<HTML>() {
        public void apply(final HTML it) {
          final Procedure1<ClickEvent> _function = new Procedure1<ClickEvent>() {
              public void apply(final ClickEvent it) {
                RepairTaskManagementView.this.refresh();
              }
            };
          it.addClickHandler(new ClickHandler() {
              public void onClick(ClickEvent event) {
                _function.apply(event);
              }
          });
        }
      };
    HTML _doubleArrow = ObjectExtensions.<HTML>operator_doubleArrow(_hTML, _function);
    this.dirtyInfoPanel = _doubleArrow;
    Timer _timer = new Timer();
    this.timer = _timer;
    final Procedure1<RepairTaskListGrid> _function_1 = new Procedure1<RepairTaskListGrid>() {
        public void apply(final RepairTaskListGrid it) {
          it.asWidget();
          it.keepSelection();
          final Procedure1<UIRepairTask> _function = new Procedure1<UIRepairTask>() {
              public void apply(final UIRepairTask it) {
                RCRepairTaskProxy _proxy = it.toProxy();
                showRepairTaskDetailRequestRequestHandler.execute(_proxy);
                
              }
            };
          it.addSelectEntityListener(new SelectEntityListener<UIRepairTask>() {
              public void objectSelected(UIRepairTask selected) {
                _function.apply(selected);
              }
          });
          final Function1<Void,UIRepairTaskCriteria> _function_1 = new Function1<Void,UIRepairTaskCriteria>() {
              public UIRepairTaskCriteria apply(final Void it) {
                UIRepairTaskCriteria _value = RepairTaskManagementView.this.criteriaForm.getValue();
                return _value;
              }
            };
          final Procedure1<IPagedCriteria> _function_2 = new Procedure1<IPagedCriteria>() {
              public void apply(final IPagedCriteria it) {
                filterRequestRequestHandler.execute(((UIRepairTaskCriteria) it));
                
              }
            };
          PagedList<UIRepairTask,UIRepairTaskCriteria> _asPagedList = PagedList.<UIRepairTask, UIRepairTaskCriteria>asPagedList(it, _function_1, _function_2);
          RepairTaskManagementView.this.pagedList = _asPagedList;
        }
      };
    ObjectExtensions.<RepairTaskListGrid>operator_doubleArrow(
      this.listGrid, _function_1);
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u8C03\u5EA6\u5DE5\u4F5C\u53F0");
    final Procedure1<FramedPanel> _function_2 = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          VerticalLayoutContainer _VLayout = RepairTaskManagementView.this.widgets.VLayout();
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
                                  FieldLabel _asWidget = RepairTaskManagementView.this.criteriaForm.comment.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                            PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = RepairTaskManagementView.this.criteriaForm.includeFinishedTask.asWidget();
                                  final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                      public void apply(final FieldLabel it) {
                                        RepairTaskManagementView.this.criteriaForm.includeFinishedTask.setValue(Boolean.valueOf(false));
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
                                  FieldLabel _asWidget = RepairTaskManagementView.this.criteriaForm.status.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
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
                                  FieldLabel _asWidget = RepairTaskManagementView.this.criteriaForm.reportDateRange.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                            PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
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
                                                    FieldLabel _asWidget = RepairTaskManagementView.this.criteriaForm.reportOrg.asWidget();
                                                    ClientUi.operator_add(it, _asWidget);
                                                  }
                                                };
                                              ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                                              PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                                              final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                                  public void apply(final PlainHTMLTD it) {
                                                    TextButton _TextButton = RepairTaskManagementView.this.widgets.TextButton("\u9009\u62E9");
                                                    final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                                                        public void apply(final TextButton it) {
                                                          final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                                              public void apply(final SelectEvent it) {
                                                                OrganizationOutlinePresenter _get = RepairTaskManagementView.this.organizationOutlinePresenter.get();
                                                                final Procedure1<OrganizationOutlinePresenter> _function = new Procedure1<OrganizationOutlinePresenter>() {
                                                                    public void apply(final OrganizationOutlinePresenter it) {
                                                                      final Procedure1<OrganizationOutlinePresenter> _function = new Procedure1<OrganizationOutlinePresenter>() {
                                                                          public void apply(final OrganizationOutlinePresenter it) {
                                                                            final Procedure1<UIOrganization> _function = new Procedure1<UIOrganization>() {
                                                                                public void apply(final UIOrganization it) {
                                                                                  RCOrganizationProxy _proxy = it.toProxy();
                                                                                  RepairTaskManagementView.this.criteriaForm.reportOrg.setValue(_proxy);
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
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                            PlainHTMLTD _td_2 = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function_2 = new Procedure1<PlainHTMLTD>() {
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
                                                    TextButton _TextButton = RepairTaskManagementView.this.widgets.TextButton("\u67E5\u8BE2");
                                                    final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                                                        public void apply(final TextButton it) {
                                                          it.setWidth("80px");
                                                          final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                                              public void apply(final SelectEvent it) {
                                                                UIRepairTaskCriteria _criteria = RepairTaskManagementView.this.pagedList.getCriteria();
                                                                filterRequestRequestHandler.execute(_criteria);
                                                                
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
                                              ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                                              PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                                              final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                                  public void apply(final PlainHTMLTD it) {
                                                    ClientUi.operator_add(it, RepairTaskManagementView.this.dirtyInfoPanel);
                                                  }
                                                };
                                              ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                                              PlainHTMLTD _td_2 = HTMLTagsExt.td(it);
                                              final Procedure1<PlainHTMLTD> _function_2 = new Procedure1<PlainHTMLTD>() {
                                                  public void apply(final PlainHTMLTD it) {
                                                    ClientUi.operator_add(it, RepairTaskManagementView.this.soundPlayer);
                                                  }
                                                };
                                              ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_2, _function_2);
                                            }
                                          };
                                        ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr, _function);
                                      }
                                    };
                                  PlainHTMLTable _doubleArrow = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE, _function);
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
                it.add(_doubleArrow);
                ContentPanel _ContentPanel = RepairTaskManagementView.this.widgets.ContentPanel();
                final Procedure1<ContentPanel> _function_1 = new Procedure1<ContentPanel>() {
                    public void apply(final ContentPanel it) {
                      VerticalLayoutContainer _VLayout = RepairTaskManagementView.this.widgets.VLayout();
                      final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                          public void apply(final VerticalLayoutContainer it) {
                            SGroupingGrid<UIRepairTask> _asWidget = RepairTaskManagementView.this.listGrid.asWidget();
                            VerticalLayoutData _VLayoutData = RepairTaskManagementView.this.widgets.VLayoutData(1, 1);
                            it.add(_asWidget, _VLayoutData);
                            PlainHTMLTable _TABLE = HTMLTagsExt.TABLE();
                            final Procedure1<PlainHTMLTable> _function = new Procedure1<PlainHTMLTable>() {
                                public void apply(final PlainHTMLTable it) {
                                  PlainHTMLTR _tr = HTMLTagsExt.tr(it);
                                  final Procedure1<PlainHTMLTR> _function = new Procedure1<PlainHTMLTR>() {
                                      public void apply(final PlainHTMLTR it) {
                                        PlainHTMLTD _td = HTMLTagsExt.td(it);
                                        final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                            public void apply(final PlainHTMLTD it) {
                                              IPager _pager = RepairTaskManagementView.this.pagedList.getPager();
                                              Widget _asWidget = _pager.asWidget();
                                              ClientUi.operator_add(it, _asWidget);
                                            }
                                          };
                                        ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                                      }
                                    };
                                  ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr, _function);
                                }
                              };
                            PlainHTMLTable _doubleArrow = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE, _function);
                            int _minus = (-1);
                            VerticalLayoutData _VLayoutData_1 = RepairTaskManagementView.this.widgets.VLayoutData(1, _minus);
                            it.add(_doubleArrow, _VLayoutData_1);
                          }
                        };
                      VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                      it.setWidget(_doubleArrow);
                      final ActionContext<UIRepairTask> ac = ActionExtensions.<UIRepairTask>createActionContext(RepairTaskManagementView.this.listGrid);
                      final Procedure1<Void> _function_1 = new Procedure1<Void>() {
                          public void apply(final Void v) {
                            final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                public void apply(final SelectEvent it) {createRequestRequestHandler.execute();
                                  
                                }
                              };
                            TextButton _TextButton = RepairTaskManagementView.this.widgets.TextButton("\u65B0\u5EFA\u62A5\u4FEE", _function);
                            it.addButton(_TextButton);
                          }
                        };
                      RepairTaskManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                        public IFunctionIdentifier apply() {
                          return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.project.RepairTaskManagementPresenter.createRequest" );
                        }
                      }.apply(), _function_1);
                      final Procedure1<Void> _function_2 = new Procedure1<Void>() {
                          public void apply(final Void v) {
                            final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                public void apply(final SingleObjectActions it) {
                                  final Procedure1<UIRepairTask> _function = new Procedure1<UIRepairTask>() {
                                      public void apply(final UIRepairTask selectedValue) {
                                        RCRepairTaskProxy _proxy = selectedValue.toProxy();
                                        modifyRequestRequestHandler.execute(_proxy);
                                        
                                      }
                                    };
                                  it.onExecute(_function);
                                  final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                                      public Boolean apply(final Void it) {
                                        final Function1<UIRepairTask,Boolean> _function = new Function1<UIRepairTask,Boolean>() {
                                            public Boolean apply(final UIRepairTask it) {
                                              UIRepairTaskStatus _status = it.getStatus();
                                              boolean _canExecute = StatusValidator.canExecute(_status, UIRepairTaskActionType.update);
                                              return Boolean.valueOf(_canExecute);
                                            }
                                          };
                                        Boolean _singleSelectedAnd = ActionExtensions.<UIRepairTask>singleSelectedAnd(RepairTaskManagementView.this.listGrid, _function);
                                        return _singleSelectedAnd;
                                      }
                                    };
                                  it.onCheckEnable(_function_1);
                                }
                              };
                            SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIRepairTask>onSingleObjectAction(ac, _function);
                            TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u4FEE\u6539/\u8C03\u5EA6");
                            it.addButton(_asButtonRequester);
                          }
                        };
                      RepairTaskManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                        public IFunctionIdentifier apply() {
                          return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.project.RepairTaskManagementPresenter.modifyRequest" );
                        }
                      }.apply(), _function_2);
                      final Procedure1<Void> _function_3 = new Procedure1<Void>() {
                          public void apply(final Void v) {
                            final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                public void apply(final SingleObjectActions it) {
                                  final Procedure1<UIRepairTask> _function = new Procedure1<UIRepairTask>() {
                                      public void apply(final UIRepairTask selectedValue) {
                                        RCRepairTaskProxy _proxy = selectedValue.toProxy();
                                        dispatchRequestRequestHandler.execute(_proxy);
                                        
                                      }
                                    };
                                  it.onExecute(_function);
                                  final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                                      public Boolean apply(final Void it) {
                                        final Function1<UIRepairTask,Boolean> _function = new Function1<UIRepairTask,Boolean>() {
                                            public Boolean apply(final UIRepairTask it) {
                                              boolean _and = false;
                                              boolean _and_1 = false;
                                              Boolean _isFromReporter = it.getIsFromReporter();
                                              if (!(_isFromReporter).booleanValue()) {
                                                _and_1 = false;
                                              } else {
                                                UIRepairTaskStatus _status = it.getStatus();
                                                boolean _equals = Objects.equal(_status, UIRepairTaskStatus.newCreated);
                                                _and_1 = ((_isFromReporter).booleanValue() && _equals);
                                              }
                                              boolean _not = (!_and_1);
                                              if (!_not) {
                                                _and = false;
                                              } else {
                                                UIRepairTaskStatus _status_1 = it.getStatus();
                                                boolean _canExecute = StatusValidator.canExecute(_status_1, UIRepairTaskActionType.createGroupTask);
                                                _and = (_not && _canExecute);
                                              }
                                              return Boolean.valueOf(_and);
                                            }
                                          };
                                        Boolean _singleSelectedAnd = ActionExtensions.<UIRepairTask>singleSelectedAnd(RepairTaskManagementView.this.listGrid, _function);
                                        return _singleSelectedAnd;
                                      }
                                    };
                                  it.onCheckEnable(_function_1);
                                }
                              };
                            SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIRepairTask>onSingleObjectAction(ac, _function);
                            TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u76F4\u63A5\u8C03\u5EA6");
                            it.addButton(_asButtonRequester);
                          }
                        };
                      RepairTaskManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                        public IFunctionIdentifier apply() {
                          return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.project.RepairTaskManagementPresenter.dispatchRequest" );
                        }
                      }.apply(), _function_3);
                      final Procedure1<Void> _function_4 = new Procedure1<Void>() {
                          public void apply(final Void v) {
                            final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                public void apply(final SingleObjectActions it) {
                                  final Procedure1<UIRepairTask> _function = new Procedure1<UIRepairTask>() {
                                      public void apply(final UIRepairTask selectedValue) {
                                        final Procedure1<Void> _function = new Procedure1<Void>() {
                                            public void apply(final Void it) {
                                              RCRepairTaskProxy _proxy = selectedValue.toProxy();
                                              deleteRequestRequestHandler.execute(_proxy);
                                              
                                            }
                                          };
                                        ConfirmMessageBox _ConfirmMessageBox = RepairTaskManagementView.this.widgets.ConfirmMessageBox("\u786E\u8BA4", "\u786E\u8BA4\u5220\u9664", _function);
                                        _ConfirmMessageBox.show();
                                      }
                                    };
                                  it.onExecute(_function);
                                  final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                                      public Boolean apply(final Void it) {
                                        final Function1<UIRepairTask,Boolean> _function = new Function1<UIRepairTask,Boolean>() {
                                            public Boolean apply(final UIRepairTask it) {
                                              UIRepairTaskStatus _status = it.getStatus();
                                              boolean _canExecute = StatusValidator.canExecute(_status, UIRepairTaskActionType.delete);
                                              return Boolean.valueOf(_canExecute);
                                            }
                                          };
                                        Boolean _singleSelectedAnd = ActionExtensions.<UIRepairTask>singleSelectedAnd(RepairTaskManagementView.this.listGrid, _function);
                                        return _singleSelectedAnd;
                                      }
                                    };
                                  it.onCheckEnable(_function_1);
                                }
                              };
                            SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIRepairTask>onSingleObjectAction(ac, _function);
                            TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u5220\u9664\u62A5\u4FEE");
                            it.addButton(_asButtonRequester);
                          }
                        };
                      RepairTaskManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                        public IFunctionIdentifier apply() {
                          return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.project.RepairTaskManagementPresenter.deleteRequest" );
                        }
                      }.apply(), _function_4);
                      final Procedure1<Void> _function_5 = new Procedure1<Void>() {
                          public void apply(final Void v) {
                            final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                public void apply(final SingleObjectActions it) {
                                  final Procedure1<UIRepairTask> _function = new Procedure1<UIRepairTask>() {
                                      public void apply(final UIRepairTask selectedValue) {
                                        final Procedure1<Void> _function = new Procedure1<Void>() {
                                            public void apply(final Void it) {
                                              RCRepairTaskProxy _proxy = selectedValue.toProxy();
                                              cancelRequestRequestHandler.execute(_proxy);
                                              
                                            }
                                          };
                                        ConfirmMessageBox _ConfirmMessageBox = RepairTaskManagementView.this.widgets.ConfirmMessageBox("\u786E\u8BA4", "\u786E\u8BA4\u53D6\u6D88", _function);
                                        _ConfirmMessageBox.show();
                                      }
                                    };
                                  it.onExecute(_function);
                                  final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                                      public Boolean apply(final Void it) {
                                        final Function1<UIRepairTask,Boolean> _function = new Function1<UIRepairTask,Boolean>() {
                                            public Boolean apply(final UIRepairTask it) {
                                              UIRepairTaskStatus _status = it.getStatus();
                                              boolean _canExecute = StatusValidator.canExecute(_status, UIRepairTaskActionType.cancel);
                                              return Boolean.valueOf(_canExecute);
                                            }
                                          };
                                        Boolean _singleSelectedAnd = ActionExtensions.<UIRepairTask>singleSelectedAnd(RepairTaskManagementView.this.listGrid, _function);
                                        return _singleSelectedAnd;
                                      }
                                    };
                                  it.onCheckEnable(_function_1);
                                }
                              };
                            SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIRepairTask>onSingleObjectAction(ac, _function);
                            TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u53D6\u6D88\u62A5\u4FEE");
                            it.addButton(_asButtonRequester);
                          }
                        };
                      RepairTaskManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                        public IFunctionIdentifier apply() {
                          return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.project.RepairTaskManagementPresenter.cancelRequest" );
                        }
                      }.apply(), _function_5);
                      final Procedure1<Void> _function_6 = new Procedure1<Void>() {
                          public void apply(final Void v) {
                            final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                public void apply(final SingleObjectActions it) {
                                  final Procedure1<UIRepairTask> _function = new Procedure1<UIRepairTask>() {
                                      public void apply(final UIRepairTask selectedValue) {
                                        final Procedure1<Void> _function = new Procedure1<Void>() {
                                            public void apply(final Void it) {
                                              RCRepairTaskProxy _proxy = selectedValue.toProxy();
                                              closeRepairTaskRequestRequestHandler.execute(_proxy);
                                              
                                            }
                                          };
                                        ConfirmMessageBox _ConfirmMessageBox = RepairTaskManagementView.this.widgets.ConfirmMessageBox("\u786E\u8BA4", "\u786E\u8BA4\u7ED3\u5355", _function);
                                        _ConfirmMessageBox.show();
                                      }
                                    };
                                  it.onExecute(_function);
                                  final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                                      public Boolean apply(final Void it) {
                                        final Function1<UIRepairTask,Boolean> _function = new Function1<UIRepairTask,Boolean>() {
                                            public Boolean apply(final UIRepairTask it) {
                                              UIRepairTaskStatus _status = it.getStatus();
                                              boolean _canExecute = StatusValidator.canExecute(_status, UIRepairTaskActionType.close);
                                              return Boolean.valueOf(_canExecute);
                                            }
                                          };
                                        Boolean _singleSelectedAnd = ActionExtensions.<UIRepairTask>singleSelectedAnd(RepairTaskManagementView.this.listGrid, _function);
                                        return _singleSelectedAnd;
                                      }
                                    };
                                  it.onCheckEnable(_function_1);
                                }
                              };
                            SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIRepairTask>onSingleObjectAction(ac, _function);
                            TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u62A5\u4FEE\u7ED3\u5355");
                            it.addButton(_asButtonRequester);
                          }
                        };
                      RepairTaskManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                        public IFunctionIdentifier apply() {
                          return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.project.RepairTaskManagementPresenter.closeRepairTaskRequest" );
                        }
                      }.apply(), _function_6);
                    }
                  };
                ContentPanel _doubleArrow_1 = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function_1);
                VerticalLayoutData _VLayoutData = RepairTaskManagementView.this.widgets.VLayoutData(1, 0.6);
                it.add(_doubleArrow_1, _VLayoutData);
                RepairTaskTreeInfoPresenterView _view = RepairTaskManagementView.this.repairTaskInfoPresenter.getView();
                Widget _asWidget = _view.asWidget();
                VerticalLayoutData _VLayoutData_1 = RepairTaskManagementView.this.widgets.VLayoutData(1, 0.4);
                it.add(_asWidget, _VLayoutData_1);
              }
            };
          VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
          it.setWidget(_doubleArrow);
        }
      };
    FramedPanel _doubleArrow_1 = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function_2);
    this.con = _doubleArrow_1;
  }
  
  public void showResults(final IPagedResult<UIRepairTask> results) {
    this.pagedList.setResults(results);
  }
  
  public void refresh() {
    this.pagedList.refresh();
  }
  
  public void refreshNew(final RCRepairTaskProxy value) {
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          RepairTaskManagementView.this.pagedList.reveal(value);
        }
      };
    this.pagedList.refresh(_function);
  }
  
  private Boolean isDirty;
  
  private Timer timer;
  
  public String buildMessage(final String color) {
    String _plus = ("<a href=\'#\' style=\'font-size:larger;color:" + color);
    String _plus_1 = (_plus + ";\'>\u6709\u65B0\u7684\u5F85\u5904\u7406\u62A5\u4FEE\u4EFB\u52A1\uFF0C\u8BF7\u5237\u65B0!</a>");
    return _plus_1;
  }
  
  public void destroy() {
    super.destroy();
    if ((this.isDirty).booleanValue()) {
      this.timer.cancel();
      this.soundPlayer.stop();
    }
  }
  
  public void markAsDirty() {
    if ((this.isDirty).booleanValue()) {
      return;
    }
    this.isDirty = Boolean.valueOf(true);
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          if ((RepairTaskManagementView.this.isDirty).booleanValue()) {
            String _hTML = RepairTaskManagementView.this.dirtyInfoPanel.getHTML();
            boolean _contains = _hTML.contains("red");
            if (_contains) {
              String _buildMessage = RepairTaskManagementView.this.buildMessage("white");
              RepairTaskManagementView.this.dirtyInfoPanel.setHTML(_buildMessage);
            } else {
              String _buildMessage_1 = RepairTaskManagementView.this.buildMessage("red");
              RepairTaskManagementView.this.dirtyInfoPanel.setHTML(_buildMessage_1);
            }
            RepairTaskManagementView.this.timer.schedule(500);
          } else {
            RepairTaskManagementView.this.timer.cancel();
          }
        }
      };
    this.timer.setProcess(_function);
    this.timer.schedule(500);
    this.soundPlayer.start();
    String _buildMessage = this.buildMessage("red");
    this.dirtyInfoPanel.setHTML(_buildMessage);
  }
  
  public void resetDirty() {
    this.dirtyInfoPanel.setHTML("");
    this.soundPlayer.stop();
    this.isDirty = Boolean.valueOf(false);
  }
  
  private RequestHandler createRequestRequestHandler;
  
  public void createRequest(final RequestHandler requestHandler) {
    this.createRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCRepairTaskProxy> deleteRequestRequestHandler;
  
  public void deleteRequest(final RequestHandler1<RCRepairTaskProxy> requestHandler) {
    this.deleteRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCRepairTaskProxy> cancelRequestRequestHandler;
  
  public void cancelRequest(final RequestHandler1<RCRepairTaskProxy> requestHandler) {
    this.cancelRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCRepairTaskProxy> modifyRequestRequestHandler;
  
  public void modifyRequest(final RequestHandler1<RCRepairTaskProxy> requestHandler) {
    this.modifyRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<UIRepairTaskCriteria> filterRequestRequestHandler;
  
  public void filterRequest(final RequestHandler1<UIRepairTaskCriteria> requestHandler) {
    this.filterRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCRepairTaskProxy> dispatchRequestRequestHandler;
  
  public void dispatchRequest(final RequestHandler1<RCRepairTaskProxy> requestHandler) {
    this.dispatchRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCRepairTaskProxy> closeRepairTaskRequestRequestHandler;
  
  public void closeRepairTaskRequest(final RequestHandler1<RCRepairTaskProxy> requestHandler) {
    this.closeRepairTaskRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCRepairTaskProxy> showRepairTaskDetailRequestRequestHandler;
  
  public void showRepairTaskDetailRequest(final RequestHandler1<RCRepairTaskProxy> requestHandler) {
    this.showRepairTaskDetailRequestRequestHandler = requestHandler;
  }
}
