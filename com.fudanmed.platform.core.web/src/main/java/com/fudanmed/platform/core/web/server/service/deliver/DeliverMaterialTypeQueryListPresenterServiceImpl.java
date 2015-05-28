package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverMaterialType;
import com.fudanmed.platform.core.deliver.DLDeliverMaterialTypeCriteria;
import com.fudanmed.platform.core.web.client.deliver.DeliverMaterialTypeQueryListPresenterService;
import com.fudanmed.platform.core.web.server.service.deliver.DeliverMaterialTypeCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.deliver.DeliverMaterialTypeMapper;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialType;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialTypeCriteria;
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

@Service("com.fudanmed.platform.core.web.client.deliver.DeliverMaterialTypeQueryListPresenterService")
@Transactional
public class DeliverMaterialTypeQueryListPresenterServiceImpl extends BaseService implements DeliverMaterialTypeQueryListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DeliverMaterialTypeCriteriaMapper criteriaMapper;
  
  @Autowired
  private DeliverMaterialTypeMapper mapper;
  
  public IPagedResult<UIDeliverMaterialType> filter(final UIDeliverMaterialTypeCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UIDeliverMaterialType> _xblockexpression = null;
    {
      DLDeliverMaterialTypeCriteria c = PagedQueries.createPagedCriteria(uicriteria, DLDeliverMaterialTypeCriteria.class, this.criteriaMapper, this.entities);
      final Function1<DLDeliverMaterialType,UIDeliverMaterialType> _function = new Function1<DLDeliverMaterialType,UIDeliverMaterialType>() {
          public UIDeliverMaterialType apply(final DLDeliverMaterialType it) {
            UIDeliverMaterialType _apply = DeliverMaterialTypeQueryListPresenterServiceImpl.this.mapper.apply(it);
            return _apply;
          }
        };
      IPagedResult<UIDeliverMaterialType> _listAndTransform = PagedQueries.<UIDeliverMaterialType, DLDeliverMaterialType>listAndTransform(c, new Function<DLDeliverMaterialType,UIDeliverMaterialType>() {
          public UIDeliverMaterialType apply(DLDeliverMaterialType input) {
            return _function.apply(input);
          }
      });
      _xblockexpression = (_listAndTransform);
    }
    return _xblockexpression;
  }
}
