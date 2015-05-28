package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.ShowImagePresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.ShowImagePresenterView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.domain.document.proxy.IDocumentProxy;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import edu.fudan.langlab.uidl.domain.document.client.DocumentDownloadExtensions;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ShowImagePresenter extends WorkbenchAbstractPresenter<ShowImagePresenterView> {
  @Inject
  protected ShowImagePresenterServiceAsync _service;
  
  @Inject
  public ShowImagePresenter(final ShowImagePresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final IPresenterInitiazerNotifier<ShowImagePresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(ShowImagePresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup(final IDocumentProxy document, final IPresenterInitiazerNotifier<ShowImagePresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<String> _function = new Procedure1<String>() {
              public void apply(final String it) {
                ShowImagePresenterView _view = ShowImagePresenter.this.getView();
                String _buildUrl = DocumentDownloadExtensions.buildUrl(it);
                _view.setUrl(_buildUrl);_notifier.done(ShowImagePresenter.this);
              }
            };
          AsyncCallback<String> _onSuccess = ShowImagePresenter.this.<String>onSuccess(_function);
          _service.prepareDownload(document, _onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void showPicture(final IDocumentProxy document) {
    
    final Procedure1<String> _function = new Procedure1<String>() {
        public void apply(final String it) {
          ShowImagePresenterView _view = ShowImagePresenter.this.getView();
          String _buildUrl = DocumentDownloadExtensions.buildUrl(it);
          _view.setUrl(_buildUrl);
        }
      };
    AsyncCallback<String> _onSuccess = this.<String>onSuccess(_function);
    _service.prepareDownload(document, _onSuccess);
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
