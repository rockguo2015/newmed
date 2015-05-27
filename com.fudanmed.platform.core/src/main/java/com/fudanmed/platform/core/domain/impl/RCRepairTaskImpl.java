package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.common.RCFaultEmergencyLevel;
import com.fudanmed.platform.core.common.RCFaultLevel;
import com.fudanmed.platform.core.common.RCFaultReportSource;
import com.fudanmed.platform.core.common.impl.RCFaultEmergencyLevelImpl;
import com.fudanmed.platform.core.common.impl.RCFaultLevelImpl;
import com.fudanmed.platform.core.common.impl.RCFaultReportSourceImpl;
import com.fudanmed.platform.core.domain.RCComplaint;
import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCEmployeeUser;
import com.fudanmed.platform.core.domain.RCEvaluateState;
import com.fudanmed.platform.core.domain.RCFaultType;
import com.fudanmed.platform.core.domain.RCGroupTask;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.RCRepairEvaluate;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.RCRepairTaskStatus;
import com.fudanmed.platform.core.domain.RCSettlement;
import com.fudanmed.platform.core.domain.RCTaskDirtyManager;
import com.fudanmed.platform.core.domain.RCWorkItemPicture;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.impl.RCComplaintImpl;
import com.fudanmed.platform.core.domain.impl.RCEmployeeImpl;
import com.fudanmed.platform.core.domain.impl.RCFaultTypeImpl;
import com.fudanmed.platform.core.domain.impl.RCGroupTaskImpl;
import com.fudanmed.platform.core.domain.impl.RCOrganizationImpl;
import com.fudanmed.platform.core.domain.impl.RCRepairEvaluateImpl;
import com.fudanmed.platform.core.domain.impl.RCSettlementImpl;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.warehouse.RCWorkItemStorage;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import edu.fudan.langlab.domain.document.IDocument;
import edu.fudan.langlab.domain.organization.Party;
import edu.fudan.langlab.domain.organization.impl.PartyImpl;
import edu.fudan.langlab.domain.security.ISystemUserService;
import edu.fudan.langlab.domain.security.User;
import edu.fudan.langlab.domain.statemachine.ModelObjectLogService;
import edu.fudan.mylang.common.NumberExtensions;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import edu.fudan.mylang.utils.DateUtil;
import edu.fudan.mylang.utils.DateUtil.Month;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.eclipse.xtext.xbase.lib.DoubleExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.hibernate.annotations.DiscriminatorOptions;
import org.springframework.beans.factory.BeanFactory;

@Entity
@DiscriminatorValue("RCREPAIRTASK_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcrepairtask")
public class RCRepairTaskImpl extends BaseModelObject implements RCRepairTask {
  public RCRepairTaskImpl() {
    super();
  }
  
  private RCRepairTaskStatus Status;
  
  public RCRepairTaskStatus getStatus() {
    return this.Status;
  }
  
  private ModelObjectLogService getModelObjectLogService() {
    return getBeanFactory().getBean(ModelObjectLogService.class);
  }
  
  private void _start(final Boolean byReporter) {
    
    if ((byReporter).booleanValue()) {
      RCTaskDirtyManager _taskDirtyManager = this.getTaskDirtyManager();
      _taskDirtyManager.notifyReported();
      this.isFromReporter = Boolean.valueOf(true);
    } else {
      this.isFromReporter = Boolean.valueOf(false);
    }RCRepairEvaluate rCRepairEvaluate=RCRepairEvaluateImpl.create(getObjectFactory());
    this.repairEvaluate = rCRepairEvaluate;
    this.updateDerived();
    Status=RCRepairTaskStatus.newCreated;
  }
  
