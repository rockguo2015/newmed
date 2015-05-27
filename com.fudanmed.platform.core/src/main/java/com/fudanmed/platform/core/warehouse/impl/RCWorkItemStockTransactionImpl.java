package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCProductStorage;
import com.fudanmed.platform.core.warehouse.RCProductSummarySnapshot;
import com.fudanmed.platform.core.warehouse.RCWorkItemOutStockRecord;
import com.fudanmed.platform.core.warehouse.RCWorkItemReturnStockRecord;
import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecord;
import com.fudanmed.platform.core.warehouse.RCWorkItemStockTransaction;
import com.fudanmed.platform.core.warehouse.impl.RCProductStoreTransactionImpl;
import com.fudanmed.platform.core.warehouse.impl.RCWorkItemStockRecordImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemStockTransactionProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.eclipse.xtext.xbase.lib.DoubleExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;

@Entity
@DiscriminatorValue("RCWORKITEMSTOCKTRANSACTION_TYPE")
public class RCWorkItemStockTransactionImpl extends RCProductStoreTransactionImpl implements RCWorkItemStockTransaction {
  public RCWorkItemStockTransactionImpl() {
    super();
  }
  
  public RCWorkItemStockTransactionImpl(final RCProductStorage productStorage) {
    super( productStorage);
    
  }
  
  @JoinColumn(name = "record_id")
  @ManyToOne(targetEntity = RCWorkItemStockRecordImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCWorkItemStockRecord record;
  
  public RCWorkItemStockRecord getRecord() {
    return this.record;
  }
  
  public RCWorkItemStockTransaction setRecord(final RCWorkItemStockRecord record) {
    this.record = record;
    return this;			
    
  }
  
  public String getEventRecordSid() {
    String _sid = this.record.getSid();
    return _sid;
  }
  
  public String getTransactionTypeDesc() {
    String _switchResult = null;
    final RCWorkItemStockRecord record = this.record;
    boolean _matched = false;
    if (!_matched) {
      if (record instanceof RCWorkItemOutStockRecord) {
        final RCWorkItemOutStockRecord _rCWorkItemOutStockRecord = (RCWorkItemOutStockRecord)record;
        _matched=true;
        String _xifexpression = null;
        Integer _quantity = this.getQuantity();
        boolean _lessThan = ((_quantity).intValue() < 0);
        if (_lessThan) {
          _xifexpression = "\u5DE5\u5355\u9886\u6599\u51FA\u5E93";
        } else {
          _xifexpression = "\u5DE5\u5355\u9886\u6599";
        }
        _switchResult = _xifexpression;
      }
    }
    if (!_matched) {
      if (record instanceof RCWorkItemReturnStockRecord) {
        final RCWorkItemReturnStockRecord _rCWorkItemReturnStockRecord = (RCWorkItemReturnStockRecord)record;
        _matched=true;
        String _xifexpression = null;
        Integer _quantity = this.getQuantity();
        boolean _greaterThan = ((_quantity).intValue() > 0);
        if (_greaterThan) {
          _xifexpression = "\u5DE5\u5355\u9000\u6599\u5165\u5E93";
        } else {
          _xifexpression = "\u5DE5\u5355\u9000\u6599\u6599";
        }
        _switchResult = _xifexpression;
      }
    }
    return _switchResult;
  }
  
  public void transactionCommitted() {
    final Procedure3<RCProductSummarySnapshot,Integer,Double> _function = new Procedure3<RCProductSummarySnapshot,Integer,Double>() {
        public void apply(final RCProductSummarySnapshot it, final Integer quantity, final Double amount) {
          Integer _workitemStockQuantity = it.getWorkitemStockQuantity();
          int _plus = ((_workitemStockQuantity).intValue() + (quantity).intValue());
          it.setWorkitemStockQuantity(Integer.valueOf(_plus));
          Double _workitemStockAmount = it.getWorkitemStockAmount();
          double _plus_1 = DoubleExtensions.operator_plus(_workitemStockAmount, amount);
          it.setWorkitemStockAmount(Double.valueOf(_plus_1));
        }
      };
    this.transactionCommitted(_function);
  }
  
  public static RCWorkItemStockTransaction create(final RCProductStorage productStorage, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.warehouse.RCWorkItemStockTransaction rCWorkItemStockTransaction = new com.fudanmed.platform.core.warehouse.impl.RCWorkItemStockTransactionImpl(
    	productStorage
    );
    objectFactory.create(rCWorkItemStockTransaction);
    return rCWorkItemStockTransaction;			
    
  }
  
  public RCWorkItemStockTransactionProxy toProxy() {
    com.fudanmed.platform.core.warehouse.proxy.RCWorkItemStockTransactionProxy proxy = new com.fudanmed.platform.core.warehouse.proxy.RCWorkItemStockTransactionProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
