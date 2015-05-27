package com.lanmon.business.server.service.customer;

import com.lanmon.business.client.customer.AllEmployeesService;
import com.lanmon.workflow.business.Employee;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import com.uniquesoft.uidl.transform.ProxyContentProviderMapper;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.lanmon.business.client.customer.AllEmployeesService")
@Transactional
public class AllEmployeesServiceImpl extends BaseContentProviderService implements AllEmployeesService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<Employee> mapper;
  
  public Collection<GWTNamedEntity> load() {
    return convertService.toGwtEntity(doLoad(),mapper);
  }
  
  public Collection<Employee> doLoad() {
    Collection<Employee> _all = this.entities.<Employee>all(Employee.class);
    return _all;
  }
}
