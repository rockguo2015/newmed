package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.RCStockTakingList;
import com.fudanmed.platform.core.warehouse.RCStockTakingService;
import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingListProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateStockTakingListPresenterService;
import com.fudanmed.platform.core.web.server.service.warehouse.StockTakingListMapper;
import com.fudanmed.platform.core.web.server.service.warehouse.StockTakingListValidator;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingList;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.langlab.domain.organization.Party;
import edu.fudan.langlab.domain.security.ISystemUserService;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateStockTakingListPresenterService")
@Transactional
public class CreateOrUpdateStockTakingListPresenterServiceImpl extends BaseService implements CreateOrUpdateStockTakingListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private StockTakingListMapper mapper;
  
  @Autowired
  private ISystemUserService systemUserService;
  
  @Autowired
  private RCStockTakingService stockTakingService;
  
  @Autowired
  private StockTakingListValidator stockTakingListValidator;
  
  public UIStockTakingList loadValue(final RCStockTakingListProxy pvalue) throws SessionTimeOutException, ValidationException {
    RCStockTakingList _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCStockTakingList)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIStockTakingList _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIStockTakingList uivalue) throws SessionTimeOutException, ValidationException {
    RCStockTakingList _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCStockTakingList)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public void createValue(final UIStockTakingList uivalue) throws SessionTimeOutException, ValidationException {
    Validates.<UIStockTakingList>validateWith(uivalue, this.stockTakingListValidator);
    final Function1<RCStockTakingList,RCStockTakingList> _function = new Function1<RCStockTakingList,RCStockTakingList>() {
        public RCStockTakingList apply(final RCStockTakingList it) {
          RCStockTakingList _transform = CreateOrUpdateStockTakingListPresenterServiceImpl.this.mapper.transform(uivalue, it);
          return _transform;
        }
      };
    this.stockTakingService.startStockTaking(_function);
  }
  
  public RCEmployeeProxy loadCurrentUser() throws SessionTimeOutException, ValidationException {
    Party _currentUserAsParty = this.systemUserService.getCurrentUserAsParty();
    RCEmployeeProxy _proxy = ((RCEmployee) _currentUserAsParty).toProxy();
    return _proxy;
  }
}
