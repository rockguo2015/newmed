package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.measure.RCMeasureValue;
import com.fudanmed.platform.core.measure.RCMeasureValueCriteria;
import com.fudanmed.platform.core.web.client.measure.MeasureValueQueryListPresenterService;
import com.fudanmed.platform.core.web.server.service.measure.MeasureValueCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.measure.MeasureValueMapper;
import com.fudanmed.platform.core.web.shared.measure.UIMeasureValue;
import com.fudanmed.platform.core.web.shared.measure.UIMeasureValueCriteria;
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

@Service("com.fudanmed.platform.core.web.client.measure.MeasureValueQueryListPresenterService")
@Transactional
public class MeasureValueQueryListPresenterServiceImpl extends BaseService implements MeasureValueQueryListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private MeasureValueCriteriaMapper criteriaMapper;
  
  @Autowired
  private MeasureValueMapper mapper;
  
  public IPagedResult<UIMeasureValue> filter(final UIMeasureValueCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UIMeasureValue> _xblockexpression = null;
    {
      RCMeasureValueCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCMeasureValueCriteria.class, this.criteriaMapper, this.entities);
      final Function1<RCMeasureValue,UIMeasureValue> _function = new Function1<RCMeasureValue,UIMeasureValue>() {
          public UIMeasureValue apply(final RCMeasureValue it) {
            UIMeasureValue _apply = MeasureValueQueryListPresenterServiceImpl.this.mapper.apply(it);
            return _apply;
          }
        };
      IPagedResult<UIMeasureValue> _listAndTransform = PagedQueries.<UIMeasureValue, RCMeasureValue>listAndTransform(c, new Function<RCMeasureValue,UIMeasureValue>() {
          public UIMeasureValue apply(RCMeasureValue input) {
            return _function.apply(input);
          }
      });
      _xblockexpression = (_listAndTransform);
    }
    return _xblockexpression;
  }
}
