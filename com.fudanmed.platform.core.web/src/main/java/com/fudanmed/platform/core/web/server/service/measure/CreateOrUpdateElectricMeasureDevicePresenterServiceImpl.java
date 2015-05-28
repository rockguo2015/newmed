package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.measure.RCElectricMeasureDevice;
import com.fudanmed.platform.core.measure.RCElectricMeasureDeviceType;
import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.CreateOrUpdateElectricMeasureDevicePresenterService;
import com.fudanmed.platform.core.web.server.service.measure.ElectricMeasureDeviceMapper;
import com.fudanmed.platform.core.web.shared.measure.UIElectricMeasureDevice;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.measure.CreateOrUpdateElectricMeasureDevicePresenterService")
@Transactional
public class CreateOrUpdateElectricMeasureDevicePresenterServiceImpl extends BaseService implements CreateOrUpdateElectricMeasureDevicePresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ElectricMeasureDeviceMapper mapper;
  
  public UIElectricMeasureDevice loadValue(final RCElectricMeasureDeviceProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCElectricMeasureDevice _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.measure.RCElectricMeasureDevice)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIElectricMeasureDevice _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIElectricMeasureDevice uivalue) throws SessionTimeOutException, ValidationException {
    RCElectricMeasureDevice _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.measure.RCElectricMeasureDevice)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    final Procedure1<RCElectricMeasureDevice> _function = new Procedure1<RCElectricMeasureDevice>() {
        public void apply(final RCElectricMeasureDevice it) {
          CreateOrUpdateElectricMeasureDevicePresenterServiceImpl.this.mapper.transform(uivalue, it);
        }
      };
     _resolved.update(_function);
  }
  
  public void createValue(final UIElectricMeasureDevice uivalue, final RCElectricMeasureDeviceTypeProxy parent) throws SessionTimeOutException, ValidationException {
    RCElectricMeasureDeviceType _resolved= null;
    if(parent!=null) _resolved=(com.fudanmed.platform.core.measure.RCElectricMeasureDeviceType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(parent, entities);
    
    final Procedure1<RCElectricMeasureDevice> _function = new Procedure1<RCElectricMeasureDevice>() {
        public void apply(final RCElectricMeasureDevice it) {
          CreateOrUpdateElectricMeasureDevicePresenterServiceImpl.this.mapper.transform(uivalue, it);
        }
      };
     _resolved.createDevice(_function);
  }
}
