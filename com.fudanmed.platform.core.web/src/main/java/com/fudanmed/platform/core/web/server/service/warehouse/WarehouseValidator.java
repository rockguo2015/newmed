package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.RCWarehouseService;
import com.fudanmed.platform.core.web.shared.warehouse.UIWarehouse;
import com.google.common.base.Objects;
import com.uniquesoft.gwt.shared.extensions.BooleanExtensions;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.WarehouseValidator")
public class WarehouseValidator implements IValidator<UIWarehouse> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RCWarehouseService sarehouseService;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Boolean hasOnMajor(final UIWarehouse _entity) {
    boolean _xifexpression = false;
    Boolean _isMajor = _entity.getIsMajor();
    boolean _isLogicTrue = BooleanExtensions.isLogicTrue(_isMajor);
    if (_isLogicTrue) {
      boolean _or = false;
      RCWarehouse _majorWarehouse = this.sarehouseService.getMajorWarehouse();
      boolean _equals = Objects.equal(_majorWarehouse, null);
      if (_equals) {
        _or = true;
      } else {
        RCWarehouse _majorWarehouse_1 = this.sarehouseService.getMajorWarehouse();
        Long _id = _majorWarehouse_1.getId();
        Long _id_1 = _entity.getId();
        boolean _equals_1 = Objects.equal(_id, _id_1);
        _or = (_equals || _equals_1);
      }
      _xifexpression = _or;
    } else {
      _xifexpression = true;
    }
    return Boolean.valueOf(_xifexpression);
  }
  
  public Collection<ValidationErrorItem> validate(final UIWarehouse _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    if(_entity.getName()!=null && !hasOnMajor(_entity)){
    	errors.add(new ValidationErrorItem("名称","主仓库只能有一个",com.google.common.collect.Lists.newArrayList("name" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getName());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("名称",rule.getMessage(),com.google.common.collect.Lists.newArrayList("name" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getStoreManager());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("仓库管理员",rule.getMessage(),com.google.common.collect.Lists.newArrayList("storeManager" )));
    }
    return errors;
    
  }
}
