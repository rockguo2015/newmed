package edu.fudan.langlab.uidl.domain.app.server.service.security;

import com.google.common.base.Objects;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.extensions.ValidationExtensions;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.langlab.domain.security.Role;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIRole;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("edu.fudan.langlab.uidl.domain.app.server.service.security.RoleValidator")
public class RoleValidator implements IValidator<UIRole> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Boolean C1(final UIRole _entity) {
    final Function1<UIRole,Role> _function = new Function1<UIRole,Role>() {
        public Role apply(final UIRole it) {
          Collection<Role> _all = RoleValidator.this.entities.<Role>all(Role.class);
          final Function1<Role,Boolean> _function = new Function1<Role,Boolean>() {
              public Boolean apply(final Role it) {
                String _roleId = it.getRoleId();
                String _roleId_1 = _entity.getRoleId();
                boolean _equals = Objects.equal(_roleId, _roleId_1);
                return Boolean.valueOf(_equals);
              }
            };
          Iterable<Role> _filter = IterableExtensions.<Role>filter(_all, _function);
          Role _head = IterableExtensions.<Role>head(_filter);
          return _head;
        }
      };
    boolean _isUnique = ValidationExtensions.<UIRole>isUnique(new Function0<UIRole>() {
      public UIRole apply() {
        return _entity;
      }
    }.apply(), _function);
    return Boolean.valueOf(_isUnique);
  }
  
  public Collection<ValidationErrorItem> validate(final UIRole _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    if(_entity.getRoleId()!=null && !C1(_entity)){
    	errors.add(new ValidationErrorItem("角色代码","角色代码必须唯一",com.google.common.collect.Lists.newArrayList("roleId" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getRoleId());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("角色代码",rule.getMessage(),com.google.common.collect.Lists.newArrayList("roleId" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getName());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("角色名称",rule.getMessage(),com.google.common.collect.Lists.newArrayList("name" )));
    }
    return errors;
    
  }
}
