package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCRepairTaskCriteria;
import com.fudanmed.platform.core.domain.RCRepairTaskStatByMonthCriteria;
import com.fudanmed.platform.core.domain.RCRepairTaskStatByMonthCriteriaData;
import com.fudanmed.platform.core.web.client.project.RepairTaskStatByMonthPresenterService;
import com.fudanmed.platform.core.web.server.service.project.RepairTaskCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.project.RepairTaskStatByMonthCriteriaDataMapper;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskCriteria;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatByMonthCriteriaData;
import com.uniquesoft.gwt.server.common.pager.PagedQueries;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.datatype.UIDateRange;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.common.shared.Objects;
import edu.fudan.mylang.pf.IObjectFactory;
import edu.fudan.mylang.utils.DateUtil.Month;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.RepairTaskStatByMonthPresenterService")
@Transactional
public class RepairTaskStatByMonthPresenterServiceImpl extends BaseService implements RepairTaskStatByMonthPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RepairTaskCriteriaMapper criteriaMapper;
  
  @Autowired
  private RepairTaskStatByMonthCriteriaDataMapper mapper;
  
  public Collection<UIRepairTaskStatByMonthCriteriaData> loadResult(final UIRepairTaskCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    List<UIRepairTaskStatByMonthCriteriaData> _xblockexpression = null;
    {
      final RCRepairTaskCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCRepairTaskCriteria.class, this.criteriaMapper, this.entities);
      c.setIncludeFinishedTask(Boolean.valueOf(true));
      RCRepairTaskStatByMonthCriteria _createStatCriteria = c.createStatCriteria(RCRepairTaskStatByMonthCriteria.class);
      Collection<RCRepairTaskStatByMonthCriteriaData> _list = _createStatCriteria.list();
      final Function1<RCRepairTaskStatByMonthCriteriaData,UIRepairTaskStatByMonthCriteriaData> _function = new Function1<RCRepairTaskStatByMonthCriteriaData,UIRepairTaskStatByMonthCriteriaData>() {
          public UIRepairTaskStatByMonthCriteriaData apply(final RCRepairTaskStatByMonthCriteriaData it) {
            UIRepairTaskStatByMonthCriteriaData _transform = RepairTaskStatByMonthPresenterServiceImpl.this.mapper.transform(it);
            return _transform;
          }
        };
      Iterable<UIRepairTaskStatByMonthCriteriaData> _map = IterableExtensions.<RCRepairTaskStatByMonthCriteriaData, UIRepairTaskStatByMonthCriteriaData>map(_list, _function);
      final Collection<UIRepairTaskStatByMonthCriteriaData> r = IterableExtensions2.<UIRepairTaskStatByMonthCriteriaData>unlazy(_map);
      UIDateRange _reportDateRange = uicriteria.getReportDateRange();
      Date _from = _reportDateRange.getFrom();
      UIDateRange _reportDateRange_1 = uicriteria.getReportDateRange();
      Date _to = _reportDateRange_1.getTo();
      Iterator<Month> _iterator = Month.getIterator(_from, _to);
      final Function1<Month,UIRepairTaskStatByMonthCriteriaData> _function_1 = new Function1<Month,UIRepairTaskStatByMonthCriteriaData>() {
          public UIRepairTaskStatByMonthCriteriaData apply(final Month m) {
            final Function1<UIRepairTaskStatByMonthCriteriaData,Boolean> _function = new Function1<UIRepairTaskStatByMonthCriteriaData,Boolean>() {
                public Boolean apply(final UIRepairTaskStatByMonthCriteriaData it) {
                  String _serialize = m.serialize();
                  String _month = it.getMonth();
                  boolean _equals = _serialize.equals(_month);
                  return Boolean.valueOf(_equals);
                }
              };
            UIRepairTaskStatByMonthCriteriaData _findFirst = IterableExtensions.<UIRepairTaskStatByMonthCriteriaData>findFirst(r, _function);
            final Function1<Void,UIRepairTaskStatByMonthCriteriaData> _function_1 = new Function1<Void,UIRepairTaskStatByMonthCriteriaData>() {
                public UIRepairTaskStatByMonthCriteriaData apply(final Void it) {
                  UIRepairTaskStatByMonthCriteriaData _uIRepairTaskStatByMonthCriteriaData = new UIRepairTaskStatByMonthCriteriaData();
                  final Procedure1<UIRepairTaskStatByMonthCriteriaData> _function = new Procedure1<UIRepairTaskStatByMonthCriteriaData>() {
                      public void apply(final UIRepairTaskStatByMonthCriteriaData it) {
                        String _serialize = m.serialize();
                        it.setMonth(_serialize);
                        it.setCnt(Long.valueOf(0l));
                      }
                    };
                  UIRepairTaskStatByMonthCriteriaData _doubleArrow = ObjectExtensions.<UIRepairTaskStatByMonthCriteriaData>operator_doubleArrow(_uIRepairTaskStatByMonthCriteriaData, _function);
                  return _doubleArrow;
                }
              };
            UIRepairTaskStatByMonthCriteriaData _nullsafe = Objects.<UIRepairTaskStatByMonthCriteriaData>nullsafe(_findFirst, _function_1);
            return _nullsafe;
          }
        };
      Iterator<UIRepairTaskStatByMonthCriteriaData> _map_1 = IteratorExtensions.<Month, UIRepairTaskStatByMonthCriteriaData>map(_iterator, _function_1);
      List<UIRepairTaskStatByMonthCriteriaData> _list_1 = IteratorExtensions.<UIRepairTaskStatByMonthCriteriaData>toList(_map_1);
      _xblockexpression = (_list_1);
    }
    return _xblockexpression;
  }
}
