package com.fudanmed.platform.core.common;

import com.fudanmed.platform.core.common.RCDocument;
import com.fudanmed.platform.core.common.impl.RCDocumentReferenceImpl;
import com.fudanmed.platform.core.common.proxy.RCDocumentReferenceProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;

@EntityImplementation(implementBy = RCDocumentReferenceImpl.class)
public interface RCDocumentReference extends IModelObject {
  public abstract RCDocument getDocument();
  
  public abstract RCDocumentReference setDocument(final RCDocument document);
  
  public abstract String getClassName();
  
  public abstract RCDocumentReference setClassName(final String className);
  
  public abstract Long getObjectId();
  
  public abstract RCDocumentReference setObjectId(final Long objectId);
  
  public abstract RCDocumentReferenceProxy toProxy();
}
