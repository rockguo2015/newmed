package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductCategory;
import com.fudanmed.platform.core.warehouse.RCProductType;
import com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductTypeProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateProductTypePresenterService;
import com.fudanmed.platform.core.web.server.service.warehouse.ProductTypeMapper;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductType;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateProductTypePresenterService")
@Transactional
public class CreateOrUpdateProductTypePresenterServiceImpl extends BaseService implements CreateOrUpdateProductTypePresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProductTypeMapper mapper;
  
  public UIProductType loadValue(final RCProductTypeProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCProductType _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCProductType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIProductType _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIProductType uivalue) throws SessionTimeOutException, ValidationException {
    RCProductType _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCProductType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public void createValue(final RCProductCategoryProxy parent, final UIProductType uivalue) throws SessionTimeOutException, ValidationException {
    RCProductCategory _resolved= null;
    if(parent!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCProductCategory)com.uniquesoft.uidl.extensions.ModelObjects.resolve(parent, entities);
    
    RCProductType value =  _resolved.createAndAddtoProductTypes();
    this.mapper.transform(uivalue, value);
  }
}
