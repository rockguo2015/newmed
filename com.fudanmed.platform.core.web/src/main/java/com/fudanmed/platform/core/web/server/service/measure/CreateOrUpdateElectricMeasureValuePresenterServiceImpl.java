package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.measure.RCElectricMeasureValue;
import com.fudanmed.platform.core.measure.RCMeasureDevice;
import com.fudanmed.platform.core.measure.RCMeasureValue;
import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureValueProxy;
import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy;
import com.fudanmed.platform.core.web.client.measure.CreateOrUpdateElectricMeasureValuePresenterService;
import com.fudanmed.platform.core.web.server.service.measure.ElectricMeasureValueMapper;
import com.fudanmed.platform.core.web.shared.measure.UIElectricMeasureValue;
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

@Service("com.fudanmed.platform.core.web.client.measure.CreateOrUpdateElectricMeasureValuePresenterService")
@Transactional
public class CreateOrUpdateElectricMeasureValuePresenterServiceImpl extends BaseService implements CreateOrUpdateElectricMeasureValuePresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ElectricMeasureValueMapper mapper;
  
  public UIElectricMeasureValue loadValue(final RCElectricMeasureValueProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCElectricMeasureValue _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.measure.RCElectricMeasureValue)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIElectricMeasureValue _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIElectricMeasureValue uivalue) throws SessionTimeOutException, ValidationException {
    RCElectricMeasureValue _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.measure.RCElectricMeasureValue)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public void createValue(final UIElectricMeasureValue uivalue, final RCMeasureDeviceProxy parent) throws SessionTimeOutException, ValidationException {
    RCMeasureDevice _resolved= null;
    if(parent!=null) _resolved=(com.fudanmed.platform.core.measure.RCMeasureDevice)com.uniquesoft.uidl.extensions.ModelObjects.resolve(parent, entities);
    
    Date _measureDate = uivalue.getMeasureDate();
    String _measurePerson = uivalue.getMeasurePerson();
    RCMeasureValue _createValue =  _resolved.createValue(_measureDate, _measurePerson);
    final Procedure1<RCElectricMeasureValue> _function = new Procedure1<RCElectricMeasureValue>() {
        public void apply(final RCElectricMeasureValue it) {
          CreateOrUpdateElectricMeasureValuePresenterServiceImpl.this.mapper.transform(uivalue, it);
        }
      };
    ObjectExtensions.<RCElectricMeasureValue>operator_doubleArrow(((RCElectricMeasureValue) _createValue), _function);
  }
}
