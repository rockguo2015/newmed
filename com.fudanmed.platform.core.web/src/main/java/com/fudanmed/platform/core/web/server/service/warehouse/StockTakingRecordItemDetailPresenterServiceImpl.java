package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCStockTakingRecord;
import com.fudanmed.platform.core.warehouse.RCStockTakingRecordItem;
import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingRecordProxy;
import com.fudanmed.platform.core.web.client.warehouse.StockTakingRecordItemDetailPresenterService;
import com.fudanmed.platform.core.web.server.service.warehouse.StockTakingRecordItemMapper;
import com.fudanmed.platform.core.web.server.service.warehouse.StockTakingRecordMapper;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecordItem;
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

@Service("com.fudanmed.platform.core.web.client.warehouse.StockTakingRecordItemDetailPresenterService")
@Transactional
public class StockTakingRecordItemDetailPresenterServiceImpl extends BaseService implements StockTakingRecordItemDetailPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private StockTakingRecordItemMapper mapper;
  
  @Autowired
  private StockTakingRecordMapper valueMapper;
  
  public Collection<UIStockTakingRecordItem> loadWorkItemStockRecordItemList(final RCStockTakingRecordProxy context) throws SessionTimeOutException, ValidationException {
    RCStockTakingRecord _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCStockTakingRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    Collection<RCStockTakingRecordItem> _items =  _resolved.getItems();
    final Function1<RCStockTakingRecordItem,UIStockTakingRecordItem> _function = new Function1<RCStockTakingRecordItem,UIStockTakingRecordItem>() {
        public UIStockTakingRecordItem apply(final RCStockTakingRecordItem it) {
          UIStockTakingRecordItem _transform = StockTakingRecordItemDetailPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIStockTakingRecordItem> _map = IterableExtensions.<RCStockTakingRecordItem, UIStockTakingRecordItem>map(_items, _function);
    Collection<UIStockTakingRecordItem> _unlazy = IterableExtensions2.<UIStockTakingRecordItem>unlazy(_map);
    return _unlazy;
  }
  
  public UIStockTakingRecord loadValue(final RCStockTakingRecordProxy context) throws SessionTimeOutException, ValidationException {
    RCStockTakingRecord _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCStockTakingRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    UIStockTakingRecord _transform = this.valueMapper.transform( _resolved);
    return _transform;
  }
  
  public String generatePrintContents(final RCStockTakingRecordProxy record) throws SessionTimeOutException, ValidationException {
    return null;
  }
}
