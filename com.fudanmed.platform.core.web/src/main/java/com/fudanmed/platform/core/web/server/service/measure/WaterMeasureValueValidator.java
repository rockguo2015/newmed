package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.web.shared.measure.UIWaterMeasureValue;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.measure.WaterMeasureValueValidator")
public class WaterMeasureValueValidator implements IValidator<UIWaterMeasureValue> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Collection<ValidationErrorItem> validate(final UIWaterMeasureValue _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getTheValue());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("读数",rule.getMessage(),com.google.common.collect.Lists.newArrayList("theValue" )));
    }
    return errors;
    
  }
}
