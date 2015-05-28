package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCGroupTask;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.warehouse.RCWorkItemStorage;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStorage4Settlement;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.WorkItemStorage4SettlementMapper")
public class WorkItemStorage4SettlementMapper extends AbstractEntityMapper<UIWorkItemStorage4Settlement,RCWorkItemStorage> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCWorkItemStorage loadEntityById(final Long id) {
    return entities.get(RCWorkItemStorage.class,id);
  }
  
  public RCWorkItemStorage create() {
    return entities.create(RCWorkItemStorage.class);
  }
  
  public void copyToEntity(final UIWorkItemStorage4Settlement from, final RCWorkItemStorage to) {
    to.setVersion(from.getVersion());
    
  }
  
  public UIWorkItemStorage4Settlement copyFromEntity(final UIWorkItemStorage4Settlement result, final RCWorkItemStorage entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setAmount(convertService.toValue(java.lang.Double.class,entity.getAmount()));
    if(entity. getProductEntry()  != null )
    	result.setProductSpec(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy.class,entity.getProductEntry().getProductSpec()));
    if(entity. getProductEntry()  != null )
    	result.setSid(convertService.toValue(java.lang.String.class,entity.getProductEntry().getSid()));
    result.setQuantity(convertService.toValue(java.lang.Integer.class,entity.getQuantity()));
    if(entity. getProductEntry()  != null &&entity. getProductEntry().getProductSpec()  != null )
    	result.setProductSid(convertService.toValue(java.lang.String.class,entity.getProductEntry().getProductSpec().getSid()));
    if(entity. getProductEntry()  != null &&entity. getProductEntry().getProductSpec()  != null )
    	result.setTypeDesc(convertService.toValue(java.lang.String.class,entity.getProductEntry().getProductSpec().getTypeDesc()));
    if(entity. getProductEntry()  != null &&entity. getProductEntry().getProductSpec()  != null )
    	result.setUnit(convertService.toValue(com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy.class,entity.getProductEntry().getProductSpec().getUnit()));
    if(entity. getProductEntry()  != null &&entity. getProductEntry().getProductSpec()  != null )
    	result.setMaterialId(convertService.toValue(java.lang.String.class,entity.getProductEntry().getProductSpec().getMaterialId()));
    if(entity. getProductEntry()  != null )
    	result.setPrice(convertService.toValue(java.lang.Double.class,entity.getProductEntry().getPrice()));
    if(entity. getProductEntry()  != null &&entity. getProductEntry().getProductSpec()  != null )
    	result.setBrand(convertService.toValue(com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy.class,entity.getProductEntry().getProductSpec().getBrandType()));
    buildFromCust(result,entity);
    return result;
    
  }
  
  public UIWorkItemStorage4Settlement buildFrom(final RCWorkItemStorage entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.project.UIWorkItemStorage4Settlement result = new com.fudanmed.platform.core.web.shared.project.UIWorkItemStorage4Settlement();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  protected void buildFromCust(final UIWorkItemStorage4Settlement _gwt, final RCWorkItemStorage _entity) {
    RCWorkItemTask _workItem = _entity.getWorkItem();
    RCGroupTask _groupTask = _workItem.getGroupTask();
    RCRepairTask repairTask = _groupTask.getRepairTask();
    String _reportSid = repairTask.getReportSid();
    _gwt.setRepairTaskSid(_reportSid);
    String _reportSid_1 = repairTask.getReportSid();
    String _plus = (_reportSid_1 + "[\u5C0F\u8BA1:");
    Double _amount = repairTask.getAmount();
    String _plus_1 = (_plus + _amount);
    String _plus_2 = (_plus_1 + "\u5143]");
    _gwt.setRepairTaskInfo(_plus_2);
  }
  
  public Class<?> getUIClass() {
    return UIWorkItemStorage4Settlement.class;
  }
  
  public Class<?> getEntityClass() {
    return RCWorkItemStorage.class;
  }
}
