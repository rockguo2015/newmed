package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCGroupTaskProxy;
import com.fudanmed.platform.core.web.client.project.GroupTaskMisDispatchReportPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.GroupTaskMisDispatchReportPresenterView;
import com.fudanmed.platform.core.web.shared.project.GroupTaskMisDispatchReportData;
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
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class GroupTaskMisDispatchReportPresenter extends WorkbenchAbstractPresenter<GroupTaskMisDispatchReportPresenterView> implements CommitablePresenter {
  @Inject
  protected GroupTaskMisDispatchReportPresenterServiceAsync _service;
  
  @Inject
  public GroupTaskMisDispatchReportPresenter(final GroupTaskMisDispatchReportPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private RCGroupTaskProxy context;
  
  public void setup(final RCGroupTaskProxy context, final IPresenterInitiazerNotifier<GroupTaskMisDispatchReportPresenter> _notifier) {
    
    this.context = context;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(GroupTaskMisDispatchReportPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    GroupTaskMisDispatchReportPresenterView _view = this.getView();
    GroupTaskMisDispatchReportData _value = _view.getValue();
    final Procedure1<ConfigurableAsyncCallback<Void>> _function = new Procedure1<ConfigurableAsyncCallback<Void>>() {
        public void apply(final ConfigurableAsyncCallback<Void> it) {
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void workItemTask) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.project.GroupTasksChangedEvent());
                
                notifier.success();
              }
            };
          it.onSuccessDo(_function);
          final Procedure1<Throwable> _function_1 = new Procedure1<Throwable>() {
              public void apply(final Throwable it) {
                Info.display("\u9519\u8BEF", "\u65E0\u6CD5\u4E0A\u62A5\uFF0C\u8BF7\u5237\u65B0\u786E\u8BA4\u62A5\u4FEE\u72B6\u6001");
              }
            };
          it.onFailureDo(_function_1);
        }
      };
    ConfigurableAsyncCallback<Void> _callback = ConfigurableAsyncCallback.<Void>callback(_function);
    _service.commit(this.context, _value, _callback);
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
