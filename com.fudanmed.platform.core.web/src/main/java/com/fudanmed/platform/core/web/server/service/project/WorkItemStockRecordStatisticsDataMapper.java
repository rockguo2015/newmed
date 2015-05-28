package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecordItem;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockRecordStatisticsData;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.WorkItemStockRecordStatisticsDataMapper")
public class WorkItemStockRecordStatisticsDataMapper extends AbstractEntityMapper<UIWorkItemStockRecordStatisticsData,RCWorkItemStockRecordItem> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCWorkItemStockRecordItem loadEntityById(final Long id) {
    return entities.get(RCWorkItemStockRecordItem.class,id);
  }
  
  public RCWorkItemStockRecordItem create() {
    return entities.create(RCWorkItemStockRecordItem.class);
  }
  
  public void copyToEntity(final UIWorkItemStockRecordStatisticsData from, final RCWorkItemStockRecordItem to) {
    to.setVersion(from.getVersion());
    
  }
  
  public UIWorkItemStockRecordStatisticsData copyFromEntity(final UIWorkItemStockRecordStatisticsData result, final RCWorkItemStockRecordItem entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    if(entity. getRecord()  != null &&entity. getRecord().getWorkItem()  != null &&entity. getRecord().getWorkItem().getGroupTask()  != null )
    	result.setTeam(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy.class,entity.getRecord().getWorkItem().getGroupTask().getTeam()));
    if(entity. getRecordItem()  != null &&entity. getRecordItem().getProductEntry()  != null &&entity. getRecordItem().getProductEntry().getProductSpec()  != null )
    	result.setMaterialId(convertService.toValue(java.lang.String.class,entity.getRecordItem().getProductEntry().getProductSpec().getMaterialId()));
    if(entity. getRecordItem()  != null &&entity. getRecordItem().getProductEntry()  != null &&entity. getRecordItem().getProductEntry().getProductSpec()  != null )
    	result.setName(convertService.toValue(java.lang.String.class,entity.getRecordItem().getProductEntry().getProductSpec().getName()));
    if(entity. getRecordItem()  != null &&entity. getRecordItem().getProductEntry()  != null &&entity. getRecordItem().getProductEntry().getProductSpec()  != null )
    	result.setTypeDesc(convertService.toValue(java.lang.String.class,entity.getRecordItem().getProductEntry().getProductSpec().getTypeDesc()));
    if(entity. getRecordItem()  != null &&entity. getRecordItem().getProductEntry()  != null &&entity. getRecordItem().getProductEntry().getProductSpec()  != null )
    	result.setUnit(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy.class,entity.getRecordItem().getProductEntry().getProductSpec().getUnit()));
    if(entity. getRecordItem()  != null &&entity. getRecordItem().getProductEntry()  != null )
    	result.setPrice(convertService.toValue(java.lang.Double.class,entity.getRecordItem().getProductEntry().getPrice()));
    if(entity. getRecordItem()  != null )
    	result.setQuantity(convertService.toValue(java.lang.Integer.class,entity.getRecordItem().getQuantity()));
    if(entity. getRecordItem()  != null )
    	result.setAmount(convertService.toValue(java.lang.Double.class,entity.getRecordItem().getTotalAmount()));
    if(entity. getRecord()  != null &&entity. getRecord().getWorkItem()  != null &&entity. getRecord().getWorkItem().getGroupTask()  != null &&entity. getRecord().getWorkItem().getGroupTask().getRepairTask()  != null )
    	result.setReportOrg(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy.class,entity.getRecord().getWorkItem().getGroupTask().getRepairTask().getReportOrg()));
    if(entity. getRecord()  != null )
    	result.setDate(convertService.toValue(java.util.Date.class,entity.getRecord().getDate()));
    if(entity. getRecord()  != null &&entity. getRecord().getWorkItem()  != null &&entity. getRecord().getWorkItem().getGroupTask()  != null &&entity. getRecord().getWorkItem().getGroupTask().getRepairTask()  != null )
    	result.setReportSid(convertService.toValue(java.lang.String.class,entity.getRecord().getWorkItem().getGroupTask().getRepairTask().getReportSid()));
    if(entity. getRecord()  != null &&entity. getRecord().getWorkItem()  != null )
    	result.setWorkItemSid(convertService.toValue(java.lang.String.class,entity.getRecord().getWorkItem().getSid()));
    if(entity. getRecord()  != null )
    	result.setInoutStockSid(convertService.toValue(java.lang.String.class,entity.getRecord().getSid()));
    return result;
    
  }
  
  public UIWorkItemStockRecordStatisticsData buildFrom(final RCWorkItemStockRecordItem entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.project.UIWorkItemStockRecordStatisticsData result = new com.fudanmed.platform.core.web.shared.project.UIWorkItemStockRecordStatisticsData();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIWorkItemStockRecordStatisticsData.class;
  }
  
  public Class<?> getEntityClass() {
    return RCWorkItemStockRecordItem.class;
  }
}
