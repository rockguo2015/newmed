package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask4Patient;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.deliver.CenterlizedDeliverTask4PatientValidator")
public class CenterlizedDeliverTask4PatientValidator implements IValidator<UICenterlizedDeliverTask4Patient> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Collection<ValidationErrorItem> validate(final UICenterlizedDeliverTask4Patient _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getPatient());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("病人",rule.getMessage(),com.google.common.collect.Lists.newArrayList("patient" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getCheckOrganization());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("检查科室",rule.getMessage(),com.google.common.collect.Lists.newArrayList("checkOrganization" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getCheckType());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("检查项目",rule.getMessage(),com.google.common.collect.Lists.newArrayList("checkType" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getDeliverMethod());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("接送方式",rule.getMessage(),com.google.common.collect.Lists.newArrayList("deliverMethod" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getEmergency());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("紧急度",rule.getMessage(),com.google.common.collect.Lists.newArrayList("emergency" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getPlanTime());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("计划时间",rule.getMessage(),com.google.common.collect.Lists.newArrayList("planTime" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getPlanDate());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("计划日期",rule.getMessage(),com.google.common.collect.Lists.newArrayList("planDate" )));
    }
    return errors;
    
  }
}
