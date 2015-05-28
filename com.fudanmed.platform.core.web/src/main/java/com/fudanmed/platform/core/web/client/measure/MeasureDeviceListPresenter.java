package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.MeasureDeviceListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.measure.MeasureDeviceListPresenterView;
import com.fudanmed.platform.core.web.shared.measure.UIMeasureDevice;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class MeasureDeviceListPresenter extends WorkbenchAbstractPresenter<MeasureDeviceListPresenterView> implements IContextConsumer<RCMeasureDeviceTypeProxy> {
  @Inject
  protected MeasureDeviceListPresenterServiceAsync _service;
  
  @Inject
  public MeasureDeviceListPresenter(final MeasureDeviceListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private RCMeasureDeviceTypeProxy context;
  
  public void setup(final IPresenterInitiazerNotifier<MeasureDeviceListPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(MeasureDeviceListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup(final RCMeasureDeviceTypeProxy context, final IPresenterInitiazerNotifier<MeasureDeviceListPresenter> _notifier) {
    
    this.context = context;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          MeasureDeviceListPresenter.this.refresh();_notifier.done(MeasureDeviceListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setMeasureDeviceType(final RCMeasureDeviceTypeProxy context) {
    
    this.context = context;
    this.refresh();
  }
  
  public void setContext(final ActionContext<RCMeasureDeviceTypeProxy> ac) {
    
    final Procedure1<Iterable<RCMeasureDeviceTypeProxy>> _function = new Procedure1<Iterable<RCMeasureDeviceTypeProxy>>() {
        public void apply(final Iterable<RCMeasureDeviceTypeProxy> selections) {
          int _size = IterableExtensions.size(selections);
          boolean _equals = (_size == 1);
          if (_equals) {
            RCMeasureDeviceTypeProxy _head = IterableExtensions.<RCMeasureDeviceTypeProxy>head(selections);
            MeasureDeviceListPresenter.this.setMeasureDeviceType(_head);
          } else {
            MeasureDeviceListPresenterView _view = MeasureDeviceListPresenter.this.getView();
            _view.clear();
          }
        }
      };
    ac.addSelectionChangedListener(new SelectionChangedListener<RCMeasureDeviceTypeProxy>() {
        public void selectionChanged(Iterable<RCMeasureDeviceTypeProxy> selections) {
          _function.apply(selections);
        }
    });
  }
  
  public void refresh() {
    
    boolean _notEquals = (!Objects.equal(this.context, null));
    if (_notEquals) {
      final Procedure1<Collection<UIMeasureDevice>> _function = new Procedure1<Collection<UIMeasureDevice>>() {
          public void apply(final Collection<UIMeasureDevice> items) {
            getView().setResults(items);
            
          }
        };
      AsyncCallback<Collection<UIMeasureDevice>> _onSuccess = this.<Collection<UIMeasureDevice>>onSuccess(_function);
      _service.loadMeasureDeviceList(this.context, _onSuccess);
    }
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
