package edu.fudan.langlab.uidl.domain.app.server.service.security;

import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import com.uniquesoft.uidl.transform.ProxyContentProviderMapper;
import edu.fudan.langlab.domain.security.Role;
import edu.fudan.langlab.domain.security.proxy.RoleProxy;
import edu.fudan.langlab.uidl.domain.app.client.security.AllRolesContentProviderService;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("edu.fudan.langlab.uidl.domain.app.client.security.AllRolesContentProviderService")
@Transactional
public class AllRolesContentProviderServiceImpl extends BaseContentProviderService implements AllRolesContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<Role> mapper;
  
  public Collection<RoleProxy> load() {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(),
    				new com.google.common.base.Function<Role, RoleProxy>() {
    					@Override
    					public  RoleProxy apply( Role input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<Role> doLoad() {
    Collection<Role> _all = this.entities.<Role>all(Role.class);
    return _all;
  }
}
