package com.lanmon.business.server.service.message;

import com.lanmon.business.shared.message.GWTContractDateTrigger;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.lanmon.business.server.service.message.ContractDateTriggerValidator")
public class ContractDateTriggerValidator implements IValidator<GWTContractDateTrigger> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Collection<ValidationErrorItem> validate(final GWTContractDateTrigger _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getType());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem(rule.getMessage(),"type"));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getTriggerDate());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem(rule.getMessage(),"triggerDate"));
    }
    return errors;
    
  }
}
