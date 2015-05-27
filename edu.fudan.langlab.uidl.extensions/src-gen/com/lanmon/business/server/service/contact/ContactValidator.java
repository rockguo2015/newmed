package com.lanmon.business.server.service.contact;

import com.lanmon.business.shared.contact.GWTContact;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.lanmon.business.server.service.contact.ContactValidator")
public class ContactValidator implements IValidator<GWTContact> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Collection<ValidationErrorItem> validate(final GWTContact _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getName());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem(rule.getMessage(),"name"));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getType());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem(rule.getMessage(),"type"));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getPhone());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem(rule.getMessage(),"phone"));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getEmail());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem(rule.getMessage(),"email"));
    }
    {
    	com.uniquesoft.uidl.validation.rules.EMail rule 
    		= ruleFactory.EMail(_entity.getEmail());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem(rule.getMessage(),"email"));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Phone rule 
    		= ruleFactory.Phone(_entity.getPhone());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem(rule.getMessage(),"phone"));
    }
    return errors;
    
  }
}
