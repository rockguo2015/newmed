package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateProductSpecificationPresenter;
import com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationManagementPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationManagementPresenterView;
import com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationUploaderPresenter;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecificationCriteria;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.gxt.client.dialog.DialogPresenterExtensions;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ProductSpecificationManagementPresenter extends WorkbenchAbstractPresenter<ProductSpecificationManagementPresenterView> {
  @Inject
  protected ProductSpecificationManagementPresenterServiceAsync _service;
  
  @Inject
  public ProductSpecificationManagementPresenter(final ProductSpecificationManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private Provider<CreateOrUpdateProductSpecificationPresenter> createOrUpdatePresenter;
  
  @Inject
  private Provider<ProductSpecificationUploaderPresenter> ProductSpecificationUploaderPresenter;
  
  public void setup(final Procedure1<? super ProductSpecificationManagementPresenter> postInit) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {getView().refresh();
          
          postInit.apply(ProductSpecificationManagementPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void view_createRequestExecution() {
    
    CreateOrUpdateProductSpecificationPresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateProductSpecificationPresenter> _function = new Procedure1<CreateOrUpdateProductSpecificationPresenter>() {
        public void apply(final CreateOrUpdateProductSpecificationPresenter it) {
          final Procedure1<CreateOrUpdateProductSpecificationPresenter> _function = new Procedure1<CreateOrUpdateProductSpecificationPresenter>() {
              public void apply(final CreateOrUpdateProductSpecificationPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Create(_function);
        }
      };
    ObjectExtensions.<CreateOrUpdateProductSpecificationPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_modifyRequestExecution(final RCProductSpecificationProxy value) {
    
    CreateOrUpdateProductSpecificationPresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateProductSpecificationPresenter> _function = new Procedure1<CreateOrUpdateProductSpecificationPresenter>() {
        public void apply(final CreateOrUpdateProductSpecificationPresenter it) {
          final Procedure1<CreateOrUpdateProductSpecificationPresenter> _function = new Procedure1<CreateOrUpdateProductSpecificationPresenter>() {
              public void apply(final CreateOrUpdateProductSpecificationPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Update(value, _function);
        }
      };
    ObjectExtensions.<CreateOrUpdateProductSpecificationPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_deleteRequestExecution(final RCProductSpecificationProxy value) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationsChangedEvent());
          
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.delete(value, _onSuccess);
  }
  
  public void view_filterRequestExecution(final UIProductSpecificationCriteria c) {
    
    final Procedure1<IPagedResult<UIProductSpecification>> _function = new Procedure1<IPagedResult<UIProductSpecification>>() {
        public void apply(final IPagedResult<UIProductSpecification> it) {
          getView().showResults(it);
          
        }
      };
    AsyncCallback<IPagedResult<UIProductSpecification>> _onSuccess = this.<IPagedResult<UIProductSpecification>>onSuccess(_function);
    _service.filter(c, _onSuccess);
  }
  
  public void _eventbus_ProductSpecificationsChanged() {
    getView().refresh();
    
  }
  
  public void view_importRequestExecution() {
    
    ProductSpecificationUploaderPresenter _get = this.ProductSpecificationUploaderPresenter.get();
    DialogPresenterExtensions.asDialog(_get, "\u6750\u6599\u54C1\u79CD\u5BFC\u5165");
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().createRequest(new RequestHandler(){
    			
    			public void execute(){
    				view_createRequestExecution();
    			}
    			
    		});
    getView().modifyRequest(new RequestHandler1<RCProductSpecificationProxy>(){
    			
    			public void execute(RCProductSpecificationProxy value){
    				view_modifyRequestExecution(value);
    			}
    			
    		});
    getView().deleteRequest(new RequestHandler1<RCProductSpecificationProxy>(){
    			
    			public void execute(RCProductSpecificationProxy value){
    				view_deleteRequestExecution(value);
    			}
    			
    		});
    getView().filterRequest(new RequestHandler1<UIProductSpecificationCriteria>(){
    			
    			public void execute(UIProductSpecificationCriteria c){
    				view_filterRequestExecution(c);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationsChangedEvent.__type__, new com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationsChangedHandler(){
    public void ProductSpecificationsChanged(){
    	_eventbus_ProductSpecificationsChanged();
    }
    }));
    getView().importRequest(new RequestHandler(){
    			
    			public void execute(){
    				view_importRequestExecution();
    			}
    			
    		});
    
  }
}
