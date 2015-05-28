package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverTaskCancelDispatchDataPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverTaskCancelDispatchDataPresenterView;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverTaskCancelDispatchData;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateDeliverTaskCancelDispatchDataPresenter extends WorkbenchAbstractPresenter<CreateOrUpdateDeliverTaskCancelDispatchDataPresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateDeliverTaskCancelDispatchDataPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateDeliverTaskCancelDispatchDataPresenter(final CreateOrUpdateDeliverTaskCancelDispatchDataPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private Procedure1<? super CommitResultNotifier> commiter;
  
  public void setup4Create(final Iterable<UICenterlizedDeliverTask> deliverTasks, final IPresenterInitiazerNotifier<CreateOrUpdateDeliverTaskCancelDispatchDataPresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          final Function1<UICenterlizedDeliverTask,DLCenterlizedDeliverTaskProxy> _function = new Function1<UICenterlizedDeliverTask,DLCenterlizedDeliverTaskProxy>() {
              public DLCenterlizedDeliverTaskProxy apply(final UICenterlizedDeliverTask it) {
                DLCenterlizedDeliverTaskProxy _proxy = it.toProxy();
                return _proxy;
              }
            };
          Iterable<DLCenterlizedDeliverTaskProxy> _map = IterableExtensions.<UICenterlizedDeliverTask, DLCenterlizedDeliverTaskProxy>map(deliverTasks, _function);
          List<DLCenterlizedDeliverTaskProxy> _list = IterableExtensions.<DLCenterlizedDeliverTaskProxy>toList(_map);
          CreateOrUpdateDeliverTaskCancelDispatchDataPresenterView _view = CreateOrUpdateDeliverTaskCancelDispatchDataPresenter.this.getView();
          UIDeliverTaskCancelDispatchData _value = _view.getValue();
          final Procedure1<Void> _function_1 = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTasksChangedEvent());
                
                notifier.success();
              }
            };
          AsyncCallback<Void> _onSuccess = CreateOrUpdateDeliverTaskCancelDispatchDataPresenter.this.<Void>onSuccess(_function_1);
          _service.commit(_list, _value, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(CreateOrUpdateDeliverTaskCancelDispatchDataPresenter.this);
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
