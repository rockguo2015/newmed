package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMDeviceTypeEntryPresenter;
import com.fudanmed.platform.core.web.client.device.PMDefaultIntervalAssociationListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.PMDefaultIntervalAssociationListPresenterView;
import com.fudanmed.platform.core.web.shared.device.UIPMDefaultIntervalAssociation;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class PMDefaultIntervalAssociationListPresenter extends WorkbenchAbstractPresenter<PMDefaultIntervalAssociationListPresenterView> {
  @Inject
  protected PMDefaultIntervalAssociationListPresenterServiceAsync _service;
  
  @Inject
  public PMDefaultIntervalAssociationListPresenter(final PMDefaultIntervalAssociationListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private RCDeviceTypeProxy context;
  
  @Inject
  private Provider<CreateOrUpdatePMDeviceTypeEntryPresenter> createOrUpdatePMDeviceTypeEntryPresenter;
  
  public void setup(final IPresenterInitiazerNotifier<PMDefaultIntervalAssociationListPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(PMDefaultIntervalAssociationListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup(final RCDeviceTypeProxy context, final IPresenterInitiazerNotifier<PMDefaultIntervalAssociationListPresenter> _notifier) {
    
    this.context = context;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          PMDefaultIntervalAssociationListPresenter.this.refresh();_notifier.done(PMDefaultIntervalAssociationListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setDeviceType(final RCDeviceTypeProxy context) {
    
    this.context = context;
    this.refresh();
  }
  
  public void setActionContext(final ActionContext<RCDeviceTypeProxy> ac) {
    
    PMDefaultIntervalAssociationListPresenterView _view = this.getView();
    _view.setActionContext(ac);
    final Procedure1<Iterable<RCDeviceTypeProxy>> _function = new Procedure1<Iterable<RCDeviceTypeProxy>>() {
        public void apply(final Iterable<RCDeviceTypeProxy> selections) {
          int _size = IterableExtensions.size(selections);
          boolean _equals = (_size == 1);
          if (_equals) {
            RCDeviceTypeProxy _head = IterableExtensions.<RCDeviceTypeProxy>head(selections);
            PMDefaultIntervalAssociationListPresenter.this.setDeviceType(_head);
          } else {
            PMDefaultIntervalAssociationListPresenterView _view = PMDefaultIntervalAssociationListPresenter.this.getView();
            _view.clear();
          }
        }
      };
    ac.addSelectionChangedListener(new SelectionChangedListener<RCDeviceTypeProxy>() {
        public void selectionChanged(Iterable<RCDeviceTypeProxy> selections) {
          _function.apply(selections);
        }
    });
  }
  
  public void refresh() {
    
    boolean _notEquals = (!Objects.equal(this.context, null));
    if (_notEquals) {
      final Procedure1<Collection<UIPMDefaultIntervalAssociation>> _function = new Procedure1<Collection<UIPMDefaultIntervalAssociation>>() {
          public void apply(final Collection<UIPMDefaultIntervalAssociation> items) {
            getView().setResults(items);
            
          }
        };
      AsyncCallback<Collection<UIPMDefaultIntervalAssociation>> _onSuccess = this.<Collection<UIPMDefaultIntervalAssociation>>onSuccess(_function);
      _service.loadPMDefaultIntervalAssociationList(this.context, _onSuccess);
    }
  }
  
  public void view_setPMSpecRequestExecution() {
    
    CreateOrUpdatePMDeviceTypeEntryPresenter _get = this.createOrUpdatePMDeviceTypeEntryPresenter.get();
    final Procedure1<CreateOrUpdatePMDeviceTypeEntryPresenter> _function = new Procedure1<CreateOrUpdatePMDeviceTypeEntryPresenter>() {
        public void apply(final CreateOrUpdatePMDeviceTypeEntryPresenter it) {
          final Procedure1<CreateOrUpdatePMDeviceTypeEntryPresenter> _function = new Procedure1<CreateOrUpdatePMDeviceTypeEntryPresenter>() {
              public void apply(final CreateOrUpdatePMDeviceTypeEntryPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Update(PMDefaultIntervalAssociationListPresenter.this.context, new IPresenterInitiazerNotifier<CreateOrUpdatePMDeviceTypeEntryPresenter>() {
              public void done(CreateOrUpdatePMDeviceTypeEntryPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    ObjectExtensions.<CreateOrUpdatePMDeviceTypeEntryPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void _eventbus_PMDefaultIntervalAssociationsChanged() {
    
    this.refresh();
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().setPMSpecRequest(new RequestHandler(){
    			
    			public void execute(){
    				view_setPMSpecRequestExecution();
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.device.PMDefaultIntervalAssociationsChangedEvent.__type__, new com.fudanmed.platform.core.web.client.device.PMDefaultIntervalAssociationsChangedHandler(){
    public void PMDefaultIntervalAssociationsChanged(){
    	_eventbus_PMDefaultIntervalAssociationsChanged();
    }
    }));
    
  }
}
