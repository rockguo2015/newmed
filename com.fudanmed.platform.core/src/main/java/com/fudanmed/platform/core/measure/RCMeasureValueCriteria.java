package com.fudanmed.platform.core.measure;

import com.fudanmed.platform.core.measure.RCMeasureDevice;
import com.fudanmed.platform.core.measure.RCMeasureDeviceType;
import com.fudanmed.platform.core.measure.RCMeasureValue;
import com.fudanmed.platform.core.measure.impl.RCMeasureValueCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;
import java.util.Date;

@QueryImplementation(implementBy = RCMeasureValueCriteriaImpl.class)
public interface RCMeasureValueCriteria extends IPagedCriteria<RCMeasureValue> {
  public abstract RCMeasureDeviceType getDeviceType();
  
  public abstract RCMeasureValueCriteria setDeviceType(final RCMeasureDeviceType deviceType);
  
  public abstract RCMeasureDevice getDevice();
  
  public abstract RCMeasureValueCriteria setDevice(final RCMeasureDevice device);
  
  public abstract Date getMeasureDateFrom();
  
  public abstract RCMeasureValueCriteria setMeasureDateFrom(final Date measureDateFrom);
  
  public abstract Date getMeasureDateTo();
  
  public abstract RCMeasureValueCriteria setMeasureDateTo(final Date measureDateTo);
}
