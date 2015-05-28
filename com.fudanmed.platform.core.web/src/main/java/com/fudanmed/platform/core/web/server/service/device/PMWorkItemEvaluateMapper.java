package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.pm.RCPMWorkItemEvaluate;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemEvaluate;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.device.PMWorkItemEvaluateMapper")
public class PMWorkItemEvaluateMapper extends AbstractDataTypeMapper<UIPMWorkItemEvaluate,RCPMWorkItemEvaluate> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UIPMWorkItemEvaluate from, final RCPMWorkItemEvaluate to) {
    to.setWorker(convertService.toValue(java.lang.String.class,from.getWorker()));
    to.setNotifyDate(convertService.toValue(java.util.Date.class,from.getNotifyDate()));
    to.setArriveDate(convertService.toValue(java.util.Date.class,from.getArriveDate()));
    to.setPrice(convertService.toValue(java.lang.Double.class,from.getPrice()));
    to.setMaterials(convertService.toValue(java.lang.String.class,from.getMaterials()));
    to.setArrivalOnTime(convertService.toValue(java.lang.Integer.class,from.getArrivalOnTime()));
    to.setAttitude(convertService.toValue(java.lang.Integer.class,from.getAttitude()));
    to.setFrequency(convertService.toValue(java.lang.Integer.class,from.getFrequency()));
    to.setQuality(convertService.toValue(java.lang.Integer.class,from.getQuality()));
    to.setProblemsRemains(convertService.toValue(java.lang.String.class,from.getProblemsRemains()));
    to.setComment(convertService.toValue(java.lang.String.class,from.getComment()));
    
  }
  
  public UIPMWorkItemEvaluate copyFromEntity(final UIPMWorkItemEvaluate result, final RCPMWorkItemEvaluate entity) {
    if(entity==null) return null;
    result.setWorker(convertService.toValue(java.lang.String.class,entity.getWorker()));
    result.setNotifyDate(convertService.toValue(java.util.Date.class,entity.getNotifyDate()));
    result.setArriveDate(convertService.toValue(java.util.Date.class,entity.getArriveDate()));
    result.setPrice(convertService.toValue(java.lang.Double.class,entity.getPrice()));
    result.setMaterials(convertService.toValue(java.lang.String.class,entity.getMaterials()));
    result.setArrivalOnTime(convertService.toValue(java.lang.Integer.class,entity.getArrivalOnTime()));
    result.setAttitude(convertService.toValue(java.lang.Integer.class,entity.getAttitude()));
    result.setFrequency(convertService.toValue(java.lang.Integer.class,entity.getFrequency()));
    result.setQuality(convertService.toValue(java.lang.Integer.class,entity.getQuality()));
    result.setProblemsRemains(convertService.toValue(java.lang.String.class,entity.getProblemsRemains()));
    result.setComment(convertService.toValue(java.lang.String.class,entity.getComment()));
    return result;
    
  }
  
  public UIPMWorkItemEvaluate buildFrom(final RCPMWorkItemEvaluate entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.device.UIPMWorkItemEvaluate result = new com.fudanmed.platform.core.web.shared.device.UIPMWorkItemEvaluate();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIPMWorkItemEvaluate.class;
  }
  
  public Class<?> getEntityClass() {
    return RCPMWorkItemEvaluate.class;
  }
}
