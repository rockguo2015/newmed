package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.domain.RCEmployeeCriteria;
import com.fudanmed.platform.core.web.shared.organization.UIEmployeeCriteria;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.organization.EmployeeCriteriaMapper")
public class EmployeeCriteriaMapper extends AbstractDataTypeMapper<UIEmployeeCriteria,RCEmployeeCriteria> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UIEmployeeCriteria from, final RCEmployeeCriteria to) {
    to.setInfo(convertService.toValue(java.lang.String.class,from.getInfo()));
    to.setOrganization(convertService.toValue(com.fudanmed.platform.core.domain.RCOrganization.class,from.getOrganization()));
    to.setOrgPath(convertService.toValue(java.lang.String.class,from.getOrgPath()));
    to.setIncludeLeaveEmployees(convertService.toValue(java.lang.Boolean.class,from.getIncludeLeaveEmployees()));
    
  }
  
  public UIEmployeeCriteria copyFromEntity(final UIEmployeeCriteria result, final RCEmployeeCriteria entity) {
    if(entity==null) return null;
    result.setInfo(convertService.toValue(java.lang.String.class,entity.getInfo()));
    result.setOrganization(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy.class,entity.getOrganization()));
    result.setOrgPath(convertService.toValue(java.lang.String.class,entity.getOrgPath()));
    result.setIncludeLeaveEmployees(convertService.toValue(java.lang.Boolean.class,entity.getIncludeLeaveEmployees()));
    return result;
    
  }
  
  public UIEmployeeCriteria buildFrom(final RCEmployeeCriteria entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.organization.UIEmployeeCriteria result = new com.fudanmed.platform.core.web.shared.organization.UIEmployeeCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIEmployeeCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return RCEmployeeCriteria.class;
  }
}
