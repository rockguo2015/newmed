package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCGroupTask;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.web.client.project.WorkItemMisDispatchingPresenterService;
import com.fudanmed.platform.core.web.server.service.project.WorkItemMisDispatchingDataValidator;
import com.fudanmed.platform.core.web.shared.project.WorkItemMisDispatchingData;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.WorkItemMisDispatchingPresenterService")
@Transactional
public class WorkItemMisDispatchingPresenterServiceImpl extends BaseService implements WorkItemMisDispatchingPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private WorkItemMisDispatchingDataValidator validator;
  
  public void commit(final RCWorkItemTaskProxy context, final WorkItemMisDispatchingData data) throws SessionTimeOutException, ValidationException {
    Validates.<WorkItemMisDispatchingData>validateWith(data, this.validator);
    RCWorkItemTask _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.domain.RCWorkItemTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    final RCWorkItemTask value =  _resolved;
    Date _finishDate = data.getFinishDate();
    value.setFinishDate(_finishDate);
    Date _finishTime = data.getFinishTime();
    value.setFinishTime(_finishTime);
    String _comment = data.getComment();
    value.setComment(_comment);
    value.misDispatching();
    Boolean _alsoReport = data.getAlsoReport();
    if ((_alsoReport).booleanValue()) {
      RCGroupTask _groupTask = value.getGroupTask();
      String _reportComment = data.getReportComment();
      _groupTask.setComment(_reportComment);
      RCGroupTask _groupTask_1 = value.getGroupTask();
      Date _finishDate_1 = data.getFinishDate();
      _groupTask_1.setFinishDate(_finishDate_1);
      RCGroupTask _groupTask_2 = value.getGroupTask();
      Date _finishTime_1 = data.getFinishTime();
      _groupTask_2.setFinishTime(_finishTime_1);
      RCGroupTask _groupTask_3 = value.getGroupTask();
      _groupTask_3.reportMisdispatch();
    }
  }
  
  public String getComment(final RCWorkItemTaskProxy context) throws SessionTimeOutException, ValidationException {
    RCWorkItemTask _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.domain.RCWorkItemTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    String _comment =  _resolved.getComment();
    return _comment;
  }
  
  public Boolean canReport(final RCWorkItemTaskProxy context) throws SessionTimeOutException, ValidationException {
    Boolean _xblockexpression = null;
    {
      RCWorkItemTask _resolved= null;
      if(context!=null) _resolved=(com.fudanmed.platform.core.domain.RCWorkItemTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
      
      final RCWorkItemTask task =  _resolved;
      RCGroupTask _groupTask = task.getGroupTask();
      Boolean _allTasksFinishedExcept = _groupTask.allTasksFinishedExcept(task);
      _xblockexpression = (_allTasksFinishedExcept);
    }
    return _xblockexpression;
  }
}
