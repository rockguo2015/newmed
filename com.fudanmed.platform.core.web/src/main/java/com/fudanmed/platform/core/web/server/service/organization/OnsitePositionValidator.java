package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.domain.RCOnsitePosition;
import com.fudanmed.platform.core.domain.RCOnsitePositionDAO;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.extensions.ValidationExtensions;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.organization.OnsitePositionValidator")
public class OnsitePositionValidator implements IValidator<UIOnsitePosition> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RCOnsitePositionDAO onsitePositionDAO;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Boolean CodeIsUnique(final UIOnsitePosition _entity) {
    final Function1<UIOnsitePosition,RCOnsitePosition> _function = new Function1<UIOnsitePosition,RCOnsitePosition>() {
        public RCOnsitePosition apply(final UIOnsitePosition newValue) {
          String _code = newValue.getCode();
          RCOnsitePosition _findByCode = OnsitePositionValidator.this.onsitePositionDAO.findByCode(_code);
          return _findByCode;
        }
      };
    boolean _isUnique = ValidationExtensions.<UIOnsitePosition>isUnique(new Function0<UIOnsitePosition>() {
      public UIOnsitePosition apply() {
        return _entity;
      }
    }.apply(), _function);
    return Boolean.valueOf(_isUnique);
  }
  
  public Collection<ValidationErrorItem> validate(final UIOnsitePosition _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    if(_entity.getCode()!=null && !CodeIsUnique(_entity)){
    	errors.add(new ValidationErrorItem("位置代码","位置代码必须唯一",com.google.common.collect.Lists.newArrayList("code" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getCode());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("位置代码",rule.getMessage(),com.google.common.collect.Lists.newArrayList("code" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getName());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("位置名称",rule.getMessage(),com.google.common.collect.Lists.newArrayList("name" )));
    }
    return errors;
    
  }
}
