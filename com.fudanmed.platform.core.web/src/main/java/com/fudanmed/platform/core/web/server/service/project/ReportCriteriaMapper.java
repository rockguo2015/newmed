package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCRepairTaskCriteria;
import com.fudanmed.platform.core.web.shared.project.UIReportCriteria;
import com.fudanmed.platform.core.web.shared.project.WorkflowEnumWorkAround;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.ReportCriteriaMapper")
public class ReportCriteriaMapper extends AbstractDataTypeMapper<UIReportCriteria,RCRepairTaskCriteria> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UIReportCriteria from, final RCRepairTaskCriteria to) {
    to.setComment(convertService.toValue(java.lang.String.class,from.getComment()));
    to.setIncludeFinishedTask4Reporter(convertService.toValue(java.lang.Boolean.class,from.getIncludeFinishedTask4Reporter()));
    to.setReportOrg(convertService.toValue(com.fudanmed.platform.core.domain.RCOrganization.class,from.getReportOrg()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final UIReportCriteria _gwt, final RCRepairTaskCriteria _entity) {
    WorkflowEnumWorkAround.initRepairTaskCriteria(new Function0<RCRepairTaskCriteria>() {
      public RCRepairTaskCriteria apply() {
        return _entity;
      }
    }.apply());
  }
  
  public UIReportCriteria copyFromEntity(final UIReportCriteria result, final RCRepairTaskCriteria entity) {
    if(entity==null) return null;
    result.setComment(convertService.toValue(java.lang.String.class,entity.getComment()));
    result.setIncludeFinishedTask4Reporter(convertService.toValue(java.lang.Boolean.class,entity.getIncludeFinishedTask4Reporter()));
    result.setReportOrg(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy.class,entity.getReportOrg()));
    return result;
    
  }
  
  public UIReportCriteria buildFrom(final RCRepairTaskCriteria entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.project.UIReportCriteria result = new com.fudanmed.platform.core.web.shared.project.UIReportCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIReportCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return RCRepairTaskCriteria.class;
  }
}
