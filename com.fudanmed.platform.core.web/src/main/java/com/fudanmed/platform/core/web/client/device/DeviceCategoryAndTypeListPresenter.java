package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.device.DeviceCategoryAndTypeListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.DeviceCategoryAndTypeListPresenterView;
import com.fudanmed.platform.core.web.shared.device.UIDeviceCategoryAndType;
import com.fudanmed.platform.core.web.shared.device.UIDeviceCategoryOrTypeType;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DeviceCategoryAndTypeListPresenter extends WorkbenchAbstractPresenter<DeviceCategoryAndTypeListPresenterView> {
  @Inject
  protected DeviceCategoryAndTypeListPresenterServiceAsync _service;
  
  @Inject
  public DeviceCategoryAndTypeListPresenter(final DeviceCategoryAndTypeListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private Procedure1<? super Void> unselectedNotifier;
  
  private Procedure1<? super RCDeviceTypeProxy> deviceTypeNotifier;
  
  private Procedure1<? super RCDeviceTypeCategoryProxy> deviceTypeCategoryNotifier;
  
  public void setup(final IPresenterInitiazerNotifier<DeviceCategoryAndTypeListPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<Collection<UIDeviceCategoryAndType>> _function = new Procedure1<Collection<UIDeviceCategoryAndType>>() {
              public void apply(final Collection<UIDeviceCategoryAndType> it) {
                getView().showCategories(it);
                _notifier.done(DeviceCategoryAndTypeListPresenter.this);
              }
            };
          AsyncCallback<Collection<UIDeviceCategoryAndType>> _onSuccess = DeviceCategoryAndTypeListPresenter.this.<Collection<UIDeviceCategoryAndType>>onSuccess(_function);
          _service.loadCategories(_onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void onUnselected(final Procedure1<? super Void> notifier) {
    
    this.unselectedNotifier = notifier;
  }
  
  public void onDeviceTypeSelected(final Procedure1<? super RCDeviceTypeProxy> notifier) {
    
    this.deviceTypeNotifier = notifier;
  }
  
  public void onDeviceTypeCategorySelected(final Procedure1<? super RCDeviceTypeCategoryProxy> notifier) {
    
    this.deviceTypeCategoryNotifier = notifier;
  }
  
  public void view_deviceCategoryOrTypeSelectedExecution(final UIDeviceCategoryAndType categoryOrType) {
    
    boolean _equals = Objects.equal(categoryOrType, null);
    if (_equals) {
      if (this.unselectedNotifier!=null) this.unselectedNotifier.apply(null);
    } else {
      final Procedure1<GWTNamedEntity> _function = new Procedure1<GWTNamedEntity>() {
          public void apply(final GWTNamedEntity ct) {
            UIDeviceCategoryOrTypeType _type = categoryOrType.getType();
            final UIDeviceCategoryOrTypeType _switchValue = _type;
            boolean _matched = false;
            if (!_matched) {
              if (Objects.equal(_switchValue,UIDeviceCategoryOrTypeType.type)) {
                _matched=true;
                if (DeviceCategoryAndTypeListPresenter.this.deviceTypeNotifier!=null) DeviceCategoryAndTypeListPresenter.this.deviceTypeNotifier.apply(((RCDeviceTypeProxy) ct));
              }
            }
            if (!_matched) {
              if (Objects.equal(_switchValue,UIDeviceCategoryOrTypeType.category)) {
                _matched=true;
                if (DeviceCategoryAndTypeListPresenter.this.deviceTypeCategoryNotifier!=null) DeviceCategoryAndTypeListPresenter.this.deviceTypeCategoryNotifier.apply(((RCDeviceTypeCategoryProxy) ct));
              }
            }
          }
        };
      AsyncCallback<GWTNamedEntity> _onSuccess = this.<GWTNamedEntity>onSuccess(_function);
      _service.loadCategoryOrType(categoryOrType, _onSuccess);
    }
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().deviceCategoryOrTypeSelected(new RequestHandler1<UIDeviceCategoryAndType>(){
    			
    			public void execute(UIDeviceCategoryAndType categoryOrType){
    				view_deviceCategoryOrTypeSelectedExecution(categoryOrType);
    			}
    			
    		});
    
  }
}
