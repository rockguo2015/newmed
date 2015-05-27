package edu.fudan.langlab.uidl.domain.app.client.workbench;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.Presenter;
import edu.fudan.langlab.gxt.client.dialog.DialogPresenterExtensions;
import edu.fudan.langlab.uidl.domain.app.client.workbench.ApplicationWorkbenchPresenterView;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;

public class ApplicationWorkbenchPresenter extends WorkbenchAbstractPresenter<ApplicationWorkbenchPresenterView> {
  @Inject
  public ApplicationWorkbenchPresenter(final ApplicationWorkbenchPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void onStartExecution() {
    
  }
  
  public void _eventbus_ShowPresenter(final Presenter presenter) {
    
    
    getView().showPresenter(presenter,null);
    
  }
  
  public void _eventbus_ShowActivePresenter(final Presenter presenter) {
    
    getView().showActivatedPresenter(presenter);
    
  }
  
  public void _eventbus_PopPresenter(final Presenter presenter) {
    
    if ((presenter instanceof CommitablePresenter)) {
      DialogPresenterExtensions.asDialog(((CommitablePresenter) presenter));
    } else {
      
      getView().popPresenter(presenter,null);
      
    }
  }
  
  public void _eventbus_PopActivatedPresenter(final Presenter presenter) {
    
    if ((presenter instanceof CommitablePresenter)) {
      DialogPresenterExtensions.asActivatedDialog(((CommitablePresenter) presenter));
    } else {
      getView().popActivatedPresenter(presenter);
      
    }
  }
  
  public void _eventbus_ShowActivePresenterWithHeader(final Presenter presenter, final String header) {
    
    
    getView().showSctivatedPresenterWithHeader(presenter,header);
    
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    _regs_.add(eventBus.addHandler(edu.fudan.langlab.uidl.domain.app.client.workbench.ShowPresenterEvent.__type__, new edu.fudan.langlab.uidl.domain.app.client.workbench.ShowPresenterHandler(){
    public void ShowPresenter(com.uniquesoft.gwt.client.common.Presenter presenter){
    	_eventbus_ShowPresenter(presenter);
    }
    }));
    _regs_.add(eventBus.addHandler(edu.fudan.langlab.uidl.domain.app.client.workbench.ShowActivePresenterEvent.__type__, new edu.fudan.langlab.uidl.domain.app.client.workbench.ShowActivePresenterHandler(){
    public void ShowActivePresenter(com.uniquesoft.gwt.client.common.Presenter presenter){
    	_eventbus_ShowActivePresenter(presenter);
    }
    }));
    _regs_.add(eventBus.addHandler(edu.fudan.langlab.uidl.domain.app.client.workbench.PopPresenterEvent.__type__, new edu.fudan.langlab.uidl.domain.app.client.workbench.PopPresenterHandler(){
    public void PopPresenter(com.uniquesoft.gwt.client.common.Presenter presenter){
    	_eventbus_PopPresenter(presenter);
    }
    }));
    _regs_.add(eventBus.addHandler(edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent.__type__, new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterHandler(){
    public void PopActivatedPresenter(com.uniquesoft.gwt.client.common.Presenter presenter){
    	_eventbus_PopActivatedPresenter(presenter);
    }
    }));
    _regs_.add(eventBus.addHandler(edu.fudan.langlab.uidl.domain.app.client.workbench.ShowActivePresenterWithHeaderEvent.__type__, new edu.fudan.langlab.uidl.domain.app.client.workbench.ShowActivePresenterWithHeaderHandler(){
    public void ShowActivePresenterWithHeader(com.uniquesoft.gwt.client.common.Presenter presenter,java.lang.String header){
    	_eventbus_ShowActivePresenterWithHeader(presenter,header);
    }
    }));
    onStartExecution();
    
  }
}
