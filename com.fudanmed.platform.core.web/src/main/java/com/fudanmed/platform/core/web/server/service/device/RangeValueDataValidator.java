package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.web.shared.device.RangeValueData;
import com.google.common.base.Objects;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.device.RangeValueDataValidator")
public class RangeValueDataValidator implements IValidator<RangeValueData> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Boolean seq(final RangeValueData _entity) {
    boolean _xifexpression = false;
    boolean _and = false;
    Double _lower = _entity.getLower();
    boolean _notEquals = (!Objects.equal(_lower, null));
    if (!_notEquals) {
      _and = false;
    } else {
      Double _upper = _entity.getUpper();
      boolean _notEquals_1 = (!Objects.equal(_upper, null));
      _and = (_notEquals && _notEquals_1);
    }
    if (_and) {
      Double _lower_1 = _entity.getLower();
      Double _upper_1 = _entity.getUpper();
      boolean _lessEqualsThan = (_lower_1.compareTo(_upper_1) <= 0);
      _xifexpression = _lessEqualsThan;
    }
    return Boolean.valueOf(_xifexpression);
  }
  
  public Collection<ValidationErrorItem> validate(final RangeValueData _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    if(_entity.getLower()!=null&&_entity.getUpper()!=null && !seq(_entity)){
    	errors.add(new ValidationErrorItem("上限,下限","下限必须大于上限",com.google.common.collect.Lists.newArrayList("lower","upper" )));
    }
    return errors;
    
  }
}
