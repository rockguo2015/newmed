package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingListProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateStockTakingListPresenter;
import com.fudanmed.platform.core.web.client.warehouse.StockTakingInputQuantityPresenter;
import com.fudanmed.platform.core.web.client.warehouse.StockTakingListListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.warehouse.StockTakingListListPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingItem;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingList;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingListCriteria;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.sencha.gxt.widget.core.client.info.Info;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.print.Print;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.csv.client.CSVClientExtensions;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class StockTakingListListPresenter extends WorkbenchAbstractPresenter<StockTakingListListPresenterView> {
  @Inject
  protected StockTakingListListPresenterServiceAsync _service;
  
  @Inject
  public StockTakingListListPresenter(final StockTakingListListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private Provider<CreateOrUpdateStockTakingListPresenter> createOrUpdatePresenter;
  
  @Inject
  private Provider<StockTakingInputQuantityPresenter> stockTakingInputQuantityPresenter;
  
  public void setup(final Procedure1<? super StockTakingListListPresenter> postInit) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<RCEmployeeProxy> _function = new Procedure1<RCEmployeeProxy>() {
              public void apply(final RCEmployeeProxy it) {
                StockTakingListListPresenterView _view = StockTakingListListPresenter.this.getView();
                final Procedure1<Void> _function = new Procedure1<Void>() {
                    public void apply(final Void it) {getView().refresh();
                      
                      postInit.apply(StockTakingListListPresenter.this);
                    }
                  };
                _view.setSourceWarehouseContext(it, _function);
              }
            };
          AsyncCallback<RCEmployeeProxy> _onSuccess = StockTakingListListPresenter.this.<RCEmployeeProxy>onSuccess(_function);
          _service.loadCurrentUser(_onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void view_filterRequestExecution(final UIStockTakingListCriteria c) {
    
    final Procedure1<IPagedResult<UIStockTakingList>> _function = new Procedure1<IPagedResult<UIStockTakingList>>() {
        public void apply(final IPagedResult<UIStockTakingList> it) {
          getView().showResults(it);
          
        }
      };
    AsyncCallback<IPagedResult<UIStockTakingList>> _onSuccess = this.<IPagedResult<UIStockTakingList>>onSuccess(_function);
    _service.filter(c, _onSuccess);
  }
  
  public void view_showDetailRequestExecution(final RCStockTakingListProxy value) {
    
    final Procedure1<Collection<UIStockTakingItem>> _function = new Procedure1<Collection<UIStockTakingItem>>() {
        public void apply(final Collection<UIStockTakingItem> it) {
          getView().showDetails(it);
          
        }
      };
    AsyncCallback<Collection<UIStockTakingItem>> _onSuccess = this.<Collection<UIStockTakingItem>>onSuccess(_function);
    _service.loadDetails(value, _onSuccess);
  }
  
  public void view_createStockTakingListRequestExecution() {
    
    CreateOrUpdateStockTakingListPresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateStockTakingListPresenter> _function = new Procedure1<CreateOrUpdateStockTakingListPresenter>() {
        public void apply(final CreateOrUpdateStockTakingListPresenter it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
          
        }
      };
    _get.setup4Create(_function);
  }
  
  public void view_inputQuantityExecution(final RCStockTakingListProxy value) {
    
    StockTakingInputQuantityPresenter _get = this.stockTakingInputQuantityPresenter.get();
    final Procedure1<StockTakingInputQuantityPresenter> _function = new Procedure1<StockTakingInputQuantityPresenter>() {
        public void apply(final StockTakingInputQuantityPresenter it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
          
        }
      };
    _get.setup(value, _function);
  }
  
  public void view_cancelStockTakingListRequestExecution(final RCStockTakingListProxy value) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.warehouse.StockTakingListsChangedEvent());
          
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.cancel(value, _onSuccess);
  }
  
  public void view_commitExecution(final RCStockTakingListProxy value) {
    
    final Procedure1<Boolean> _function = new Procedure1<Boolean>() {
        public void apply(final Boolean allDataCollected) {
          if ((allDataCollected).booleanValue()) {
            final Procedure1<Void> _function = new Procedure1<Void>() {
                public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.warehouse.StockTakingListsChangedEvent());
                  
                }
              };
            AsyncCallback<Void> _onSuccess = StockTakingListListPresenter.this.<Void>onSuccess(_function);
            _service.commit(value, _onSuccess);
          } else {
            Info.display("\u9519\u8BEF", "\u6709\u672A\u76D8\u70B9\u7684\u5E93\u5B58");
          }
        }
      };
    AsyncCallback<Boolean> _onSuccess = this.<Boolean>onSuccess(_function);
    _service.isAllDataCollected(value, _onSuccess);
  }
  
  public void _eventbus_StockTakingListsChanged() {
    getView().refresh();
    
  }
  
  public void view_printListlRequestExecution(final RCStockTakingListProxy value) {
    
    final Procedure1<String> _function = new Procedure1<String>() {
        public void apply(final String html) {
          Print.it(html);
        }
      };
    AsyncCallback<String> _onSuccess = this.<String>onSuccess(_function);
    _service.generatePrintContents(value, _onSuccess);
  }
  
  public void view_exportExecution(final RCStockTakingListProxy value) {
    
    final Procedure1<String> _function = new Procedure1<String>() {
        public void apply(final String it) {
          CSVClientExtensions.doDownload(it);
        }
      };
    AsyncCallback<String> _onSuccess = this.<String>onSuccess(_function);
    _service.prepareExport(value, _onSuccess);
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().filterRequest(new RequestHandler1<UIStockTakingListCriteria>(){
    			
    			public void execute(UIStockTakingListCriteria c){
    				view_filterRequestExecution(c);
    			}
    			
    		});
    getView().showDetailRequest(new RequestHandler1<RCStockTakingListProxy>(){
    			
    			public void execute(RCStockTakingListProxy value){
    				view_showDetailRequestExecution(value);
    			}
    			
    		});
    getView().createStockTakingListRequest(new RequestHandler(){
    			
    			public void execute(){
    				view_createStockTakingListRequestExecution();
    			}
    			
    		});
    getView().inputQuantity(new RequestHandler1<RCStockTakingListProxy>(){
    			
    			public void execute(RCStockTakingListProxy value){
    				view_inputQuantityExecution(value);
    			}
    			
    		});
    getView().cancelStockTakingListRequest(new RequestHandler1<RCStockTakingListProxy>(){
    			
    			public void execute(RCStockTakingListProxy value){
    				view_cancelStockTakingListRequestExecution(value);
    			}
    			
    		});
    getView().commit(new RequestHandler1<RCStockTakingListProxy>(){
    			
    			public void execute(RCStockTakingListProxy value){
    				view_commitExecution(value);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.warehouse.StockTakingListsChangedEvent.__type__, new com.fudanmed.platform.core.web.client.warehouse.StockTakingListsChangedHandler(){
    public void StockTakingListsChanged(){
    	_eventbus_StockTakingListsChanged();
    }
    }));
    getView().printListlRequest(new RequestHandler1<RCStockTakingListProxy>(){
    			
    			public void execute(RCStockTakingListProxy value){
    				view_printListlRequestExecution(value);
    			}
    			
    		});
    getView().export(new RequestHandler1<RCStockTakingListProxy>(){
    			
    			public void execute(RCStockTakingListProxy value){
    				view_exportExecution(value);
    			}
    			
    		});
    
  }
}
