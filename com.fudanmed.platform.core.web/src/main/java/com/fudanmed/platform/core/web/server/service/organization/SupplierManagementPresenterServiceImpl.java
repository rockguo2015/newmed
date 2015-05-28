package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.domain.RCSupplier;
import com.fudanmed.platform.core.domain.RCSupplierCriteria;
import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.fudanmed.platform.core.web.client.organization.SupplierManagementPresenterService;
import com.fudanmed.platform.core.web.server.service.organization.SupplierCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.organization.SupplierMapper;
import com.fudanmed.platform.core.web.shared.organization.UISupplier;
import com.fudanmed.platform.core.web.shared.organization.UISupplierCriteria;
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

@Service("com.fudanmed.platform.core.web.client.organization.SupplierManagementPresenterService")
@Transactional
public class SupplierManagementPresenterServiceImpl extends BaseService implements SupplierManagementPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private SupplierCriteriaMapper criteriaMapper;
  
  @Autowired
  private SupplierMapper mapper;
  
  public IPagedResult<UISupplier> filter(final UISupplierCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UISupplier> _xblockexpression = null;
    {
      RCSupplierCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCSupplierCriteria.class, this.criteriaMapper, this.entities);
      final Function1<RCSupplier,UISupplier> _function = new Function1<RCSupplier,UISupplier>() {
          public UISupplier apply(final RCSupplier it) {
            UISupplier _apply = SupplierManagementPresenterServiceImpl.this.mapper.apply(it);
            return _apply;
          }
        };
      IPagedResult<UISupplier> _listAndTransform = PagedQueries.<UISupplier, RCSupplier>listAndTransform(c, new Function<RCSupplier,UISupplier>() {
          public UISupplier apply(RCSupplier input) {
            return _function.apply(input);
          }
      });
      _xblockexpression = (_listAndTransform);
    }
    return _xblockexpression;
  }
  
  public void delete(final RCSupplierProxy value) throws SessionTimeOutException, ValidationException {
    RCSupplier _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.domain.RCSupplier)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    this.entities.delete( _resolved);
  }
}
