package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecord;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.OutStockRecordValidator")
public class OutStockRecordValidator implements IValidator<UIOutStockRecord> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Collection<ValidationErrorItem> validate(final UIOutStockRecord _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getSourceStore());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("出库仓库",rule.getMessage(),com.google.common.collect.Lists.newArrayList("sourceStore" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getItemSummarys());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("出库明细",rule.getMessage(),com.google.common.collect.Lists.newArrayList("itemSummarys" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getType());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("出库类型",rule.getMessage(),com.google.common.collect.Lists.newArrayList("type" )));
    }
    return errors;
    
  }
}
