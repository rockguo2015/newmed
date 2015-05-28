package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.client.measure.MeasureValueQueryListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.measure.MeasureValueQueryListPresenterView;
import com.fudanmed.platform.core.web.shared.measure.UIMeasureValue;
import com.fudanmed.platform.core.web.shared.measure.UIMeasureValueCriteria;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class MeasureValueQueryListPresenter extends WorkbenchAbstractPresenter<MeasureValueQueryListPresenterView> {
  @Inject
  protected MeasureValueQueryListPresenterServiceAsync _service;
  
  @Inject
  public MeasureValueQueryListPresenter(final MeasureValueQueryListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final IPresenterInitiazerNotifier<MeasureValueQueryListPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {getView().refresh();
          _notifier.done(MeasureValueQueryListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void view_filterRequestExecution(final UIMeasureValueCriteria c) {
    
    final Procedure1<IPagedResult<UIMeasureValue>> _function = new Procedure1<IPagedResult<UIMeasureValue>>() {
        public void apply(final IPagedResult<UIMeasureValue> it) {
          getView().showResults(it);
          
        }
      };
    AsyncCallback<IPagedResult<UIMeasureValue>> _onSuccess = this.<IPagedResult<UIMeasureValue>>onSuccess(_function);
    _service.filter(c, _onSuccess);
  }
  
  public void _eventbus_MeasureValuesChanged() {
    getView().refresh();
    
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().filterRequest(new RequestHandler1<UIMeasureValueCriteria>(){
    			
    			public void execute(UIMeasureValueCriteria c){
    				view_filterRequestExecution(c);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.measure.MeasureValuesChangedEvent.__type__, new com.fudanmed.platform.core.web.client.measure.MeasureValuesChangedHandler(){
    public void MeasureValuesChanged(){
    	_eventbus_MeasureValuesChanged();
    }
    }));
    
  }
}
