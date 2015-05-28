package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemOutStockRecordProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemReturnStockRecordProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemStockRecordProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateWorkItemOutStockRecordPresenter;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateWorkItemReturnStockRecordPresenter;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemOutStockRecordItemDetailPresenter;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemOutStockRecordListPresenter;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemReturnStockRecordItemDetailPresenter;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemStorageListPresenter;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemTaskManagementPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemTaskManagementPresenterView;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTask;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemTaskCriteria;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.print.Print;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class WorkItemTaskManagementPresenter extends WorkbenchAbstractPresenter<WorkItemTaskManagementPresenterView> {
  @Inject
  protected WorkItemTaskManagementPresenterServiceAsync _service;
  
  @Inject
  public WorkItemTaskManagementPresenter(final WorkItemTaskManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private Provider<CreateOrUpdateWorkItemOutStockRecordPresenter> createOrUpdatePresenter;
  
  @Inject
  private Provider<WorkItemOutStockRecordItemDetailPresenter> workItemOutStockRecordItemDetailPresenter;
  
  @Inject
  private Provider<WorkItemReturnStockRecordItemDetailPresenter> workItemReturnStockRecordItemDetailPresenter;
  
  @Inject
  private Provider<CreateOrUpdateWorkItemReturnStockRecordPresenter> createOrUpdateWorkItemReturnStockRecordPresenter;
  
  public WorkItemOutStockRecordListPresenter initPart(final WorkItemOutStockRecordListPresenter part) {
    this.registerPart(part);
    this.getView().setWorkItemOutStockRecordListPresenter(part);
    return part;
    
  }
  
  @Inject
  private WorkItemOutStockRecordListPresenter workItemOutStockRecordListPresenter;
  
  public WorkItemStorageListPresenter initPart(final WorkItemStorageListPresenter part) {
    this.registerPart(part);
    this.getView().setWorkItemStorageListPresenter(part);
    return part;
    
  }
  
  @Inject
  private WorkItemStorageListPresenter workItemStorageListPresenter;
  
  public void setup(final Procedure1<? super WorkItemTaskManagementPresenter> postInit) {
    
    WorkItemOutStockRecordListPresenter _initPart = this.initPart(this.workItemOutStockRecordListPresenter);
    final Procedure1<WorkItemOutStockRecordListPresenter> _function = new Procedure1<WorkItemOutStockRecordListPresenter>() {
        public void apply(final WorkItemOutStockRecordListPresenter it) {
          WorkItemStorageListPresenter _initPart = WorkItemTaskManagementPresenter.this.initPart(WorkItemTaskManagementPresenter.this.workItemStorageListPresenter);
          final Procedure1<WorkItemStorageListPresenter> _function = new Procedure1<WorkItemStorageListPresenter>() {
              public void apply(final WorkItemStorageListPresenter it) {
                final Procedure1<Void> _function = new Procedure1<Void>() {
                    public void apply(final Void it) {getView().refresh();
                      
                      postInit.apply(WorkItemTaskManagementPresenter.this);
                    }
                  };
                WorkItemTaskManagementPresenter.this.activate(new IPostInitializeAction() {
                    public void initializeFinished(Void v) {
                      _function.apply(v);
                    }
                });
              }
            };
          _initPart.setup(_function);
        }
      };
    _initPart.setup(_function);
  }
  
  public void view_showWorkItemDetailRequestExecution(final RCWorkItemTaskProxy workItem) {
    
    this.workItemOutStockRecordListPresenter.setWorkItemTask(workItem);
    this.workItemStorageListPresenter.setWorkItemTask(workItem);
  }
  
  public void view_filterRequestExecution(final UIWorkItemTaskCriteria c) {
    
    final Procedure1<IPagedResult<UIWorkItemTask>> _function = new Procedure1<IPagedResult<UIWorkItemTask>>() {
        public void apply(final IPagedResult<UIWorkItemTask> it) {
          getView().showResults(it);
          
        }
      };
    AsyncCallback<IPagedResult<UIWorkItemTask>> _onSuccess = this.<IPagedResult<UIWorkItemTask>>onSuccess(_function);
    _service.filter(c, _onSuccess);
  }
  
  public void view_createWorkItemOutStoreRequestExecution(final RCWorkItemTaskProxy workItem) {
    
    CreateOrUpdateWorkItemOutStockRecordPresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateWorkItemOutStockRecordPresenter> _function = new Procedure1<CreateOrUpdateWorkItemOutStockRecordPresenter>() {
        public void apply(final CreateOrUpdateWorkItemOutStockRecordPresenter it) {
          final Procedure1<CreateOrUpdateWorkItemOutStockRecordPresenter> _function = new Procedure1<CreateOrUpdateWorkItemOutStockRecordPresenter>() {
              public void apply(final CreateOrUpdateWorkItemOutStockRecordPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Create(workItem, _function);
        }
      };
    ObjectExtensions.<CreateOrUpdateWorkItemOutStockRecordPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_createWorkItemReturnStoreRequestExecution(final RCWorkItemTaskProxy workItem) {
    
    CreateOrUpdateWorkItemReturnStockRecordPresenter _get = this.createOrUpdateWorkItemReturnStockRecordPresenter.get();
    final Procedure1<CreateOrUpdateWorkItemReturnStockRecordPresenter> _function = new Procedure1<CreateOrUpdateWorkItemReturnStockRecordPresenter>() {
        public void apply(final CreateOrUpdateWorkItemReturnStockRecordPresenter it) {
          final Procedure1<CreateOrUpdateWorkItemReturnStockRecordPresenter> _function = new Procedure1<CreateOrUpdateWorkItemReturnStockRecordPresenter>() {
              public void apply(final CreateOrUpdateWorkItemReturnStockRecordPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Create(workItem, _function);
        }
      };
    ObjectExtensions.<CreateOrUpdateWorkItemReturnStockRecordPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_showWorkItemOutStockRecordDetailExecution(final RCWorkItemStockRecordProxy context) {
    
    final Procedure1<Boolean> _function = new Procedure1<Boolean>() {
        public void apply(final Boolean isOut) {
          if ((isOut).booleanValue()) {
            WorkItemOutStockRecordItemDetailPresenter _get = WorkItemTaskManagementPresenter.this.workItemOutStockRecordItemDetailPresenter.get();
            final Procedure1<WorkItemOutStockRecordItemDetailPresenter> _function = new Procedure1<WorkItemOutStockRecordItemDetailPresenter>() {
                public void apply(final WorkItemOutStockRecordItemDetailPresenter it) {
                  final Procedure1<WorkItemOutStockRecordItemDetailPresenter> _function = new Procedure1<WorkItemOutStockRecordItemDetailPresenter>() {
                      public void apply(final WorkItemOutStockRecordItemDetailPresenter it) {
                        eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                        
                      }
                    };
                  it.setup(((RCWorkItemOutStockRecordProxy) context), _function);
                }
              };
            ObjectExtensions.<WorkItemOutStockRecordItemDetailPresenter>operator_doubleArrow(_get, _function);
          } else {
            WorkItemReturnStockRecordItemDetailPresenter _get_1 = WorkItemTaskManagementPresenter.this.workItemReturnStockRecordItemDetailPresenter.get();
            final Procedure1<WorkItemReturnStockRecordItemDetailPresenter> _function_1 = new Procedure1<WorkItemReturnStockRecordItemDetailPresenter>() {
                public void apply(final WorkItemReturnStockRecordItemDetailPresenter it) {
                  final Procedure1<WorkItemReturnStockRecordItemDetailPresenter> _function = new Procedure1<WorkItemReturnStockRecordItemDetailPresenter>() {
                      public void apply(final WorkItemReturnStockRecordItemDetailPresenter it) {
                        eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                        
                      }
                    };
                  it.setup(((RCWorkItemReturnStockRecordProxy) context), _function);
                }
              };
            ObjectExtensions.<WorkItemReturnStockRecordItemDetailPresenter>operator_doubleArrow(_get_1, _function_1);
          }
        }
      };
    AsyncCallback<Boolean> _onSuccess = this.<Boolean>onSuccess(_function);
    _service.isOutStock(context, _onSuccess);
  }
  
  public void _eventbus_WorkItemTasksChanged() {
    getView().refresh();
    
  }
  
  public void _eventbus_WorkItemStockRecordsChanged() {
    getView().refresh();
    
  }
  
  public void view_printExecution(final RCWorkItemStockRecordProxy context) {
    
    final Procedure1<String> _function = new Procedure1<String>() {
        public void apply(final String html) {
          Print.it(html);
        }
      };
    AsyncCallback<String> _onSuccess = this.<String>onSuccess(_function);
    _service.generatePrintContents(context, _onSuccess);
  }
  
  public void view_printFitExecution(final RCWorkItemStockRecordProxy context) {
    
    final Procedure1<String> _function = new Procedure1<String>() {
        public void apply(final String html) {
          Print.it(html);
        }
      };
    AsyncCallback<String> _onSuccess = this.<String>onSuccess(_function);
    _service.generateOutFitPrintContents(((RCWorkItemOutStockRecordProxy) context), _onSuccess);
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().showWorkItemDetailRequest(new RequestHandler1<RCWorkItemTaskProxy>(){
    			
    			public void execute(RCWorkItemTaskProxy workItem){
    				view_showWorkItemDetailRequestExecution(workItem);
    			}
    			
    		});
    getView().filterRequest(new RequestHandler1<UIWorkItemTaskCriteria>(){
    			
    			public void execute(UIWorkItemTaskCriteria c){
    				view_filterRequestExecution(c);
    			}
    			
    		});
    getView().createWorkItemOutStoreRequest(new RequestHandler1<RCWorkItemTaskProxy>(){
    			
    			public void execute(RCWorkItemTaskProxy workItem){
    				view_createWorkItemOutStoreRequestExecution(workItem);
    			}
    			
    		});
    getView().createWorkItemReturnStoreRequest(new RequestHandler1<RCWorkItemTaskProxy>(){
    			
    			public void execute(RCWorkItemTaskProxy workItem){
    				view_createWorkItemReturnStoreRequestExecution(workItem);
    			}
    			
    		});
    getView().showWorkItemOutStockRecordDetail(new RequestHandler1<RCWorkItemStockRecordProxy>(){
    			
    			public void execute(RCWorkItemStockRecordProxy context){
    				view_showWorkItemOutStockRecordDetailExecution(context);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.project.WorkItemTasksChangedEvent.__type__, new com.fudanmed.platform.core.web.client.project.WorkItemTasksChangedHandler(){
    public void WorkItemTasksChanged(){
    	_eventbus_WorkItemTasksChanged();
    }
    }));
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.warehouse.WorkItemStockRecordsChangedEvent.__type__, new com.fudanmed.platform.core.web.client.warehouse.WorkItemStockRecordsChangedHandler(){
    public void WorkItemStockRecordsChanged(){
    	_eventbus_WorkItemStockRecordsChanged();
    }
    }));
    getView().print(new RequestHandler1<RCWorkItemStockRecordProxy>(){
    			
    			public void execute(RCWorkItemStockRecordProxy context){
    				view_printExecution(context);
    			}
    			
    		});
    getView().printFit(new RequestHandler1<RCWorkItemStockRecordProxy>(){
    			
    			public void execute(RCWorkItemStockRecordProxy context){
    				view_printFitExecution(context);
    			}
    			
    		});
    
  }
}
