package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCReporterDirtyRecord;
import com.fudanmed.platform.core.domain.proxy.RCReporterDirtyRecordProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCREPORTERDIRTYRECORD_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcreporterdirtyrecord")
public class RCReporterDirtyRecordImpl extends BaseModelObject implements RCReporterDirtyRecord {
  public RCReporterDirtyRecordImpl() {
    super();
  }
  
  private Boolean isDirty;
  
  public Boolean getIsDirty() {
    return this.isDirty;
  }
  
  public RCReporterDirtyRecord setIsDirty(final Boolean isDirty) {
    this.isDirty = isDirty;
    return this;			
    
  }
  
  public static RCReporterDirtyRecord create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.domain.RCReporterDirtyRecord rCReporterDirtyRecord = new com.fudanmed.platform.core.domain.impl.RCReporterDirtyRecordImpl(
    );
    objectFactory.create(rCReporterDirtyRecord);
    return rCReporterDirtyRecord;			
    
  }
  
  public RCReporterDirtyRecordProxy toProxy() {
    com.fudanmed.platform.core.domain.proxy.RCReporterDirtyRecordProxy proxy = new com.fudanmed.platform.core.domain.proxy.RCReporterDirtyRecordProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
