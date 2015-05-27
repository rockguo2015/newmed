package edu.fudan.langlab.domain.document.impl;

import edu.fudan.langlab.domain.document.DocumentStorage;
import edu.fudan.langlab.domain.document.proxy.DocumentStorageProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.util.Date;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.hibernate.LobHelper;
import org.hibernate.Session;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("DOCUMENTSTORAGE_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "documentstorage")
public abstract class DocumentStorageImpl extends BaseModelObject implements DocumentStorage {
  public DocumentStorageImpl() {
    super();
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public DocumentStorage setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  private String contentType;
  
  public String getContentType() {
    return this.contentType;
  }
  
  public DocumentStorage setContentType(final String contentType) {
    this.contentType = contentType;
    return this;			
    
  }
  
  private String fileName;
  
  public String getFileName() {
    return this.fileName;
  }
  
  public DocumentStorage setFileName(final String fileName) {
    this.fileName = fileName;
    return this;			
    
  }
  
  private Blob content;
  
  public Blob getContent() {
    return this.content;
  }
  
  public DocumentStorage setContent(final Blob content) {
    this.content = content;
    return this;			
    
  }
  
  private Date uploadTime;
  
  public Date getUploadTime() {
    return this.uploadTime;
  }
  
  public DocumentStorage setUploadTime(final Date uploadTime) {
    this.uploadTime = uploadTime;
    return this;			
    
  }
  
  public void setFile(final File file) {
    try {
      IObjectFactory _objectFactory = this.getObjectFactory();
      Session _hibernateSession = _objectFactory.getHibernateSession();
      LobHelper _lobHelper = _hibernateSession.getLobHelper();
      FileInputStream _fileInputStream = new FileInputStream(file);
      int _minus = (-1);
      Blob _createBlob = _lobHelper.createBlob(_fileInputStream, _minus);
      this.content = _createBlob;
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException e = (IOException)_t;
        RuntimeException _runtimeException = new RuntimeException(e);
        throw _runtimeException;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public String getEntityName() {
    return this.name;
  }
  
  public DocumentStorageProxy toProxy() {
    edu.fudan.langlab.domain.document.proxy.DocumentStorageProxy proxy = new edu.fudan.langlab.domain.document.proxy.DocumentStorageProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
