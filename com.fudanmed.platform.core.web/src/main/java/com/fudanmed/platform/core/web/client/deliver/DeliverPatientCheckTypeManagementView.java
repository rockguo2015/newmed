package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateDeliverPatientCheckCategoryCommand;
import com.fudanmed.platform.core.web.client.deliver.CreateDeliverPatientCheckTypeCommand;
import com.fudanmed.platform.core.web.client.deliver.DeleteDeliverPatientCheckCategoryCommand;
import com.fudanmed.platform.core.web.client.deliver.DeleteDeliverPatientCheckTypeCommand;
import com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckCategoryListPresenter;
import com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckCategoryListPresenterView;
import com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckTypeManagementPresenterView;
import com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckTypeQueryListPresenter;
import com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckTypeQueryListPresenterView;
import com.fudanmed.platform.core.web.client.deliver.UpdateDeliverPatientCheckCategoryCommand;
import com.fudanmed.platform.core.web.client.deliver.UpdateDeliverPatientCheckTypeCommand;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckCategory;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckType;
import com.google.common.base.Function;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.form.FieldSet;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.extensions.ObjectSelectionProviders;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.widget.ContentPanel;
import edu.fudan.langlab.gxt.client.widget.FramedPanel;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DeliverPatientCheckTypeManagementView extends GWTAbstractView implements DeliverPatientCheckTypeManagementPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(createDeliverPatientCheckCategoryCommand,updateDeliverPatientCheckCategoryCommand,deleteDeliverPatientCheckCategoryCommand,createDeliverPatientCheckTypeCommand,updateDeliverPatientCheckTypeCommand,deleteDeliverPatientCheckTypeCommand),
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
  
  private DeliverPatientCheckCategoryListPresenter categoryQueryListPresenter;
  
  public void setCategoryQueryListPresenter(final DeliverPatientCheckCategoryListPresenter categoryQueryListPresenter) {
    this.categoryQueryListPresenter = categoryQueryListPresenter;
  }
  
  private DeliverPatientCheckTypeQueryListPresenter deliverPatientCheckTypeQueryListPresenter;
  
  public void setDeliverPatientCheckTypeQueryListPresenter(final DeliverPatientCheckTypeQueryListPresenter deliverPatientCheckTypeQueryListPresenter) {
    this.deliverPatientCheckTypeQueryListPresenter = deliverPatientCheckTypeQueryListPresenter;
  }
  
  @Inject
  private CreateDeliverPatientCheckCategoryCommand createDeliverPatientCheckCategoryCommand;
  
  @Inject
  private UpdateDeliverPatientCheckCategoryCommand updateDeliverPatientCheckCategoryCommand;
  
  @Inject
  private DeleteDeliverPatientCheckCategoryCommand deleteDeliverPatientCheckCategoryCommand;
  
  @Inject
  private CreateDeliverPatientCheckTypeCommand createDeliverPatientCheckTypeCommand;
  
  @Inject
  private UpdateDeliverPatientCheckTypeCommand updateDeliverPatientCheckTypeCommand;
  
  @Inject
  private DeleteDeliverPatientCheckTypeCommand deleteDeliverPatientCheckTypeCommand;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    DeliverPatientCheckCategoryListPresenterView _view = this.categoryQueryListPresenter.getView();
    ActionContext<UIDeliverPatientCheckCategory> _actionContext = _view.getActionContext();
    final Function1<UIDeliverPatientCheckCategory,DLDeliverPatientCheckCategoryProxy> _function = new Function1<UIDeliverPatientCheckCategory,DLDeliverPatientCheckCategoryProxy>() {
        public DLDeliverPatientCheckCategoryProxy apply(final UIDeliverPatientCheckCategory it) {
          DLDeliverPatientCheckCategoryProxy _proxy = it.toProxy();
          return _proxy;
        }
      };
    final ActionContext<DLDeliverPatientCheckCategoryProxy> categoryAC = _actionContext.<DLDeliverPatientCheckCategoryProxy>adapt(new Function<UIDeliverPatientCheckCategory,DLDeliverPatientCheckCategoryProxy>() {
        public DLDeliverPatientCheckCategoryProxy apply(UIDeliverPatientCheckCategory input) {
          return _function.apply(input);
        }
    });
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u68C0\u67E5\u9879\u76EE\u7EF4\u62A4");
    final Procedure1<FramedPanel> _function_1 = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          HorizontalLayoutContainer _HLayout = DeliverPatientCheckTypeManagementView.this.widgets.HLayout();
          final Procedure1<HorizontalLayoutContainer> _function = new Procedure1<HorizontalLayoutContainer>() {
              public void apply(final HorizontalLayoutContainer it) {
                FieldSet _FieldSet = DeliverPatientCheckTypeManagementView.this.widgets.FieldSet("\u68C0\u67E5\u9879\u76EE\u5927\u7C7B");
                final Procedure1<FieldSet> _function = new Procedure1<FieldSet>() {
                    public void apply(final FieldSet it) {
                      ContentPanel _ContentPanel = DeliverPatientCheckTypeManagementView.this.widgets.ContentPanel();
                      final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
                          public void apply(final ContentPanel it) {
                            DeliverPatientCheckCategoryListPresenterView _view = DeliverPatientCheckTypeManagementView.this.categoryQueryListPresenter.getView();
                            Widget _asWidget = _view.asWidget();
                            it.setWidget(_asWidget);
                            final Function0<DLDeliverPatientCheckCategoryProxy> _function = new Function0<DLDeliverPatientCheckCategoryProxy>() {
                                public DLDeliverPatientCheckCategoryProxy apply() {
                                  DLDeliverPatientCheckCategoryProxy _onlySelected = ObjectSelectionProviders.<DLDeliverPatientCheckCategoryProxy>getOnlySelected(categoryAC);
                                  return _onlySelected;
                                }
                              };
                            it.<DLDeliverPatientCheckCategoryProxy>addCommand(_function, DeliverPatientCheckTypeManagementView.this.createDeliverPatientCheckCategoryCommand);
                            it.addCommand(categoryAC, DeliverPatientCheckTypeManagementView.this.updateDeliverPatientCheckCategoryCommand);
                            it.addCommand(categoryAC, DeliverPatientCheckTypeManagementView.this.deleteDeliverPatientCheckCategoryCommand);
                          }
                        };
                      ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
                      it.setWidget(_doubleArrow);
                    }
                  };
                FieldSet _doubleArrow = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet, _function);
                HorizontalLayoutData _HLayoutData = DeliverPatientCheckTypeManagementView.this.widgets.HLayoutData(0.3, 1);
                it.add(_doubleArrow, _HLayoutData);
                FieldSet _FieldSet_1 = DeliverPatientCheckTypeManagementView.this.widgets.FieldSet("\u68C0\u67E5\u9879\u76EE");
                final Procedure1<FieldSet> _function_1 = new Procedure1<FieldSet>() {
                    public void apply(final FieldSet it) {
                      ContentPanel _ContentPanel = DeliverPatientCheckTypeManagementView.this.widgets.ContentPanel();
                      final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
                          public void apply(final ContentPanel it) {
                            DeliverPatientCheckTypeQueryListPresenterView _view = DeliverPatientCheckTypeManagementView.this.deliverPatientCheckTypeQueryListPresenter.getView();
                            ActionContext<UIDeliverPatientCheckType> _actionContext = _view.getActionContext();
                            final Function1<UIDeliverPatientCheckType,DLDeliverPatientCheckTypeProxy> _function = new Function1<UIDeliverPatientCheckType,DLDeliverPatientCheckTypeProxy>() {
                                public DLDeliverPatientCheckTypeProxy apply(final UIDeliverPatientCheckType it) {
                                  DLDeliverPatientCheckTypeProxy _proxy = it.toProxy();
                                  return _proxy;
                                }
                              };
                            final ActionContext<DLDeliverPatientCheckTypeProxy> typeAC = _actionContext.<DLDeliverPatientCheckTypeProxy>adapt(new Function<UIDeliverPatientCheckType,DLDeliverPatientCheckTypeProxy>() {
                                public DLDeliverPatientCheckTypeProxy apply(UIDeliverPatientCheckType input) {
                                  return _function.apply(input);
                                }
                            });
                            DeliverPatientCheckTypeQueryListPresenterView _view_1 = DeliverPatientCheckTypeManagementView.this.deliverPatientCheckTypeQueryListPresenter.getView();
                            Widget _asWidget = _view_1.asWidget();
                            it.setWidget(_asWidget);
                            it.addCommand(categoryAC, DeliverPatientCheckTypeManagementView.this.createDeliverPatientCheckTypeCommand);
                            it.addCommand(typeAC, DeliverPatientCheckTypeManagementView.this.updateDeliverPatientCheckTypeCommand);
                            it.addCommand(typeAC, DeliverPatientCheckTypeManagementView.this.deleteDeliverPatientCheckTypeCommand);
                          }
                        };
                      ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
                      it.setWidget(_doubleArrow);
                    }
                  };
                FieldSet _doubleArrow_1 = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet_1, _function_1);
                HorizontalLayoutData _HLayoutData_1 = DeliverPatientCheckTypeManagementView.this.widgets.HLayoutData(0.7, 1);
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
}
