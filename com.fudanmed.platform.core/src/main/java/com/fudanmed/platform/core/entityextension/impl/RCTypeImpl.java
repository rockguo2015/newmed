package com.fudanmed.platform.core.entityextension.impl;

import com.fudanmed.platform.core.entityextension.RCType;
import com.fudanmed.platform.core.entityextension.proxy.RCTypeProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCTYPE_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rctype")
public abstract class RCTypeImpl extends BaseModelObject implements RCType {
  public RCTypeImpl() {
    super();
  }
  
  public String getEntityName() {
    String _typeName = this.getTypeName();
    return _typeName;
  }
  
  public RCTypeProxy toProxy() {
    com.fudanmed.platform.core.entityextension.proxy.RCTypeProxy proxy = new com.fudanmed.platform.core.entityextension.proxy.RCTypeProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
