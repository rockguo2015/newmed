package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCTransferRecordProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateTransferRecordPresenter;
import com.fudanmed.platform.core.web.client.warehouse.TransferRecordListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.warehouse.TransferRecordListPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UITransferRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UITransferRecordCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UITransferRecordItem;
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

public class TransferRecordListPresenter extends WorkbenchAbstractPresenter<TransferRecordListPresenterView> {
  @Inject
  protected TransferRecordListPresenterServiceAsync _service;
  
  @Inject
  public TransferRecordListPresenter(final TransferRecordListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private Provider<CreateOrUpdateTransferRecordPresenter> createOrUpdatePresenter;
  
  public void setup(final Procedure1<? super TransferRecordListPresenter> postInit) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {getView().refresh();
          
          postInit.apply(TransferRecordListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void view_filterRequestExecution(final UITransferRecordCriteria c) {
    
    final Procedure1<IPagedResult<UITransferRecord>> _function = new Procedure1<IPagedResult<UITransferRecord>>() {
        public void apply(final IPagedResult<UITransferRecord> it) {
          getView().showResults(it);
          
        }
      };
    AsyncCallback<IPagedResult<UITransferRecord>> _onSuccess = this.<IPagedResult<UITransferRecord>>onSuccess(_function);
    _service.filter(c, _onSuccess);
  }
  
  public void view_showDetailRequestExecution(final RCTransferRecordProxy value) {
    
    final Procedure1<Collection<UITransferRecordItem>> _function = new Procedure1<Collection<UITransferRecordItem>>() {
        public void apply(final Collection<UITransferRecordItem> it) {
          getView().showDetails(it);
          
        }
      };
    AsyncCallback<Collection<UITransferRecordItem>> _onSuccess = this.<Collection<UITransferRecordItem>>onSuccess(_function);
    _service.loadDetails(value, _onSuccess);
  }
  
  public void _eventbus_TransferRecordsChanged() {
    getView().refresh();
    
  }
  
  public void view_transferRequestExecution() {
    
    CreateOrUpdateTransferRecordPresenter _get = this.createOrUpdatePresenter.get();
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
  
  public void view_printExecution(final RCTransferRecordProxy value) {
    
    final Procedure1<String> _function = new Procedure1<String>() {
        public void apply(final String html) {
          Print.it(html);
        }
      };
    AsyncCallback<String> _onSuccess = this.<String>onSuccess(_function);
    _service.generatePrintContents(value, _onSuccess);
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().filterRequest(new RequestHandler1<UITransferRecordCriteria>(){
    			
    			public void execute(UITransferRecordCriteria c){
    				view_filterRequestExecution(c);
    			}
    			
    		});
    getView().showDetailRequest(new RequestHandler1<RCTransferRecordProxy>(){
    			
    			public void execute(RCTransferRecordProxy value){
    				view_showDetailRequestExecution(value);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.warehouse.TransferRecordsChangedEvent.__type__, new com.fudanmed.platform.core.web.client.warehouse.TransferRecordsChangedHandler(){
    public void TransferRecordsChanged(){
    	_eventbus_TransferRecordsChanged();
    }
    }));
    getView().transferRequest(new RequestHandler(){
    			
    			public void execute(){
    				view_transferRequestExecution();
    			}
    			
    		});
    getView().print(new RequestHandler1<RCTransferRecordProxy>(){
    			
    			public void execute(RCTransferRecordProxy value){
    				view_printExecution(value);
    			}
    			
    		});
    
  }
}
