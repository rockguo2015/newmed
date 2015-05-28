package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummaryCriteria;
import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductWarehouseStorageSummaryProxy;
import com.fudanmed.platform.core.web.client.warehouse.ProductWarehouseStorageSummaryManagementPresenterService;
import com.fudanmed.platform.core.web.server.service.warehouse.ProductWarehouseStorageSummaryCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.warehouse.ProductWarehouseStorageSummaryMapper;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummaryCriteria;
import com.google.common.base.Function;
import com.uniquesoft.gwt.server.common.pager.PagedQueries;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.domain.organization.Party;
import edu.fudan.langlab.domain.security.ISystemUserService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.warehouse.ProductWarehouseStorageSummaryManagementPresenterService")
@Transactional
public class ProductWarehouseStorageSummaryManagementPresenterServiceImpl extends BaseService implements ProductWarehouseStorageSummaryManagementPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProductWarehouseStorageSummaryCriteriaMapper criteriaMapper;
  
  @Autowired
  private ProductWarehouseStorageSummaryMapper mapper;
  
  @Autowired
  private ISystemUserService systemUserService;
  
  public IPagedResult<UIProductWarehouseStorageSummary> filter(final UIProductWarehouseStorageSummaryCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UIProductWarehouseStorageSummary> _xblockexpression = null;
    {
      RCProductWarehouseStorageSummaryCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCProductWarehouseStorageSummaryCriteria.class, this.criteriaMapper, this.entities);
      final Function1<RCProductWarehouseStorageSummary,UIProductWarehouseStorageSummary> _function = new Function1<RCProductWarehouseStorageSummary,UIProductWarehouseStorageSummary>() {
          public UIProductWarehouseStorageSummary apply(final RCProductWarehouseStorageSummary it) {
            UIProductWarehouseStorageSummary _apply = ProductWarehouseStorageSummaryManagementPresenterServiceImpl.this.mapper.apply(it);
            return _apply;
          }
        };
      IPagedResult<UIProductWarehouseStorageSummary> _listAndTransform = PagedQueries.<UIProductWarehouseStorageSummary, RCProductWarehouseStorageSummary>listAndTransform(c, new Function<RCProductWarehouseStorageSummary,UIProductWarehouseStorageSummary>() {
          public UIProductWarehouseStorageSummary apply(RCProductWarehouseStorageSummary input) {
            return _function.apply(input);
          }
      });
      _xblockexpression = (_listAndTransform);
    }
    return _xblockexpression;
  }
  
  public void delete(final RCProductWarehouseStorageSummaryProxy value) throws SessionTimeOutException, ValidationException {
    RCProductWarehouseStorageSummary _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    this.entities.delete( _resolved);
  }
  
  public RCProductSpecificationProxy getProductSpec(final RCProductWarehouseStorageSummaryProxy value) throws SessionTimeOutException, ValidationException {
    RCProductWarehouseStorageSummary _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    RCProductSpecification _productSpec =  _resolved.getProductSpec();
    RCProductSpecificationProxy _proxy = _productSpec.toProxy();
    return _proxy;
  }
  
  public RCEmployeeProxy loadCurrentUser() throws SessionTimeOutException, ValidationException {
    Party _currentUserAsParty = this.systemUserService.getCurrentUserAsParty();
    RCEmployeeProxy _proxy = ((RCEmployee) _currentUserAsParty).toProxy();
    return _proxy;
  }
}
