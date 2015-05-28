package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLCheckOrganization;
import com.fudanmed.platform.core.deliver.DLCheckOrganizationCriteria;
import com.fudanmed.platform.core.web.client.deliver.CheckOrganizationQueryListPresenterService;
import com.fudanmed.platform.core.web.server.service.deliver.CheckOrganizationCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.deliver.CheckOrganizationMapper;
import com.fudanmed.platform.core.web.shared.deliver.UICheckOrganization;
import com.fudanmed.platform.core.web.shared.deliver.UICheckOrganizationCriteria;
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

@Service("com.fudanmed.platform.core.web.client.deliver.CheckOrganizationQueryListPresenterService")
@Transactional
public class CheckOrganizationQueryListPresenterServiceImpl extends BaseService implements CheckOrganizationQueryListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private CheckOrganizationCriteriaMapper criteriaMapper;
  
  @Autowired
  private CheckOrganizationMapper mapper;
  
  public IPagedResult<UICheckOrganization> filter(final UICheckOrganizationCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UICheckOrganization> _xblockexpression = null;
    {
      DLCheckOrganizationCriteria c = PagedQueries.createPagedCriteria(uicriteria, DLCheckOrganizationCriteria.class, this.criteriaMapper, this.entities);
      final Function1<DLCheckOrganization,UICheckOrganization> _function = new Function1<DLCheckOrganization,UICheckOrganization>() {
          public UICheckOrganization apply(final DLCheckOrganization it) {
            UICheckOrganization _apply = CheckOrganizationQueryListPresenterServiceImpl.this.mapper.apply(it);
            return _apply;
          }
        };
      IPagedResult<UICheckOrganization> _listAndTransform = PagedQueries.<UICheckOrganization, DLCheckOrganization>listAndTransform(c, new Function<DLCheckOrganization,UICheckOrganization>() {
          public UICheckOrganization apply(DLCheckOrganization input) {
            return _function.apply(input);
          }
      });
      _xblockexpression = (_listAndTransform);
    }
    return _xblockexpression;
  }
}
