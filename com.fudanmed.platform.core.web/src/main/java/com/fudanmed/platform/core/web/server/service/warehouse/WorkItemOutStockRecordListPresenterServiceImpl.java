package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecord;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemOutStockRecordListPresenterService;
import com.fudanmed.platform.core.web.server.service.warehouse.WorkItemStockRecordMapper;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecord;
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

@Service("com.fudanmed.platform.core.web.client.warehouse.WorkItemOutStockRecordListPresenterService")
@Transactional
public class WorkItemOutStockRecordListPresenterServiceImpl extends BaseService implements WorkItemOutStockRecordListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private WorkItemStockRecordMapper mapper;
  
  public Collection<UIWorkItemStockRecord> loadWorkItemOutStockRecordList(final RCWorkItemTaskProxy context) throws SessionTimeOutException, ValidationException {
    RCWorkItemTask _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.domain.RCWorkItemTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    Collection<RCWorkItemStockRecord> _outStoreRecord =  _resolved.getOutStoreRecord();
    final Function1<RCWorkItemStockRecord,UIWorkItemStockRecord> _function = new Function1<RCWorkItemStockRecord,UIWorkItemStockRecord>() {
        public UIWorkItemStockRecord apply(final RCWorkItemStockRecord it) {
          UIWorkItemStockRecord _transform = WorkItemOutStockRecordListPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIWorkItemStockRecord> _map = IterableExtensions.<RCWorkItemStockRecord, UIWorkItemStockRecord>map(_outStoreRecord, _function);
    Collection<UIWorkItemStockRecord> _unlazy = IterableExtensions2.<UIWorkItemStockRecord>unlazy(_map);
    return _unlazy;
  }
}
