package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.measure.RCElectricMeasureValue;
import com.fudanmed.platform.core.measure.RCMeasureValueDAO;
import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureValueProxy;
import com.fudanmed.platform.core.web.client.measure.DeleteElectricMeasureValueCommandService;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.measure.DeleteElectricMeasureValueCommandService")
@Transactional
public class DeleteElectricMeasureValueCommandServiceImpl extends BaseService implements DeleteElectricMeasureValueCommandService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RCMeasureValueDAO valueDAO;
  
  public void delete(final RCElectricMeasureValueProxy value) throws SessionTimeOutException, ValidationException {
    RCElectricMeasureValue _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.measure.RCElectricMeasureValue)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    this.valueDAO.delete( _resolved);
  }
}
