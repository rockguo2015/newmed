package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy;
import com.fudanmed.platform.core.domain.RCRepairTaskCriteria;
import com.fudanmed.platform.core.domain.RCRepairTaskStatByOrganizationTypeCriteria;
import com.fudanmed.platform.core.domain.RCRepairTaskStatByOrganizationTypeCriteriaData;
import com.fudanmed.platform.core.web.client.project.RepairTaskStatByOrganizationTypeListPresenterService;
import com.fudanmed.platform.core.web.server.service.project.RepairTaskCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.project.RepairTaskStatByOrganizationTypeCriteriaDataMapper;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskCriteria;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatByOrganizationTypeCriteriaData;
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

@Service("com.fudanmed.platform.core.web.client.project.RepairTaskStatByOrganizationTypeListPresenterService")
@Transactional
public class RepairTaskStatByOrganizationTypeListPresenterServiceImpl extends BaseService implements RepairTaskStatByOrganizationTypeListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RepairTaskCriteriaMapper criteriaMapper;
  
  @Autowired
  private RepairTaskStatByOrganizationTypeCriteriaDataMapper mapper;
  
  public Collection<UIRepairTaskStatByOrganizationTypeCriteriaData> executeCriteria(final UIRepairTaskCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    List<UIRepairTaskStatByOrganizationTypeCriteriaData> _xblockexpression = null;
    {
      final RCRepairTaskCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCRepairTaskCriteria.class, this.criteriaMapper, this.entities);
      c.setIncludeFinishedTask(Boolean.valueOf(true));
      RCRepairTaskStatByOrganizationTypeCriteria _createStatCriteria = c.createStatCriteria(RCRepairTaskStatByOrganizationTypeCriteria.class);
      Collection<RCRepairTaskStatByOrganizationTypeCriteriaData> _list = _createStatCriteria.list();
      final Function1<RCRepairTaskStatByOrganizationTypeCriteriaData,UIRepairTaskStatByOrganizationTypeCriteriaData> _function = new Function1<RCRepairTaskStatByOrganizationTypeCriteriaData,UIRepairTaskStatByOrganizationTypeCriteriaData>() {
          public UIRepairTaskStatByOrganizationTypeCriteriaData apply(final RCRepairTaskStatByOrganizationTypeCriteriaData it) {
            UIRepairTaskStatByOrganizationTypeCriteriaData _transform = RepairTaskStatByOrganizationTypeListPresenterServiceImpl.this.mapper.transform(it);
            return _transform;
          }
        };
      Iterable<UIRepairTaskStatByOrganizationTypeCriteriaData> _map = IterableExtensions.<RCRepairTaskStatByOrganizationTypeCriteriaData, UIRepairTaskStatByOrganizationTypeCriteriaData>map(_list, _function);
      List<UIRepairTaskStatByOrganizationTypeCriteriaData> _list_1 = IterableExtensions.<UIRepairTaskStatByOrganizationTypeCriteriaData>toList(_map);
      final Function1<UIRepairTaskStatByOrganizationTypeCriteriaData,Long> _function_1 = new Function1<UIRepairTaskStatByOrganizationTypeCriteriaData,Long>() {
          public Long apply(final UIRepairTaskStatByOrganizationTypeCriteriaData it) {
            Long _cnt = it.getCnt();
            return _cnt;
          }
        };
      List<UIRepairTaskStatByOrganizationTypeCriteriaData> _sortBy = IterableExtensions.<UIRepairTaskStatByOrganizationTypeCriteriaData, Long>sortBy(_list_1, _function_1);
      List<UIRepairTaskStatByOrganizationTypeCriteriaData> _reverse = ListExtensions.<UIRepairTaskStatByOrganizationTypeCriteriaData>reverse(_sortBy);
      _xblockexpression = (_reverse);
    }
    return _xblockexpression;
  }
  
  public Collection<UIRepairTaskStatByOrganizationTypeCriteriaData> load(final String month) throws SessionTimeOutException, ValidationException {
    Collection<UIRepairTaskStatByOrganizationTypeCriteriaData> _xblockexpression = null;
    {
      UIRepairTaskCriteria _uIRepairTaskCriteria = new UIRepairTaskCriteria();
      final Procedure1<UIRepairTaskCriteria> _function = new Procedure1<UIRepairTaskCriteria>() {
          public void apply(final UIRepairTaskCriteria it) {
            it.setMonth(month);
          }
        };
      final UIRepairTaskCriteria uicriteria = ObjectExtensions.<UIRepairTaskCriteria>operator_doubleArrow(_uIRepairTaskCriteria, _function);
      Collection<UIRepairTaskStatByOrganizationTypeCriteriaData> _executeCriteria = this.executeCriteria(uicriteria);
      _xblockexpression = (_executeCriteria);
    }
    return _xblockexpression;
  }
  
  public Collection<UIRepairTaskStatByOrganizationTypeCriteriaData> load(final UIDateRange dateRange) throws SessionTimeOutException, ValidationException {
    Collection<UIRepairTaskStatByOrganizationTypeCriteriaData> _xblockexpression = null;
    {
      UIRepairTaskCriteria _uIRepairTaskCriteria = new UIRepairTaskCriteria();
      final Procedure1<UIRepairTaskCriteria> _function = new Procedure1<UIRepairTaskCriteria>() {
          public void apply(final UIRepairTaskCriteria it) {
            it.setReportDateRange(dateRange);
          }
        };
      final UIRepairTaskCriteria uicriteria = ObjectExtensions.<UIRepairTaskCriteria>operator_doubleArrow(_uIRepairTaskCriteria, _function);
      Collection<UIRepairTaskStatByOrganizationTypeCriteriaData> _executeCriteria = this.executeCriteria(uicriteria);
      _xblockexpression = (_executeCriteria);
    }
    return _xblockexpression;
  }
  
  public Collection<UIRepairTaskStatByOrganizationTypeCriteriaData> load(final UIDateRange dateRange, final RCFaultReportSourceProxy reportSource) throws SessionTimeOutException, ValidationException {
    Collection<UIRepairTaskStatByOrganizationTypeCriteriaData> _xblockexpression = null;
    {
      UIRepairTaskCriteria _uIRepairTaskCriteria = new UIRepairTaskCriteria();
      final Procedure1<UIRepairTaskCriteria> _function = new Procedure1<UIRepairTaskCriteria>() {
          public void apply(final UIRepairTaskCriteria it) {
            it.setReportDateRange(dateRange);
            it.setFaultReportSource(reportSource);
          }
        };
      final UIRepairTaskCriteria uicriteria = ObjectExtensions.<UIRepairTaskCriteria>operator_doubleArrow(_uIRepairTaskCriteria, _function);
      Collection<UIRepairTaskStatByOrganizationTypeCriteriaData> _executeCriteria = this.executeCriteria(uicriteria);
      _xblockexpression = (_executeCriteria);
    }
    return _xblockexpression;
  }
}
