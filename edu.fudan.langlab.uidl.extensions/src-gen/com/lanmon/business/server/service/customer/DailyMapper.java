package com.lanmon.business.server.service.customer;

import com.lanmon.business.shared.customer.GWTDaily;
import com.lanmon.workflow.business.Daily;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.lanmon.business.server.service.customer.DailyMapper")
public class DailyMapper extends AbstractEntityMapper<GWTDaily,Daily> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public Daily loadEntityById(final Long id) {
    return entities.get(Daily.class,id);
  }
  
  public Daily create() {
    return entities.create(Daily.class);
  }
  
  public void copyToEntity(final GWTDaily from, final Daily to) {
    to.setEmployee(convertService.toValue(com.lanmon.workflow.business.Employee.class,from.getEmployee()));
    to.setDate(convertService.toValue(java.util.Date.class,from.getDate()));
    to.setNote(convertService.toValue(java.lang.String.class,from.getNote()));
    to.setPhoneCount(convertService.toValue(java.lang.Integer.class,from.getPhoneCount()));
    to.setCreateCustomerCount(convertService.toValue(java.lang.Integer.class,from.getCreateCustomerCount()));
    to.setOnsiteCount(convertService.toValue(java.lang.Integer.class,from.getOnsiteCount()));
    
  }
  
  public GWTDaily copyFromEntity(final GWTDaily result, final Daily entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setEmployee(convertService.toValue(com.uniquesoft.gwt.shared.GWTNamedEntity.class,entity.getEmployee()));
    result.setDate(convertService.toValue(java.util.Date.class,entity.getDate()));
    result.setNote(convertService.toValue(java.lang.String.class,entity.getNote()));
    result.setPhoneCount(convertService.toValue(java.lang.Integer.class,entity.getPhoneCount()));
    result.setCreateCustomerCount(convertService.toValue(java.lang.Integer.class,entity.getCreateCustomerCount()));
    result.setOnsiteCount(convertService.toValue(java.lang.Integer.class,entity.getOnsiteCount()));
    return result;
    
  }
  
  public GWTDaily buildFrom(final Daily entity) {
    if(entity==null) return null;
    com.lanmon.business.shared.customer.GWTDaily result = new com.lanmon.business.shared.customer.GWTDaily();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return GWTDaily.class;
  }
  
  public Class<?> getEntityClass() {
    return Daily.class;
  }
}
