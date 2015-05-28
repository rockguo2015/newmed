package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecord;
import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecordCriteria;
import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecordItem;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemStockRecordProxy;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemStockRecordManagementPresenterService;
import com.fudanmed.platform.core.web.server.service.warehouse.WorkItemStockRecordCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.warehouse.WorkItemStockRecordItemMapper;
import com.fudanmed.platform.core.web.server.service.warehouse.WorkItemStockRecordMapper;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecordCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecordItem;
import com.google.common.base.Function;
import com.uniquesoft.gwt.server.common.pager.PagedQueries;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.warehouse.WorkItemStockRecordManagementPresenterService")
@Transactional
public class WorkItemStockRecordManagementPresenterServiceImpl extends BaseService implements WorkItemStockRecordManagementPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private WorkItemStockRecordCriteriaMapper criteriaMapper;
  
  @Autowired
  private WorkItemStockRecordMapper mapper;
  
  @Autowired
  private WorkItemStockRecordItemMapper itemMapper;
  
  public IPagedResult<UIWorkItemStockRecord> filter(final UIWorkItemStockRecordCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UIWorkItemStockRecord> _xblockexpression = null;
    {
      RCWorkItemStockRecordCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCWorkItemStockRecordCriteria.class, this.criteriaMapper, this.entities);
      final Function1<RCWorkItemStockRecord,UIWorkItemStockRecord> _function = new Function1<RCWorkItemStockRecord,UIWorkItemStockRecord>() {
          public UIWorkItemStockRecord apply(final RCWorkItemStockRecord it) {
            UIWorkItemStockRecord _apply = WorkItemStockRecordManagementPresenterServiceImpl.this.mapper.apply(it);
            return _apply;
          }
        };
      IPagedResult<UIWorkItemStockRecord> _listAndTransform = PagedQueries.<UIWorkItemStockRecord, RCWorkItemStockRecord>listAndTransform(c, new Function<RCWorkItemStockRecord,UIWorkItemStockRecord>() {
          public UIWorkItemStockRecord apply(RCWorkItemStockRecord input) {
            return _function.apply(input);
          }
      });
      _xblockexpression = (_listAndTransform);
    }
    return _xblockexpression;
  }
  
  public Collection<UIWorkItemStockRecordItem> loadDetail(final RCWorkItemStockRecordProxy value) throws SessionTimeOutException, ValidationException {
    RCWorkItemStockRecord _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCWorkItemStockRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    Collection<RCWorkItemStockRecordItem> _items =  _resolved.getItems();
    final Function1<RCWorkItemStockRecordItem,UIWorkItemStockRecordItem> _function = new Function1<RCWorkItemStockRecordItem,UIWorkItemStockRecordItem>() {
        public UIWorkItemStockRecordItem apply(final RCWorkItemStockRecordItem it) {
          UIWorkItemStockRecordItem _transform = WorkItemStockRecordManagementPresenterServiceImpl.this.itemMapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIWorkItemStockRecordItem> _map = IterableExtensions.<RCWorkItemStockRecordItem, UIWorkItemStockRecordItem>map(_items, _function);
    Collection<UIWorkItemStockRecordItem> _unlazy = IterableExtensions2.<UIWorkItemStockRecordItem>unlazy(_map);
    return _unlazy;
  }
}
