package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCSettlement;
import com.fudanmed.platform.core.domain.RCSettlementService;
import com.fudanmed.platform.core.domain.proxy.RCSettlementProxy;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateSettlementPresenterService;
import com.fudanmed.platform.core.web.server.service.project.SettlementMapper;
import com.fudanmed.platform.core.web.shared.project.UISettlement;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.CreateOrUpdateSettlementPresenterService")
@Transactional
public class CreateOrUpdateSettlementPresenterServiceImpl extends BaseService implements CreateOrUpdateSettlementPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private SettlementMapper mapper;
  
  @Autowired
  private RCSettlementService settlementService;
  
  public UISettlement loadValue(final RCSettlementProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCSettlement _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.domain.RCSettlement)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UISettlement _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UISettlement uivalue) throws SessionTimeOutException, ValidationException {
    RCSettlement _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.domain.RCSettlement)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public void createValue(final UISettlement uivalue) throws SessionTimeOutException, ValidationException {
    final Procedure1<RCSettlement> _function = new Procedure1<RCSettlement>() {
        public void apply(final RCSettlement it) {
          CreateOrUpdateSettlementPresenterServiceImpl.this.mapper.transform(uivalue, it);
        }
      };
    this.settlementService.createSettlement(_function);
  }
}
