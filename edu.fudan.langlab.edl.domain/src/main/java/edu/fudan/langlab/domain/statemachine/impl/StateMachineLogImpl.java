package edu.fudan.langlab.domain.statemachine.impl;

import edu.fudan.langlab.domain.statemachine.StateMachineLog;
import edu.fudan.langlab.domain.statemachine.proxy.StateMachineLogProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Date;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("STATEMACHINELOG_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "statemachinelog")
public class StateMachineLogImpl extends BaseModelObject implements StateMachineLog {
  public StateMachineLogImpl() {
    super();
  }
  
  private String type;
  
  public String getType() {
    return this.type;
  }
  
  public StateMachineLog setType(final String type) {
    this.type = type;
    return this;			
    
  }
  
  private Long targetid;
  
  public Long getTargetid() {
    return this.targetid;
  }
  
  public StateMachineLog setTargetid(final Long targetid) {
    this.targetid = targetid;
    return this;			
    
  }
  
  private String smid;
  
  public String getSmid() {
    return this.smid;
  }
  
  public StateMachineLog setSmid(final String smid) {
    this.smid = smid;
    return this;			
    
  }
  
  private Date date;
  
  public Date getDate() {
    return this.date;
  }
  
  public StateMachineLog setDate(final Date date) {
    this.date = date;
    return this;			
    
  }
  
  private String actionName;
  
  public String getActionName() {
    return this.actionName;
  }
  
  public StateMachineLog setActionName(final String actionName) {
    this.actionName = actionName;
    return this;			
    
  }
  
  public static StateMachineLog create(final IObjectFactory objectFactory) {
    edu.fudan.langlab.domain.statemachine.StateMachineLog stateMachineLog = new edu.fudan.langlab.domain.statemachine.impl.StateMachineLogImpl(
    );
    objectFactory.create(stateMachineLog);
    return stateMachineLog;			
    
  }
  
  public StateMachineLogProxy toProxy() {
    edu.fudan.langlab.domain.statemachine.proxy.StateMachineLogProxy proxy = new edu.fudan.langlab.domain.statemachine.proxy.StateMachineLogProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
