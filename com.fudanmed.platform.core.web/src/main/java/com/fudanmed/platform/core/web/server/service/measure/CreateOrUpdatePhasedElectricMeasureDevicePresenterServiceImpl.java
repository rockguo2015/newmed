package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.measure.RCPhasedElectricMeasureDevice;
import com.fudanmed.platform.core.measure.RCPhasedElectricMeasureDeviceType;
import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.CreateOrUpdatePhasedElectricMeasureDevicePresenterService;
import com.fudanmed.platform.core.web.server.service.measure.PhasedElectricMeasureDeviceMapper;
import com.fudanmed.platform.core.web.shared.measure.UIPhasedElectricMeasureDevice;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.measure.CreateOrUpdatePhasedElectricMeasureDevicePresenterService")
@Transactional
public class CreateOrUpdatePhasedElectricMeasureDevicePresenterServiceImpl extends BaseService implements CreateOrUpdatePhasedElectricMeasureDevicePresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private PhasedElectricMeasureDeviceMapper mapper;
  
  public UIPhasedElectricMeasureDevice loadValue(final RCPhasedElectricMeasureDeviceProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCPhasedElectricMeasureDevice _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.measure.RCPhasedElectricMeasureDevice)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIPhasedElectricMeasureDevice _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIPhasedElectricMeasureDevice uivalue) throws SessionTimeOutException, ValidationException {
    RCPhasedElectricMeasureDevice _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.measure.RCPhasedElectricMeasureDevice)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    final Procedure1<RCPhasedElectricMeasureDevice> _function = new Procedure1<RCPhasedElectricMeasureDevice>() {
        public void apply(final RCPhasedElectricMeasureDevice it) {
          CreateOrUpdatePhasedElectricMeasureDevicePresenterServiceImpl.this.mapper.transform(uivalue, it);
        }
      };
     _resolved.update(_function);
  }
  
  public void createValue(final UIPhasedElectricMeasureDevice uivalue, final RCPhasedElectricMeasureDeviceTypeProxy parent) throws SessionTimeOutException, ValidationException {
    RCPhasedElectricMeasureDeviceType _resolved= null;
    if(parent!=null) _resolved=(com.fudanmed.platform.core.measure.RCPhasedElectricMeasureDeviceType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(parent, entities);
    
    final Procedure1<RCPhasedElectricMeasureDevice> _function = new Procedure1<RCPhasedElectricMeasureDevice>() {
        public void apply(final RCPhasedElectricMeasureDevice it) {
          CreateOrUpdatePhasedElectricMeasureDevicePresenterServiceImpl.this.mapper.transform(uivalue, it);
        }
      };
     _resolved.createDevice(_function);
  }
}
