package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCGroupTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.web.client.device.PictureListPresenter;
import com.fudanmed.platform.core.web.client.device.PictureListPresenterView;
import com.fudanmed.platform.core.web.client.organization.OrganizationOutlinePresenter;
import com.fudanmed.platform.core.web.client.project.CreateWorkItemPictureCommand;
import com.fudanmed.platform.core.web.client.project.GroupTaskCriteriaForm;
import com.fudanmed.platform.core.web.client.project.GroupTaskListGrid;
import com.fudanmed.platform.core.web.client.project.GroupTaskManagementPresenterView;
import com.fudanmed.platform.core.web.client.project.RepairTaskDetailInfoPresenter;
import com.fudanmed.platform.core.web.client.project.RepairTaskDetailInfoPresenterView;
import com.fudanmed.platform.core.web.client.project.ViewWorkItemPictureCommand;
import com.fudanmed.platform.core.web.client.project.WorkItemTaskListPresenter;
import com.fudanmed.platform.core.web.client.project.WorkItemTaskListPresenterView;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemStorageListPresenter;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemStorageListPresenterView;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
import com.fudanmed.platform.core.web.shared.project.HasDocumentsWithAdditionalInfo;
import com.fudanmed.platform.core.web.shared.project.StatusValidator;
import com.fudanmed.platform.core.web.shared.project.UIGroupTask;
import com.fudanmed.platform.core.web.shared.project.UIGroupTaskActionType;
import com.fudanmed.platform.core.web.shared.project.UIGroupTaskCriteria;
import com.fudanmed.platform.core.web.shared.project.UIGroupTaskStatus;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTask;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTaskActionType;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTaskStatus;
import com.google.common.base.Function;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.sencha.gxt.widget.core.client.Dialog;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Timer;
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
import edu.fudan.langlab.gxt.client.selector.ObjectSelector;
import edu.fudan.langlab.gxt.client.widget.ContentPanel;
import edu.fudan.langlab.gxt.client.widget.FramedPanel;
import edu.fudan.langlab.gxt.client.widget.HTMLTagsExt;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTD;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTR;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTable;
import edu.fudan.langlab.gxt.client.widget.SoundWidget;
import edu.fudan.langlab.gxt.client.widget.TabPanel;
import edu.fudan.langlab.security.client.Securities;
import edu.fudan.langlab.security.shared.IFunctionIdentifier;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.StringExtensions;

