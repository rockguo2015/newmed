package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.measure.RCGasMeasureValue;
import com.fudanmed.platform.core.measure.RCMeasureValue;
import com.fudanmed.platform.core.measure.RCMeasureValueCriteria;
import com.fudanmed.platform.core.web.client.measure.GasMeasureValueQueryListPresenterService;
import com.fudanmed.platform.core.web.server.service.measure.GasMeasureValueMapper;
import com.fudanmed.platform.core.web.server.service.measure.MeasureValueCriteriaMapper;
import com.fudanmed.platform.core.web.shared.measure.UIGasMeasureValue;
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

@Service("com.fudanmed.platform.core.web.client.measure.GasMeasureValueQueryListPresenterService")
@Transactional
public class GasMeasureValueQueryListPresenterServiceImpl extends BaseService implements GasMeasureValueQueryListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private MeasureValueCriteriaMapper criteriaMapper;
  
  @Autowired
  private GasMeasureValueMapper mapper;
  
  public IPagedResult<UIGasMeasureValue> filter(final UIMeasureValueCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UIGasMeasureValue> _xblockexpression = null;
    {
      RCMeasureValueCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCMeasureValueCriteria.class, this.criteriaMapper, this.entities);
      final Function1<RCMeasureValue,UIGasMeasureValue> _function = new Function1<RCMeasureValue,UIGasMeasureValue>() {
          public UIGasMeasureValue apply(final RCMeasureValue it) {
            UIGasMeasureValue _apply = GasMeasureValueQueryListPresenterServiceImpl.this.mapper.apply(((RCGasMeasureValue) it));
            return _apply;
          }
        };
      IPagedResult<UIGasMeasureValue> _listAndTransform = PagedQueries.<UIGasMeasureValue, RCMeasureValue>listAndTransform(c, new Function<RCMeasureValue,UIGasMeasureValue>() {
          public UIGasMeasureValue apply(RCMeasureValue input) {
            return _function.apply(input);
          }
      });
      _xblockexpression = (_listAndTransform);
    }
    return _xblockexpression;
  }
}
