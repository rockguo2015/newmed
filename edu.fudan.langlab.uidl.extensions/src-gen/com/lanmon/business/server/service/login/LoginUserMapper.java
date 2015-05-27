package com.lanmon.business.server.service.login;

import com.lanmon.business.shared.login.GWTLoginUser;
import com.lanmon.workflow.business.EmployeeUser;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.lanmon.business.server.service.login.LoginUserMapper")
public class LoginUserMapper extends AbstractEntityMapper<GWTLoginUser,EmployeeUser> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public EmployeeUser loadEntityById(final Long id) {
    return entities.get(EmployeeUser.class,id);
  }
  
  public EmployeeUser create() {
    return entities.create(EmployeeUser.class);
  }
  
  public void copyToEntity(final GWTLoginUser from, final EmployeeUser to) {
    
  }
  
  public GWTLoginUser copyFromEntity(final GWTLoginUser result, final EmployeeUser entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setRoles(convertService.toCollectionValue(com.lanmon.business.shared.customer.GWTRole.class,entity.getRoles()));
    result.setUserid(convertService.toValue(java.lang.String.class,entity.getUserid()));
    if(entity. getEmployee()  != null )
    	result.setUserName(convertService.toValue(java.lang.String.class,entity.getEmployee().getName()));
    if(entity. getEmployee()  != null )
    	result.setPhoneCountExpected(convertService.toValue(java.lang.Integer.class,entity.getEmployee().getPhoneCountExpected()));
    return result;
    
  }
  
  public GWTLoginUser buildFrom(final EmployeeUser entity) {
    if(entity==null) return null;
    com.lanmon.business.shared.login.GWTLoginUser result = new com.lanmon.business.shared.login.GWTLoginUser();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return GWTLoginUser.class;
  }
  
  public Class<?> getEntityClass() {
    return EmployeeUser.class;
  }
}
