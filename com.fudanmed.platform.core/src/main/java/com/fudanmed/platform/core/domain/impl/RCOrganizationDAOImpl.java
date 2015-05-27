package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.RCOrganizationDAO;
import com.fudanmed.platform.core.domain.impl.RCOrganizationImpl;
import edu.fudan.mylang.pf.BaseService;
import edu.fudan.mylang.pf.IGenericQuery;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.domain.RCOrganizationDAO")
public class RCOrganizationDAOImpl extends BaseService implements RCOrganizationDAO {
  public RCOrganization findByCode(final String code) {
    IGenericQuery<RCOrganization> query=getObjectFactory().createGenericQuery(RCOrganization.class,"select o from com.fudanmed.platform.core.domain.impl.RCOrganizationImpl as o   where (o.code = :code) and  o.active = 1      ").setParameter("code",code);
    RCOrganization _uniqueResult = query.uniqueResult();
    return _uniqueResult;
  }
  
  public RCOrganization createOrganization(final RCOrganization parent, final Function1<? super RCOrganization,? extends RCOrganization> preinit) {RCOrganization rCOrganization=RCOrganizationImpl.create(parent,getObjectFactory());
    final Procedure1<RCOrganization> _function = new Procedure1<RCOrganization>() {
        public void apply(final RCOrganization org) {
          preinit.apply(org);
        }
      };
    RCOrganization _doubleArrow = ObjectExtensions.<RCOrganization>operator_doubleArrow(rCOrganization, _function);
    return _doubleArrow;
  }
  
  public void deleteOrganization(final RCOrganization organization) {getObjectFactory().delete(organization);
    
  }
}
