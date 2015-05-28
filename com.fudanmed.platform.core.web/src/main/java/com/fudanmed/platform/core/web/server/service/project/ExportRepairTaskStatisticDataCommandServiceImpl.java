package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.RCRepairTaskStatisticCriteria;
import com.fudanmed.platform.core.web.client.project.ExportRepairTaskStatisticDataCommandService;
import com.fudanmed.platform.core.web.server.service.project.RepairTaskStatisticCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.project.RepairTaskStatisticDataCSVMapper;
import com.fudanmed.platform.core.web.server.service.project.RepairTaskStatisticDataMapper;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatisticCriteria;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatisticData;
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

@Service("com.fudanmed.platform.core.web.client.project.ExportRepairTaskStatisticDataCommandService")
@Transactional
public class ExportRepairTaskStatisticDataCommandServiceImpl extends BaseService implements ExportRepairTaskStatisticDataCommandService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RepairTaskStatisticDataMapper mapper;
  
  @Autowired
  private RepairTaskStatisticCriteriaMapper criteriaMapper;
  
  public String prepareExport(final UIRepairTaskStatisticCriteria pagedCriteria) throws SessionTimeOutException, ValidationException {
    String _xblockexpression = null;
    {
      RCRepairTaskStatisticCriteria c = PagedQueries.createCriteria4All(pagedCriteria, RCRepairTaskStatisticCriteria.class, this.criteriaMapper, this.entities);
      final Function1<RCRepairTask,UIRepairTaskStatisticData> _function = new Function1<RCRepairTask,UIRepairTaskStatisticData>() {
          public UIRepairTaskStatisticData apply(final RCRepairTask it) {
            UIRepairTaskStatisticData _apply = ExportRepairTaskStatisticDataCommandServiceImpl.this.mapper.apply(it);
            return _apply;
          }
        };
      IPagedResult<UIRepairTaskStatisticData> _listAndTransform = PagedQueries.<UIRepairTaskStatisticData, RCRepairTask>listAndTransform(c, new Function<RCRepairTask,UIRepairTaskStatisticData>() {
          public UIRepairTaskStatisticData apply(RCRepairTask input) {
            return _function.apply(input);
          }
      });
      String _csvPrepare = CSVExtensions.<UIRepairTaskStatisticData>csvPrepare(this, "RepairTaskStatisticData", RepairTaskStatisticDataCSVMapper.class, _listAndTransform);
      _xblockexpression = (_csvPrepare);
    }
    return _xblockexpression;
  }
}
