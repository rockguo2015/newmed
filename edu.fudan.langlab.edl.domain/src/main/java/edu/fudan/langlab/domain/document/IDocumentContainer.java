package edu.fudan.langlab.domain.document;

import com.google.gwt.user.client.rpc.IsSerializable;
import edu.fudan.langlab.domain.document.IDocument;
import edu.fudan.langlab.domain.document.IHasDocuments;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public interface IDocumentContainer extends IsSerializable, IHasDocuments {
  public abstract IDocument createDocument(final Procedure1<? super IDocument> init);
  
  public abstract void removeDocument(final IDocument document);
  
  public abstract Object toProxy();
}