public class GroupTaskManagementView extends GWTAbstractView implements GroupTaskManagementPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(listGrid,criteriaForm,createWorkItemPictureCommand,viewWorkItemPictureCommand),
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
  
  private WorkItemTaskListPresenter WorkItemTaskListPresenter;
  
  public void setWorkItemTaskListPresenter(final WorkItemTaskListPresenter WorkItemTaskListPresenter) {
    this.WorkItemTaskListPresenter = WorkItemTaskListPresenter;
  }
  
  private RepairTaskDetailInfoPresenter repairTaskDetailInfoPresenter;
  
  public void setRepairTaskDetailInfoPresenter(final RepairTaskDetailInfoPresenter repairTaskDetailInfoPresenter) {
    this.repairTaskDetailInfoPresenter = repairTaskDetailInfoPresenter;
  }
  
  private WorkItemStorageListPresenter workItemStorageListPresenter;
  
  public void setWorkItemStorageListPresenter(final WorkItemStorageListPresenter workItemStorageListPresenter) {
    this.workItemStorageListPresenter = workItemStorageListPresenter;
  }
  
  private PictureListPresenter workitemPictureListPresenter;
  
  public void setWorkitemPictureListPresenter(final PictureListPresenter workitemPictureListPresenter) {
    this.workitemPictureListPresenter = workitemPictureListPresenter;
  }
  
  @Inject
  private GroupTaskListGrid listGrid;
  
  @Inject
  private GroupTaskCriteriaForm criteriaForm;
  
  @Inject
  private Provider<OrganizationOutlinePresenter> organizationOutlinePresenter;
  
  @Inject
  private CreateWorkItemPictureCommand createWorkItemPictureCommand;
  
  @Inject
  private ViewWorkItemPictureCommand viewWorkItemPictureCommand;
  
  private IPager pager;
  
  private TextButton refreshButton;
  
  private SoundWidget soundPlayer;
  
  private Boolean isDirty;
  
  private Timer timer;
  
  private HTML dirtyInfoPanel;
  
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
                GroupTaskManagementView.this.refresh();
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
    this.listGrid.asWidget();
    this.listGrid.keepSelection();
    final ActionContext<UIGroupTask> ac = ActionExtensions.<UIGroupTask>createActionContext(this.listGrid);
    String _xifexpression = null;
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(this.teamName);
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      String _plus = ("--" + this.teamName);
      _xifexpression = _plus;
    } else {
      _xifexpression = "";
    }
    final String header = _xifexpression;
    String _plus_1 = ("\u73ED\u7EC4\u62A5\u4FEE\u5DE5\u4F5C\u53F0" + header);
    FramedPanel _FramedPanel = this.widgets.FramedPanel(_plus_1);
    final Procedure1<FramedPanel> _function_1 = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          VerticalLayoutContainer _VLayout = GroupTaskManagementView.this.widgets.VLayout();
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
                                  FieldLabel _asWidget = GroupTaskManagementView.this.criteriaForm.dateFrom.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                            PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = GroupTaskManagementView.this.criteriaForm.dateTo.asWidget();
                                  ClientUi.operator_add(it, _asWidget);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                            PlainHTMLTD _td_2 = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function_2 = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  FieldLabel _asWidget = GroupTaskManagementView.this.criteriaForm.includeFinishedTask.asWidget();
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
                                  FieldLabel _asWidget = GroupTaskManagementView.this.criteriaForm.status.asWidget();
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
                                                    FieldLabel _asWidget = GroupTaskManagementView.this.criteriaForm.reportOrg.asWidget();
                                                    ClientUi.operator_add(it, _asWidget);
                                                  }
                                                };
                                              ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                                              PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                                              final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                                  public void apply(final PlainHTMLTD it) {
                                                    TextButton _TextButton = GroupTaskManagementView.this.widgets.TextButton("\u9009\u62E9");
                                                    final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                                                        public void apply(final TextButton it) {
                                                          final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                                              public void apply(final SelectEvent it) {
                                                                OrganizationOutlinePresenter _get = GroupTaskManagementView.this.organizationOutlinePresenter.get();
                                                                final Procedure1<OrganizationOutlinePresenter> _function = new Procedure1<OrganizationOutlinePresenter>() {
                                                                    public void apply(final OrganizationOutlinePresenter it) {
                                                                      final Procedure1<OrganizationOutlinePresenter> _function = new Procedure1<OrganizationOutlinePresenter>() {
                                                                          public void apply(final OrganizationOutlinePresenter it) {
                                                                            final Procedure1<UIOrganization> _function = new Procedure1<UIOrganization>() {
                                                                                public void apply(final UIOrganization it) {
                                                                                  RCOrganizationProxy _proxy = it.toProxy();
                                                                                  GroupTaskManagementView.this.criteriaForm.reportOrg.setValue(_proxy);
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
                                                    TextButton _TextButton = GroupTaskManagementView.this.widgets.TextButton("\u67E5\u8BE2");
                                                    final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
                                                        public void apply(final TextButton it) {
                                                          it.setWidth("80px");
                                                          final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                                                              public void apply(final SelectEvent it) {
                                                                UIGroupTaskCriteria _value = GroupTaskManagementView.this.criteriaForm.getValue();
                                                                UIGroupTaskCriteria _withPagerInfo = Extensions.<UIGroupTaskCriteria>withPagerInfo(_value, GroupTaskManagementView.this.pager);
                                                                final Procedure1<UIGroupTaskCriteria> _function = new Procedure1<UIGroupTaskCriteria>() {
                                                                    public void apply(final UIGroupTaskCriteria it) {
                                                                      it.setPage(Integer.valueOf(1));
                                                                    }
                                                                  };
                                                                UIGroupTaskCriteria _doubleArrow = ObjectExtensions.<UIGroupTaskCriteria>operator_doubleArrow(_withPagerInfo, _function);
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
                                                    TextButton _refreshButton = GroupTaskManagementView.this.refreshButton = _doubleArrow;
                                                    ClientUi.operator_add(it, _refreshButton);
                                                  }
                                                };
                                              ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                                              PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                                              final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                                                  public void apply(final PlainHTMLTD it) {
                                                    ClientUi.operator_add(it, GroupTaskManagementView.this.dirtyInfoPanel);
                                                  }
                                                };
                                              ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                                              PlainHTMLTD _td_2 = HTMLTagsExt.td(it);
                                              final Procedure1<PlainHTMLTD> _function_2 = new Procedure1<PlainHTMLTD>() {
                                                  public void apply(final PlainHTMLTD it) {
                                                    ClientUi.operator_add(it, GroupTaskManagementView.this.soundPlayer);
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
                IPager<UIGroupTask> _createPager = edu.fudan.langlab.gxt.client.pager.Extensions.<UIGroupTask>createPager(GroupTaskManagementView.this.listGrid);
                final Procedure1<IPager<UIGroupTask>> _function_1 = new Procedure1<IPager<UIGroupTask>>() {
                    public void apply(final IPager<UIGroupTask> it) {
                      final Procedure2<Integer,Integer> _function = new Procedure2<Integer,Integer>() {
                          public void apply(final Integer pageNum, final Integer recordsPerPage) {
                            UIGroupTaskCriteria _value = GroupTaskManagementView.this.criteriaForm.getValue();
                            UIGroupTaskCriteria _withPagerInfo = Extensions.<UIGroupTaskCriteria>withPagerInfo(_value, GroupTaskManagementView.this.pager);
                            final Procedure1<UIGroupTaskCriteria> _function = new Procedure1<UIGroupTaskCriteria>() {
                                public void apply(final UIGroupTaskCriteria it) {
                                  it.setPage(Integer.valueOf(pageNum));
                                  it.setPageSize(Integer.valueOf(recordsPerPage));
                                }
                              };
                            UIGroupTaskCriteria _doubleArrow = ObjectExtensions.<UIGroupTaskCriteria>operator_doubleArrow(_withPagerInfo, _function);
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
                IPager<UIGroupTask> _doubleArrow_1 = ObjectExtensions.<IPager<UIGroupTask>>operator_doubleArrow(_createPager, _function_1);
                GroupTaskManagementView.this.pager = _doubleArrow_1;
                ContentPanel _ContentPanel = GroupTaskManagementView.this.widgets.ContentPanel();
                final Procedure1<ContentPanel> _function_2 = new Procedure1<ContentPanel>() {
                    public void apply(final ContentPanel it) {
                      VerticalLayoutContainer _VLayout = GroupTaskManagementView.this.widgets.VLayout();
                      final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                          public void apply(final VerticalLayoutContainer it) {
                            SGroupingGrid<UIGroupTask> _asWidget = GroupTaskManagementView.this.listGrid.asWidget();
                            VerticalLayoutData _VLayoutData = GroupTaskManagementView.this.widgets.VLayoutData(1, 1);
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
                                              Widget _asWidget = GroupTaskManagementView.this.pager.asWidget();
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
                            it.add(_doubleArrow);
                          }
                        };
                      VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                      it.setWidget(_doubleArrow);
                      final Procedure1<Void> _function_1 = new Procedure1<Void>() {
                          public void apply(final Void v) {
                            final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                public void apply(final SingleObjectActions it) {
                                  final Procedure1<UIGroupTask> _function = new Procedure1<UIGroupTask>() {
                                      public void apply(final UIGroupTask groupTask) {
                                        RCGroupTaskProxy _proxy = groupTask.toProxy();
                                        createWorkItemTaskRequestRequestHandler.execute(_proxy);
                                        
                                      }
                                    };
                                  it.onExecute(_function);
                                  final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                                      public Boolean apply(final Void it) {
                                        final Function1<UIGroupTask,Boolean> _function = new Function1<UIGroupTask,Boolean>() {
                                            public Boolean apply(final UIGroupTask it) {
                                              UIGroupTaskStatus _status = it.getStatus();
                                              boolean _canExecute = StatusValidator.canExecute(_status, UIGroupTaskActionType.createTask);
                                              return Boolean.valueOf(_canExecute);
                                            }
                                          };
                                        Boolean _singleSelectedAnd = ActionExtensions.<UIGroupTask>singleSelectedAnd(ac, _function);
                                        return _singleSelectedAnd;
                                      }
                                    };
                                  it.onCheckEnable(_function_1);
                                }
                              };
                            SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIGroupTask>onSingleObjectAction(ac, _function);
                            TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u5DE5\u5355\u6D3E\u5DE5");
                            it.addButton(_asButtonRequester);
                          }
                        };
                      GroupTaskManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                        public IFunctionIdentifier apply() {
                          return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.project.GroupTaskManagementPresenter.createWorkItemTaskRequest" );
                        }
                      }.apply(), _function_1);
                      final Procedure1<Void> _function_2 = new Procedure1<Void>() {
                          public void apply(final Void v) {
                            final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                public void apply(final SingleObjectActions it) {
                                  final Procedure1<UIGroupTask> _function = new Procedure1<UIGroupTask>() {
                                      public void apply(final UIGroupTask groupTask) {
                                        RCGroupTaskProxy _proxy = groupTask.toProxy();
                                        finishGroupTaskRequestRequestHandler.execute(_proxy);
                                        
                                      }
                                    };
                                  it.onExecute(_function);
                                  final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                                      public Boolean apply(final Void it) {
                                        final Function1<UIGroupTask,Boolean> _function = new Function1<UIGroupTask,Boolean>() {
                                            public Boolean apply(final UIGroupTask it) {
                                              UIGroupTaskStatus _status = it.getStatus();
                                              boolean _canExecute = StatusValidator.canExecute(_status, UIGroupTaskActionType.reportFinish);
                                              return Boolean.valueOf(_canExecute);
                                            }
                                          };
                                        Boolean _singleSelectedAnd = ActionExtensions.<UIGroupTask>singleSelectedAnd(ac, _function);
                                        return _singleSelectedAnd;
                                      }
                                    };
                                  it.onCheckEnable(_function_1);
                                }
                              };
                            SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIGroupTask>onSingleObjectAction(ac, _function);
                            TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u5B8C\u5DE5\u4E0A\u62A5");
                            it.addButton(_asButtonRequester);
                          }
                        };
                      GroupTaskManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                        public IFunctionIdentifier apply() {
                          return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.project.GroupTaskManagementPresenter.finishGroupTaskRequest" );
                        }
                      }.apply(), _function_2);
                      final Procedure1<Void> _function_3 = new Procedure1<Void>() {
                          public void apply(final Void v) {
                            final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                public void apply(final SingleObjectActions it) {
                                  final Procedure1<UIGroupTask> _function = new Procedure1<UIGroupTask>() {
                                      public void apply(final UIGroupTask groupTask) {
                                        RCGroupTaskProxy _proxy = groupTask.toProxy();
                                        misDispatchGroupTaskRequestRequestHandler.execute(_proxy);
                                        
                                      }
                                    };
                                  it.onExecute(_function);
                                  final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                                      public Boolean apply(final Void it) {
                                        final Function1<UIGroupTask,Boolean> _function = new Function1<UIGroupTask,Boolean>() {
                                            public Boolean apply(final UIGroupTask it) {
                                              UIGroupTaskStatus _status = it.getStatus();
                                              boolean _canExecute = StatusValidator.canExecute(_status, UIGroupTaskActionType.reportMisdispatch);
                                              return Boolean.valueOf(_canExecute);
                                            }
                                          };
                                        Boolean _singleSelectedAnd = ActionExtensions.<UIGroupTask>singleSelectedAnd(ac, _function);
                                        return _singleSelectedAnd;
                                      }
                                    };
                                  it.onCheckEnable(_function_1);
                                }
                              };
                            SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIGroupTask>onSingleObjectAction(ac, _function);
                            TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u4E32\u5355\u4E0A\u62A5");
                            it.addButton(_asButtonRequester);
                          }
                        };
                      GroupTaskManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                        public IFunctionIdentifier apply() {
                          return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.project.GroupTaskManagementPresenter.misDispatchGroupTaskRequest" );
                        }
                      }.apply(), _function_3);
                    }
                  };
                ContentPanel _doubleArrow_2 = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function_2);
                VerticalLayoutData _VLayoutData = GroupTaskManagementView.this.widgets.VLayoutData(1, 0.6);
                it.add(_doubleArrow_2, _VLayoutData);
                TabPanel _TabPanel = GroupTaskManagementView.this.widgets.TabPanel();
                final Procedure1<TabPanel> _function_3 = new Procedure1<TabPanel>() {
                    public void apply(final TabPanel it) {
                      ContentPanel _ContentPanel = GroupTaskManagementView.this.widgets.ContentPanel();
                      final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
                          public void apply(final ContentPanel it) {
                            WorkItemTaskListPresenterView _view = GroupTaskManagementView.this.WorkItemTaskListPresenter.getView();
                            Widget _asWidget = _view.asWidget();
                            it.setWidget(_asWidget);
                            WorkItemTaskListPresenterView _view_1 = GroupTaskManagementView.this.WorkItemTaskListPresenter.getView();
                            final ActionContext<UIWorkItemTask> taskListAc = _view_1.getActionContext();
                            final Procedure1<Void> _function = new Procedure1<Void>() {
                                public void apply(final Void v) {
                                  final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                      public void apply(final SingleObjectActions it) {
                                        final Procedure1<UIWorkItemTask> _function = new Procedure1<UIWorkItemTask>() {
                                            public void apply(final UIWorkItemTask workItemTask) {
                                              RCWorkItemTaskProxy _proxy = workItemTask.toProxy();
                                              finishWorkItemTaskRequestRequestHandler.execute(_proxy);
                                              
                                            }
                                          };
                                        it.onExecute(_function);
                                        final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                                            public Boolean apply(final Void it) {
                                              final Function1<UIWorkItemTask,Boolean> _function = new Function1<UIWorkItemTask,Boolean>() {
                                                  public Boolean apply(final UIWorkItemTask it) {
                                                    UIWorkItemTaskStatus _status = it.getStatus();
                                                    boolean _canExecute = StatusValidator.canExecute(_status, UIWorkItemTaskActionType.finish);
                                                    return Boolean.valueOf(_canExecute);
                                                  }
                                                };
                                              Boolean _singleSelectedAnd = ActionExtensions.<UIWorkItemTask>singleSelectedAnd(taskListAc, _function);
                                              return _singleSelectedAnd;
                                            }
                                          };
                                        it.onCheckEnable(_function_1);
                                      }
                                    };
                                  SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIWorkItemTask>onSingleObjectAction(taskListAc, _function);
                                  TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u5DE5\u5355\u5B8C\u5DE5");
                                  it.addButton(_asButtonRequester);
                                }
                              };
                            GroupTaskManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                              public IFunctionIdentifier apply() {
                                return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.project.GroupTaskManagementPresenter.finishWorkItemTaskRequest" );
                              }
                            }.apply(), _function);
                            final Procedure1<Void> _function_1 = new Procedure1<Void>() {
                                public void apply(final Void v) {
                                  final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                      public void apply(final SingleObjectActions it) {
                                        final Procedure1<UIWorkItemTask> _function = new Procedure1<UIWorkItemTask>() {
                                            public void apply(final UIWorkItemTask workItemTask) {
                                              RCWorkItemTaskProxy _proxy = workItemTask.toProxy();
                                              pendWorkItemTaskRequestRequestHandler.execute(_proxy);
                                              
                                            }
                                          };
                                        it.onExecute(_function);
                                        final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                                            public Boolean apply(final Void it) {
                                              final Function1<UIWorkItemTask,Boolean> _function = new Function1<UIWorkItemTask,Boolean>() {
                                                  public Boolean apply(final UIWorkItemTask it) {
                                                    UIWorkItemTaskStatus _status = it.getStatus();
                                                    boolean _canExecute = StatusValidator.canExecute(_status, UIWorkItemTaskActionType.pend);
                                                    return Boolean.valueOf(_canExecute);
                                                  }
                                                };
                                              Boolean _singleSelectedAnd = ActionExtensions.<UIWorkItemTask>singleSelectedAnd(taskListAc, _function);
                                              return _singleSelectedAnd;
                                            }
                                          };
                                        it.onCheckEnable(_function_1);
                                      }
                                    };
                                  SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIWorkItemTask>onSingleObjectAction(taskListAc, _function);
                                  TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u5DE5\u5355\u6302\u8D77");
                                  it.addButton(_asButtonRequester);
                                }
                              };
                            GroupTaskManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                              public IFunctionIdentifier apply() {
                                return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.project.GroupTaskManagementPresenter.pendWorkItemTaskRequest" );
                              }
                            }.apply(), _function_1);
                            final Procedure1<Void> _function_2 = new Procedure1<Void>() {
                                public void apply(final Void v) {
                                  final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                      public void apply(final SingleObjectActions it) {
                                        final Procedure1<UIWorkItemTask> _function = new Procedure1<UIWorkItemTask>() {
                                            public void apply(final UIWorkItemTask workItemTask) {
                                              RCWorkItemTaskProxy _proxy = workItemTask.toProxy();
                                              cancelPendWorkItemTaskRequestRequestHandler.execute(_proxy);
                                              
                                            }
                                          };
                                        it.onExecute(_function);
                                        final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                                            public Boolean apply(final Void it) {
                                              final Function1<UIWorkItemTask,Boolean> _function = new Function1<UIWorkItemTask,Boolean>() {
                                                  public Boolean apply(final UIWorkItemTask it) {
                                                    UIWorkItemTaskStatus _status = it.getStatus();
                                                    boolean _canExecute = StatusValidator.canExecute(_status, UIWorkItemTaskActionType.cancelPend);
                                                    return Boolean.valueOf(_canExecute);
                                                  }
                                                };
                                              Boolean _singleSelectedAnd = ActionExtensions.<UIWorkItemTask>singleSelectedAnd(taskListAc, _function);
                                              return _singleSelectedAnd;
                                            }
                                          };
                                        it.onCheckEnable(_function_1);
                                      }
                                    };
                                  SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIWorkItemTask>onSingleObjectAction(taskListAc, _function);
                                  TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u7ED3\u675F\u6302\u8D77");
                                  it.addButton(_asButtonRequester);
                                }
                              };
                            GroupTaskManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                              public IFunctionIdentifier apply() {
                                return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.project.GroupTaskManagementPresenter.cancelPendWorkItemTaskRequest" );
                              }
                            }.apply(), _function_2);
                            final Procedure1<Void> _function_3 = new Procedure1<Void>() {
                                public void apply(final Void v) {
                                  final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                      public void apply(final SingleObjectActions it) {
                                        final Procedure1<UIWorkItemTask> _function = new Procedure1<UIWorkItemTask>() {
                                            public void apply(final UIWorkItemTask workItemTask) {
                                              RCWorkItemTaskProxy _proxy = workItemTask.toProxy();
                                              outsourceWorkItemTaskRequestRequestHandler.execute(_proxy);
                                              
                                            }
                                          };
                                        it.onExecute(_function);
                                        final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                                            public Boolean apply(final Void it) {
                                              final Function1<UIWorkItemTask,Boolean> _function = new Function1<UIWorkItemTask,Boolean>() {
                                                  public Boolean apply(final UIWorkItemTask it) {
                                                    UIWorkItemTaskStatus _status = it.getStatus();
                                                    boolean _canExecute = StatusValidator.canExecute(_status, UIWorkItemTaskActionType.oursource);
                                                    return Boolean.valueOf(_canExecute);
                                                  }
                                                };
                                              Boolean _singleSelectedAnd = ActionExtensions.<UIWorkItemTask>singleSelectedAnd(taskListAc, _function);
                                              return _singleSelectedAnd;
                                            }
                                          };
                                        it.onCheckEnable(_function_1);
                                      }
                                    };
                                  SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIWorkItemTask>onSingleObjectAction(taskListAc, _function);
                                  TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u9700\u5916\u534F");
                                  it.addButton(_asButtonRequester);
                                }
                              };
                            GroupTaskManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                              public IFunctionIdentifier apply() {
                                return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.project.GroupTaskManagementPresenter.outsourceWorkItemTaskRequest" );
                              }
                            }.apply(), _function_3);
                            final Procedure1<Void> _function_4 = new Procedure1<Void>() {
                                public void apply(final Void v) {
                                  final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                      public void apply(final SingleObjectActions it) {
                                        final Procedure1<UIWorkItemTask> _function = new Procedure1<UIWorkItemTask>() {
                                            public void apply(final UIWorkItemTask workItemTask) {
                                              RCWorkItemTaskProxy _proxy = workItemTask.toProxy();
                                              finishOutsourceWorkItemTaskRequestRequestHandler.execute(_proxy);
                                              
                                            }
                                          };
                                        it.onExecute(_function);
                                        final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                                            public Boolean apply(final Void it) {
                                              final Function1<UIWorkItemTask,Boolean> _function = new Function1<UIWorkItemTask,Boolean>() {
                                                  public Boolean apply(final UIWorkItemTask it) {
                                                    UIWorkItemTaskStatus _status = it.getStatus();
                                                    boolean _canExecute = StatusValidator.canExecute(_status, UIWorkItemTaskActionType.finishOutsource);
                                                    return Boolean.valueOf(_canExecute);
                                                  }
                                                };
                                              Boolean _singleSelectedAnd = ActionExtensions.<UIWorkItemTask>singleSelectedAnd(taskListAc, _function);
                                              return _singleSelectedAnd;
                                            }
                                          };
                                        it.onCheckEnable(_function_1);
                                      }
                                    };
                                  SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIWorkItemTask>onSingleObjectAction(taskListAc, _function);
                                  TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u5B8C\u6210\u5916\u534F");
                                  it.addButton(_asButtonRequester);
                                }
                              };
                            GroupTaskManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                              public IFunctionIdentifier apply() {
                                return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.project.GroupTaskManagementPresenter.finishOutsourceWorkItemTaskRequest" );
                              }
                            }.apply(), _function_4);
                            final Procedure1<Void> _function_5 = new Procedure1<Void>() {
                                public void apply(final Void v) {
                                  final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                      public void apply(final SingleObjectActions it) {
                                        final Procedure1<UIWorkItemTask> _function = new Procedure1<UIWorkItemTask>() {
                                            public void apply(final UIWorkItemTask workItemTask) {
                                              RCWorkItemTaskProxy _proxy = workItemTask.toProxy();
                                              misDispatchingWorkItemTaskRequestRequestHandler.execute(_proxy);
                                              
                                            }
                                          };
                                        it.onExecute(_function);
                                        final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                                            public Boolean apply(final Void it) {
                                              final Function1<UIWorkItemTask,Boolean> _function = new Function1<UIWorkItemTask,Boolean>() {
                                                  public Boolean apply(final UIWorkItemTask it) {
                                                    UIWorkItemTaskStatus _status = it.getStatus();
                                                    boolean _canExecute = StatusValidator.canExecute(_status, UIWorkItemTaskActionType.misDispatching);
                                                    return Boolean.valueOf(_canExecute);
                                                  }
                                                };
                                              Boolean _singleSelectedAnd = ActionExtensions.<UIWorkItemTask>singleSelectedAnd(taskListAc, _function);
                                              return _singleSelectedAnd;
                                            }
                                          };
                                        it.onCheckEnable(_function_1);
                                      }
                                    };
                                  SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIWorkItemTask>onSingleObjectAction(taskListAc, _function);
                                  TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u5DE5\u5355\u4E32\u5355");
                                  it.addButton(_asButtonRequester);
                                }
                              };
                            GroupTaskManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                              public IFunctionIdentifier apply() {
                                return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.project.GroupTaskManagementPresenter.misDispatchingWorkItemTaskRequest" );
                              }
                            }.apply(), _function_5);
                            final Procedure1<Void> _function_6 = new Procedure1<Void>() {
                                public void apply(final Void v) {
                                  final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                      public void apply(final SingleObjectActions it) {
                                        final Procedure1<UIWorkItemTask> _function = new Procedure1<UIWorkItemTask>() {
                                            public void apply(final UIWorkItemTask workItemTask) {
                                              RCWorkItemTaskProxy _proxy = workItemTask.toProxy();
                                              followUpWOrkItemTaskRequestRequestHandler.execute(_proxy);
                                              
                                            }
                                          };
                                        it.onExecute(_function);
                                        final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                                            public Boolean apply(final Void it) {
                                              final Function1<UIWorkItemTask,Boolean> _function = new Function1<UIWorkItemTask,Boolean>() {
                                                  public Boolean apply(final UIWorkItemTask it) {
                                                    UIWorkItemTaskStatus _status = it.getStatus();
                                                    boolean _canExecute = StatusValidator.canExecute(_status, UIWorkItemTaskActionType.followup);
                                                    return Boolean.valueOf(_canExecute);
                                                  }
                                                };
                                              Boolean _singleSelectedAnd = ActionExtensions.<UIWorkItemTask>singleSelectedAnd(taskListAc, _function);
                                              return _singleSelectedAnd;
                                            }
                                          };
                                        it.onCheckEnable(_function_1);
                                      }
                                    };
                                  SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIWorkItemTask>onSingleObjectAction(taskListAc, _function);
                                  TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u5DE5\u5355\u8DDF\u8FDB");
                                  it.addButton(_asButtonRequester);
                                }
                              };
                            GroupTaskManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                              public IFunctionIdentifier apply() {
                                return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.project.GroupTaskManagementPresenter.followUpWOrkItemTaskRequest" );
                              }
                            }.apply(), _function_6);
                            final Procedure1<Void> _function_7 = new Procedure1<Void>() {
                                public void apply(final Void v) {
                                  final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                      public void apply(final SingleObjectActions it) {
                                        final Procedure1<UIWorkItemTask> _function = new Procedure1<UIWorkItemTask>() {
                                            public void apply(final UIWorkItemTask workItemTask) {
                                              RCWorkItemTaskProxy _proxy = workItemTask.toProxy();
                                              printWorkItemRequestRequestHandler.execute(_proxy);
                                              
                                            }
                                          };
                                        it.onExecute(_function);
                                      }
                                    };
                                  SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIWorkItemTask>onSingleObjectAction(taskListAc, _function);
                                  TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u5DE5\u5355\u6253\u5370");
                                  it.addButton(_asButtonRequester);
                                }
                              };
                            GroupTaskManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                              public IFunctionIdentifier apply() {
                                return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.project.GroupTaskManagementPresenter.printWorkItemRequest" );
                              }
                            }.apply(), _function_7);
                            final Function1<UIWorkItemTask,RCWorkItemTaskProxy> _function_8 = new Function1<UIWorkItemTask,RCWorkItemTaskProxy>() {
                                public RCWorkItemTaskProxy apply(final UIWorkItemTask it) {
                                  RCWorkItemTaskProxy _proxy = it.toProxy();
                                  return _proxy;
                                }
                              };
                            ActionContext<RCWorkItemTaskProxy> _adapt = taskListAc.<RCWorkItemTaskProxy>adapt(new Function<UIWorkItemTask,RCWorkItemTaskProxy>() {
                                public RCWorkItemTaskProxy apply(UIWorkItemTask input) {
                                  return _function_8.apply(input);
                                }
                            });
                            it.addCommand(_adapt, GroupTaskManagementView.this.createWorkItemPictureCommand);
                            final Function1<UIWorkItemTask,HasDocumentsWithAdditionalInfo> _function_9 = new Function1<UIWorkItemTask,HasDocumentsWithAdditionalInfo>() {
                                public HasDocumentsWithAdditionalInfo apply(final UIWorkItemTask uitask) {
                                  HasDocumentsWithAdditionalInfo _hasDocumentsWithAdditionalInfo = new HasDocumentsWithAdditionalInfo();
                                  final Procedure1<HasDocumentsWithAdditionalInfo> _function = new Procedure1<HasDocumentsWithAdditionalInfo>() {
                                      public void apply(final HasDocumentsWithAdditionalInfo it) {
                                        RCWorkItemTaskProxy _proxy = uitask.toProxy();
                                        it.setValue(_proxy);
                                        Boolean _hasDocuments = uitask.getHasDocuments();
                                        it.setHasDocuments(_hasDocuments);
                                      }
                                    };
                                  HasDocumentsWithAdditionalInfo _doubleArrow = ObjectExtensions.<HasDocumentsWithAdditionalInfo>operator_doubleArrow(_hasDocumentsWithAdditionalInfo, _function);
                                  return _doubleArrow;
                                }
                              };
                            ActionContext<HasDocumentsWithAdditionalInfo> _adapt_1 = taskListAc.<HasDocumentsWithAdditionalInfo>adapt(new Function<UIWorkItemTask,HasDocumentsWithAdditionalInfo>() {
                                public HasDocumentsWithAdditionalInfo apply(UIWorkItemTask input) {
                                  return _function_9.apply(input);
                                }
                            });
                            it.addCommand(_adapt_1, GroupTaskManagementView.this.viewWorkItemPictureCommand);
                          }
                        };
                      ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
                      it.add(_doubleArrow, "\u6D3E\u5DE5\u4FE1\u606F");
                      WorkItemStorageListPresenterView _view = GroupTaskManagementView.this.workItemStorageListPresenter.getView();
                      Widget _asWidget = _view.asWidget();
                      it.add(_asWidget, "\u7528\u6599\u4FE1\u606F");
                      RepairTaskDetailInfoPresenterView _view_1 = GroupTaskManagementView.this.repairTaskDetailInfoPresenter.getView();
                      Widget _asWidget_1 = _view_1.asWidget();
                      it.add(_asWidget_1, "\u62A5\u4FEE\u4FE1\u606F");
                      ContentPanel _ContentPanel_1 = GroupTaskManagementView.this.widgets.ContentPanel();
                      final Procedure1<ContentPanel> _function_1 = new Procedure1<ContentPanel>() {
                          public void apply(final ContentPanel it) {
                            PictureListPresenterView _view = GroupTaskManagementView.this.workitemPictureListPresenter.getView();
                            Widget _asWidget = _view.asWidget();
                            it.setWidget(_asWidget);
                          }
                        };
                      ContentPanel _doubleArrow_1 = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel_1, _function_1);
                      it.add(_doubleArrow_1, "\u5DE5\u5355\u56FE\u7247");
                    }
                  };
                TabPanel _doubleArrow_3 = ObjectExtensions.<TabPanel>operator_doubleArrow(_TabPanel, _function_3);
                VerticalLayoutData _VLayoutData_1 = GroupTaskManagementView.this.widgets.VLayoutData(1, 0.4);
                it.add(_doubleArrow_3, _VLayoutData_1);
              }
            };
          VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
          it.setWidget(_doubleArrow);
          final Procedure1<UIGroupTask> _function_1 = new Procedure1<UIGroupTask>() {
              public void apply(final UIGroupTask it) {
                RCGroupTaskProxy _proxy = it.toProxy();
                showGroupTaskDetailRequestRequestHandler.execute(_proxy);
                
              }
            };
          GroupTaskManagementView.this.listGrid.addSelectEntityListener(new SelectEntityListener<UIGroupTask>() {
              public void objectSelected(UIGroupTask selected) {
                _function_1.apply(selected);
              }
          });
        }
      };
    FramedPanel _doubleArrow_1 = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function_1);
    this.con = _doubleArrow_1;
  }
  
  public void showResults(final IPagedResult<UIGroupTask> results) {
    this.pager.pageLoaded(results);
    this.refreshButton.setHTML("\u67E5\u8BE2");
  }
  
  public void refresh() {
    int _activePage = this.pager.getActivePage();
    this.pager.gotoPage(_activePage);
  }
  
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
          if ((GroupTaskManagementView.this.isDirty).booleanValue()) {
            String _hTML = GroupTaskManagementView.this.dirtyInfoPanel.getHTML();
            boolean _contains = _hTML.contains("red");
            if (_contains) {
              String _buildMessage = GroupTaskManagementView.this.buildMessage("white");
              GroupTaskManagementView.this.dirtyInfoPanel.setHTML(_buildMessage);
            } else {
              String _buildMessage_1 = GroupTaskManagementView.this.buildMessage("red");
              GroupTaskManagementView.this.dirtyInfoPanel.setHTML(_buildMessage_1);
            }
            GroupTaskManagementView.this.timer.schedule(500);
          } else {
            GroupTaskManagementView.this.timer.cancel();
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
  
  private String teamName;
  
  public void setTeamName(final String name) {
    this.teamName = name;
  }
  
  public ActionContext<UIGroupTask> getActionContext() {
    ActionContext<UIGroupTask> _createActionContext = ActionExtensions.<UIGroupTask>createActionContext(this.listGrid);
    return _createActionContext;
  }
  
  private RequestHandler1<UIGroupTaskCriteria> filterRequestRequestHandler;
  
  public void filterRequest(final RequestHandler1<UIGroupTaskCriteria> requestHandler) {
    this.filterRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCGroupTaskProxy> showGroupTaskDetailRequestRequestHandler;
  
  public void showGroupTaskDetailRequest(final RequestHandler1<RCGroupTaskProxy> requestHandler) {
    this.showGroupTaskDetailRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCGroupTaskProxy> createWorkItemTaskRequestRequestHandler;
  
  public void createWorkItemTaskRequest(final RequestHandler1<RCGroupTaskProxy> requestHandler) {
    this.createWorkItemTaskRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCGroupTaskProxy> finishGroupTaskRequestRequestHandler;
  
  public void finishGroupTaskRequest(final RequestHandler1<RCGroupTaskProxy> requestHandler) {
    this.finishGroupTaskRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCGroupTaskProxy> misDispatchGroupTaskRequestRequestHandler;
  
  public void misDispatchGroupTaskRequest(final RequestHandler1<RCGroupTaskProxy> requestHandler) {
    this.misDispatchGroupTaskRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCWorkItemTaskProxy> pendWorkItemTaskRequestRequestHandler;
  
  public void pendWorkItemTaskRequest(final RequestHandler1<RCWorkItemTaskProxy> requestHandler) {
    this.pendWorkItemTaskRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCWorkItemTaskProxy> cancelPendWorkItemTaskRequestRequestHandler;
  
  public void cancelPendWorkItemTaskRequest(final RequestHandler1<RCWorkItemTaskProxy> requestHandler) {
    this.cancelPendWorkItemTaskRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCWorkItemTaskProxy> outsourceWorkItemTaskRequestRequestHandler;
  
  public void outsourceWorkItemTaskRequest(final RequestHandler1<RCWorkItemTaskProxy> requestHandler) {
    this.outsourceWorkItemTaskRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCWorkItemTaskProxy> finishOutsourceWorkItemTaskRequestRequestHandler;
  
  public void finishOutsourceWorkItemTaskRequest(final RequestHandler1<RCWorkItemTaskProxy> requestHandler) {
    this.finishOutsourceWorkItemTaskRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCWorkItemTaskProxy> misDispatchingWorkItemTaskRequestRequestHandler;
  
  public void misDispatchingWorkItemTaskRequest(final RequestHandler1<RCWorkItemTaskProxy> requestHandler) {
    this.misDispatchingWorkItemTaskRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCWorkItemTaskProxy> finishWorkItemTaskRequestRequestHandler;
  
  public void finishWorkItemTaskRequest(final RequestHandler1<RCWorkItemTaskProxy> requestHandler) {
    this.finishWorkItemTaskRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCWorkItemTaskProxy> followUpWOrkItemTaskRequestRequestHandler;
  
  public void followUpWOrkItemTaskRequest(final RequestHandler1<RCWorkItemTaskProxy> requestHandler) {
    this.followUpWOrkItemTaskRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCWorkItemTaskProxy> printWorkItemRequestRequestHandler;
  
  public void printWorkItemRequest(final RequestHandler1<RCWorkItemTaskProxy> requestHandler) {
    this.printWorkItemRequestRequestHandler = requestHandler;
  }
}
