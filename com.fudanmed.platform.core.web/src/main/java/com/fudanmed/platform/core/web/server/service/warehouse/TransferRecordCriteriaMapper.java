package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCTransferRecordCriteria;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.RCWarehouseDAO;
import com.fudanmed.platform.core.web.shared.warehouse.UITransferRecordCriteria;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.TransferRecordCriteriaMapper")
public class TransferRecordCriteriaMapper extends AbstractDataTypeMapper<UITransferRecordCriteria,RCTransferRecordCriteria> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private RCWarehouseDAO warehouseDAO;
  
  public void copyToEntity(final UITransferRecordCriteria from, final RCTransferRecordCriteria to) {
    to.setTargetStore(convertService.toValue(com.fudanmed.platform.core.warehouse.RCWarehouse.class,from.getTargetStore()));
    to.setDateFrom(convertService.toValue(java.util.Date.class,from.getDateFrom()));
    to.setDateTo(convertService.toValue(java.util.Date.class,from.getDateTo()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final UITransferRecordCriteria _gwt, final RCTransferRecordCriteria _entity) {
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
  
  public UITransferRecordCriteria copyFromEntity(final UITransferRecordCriteria result, final RCTransferRecordCriteria entity) {
    if(entity==null) return null;
    result.setTargetStore(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy.class,entity.getTargetStore()));
    result.setDateFrom(convertService.toValue(java.util.Date.class,entity.getDateFrom()));
    result.setDateTo(convertService.toValue(java.util.Date.class,entity.getDateTo()));
    return result;
    
  }
  
  public UITransferRecordCriteria buildFrom(final RCTransferRecordCriteria entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.warehouse.UITransferRecordCriteria result = new com.fudanmed.platform.core.web.shared.warehouse.UITransferRecordCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UITransferRecordCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return RCTransferRecordCriteria.class;
  }
}
