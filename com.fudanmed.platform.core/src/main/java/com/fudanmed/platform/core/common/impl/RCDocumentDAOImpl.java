package com.fudanmed.platform.core.common.impl;

import com.fudanmed.platform.core.common.RCDocument;
import com.fudanmed.platform.core.common.RCDocumentDAO;
import com.fudanmed.platform.core.common.RCDocumentReference;
import com.fudanmed.platform.core.common.impl.RCDocumentImpl;
import com.fudanmed.platform.core.common.impl.RCDocumentReferenceImpl;
import edu.fudan.mylang.pf.BaseDAOService;
import edu.fudan.mylang.pf.IModelObject;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.common.RCDocumentDAO")
public class RCDocumentDAOImpl extends BaseDAOService<RCDocument> implements RCDocumentDAO {
  public RCDocument createFor(final IModelObject owner, final Procedure1<? super RCDocument> postInit) {RCDocument rCDocument=RCDocumentImpl.create(getObjectFactory());
    final Procedure1<RCDocument> _function = new Procedure1<RCDocument>() {
        public void apply(final RCDocument document) {RCDocumentReference rCDocumentReference=RCDocumentReferenceImpl.create(document,getObjectFactory());
          final Procedure1<RCDocumentReference> _function = new Procedure1<RCDocumentReference>() {
              public void apply(final RCDocumentReference it) {
                Class<? extends Object> _class = owner.getClass();
                String _name = _class.getName();
                it.setClassName(_name);
                Long _id = owner.getId();
                it.setObjectId(_id);
              }
            };
          ObjectExtensions.<RCDocumentReference>operator_doubleArrow(rCDocumentReference, _function);
          postInit.apply(document);
        }
      };
    RCDocument _doubleArrow = ObjectExtensions.<RCDocument>operator_doubleArrow(rCDocument, _function);
    return _doubleArrow;
  }
}
