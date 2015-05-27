package edu.fudan.langlab.domain.workflow.impl;

import edu.fudan.langlab.domain.workflow.ForkStatus;
import edu.fudan.langlab.domain.workflow.proxy.ForkStatusProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("FORKSTATUS_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "forkstatus")
public class ForkStatusImpl extends BaseModelObject implements ForkStatus {
  public ForkStatusImpl() {
    super();
  }
  
  public ForkStatusImpl(final String joinPoint) {
    super();
    this.joinPoint = joinPoint;
  }
  
  private Integer activeActivities = Integer.valueOf(0);
  
  public Integer getActiveActivities() {
    return this.activeActivities;
  }
  
  public ForkStatus setActiveActivities(final Integer activeActivities) {
    this.activeActivities = activeActivities;
    return this;			
    
  }
  
  private String joinPoint;
  
  public String getJoinPoint() {
    return this.joinPoint;
  }
  
  public ForkStatus setJoinPoint(final String joinPoint) {
    this.joinPoint = joinPoint;
    return this;			
    
  }
  
  public static ForkStatus create(final String joinPoint, final IObjectFactory objectFactory) {
    edu.fudan.langlab.domain.workflow.ForkStatus forkStatus = new edu.fudan.langlab.domain.workflow.impl.ForkStatusImpl(
    	joinPoint
    );
    objectFactory.create(forkStatus);
    return forkStatus;			
    
  }
  
  public ForkStatusProxy toProxy() {
    edu.fudan.langlab.domain.workflow.proxy.ForkStatusProxy proxy = new edu.fudan.langlab.domain.workflow.proxy.ForkStatusProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
