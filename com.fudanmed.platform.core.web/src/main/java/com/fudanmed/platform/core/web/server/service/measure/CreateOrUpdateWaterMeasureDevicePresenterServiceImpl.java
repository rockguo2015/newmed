package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.measure.RCWaterMeasureDevice;
import com.fudanmed.platform.core.measure.RCWaterMeasureDeviceType;
import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.CreateOrUpdateWaterMeasureDevicePresenterService;
import com.fudanmed.platform.core.web.server.service.measure.WaterMeasureDeviceMapper;
import com.fudanmed.platform.core.web.shared.measure.UIWaterMeasureDevice;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.measure.CreateOrUpdateWaterMeasureDevicePresenterService")
@Transactional
public class CreateOrUpdateWaterMeasureDevicePresenterServiceImpl extends BaseService implements CreateOrUpdateWaterMeasureDevicePresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private WaterMeasureDeviceMapper mapper;
  
  public UIWaterMeasureDevice loadValue(final RCWaterMeasureDeviceProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCWaterMeasureDevice _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.measure.RCWaterMeasureDevice)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIWaterMeasureDevice _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIWaterMeasureDevice uivalue) throws SessionTimeOutException, ValidationException {
    RCWaterMeasureDevice _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.measure.RCWaterMeasureDevice)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    final Procedure1<RCWaterMeasureDevice> _function = new Procedure1<RCWaterMeasureDevice>() {
        public void apply(final RCWaterMeasureDevice it) {
          CreateOrUpdateWaterMeasureDevicePresenterServiceImpl.this.mapper.transform(uivalue, it);
        }
      };
     _resolved.update(_function);
  }
  
  public void createValue(final UIWaterMeasureDevice uivalue, final RCWaterMeasureDeviceTypeProxy parent) throws SessionTimeOutException, ValidationException {
    RCWaterMeasureDeviceType _resolved= null;
    if(parent!=null) _resolved=(com.fudanmed.platform.core.measure.RCWaterMeasureDeviceType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(parent, entities);
    
    final Procedure1<RCWaterMeasureDevice> _function = new Procedure1<RCWaterMeasureDevice>() {
        public void apply(final RCWaterMeasureDevice it) {
          CreateOrUpdateWaterMeasureDevicePresenterServiceImpl.this.mapper.transform(uivalue, it);
        }
      };
     _resolved.createDevice(_function);
  }
}
