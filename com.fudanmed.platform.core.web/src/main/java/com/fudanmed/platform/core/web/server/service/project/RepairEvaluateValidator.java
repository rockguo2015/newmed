package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.web.shared.project.UIRepairEvaluate;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.RepairEvaluateValidator")
public class RepairEvaluateValidator implements IValidator<UIRepairEvaluate> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Collection<ValidationErrorItem> validate(final UIRepairEvaluate _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getArrivalTimeValue());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("到达及时性",rule.getMessage(),com.google.common.collect.Lists.newArrayList("arrivalTimeValue" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getServiceAttitudeValue());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("服务态度",rule.getMessage(),com.google.common.collect.Lists.newArrayList("serviceAttitudeValue" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getFrequencyProblemValue());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("同一问题频率",rule.getMessage(),com.google.common.collect.Lists.newArrayList("frequencyProblemValue" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getRepairQualityValue());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("维修质量",rule.getMessage(),com.google.common.collect.Lists.newArrayList("repairQualityValue" )));
    }
    return errors;
    
  }
}
