package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCInStockRecordCriteria;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.RCWarehouseDAO;
import com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecordCriteria;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.InStockRecordCriteriaMapper")
public class InStockRecordCriteriaMapper extends AbstractDataTypeMapper<UIInStockRecordCriteria,RCInStockRecordCriteria> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private RCWarehouseDAO warehouseDAO;
  
  public void copyToEntity(final UIInStockRecordCriteria from, final RCInStockRecordCriteria to) {
    to.setSid(convertService.toValue(java.lang.String.class,from.getSid()));
    to.setDateFrom(convertService.toValue(java.util.Date.class,from.getDateFrom()));
    to.setDateTo(convertService.toValue(java.util.Date.class,from.getDateTo()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final UIInStockRecordCriteria _gwt, final RCInStockRecordCriteria _entity) {
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
  
  public UIInStockRecordCriteria copyFromEntity(final UIInStockRecordCriteria result, final RCInStockRecordCriteria entity) {
    if(entity==null) return null;
    result.setSid(convertService.toValue(java.lang.String.class,entity.getSid()));
    result.setDateFrom(convertService.toValue(java.util.Date.class,entity.getDateFrom()));
    result.setDateTo(convertService.toValue(java.util.Date.class,entity.getDateTo()));
    return result;
    
  }
  
  public UIInStockRecordCriteria buildFrom(final RCInStockRecordCriteria entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecordCriteria result = new com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecordCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIInStockRecordCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return RCInStockRecordCriteria.class;
  }
}
