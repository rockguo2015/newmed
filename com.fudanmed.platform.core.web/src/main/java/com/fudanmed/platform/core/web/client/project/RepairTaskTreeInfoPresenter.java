package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.client.device.PictureListPresenter;
import com.fudanmed.platform.core.web.client.project.ComplaintListPresenter;
import com.fudanmed.platform.core.web.client.project.RepairTaskDetailInfoPresenter;
import com.fudanmed.platform.core.web.client.project.RepairTaskTreeInfoPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.RepairTaskTreeInfoPresenterView;
import com.fudanmed.platform.core.web.client.project.ShowRepairEvaluatePresenter;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemStorageListPresenter;
import com.fudanmed.platform.core.web.shared.project.UIGeneralTask;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class RepairTaskTreeInfoPresenter extends WorkbenchAbstractPresenter<RepairTaskTreeInfoPresenterView> {
  @Inject
  protected RepairTaskTreeInfoPresenterServiceAsync _service;
  
  @Inject
  public RepairTaskTreeInfoPresenter(final RepairTaskTreeInfoPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public RepairTaskDetailInfoPresenter initPart(final RepairTaskDetailInfoPresenter part) {
    this.registerPart(part);
    this.getView().setRepairTaskDetailInfoPresenter(part);
    return part;
    
  }
  
  @Inject
  private RepairTaskDetailInfoPresenter repairTaskDetailInfoPresenter;
  
  public WorkItemStorageListPresenter initPart(final WorkItemStorageListPresenter part) {
    this.registerPart(part);
    this.getView().setWorkItemStorageListPresenter(part);
    return part;
    
  }
  
  @Inject
  private WorkItemStorageListPresenter workItemStorageListPresenter;
  
  public ShowRepairEvaluatePresenter initPart(final ShowRepairEvaluatePresenter part) {
    this.registerPart(part);
    this.getView().setShowRepairEvaluatePresenter(part);
    return part;
    
  }
  
  @Inject
  private ShowRepairEvaluatePresenter showRepairEvaluatePresenter;
  
  public ComplaintListPresenter initPart(final ComplaintListPresenter part) {
    this.registerPart(part);
    this.getView().setComplaintListPresenter(part);
    return part;
    
  }
  
  @Inject
  private ComplaintListPresenter complaintListPresenter;
  
  public PictureListPresenter initPart(final PictureListPresenter part) {
    this.registerPart(part);
    this.getView().setWorkitemPictureListPresenter(part);
    return part;
    
  }
  
  @Inject
  private PictureListPresenter workitemPictureListPresenter;
  
  public void setup(final Procedure1<? super RepairTaskTreeInfoPresenter> postInit) {
    
    WorkItemStorageListPresenter _initPart = this.initPart(this.workItemStorageListPresenter);
    final Procedure1<WorkItemStorageListPresenter> _function = new Procedure1<WorkItemStorageListPresenter>() {
        public void apply(final WorkItemStorageListPresenter it) {
          RepairTaskDetailInfoPresenter _initPart = RepairTaskTreeInfoPresenter.this.initPart(RepairTaskTreeInfoPresenter.this.repairTaskDetailInfoPresenter);
          final Procedure1<RepairTaskDetailInfoPresenter> _function = new Procedure1<RepairTaskDetailInfoPresenter>() {
              public void apply(final RepairTaskDetailInfoPresenter it) {
                ComplaintListPresenter _initPart = RepairTaskTreeInfoPresenter.this.initPart(RepairTaskTreeInfoPresenter.this.complaintListPresenter);
                final Procedure1<ComplaintListPresenter> _function = new Procedure1<ComplaintListPresenter>() {
                    public void apply(final ComplaintListPresenter it) {
                      ShowRepairEvaluatePresenter _initPart = RepairTaskTreeInfoPresenter.this.initPart(RepairTaskTreeInfoPresenter.this.showRepairEvaluatePresenter);
                      final Procedure1<ShowRepairEvaluatePresenter> _function = new Procedure1<ShowRepairEvaluatePresenter>() {
                          public void apply(final ShowRepairEvaluatePresenter it) {
                            PictureListPresenter _initPart = RepairTaskTreeInfoPresenter.this.initPart(RepairTaskTreeInfoPresenter.this.workitemPictureListPresenter);
                            final Procedure1<PictureListPresenter> _function = new Procedure1<PictureListPresenter>() {
                                public void apply(final PictureListPresenter it) {
                                  final Procedure1<Void> _function = new Procedure1<Void>() {
                                      public void apply(final Void it) {
                                        postInit.apply(RepairTaskTreeInfoPresenter.this);
                                      }
                                    };
                                  RepairTaskTreeInfoPresenter.this.activate(new IPostInitializeAction() {
                                      public void initializeFinished(Void v) {
                                        _function.apply(v);
                                      }
                                  });
                                }
                              };
                            _initPart.setup(new IPresenterInitiazerNotifier<PictureListPresenter>() {
                                public void done(PictureListPresenter presenter) {
                                  _function.apply(presenter);
                                }
                            });
                          }
                        };
                      _initPart.setup(_function);
                    }
                  };
                _initPart.setup(_function);
              }
            };
          _initPart.setup(_function);
        }
      };
    _initPart.setup(_function);
  }
  
  public void setRepairTask(final RCRepairTaskProxy value) {
    
    final Procedure1<Collection<UIGeneralTask>> _function = new Procedure1<Collection<UIGeneralTask>>() {
        public void apply(final Collection<UIGeneralTask> it) {
          getView().setResults(it);
          
        }
      };
    AsyncCallback<Collection<UIGeneralTask>> _onSuccess = this.<Collection<UIGeneralTask>>onSuccess(_function);
    _service.loadTree(value, _onSuccess);
    this.repairTaskDetailInfoPresenter.setRepairTask(value);
    this.workItemStorageListPresenter.setRepairTask(value);
    this.complaintListPresenter.setRepairTask(value);
    this.showRepairEvaluatePresenter.setRepairTask(value);
    this.workitemPictureListPresenter.setDevice(value);
  }
  
  public void view_showCommentRequestExecution(final UIGeneralTask generalTask) {
    
    final Procedure1<String> _function = new Procedure1<String>() {
        public void apply(final String it) {
          getView().showComment(it);
          
        }
      };
    AsyncCallback<String> _onSuccess = this.<String>onSuccess(_function);
    _service.loadComment(generalTask, _onSuccess);
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().showCommentRequest(new RequestHandler1<UIGeneralTask>(){
    			
    			public void execute(UIGeneralTask generalTask){
    				view_showCommentRequestExecution(generalTask);
    			}
    			
    		});
    
  }
}
