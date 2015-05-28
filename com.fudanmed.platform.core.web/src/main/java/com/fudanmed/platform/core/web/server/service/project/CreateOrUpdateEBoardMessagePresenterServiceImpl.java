package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.common.RCEBoardMessage;
import com.fudanmed.platform.core.common.RCEBoardMessageService;
import com.fudanmed.platform.core.common.proxy.RCEBoardMessageProxy;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateEBoardMessagePresenterService;
import com.fudanmed.platform.core.web.server.service.project.EBoardMessageMapper;
import com.fudanmed.platform.core.web.shared.project.UIEBoardMessage;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.CreateOrUpdateEBoardMessagePresenterService")
@Transactional
public class CreateOrUpdateEBoardMessagePresenterServiceImpl extends BaseService implements CreateOrUpdateEBoardMessagePresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private EBoardMessageMapper mapper;
  
  @Autowired
  private RCEBoardMessageService dao;
  
  public UIEBoardMessage loadValue(final RCEBoardMessageProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCEBoardMessage _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.common.RCEBoardMessage)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIEBoardMessage _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIEBoardMessage uivalue) throws SessionTimeOutException, ValidationException {
    RCEBoardMessage _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.common.RCEBoardMessage)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
}
