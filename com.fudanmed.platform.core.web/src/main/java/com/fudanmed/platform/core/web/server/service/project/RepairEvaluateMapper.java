package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCRepairEvaluate;
import com.fudanmed.platform.core.web.server.service.project.RepairEvaluateValidator;
import com.fudanmed.platform.core.web.shared.project.UIRepairEvaluate;
import com.uniquesoft.gwt.shared.DateUtil;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.langlab.domain.organization.Party;
import edu.fudan.langlab.domain.security.ISystemUserService;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.RepairEvaluateMapper")
public class RepairEvaluateMapper extends AbstractEntityMapper<UIRepairEvaluate,RCRepairEvaluate> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public RCRepairEvaluate loadEntityById(final Long id) {
    return entities.get(RCRepairEvaluate.class,id);
  }
  
  public RCRepairEvaluate create() {
    return entities.create(RCRepairEvaluate.class);
  }
  
  @Autowired
  private ISystemUserService systemUserService;
  
  @Autowired
  private RepairEvaluateValidator validator;
  
  public void copyToEntity(final UIRepairEvaluate from, final RCRepairEvaluate to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setVersion(from.getVersion());
    to.setEvaluateState(convertService.toValue(com.fudanmed.platform.core.domain.RCEvaluateState.class,from.getEvaluateState()));
    to.setArrivalTimeValue(convertService.toValue(java.lang.Integer.class,from.getArrivalTimeValue()));
    to.setServiceAttitudeValue(convertService.toValue(java.lang.Integer.class,from.getServiceAttitudeValue()));
    to.setFrequencyProblemValue(convertService.toValue(java.lang.Integer.class,from.getFrequencyProblemValue()));
    to.setRepairQualityValue(convertService.toValue(java.lang.Integer.class,from.getRepairQualityValue()));
    to.setComment(convertService.toValue(java.lang.String.class,from.getComment()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final UIRepairEvaluate _gwt, final RCRepairEvaluate _entity) {
    Party _currentUserAsParty = this.systemUserService.getCurrentUserAsParty();
    _entity.setEvaluator(((RCEmployee) _currentUserAsParty));
    Date _day = DateUtil.today();
    _entity.setEvaluateDate(_day);
  }
  
  public UIRepairEvaluate copyFromEntity(final UIRepairEvaluate result, final RCRepairEvaluate entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setVersion(entity.getVersion());
    result.setProxy(entity.toProxy());
    result.setClazzName(entity.getClass().getName());
    result.setEvaluateState(convertService.toValue(com.fudanmed.platform.core.web.shared.project.UIEvaluateState.class,entity.getEvaluateState()));
    result.setArrivalTimeValue(convertService.toValue(java.lang.Integer.class,entity.getArrivalTimeValue()));
    result.setServiceAttitudeValue(convertService.toValue(java.lang.Integer.class,entity.getServiceAttitudeValue()));
    result.setFrequencyProblemValue(convertService.toValue(java.lang.Integer.class,entity.getFrequencyProblemValue()));
    result.setRepairQualityValue(convertService.toValue(java.lang.Integer.class,entity.getRepairQualityValue()));
    result.setComment(convertService.toValue(java.lang.String.class,entity.getComment()));
    result.setEvaluator(convertService.toValue(com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy.class,entity.getEvaluator()));
    result.setEvaluateDate(convertService.toValue(java.util.Date.class,entity.getEvaluateDate()));
    return result;
    
  }
  
  public UIRepairEvaluate buildFrom(final RCRepairEvaluate entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.project.UIRepairEvaluate result = new com.fudanmed.platform.core.web.shared.project.UIRepairEvaluate();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIRepairEvaluate.class;
  }
  
  public Class<?> getEntityClass() {
    return RCRepairEvaluate.class;
  }
}
