package edu.fudan.langlab.client.csv;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.client.csv.ErrorMessagePresenterView;
import edu.fudan.langlab.shared.csv.UIErrorItem;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ErrorMessagePresenter extends WorkbenchAbstractPresenter<ErrorMessagePresenterView> {
  @Inject
  public ErrorMessagePresenter(final ErrorMessagePresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final Collection<UIErrorItem> results, final IPresenterInitiazerNotifier<ErrorMessagePresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          ErrorMessagePresenterView _view = ErrorMessagePresenter.this.getView();
          _view.showErrorItems(results);_notifier.done(ErrorMessagePresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
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
