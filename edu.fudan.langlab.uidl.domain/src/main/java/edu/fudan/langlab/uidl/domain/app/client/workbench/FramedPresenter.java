package edu.fudan.langlab.uidl.domain.app.client.workbench;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.Presenter;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.FramedPresenterView;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class FramedPresenter extends WorkbenchAbstractPresenter<FramedPresenterView> {
  @Inject
  public FramedPresenter(final FramedPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private Presenter contentPresenter;
  
  public void setup(final String theTitle, final Presenter p, final IPresenterInitiazerNotifier<FramedPresenter> _notifier) {
    
    this.contentPresenter = p;
    FramedPresenterView _view = this.getView();
    _view.setContentPresenter(theTitle, p);
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(FramedPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void postDeactivated() {
    
    this.contentPresenter.deactivate();
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
