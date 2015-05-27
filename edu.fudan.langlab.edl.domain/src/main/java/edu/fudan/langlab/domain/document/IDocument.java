package edu.fudan.langlab.domain.document;

import com.google.gwt.user.client.rpc.IsSerializable;
import edu.fudan.langlab.domain.document.IDocumentContainer;
import java.sql.Blob;

public interface IDocument extends IsSerializable {
  public abstract String getContentType();
  
  public abstract Blob getContent();
  
  public abstract String getFileName();
  
  public abstract IDocumentContainer getContainer();
  
  public abstract Object toProxy();
}
