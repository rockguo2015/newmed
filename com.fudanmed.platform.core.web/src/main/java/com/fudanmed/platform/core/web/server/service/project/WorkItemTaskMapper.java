package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCWorkItemPicture;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.warehouse.RCWorkItemStorage;
import com.fudanmed.platform.core.web.server.service.common.DocumentMapper;
import com.fudanmed.platform.core.web.server.service.project.WorkItemTaskValidator;
import com.fudanmed.platform.core.web.server.service.project.WorkerMapper;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTask;
import com.uniquesoft.gwt.shared.DateUtil;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.WorkItemTaskMapper")
public class WorkItemTaskMapper extends AbstractEntityMapper<UIWorkItemTask,RCWorkItemTask> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCWorkItemTask loadEntityById(final Long id) {
    return entities.get(RCWorkItemTask.class,id);
  }
  
  public RCWorkItemTask create() {
    return entities.create(RCWorkItemTask.class);
  }
  
  @Autowired
  private DocumentMapper documentMapper;
  
  @Autowired
  private WorkerMapper __WorkerMapper__;
  
  @Autowired
  private WorkItemTaskValidator validator;
  
  public void copyToEntity(final UIWorkItemTask from, final RCWorkItemTask to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setOperator(convertService.toValue(com.fudanmed.platform.core.domain.RCEmployee.class,from.getOperator()));
    to.setDate(convertService.toValue(java.util.Date.class,from.getDate()));
    to.setTime(convertService.toValue(java.util.Date.class,from.getTime()));
    convertService.toRefEntity(from.getWorkers(),to.getWorkers(),__WorkerMapper__);
    to.setComment(convertService.toValue(java.lang.String.class,from.getComment()));
    to.setFaultType(convertService.toValue(com.fudanmed.platform.core.domain.RCFaultType.class,from.getFaultType()));
    to.setFaultDescription(convertService.toValue(java.lang.String.class,from.getFaultDescription()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final UIWorkItemTask _gwt, final RCWorkItemTask _entity) {
    _entity.updateDerived();
  }
  
  public UIWorkItemTask copyFromEntity(final UIWorkItemTask result, final RCWorkItemTask entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setSid(convertService.toValue(java.lang.String.class,entity.getSid()));
    result.setOperator(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy.class,entity.getOperator()));
    result.setDate(convertService.toValue(java.util.Date.class,entity.getDate()));
    result.setTime(convertService.toValue(java.util.Date.class,entity.getTime()));
    result.setFinishTime(convertService.toValue(java.util.Date.class,entity.getFinishTime()));
    result.setFinishDate(convertService.toValue(java.util.Date.class,entity.getFinishDate()));
    result.setWorkers(convertService.toGwtEntity(entity.getWorkers(),__WorkerMapper__));
    result.setComment(convertService.toValue(java.lang.String.class,entity.getComment()));
    result.setStatus(convertService.toValue(com.fudanmed.platform.core.web.shared.project.UIWorkItemTaskStatus.class,entity.getStatus()));
    result.setFaultType(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy.class,entity.getFaultType()));
    result.setFaultDescription(convertService.toValue(java.lang.String.class,entity.getFaultDescription()));
    if(entity. getGroupTask()  != null &&entity. getGroupTask().getRepairTask()  != null )
    	result.setReportSid(convertService.toValue(java.lang.String.class,entity.getGroupTask().getRepairTask().getReportSid()));
    buildFromCust(result,entity);
    return result;
    
  }
  
  public UIWorkItemTask buildFrom(final RCWorkItemTask entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.project.UIWorkItemTask result = new com.fudanmed.platform.core.web.shared.project.UIWorkItemTask();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  protected void buildFromCust(final UIWorkItemTask _gwt, final RCWorkItemTask _entity) {
    Collection<RCWorkItemStorage> _storage = _entity.getStorage();
    int _size = _storage.size();
    boolean _notEquals = (_size != 0);
    if (_notEquals) {
      _gwt.setStockStatus("\u5DF2\u9886\u6599");
      _gwt.setBStockStatus(Boolean.valueOf(true));
    } else {
      _gwt.setStockStatus("\u672A\u9886\u6599");
      _gwt.setBStockStatus(Boolean.valueOf(false));
    }
    Date _finishDate = _entity.getFinishDate();
    Date _finishTime = _entity.getFinishTime();
    Date _appendTime = DateUtil.appendTime(_finishDate, _finishTime);
    _gwt.setFinishDateTime(_appendTime);
    Date _date = _entity.getDate();
    Date _time = _entity.getTime();
    Date _appendTime_1 = DateUtil.appendTime(_date, _time);
    _gwt.setDateTime(_appendTime_1);
    Collection<RCWorkItemPicture> _documents = _entity.getDocuments();
    int _size_1 = _documents.size();
    boolean _notEquals_1 = (_size_1 != 0);
    _gwt.setHasDocuments(Boolean.valueOf(_notEquals_1));
  }
  
  public Class<?> getUIClass() {
    return UIWorkItemTask.class;
  }
  
  public Class<?> getEntityClass() {
    return RCWorkItemTask.class;
  }
}
