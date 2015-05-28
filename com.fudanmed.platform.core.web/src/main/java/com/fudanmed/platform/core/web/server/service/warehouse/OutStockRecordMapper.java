package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCOutStockRecord;
import com.fudanmed.platform.core.warehouse.RCOutStockRecordItem;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductSpecificationSummary;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary;
import com.fudanmed.platform.core.web.server.service.warehouse.OutStockRecordValidator;
import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.fudanmed.platform.core.web.shared.warehouse.UIWarehouseProductSpecSummary;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.OutStockRecordMapper")
public class OutStockRecordMapper extends AbstractEntityMapper<UIOutStockRecord,RCOutStockRecord> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCOutStockRecord loadEntityById(final Long id) {
    return entities.get(RCOutStockRecord.class,id);
  }
  
  public RCOutStockRecord create() {
    return entities.create(RCOutStockRecord.class);
  }
  
  @Autowired
  private OutStockRecordValidator validator;
  
  public void copyToEntity(final UIOutStockRecord from, final RCOutStockRecord to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setSourceStore(convertService.toValue(com.fudanmed.platform.core.warehouse.RCWarehouse.class,from.getSourceStore()));
    to.setDate(convertService.toValue(java.util.Date.class,from.getDate()));
    to.setOperator(convertService.toValue(com.fudanmed.platform.core.domain.RCEmployee.class,from.getOperator()));
    to.setComment(convertService.toValue(java.lang.String.class,from.getComment()));
    to.setType(convertService.toValue(com.fudanmed.platform.core.common.RCOutStockType.class,from.getType()));
    to.setTeam(convertService.toValue(com.fudanmed.platform.core.domain.RCMaintenanceTeam.class,from.getTeam()));
    to.setWorker(convertService.toValue(com.fudanmed.platform.core.domain.RCEmployee.class,from.getWorker()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final UIOutStockRecord _gwt, final RCOutStockRecord _entity) {
    Collection<UIWarehouseProductSpecSummary> _itemSummarys = _gwt.getItemSummarys();
    final Function1<UIWarehouseProductSpecSummary,RCProductSpecificationSummary> _function = new Function1<UIWarehouseProductSpecSummary,RCProductSpecificationSummary>() {
        public RCProductSpecificationSummary apply(final UIWarehouseProductSpecSummary itemSummary) {
          RCProductSpecificationSummary _rCProductSpecificationSummary = new RCProductSpecificationSummary();
          final Procedure1<RCProductSpecificationSummary> _function = new Procedure1<RCProductSpecificationSummary>() {
              public void apply(final RCProductSpecificationSummary it) {
                UIProductWarehouseStorageSummary _storageSummary = itemSummary.getStorageSummary();
                Long _id = _storageSummary.getId();
                RCProductWarehouseStorageSummary _get = OutStockRecordMapper.this.entities.<RCProductWarehouseStorageSummary>get(RCProductWarehouseStorageSummary.class, _id);
                RCProductSpecification _productSpec = _get.getProductSpec();
                it.setProductSpec(_productSpec);
                Integer _quantity = itemSummary.getQuantity();
                it.setQuantity(_quantity);
              }
            };
          RCProductSpecificationSummary _doubleArrow = ObjectExtensions.<RCProductSpecificationSummary>operator_doubleArrow(_rCProductSpecificationSummary, _function);
          return _doubleArrow;
        }
      };
    Iterable<RCProductSpecificationSummary> _map = IterableExtensions.<UIWarehouseProductSpecSummary, RCProductSpecificationSummary>map(_itemSummarys, _function);
    List<RCProductSpecificationSummary> _list = IterableExtensions.<RCProductSpecificationSummary>toList(_map);
    _entity.initItemsFromSummary(_list);
  }
  
  public UIOutStockRecord copyFromEntity(final UIOutStockRecord result, final RCOutStockRecord entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setSid(convertService.toValue(java.lang.String.class,entity.getSid()));
    result.setSourceStore(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy.class,entity.getSourceStore()));
    result.setDate(convertService.toValue(java.util.Date.class,entity.getDate()));
    result.setOperator(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy.class,entity.getOperator()));
    result.setComment(convertService.toValue(java.lang.String.class,entity.getComment()));
    result.setCommitted(convertService.toValue(java.lang.Boolean.class,entity.getCommitted()));
    result.setType(convertService.toValue(com.fudanmed.platform.core.common.proxy.RCOutStockTypeProxy.class,entity.getType()));
    result.setTeam(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy.class,entity.getTeam()));
    result.setWorker(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy.class,entity.getWorker()));
    buildFromCust(result,entity);
    return result;
    
  }
  
  public UIOutStockRecord buildFrom(final RCOutStockRecord entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecord result = new com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecord();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  protected void buildFromCust(final UIOutStockRecord _gwt, final RCOutStockRecord _entity) {
    Collection<RCOutStockRecordItem> _items = _entity.getItems();
    final Function1<RCOutStockRecordItem,UIWarehouseProductSpecSummary> _function = new Function1<RCOutStockRecordItem,UIWarehouseProductSpecSummary>() {
        public UIWarehouseProductSpecSummary apply(final RCOutStockRecordItem item) {
          UIWarehouseProductSpecSummary _uIWarehouseProductSpecSummary = new UIWarehouseProductSpecSummary();
          final Procedure1<UIWarehouseProductSpecSummary> _function = new Procedure1<UIWarehouseProductSpecSummary>() {
              public void apply(final UIWarehouseProductSpecSummary it) {
              }
            };
          UIWarehouseProductSpecSummary _doubleArrow = ObjectExtensions.<UIWarehouseProductSpecSummary>operator_doubleArrow(_uIWarehouseProductSpecSummary, _function);
          return _doubleArrow;
        }
      };
    Iterable<UIWarehouseProductSpecSummary> _map = IterableExtensions.<RCOutStockRecordItem, UIWarehouseProductSpecSummary>map(_items, _function);
    Collection<UIWarehouseProductSpecSummary> _unlazy = IterableExtensions2.<UIWarehouseProductSpecSummary>unlazy(_map);
    _gwt.setItemSummarys(_unlazy);
  }
  
  public Class<?> getUIClass() {
    return UIOutStockRecord.class;
  }
  
  public Class<?> getEntityClass() {
    return RCOutStockRecord.class;
  }
}
