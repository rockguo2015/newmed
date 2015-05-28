package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.common.RCFaultReportSource;
import com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy;
import com.fudanmed.platform.core.domain.RCRepairTaskCriteria;
import com.fudanmed.platform.core.domain.RCRepairTaskStatByReportSourceCriteria;
import com.fudanmed.platform.core.domain.RCRepairTaskStatByReportSourceCriteriaData;
import com.fudanmed.platform.core.web.client.project.RepairTaskStatByReportSourcePresenterService;
import com.fudanmed.platform.core.web.server.service.project.RepairTaskCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.project.RepairTaskStatByReportSourceCriteriaDataMapper;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskCriteria;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatByReportSourceCriteriaData;
import com.google.common.base.Objects;
import com.uniquesoft.gwt.server.common.pager.PagedQueries;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.RepairTaskStatByReportSourcePresenterService")
@Transactional
public class RepairTaskStatByReportSourcePresenterServiceImpl extends BaseService implements RepairTaskStatByReportSourcePresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RepairTaskCriteriaMapper criteriaMapper;
  
  @Autowired
  private RepairTaskStatByReportSourceCriteriaDataMapper mapper;
  
  public Collection<UIRepairTaskStatByReportSourceCriteriaData> loadResult(final UIRepairTaskCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    Collection<UIRepairTaskStatByReportSourceCriteriaData> _xblockexpression = null;
    {
      final RCRepairTaskCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCRepairTaskCriteria.class, this.criteriaMapper, this.entities);
      c.setIncludeFinishedTask(Boolean.valueOf(true));
      RCRepairTaskStatByReportSourceCriteria _createStatCriteria = c.createStatCriteria(RCRepairTaskStatByReportSourceCriteria.class);
      Collection<RCRepairTaskStatByReportSourceCriteriaData> _list = _createStatCriteria.list();
      final Function1<RCRepairTaskStatByReportSourceCriteriaData,UIRepairTaskStatByReportSourceCriteriaData> _function = new Function1<RCRepairTaskStatByReportSourceCriteriaData,UIRepairTaskStatByReportSourceCriteriaData>() {
          public UIRepairTaskStatByReportSourceCriteriaData apply(final RCRepairTaskStatByReportSourceCriteriaData it) {
            UIRepairTaskStatByReportSourceCriteriaData _transform = RepairTaskStatByReportSourcePresenterServiceImpl.this.mapper.transform(it);
            return _transform;
          }
        };
      Iterable<UIRepairTaskStatByReportSourceCriteriaData> _map = IterableExtensions.<RCRepairTaskStatByReportSourceCriteriaData, UIRepairTaskStatByReportSourceCriteriaData>map(_list, _function);
      final Collection<UIRepairTaskStatByReportSourceCriteriaData> result = IterableExtensions2.<UIRepairTaskStatByReportSourceCriteriaData>unlazy(_map);
      Collection<RCFaultReportSource> _all = this.entities.<RCFaultReportSource>all(RCFaultReportSource.class);
      final Function1<RCFaultReportSource,UIRepairTaskStatByReportSourceCriteriaData> _function_1 = new Function1<RCFaultReportSource,UIRepairTaskStatByReportSourceCriteriaData>() {
          public UIRepairTaskStatByReportSourceCriteriaData apply(final RCFaultReportSource source) {
            final Function1<UIRepairTaskStatByReportSourceCriteriaData,Boolean> _function = new Function1<UIRepairTaskStatByReportSourceCriteriaData,Boolean>() {
                public Boolean apply(final UIRepairTaskStatByReportSourceCriteriaData it) {
                  RCFaultReportSourceProxy _faultReportSource = it.getFaultReportSource();
                  Long _id = _faultReportSource.getId();
                  Long _id_1 = source.getId();
                  boolean _equals = Objects.equal(_id, _id_1);
                  return Boolean.valueOf(_equals);
                }
              };
            UIRepairTaskStatByReportSourceCriteriaData _findFirst = IterableExtensions.<UIRepairTaskStatByReportSourceCriteriaData>findFirst(result, _function);
            final Function1<Void,UIRepairTaskStatByReportSourceCriteriaData> _function_1 = new Function1<Void,UIRepairTaskStatByReportSourceCriteriaData>() {
                public UIRepairTaskStatByReportSourceCriteriaData apply(final Void it) {
                  UIRepairTaskStatByReportSourceCriteriaData _uIRepairTaskStatByReportSourceCriteriaData = new UIRepairTaskStatByReportSourceCriteriaData();
                  final Procedure1<UIRepairTaskStatByReportSourceCriteriaData> _function = new Procedure1<UIRepairTaskStatByReportSourceCriteriaData>() {
                      public void apply(final UIRepairTaskStatByReportSourceCriteriaData it) {
                        RCFaultReportSourceProxy _proxy = source.toProxy();
                        it.setFaultReportSource(_proxy);
                        it.setCnt(Long.valueOf(0l));
                      }
                    };
                  UIRepairTaskStatByReportSourceCriteriaData _doubleArrow = ObjectExtensions.<UIRepairTaskStatByReportSourceCriteriaData>operator_doubleArrow(_uIRepairTaskStatByReportSourceCriteriaData, _function);
                  return _doubleArrow;
                }
              };
            UIRepairTaskStatByReportSourceCriteriaData _nullsafe = edu.fudan.langlab.common.shared.Objects.<UIRepairTaskStatByReportSourceCriteriaData>nullsafe(_findFirst, _function_1);
            return _nullsafe;
          }
        };
      Iterable<UIRepairTaskStatByReportSourceCriteriaData> _map_1 = IterableExtensions.<RCFaultReportSource, UIRepairTaskStatByReportSourceCriteriaData>map(_all, _function_1);
      Collection<UIRepairTaskStatByReportSourceCriteriaData> _unlazy = IterableExtensions2.<UIRepairTaskStatByReportSourceCriteriaData>unlazy(_map_1);
      _xblockexpression = (_unlazy);
    }
    return _xblockexpression;
  }
}
