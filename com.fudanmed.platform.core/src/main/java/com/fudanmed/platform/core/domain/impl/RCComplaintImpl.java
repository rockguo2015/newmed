package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCComplaint;
import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.impl.RCEmployeeImpl;
import com.fudanmed.platform.core.domain.impl.RCRepairTaskImpl;
import com.fudanmed.platform.core.domain.proxy.RCComplaintProxy;
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

@Entity
@DiscriminatorValue("RCCOMPLAINT_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rccomplaint")
public class RCComplaintImpl extends BaseModelObject implements RCComplaint {
  public RCComplaintImpl() {
    super();
  }
  
  public RCComplaintImpl(final RCRepairTask repairTask) {
    super();
    this.repairTask = repairTask;
  }
  
  @JoinColumn(name = "repairTask_id")
  @ManyToOne(targetEntity = RCRepairTaskImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCRepairTask repairTask;
  
  public RCRepairTask getRepairTask() {
    return this.repairTask;
  }
  
  public RCComplaint setRepairTask(final RCRepairTask repairTask) {
    this.repairTask = repairTask;
    return this;			
    
  }
  
  private Date date;
  
  public Date getDate() {
    return this.date;
  }
  
  public RCComplaint setDate(final Date date) {
    this.date = date;
    return this;			
    
  }
  
  private String contents;
  
  public String getContents() {
    return this.contents;
  }
  
  public RCComplaint setContents(final String contents) {
    this.contents = contents;
    return this;			
    
  }
  
  @JoinColumn(name = "owner_id")
  @ManyToOne(targetEntity = RCEmployeeImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCEmployee owner;
  
  public RCEmployee getOwner() {
    return this.owner;
  }
  
  public RCComplaint setOwner(final RCEmployee owner) {
    this.owner = owner;
    return this;			
    
  }
  
  public static RCComplaint create(final RCRepairTask repairTask, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.domain.RCComplaint rCComplaint = new com.fudanmed.platform.core.domain.impl.RCComplaintImpl(
    	repairTask
    );
    objectFactory.create(rCComplaint);
    return rCComplaint;			
    
  }
  
  public RCComplaintProxy toProxy() {
    com.fudanmed.platform.core.domain.proxy.RCComplaintProxy proxy = new com.fudanmed.platform.core.domain.proxy.RCComplaintProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
