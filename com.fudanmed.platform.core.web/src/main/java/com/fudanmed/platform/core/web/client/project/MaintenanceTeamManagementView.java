package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.OrganizationOutlinePresenter;
import com.fudanmed.platform.core.web.client.organization.OrganizationOutlinePresenterView;
import com.fudanmed.platform.core.web.client.project.MaintenanceTeamListGrid;
import com.fudanmed.platform.core.web.client.project.MaintenanceTeamManagementPresenterView;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
import com.fudanmed.platform.core.web.shared.project.UIMaintenanceTeam;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.form.FieldSet;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.ActionExtensions;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.extensions.ObjectSelectionProviders;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.action.SingleObjectActions;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.widget.ContentPanel;
import edu.fudan.langlab.gxt.client.widget.FramedPanel;
import edu.fudan.langlab.gxt.client.widget.HTMLTagsExt;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTD;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTR;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTable;
import edu.fudan.langlab.security.client.Securities;
import edu.fudan.langlab.security.shared.IFunctionIdentifier;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class MaintenanceTeamManagementView extends GWTAbstractView implements MaintenanceTeamManagementPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(maintenanceTeamListGrid),
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
  private MaintenanceTeamListGrid maintenanceTeamListGrid;
  
  private OrganizationOutlinePresenter organizationOutlinePresenter;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u7EF4\u4FEE\u73ED\u7EC4\u8BBE\u7F6E");
    final Procedure1<FramedPanel> _function = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          HorizontalLayoutContainer _HLayout = MaintenanceTeamManagementView.this.widgets.HLayout();
          final Procedure1<HorizontalLayoutContainer> _function = new Procedure1<HorizontalLayoutContainer>() {
              public void apply(final HorizontalLayoutContainer it) {
                MaintenanceTeamManagementView.this.maintenanceTeamListGrid.asWidget();
                OrganizationOutlinePresenterView _view = MaintenanceTeamManagementView.this.organizationOutlinePresenter.getView();
                final ActionContext<UIOrganization> ac = _view.getActionContext();
                FieldSet _FieldSet = MaintenanceTeamManagementView.this.widgets.FieldSet("\u7EC4\u7EC7\u673A\u6784");
                final Procedure1<FieldSet> _function = new Procedure1<FieldSet>() {
                    public void apply(final FieldSet it) {
                      OrganizationOutlinePresenterView _view = MaintenanceTeamManagementView.this.organizationOutlinePresenter.getView();
                      Widget _asWidget = _view.asWidget();
                      it.setWidget(_asWidget);
                    }
                  };
                FieldSet _doubleArrow = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet, _function);
                HorizontalLayoutData _HLayoutData = MaintenanceTeamManagementView.this.widgets.HLayoutData(0.4, 1, 1);
                it.add(_doubleArrow, _HLayoutData);
                PlainHTMLTable _TABLE = HTMLTagsExt.TABLE();
                final Procedure1<PlainHTMLTable> _function_1 = new Procedure1<PlainHTMLTable>() {
                    public void apply(final PlainHTMLTable it) {
                      PlainHTMLTR _tr = HTMLTagsExt.tr(it);
                      final Procedure1<PlainHTMLTR> _function = new Procedure1<PlainHTMLTR>() {
                          public void apply(final PlainHTMLTR it) {
                            PlainHTMLTD _td = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  final Procedure1<Void> _function = new Procedure1<Void>() {
                                      public void apply(final Void v) {
                                        final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                            public void apply(final SingleObjectActions it) {
                                              final Procedure1<UIOrganization> _function = new Procedure1<UIOrganization>() {
                                                  public void apply(final UIOrganization org) {
                                                    ac.deselect();
                                                    RCOrganizationProxy _proxy = org.toProxy();
                                                    selectAsTeamRequestHandler.execute(_proxy);
                                                    
                                                  }
                                                };
                                              it.onExecute(_function);
                                              final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                                                  public Boolean apply(final Void it) {
                                                    final Function1<UIOrganization,Boolean> _function = new Function1<UIOrganization,Boolean>() {
                                                        public Boolean apply(final UIOrganization selected) {
                                                          Iterable<UIMaintenanceTeam> _objects = MaintenanceTeamManagementView.this.maintenanceTeamListGrid.getObjects();
                                                          final Function1<UIMaintenanceTeam,Boolean> _function = new Function1<UIMaintenanceTeam,Boolean>() {
                                                              public Boolean apply(final UIMaintenanceTeam it) {
                                                                RCOrganizationProxy _organization = it.getOrganization();
                                                                Long _id = _organization.getId();
                                                                Long _id_1 = selected.getId();
                                                                boolean _equals = Objects.equal(_id, _id_1);
                                                                return Boolean.valueOf(_equals);
                                                              }
                                                            };
                                                          boolean _exists = IterableExtensions.<UIMaintenanceTeam>exists(_objects, _function);
                                                          boolean _not = (!_exists);
                                                          return Boolean.valueOf(_not);
                                                        }
                                                      };
                                                    Boolean _isOnlySelectedAnd = ObjectSelectionProviders.<UIOrganization>isOnlySelectedAnd(ac, _function);
                                                    return _isOnlySelectedAnd;
                                                  }
                                                };
                                              it.onCheckEnable(_function_1);
                                            }
                                          };
                                        SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIOrganization>onSingleObjectAction(ac, _function);
                                        TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("=>");
                                        final Procedure1<TextButton> _function_1 = new Procedure1<TextButton>() {
                                            public void apply(final TextButton it) {
                                              it.setWidth(50);
                                            }
                                          };
                                        TextButton _doubleArrow = ObjectExtensions.<TextButton>operator_doubleArrow(_asButtonRequester, _function_1);
                                        ClientUi.operator_add(it, _doubleArrow);
                                      }
                                    };
                                  MaintenanceTeamManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                                    public IFunctionIdentifier apply() {
                                      return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.project.MaintenanceTeamManagementPresenter.selectAsTeam" );
                                    }
                                  }.apply(), _function);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr, _function);
                      PlainHTMLTR _tr_1 = HTMLTagsExt.tr(it);
                      final Procedure1<PlainHTMLTR> _function_1 = new Procedure1<PlainHTMLTR>() {
                          public void apply(final PlainHTMLTR it) {
                            PlainHTMLTD _td = HTMLTagsExt.td(it);
                            final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                                public void apply(final PlainHTMLTD it) {
                                  final Procedure1<Void> _function = new Procedure1<Void>() {
                                      public void apply(final Void v) {
                                        ActionContext<UIMaintenanceTeam> _createActionContext = ActionExtensions.<UIMaintenanceTeam>createActionContext(MaintenanceTeamManagementView.this.maintenanceTeamListGrid);
                                        final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
                                            public void apply(final SingleObjectActions it) {
                                              final Procedure1<UIMaintenanceTeam> _function = new Procedure1<UIMaintenanceTeam>() {
                                                  public void apply(final UIMaintenanceTeam team) {
                                                    ac.deselect();
                                                    RCMaintenanceTeamProxy _proxy = team.toProxy();
                                                    removeFromTeamRequestHandler.execute(_proxy);
                                                    
                                                  }
                                                };
                                              it.onExecute(_function);
                                            }
                                          };
                                        SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIMaintenanceTeam>onSingleObjectAction(_createActionContext, _function);
                                        TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("<=");
                                        final Procedure1<TextButton> _function_1 = new Procedure1<TextButton>() {
                                            public void apply(final TextButton it) {
                                              it.setWidth(50);
                                            }
                                          };
                                        TextButton _doubleArrow = ObjectExtensions.<TextButton>operator_doubleArrow(_asButtonRequester, _function_1);
                                        ClientUi.operator_add(it, _doubleArrow);
                                      }
                                    };
                                  MaintenanceTeamManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
                                    public IFunctionIdentifier apply() {
                                      return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.project.MaintenanceTeamManagementPresenter.removeFromTeam" );
                                    }
                                  }.apply(), _function);
                                }
                              };
                            ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr_1, _function_1);
                    }
                  };
                PlainHTMLTable _doubleArrow_1 = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE, _function_1);
                HorizontalLayoutData _HLayoutData_1 = MaintenanceTeamManagementView.this.widgets.HLayoutData(50, 1);
                it.add(_doubleArrow_1, _HLayoutData_1);
                FieldSet _FieldSet_1 = MaintenanceTeamManagementView.this.widgets.FieldSet("\u7EF4\u4FEE\u73ED\u7EC4");
                final Procedure1<FieldSet> _function_2 = new Procedure1<FieldSet>() {
                    public void apply(final FieldSet it) {
                      ContentPanel _ContentPanel = MaintenanceTeamManagementView.this.widgets.ContentPanel();
                      final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
                          public void apply(final ContentPanel it) {
                            SGroupingGrid<UIMaintenanceTeam> _asWidget = MaintenanceTeamManagementView.this.maintenanceTeamListGrid.asWidget();
                            final Procedure1<SGroupingGrid<UIMaintenanceTeam>> _function = new Procedure1<SGroupingGrid<UIMaintenanceTeam>>() {
                                public void apply(final SGroupingGrid<UIMaintenanceTeam> it) {
                                  it.setHideHeaders(true);
                                }
                              };
                            SGroupingGrid<UIMaintenanceTeam> _doubleArrow = ObjectExtensions.<SGroupingGrid<UIMaintenanceTeam>>operator_doubleArrow(_asWidget, _function);
                            it.setWidget(_doubleArrow);
                          }
                        };
                      ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
                      it.setWidget(_doubleArrow);
                    }
                  };
                FieldSet _doubleArrow_2 = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet_1, _function_2);
                HorizontalLayoutData _HLayoutData_2 = MaintenanceTeamManagementView.this.widgets.HLayoutData(350, 1, 1);
                it.add(_doubleArrow_2, _HLayoutData_2);
              }
            };
          HorizontalLayoutContainer _doubleArrow = ObjectExtensions.<HorizontalLayoutContainer>operator_doubleArrow(_HLayout, _function);
          it.setWidget(_doubleArrow);
        }
      };
    FramedPanel _doubleArrow = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function);
    this.con = _doubleArrow;
  }
  
  public void showTeams(final Collection<UIMaintenanceTeam> teams) {
    
    this.maintenanceTeamListGrid.setObjects(teams);
  }
  
  public void setOrganizationOutlinePresenter(final OrganizationOutlinePresenter organizationOutlinePresenter) {
    
    this.organizationOutlinePresenter = organizationOutlinePresenter;
  }
  
  private RequestHandler1<RCOrganizationProxy> selectAsTeamRequestHandler;
  
  public void selectAsTeam(final RequestHandler1<RCOrganizationProxy> requestHandler) {
    this.selectAsTeamRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCMaintenanceTeamProxy> removeFromTeamRequestHandler;
  
  public void removeFromTeam(final RequestHandler1<RCMaintenanceTeamProxy> requestHandler) {
    this.removeFromTeamRequestHandler = requestHandler;
  }
}
