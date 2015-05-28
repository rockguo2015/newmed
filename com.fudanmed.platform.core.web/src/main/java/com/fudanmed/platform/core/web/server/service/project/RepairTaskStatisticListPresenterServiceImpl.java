package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.RCRepairTaskStatisticCriteria;
import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.project.RepairTaskStatisticListPresenterService;
import com.fudanmed.platform.core.web.server.service.project.RepairTaskStatisticCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.project.RepairTaskStatisticDataMapper;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatisticCriteria;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatisticData;
import com.google.common.base.Function;
import com.uniquesoft.gwt.server.common.pager.PagedQueries;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.RepairTaskStatisticListPresenterService")
@Transactional
public class RepairTaskStatisticListPresenterServiceImpl extends BaseService implements RepairTaskStatisticListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RepairTaskStatisticDataMapper mapper;
  
  @Autowired
  private RepairTaskStatisticCriteriaMapper criteriaMapper;
  
  public Collection<UIRepairTaskStatisticData> loadRepairTaskList(final UIRepairTaskStatisticCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UIRepairTaskStatisticData> _xblockexpression = null;
    {
      RCRepairTaskStatisticCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCRepairTaskStatisticCriteria.class, this.criteriaMapper, this.entities);
      final Function1<RCRepairTask,UIRepairTaskStatisticData> _function = new Function1<RCRepairTask,UIRepairTaskStatisticData>() {
          public UIRepairTaskStatisticData apply(final RCRepairTask it) {
            UIRepairTaskStatisticData _apply = RepairTaskStatisticListPresenterServiceImpl.this.mapper.apply(it);
            return _apply;
          }
        };
      IPagedResult<UIRepairTaskStatisticData> _listAndTransform = PagedQueries.<UIRepairTaskStatisticData, RCRepairTask>listAndTransform(c, new Function<RCRepairTask,UIRepairTaskStatisticData>() {
          public UIRepairTaskStatisticData apply(RCRepairTask input) {
            return _function.apply(input);
          }
      });
      _xblockexpression = (_listAndTransform);
    }
    return _xblockexpression;
  }
  
  public RCOrganizationProxy loadOrganization(final RCMaintenanceTeamProxy team) throws SessionTimeOutException, ValidationException {
    RCMaintenanceTeam _resolved= null;
    if(team!=null) _resolved=(com.fudanmed.platform.core.domain.RCMaintenanceTeam)com.uniquesoft.uidl.extensions.ModelObjects.resolve(team, entities);
    
    RCOrganization _organization =  _resolved.getOrganization();
    RCOrganizationProxy _proxy = _organization.toProxy();
    return _proxy;
  }
}
