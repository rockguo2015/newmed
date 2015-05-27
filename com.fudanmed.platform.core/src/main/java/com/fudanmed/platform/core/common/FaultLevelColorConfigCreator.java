package com.fudanmed.platform.core.common;

import com.fudanmed.platform.core.common.RCFaultLevel;
import com.fudanmed.platform.core.common.RCFaultLevelColorAdaptor;
import com.fudanmed.platform.core.common.RCStandardColor;
import com.fudanmed.platform.core.common.impl.RCFaultLevelColorAdaptorImpl;
import edu.fudan.langlab.domain.code.Code;
import edu.fudan.langlab.domain.code.events.CodeEventsListener;
import edu.fudan.mylang.pf.IGenericQuery;
import edu.fudan.mylang.pf.event.BaseEntityEventsListener;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.common.FaultLevelColorConfigCreator")
public class FaultLevelColorConfigCreator extends BaseEntityEventsListener<Code> implements CodeEventsListener {
  public void entityCreated(final Code entity) {
    if ((entity instanceof RCFaultLevel)) {RCFaultLevelColorAdaptor rCFaultLevelColorAdaptor=RCFaultLevelColorAdaptorImpl.create(getObjectFactory());
      final Procedure1<RCFaultLevelColorAdaptor> _function = new Procedure1<RCFaultLevelColorAdaptor>() {
          public void apply(final RCFaultLevelColorAdaptor it) {
            it.setColor(RCStandardColor.black);
            it.setFaultLevel(((RCFaultLevel) entity));
          }
        };
      ObjectExtensions.<RCFaultLevelColorAdaptor>operator_doubleArrow(rCFaultLevelColorAdaptor, _function);
    }
  }
  
  public void entityDeleted(final Code entity) {
    if ((entity instanceof RCFaultLevel)) {
      final RCFaultLevel d = ((RCFaultLevel) entity);
      IGenericQuery<RCFaultLevelColorAdaptor> query=getObjectFactory().createGenericQuery(RCFaultLevelColorAdaptor.class,"select e from com.fudanmed.platform.core.common.impl.RCFaultLevelColorAdaptorImpl as e   where (e.faultLevel = :d) and  e.active = 1      ").setParameter("d",d);
      final RCFaultLevelColorAdaptor toDelete = query.uniqueResult();getObjectFactory().delete(toDelete);
      
    }
  }
}
