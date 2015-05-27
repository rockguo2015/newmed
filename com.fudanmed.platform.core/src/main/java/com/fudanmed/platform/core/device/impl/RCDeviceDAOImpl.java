package com.fudanmed.platform.core.device.impl;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.RCDeviceDAO;
import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.events.RCDeviceEventsManager;
import com.fudanmed.platform.core.device.impl.RCDeviceImpl;
import com.fudanmed.platform.core.entityextension.RCCompositeValue;
import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCExtensiableEntityType;
import com.fudanmed.platform.core.entityextension.impl.RCExtensiableEntityImpl;
import edu.fudan.mylang.pf.BaseDAOService;
import edu.fudan.mylang.pf.IGenericQuery;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.device.RCDeviceDAO")
public class RCDeviceDAOImpl extends BaseDAOService<RCDevice> implements RCDeviceDAO {
  @Autowired
  private RCDeviceEventsManager eventsManager;
  
  public RCDevice createDevice(final String sid, final Procedure1<? super RCDevice> preInit) {RCDevice rCDevice=RCDeviceImpl.create(getObjectFactory());
    final Procedure1<RCDevice> _function = new Procedure1<RCDevice>() {
        public void apply(final RCDevice device) {
          preInit.apply(device);RCExtensiableEntity rCExtensiableEntity=RCExtensiableEntityImpl.create(getObjectFactory());
          final Procedure1<RCExtensiableEntity> _function = new Procedure1<RCExtensiableEntity>() {
              public void apply(final RCExtensiableEntity extension) {
                RCDeviceType _deviceType = device.getDeviceType();
                RCExtensiableEntityType _extensiableType = _deviceType.getExtensiableType();
                extension.setType(_extensiableType);
                RCDeviceType _deviceType_1 = device.getDeviceType();
                RCExtensiableEntity _defaultValue = _deviceType_1.getDefaultValue();
                RCCompositeValue _value = _defaultValue.getValue();
                RCCompositeValue _cloneIn = _value.cloneIn(extension);
                extension.setValue(_cloneIn);
              }
            };
          RCExtensiableEntity _doubleArrow = ObjectExtensions.<RCExtensiableEntity>operator_doubleArrow(rCExtensiableEntity, _function);
          device.setExtension(_doubleArrow);
          device.checkValid();
          RCDeviceDAOImpl.this.eventsManager.fireCreated(device);
        }
      };
    RCDevice _doubleArrow = ObjectExtensions.<RCDevice>operator_doubleArrow(rCDevice, _function);
    return _doubleArrow;
  }
  
  public void update(final RCDevice device, final Procedure1<? super RCDevice> updater) {
    updater.apply(device);
    this.eventsManager.fireUpdateded(device);
  }
  
  public void delete(final RCDevice device, final Procedure1<? super RCDevice> postProc) {getObjectFactory().delete(device);
    
    this.eventsManager.fireDeleted(device);
  }
  
  public RCDevice findDeviceBySid(final String sid) {
    IGenericQuery<RCDevice> query=getObjectFactory().createGenericQuery(RCDevice.class,"select e from com.fudanmed.platform.core.device.impl.RCDeviceImpl as e   where (e.sid = :sid) and  e.active = 1      ").setParameter("sid",sid);
    RCDevice _uniqueResult = query.uniqueResult();
    return _uniqueResult;
  }
  
  public Collection<RCDevice> findDevicesByType(final RCDeviceType deviceType) {
    IGenericQuery<RCDevice> query=getObjectFactory().createGenericQuery(RCDevice.class,"select e from com.fudanmed.platform.core.device.impl.RCDeviceImpl as e   where (e.deviceType = :deviceType) and  e.active = 1      ").setParameter("deviceType",deviceType);
    Collection<RCDevice> _list = query.list();
    return _list;
  }
}
