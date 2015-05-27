package edu.fudan.langlab.uidl.domain.code.client.web;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.domain.code.proxy.CodeProxy;
import edu.fudan.langlab.gxt.client.dialog.DialogPresenterExtensions;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import edu.fudan.langlab.uidl.domain.code.client.web.CodeManagementPresenterServiceAsync;
import edu.fudan.langlab.uidl.domain.code.client.web.CodeManagementPresenterView;
import edu.fudan.langlab.uidl.domain.code.client.web.CreateOrUpdateCodePresenter;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICode;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICodeCriteria;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICodeType;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CodeManagementPresenter extends WorkbenchAbstractPresenter<CodeManagementPresenterView> {
  @Inject
  protected CodeManagementPresenterServiceAsync _service;
  
  @Inject
  public CodeManagementPresenter(final CodeManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private Provider<CreateOrUpdateCodePresenter> createOrUpdatePresenter;
  
  public void setup(final IPresenterInitiazerNotifier<CodeManagementPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(CodeManagementPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void onStartExecution() {
    getView().showFirst();
    
  }
  
  public void view_createRequestExecution(final UICodeType codeType) {
    
    CreateOrUpdateCodePresenter p = this.createOrUpdatePresenter.get();
    p.setCodeType(codeType);
    DialogPresenterExtensions.asDialog(p, "\u65B0\u5EFA", Integer.valueOf(300), Integer.valueOf(200));
  }
  
  public void _eventbus_InputNextCode(final UICodeType codeType) {
    
    CreateOrUpdateCodePresenter p = this.createOrUpdatePresenter.get();
    p.setCodeType(codeType);
    DialogPresenterExtensions.asDialog(p, "\u65B0\u5EFA", Integer.valueOf(300), Integer.valueOf(200));
  }
  
  public void view_modifyRequestExecution(final CodeProxy value) {
    
    CreateOrUpdateCodePresenter p = this.createOrUpdatePresenter.get();
    p.setValue(value);
    DialogPresenterExtensions.asDialog(p, "\u4FEE\u6539", Integer.valueOf(300), Integer.valueOf(200));
  }
  
  public void view_deleteRequestExecution(final CodeProxy value) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.code.client.web.CodesChangedEvent());
          
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.delete(value, _onSuccess);
  }
  
  public void view_filterRequestExecution(final UICodeCriteria c) {
    
    final Procedure1<Collection<UICode>> _function = new Procedure1<Collection<UICode>>() {
        public void apply(final Collection<UICode> it) {
          getView().showResults(it);
          
        }
      };
    AsyncCallback<Collection<UICode>> _onSuccess = this.<Collection<UICode>>onSuccess(_function);
    _service.filter(c, _onSuccess);
  }
  
  public void _eventbus_CodesChanged() {
    getView().refresh();
    
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().createRequest(new RequestHandler1<UICodeType>(){
    			
    			public void execute(UICodeType codeType){
    				view_createRequestExecution(codeType);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(edu.fudan.langlab.uidl.domain.code.client.web.InputNextCodeEvent.__type__, new edu.fudan.langlab.uidl.domain.code.client.web.InputNextCodeHandler(){
    public void InputNextCode(edu.fudan.langlab.uidl.domain.code.shared.web.UICodeType codeType){
    	_eventbus_InputNextCode(codeType);
    }
    }));
    getView().modifyRequest(new RequestHandler1<CodeProxy>(){
    			
    			public void execute(CodeProxy value){
    				view_modifyRequestExecution(value);
    			}
    			
    		});
    getView().deleteRequest(new RequestHandler1<CodeProxy>(){
    			
    			public void execute(CodeProxy value){
    				view_deleteRequestExecution(value);
    			}
    			
    		});
    getView().filterRequest(new RequestHandler1<UICodeCriteria>(){
    			
    			public void execute(UICodeCriteria c){
    				view_filterRequestExecution(c);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(edu.fudan.langlab.uidl.domain.code.client.web.CodesChangedEvent.__type__, new edu.fudan.langlab.uidl.domain.code.client.web.CodesChangedHandler(){
    public void CodesChanged(){
    	_eventbus_CodesChanged();
    }
    }));
    onStartExecution();
    
  }
}
