package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.measure.RCGasMeasureValue;
import com.fudanmed.platform.core.measure.RCMeasureDevice;
import com.fudanmed.platform.core.measure.RCMeasureValue;
import com.fudanmed.platform.core.measure.proxy.RCGasMeasureValueProxy;
import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy;
import com.fudanmed.platform.core.web.client.measure.CreateOrUpdateGasMeasureValuePresenterService;
import com.fudanmed.platform.core.web.server.service.measure.GasMeasureValueMapper;
import com.fudanmed.platform.core.web.shared.measure.UIGasMeasureValue;
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

@Service("com.fudanmed.platform.core.web.client.measure.CreateOrUpdateGasMeasureValuePresenterService")
@Transactional
public class CreateOrUpdateGasMeasureValuePresenterServiceImpl extends BaseService implements CreateOrUpdateGasMeasureValuePresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private GasMeasureValueMapper mapper;
  
  public UIGasMeasureValue loadValue(final RCGasMeasureValueProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCGasMeasureValue _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.measure.RCGasMeasureValue)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIGasMeasureValue _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIGasMeasureValue uivalue) throws SessionTimeOutException, ValidationException {
    RCGasMeasureValue _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.measure.RCGasMeasureValue)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public void createValue(final UIGasMeasureValue uivalue, final RCMeasureDeviceProxy parent) throws SessionTimeOutException, ValidationException {
    RCMeasureDevice _resolved= null;
    if(parent!=null) _resolved=(com.fudanmed.platform.core.measure.RCMeasureDevice)com.uniquesoft.uidl.extensions.ModelObjects.resolve(parent, entities);
    
    Date _measureDate = uivalue.getMeasureDate();
    String _measurePerson = uivalue.getMeasurePerson();
    RCMeasureValue _createValue =  _resolved.createValue(_measureDate, _measurePerson);
    final Procedure1<RCGasMeasureValue> _function = new Procedure1<RCGasMeasureValue>() {
        public void apply(final RCGasMeasureValue it) {
          CreateOrUpdateGasMeasureValuePresenterServiceImpl.this.mapper.transform(uivalue, it);
        }
      };
    ObjectExtensions.<RCGasMeasureValue>operator_doubleArrow(((RCGasMeasureValue) _createValue), _function);
  }
}
