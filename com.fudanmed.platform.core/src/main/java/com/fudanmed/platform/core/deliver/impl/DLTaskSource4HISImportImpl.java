package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLTaskSource4HISImport;
import com.fudanmed.platform.core.deliver.impl.DLTaskSourceImpl;
import com.fudanmed.platform.core.deliver.proxy.DLTaskSource4HISImportProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DLTASKSOURCE4HISIMPORT_TYPE")
public class DLTaskSource4HISImportImpl extends DLTaskSourceImpl implements DLTaskSource4HISImport {
  public DLTaskSource4HISImportImpl() {
    super();
  }
  
  private String importBatchId;
  
  public String getImportBatchId() {
    return this.importBatchId;
  }
  
  public DLTaskSource4HISImport setImportBatchId(final String importBatchId) {
    this.importBatchId = importBatchId;
    return this;			
    
  }
  
  public String getEntityName() {
    return "HIS\u7CFB\u7EDF\u5BFC\u5165";
  }
  
  public static DLTaskSource4HISImport create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.deliver.DLTaskSource4HISImport dLTaskSource4HISImport = new com.fudanmed.platform.core.deliver.impl.DLTaskSource4HISImportImpl(
    );
    objectFactory.create(dLTaskSource4HISImport);
    return dLTaskSource4HISImport;			
    
  }
  
  public DLTaskSource4HISImportProxy toProxy() {
    com.fudanmed.platform.core.deliver.proxy.DLTaskSource4HISImportProxy proxy = new com.fudanmed.platform.core.deliver.proxy.DLTaskSource4HISImportProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
