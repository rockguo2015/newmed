package com.fudanmed.platform.core.common.impl;

import com.fudanmed.platform.core.common.RCEBoardMessage;
import com.fudanmed.platform.core.common.proxy.RCEBoardMessageProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCEBOARDMESSAGE_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rceboardmessage")
public class RCEBoardMessageImpl extends BaseModelObject implements RCEBoardMessage {
  public RCEBoardMessageImpl() {
    super();
  }
  
  @Column(length = 512)
  private String message;
  
  public String getMessage() {
    return this.message;
  }
  
  public RCEBoardMessage setMessage(final String message) {
    this.message = message;
    return this;			
    
  }
  
  public static RCEBoardMessage create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.common.RCEBoardMessage rCEBoardMessage = new com.fudanmed.platform.core.common.impl.RCEBoardMessageImpl(
    );
    objectFactory.create(rCEBoardMessage);
    return rCEBoardMessage;			
    
  }
  
  public RCEBoardMessageProxy toProxy() {
    com.fudanmed.platform.core.common.proxy.RCEBoardMessageProxy proxy = new com.fudanmed.platform.core.common.proxy.RCEBoardMessageProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
