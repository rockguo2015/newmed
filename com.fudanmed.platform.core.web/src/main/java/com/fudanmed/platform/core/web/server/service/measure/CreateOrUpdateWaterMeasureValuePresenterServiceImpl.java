package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.measure.RCMeasureDevice;
import com.fudanmed.platform.core.measure.RCMeasureValue;
import com.fudanmed.platform.core.measure.RCWaterMeasureValue;
import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureValueProxy;
import com.fudanmed.platform.core.web.client.measure.CreateOrUpdateWaterMeasureValuePresenterService;
import com.fudanmed.platform.core.web.server.service.measure.WaterMeasureValueMapper;
import com.fudanmed.platform.core.web.shared.measure.UIWaterMeasureValue;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.measure.CreateOrUpdateWaterMeasureValuePresenterService")
@Transactional
public class CreateOrUpdateWaterMeasureValuePresenterServiceImpl extends BaseService implements CreateOrUpdateWaterMeasureValuePresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private WaterMeasureValueMapper mapper;
  
  public UIWaterMeasureValue loadValue(final RCWaterMeasureValueProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCWaterMeasureValue _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.measure.RCWaterMeasureValue)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIWaterMeasureValue _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIWaterMeasureValue uivalue) throws SessionTimeOutException, ValidationException {
    RCWaterMeasureValue _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.measure.RCWaterMeasureValue)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public void createValue(final UIWaterMeasureValue uivalue, final RCMeasureDeviceProxy parent) throws SessionTimeOutException, ValidationException {
    RCMeasureDevice _resolved= null;
    if(parent!=null) _resolved=(com.fudanmed.platform.core.measure.RCMeasureDevice)com.uniquesoft.uidl.extensions.ModelObjects.resolve(parent, entities);
    
    Date _measureDate = uivalue.getMeasureDate();
    String _measurePerson = uivalue.getMeasurePerson();
    RCMeasureValue _createValue =  _resolved.createValue(_measureDate, _measurePerson);
    final Procedure1<RCWaterMeasureValue> _function = new Procedure1<RCWaterMeasureValue>() {
        public void apply(final RCWaterMeasureValue it) {
          CreateOrUpdateWaterMeasureValuePresenterServiceImpl.this.mapper.transform(uivalue, it);
        }
      };
    ObjectExtensions.<RCWaterMeasureValue>operator_doubleArrow(((RCWaterMeasureValue) _createValue), _function);
  }
}
