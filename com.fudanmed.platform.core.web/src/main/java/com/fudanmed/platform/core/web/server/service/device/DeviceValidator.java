package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.RCDeviceDAO;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
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

@Component("com.fudanmed.platform.core.web.server.service.device.DeviceValidator")
public class DeviceValidator implements IValidator<UIDevice> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RCDeviceDAO dao;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Boolean SidIsUniqueCheck(final UIDevice _entity) {
    final Function1<UIDevice,RCDevice> _function = new Function1<UIDevice,RCDevice>() {
        public RCDevice apply(final UIDevice it) {
          String _sid = it.getSid();
          RCDevice _findDeviceBySid = DeviceValidator.this.dao.findDeviceBySid(_sid);
          return _findDeviceBySid;
        }
      };
    boolean _isUnique = ValidationExtensions.<UIDevice>isUnique(new Function0<UIDevice>() {
      public UIDevice apply() {
        return _entity;
      }
    }.apply(), _function);
    return Boolean.valueOf(_isUnique);
  }
  
  public Collection<ValidationErrorItem> validate(final UIDevice _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    if(_entity.getSid()!=null && !SidIsUniqueCheck(_entity)){
    	errors.add(new ValidationErrorItem("设备编号","设备编号必须唯一",com.google.common.collect.Lists.newArrayList("sid" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getSid());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("设备编号",rule.getMessage(),com.google.common.collect.Lists.newArrayList("sid" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getName());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("设备名称",rule.getMessage(),com.google.common.collect.Lists.newArrayList("name" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getDeviceType());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("设备类型",rule.getMessage(),com.google.common.collect.Lists.newArrayList("deviceType" )));
    }
    return errors;
    
  }
}
