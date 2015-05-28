package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.domain.RCSupplier;
import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.fudanmed.platform.core.web.client.organization.CreateOrUpdateSupplierPresenterService;
import com.fudanmed.platform.core.web.server.service.organization.SupplierMapper;
import com.fudanmed.platform.core.web.shared.organization.UISupplier;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.organization.CreateOrUpdateSupplierPresenterService")
@Transactional
public class CreateOrUpdateSupplierPresenterServiceImpl extends BaseService implements CreateOrUpdateSupplierPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private SupplierMapper mapper;
  
  public UISupplier loadValue(final RCSupplierProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCSupplier _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.domain.RCSupplier)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UISupplier _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UISupplier uivalue) throws SessionTimeOutException, ValidationException {
    RCSupplier _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.domain.RCSupplier)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public RCSupplierProxy createValue(final UISupplier uivalue) throws SessionTimeOutException, ValidationException {
    RCSupplierProxy _xblockexpression = null;
    {
      RCSupplier value = this.entities.<RCSupplier>create(RCSupplier.class);
      this.mapper.transform(uivalue, value);
      RCSupplierProxy _proxy = value.toProxy();
      _xblockexpression = (_proxy);
    }
    return _xblockexpression;
  }
}
