package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.DocumentStorageListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.DocumentStorageListPresenterView;
import com.fudanmed.platform.core.web.shared.device.UIDocumentStorage;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.domain.document.proxy.DocumentStorageProxy;
import edu.fudan.langlab.domain.document.proxy.IDocumentContainerProxy;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import edu.fudan.langlab.uidl.domain.document.client.DocumentDownloadExtensions;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DocumentStorageListPresenter extends WorkbenchAbstractPresenter<DocumentStorageListPresenterView> implements IContextConsumer<IDocumentContainerProxy> {
  @Inject
  protected DocumentStorageListPresenterServiceAsync _service;
  
  @Inject
  public DocumentStorageListPresenter(final DocumentStorageListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private IDocumentContainerProxy context;
  
  public void setup(final IPresenterInitiazerNotifier<DocumentStorageListPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(DocumentStorageListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup(final IDocumentContainerProxy context, final IPresenterInitiazerNotifier<DocumentStorageListPresenter> _notifier) {
    
    this.context = context;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          DocumentStorageListPresenter.this.refresh();_notifier.done(DocumentStorageListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setContext(final ActionContext<IDocumentContainerProxy> ac) {
    
    final Procedure1<Iterable<IDocumentContainerProxy>> _function = new Procedure1<Iterable<IDocumentContainerProxy>>() {
        public void apply(final Iterable<IDocumentContainerProxy> selections) {
          int _size = IterableExtensions.size(selections);
          boolean _equals = (_size == 1);
          if (_equals) {
            IDocumentContainerProxy _head = IterableExtensions.<IDocumentContainerProxy>head(selections);
            DocumentStorageListPresenter.this.setDevice(_head);
          } else {
            DocumentStorageListPresenterView _view = DocumentStorageListPresenter.this.getView();
            _view.clear();
          }
        }
      };
    ac.addSelectionChangedListener(new SelectionChangedListener<IDocumentContainerProxy>() {
        public void selectionChanged(Iterable<IDocumentContainerProxy> selections) {
          _function.apply(selections);
        }
    });
  }
  
  public void setDevice(final IDocumentContainerProxy context) {
    
    this.context = context;
    this.refresh();
  }
  
  public void refresh() {
    
    boolean _notEquals = (!Objects.equal(this.context, null));
    if (_notEquals) {
      final Procedure1<Collection<UIDocumentStorage>> _function = new Procedure1<Collection<UIDocumentStorage>>() {
          public void apply(final Collection<UIDocumentStorage> items) {
            getView().setResults(items);
            
          }
        };
      AsyncCallback<Collection<UIDocumentStorage>> _onSuccess = this.<Collection<UIDocumentStorage>>onSuccess(_function);
      _service.loadDocumentStorageList(this.context, _onSuccess);
    }
  }
  
  public void _eventbus_DocumentStoragesChanged() {
    
    this.refresh();
  }
  
  public void view_viewDocumentExecution(final DocumentStorageProxy document) {
    
    final Procedure1<String> _function = new Procedure1<String>() {
        public void apply(final String it) {
          DocumentDownloadExtensions.doDownload(it);
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
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.device.DocumentStoragesChangedEvent.__type__, new com.fudanmed.platform.core.web.client.device.DocumentStoragesChangedHandler(){
    public void DocumentStoragesChanged(){
    	_eventbus_DocumentStoragesChanged();
    }
    }));
    getView().viewDocument(new RequestHandler1<DocumentStorageProxy>(){
    			
    			public void execute(DocumentStorageProxy document){
    				view_viewDocumentExecution(document);
    			}
    			
    		});
    
  }
}
