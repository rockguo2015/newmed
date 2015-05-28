package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.common.RCFaultLevel;
import com.fudanmed.platform.core.common.RCFaultLevelColorAdaptorDao;
import com.fudanmed.platform.core.domain.RCGroupTask;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.web.shared.project.UIGroupTask;
import com.uniquesoft.gwt.shared.DateUtil;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.GroupTaskMapper")
public class GroupTaskMapper extends AbstractEntityMapper<UIGroupTask,RCGroupTask> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCGroupTask loadEntityById(final Long id) {
    return entities.get(RCGroupTask.class,id);
  }
  
  public RCGroupTask create() {
    return entities.create(RCGroupTask.class);
  }
  
  @Autowired
  private RCFaultLevelColorAdaptorDao dao;
  
  public void copyToEntity(final UIGroupTask from, final RCGroupTask to) {
    to.setVersion(from.getVersion());
    to.getRepairTask().setComment(convertService.toValue(java.lang.String.class,from.getComment()));
    to.getRepairTask().setReporterName(convertService.toValue(java.lang.String.class,from.getReporterName()));
    to.getRepairTask().setReportOrg(convertService.toValue(com.fudanmed.platform.core.domain.RCOrganization.class,from.getReportOrg()));
    to.getRepairTask().setFaultLevel(convertService.toValue(com.fudanmed.platform.core.common.RCFaultLevel.class,from.getFaultLevel()));
    
  }
  
  public UIGroupTask copyFromEntity(final UIGroupTask result, final RCGroupTask entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setDate(convertService.toValue(java.util.Date.class,entity.getDate()));
    result.setTime(convertService.toValue(java.util.Date.class,entity.getTime()));
    result.setFinishDate(convertService.toValue(java.util.Date.class,entity.getFinishDate()));
    result.setFinishTime(convertService.toValue(java.util.Date.class,entity.getFinishTime()));
    result.setStatus(convertService.toValue(com.fudanmed.platform.core.web.shared.project.UIGroupTaskStatus.class,entity.getStatus()));
    if(entity. getRepairTask()  != null )
    	result.setLocation(convertService.toValue(java.lang.String.class,entity.getRepairTask().getLocation()));
    if(entity. getRepairTask()  != null )
    	result.setComment(convertService.toValue(java.lang.String.class,entity.getRepairTask().getComment()));
    if(entity. getRepairTask()  != null )
    	result.setReporterName(convertService.toValue(java.lang.String.class,entity.getRepairTask().getReporterName()));
    if(entity. getRepairTask()  != null )
    	result.setReportOrg(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy.class,entity.getRepairTask().getReportOrg()));
    result.setTeam(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy.class,entity.getTeam()));
    if(entity. getRepairTask()  != null )
    	result.setFaultLevel(convertService.toValue(com.fudanmed.platform.core.common.proxy.RCFaultLevelProxy.class,entity.getRepairTask().getFaultLevel()));
    if(entity. getRepairTask()  != null &&entity. getRepairTask().getFaultType()  != null )
    	result.setNeedAudit(convertService.toValue(java.lang.Boolean.class,entity.getRepairTask().getFaultType().getNeedAudit()));
    buildFromCust(result,entity);
    return result;
    
  }
  
  public UIGroupTask buildFrom(final RCGroupTask entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.project.UIGroupTask result = new com.fudanmed.platform.core.web.shared.project.UIGroupTask();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  protected void buildFromCust(final UIGroupTask _gwt, final RCGroupTask _entity) {
    RCRepairTask _repairTask = _entity.getRepairTask();
    String _reportSid = _repairTask.getReportSid();
    _gwt.setReportSid(_reportSid);
    Date _finishDate = _entity.getFinishDate();
    Date _finishTime = _entity.getFinishTime();
    Date _appendTime = DateUtil.appendTime(_finishDate, _finishTime);
    _gwt.setFinishDateTime(_appendTime);
    Date _date = _entity.getDate();
    Date _time = _entity.getTime();
    Date _appendTime_1 = DateUtil.appendTime(_date, _time);
    _gwt.setDateTime(_appendTime_1);
    RCRepairTask _repairTask_1 = _entity.getRepairTask();
    Date _planFinishDate = _repairTask_1.getPlanFinishDate();
    RCRepairTask _repairTask_2 = _entity.getRepairTask();
    Date _planFinishTime = _repairTask_2.getPlanFinishTime();
    Date _appendTime_2 = DateUtil.appendTime(_planFinishDate, _planFinishTime);
    _gwt.setPlanFinishDateTime(_appendTime_2);
    RCRepairTask _repairTask_3 = _entity.getRepairTask();
    RCFaultLevel _faultLevel = _repairTask_3.getFaultLevel();
    String _color = this.dao.getColor(_faultLevel);
    _gwt.setFaultLevelColor(_color);
  }
  
  public Class<?> getUIClass() {
    return UIGroupTask.class;
  }
  
  public Class<?> getEntityClass() {
    return RCGroupTask.class;
  }
}
