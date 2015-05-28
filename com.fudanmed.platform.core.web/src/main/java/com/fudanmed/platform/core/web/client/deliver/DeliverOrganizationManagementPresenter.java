package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.DeliverOrganizationManagementPresenterView;
import com.fudanmed.platform.core.web.client.deliver.DeliverOrganizationQueryListPresenter;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DeliverOrganizationManagementPresenter extends WorkbenchAbstractPresenter<DeliverOrganizationManagementPresenterView> {
  @Inject
  public DeliverOrganizationManagementPresenter(final DeliverOrganizationManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public DeliverOrganizationQueryListPresenter initPart(final DeliverOrganizationQueryListPresenter part) {
    this.registerPart(part);
    this.getView().setQueryListPresenter(part);
    return part;
    
  }
  
  @Inject
  private DeliverOrganizationQueryListPresenter queryListPresenter;
  
  public void setup(final IPresenterInitiazerNotifier<DeliverOrganizationManagementPresenter> _notifier) {
    
    DeliverOrganizationQueryListPresenter _initPart = this.initPart(this.queryListPresenter);
    final Procedure1<DeliverOrganizationQueryListPresenter> _function = new Procedure1<DeliverOrganizationQueryListPresenter>() {
        public void apply(final DeliverOrganizationQueryListPresenter it) {
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {_notifier.done(DeliverOrganizationManagementPresenter.this);
              }
            };
          DeliverOrganizationManagementPresenter.this.activate(new IPostInitializeAction() {
              public void initializeFinished(Void v) {
                _function.apply(v);
              }
          });
        }
      };
    _initPart.setup(new IPresenterInitiazerNotifier<DeliverOrganizationQueryListPresenter>() {
        public void done(DeliverOrganizationQueryListPresenter presenter) {
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
