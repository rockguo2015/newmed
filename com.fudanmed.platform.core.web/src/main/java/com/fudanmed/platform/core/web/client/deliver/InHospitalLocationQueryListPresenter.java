package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.InHospitalLocationQueryListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.deliver.InHospitalLocationQueryListPresenterView;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalLocation;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalLocationCriteria;
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

public class InHospitalLocationQueryListPresenter extends WorkbenchAbstractPresenter<InHospitalLocationQueryListPresenterView> {
  @Inject
  protected InHospitalLocationQueryListPresenterServiceAsync _service;
  
  @Inject
  public InHospitalLocationQueryListPresenter(final InHospitalLocationQueryListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final IPresenterInitiazerNotifier<InHospitalLocationQueryListPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {getView().refresh();
          _notifier.done(InHospitalLocationQueryListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void view_filterRequestExecution(final UIInHospitalLocationCriteria c) {
    
    final Procedure1<IPagedResult<UIInHospitalLocation>> _function = new Procedure1<IPagedResult<UIInHospitalLocation>>() {
        public void apply(final IPagedResult<UIInHospitalLocation> it) {
          getView().showResults(it);
          
        }
      };
    AsyncCallback<IPagedResult<UIInHospitalLocation>> _onSuccess = this.<IPagedResult<UIInHospitalLocation>>onSuccess(_function);
    _service.filter(c, _onSuccess);
  }
  
  public void _eventbus_InHospitalLocationsChanged() {
    getView().refresh();
    
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().filterRequest(new RequestHandler1<UIInHospitalLocationCriteria>(){
    			
    			public void execute(UIInHospitalLocationCriteria c){
    				view_filterRequestExecution(c);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.deliver.InHospitalLocationsChangedEvent.__type__, new com.fudanmed.platform.core.web.client.deliver.InHospitalLocationsChangedHandler(){
    public void InHospitalLocationsChanged(){
    	_eventbus_InHospitalLocationsChanged();
    }
    }));
    
  }
}
