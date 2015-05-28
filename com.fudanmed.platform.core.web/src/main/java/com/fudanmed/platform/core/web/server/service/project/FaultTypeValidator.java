package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.web.shared.project.UIFaultType;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.FaultTypeValidator")
public class FaultTypeValidator implements IValidator<UIFaultType> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Collection<ValidationErrorItem> validate(final UIFaultType _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getName());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("名称",rule.getMessage(),com.google.common.collect.Lists.newArrayList("name" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getStandardCostTime());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("标准工时(小时)",rule.getMessage(),com.google.common.collect.Lists.newArrayList("standardCostTime" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getPerformanceWeight());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("绩效系数",rule.getMessage(),com.google.common.collect.Lists.newArrayList("performanceWeight" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getFaultRiskLevel());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("风险等级",rule.getMessage(),com.google.common.collect.Lists.newArrayList("faultRiskLevel" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getNeedAudit());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("需审批",rule.getMessage(),com.google.common.collect.Lists.newArrayList("needAudit" )));
    }
    return errors;
    
  }
}
