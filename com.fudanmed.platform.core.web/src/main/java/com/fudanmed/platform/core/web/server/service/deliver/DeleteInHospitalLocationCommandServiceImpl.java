package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLInHospitalLocation;
import com.fudanmed.platform.core.deliver.DLInHospitalLocationDAO;
import com.fudanmed.platform.core.deliver.proxy.DLInHospitalLocationProxy;
import com.fudanmed.platform.core.web.client.deliver.DeleteInHospitalLocationCommandService;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.deliver.DeleteInHospitalLocationCommandService")
@Transactional
public class DeleteInHospitalLocationCommandServiceImpl extends BaseService implements DeleteInHospitalLocationCommandService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DLInHospitalLocationDAO dao;
  
  public void delete(final DLInHospitalLocationProxy value) throws SessionTimeOutException, ValidationException {
    DLInHospitalLocation _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.deliver.DLInHospitalLocation)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    this.dao.delete( _resolved);
  }
}
