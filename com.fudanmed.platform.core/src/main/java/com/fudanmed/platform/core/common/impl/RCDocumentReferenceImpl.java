package com.fudanmed.platform.core.common.impl;

import com.fudanmed.platform.core.common.RCDocument;
import com.fudanmed.platform.core.common.RCDocumentReference;
import com.fudanmed.platform.core.common.proxy.RCDocumentReferenceProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCDOCUMENTREFERENCE_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcdocumentreference")
public class RCDocumentReferenceImpl extends BaseModelObject implements RCDocumentReference {
  public RCDocumentReferenceImpl() {
    super();
  }
  
  public RCDocumentReferenceImpl(final RCDocument document) {
    super();
    this.document = document;
  }
  
  private RCDocument document;
  
  public RCDocument getDocument() {
    return this.document;
  }
  
  public RCDocumentReference setDocument(final RCDocument document) {
    this.document = document;
    return this;			
    
  }
  
  private String className;
  
  public String getClassName() {
    return this.className;
  }
  
  public RCDocumentReference setClassName(final String className) {
    this.className = className;
    return this;			
    
  }
  
  private Long objectId;
  
  public Long getObjectId() {
    return this.objectId;
  }
  
  public RCDocumentReference setObjectId(final Long objectId) {
    this.objectId = objectId;
    return this;			
    
  }
  
  public static RCDocumentReference create(final RCDocument document, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.common.RCDocumentReference rCDocumentReference = new com.fudanmed.platform.core.common.impl.RCDocumentReferenceImpl(
    	document
    );
    objectFactory.create(rCDocumentReference);
    return rCDocumentReference;			
    
  }
  
  public RCDocumentReferenceProxy toProxy() {
    com.fudanmed.platform.core.common.proxy.RCDocumentReferenceProxy proxy = new com.fudanmed.platform.core.common.proxy.RCDocumentReferenceProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
