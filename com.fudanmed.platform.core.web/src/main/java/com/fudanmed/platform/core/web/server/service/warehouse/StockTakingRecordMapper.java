package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductSpecificationSummary;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary;
import com.fudanmed.platform.core.warehouse.RCStockTakingRecord;
import com.fudanmed.platform.core.web.server.service.warehouse.StockTakingRecordValidator;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIWarehouseProductSpecSummary;
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

@Component("com.fudanmed.platform.core.web.server.service.warehouse.StockTakingRecordMapper")
public class StockTakingRecordMapper extends AbstractEntityMapper<UIStockTakingRecord,RCStockTakingRecord> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCStockTakingRecord loadEntityById(final Long id) {
    return entities.get(RCStockTakingRecord.class,id);
  }
  
  public RCStockTakingRecord create() {
    return entities.create(RCStockTakingRecord.class);
  }
  
  @Autowired
  private StockTakingRecordValidator validator;
  
  public void copyToEntity(final UIStockTakingRecord from, final RCStockTakingRecord to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setSourceStore(convertService.toValue(com.fudanmed.platform.core.warehouse.RCWarehouse.class,from.getSourceStore()));
    to.setDate(convertService.toValue(java.util.Date.class,from.getDate()));
    to.setOperator(convertService.toValue(com.fudanmed.platform.core.domain.RCEmployee.class,from.getOperator()));
    to.setComment(convertService.toValue(java.lang.String.class,from.getComment()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final UIStockTakingRecord _gwt, final RCStockTakingRecord _entity) {
    Collection<UIWarehouseProductSpecSummary> _itemSummarys = _gwt.getItemSummarys();
    final Function1<UIWarehouseProductSpecSummary,RCProductSpecificationSummary> _function = new Function1<UIWarehouseProductSpecSummary,RCProductSpecificationSummary>() {
        public RCProductSpecificationSummary apply(final UIWarehouseProductSpecSummary itemSummary) {
          RCProductSpecificationSummary _rCProductSpecificationSummary = new RCProductSpecificationSummary();
          final Procedure1<RCProductSpecificationSummary> _function = new Procedure1<RCProductSpecificationSummary>() {
              public void apply(final RCProductSpecificationSummary it) {
                UIProductWarehouseStorageSummary _storageSummary = itemSummary.getStorageSummary();
                Long _id = _storageSummary.getId();
                RCProductWarehouseStorageSummary _get = StockTakingRecordMapper.this.entities.<RCProductWarehouseStorageSummary>get(RCProductWarehouseStorageSummary.class, _id);
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
  
  public UIStockTakingRecord copyFromEntity(final UIStockTakingRecord result, final RCStockTakingRecord entity) {
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
    return result;
    
  }
  
  public UIStockTakingRecord buildFrom(final RCStockTakingRecord entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecord result = new com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecord();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIStockTakingRecord.class;
  }
  
  public Class<?> getEntityClass() {
    return RCStockTakingRecord.class;
  }
}
