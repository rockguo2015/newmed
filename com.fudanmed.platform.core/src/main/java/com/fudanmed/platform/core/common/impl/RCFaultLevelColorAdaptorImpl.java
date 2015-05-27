package com.fudanmed.platform.core.common.impl;

import com.fudanmed.platform.core.common.RCFaultLevel;
import com.fudanmed.platform.core.common.RCFaultLevelColorAdaptor;
import com.fudanmed.platform.core.common.RCStandardColor;
import com.fudanmed.platform.core.common.impl.RCFaultLevelImpl;
import com.fudanmed.platform.core.common.proxy.RCFaultLevelColorAdaptorProxy;
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
@DiscriminatorValue("RCFAULTLEVELCOLORADAPTOR_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcfaultlevelcoloradaptor")
public class RCFaultLevelColorAdaptorImpl extends BaseModelObject implements RCFaultLevelColorAdaptor {
  public RCFaultLevelColorAdaptorImpl() {
    super();
  }
  
  private RCStandardColor color;
  
  public RCStandardColor getColor() {
    return this.color;
  }
  
  public RCFaultLevelColorAdaptor setColor(final RCStandardColor color) {
    this.color = color;
    return this;			
    
  }
  
  @JoinColumn(name = "faultLevel_id")
  @ManyToOne(targetEntity = RCFaultLevelImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCFaultLevel faultLevel;
  
  public RCFaultLevel getFaultLevel() {
    return this.faultLevel;
  }
  
  public RCFaultLevelColorAdaptor setFaultLevel(final RCFaultLevel faultLevel) {
    this.faultLevel = faultLevel;
    return this;			
    
  }
  
  public static RCFaultLevelColorAdaptor create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.common.RCFaultLevelColorAdaptor rCFaultLevelColorAdaptor = new com.fudanmed.platform.core.common.impl.RCFaultLevelColorAdaptorImpl(
    );
    objectFactory.create(rCFaultLevelColorAdaptor);
    return rCFaultLevelColorAdaptor;			
    
  }
  
  public RCFaultLevelColorAdaptorProxy toProxy() {
    com.fudanmed.platform.core.common.proxy.RCFaultLevelColorAdaptorProxy proxy = new com.fudanmed.platform.core.common.proxy.RCFaultLevelColorAdaptorProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
