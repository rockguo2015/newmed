package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.measure.RCMeasureValue;
import com.fudanmed.platform.core.measure.RCMeasureValueCriteria;
import com.fudanmed.platform.core.measure.RCWaterMeasureValue;
import com.fudanmed.platform.core.web.client.measure.WaterMeasureValueQueryListPresenterService;
import com.fudanmed.platform.core.web.server.service.measure.MeasureValueCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.measure.WaterMeasureValueMapper;
import com.fudanmed.platform.core.web.shared.measure.UIMeasureValueCriteria;
import com.fudanmed.platform.core.web.shared.measure.UIWaterMeasureValue;
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

@Service("com.fudanmed.platform.core.web.client.measure.WaterMeasureValueQueryListPresenterService")
@Transactional
public class WaterMeasureValueQueryListPresenterServiceImpl extends BaseService implements WaterMeasureValueQueryListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private MeasureValueCriteriaMapper criteriaMapper;
  
  @Autowired
  private WaterMeasureValueMapper mapper;
  
  public IPagedResult<UIWaterMeasureValue> filter(final UIMeasureValueCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UIWaterMeasureValue> _xblockexpression = null;
    {
      RCMeasureValueCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCMeasureValueCriteria.class, this.criteriaMapper, this.entities);
      final Function1<RCMeasureValue,UIWaterMeasureValue> _function = new Function1<RCMeasureValue,UIWaterMeasureValue>() {
          public UIWaterMeasureValue apply(final RCMeasureValue it) {
            UIWaterMeasureValue _apply = WaterMeasureValueQueryListPresenterServiceImpl.this.mapper.apply(((RCWaterMeasureValue) it));
            return _apply;
          }
        };
      IPagedResult<UIWaterMeasureValue> _listAndTransform = PagedQueries.<UIWaterMeasureValue, RCMeasureValue>listAndTransform(c, new Function<RCMeasureValue,UIWaterMeasureValue>() {
          public UIWaterMeasureValue apply(RCMeasureValue input) {
            return _function.apply(input);
          }
      });
      _xblockexpression = (_listAndTransform);
    }
    return _xblockexpression;
  }
}
