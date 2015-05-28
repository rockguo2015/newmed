package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.web.shared.device.InitializePMPlanData;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.device.InitializePMPlanDataValidator")
public class InitializePMPlanDataValidator implements IValidator<InitializePMPlanData> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Collection<ValidationErrorItem> validate(final InitializePMPlanData _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getYear());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("截止年份",rule.getMessage(),com.google.common.collect.Lists.newArrayList("year" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getFromDate());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("起始日期",rule.getMessage(),com.google.common.collect.Lists.newArrayList("fromDate" )));
    }
    return errors;
    
  }
}
