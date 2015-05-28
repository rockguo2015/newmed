package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.InHospitalLocationManagementPresenterView;
import com.fudanmed.platform.core.web.client.deliver.InHospitalLocationQueryListPresenter;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class InHospitalLocationManagementPresenter extends WorkbenchAbstractPresenter<InHospitalLocationManagementPresenterView> {
  @Inject
  public InHospitalLocationManagementPresenter(final InHospitalLocationManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public InHospitalLocationQueryListPresenter initPart(final InHospitalLocationQueryListPresenter part) {
    this.registerPart(part);
    this.getView().setQueryListPresenter(part);
    return part;
    
  }
  
  @Inject
  private InHospitalLocationQueryListPresenter queryListPresenter;
  
  public void setup(final IPresenterInitiazerNotifier<InHospitalLocationManagementPresenter> _notifier) {
    
    InHospitalLocationQueryListPresenter _initPart = this.initPart(this.queryListPresenter);
    final Procedure1<InHospitalLocationQueryListPresenter> _function = new Procedure1<InHospitalLocationQueryListPresenter>() {
        public void apply(final InHospitalLocationQueryListPresenter it) {
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {_notifier.done(InHospitalLocationManagementPresenter.this);
              }
            };
          InHospitalLocationManagementPresenter.this.activate(new IPostInitializeAction() {
              public void initializeFinished(Void v) {
                _function.apply(v);
              }
          });
        }
      };
    _initPart.setup(new IPresenterInitiazerNotifier<InHospitalLocationQueryListPresenter>() {
        public void done(InHospitalLocationQueryListPresenter presenter) {
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
