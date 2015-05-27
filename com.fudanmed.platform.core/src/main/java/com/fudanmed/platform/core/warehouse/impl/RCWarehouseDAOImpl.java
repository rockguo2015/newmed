package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.RCWarehouseDAO;
import edu.fudan.langlab.domain.organization.Party;
import edu.fudan.langlab.domain.security.ISystemUserService;
import edu.fudan.mylang.pf.BaseDAOService;
import edu.fudan.mylang.pf.IGenericQuery;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.RCWarehouseDAO")
public class RCWarehouseDAOImpl extends BaseDAOService<RCWarehouse> implements RCWarehouseDAO {
  @Autowired
  private ISystemUserService systemUserService;
  
  public Collection<RCWarehouse> findManagedWarehouse(final RCEmployee employee) {
    IGenericQuery<RCWarehouse> query=getObjectFactory().createGenericQuery(RCWarehouse.class,"select  distinct e from com.fudanmed.platform.core.warehouse.impl.RCWarehouseImpl as e left join  e.storeManager as sm   where (sm = :employee) and  e.active = 1      ").setParameter("employee",employee);
    Collection<RCWarehouse> _list = query.list();
    return _list;
  }
  
  public Collection<RCWarehouse> findManagedWarehouse() {
    Party _currentUserAsParty = this.systemUserService.getCurrentUserAsParty();
    Collection<RCWarehouse> _findManagedWarehouse = this.findManagedWarehouse(((RCEmployee) _currentUserAsParty));
    return _findManagedWarehouse;
  }
}
