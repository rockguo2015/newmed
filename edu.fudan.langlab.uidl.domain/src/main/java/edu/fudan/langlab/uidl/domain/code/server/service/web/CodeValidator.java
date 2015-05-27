package edu.fudan.langlab.uidl.domain.code.server.service.web;

import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICode;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("edu.fudan.langlab.uidl.domain.code.server.service.web.CodeValidator")
public class CodeValidator implements IValidator<UICode> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Collection<ValidationErrorItem> validate(final UICode _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getCodeid());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("代码",rule.getMessage(),com.google.common.collect.Lists.newArrayList("codeid" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getName());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("名称",rule.getMessage(),com.google.common.collect.Lists.newArrayList("name" )));
    }
    return errors;
    
  }
}
