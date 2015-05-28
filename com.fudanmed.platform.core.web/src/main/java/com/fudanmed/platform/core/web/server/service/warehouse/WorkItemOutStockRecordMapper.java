package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductSpecificationSummary;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary;
import com.fudanmed.platform.core.warehouse.RCWorkItemOutStockRecord;
import com.fudanmed.platform.core.web.server.service.warehouse.WorkItemOutStockRecordValidator;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.fudanmed.platform.core.web.shared.warehouse.UIWarehouseProductSpecSummary;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemOutStockRecord;
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

@Component("com.fudanmed.platform.core.web.server.service.warehouse.WorkItemOutStockRecordMapper")
public class WorkItemOutStockRecordMapper extends AbstractEntityMapper<UIWorkItemOutStockRecord,RCWorkItemOutStockRecord> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCWorkItemOutStockRecord loadEntityById(final Long id) {
    return entities.get(RCWorkItemOutStockRecord.class,id);
  }
  
  public RCWorkItemOutStockRecord create() {
    return entities.create(RCWorkItemOutStockRecord.class);
  }
  
  @Autowired
  private WorkItemOutStockRecordValidator validator;
  
  public void copyToEntity(final UIWorkItemOutStockRecord from, final RCWorkItemOutStockRecord to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setSourceStore(convertService.toValue(com.fudanmed.platform.core.warehouse.RCWarehouse.class,from.getSourceStore()));
    to.setWorkItem(convertService.toValue(com.fudanmed.platform.core.domain.RCWorkItemTask.class,from.getWorkItem()));
    to.setDate(convertService.toValue(java.util.Date.class,from.getDate()));
    to.setOperator(convertService.toValue(com.fudanmed.platform.core.domain.RCEmployee.class,from.getOperator()));
    to.setComment(convertService.toValue(java.lang.String.class,from.getComment()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final UIWorkItemOutStockRecord _gwt, final RCWorkItemOutStockRecord _entity) {
    Collection<UIWarehouseProductSpecSummary> _itemSummarys = _gwt.getItemSummarys();
    final Function1<UIWarehouseProductSpecSummary,RCProductSpecificationSummary> _function = new Function1<UIWarehouseProductSpecSummary,RCProductSpecificationSummary>() {
        public RCProductSpecificationSummary apply(final UIWarehouseProductSpecSummary itemSummary) {
          RCProductSpecificationSummary _rCProductSpecificationSummary = new RCProductSpecificationSummary();
          final Procedure1<RCProductSpecificationSummary> _function = new Procedure1<RCProductSpecificationSummary>() {
              public void apply(final RCProductSpecificationSummary it) {
                UIProductWarehouseStorageSummary _storageSummary = itemSummary.getStorageSummary();
                Long _id = _storageSummary.getId();
                RCProductWarehouseStorageSummary _get = WorkItemOutStockRecordMapper.this.entities.<RCProductWarehouseStorageSummary>get(RCProductWarehouseStorageSummary.class, _id);
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
  
  public UIWorkItemOutStockRecord copyFromEntity(final UIWorkItemOutStockRecord result, final RCWorkItemOutStockRecord entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setSid(convertService.toValue(java.lang.String.class,entity.getSid()));
    result.setSourceStore(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy.class,entity.getSourceStore()));
    result.setWorkItem(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy.class,entity.getWorkItem()));
    result.setDate(convertService.toValue(java.util.Date.class,entity.getDate()));
    result.setOperator(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy.class,entity.getOperator()));
    result.setComment(convertService.toValue(java.lang.String.class,entity.getComment()));
    if(entity. getWorkItem()  != null &&entity. getWorkItem().getGroupTask()  != null &&entity. getWorkItem().getGroupTask().getRepairTask()  != null )
    	result.setReportSid(convertService.toValue(java.lang.String.class,entity.getWorkItem().getGroupTask().getRepairTask().getReportSid()));
    return result;
    
  }
  
  public UIWorkItemOutStockRecord buildFrom(final RCWorkItemOutStockRecord entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemOutStockRecord result = new com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemOutStockRecord();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIWorkItemOutStockRecord.class;
  }
  
  public Class<?> getEntityClass() {
    return RCWorkItemOutStockRecord.class;
  }
}
