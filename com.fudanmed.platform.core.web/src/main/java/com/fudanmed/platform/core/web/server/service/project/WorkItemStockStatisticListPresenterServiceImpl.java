package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecordItem;
import com.fudanmed.platform.core.warehouse.RCWorkItemStockStatisticsCriteria;
import com.fudanmed.platform.core.web.client.project.WorkItemStockStatisticListPresenterService;
import com.fudanmed.platform.core.web.server.service.project.WorkItemStockRecordStatisticsDataMapper;
import com.fudanmed.platform.core.web.server.service.project.WorkItemStockStatisticsCriteriaMapper;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockRecordStatisticsData;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockStatisticsCriteria;
import com.google.common.base.Function;
import com.uniquesoft.gwt.server.common.pager.PagedQueries;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.WorkItemStockStatisticListPresenterService")
@Transactional
public class WorkItemStockStatisticListPresenterServiceImpl extends BaseService implements WorkItemStockStatisticListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private WorkItemStockRecordStatisticsDataMapper mapper;
  
  @Autowired
  private WorkItemStockStatisticsCriteriaMapper criteriaMapper;
  
  public Collection<UIWorkItemStockRecordStatisticsData> loadRepairTaskList(final UIWorkItemStockStatisticsCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UIWorkItemStockRecordStatisticsData> _xblockexpression = null;
    {
      RCWorkItemStockStatisticsCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCWorkItemStockStatisticsCriteria.class, this.criteriaMapper, this.entities);
      final Function1<RCWorkItemStockRecordItem,UIWorkItemStockRecordStatisticsData> _function = new Function1<RCWorkItemStockRecordItem,UIWorkItemStockRecordStatisticsData>() {
          public UIWorkItemStockRecordStatisticsData apply(final RCWorkItemStockRecordItem it) {
            UIWorkItemStockRecordStatisticsData _apply = WorkItemStockStatisticListPresenterServiceImpl.this.mapper.apply(it);
            return _apply;
          }
        };
      IPagedResult<UIWorkItemStockRecordStatisticsData> _listAndTransform = PagedQueries.<UIWorkItemStockRecordStatisticsData, RCWorkItemStockRecordItem>listAndTransform(c, new Function<RCWorkItemStockRecordItem,UIWorkItemStockRecordStatisticsData>() {
          public UIWorkItemStockRecordStatisticsData apply(RCWorkItemStockRecordItem input) {
            return _function.apply(input);
          }
      });
      _xblockexpression = (_listAndTransform);
    }
    return _xblockexpression;
  }
}
