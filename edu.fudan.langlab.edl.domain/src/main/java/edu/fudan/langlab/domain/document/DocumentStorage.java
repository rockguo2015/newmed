package edu.fudan.langlab.domain.document;

import edu.fudan.langlab.domain.document.IDocument;
import edu.fudan.langlab.domain.document.IDocumentContainer;
import edu.fudan.langlab.domain.document.impl.DocumentStorageImpl;
import edu.fudan.langlab.domain.document.proxy.DocumentStorageProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import edu.fudan.mylang.pf.INamedModelObject;
import java.io.File;
import java.sql.Blob;
import java.util.Date;

@EntityImplementation(implementBy = DocumentStorageImpl.class)
public interface DocumentStorage extends IModelObject, INamedModelObject, IDocument {
  public abstract String getName();
  
  public abstract DocumentStorage setName(final String name);
  
  public abstract String getContentType();
  
  public abstract DocumentStorage setContentType(final String contentType);
  
  public abstract String getFileName();
  
  public abstract DocumentStorage setFileName(final String fileName);
  
  public abstract Blob getContent();
  
  public abstract DocumentStorage setContent(final Blob content);
  
  public abstract Date getUploadTime();
  
  public abstract DocumentStorage setUploadTime(final Date uploadTime);
  
  public abstract void setFile(final File file);
  
  public abstract IDocumentContainer getContainer();
  
  public abstract String getEntityName();
  
  public abstract DocumentStorageProxy toProxy();
}
