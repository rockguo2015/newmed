package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCEmployeeUser;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.RCRepairEvaluate;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.RCRepairTaskCriteria;
import com.fudanmed.platform.core.domain.proxy.RCRepairEvaluateProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.client.project.ReportManagementPresenterService;
import com.fudanmed.platform.core.web.server.service.project.RepairTaskMapper;
import com.fudanmed.platform.core.web.server.service.project.ReportCriteriaMapper;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.fudanmed.platform.core.web.shared.project.UIReportCriteria;
import com.google.common.base.Function;
import com.uniquesoft.gwt.server.common.pager.PagedQueries;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.domain.security.ISystemUserService;
import edu.fudan.langlab.domain.security.User;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.ReportManagementPresenterService")
@Transactional
public class ReportManagementPresenterServiceImpl extends BaseService implements ReportManagementPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ReportCriteriaMapper criteriaMapper;
  
  @Autowired
  private RepairTaskMapper mapper;
  
  @Autowired
  private ISystemUserService systemUserService;
  
  public IPagedResult<UIRepairTask> filter(final UIReportCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UIRepairTask> _xblockexpression = null;
    {
      RCRepairTaskCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCRepairTaskCriteria.class, this.criteriaMapper, this.entities);
      User _currentUser = this.systemUserService.getCurrentUser();
      RCEmployee _employee = ((RCEmployeeUser) _currentUser).getEmployee();
      RCOrganization _organization = _employee.getOrganization();
      c.setReportOrg(_organization);
      final Function1<RCRepairTask,UIRepairTask> _function = new Function1<RCRepairTask,UIRepairTask>() {
          public UIRepairTask apply(final RCRepairTask it) {
            UIRepairTask _apply = ReportManagementPresenterServiceImpl.this.mapper.apply(it);
            return _apply;
          }
        };
      final IPagedResult<UIRepairTask> result = PagedQueries.<UIRepairTask, RCRepairTask>listAndTransform(c, new Function<RCRepairTask,UIRepairTask>() {
          public UIRepairTask apply(RCRepairTask input) {
            return _function.apply(input);
          }
      });
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public void delete(final RCRepairTaskProxy value) throws SessionTimeOutException, ValidationException {
    RCRepairTask _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.domain.RCRepairTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    this.entities.delete( _resolved);
  }
  
  public void close(final RCRepairTaskProxy value) throws SessionTimeOutException, ValidationException {
    RCRepairTask _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.domain.RCRepairTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
     _resolved.close();
  }
  
  public RCRepairEvaluateProxy loadRepairEvaluate(final RCRepairTaskProxy value) throws SessionTimeOutException, ValidationException {
    RCRepairTask _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.domain.RCRepairTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    RCRepairEvaluate _repairEvaluate =  _resolved.getRepairEvaluate();
    RCRepairEvaluateProxy _proxy = _repairEvaluate.toProxy();
    return _proxy;
  }
}
