package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckType;
import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckTypeCriteria;
import com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckTypeQueryListPresenterService;
import com.fudanmed.platform.core.web.server.service.deliver.DeliverPatientCheckTypeCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.deliver.DeliverPatientCheckTypeMapper;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckType;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckTypeCriteria;
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

@Service("com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckTypeQueryListPresenterService")
@Transactional
public class DeliverPatientCheckTypeQueryListPresenterServiceImpl extends BaseService implements DeliverPatientCheckTypeQueryListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DeliverPatientCheckTypeCriteriaMapper criteriaMapper;
  
  @Autowired
  private DeliverPatientCheckTypeMapper mapper;
  
  public IPagedResult<UIDeliverPatientCheckType> filter(final UIDeliverPatientCheckTypeCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UIDeliverPatientCheckType> _xblockexpression = null;
    {
      DLDeliverPatientCheckTypeCriteria c = PagedQueries.createPagedCriteria(uicriteria, DLDeliverPatientCheckTypeCriteria.class, this.criteriaMapper, this.entities);
      final Function1<DLDeliverPatientCheckType,UIDeliverPatientCheckType> _function = new Function1<DLDeliverPatientCheckType,UIDeliverPatientCheckType>() {
          public UIDeliverPatientCheckType apply(final DLDeliverPatientCheckType it) {
            UIDeliverPatientCheckType _apply = DeliverPatientCheckTypeQueryListPresenterServiceImpl.this.mapper.apply(it);
            return _apply;
          }
        };
      IPagedResult<UIDeliverPatientCheckType> _listAndTransform = PagedQueries.<UIDeliverPatientCheckType, DLDeliverPatientCheckType>listAndTransform(c, new Function<DLDeliverPatientCheckType,UIDeliverPatientCheckType>() {
          public UIDeliverPatientCheckType apply(DLDeliverPatientCheckType input) {
            return _function.apply(input);
          }
      });
      _xblockexpression = (_listAndTransform);
    }
    return _xblockexpression;
  }
}
