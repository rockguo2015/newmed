package com.lanmon.business.server.service.customer;

import com.lanmon.business.shared.customer.GWTCustomerCriteria4Sales;
import com.lanmon.workflow.business.CustomerCriteria4Sales;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.lanmon.business.server.service.customer.CustomerCriteria4SalesMapper")
public class CustomerCriteria4SalesMapper extends AbstractDataTypeMapper<GWTCustomerCriteria4Sales,CustomerCriteria4Sales> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final GWTCustomerCriteria4Sales from, final CustomerCriteria4Sales to) {
    to.setAddress(convertService.toValue(java.lang.String.class,from.getAddress()));
    to.setDomainCode(convertService.toValue(com.lanmon.workflow.business.DomainCode.class,from.getDomainCode()));
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    to.setPropertyCode(convertService.toValue(com.lanmon.workflow.business.PropertyCode.class,from.getPropertyCode()));
    to.setSales(convertService.toValue(com.lanmon.workflow.business.Employee.class,from.getSales()));
    to.setScaleCode(convertService.toValue(com.lanmon.workflow.business.ScaleCode.class,from.getScaleCode()));
    to.setStatus(convertService.toValue(com.lanmon.workflow.business.CustomerStatus.class,from.getStatus()));
    to.setAnnotation(convertService.toValue(java.lang.String.class,from.getAnnotation()));
    to.setContactType(convertService.toValue(com.lanmon.workflow.business.ContactCode.class,from.getContactType()));
    to.setEmailUpdateDate(convertService.toValue(java.util.Date.class,from.getEmailUpdateDate()));
    
  }
  
  public GWTCustomerCriteria4Sales copyFromEntity(final GWTCustomerCriteria4Sales result, final CustomerCriteria4Sales entity) {
    if(entity==null) return null;
    result.setAddress(convertService.toValue(java.lang.String.class,entity.getAddress()));
    result.setDomainCode(convertService.toValue(com.uniquesoft.gwt.shared.GWTNamedEntity.class,entity.getDomainCode()));
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    result.setPropertyCode(convertService.toValue(com.uniquesoft.gwt.shared.GWTNamedEntity.class,entity.getPropertyCode()));
    result.setSales(convertService.toValue(com.uniquesoft.gwt.shared.GWTNamedEntity.class,entity.getSales()));
    result.setScaleCode(convertService.toValue(com.uniquesoft.gwt.shared.GWTNamedEntity.class,entity.getScaleCode()));
    result.setStatus(convertService.toValue(com.lanmon.business.shared.customer.GWTCustomerStatus.class,entity.getStatus()));
    result.setAnnotation(convertService.toValue(java.lang.String.class,entity.getAnnotation()));
    result.setContactType(convertService.toValue(com.uniquesoft.gwt.shared.GWTNamedEntity.class,entity.getContactType()));
    result.setEmailUpdateDate(convertService.toValue(java.util.Date.class,entity.getEmailUpdateDate()));
    return result;
    
  }
  
  public GWTCustomerCriteria4Sales buildFrom(final CustomerCriteria4Sales entity) {
    if(entity==null) return null;
    com.lanmon.business.shared.customer.GWTCustomerCriteria4Sales result = new com.lanmon.business.shared.customer.GWTCustomerCriteria4Sales();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return GWTCustomerCriteria4Sales.class;
  }
  
  public Class<?> getEntityClass() {
    return CustomerCriteria4Sales.class;
  }
}
