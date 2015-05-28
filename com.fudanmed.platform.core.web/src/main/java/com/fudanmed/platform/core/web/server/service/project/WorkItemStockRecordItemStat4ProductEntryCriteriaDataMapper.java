package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.warehouse.RCProduceSpecificationUnit;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecordItemStat4ProductEntryCriteriaData;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockRecordItemStat4ProductEntryCriteriaData;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.WorkItemStockRecordItemStat4ProductEntryCriteriaDataMapper")
public class WorkItemStockRecordItemStat4ProductEntryCriteriaDataMapper extends AbstractDataTypeMapper<UIWorkItemStockRecordItemStat4ProductEntryCriteriaData,RCWorkItemStockRecordItemStat4ProductEntryCriteriaData> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UIWorkItemStockRecordItemStat4ProductEntryCriteriaData from, final RCWorkItemStockRecordItemStat4ProductEntryCriteriaData to) {
    
  }
  
  public UIWorkItemStockRecordItemStat4ProductEntryCriteriaData copyFromEntity(final UIWorkItemStockRecordItemStat4ProductEntryCriteriaData result, final RCWorkItemStockRecordItemStat4ProductEntryCriteriaData entity) {
    if(entity==null) return null;
    result.setProductEntry(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy.class,entity.getProductEntry()));
    result.setCnt(convertService.toValue(java.lang.Long.class,entity.getCnt()));
    buildFromCust(result,entity);
    return result;
    
  }
  
  public UIWorkItemStockRecordItemStat4ProductEntryCriteriaData buildFrom(final RCWorkItemStockRecordItemStat4ProductEntryCriteriaData entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.project.UIWorkItemStockRecordItemStat4ProductEntryCriteriaData result = new com.fudanmed.platform.core.web.shared.project.UIWorkItemStockRecordItemStat4ProductEntryCriteriaData();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  protected void buildFromCust(final UIWorkItemStockRecordItemStat4ProductEntryCriteriaData _gwt, final RCWorkItemStockRecordItemStat4ProductEntryCriteriaData _entity) {
    RCProductSpecification _productEntry = _entity.getProductEntry();
    String _typeDesc = _productEntry.getTypeDesc();
    _gwt.setTypeDesc(_typeDesc);
    RCProductSpecification _productEntry_1 = _entity.getProductEntry();
    RCProduceSpecificationUnit _unit = _productEntry_1.getUnit();
    String _name = _unit.getName();
    _gwt.setUnit(_name);
  }
  
  public Class<?> getUIClass() {
    return UIWorkItemStockRecordItemStat4ProductEntryCriteriaData.class;
  }
  
  public Class<?> getEntityClass() {
    return RCWorkItemStockRecordItemStat4ProductEntryCriteriaData.class;
  }
}
