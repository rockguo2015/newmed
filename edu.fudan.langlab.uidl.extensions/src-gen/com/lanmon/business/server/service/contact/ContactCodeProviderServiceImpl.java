package com.lanmon.business.server.service.contact;

import com.lanmon.business.client.contact.ContactCodeProviderService;
import com.lanmon.workflow.business.ContactCode;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import com.uniquesoft.uidl.transform.ProxyContentProviderMapper;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.lanmon.business.client.contact.ContactCodeProviderService")
@Transactional
public class ContactCodeProviderServiceImpl extends BaseContentProviderService implements ContactCodeProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<ContactCode> mapper;
  
  public Collection<GWTNamedEntity> load() {
    return convertService.toGwtEntity(doLoad(),mapper);
  }
  
  public Collection<ContactCode> doLoad() {
    Collection<ContactCode> _all = this.entities.<ContactCode>all(ContactCode.class);
    return _all;
  }
}
