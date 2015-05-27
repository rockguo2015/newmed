package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLDeliverSubject;
import com.fudanmed.platform.core.deliver.DLScheduleCenter;
import com.fudanmed.platform.core.deliver.DLTaskConsumer;
import com.fudanmed.platform.core.deliver.proxy.DLScheduleCenterProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("DLSCHEDULECENTER_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "dlschedulecenter")
public class DLScheduleCenterImpl extends BaseModelObject implements DLScheduleCenter {
  public DLScheduleCenterImpl() {
    super();
  }
  
  public void forwardTo(final DLTaskConsumer consumer, final DLDeliverSubject subject) {
  }
  
  public static DLScheduleCenter create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLScheduleCenter dLScheduleCenter = new com.fudanmed.platform.core.deliver.impl.DLScheduleCenterImpl(
    );
    objectFactory.create(dLScheduleCenter);
    return dLScheduleCenter;			
    
  }
  
  public DLScheduleCenterProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLScheduleCenterProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLScheduleCenterProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
