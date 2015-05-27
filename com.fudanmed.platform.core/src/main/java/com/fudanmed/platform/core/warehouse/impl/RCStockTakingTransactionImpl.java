package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCProductStorage;
import com.fudanmed.platform.core.warehouse.RCProductSummarySnapshot;
import com.fudanmed.platform.core.warehouse.RCStockTakingRecord;
import com.fudanmed.platform.core.warehouse.RCStockTakingTransaction;
import com.fudanmed.platform.core.warehouse.impl.RCProductStoreTransactionImpl;
import com.fudanmed.platform.core.warehouse.impl.RCStockTakingRecordImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingTransactionProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.eclipse.xtext.xbase.lib.DoubleExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;

@Entity
@DiscriminatorValue("RCSTOCKTAKINGTRANSACTION_TYPE")
public class RCStockTakingTransactionImpl extends RCProductStoreTransactionImpl implements RCStockTakingTransaction {
  public RCStockTakingTransactionImpl() {
    super();
  }
  
  public RCStockTakingTransactionImpl(final RCProductStorage productStorage) {
    super( productStorage);
    
  }
  
  @JoinColumn(name = "stockTakingRecord_id")
  @ManyToOne(targetEntity = RCStockTakingRecordImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCStockTakingRecord stockTakingRecord;
  
  public RCStockTakingRecord getStockTakingRecord() {
    return this.stockTakingRecord;
  }
  
  public RCStockTakingTransaction setStockTakingRecord(final RCStockTakingRecord stockTakingRecord) {
    this.stockTakingRecord = stockTakingRecord;
    return this;			
    
  }
  
  public String getEventRecordSid() {
    String _sid = this.stockTakingRecord.getSid();
    return _sid;
  }
  
  public String getTransactionTypeDesc() {
    String _xifexpression = null;
    Integer _quantity = this.getQuantity();
    boolean _greaterThan = ((_quantity).intValue() > 0);
    if (_greaterThan) {
      _xifexpression = "\u76D8\u8D62";
    } else {
      String _xifexpression_1 = null;
      Integer _quantity_1 = this.getQuantity();
      boolean _lessThan = ((_quantity_1).intValue() < 0);
      if (_lessThan) {
        _xifexpression_1 = "\u76D8\u4E8F";
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public void transactionCommitted() {
    final Procedure3<RCProductSummarySnapshot,Integer,Double> _function = new Procedure3<RCProductSummarySnapshot,Integer,Double>() {
        public void apply(final RCProductSummarySnapshot it, final Integer quantity, final Double amount) {
          Integer _stockTakingStockQuantity = it.getStockTakingStockQuantity();
          int _plus = ((_stockTakingStockQuantity).intValue() + (quantity).intValue());
          it.setStockTakingStockQuantity(Integer.valueOf(_plus));
          Double _stockTakingStockAmount = it.getStockTakingStockAmount();
          double _plus_1 = DoubleExtensions.operator_plus(_stockTakingStockAmount, amount);
          it.setStockTakingStockAmount(Double.valueOf(_plus_1));
        }
      };
    this.transactionCommitted(_function);
  }
  
  public static RCStockTakingTransaction create(final RCProductStorage productStorage, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.warehouse.RCStockTakingTransaction rCStockTakingTransaction = new com.fudanmed.platform.core.warehouse.impl.RCStockTakingTransactionImpl(
    	productStorage
    );
    objectFactory.create(rCStockTakingTransaction);
    return rCStockTakingTransaction;			
    
  }
  
  public RCStockTakingTransactionProxy toProxy() {
    com.fudanmed.platform.core.warehouse.proxy.RCStockTakingTransactionProxy proxy = new com.fudanmed.platform.core.warehouse.proxy.RCStockTakingTransactionProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
