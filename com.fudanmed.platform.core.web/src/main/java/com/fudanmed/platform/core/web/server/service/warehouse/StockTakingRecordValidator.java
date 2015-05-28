package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecord;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.StockTakingRecordValidator")
public class StockTakingRecordValidator implements IValidator<UIStockTakingRecord> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Collection<ValidationErrorItem> validate(final UIStockTakingRecord _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getSourceStore());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("盘点仓库",rule.getMessage(),com.google.common.collect.Lists.newArrayList("sourceStore" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getItemSummarys());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("盘点明细",rule.getMessage(),com.google.common.collect.Lists.newArrayList("itemSummarys" )));
    }
    return errors;
    
  }
}
