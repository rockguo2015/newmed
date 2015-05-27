package com.fudanmed.platform.core.common.impl;

import com.fudanmed.platform.core.common.RCFaultReportSource;
import com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy;
import edu.fudan.langlab.domain.code.impl.CodeImpl;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RCFAULTREPORTSOURCE_TYPE")
public class RCFaultReportSourceImpl extends CodeImpl implements RCFaultReportSource {
  public RCFaultReportSourceImpl() {
    super();
  }
  
  public static RCFaultReportSource create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.common.RCFaultReportSource rCFaultReportSource = new com.fudanmed.platform.core.common.impl.RCFaultReportSourceImpl(
    );
    objectFactory.create(rCFaultReportSource);
    return rCFaultReportSource;			
    
  }
  
  public RCFaultReportSourceProxy toProxy() {
    com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy proxy = new com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
