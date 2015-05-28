package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.common.RCSequenceService;
import com.fudanmed.platform.core.warehouse.RCInStockRecord;
import com.fudanmed.platform.core.warehouse.RCInStockRecordItem;
import com.fudanmed.platform.core.web.server.service.warehouse.InStockRecordItemMapper;
import com.fudanmed.platform.core.web.server.service.warehouse.InStockRecordValidator;
import com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecord;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.InStockRecordMapper")
public class InStockRecordMapper extends AbstractEntityMapper<UIInStockRecord,RCInStockRecord> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCInStockRecord loadEntityById(final Long id) {
    return entities.get(RCInStockRecord.class,id);
  }
  
  public RCInStockRecord create() {
    return entities.create(RCInStockRecord.class);
  }
  
  @Autowired
  private RCSequenceService warehouseSequenceService;
  
  @Autowired
  private InStockRecordItemMapper __InStockRecordItemMapper__;
  
  @Autowired
  private InStockRecordValidator validator;
  
  public void copyToEntity(final UIInStockRecord from, final RCInStockRecord to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setDate(convertService.toValue(java.util.Date.class,from.getDate()));
    convertService.toPartEntity(from.getItems(),to.getItems(),__InStockRecordItemMapper__,to);
    to.setStore(convertService.toValue(com.fudanmed.platform.core.warehouse.RCWarehouse.class,from.getStore()));
    to.setInStoreType(convertService.toValue(com.fudanmed.platform.core.warehouse.RCInStoreType.class,from.getInStoreType()));
    to.setInvoiceNumber(convertService.toValue(java.lang.String.class,from.getInvoiceNumber()));
    to.setDeliverNumber(convertService.toValue(java.lang.String.class,from.getDeliverNumber()));
    to.setComment(convertService.toValue(java.lang.String.class,from.getComment()));
    to.setSupplier(convertService.toValue(com.fudanmed.platform.core.domain.RCSupplier.class,from.getSupplier()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final UIInStockRecord _gwt, final RCInStockRecord _entity) {
    String _nextInStockSequence = this.warehouseSequenceService.getNextInStockSequence();
    _entity.setSid(_nextInStockSequence);
    Collection<RCInStockRecordItem> _items = _entity.getItems();
    final Procedure1<RCInStockRecordItem> _function = new Procedure1<RCInStockRecordItem>() {
        public void apply(final RCInStockRecordItem it) {
          String _sid = it.getSid();
          boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_sid);
          if (_isNullOrEmpty) {
            String _sid_1 = _entity.getSid();
            it.setSid(_sid_1);
          }
        }
      };
    IterableExtensions.<RCInStockRecordItem>forEach(_items, _function);
  }
  
  public UIInStockRecord copyFromEntity(final UIInStockRecord result, final RCInStockRecord entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setSid(convertService.toValue(java.lang.String.class,entity.getSid()));
    result.setDate(convertService.toValue(java.util.Date.class,entity.getDate()));
    result.setOperator(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy.class,entity.getOperator()));
    result.setItems(convertService.toGwtEntity(entity.getItems(),__InStockRecordItemMapper__));
    result.setStore(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy.class,entity.getStore()));
    result.setInStoreType(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCInStoreTypeProxy.class,entity.getInStoreType()));
    result.setInvoiceNumber(convertService.toValue(java.lang.String.class,entity.getInvoiceNumber()));
    result.setDeliverNumber(convertService.toValue(java.lang.String.class,entity.getDeliverNumber()));
    result.setComment(convertService.toValue(java.lang.String.class,entity.getComment()));
    result.setSupplier(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCSupplierProxy.class,entity.getSupplier()));
    result.setCommitted(convertService.toValue(java.lang.Boolean.class,entity.getCommitted()));
    return result;
    
  }
  
  public UIInStockRecord buildFrom(final RCInStockRecord entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecord result = new com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecord();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIInStockRecord.class;
  }
  
  public Class<?> getEntityClass() {
    return RCInStockRecord.class;
  }
}
