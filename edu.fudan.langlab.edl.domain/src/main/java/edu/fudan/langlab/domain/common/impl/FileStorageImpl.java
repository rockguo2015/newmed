package edu.fudan.langlab.domain.common.impl;

import edu.fudan.langlab.domain.common.FileStorage;
import edu.fudan.langlab.domain.common.proxy.FileStorageProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import java.sql.Blob;
import java.util.Date;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("FILESTORAGE_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "filestorage")
public class FileStorageImpl extends BaseModelObject implements FileStorage {
  public FileStorageImpl() {
    super();
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public FileStorage setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  private String contentType;
  
  public String getContentType() {
    return this.contentType;
  }
  
  public FileStorage setContentType(final String contentType) {
    this.contentType = contentType;
    return this;			
    
  }
  
  private Blob content;
  
  public Blob getContent() {
    return this.content;
  }
  
  public FileStorage setContent(final Blob content) {
    this.content = content;
    return this;			
    
  }
  
  private Date uploadTime;
  
  public Date getUploadTime() {
    return this.uploadTime;
  }
  
  public FileStorage setUploadTime(final Date uploadTime) {
    this.uploadTime = uploadTime;
    return this;			
    
  }
  
  public String getEntityName() {
    return this.name;
  }
  
  public static FileStorage create(final IObjectFactory objectFactory) {
    edu.fudan.langlab.domain.common.FileStorage fileStorage = new edu.fudan.langlab.domain.common.impl.FileStorageImpl(
    );
    objectFactory.create(fileStorage);
    return fileStorage;			
    
  }
  
  public FileStorageProxy toProxy() {
    edu.fudan.langlab.domain.common.proxy.FileStorageProxy proxy = new edu.fudan.langlab.domain.common.proxy.FileStorageProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
