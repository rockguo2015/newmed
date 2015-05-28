package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCRepairTaskCriteria;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskCriteria;
import com.fudanmed.platform.core.web.shared.project.WorkflowEnumWorkAround;
import com.google.common.base.Objects;
import com.uniquesoft.gwt.shared.datatype.UIDateRange;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.RepairTaskCriteriaMapper")
public class RepairTaskCriteriaMapper extends AbstractDataTypeMapper<UIRepairTaskCriteria,RCRepairTaskCriteria> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UIRepairTaskCriteria from, final RCRepairTaskCriteria to) {
    to.setComment(convertService.toValue(java.lang.String.class,from.getComment()));
    to.setIncludeFinishedTask(convertService.toValue(java.lang.Boolean.class,from.getIncludeFinishedTask()));
    to.setReportOrg(convertService.toValue(com.fudanmed.platform.core.domain.RCOrganization.class,from.getReportOrg()));
    to.setStatus(convertService.toValue(com.fudanmed.platform.core.domain.RCRepairTaskStatus.class,from.getStatus()));
    to.setMonth(convertService.toValue(java.lang.String.class,from.getMonth()));
    to.setFaultReportSource(convertService.toValue(com.fudanmed.platform.core.common.RCFaultReportSource.class,from.getFaultReportSource()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final UIRepairTaskCriteria _gwt, final RCRepairTaskCriteria _entity) {
    WorkflowEnumWorkAround.initRepairTaskCriteria(new Function0<RCRepairTaskCriteria>() {
      public RCRepairTaskCriteria apply() {
        return _entity;
      }
    }.apply());
    UIDateRange _reportDateRange = _gwt.getReportDateRange();
    boolean _notEquals = (!Objects.equal(_reportDateRange, null));
    if (_notEquals) {
      UIDateRange _reportDateRange_1 = _gwt.getReportDateRange();
      Date _from = _reportDateRange_1.getFrom();
      _entity.setReportDateFrom(_from);
      UIDateRange _reportDateRange_2 = _gwt.getReportDateRange();
      Date _to = _reportDateRange_2.getTo();
      _entity.setReportDateTo(_to);
    }
  }
  
  public UIRepairTaskCriteria copyFromEntity(final UIRepairTaskCriteria result, final RCRepairTaskCriteria entity) {
    if(entity==null) return null;
    result.setComment(convertService.toValue(java.lang.String.class,entity.getComment()));
    result.setIncludeFinishedTask(convertService.toValue(java.lang.Boolean.class,entity.getIncludeFinishedTask()));
    result.setReportOrg(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy.class,entity.getReportOrg()));
    result.setStatus(convertService.toValue(com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatus.class,entity.getStatus()));
    result.setMonth(convertService.toValue(java.lang.String.class,entity.getMonth()));
    result.setFaultReportSource(convertService.toValue(com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy.class,entity.getFaultReportSource()));
    return result;
    
  }
  
  public UIRepairTaskCriteria buildFrom(final RCRepairTaskCriteria entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.project.UIRepairTaskCriteria result = new com.fudanmed.platform.core.web.shared.project.UIRepairTaskCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIRepairTaskCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return RCRepairTaskCriteria.class;
  }
}
