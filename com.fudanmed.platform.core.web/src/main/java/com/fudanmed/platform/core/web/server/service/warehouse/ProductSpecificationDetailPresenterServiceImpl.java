package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationDetailPresenterService;
import com.fudanmed.platform.core.web.server.service.warehouse.ProductSpecificationMapper;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationDetailPresenterService")
@Transactional
public class ProductSpecificationDetailPresenterServiceImpl extends BaseService implements ProductSpecificationDetailPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProductSpecificationMapper mapper;
  
  public UIProductSpecification loadDetail(final RCProductSpecificationProxy detail) throws SessionTimeOutException, ValidationException {
    RCProductSpecification _resolved= null;
    if(detail!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCProductSpecification)com.uniquesoft.uidl.extensions.ModelObjects.resolve(detail, entities);
    
    UIProductSpecification _transform = this.mapper.transform( _resolved);
    return _transform;
  }
}
