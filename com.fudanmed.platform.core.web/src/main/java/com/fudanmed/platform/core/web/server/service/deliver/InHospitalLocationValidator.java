package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalLocation;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.deliver.InHospitalLocationValidator")
public class InHospitalLocationValidator implements IValidator<UIInHospitalLocation> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Collection<ValidationErrorItem> validate(final UIInHospitalLocation _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getCode());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("病区代码",rule.getMessage(),com.google.common.collect.Lists.newArrayList("code" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getName());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("病区名称",rule.getMessage(),com.google.common.collect.Lists.newArrayList("name" )));
    }
    return errors;
    
  }
}
