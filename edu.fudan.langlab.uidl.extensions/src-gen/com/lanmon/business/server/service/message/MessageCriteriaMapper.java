package com.lanmon.business.server.service.message;

import com.lanmon.business.shared.message.GWTMessageCriteria;
import com.lanmon.workflow.business.MessageCriteria;
import com.uniquesoft.gwt.shared.datatype.DateRange;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.lanmon.business.server.service.message.MessageCriteriaMapper")
public class MessageCriteriaMapper extends AbstractDataTypeMapper<GWTMessageCriteria,MessageCriteria> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final GWTMessageCriteria from, final MessageCriteria to) {
    to.setCustomer(convertService.toValue(com.lanmon.workflow.business.Customer.class,from.getCustomer()));
    to.setTitle(convertService.toValue(java.lang.String.class,from.getTitle()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final GWTMessageCriteria _gwt, final MessageCriteria _entity) {
    DateRange _triggerDate = _gwt.getTriggerDate();
    Date _startDate = _triggerDate==null?(Date)null:_triggerDate.getStartDate();
    _entity.setTriggerDateFrom(_startDate);
    DateRange _triggerDate_1 = _gwt.getTriggerDate();
    Date _finishDate = _triggerDate_1==null?(Date)null:_triggerDate_1.getFinishDate();
    _entity.setTriggerDateTo(_finishDate);
  }
  
  public GWTMessageCriteria copyFromEntity(final GWTMessageCriteria result, final MessageCriteria entity) {
    if(entity==null) return null;
    return result;
    
  }
  
  public GWTMessageCriteria buildFrom(final MessageCriteria entity) {
    if(entity==null) return null;
    com.lanmon.business.shared.message.GWTMessageCriteria result = new com.lanmon.business.shared.message.GWTMessageCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return GWTMessageCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return MessageCriteria.class;
  }
}
