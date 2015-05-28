package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.CreateOrUpdateDocumentStoragePresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdateDocumentStoragePresenterView;
import com.fudanmed.platform.core.web.shared.device.UIDocumentStorage;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.domain.document.proxy.DocumentStorageProxy;
import edu.fudan.langlab.domain.document.proxy.IDocumentContainerProxy;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateDocumentStoragePresenter extends WorkbenchAbstractPresenter<CreateOrUpdateDocumentStoragePresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateDocumentStoragePresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateDocumentStoragePresenter(final CreateOrUpdateDocumentStoragePresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private Procedure1<? super CommitResultNotifier> commiter;
  
  public void setup4Create(final IDocumentContainerProxy parent, final IPresenterInitiazerNotifier<CreateOrUpdateDocumentStoragePresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreateOrUpdateDocumentStoragePresenterView _view = CreateOrUpdateDocumentStoragePresenter.this.getView();
          UIDocumentStorage _value = _view.getValue();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {
                notifier.success();eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.DocumentStoragesChangedEvent());
                
              }
            };
          AsyncCallback<Void> _onSuccess = CreateOrUpdateDocumentStoragePresenter.this.<Void>onSuccess(_function);
          _service.create(parent, _value, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(CreateOrUpdateDocumentStoragePresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function_1.apply(v);
        }
    });
  }
  
  public void setup4Update(final DocumentStorageProxy value, final IPresenterInitiazerNotifier<CreateOrUpdateDocumentStoragePresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreateOrUpdateDocumentStoragePresenterView _view = CreateOrUpdateDocumentStoragePresenter.this.getView();
          UIDocumentStorage _value = _view.getValue();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.DocumentStoragesChangedEvent());
                
                notifier.success();
              }
            };
          AsyncCallback<Void> _onSuccess = CreateOrUpdateDocumentStoragePresenter.this.<Void>onSuccess(_function);
          _service.updateValue(_value, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIDocumentStorage> _function = new Procedure1<UIDocumentStorage>() {
              public void apply(final UIDocumentStorage it) {
                CreateOrUpdateDocumentStoragePresenterView _view = CreateOrUpdateDocumentStoragePresenter.this.getView();
                _view.setValue(it);_notifier.done(CreateOrUpdateDocumentStoragePresenter.this);
              }
            };
          AsyncCallback<UIDocumentStorage> _onSuccess = CreateOrUpdateDocumentStoragePresenter.this.<UIDocumentStorage>onSuccess(_function);
          _service.loadValue(value, _onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function_1.apply(v);
        }
    });
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    this.commiter.apply(notifier);
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
