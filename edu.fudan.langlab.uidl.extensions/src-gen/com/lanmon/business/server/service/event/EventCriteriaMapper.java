package com.lanmon.business.server.service.event;

import com.google.common.base.Objects;
import com.lanmon.business.shared.event.GWTEventCriteria;
import com.lanmon.workflow.business.EventCriteria;
import com.uniquesoft.gwt.shared.datatype.DateRange;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.lanmon.business.server.service.event.EventCriteriaMapper")
public class EventCriteriaMapper extends AbstractDataTypeMapper<GWTEventCriteria,EventCriteria> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final GWTEventCriteria from, final EventCriteria to) {
    to.setCustomer(convertService.toValue(com.lanmon.workflow.business.Customer.class,from.getCustomer()));
    to.setMessage(convertService.toValue(java.lang.String.class,from.getMessage()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final GWTEventCriteria _gwt, final EventCriteria _entity) {
    DateRange _dateRange = _gwt.getDateRange();
    boolean _notEquals = (!Objects.equal(_dateRange, null));
    if (_notEquals) {
      DateRange _dateRange_1 = _gwt.getDateRange();
      Date _startDate = _dateRange_1.getStartDate();
      _entity.setDateFrom(_startDate);
      DateRange _dateRange_2 = _gwt.getDateRange();
      Date _finishDate = _dateRange_2.getFinishDate();
      _entity.setDateTo(_finishDate);
    }
  }
  
  public GWTEventCriteria copyFromEntity(final GWTEventCriteria result, final EventCriteria entity) {
    if(entity==null) return null;
    result.setCustomer(convertService.toValue(com.uniquesoft.gwt.shared.GWTNamedEntity.class,entity.getCustomer()));
    result.setMessage(convertService.toValue(java.lang.String.class,entity.getMessage()));
    return result;
    
  }
  
  public GWTEventCriteria buildFrom(final EventCriteria entity) {
    if(entity==null) return null;
    com.lanmon.business.shared.event.GWTEventCriteria result = new com.lanmon.business.shared.event.GWTEventCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return GWTEventCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return EventCriteria.class;
  }
}
