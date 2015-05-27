package com.lanmon.business.server.service.customer;

import com.lanmon.business.shared.customer.GWTEmployee;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import com.uniquesoft.uidl.validation.rules.StringLength;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.lanmon.business.server.service.customer.EmployeeValidator")
public class EmployeeValidator implements IValidator<GWTEmployee> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public void stringLength_name_init(final GWTEmployee _entity, final StringLength _rule) {
    _rule.setMaxLength(10);
  }
  
  public void stringLength_userid_init(final GWTEmployee _entity, final StringLength _rule) {
    _rule.setMinLength(3);
    _rule.setMaxLength(32);
  }
  
  public Collection<ValidationErrorItem> validate(final GWTEmployee _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getName());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("name is required","name"));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getUserid());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem(rule.getMessage(),"userid"));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getPasswd());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem(rule.getMessage(),"passwd"));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getRoles());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem(rule.getMessage(),"roles"));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getPhoneCountExpected());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem(rule.getMessage(),"phoneCountExpected"));
    }
    {
    	com.uniquesoft.uidl.validation.rules.StringLength rule 
    		= ruleFactory.StringLength(_entity.getName());
    	stringLength_name_init(_entity,rule);
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem(rule.getMessage(),"name"));
    }
    {
    	com.uniquesoft.uidl.validation.rules.StringLength rule 
    		= ruleFactory.StringLength(_entity.getUserid());
    	stringLength_userid_init(_entity,rule);
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem(rule.getMessage(),"userid"));
    }
    return errors;
    
  }
}
