package com.fudanmed.platform.core.device.pm;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.events.RCDeviceEventsListener;
import com.fudanmed.platform.core.device.pm.RCDevicePMSpecification;
import com.fudanmed.platform.core.device.pm.RCDevicePMSpecificationDAO;
import com.fudanmed.platform.core.device.pm.RCPMDeviceTypeEntry;
import edu.fudan.mylang.pf.IGenericQuery;
import edu.fudan.mylang.pf.event.BaseEntityEventsListener;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.device.pm.RCDevicePMSpecificationDeviceAction")
public class RCDevicePMSpecificationDeviceAction extends BaseEntityEventsListener<RCDevice> implements RCDeviceEventsListener {
  @Autowired
  private RCDevicePMSpecificationDAO dao;
  
  public void entityCreated(final RCDevice entity) {
    final RCDeviceType deviceType = entity.getDeviceType();
    IGenericQuery<RCPMDeviceTypeEntry> query=getObjectFactory().createGenericQuery(RCPMDeviceTypeEntry.class,"select e from com.fudanmed.platform.core.device.pm.impl.RCPMDeviceTypeEntryImpl as e   where (e.deviceType = :deviceType) and  e.active = 1      ").setParameter("deviceType",deviceType);
    final RCPMDeviceTypeEntry entry = query.uniqueResult();
    entry.populateToDevice(entity);
  }
  
  public void entityDeleted(final RCDevice entity) {
    IGenericQuery<RCDevicePMSpecification> query=getObjectFactory().createGenericQuery(RCDevicePMSpecification.class,"select e from com.fudanmed.platform.core.device.pm.impl.RCDevicePMSpecificationImpl as e   where (e.device = :entity) and  e.active = 1      ").setParameter("entity",entity);
    Collection<RCDevicePMSpecification> _list = query.list();
    final Procedure1<RCDevicePMSpecification> _function = new Procedure1<RCDevicePMSpecification>() {
        public void apply(final RCDevicePMSpecification it) {
          final Procedure1<RCDevicePMSpecification> _function = new Procedure1<RCDevicePMSpecification>() {
              public void apply(final RCDevicePMSpecification it) {
              }
            };
          RCDevicePMSpecificationDeviceAction.this.dao.delete(it, _function);
        }
      };
    IterableExtensions.<RCDevicePMSpecification>forEach(_list, _function);
  }
}
