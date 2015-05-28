package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy;
import com.fudanmed.platform.core.domain.RCRepairTaskCriteria;
import com.fudanmed.platform.core.domain.RCRepairTaskStatByFaultTypeCriteria;
import com.fudanmed.platform.core.domain.RCRepairTaskStatByFaultTypeCriteriaData;
import com.fudanmed.platform.core.web.client.project.RepairTaskStatByFaultTypeListPresenterService;
import com.fudanmed.platform.core.web.server.service.project.RepairTaskCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.project.RepairTaskStatByFaultTypeCriteriaDataMapper;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskCriteria;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatByFaultTypeCriteriaData;
import com.uniquesoft.gwt.server.common.pager.PagedQueries;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.datatype.UIDateRange;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.RepairTaskStatByFaultTypeListPresenterService")
@Transactional
public class RepairTaskStatByFaultTypeListPresenterServiceImpl extends BaseService implements RepairTaskStatByFaultTypeListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RepairTaskCriteriaMapper criteriaMapper;
  
  @Autowired
  private RepairTaskStatByFaultTypeCriteriaDataMapper mapper;
  
  public Collection<UIRepairTaskStatByFaultTypeCriteriaData> executeCriteria(final UIRepairTaskCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    List<UIRepairTaskStatByFaultTypeCriteriaData> _xblockexpression = null;
    {
      final RCRepairTaskCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCRepairTaskCriteria.class, this.criteriaMapper, this.entities);
      c.setIncludeFinishedTask(Boolean.valueOf(true));
      RCRepairTaskStatByFaultTypeCriteria _createStatCriteria = c.createStatCriteria(RCRepairTaskStatByFaultTypeCriteria.class);
      Collection<RCRepairTaskStatByFaultTypeCriteriaData> _list = _createStatCriteria.list();
      final Function1<RCRepairTaskStatByFaultTypeCriteriaData,UIRepairTaskStatByFaultTypeCriteriaData> _function = new Function1<RCRepairTaskStatByFaultTypeCriteriaData,UIRepairTaskStatByFaultTypeCriteriaData>() {
          public UIRepairTaskStatByFaultTypeCriteriaData apply(final RCRepairTaskStatByFaultTypeCriteriaData it) {
            UIRepairTaskStatByFaultTypeCriteriaData _transform = RepairTaskStatByFaultTypeListPresenterServiceImpl.this.mapper.transform(it);
            return _transform;
          }
        };
      Iterable<UIRepairTaskStatByFaultTypeCriteriaData> _map = IterableExtensions.<RCRepairTaskStatByFaultTypeCriteriaData, UIRepairTaskStatByFaultTypeCriteriaData>map(_list, _function);
      List<UIRepairTaskStatByFaultTypeCriteriaData> _list_1 = IterableExtensions.<UIRepairTaskStatByFaultTypeCriteriaData>toList(_map);
      final Function1<UIRepairTaskStatByFaultTypeCriteriaData,Long> _function_1 = new Function1<UIRepairTaskStatByFaultTypeCriteriaData,Long>() {
          public Long apply(final UIRepairTaskStatByFaultTypeCriteriaData it) {
            Long _cnt = it.getCnt();
            return _cnt;
          }
        };
      List<UIRepairTaskStatByFaultTypeCriteriaData> _sortBy = IterableExtensions.<UIRepairTaskStatByFaultTypeCriteriaData, Long>sortBy(_list_1, _function_1);
      List<UIRepairTaskStatByFaultTypeCriteriaData> _reverse = ListExtensions.<UIRepairTaskStatByFaultTypeCriteriaData>reverse(_sortBy);
      _xblockexpression = (_reverse);
    }
    return _xblockexpression;
  }
  
  public Collection<UIRepairTaskStatByFaultTypeCriteriaData> load(final UIDateRange dateRange) throws SessionTimeOutException, ValidationException {
    Collection<UIRepairTaskStatByFaultTypeCriteriaData> _xblockexpression = null;
    {
      UIRepairTaskCriteria _uIRepairTaskCriteria = new UIRepairTaskCriteria();
      final Procedure1<UIRepairTaskCriteria> _function = new Procedure1<UIRepairTaskCriteria>() {
          public void apply(final UIRepairTaskCriteria it) {
            it.setReportDateRange(dateRange);
          }
        };
      final UIRepairTaskCriteria uicriteria = ObjectExtensions.<UIRepairTaskCriteria>operator_doubleArrow(_uIRepairTaskCriteria, _function);
      Collection<UIRepairTaskStatByFaultTypeCriteriaData> _executeCriteria = this.executeCriteria(uicriteria);
      _xblockexpression = (_executeCriteria);
    }
    return _xblockexpression;
  }
  
  public Collection<UIRepairTaskStatByFaultTypeCriteriaData> load(final String month) throws SessionTimeOutException, ValidationException {
    Collection<UIRepairTaskStatByFaultTypeCriteriaData> _xblockexpression = null;
    {
      UIRepairTaskCriteria _uIRepairTaskCriteria = new UIRepairTaskCriteria();
      final Procedure1<UIRepairTaskCriteria> _function = new Procedure1<UIRepairTaskCriteria>() {
          public void apply(final UIRepairTaskCriteria it) {
            it.setMonth(month);
          }
        };
      final UIRepairTaskCriteria uicriteria = ObjectExtensions.<UIRepairTaskCriteria>operator_doubleArrow(_uIRepairTaskCriteria, _function);
      Collection<UIRepairTaskStatByFaultTypeCriteriaData> _executeCriteria = this.executeCriteria(uicriteria);
      _xblockexpression = (_executeCriteria);
    }
    return _xblockexpression;
  }
  
  public Collection<UIRepairTaskStatByFaultTypeCriteriaData> load(final UIDateRange dateRange, final RCFaultReportSourceProxy reportSource) throws SessionTimeOutException, ValidationException {
    Collection<UIRepairTaskStatByFaultTypeCriteriaData> _xblockexpression = null;
    {
      UIRepairTaskCriteria _uIRepairTaskCriteria = new UIRepairTaskCriteria();
      final Procedure1<UIRepairTaskCriteria> _function = new Procedure1<UIRepairTaskCriteria>() {
          public void apply(final UIRepairTaskCriteria it) {
            it.setReportDateRange(dateRange);
            it.setFaultReportSource(reportSource);
          }
        };
      final UIRepairTaskCriteria uicriteria = ObjectExtensions.<UIRepairTaskCriteria>operator_doubleArrow(_uIRepairTaskCriteria, _function);
      Collection<UIRepairTaskStatByFaultTypeCriteriaData> _executeCriteria = this.executeCriteria(uicriteria);
      _xblockexpression = (_executeCriteria);
    }
    return _xblockexpression;
  }
}
