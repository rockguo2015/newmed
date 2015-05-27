package com.fudanmed.platform.core.deliver;

import com.fudanmed.platform.core.deliver.DLTaskSource;
import com.fudanmed.platform.core.deliver.impl.DLTaskSource4HISImportImpl;
import com.fudanmed.platform.core.deliver.proxy.DLTaskSource4HISImportProxy;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = DLTaskSource4HISImportImpl.class)
public interface DLTaskSource4HISImport extends DLTaskSource {
  public abstract String getImportBatchId();
  
  public abstract DLTaskSource4HISImport setImportBatchId(final String importBatchId);
  
  public abstract String getEntityName();
  
  public abstract DLTaskSource4HISImportProxy toProxy();
}
