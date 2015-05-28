package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UITransferRecord;
import com.google.common.base.Objects;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.uidl.validation.IValidator;
import com.uniquesoft.uidl.validation.RuleFactory;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.TransferRecordValidator")
public class TransferRecordValidator implements IValidator<UITransferRecord> {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RuleFactory ruleFactory;
  
  public Boolean C1(final UITransferRecord _entity) {
    RCWarehouseProxy _targetStore = _entity.getTargetStore();
    RCWarehouseProxy _sourceStore = _entity.getSourceStore();
    boolean _notEquals = (!Objects.equal(_targetStore, _sourceStore));
    return Boolean.valueOf(_notEquals);
  }
  
  public Collection<ValidationErrorItem> validate(final UITransferRecord _entity) {
    Collection<ValidationErrorItem> errors = com.google.common.collect.Lists.newArrayList();
    if(_entity.getTargetStore()!=null&&_entity.getSourceStore()!=null && !C1(_entity)){
    	errors.add(new ValidationErrorItem("调入仓库,调出仓库","调入调出仓库不能相同",com.google.common.collect.Lists.newArrayList("targetStore","sourceStore" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getTargetStore());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("调入仓库",rule.getMessage(),com.google.common.collect.Lists.newArrayList("targetStore" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getSourceStore());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("调出仓库",rule.getMessage(),com.google.common.collect.Lists.newArrayList("sourceStore" )));
    }
    {
    	com.uniquesoft.uidl.validation.rules.Required rule 
    		= ruleFactory.Required(_entity.getItemSummarys());
    	if(!rule.checkValid()) 
    		errors.add(new ValidationErrorItem("调拨明细",rule.getMessage(),com.google.common.collect.Lists.newArrayList("itemSummarys" )));
    }
    return errors;
    
  }
}
