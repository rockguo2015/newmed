package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecordItem;
import com.fudanmed.platform.core.warehouse.RCWorkItemStockStatisticsCriteria;
import com.fudanmed.platform.core.web.client.project.ExportWorkItemStockRecordStatisticsCommandService;
import com.fudanmed.platform.core.web.server.service.project.WorkItemStockRecordStatisticsDataCSVMapper;
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
import edu.fudan.langlab.csv.server.CSVExtensions;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.ExportWorkItemStockRecordStatisticsCommandService")
@Transactional
public class ExportWorkItemStockRecordStatisticsCommandServiceImpl extends BaseService implements ExportWorkItemStockRecordStatisticsCommandService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private WorkItemStockRecordStatisticsDataMapper mapper;
  
  @Autowired
  private WorkItemStockStatisticsCriteriaMapper criteriaMapper;
  
  public String prepareExport(final UIWorkItemStockStatisticsCriteria pagedCriteria) throws SessionTimeOutException, ValidationException {
    String _xblockexpression = null;
    {
      RCWorkItemStockStatisticsCriteria c = PagedQueries.createCriteria4All(pagedCriteria, RCWorkItemStockStatisticsCriteria.class, this.criteriaMapper, this.entities);
      final Function1<RCWorkItemStockRecordItem,UIWorkItemStockRecordStatisticsData> _function = new Function1<RCWorkItemStockRecordItem,UIWorkItemStockRecordStatisticsData>() {
          public UIWorkItemStockRecordStatisticsData apply(final RCWorkItemStockRecordItem it) {
            UIWorkItemStockRecordStatisticsData _apply = ExportWorkItemStockRecordStatisticsCommandServiceImpl.this.mapper.apply(it);
            return _apply;
          }
        };
      IPagedResult<UIWorkItemStockRecordStatisticsData> _listAndTransform = PagedQueries.<UIWorkItemStockRecordStatisticsData, RCWorkItemStockRecordItem>listAndTransform(c, new Function<RCWorkItemStockRecordItem,UIWorkItemStockRecordStatisticsData>() {
          public UIWorkItemStockRecordStatisticsData apply(RCWorkItemStockRecordItem input) {
            return _function.apply(input);
          }
      });
      String _csvPrepare = CSVExtensions.<UIWorkItemStockRecordStatisticsData>csvPrepare(this, "WorkItemStockRecordStatistics", WorkItemStockRecordStatisticsDataCSVMapper.class, _listAndTransform);
      _xblockexpression = (_csvPrepare);
    }
    return _xblockexpression;
  }
}
