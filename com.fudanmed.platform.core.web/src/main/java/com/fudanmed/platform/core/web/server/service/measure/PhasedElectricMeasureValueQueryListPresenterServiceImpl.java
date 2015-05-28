package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.measure.RCMeasureValue;
import com.fudanmed.platform.core.measure.RCMeasureValueCriteria;
import com.fudanmed.platform.core.measure.RCPhasedElectricMeasureValue;
import com.fudanmed.platform.core.web.client.measure.PhasedElectricMeasureValueQueryListPresenterService;
import com.fudanmed.platform.core.web.server.service.measure.MeasureValueCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.measure.PhasedElectricMeasureValueMapper;
import com.fudanmed.platform.core.web.shared.measure.UIMeasureValueCriteria;
import com.fudanmed.platform.core.web.shared.measure.UIPhasedElectricMeasureValue;
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

@Service("com.fudanmed.platform.core.web.client.measure.PhasedElectricMeasureValueQueryListPresenterService")
@Transactional
public class PhasedElectricMeasureValueQueryListPresenterServiceImpl extends BaseService implements PhasedElectricMeasureValueQueryListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private MeasureValueCriteriaMapper criteriaMapper;
  
  @Autowired
  private PhasedElectricMeasureValueMapper mapper;
  
  public IPagedResult<UIPhasedElectricMeasureValue> filter(final UIMeasureValueCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UIPhasedElectricMeasureValue> _xblockexpression = null;
    {
      RCMeasureValueCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCMeasureValueCriteria.class, this.criteriaMapper, this.entities);
      final Function1<RCMeasureValue,UIPhasedElectricMeasureValue> _function = new Function1<RCMeasureValue,UIPhasedElectricMeasureValue>() {
          public UIPhasedElectricMeasureValue apply(final RCMeasureValue it) {
            UIPhasedElectricMeasureValue _apply = PhasedElectricMeasureValueQueryListPresenterServiceImpl.this.mapper.apply(((RCPhasedElectricMeasureValue) it));
            return _apply;
          }
        };
      IPagedResult<UIPhasedElectricMeasureValue> _listAndTransform = PagedQueries.<UIPhasedElectricMeasureValue, RCMeasureValue>listAndTransform(c, new Function<RCMeasureValue,UIPhasedElectricMeasureValue>() {
          public UIPhasedElectricMeasureValue apply(RCMeasureValue input) {
            return _function.apply(input);
          }
      });
      _xblockexpression = (_listAndTransform);
    }
    return _xblockexpression;
  }
}
