package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCWorkItemTask4WorkersCriteria;
import com.fudanmed.platform.core.domain.RCWorkItemTask4WorkersStatCriteria;
import com.fudanmed.platform.core.domain.RCWorkItemTask4WorkersStatCriteriaData;
import com.fudanmed.platform.core.web.client.project.WorkItemTask4WorkersStatListPresenterService;
import com.fudanmed.platform.core.web.server.service.project.WorkItemTask4WorkersCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.project.WorkItemTask4WorkersStatCriteriaDataMapper;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTask4WorkersCriteria;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTask4WorkersStatCriteriaData;
import com.uniquesoft.gwt.server.common.pager.PagedQueries;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.WorkItemTask4WorkersStatListPresenterService")
@Transactional
public class WorkItemTask4WorkersStatListPresenterServiceImpl extends BaseService implements WorkItemTask4WorkersStatListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private WorkItemTask4WorkersCriteriaMapper criteriaMapper;
  
  @Autowired
  private WorkItemTask4WorkersStatCriteriaDataMapper mapper;
  
  public Collection<UIWorkItemTask4WorkersStatCriteriaData> load(final UIWorkItemTask4WorkersCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    List<UIWorkItemTask4WorkersStatCriteriaData> _xblockexpression = null;
    {
      final RCWorkItemTask4WorkersCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCWorkItemTask4WorkersCriteria.class, this.criteriaMapper, this.entities);
      RCWorkItemTask4WorkersStatCriteria _createStatCriteria = c.createStatCriteria(RCWorkItemTask4WorkersStatCriteria.class);
      Collection<RCWorkItemTask4WorkersStatCriteriaData> _list = _createStatCriteria.list();
      final Function1<RCWorkItemTask4WorkersStatCriteriaData,UIWorkItemTask4WorkersStatCriteriaData> _function = new Function1<RCWorkItemTask4WorkersStatCriteriaData,UIWorkItemTask4WorkersStatCriteriaData>() {
          public UIWorkItemTask4WorkersStatCriteriaData apply(final RCWorkItemTask4WorkersStatCriteriaData it) {
            UIWorkItemTask4WorkersStatCriteriaData _transform = WorkItemTask4WorkersStatListPresenterServiceImpl.this.mapper.transform(it);
            return _transform;
          }
        };
      Iterable<UIWorkItemTask4WorkersStatCriteriaData> _map = IterableExtensions.<RCWorkItemTask4WorkersStatCriteriaData, UIWorkItemTask4WorkersStatCriteriaData>map(_list, _function);
      List<UIWorkItemTask4WorkersStatCriteriaData> _list_1 = IterableExtensions.<UIWorkItemTask4WorkersStatCriteriaData>toList(_map);
      final Function1<UIWorkItemTask4WorkersStatCriteriaData,Long> _function_1 = new Function1<UIWorkItemTask4WorkersStatCriteriaData,Long>() {
          public Long apply(final UIWorkItemTask4WorkersStatCriteriaData it) {
            Long _cnt = it.getCnt();
            return _cnt;
          }
        };
      List<UIWorkItemTask4WorkersStatCriteriaData> _sortBy = IterableExtensions.<UIWorkItemTask4WorkersStatCriteriaData, Long>sortBy(_list_1, _function_1);
      List<UIWorkItemTask4WorkersStatCriteriaData> _reverse = ListExtensions.<UIWorkItemTask4WorkersStatCriteriaData>reverse(_sortBy);
      _xblockexpression = (_reverse);
    }
    return _xblockexpression;
  }
}
