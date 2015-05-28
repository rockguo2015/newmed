package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.web.shared.device.BatchInitializePMPlanData;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.device.BatchInitializePMPlanDataValidator")
public class BatchInitializePMPlanDataValidator implements IValidator<BatchInitializePMPlanData> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Collection<ValidationErrorItem> validate(final BatchInitializePMPlanData _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getYear());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("截止年份",rule.getMessage(),com.google.common.collect.Lists.newArrayList("year" )));
    }
    return errors;
    
  }
}
