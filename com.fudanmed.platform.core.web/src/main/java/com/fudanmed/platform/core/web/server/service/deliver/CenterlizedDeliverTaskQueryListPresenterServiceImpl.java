package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTask;
import com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTaskCriteria;
import com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTaskQueryListPresenterService;
import com.fudanmed.platform.core.web.server.service.deliver.CenterlizedDeliverTaskCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.deliver.CenterlizedDeliverTaskMapper;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTaskCriteria;
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

@Service("com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTaskQueryListPresenterService")
@Transactional
public class CenterlizedDeliverTaskQueryListPresenterServiceImpl extends BaseService implements CenterlizedDeliverTaskQueryListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private CenterlizedDeliverTaskCriteriaMapper criteriaMapper;
  
  @Autowired
  private CenterlizedDeliverTaskMapper mapper;
  
  public IPagedResult<UICenterlizedDeliverTask> filter(final UICenterlizedDeliverTaskCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UICenterlizedDeliverTask> _xblockexpression = null;
    {
      DLCenterlizedDeliverTaskCriteria c = PagedQueries.createPagedCriteria(uicriteria, DLCenterlizedDeliverTaskCriteria.class, this.criteriaMapper, this.entities);
      final Function1<DLCenterlizedDeliverTask,UICenterlizedDeliverTask> _function = new Function1<DLCenterlizedDeliverTask,UICenterlizedDeliverTask>() {
          public UICenterlizedDeliverTask apply(final DLCenterlizedDeliverTask it) {
            UICenterlizedDeliverTask _apply = CenterlizedDeliverTaskQueryListPresenterServiceImpl.this.mapper.apply(it);
            return _apply;
          }
        };
      IPagedResult<UICenterlizedDeliverTask> _listAndTransform = PagedQueries.<UICenterlizedDeliverTask, DLCenterlizedDeliverTask>listAndTransform(c, new Function<DLCenterlizedDeliverTask,UICenterlizedDeliverTask>() {
          public UICenterlizedDeliverTask apply(DLCenterlizedDeliverTask input) {
            return _function.apply(input);
          }
      });
      _xblockexpression = (_listAndTransform);
    }
    return _xblockexpression;
  }
}
