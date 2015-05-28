package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.common.RCSystemParameter;
import com.fudanmed.platform.core.common.RCSystemParameterService;
import com.fudanmed.platform.core.warehouse.RCOutStockRecord;
import com.fudanmed.platform.core.warehouse.RCOutStockRecordCriteria;
import com.fudanmed.platform.core.warehouse.RCOutStockRecordItem;
import com.fudanmed.platform.core.warehouse.proxy.RCOutStockRecordProxy;
import com.fudanmed.platform.core.web.client.warehouse.OutStockRecordListPresenterService;
import com.fudanmed.platform.core.web.server.service.template.OutStockTemplate;
import com.fudanmed.platform.core.web.server.service.warehouse.OutStockRecordCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.warehouse.OutStockRecordItemMapper;
import com.fudanmed.platform.core.web.server.service.warehouse.OutStockRecordMapper;
import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecordCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecordItem;
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

@Service("com.fudanmed.platform.core.web.client.warehouse.OutStockRecordListPresenterService")
@Transactional
public class OutStockRecordListPresenterServiceImpl extends BaseService implements OutStockRecordListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private OutStockRecordCriteriaMapper criteriaMapper;
  
  @Autowired
  private OutStockRecordMapper mapper;
  
  @Autowired
  private OutStockRecordItemMapper itemMapper;
  
  @Autowired
  private RCSystemParameterService systemParameter;
  
  public String generatePrintContents(final RCOutStockRecordProxy record) throws SessionTimeOutException, ValidationException {
    RCOutStockRecord _resolved= null;
    if(record!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCOutStockRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(record, entities);
    
    RCSystemParameter _systemParameter = this.systemParameter.getSystemParameter();
    String _template = OutStockTemplate.template( _resolved, _systemParameter, this.itemMapper);
    return _template;
  }
  
  public IPagedResult<UIOutStockRecord> filter(final UIOutStockRecordCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UIOutStockRecord> _xblockexpression = null;
    {
      RCOutStockRecordCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCOutStockRecordCriteria.class, this.criteriaMapper, this.entities);
      final Function1<RCOutStockRecord,UIOutStockRecord> _function = new Function1<RCOutStockRecord,UIOutStockRecord>() {
          public UIOutStockRecord apply(final RCOutStockRecord it) {
            UIOutStockRecord _apply = OutStockRecordListPresenterServiceImpl.this.mapper.apply(it);
            return _apply;
          }
        };
      IPagedResult<UIOutStockRecord> _listAndTransform = PagedQueries.<UIOutStockRecord, RCOutStockRecord>listAndTransform(c, new Function<RCOutStockRecord,UIOutStockRecord>() {
          public UIOutStockRecord apply(RCOutStockRecord input) {
            return _function.apply(input);
          }
      });
      _xblockexpression = (_listAndTransform);
    }
    return _xblockexpression;
  }
  
  public void delete(final RCOutStockRecordProxy value) throws SessionTimeOutException, ValidationException {
    RCOutStockRecord _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCOutStockRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    this.entities.delete( _resolved);
  }
  
  public Collection<UIOutStockRecordItem> loadDetails(final RCOutStockRecordProxy parent) throws SessionTimeOutException, ValidationException {
    RCOutStockRecord _resolved= null;
    if(parent!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCOutStockRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(parent, entities);
    
    Collection<RCOutStockRecordItem> _items =  _resolved.getItems();
    final Function1<RCOutStockRecordItem,UIOutStockRecordItem> _function = new Function1<RCOutStockRecordItem,UIOutStockRecordItem>() {
        public UIOutStockRecordItem apply(final RCOutStockRecordItem it) {
          UIOutStockRecordItem _transform = OutStockRecordListPresenterServiceImpl.this.itemMapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIOutStockRecordItem> _map = IterableExtensions.<RCOutStockRecordItem, UIOutStockRecordItem>map(_items, _function);
    Collection<UIOutStockRecordItem> _unlazy = IterableExtensions2.<UIOutStockRecordItem>unlazy(_map);
    return _unlazy;
  }
  
  public UIOutStockRecord loadOutStockRecordInfo(final RCOutStockRecordProxy record) throws SessionTimeOutException, ValidationException {
    RCOutStockRecord _resolved= null;
    if(record!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCOutStockRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(record, entities);
    
    UIOutStockRecord _transform = this.mapper.transform( _resolved);
    return _transform;
  }
}
