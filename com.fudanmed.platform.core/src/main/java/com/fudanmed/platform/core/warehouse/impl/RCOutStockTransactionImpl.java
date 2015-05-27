package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCOutStockRecord;
import com.fudanmed.platform.core.warehouse.RCOutStockTransaction;
import com.fudanmed.platform.core.warehouse.RCProductStorage;
import com.fudanmed.platform.core.warehouse.RCProductSummarySnapshot;
import com.fudanmed.platform.core.warehouse.impl.RCOutStockRecordImpl;
import com.fudanmed.platform.core.warehouse.impl.RCProductStoreTransactionImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCOutStockTransactionProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.eclipse.xtext.xbase.lib.DoubleExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;

@Entity
@DiscriminatorValue("RCOUTSTOCKTRANSACTION_TYPE")
public class RCOutStockTransactionImpl extends RCProductStoreTransactionImpl implements RCOutStockTransaction {
  public RCOutStockTransactionImpl() {
    super();
  }
  
  public RCOutStockTransactionImpl(final RCProductStorage productStorage) {
    super( productStorage);
    
  }
  
  @JoinColumn(name = "outStockRecord_id")
  @ManyToOne(targetEntity = RCOutStockRecordImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private RCOutStockRecord outStockRecord;
  
  public RCOutStockRecord getOutStockRecord() {
    return this.outStockRecord;
  }
  
  public RCOutStockTransaction setOutStockRecord(final RCOutStockRecord outStockRecord) {
    this.outStockRecord = outStockRecord;
    return this;			
    
  }
  
  public String getEventRecordSid() {
    String _sid = this.outStockRecord.getSid();
    return _sid;
  }
  
  public String getTransactionTypeDesc() {
    return "\u51FA\u5E93";
  }
  
  public void transactionCommitted() {
    final Procedure3<RCProductSummarySnapshot,Integer,Double> _function = new Procedure3<RCProductSummarySnapshot,Integer,Double>() {
        public void apply(final RCProductSummarySnapshot it, final Integer quantity, final Double amount) {
          Integer _outStockQuantity = it.getOutStockQuantity();
          int _plus = ((_outStockQuantity).intValue() + (quantity).intValue());
          it.setOutStockQuantity(Integer.valueOf(_plus));
          Double _outStockAmount = it.getOutStockAmount();
          double _plus_1 = DoubleExtensions.operator_plus(_outStockAmount, amount);
          it.setOutStockAmount(Double.valueOf(_plus_1));
        }
      };
    this.transactionCommitted(_function);
  }
  
  public static RCOutStockTransaction create(final RCProductStorage productStorage, final IObjectFactory objectFactory) {
    com.fudanmed.platform.core.warehouse.RCOutStockTransaction rCOutStockTransaction = new com.fudanmed.platform.core.warehouse.impl.RCOutStockTransactionImpl(
    	productStorage
    );
    objectFactory.create(rCOutStockTransaction);
    return rCOutStockTransaction;			
    
  }
  
  public RCOutStockTransactionProxy toProxy() {
    com.fudanmed.platform.core.warehouse.proxy.RCOutStockTransactionProxy proxy = new com.fudanmed.platform.core.warehouse.proxy.RCOutStockTransactionProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
