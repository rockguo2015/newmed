package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.web.shared.device.UIPartTypeSelectData;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.device.PartTypeSelectDataValidator")
public class PartTypeSelectDataValidator implements IValidator<UIPartTypeSelectData> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Collection<ValidationErrorItem> validate(final UIPartTypeSelectData _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getProductSpec());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("备件类型",rule.getMessage(),com.google.common.collect.Lists.newArrayList("productSpec" )));
    }
    return errors;
    
  }
}
