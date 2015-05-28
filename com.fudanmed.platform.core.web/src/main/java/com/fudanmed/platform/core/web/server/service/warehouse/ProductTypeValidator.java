package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductType;
import com.fudanmed.platform.core.warehouse.RCProductTypeDAO;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductType;
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

@Component("com.fudanmed.platform.core.web.server.service.warehouse.ProductTypeValidator")
public class ProductTypeValidator implements IValidator<UIProductType> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RCProductTypeDAO productTypeDAO;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Boolean UniqueCode(final UIProductType _entity) {
    final Function1<UIProductType,RCProductType> _function = new Function1<UIProductType,RCProductType>() {
        public RCProductType apply(final UIProductType newValue) {
          String _code = newValue.getCode();
          RCProductType _findByCode = ProductTypeValidator.this.productTypeDAO.findByCode(_code);
          return _findByCode;
        }
      };
    boolean _isUnique = ValidationExtensions.<UIProductType>isUnique(new Function0<UIProductType>() {
      public UIProductType apply() {
        return _entity;
      }
    }.apply(), _function);
    return Boolean.valueOf(_isUnique);
  }
  
  public Collection<ValidationErrorItem> validate(final UIProductType _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    if(_entity.getCode()!=null && !UniqueCode(_entity)){
    	errors.add(new ValidationErrorItem("物品类别代码","物品类别代码必须唯一",com.google.common.collect.Lists.newArrayList("code" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getCode());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("物品类别代码",rule.getMessage(),com.google.common.collect.Lists.newArrayList("code" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getName());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("物品类别名称",rule.getMessage(),com.google.common.collect.Lists.newArrayList("name" )));
    }
    return errors;
    
  }
}
