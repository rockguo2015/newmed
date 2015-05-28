package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductStorage;
import com.fudanmed.platform.core.warehouse.RCProductStoreTransaction;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary;
import com.fudanmed.platform.core.warehouse.proxy.RCProductStorageProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductWarehouseStorageSummaryProxy;
import com.fudanmed.platform.core.web.client.warehouse.ProductStoreTransactionListPresenterService;
import com.fudanmed.platform.core.web.server.service.warehouse.ProductStoreTransactionMapper;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductStoreTransaction;
import com.google.common.base.Objects;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.DateUtil;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.warehouse.ProductStoreTransactionListPresenterService")
@Transactional
public class ProductStoreTransactionListPresenterServiceImpl extends BaseService implements ProductStoreTransactionListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProductStoreTransactionMapper mapper;
  
  public Collection<UIProductStoreTransaction> loadProductStoreTransactionList(final RCProductStorageProxy context) throws SessionTimeOutException, ValidationException {
    RCProductStorage _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCProductStorage)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    Collection<RCProductStoreTransaction> _transactions =  _resolved.getTransactions();
    final Function1<RCProductStoreTransaction,UIProductStoreTransaction> _function = new Function1<RCProductStoreTransaction,UIProductStoreTransaction>() {
        public UIProductStoreTransaction apply(final RCProductStoreTransaction it) {
          UIProductStoreTransaction _transform = ProductStoreTransactionListPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIProductStoreTransaction> _map = IterableExtensions.<RCProductStoreTransaction, UIProductStoreTransaction>map(_transactions, _function);
    Collection<UIProductStoreTransaction> _unlazy = IterableExtensions2.<UIProductStoreTransaction>unlazy(_map);
    return _unlazy;
  }
  
  public Collection<UIProductStoreTransaction> loadProductStoreTransactionList4Summary(final RCProductWarehouseStorageSummaryProxy context) throws SessionTimeOutException, ValidationException {
    RCProductWarehouseStorageSummary _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    Collection<RCProductStoreTransaction> _transactions =  _resolved.getTransactions();
    final Function1<RCProductStoreTransaction,UIProductStoreTransaction> _function = new Function1<RCProductStoreTransaction,UIProductStoreTransaction>() {
        public UIProductStoreTransaction apply(final RCProductStoreTransaction it) {
          UIProductStoreTransaction _transform = ProductStoreTransactionListPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIProductStoreTransaction> _map = IterableExtensions.<RCProductStoreTransaction, UIProductStoreTransaction>map(_transactions, _function);
    Collection<UIProductStoreTransaction> _unlazy = IterableExtensions2.<UIProductStoreTransaction>unlazy(_map);
    return _unlazy;
  }
  
  public Collection<UIProductStoreTransaction> loadProductStoreTransactionList4Summary(final RCProductWarehouseStorageSummaryProxy context, final Date dateFrom, final Date dateTo) throws SessionTimeOutException, ValidationException {
    RCProductWarehouseStorageSummary _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    Collection<RCProductStoreTransaction> _transactions =  _resolved.getTransactions();
    final Function1<RCProductStoreTransaction,Boolean> _function = new Function1<RCProductStoreTransaction,Boolean>() {
        public Boolean apply(final RCProductStoreTransaction it) {
          boolean _xifexpression = false;
          boolean _notEquals = (!Objects.equal(dateFrom, null));
          if (_notEquals) {
            Date _date = it.getDate();
            Date _trimDate = DateUtil.trimDate(dateFrom);
            boolean _greaterEqualsThan = (_date.compareTo(_trimDate) >= 0);
            _xifexpression = _greaterEqualsThan;
          } else {
            boolean _and = false;
            if (!true) {
              _and = false;
            } else {
              boolean _xifexpression_1 = false;
              boolean _notEquals_1 = (!Objects.equal(dateTo, null));
              if (_notEquals_1) {
                Date _date_1 = it.getDate();
                Date _addDays = DateUtil.addDays(dateTo, 1);
                Date _trimDate_1 = DateUtil.trimDate(_addDays);
                boolean _lessEqualsThan = (_date_1.compareTo(_trimDate_1) <= 0);
                _xifexpression_1 = _lessEqualsThan;
              } else {
                _xifexpression_1 = true;
              }
              _and = (true && _xifexpression_1);
            }
            _xifexpression = _and;
          }
          return Boolean.valueOf(_xifexpression);
        }
      };
    Iterable<RCProductStoreTransaction> _filter = IterableExtensions.<RCProductStoreTransaction>filter(_transactions, _function);
    final Function1<RCProductStoreTransaction,UIProductStoreTransaction> _function_1 = new Function1<RCProductStoreTransaction,UIProductStoreTransaction>() {
        public UIProductStoreTransaction apply(final RCProductStoreTransaction it) {
          UIProductStoreTransaction _transform = ProductStoreTransactionListPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIProductStoreTransaction> _map = IterableExtensions.<RCProductStoreTransaction, UIProductStoreTransaction>map(_filter, _function_1);
    Collection<UIProductStoreTransaction> _unlazy = IterableExtensions2.<UIProductStoreTransaction>unlazy(_map);
    return _unlazy;
  }
}
