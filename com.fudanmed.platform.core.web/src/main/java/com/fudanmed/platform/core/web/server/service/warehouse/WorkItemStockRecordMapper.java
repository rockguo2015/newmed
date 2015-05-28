package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecord;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.WorkItemStockRecordMapper")
public class WorkItemStockRecordMapper extends AbstractEntityMapper<UIWorkItemStockRecord,RCWorkItemStockRecord> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCWorkItemStockRecord loadEntityById(final Long id) {
    return entities.get(RCWorkItemStockRecord.class,id);
  }
  
  public RCWorkItemStockRecord create() {
    return entities.create(RCWorkItemStockRecord.class);
  }
  
  public void copyToEntity(final UIWorkItemStockRecord from, final RCWorkItemStockRecord to) {
    to.setVersion(from.getVersion());
    to.setSourceStore(convertService.toValue(com.fudanmed.platform.core.warehouse.RCWarehouse.class,from.getSourceStore()));
    to.setWorkItem(convertService.toValue(com.fudanmed.platform.core.domain.RCWorkItemTask.class,from.getWorkItem()));
    to.setDate(convertService.toValue(java.util.Date.class,from.getDate()));
    to.setOperator(convertService.toValue(com.fudanmed.platform.core.domain.RCEmployee.class,from.getOperator()));
    to.setComment(convertService.toValue(java.lang.String.class,from.getComment()));
    
  }
  
  public UIWorkItemStockRecord copyFromEntity(final UIWorkItemStockRecord result, final RCWorkItemStockRecord entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setTypeName(convertService.toValue(java.lang.String.class,entity.getTypeName()));
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
  
  public UIWorkItemStockRecord buildFrom(final RCWorkItemStockRecord entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecord result = new com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecord();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIWorkItemStockRecord.class;
  }
  
  public Class<?> getEntityClass() {
    return RCWorkItemStockRecord.class;
  }
}
