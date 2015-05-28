package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.common.RCFaultLevelColorAdaptor;
import com.fudanmed.platform.core.common.RCFaultLevelColorAdaptorDao;
import com.fudanmed.platform.core.web.client.organization.FaultLevelColorAdaptorListPresenterService;
import com.fudanmed.platform.core.web.server.service.organization.FaultLevelColorAdaptorMapper;
import com.fudanmed.platform.core.web.shared.organization.UIFaultLevelColorAdaptor;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.organization.FaultLevelColorAdaptorListPresenterService")
@Transactional
public class FaultLevelColorAdaptorListPresenterServiceImpl extends BaseService implements FaultLevelColorAdaptorListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private FaultLevelColorAdaptorMapper mapper;
  
  @Autowired
  private RCFaultLevelColorAdaptorDao dao;
  
  public Collection<UIFaultLevelColorAdaptor> loadFaultLevelColorAdaptorList() throws SessionTimeOutException, ValidationException {
    Collection<RCFaultLevelColorAdaptor> _findAll = this.dao.findAll();
    final Function1<RCFaultLevelColorAdaptor,UIFaultLevelColorAdaptor> _function = new Function1<RCFaultLevelColorAdaptor,UIFaultLevelColorAdaptor>() {
        public UIFaultLevelColorAdaptor apply(final RCFaultLevelColorAdaptor it) {
          UIFaultLevelColorAdaptor _transform = FaultLevelColorAdaptorListPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIFaultLevelColorAdaptor> _map = IterableExtensions.<RCFaultLevelColorAdaptor, UIFaultLevelColorAdaptor>map(_findAll, _function);
    Collection<UIFaultLevelColorAdaptor> _unlazy = IterableExtensions2.<UIFaultLevelColorAdaptor>unlazy(_map);
    return _unlazy;
  }
}
