package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.common.RCSystemParameter;
import com.fudanmed.platform.core.common.RCSystemParameterService;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.RCSettlement;
import com.fudanmed.platform.core.domain.RCSettlementCriteria;
import com.fudanmed.platform.core.domain.RCSettlementService;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCSettlementProxy;
import com.fudanmed.platform.core.web.client.project.SettlementListPresenterService;
import com.fudanmed.platform.core.web.server.service.project.RepairTaskMapper;
import com.fudanmed.platform.core.web.server.service.project.SettlementCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.project.SettlementMapper;
import com.fudanmed.platform.core.web.server.service.template.SettlementTemplate;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.fudanmed.platform.core.web.shared.project.UISettlement;
import com.fudanmed.platform.core.web.shared.project.UISettlementCriteria;
import com.google.common.base.Function;
import com.uniquesoft.gwt.server.common.pager.PagedQueries;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.SettlementListPresenterService")
@Transactional
public class SettlementListPresenterServiceImpl extends BaseService implements SettlementListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private SettlementCriteriaMapper criteriaMapper;
  
  @Autowired
  private SettlementMapper mapper;
  
  @Autowired
  private RepairTaskMapper itemMapper;
  
  @Autowired
  private RCSettlementService settlementService;
  
  @Autowired
  private RCSystemParameterService systemParameter;
  
  public IPagedResult<UISettlement> filter(final UISettlementCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UISettlement> _xblockexpression = null;
    {
      RCSettlementCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCSettlementCriteria.class, this.criteriaMapper, this.entities);
      final Function1<RCSettlement,UISettlement> _function = new Function1<RCSettlement,UISettlement>() {
          public UISettlement apply(final RCSettlement it) {
            UISettlement _apply = SettlementListPresenterServiceImpl.this.mapper.apply(it);
            return _apply;
          }
        };
      IPagedResult<UISettlement> _listAndTransform = PagedQueries.<UISettlement, RCSettlement>listAndTransform(c, new Function<RCSettlement,UISettlement>() {
          public UISettlement apply(RCSettlement input) {
            return _function.apply(input);
          }
      });
      _xblockexpression = (_listAndTransform);
    }
    return _xblockexpression;
  }
  
  public void delete(final RCSettlementProxy value) throws SessionTimeOutException, ValidationException {
    RCSettlement _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.domain.RCSettlement)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    this.settlementService.cancelSettlement( _resolved);
  }
  
  public Collection<UIRepairTask> loadDetails(final RCSettlementProxy parent) throws SessionTimeOutException, ValidationException {
    RCSettlement _resolved= null;
    if(parent!=null) _resolved=(com.fudanmed.platform.core.domain.RCSettlement)com.uniquesoft.uidl.extensions.ModelObjects.resolve(parent, entities);
    
    Collection<RCRepairTask> _allItems =  _resolved.getAllItems();
    final Function1<RCRepairTask,UIRepairTask> _function = new Function1<RCRepairTask,UIRepairTask>() {
        public UIRepairTask apply(final RCRepairTask it) {
          UIRepairTask _transform = SettlementListPresenterServiceImpl.this.itemMapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIRepairTask> _map = IterableExtensions.<RCRepairTask, UIRepairTask>map(_allItems, _function);
    Collection<UIRepairTask> _unlazy = IterableExtensions2.<UIRepairTask>unlazy(_map);
    return _unlazy;
  }
  
  public void cancelSettlementItems(final Collection<RCRepairTaskProxy> repairTasks) throws SessionTimeOutException, ValidationException {
    final Procedure1<RCRepairTaskProxy> _function = new Procedure1<RCRepairTaskProxy>() {
        public void apply(final RCRepairTaskProxy repairTask) {
          RCRepairTask _resolved= null;
          if(repairTask!=null) _resolved=(com.fudanmed.platform.core.domain.RCRepairTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(repairTask, entities);
          
          final RCRepairTask task =  _resolved;
          RCSettlement _settlement = task.getSettlement();
          SettlementListPresenterServiceImpl.this.settlementService.detachSettlementItem(_settlement, task);
        }
      };
    IterableExtensions.<RCRepairTaskProxy>forEach(repairTasks, _function);
  }
  
  public String generatePrintContents(final RCSettlementProxy value) throws SessionTimeOutException, ValidationException {
    RCSettlement _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.domain.RCSettlement)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    RCSystemParameter _systemParameter = this.systemParameter.getSystemParameter();
    String _settlementTemplate = SettlementTemplate.settlementTemplate( _resolved, _systemParameter);
    return _settlementTemplate;
  }
  
  public String prepareExport(final RCSettlementProxy parent) throws SessionTimeOutException, ValidationException {
    return null;
  }
}
