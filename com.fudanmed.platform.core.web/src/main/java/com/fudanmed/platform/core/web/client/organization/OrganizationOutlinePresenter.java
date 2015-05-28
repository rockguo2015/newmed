package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.OrganizationOutlinePresenterServiceAsync;
import com.fudanmed.platform.core.web.client.organization.OrganizationOutlinePresenterView;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
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

public class OrganizationOutlinePresenter extends WorkbenchAbstractPresenter<OrganizationOutlinePresenterView> implements IHasObjectSelectionProvider<UIOrganization> {
  @Inject
  protected OrganizationOutlinePresenterServiceAsync _service;
  
  @Inject
  public OrganizationOutlinePresenter(final OrganizationOutlinePresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final Procedure1<? super OrganizationOutlinePresenter> postInit) {
    
    getView().asSimpleTree(false);
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<Collection<UIOrganization>> _function = new Procedure1<Collection<UIOrganization>>() {
              public void apply(final Collection<UIOrganization> it) {
                getView().showResults(it);
                
                postInit.apply(OrganizationOutlinePresenter.this);
              }
            };
          AsyncCallback<Collection<UIOrganization>> _onSuccess = OrganizationOutlinePresenter.this.<Collection<UIOrganization>>onSuccess(_function);
          _service.loadAllOrganization(_onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setupAsSimpleTree(final Procedure1<? super OrganizationOutlinePresenter> postInit) {
    
    getView().asSimpleTree(true);
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<Collection<UIOrganization>> _function = new Procedure1<Collection<UIOrganization>>() {
              public void apply(final Collection<UIOrganization> it) {
                getView().showResults(it);
                
                postInit.apply(OrganizationOutlinePresenter.this);
              }
            };
          AsyncCallback<Collection<UIOrganization>> _onSuccess = OrganizationOutlinePresenter.this.<Collection<UIOrganization>>onSuccess(_function);
          _service.loadAllOrganization(_onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void _eventbus_OrganizationsChanged() {
    
    final Procedure1<Collection<UIOrganization>> _function = new Procedure1<Collection<UIOrganization>>() {
        public void apply(final Collection<UIOrganization> it) {
          getView().showResults(it);
          
        }
      };
    AsyncCallback<Collection<UIOrganization>> _onSuccess = this.<Collection<UIOrganization>>onSuccess(_function);
    _service.loadAllOrganization(_onSuccess);
  }
  
  public void _eventbus_OrganizationChanged(final RCOrganizationProxy org) {
    
    final Procedure1<UIOrganization> _function = new Procedure1<UIOrganization>() {
        public void apply(final UIOrganization it) {
          getView().updateOrganization(it);
          
        }
      };
    AsyncCallback<UIOrganization> _onSuccess = this.<UIOrganization>onSuccess(_function);
    _service.getValue(org, _onSuccess);
  }
  
  public void _eventbus_OrganizationDeleted(final RCOrganizationProxy org) {
    
    getView().deleteOrganization(org);
    
  }
  
  public void _eventbus_OrganizationAdded(final RCOrganizationProxy org) {
    
    final Procedure1<UIOrganization> _function = new Procedure1<UIOrganization>() {
        public void apply(final UIOrganization it) {
          getView().addOrganization(it);
          
        }
      };
    AsyncCallback<UIOrganization> _onSuccess = this.<UIOrganization>onSuccess(_function);
    _service.getValue(org, _onSuccess);
  }
  
  public ObjectSelectionProvider<UIOrganization> getSelectionProvider() {
    
    OrganizationOutlinePresenterView _view = this.getView();
    ActionContext<UIOrganization> _actionContext = _view.getActionContext();
    return _actionContext;
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.organization.OrganizationsChangedEvent.__type__, new com.fudanmed.platform.core.web.client.organization.OrganizationsChangedHandler(){
    public void OrganizationsChanged(){
    	_eventbus_OrganizationsChanged();
    }
    }));
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.organization.OrganizationChangedEvent.__type__, new com.fudanmed.platform.core.web.client.organization.OrganizationChangedHandler(){
    public void OrganizationChanged(com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy org){
    	_eventbus_OrganizationChanged(org);
    }
    }));
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.organization.OrganizationDeletedEvent.__type__, new com.fudanmed.platform.core.web.client.organization.OrganizationDeletedHandler(){
    public void OrganizationDeleted(com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy org){
    	_eventbus_OrganizationDeleted(org);
    }
    }));
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.organization.OrganizationAddedEvent.__type__, new com.fudanmed.platform.core.web.client.organization.OrganizationAddedHandler(){
    public void OrganizationAdded(com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy org){
    	_eventbus_OrganizationAdded(org);
    }
    }));
    
  }
}
