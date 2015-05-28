package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductWarehouseStorageSummaryProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateInStockRecordPresenter;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateTransferRecordPresenter;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateWorkItemOutStockRecordPresenter;
import com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationDetailPresenter;
import com.fudanmed.platform.core.web.client.warehouse.ProductStoreTransactionListPresenter;
import com.fudanmed.platform.core.web.client.warehouse.ProductWarehouseStorageListPresenter;
import com.fudanmed.platform.core.web.client.warehouse.ProductWarehouseStorageSummaryManagementPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.warehouse.ProductWarehouseStorageSummaryManagementPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummaryCriteria;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ProductWarehouseStorageSummaryManagementPresenter extends WorkbenchAbstractPresenter<ProductWarehouseStorageSummaryManagementPresenterView> {
  @Inject
  protected ProductWarehouseStorageSummaryManagementPresenterServiceAsync _service;
  
  @Inject
  public ProductWarehouseStorageSummaryManagementPresenter(final ProductWarehouseStorageSummaryManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private Provider<CreateOrUpdateInStockRecordPresenter> createOrUpdateInStockRecordPresenter;
  
  @Inject
  private Provider<CreateOrUpdateTransferRecordPresenter> createOrUpdateTransferRecordPresenter;
  
  @Inject
  private Provider<CreateOrUpdateWorkItemOutStockRecordPresenter> createOrUpdateWorkItemOutStockRecordPresenter;
  
  public ProductStoreTransactionListPresenter initPart(final ProductStoreTransactionListPresenter part) {
    this.registerPart(part);
    this.getView().setProductStoreTransactionListPresenter(part);
    return part;
    
  }
  
  @Inject
  private ProductStoreTransactionListPresenter productStoreTransactionListPresenter;
  
  public ProductWarehouseStorageListPresenter initPart(final ProductWarehouseStorageListPresenter part) {
    this.registerPart(part);
    this.getView().setProductWarehouseStorageListPresenter(part);
    return part;
    
  }
  
  @Inject
  private ProductWarehouseStorageListPresenter productWarehouseStorageListPresenter;
  
  public ProductSpecificationDetailPresenter initPart(final ProductSpecificationDetailPresenter part) {
    this.registerPart(part);
    this.getView().setProductSpecificationDetailPresenter(part);
    return part;
    
  }
  
  @Inject
  private ProductSpecificationDetailPresenter productSpecificationDetailPresenter;
  
  public void setup(final Procedure1<? super ProductWarehouseStorageSummaryManagementPresenter> postInit) {
    
    ProductStoreTransactionListPresenter _initPart = this.initPart(this.productStoreTransactionListPresenter);
    final Procedure1<ProductStoreTransactionListPresenter> _function = new Procedure1<ProductStoreTransactionListPresenter>() {
        public void apply(final ProductStoreTransactionListPresenter it) {
          ProductWarehouseStorageListPresenter _initPart = ProductWarehouseStorageSummaryManagementPresenter.this.initPart(ProductWarehouseStorageSummaryManagementPresenter.this.productWarehouseStorageListPresenter);
          final Procedure1<ProductWarehouseStorageListPresenter> _function = new Procedure1<ProductWarehouseStorageListPresenter>() {
              public void apply(final ProductWarehouseStorageListPresenter it) {
                ProductSpecificationDetailPresenter _initPart = ProductWarehouseStorageSummaryManagementPresenter.this.initPart(ProductWarehouseStorageSummaryManagementPresenter.this.productSpecificationDetailPresenter);
                final Procedure1<ProductSpecificationDetailPresenter> _function = new Procedure1<ProductSpecificationDetailPresenter>() {
                    public void apply(final ProductSpecificationDetailPresenter it) {
                      final Procedure1<Void> _function = new Procedure1<Void>() {
                          public void apply(final Void it) {
                            final Procedure1<RCEmployeeProxy> _function = new Procedure1<RCEmployeeProxy>() {
                                public void apply(final RCEmployeeProxy it) {
                                  ProductWarehouseStorageSummaryManagementPresenterView _view = ProductWarehouseStorageSummaryManagementPresenter.this.getView();
                                  final Procedure1<Void> _function = new Procedure1<Void>() {
                                      public void apply(final Void it) {getView().refresh();
                                        
                                        postInit.apply(ProductWarehouseStorageSummaryManagementPresenter.this);
                                      }
                                    };
                                  _view.setSourceWarehouseContext(it, _function);
                                }
                              };
                            AsyncCallback<RCEmployeeProxy> _onSuccess = ProductWarehouseStorageSummaryManagementPresenter.this.<RCEmployeeProxy>onSuccess(_function);
                            _service.loadCurrentUser(_onSuccess);
                          }
                        };
                      ProductWarehouseStorageSummaryManagementPresenter.this.activate(new IPostInitializeAction() {
                          public void initializeFinished(Void v) {
                            _function.apply(v);
                          }
                      });
                    }
                  };
                _initPart.setup(_function);
              }
            };
          _initPart.setup(_function);
        }
      };
    _initPart.setup(_function);
  }
  
  public void view_filterRequestExecution(final UIProductWarehouseStorageSummaryCriteria c) {
    
    final Procedure1<IPagedResult<UIProductWarehouseStorageSummary>> _function = new Procedure1<IPagedResult<UIProductWarehouseStorageSummary>>() {
        public void apply(final IPagedResult<UIProductWarehouseStorageSummary> it) {
          ProductWarehouseStorageSummaryManagementPresenter.this.productStoreTransactionListPresenter.reset();
          getView().showResults(it);
          
        }
      };
    AsyncCallback<IPagedResult<UIProductWarehouseStorageSummary>> _onSuccess = this.<IPagedResult<UIProductWarehouseStorageSummary>>onSuccess(_function);
    _service.filter(c, _onSuccess);
  }
  
  public void _eventbus_ProductWarehouseStorageSummarysChanged() {
    getView().refresh();
    
  }
  
  public void view_inStockRequestExecution() {
    
    CreateOrUpdateInStockRecordPresenter _get = this.createOrUpdateInStockRecordPresenter.get();
    final Procedure1<CreateOrUpdateInStockRecordPresenter> _function = new Procedure1<CreateOrUpdateInStockRecordPresenter>() {
        public void apply(final CreateOrUpdateInStockRecordPresenter it) {
          final Procedure1<CreateOrUpdateInStockRecordPresenter> _function = new Procedure1<CreateOrUpdateInStockRecordPresenter>() {
              public void apply(final CreateOrUpdateInStockRecordPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Create(_function);
        }
      };
    ObjectExtensions.<CreateOrUpdateInStockRecordPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_transferRequestExecution() {
    
    CreateOrUpdateTransferRecordPresenter _get = this.createOrUpdateTransferRecordPresenter.get();
    final Procedure1<CreateOrUpdateTransferRecordPresenter> _function = new Procedure1<CreateOrUpdateTransferRecordPresenter>() {
        public void apply(final CreateOrUpdateTransferRecordPresenter it) {
          final Procedure1<CreateOrUpdateTransferRecordPresenter> _function = new Procedure1<CreateOrUpdateTransferRecordPresenter>() {
              public void apply(final CreateOrUpdateTransferRecordPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Create(_function);
        }
      };
    ObjectExtensions.<CreateOrUpdateTransferRecordPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_showStorageDetailRequestExecution(final RCProductWarehouseStorageSummaryProxy value) {
    
    this.productStoreTransactionListPresenter.setProductStorage4Summary(value);
    this.productWarehouseStorageListPresenter.setProductWarehouseStorageSummary(value);
    final Procedure1<RCProductSpecificationProxy> _function = new Procedure1<RCProductSpecificationProxy>() {
        public void apply(final RCProductSpecificationProxy it) {
          ProductWarehouseStorageSummaryManagementPresenter.this.productSpecificationDetailPresenter.setDetailInfo(it);
        }
      };
    AsyncCallback<RCProductSpecificationProxy> _onSuccess = this.<RCProductSpecificationProxy>onSuccess(_function);
    _service.getProductSpec(value, _onSuccess);
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().filterRequest(new RequestHandler1<UIProductWarehouseStorageSummaryCriteria>(){
    			
    			public void execute(UIProductWarehouseStorageSummaryCriteria c){
    				view_filterRequestExecution(c);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.warehouse.ProductWarehouseStorageSummarysChangedEvent.__type__, new com.fudanmed.platform.core.web.client.warehouse.ProductWarehouseStorageSummarysChangedHandler(){
    public void ProductWarehouseStorageSummarysChanged(){
    	_eventbus_ProductWarehouseStorageSummarysChanged();
    }
    }));
    getView().inStockRequest(new RequestHandler(){
    			
    			public void execute(){
    				view_inStockRequestExecution();
    			}
    			
    		});
    getView().transferRequest(new RequestHandler(){
    			
    			public void execute(){
    				view_transferRequestExecution();
    			}
    			
    		});
    getView().showStorageDetailRequest(new RequestHandler1<RCProductWarehouseStorageSummaryProxy>(){
    			
    			public void execute(RCProductWarehouseStorageSummaryProxy value){
    				view_showStorageDetailRequestExecution(value);
    			}
    			
    		});
    
  }
}
