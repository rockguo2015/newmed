package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCStockTakingService;
import com.fudanmed.platform.core.warehouse.RCStockTakingStatus;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingList;
import com.uniquesoft.gwt.shared.extensions.BooleanExtensions;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.StockTakingListValidator")
public class StockTakingListValidator implements IValidator<UIStockTakingList> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RCStockTakingService stockTakingService;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Boolean InProgressCheck(final UIStockTakingList _entity) {
    RCWarehouseProxy _warehouse = _entity.getWarehouse();
    RCWarehouse _resolved= null;
    if(_warehouse!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCWarehouse)com.uniquesoft.uidl.extensions.ModelObjects.resolve(_warehouse, entities);
    
    RCStockTakingStatus _stockTakingStatus = this.stockTakingService.getStockTakingStatus( _resolved);
    Boolean _isInStockTaking = _stockTakingStatus.getIsInStockTaking();
    boolean _isLogicTrue = BooleanExtensions.isLogicTrue(_isInStockTaking);
    boolean _not = (!_isLogicTrue);
    return Boolean.valueOf(_not);
  }
  
  public Collection<ValidationErrorItem> validate(final UIStockTakingList _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    if(_entity.getWarehouse()!=null && !InProgressCheck(_entity)){
    	errors.add(new ValidationErrorItem("盘点仓库","选择仓库正在盘点中",com.google.common.collect.Lists.newArrayList("warehouse" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getWarehouse());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("盘点仓库",rule.getMessage(),com.google.common.collect.Lists.newArrayList("warehouse" )));
    }
    return errors;
    
  }
}
