package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductTypeProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateProductCategoryPresenter;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateProductTypePresenter;
import com.fudanmed.platform.core.web.client.warehouse.ProductCategoryManagementPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.warehouse.ProductCategoryManagementPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductCategory;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductType;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.selector.IHasObjectSelectionProvider;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ProductCategoryManagementPresenter extends WorkbenchAbstractPresenter<ProductCategoryManagementPresenterView> implements IHasObjectSelectionProvider<UIProductType> {
  @Inject
  protected ProductCategoryManagementPresenterServiceAsync _service;
  
  @Inject
  public ProductCategoryManagementPresenter(final ProductCategoryManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private Provider<CreateOrUpdateProductCategoryPresenter> createOrUpdatePresenter;
  
  @Inject
  private Provider<CreateOrUpdateProductTypePresenter> createOrUpdateProductTypePresenter;
  
  private RCProductCategoryProxy parent;
  
  public void setup(final Procedure1<? super ProductCategoryManagementPresenter> postInit) {
    
    getView().setAsReadonly(false);
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<Collection<UIProductCategory>> _function = new Procedure1<Collection<UIProductCategory>>() {
              public void apply(final Collection<UIProductCategory> it) {
                getView().showResults(it);
                
                postInit.apply(ProductCategoryManagementPresenter.this);
              }
            };
          AsyncCallback<Collection<UIProductCategory>> _onSuccess = ProductCategoryManagementPresenter.this.<Collection<UIProductCategory>>onSuccess(_function);
          _service.loadAllProductCategory(_onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup4Readonly(final Procedure1<? super ProductCategoryManagementPresenter> postInit) {
    
    getView().setAsReadonly(true);
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<Collection<UIProductCategory>> _function = new Procedure1<Collection<UIProductCategory>>() {
              public void apply(final Collection<UIProductCategory> it) {
                getView().showResults(it);
                
                postInit.apply(ProductCategoryManagementPresenter.this);
              }
            };
          AsyncCallback<Collection<UIProductCategory>> _onSuccess = ProductCategoryManagementPresenter.this.<Collection<UIProductCategory>>onSuccess(_function);
          _service.loadAllProductCategory(_onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void view_createRequestExecution(final RCProductCategoryProxy parent) {
    
    CreateOrUpdateProductCategoryPresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateProductCategoryPresenter> _function = new Procedure1<CreateOrUpdateProductCategoryPresenter>() {
        public void apply(final CreateOrUpdateProductCategoryPresenter it) {
          final Procedure1<CreateOrUpdateProductCategoryPresenter> _function = new Procedure1<CreateOrUpdateProductCategoryPresenter>() {
              public void apply(final CreateOrUpdateProductCategoryPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Create(parent, new IPresenterInitiazerNotifier<CreateOrUpdateProductCategoryPresenter>() {
              public void done(CreateOrUpdateProductCategoryPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    ObjectExtensions.<CreateOrUpdateProductCategoryPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_modifyRequestExecution(final RCProductCategoryProxy value) {
    
    CreateOrUpdateProductCategoryPresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateProductCategoryPresenter> _function = new Procedure1<CreateOrUpdateProductCategoryPresenter>() {
        public void apply(final CreateOrUpdateProductCategoryPresenter it) {
          final Procedure1<CreateOrUpdateProductCategoryPresenter> _function = new Procedure1<CreateOrUpdateProductCategoryPresenter>() {
              public void apply(final CreateOrUpdateProductCategoryPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Update(value, new IPresenterInitiazerNotifier<CreateOrUpdateProductCategoryPresenter>() {
              public void done(CreateOrUpdateProductCategoryPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    ObjectExtensions.<CreateOrUpdateProductCategoryPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_deleteRequestExecution(final RCProductCategoryProxy value) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          eventBus.fireEvent(new com.fudanmed.platform.core.web.client.warehouse.ProductCategoryDeletedEvent(value));
          
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.delete(value, _onSuccess);
  }
  
  public void _eventbus_ProductCategoryChanged(final RCProductCategoryProxy org) {
    
    final Procedure1<UIProductCategory> _function = new Procedure1<UIProductCategory>() {
        public void apply(final UIProductCategory it) {
          getView().updateProductCategory(it);
          
        }
      };
    AsyncCallback<UIProductCategory> _onSuccess = this.<UIProductCategory>onSuccess(_function);
    _service.getValue(org, _onSuccess);
  }
  
  public void _eventbus_ProductCategoryDeleted(final RCProductCategoryProxy org) {
    
    getView().deleteProductCategory(org);
    
  }
  
  public void _eventbus_ProductCategoryAdded(final RCProductCategoryProxy org) {
    
    final Procedure1<UIProductCategory> _function = new Procedure1<UIProductCategory>() {
        public void apply(final UIProductCategory it) {
          getView().addProductCategory(it);
          
        }
      };
    AsyncCallback<UIProductCategory> _onSuccess = this.<UIProductCategory>onSuccess(_function);
    _service.getValue(org, _onSuccess);
  }
  
  public void view_typeSelectedExecution(final RCProductCategoryProxy value) {
    
    this.parent = value;
    final Procedure1<Collection<UIProductType>> _function = new Procedure1<Collection<UIProductType>>() {
        public void apply(final Collection<UIProductType> it) {
          getView().showItems(it);
          
        }
      };
    AsyncCallback<Collection<UIProductType>> _onSuccess = this.<Collection<UIProductType>>onSuccess(_function);
    _service.loadItems(value, _onSuccess);
  }
  
  public void view_createChildRequestExecution(final RCProductCategoryProxy parent) {
    
    CreateOrUpdateProductTypePresenter _get = this.createOrUpdateProductTypePresenter.get();
    final Procedure1<CreateOrUpdateProductTypePresenter> _function = new Procedure1<CreateOrUpdateProductTypePresenter>() {
        public void apply(final CreateOrUpdateProductTypePresenter it) {
          final Procedure1<CreateOrUpdateProductTypePresenter> _function = new Procedure1<CreateOrUpdateProductTypePresenter>() {
              public void apply(final CreateOrUpdateProductTypePresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Create(parent, _function);
        }
      };
    ObjectExtensions.<CreateOrUpdateProductTypePresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_modifyChildRequestExecution(final RCProductTypeProxy child) {
    
    CreateOrUpdateProductTypePresenter _get = this.createOrUpdateProductTypePresenter.get();
    final Procedure1<CreateOrUpdateProductTypePresenter> _function = new Procedure1<CreateOrUpdateProductTypePresenter>() {
        public void apply(final CreateOrUpdateProductTypePresenter it) {
          final Procedure1<CreateOrUpdateProductTypePresenter> _function = new Procedure1<CreateOrUpdateProductTypePresenter>() {
              public void apply(final CreateOrUpdateProductTypePresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Update(child, _function);
        }
      };
    ObjectExtensions.<CreateOrUpdateProductTypePresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_deleteChildRequestExecution(final RCProductTypeProxy child) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.warehouse.ProductTypesChangedEvent());
          
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.deleteChild(child, _onSuccess);
  }
  
  public void _eventbus_ProductTypesChanged() {
    
    final Procedure1<Collection<UIProductType>> _function = new Procedure1<Collection<UIProductType>>() {
        public void apply(final Collection<UIProductType> it) {
          getView().showItems(it);
          
        }
      };
    AsyncCallback<Collection<UIProductType>> _onSuccess = this.<Collection<UIProductType>>onSuccess(_function);
    _service.loadItems(this.parent, _onSuccess);
  }
  
  public ObjectSelectionProvider<UIProductType> getSelectionProvider() {
    
    ProductCategoryManagementPresenterView _view = this.getView();
    ActionContext<UIProductType> _actionContext = _view.getActionContext();
    return _actionContext;
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().createRequest(new RequestHandler1<RCProductCategoryProxy>(){
    			
    			public void execute(RCProductCategoryProxy parent){
    				view_createRequestExecution(parent);
    			}
    			
    		});
    getView().modifyRequest(new RequestHandler1<RCProductCategoryProxy>(){
    			
    			public void execute(RCProductCategoryProxy value){
    				view_modifyRequestExecution(value);
    			}
    			
    		});
    getView().deleteRequest(new RequestHandler1<RCProductCategoryProxy>(){
    			
    			public void execute(RCProductCategoryProxy value){
    				view_deleteRequestExecution(value);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.warehouse.ProductCategoryChangedEvent.__type__, new com.fudanmed.platform.core.web.client.warehouse.ProductCategoryChangedHandler(){
    public void ProductCategoryChanged(com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy org){
    	_eventbus_ProductCategoryChanged(org);
    }
    }));
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.warehouse.ProductCategoryDeletedEvent.__type__, new com.fudanmed.platform.core.web.client.warehouse.ProductCategoryDeletedHandler(){
    public void ProductCategoryDeleted(com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy org){
    	_eventbus_ProductCategoryDeleted(org);
    }
    }));
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.warehouse.ProductCategoryAddedEvent.__type__, new com.fudanmed.platform.core.web.client.warehouse.ProductCategoryAddedHandler(){
    public void ProductCategoryAdded(com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy org){
    	_eventbus_ProductCategoryAdded(org);
    }
    }));
    getView().typeSelected(new RequestHandler1<RCProductCategoryProxy>(){
    			
    			public void execute(RCProductCategoryProxy value){
    				view_typeSelectedExecution(value);
    			}
    			
    		});
    getView().createChildRequest(new RequestHandler1<RCProductCategoryProxy>(){
    			
    			public void execute(RCProductCategoryProxy parent){
    				view_createChildRequestExecution(parent);
    			}
    			
    		});
    getView().modifyChildRequest(new RequestHandler1<RCProductTypeProxy>(){
    			
    			public void execute(RCProductTypeProxy child){
    				view_modifyChildRequestExecution(child);
    			}
    			
    		});
    getView().deleteChildRequest(new RequestHandler1<RCProductTypeProxy>(){
    			
    			public void execute(RCProductTypeProxy child){
    				view_deleteChildRequestExecution(child);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.warehouse.ProductTypesChangedEvent.__type__, new com.fudanmed.platform.core.web.client.warehouse.ProductTypesChangedHandler(){
    public void ProductTypesChanged(){
    	_eventbus_ProductTypesChanged();
    }
    }));
    
  }
}
