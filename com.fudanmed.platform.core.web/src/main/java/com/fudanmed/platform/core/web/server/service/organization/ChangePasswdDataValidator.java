package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.web.shared.organization.UIChangePasswdData;
import com.google.common.base.Objects;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.langlab.domain.security.User;
import edu.fudan.langlab.domain.security.proxy.UserProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.organization.ChangePasswdDataValidator")
public class ChangePasswdDataValidator implements IValidator<UIChangePasswdData> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Boolean C1(final UIChangePasswdData _entity) {
    UserProxy _user = _entity.getUser();
    User _resolved= null;
    if(_user!=null) _resolved=(edu.fudan.langlab.domain.security.User)com.uniquesoft.uidl.extensions.ModelObjects.resolve(_user, entities);
    
    String _passwd =  _resolved.getPasswd();
    String _orgPasswd = _entity.getOrgPasswd();
    boolean _equals = Objects.equal(_passwd, _orgPasswd);
    return Boolean.valueOf(_equals);
  }
  
  public Boolean C2(final UIChangePasswdData _entity) {
    String _newPasswd = _entity.getNewPasswd();
    String _newPasswdAgain = _entity.getNewPasswdAgain();
    boolean _equals = Objects.equal(_newPasswd, _newPasswdAgain);
    return Boolean.valueOf(_equals);
  }
  
  public Collection<ValidationErrorItem> validate(final UIChangePasswdData _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    if(_entity.getOrgPasswd()!=null && !C1(_entity)){
    	errors.add(new ValidationErrorItem("原密码","旧密码不符",com.google.common.collect.Lists.newArrayList("orgPasswd" )));
    }
    if(_entity.getNewPasswd()!=null&&_entity.getNewPasswdAgain()!=null && !C2(_entity)){
    	errors.add(new ValidationErrorItem("新密码,新密码","两次密码输入不一致",com.google.common.collect.Lists.newArrayList("newPasswd","newPasswdAgain" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getOrgPasswd());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("原密码",rule.getMessage(),com.google.common.collect.Lists.newArrayList("orgPasswd" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getNewPasswd());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("新密码",rule.getMessage(),com.google.common.collect.Lists.newArrayList("newPasswd" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getNewPasswdAgain());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("新密码",rule.getMessage(),com.google.common.collect.Lists.newArrayList("newPasswdAgain" )));
    }
    return errors;
    
  }
}
