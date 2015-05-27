package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCDirtyRecord;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.impl.RCMaintenanceTeamImpl;
import com.fudanmed.platform.core.domain.proxy.RCDirtyRecordProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCDIRTYRECORD_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcdirtyrecord")
public class RCDirtyRecordImpl extends BaseModelObject implements RCDirtyRecord {
  public RCDirtyRecordImpl() {
    super();
  }
  
  @JoinColumn(name = "team_id")
  @ManyToOne(targetEntity = RCMaintenanceTeamImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCMaintenanceTeam team;
  
  public RCMaintenanceTeam getTeam() {
    return this.team;
  }
  
  public RCDirtyRecord setTeam(final RCMaintenanceTeam team) {
    this.team = team;
    return this;			
    
  }
  
  private Boolean isDirty4Team;
  
  public Boolean getIsDirty4Team() {
    return this.isDirty4Team;
  }
  
  public RCDirtyRecord setIsDirty4Team(final Boolean isDirty4Team) {
    this.isDirty4Team = isDirty4Team;
    return this;			
    
  }
  
  private Boolean isDirty4Scheduler;
  
  public Boolean getIsDirty4Scheduler() {
    return this.isDirty4Scheduler;
  }
  
  public RCDirtyRecord setIsDirty4Scheduler(final Boolean isDirty4Scheduler) {
    this.isDirty4Scheduler = isDirty4Scheduler;
    return this;			
    
  }
  
  public void refreshed4Team() {
    this.isDirty4Team = Boolean.valueOf(false);
  }
  
  public void notify4Team() {
    this.isDirty4Team = Boolean.valueOf(true);
  }
  
  public void refreshed4Scheduler() {
    this.isDirty4Scheduler = Boolean.valueOf(false);
  }
  
  public void notify4Scheduler() {
    this.isDirty4Scheduler = Boolean.valueOf(true);
  }
  
  public static RCDirtyRecord create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.domain.RCDirtyRecord rCDirtyRecord = new com.fudanmed.platform.core.domain.impl.RCDirtyRecordImpl(
    );
    objectFactory.create(rCDirtyRecord);
    return rCDirtyRecord;			
    
  }
  
  public RCDirtyRecordProxy toProxy() {
    com.fudanmed.platform.core.domain.proxy.RCDirtyRecordProxy proxy = new com.fudanmed.platform.core.domain.proxy.RCDirtyRecordProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
