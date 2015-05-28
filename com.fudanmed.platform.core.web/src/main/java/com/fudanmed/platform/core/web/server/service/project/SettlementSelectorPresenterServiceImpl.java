package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.RCRepairTask4SettlementCriteria;
import com.fudanmed.platform.core.domain.RCSettlement;
import com.fudanmed.platform.core.domain.RCSettlementService;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCSettlementProxy;
import com.fudanmed.platform.core.web.client.project.SettlementSelectorPresenterService;
import com.fudanmed.platform.core.web.server.service.project.RepairTask4SettlementCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.project.RepairTaskMapper;
import com.fudanmed.platform.core.web.server.service.project.SettlementMapper;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask4SettlementCriteria;
import com.fudanmed.platform.core.web.shared.project.UISettlement;
import com.fudanmed.platform.core.web.shared.project.WorkflowEnumWorkAround;
import com.google.common.base.Function;
import com.uniquesoft.gwt.server.common.pager.PagedQueries;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.SettlementSelectorPresenterService")
@Transactional
public class SettlementSelectorPresenterServiceImpl extends BaseService implements SettlementSelectorPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RepairTask4SettlementCriteriaMapper criteriaMapper;
  
  @Autowired
  private RepairTaskMapper mapper;
  
  @Autowired
  private RCSettlementService settlementService;
  
  @Autowired
  private SettlementMapper settlementMapper;
  
  public IPagedResult<UIRepairTask> filter(final UIRepairTask4SettlementCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UIRepairTask> _xblockexpression = null;
    {
      RCRepairTask4SettlementCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCRepairTask4SettlementCriteria.class, this.criteriaMapper, this.entities);
      WorkflowEnumWorkAround.initRepairTask4SettlementCriteria(c);
      final Function1<RCRepairTask,UIRepairTask> _function = new Function1<RCRepairTask,UIRepairTask>() {
          public UIRepairTask apply(final RCRepairTask it) {
            UIRepairTask _apply = SettlementSelectorPresenterServiceImpl.this.mapper.apply(it);
            return _apply;
          }
        };
      IPagedResult<UIRepairTask> _listAndTransform = PagedQueries.<UIRepairTask, RCRepairTask>listAndTransform(c, new Function<RCRepairTask,UIRepairTask>() {
          public UIRepairTask apply(RCRepairTask input) {
            return _function.apply(input);
          }
      });
      _xblockexpression = (_listAndTransform);
    }
    return _xblockexpression;
  }
  
  public void performSettlement(final RCSettlementProxy settlement, final Collection<RCRepairTaskProxy> repairTasks) throws SessionTimeOutException, ValidationException {
    RCSettlement _resolved= null;
    if(settlement!=null) _resolved=(com.fudanmed.platform.core.domain.RCSettlement)com.uniquesoft.uidl.extensions.ModelObjects.resolve(settlement, entities);
    
    final Function1<RCRepairTaskProxy,RCRepairTask> _function = new Function1<RCRepairTaskProxy,RCRepairTask>() {
        public RCRepairTask apply(final RCRepairTaskProxy it) {
          Long _id = it.getId();
          RCRepairTask _get = SettlementSelectorPresenterServiceImpl.this.entities.<RCRepairTask>get(RCRepairTask.class, _id);
          return _get;
        }
      };
    Iterable<RCRepairTask> _map = IterableExtensions.<RCRepairTaskProxy, RCRepairTask>map(repairTasks, _function);
    this.settlementService.attachSettlementItems( _resolved, _map);
  }
  
  public UISettlement loadSettlement(final RCSettlementProxy settlement) throws SessionTimeOutException, ValidationException {
    RCSettlement _resolved= null;
    if(settlement!=null) _resolved=(com.fudanmed.platform.core.domain.RCSettlement)com.uniquesoft.uidl.extensions.ModelObjects.resolve(settlement, entities);
    
    UISettlement _transform = this.settlementMapper.transform( _resolved);
    return _transform;
  }
}
