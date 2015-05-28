package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.web.shared.project.UIRepairDispatchData;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.RepairDispatchDataValidator")
public class RepairDispatchDataValidator implements IValidator<UIRepairDispatchData> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Collection<ValidationErrorItem> validate(final UIRepairDispatchData _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getTeam());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("选择班组",rule.getMessage(),com.google.common.collect.Lists.newArrayList("team" )));
    }
    return errors;
    
  }
}
