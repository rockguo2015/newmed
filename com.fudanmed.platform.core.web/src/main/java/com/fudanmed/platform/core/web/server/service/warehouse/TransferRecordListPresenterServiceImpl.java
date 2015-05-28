package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.common.RCSystemParameter;
import com.fudanmed.platform.core.common.RCSystemParameterService;
import com.fudanmed.platform.core.warehouse.RCTransferRecord;
import com.fudanmed.platform.core.warehouse.RCTransferRecordCriteria;
import com.fudanmed.platform.core.warehouse.RCTransferRecordItem;
import com.fudanmed.platform.core.warehouse.proxy.RCTransferRecordProxy;
import com.fudanmed.platform.core.web.client.warehouse.TransferRecordListPresenterService;
import com.fudanmed.platform.core.web.server.service.template.TransferTemplate;
import com.fudanmed.platform.core.web.server.service.warehouse.TransferRecordCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.warehouse.TransferRecordItemMapper;
import com.fudanmed.platform.core.web.server.service.warehouse.TransferRecordMapper;
import com.fudanmed.platform.core.web.shared.warehouse.UITransferRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UITransferRecordCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UITransferRecordItem;
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

@Service("com.fudanmed.platform.core.web.client.warehouse.TransferRecordListPresenterService")
@Transactional
public class TransferRecordListPresenterServiceImpl extends BaseService implements TransferRecordListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private TransferRecordCriteriaMapper criteriaMapper;
  
  @Autowired
  private TransferRecordMapper mapper;
  
  @Autowired
  private TransferRecordItemMapper itemMapper;
  
  @Autowired
  private RCSystemParameterService systemParameter;
  
  public String generatePrintContents(final RCTransferRecordProxy record) throws SessionTimeOutException, ValidationException {
    RCTransferRecord _resolved= null;
    if(record!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCTransferRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(record, entities);
    
    RCSystemParameter _systemParameter = this.systemParameter.getSystemParameter();
    String _template = TransferTemplate.template( _resolved, _systemParameter, this.itemMapper);
    return _template;
  }
  
  public IPagedResult<UITransferRecord> filter(final UITransferRecordCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UITransferRecord> _xblockexpression = null;
    {
      RCTransferRecordCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCTransferRecordCriteria.class, this.criteriaMapper, this.entities);
      final Function1<RCTransferRecord,UITransferRecord> _function = new Function1<RCTransferRecord,UITransferRecord>() {
          public UITransferRecord apply(final RCTransferRecord it) {
            UITransferRecord _apply = TransferRecordListPresenterServiceImpl.this.mapper.apply(it);
            return _apply;
          }
        };
      IPagedResult<UITransferRecord> _listAndTransform = PagedQueries.<UITransferRecord, RCTransferRecord>listAndTransform(c, new Function<RCTransferRecord,UITransferRecord>() {
          public UITransferRecord apply(RCTransferRecord input) {
            return _function.apply(input);
          }
      });
      _xblockexpression = (_listAndTransform);
    }
    return _xblockexpression;
  }
  
  public void delete(final RCTransferRecordProxy value) throws SessionTimeOutException, ValidationException {
    RCTransferRecord _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCTransferRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    this.entities.delete( _resolved);
  }
  
  public Collection<UITransferRecordItem> loadDetails(final RCTransferRecordProxy parent) throws SessionTimeOutException, ValidationException {
    RCTransferRecord _resolved= null;
    if(parent!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCTransferRecord)com.uniquesoft.uidl.extensions.ModelObjects.resolve(parent, entities);
    
    Collection<RCTransferRecordItem> _items =  _resolved.getItems();
    final Function1<RCTransferRecordItem,UITransferRecordItem> _function = new Function1<RCTransferRecordItem,UITransferRecordItem>() {
        public UITransferRecordItem apply(final RCTransferRecordItem it) {
          UITransferRecordItem _transform = TransferRecordListPresenterServiceImpl.this.itemMapper.transform(it);
          return _transform;
        }
      };
    Iterable<UITransferRecordItem> _map = IterableExtensions.<RCTransferRecordItem, UITransferRecordItem>map(_items, _function);
    Collection<UITransferRecordItem> _unlazy = IterableExtensions2.<UITransferRecordItem>unlazy(_map);
    return _unlazy;
  }
}
