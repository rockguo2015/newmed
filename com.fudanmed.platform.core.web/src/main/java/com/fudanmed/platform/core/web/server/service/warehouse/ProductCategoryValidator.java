package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductCategory;
import com.fudanmed.platform.core.warehouse.RCProductCategoryDAO;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductCategory;
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

@Component("com.fudanmed.platform.core.web.server.service.warehouse.ProductCategoryValidator")
public class ProductCategoryValidator implements IValidator<UIProductCategory> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RCProductCategoryDAO productCategoryDAO;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Boolean UniqueCode(final UIProductCategory _entity) {
    final Function1<UIProductCategory,RCProductCategory> _function = new Function1<UIProductCategory,RCProductCategory>() {
        public RCProductCategory apply(final UIProductCategory newValue) {
          String _code = newValue.getCode();
          RCProductCategory _findByCode = ProductCategoryValidator.this.productCategoryDAO.findByCode(_code);
          return _findByCode;
        }
      };
    boolean _isUnique = ValidationExtensions.<UIProductCategory>isUnique(new Function0<UIProductCategory>() {
      public UIProductCategory apply() {
        return _entity;
      }
    }.apply(), _function);
    return Boolean.valueOf(_isUnique);
  }
  
  public Collection<ValidationErrorItem> validate(final UIProductCategory _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    if(_entity.getCode()!=null && !UniqueCode(_entity)){
    	errors.add(new ValidationErrorItem("物品大类代码","物品大类代码必须唯一",com.google.common.collect.Lists.newArrayList("code" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getCode());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("物品大类代码",rule.getMessage(),com.google.common.collect.Lists.newArrayList("code" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getName());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("物品大类名称",rule.getMessage(),com.google.common.collect.Lists.newArrayList("name" )));
    }
    return errors;
    
  }
}
