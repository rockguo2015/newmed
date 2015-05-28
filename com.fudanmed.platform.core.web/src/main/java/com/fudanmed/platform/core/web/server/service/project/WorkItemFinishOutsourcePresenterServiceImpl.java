package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCGroupTask;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.web.client.project.WorkItemFinishOutsourcePresenterService;
import com.fudanmed.platform.core.web.server.service.project.WorkItemFinishOutsourceDataValidator;
import com.fudanmed.platform.core.web.shared.project.WorkItemFinishOutsourceData;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.WorkItemFinishOutsourcePresenterService")
@Transactional
public class WorkItemFinishOutsourcePresenterServiceImpl extends BaseService implements WorkItemFinishOutsourcePresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private WorkItemFinishOutsourceDataValidator validator;
  
  public void commit(final RCWorkItemTaskProxy context, final WorkItemFinishOutsourceData data) throws SessionTimeOutException, ValidationException {
    Validates.<WorkItemFinishOutsourceData>validateWith(data, this.validator);
    RCWorkItemTask _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.domain.RCWorkItemTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    final RCWorkItemTask task =  _resolved;
    Date _finishDate = data.getFinishDate();
    task.setFinishDate(_finishDate);
    Date _finishTime = data.getFinishTime();
    task.setFinishTime(_finishTime);
    String _comment = data.getComment();
    task.setComment(_comment);
    task.finishOutsource();
    Boolean _alsoReport = data.getAlsoReport();
    if ((_alsoReport).booleanValue()) {
      RCGroupTask _groupTask = task.getGroupTask();
      Date _finishDate_1 = data.getFinishDate();
      _groupTask.setFinishDate(_finishDate_1);
      RCGroupTask _groupTask_1 = task.getGroupTask();
      Date _finishTime_1 = data.getFinishTime();
      _groupTask_1.setFinishTime(_finishTime_1);
      RCGroupTask _groupTask_2 = task.getGroupTask();
      String _reportComment = data.getReportComment();
      _groupTask_2.setComment(_reportComment);
      RCGroupTask _groupTask_3 = task.getGroupTask();
      _groupTask_3.reportFinish();
    }
  }
  
  public String loadComment(final RCWorkItemTaskProxy context) throws SessionTimeOutException, ValidationException {
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
