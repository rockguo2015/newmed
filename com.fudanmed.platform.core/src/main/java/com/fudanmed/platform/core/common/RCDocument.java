package com.fudanmed.platform.core.common;

import com.fudanmed.platform.core.common.impl.RCDocumentImpl;
import com.fudanmed.platform.core.common.proxy.RCDocumentProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import java.sql.Blob;

@EntityImplementation(implementBy = RCDocumentImpl.class)
public interface RCDocument extends IModelObject {
  public abstract String getDescription();
  
  public abstract RCDocument setDescription(final String description);
  
  public abstract String getFileName();
  
  public abstract RCDocument setFileName(final String fileName);
  
  public abstract String getContentType();
  
  public abstract RCDocument setContentType(final String contentType);
  
  public abstract Integer getRefCount();
  
  public abstract RCDocument setRefCount(final Integer refCount);
  
  public abstract Blob getFile();
  
  public abstract RCDocument setFile(final Blob file);
  
  public abstract RCDocumentProxy toProxy();
}
