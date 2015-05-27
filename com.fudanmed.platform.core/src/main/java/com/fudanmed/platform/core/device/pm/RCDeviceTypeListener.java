package com.fudanmed.platform.core.device.pm;

import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.events.RCDeviceTypeEventsListener;
import com.fudanmed.platform.core.device.pm.RCPMDeviceTypeEntry;
import com.fudanmed.platform.core.device.pm.impl.RCPMDeviceTypeEntryImpl;
import edu.fudan.mylang.pf.IGenericQuery;
import edu.fudan.mylang.pf.event.BaseEntityEventsListener;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.device.pm.RCDeviceTypeListener")
public class RCDeviceTypeListener extends BaseEntityEventsListener<RCDeviceType> implements RCDeviceTypeEventsListener {
  public void entityCreated(final RCDeviceType entity) {RCPMDeviceTypeEntry rCPMDeviceTypeEntry=RCPMDeviceTypeEntryImpl.create(getObjectFactory());
    final Procedure1<RCPMDeviceTypeEntry> _function = new Procedure1<RCPMDeviceTypeEntry>() {
        public void apply(final RCPMDeviceTypeEntry it) {
          it.setDeviceType(entity);
        }
      };
    ObjectExtensions.<RCPMDeviceTypeEntry>operator_doubleArrow(rCPMDeviceTypeEntry, _function);
  }
  
  public void entityDeleted(final RCDeviceType entity) {
    IGenericQuery<RCPMDeviceTypeEntry> query=getObjectFactory().createGenericQuery(RCPMDeviceTypeEntry.class,"select e from com.fudanmed.platform.core.device.pm.impl.RCPMDeviceTypeEntryImpl as e   where (e.deviceType = :entity) and  e.active = 1      ").setParameter("entity",entity);
    Collection<RCPMDeviceTypeEntry> _list = query.list();
    final Procedure1<RCPMDeviceTypeEntry> _function = new Procedure1<RCPMDeviceTypeEntry>() {
        public void apply(final RCPMDeviceTypeEntry it) {getObjectFactory().delete(it);
          
        }
      };
    IterableExtensions.<RCPMDeviceTypeEntry>forEach(_list, _function);
  }
}
