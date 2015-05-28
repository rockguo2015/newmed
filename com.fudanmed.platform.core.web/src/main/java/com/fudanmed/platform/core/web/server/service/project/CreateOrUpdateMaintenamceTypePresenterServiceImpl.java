package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCMaintenamceType;
import com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateMaintenamceTypePresenterService;
import com.fudanmed.platform.core.web.server.service.project.MaintenamceTypeMapper;
import com.fudanmed.platform.core.web.shared.project.UIMaintenamceType;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.CreateOrUpdateMaintenamceTypePresenterService")
@Transactional
public class CreateOrUpdateMaintenamceTypePresenterServiceImpl extends BaseService implements CreateOrUpdateMaintenamceTypePresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private MaintenamceTypeMapper mapper;
  
  public UIMaintenamceType loadValue(final RCMaintenamceTypeProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCMaintenamceType _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.domain.RCMaintenamceType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIMaintenamceType _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIMaintenamceType uivalue) throws SessionTimeOutException, ValidationException {
    RCMaintenamceType _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.domain.RCMaintenamceType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public RCMaintenamceTypeProxy createValue(final UIMaintenamceType uivalue) throws SessionTimeOutException, ValidationException {
    RCMaintenamceTypeProxy _xblockexpression = null;
    {
      RCMaintenamceType value = this.entities.<RCMaintenamceType>create(RCMaintenamceType.class);
      this.mapper.transform(uivalue, value);
      RCMaintenamceTypeProxy _proxy = value.toProxy();
      _xblockexpression = (_proxy);
    }
    return _xblockexpression;
  }
}
