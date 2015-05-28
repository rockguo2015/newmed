package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCStockTakingRecord;
import com.fudanmed.platform.core.warehouse.RCStockTakingRecordCriteria;
import com.fudanmed.platform.core.warehouse.RCStockTakingRecordItem;
import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingRecordProxy;
import com.fudanmed.platform.core.web.client.warehouse.StockTakingRecordListPresenterService;
import com.fudanmed.platform.core.web.server.service.warehouse.StockTakingRecordCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.warehouse.StockTakingRecordItemMapper;
import com.fudanmed.platform.core.web.server.service.warehouse.StockTakingRecordMapper;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecordCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecordItem;
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

@Service("com.fudanmed.platform.core.web.client.warehouse.StockTakingRecordListPresenterService")
@Transactional
public class StockTakingRecordListPresenterServiceImpl extends BaseService implements StockTakingRecordListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private StockTakingRecordCriteriaMapper criteriaMapper;
  
  @Autowired
  private StockTakingRecordMapper mapper;
  
  @Autowired
  private StockTakingRecordItemMapper itemMapper;
  
  public IPagedResult<UIStockTakingRecord> filter(final UIStockTakingRecordCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UIStockTakingRecord> _xblockexpression = null;
    {
      RCStockTakingRecordCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCStockTakingRecordCriteria.class, this.criteriaMapper, this.entities);
      final Function1<RCStockTakingRecord,UIStockTakingRecord> _function = new Function1<RCStockTakingRecord,UIStockTakingRecord>() {
          public UIStockTakingRecord apply(final RCStockTakingRecord it) {
            UIStockTakingRecord _apply = StockTakingRecordListPresenterServiceImpl.this.mapper.apply(it);
            return _apply;
          }
        };
      IPagedResult<UIStockTakingRecord> _listAndTransform = PagedQueries.<UIStockTakingRecord, RCStockTakingRecord>listAndTransform(c, new Function<RCStockTakingRecord,UIStockTakingRecord>() {
          public UIStockTakingRecord apply(RCStockTakingRecord input) {
            return _function.apply(input);
          }
      });
      _xblockexpression = (_listAndTransform);
    }
    return _xblockexpression;
  }
  
  public void delete(final RCStockTakingRecordProxy value) throws SessionTimeOutException, ValidationException {
    RCStockTakingRecord _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCStockTakingRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    this.entities.delete( _resolved);
  }
  
  public Collection<UIStockTakingRecordItem> loadDetails(final RCStockTakingRecordProxy parent) throws SessionTimeOutException, ValidationException {
    RCStockTakingRecord _resolved= null;
    if(parent!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCStockTakingRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(parent, entities);
    
    Collection<RCStockTakingRecordItem> _items =  _resolved.getItems();
    final Function1<RCStockTakingRecordItem,UIStockTakingRecordItem> _function = new Function1<RCStockTakingRecordItem,UIStockTakingRecordItem>() {
        public UIStockTakingRecordItem apply(final RCStockTakingRecordItem it) {
          UIStockTakingRecordItem _transform = StockTakingRecordListPresenterServiceImpl.this.itemMapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIStockTakingRecordItem> _map = IterableExtensions.<RCStockTakingRecordItem, UIStockTakingRecordItem>map(_items, _function);
    Collection<UIStockTakingRecordItem> _unlazy = IterableExtensions2.<UIStockTakingRecordItem>unlazy(_map);
    return _unlazy;
  }
  
  public UIStockTakingRecord loadStockTakingRecordInfo(final RCStockTakingRecordProxy record) throws SessionTimeOutException, ValidationException {
    RCStockTakingRecord _resolved= null;
    if(record!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCStockTakingRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(record, entities);
    
    UIStockTakingRecord _transform = this.mapper.transform( _resolved);
    return _transform;
  }
}
