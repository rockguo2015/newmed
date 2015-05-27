package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLRoutineProtocal;
import com.fudanmed.platform.core.deliver.DLTaskProtocalSource;
import com.fudanmed.platform.core.deliver.impl.DLRoutineProtocalImpl;
import com.fudanmed.platform.core.deliver.impl.DLTaskSourceImpl;
import com.fudanmed.platform.core.deliver.proxy.DLTaskProtocalSourceProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("DLTASKPROTOCALSOURCE_TYPE")
public class DLTaskProtocalSourceImpl extends DLTaskSourceImpl implements DLTaskProtocalSource {
  public DLTaskProtocalSourceImpl() {
    super();
  }
  
  @JoinColumn(name = "protocal_id")
  @ManyToOne(targetEntity = DLRoutineProtocalImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private DLRoutineProtocal protocal;
  
  public DLRoutineProtocal getProtocal() {
    return this.protocal;
  }
  
  public DLTaskProtocalSource setProtocal(final DLRoutineProtocal protocal) {
    this.protocal = protocal;
    return this;			
    
  }
  
  public String getEntityName() {
    return "\u5468\u671F\u4EFB\u52A1";
  }
  
  public static DLTaskProtocalSource create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLTaskProtocalSource dLTaskProtocalSource = new com.fudanmed.platform.core.deliver.impl.DLTaskProtocalSourceImpl(
    );
    objectFactory.create(dLTaskProtocalSource);
    return dLTaskProtocalSource;			
    
  }
  
  public DLTaskProtocalSourceProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLTaskProtocalSourceProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLTaskProtocalSourceProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
