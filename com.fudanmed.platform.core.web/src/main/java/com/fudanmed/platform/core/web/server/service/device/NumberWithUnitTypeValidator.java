package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.web.shared.device.UINumberWithUnitType;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.device.NumberWithUnitTypeValidator")
public class NumberWithUnitTypeValidator implements IValidator<UINumberWithUnitType> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Collection<ValidationErrorItem> validate(final UINumberWithUnitType _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getUnit());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("单位",rule.getMessage(),com.google.common.collect.Lists.newArrayList("unit" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getAlias());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("别名",rule.getMessage(),com.google.common.collect.Lists.newArrayList("alias" )));
    }
    return errors;
    
  }
}
