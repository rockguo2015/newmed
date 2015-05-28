package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverOrganization;
import com.fudanmed.platform.core.deliver.DLDeliverOrganizationCriteria;
import com.fudanmed.platform.core.web.client.deliver.DeliverOrganizationQueryListPresenterService;
import com.fudanmed.platform.core.web.server.service.deliver.DeliverOrganizationCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.deliver.DeliverOrganizationMapper;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverOrganization;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverOrganizationCriteria;
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

@Service("com.fudanmed.platform.core.web.client.deliver.DeliverOrganizationQueryListPresenterService")
@Transactional
public class DeliverOrganizationQueryListPresenterServiceImpl extends BaseService implements DeliverOrganizationQueryListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DeliverOrganizationCriteriaMapper criteriaMapper;
  
  @Autowired
  private DeliverOrganizationMapper mapper;
  
  public IPagedResult<UIDeliverOrganization> filter(final UIDeliverOrganizationCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UIDeliverOrganization> _xblockexpression = null;
    {
      DLDeliverOrganizationCriteria c = PagedQueries.createPagedCriteria(uicriteria, DLDeliverOrganizationCriteria.class, this.criteriaMapper, this.entities);
      final Function1<DLDeliverOrganization,UIDeliverOrganization> _function = new Function1<DLDeliverOrganization,UIDeliverOrganization>() {
          public UIDeliverOrganization apply(final DLDeliverOrganization it) {
            UIDeliverOrganization _apply = DeliverOrganizationQueryListPresenterServiceImpl.this.mapper.apply(it);
            return _apply;
          }
        };
      IPagedResult<UIDeliverOrganization> _listAndTransform = PagedQueries.<UIDeliverOrganization, DLDeliverOrganization>listAndTransform(c, new Function<DLDeliverOrganization,UIDeliverOrganization>() {
          public UIDeliverOrganization apply(DLDeliverOrganization input) {
            return _function.apply(input);
          }
      });
      _xblockexpression = (_listAndTransform);
    }
    return _xblockexpression;
  }
}
