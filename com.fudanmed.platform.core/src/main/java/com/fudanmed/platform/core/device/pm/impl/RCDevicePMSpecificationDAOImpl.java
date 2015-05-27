package com.fudanmed.platform.core.device.pm.impl;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.pm.RCDevicePMSpecification;
import com.fudanmed.platform.core.device.pm.RCDevicePMSpecificationDAO;
import com.fudanmed.platform.core.device.pm.events.RCDevicePMSpecificationEventsManager;
import com.fudanmed.platform.core.device.pm.impl.RCDevicePMSpecificationImpl;
import com.google.common.base.Objects;
import edu.fudan.mylang.pf.BaseDAOService;
import edu.fudan.mylang.pf.IGenericQuery;
import edu.fudan.mylang.utils.DateUtil;
import java.util.Collection;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.device.pm.RCDevicePMSpecificationDAO")
public class RCDevicePMSpecificationDAOImpl extends BaseDAOService<RCDevicePMSpecification> implements RCDevicePMSpecificationDAO {
  @Autowired
  private RCDevicePMSpecificationEventsManager eventsManager;
  
  public RCDevicePMSpecification create(final Procedure1<? super RCDevicePMSpecification> preInit) {RCDevicePMSpecification rCDevicePMSpecification=RCDevicePMSpecificationImpl.create(getObjectFactory());
    final Procedure1<RCDevicePMSpecification> _function = new Procedure1<RCDevicePMSpecification>() {
        public void apply(final RCDevicePMSpecification it) {
          preInit.apply(it);
          RCDevicePMSpecificationDAOImpl.this.eventsManager.fireCreated(it);
        }
      };
    RCDevicePMSpecification _doubleArrow = ObjectExtensions.<RCDevicePMSpecification>operator_doubleArrow(rCDevicePMSpecification, _function);
    return _doubleArrow;
  }
  
  public void delete(final RCDevicePMSpecification value, final Procedure1<? super RCDevicePMSpecification> postProc) {getObjectFactory().delete(value);
    
    postProc.apply(value);
    this.eventsManager.fireDeleted(value);
  }
  
  public Collection<RCDevicePMSpecification> findByDevice(final RCDevice device) {
    IGenericQuery<RCDevicePMSpecification> query=getObjectFactory().createGenericQuery(RCDevicePMSpecification.class,"select e from com.fudanmed.platform.core.device.pm.impl.RCDevicePMSpecificationImpl as e   where (e.device = :device) and  e.active = 1      ").setParameter("device",device);
    Collection<RCDevicePMSpecification> _list = query.list();
    return _list;
  }
  
  public void batchInitializePMPlanUptoYear(final Integer year) {IGenericQuery<RCDevicePMSpecification> query=getObjectFactory().createGenericQuery(RCDevicePMSpecification.class,"select e from com.fudanmed.platform.core.device.pm.impl.RCDevicePMSpecificationImpl as e   where  e.active = 1      ");
    Collection<RCDevicePMSpecification> _list = query.list();
    final Procedure1<RCDevicePMSpecification> _function = new Procedure1<RCDevicePMSpecification>() {
        public void apply(final RCDevicePMSpecification devicePMSpec) {
          Date _xifexpression = null;
          Date _lastPMPlanDate = devicePMSpec.getLastPMPlanDate();
          boolean _equals = Objects.equal(_lastPMPlanDate, null);
          if (_equals) {
            Date _day = DateUtil.today();
            _xifexpression = _day;
          } else {
            Date _lastPMPlanDate_1 = devicePMSpec.getLastPMPlanDate();
            _xifexpression = _lastPMPlanDate_1;
          }
          final Date lastPMPlanDate = _xifexpression;
          devicePMSpec.initializePMPlanUptoYear(lastPMPlanDate, year);
        }
      };
    IterableExtensions.<RCDevicePMSpecification>forEach(_list, _function);
  }
  
  public void batchInitializePMPlanUptoYear(final RCDevice device, final Date fromDate, final Integer year) {
    Collection<RCDevicePMSpecification> _findByDevice = this.findByDevice(device);
    final Procedure1<RCDevicePMSpecification> _function = new Procedure1<RCDevicePMSpecification>() {
        public void apply(final RCDevicePMSpecification devicePMSpec) {
          Date _xifexpression = null;
          boolean _equals = Objects.equal(fromDate, null);
          if (_equals) {
            Date _xifexpression_1 = null;
            Date _lastPMPlanDate = devicePMSpec.getLastPMPlanDate();
            boolean _equals_1 = Objects.equal(_lastPMPlanDate, null);
            if (_equals_1) {
              Date _day = DateUtil.today();
              _xifexpression_1 = _day;
            } else {
              Date _lastPMPlanDate_1 = devicePMSpec.getLastPMPlanDate();
              _xifexpression_1 = _lastPMPlanDate_1;
            }
            _xifexpression = _xifexpression_1;
          } else {
            _xifexpression = fromDate;
          }
          final Date lastPMPlanDate = _xifexpression;
          devicePMSpec.initializePMPlanUptoYear(lastPMPlanDate, year);
        }
      };
    IterableExtensions.<RCDevicePMSpecification>forEach(_findByDevice, _function);
  }
}
