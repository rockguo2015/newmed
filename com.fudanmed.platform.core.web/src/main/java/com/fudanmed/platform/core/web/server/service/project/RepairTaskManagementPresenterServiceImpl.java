package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.RCRepairTaskCriteria;
import com.fudanmed.platform.core.domain.RCTaskDirtyManager;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.client.project.RepairTaskManagementPresenterService;
import com.fudanmed.platform.core.web.server.service.project.RepairTaskCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.project.RepairTaskMapper;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskCriteria;
import com.google.common.base.Function;
import com.uniquesoft.gwt.server.common.pager.PagedQueries;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.RepairTaskManagementPresenterService")
@Transactional
public class RepairTaskManagementPresenterServiceImpl extends BaseService implements RepairTaskManagementPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RepairTaskCriteriaMapper criteriaMapper;
  
  @Autowired
  private RepairTaskMapper mapper;
  
  @Autowired
  private RCTaskDirtyManager taskDirtyManager;
  
  public Boolean isDirty() throws SessionTimeOutException, ValidationException {
    Boolean _checkDirty = this.taskDirtyManager.checkDirty();
    return _checkDirty;
  }
  
  public IPagedResult<UIRepairTask> filter(final UIRepairTaskCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UIRepairTask> _xblockexpression = null;
    {
      RCRepairTaskCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCRepairTaskCriteria.class, this.criteriaMapper, this.entities);
      final Function1<RCRepairTask,UIRepairTask> _function = new Function1<RCRepairTask,UIRepairTask>() {
          public UIRepairTask apply(final RCRepairTask it) {
            UIRepairTask _apply = RepairTaskManagementPresenterServiceImpl.this.mapper.apply(it);
            return _apply;
          }
        };
      final IPagedResult<UIRepairTask> result = PagedQueries.<UIRepairTask, RCRepairTask>listAndTransform(c, new Function<RCRepairTask,UIRepairTask>() {
          public UIRepairTask apply(RCRepairTask input) {
            return _function.apply(input);
          }
      });
      this.taskDirtyManager.refreshed();
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public void delete(final RCRepairTaskProxy value) throws SessionTimeOutException, ValidationException {
    RCRepairTask _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.domain.RCRepairTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    final RCRepairTask v =  _resolved;
    this.entities.delete(v);
  }
  
  public void cancel(final RCRepairTaskProxy value) throws SessionTimeOutException, ValidationException {
    RCRepairTask _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.domain.RCRepairTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    final RCRepairTask v =  _resolved;
    v.cancel();
  }
  
  public void close(final RCRepairTaskProxy value) throws SessionTimeOutException, ValidationException {
    RCRepairTask _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.domain.RCRepairTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
     _resolved.close();
  }
}
