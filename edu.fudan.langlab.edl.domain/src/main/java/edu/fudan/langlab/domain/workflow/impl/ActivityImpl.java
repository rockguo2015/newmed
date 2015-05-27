package edu.fudan.langlab.domain.workflow.impl;

import edu.fudan.langlab.domain.security.User;
import edu.fudan.langlab.domain.security.impl.UserImpl;
import edu.fudan.langlab.domain.workflow.Activity;
import edu.fudan.langlab.domain.workflow.BusinessProcess;
import edu.fudan.langlab.domain.workflow.ProcessManager;
import edu.fudan.langlab.domain.workflow.impl.BusinessProcessImpl;
import edu.fudan.langlab.domain.workflow.proxy.ActivityProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;
import org.springframework.beans.factory.BeanFactory;

@Entity
@DiscriminatorValue("ACTIVITY_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "activity")
public class ActivityImpl extends BaseModelObject implements Activity {
  public ActivityImpl() {
    super();
  }
  
  public ActivityImpl(final BusinessProcess bp) {
    super();
    this.bp = bp;
  }
  
  @JoinColumn(name = "executer_id")
  @ManyToOne(targetEntity = UserImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private User executer;
  
  public User getExecuter() {
    return this.executer;
  }
  
  public Activity setExecuter(final User executer) {
    this.executer = executer;
    return this;			
    
  }
  
  private Date executeDate;
  
  public Date getExecuteDate() {
    return this.executeDate;
  }
  
  public Activity setExecuteDate(final Date executeDate) {
    this.executeDate = executeDate;
    return this;			
    
  }
  
  private String activityName;
  
  public String getActivityName() {
    return this.activityName;
  }
  
  public Activity setActivityName(final String activityName) {
    this.activityName = activityName;
    return this;			
    
  }
  
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public Activity setComment(final String comment) {
    this.comment = comment;
    return this;			
    
  }
  
  @JoinColumn(name = "bp_id")
  @ManyToOne(targetEntity = BusinessProcessImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private BusinessProcess bp;
  
  public BusinessProcess getBp() {
    return this.bp;
  }
  
  public Activity setBp(final BusinessProcess bp) {
    this.bp = bp;
    return this;			
    
  }
  
  public ProcessManager getProcessManager() {
    BeanFactory _beanFactory = this.getBeanFactory();
    ProcessManager _bean = _beanFactory.<ProcessManager>getBean(ProcessManager.class);
    return _bean;
  }
  
  public String getEntityName() {
    return this.comment;
  }
  
  public String toString() {
    String _plus = (this.activityName + ",");
    String _plus_1 = (_plus + this.comment);
    return _plus_1;
  }
  
  public static Activity create(final BusinessProcess bp, final IObjectFactory objectFactory) {
    edu.fudan.langlab.domain.workflow.Activity activity = new edu.fudan.langlab.domain.workflow.impl.ActivityImpl(
    	bp
    );
    objectFactory.create(activity);
    return activity;			
    
  }
  
  public ActivityProxy toProxy() {
    edu.fudan.langlab.domain.workflow.proxy.ActivityProxy proxy = new edu.fudan.langlab.domain.workflow.proxy.ActivityProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
