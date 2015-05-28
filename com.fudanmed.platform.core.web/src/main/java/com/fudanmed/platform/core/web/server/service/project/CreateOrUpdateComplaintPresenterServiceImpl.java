package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCComplaint;
import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.proxy.RCComplaintProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateComplaintPresenterService;
import com.fudanmed.platform.core.web.server.service.project.ComplaintMapper;
import com.fudanmed.platform.core.web.shared.project.UIComplaint;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.domain.organization.Party;
import edu.fudan.langlab.domain.security.ISystemUserService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.CreateOrUpdateComplaintPresenterService")
@Transactional
public class CreateOrUpdateComplaintPresenterServiceImpl extends BaseService implements CreateOrUpdateComplaintPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ComplaintMapper mapper;
  
  @Autowired
  private ISystemUserService systemUserService;
  
  public UIComplaint loadValue(final RCComplaintProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCComplaint _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.domain.RCComplaint)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIComplaint _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIComplaint uivalue) throws SessionTimeOutException, ValidationException {
    RCComplaint _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.domain.RCComplaint)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public void createValue(final RCRepairTaskProxy parent, final UIComplaint uivalue) throws SessionTimeOutException, ValidationException {
    RCRepairTask _resolved= null;
    if(parent!=null) _resolved=(com.fudanmed.platform.core.domain.RCRepairTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(parent, entities);
    
    RCComplaint value =  _resolved.createCompaint();
    this.mapper.transform(uivalue, value);
    Party _currentUserAsParty = this.systemUserService.getCurrentUserAsParty();
    value.setOwner(((RCEmployee) _currentUserAsParty));
  }
}
