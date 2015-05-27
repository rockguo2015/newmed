package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLWeekDay;
import com.fudanmed.platform.core.deliver.DLWeeklyRoutineProtocal;
import com.fudanmed.platform.core.deliver.impl.DLRoutineProtocalImpl;
import com.fudanmed.platform.core.deliver.proxy.DLWeeklyRoutineProtocalProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DLWEEKLYROUTINEPROTOCAL_TYPE")
public class DLWeeklyRoutineProtocalImpl extends DLRoutineProtocalImpl implements DLWeeklyRoutineProtocal {
  public DLWeeklyRoutineProtocalImpl() {
    super();
  }
  
  @ElementCollection
  private Collection<DLWeekDay> weekdays = new java.util.ArrayList<com.fudanmed.platform.core.deliver.DLWeekDay>();;
  
  public Collection<DLWeekDay> getWeekdays() {
    return this.weekdays;
  }
  
  public DLWeeklyRoutineProtocal setWeekdays(final Iterable<DLWeekDay> weekdays) {
    removeAllWeekdays();
    for(DLWeekDay ca : weekdays){
    	addtoWeekdays(ca);
    }
    return this;		
    
  }
  
  public DLWeeklyRoutineProtocal addtoWeekdays(final DLWeekDay dLWeekDay) {
    this.weekdays.add(dLWeekDay);
    return this;
    
  }
  
  public DLWeeklyRoutineProtocal removeAllWeekdays() {
    this.weekdays.clear();
    return this;	
    
  }
  
  public DLWeeklyRoutineProtocal removeFromWeekdays(final DLWeekDay dLWeekDay) {
    this.weekdays.remove(dLWeekDay);
    return this;
    
  }
  
  public void generateTasks(final Date fromDate, final Date toDate) {
  }
  
  public static DLWeeklyRoutineProtocal create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLWeeklyRoutineProtocal dLWeeklyRoutineProtocal = new com.fudanmed.platform.core.deliver.impl.DLWeeklyRoutineProtocalImpl(
    );
    objectFactory.create(dLWeeklyRoutineProtocal);
    return dLWeeklyRoutineProtocal;			
    
  }
  
  public DLWeeklyRoutineProtocalProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLWeeklyRoutineProtocalProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLWeeklyRoutineProtocalProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
