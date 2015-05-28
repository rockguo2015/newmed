package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.common.RCSystemParameter;
import com.fudanmed.platform.core.common.RCSystemParameterService;
import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.RCStockTakingItem;
import com.fudanmed.platform.core.warehouse.RCStockTakingList;
import com.fudanmed.platform.core.warehouse.RCStockTakingListCriteria;
import com.fudanmed.platform.core.warehouse.RCStockTakingService;
import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingListProxy;
import com.fudanmed.platform.core.web.client.warehouse.StockTakingListListPresenterService;
import com.fudanmed.platform.core.web.server.service.template.StockTakingTemplate;
import com.fudanmed.platform.core.web.server.service.warehouse.StockTakingItemCSVMapper;
import com.fudanmed.platform.core.web.server.service.warehouse.StockTakingItemMapper;
import com.fudanmed.platform.core.web.server.service.warehouse.StockTakingListCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.warehouse.StockTakingListMapper;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingItem;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingList;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingListCriteria;
import com.google.common.base.Function;
import com.uniquesoft.gwt.server.common.pager.PagedQueries;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.csv.server.CSVExtensions;
import edu.fudan.langlab.domain.organization.Party;
import edu.fudan.langlab.domain.security.ISystemUserService;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.warehouse.StockTakingListListPresenterService")
@Transactional
public class StockTakingListListPresenterServiceImpl extends BaseService implements StockTakingListListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private StockTakingListCriteriaMapper criteriaMapper;
  
  @Autowired
  private StockTakingListMapper mapper;
  
  @Autowired
  private StockTakingItemMapper itemMapper;
  
  @Autowired
  private RCStockTakingService stockTakingService;
  
  @Autowired
  private ISystemUserService systemUserService;
  
  @Autowired
  private StockTakingItemCSVMapper stockTakingItemCSVMapper;
  
  @Autowired
  private RCSystemParameterService systemParameter;
  
  public IPagedResult<UIStockTakingList> filter(final UIStockTakingListCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UIStockTakingList> _xblockexpression = null;
    {
      RCStockTakingListCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCStockTakingListCriteria.class, this.criteriaMapper, this.entities);
      final Function1<RCStockTakingList,UIStockTakingList> _function = new Function1<RCStockTakingList,UIStockTakingList>() {
          public UIStockTakingList apply(final RCStockTakingList it) {
            UIStockTakingList _apply = StockTakingListListPresenterServiceImpl.this.mapper.apply(it);
            return _apply;
          }
        };
      IPagedResult<UIStockTakingList> _listAndTransform = PagedQueries.<UIStockTakingList, RCStockTakingList>listAndTransform(c, new Function<RCStockTakingList,UIStockTakingList>() {
          public UIStockTakingList apply(RCStockTakingList input) {
            return _function.apply(input);
          }
      });
      _xblockexpression = (_listAndTransform);
    }
    return _xblockexpression;
  }
  
  public void cancel(final RCStockTakingListProxy value) throws SessionTimeOutException, ValidationException {
    RCStockTakingList _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCStockTakingList)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    this.stockTakingService.cancelStockTaking( _resolved);
  }
  
  public void commit(final RCStockTakingListProxy value) throws SessionTimeOutException, ValidationException {
    RCStockTakingList _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCStockTakingList)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    Party _currentUserAsParty = this.systemUserService.getCurrentUserAsParty();
    this.stockTakingService.commitStockTaking( _resolved, ((RCEmployee) _currentUserAsParty));
  }
  
  public Collection<UIStockTakingItem> loadDetails(final RCStockTakingListProxy parent) throws SessionTimeOutException, ValidationException {
    RCStockTakingList _resolved= null;
    if(parent!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCStockTakingList)com.uniquesoft.uidl.extensions.ModelObjects.resolve(parent, entities);
    
    Collection<RCStockTakingItem> _items =  _resolved.getItems();
    final Function1<RCStockTakingItem,UIStockTakingItem> _function = new Function1<RCStockTakingItem,UIStockTakingItem>() {
        public UIStockTakingItem apply(final RCStockTakingItem it) {
          UIStockTakingItem _transform = StockTakingListListPresenterServiceImpl.this.itemMapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIStockTakingItem> _map = IterableExtensions.<RCStockTakingItem, UIStockTakingItem>map(_items, _function);
    Collection<UIStockTakingItem> _unlazy = IterableExtensions2.<UIStockTakingItem>unlazy(_map);
    return _unlazy;
  }
  
  public String prepareExport(final RCStockTakingListProxy parent) throws SessionTimeOutException, ValidationException {
    RCStockTakingList _resolved= null;
    if(parent!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCStockTakingList)com.uniquesoft.uidl.extensions.ModelObjects.resolve(parent, entities);
    
    Collection<RCStockTakingItem> _items =  _resolved.getItems();
    final Function1<RCStockTakingItem,UIStockTakingItem> _function = new Function1<RCStockTakingItem,UIStockTakingItem>() {
        public UIStockTakingItem apply(final RCStockTakingItem it) {
          UIStockTakingItem _transform = StockTakingListListPresenterServiceImpl.this.itemMapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIStockTakingItem> _map = IterableExtensions.<RCStockTakingItem, UIStockTakingItem>map(_items, _function);
    Collection<UIStockTakingItem> _unlazy = IterableExtensions2.<UIStockTakingItem>unlazy(_map);
    String _csvPrepare = CSVExtensions.<UIStockTakingItem>csvPrepare(this, "stocklist", StockTakingItemCSVMapper.class, _unlazy);
    return _csvPrepare;
  }
  
  public String generatePrintContents(final RCStockTakingListProxy value) throws SessionTimeOutException, ValidationException {
    RCStockTakingList _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCStockTakingList)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    RCSystemParameter _systemParameter = this.systemParameter.getSystemParameter();
    String _template = StockTakingTemplate.template( _resolved, _systemParameter);
    return _template;
  }
  
  public Boolean isAllDataCollected(final RCStockTakingListProxy value) throws SessionTimeOutException, ValidationException {
    RCStockTakingList _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCStockTakingList)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    Boolean _allDataCollected =  _resolved.allDataCollected();
    return _allDataCollected;
  }
  
  public RCEmployeeProxy loadCurrentUser() throws SessionTimeOutException, ValidationException {
    Party _currentUserAsParty = this.systemUserService.getCurrentUserAsParty();
    RCEmployeeProxy _proxy = ((RCEmployee) _currentUserAsParty).toProxy();
    return _proxy;
  }
}
