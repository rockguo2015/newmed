package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskProxy;
import com.fudanmed.platform.core.web.client.deliver.PatientCheckDeliverTaskEventListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.deliver.PatientCheckDeliverTaskEventListPresenterView;
import com.fudanmed.platform.core.web.shared.deliver.UIPatientCheckDeliverTaskEvent;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class PatientCheckDeliverTaskEventListPresenter extends WorkbenchAbstractPresenter<PatientCheckDeliverTaskEventListPresenterView> implements IContextConsumer<DLCenterlizedDeliverTaskProxy> {
  @Inject
  protected PatientCheckDeliverTaskEventListPresenterServiceAsync _service;
  
  @Inject
  public PatientCheckDeliverTaskEventListPresenter(final PatientCheckDeliverTaskEventListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private DLCenterlizedDeliverTaskProxy context;
  
  public void setup(final IPresenterInitiazerNotifier<PatientCheckDeliverTaskEventListPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(PatientCheckDeliverTaskEventListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup(final DLCenterlizedDeliverTaskProxy context, final IPresenterInitiazerNotifier<PatientCheckDeliverTaskEventListPresenter> _notifier) {
    
    this.context = context;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          PatientCheckDeliverTaskEventListPresenter.this.refresh();_notifier.done(PatientCheckDeliverTaskEventListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setTask(final DLCenterlizedDeliverTaskProxy context) {
    
    this.context = context;
    this.refresh();
  }
  
  public void setContext(final ActionContext<DLCenterlizedDeliverTaskProxy> ac) {
    
    final Procedure1<Iterable<DLCenterlizedDeliverTaskProxy>> _function = new Procedure1<Iterable<DLCenterlizedDeliverTaskProxy>>() {
        public void apply(final Iterable<DLCenterlizedDeliverTaskProxy> selections) {
          int _size = IterableExtensions.size(selections);
          boolean _equals = (_size == 1);
          if (_equals) {
            DLCenterlizedDeliverTaskProxy _head = IterableExtensions.<DLCenterlizedDeliverTaskProxy>head(selections);
            PatientCheckDeliverTaskEventListPresenter.this.setTask(_head);
          } else {
            PatientCheckDeliverTaskEventListPresenterView _view = PatientCheckDeliverTaskEventListPresenter.this.getView();
            _view.clear();
          }
        }
      };
    ac.addSelectionChangedListener(new SelectionChangedListener<DLCenterlizedDeliverTaskProxy>() {
        public void selectionChanged(Iterable<DLCenterlizedDeliverTaskProxy> selections) {
          _function.apply(selections);
        }
    });
  }
  
  public void refresh() {
    
    boolean _notEquals = (!Objects.equal(this.context, null));
    if (_notEquals) {
      final Procedure1<Collection<UIPatientCheckDeliverTaskEvent>> _function = new Procedure1<Collection<UIPatientCheckDeliverTaskEvent>>() {
          public void apply(final Collection<UIPatientCheckDeliverTaskEvent> items) {
            getView().setResults(items);
            
          }
        };
      AsyncCallback<Collection<UIPatientCheckDeliverTaskEvent>> _onSuccess = this.<Collection<UIPatientCheckDeliverTaskEvent>>onSuccess(_function);
      _service.loadPatientCheckDeliverTaskEventList(this.context, _onSuccess);
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
