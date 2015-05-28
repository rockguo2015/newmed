package com.fudanmed.platform.core.web.server.service.workbench;

import com.fudanmed.platform.core.web.shared.workbench.UISystemParameter;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.workbench.SystemParameterValidator")
public class SystemParameterValidator implements IValidator<UISystemParameter> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Collection<ValidationErrorItem> validate(final UISystemParameter _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getApplicationTitle());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("应用系统标题",rule.getMessage(),com.google.common.collect.Lists.newArrayList("applicationTitle" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getRefreshInterval());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("客户端刷新间隔(秒)",rule.getMessage(),com.google.common.collect.Lists.newArrayList("refreshInterval" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getCustomerEvalCommitInterval());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("科室反馈超时(天)",rule.getMessage(),com.google.common.collect.Lists.newArrayList("customerEvalCommitInterval" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getEboardRefreshInterval());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("电子屏刷新间隔(秒)",rule.getMessage(),com.google.common.collect.Lists.newArrayList("eboardRefreshInterval" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getOrgName());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("用户名称",rule.getMessage(),com.google.common.collect.Lists.newArrayList("orgName" )));
    }
    return errors;
    
  }
}
