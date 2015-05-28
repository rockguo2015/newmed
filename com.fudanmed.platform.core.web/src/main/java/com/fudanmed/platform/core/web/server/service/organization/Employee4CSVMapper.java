package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.web.server.service.organization.EmployeeValidator;
import com.fudanmed.platform.core.web.shared.organization.UIEmployee;
import com.google.common.base.Objects;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.langlab.domain.security.Role;
import edu.fudan.langlab.domain.security.proxy.RoleProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.organization.Employee4CSVMapper")
public class Employee4CSVMapper extends AbstractEntityMapper<UIEmployee,RCEmployee> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCEmployee loadEntityById(final Long id) {
    return entities.get(RCEmployee.class,id);
  }
  
  public RCEmployee create() {
    return entities.create(RCEmployee.class);
  }
  
  @Autowired
  private EmployeeValidator validator;
  
  public void copyToEntity(final UIEmployee from, final RCEmployee to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setEid(convertService.toValue(java.lang.String.class,from.getEid()));
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    to.setMobil(convertService.toValue(java.lang.String.class,from.getMobil()));
    to.setTel(convertService.toValue(java.lang.String.class,from.getTel()));
    to.setWorkTel(convertService.toValue(java.lang.String.class,from.getWorkTel()));
    to.setEmail(convertService.toValue(java.lang.String.class,from.getEmail()));
    to.setAddress(convertService.toValue(java.lang.String.class,from.getAddress()));
    to.setOrganization(convertService.toValue(com.fudanmed.platform.core.domain.RCOrganization.class,from.getOrganization()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final UIEmployee _gwt, final RCEmployee _entity) {
    String orgp = "";
    RCOrganization curOrg = _entity.getOrganization();
    boolean _notEquals = (!Objects.equal(curOrg, null));
    boolean _while = _notEquals;
    while (_while) {
      {
        String _plus = (orgp + "[");
        Long _id = curOrg.getId();
        String _string = _id.toString();
        String _plus_1 = (_plus + _string);
        String _plus_2 = (_plus_1 + "]");
        orgp = _plus_2;
        RCOrganization _parent = curOrg.getParent();
        curOrg = _parent;
      }
      boolean _notEquals_1 = (!Objects.equal(curOrg, null));
      _while = _notEquals_1;
    }
    _entity.setOrgPath(orgp);
  }
  
  public UIEmployee copyFromEntity(final UIEmployee result, final RCEmployee entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setEid(convertService.toValue(java.lang.String.class,entity.getEid()));
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    result.setMobil(convertService.toValue(java.lang.String.class,entity.getMobil()));
    result.setTel(convertService.toValue(java.lang.String.class,entity.getTel()));
    result.setWorkTel(convertService.toValue(java.lang.String.class,entity.getWorkTel()));
    result.setEmail(convertService.toValue(java.lang.String.class,entity.getEmail()));
    result.setAddress(convertService.toValue(java.lang.String.class,entity.getAddress()));
    result.setOrganization(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy.class,entity.getOrganization()));
    buildFromCust(result,entity);
    return result;
    
  }
  
  public UIEmployee buildFrom(final RCEmployee entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.organization.UIEmployee result = new com.fudanmed.platform.core.web.shared.organization.UIEmployee();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  protected void buildFromCust(final UIEmployee _gwt, final RCEmployee _entity) {
    Collection<Role> _roles = _entity.getRoles();
    final Function1<Role,RoleProxy> _function = new Function1<Role,RoleProxy>() {
        public RoleProxy apply(final Role it) {
          RoleProxy _proxy = it.toProxy();
          return _proxy;
        }
      };
    Iterable<RoleProxy> _map = IterableExtensions.<Role, RoleProxy>map(_roles, _function);
    Collection<RoleProxy> _unlazy = IterableExtensions2.<RoleProxy>unlazy(_map);
    _gwt.setRoles(_unlazy);
  }
  
  public Class<?> getUIClass() {
    return UIEmployee.class;
  }
  
  public Class<?> getEntityClass() {
    return RCEmployee.class;
  }
}
