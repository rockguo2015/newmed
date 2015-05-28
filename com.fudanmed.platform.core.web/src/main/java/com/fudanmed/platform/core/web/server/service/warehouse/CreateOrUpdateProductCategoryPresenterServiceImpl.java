package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductCategory;
import com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateProductCategoryPresenterService;
import com.fudanmed.platform.core.web.server.service.warehouse.ProductCategoryMapper;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductCategory;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateProductCategoryPresenterService")
@Transactional
public class CreateOrUpdateProductCategoryPresenterServiceImpl extends BaseService implements CreateOrUpdateProductCategoryPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProductCategoryMapper mapper;
  
  public UIProductCategory loadValue(final RCProductCategoryProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCProductCategory _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCProductCategory)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIProductCategory _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIProductCategory uivalue) throws SessionTimeOutException, ValidationException {
    RCProductCategory _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCProductCategory)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public RCProductCategoryProxy createValue(final UIProductCategory uivalue) throws SessionTimeOutException, ValidationException {
    RCProductCategoryProxy _xblockexpression = null;
    {
      RCProductCategory value = this.entities.<RCProductCategory>create(RCProductCategory.class);
      this.mapper.transform(uivalue, value);
      RCProductCategoryProxy _proxy = value.toProxy();
      _xblockexpression = (_proxy);
    }
    return _xblockexpression;
  }
}
