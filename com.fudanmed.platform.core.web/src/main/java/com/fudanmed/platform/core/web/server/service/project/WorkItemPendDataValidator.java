package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.web.shared.project.WorkItemPendData;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.WorkItemPendDataValidator")
public class WorkItemPendDataValidator implements IValidator<WorkItemPendData> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Collection<ValidationErrorItem> validate(final WorkItemPendData _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getFinishDate());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("挂起日期",rule.getMessage(),com.google.common.collect.Lists.newArrayList("finishDate" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getFinishTime());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("挂起时间",rule.getMessage(),com.google.common.collect.Lists.newArrayList("finishTime" )));
    }
    return errors;
    
  }
}
