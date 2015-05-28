package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.common.RCSystemParameter;
import com.fudanmed.platform.core.common.RCSystemParameterService;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.RCWorkItemTaskCriteria;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.warehouse.RCWorkItemOutStockRecord;
import com.fudanmed.platform.core.warehouse.RCWorkItemReturnStockRecord;
import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecord;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemOutStockRecordProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemStockRecordProxy;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemTaskManagementPresenterService;
import com.fudanmed.platform.core.web.server.service.project.WorkItemTaskMapper;
import com.fudanmed.platform.core.web.server.service.template.Template;
import com.fudanmed.platform.core.web.server.service.template.WorkOrderReturnTemplate;
import com.fudanmed.platform.core.web.server.service.warehouse.WorkItemTaskCriteriaMapper;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTask;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemTaskCriteria;
import com.google.common.base.Function;
import com.uniquesoft.gwt.server.common.pager.PagedQueries;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.warehouse.WorkItemTaskManagementPresenterService")
@Transactional
public class WorkItemTaskManagementPresenterServiceImpl extends BaseService implements WorkItemTaskManagementPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private WorkItemTaskCriteriaMapper criteriaMapper;
  
  @Autowired
  private WorkItemTaskMapper mapper;
  
  @Autowired
  private RCSystemParameterService systemParameter;
  
  public String generatePrintContents(final RCWorkItemStockRecordProxy record) throws SessionTimeOutException, ValidationException {
    String _xblockexpression = null;
    {
      RCWorkItemStockRecord _resolved= null;
      if(record!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCWorkItemStockRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(record, entities);
      
      final RCWorkItemStockRecord r =  _resolved;
      String _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (r instanceof RCWorkItemOutStockRecord) {
          final RCWorkItemOutStockRecord _rCWorkItemOutStockRecord = (RCWorkItemOutStockRecord)r;
          _matched=true;
          RCSystemParameter _systemParameter = this.systemParameter.getSystemParameter();
          String _workItemOutStock = Template.workItemOutStock(_rCWorkItemOutStockRecord, _systemParameter);
          _switchResult = _workItemOutStock;
        }
      }
      if (!_matched) {
        if (r instanceof RCWorkItemReturnStockRecord) {
          final RCWorkItemReturnStockRecord _rCWorkItemReturnStockRecord = (RCWorkItemReturnStockRecord)r;
          _matched=true;
          RCSystemParameter _systemParameter = this.systemParameter.getSystemParameter();
          String _template = WorkOrderReturnTemplate.template(_rCWorkItemReturnStockRecord, _systemParameter);
          _switchResult = _template;
        }
      }
      _xblockexpression = (_switchResult);
    }
    return _xblockexpression;
  }
  
  public String generateOutFitPrintContents(final RCWorkItemOutStockRecordProxy record) throws SessionTimeOutException, ValidationException {
    RCWorkItemOutStockRecord _resolved= null;
    if(record!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCWorkItemOutStockRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(record, entities);
    
    String _workItemOutStockFit = Template.workItemOutStockFit( _resolved);
    return _workItemOutStockFit;
  }
  
  public IPagedResult<UIWorkItemTask> filter(final UIWorkItemTaskCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UIWorkItemTask> _xblockexpression = null;
    {
      RCWorkItemTaskCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCWorkItemTaskCriteria.class, this.criteriaMapper, this.entities);
      final Function1<RCWorkItemTask,UIWorkItemTask> _function = new Function1<RCWorkItemTask,UIWorkItemTask>() {
          public UIWorkItemTask apply(final RCWorkItemTask it) {
            UIWorkItemTask _apply = WorkItemTaskManagementPresenterServiceImpl.this.mapper.apply(it);
            return _apply;
          }
        };
      IPagedResult<UIWorkItemTask> _listAndTransform = PagedQueries.<UIWorkItemTask, RCWorkItemTask>listAndTransform(c, new Function<RCWorkItemTask,UIWorkItemTask>() {
          public UIWorkItemTask apply(RCWorkItemTask input) {
            return _function.apply(input);
          }
      });
      _xblockexpression = (_listAndTransform);
    }
    return _xblockexpression;
  }
  
  public void delete(final RCWorkItemTaskProxy value) throws SessionTimeOutException, ValidationException {
    RCWorkItemTask _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.domain.RCWorkItemTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    this.entities.delete( _resolved);
  }
  
  public Boolean isOutStock(final RCWorkItemStockRecordProxy context) throws SessionTimeOutException, ValidationException {
    RCWorkItemStockRecord _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCWorkItemStockRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    return Boolean.valueOf(( _resolved instanceof RCWorkItemOutStockRecord));
  }
}
