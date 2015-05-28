package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialTypeProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateDeliverMaterialCategoryCommand;
import com.fudanmed.platform.core.web.client.deliver.CreateDeliverMaterialTypeCommand;
import com.fudanmed.platform.core.web.client.deliver.DeleteDeliverMaterialCategoryCommand;
import com.fudanmed.platform.core.web.client.deliver.DeleteDeliverMaterialTypeCommand;
import com.fudanmed.platform.core.web.client.deliver.DeliverMaterialCategoryListPresenter;
import com.fudanmed.platform.core.web.client.deliver.DeliverMaterialCategoryListPresenterView;
import com.fudanmed.platform.core.web.client.deliver.DeliverMaterialCategoryManagementPresenterView;
import com.fudanmed.platform.core.web.client.deliver.DeliverMaterialTypeQueryListPresenter;
import com.fudanmed.platform.core.web.client.deliver.DeliverMaterialTypeQueryListPresenterView;
import com.fudanmed.platform.core.web.client.deliver.UpdateDeliverMaterialCategoryCommand;
import com.fudanmed.platform.core.web.client.deliver.UpdateDeliverMaterialTypeCommand;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialCategory;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialType;
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

public class DeliverMaterialCategoryManagementView extends GWTAbstractView implements DeliverMaterialCategoryManagementPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(createDeliverMaterialCategoryCommand,updateDeliverMaterialCategoryCommand,deleteDeliverMaterialCategoryCommand,createDeliverMaterialTypeCommand,updateDeliverMaterialTypeCommand,deleteDeliverMaterialTypeCommand),
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
  
  private DeliverMaterialCategoryListPresenter queryListPresenter;
  
  public void setQueryListPresenter(final DeliverMaterialCategoryListPresenter queryListPresenter) {
    this.queryListPresenter = queryListPresenter;
  }
  
  private DeliverMaterialTypeQueryListPresenter deliverMaterialTypeQueryListPresenter;
  
  public void setDeliverMaterialTypeQueryListPresenter(final DeliverMaterialTypeQueryListPresenter deliverMaterialTypeQueryListPresenter) {
    this.deliverMaterialTypeQueryListPresenter = deliverMaterialTypeQueryListPresenter;
  }
  
  @Inject
  private CreateDeliverMaterialCategoryCommand createDeliverMaterialCategoryCommand;
  
  @Inject
  private UpdateDeliverMaterialCategoryCommand updateDeliverMaterialCategoryCommand;
  
  @Inject
  private DeleteDeliverMaterialCategoryCommand deleteDeliverMaterialCategoryCommand;
  
  @Inject
  private CreateDeliverMaterialTypeCommand createDeliverMaterialTypeCommand;
  
  @Inject
  private UpdateDeliverMaterialTypeCommand updateDeliverMaterialTypeCommand;
  
  @Inject
  private DeleteDeliverMaterialTypeCommand deleteDeliverMaterialTypeCommand;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    DeliverMaterialCategoryListPresenterView _view = this.queryListPresenter.getView();
    ActionContext<UIDeliverMaterialCategory> _actionContext = _view.getActionContext();
    final Function1<UIDeliverMaterialCategory,DLDeliverMaterialCategoryProxy> _function = new Function1<UIDeliverMaterialCategory,DLDeliverMaterialCategoryProxy>() {
        public DLDeliverMaterialCategoryProxy apply(final UIDeliverMaterialCategory it) {
          DLDeliverMaterialCategoryProxy _proxy = it.toProxy();
          return _proxy;
        }
      };
    final ActionContext<DLDeliverMaterialCategoryProxy> categoryAC = _actionContext.<DLDeliverMaterialCategoryProxy>adapt(new Function<UIDeliverMaterialCategory,DLDeliverMaterialCategoryProxy>() {
        public DLDeliverMaterialCategoryProxy apply(UIDeliverMaterialCategory input) {
          return _function.apply(input);
        }
    });
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u8FD0\u9001\u6750\u6599\u7EF4\u62A4");
    final Procedure1<FramedPanel> _function_1 = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          HorizontalLayoutContainer _HLayout = DeliverMaterialCategoryManagementView.this.widgets.HLayout();
          final Procedure1<HorizontalLayoutContainer> _function = new Procedure1<HorizontalLayoutContainer>() {
              public void apply(final HorizontalLayoutContainer it) {
                FieldSet _FieldSet = DeliverMaterialCategoryManagementView.this.widgets.FieldSet("\u8FD0\u9001\u6750\u6599\u5927\u7C7B");
                final Procedure1<FieldSet> _function = new Procedure1<FieldSet>() {
                    public void apply(final FieldSet it) {
                      ContentPanel _ContentPanel = DeliverMaterialCategoryManagementView.this.widgets.ContentPanel();
                      final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
                          public void apply(final ContentPanel it) {
                            DeliverMaterialCategoryListPresenterView _view = DeliverMaterialCategoryManagementView.this.queryListPresenter.getView();
                            Widget _asWidget = _view.asWidget();
                            it.setWidget(_asWidget);
                            final Function0<DLDeliverMaterialCategoryProxy> _function = new Function0<DLDeliverMaterialCategoryProxy>() {
                                public DLDeliverMaterialCategoryProxy apply() {
                                  DLDeliverMaterialCategoryProxy _onlySelected = ObjectSelectionProviders.<DLDeliverMaterialCategoryProxy>getOnlySelected(categoryAC);
                                  return _onlySelected;
                                }
                              };
                            it.<DLDeliverMaterialCategoryProxy>addCommand(_function, DeliverMaterialCategoryManagementView.this.createDeliverMaterialCategoryCommand);
                            it.addCommand(categoryAC, DeliverMaterialCategoryManagementView.this.updateDeliverMaterialCategoryCommand);
                            it.addCommand(categoryAC, DeliverMaterialCategoryManagementView.this.deleteDeliverMaterialCategoryCommand);
                          }
                        };
                      ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
                      it.setWidget(_doubleArrow);
                    }
                  };
                FieldSet _doubleArrow = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet, _function);
                HorizontalLayoutData _HLayoutData = DeliverMaterialCategoryManagementView.this.widgets.HLayoutData(0.3, 1);
                it.add(_doubleArrow, _HLayoutData);
                FieldSet _FieldSet_1 = DeliverMaterialCategoryManagementView.this.widgets.FieldSet("\u8FD0\u9001\u6750\u6599\u7C7B\u522B");
                final Procedure1<FieldSet> _function_1 = new Procedure1<FieldSet>() {
                    public void apply(final FieldSet it) {
                      ContentPanel _ContentPanel = DeliverMaterialCategoryManagementView.this.widgets.ContentPanel();
                      final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
                          public void apply(final ContentPanel it) {
                            DeliverMaterialTypeQueryListPresenterView _view = DeliverMaterialCategoryManagementView.this.deliverMaterialTypeQueryListPresenter.getView();
                            ActionContext<UIDeliverMaterialType> _actionContext = _view.getActionContext();
                            final Function1<UIDeliverMaterialType,DLDeliverMaterialTypeProxy> _function = new Function1<UIDeliverMaterialType,DLDeliverMaterialTypeProxy>() {
                                public DLDeliverMaterialTypeProxy apply(final UIDeliverMaterialType it) {
                                  DLDeliverMaterialTypeProxy _proxy = it.toProxy();
                                  return _proxy;
                                }
                              };
                            final ActionContext<DLDeliverMaterialTypeProxy> typeAC = _actionContext.<DLDeliverMaterialTypeProxy>adapt(new Function<UIDeliverMaterialType,DLDeliverMaterialTypeProxy>() {
                                public DLDeliverMaterialTypeProxy apply(UIDeliverMaterialType input) {
                                  return _function.apply(input);
                                }
                            });
                            DeliverMaterialTypeQueryListPresenterView _view_1 = DeliverMaterialCategoryManagementView.this.deliverMaterialTypeQueryListPresenter.getView();
                            Widget _asWidget = _view_1.asWidget();
                            it.setWidget(_asWidget);
                            it.addCommand(categoryAC, DeliverMaterialCategoryManagementView.this.createDeliverMaterialTypeCommand);
                            it.addCommand(typeAC, DeliverMaterialCategoryManagementView.this.updateDeliverMaterialTypeCommand);
                            it.addCommand(typeAC, DeliverMaterialCategoryManagementView.this.deleteDeliverMaterialTypeCommand);
                          }
                        };
                      ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
                      it.setWidget(_doubleArrow);
                    }
                  };
                FieldSet _doubleArrow_1 = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet_1, _function_1);
                HorizontalLayoutData _HLayoutData_1 = DeliverMaterialCategoryManagementView.this.widgets.HLayoutData(0.7, 1);
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
