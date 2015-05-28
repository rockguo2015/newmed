package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.measure.RCGasMeasureDevice;
import com.fudanmed.platform.core.measure.RCGasMeasureDeviceType;
import com.fudanmed.platform.core.measure.proxy.RCGasMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCGasMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.CreateOrUpdateGasMeasureDevicePresenterService;
import com.fudanmed.platform.core.web.server.service.measure.GasMeasureDeviceMapper;
import com.fudanmed.platform.core.web.shared.measure.UIGasMeasureDevice;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.measure.CreateOrUpdateGasMeasureDevicePresenterService")
@Transactional
public class CreateOrUpdateGasMeasureDevicePresenterServiceImpl extends BaseService implements CreateOrUpdateGasMeasureDevicePresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private GasMeasureDeviceMapper mapper;
  
  public UIGasMeasureDevice loadValue(final RCGasMeasureDeviceProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCGasMeasureDevice _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.measure.RCGasMeasureDevice)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIGasMeasureDevice _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIGasMeasureDevice uivalue) throws SessionTimeOutException, ValidationException {
    RCGasMeasureDevice _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.measure.RCGasMeasureDevice)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    final Procedure1<RCGasMeasureDevice> _function = new Procedure1<RCGasMeasureDevice>() {
        public void apply(final RCGasMeasureDevice it) {
          CreateOrUpdateGasMeasureDevicePresenterServiceImpl.this.mapper.transform(uivalue, it);
        }
      };
     _resolved.update(_function);
  }
  
  public void createValue(final UIGasMeasureDevice uivalue, final RCGasMeasureDeviceTypeProxy parent) throws SessionTimeOutException, ValidationException {
    RCGasMeasureDeviceType _resolved= null;
    if(parent!=null) _resolved=(com.fudanmed.platform.core.measure.RCGasMeasureDeviceType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(parent, entities);
    
    final Procedure1<RCGasMeasureDevice> _function = new Procedure1<RCGasMeasureDevice>() {
        public void apply(final RCGasMeasureDevice it) {
          CreateOrUpdateGasMeasureDevicePresenterServiceImpl.this.mapper.transform(uivalue, it);
        }
      };
     _resolved.createDevice(_function);
  }
}
