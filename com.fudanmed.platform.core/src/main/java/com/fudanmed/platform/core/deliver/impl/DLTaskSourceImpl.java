package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLTaskSource;
import com.fudanmed.platform.core.deliver.DLTaskSourceType;
import com.fudanmed.platform.core.deliver.proxy.DLTaskSourceProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("DLTASKSOURCE_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "dltasksource")
public class DLTaskSourceImpl extends BaseModelObject implements DLTaskSource {
  public DLTaskSourceImpl() {
    super();
  }
  
  private DLTaskSourceType type;
  
  public DLTaskSourceType getType() {
    return this.type;
  }
  
  public DLTaskSource setType(final DLTaskSourceType type) {
    this.type = type;
    return this;			
    
  }
  
  public static DLTaskSource create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLTaskSource dLTaskSource = new com.fudanmed.platform.core.deliver.impl.DLTaskSourceImpl(
    );
    objectFactory.create(dLTaskSource);
    return dLTaskSource;			
    
  }
  
  public DLTaskSourceProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLTaskSourceProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLTaskSourceProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
