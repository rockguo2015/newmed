package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.domain.RCOnsitePosition;
import com.fudanmed.platform.core.domain.RCOrganizationService;
import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.client.organization.OnsiteLocationOutlinePresenterService;
import com.fudanmed.platform.core.web.server.service.organization.OnsitePositionMapper;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
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

@Service("com.fudanmed.platform.core.web.client.organization.OnsiteLocationOutlinePresenterService")
@Transactional
public class OnsiteLocationOutlinePresenterServiceImpl extends BaseService implements OnsiteLocationOutlinePresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private OnsitePositionMapper mapper;
  
  @Autowired
  private RCOrganizationService OnsitePositionService;
  
  public Collection<UIOnsitePosition> loadAllOnsitePosition() throws SessionTimeOutException, ValidationException {
    Collection<RCOnsitePosition> _allOnsitePositions = this.OnsitePositionService.getAllOnsitePositions();
    final Function1<RCOnsitePosition,UIOnsitePosition> _function = new Function1<RCOnsitePosition,UIOnsitePosition>() {
        public UIOnsitePosition apply(final RCOnsitePosition it) {
          UIOnsitePosition _transform = OnsiteLocationOutlinePresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIOnsitePosition> _map = IterableExtensions.<RCOnsitePosition, UIOnsitePosition>map(_allOnsitePositions, _function);
    Collection<UIOnsitePosition> _unlazy = IterableExtensions2.<UIOnsitePosition>unlazy(_map);
    return _unlazy;
  }
  
  public UIOnsitePosition getValue(final RCOnsitePositionProxy org) throws SessionTimeOutException, ValidationException {
    RCOnsitePosition _resolved= null;
    if(org!=null) _resolved=(com.fudanmed.platform.core.domain.RCOnsitePosition)com.uniquesoft.uidl.extensions.ModelObjects.resolve(org, entities);
    
    UIOnsitePosition _transform = this.mapper.transform( _resolved);
    return _transform;
  }
}
