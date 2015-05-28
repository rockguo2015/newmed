package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCGroupTaskCriteria;
import com.fudanmed.platform.core.domain.RCGroupTaskStatByTeamCriteria;
import com.fudanmed.platform.core.domain.RCGroupTaskStatByTeamCriteriaData;
import com.fudanmed.platform.core.web.client.project.GroupTaskStatByTeamListPresenterService;
import com.fudanmed.platform.core.web.server.service.project.GroupTaskCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.project.GroupTaskStatByTeamCriteriaDataMapper;
import com.fudanmed.platform.core.web.shared.project.UIGroupTaskCriteria;
import com.fudanmed.platform.core.web.shared.project.UIGroupTaskStatByTeamCriteriaData;
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

@Service("com.fudanmed.platform.core.web.client.project.GroupTaskStatByTeamListPresenterService")
@Transactional
public class GroupTaskStatByTeamListPresenterServiceImpl extends BaseService implements GroupTaskStatByTeamListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private GroupTaskCriteriaMapper criteriaMapper;
  
  @Autowired
  private GroupTaskStatByTeamCriteriaDataMapper mapper;
  
  public Collection<UIGroupTaskStatByTeamCriteriaData> loadResult(final UIGroupTaskCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    List<UIGroupTaskStatByTeamCriteriaData> _xblockexpression = null;
    {
      final RCGroupTaskCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCGroupTaskCriteria.class, this.criteriaMapper, this.entities);
      c.setIncludeFinishedTask(Boolean.valueOf(true));
      RCGroupTaskStatByTeamCriteria _createStatCriteria = c.createStatCriteria(RCGroupTaskStatByTeamCriteria.class);
      Collection<RCGroupTaskStatByTeamCriteriaData> _list = _createStatCriteria.list();
      final Function1<RCGroupTaskStatByTeamCriteriaData,UIGroupTaskStatByTeamCriteriaData> _function = new Function1<RCGroupTaskStatByTeamCriteriaData,UIGroupTaskStatByTeamCriteriaData>() {
          public UIGroupTaskStatByTeamCriteriaData apply(final RCGroupTaskStatByTeamCriteriaData it) {
            UIGroupTaskStatByTeamCriteriaData _transform = GroupTaskStatByTeamListPresenterServiceImpl.this.mapper.transform(it);
            return _transform;
          }
        };
      Iterable<UIGroupTaskStatByTeamCriteriaData> _map = IterableExtensions.<RCGroupTaskStatByTeamCriteriaData, UIGroupTaskStatByTeamCriteriaData>map(_list, _function);
      List<UIGroupTaskStatByTeamCriteriaData> _list_1 = IterableExtensions.<UIGroupTaskStatByTeamCriteriaData>toList(_map);
      final Function1<UIGroupTaskStatByTeamCriteriaData,Long> _function_1 = new Function1<UIGroupTaskStatByTeamCriteriaData,Long>() {
          public Long apply(final UIGroupTaskStatByTeamCriteriaData it) {
            Long _cnt = it.getCnt();
            return _cnt;
          }
        };
      List<UIGroupTaskStatByTeamCriteriaData> _sortBy = IterableExtensions.<UIGroupTaskStatByTeamCriteriaData, Long>sortBy(_list_1, _function_1);
      List<UIGroupTaskStatByTeamCriteriaData> _reverse = ListExtensions.<UIGroupTaskStatByTeamCriteriaData>reverse(_sortBy);
      _xblockexpression = (_reverse);
    }
    return _xblockexpression;
  }
}
