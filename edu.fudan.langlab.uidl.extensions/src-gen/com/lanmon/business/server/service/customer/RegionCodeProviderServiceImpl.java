package com.lanmon.business.server.service.customer;

import com.lanmon.business.client.customer.RegionCodeProviderService;
import com.lanmon.workflow.business.RegionCode;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import com.uniquesoft.uidl.transform.ProxyContentProviderMapper;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.lanmon.business.client.customer.RegionCodeProviderService")
@Transactional
public class RegionCodeProviderServiceImpl extends BaseContentProviderService implements RegionCodeProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<RegionCode> mapper;
  
  public Collection<GWTNamedEntity> load() {
    return convertService.toGwtEntity(doLoad(),mapper);
  }
  
  public Collection<RegionCode> doLoad() {
    Collection<RegionCode> _all = this.entities.<RegionCode>all(RegionCode.class);
    return _all;
  }
}
