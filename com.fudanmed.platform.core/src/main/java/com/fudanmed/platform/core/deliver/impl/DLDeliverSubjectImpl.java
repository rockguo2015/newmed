package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLDeliverEmergency;
import com.fudanmed.platform.core.deliver.DLDeliverSubject;
import com.fudanmed.platform.core.deliver.impl.DLDeliverEmergencyImpl;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverSubjectProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("DLDELIVERSUBJECT_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "dldeliversubject")
public abstract class DLDeliverSubjectImpl extends BaseModelObject implements DLDeliverSubject {
  public DLDeliverSubjectImpl() {
    super();
  }
  
  @JoinColumn(name = "emergency_id")
  @ManyToOne(targetEntity = DLDeliverEmergencyImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private DLDeliverEmergency emergency;
  
  public DLDeliverEmergency getEmergency() {
    return this.emergency;
  }
  
  public DLDeliverSubject setEmergency(final DLDeliverEmergency emergency) {
    this.emergency = emergency;
    return this;			
    
  }
  
  public DLDeliverSubjectProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLDeliverSubjectProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLDeliverSubjectProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
