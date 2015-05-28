package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCInStockRecordProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateInStockRecordPresenter;
import com.fudanmed.platform.core.web.client.warehouse.InStockRecordListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.warehouse.InStockRecordListPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecordCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecordItem;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.print.Print;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class InStockRecordListPresenter extends WorkbenchAbstractPresenter<InStockRecordListPresenterView> {
  @Inject
  protected InStockRecordListPresenterServiceAsync _service;
  
  @Inject
  public InStockRecordListPresenter(final InStockRecordListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private Provider<CreateOrUpdateInStockRecordPresenter> createOrUpdatePresenter;
  
  public void setup(final Procedure1<? super InStockRecordListPresenter> postInit) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {getView().refresh();
          
          postInit.apply(InStockRecordListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void view_filterRequestExecution(final UIInStockRecordCriteria c) {
    
    final Procedure1<IPagedResult<UIInStockRecord>> _function = new Procedure1<IPagedResult<UIInStockRecord>>() {
        public void apply(final IPagedResult<UIInStockRecord> it) {
          getView().showResults(it);
          
        }
      };
    AsyncCallback<IPagedResult<UIInStockRecord>> _onSuccess = this.<IPagedResult<UIInStockRecord>>onSuccess(_function);
    _service.filter(c, _onSuccess);
  }
  
  public void view_showDetailRequestExecution(final RCInStockRecordProxy value) {
    
    final Procedure1<Collection<UIInStockRecordItem>> _function = new Procedure1<Collection<UIInStockRecordItem>>() {
        public void apply(final Collection<UIInStockRecordItem> details) {
          final Procedure1<UIInStockRecord> _function = new Procedure1<UIInStockRecord>() {
              public void apply(final UIInStockRecord detail) {
                
                getView().showDetails(detail,details);
                
              }
            };
          AsyncCallback<UIInStockRecord> _onSuccess = InStockRecordListPresenter.this.<UIInStockRecord>onSuccess(_function);
          _service.loadInStockRecordInfo(value, _onSuccess);
        }
      };
    AsyncCallback<Collection<UIInStockRecordItem>> _onSuccess = this.<Collection<UIInStockRecordItem>>onSuccess(_function);
    _service.loadDetails(value, _onSuccess);
  }
  
  public void _eventbus_InStockRecordsChanged() {
    getView().refresh();
    
  }
  
  public void view_modifyInStockRequestExecution(final RCInStockRecordProxy value) {
    
    CreateOrUpdateInStockRecordPresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateInStockRecordPresenter> _function = new Procedure1<CreateOrUpdateInStockRecordPresenter>() {
        public void apply(final CreateOrUpdateInStockRecordPresenter it) {
          final Procedure1<CreateOrUpdateInStockRecordPresenter> _function = new Procedure1<CreateOrUpdateInStockRecordPresenter>() {
              public void apply(final CreateOrUpdateInStockRecordPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Update(value, _function);
        }
      };
    ObjectExtensions.<CreateOrUpdateInStockRecordPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_inStockRequestExecution() {
    
    CreateOrUpdateInStockRecordPresenter _get = this.createOrUpdatePresenter.get();
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
  
  public void view_printExecution(final RCInStockRecordProxy value) {
    
    final Procedure1<String> _function = new Procedure1<String>() {
        public void apply(final String it) {
          Print.it(it);
        }
      };
    AsyncCallback<String> _onSuccess = this.<String>onSuccess(_function);
    _service.generatePrintContent(value, _onSuccess);
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().filterRequest(new RequestHandler1<UIInStockRecordCriteria>(){
    			
    			public void execute(UIInStockRecordCriteria c){
    				view_filterRequestExecution(c);
    			}
    			
    		});
    getView().showDetailRequest(new RequestHandler1<RCInStockRecordProxy>(){
    			
    			public void execute(RCInStockRecordProxy value){
    				view_showDetailRequestExecution(value);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.warehouse.InStockRecordsChangedEvent.__type__, new com.fudanmed.platform.core.web.client.warehouse.InStockRecordsChangedHandler(){
    public void InStockRecordsChanged(){
    	_eventbus_InStockRecordsChanged();
    }
    }));
    getView().modifyInStockRequest(new RequestHandler1<RCInStockRecordProxy>(){
    			
    			public void execute(RCInStockRecordProxy value){
    				view_modifyInStockRequestExecution(value);
    			}
    			
    		});
    getView().inStockRequest(new RequestHandler(){
    			
    			public void execute(){
    				view_inStockRequestExecution();
    			}
    			
    		});
    getView().print(new RequestHandler1<RCInStockRecordProxy>(){
    			
    			public void execute(RCInStockRecordProxy value){
    				view_printExecution(value);
    			}
    			
    		});
    
  }
}
