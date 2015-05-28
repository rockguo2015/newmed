package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.CreateOrUpdateOrganizationPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.organization.CreateOrUpdateOrganizationPresenterView;
import com.fudanmed.platform.core.web.client.organization.OnsiteLocationOutlinePresenter;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.shared.extensions.BooleanExtensions;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateOrganizationPresenter extends WorkbenchAbstractPresenter<CreateOrUpdateOrganizationPresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateOrganizationPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateOrganizationPresenter(final CreateOrUpdateOrganizationPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private boolean used4Update;
  
  private RCOrganizationProxy parent;
  
  public OnsiteLocationOutlinePresenter initPart(final OnsiteLocationOutlinePresenter part) {
    this.registerPart(part);
    this.getView().setOnsiteLocationOutlinePresenter(part);
    return part;
    
  }
  
  @Inject
  private OnsiteLocationOutlinePresenter onsiteLocationOutlinePresenter;
  
  public void setup4Create(final RCOrganizationProxy parent, final Procedure1<? super CreateOrUpdateOrganizationPresenter> postInitializer) {
    
    this.used4Update = false;
    this.parent = parent;
    OnsiteLocationOutlinePresenter _initPart = this.initPart(this.onsiteLocationOutlinePresenter);
    final Procedure1<OnsiteLocationOutlinePresenter> _function = new Procedure1<OnsiteLocationOutlinePresenter>() {
        public void apply(final OnsiteLocationOutlinePresenter it) {
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {
                getView().setParent(parent);
                
                postInitializer.apply(CreateOrUpdateOrganizationPresenter.this);
              }
            };
          CreateOrUpdateOrganizationPresenter.this.activate(new IPostInitializeAction() {
              public void initializeFinished(Void v) {
                _function.apply(v);
              }
          });
        }
      };
    _initPart.setupAsSimpleTree(_function);
  }
  
  public void setup4Update(final RCOrganizationProxy value, final Procedure1<? super CreateOrUpdateOrganizationPresenter> postInitializer) {
    
    this.used4Update = true;
    OnsiteLocationOutlinePresenter _initPart = this.initPart(this.onsiteLocationOutlinePresenter);
    final Procedure1<OnsiteLocationOutlinePresenter> _function = new Procedure1<OnsiteLocationOutlinePresenter>() {
        public void apply(final OnsiteLocationOutlinePresenter it) {
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {
                final Procedure1<UIOrganization> _function = new Procedure1<UIOrganization>() {
                    public void apply(final UIOrganization it) {
                      CreateOrUpdateOrganizationPresenterView _view = CreateOrUpdateOrganizationPresenter.this.getView();
                      _view.setValue(it);
                      CreateOrUpdateOrganizationPresenterView _view_1 = CreateOrUpdateOrganizationPresenter.this.getView();
                      Collection<UIOnsitePosition> _positions = it.getPositions();
                      _view_1.setPositions(_positions);
                      postInitializer.apply(CreateOrUpdateOrganizationPresenter.this);
                    }
                  };
                AsyncCallback<UIOrganization> _onSuccess = CreateOrUpdateOrganizationPresenter.this.<UIOrganization>onSuccess(_function);
                _service.loadValue(value, _onSuccess);
              }
            };
          CreateOrUpdateOrganizationPresenter.this.activate(new IPostInitializeAction() {
              public void initializeFinished(Void v) {
                _function.apply(v);
              }
          });
        }
      };
    _initPart.setupAsSimpleTree(_function);
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    if (this.used4Update) {
      CreateOrUpdateOrganizationPresenterView _view = this.getView();
      UIOrganization _value = _view.getValue();
      final Procedure1<UIOrganization> _function = new Procedure1<UIOrganization>() {
          public void apply(final UIOrganization it) {
            CreateOrUpdateOrganizationPresenterView _view = CreateOrUpdateOrganizationPresenter.this.getView();
            Collection<UIOnsitePosition> _positions = _view.getPositions();
            it.setPositions(_positions);
          }
        };
      UIOrganization _doubleArrow = ObjectExtensions.<UIOrganization>operator_doubleArrow(_value, _function);
      final Procedure1<Void> _function_1 = new Procedure1<Void>() {
          public void apply(final Void it) {
            CreateOrUpdateOrganizationPresenterView _view = CreateOrUpdateOrganizationPresenter.this.getView();
            UIOrganization _value = _view.getValue();
            RCOrganizationProxy _proxy = _value.toProxy();
            eventBus.fireEvent(new com.fudanmed.platform.core.web.client.organization.OrganizationChangedEvent(_proxy));
            
            notifier.success();
          }
        };
      AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function_1);
      _service.updateValue(_doubleArrow, _onSuccess);
    } else {
      CreateOrUpdateOrganizationPresenterView _view_1 = this.getView();
      UIOrganization _value_1 = _view_1.getValue();
      final Procedure1<UIOrganization> _function_2 = new Procedure1<UIOrganization>() {
          public void apply(final UIOrganization it) {
            it.setParent(CreateOrUpdateOrganizationPresenter.this.parent);
            CreateOrUpdateOrganizationPresenterView _view = CreateOrUpdateOrganizationPresenter.this.getView();
            Collection<UIOnsitePosition> _positions = _view.getPositions();
            it.setPositions(_positions);
          }
        };
      UIOrganization _doubleArrow_1 = ObjectExtensions.<UIOrganization>operator_doubleArrow(_value_1, _function_2);
      final Procedure1<RCOrganizationProxy> _function_3 = new Procedure1<RCOrganizationProxy>() {
          public void apply(final RCOrganizationProxy it) {
            eventBus.fireEvent(new com.fudanmed.platform.core.web.client.organization.OrganizationAddedEvent(it));
            
            notifier.success();
            CreateOrUpdateOrganizationPresenterView _view = CreateOrUpdateOrganizationPresenter.this.getView();
            UIOrganization _value = _view.getValue();
            Boolean _inputNext = _value.getInputNext();
            boolean _isLogicTrue = BooleanExtensions.isLogicTrue(_inputNext);
            if (_isLogicTrue) {
              eventBus.fireEvent(new com.fudanmed.platform.core.web.client.organization.InputNextOrganizationEvent(CreateOrUpdateOrganizationPresenter.this.parent));
              
            }
          }
        };
      AsyncCallback<RCOrganizationProxy> _onSuccess_1 = this.<RCOrganizationProxy>onSuccess(_function_3);
      _service.createValue(_doubleArrow_1, _onSuccess_1);
    }
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    
  }
}
