package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.warehouse.RCStockTakingList;
import com.fudanmed.platform.core.web.server.service.warehouse.StockTakingListValidator;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingList;
import com.uniquesoft.gwt.shared.DateUtil;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.langlab.domain.organization.Party;
import edu.fudan.langlab.domain.security.ISystemUserService;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.StockTakingListMapper")
public class StockTakingListMapper extends AbstractEntityMapper<UIStockTakingList,RCStockTakingList> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCStockTakingList loadEntityById(final Long id) {
    return entities.get(RCStockTakingList.class,id);
  }
  
  public RCStockTakingList create() {
    return entities.create(RCStockTakingList.class);
  }
  
  @Autowired
  private ISystemUserService systemUserService;
  
  @Autowired
  private StockTakingListValidator validator;
  
  public void copyToEntity(final UIStockTakingList from, final RCStockTakingList to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setWarehouse(convertService.toValue(com.fudanmed.platform.core.warehouse.RCWarehouse.class,from.getWarehouse()));
    to.setComment(convertService.toValue(java.lang.String.class,from.getComment()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final UIStockTakingList _gwt, final RCStockTakingList _entity) {
    Party _currentUserAsParty = this.systemUserService.getCurrentUserAsParty();
    _entity.setOperator(((RCEmployee) _currentUserAsParty));
    Date _day = DateUtil.today();
    _entity.setDate(_day);
  }
  
  public UIStockTakingList copyFromEntity(final UIStockTakingList result, final RCStockTakingList entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setWarehouse(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy.class,entity.getWarehouse()));
    result.setComment(convertService.toValue(java.lang.String.class,entity.getComment()));
    result.setOperator(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy.class,entity.getOperator()));
    result.setDate(convertService.toValue(java.util.Date.class,entity.getDate()));
    result.setIsCommited(convertService.toValue(java.lang.Boolean.class,entity.getIsCommited()));
    return result;
    
  }
  
  public UIStockTakingList buildFrom(final RCStockTakingList entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingList result = new com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingList();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIStockTakingList.class;
  }
  
  public Class<?> getEntityClass() {
    return RCStockTakingList.class;
  }
}
