package edu.fudan.langlab.domain.common;

import edu.fudan.langlab.domain.common.impl.FileStorageImpl;
import edu.fudan.langlab.domain.common.proxy.FileStorageProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import edu.fudan.mylang.pf.INamedModelObject;
import java.sql.Blob;
import java.util.Date;

@EntityImplementation(implementBy = FileStorageImpl.class)
public interface FileStorage extends IModelObject, INamedModelObject {
  public abstract String getName();
  
  public abstract FileStorage setName(final String name);
  
  public abstract String getContentType();
  
  public abstract FileStorage setContentType(final String contentType);
  
  public abstract Blob getContent();
  
  public abstract FileStorage setContent(final Blob content);
  
  public abstract Date getUploadTime();
  
  public abstract FileStorage setUploadTime(final Date uploadTime);
  
  public abstract String getEntityName();
  
  public abstract FileStorageProxy toProxy();
}
