package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.web.shared.device.UIDevicePMSpecification;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.device.DevicePMSpecificationValidator")
public class DevicePMSpecificationValidator implements IValidator<UIDevicePMSpecification> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Collection<ValidationErrorItem> validate(final UIDevicePMSpecification _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getDevice());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("维保设备",rule.getMessage(),com.google.common.collect.Lists.newArrayList("device" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getPmType());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("维保类别",rule.getMessage(),com.google.common.collect.Lists.newArrayList("pmType" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getIntervalInDays());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("维保周期(天)",rule.getMessage(),com.google.common.collect.Lists.newArrayList("intervalInDays" )));
    }
    return errors;
    
  }
}
