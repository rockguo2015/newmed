package com.lanmon.business.server.service.customer;

import com.lanmon.business.shared.customer.GWTDailyCriteria;
import com.lanmon.workflow.business.DailyCriteria;
import com.uniquesoft.gwt.shared.datatype.DateRange;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.lanmon.business.server.service.customer.DailyCriteriaMapper")
public class DailyCriteriaMapper extends AbstractDataTypeMapper<GWTDailyCriteria,DailyCriteria> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final GWTDailyCriteria from, final DailyCriteria to) {
    to.setEmployee(convertService.toValue(com.lanmon.workflow.business.Employee.class,from.getEmployee()));
    to.setNote(convertService.toValue(java.lang.String.class,from.getNote()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final GWTDailyCriteria _gwt, final DailyCriteria _entity) {
    DateRange _dateRange = _gwt.getDateRange();
    Date _startDate = _dateRange.getStartDate();
    _entity.setDateFrom(_startDate);
    DateRange _dateRange_1 = _gwt.getDateRange();
    Date _finishDate = _dateRange_1.getFinishDate();
    _entity.setDateTo(_finishDate);
  }
  
  public GWTDailyCriteria copyFromEntity(final GWTDailyCriteria result, final DailyCriteria entity) {
    if(entity==null) return null;
    result.setEmployee(convertService.toValue(com.uniquesoft.gwt.shared.GWTNamedEntity.class,entity.getEmployee()));
    result.setNote(convertService.toValue(java.lang.String.class,entity.getNote()));
    return result;
    
  }
  
  public GWTDailyCriteria buildFrom(final DailyCriteria entity) {
    if(entity==null) return null;
    com.lanmon.business.shared.customer.GWTDailyCriteria result = new com.lanmon.business.shared.customer.GWTDailyCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return GWTDailyCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return DailyCriteria.class;
  }
}
