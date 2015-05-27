package com.fudanmed.platform.core.common;

import com.fudanmed.platform.core.common.RCDocument;
import edu.fudan.mylang.pf.IDAOService;
import edu.fudan.mylang.pf.IModelObject;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public interface RCDocumentDAO extends IDAOService<RCDocument> {
  public abstract RCDocument createFor(final IModelObject owner, final Procedure1<? super RCDocument> postInit);
}
