package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.common.RCSystemParameter;
import com.fudanmed.platform.core.common.RCSystemParameterService;
import com.fudanmed.platform.core.warehouse.RCOutStockRecord;
import com.fudanmed.platform.core.warehouse.RCOutStockRecordItem;
import com.fudanmed.platform.core.warehouse.proxy.RCOutStockRecordProxy;
import com.fudanmed.platform.core.web.client.warehouse.OutStockRecordItemDetailPresenterService;
import com.fudanmed.platform.core.web.server.service.template.OutStockTemplate;
import com.fudanmed.platform.core.web.server.service.warehouse.OutStockRecordItemMapper;
import com.fudanmed.platform.core.web.server.service.warehouse.OutStockRecordMapper;
import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecordItem;
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

@Service("com.fudanmed.platform.core.web.client.warehouse.OutStockRecordItemDetailPresenterService")
@Transactional
public class OutStockRecordItemDetailPresenterServiceImpl extends BaseService implements OutStockRecordItemDetailPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private OutStockRecordItemMapper mapper;
  
  @Autowired
  private OutStockRecordMapper valueMapper;
  
  @Autowired
  private RCSystemParameterService systemParameter;
  
  @Autowired
  private OutStockRecordItemMapper itemMapper;
  
  public Collection<UIOutStockRecordItem> loadWorkItemStockRecordItemList(final RCOutStockRecordProxy context) throws SessionTimeOutException, ValidationException {
    RCOutStockRecord _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCOutStockRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    Collection<RCOutStockRecordItem> _items =  _resolved.getItems();
    final Function1<RCOutStockRecordItem,UIOutStockRecordItem> _function = new Function1<RCOutStockRecordItem,UIOutStockRecordItem>() {
        public UIOutStockRecordItem apply(final RCOutStockRecordItem it) {
          UIOutStockRecordItem _transform = OutStockRecordItemDetailPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIOutStockRecordItem> _map = IterableExtensions.<RCOutStockRecordItem, UIOutStockRecordItem>map(_items, _function);
    Collection<UIOutStockRecordItem> _unlazy = IterableExtensions2.<UIOutStockRecordItem>unlazy(_map);
    return _unlazy;
  }
  
  public UIOutStockRecord loadValue(final RCOutStockRecordProxy context) throws SessionTimeOutException, ValidationException {
    RCOutStockRecord _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCOutStockRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    UIOutStockRecord _transform = this.valueMapper.transform( _resolved);
    return _transform;
  }
  
  public String generatePrintContents(final RCOutStockRecordProxy record) throws SessionTimeOutException, ValidationException {
    RCOutStockRecord _resolved= null;
    if(record!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCOutStockRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(record, entities);
    
    RCSystemParameter _systemParameter = this.systemParameter.getSystemParameter();
    String _template = OutStockTemplate.template( _resolved, _systemParameter, this.itemMapper);
    return _template;
  }
}
