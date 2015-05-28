package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductSpecificationSummary;
import com.fudanmed.platform.core.warehouse.RCWorkItemReturnStockRecord;
import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.web.server.service.warehouse.WorkItemReturnStockRecordValidator;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecificationSummary;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemProductSpecSummary;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemReturnStockRecord;
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

@Component("com.fudanmed.platform.core.web.server.service.warehouse.WorkItemReturnStockRecordMapper")
public class WorkItemReturnStockRecordMapper extends AbstractEntityMapper<UIWorkItemReturnStockRecord,RCWorkItemReturnStockRecord> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCWorkItemReturnStockRecord loadEntityById(final Long id) {
    return entities.get(RCWorkItemReturnStockRecord.class,id);
  }
  
  public RCWorkItemReturnStockRecord create() {
    return entities.create(RCWorkItemReturnStockRecord.class);
  }
  
  @Autowired
  private WorkItemReturnStockRecordValidator validator;
  
  public void copyToEntity(final UIWorkItemReturnStockRecord from, final RCWorkItemReturnStockRecord to) {
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
  
  protected void copyToCust(final UIWorkItemReturnStockRecord _gwt, final RCWorkItemReturnStockRecord _entity) {
    Collection<UIWorkItemProductSpecSummary> _itemSummarys = _gwt.getItemSummarys();
    final Function1<UIWorkItemProductSpecSummary,RCProductSpecificationSummary> _function = new Function1<UIWorkItemProductSpecSummary,RCProductSpecificationSummary>() {
        public RCProductSpecificationSummary apply(final UIWorkItemProductSpecSummary itemSummary) {
          RCProductSpecificationSummary _rCProductSpecificationSummary = new RCProductSpecificationSummary();
          final Procedure1<RCProductSpecificationSummary> _function = new Procedure1<RCProductSpecificationSummary>() {
              public void apply(final RCProductSpecificationSummary it) {
                UIProductSpecificationSummary _productSpecSummary = itemSummary.getProductSpecSummary();
                RCProductSpecificationProxy _productSpec = _productSpecSummary.getProductSpec();
                Long _id = _productSpec.getId();
                RCProductSpecification _get = WorkItemReturnStockRecordMapper.this.entities.<RCProductSpecification>get(RCProductSpecification.class, _id);
                it.setProductSpec(_get);
                Integer _quantity = itemSummary.getQuantity();
                it.setQuantity(_quantity);
              }
            };
          RCProductSpecificationSummary _doubleArrow = ObjectExtensions.<RCProductSpecificationSummary>operator_doubleArrow(_rCProductSpecificationSummary, _function);
          return _doubleArrow;
        }
      };
    Iterable<RCProductSpecificationSummary> _map = IterableExtensions.<UIWorkItemProductSpecSummary, RCProductSpecificationSummary>map(_itemSummarys, _function);
    List<RCProductSpecificationSummary> _list = IterableExtensions.<RCProductSpecificationSummary>toList(_map);
    _entity.initItemsFromSummary(_list);
  }
  
  public UIWorkItemReturnStockRecord copyFromEntity(final UIWorkItemReturnStockRecord result, final RCWorkItemReturnStockRecord entity) {
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
  
  public UIWorkItemReturnStockRecord buildFrom(final RCWorkItemReturnStockRecord entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemReturnStockRecord result = new com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemReturnStockRecord();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIWorkItemReturnStockRecord.class;
  }
  
  public Class<?> getEntityClass() {
    return RCWorkItemReturnStockRecord.class;
  }
}
