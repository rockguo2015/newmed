package com.lanmon.business.server.service.customer;

import com.lanmon.business.shared.customer.EmailExportCriteria;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.lanmon.business.server.service.customer.EmailExportCriteriaRule")
public class EmailExportCriteriaRule implements IValidator<EmailExportCriteria> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Collection<ValidationErrorItem> validate(final EmailExportCriteria _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getContactType());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem(rule.getMessage(),"contactType"));
    }
    return errors;
    
  }
}
