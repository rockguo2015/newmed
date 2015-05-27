package com.fudanmed.platform.core.measure.impl;

import com.fudanmed.platform.core.measure.RCMeasureValue;
import com.fudanmed.platform.core.measure.RCMeasureValueDAO;
import edu.fudan.mylang.pf.BaseDAOService;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.measure.RCMeasureValueDAO")
public class RCMeasureValueDAOImpl extends BaseDAOService<RCMeasureValue> implements RCMeasureValueDAO {
  public void delete(final RCMeasureValue value) {getObjectFactory().delete(value);
    
  }
}
