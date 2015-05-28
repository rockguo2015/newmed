package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.web.shared.organization.UIResetPasswdData;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.organization.ResetPasswdDataValidator")
public class ResetPasswdDataValidator implements IValidator<UIResetPasswdData> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Collection<ValidationErrorItem> validate(final UIResetPasswdData _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getNewPasswd());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("新密码",rule.getMessage(),com.google.common.collect.Lists.newArrayList("newPasswd" )));
    }
    return errors;
    
  }
}
