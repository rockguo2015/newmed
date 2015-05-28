package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.common.RCSystemParameter;
import com.fudanmed.platform.core.common.RCSystemParameterService;
import com.fudanmed.platform.core.warehouse.RCInStockRecord;
import com.fudanmed.platform.core.warehouse.RCInStockRecordCriteria;
import com.fudanmed.platform.core.warehouse.RCInStockRecordItem;
import com.fudanmed.platform.core.warehouse.proxy.RCInStockRecordProxy;
import com.fudanmed.platform.core.web.client.warehouse.InStockRecordListPresenterService;
import com.fudanmed.platform.core.web.server.service.template.InStockTemplate;
import com.fudanmed.platform.core.web.server.service.warehouse.InStockRecordCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.warehouse.InStockRecordItemMapper;
import com.fudanmed.platform.core.web.server.service.warehouse.InStockRecordMapper;
import com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecordCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecordItem;
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

@Service("com.fudanmed.platform.core.web.client.warehouse.InStockRecordListPresenterService")
@Transactional
public class InStockRecordListPresenterServiceImpl extends BaseService implements InStockRecordListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private InStockRecordCriteriaMapper criteriaMapper;
  
  @Autowired
  private InStockRecordMapper mapper;
  
  @Autowired
  private InStockRecordItemMapper itemMapper;
  
  @Autowired
  private RCSystemParameterService systemParameter;
  
  public String generatePrintContent(final RCInStockRecordProxy inStockRecord) throws SessionTimeOutException, ValidationException {
    RCInStockRecord _resolved= null;
    if(inStockRecord!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCInStockRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(inStockRecord, entities);
    
    RCSystemParameter _systemParameter = this.systemParameter.getSystemParameter();
    String _template = InStockTemplate.template( _resolved, _systemParameter, this.itemMapper);
    return _template;
  }
  
  public IPagedResult<UIInStockRecord> filter(final UIInStockRecordCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UIInStockRecord> _xblockexpression = null;
    {
      RCInStockRecordCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCInStockRecordCriteria.class, this.criteriaMapper, this.entities);
      final Function1<RCInStockRecord,UIInStockRecord> _function = new Function1<RCInStockRecord,UIInStockRecord>() {
          public UIInStockRecord apply(final RCInStockRecord it) {
            UIInStockRecord _apply = InStockRecordListPresenterServiceImpl.this.mapper.apply(it);
            return _apply;
          }
        };
      IPagedResult<UIInStockRecord> _listAndTransform = PagedQueries.<UIInStockRecord, RCInStockRecord>listAndTransform(c, new Function<RCInStockRecord,UIInStockRecord>() {
          public UIInStockRecord apply(RCInStockRecord input) {
            return _function.apply(input);
          }
      });
      _xblockexpression = (_listAndTransform);
    }
    return _xblockexpression;
  }
  
  public void delete(final RCInStockRecordProxy value) throws SessionTimeOutException, ValidationException {
    RCInStockRecord _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCInStockRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    this.entities.delete( _resolved);
  }
  
  public Collection<UIInStockRecordItem> loadDetails(final RCInStockRecordProxy parent) throws SessionTimeOutException, ValidationException {
    RCInStockRecord _resolved= null;
    if(parent!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCInStockRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(parent, entities);
    
    Collection<RCInStockRecordItem> _items =  _resolved.getItems();
    final Function1<RCInStockRecordItem,UIInStockRecordItem> _function = new Function1<RCInStockRecordItem,UIInStockRecordItem>() {
        public UIInStockRecordItem apply(final RCInStockRecordItem it) {
          UIInStockRecordItem _transform = InStockRecordListPresenterServiceImpl.this.itemMapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIInStockRecordItem> _map = IterableExtensions.<RCInStockRecordItem, UIInStockRecordItem>map(_items, _function);
    Collection<UIInStockRecordItem> _unlazy = IterableExtensions2.<UIInStockRecordItem>unlazy(_map);
    return _unlazy;
  }
  
  public UIInStockRecord loadInStockRecordInfo(final RCInStockRecordProxy record) throws SessionTimeOutException, ValidationException {
    RCInStockRecord _resolved= null;
    if(record!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCInStockRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(record, entities);
    
    UIInStockRecord _transform = this.mapper.transform( _resolved);
    return _transform;
  }
}
