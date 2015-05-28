package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCGroupTaskCriteria;
import com.fudanmed.platform.core.domain.RCGroupTaskStatByTeamCriteria;
import com.fudanmed.platform.core.domain.RCGroupTaskStatByTeamCriteriaData;
import com.fudanmed.platform.core.web.client.project.GroupTaskStatByTeamPresenterService;
import com.fudanmed.platform.core.web.server.service.project.GroupTaskCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.project.GroupTaskStatByTeamCriteriaDataMapper;
import com.fudanmed.platform.core.web.shared.project.UIGroupTaskCriteria;
import com.fudanmed.platform.core.web.shared.project.UIGroupTaskStatByTeamCriteriaData;
import com.uniquesoft.gwt.server.common.pager.PagedQueries;
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

@Service("com.fudanmed.platform.core.web.client.project.GroupTaskStatByTeamPresenterService")
@Transactional
public class GroupTaskStatByTeamPresenterServiceImpl extends BaseService implements GroupTaskStatByTeamPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private GroupTaskCriteriaMapper criteriaMapper;
  
  @Autowired
  private GroupTaskStatByTeamCriteriaDataMapper mapper;
  
  public Collection<UIGroupTaskStatByTeamCriteriaData> loadResult(final UIGroupTaskCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    Collection<UIGroupTaskStatByTeamCriteriaData> _xblockexpression = null;
    {
      final RCGroupTaskCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCGroupTaskCriteria.class, this.criteriaMapper, this.entities);
      c.setIncludeFinishedTask(Boolean.valueOf(true));
      RCGroupTaskStatByTeamCriteria _createStatCriteria = c.createStatCriteria(RCGroupTaskStatByTeamCriteria.class);
      Collection<RCGroupTaskStatByTeamCriteriaData> _list = _createStatCriteria.list();
      final Function1<RCGroupTaskStatByTeamCriteriaData,UIGroupTaskStatByTeamCriteriaData> _function = new Function1<RCGroupTaskStatByTeamCriteriaData,UIGroupTaskStatByTeamCriteriaData>() {
          public UIGroupTaskStatByTeamCriteriaData apply(final RCGroupTaskStatByTeamCriteriaData it) {
            UIGroupTaskStatByTeamCriteriaData _transform = GroupTaskStatByTeamPresenterServiceImpl.this.mapper.transform(it);
            return _transform;
          }
        };
      Iterable<UIGroupTaskStatByTeamCriteriaData> _map = IterableExtensions.<RCGroupTaskStatByTeamCriteriaData, UIGroupTaskStatByTeamCriteriaData>map(_list, _function);
      Collection<UIGroupTaskStatByTeamCriteriaData> _unlazy = IterableExtensions2.<UIGroupTaskStatByTeamCriteriaData>unlazy(_map);
      _xblockexpression = (_unlazy);
    }
    return _xblockexpression;
  }
}
