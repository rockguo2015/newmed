package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.CheckOrganizationManagementPresenterView;
import com.fudanmed.platform.core.web.client.deliver.CheckOrganizationQueryListPresenter;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CheckOrganizationManagementPresenter extends WorkbenchAbstractPresenter<CheckOrganizationManagementPresenterView> {
  @Inject
  public CheckOrganizationManagementPresenter(final CheckOrganizationManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public CheckOrganizationQueryListPresenter initPart(final CheckOrganizationQueryListPresenter part) {
    this.registerPart(part);
    this.getView().setQueryListPresenter(part);
    return part;
    
  }
  
  @Inject
  private CheckOrganizationQueryListPresenter queryListPresenter;
  
  public void setup(final IPresenterInitiazerNotifier<CheckOrganizationManagementPresenter> _notifier) {
    
    CheckOrganizationQueryListPresenter _initPart = this.initPart(this.queryListPresenter);
    final Procedure1<CheckOrganizationQueryListPresenter> _function = new Procedure1<CheckOrganizationQueryListPresenter>() {
        public void apply(final CheckOrganizationQueryListPresenter it) {
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {_notifier.done(CheckOrganizationManagementPresenter.this);
              }
            };
          CheckOrganizationManagementPresenter.this.activate(new IPostInitializeAction() {
              public void initializeFinished(Void v) {
                _function.apply(v);
              }
          });
        }
      };
    _initPart.setup(new IPresenterInitiazerNotifier<CheckOrganizationQueryListPresenter>() {
        public void done(CheckOrganizationQueryListPresenter presenter) {
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
