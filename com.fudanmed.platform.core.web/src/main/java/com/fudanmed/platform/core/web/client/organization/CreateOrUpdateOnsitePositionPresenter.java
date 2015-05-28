package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.client.organization.CreateOrUpdateOnsitePositionPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.organization.CreateOrUpdateOnsitePositionPresenterView;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.shared.extensions.BooleanExtensions;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateOnsitePositionPresenter extends WorkbenchAbstractPresenter<CreateOrUpdateOnsitePositionPresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateOnsitePositionPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateOnsitePositionPresenter(final CreateOrUpdateOnsitePositionPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private boolean used4Update;
  
  private RCOnsitePositionProxy parent;
  
  public void setup4Create(final RCOnsitePositionProxy parent, final IPresenterInitiazerNotifier<CreateOrUpdateOnsitePositionPresenter> _notifier) {
    
    this.used4Update = false;
    this.parent = parent;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          CreateOrUpdateOnsitePositionPresenterView _view = CreateOrUpdateOnsitePositionPresenter.this.getView();
          _view.setParent(parent);_notifier.done(CreateOrUpdateOnsitePositionPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup4Update(final RCOnsitePositionProxy value, final IPresenterInitiazerNotifier<CreateOrUpdateOnsitePositionPresenter> _notifier) {
    
    this.used4Update = true;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIOnsitePosition> _function = new Procedure1<UIOnsitePosition>() {
              public void apply(final UIOnsitePosition it) {
                CreateOrUpdateOnsitePositionPresenterView _view = CreateOrUpdateOnsitePositionPresenter.this.getView();
                _view.setValue(it);_notifier.done(CreateOrUpdateOnsitePositionPresenter.this);
              }
            };
          AsyncCallback<UIOnsitePosition> _onSuccess = CreateOrUpdateOnsitePositionPresenter.this.<UIOnsitePosition>onSuccess(_function);
          _service.loadValue(value, _onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    if (this.used4Update) {
      CreateOrUpdateOnsitePositionPresenterView _view = this.getView();
      UIOnsitePosition _value = _view.getValue();
      final Procedure1<Void> _function = new Procedure1<Void>() {
          public void apply(final Void it) {
            CreateOrUpdateOnsitePositionPresenterView _view = CreateOrUpdateOnsitePositionPresenter.this.getView();
            UIOnsitePosition _value = _view.getValue();
            RCOnsitePositionProxy _proxy = _value.toProxy();
            eventBus.fireEvent(new com.fudanmed.platform.core.web.client.organization.OnsitePositionChangedEvent(_proxy));
            
            notifier.success();
          }
        };
      AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
      _service.updateValue(_value, _onSuccess);
    } else {
      CreateOrUpdateOnsitePositionPresenterView _view_1 = this.getView();
      UIOnsitePosition _value_1 = _view_1.getValue();
      final Procedure1<UIOnsitePosition> _function_1 = new Procedure1<UIOnsitePosition>() {
          public void apply(final UIOnsitePosition it) {
            it.setParent(CreateOrUpdateOnsitePositionPresenter.this.parent);
          }
        };
      UIOnsitePosition _doubleArrow = ObjectExtensions.<UIOnsitePosition>operator_doubleArrow(_value_1, _function_1);
      final Procedure1<RCOnsitePositionProxy> _function_2 = new Procedure1<RCOnsitePositionProxy>() {
          public void apply(final RCOnsitePositionProxy it) {
            eventBus.fireEvent(new com.fudanmed.platform.core.web.client.organization.OnsitePositionAddedEvent(it));
            
            notifier.success();
            CreateOrUpdateOnsitePositionPresenterView _view = CreateOrUpdateOnsitePositionPresenter.this.getView();
            UIOnsitePosition _value = _view.getValue();
            Boolean _inputNext = _value.getInputNext();
            boolean _isLogicTrue = BooleanExtensions.isLogicTrue(_inputNext);
            if (_isLogicTrue) {
              eventBus.fireEvent(new com.fudanmed.platform.core.web.client.organization.InputNextOnsitePositionEvent(CreateOrUpdateOnsitePositionPresenter.this.parent));
              
            }
          }
        };
      AsyncCallback<RCOnsitePositionProxy> _onSuccess_1 = this.<RCOnsitePositionProxy>onSuccess(_function_2);
      _service.createValue(_doubleArrow, _onSuccess_1);
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
