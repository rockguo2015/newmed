package com.fudanmed.platform.core.web.client.workbench;

import com.fudanmed.platform.core.web.client.workbench.HeaderPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.workbench.HeaderPresenterView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class HeaderPresenter extends WorkbenchAbstractPresenter<HeaderPresenterView> {
  @Inject
  protected HeaderPresenterServiceAsync _service;
  
  @Inject
  public HeaderPresenter(final HeaderPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final Procedure1<? super HeaderPresenter> postInitializer) {
    
    final Procedure1<String> _function = new Procedure1<String>() {
        public void apply(final String it) {
          HeaderPresenterView _view = HeaderPresenter.this.getView();
          _view.setApplicationTitle(it);
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {
                postInitializer.apply(HeaderPresenter.this);
              }
            };
          HeaderPresenter.this.activate(new IPostInitializeAction() {
              public void initializeFinished(Void v) {
                _function.apply(v);
              }
          });
        }
      };
    AsyncCallback<String> _onSuccess = this.<String>onSuccess(_function);
    _service.getAppTitle(_onSuccess);
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
