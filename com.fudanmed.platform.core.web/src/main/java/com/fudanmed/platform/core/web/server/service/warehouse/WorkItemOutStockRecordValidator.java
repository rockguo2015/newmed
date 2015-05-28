package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemOutStockRecord;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.WorkItemOutStockRecordValidator")
public class WorkItemOutStockRecordValidator implements IValidator<UIWorkItemOutStockRecord> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Collection<ValidationErrorItem> validate(final UIWorkItemOutStockRecord _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getSourceStore());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("出库仓库",rule.getMessage(),com.google.common.collect.Lists.newArrayList("sourceStore" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getWorkItem());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("工单号",rule.getMessage(),com.google.common.collect.Lists.newArrayList("workItem" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getItemSummarys());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("领料明细",rule.getMessage(),com.google.common.collect.Lists.newArrayList("itemSummarys" )));
    }
    return errors;
    
  }
}
