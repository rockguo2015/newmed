package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCWorkItemReturnStockRecord;
import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecordItem;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemReturnStockRecordProxy;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemReturnStockRecordItemDetailPresenterService;
import com.fudanmed.platform.core.web.server.service.warehouse.WorkItemReturnStockRecordMapper;
import com.fudanmed.platform.core.web.server.service.warehouse.WorkItemStockRecordItemMapper;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemReturnStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecordItem;
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

@Service("com.fudanmed.platform.core.web.client.warehouse.WorkItemReturnStockRecordItemDetailPresenterService")
@Transactional
public class WorkItemReturnStockRecordItemDetailPresenterServiceImpl extends BaseService implements WorkItemReturnStockRecordItemDetailPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private WorkItemStockRecordItemMapper mapper;
  
  @Autowired
  private WorkItemReturnStockRecordMapper valueMapper;
  
  public Collection<UIWorkItemStockRecordItem> loadWorkItemStockRecordItemList(final RCWorkItemReturnStockRecordProxy context) throws SessionTimeOutException, ValidationException {
    RCWorkItemReturnStockRecord _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCWorkItemReturnStockRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    Collection<RCWorkItemStockRecordItem> _items =  _resolved.getItems();
    final Function1<RCWorkItemStockRecordItem,UIWorkItemStockRecordItem> _function = new Function1<RCWorkItemStockRecordItem,UIWorkItemStockRecordItem>() {
        public UIWorkItemStockRecordItem apply(final RCWorkItemStockRecordItem it) {
          UIWorkItemStockRecordItem _transform = WorkItemReturnStockRecordItemDetailPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIWorkItemStockRecordItem> _map = IterableExtensions.<RCWorkItemStockRecordItem, UIWorkItemStockRecordItem>map(_items, _function);
    Collection<UIWorkItemStockRecordItem> _unlazy = IterableExtensions2.<UIWorkItemStockRecordItem>unlazy(_map);
    return _unlazy;
  }
  
  public UIWorkItemReturnStockRecord loadValue(final RCWorkItemReturnStockRecordProxy context) throws SessionTimeOutException, ValidationException {
    RCWorkItemReturnStockRecord _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCWorkItemReturnStockRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    UIWorkItemReturnStockRecord _transform = this.valueMapper.transform( _resolved);
    return _transform;
  }
}
