package edu.fudan.langlab.domain.document;

import com.google.gwt.user.client.rpc.IsSerializable;
import edu.fudan.langlab.domain.document.IDocument;
import java.util.Collection;

public interface IHasDocuments extends IsSerializable {
  public abstract Collection<? extends IDocument> getDocuments();
  
  public abstract Object toProxy();
}
