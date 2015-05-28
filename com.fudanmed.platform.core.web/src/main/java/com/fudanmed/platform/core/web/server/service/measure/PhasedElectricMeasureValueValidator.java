package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.web.shared.measure.UIPhasedElectricMeasureValue;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.measure.PhasedElectricMeasureValueValidator")
public class PhasedElectricMeasureValueValidator implements IValidator<UIPhasedElectricMeasureValue> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Collection<ValidationErrorItem> validate(final UIPhasedElectricMeasureValue _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getHighValue());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("峰电量",rule.getMessage(),com.google.common.collect.Lists.newArrayList("highValue" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getLowValue());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("谷电量",rule.getMessage(),com.google.common.collect.Lists.newArrayList("lowValue" )));
    }
    return errors;
    
  }
}
