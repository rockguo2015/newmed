package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.client.organization.OnsiteLocationOutlinePresenterServiceAsync;
import com.fudanmed.platform.core.web.client.organization.OnsiteLocationOutlinePresenterView;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.selector.IHasObjectSelectionProvider;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class OnsiteLocationOutlinePresenter extends WorkbenchAbstractPresenter<OnsiteLocationOutlinePresenterView> implements IHasObjectSelectionProvider<UIOnsitePosition> {
  @Inject
  protected OnsiteLocationOutlinePresenterServiceAsync _service;
  
  @Inject
  public OnsiteLocationOutlinePresenter(final OnsiteLocationOutlinePresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final Procedure1<? super OnsiteLocationOutlinePresenter> postInit) {
    
    getView().setAsSimpleTree(false);
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<Collection<UIOnsitePosition>> _function = new Procedure1<Collection<UIOnsitePosition>>() {
              public void apply(final Collection<UIOnsitePosition> it) {
                getView().showResults(it);
                
                postInit.apply(OnsiteLocationOutlinePresenter.this);
              }
            };
          AsyncCallback<Collection<UIOnsitePosition>> _onSuccess = OnsiteLocationOutlinePresenter.this.<Collection<UIOnsitePosition>>onSuccess(_function);
          _service.loadAllOnsitePosition(_onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setupAsSimpleTree(final Procedure1<? super OnsiteLocationOutlinePresenter> postInit) {
    
    getView().setAsSimpleTree(true);
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<Collection<UIOnsitePosition>> _function = new Procedure1<Collection<UIOnsitePosition>>() {
              public void apply(final Collection<UIOnsitePosition> it) {
                getView().showResults(it);
                
                postInit.apply(OnsiteLocationOutlinePresenter.this);
              }
            };
          AsyncCallback<Collection<UIOnsitePosition>> _onSuccess = OnsiteLocationOutlinePresenter.this.<Collection<UIOnsitePosition>>onSuccess(_function);
          _service.loadAllOnsitePosition(_onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public ObjectSelectionProvider<UIOnsitePosition> getSelectionProvider() {
    
    OnsiteLocationOutlinePresenterView _view = this.getView();
    ActionContext<UIOnsitePosition> _actionContext = _view.getActionContext();
    return _actionContext;
  }
  
  public void _eventbus_OnsitePositionsChanged() {
    
    final Procedure1<Collection<UIOnsitePosition>> _function = new Procedure1<Collection<UIOnsitePosition>>() {
        public void apply(final Collection<UIOnsitePosition> it) {
          getView().showResults(it);
          
        }
      };
    AsyncCallback<Collection<UIOnsitePosition>> _onSuccess = this.<Collection<UIOnsitePosition>>onSuccess(_function);
    _service.loadAllOnsitePosition(_onSuccess);
  }
  
  public void _eventbus_OnsitePositionChanged(final RCOnsitePositionProxy org) {
    
    final Procedure1<UIOnsitePosition> _function = new Procedure1<UIOnsitePosition>() {
        public void apply(final UIOnsitePosition it) {
          getView().updateOnsitePosition(it);
          
        }
      };
    AsyncCallback<UIOnsitePosition> _onSuccess = this.<UIOnsitePosition>onSuccess(_function);
    _service.getValue(org, _onSuccess);
  }
  
  public void _eventbus_OnsitePositionDeleted(final RCOnsitePositionProxy org) {
    
    getView().deleteOnsitePosition(org);
    
  }
  
  public void _eventbus_OnsitePositionAdded(final RCOnsitePositionProxy org) {
    
    final Procedure1<UIOnsitePosition> _function = new Procedure1<UIOnsitePosition>() {
        public void apply(final UIOnsitePosition it) {
          getView().addOnsitePosition(it);
          
        }
      };
    AsyncCallback<UIOnsitePosition> _onSuccess = this.<UIOnsitePosition>onSuccess(_function);
    _service.getValue(org, _onSuccess);
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.organization.OnsitePositionsChangedEvent.__type__, new com.fudanmed.platform.core.web.client.organization.OnsitePositionsChangedHandler(){
    public void OnsitePositionsChanged(){
    	_eventbus_OnsitePositionsChanged();
    }
    }));
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.organization.OnsitePositionChangedEvent.__type__, new com.fudanmed.platform.core.web.client.organization.OnsitePositionChangedHandler(){
    public void OnsitePositionChanged(com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy org){
    	_eventbus_OnsitePositionChanged(org);
    }
    }));
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.organization.OnsitePositionDeletedEvent.__type__, new com.fudanmed.platform.core.web.client.organization.OnsitePositionDeletedHandler(){
    public void OnsitePositionDeleted(com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy org){
    	_eventbus_OnsitePositionDeleted(org);
    }
    }));
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.organization.OnsitePositionAddedEvent.__type__, new com.fudanmed.platform.core.web.client.organization.OnsitePositionAddedHandler(){
    public void OnsitePositionAdded(com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy org){
    	_eventbus_OnsitePositionAdded(org);
    }
    }));
    
  }
}
