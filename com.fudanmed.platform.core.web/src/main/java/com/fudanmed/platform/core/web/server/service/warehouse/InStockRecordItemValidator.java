package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecordItem;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.InStockRecordItemValidator")
public class InStockRecordItemValidator implements IValidator<UIInStockRecordItem> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Collection<ValidationErrorItem> validate(final UIInStockRecordItem _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getUiProductSpec());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("物品名称",rule.getMessage(),com.google.common.collect.Lists.newArrayList("uiProductSpec" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getPrice());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("单价",rule.getMessage(),com.google.common.collect.Lists.newArrayList("price" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getQuantity());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("数量",rule.getMessage(),com.google.common.collect.Lists.newArrayList("quantity" )));
    }
    return errors;
    
  }
}
