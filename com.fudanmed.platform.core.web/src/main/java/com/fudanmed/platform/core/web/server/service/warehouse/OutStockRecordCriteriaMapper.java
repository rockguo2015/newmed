package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCOutStockRecordCriteria;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.RCWarehouseDAO;
import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecordCriteria;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.OutStockRecordCriteriaMapper")
public class OutStockRecordCriteriaMapper extends AbstractDataTypeMapper<UIOutStockRecordCriteria,RCOutStockRecordCriteria> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private RCWarehouseDAO warehouseDAO;
  
  public void copyToEntity(final UIOutStockRecordCriteria from, final RCOutStockRecordCriteria to) {
    to.setSid(convertService.toValue(java.lang.String.class,from.getSid()));
    to.setDateFrom(convertService.toValue(java.util.Date.class,from.getDateFrom()));
    to.setDateTo(convertService.toValue(java.util.Date.class,from.getDateTo()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final UIOutStockRecordCriteria _gwt, final RCOutStockRecordCriteria _entity) {
    Collection<RCWarehouse> _findManagedWarehouse = this.warehouseDAO.findManagedWarehouse();
    final Function1<RCWarehouse,Long> _function = new Function1<RCWarehouse,Long>() {
        public Long apply(final RCWarehouse it) {
          Long _id = it.getId();
          return _id;
        }
      };
    Iterable<Long> _map = IterableExtensions.<RCWarehouse, Long>map(_findManagedWarehouse, _function);
    Collection<Long> _unlazy = IterableExtensions2.<Long>unlazy(_map);
    _entity.setStores(_unlazy);
  }
  
  public UIOutStockRecordCriteria copyFromEntity(final UIOutStockRecordCriteria result, final RCOutStockRecordCriteria entity) {
    if(entity==null) return null;
    result.setSid(convertService.toValue(java.lang.String.class,entity.getSid()));
    result.setDateFrom(convertService.toValue(java.util.Date.class,entity.getDateFrom()));
    result.setDateTo(convertService.toValue(java.util.Date.class,entity.getDateTo()));
    return result;
    
  }
  
  public UIOutStockRecordCriteria buildFrom(final RCOutStockRecordCriteria entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecordCriteria result = new com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecordCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIOutStockRecordCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return RCOutStockRecordCriteria.class;
  }
}
