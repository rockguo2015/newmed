package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCInStockRecord;
import com.fudanmed.platform.core.warehouse.RCInStoreTransaction;
import com.fudanmed.platform.core.warehouse.RCInStoreType;
import com.fudanmed.platform.core.warehouse.RCProductStorage;
import com.fudanmed.platform.core.warehouse.RCProductSummarySnapshot;
import com.fudanmed.platform.core.warehouse.impl.RCInStockRecordImpl;
import com.fudanmed.platform.core.warehouse.impl.RCProductStoreTransactionImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCInStoreTransactionProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.eclipse.xtext.xbase.lib.DoubleExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;

@Entity
@DiscriminatorValue("RCINSTORETRANSACTION_TYPE")
public class RCInStoreTransactionImpl extends RCProductStoreTransactionImpl implements RCInStoreTransaction {
  public RCInStoreTransactionImpl() {
    super();
  }
  
  public RCInStoreTransactionImpl(final RCProductStorage productStorage) {
    super( productStorage);
    
  }
  
  @JoinColumn(name = "inStoreRecord_id")
  @ManyToOne(targetEntity = RCInStockRecordImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCInStockRecord inStoreRecord;
  
  public RCInStockRecord getInStoreRecord() {
    return this.inStoreRecord;
  }
  
  public RCInStoreTransaction setInStoreRecord(final RCInStockRecord inStoreRecord) {
    this.inStoreRecord = inStoreRecord;
    return this;			
    
  }
  
  public String getEventRecordSid() {
    String _sid = this.inStoreRecord.getSid();
    return _sid;
  }
  
  public String getTransactionTypeDesc() {
    RCInStoreType _inStoreType = this.inStoreRecord.getInStoreType();
    String _name = _inStoreType.getName();
    return _name;
  }
  
  public void transactionCommitted() {
    final Procedure3<RCProductSummarySnapshot,Integer,Double> _function = new Procedure3<RCProductSummarySnapshot,Integer,Double>() {
        public void apply(final RCProductSummarySnapshot it, final Integer quantity, final Double amount) {
          Integer _inStockQuantity = it.getInStockQuantity();
          int _plus = ((_inStockQuantity).intValue() + (quantity).intValue());
          it.setInStockQuantity(Integer.valueOf(_plus));
          Double _inStockAmount = it.getInStockAmount();
          double _plus_1 = DoubleExtensions.operator_plus(_inStockAmount, amount);
          it.setInStockAmount(Double.valueOf(_plus_1));
        }
      };
    this.transactionCommitted(_function);
  }
  
  public static RCInStoreTransaction create(final RCProductStorage productStorage, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.warehouse.RCInStoreTransaction rCInStoreTransaction = new com.fudanmed.platform.core.warehouse.impl.RCInStoreTransactionImpl(
    	productStorage
    );
    objectFactory.create(rCInStoreTransaction);
    return rCInStoreTransaction;			
    
  }
  
  public RCInStoreTransactionProxy toProxy() {
    com.fudanmed.platform.core.warehouse.proxy.RCInStoreTransactionProxy proxy = new com.fudanmed.platform.core.warehouse.proxy.RCInStoreTransactionProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
