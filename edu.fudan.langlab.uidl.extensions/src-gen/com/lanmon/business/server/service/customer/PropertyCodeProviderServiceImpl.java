package com.lanmon.business.server.service.customer;

import com.lanmon.business.client.customer.PropertyCodeProviderService;
import com.lanmon.workflow.business.PropertyCode;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import com.uniquesoft.uidl.transform.ProxyContentProviderMapper;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.lanmon.business.client.customer.PropertyCodeProviderService")
@Transactional
public class PropertyCodeProviderServiceImpl extends BaseContentProviderService implements PropertyCodeProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<PropertyCode> mapper;
  
  public Collection<GWTNamedEntity> load() {
    return convertService.toGwtEntity(doLoad(),mapper);
  }
  
  public Collection<PropertyCode> doLoad() {
    Collection<PropertyCode> _all = this.entities.<PropertyCode>all(PropertyCode.class);
    return _all;
  }
}
