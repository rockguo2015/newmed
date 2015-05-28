package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignment;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.device.PMWorkItemWorkerAssignmentValidator")
public class PMWorkItemWorkerAssignmentValidator implements IValidator<UIPMWorkItemWorkerAssignment> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Collection<ValidationErrorItem> validate(final UIPMWorkItemWorkerAssignment _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getWorkers());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("工程师",rule.getMessage(),com.google.common.collect.Lists.newArrayList("workers" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getAssignDate());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("派工日期",rule.getMessage(),com.google.common.collect.Lists.newArrayList("assignDate" )));
    }
    return errors;
    
  }
}
