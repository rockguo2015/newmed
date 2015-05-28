package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDeviceTypeCategory;
import com.fudanmed.platform.core.device.RCDeviceTypeCategoryDAO;
import com.fudanmed.platform.core.web.shared.device.UIDeviceTypeCategory;
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

@Component("com.fudanmed.platform.core.web.server.service.device.DeviceTypeCategoryValidator")
public class DeviceTypeCategoryValidator implements IValidator<UIDeviceTypeCategory> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RCDeviceTypeCategoryDAO productCategoryDAO;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Boolean UniqueCode(final UIDeviceTypeCategory _entity) {
    final Function1<UIDeviceTypeCategory,RCDeviceTypeCategory> _function = new Function1<UIDeviceTypeCategory,RCDeviceTypeCategory>() {
        public RCDeviceTypeCategory apply(final UIDeviceTypeCategory newValue) {
          String _code = newValue.getCode();
          RCDeviceTypeCategory _findByCode = DeviceTypeCategoryValidator.this.productCategoryDAO.findByCode(_code);
          return _findByCode;
        }
      };
    boolean _isUnique = ValidationExtensions.<UIDeviceTypeCategory>isUnique(new Function0<UIDeviceTypeCategory>() {
      public UIDeviceTypeCategory apply() {
        return _entity;
      }
    }.apply(), _function);
    return Boolean.valueOf(_isUnique);
  }
  
  public Collection<ValidationErrorItem> validate(final UIDeviceTypeCategory _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    if(_entity.getCode()!=null && !UniqueCode(_entity)){
    	errors.add(new ValidationErrorItem("大类代码","物品大类代码必须唯一",com.google.common.collect.Lists.newArrayList("code" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getCode());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("大类代码",rule.getMessage(),com.google.common.collect.Lists.newArrayList("code" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getName());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("大类名称",rule.getMessage(),com.google.common.collect.Lists.newArrayList("name" )));
    }
    return errors;
    
  }
}
