package com.lanmon.business.server.service.customer;

import com.lanmon.business.shared.customer.GWTNormalCustomerCriteria4Admin;
import com.lanmon.workflow.business.NormalCustomerCriteria4Admin;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.lanmon.business.server.service.customer.NormalCustomerCriteria4AdminMapper")
public class NormalCustomerCriteria4AdminMapper extends AbstractDataTypeMapper<GWTNormalCustomerCriteria4Admin,NormalCustomerCriteria4Admin> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final GWTNormalCustomerCriteria4Admin from, final NormalCustomerCriteria4Admin to) {
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    to.setPhone(convertService.toValue(java.lang.String.class,from.getPhone()));
    to.setInfo(convertService.toValue(java.lang.String.class,from.getInfo()));
    to.setStatus(convertService.toValue(com.lanmon.workflow.business.CustomerStatus.class,from.getStatus()));
    to.setNoPhoneSales(convertService.toValue(java.lang.Boolean.class,from.getNoPhoneSales()));
    to.setPhoneSales(convertService.toValue(com.lanmon.workflow.business.Employee.class,from.getPhoneSales()));
    to.setOnsiteSales(convertService.toValue(com.lanmon.workflow.business.Employee.class,from.getOnsiteSales()));
    
  }
  
  public GWTNormalCustomerCriteria4Admin copyFromEntity(final GWTNormalCustomerCriteria4Admin result, final NormalCustomerCriteria4Admin entity) {
    if(entity==null) return null;
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    result.setPhone(convertService.toValue(java.lang.String.class,entity.getPhone()));
    result.setInfo(convertService.toValue(java.lang.String.class,entity.getInfo()));
    result.setStatus(convertService.toValue(com.lanmon.business.shared.customer.GWTCustomerStatus.class,entity.getStatus()));
    result.setNoPhoneSales(convertService.toValue(java.lang.Boolean.class,entity.getNoPhoneSales()));
    result.setPhoneSales(convertService.toValue(com.uniquesoft.gwt.shared.GWTNamedEntity.class,entity.getPhoneSales()));
    result.setOnsiteSales(convertService.toValue(com.uniquesoft.gwt.shared.GWTNamedEntity.class,entity.getOnsiteSales()));
    return result;
    
  }
  
  public GWTNormalCustomerCriteria4Admin buildFrom(final NormalCustomerCriteria4Admin entity) {
    if(entity==null) return null;
    com.lanmon.business.shared.customer.GWTNormalCustomerCriteria4Admin result = new com.lanmon.business.shared.customer.GWTNormalCustomerCriteria4Admin();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return GWTNormalCustomerCriteria4Admin.class;
  }
  
  public Class<?> getEntityClass() {
    return NormalCustomerCriteria4Admin.class;
  }
}
