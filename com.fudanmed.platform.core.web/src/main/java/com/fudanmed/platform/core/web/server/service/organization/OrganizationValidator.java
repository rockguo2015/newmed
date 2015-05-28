package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.RCOrganizationDAO;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
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

@Component("com.fudanmed.platform.core.web.server.service.organization.OrganizationValidator")
public class OrganizationValidator implements IValidator<UIOrganization> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RCOrganizationDAO organizationDAO;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Boolean CodeIsUnique(final UIOrganization _entity) {
    final Function1<UIOrganization,RCOrganization> _function = new Function1<UIOrganization,RCOrganization>() {
        public RCOrganization apply(final UIOrganization newValue) {
          String _code = newValue.getCode();
          RCOrganization _findByCode = OrganizationValidator.this.organizationDAO.findByCode(_code);
          return _findByCode;
        }
      };
    boolean _isUnique = ValidationExtensions.<UIOrganization>isUnique(new Function0<UIOrganization>() {
      public UIOrganization apply() {
        return _entity;
      }
    }.apply(), _function);
    return Boolean.valueOf(_isUnique);
  }
  
  public Collection<ValidationErrorItem> validate(final UIOrganization _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    if(_entity.getCode()!=null && !CodeIsUnique(_entity)){
    	errors.add(new ValidationErrorItem("代码","机构代码必须唯一",com.google.common.collect.Lists.newArrayList("code" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getCode());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("代码",rule.getMessage(),com.google.common.collect.Lists.newArrayList("code" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getName());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("名称",rule.getMessage(),com.google.common.collect.Lists.newArrayList("name" )));
    }
    return errors;
    
  }
}
