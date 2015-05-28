package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLInHospitalLocation;
import com.fudanmed.platform.core.deliver.DLInHospitalLocationCriteria;
import com.fudanmed.platform.core.web.client.deliver.InHospitalLocationQueryListPresenterService;
import com.fudanmed.platform.core.web.server.service.deliver.InHospitalLocationCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.deliver.InHospitalLocationMapper;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalLocation;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalLocationCriteria;
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

@Service("com.fudanmed.platform.core.web.client.deliver.InHospitalLocationQueryListPresenterService")
@Transactional
public class InHospitalLocationQueryListPresenterServiceImpl extends BaseService implements InHospitalLocationQueryListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private InHospitalLocationCriteriaMapper criteriaMapper;
  
  @Autowired
  private InHospitalLocationMapper mapper;
  
  public IPagedResult<UIInHospitalLocation> filter(final UIInHospitalLocationCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UIInHospitalLocation> _xblockexpression = null;
    {
      DLInHospitalLocationCriteria c = PagedQueries.createPagedCriteria(uicriteria, DLInHospitalLocationCriteria.class, this.criteriaMapper, this.entities);
      final Function1<DLInHospitalLocation,UIInHospitalLocation> _function = new Function1<DLInHospitalLocation,UIInHospitalLocation>() {
          public UIInHospitalLocation apply(final DLInHospitalLocation it) {
            UIInHospitalLocation _apply = InHospitalLocationQueryListPresenterServiceImpl.this.mapper.apply(it);
            return _apply;
          }
        };
      IPagedResult<UIInHospitalLocation> _listAndTransform = PagedQueries.<UIInHospitalLocation, DLInHospitalLocation>listAndTransform(c, new Function<DLInHospitalLocation,UIInHospitalLocation>() {
          public UIInHospitalLocation apply(DLInHospitalLocation input) {
            return _function.apply(input);
          }
      });
      _xblockexpression = (_listAndTransform);
    }
    return _xblockexpression;
  }
}
