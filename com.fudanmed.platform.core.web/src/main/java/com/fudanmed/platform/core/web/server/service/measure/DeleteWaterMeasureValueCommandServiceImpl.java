package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.measure.RCMeasureValueDAO;
import com.fudanmed.platform.core.measure.RCWaterMeasureValue;
import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureValueProxy;
import com.fudanmed.platform.core.web.client.measure.DeleteWaterMeasureValueCommandService;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.measure.DeleteWaterMeasureValueCommandService")
@Transactional
public class DeleteWaterMeasureValueCommandServiceImpl extends BaseService implements DeleteWaterMeasureValueCommandService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RCMeasureValueDAO valueDAO;
  
  public void delete(final RCWaterMeasureValueProxy value) throws SessionTimeOutException, ValidationException {
    RCWaterMeasureValue _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.measure.RCWaterMeasureValue)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    this.valueDAO.delete( _resolved);
  }
}
