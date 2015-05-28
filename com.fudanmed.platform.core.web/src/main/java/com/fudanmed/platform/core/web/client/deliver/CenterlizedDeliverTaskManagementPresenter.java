package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTaskManagementPresenterView;
import com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTaskQueryListPresenter;
import com.fudanmed.platform.core.web.client.deliver.PatientCheckDeliverTaskEventListPresenter;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CenterlizedDeliverTaskManagementPresenter extends WorkbenchAbstractPresenter<CenterlizedDeliverTaskManagementPresenterView> {
  @Inject
  public CenterlizedDeliverTaskManagementPresenter(final CenterlizedDeliverTaskManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public CenterlizedDeliverTaskQueryListPresenter initPart(final CenterlizedDeliverTaskQueryListPresenter part) {
    this.registerPart(part);
    this.getView().setQueryListPresenter(part);
    return part;
    
  }
  
  @Inject
  private CenterlizedDeliverTaskQueryListPresenter queryListPresenter;
  
  public PatientCheckDeliverTaskEventListPresenter initPart(final PatientCheckDeliverTaskEventListPresenter part) {
    this.registerPart(part);
    this.getView().setPatientCheckDeliverTaskEventListPresenter(part);
    return part;
    
  }
  
  @Inject
  private PatientCheckDeliverTaskEventListPresenter patientCheckDeliverTaskEventListPresenter;
  
  public void setup(final IPresenterInitiazerNotifier<CenterlizedDeliverTaskManagementPresenter> _notifier) {
    
    CenterlizedDeliverTaskQueryListPresenter _initPart = this.initPart(this.queryListPresenter);
    final Procedure1<CenterlizedDeliverTaskQueryListPresenter> _function = new Procedure1<CenterlizedDeliverTaskQueryListPresenter>() {
        public void apply(final CenterlizedDeliverTaskQueryListPresenter it) {
          PatientCheckDeliverTaskEventListPresenter _initPart = CenterlizedDeliverTaskManagementPresenter.this.initPart(CenterlizedDeliverTaskManagementPresenter.this.patientCheckDeliverTaskEventListPresenter);
          final Procedure1<PatientCheckDeliverTaskEventListPresenter> _function = new Procedure1<PatientCheckDeliverTaskEventListPresenter>() {
              public void apply(final PatientCheckDeliverTaskEventListPresenter it) {
                final Procedure1<Void> _function = new Procedure1<Void>() {
                    public void apply(final Void it) {_notifier.done(CenterlizedDeliverTaskManagementPresenter.this);
                    }
                  };
                CenterlizedDeliverTaskManagementPresenter.this.activate(new IPostInitializeAction() {
                    public void initializeFinished(Void v) {
                      _function.apply(v);
                    }
                });
              }
            };
          _initPart.setup(new IPresenterInitiazerNotifier<PatientCheckDeliverTaskEventListPresenter>() {
              public void done(PatientCheckDeliverTaskEventListPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    _initPart.setup(new IPresenterInitiazerNotifier<CenterlizedDeliverTaskQueryListPresenter>() {
        public void done(CenterlizedDeliverTaskQueryListPresenter presenter) {
          _function.apply(presenter);
        }
    });
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
