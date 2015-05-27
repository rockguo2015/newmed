package com.lanmon.business.server.service.event;

import com.lanmon.business.shared.event.GWTEvent;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import com.uniquesoft.uidl.validation.rules.StringLength;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.lanmon.business.server.service.event.EventValidator")
public class EventValidator implements IValidator<GWTEvent> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public void stringLength_note_init(final GWTEvent _entity, final StringLength _rule) {
    _rule.setMaxLength(10240);
  }
  
  public Collection<ValidationErrorItem> validate(final GWTEvent _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getType());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem(rule.getMessage(),"type"));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getNote());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem(rule.getMessage(),"note"));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getEventDate());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem(rule.getMessage(),"eventDate"));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getCustomer());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem(rule.getMessage(),"customer"));
    }
    {
    	com.uniquesoft.uidl.validation.rules.StringLength rule 
    		= ruleFactory.StringLength(_entity.getNote());
    	stringLength_note_init(_entity,rule);
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem(rule.getMessage(),"note"));
    }
    return errors;
    
  }
}
