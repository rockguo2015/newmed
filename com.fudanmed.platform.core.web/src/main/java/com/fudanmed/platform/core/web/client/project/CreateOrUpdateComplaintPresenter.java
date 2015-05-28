package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCComplaintProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateComplaintPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateComplaintPresenterView;
import com.fudanmed.platform.core.web.shared.project.UIComplaint;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateComplaintPresenter extends WorkbenchAbstractPresenter<CreateOrUpdateComplaintPresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateComplaintPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateComplaintPresenter(final CreateOrUpdateComplaintPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private boolean used4Update;
  
  private RCRepairTaskProxy parent;
  
  public void setup4Create(final RCRepairTaskProxy parent, final Procedure1<? super CreateOrUpdateComplaintPresenter> postInitializer) {
    
    this.used4Update = false;
    this.parent = parent;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          postInitializer.apply(CreateOrUpdateComplaintPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup4Update(final RCComplaintProxy value, final Procedure1<? super CreateOrUpdateComplaintPresenter> postInitializer) {
    
    this.used4Update = true;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIComplaint> _function = new Procedure1<UIComplaint>() {
              public void apply(final UIComplaint it) {
                CreateOrUpdateComplaintPresenterView _view = CreateOrUpdateComplaintPresenter.this.getView();
                _view.setValue(it);
                postInitializer.apply(CreateOrUpdateComplaintPresenter.this);
              }
            };
          AsyncCallback<UIComplaint> _onSuccess = CreateOrUpdateComplaintPresenter.this.<UIComplaint>onSuccess(_function);
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
      CreateOrUpdateComplaintPresenterView _view = this.getView();
      UIComplaint _value = _view.getValue();
      final Procedure1<Void> _function = new Procedure1<Void>() {
          public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.project.ComplaintsChangedEvent());
            
            notifier.success();
          }
        };
      AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
      _service.updateValue(_value, _onSuccess);
    } else {
      CreateOrUpdateComplaintPresenterView _view_1 = this.getView();
      UIComplaint _value_1 = _view_1.getValue();
      final Procedure1<Void> _function_1 = new Procedure1<Void>() {
          public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.project.ComplaintsChangedEvent());
            
            notifier.success();
          }
        };
      AsyncCallback<Void> _onSuccess_1 = this.<Void>onSuccess(_function_1);
      _service.createValue(this.parent, _value_1, _onSuccess_1);
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
