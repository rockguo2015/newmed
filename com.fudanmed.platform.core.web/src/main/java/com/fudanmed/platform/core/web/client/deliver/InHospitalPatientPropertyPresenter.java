package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy;
import com.fudanmed.platform.core.web.client.deliver.InHospitalPatientPropertyPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.deliver.InHospitalPatientPropertyPresenterView;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalPatient;
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

public class InHospitalPatientPropertyPresenter extends WorkbenchAbstractPresenter<InHospitalPatientPropertyPresenterView> implements IContextConsumer<DLInHospitalPatientProxy> {
  @Inject
  protected InHospitalPatientPropertyPresenterServiceAsync _service;
  
  @Inject
  public InHospitalPatientPropertyPresenter(final InHospitalPatientPropertyPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final IPresenterInitiazerNotifier<InHospitalPatientPropertyPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(InHospitalPatientPropertyPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setContext(final ActionContext<DLInHospitalPatientProxy> ac) {
    
    final Procedure1<Iterable<DLInHospitalPatientProxy>> _function = new Procedure1<Iterable<DLInHospitalPatientProxy>>() {
        public void apply(final Iterable<DLInHospitalPatientProxy> selections) {
          int _size = IterableExtensions.size(selections);
          boolean _equals = (_size == 1);
          if (_equals) {
            DLInHospitalPatientProxy _head = IterableExtensions.<DLInHospitalPatientProxy>head(selections);
            InHospitalPatientPropertyPresenter.this.setValue(_head);
          } else {
            InHospitalPatientPropertyPresenterView _view = InHospitalPatientPropertyPresenter.this.getView();
            _view.clear();
          }
        }
      };
    ac.addSelectionChangedListener(new SelectionChangedListener<DLInHospitalPatientProxy>() {
        public void selectionChanged(Iterable<DLInHospitalPatientProxy> selections) {
          _function.apply(selections);
        }
    });
  }
  
  public void setValue(final DLInHospitalPatientProxy value) {
    
    final Procedure1<UIInHospitalPatient> _function = new Procedure1<UIInHospitalPatient>() {
        public void apply(final UIInHospitalPatient it) {
          getView().setValue(it);
          
        }
      };
    AsyncCallback<UIInHospitalPatient> _onSuccess = this.<UIInHospitalPatient>onSuccess(_function);
    _service.loadValue(value, _onSuccess);
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
