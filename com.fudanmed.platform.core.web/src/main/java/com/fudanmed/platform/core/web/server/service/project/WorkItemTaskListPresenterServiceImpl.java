package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCGroupTask;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.proxy.RCGroupTaskProxy;
import com.fudanmed.platform.core.web.client.project.WorkItemTaskListPresenterService;
import com.fudanmed.platform.core.web.server.service.project.WorkItemTaskMapper;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTask;
import com.google.common.collect.Iterables;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.WorkItemTaskListPresenterService")
@Transactional
public class WorkItemTaskListPresenterServiceImpl extends BaseService implements WorkItemTaskListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private WorkItemTaskMapper mapper;
  
  public Collection<UIWorkItemTask> load(final RCGroupTaskProxy parent) throws SessionTimeOutException, ValidationException {
    RCGroupTask _resolved= null;
    if(parent!=null) _resolved=(com.fudanmed.platform.core.domain.RCGroupTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(parent, entities);
    
    Collection<RCWorkItemTask> _tasks =  _resolved.getTasks();
    Iterable<RCWorkItemTask> _filter = Iterables.<RCWorkItemTask>filter(_tasks, RCWorkItemTask.class);
    final Function1<RCWorkItemTask,UIWorkItemTask> _function = new Function1<RCWorkItemTask,UIWorkItemTask>() {
        public UIWorkItemTask apply(final RCWorkItemTask it) {
          UIWorkItemTask _transform = WorkItemTaskListPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIWorkItemTask> _map = IterableExtensions.<RCWorkItemTask, UIWorkItemTask>map(_filter, _function);
    Collection<UIWorkItemTask> _unlazy = IterableExtensions2.<UIWorkItemTask>unlazy(_map);
    return _unlazy;
  }
}
