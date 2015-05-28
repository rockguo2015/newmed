package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.ReportValidator")
public class ReportValidator implements IValidator<UIRepairTask> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Collection<ValidationErrorItem> validate(final UIRepairTask _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getReportDate());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("接报日期",rule.getMessage(),com.google.common.collect.Lists.newArrayList("reportDate" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getReportTime());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("接报时间",rule.getMessage(),com.google.common.collect.Lists.newArrayList("reportTime" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getLocation());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("报修地点",rule.getMessage(),com.google.common.collect.Lists.newArrayList("location" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getComment());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("报修内容",rule.getMessage(),com.google.common.collect.Lists.newArrayList("comment" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getReporterName());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("报修人",rule.getMessage(),com.google.common.collect.Lists.newArrayList("reporterName" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getReportOrg());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("报修部门",rule.getMessage(),com.google.common.collect.Lists.newArrayList("reportOrg" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getFaultEmergencyLevel());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("紧急度",rule.getMessage(),com.google.common.collect.Lists.newArrayList("faultEmergencyLevel" )));
    }
    return errors;
    
  }
}
