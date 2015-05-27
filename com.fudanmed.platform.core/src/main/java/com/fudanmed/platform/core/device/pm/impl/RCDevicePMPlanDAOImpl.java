package com.fudanmed.platform.core.device.pm.impl;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.pm.RCDevicePMPlan;
import com.fudanmed.platform.core.device.pm.RCDevicePMPlanDAO;
import edu.fudan.mylang.pf.BaseDAOService;
import edu.fudan.mylang.pf.IGenericQuery;
import java.util.Collection;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.device.pm.RCDevicePMPlanDAO")
public class RCDevicePMPlanDAOImpl extends BaseDAOService<RCDevicePMPlan> implements RCDevicePMPlanDAO {
  public Collection<RCDevicePMPlan> findByDevice(final RCDevice device) {
    IGenericQuery<RCDevicePMPlan> query=getObjectFactory().createGenericQuery(RCDevicePMPlan.class,"select e from com.fudanmed.platform.core.device.pm.impl.RCDevicePMPlanImpl as e   where (e.spec.device = :device) and  e.active = 1      ").setParameter("device",device);
    Collection<RCDevicePMPlan> _list = query.list();
    return _list;
  }
}
