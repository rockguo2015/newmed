package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecordItem;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.WorkItemStockRecordItemValidator")
public class WorkItemStockRecordItemValidator implements IValidator<UIWorkItemStockRecordItem> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Collection<ValidationErrorItem> validate(final UIWorkItemStockRecordItem _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    return errors;
    
  }
}
