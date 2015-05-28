package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCEmployeeDAO;
import com.fudanmed.platform.core.web.shared.organization.UIEmployee;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.extensions.ValidationExtensions;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.organization.EmployeeValidator")
public class EmployeeValidator implements IValidator<UIEmployee> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RCEmployeeDAO employeeDAO;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Boolean UniqueCheck(final UIEmployee _entity) {
    final Function1<UIEmployee,RCEmployee> _function = new Function1<UIEmployee,RCEmployee>() {
        public RCEmployee apply(final UIEmployee newValue) {
          String _eid = newValue.getEid();
          RCEmployee _findByEid = EmployeeValidator.this.employeeDAO.findByEid(_eid);
          return _findByEid;
        }
      };
    boolean _isUnique = ValidationExtensions.<UIEmployee>isUnique(new Function0<UIEmployee>() {
      public UIEmployee apply() {
        return _entity;
      }
    }.apply(), _function);
    return Boolean.valueOf(_isUnique);
  }
  
  public Collection<ValidationErrorItem> validate(final UIEmployee _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    if(_entity.getEid()!=null && !UniqueCheck(_entity)){
    	errors.add(new ValidationErrorItem("工号","员工工号必须唯一",com.google.common.collect.Lists.newArrayList("eid" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getEid());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("工号",rule.getMessage(),com.google.common.collect.Lists.newArrayList("eid" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getName());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("姓名",rule.getMessage(),com.google.common.collect.Lists.newArrayList("name" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getOrganization());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("所属机构",rule.getMessage(),com.google.common.collect.Lists.newArrayList("organization" )));
    }
    return errors;
    
  }
}
