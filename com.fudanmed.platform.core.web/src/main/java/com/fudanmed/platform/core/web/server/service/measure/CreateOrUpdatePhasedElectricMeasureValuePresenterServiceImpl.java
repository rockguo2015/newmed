package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.measure.RCMeasureDevice;
import com.fudanmed.platform.core.measure.RCMeasureValue;
import com.fudanmed.platform.core.measure.RCPhasedElectricMeasureValue;
import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureValueProxy;
import com.fudanmed.platform.core.web.client.measure.CreateOrUpdatePhasedElectricMeasureValuePresenterService;
import com.fudanmed.platform.core.web.server.service.measure.PhasedElectricMeasureValueMapper;
import com.fudanmed.platform.core.web.shared.measure.UIPhasedElectricMeasureValue;
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

@Service("com.fudanmed.platform.core.web.client.measure.CreateOrUpdatePhasedElectricMeasureValuePresenterService")
@Transactional
public class CreateOrUpdatePhasedElectricMeasureValuePresenterServiceImpl extends BaseService implements CreateOrUpdatePhasedElectricMeasureValuePresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private PhasedElectricMeasureValueMapper mapper;
  
  public UIPhasedElectricMeasureValue loadValue(final RCPhasedElectricMeasureValueProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCPhasedElectricMeasureValue _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.measure.RCPhasedElectricMeasureValue)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIPhasedElectricMeasureValue _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIPhasedElectricMeasureValue uivalue) throws SessionTimeOutException, ValidationException {
    RCPhasedElectricMeasureValue _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.measure.RCPhasedElectricMeasureValue)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public void createValue(final UIPhasedElectricMeasureValue uivalue, final RCMeasureDeviceProxy parent) throws SessionTimeOutException, ValidationException {
    RCMeasureDevice _resolved= null;
    if(parent!=null) _resolved=(com.fudanmed.platform.core.measure.RCMeasureDevice)com.uniquesoft.uidl.extensions.ModelObjects.resolve(parent, entities);
    
    Date _measureDate = uivalue.getMeasureDate();
    String _measurePerson = uivalue.getMeasurePerson();
    RCMeasureValue _createValue =  _resolved.createValue(_measureDate, _measurePerson);
    final Procedure1<RCPhasedElectricMeasureValue> _function = new Procedure1<RCPhasedElectricMeasureValue>() {
        public void apply(final RCPhasedElectricMeasureValue it) {
          CreateOrUpdatePhasedElectricMeasureValuePresenterServiceImpl.this.mapper.transform(uivalue, it);
        }
      };
    ObjectExtensions.<RCPhasedElectricMeasureValue>operator_doubleArrow(((RCPhasedElectricMeasureValue) _createValue), _function);
  }
}
