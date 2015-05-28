package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.PictureBrowsePresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.PictureBrowsePresenterView;
import com.fudanmed.platform.core.web.client.device.ShowImagePresenter;
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
import edu.fudan.langlab.domain.document.proxy.IHasDocumentsProxy;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class PictureBrowsePresenter extends WorkbenchAbstractPresenter<PictureBrowsePresenterView> implements IContextConsumer<IHasDocumentsProxy> {
  @Inject
  protected PictureBrowsePresenterServiceAsync _service;
  
  @Inject
  public PictureBrowsePresenter(final PictureBrowsePresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public ShowImagePresenter initPart(final ShowImagePresenter part) {
    this.registerPart(part);
    this.getView().setShowImagePresenter(part);
    return part;
    
  }
  
  @Inject
  private ShowImagePresenter showImagePresenter;
  
  private IHasDocumentsProxy context;
  
  public void setup(final IPresenterInitiazerNotifier<PictureBrowsePresenter> _notifier) {
    
    ShowImagePresenter _initPart = this.initPart(this.showImagePresenter);
    final Procedure1<ShowImagePresenter> _function = new Procedure1<ShowImagePresenter>() {
        public void apply(final ShowImagePresenter it) {
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {_notifier.done(PictureBrowsePresenter.this);
              }
            };
          PictureBrowsePresenter.this.activate(new IPostInitializeAction() {
              public void initializeFinished(Void v) {
                _function.apply(v);
              }
          });
        }
      };
    _initPart.setup(new IPresenterInitiazerNotifier<ShowImagePresenter>() {
        public void done(ShowImagePresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  public void setup(final IHasDocumentsProxy context, final IPresenterInitiazerNotifier<PictureBrowsePresenter> _notifier) {
    
    this.context = context;
    ShowImagePresenter _initPart = this.initPart(this.showImagePresenter);
    final Procedure1<ShowImagePresenter> _function = new Procedure1<ShowImagePresenter>() {
        public void apply(final ShowImagePresenter it) {
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {
                PictureBrowsePresenter.this.refresh();_notifier.done(PictureBrowsePresenter.this);
              }
            };
          PictureBrowsePresenter.this.activate(new IPostInitializeAction() {
              public void initializeFinished(Void v) {
                _function.apply(v);
              }
          });
        }
      };
    _initPart.setup(new IPresenterInitiazerNotifier<ShowImagePresenter>() {
        public void done(ShowImagePresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  public void setContext(final ActionContext<IHasDocumentsProxy> ac) {
    
    final Procedure1<Iterable<IHasDocumentsProxy>> _function = new Procedure1<Iterable<IHasDocumentsProxy>>() {
        public void apply(final Iterable<IHasDocumentsProxy> selections) {
          int _size = IterableExtensions.size(selections);
          boolean _equals = (_size == 1);
          if (_equals) {
            IHasDocumentsProxy _head = IterableExtensions.<IHasDocumentsProxy>head(selections);
            PictureBrowsePresenter.this.setDevice(_head);
          } else {
            PictureBrowsePresenterView _view = PictureBrowsePresenter.this.getView();
            _view.clear();
          }
        }
      };
    ac.addSelectionChangedListener(new SelectionChangedListener<IHasDocumentsProxy>() {
        public void selectionChanged(Iterable<IHasDocumentsProxy> selections) {
          _function.apply(selections);
        }
    });
  }
  
  public void setDevice(final IHasDocumentsProxy context) {
    
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
    
    this.showImagePresenter.showPicture(document);
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
