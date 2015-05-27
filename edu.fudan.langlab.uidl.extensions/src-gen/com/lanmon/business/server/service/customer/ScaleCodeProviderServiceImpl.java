package com.lanmon.business.server.service.customer;

import com.lanmon.business.client.customer.ScaleCodeProviderService;
import com.lanmon.workflow.business.ScaleCode;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import com.uniquesoft.uidl.transform.ProxyContentProviderMapper;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.lanmon.business.client.customer.ScaleCodeProviderService")
@Transactional
public class ScaleCodeProviderServiceImpl extends BaseContentProviderService implements ScaleCodeProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<ScaleCode> mapper;
  
  public Collection<GWTNamedEntity> load() {
    return convertService.toGwtEntity(doLoad(),mapper);
  }
  
  public Collection<ScaleCode> doLoad() {
    Collection<ScaleCode> _all = this.entities.<ScaleCode>all(ScaleCode.class);
    return _all;
  }
}
