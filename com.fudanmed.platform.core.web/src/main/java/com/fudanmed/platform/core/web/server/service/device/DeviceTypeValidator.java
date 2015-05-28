package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.RCDeviceTypeDAO;
import com.fudanmed.platform.core.web.shared.device.UIDeviceType;
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

@Component("com.fudanmed.platform.core.web.server.service.device.DeviceTypeValidator")
public class DeviceTypeValidator implements IValidator<UIDeviceType> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RCDeviceTypeDAO dao;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Boolean codeUniqueCheck(final UIDeviceType _entity) {
    final Function1<UIDeviceType,RCDeviceType> _function = new Function1<UIDeviceType,RCDeviceType>() {
        public RCDeviceType apply(final UIDeviceType it) {
          String _code = _entity.getCode();
          RCDeviceType _findByCode = DeviceTypeValidator.this.dao.findByCode(_code);
          return _findByCode;
        }
      };
    boolean _isUnique = ValidationExtensions.<UIDeviceType>isUnique(new Function0<UIDeviceType>() {
      public UIDeviceType apply() {
        return _entity;
      }
    }.apply(), _function);
    return Boolean.valueOf(_isUnique);
  }
  
  public Collection<ValidationErrorItem> validate(final UIDeviceType _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    if(_entity.getCode()!=null && !codeUniqueCheck(_entity)){
    	errors.add(new ValidationErrorItem("类型编码","代码必须唯一",com.google.common.collect.Lists.newArrayList("code" )));
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