  public void start(final Boolean byReporter) {
    if(Status==null){
    	_start(byReporter);
    	getModelObjectLogService().createLog(this,"Status","Initialize");
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _cancel() {
    
    Boolean _isScheduled = this.isScheduled();
    if ((_isScheduled).booleanValue()) {
      final Procedure1<RCGroupTask> _function = new Procedure1<RCGroupTask>() {
          public void apply(final RCGroupTask it) {
            RCTaskDirtyManager _taskDirtyManager = it.getTaskDirtyManager();
            RCMaintenanceTeam _team = it.getTeam();
            _taskDirtyManager.notifyTeam(_team);
            it.cancel();
          }
        };
      IterableExtensions.<RCGroupTask>forEach(this.groupTasks, _function);
    }
    Status=RCRepairTaskStatus.cancel;
  }
  
  public void cancel() {
    if(Status==RCRepairTaskStatus.newCreated||Status==RCRepairTaskStatus.scheduled||Status==RCRepairTaskStatus.wait4Close){
    	_cancel();
    	getModelObjectLogService().createLog(this,"Status","cancel");
    	getBeanFactory().getBean(com.fudanmed.platform.core.domain.events.RCRepairTaskEventsManager.class).fireCancel(this);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _updated() {
    
    final RCRepairTaskStatus _switchValue = this.Status;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,RCRepairTaskStatus.newCreated)) {
        _matched=true;
        Status=RCRepairTaskStatus.newCreated;
      }
    }
    if (!_matched) {
      Status=RCRepairTaskStatus.wait4SchedulerProcess;
    }
  }
  
  public void updated() {
    if(Status==RCRepairTaskStatus.wait4SchedulerProcess||Status==RCRepairTaskStatus.newCreated){
    	_updated();
    	getModelObjectLogService().createLog(this,"Status","updated");
    	getBeanFactory().getBean(com.fudanmed.platform.core.domain.events.RCRepairTaskEventsManager.class).fireUpdated(this);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _firstWorkItemCreated() {
    
    Status=RCRepairTaskStatus.wait4GroupTaskFinish;
  }
  
  public void firstWorkItemCreated() {
    if(Status==RCRepairTaskStatus.scheduled){
    	_firstWorkItemCreated();
    	getModelObjectLogService().createLog(this,"Status","firstWorkItemCreated");
    	getBeanFactory().getBean(com.fudanmed.platform.core.domain.events.RCRepairTaskEventsManager.class).fireFirstWorkItemCreated(this);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _misdispatch(final RCGroupTask groupTask) {
    
    Status=RCRepairTaskStatus.wait4SchedulerProcess;
  }
  
  public void misdispatch(final RCGroupTask groupTask) {
    if(Status==RCRepairTaskStatus.scheduled||Status==RCRepairTaskStatus.wait4GroupTaskFinish){
    	_misdispatch(groupTask);
    	getModelObjectLogService().createLog(this,"Status","misdispatch");
    	getBeanFactory().getBean(com.fudanmed.platform.core.domain.events.RCRepairTaskEventsManager.class).fireMisdispatch(this,groupTask);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _groupTaskFinished(final RCGroupTask groupTask) {
    
    Status=RCRepairTaskStatus.wait4Close;
  }
  
  public void groupTaskFinished(final RCGroupTask groupTask) {
    if(Status==RCRepairTaskStatus.wait4GroupTaskFinish){
    	_groupTaskFinished(groupTask);
    	getModelObjectLogService().createLog(this,"Status","groupTaskFinished");
    	getBeanFactory().getBean(com.fudanmed.platform.core.domain.events.RCRepairTaskEventsManager.class).fireGroupTaskFinished(this,groupTask);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _close() {
    
    this.repairEvaluate.setEvaluateState(RCEvaluateState.waiting);
    Date _day = DateUtil.today();
    this.finishDate = _day;
    Date _now = DateUtil.now();
    this.finishTime = _now;
    Status=RCRepairTaskStatus.closed;
  }
  
  public void close() {
    if(Status==RCRepairTaskStatus.wait4Close){
    	_close();
    	getModelObjectLogService().createLog(this,"Status","close");
    	getBeanFactory().getBean(com.fudanmed.platform.core.domain.events.RCRepairTaskEventsManager.class).fireClose(this);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  private void _createGroupTask(final RCMaintenanceTeam team) {
    RCGroupTask rCGroupTask=RCGroupTaskImpl.create(this,getObjectFactory());
    final Procedure1<RCGroupTask> _function = new Procedure1<RCGroupTask>() {
        public void apply(final RCGroupTask it) {
          it.setTeam(team);
          Date _day = DateUtil.today();
          it.setDate(_day);
          Date _now = DateUtil.now();
          it.setTime(_now);
          BeanFactory _beanFactory = RCRepairTaskImpl.this.getBeanFactory();
          ISystemUserService _bean = _beanFactory.<ISystemUserService>getBean(ISystemUserService.class);
          User _currentUser = _bean.getCurrentUser();
          RCEmployee _employee = ((RCEmployeeUser) _currentUser).getEmployee();
          it.setOperator(_employee);
          it.start();
        }
      };
    RCGroupTask _doubleArrow = ObjectExtensions.<RCGroupTask>operator_doubleArrow(rCGroupTask, _function);
    this.activeGroupTask = _doubleArrow;
    Status=RCRepairTaskStatus.scheduled;
  }
  
  public void createGroupTask(final RCMaintenanceTeam team) {
    if(Status==RCRepairTaskStatus.newCreated||Status==RCRepairTaskStatus.wait4SchedulerProcess||Status==RCRepairTaskStatus.wait4Close){
    	_createGroupTask(team);
    	getModelObjectLogService().createLog(this,"Status","createGroupTask");
    	getBeanFactory().getBean(com.fudanmed.platform.core.domain.events.RCRepairTaskEventsManager.class).fireCreateGroupTask(this,team);						
    }else{
    	throw new edu.fudan.langlab.domain.statemachine.InvalidStateException();
    }
  }
  
  public Boolean isNewCreated() {
    return com.fudanmed.platform.core.domain.RCRepairTaskStatus.newCreated==Status;
  }
  
  public Boolean isScheduled() {
    return com.fudanmed.platform.core.domain.RCRepairTaskStatus.scheduled==Status;
  }
  
  public Boolean isWait4SchedulerProcess() {
    return com.fudanmed.platform.core.domain.RCRepairTaskStatus.wait4SchedulerProcess==Status;
  }
  
  public Boolean isWait4GroupTaskFinish() {
    return com.fudanmed.platform.core.domain.RCRepairTaskStatus.wait4GroupTaskFinish==Status;
  }
  
  public Boolean isWait4Close() {
    return com.fudanmed.platform.core.domain.RCRepairTaskStatus.wait4Close==Status;
  }
  
  public Boolean isClosed() {
    return com.fudanmed.platform.core.domain.RCRepairTaskStatus.closed==Status;
  }
  
  public Boolean isCancel() {
    return com.fudanmed.platform.core.domain.RCRepairTaskStatus.cancel==Status;
  }
  
  @JoinColumn(name = "faultReportSource_id")
  @ManyToOne(targetEntity = RCFaultReportSourceImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCFaultReportSource faultReportSource;
  
  public RCFaultReportSource getFaultReportSource() {
    return this.faultReportSource;
  }
  
  public RCRepairTask setFaultReportSource(final RCFaultReportSource faultReportSource) {
    this.faultReportSource = faultReportSource;
    return this;			
    
  }
  
  private String reportSid;
  
  public String getReportSid() {
    return this.reportSid;
  }
  
  public RCRepairTask setReportSid(final String reportSid) {
    this.reportSid = reportSid;
    return this;			
    
  }
  
  private Date reportDate;
  
  public Date getReportDate() {
    return this.reportDate;
  }
  
  public RCRepairTask setReportDate(final Date reportDate) {
    this.reportDate = reportDate;
    return this;			
    
  }
  
  private Date reportTime;
  
  public Date getReportTime() {
    return this.reportTime;
  }
  
  public RCRepairTask setReportTime(final Date reportTime) {
    this.reportTime = reportTime;
    return this;			
    
  }
  
  private Date reserveDate;
  
  public Date getReserveDate() {
    return this.reserveDate;
  }
  
  public RCRepairTask setReserveDate(final Date reserveDate) {
    this.reserveDate = reserveDate;
    return this;			
    
  }
  
  private Date reserveTime;
  
  public Date getReserveTime() {
    return this.reserveTime;
  }
  
  public RCRepairTask setReserveTime(final Date reserveTime) {
    this.reserveTime = reserveTime;
    return this;			
    
  }
  
  private Date planFinishDate;
  
  public Date getPlanFinishDate() {
    return this.planFinishDate;
  }
  
  public RCRepairTask setPlanFinishDate(final Date planFinishDate) {
    this.planFinishDate = planFinishDate;
    return this;			
    
  }
  
  private Date planFinishTime;
  
  public Date getPlanFinishTime() {
    return this.planFinishTime;
  }
  
  public RCRepairTask setPlanFinishTime(final Date planFinishTime) {
    this.planFinishTime = planFinishTime;
    return this;			
    
  }
  
  private Date finishDate;
  
  public Date getFinishDate() {
    return this.finishDate;
  }
  
  public RCRepairTask setFinishDate(final Date finishDate) {
    this.finishDate = finishDate;
    return this;			
    
  }
  
  private Date finishTime;
  
  public Date getFinishTime() {
    return this.finishTime;
  }
  
  public RCRepairTask setFinishTime(final Date finishTime) {
    this.finishTime = finishTime;
    return this;			
    
  }
  
  private String location;
  
  public String getLocation() {
    return this.location;
  }
  
  public RCRepairTask setLocation(final String location) {
    this.location = location;
    return this;			
    
  }
  
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public RCRepairTask setComment(final String comment) {
    this.comment = comment;
    return this;			
    
  }
  
  @JoinColumn(name = "reporter_id")
  @ManyToOne(targetEntity = RCEmployeeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCEmployee reporter;
  
  public RCEmployee getReporter() {
    return this.reporter;
  }
  
  public RCRepairTask setReporter(final RCEmployee reporter) {
    this.reporter = reporter;
    return this;			
    
  }
  
  private String reporterName;
  
  public String getReporterName() {
    return this.reporterName;
  }
  
  public RCRepairTask setReporterName(final String reporterName) {
    this.reporterName = reporterName;
    return this;			
    
  }
  
  private String reporterPhone;
  
  public String getReporterPhone() {
    return this.reporterPhone;
  }
  
  public RCRepairTask setReporterPhone(final String reporterPhone) {
    this.reporterPhone = reporterPhone;
    return this;			
    
  }
  
  @JoinColumn(name = "reportOrg_id")
  @ManyToOne(targetEntity = RCOrganizationImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCOrganization reportOrg;
  
  public RCOrganization getReportOrg() {
    return this.reportOrg;
  }
  
  public RCRepairTask setReportOrg(final RCOrganization reportOrg) {
    this.reportOrg = reportOrg;
    return this;			
    
  }
  
  @JoinColumn(name = "faultLevel_id")
  @ManyToOne(targetEntity = RCFaultLevelImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCFaultLevel faultLevel;
  
  public RCFaultLevel getFaultLevel() {
    return this.faultLevel;
  }
  
  public RCRepairTask setFaultLevel(final RCFaultLevel faultLevel) {
    this.faultLevel = faultLevel;
    return this;			
    
  }
  
  @JoinColumn(name = "faultEmergencyLevel_id")
  @ManyToOne(targetEntity = RCFaultEmergencyLevelImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCFaultEmergencyLevel faultEmergencyLevel;
  
  public RCFaultEmergencyLevel getFaultEmergencyLevel() {
    return this.faultEmergencyLevel;
  }
  
  public RCRepairTask setFaultEmergencyLevel(final RCFaultEmergencyLevel faultEmergencyLevel) {
    this.faultEmergencyLevel = faultEmergencyLevel;
    return this;			
    
  }
  
  @JoinColumn(name = "faultType_id")
  @ManyToOne(targetEntity = RCFaultTypeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCFaultType faultType;
  
  public RCFaultType getFaultType() {
    return this.faultType;
  }
  
  public RCRepairTask setFaultType(final RCFaultType faultType) {
    this.faultType = faultType;
    return this;			
    
  }
  
  private Boolean isFromReporter;
  
  public Boolean getIsFromReporter() {
    return this.isFromReporter;
  }
  
  public RCRepairTask setIsFromReporter(final Boolean isFromReporter) {
    this.isFromReporter = isFromReporter;
    return this;			
    
  }
  
  @JoinColumn(name = "operator_id")
  @ManyToOne(targetEntity = PartyImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private Party operator;
  
  public Party getOperator() {
    return this.operator;
  }
  
  public RCRepairTask setOperator(final Party operator) {
    this.operator = operator;
    return this;			
    
  }
  
  private String month;
  
  public String getMonth() {
    return this.month;
  }
  
  public RCRepairTask setMonth(final String month) {
    this.month = month;
    return this;			
    
  }
  
  @OneToMany(targetEntity = RCGroupTaskImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "repairTask")
  private Collection<RCGroupTask> groupTasks = new java.util.ArrayList<com.fudanmed.platform.core.domain.RCGroupTask>();;
  
  public Collection<RCGroupTask> getGroupTasks() {
    return this.groupTasks;
  }
  
  public RCGroupTask createAndAddtoGroupTasks() {
    getGroupTasks().size();
    com.fudanmed.platform.core.domain.RCGroupTask rCGroupTask = new com.fudanmed.platform.core.domain.impl.RCGroupTaskImpl(this);
    getObjectFactory().create(rCGroupTask);
    getGroupTasks().add(rCGroupTask);
    return rCGroupTask;
    
  }
  
  public RCRepairTask removeAllGroupTasks() {
    for(RCGroupTask obj : this.groupTasks){
    	getObjectFactory().delete(obj);
    }
    this.groupTasks.clear();
    return this;	
    
  }
  
  public RCRepairTask removeFromGroupTasks(final RCGroupTask rCGroupTask) {
    this.groupTasks.remove(rCGroupTask);
    getObjectFactory().delete(rCGroupTask);
    return this;
    
  }
  
  @OneToMany(targetEntity = RCComplaintImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "repairTask")
  private Collection<RCComplaint> complaints = new java.util.ArrayList<com.fudanmed.platform.core.domain.RCComplaint>();;
  
  public Collection<RCComplaint> getComplaints() {
    return this.complaints;
  }
  
  public RCComplaint createAndAddtoComplaints() {
    getComplaints().size();
    com.fudanmed.platform.core.domain.RCComplaint rCComplaint = new com.fudanmed.platform.core.domain.impl.RCComplaintImpl(this);
    getObjectFactory().create(rCComplaint);
    getComplaints().add(rCComplaint);
    return rCComplaint;
    
  }
  
  public RCRepairTask removeAllComplaints() {
    for(RCComplaint obj : this.complaints){
    	getObjectFactory().delete(obj);
    }
    this.complaints.clear();
    return this;	
    
  }
  
  public RCRepairTask removeFromComplaints(final RCComplaint rCComplaint) {
    this.complaints.remove(rCComplaint);
    getObjectFactory().delete(rCComplaint);
    return this;
    
  }
  
  @JoinColumn(name = "activeGroupTask_id")
  @ManyToOne(targetEntity = RCGroupTaskImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCGroupTask activeGroupTask;
  
  public RCGroupTask getActiveGroupTask() {
    return this.activeGroupTask;
  }
  
  public RCRepairTask setActiveGroupTask(final RCGroupTask activeGroupTask) {
    this.activeGroupTask = activeGroupTask;
    return this;			
    
  }
  
  @JoinColumn(name = "settlement_id")
  @ManyToOne(targetEntity = RCSettlementImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCSettlement settlement;
  
  public RCSettlement getSettlement() {
    return this.settlement;
  }
  
  public RCRepairTask setSettlement(final RCSettlement settlement) {
    this.settlement = settlement;
    return this;			
    
  }
  
  @JoinColumn(name = "repairEvaluate_id")
  @OneToOne(targetEntity = RCRepairEvaluateImpl.class, cascade = CascadeType.ALL)
  private RCRepairEvaluate repairEvaluate;
  
  public RCRepairEvaluate getRepairEvaluate() {
    return this.repairEvaluate;
  }
  
  public RCRepairTask setRepairEvaluate(final RCRepairEvaluate repairEvaluate) {
    this.repairEvaluate = repairEvaluate;
    return this;			
    
  }
  
  public void attachToSettlement(final RCSettlement settlement) {
    this.settlement = settlement;
  }
  
  public void cancelSettlement() {
    this.settlement = null;
  }
  
  public Boolean isEnd() {
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(this.activeGroupTask, null));
    if (!_notEquals) {
      _and = false;
    } else {
      Boolean _isEnd = this.activeGroupTask.isEnd();
      _and = (_notEquals && (_isEnd).booleanValue());
    }
    return Boolean.valueOf(_and);
  }
  
  public Collection<RCWorkItemStorage> getStorage() {
    final Function1<RCGroupTask,Collection<RCWorkItemStorage>> _function = new Function1<RCGroupTask,Collection<RCWorkItemStorage>>() {
        public Collection<RCWorkItemStorage> apply(final RCGroupTask it) {
          Collection<RCWorkItemStorage> _storage = it.getStorage();
          return _storage;
        }
      };
    Iterable<Collection<RCWorkItemStorage>> _map = IterableExtensions.<RCGroupTask, Collection<RCWorkItemStorage>>map(this.groupTasks, _function);
    Iterable<RCWorkItemStorage> _flatten = Iterables.<RCWorkItemStorage>concat(_map);
    List<RCWorkItemStorage> _list = IterableExtensions.<RCWorkItemStorage>toList(_flatten);
    return _list;
  }
  
  public RCTaskDirtyManager getTaskDirtyManager() {
    BeanFactory _beanFactory = this.getBeanFactory();
    RCTaskDirtyManager _bean = _beanFactory.<RCTaskDirtyManager>getBean(RCTaskDirtyManager.class);
    return _bean;
  }
  
  public RCComplaint createCompaint() {
    RCComplaint _createAndAddtoComplaints = this.createAndAddtoComplaints();
    return _createAndAddtoComplaints;
  }
  
  public Double getAmount() {
    final Function1<RCGroupTask,Double> _function = new Function1<RCGroupTask,Double>() {
        public Double apply(final RCGroupTask it) {
          Double _amount = it.getAmount();
          return _amount;
        }
      };
    Iterable<Double> _map = IterableExtensions.<RCGroupTask, Double>map(this.groupTasks, _function);
    final Function2<Double,Double,Double> _function_1 = new Function2<Double,Double,Double>() {
        public Double apply(final Double d1, final Double d2) {
          double _plus = DoubleExtensions.operator_plus(d1, d2);
          return Double.valueOf(_plus);
        }
      };
    Double _reduce = IterableExtensions.<Double>reduce(_map, _function_1);
    Double _nullsafe = NumberExtensions.nullsafe(_reduce);
    return _nullsafe;
  }
  
  public Boolean isColsed() {
    RCRepairTaskStatus _status = this.getStatus();
    String _name = _status.name();
    boolean _equals = _name.equals("closed");
    return Boolean.valueOf(_equals);
  }
  
  public void updateDerived() {
    Month _month = DateUtil.getMonth(this.reportDate);
    String _serialize = _month.serialize();
    this.month = _serialize;
  }
  
  public Collection<? extends IDocument> getDocuments() {
    final Function1<RCGroupTask,Collection<RCWorkItemTask>> _function = new Function1<RCGroupTask,Collection<RCWorkItemTask>>() {
        public Collection<RCWorkItemTask> apply(final RCGroupTask it) {
          Collection<RCWorkItemTask> _tasks = it.getTasks();
          return _tasks;
        }
      };
    Iterable<Collection<RCWorkItemTask>> _map = IterableExtensions.<RCGroupTask, Collection<RCWorkItemTask>>map(this.groupTasks, _function);
    Iterable<RCWorkItemTask> _flatten = Iterables.<RCWorkItemTask>concat(_map);
    final Function1<RCWorkItemTask,Collection<RCWorkItemPicture>> _function_1 = new Function1<RCWorkItemTask,Collection<RCWorkItemPicture>>() {
        public Collection<RCWorkItemPicture> apply(final RCWorkItemTask it) {
          Collection<RCWorkItemPicture> _documents = it.getDocuments();
          return _documents;
        }
      };
    Iterable<Collection<RCWorkItemPicture>> _map_1 = IterableExtensions.<RCWorkItemTask, Collection<RCWorkItemPicture>>map(_flatten, _function_1);
    Iterable<RCWorkItemPicture> _flatten_1 = Iterables.<RCWorkItemPicture>concat(_map_1);
    List<RCWorkItemPicture> _list = IterableExtensions.<RCWorkItemPicture>toList(_flatten_1);
    return _list;
  }
  
  public static RCRepairTask create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.domain.RCRepairTask rCRepairTask = new com.fudanmed.platform.core.domain.impl.RCRepairTaskImpl(
    );
    objectFactory.create(rCRepairTask);
    return rCRepairTask;			
    
  }
  
  public RCRepairTaskProxy toProxy() {
    com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy proxy = new com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
