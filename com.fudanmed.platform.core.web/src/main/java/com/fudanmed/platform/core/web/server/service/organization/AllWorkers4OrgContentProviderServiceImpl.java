package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCEmployeeDAO;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.AllWorkers4OrgContentProviderService;
import com.fudanmed.platform.core.web.server.service.project.WorkerMapper;
import com.fudanmed.platform.core.web.shared.organization.AllWorkers4OrgContentProviderCriteria;
import com.fudanmed.platform.core.web.shared.project.UIWorker;
import com.google.common.base.Objects;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.organization.AllWorkers4OrgContentProviderService")
@Transactional
public class AllWorkers4OrgContentProviderServiceImpl extends BaseContentProviderService implements AllWorkers4OrgContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RCEmployeeDAO dao;
  
  @Autowired
  private WorkerMapper mapper;
  
  public Collection<UIWorker> load(final AllWorkers4OrgContentProviderCriteria filter) {
    return doLoad(filter);
  }
  
  public Collection<UIWorker> doLoad(final AllWorkers4OrgContentProviderCriteria filter) {
    Collection<RCEmployee> _xifexpression = null;
    RCOrganizationProxy _org = filter.getOrg();
    boolean _equals = Objects.equal(_org, null);
    if (_equals) {
      Collection<RCEmployee> _allOnJobEmployees = this.dao.allOnJobEmployees();
      _xifexpression = _allOnJobEmployees;
    } else {
      RCOrganizationProxy _org_1 = filter.getOrg();
      Long _id = _org_1.getId();
      RCOrganization _get = this.entities.<RCOrganization>get(RCOrganization.class, _id);
      Collection<RCEmployee> _onJobEmployees = _get.getOnJobEmployees();
      _xifexpression = _onJobEmployees;
    }
    final Function1<RCEmployee,UIWorker> _function = new Function1<RCEmployee,UIWorker>() {
        public UIWorker apply(final RCEmployee it) {
          UIWorker _transform = AllWorkers4OrgContentProviderServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIWorker> _map = IterableExtensions.<RCEmployee, UIWorker>map(_xifexpression, _function);
    Collection<UIWorker> _unlazy = IterableExtensions2.<UIWorker>unlazy(_map);
    return _unlazy;
  }
}
