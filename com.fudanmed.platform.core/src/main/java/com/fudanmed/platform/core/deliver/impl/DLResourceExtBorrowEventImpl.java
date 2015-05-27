package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLResource;
import com.fudanmed.platform.core.deliver.DLResourceExtBorrowEvent;
import com.fudanmed.platform.core.deliver.impl.DLResourceEventImpl;
import com.fudanmed.platform.core.deliver.proxy.DLResourceExtBorrowEventProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DLRESOURCEEXTBORROWEVENT_TYPE")
public class DLResourceExtBorrowEventImpl extends DLResourceEventImpl implements DLResourceExtBorrowEvent {
  public DLResourceExtBorrowEventImpl() {
    super();
  }
  
  public DLResourceExtBorrowEventImpl(final DLResource resource) {
    super( resource);
    
  }
  
  private Date dateTime;
  
  public Date getDateTime() {
    return this.dateTime;
  }
  
  public DLResourceExtBorrowEvent setDateTime(final Date dateTime) {
    this.dateTime = dateTime;
    return this;			
    
  }
  
  private Date returnDateTime;
  
  public Date getReturnDateTime() {
    return this.returnDateTime;
  }
  
  public DLResourceExtBorrowEvent setReturnDateTime(final Date returnDateTime) {
    this.returnDateTime = returnDateTime;
    return this;			
    
  }
  
  private Boolean returned = Boolean.valueOf(false);
  
  public Boolean getReturned() {
    return this.returned;
  }
  
  public DLResourceExtBorrowEvent setReturned(final Boolean returned) {
    this.returned = returned;
    return this;			
    
  }
  
  public static DLResourceExtBorrowEvent create(final DLResource resource, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLResourceExtBorrowEvent dLResourceExtBorrowEvent = new com.fudanmed.platform.core.deliver.impl.DLResourceExtBorrowEventImpl(
    	resource
    );
    objectFactory.create(dLResourceExtBorrowEvent);
    return dLResourceExtBorrowEvent;			
    
  }
  
  public DLResourceExtBorrowEventProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLResourceExtBorrowEventProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLResourceExtBorrowEventProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
