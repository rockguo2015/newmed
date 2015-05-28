package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.web.shared.project.UIWorkItemTask;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.WorkItemTaskValidator")
public class WorkItemTaskValidator implements IValidator<UIWorkItemTask> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Collection<ValidationErrorItem> validate(final UIWorkItemTask _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getDate());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("派工日期",rule.getMessage(),com.google.common.collect.Lists.newArrayList("date" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getTime());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("派工时间",rule.getMessage(),com.google.common.collect.Lists.newArrayList("time" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getFaultType());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("维修类别",rule.getMessage(),com.google.common.collect.Lists.newArrayList("faultType" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getWorkers());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("维修人员",rule.getMessage(),com.google.common.collect.Lists.newArrayList("workers" )));
    }
    return errors;
    
  }
}
