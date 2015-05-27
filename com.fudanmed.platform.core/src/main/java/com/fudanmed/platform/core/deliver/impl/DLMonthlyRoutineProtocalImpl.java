package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLMonthlyRoutineProtocal;
import com.fudanmed.platform.core.deliver.impl.DLRoutineProtocalImpl;
import com.fudanmed.platform.core.deliver.proxy.DLMonthlyRoutineProtocalProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DLMONTHLYROUTINEPROTOCAL_TYPE")
public class DLMonthlyRoutineProtocalImpl extends DLRoutineProtocalImpl implements DLMonthlyRoutineProtocal {
  public DLMonthlyRoutineProtocalImpl() {
    super();
  }
  
  @ElementCollection
  private Collection<Integer> days = new java.util.ArrayList<java.lang.Integer>();;
  
  public Collection<Integer> getDays() {
    return this.days;
  }
  
  public DLMonthlyRoutineProtocal setDays(final Iterable<Integer> days) {
    removeAllDays();
    for(Integer ca : days){
    	addtoDays(ca);
    }
    return this;		
    
  }
  
  public DLMonthlyRoutineProtocal addtoDays(final Integer integer) {
    this.days.add(integer);
    return this;
    
  }
  
  public DLMonthlyRoutineProtocal removeAllDays() {
    this.days.clear();
    return this;	
    
  }
  
  public DLMonthlyRoutineProtocal removeFromDays(final Integer integer) {
    this.days.remove(integer);
    return this;
    
  }
  
  private Integer interval;
  
  public Integer getInterval() {
    return this.interval;
  }
  
  public DLMonthlyRoutineProtocal setInterval(final Integer interval) {
    this.interval = interval;
    return this;			
    
  }
  
  public static DLMonthlyRoutineProtocal create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLMonthlyRoutineProtocal dLMonthlyRoutineProtocal = new com.fudanmed.platform.core.deliver.impl.DLMonthlyRoutineProtocalImpl(
    );
    objectFactory.create(dLMonthlyRoutineProtocal);
    return dLMonthlyRoutineProtocal;			
    
  }
  
  public DLMonthlyRoutineProtocalProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLMonthlyRoutineProtocalProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLMonthlyRoutineProtocalProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
