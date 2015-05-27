package com.lanmon.business.server.service.customer;

import com.lanmon.business.client.customer.DomainCodeProviderService;
import com.lanmon.workflow.business.DomainCode;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import com.uniquesoft.uidl.transform.ProxyContentProviderMapper;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.lanmon.business.client.customer.DomainCodeProviderService")
@Transactional
public class DomainCodeProviderServiceImpl extends BaseContentProviderService implements DomainCodeProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<DomainCode> mapper;
  
  public Collection<GWTNamedEntity> load() {
    return convertService.toGwtEntity(doLoad(),mapper);
  }
  
  public Collection<DomainCode> doLoad() {
    Collection<DomainCode> _all = this.entities.<DomainCode>all(DomainCode.class);
    return _all;
  }
}
