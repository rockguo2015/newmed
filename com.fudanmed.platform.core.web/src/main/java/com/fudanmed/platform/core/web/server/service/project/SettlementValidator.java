package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.web.shared.project.UISettlement;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.SettlementValidator")
public class SettlementValidator implements IValidator<UISettlement> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Collection<ValidationErrorItem> validate(final UISettlement _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getFromDate());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("起始时间",rule.getMessage(),com.google.common.collect.Lists.newArrayList("fromDate" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getToDate());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("结束时间",rule.getMessage(),com.google.common.collect.Lists.newArrayList("toDate" )));
    }
    return errors;
    
  }
}
