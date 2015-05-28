package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskProxy;
import com.fudanmed.platform.core.web.client.deliver.DeliverTaskDispatchPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.deliver.DeliverTaskDispatchPresenterView;
import com.fudanmed.platform.core.web.shared.deliver.DeliverTaskDispatchData;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.info.Info;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.extensions.ConfigurableAsyncCallback;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DeliverTaskDispatchPresenter extends WorkbenchAbstractPresenter<DeliverTaskDispatchPresenterView> implements CommitablePresenter {
  @Inject
  protected DeliverTaskDispatchPresenterServiceAsync _service;
  
  @Inject
  public DeliverTaskDispatchPresenter(final DeliverTaskDispatchPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup4create(final Iterable<UICenterlizedDeliverTask> tasks, final IPresenterInitiazerNotifier<DeliverTaskDispatchPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          DeliverTaskDispatchPresenterView _view = DeliverTaskDispatchPresenter.this.getView();
          _view.setTasks(tasks);_notifier.done(DeliverTaskDispatchPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    DeliverTaskDispatchPresenterView _view = this.getView();
    Iterable<UICenterlizedDeliverTask> _tasks = _view.getTasks();
    final Function1<UICenterlizedDeliverTask,DLCenterlizedDeliverTaskProxy> _function = new Function1<UICenterlizedDeliverTask,DLCenterlizedDeliverTaskProxy>() {
        public DLCenterlizedDeliverTaskProxy apply(final UICenterlizedDeliverTask it) {
          DLCenterlizedDeliverTaskProxy _proxy = it.toProxy();
          return _proxy;
        }
      };
    Iterable<DLCenterlizedDeliverTaskProxy> _map = IterableExtensions.<UICenterlizedDeliverTask, DLCenterlizedDeliverTaskProxy>map(_tasks, _function);
    List<DLCenterlizedDeliverTaskProxy> _list = IterableExtensions.<DLCenterlizedDeliverTaskProxy>toList(_map);
    DeliverTaskDispatchPresenterView _view_1 = this.getView();
    DeliverTaskDispatchData _value = _view_1.getValue();
    final Procedure1<ConfigurableAsyncCallback<Void>> _function_1 = new Procedure1<ConfigurableAsyncCallback<Void>>() {
        public void apply(final ConfigurableAsyncCallback<Void> it) {
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void workItemTask) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTasksChangedEvent());
                
                notifier.success();
              }
            };
          it.onSuccessDo(_function);
          final Procedure1<Throwable> _function_1 = new Procedure1<Throwable>() {
              public void apply(final Throwable it) {
                Info.display("\u9519\u8BEF", "\u65E0\u6CD5\u6D3E\u5DE5\uFF0C\u8BF7\u5237\u65B0\u786E\u8BA4\u62A5\u4FEE\u72B6\u6001");
              }
            };
          it.onFailureDo(_function_1);
        }
      };
    ConfigurableAsyncCallback<Void> _callback = ConfigurableAsyncCallback.<Void>callback(_function_1);
    _service.commit(_list, _value, _callback);
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
