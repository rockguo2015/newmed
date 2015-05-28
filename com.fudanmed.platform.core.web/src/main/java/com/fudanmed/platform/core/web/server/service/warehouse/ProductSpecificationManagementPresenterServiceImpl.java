package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductSpecificationCriteria;
import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationManagementPresenterService;
import com.fudanmed.platform.core.web.server.service.warehouse.ProductSpecificationCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.warehouse.ProductSpecificationMapper;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecificationCriteria;
import com.google.common.base.Function;
import com.uniquesoft.gwt.server.common.pager.PagedQueries;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationManagementPresenterService")
@Transactional
public class ProductSpecificationManagementPresenterServiceImpl extends BaseService implements ProductSpecificationManagementPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProductSpecificationCriteriaMapper criteriaMapper;
  
  @Autowired
  private ProductSpecificationMapper mapper;
  
  public IPagedResult<UIProductSpecification> filter(final UIProductSpecificationCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UIProductSpecification> _xblockexpression = null;
    {
      RCProductSpecificationCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCProductSpecificationCriteria.class, this.criteriaMapper, this.entities);
      final Function1<RCProductSpecification,UIProductSpecification> _function = new Function1<RCProductSpecification,UIProductSpecification>() {
          public UIProductSpecification apply(final RCProductSpecification it) {
            UIProductSpecification _apply = ProductSpecificationManagementPresenterServiceImpl.this.mapper.apply(it);
            return _apply;
          }
        };
      IPagedResult<UIProductSpecification> _listAndTransform = PagedQueries.<UIProductSpecification, RCProductSpecification>listAndTransform(c, new Function<RCProductSpecification,UIProductSpecification>() {
          public UIProductSpecification apply(RCProductSpecification input) {
            return _function.apply(input);
          }
      });
      _xblockexpression = (_listAndTransform);
    }
    return _xblockexpression;
  }
  
  public void delete(final RCProductSpecificationProxy value) throws SessionTimeOutException, ValidationException {
    RCProductSpecification _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCProductSpecification)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    this.entities.delete( _resolved);
  }
}
