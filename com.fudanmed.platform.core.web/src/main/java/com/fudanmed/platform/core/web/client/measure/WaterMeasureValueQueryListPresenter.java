package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy;
import com.fudanmed.platform.core.web.client.measure.WaterMeasureValueQueryListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.measure.WaterMeasureValueQueryListPresenterView;
import com.fudanmed.platform.core.web.shared.measure.UIMeasureValueCriteria;
import com.fudanmed.platform.core.web.shared.measure.UIWaterMeasureValue;
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

public class WaterMeasureValueQueryListPresenter extends WorkbenchAbstractPresenter<WaterMeasureValueQueryListPresenterView> {
  @Inject
  protected WaterMeasureValueQueryListPresenterServiceAsync _service;
  
  @Inject
  public WaterMeasureValueQueryListPresenter(final WaterMeasureValueQueryListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final RCMeasureDeviceProxy device, final IPresenterInitiazerNotifier<WaterMeasureValueQueryListPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          WaterMeasureValueQueryListPresenterView _view = WaterMeasureValueQueryListPresenter.this.getView();
          _view.setMeasureDevice(device);_notifier.done(WaterMeasureValueQueryListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void view_filterRequestExecution(final UIMeasureValueCriteria c) {
    
    final Procedure1<IPagedResult<UIWaterMeasureValue>> _function = new Procedure1<IPagedResult<UIWaterMeasureValue>>() {
        public void apply(final IPagedResult<UIWaterMeasureValue> it) {
          getView().showResults(it);
          
        }
      };
    AsyncCallback<IPagedResult<UIWaterMeasureValue>> _onSuccess = this.<IPagedResult<UIWaterMeasureValue>>onSuccess(_function);
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
