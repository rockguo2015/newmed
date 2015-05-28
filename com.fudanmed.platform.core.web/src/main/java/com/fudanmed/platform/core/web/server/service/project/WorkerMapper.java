package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCWorkItemTaskDAO;
import com.fudanmed.platform.core.web.shared.project.UIWorker;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.WorkerMapper")
public class WorkerMapper extends AbstractEntityMapper<UIWorker,RCEmployee> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCEmployee loadEntityById(final Long id) {
    return entities.get(RCEmployee.class,id);
  }
  
  public RCEmployee create() {
    return entities.create(RCEmployee.class);
  }
  
  @Autowired
  private RCWorkItemTaskDAO workItemTaskDAO;
  
  public void copyToEntity(final UIWorker from, final RCEmployee to) {
    to.setVersion(from.getVersion());
    
  }
  
  public UIWorker copyFromEntity(final UIWorker result, final RCEmployee entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    result.setCardNumber(convertService.toValue(java.lang.String.class,entity.getCardNumber()));
    buildFromCust(result,entity);
    return result;
    
  }
  
  public UIWorker buildFrom(final RCEmployee entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.project.UIWorker result = new com.fudanmed.platform.core.web.shared.project.UIWorker();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  protected void buildFromCust(final UIWorker _gwt, final RCEmployee _entity) {
    Boolean _workerIsBusy = this.workItemTaskDAO.workerIsBusy(new Function0<RCEmployee>() {
      public RCEmployee apply() {
        return _entity;
      }
    }.apply());
    _gwt.setIsBusy(_workerIsBusy);
  }
  
  public Class<?> getUIClass() {
    return UIWorker.class;
  }
  
  public Class<?> getEntityClass() {
    return RCEmployee.class;
  }
}
