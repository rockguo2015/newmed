package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.web.shared.measure.UIWaterMeasureDevice;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.measure.WaterMeasureDeviceValidator")
public class WaterMeasureDeviceValidator implements IValidator<UIWaterMeasureDevice> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Collection<ValidationErrorItem> validate(final UIWaterMeasureDevice _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    return errors;
    
  }
}
