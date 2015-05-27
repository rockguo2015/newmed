package com.fudanmed.platform.core.common.impl;

import com.fudanmed.platform.core.common.RCDocument;
import com.fudanmed.platform.core.common.proxy.RCDocumentProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import java.sql.Blob;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("RCDOCUMENT_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "rcdocument")
public class RCDocumentImpl extends BaseModelObject implements RCDocument {
  public RCDocumentImpl() {
    super();
  }
  
  private String description;
  
  public String getDescription() {
    return this.description;
  }
  
  public RCDocument setDescription(final String description) {
    this.description = description;
    return this;			
    
  }
  
  private String fileName;
  
  public String getFileName() {
    return this.fileName;
  }
  
  public RCDocument setFileName(final String fileName) {
    this.fileName = fileName;
    return this;			
    
  }
  
  private String contentType;
  
  public String getContentType() {
    return this.contentType;
  }
  
  public RCDocument setContentType(final String contentType) {
    this.contentType = contentType;
    return this;			
    
  }
  
  private Integer refCount;
  
  public Integer getRefCount() {
    return this.refCount;
  }
  
  public RCDocument setRefCount(final Integer refCount) {
    this.refCount = refCount;
    return this;			
    
  }
  
  private Blob file;
  
  public Blob getFile() {
    return this.file;
  }
  
  public RCDocument setFile(final Blob file) {
    this.file = file;
    return this;			
    
  }
  
  public static RCDocument create(final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.common.RCDocument rCDocument = new com.fudanmed.platform.core.common.impl.RCDocumentImpl(
    );
    objectFactory.create(rCDocument);
    return rCDocument;			
    
  }
  
  public RCDocumentProxy toProxy() {
    com.fudanmed.platform.core.common.proxy.RCDocumentProxy proxy = new com.fudanmed.platform.core.common.proxy.RCDocumentProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
