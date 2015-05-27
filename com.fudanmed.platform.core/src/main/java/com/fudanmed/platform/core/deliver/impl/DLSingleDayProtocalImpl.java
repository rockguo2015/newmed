package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLSingleDayProtocal;
import com.fudanmed.platform.core.deliver.impl.DLRoutineProtocalImpl;
import com.fudanmed.platform.core.deliver.proxy.DLSingleDayProtocalProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DLSINGLEDAYPROTOCAL_TYPE")
public class DLSingleDayProtocalImpl extends DLRoutineProtocalImpl implements DLSingleDayProtocal {
  public DLSingleDayProtocalImpl() {
    super();
  }
  
  private Date date;
  
  public Date getDate() {
    return this.date;
  }
  
  public DLSingleDayProtocal setDate(final Date date) {
    this.date = date;
    return this;			
    
  }
  
  public static DLSingleDayProtocal create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLSingleDayProtocal dLSingleDayProtocal = new com.fudanmed.platform.core.deliver.impl.DLSingleDayProtocalImpl(
    );
    objectFactory.create(dLSingleDayProtocal);
    return dLSingleDayProtocal;			
    
  }
  
  public DLSingleDayProtocalProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLSingleDayProtocalProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLSingleDayProtocalProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
