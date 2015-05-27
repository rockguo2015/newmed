package com.lanmon.business.server.service.customer;

import com.lanmon.business.client.customer.CustomerContentProviderService;
import com.lanmon.business.shared.customer.CustomerContentProviderCriteria;
import com.lanmon.workflow.business.Customer;
import com.lanmon.workflow.business.CustomerService;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import com.uniquesoft.uidl.transform.ProxyContentProviderMapper;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.lanmon.business.client.customer.CustomerContentProviderService")
@Transactional
public class CustomerContentProviderServiceImpl extends BaseContentProviderService implements CustomerContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<Customer> mapper;
  
  @Autowired
  private CustomerService customerService;
  
  public Collection<GWTNamedEntity> load(final CustomerContentProviderCriteria filter) {
    return convertService.toGwtEntity(doLoad(filter), mapper);
  }
  
  public Collection<Customer> doLoad(final CustomerContentProviderCriteria filter) {
    String _name = filter.getName();
    Collection<Customer> _findCustomerByLikeName = this.customerService.findCustomerByLikeName(_name);
    return _findCustomerByLikeName;
  }
}
