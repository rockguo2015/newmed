package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLTask;
import com.fudanmed.platform.core.deliver.DLTaskCriteria;
import com.fudanmed.platform.core.web.client.deliver.TaskQueryListPresenterService;
import com.fudanmed.platform.core.web.server.service.deliver.TaskCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.deliver.TaskMapper;
import com.fudanmed.platform.core.web.shared.deliver.UITask;
import com.fudanmed.platform.core.web.shared.deliver.UITaskCriteria;
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

@Service("com.fudanmed.platform.core.web.client.deliver.TaskQueryListPresenterService")
@Transactional
public class TaskQueryListPresenterServiceImpl extends BaseService implements TaskQueryListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private TaskCriteriaMapper criteriaMapper;
  
  @Autowired
  private TaskMapper mapper;
  
  public IPagedResult<UITask> filter(final UITaskCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UITask> _xblockexpression = null;
    {
      DLTaskCriteria c = PagedQueries.createPagedCriteria(uicriteria, DLTaskCriteria.class, this.criteriaMapper, this.entities);
      final Function1<DLTask,UITask> _function = new Function1<DLTask,UITask>() {
          public UITask apply(final DLTask it) {
            UITask _apply = TaskQueryListPresenterServiceImpl.this.mapper.apply(it);
            return _apply;
          }
        };
      IPagedResult<UITask> _listAndTransform = PagedQueries.<UITask, DLTask>listAndTransform(c, new Function<DLTask,UITask>() {
          public UITask apply(DLTask input) {
            return _function.apply(input);
          }
      });
      _xblockexpression = (_listAndTransform);
    }
    return _xblockexpression;
  }
}
