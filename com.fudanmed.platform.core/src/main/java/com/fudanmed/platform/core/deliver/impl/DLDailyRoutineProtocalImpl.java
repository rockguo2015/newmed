package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLDailyRoutineProtocal;
import com.fudanmed.platform.core.deliver.impl.DLRoutineProtocalImpl;
import com.fudanmed.platform.core.deliver.proxy.DLDailyRoutineProtocalProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DLDAILYROUTINEPROTOCAL_TYPE")
public class DLDailyRoutineProtocalImpl extends DLRoutineProtocalImpl implements DLDailyRoutineProtocal {
  public DLDailyRoutineProtocalImpl() {
    super();
  }
  
  private Date fromDate;
  
  public Date getFromDate() {
    return this.fromDate;
  }
  
  public DLDailyRoutineProtocal setFromDate(final Date fromDate) {
    this.fromDate = fromDate;
    return this;			
    
  }
  
  private Date toDate;
  
  public Date getToDate() {
    return this.toDate;
  }
  
  public DLDailyRoutineProtocal setToDate(final Date toDate) {
    this.toDate = toDate;
    return this;			
    
  }
  
  private Boolean isForever = Boolean.valueOf(false);
  
  public Boolean getIsForever() {
    return this.isForever;
  }
  
  public DLDailyRoutineProtocal setIsForever(final Boolean isForever) {
    this.isForever = isForever;
    return this;			
    
  }
  
  public static DLDailyRoutineProtocal create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLDailyRoutineProtocal dLDailyRoutineProtocal = new com.fudanmed.platform.core.deliver.impl.DLDailyRoutineProtocalImpl(
    );
    objectFactory.create(dLDailyRoutineProtocal);
    return dLDailyRoutineProtocal;			
    
  }
  
  public DLDailyRoutineProtocalProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLDailyRoutineProtocalProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLDailyRoutineProtocalProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
