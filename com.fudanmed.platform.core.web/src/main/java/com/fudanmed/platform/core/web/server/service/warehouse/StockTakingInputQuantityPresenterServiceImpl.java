package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCStockTakingItem;
import com.fudanmed.platform.core.warehouse.RCStockTakingList;
import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingListProxy;
import com.fudanmed.platform.core.web.client.warehouse.StockTakingInputQuantityPresenterService;
import com.fudanmed.platform.core.web.server.service.warehouse.StockTakingItemMapper;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingItem;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.warehouse.StockTakingInputQuantityPresenterService")
@Transactional
public class StockTakingInputQuantityPresenterServiceImpl extends BaseService implements StockTakingInputQuantityPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private StockTakingItemMapper mapper;
  
  public Collection<UIStockTakingItem> loadItems(final RCStockTakingListProxy takingList) throws SessionTimeOutException, ValidationException {
    RCStockTakingList _resolved= null;
    if(takingList!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCStockTakingList)com.uniquesoft.uidl.extensions.ModelObjects.resolve(takingList, entities);
    
    Collection<RCStockTakingItem> _items =  _resolved.getItems();
    final Function1<RCStockTakingItem,UIStockTakingItem> _function = new Function1<RCStockTakingItem,UIStockTakingItem>() {
        public UIStockTakingItem apply(final RCStockTakingItem it) {
          UIStockTakingItem _transform = StockTakingInputQuantityPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIStockTakingItem> _map = IterableExtensions.<RCStockTakingItem, UIStockTakingItem>map(_items, _function);
    Collection<UIStockTakingItem> _unlazy = IterableExtensions2.<UIStockTakingItem>unlazy(_map);
    return _unlazy;
  }
  
  public void updateItems(final Collection<UIStockTakingItem> items) throws SessionTimeOutException, ValidationException {
    final Procedure1<UIStockTakingItem> _function = new Procedure1<UIStockTakingItem>() {
        public void apply(final UIStockTakingItem item) {
          RCStockTakingItem _resolved= null;
          if(item!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCStockTakingItem)com.uniquesoft.uidl.extensions.ModelObjects.resolve(item, entities);
          
          StockTakingInputQuantityPresenterServiceImpl.this.mapper.transform(item,  _resolved);
        }
      };
    IterableExtensions.<UIStockTakingItem>forEach(items, _function);
  }
}
