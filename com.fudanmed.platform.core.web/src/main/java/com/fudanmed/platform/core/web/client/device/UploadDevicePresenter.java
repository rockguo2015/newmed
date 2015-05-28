package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.UploadDevicePresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.UploadDevicePresenterView;
import com.fudanmed.platform.core.web.shared.device.DeviceUploadData;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.extensions.ConfigurableAsyncCallback;
import com.uniquesoft.gwt.shared.datatype.File;
import edu.fudan.langlab.gxt.client.validation.CSVClientExtensions;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class UploadDevicePresenter extends WorkbenchAbstractPresenter<UploadDevicePresenterView> implements CommitablePresenter {
  @Inject
  protected UploadDevicePresenterServiceAsync _service;
  
  @Inject
  public UploadDevicePresenter(final UploadDevicePresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final IPresenterInitiazerNotifier<UploadDevicePresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(UploadDevicePresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void view_fileUploadedExecution() {
    
    UploadDevicePresenterView _view = this.getView();
    DeviceUploadData _value = _view.getValue();
    File _file = _value.getFile();
    final Procedure1<ConfigurableAsyncCallback<Collection<UIDevice>>> _function = new Procedure1<ConfigurableAsyncCallback<Collection<UIDevice>>>() {
        public void apply(final ConfigurableAsyncCallback<Collection<UIDevice>> it) {
          final Procedure1<Collection<UIDevice>> _function = new Procedure1<Collection<UIDevice>>() {
              public void apply(final Collection<UIDevice> it) {
                UploadDevicePresenterView _view = UploadDevicePresenter.this.getView();
                _view.setPreviewValues(it);
              }
            };
          it.onSuccessDo(_function);
          final Procedure1<Throwable> _function_1 = new Procedure1<Throwable>() {
              public void apply(final Throwable caught) {
                CSVClientExtensions.showErrors(caught);
              }
            };
          it.onFailureDo(_function_1);
        }
      };
    ConfigurableAsyncCallback<Collection<UIDevice>> _callback = ConfigurableAsyncCallback.<Collection<UIDevice>>callback(_function);
    _service.doUpload(_file, _callback);
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    UploadDevicePresenterView _view = this.getView();
    Collection<UIDevice> _previewValues = _view.getPreviewValues();
    final Procedure1<ConfigurableAsyncCallback<Void>> _function = new Procedure1<ConfigurableAsyncCallback<Void>>() {
        public void apply(final ConfigurableAsyncCallback<Void> it) {
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {
                notifier.success();eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.DevicesChangedEvent());
                
              }
            };
          it.onSuccessDo(_function);
          final Procedure1<Throwable> _function_1 = new Procedure1<Throwable>() {
              public void apply(final Throwable caught) {
                CSVClientExtensions.showErrors(caught);
              }
            };
          it.onFailureDo(_function_1);
        }
      };
    ConfigurableAsyncCallback<Void> _callback = ConfigurableAsyncCallback.<Void>callback(_function);
    _service.commit(_previewValues, _callback);
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().fileUploaded(new RequestHandler(){
    			
    			public void execute(){
    				view_fileUploadedExecution();
    			}
    			
    		});
    
  }
}
