package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.measure.RCElectricMeasureValue;
import com.fudanmed.platform.core.measure.RCMeasureValue;
import com.fudanmed.platform.core.measure.RCMeasureValueCriteria;
import com.fudanmed.platform.core.web.client.measure.ElectricMeasureValueQueryListPresenterService;
import com.fudanmed.platform.core.web.server.service.measure.ElectricMeasureValueMapper;
import com.fudanmed.platform.core.web.server.service.measure.MeasureValueCriteriaMapper;
import com.fudanmed.platform.core.web.shared.measure.UIElectricMeasureValue;
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

@Service("com.fudanmed.platform.core.web.client.measure.ElectricMeasureValueQueryListPresenterService")
@Transactional
public class ElectricMeasureValueQueryListPresenterServiceImpl extends BaseService implements ElectricMeasureValueQueryListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private MeasureValueCriteriaMapper criteriaMapper;
  
  @Autowired
  private ElectricMeasureValueMapper mapper;
  
  public IPagedResult<UIElectricMeasureValue> filter(final UIMeasureValueCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UIElectricMeasureValue> _xblockexpression = null;
    {
      RCMeasureValueCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCMeasureValueCriteria.class, this.criteriaMapper, this.entities);
      final Function1<RCMeasureValue,UIElectricMeasureValue> _function = new Function1<RCMeasureValue,UIElectricMeasureValue>() {
          public UIElectricMeasureValue apply(final RCMeasureValue it) {
            UIElectricMeasureValue _apply = ElectricMeasureValueQueryListPresenterServiceImpl.this.mapper.apply(((RCElectricMeasureValue) it));
            return _apply;
          }
        };
      IPagedResult<UIElectricMeasureValue> _listAndTransform = PagedQueries.<UIElectricMeasureValue, RCMeasureValue>listAndTransform(c, new Function<RCMeasureValue,UIElectricMeasureValue>() {
          public UIElectricMeasureValue apply(RCMeasureValue input) {
            return _function.apply(input);
          }
      });
      _xblockexpression = (_listAndTransform);
    }
    return _xblockexpression;
  }
}
