package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecordItemStat4ProductEntryCriteria;
import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecordItemStat4ProductEntryCriteriaData;
import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecordItemStatCriteria;
import com.fudanmed.platform.core.web.client.project.ExportWorkItemStockRecordItemStat4ProductEntryCriteriaDataCommandService;
import com.fudanmed.platform.core.web.server.service.project.WorkItemStockRecordItemStat4ProductEntryCriteriaDataCSVMapper;
import com.fudanmed.platform.core.web.server.service.project.WorkItemStockRecordItemStat4ProductEntryCriteriaDataMapper;
import com.fudanmed.platform.core.web.server.service.project.WorkItemStockRecordItemStatCriteriaMapper;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockRecordItemStat4ProductEntryCriteriaData;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockRecordItemStatCriteria;
import com.uniquesoft.gwt.server.common.pager.PagedQueries;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.csv.server.CSVExtensions;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.ExportWorkItemStockRecordItemStat4ProductEntryCriteriaDataCommandService")
@Transactional
public class ExportWorkItemStockRecordItemStat4ProductEntryCriteriaDataCommandServiceImpl extends BaseService implements ExportWorkItemStockRecordItemStat4ProductEntryCriteriaDataCommandService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private WorkItemStockRecordItemStat4ProductEntryCriteriaDataMapper mapper;
  
  @Autowired
  private WorkItemStockRecordItemStatCriteriaMapper criteriaMapper;
  
  public String prepareExport(final UIWorkItemStockRecordItemStatCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    String _xblockexpression = null;
    {
      final RCWorkItemStockRecordItemStatCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCWorkItemStockRecordItemStatCriteria.class, this.criteriaMapper, this.entities);
      RCWorkItemStockRecordItemStat4ProductEntryCriteria _createStatCriteria = c.createStatCriteria(RCWorkItemStockRecordItemStat4ProductEntryCriteria.class);
      Collection<RCWorkItemStockRecordItemStat4ProductEntryCriteriaData> _list = _createStatCriteria.list();
      final Function1<RCWorkItemStockRecordItemStat4ProductEntryCriteriaData,UIWorkItemStockRecordItemStat4ProductEntryCriteriaData> _function = new Function1<RCWorkItemStockRecordItemStat4ProductEntryCriteriaData,UIWorkItemStockRecordItemStat4ProductEntryCriteriaData>() {
          public UIWorkItemStockRecordItemStat4ProductEntryCriteriaData apply(final RCWorkItemStockRecordItemStat4ProductEntryCriteriaData it) {
            UIWorkItemStockRecordItemStat4ProductEntryCriteriaData _transform = ExportWorkItemStockRecordItemStat4ProductEntryCriteriaDataCommandServiceImpl.this.mapper.transform(it);
            return _transform;
          }
        };
      Iterable<UIWorkItemStockRecordItemStat4ProductEntryCriteriaData> _map = IterableExtensions.<RCWorkItemStockRecordItemStat4ProductEntryCriteriaData, UIWorkItemStockRecordItemStat4ProductEntryCriteriaData>map(_list, _function);
      List<UIWorkItemStockRecordItemStat4ProductEntryCriteriaData> _list_1 = IterableExtensions.<UIWorkItemStockRecordItemStat4ProductEntryCriteriaData>toList(_map);
      final Function1<UIWorkItemStockRecordItemStat4ProductEntryCriteriaData,Long> _function_1 = new Function1<UIWorkItemStockRecordItemStat4ProductEntryCriteriaData,Long>() {
          public Long apply(final UIWorkItemStockRecordItemStat4ProductEntryCriteriaData it) {
            Long _cnt = it.getCnt();
            return _cnt;
          }
        };
      List<UIWorkItemStockRecordItemStat4ProductEntryCriteriaData> _sortBy = IterableExtensions.<UIWorkItemStockRecordItemStat4ProductEntryCriteriaData, Long>sortBy(_list_1, _function_1);
      final List<UIWorkItemStockRecordItemStat4ProductEntryCriteriaData> data = ListExtensions.<UIWorkItemStockRecordItemStat4ProductEntryCriteriaData>reverse(_sortBy);
      String _csvPrepare = CSVExtensions.<UIWorkItemStockRecordItemStat4ProductEntryCriteriaData>csvPrepare(this, "StockRecordStatistic", WorkItemStockRecordItemStat4ProductEntryCriteriaDataCSVMapper.class, data);
      _xblockexpression = (_csvPrepare);
    }
    return _xblockexpression;
  }
}
