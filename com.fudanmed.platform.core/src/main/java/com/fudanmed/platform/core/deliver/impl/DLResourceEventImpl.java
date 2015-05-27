package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLResource;
import com.fudanmed.platform.core.deliver.DLResourceEvent;
import com.fudanmed.platform.core.deliver.impl.DLResourceImpl;
import com.fudanmed.platform.core.deliver.proxy.DLResourceEventProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("DLRESOURCEEVENT_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "dlresourceevent")
public class DLResourceEventImpl extends BaseModelObject implements DLResourceEvent {
  public DLResourceEventImpl() {
    super();
  }
  
  public DLResourceEventImpl(final DLResource resource) {
    super();
    this.resource = resource;
  }
  
  private Date date;
  
  public Date getDate() {
    return this.date;
  }
  
  public DLResourceEvent setDate(final Date date) {
    this.date = date;
    return this;			
    
  }
  
  private String comment;
  
  public String getComment() {
    return this.comment;
  }
  
  public DLResourceEvent setComment(final String comment) {
    this.comment = comment;
    return this;			
    
  }
  
  @JoinColumn(name = "resource_id")
  @ManyToOne(targetEntity = DLResourceImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private DLResource resource;
  
  public DLResource getResource() {
    return this.resource;
  }
  
  public DLResourceEvent setResource(final DLResource resource) {
    this.resource = resource;
    return this;			
    
  }
  
  public static DLResourceEvent create(final DLResource resource, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLResourceEvent dLResourceEvent = new com.fudanmed.platform.core.deliver.impl.DLResourceEventImpl(
    	resource
    );
    objectFactory.create(dLResourceEvent);
    return dLResourceEvent;			
    
  }
  
  public DLResourceEventProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLResourceEventProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLResourceEventProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
