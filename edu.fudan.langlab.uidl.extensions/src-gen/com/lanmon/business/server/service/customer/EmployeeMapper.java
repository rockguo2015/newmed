package com.lanmon.business.server.service.customer;

import com.lanmon.business.server.service.customer.EmployeeValidator;
import com.lanmon.business.shared.customer.GWTEmployee;
import com.lanmon.workflow.business.Employee;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.lanmon.business.server.service.customer.EmployeeMapper")
public class EmployeeMapper extends AbstractEntityMapper<GWTEmployee,Employee> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public Employee loadEntityById(final Long id) {
    return entities.get(Employee.class,id);
  }
  
  public Employee create() {
    return entities.create(Employee.class);
  }
  
  @Autowired
  private EmployeeValidator validator;
  
  public void copyToEntity(final GWTEmployee from, final Employee to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    to.setDirectManager(convertService.toValue(com.lanmon.workflow.business.Employee.class,from.getDirectManager()));
    to.setPhoneCountExpected(convertService.toValue(java.lang.Integer.class,from.getPhoneCountExpected()));
    to.getUser().setUserid(convertService.toValue(java.lang.String.class,from.getUserid()));
    to.getUser().setPasswd(convertService.toValue(java.lang.String.class,from.getPasswd()));
    to.getUser().setRoles(convertService.toCollectionValue(com.lanmon.workflow.business.Role.class,from.getRoles()));
    
  }
  
  public GWTEmployee copyFromEntity(final GWTEmployee result, final Employee entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    result.setDirectManager(convertService.toValue(com.uniquesoft.gwt.shared.GWTNamedEntity.class,entity.getDirectManager()));
    result.setPhoneCountExpected(convertService.toValue(java.lang.Integer.class,entity.getPhoneCountExpected()));
    if(entity. getUser()  != null )
    	result.setUserid(convertService.toValue(java.lang.String.class,entity.getUser().getUserid()));
    if(entity. getUser()  != null )
    	result.setPasswd(convertService.toValue(java.lang.String.class,entity.getUser().getPasswd()));
    if(entity. getUser()  != null )
    	result.setRoles(convertService.toCollectionValue(com.lanmon.business.shared.customer.GWTRole.class,entity.getUser().getRoles()));
    return result;
    
  }
  
  public GWTEmployee buildFrom(final Employee entity) {
    if(entity==null) return null;
    com.lanmon.business.shared.customer.GWTEmployee result = new com.lanmon.business.shared.customer.GWTEmployee();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return GWTEmployee.class;
  }
  
  public Class<?> getEntityClass() {
    return Employee.class;
  }
}
